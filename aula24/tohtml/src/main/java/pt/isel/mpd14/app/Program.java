package pt.isel.mpd14.app;

import pt.isel.mpd14.tohtml.HtmlWriter;
import pt.isel.mpd14.tohtml.layouts.SimpleLayout;

/**
 * Hello world!
 *
 */
public class Program 
{
    public static void main( String[] args )
    {
        
        Student s = new Student(7237, "Jose Manel", 20);
        new HtmlWriter(System.out, new SimpleLayout()).write(s);
    }
}
