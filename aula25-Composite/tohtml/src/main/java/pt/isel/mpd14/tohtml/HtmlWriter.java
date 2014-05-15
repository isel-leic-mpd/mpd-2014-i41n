/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.isel.mpd14.tohtml;

import java.io.PrintStream;

/**
 *
 * @author Miguel Gamboa at CCISEL
 */
public class HtmlWriter {
    
    final PrintStream out;
    final AbstractHtmlLayout layout;

    public HtmlWriter(PrintStream out, AbstractHtmlLayout layout) {
        this.out = out;
        this.layout = layout;
    }

    public void write(Object o){
        out.println(layout.buildPage(o));
    }
    
}
