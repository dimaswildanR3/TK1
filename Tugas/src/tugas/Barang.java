/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Barang extends javax.swing.JFrame {

    public Barang() {
        initComponents();
        tampil();
    }

    private void clean() {
        filed_nomer_barang.setText("");
        field_nama_barang.setText("");
        filed_harga.setText("");
        field_stok.setText("");
    }

    private void tampil() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Kode Barang");
        model.addColumn("Nama Barang");
        model.addColumn("Harga");
        model.addColumn("Stok");

        try {
            int no = 1;
            String sql = "select * from barang";
            java.sql.Connection conn = (Connection) config.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while (res.next()) {
                model.addRow(new Object[]{res.getString(1), res.getString(2), res.getString(3), res.getString(4)});
            }
            tabel_barang.setModel(model);
        } catch (SQLException e) {
        }
    }

    public abstract class Item {
        protected String nomorBarang;
        protected String namaBarang;
        protected double harga;
        protected int stok;

        public Item(String nomorBarang, String namaBarang, double harga, int stok) {
            this.nomorBarang = nomorBarang;
            this.namaBarang = namaBarang;
            this.harga = harga;
            this.stok = stok;
        }

        public abstract void displayInfo();
    }

    public class Produk extends Item {
        private String kategori;

        public Produk(String nomorBarang, String namaBarang, double harga, int stok, String kategori) {
            super(nomorBarang, namaBarang, harga, stok);
            this.kategori = kategori;
        }

        @Override
        public void displayInfo() {
            filed_nomer_barang.setText(nomorBarang);
            field_nama_barang.setText(namaBarang);
            filed_harga.setText(String.valueOf(harga));
            field_stok.setText(String.valueOf(stok));
        }
    }

    public class Peralatan extends Item {
        private String jenis;

        public Peralatan(String nomorBarang, String namaBarang, double harga, int stok, String jenis) {
            super(nomorBarang, namaBarang, harga, stok);
            this.jenis = jenis;
        }

        @Override
        public void displayInfo() {
            filed_nomer_barang.setText(nomorBarang);
            field_nama_barang.setText(namaBarang);
            filed_harga.setText(String.valueOf(harga));
            field_stok.setText(String.valueOf(stok));
        }
    }

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {
        try {
            String nomorBarang = filed_nomer_barang.getText();
            String namaBarang = field_nama_barang.getText();
            double harga = Double.parseDouble(filed_harga.getText());
            int stok = Integer.parseInt(field_stok.getText());
            String sql = "INSERT INTO barang VALUES ('" + nomorBarang + "','" + namaBarang + "','" + harga + "','" + stok + "')";
            java.sql.Connection conn = (Connection) config.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Data Disimpan");
        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        tampil();
        clean();
    }

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {
        try {
            String nomorBarang = filed_nomer_barang.getText();
            String sql = "delete from barang where kd_barang='" + nomorBarang + "'";
            java.sql.Connection conn = (Connection) config.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(this, "Data berhasil dihapus");
        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        tampil();
        clean();
    }

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {
        try {
            String nomorBarang = filed_nomer_barang.getText();
            String namaBarang = field_nama_barang.getText();
            double harga = Double.parseDouble(filed_harga.getText());
            int stok = Integer.parseInt(field_stok.getText());
            String sql = "UPDATE barang SET nm_barang = '" + namaBarang + "',harga= '" + harga + "',stok= '" + stok + "' WHERE kd_barang = '" + nomorBarang + "'";
            java.sql.Connection conn = (Connection) config.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "data berhasil di edit");
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Perubahan Data Gagal" + e.getMessage());
        }
        tampil();
        clean();
    }

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Kode Barang");
        model.addColumn("Nama Barang");
        model.addColumn("Harga");
        model.addColumn("Stok");

        try {
            String sql = "Select * from barang where kd_barang like '%" + field_cari.getText() + "%'"
                    + "or  nm_barang like '%" + field_cari.getText() + "%'";
            java.sql.Connection conn = (Connection) config.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while (res.next()) {
                model.addRow(new Object[]{res.getString(1), res.getString(2), res.getString(3), res.getString(4)});
            }
            tabel_barang.setModel(model);
        } catch (Exception e) {
        }
        if (field_cari.getText().equals("")) {
            tampil();
        }
    }

    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Barang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField field_cari;
    private javax.swing.JTextField field_nama_barang;
    private javax.swing.JTextField field_stok;
    private javax.swing.JTextField filed_harga;
    private javax.swing.JTextField filed_nomer_barang;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabel_barang;
    // End of variables declaration//GEN-END:variables
}
