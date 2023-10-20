package tugas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection extends config {
    private String databaseName;
    
    public DatabaseConnection(String databaseName) {
        this.databaseName = databaseName;
    }
    
    public Connection establishConnection() throws SQLException {
        Connection connection = null;
        try {
            String url = "jdbc:mysql://localhost:3306/" + databaseName; //url database
            String user = "root"; //user database
            String pass = ""; //password database
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            connection = DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
            System.err.println("Koneksi gagal " + e.getMessage());
        }
        return connection;
    }

    public static void main(String[] args) {
        // Membuat objek DatabaseConnection
        DatabaseConnection dbConnection = new DatabaseConnection("toko");
        
        try {
            // Membuka koneksi ke database
            Connection connection = dbConnection.establishConnection();
            if (connection != null) {
                System.out.println("Koneksi sukses!");
                // Lakukan operasi lain dengan koneksi database
                // ...
                // Tutup koneksi setelah selesai
                connection.close();
            } else {
                System.out.println("Koneksi gagal!");
            }
        } catch (SQLException e) {
            System.err.println("Terjadi kesalahan saat menghubungkan ke database: " + e.getMessage());
        }
    }
}
