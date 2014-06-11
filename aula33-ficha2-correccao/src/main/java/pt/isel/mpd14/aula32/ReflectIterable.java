/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.isel.mpd14.aula32;

/**
 *
 * @author Miguel Gamboa at CCISEL
 */
interface ReflectIterable<T> extends Iterable<T>{
    ReflectIterable<T> filter(String fieldName, Object expected);
}
