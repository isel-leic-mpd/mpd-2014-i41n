package pt.isel.mpd14.sqlfw;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import java.sql.SQLException;
import pt.isel.mpd14.sqlfw.northwind.Product;
import pt.isel.mpd14.sqlfw.northwind.Supplier;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException
    {
        SQLServerDataSource ds = new SQLServerDataSource();
        ds.setUser("myAppUser");
        ds.setPassword("fcp");
        ds.setServerName("localhost");
        ds.setPortNumber(1433);
        ds.setDatabaseName("Northwind");

        SqlExecutor exec = new SqlExecutor(ds);
        
        String getAllProducts = "SELECT ProductID, ProductName, UnitPrice, UnitsInStock "
                        + "FROM Products "
                        + "WHERE ProductId = ?";        
        SqlConverter<Product> conv = rs -> new Product(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getInt(4));
        Iterable<Product> prods = exec.executeQuery(
                Product.class,
                getAllProducts,
                conv,
                7);
        
        prods = exec.executeQuery(
                Product.class,
                getAllProducts,
                conv,
                11);
        
        for (Product p : prods) {
            System.out.println(p);
        }
        
        String getAllSuppliers = "SELECT [SupplierID],[CompanyName],[ContactName],[City] FROM [Northwind].[dbo].[Suppliers]";
        
        Iterable<Supplier> sups = exec.executeQuery(
                Supplier.class,
                getAllSuppliers,
                rs -> new Supplier(
                            rs.getInt(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4)));
    }
}
