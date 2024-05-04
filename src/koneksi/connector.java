/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

//koneksi ke database

package koneksi;
import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class connector {
    static Connection con;
    
    public static Connection connection(){
        if (con==null) {
            MysqlDataSource data = new MysqlDataSource();
            data.setDatabaseName("movie_db");
            data.setUser("root");
            data.setPassword("");
            try {
                con = data.getConnection();
                System.out.println("Koneksi ke Database Berhasil!");
            } catch (SQLException ex) {
                ex.printStackTrace();
                System.out.println("Koneksi ke Database Gagal!");
            }
        }
        
        return con;
    }
}