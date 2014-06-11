/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.isel.mpd14.aula32;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Miguel Gamboa at CCISEL
 */
public class ReflectPredicate<T> implements Predicate<T>{

    final String fieldName;
    final Object expected;
    Field targetField;
    
    public ReflectPredicate(String fieldName, Object expected) {
        this.fieldName = fieldName;
        this.expected = expected;
    }

    @Override
    public boolean test(T target) {
        
        if(targetField == null)
            targetField = Arrays.stream(target.getClass().getDeclaredFields())
                    .filter( f -> f.getName().equals(fieldName))
                    .findFirst()
                    .get();
        try {
            return targetField.get(target).equals(expected);
        } catch (IllegalArgumentException | IllegalAccessException ex) {
            throw new RuntimeException(ex);
        }
    }
    
}
