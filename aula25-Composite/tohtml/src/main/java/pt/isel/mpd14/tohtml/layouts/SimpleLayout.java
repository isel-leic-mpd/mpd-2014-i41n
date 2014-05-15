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
import pt.isel.mpd14.tohtml.HtmlElement;

/**
 *
 * @author Miguel Gamboa at CCISEL
 */
public class SimpleLayout extends AbstractHtmlLayout{

    @Override
    protected String buildHeadContent(Object o) {
        String res = "       <title>";
        res += o.getClass();
        res += "</title>\n";
        return res;
    }

    @Override
    protected String buildBodyContent(Object o) {
        HtmlElement div = new HtmlElement("div");
        try {
            Map<String, Object> values = Binder.getFieldsValues(o);
            for (Map.Entry<String, Object> entry : values.entrySet()) {
                String k = entry.getKey();
                Object v  = entry.getValue();
                div.add(new HtmlElement("p", k + ": " + v));                
            }
        } catch (IllegalArgumentException | IllegalAccessException ex) {
            throw new RuntimeException(ex);
        }
        return div.print();
    }

}
