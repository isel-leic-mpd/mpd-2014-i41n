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
public interface HtmlNode {

    public static final int INDENTATION = 3;
    
    default String print(){
        return print(0);
    }
    
    default String indentation(int indent) {
        String res = "";
        for (int i = 0; i < indent; i++) {
            res += " ";
        }
        return res;
    }
    
    String print(int indent);
    
}
