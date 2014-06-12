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
    public void test_supplier_update() throws Exception {
        try (SqlExecutor exec = new SqlExecutor(ds)) {
            exec.beginConnection(false);
            String getSupplierById = ""
                    + "SELECT [SupplierID],[CompanyName],[ContactName],[City] "
                    + "FROM [Northwind].[dbo].[Suppliers] "
                    + "WHERE [SupplierID] = ?";
            String updateSupplierById = ""
                    + "UPDATE  [Northwind].[dbo].[Suppliers] SET "
                    + "[CompanyName] = ?,[ContactName] = ?,[City] = ? "
                    + "WHERE [SupplierID] = ?";

            SqlConverter<Supplier> conv = rs -> new Supplier(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4));

            /*
             * 1. Lemos um Supplier
            */
            Supplier sup = exec.executeQuery(
                    getSupplierById,
                    conv,
                    7
            ).iterator().next();
            Assert.assertEquals("Melbourne", sup.getCity());
            /*
             * 2. Actualizamos uma propriedade no objecto de domínio.
            */
            sup.setCity("NY");
            /*
             * 3. Actualizamos a BD em conformidade com o objecto de domínio Supplier
            */
            exec.executeUpdate(updateSupplierById, sup.getCompanyName(), sup.getContactName(), sup.getCity(), sup.supplierID);
            /*
             * 4. Lemos o mesmo Supplier para outra referencia
            */
            Supplier updatedSup = exec.executeQuery(
                    getSupplierById,
                    conv,
                    7
            ).iterator().next();
            Assert.assertEquals(sup.getCity(),updatedSup.getCity());
            Assert.assertEquals(sup.getCompanyName(), updatedSup.getCompanyName());
            Assert.assertEquals(sup.getContactName(), updatedSup.getContactName());
            
            exec.rollback();
        }
    }
    
    @Test
    public void test_supplier_getall() throws Exception {
        try (SqlExecutor exec = new SqlExecutor(ds)) {
            
            exec.beginConnection(true);
            String getAllSuppliers = ""
                    + "SELECT [SupplierID],[CompanyName],[ContactName],[City] "
                    + "FROM [Northwind].[dbo].[Suppliers]";

            SqlConverter<Supplier> conv = rs -> new Supplier(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4));

            Supplier sup = exec.executeQuery(
                    getAllSuppliers,
                    conv
            ).iterator().next();

            Assert.assertEquals("Exotic Liquids", sup.getCompanyName());
        }

    }
}
