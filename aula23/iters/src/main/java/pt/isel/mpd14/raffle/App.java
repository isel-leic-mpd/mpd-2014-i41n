package pt.isel.mpd14.raffle;

import java.io.IOException;
import java.net.URL;


class App
{
    private static String classroomUrl = "http://thoth.cc.e.ipl.pt/classes/MPD/1314v/LI41N-LI61N/pages/tpcs---entregas/501";

    public static void main(String [] args) throws IOException
    {
        Dealer d = new Dealer(new URL(classroomUrl));
        
        d.stds.stream()
                .filter(s -> s.nr > 100)
                .sorted((s1, s2) -> s1.name.compareTo(s2.name))
                .forEach(System.out::println);
                //.forEach(s -> System.out.println(s));

        Student s = d.randStudent();
        System.out.println("Aluno sorteado = " + s);
    }

    private static int CompareStdById(Student s1, Student s2)
    {
        return s1.nr - s2.nr;
    }

}
