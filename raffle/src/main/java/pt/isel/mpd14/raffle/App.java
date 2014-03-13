package pt.isel.mpd14.raffle;

import java.io.IOException;

public class App 
{
    public static void main( String[] args ) throws IOException
    {
        System.out.println("Working Directory = " +
              System.getProperty("user.dir"));
        new Dealer().print();
    }
}
