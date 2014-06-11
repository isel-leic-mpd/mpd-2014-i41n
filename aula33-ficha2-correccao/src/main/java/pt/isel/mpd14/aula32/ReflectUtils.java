/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.isel.mpd14.aula32;

import java.util.function.Predicate;

/**
 *
 * @author Miguel Gamboa at CCISEL
 */
public class ReflectUtils {

    public static <T> ReflectIterable<T> reflect(Iterable<T> itens){
        return new ReflectIterableEager(itens);
    }
    
    
    public static <T> Predicate<T> and(final Predicate<T> p1, final Predicate<T> p2){
        // return arg -> p1.test(arg) && p2.test(arg);
        
        if(p1 == null && p2 == null)
            throw new IllegalArgumentException("Both arguments are null!!");
        
        if(p1 == null) return p2;
        if(p2 == null) return p1;
        
        return new Predicate<T>() {
         @Override
            public boolean test(T arg) {
                return p1.test(arg) && p2.test(arg);
            }
        };
    }
   
}
