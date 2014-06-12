/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.isel.mpd14.sqlfw;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Miguel Gamboa at CCISEL
 */
@FunctionalInterface
public interface SqlConverter<T>{
    T convert(ResultSet rs) throws SQLException;
    
}
