/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.isel.mpd14.app;

import java.io.IOException;
import java.net.URL;
import pt.isel.mpd14.iters.ListUtils;
import pt.isel.mpd14.raffle.Dealer;
import pt.isel.mpd14.raffle.Student;

/**
 *
 * @author Miguel Gamboa at CCISEL
 */
public class Program {
 private static String classroomUrl = "http://thoth.cc.e.ipl.pt/classes/MPD/1314v/LI41N-LI61N/pages/tpcs---entregas/501";

    public static void main(String [] args) throws IOException
    {
        Dealer d = new Dealer(new URL(classroomUrl));

        String name = ListUtils.query(d.stds)
                .filter(s -> s.nr > 100)
                .map(s -> s.name)
                .skip(3)
                .iterator().next();

        System.out.println(name);
    }

    private static int CompareStdById(Student s1, Student s2)
    {
        return s1.nr - s2.nr;
    }
   
}
