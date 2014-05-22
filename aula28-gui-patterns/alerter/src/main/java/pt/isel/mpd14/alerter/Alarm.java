/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isel.mpd14.alerter;

import java.util.Iterator;
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
    SortedSet<Long> events = new TreeSet<Long>();

    public void addEvent(long time) {
        events.add(time);
    }

    public void start() {

        Iterator<Long> iter = events.iterator();
        Long instant = iter.hasNext() ? iter.next() : null;
        while (instant != null) {
            if (System.currentTimeMillis() >= instant) {
                System.out.println("Triiiim");
                iter.remove();
                instant = iter.hasNext() ? iter.next() : null;
            }
        }
    }

}
