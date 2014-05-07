/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isel.mpd14.app;

import java.io.IOException;
import java.net.URL;
import pt.isel.mpd14.iters.IterUtils;
import pt.isel.mpd14.iters.ListUtils;
import pt.isel.mpd14.raffle.Dealer;
import pt.isel.mpd14.raffle.Student;

/**
 *
 * @author Miguel Gamboa at CCISEL
 */
public class Program {

    private static String classroomUrl = "http://thoth.cc.e.ipl.pt/classes/MPD/1314v/LI41N-LI61N/pages/tpcs---entregas/501";

    public static void main(String[] args) throws IOException {
        Dealer d = new Dealer(new URL(classroomUrl));

        // String name = IterUtils.query(d.stds) // TPC Alinea 3
        // String name = ListUtils.query(d.stds) // TPC Alinea 2
        String name = d.stds.stream() // TPC Alinea 1
                .filter(s -> {
                    trace("filter1");
                    return s.nr > 3500;
                })
                .filter(s -> {
                    trace("filter2");
                    return s.name.startsWith("R");
                })
                .map(s -> {
                    trace("map");
                    return s.nr + " " + s.name + " " + s.grade;
                })
                .skip(2)
                .iterator().next();

        System.out.println(name);
    }

    public static void trace(String msg) {
        System.out.println(msg);
    }

    private static int CompareStdById(Student s1, Student s2) {
        return s1.nr - s2.nr;
    }

}
