/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.isel.mpd14.tohtml.layouts;

import java.util.Map;
import pt.isel.mpd14.probe.Binder;
import pt.isel.mpd14.tohtml.AbstractHtmlLayout;
import pt.isel.mpd14.tohtml.HtmlElement;
import static pt.isel.mpd14.tohtml.HtmlElement.title;
import pt.isel.mpd14.tohtml.TextNode;
import pt.isel.mpd14.tohtml.elems.HtmlTable;
import pt.isel.mpd14.tohtml.elems.HtmlTd;
import pt.isel.mpd14.tohtml.elems.HtmlTr;

/**
 *
 * @author Miguel Gamboa at CCISEL
 */
public class TableLayout extends AbstractHtmlLayout{

    @Override
    protected HtmlElement buildHeadContent(Object o) {
        HtmlElement title = title();
        title.add(new TextNode(o.getClass().toString()));
        return title;
    }

    @Override
    protected HtmlElement buildBodyContent(Object o) {
        HtmlTable table = HtmlElement.table();
        try {
            Map<String, Object> values = Binder.getFieldsValues(o);
            for (Map.Entry<String, Object> entry : values.entrySet()) {
                String k = entry.getKey();
                Object v  = entry.getValue();
                
                HtmlTr tr = table.tr();
               
                HtmlElement fieldName = tr.td(k);
                HtmlElement fieldValue = tr.td(v.toString());
            }
        } catch (IllegalArgumentException | IllegalAccessException ex) {
            throw new RuntimeException(ex);
        }
        return table;
    }
    
}
