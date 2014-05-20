package pt.isel.mpd14.tohtml.elems;

import pt.isel.mpd14.tohtml.HtmlElement;
import pt.isel.mpd14.tohtml.HtmlNode;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Miguel Gamboa at CCISEL
 */
public class HtmlTable extends HtmlElement{

    public HtmlTable() {
        super("TABLE");
    }

    public HtmlTr tr(){
        HtmlTr tr = new HtmlTr();
        super.add(tr);
        return tr;
    }

    @Override
    public void add(HtmlNode elem) {
        throw new UnsupportedOperationException("You cannot explicitly add new Elements!");
    }
    
    
}
