/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.isel.mpd14.tohtml.elems;

import pt.isel.mpd14.tohtml.HtmlElement;

/**
 *
 * @author Miguel Gamboa at CCISEL
 */
public class HtmlTr extends HtmlElement{

    public HtmlTr() {
        super("TR");
    }
    
    public HtmlTd td(String content){
        HtmlTd td = new HtmlTd(content);
        this.add(td);
        return td;
    }
    
}
