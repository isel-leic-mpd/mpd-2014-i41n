/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.isel.mpd14.sqlfw.northwind;

import java.sql.SQLException;
import pt.isel.mpd14.sqlfw.AbstractDataMapper;
import pt.isel.mpd14.sqlfw.DataMapper;
import pt.isel.mpd14.sqlfw.SqlConverter;
import pt.isel.mpd14.sqlfw.SqlExecutor;
import pt.isel.mpd14.sqlfw.SqlSerializer;

/**
 *
 * @author Miguel Gamboa at CCISEL
 */
public class ProductDataMapper extends AbstractDataMapper<Product>{

    final DataMapper<Supplier> mapperSupplier;
    
    public ProductDataMapper(SqlExecutor exec, DataMapper<Supplier> mapperSupplier) {
        super(exec);
        this.mapperSupplier = mapperSupplier;
    }
    
     @Override
    public void delete(Product val) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insert(Product val) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected String sqlGetAll() {
        return "SELECT ProductID, ProductName, UnitPrice, UnitsInStock, SupplierId "
                    + "FROM Products";
    }

    @Override
    protected SqlConverter<Product> conv() {
        return rs -> new Product(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getDouble(3),
                    rs.getInt(4),
                mapperSupplier.getById( rs.getInt(5)));
    }

    @Override
    protected String sqlGetById() {
        return sqlGetAll() + " WHERE ProductID = ?";
    }

    @Override
    protected String sqlUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected SqlSerializer<Product> serializer() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
