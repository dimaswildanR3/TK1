/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koneksi;
import java.sql.*;
import javax.swing.JOptionPane;
public class koneksi_database {
public Connection cc;
public Statement ss;
public ResultSet rr;
    
  private static Connection koneksi;
    public static Connection getkoneksi(){
        if(koneksi==null){
            try{
            String url;
            url="jdbc:mysql://localhost/toko";
            String username = "root";
            String password = "";
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            koneksi = DriverManager.getConnection(url,username,password);
            }catch (SQLException e){
                JOptionPane.showMessageDialog(null, "Error koneksi");
            }
    
}return koneksi;
    }static Object getConnection(){
        throw new UnsupportedOperationException("Not Yet implemented");
    }
    public void Class () {

try{
        Class.forName("com.mysql.jdbc.Driver");
        cc=DriverManager.getConnection("jdbc:mysql://localhost/toko","root","");
        System.out.println("Koneksi Berhasil");
}

catch (ClassNotFoundException | SQLException e){
System.out.println (e);

}
}
}

