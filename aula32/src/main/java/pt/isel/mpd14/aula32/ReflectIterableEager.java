/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.isel.mpd14.aula32;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;
import static pt.isel.mpd14.aula32.ReflectUtils.and;

/**
 *
 * @author Miguel Gamboa at CCISEL
 */
class ReflectIterableEager<T> implements ReflectIterable<T> {
    final Iterable<T> src;
    final Predicate<T> pred;

    public ReflectIterableEager(Iterable<T> src, Predicate<T> pred) {
        this.src = src;
        this.pred = pred;
    }
     
    public ReflectIterableEager(Iterable<T> src) {
        this.src = src;
        this.pred = null;
    }
    
    @Override
    public ReflectIterable<T> filter(String fieldName, Object expected) {
        Predicate<T> newPred = and(pred, new ReflectPredicate<>(fieldName, expected));
        return new ReflectIterableEager<T>(src, newPred);
    }

    @Override
    public Iterator<T> iterator() {
        if(pred == null) return src.iterator();
        
        List<T> res = new LinkedList<T>();
        for (T item : src) {
            if(pred.test(item))
                res.add(item);
        }
        return res.iterator();
    }
    
}
