/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.isel.mpd14.tohtml.layouts;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import pt.isel.mpd14.probe.Binder;
import pt.isel.mpd14.tohtml.AbstractHtmlLayout;

/**
 *
 * @author Miguel Gamboa at CCISEL
 */
public class SimpleLayout extends AbstractHtmlLayout{

    @Override
    protected String buildHeader(Object o) {
        String res = "<html>\n";
        res += "   <head>\n";
        res += "   <title>";
        res += o.getClass();
        res += "</title>\n";
        res += "   </head>\n";
        return res;
    }

    @Override
    protected String buildBody(Object o) {
        String res = "<body>";
        try {
            Map<String, Object> values = Binder.getFieldsValues(o);
            for (Map.Entry<String, Object> entry : values.entrySet()) {
                String k = entry.getKey();
                Object v  = entry.getValue();
                res += "    <p>";
                res += k + ": " + v;
                res += "</p>\n";
                
            }
        } catch (IllegalArgumentException | IllegalAccessException ex) {
            throw new RuntimeException(ex);
        }
        return res;
    }

    @Override
    protected String buildEnd() {
        String res = "</body>\n";
        res += "</html>\n";
        return res;
    }
    
}
