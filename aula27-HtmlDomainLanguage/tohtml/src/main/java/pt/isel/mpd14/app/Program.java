package pt.isel.mpd14.app;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import pt.isel.mpd14.tohtml.HtmlWriter;
import pt.isel.mpd14.tohtml.layouts.SimpleLayout;
import pt.isel.mpd14.tohtml.layouts.TableLayout;

/**
 * Hello world!
 *
 */
public class Program 
{
    public static void main( String[] args ) throws FileNotFoundException
    {
        
        Student s = new Student(7237, "Jose Manel", 20);
        
        // PrintStream out = new PrintStream(new FileOutputStream("Stud2.html"));
        PrintStream out = System.out;
        
        new HtmlWriter(out, new TableLayout()).write(s);
        // new HtmlWriter(out, new SimpleLayout()).write(s);
    }
}
