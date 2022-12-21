/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huytm.Connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author acer
 */
public class MyConnection {
    public static Connection makeConnecton () throws SQLException{
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            String url = "jdbc:sqlserver://SE140602:1433; databaseName=ProductManagement";
            Connection cn = DriverManager.getConnection(url, "sa", "0986855878");
            return cn;
                    
        }catch(ClassNotFoundException ex){
            ex.printStackTrace();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }
}
