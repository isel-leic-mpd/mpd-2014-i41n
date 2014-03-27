/*
 * Copyright (C) 2014 Miguel Gamboa at CCISEL
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package pt.isel.mpd14.probe;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import static pt.isel.mpd14.probe.util.SneakyUtils.asRuntimeException;

/**
 *
 * @author Miguel Gamboa at CCISEL
 */
public class BindProp implements BindMember {

    @Override
    public <T> boolean bind(T target, String key, Object v) {
        Method[] ms = target.getClass().getMethods();
        try {
            for (Method m : ms) {
                String mName = m.getName();
                if (!mName.equalsIgnoreCase("set" + key)) {
                    continue;
                }
                Class<?>[] paramsKlasses = m.getParameterTypes();
                if (paramsKlasses.length != 1) {
                    continue;
                }
                Class<?> propType = WrapperUtilites.toWrapper(paramsKlasses[0]);
                if (propType.isAssignableFrom(v.getClass())) {
                    m.setAccessible(true);
                    m.invoke(target, v);
                    return true;
                }
            }
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            throw asRuntimeException(ex);
        }
        return false;

    }

}
