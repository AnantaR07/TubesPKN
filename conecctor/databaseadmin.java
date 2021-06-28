/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conecctor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author USER
 */
public class databaseadmin {
    public static Connection connection;
    public static Connection getConnection() throws SQLException{
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_admin","root","");
            
            
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        return connection;
    }
}
