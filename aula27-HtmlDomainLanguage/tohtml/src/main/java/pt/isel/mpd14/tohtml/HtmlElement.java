/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.isel.mpd14.tohtml;

import java.util.LinkedList;
import java.util.List;
import pt.isel.mpd14.tohtml.elems.HtmlTable;

/**
 *
 * @author Miguel Gamboa at CCISEL
 */
public class HtmlElement implements HtmlNode{

    public static HtmlElement html(){return new HtmlElement("HTML");}
    public static HtmlElement body(){return new HtmlElement("BODY");}
    public static HtmlElement head(){return new HtmlElement("HEAD");}
    public static HtmlElement div(){return new HtmlElement("DIV");}
    public static HtmlElement p(String content){return new HtmlElement("P", content);}
    public static HtmlElement title(){return new HtmlElement("TITLE");}
    public static HtmlTable table(){return new HtmlTable();}
    
    
    final String name;
    final List<HtmlNode> children;

    public HtmlElement(String name) {
        this.name = name;
        children = new LinkedList<>();
    }
    
    protected HtmlElement(String name, String content) {
        this.name = name;
        children = new LinkedList<>();
        children.add(new TextNode(content));
    }

    public void add(HtmlNode elem){
        children.add(elem);
    }
    
    public String print(){
        return print(0);
    }
    
    public String print(int indent){
        String res = indentation(indent) + "<" + name + ">\n";
        for (HtmlNode n : children) {
            res += n.print(INDENTATION + indent);
        }
        res += indentation(indent) + "</" + name + ">\n";
        return res;
    }
}
