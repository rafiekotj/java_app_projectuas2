/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package konfigurasi;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author rafie
 */
public class Koneksi {
     String url, username, password;
   
    //Constructor
    public Koneksi(String database){
        this.url="jdbc:mysql://localhost:3306/"+database;
        this.username="root";
        this.password="";
    }
   
    public Connection aktifkan_koneksi(){
        Connection konek=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            konek=DriverManager.getConnection(this.url,this.username,this.password);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Periksa Nama Database, Koneksi Gagal");
            System.out.println("Erornya :"+e);
            System.exit(0);
        }
        return konek;
    }

}
