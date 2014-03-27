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

package pt.isel.mpd14.probe.util;

import java.util.logging.Level;
import java.util.logging.Logger;
import static pt.isel.mpd14.probe.util.SneakyUtils.asRuntimeException;

/**
 *
 * @author Miguel Gamboa at CCISEL
 */
public class SneakyApp {
 
    public static void main(String [] args){
        teste();
    }
    
    public static void teste(){
        try {
            m(0);
        } catch (Exception ex) {
            asRuntimeException(ex);
        }
    }
    public static void m(int div) throws Exception{
        try{
            int n = 5;
            int res = n/div;
        }catch(java.lang.ArithmeticException ex){
            throw new Exception("Illegal div = " +  div);
        }
    }
}
