package pt.isel.mpd14.alerter;

import javax.swing.JOptionPane;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Alarm a = new Alarm();
        
        a.addHandler((eventNr) -> System.out.println("Evento " + eventNr.nrEvent));
        a.addHandler((eventNr) -> JOptionPane.showMessageDialog(null, "Ola evento " + eventNr.nrEvent + " at " + eventNr.eventTime));
        
        long now = System.currentTimeMillis();
        a.addEvent(now + 2000);
        a.addEvent(now + 5000);
        a.addEvent(now + 6000);
        
        a.start();
    }
}
