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
import java.util.Map;

/**
 *
 * @author Miguel Gamboa at CCISEL
 */
public abstract class AbstractBinder {

    public <T> T bindTo(Class<T> klass, Map<String, Object> vals)
            throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (klass == null || vals == null) {
            throw new IllegalArgumentException();
        }
        T target = klass.newInstance();
        for (Map.Entry<String, Object> e : vals.entrySet()) {
            bindMember(target, e.getKey(), e.getValue());
        }
        return target;
    }

    abstract <T> boolean bindMember(T target, String key, Object value) 
            throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
}
