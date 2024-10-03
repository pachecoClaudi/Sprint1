/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sprintuno;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author PACHECO
 */
public class Conexion {
    PreparedStatement ps;
    Connection cn;
    ResultSet rs;
    public  static  Connection getConnection(){
        Connection cn = null;
         
         String DB = "sisi_inf_2";
        String USER = "postgresql";
        String PASSWORD = "vyOGxx0O7zszp7ujIoo751QEinO0nD7j";
        String HOST = "dpg-crqs1188fa8c739icfh0-a.oregon-postgres.render.com";
        String PORT = "5432";
        String cadena="jdbc:postgresql://dpg-crqs1188fa8c739icfh0-a.oregon-postgres.render.com:5432/postgres1_kapp";
        try {
            Class.forName("org.postgresql.Driver");
            cn=DriverManager.getConnection(cadena,USER,PASSWORD);
            System.out.println("Conexion exitosa");
        } catch (Exception e) {
            System.out.println("error al conectar" + e.getMessage());
    }
        return cn;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Conexion.getConnection();
    }
    
    
    

}
