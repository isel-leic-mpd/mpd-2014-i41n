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

/**
 *
 * @author Miguel Gamboa at CCISEL
 */
class BinderPropsAndFields extends AbstractBinder{

    private AbstractBinder binderF = new BinderFields();
    private AbstractBinder binderP = new BinderProps();

    
    @Override
    <T> boolean bindMember(T target, String key, Object value) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if(!binderP.bindMember(target, key, value))
            return binderF.bindMember(target, key, value);
        return true;
    }

    
}
