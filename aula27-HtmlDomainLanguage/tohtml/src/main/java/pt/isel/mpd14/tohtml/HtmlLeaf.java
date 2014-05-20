/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.isel.mpd14.tohtml;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Miguel Gamboa at CCISEL
 */
public class HtmlLeaf implements HtmlNode{
    final String name;
    final Map<String, String> attributes;
    
    
    public HtmlLeaf(String name){
        this.name = name;
        attributes = new HashMap<>();
    }
    
    
    public void add(String key, String value){
        attributes.put(key, value);
    }
    

    @Override
    public String print(int indent) {
         String res = indent + "<" + name;
        for (Map.Entry<String, String> e : attributes.entrySet()) {
            res += " " + e.getKey()+"=\""+e.getValue() + "\"";
        }
        res += "/>\n";
        return res;
    }
}