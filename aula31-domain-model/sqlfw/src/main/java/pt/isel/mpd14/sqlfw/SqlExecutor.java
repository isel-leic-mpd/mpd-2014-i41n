/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isel.mpd14.sqlfw;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import javax.sql.DataSource;

/**
 *
 * @author Miguel Gamboa at CCISEL
 */
class SqlExecutor {

    private final DataSource ds;
            
    public SqlExecutor(DataSource ds) {
        this.ds = ds;
    }

    public <T> Iterable<T> executeQuery(
            Class<T> de, 
            String sqlStmt, 
            SqlConverter<T> conv,
            Object...args) throws SQLException 
    {
        try(Connection c = ds.getConnection();
            PreparedStatement cmd = c.prepareStatement(sqlStmt);
        ){
            int idx = 1;
            for (Object arg : args) {
                cmd.setObject(idx, arg);
                idx++;
            }
            ResultSet rs = cmd.executeQuery();
            List<T> elems = new LinkedList<>();
            while (rs.next()) {
                T item = conv.convert(rs);
                elems.add(item);
            }
            return elems;
        }
    }
}
