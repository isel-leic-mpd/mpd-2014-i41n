/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isel.mpd14.sqlfw.northwind.test;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import org.junit.Assert;
import org.junit.Test;
import pt.isel.mpd14.sqlfw.DataMapper;
import pt.isel.mpd14.sqlfw.SqlExecutor;
import pt.isel.mpd14.sqlfw.northwind.Product;
import pt.isel.mpd14.sqlfw.northwind.ProductDataMapper;
import pt.isel.mpd14.sqlfw.northwind.SupplierDataMapper;

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
    public void test_product_get_by_id() throws Exception {
        try(SqlExecutor exec = new SqlExecutor(ds)){

            exec.beginConnection(true);
            
            DataMapper<Product> mapper = new ProductDataMapper(
                    exec, 
                    new SupplierDataMapper(exec));
            
            Product p = mapper.getById(7);
            
            Assert.assertEquals(
                    "Uncle Bob's Organic Dried Pears", 
                    p.productName);
            Assert.assertEquals(
                    3, 
                    p.supplier.supplierID);
        }
    }
}
