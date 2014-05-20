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
import static pt.isel.mpd14.tohtml.HtmlElement.div;
import static pt.isel.mpd14.tohtml.HtmlElement.html;
import static pt.isel.mpd14.tohtml.HtmlElement.p;
import static pt.isel.mpd14.tohtml.HtmlElement.title;
import pt.isel.mpd14.tohtml.TextNode;

/**
 *
 * @author Miguel Gamboa at CCISEL
 */
public class SimpleLayout extends AbstractHtmlLayout{

    @Override
    protected HtmlElement buildHeadContent(Object o) {
        HtmlElement title = title();
        title.add(new TextNode(o.getClass().toString()));
        return title;
    }

    @Override
    protected HtmlElement buildBodyContent(Object o) {
        HtmlElement div = div();
        try {
            Map<String, Object> values = Binder.getFieldsValues(o);
            for (Map.Entry<String, Object> entry : values.entrySet()) {
                String k = entry.getKey();
                Object v  = entry.getValue();
                div.add(p(k + ": " + v));                
            }
        } catch (IllegalArgumentException | IllegalAccessException ex) {
            throw new RuntimeException(ex);
        }
        return div;
    }

}
