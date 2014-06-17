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
public abstract class AbstractDataMapper<T> implements DataMapper<T>{

    protected abstract String sqlGetAll();
    protected abstract String sqlGetById();
    protected abstract String sqlUpdate();
    protected abstract SqlConverter<T> conv();
    protected abstract SqlSerializer<T> serializer();
    
    protected final SqlExecutor exec;

    protected AbstractDataMapper(SqlExecutor exec) {
        this.exec = exec;
    }
    
    @Override
    public final Iterable<T> getAll() throws SQLException {
            return exec.executeQuery(
                    sqlGetAll(),
                    conv()); 
    }

    @Override
    public final T getById(int id) throws SQLException {
            return exec.executeQuery(
                    sqlGetById(),
                    conv(),
                    id).iterator().next(); 
    
    }

    @Override
    public final void update(T val) throws SQLException {
        exec.executeUpdate(
                sqlUpdate(), 
                serializer().serialize(val));
    }
    
    
    
}
