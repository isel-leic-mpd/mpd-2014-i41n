/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.isel.mpd14.iters;

import java.util.List;

/**
 *
 * @author Miguel Gamboa at CCISEL
 */
public class IterUtils {
    
    public static <T> Queryable<T> query(List<T> src){
        return new IterableQueryable(src);
    }
}
