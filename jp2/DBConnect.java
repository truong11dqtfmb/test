package jp2;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnect {
    
    public static Connection open() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
        } catch (Exception ex) {
            System.out.println("HUUU: " + ex.getMessage());
            ex.printStackTrace();
            return null;
        }
        
    }

    public static void closeAll(Connection con, PreparedStatement stm, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (stm != null) {
            try {
                stm.close();
            } catch (SQLException ex) {
                Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static void main(String[] args) {
//        System.out.println(open());
System.out.println("aaaaaaaaaaaaaa");
        
    }
    
}
