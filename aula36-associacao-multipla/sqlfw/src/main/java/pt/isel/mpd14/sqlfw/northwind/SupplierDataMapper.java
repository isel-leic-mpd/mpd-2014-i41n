/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isel.mpd14.sqlfw.northwind;

import java.sql.SQLException;
import pt.isel.mpd14.sqlfw.AbstractDataMapper;
import pt.isel.mpd14.sqlfw.SqlConverter;
import pt.isel.mpd14.sqlfw.SqlExecutor;
import pt.isel.mpd14.sqlfw.SqlSerializer;

/**
 *
 * @author Miguel Gamboa at CCISEL
 */
/**
 *
 * @author Miguel Gamboa at CCISEL
 */
public class SupplierDataMapper extends AbstractDataMapper<Supplier> {

    public SupplierDataMapper(SqlExecutor exec) {
        super(exec);
    }

    @Override
    public void delete(Supplier val) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insert(Supplier val) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected String sqlGetAll() {
        return "SELECT [SupplierID],[CompanyName],[ContactName],[City] "
                + "FROM [Northwind].[dbo].[Suppliers]";
    }

    @Override
    protected String sqlGetById() {
        return sqlGetAll() + " WHERE SupplierID = ?";
    }

    @Override
    protected SqlConverter<Supplier> conv() {
        return rs -> new Supplier(
                rs.getInt(1),
                rs.getString(2),
                rs.getString(3),
                rs.getString(4));
    }

    @Override
    protected String sqlUpdate() {
        return "UPDATE  [Northwind].[dbo].[Suppliers] SET "
                    + "[CompanyName] = ?,[ContactName] = ?,[City] = ? "
                    + "WHERE [SupplierID] = ?";
    }

    @Override
    protected SqlSerializer<Supplier> serializer() {
        return sup -> new Object[] {
                sup.getCompanyName(),
                sup.getContactName(),
                sup.getCity(),
                sup.supplierID
            };
    }
}
