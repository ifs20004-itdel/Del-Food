/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConToDB;

import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author samuel
 */
public class DBConnection {
    public Connection dbLink;   
    public Connection getConnection() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();;
            dbLink = DriverManager.getConnection("jdbc:mysql://localhost:3306/javafx-app","root","root");
        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
        
        return dbLink;
    }   
}