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
public class TextNode implements HtmlNode{

    final String content;
    
    public TextNode(String content) {
        this.content = content;
    }

    @Override
    public String print(int indent) {
        return indentation(indent) + content + "\n";
    }
    
}
