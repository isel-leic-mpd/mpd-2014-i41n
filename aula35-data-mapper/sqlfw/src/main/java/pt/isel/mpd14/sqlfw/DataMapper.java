/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.isel.mpd14.sqlfw;

import java.sql.SQLException;

/**
 *
 * @author Miguel Gamboa at CCISEL
 */
public interface DataMapper<T>{ 
  Iterable<T> getAll() throws SQLException; 
  T getById(int id) throws SQLException;
  void update(T val) throws SQLException; 
  void delete(T val) throws SQLException; 
  void insert(T val) throws SQLException; 
} 