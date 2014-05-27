package pt.isel.mpd14.sqlfw;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import static java.lang.String.format;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException
    {
         final String connectionUrl = 
			"jdbc:sqlserver://localhost:1433;" +
			"databaseName=Northwind;" + 
			"user=myAppUser;password=fcp";
        
        // Connection c = DriverManager.getConnection(connectionUrl);
         
        SQLServerDataSource ds = new SQLServerDataSource();
        ds.setUser("myAppUser");
        ds.setPassword("fcp");
        ds.setServerName("localhost");
        ds.setPortNumber(1433);
        ds.setDatabaseName("Northwind");
        Connection c = ds.getConnection();
        
        PreparedStatement cmd = c.prepareStatement(
                "SELECT ProductID, ProductName, UnitPrice, UnitsInStock "
                        + "FROM Products WHERE UnitPrice > ? AND UnitsInStock > ?");
        cmd.setDouble(1, 30.0);
        cmd.setInt(2, 20);
        ResultSet rs = cmd.executeQuery();
        int count = 0;
        while(rs.next())
        {
            System.out.println(format("%d %s %f %d", rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getInt(4)));
            count++;
        }
        System.out.println("Fetched " + count + " rows");
    }
}
