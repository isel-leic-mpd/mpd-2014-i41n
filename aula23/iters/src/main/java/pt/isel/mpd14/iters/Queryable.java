/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.isel.mpd14.iters;

import java.util.function.Function;
import java.util.function.Predicate;

/**
 *
 * @author Miguel Gamboa at CCISEL
 * @param <T>
 */
public interface Queryable<T> extends Iterable<T>{
    
    Queryable<T> filter(Predicate<T> p);
    
    <R> Queryable<R> map(Function<T,R> mapper);
    
    Queryable<T> skip(int n);
}
