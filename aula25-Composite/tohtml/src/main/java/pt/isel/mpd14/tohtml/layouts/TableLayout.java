/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.isel.mpd14.tohtml.layouts;

import java.util.Map;
import pt.isel.mpd14.probe.Binder;
import pt.isel.mpd14.tohtml.AbstractHtmlLayout;

/**
 *
 * @author Miguel Gamboa at CCISEL
 */
public class TableLayout extends AbstractHtmlLayout{

    @Override
    protected String buildHeadContent(Object o) {
        String res = "       <title>";
        res += o.getClass();
        res += "</title>\n";
        return res;
    }

    @Override
    protected String buildBodyContent(Object o) {
            String res = "      <table>\n";
        try {
            Map<String, Object> values = Binder.getFieldsValues(o);
            for (Map.Entry<String, Object> entry : values.entrySet()) {
                String k = entry.getKey();
                Object v  = entry.getValue();
                res += "          <tr>";
                res += "<td>" + k + "</td><td>" + v + "</td>";
                res += "</tr>\n";
                
            }
        } catch (IllegalArgumentException | IllegalAccessException ex) {
            throw new RuntimeException(ex);
        }
        res += "       </table>\n";
        return res;
    }
    
}
