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

/**
 *
 * @author Miguel Gamboa at CCISEL
 */
public class ProductsTest {

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
        
        String cmdGetAllProducts = "SELECT ProductID, ProductName, UnitPrice, UnitsInStock "
                        + "FROM Products "
                        + "WHERE ProductId = ?";        
        
        SqlConverter<Product> conv = rs -> new Product(
                rs.getInt(1),
                rs.getString(2),
                rs.getDouble(3),
                rs.getInt(4));

        Product prod = exec.executeQuery(
                Product.class,
                cmdGetAllProducts,
                conv,
                7
        ).iterator().next();
        
        Assert.assertEquals("Uncle Bob's Organic Dried Pears", prod.productName);

    }
}
