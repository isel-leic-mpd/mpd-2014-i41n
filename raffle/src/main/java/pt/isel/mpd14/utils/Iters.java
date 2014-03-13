package pt.isel.mpd14.utils;

import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Iters {

    public static <T> Stream<T> stream(Iterable<T> elems){
        return StreamSupport.stream(elems.spliterator(), false);
    }

}
