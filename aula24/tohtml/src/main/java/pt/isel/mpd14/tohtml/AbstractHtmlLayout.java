/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.isel.mpd14.tohtml;

/**
 *
 * @author Miguel Gamboa at CCISEL
 */
public abstract class AbstractHtmlLayout {
    
    public String buildPage(Object o){
        String res = "<html>\n";
        res += "   <head>\n";
        res += buildHeadContent(o);
        res += "   </head>\n";
        res += "   <body>\n";
        res += buildBodyContent(o);
        res += "   </body>\n";
        res += "</html>\n";
        return res;
    }
    
    protected abstract String buildHeadContent(Object o);
    protected abstract String buildBodyContent(Object o);   
}
