package tugas;

import javax.swing.JOptionPane;

public class Menu extends javax.swing.JFrame {
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;

    public Menu() {
        initComponents();
    }

    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24));
        jLabel1.setText("Selamat Datang");

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Data Karyawan");
        jButton1.addActionListener(evt -> jButton1ActionPerformed(evt));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Data Barang");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Transaksi");
        jButton3.addActionListener(evt -> jButton3ActionPerformed(evt));

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Data Pembeli");
        jButton4.addActionListener(evt -> jButton4ActionPerformed(evt));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/off_logo.png")));
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        jLabel3.setForeground(new java.awt.Color(153, 153, 153));
        jLabel3.setText("Di aplikasi toko kami");

        // Tambahkan komponen ke panel
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(42, 42, 42)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(getLabel1Text())
                                .addComponent(jLabel2)
                            )
                        )
                    )
                )
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                )
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        // Kode lainnya tetap sama
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        karyawan fa = new karyawan();
        fa.show();
        dispose();
    }

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {
        int jawab;
        if ((jawab = JOptionPane.showConfirmDialog(null, "Apakah Anda Ingin Keluar ?", "Konfirmasi", JOptionPane.YES_NO_OPTION)) == 0) {
            Login lg = new Login();
            lg.show();
            this.dispose();
        }
    }

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {
        Barang fa = new Barang();
        fa.show();
        dispose();
    }

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
        pembeli fa = new pembeli();
        fa.show();
        dispose();
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        transaksi fa = new transaksi();
        fa.show();
        dispose();
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> new Menu().setVisible(true));
    }

    public String getLabel1Text() {
        return jLabel1.getText();
    }

    public void setLabel1Text(String text) {
        jLabel1.setText(text);
    }

    public String getLabel3Text() {
        return jLabel3.getText();
    }

    public void setLabel3Text(String text) {
        jLabel3.setText(text);
    }
}
