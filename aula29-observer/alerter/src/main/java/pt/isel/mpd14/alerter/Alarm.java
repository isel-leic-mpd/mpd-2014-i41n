/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isel.mpd14.alerter;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 *
 * @author Miguel Gamboa at CCISEL
 */
public class Alarm {

    /*
     * Cada evento é representado por um instante de tempo em Milisegundos
    */
    private final SortedSet<Long> events = new TreeSet<>();
    private final List<AlarmHandler> handlers = new LinkedList<>();
    private int eventNr;

    public void addEvent(long time) {
        events.add(time);
    }

    public void start() {

        Iterator<Long> iter = events.iterator();
        Long instant = iter.hasNext() ? iter.next() : null;
        while (instant != null) {
            if (System.currentTimeMillis() >= instant) {
                eventNr++;
                notifyHanders();
                iter.remove();
                instant = iter.hasNext() ? iter.next() : null;
            }
        }
    }

    private void notifyHanders() {
        handlers.stream().forEach(
                h -> h.alert(new AlarmArgs(eventNr, System.currentTimeMillis()))
        );
    }

    public void addHandler(AlarmHandler h){
        handlers.add(h);
    }
}
