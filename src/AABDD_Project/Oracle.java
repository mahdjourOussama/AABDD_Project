/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AABDD_Project;

/**
 *
 * @author mahdj
 */
import java.sql.*;
import javax.swing.*;

public class Oracle {
    Connection conn = null;
    public static String username="oussama",password="oussama";
    public static Connection ConnectDB(){
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String unicode="?useUnicode=yes&characterEncoding=UTF-8";


            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe",username,password); //serveur

            return conn;
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
            return null;
        }
    }

}
