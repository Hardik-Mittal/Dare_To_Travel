
package frontPage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class myConnection {
    public static Connection getConnection() throws SQLException{
        
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3307/daretotravel","root","anand1234");
            } 
        catch (ClassNotFoundException ex) {
            Logger.getLogger(myConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
}
