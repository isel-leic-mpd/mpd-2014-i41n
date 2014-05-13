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
public abstract class AbstractHtmlLayout {
    
    public String buildPage(Object o){
        String res = buildHeader(o);
        res += buildBody(o);
        res += buildEnd();
        return res;
    }
    
    protected abstract String buildHeader(Object o);
    protected abstract String buildBody(Object o);
    protected abstract String buildEnd();
    
}
