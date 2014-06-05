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
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;

/**
 *
 * @author Miguel Gamboa at CCISEL
 */
public class SqlExecutor implements AutoCloseable {

    private final DataSource ds;
    private Connection c;

    public SqlExecutor(DataSource ds) {
        this.ds = ds;
    }

    public void beginConnection(boolean autocommit) {
        try {
            if (c == null) {
                c = ds.getConnection();
                c.setAutoCommit(autocommit);
            } else {
                throw new UnsupportedOperationException("You already have an open connection.");
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void rollback() throws SQLException {
        c.rollback();
    }

    public void commit() throws SQLException {
        c.commit();
    }

    @Override
    public void close() throws Exception {
        if (c != null) {
            c.close();
            c = null;
        }
    }

    public <T> Iterable<T> executeQuery(
            String sqlStmt,
            SqlConverter<T> conv,
            Object... args) throws SQLException {
        /*
         if(c == null)
         throw new UnsupportedOperationException("You must initialize a connection before execute a comand!");
         */
        assert c != null; // activar com a opção -ea
        try (PreparedStatement cmd = c.prepareStatement(sqlStmt)) {
            /*
             * Bind dos parametros
             */
            int idx = 1;
            for (Object arg : args) {
                cmd.setObject(idx, arg);
                idx++;
            }
            /*
             * Execução do comando
             */
            ResultSet rs = cmd.executeQuery();
            /*
             * Transformação do RS em ED
             */
            Collection<T> elems = new LinkedList<>();
            while (rs.next()) {
                T item = conv.convert(rs);
                elems.add(item);
            }
            return elems;
        }   
    }

    public void executeUpdate(String sqlStmt, Object... args) throws SQLException {
        assert c != null; // activar com a opção -ea
        try (PreparedStatement cmd = c.prepareStatement(sqlStmt)) {
            /*
             * Bind dos parametros
             */
            int idx = 1;
            for (Object arg : args) {
                cmd.setObject(idx, arg);
                idx++;
            }
            /*
             * Execução do comando
             */
            cmd.executeUpdate();
        }
    }
}
