/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.isel.mpd14.iters;

import java.util.Iterator;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 *
 * @author Miguel Gamboa at CCISEL
 */
class IterableQueryable<T> implements Queryable<T> {
    
    final Iterable<T> src;
    
    public IterableQueryable(Iterable<T> src) {
        this.src = src;
    }

    @Override
    public Queryable<T> filter(Predicate<T> p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public <R> Queryable<R> map(Function<T, R> mapper) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Queryable<T> skip(int n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
        
}
