/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fees_managmentsystem;
import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author ankit
 */
public class DBConnection {
    public static  Connection getConnection(){
        Connection con =null;
         try{
            Class.forName("org.apache.derby.iapi.jdbc.AutoloadedDriver");
             con =DriverManager.getConnection("jdbc:derby://localhost:1527/FeesManagementSystem","ankit","ankit");
        }
        catch(Exception e){
            e.printStackTrace();
        }
       return con; 
    }
}
