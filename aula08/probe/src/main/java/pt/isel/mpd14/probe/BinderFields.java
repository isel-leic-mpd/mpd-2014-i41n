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
import java.lang.reflect.InvocationTargetException;

/**
 *
 * @author Miguel Gamboa at CCISEL
 */
public class BinderFields extends AbstractBinder{

    @Override
    <T> boolean bindMember(T target, String key, Object fValue) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                Field[] fields = target.getClass().getDeclaredFields();
        for (Field f : fields) {
            String fName = f.getName();
            if (fName.equals(key)) {
                Class<?> fType = f.getType();
                f.setAccessible(true);
                if (fType.isPrimitive()) {
                    fType = f.get(target).getClass();
                }
                /*
                 * Verifica se o tipo do campo (fType) é tipo base do tipo de fValue.
                 * Nota: Tipo base inclui superclasses ou superinterfaces.
                 */
                if (fType.isAssignableFrom(fValue.getClass())) {
                    f.set(target, fValue);
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;

    }
    
}
