

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Zunayed
 */
public class ConnectionUtil {
    Connection conn = null;
    public static Connection conDB() throws SQLException
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/memoria", "root", "");
            return con; 
            
        } catch (Exception ex) {
            System.err.println("Connection Util"+ ex.getMessage());
            return null;
        }
    }
}
