/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.isel.mpd14.tohtml;

import static pt.isel.mpd14.tohtml.HtmlElement.body;
import static pt.isel.mpd14.tohtml.HtmlElement.head;
import static pt.isel.mpd14.tohtml.HtmlElement.html;

/**
 *
 * @author Miguel Gamboa at CCISEL
 */
public abstract class AbstractHtmlLayout {
    
    public String buildPage(Object o){
        HtmlElement html = html();
        HtmlElement head  = head();
        HtmlElement body = body();
        html.add(head);
        html.add(body);
        head.add(buildHeadContent(o));
        body.add(buildBodyContent(o));
        return html.print();
    }
    
    protected abstract HtmlElement buildHeadContent(Object o);
    protected abstract HtmlElement buildBodyContent(Object o);   
}
