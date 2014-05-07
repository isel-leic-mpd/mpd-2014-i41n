/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.isel.mpd14.iters;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 *
 * @author Miguel Gamboa at CCISEL
 */
class ListQueryable<T> implements Queryable<T> {
    
    final Iterable<T> src;
    
    public ListQueryable(Iterable<T> src) {
        this.src = src;
    }
    
    @Override
    public Queryable<T> filter(Predicate<T> p) {
        List<T> res = new LinkedList<>();
        for (T elem : src) {
            if (p.test(elem)) {
                res.add(elem);
            }
        }
        return new ListQueryable(res);
    }
    
    @Override
    public <R> Queryable<R> map(Function<T, R> mapper) {
        List<R> res = new LinkedList<>();
        for (T elem : src) {
            res.add(mapper.apply(elem));
        }
        return new ListQueryable(res);
    }
    
    @Override
    public Queryable<T> skip(int n) {
        List<T> res = new LinkedList<>();
        Iterator<T> i = src.iterator();
        while(n > 0){ i.next(); n--;}
        while(i.hasNext()) res.add(i.next());
        return new ListQueryable(res);
    }
    
    @Override
    public Iterator<T> iterator() {
        return src.iterator();
    }
    
}
