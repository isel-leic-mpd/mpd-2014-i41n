/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isel.mpd14.sqlfw.northwind.test;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import java.sql.SQLException;
import org.junit.Assert;
import org.junit.Test;
import pt.isel.mpd14.sqlfw.SqlConverter;
import pt.isel.mpd14.sqlfw.SqlExecutor;
import pt.isel.mpd14.sqlfw.northwind.Product;
import pt.isel.mpd14.sqlfw.northwind.Supplier;

/**
 *
 * @author Miguel Gamboa at CCISEL
 */
public class SuppliersTest {

    private final static SQLServerDataSource ds;

    static {
        ds = new SQLServerDataSource();
        ds.setUser("myAppUser");
        ds.setPassword("fcp");
        ds.setServerName("localhost");
        ds.setPortNumber(1433);
        ds.setDatabaseName("Northwind");
    }

    @Test
    public void test_product_get_by_id() throws SQLException {
        SqlExecutor exec = new SqlExecutor(ds);

        String getAllSuppliers = "SELECT [SupplierID],[CompanyName],[ContactName],[City] FROM [Northwind].[dbo].[Suppliers]";

        SqlConverter<Supplier> conv = rs -> new Supplier(
                rs.getInt(1),
                rs.getString(2),
                rs.getString(3),
                rs.getString(4));

        Supplier sup = exec.executeQuery(
                Supplier.class,
                getAllSuppliers,
                conv
        ).iterator().next();

        Assert.assertEquals("Exotic Liquids", sup.companyName);

    }
}
