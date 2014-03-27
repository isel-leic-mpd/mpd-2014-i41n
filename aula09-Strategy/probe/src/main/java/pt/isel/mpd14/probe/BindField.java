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

import java.lang.reflect.Field;
import static pt.isel.mpd14.probe.util.SneakyUtils.asRuntimeException;

/**
 *
 * @author Miguel Gamboa at CCISEL
 */
public class BindField implements BindMember {

    @Override
    public <T> boolean bind(T target, String name, Object v) {
        try {
            Field[] fields = target.getClass().getDeclaredFields();
            for (Field f : fields) {
                String fName = f.getName();
                if (fName.equals(name)) {
                    Class<?> fType = f.getType();
                    f.setAccessible(true);
                    if (fType.isPrimitive()) {
                        fType = f.get(target).getClass();
                    }
                    /*
                     * Verifica se o tipo do campo (fType) é tipo base do tipo de fValue.
                     * Nota: Tipo base inclui superclasses ou superinterfaces.
                     */
                    if (fType.isAssignableFrom(v.getClass())) {
                        f.set(target, v);
                        return true;
                    } else {
                        return false;
                    }
                }
            }
        } catch (IllegalArgumentException | IllegalAccessException ex) {
            throw asRuntimeException(ex);
        }
        return false;

    }

}
