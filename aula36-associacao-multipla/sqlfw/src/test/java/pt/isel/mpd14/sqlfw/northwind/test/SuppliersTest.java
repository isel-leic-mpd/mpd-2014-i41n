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
import pt.isel.mpd14.sqlfw.northwind.Supplier;
import pt.isel.mpd14.sqlfw.northwind.SupplierDataMapper;

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
   
            DataMapper<Supplier> mapper = new SupplierDataMapper(exec);
            /*
             * 1. Lemos um Supplier
            */
            Supplier sup = mapper.getById(7);
            Assert.assertEquals("Melbourne", sup.getCity());
            /*
             * 2. Actualizamos uma propriedade no objecto de domínio.
            */
            sup.setCity("NY");
            /*
             * 3. Actualizamos a BD em conformidade com o objecto de domínio Supplier
            */
            mapper.update(sup);
            /*
             * 4. Lemos o mesmo Supplier para outra referencia
            */
            Supplier updatedSup = mapper.getById(7);
            
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
            
            DataMapper<Supplier> mapper = new SupplierDataMapper(exec);
            
            Assert.assertEquals(
                    "Exotic Liquids", 
                    mapper.getAll().iterator().next().getCompanyName());
        }

    }
}
