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

import java.lang.reflect.AnnotatedElement;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Miguel Gamboa at CCISEL
 */
public abstract class AbstractBindMember<T> implements BindMember<T> {

    Map<AnnotatedElement, Formatter> formats = new HashMap<>();
    
    protected Object format(AnnotatedElement mb, Object v) throws InstantiationException, IllegalAccessException {
        Formatter f = formats.get(mb);
        if(f != null)
            return f.format(v);
        
        Format a = mb.getAnnotation(Format.class);
        if (a != null) {
            f = a.formatter().newInstance();
            formats.put(mb, f);
            v = f.format(v);
        }
        return v;
    }
}
