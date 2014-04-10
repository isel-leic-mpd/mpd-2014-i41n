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
import java.util.logging.Level;
import java.util.logging.Logger;
import pt.isel.mpd14.probe.util.SneakyUtils;

/**
 *
 * @author Miguel Gamboa at CCISEL
 */
class FormatterAdpater implements Formatter {

    Method targetMethod;
    
    public FormatterAdpater(Method m) {
        targetMethod = m;
    }

    @Override
    public Object format(Object o) {
        Object res = null;
        try {
            res = targetMethod.invoke(null, o);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            SneakyUtils.throwAsRTException(ex);
        }
        return res;
    }
    
}
