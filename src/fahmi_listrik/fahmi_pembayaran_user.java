/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fahmi_listrik;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import fahmi_connection.fahmidb_connection;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.HeadlessException;
import java.awt.print.PrinterException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Acer
 */
public class fahmi_pembayaran_user extends javax.swing.JFrame {

    /**
     * Creates new form fahmi_pembayaran_user
     */
    private Statement statement;
    private ResultSet resultset;
    private fahmidb_connection con;
    public fahmi_pembayaran_user() {
        initComponents();
        con = new fahmidb_connection();
        fahmi_BacaTabel();
    }
    
    private void fahmi_update(){
       try{
           Statement statement = con.connection.createStatement(resultset.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
           String SQL = "UPDATE pembayaran SET id_pembayaran='"+id_pem.getText()
                   +"',status='lunas"
                   +"'WHERE id_pembayaran='"+id_pem.getText()
                   +"'";
           statement.executeUpdate(SQL);
           statement.close();
           JOptionPane.showMessageDialog(null, "Terima Kasih Telah Membayar!");
       }
       catch (Exception e){
           JOptionPane.showMessageDialog(null,e.getMessage());
       }
   }
    
    private void fahmi_settabel(){
        int kolom=tabel.getSelectedRow();
        id_pem.setText((String)tabel.getValueAt(kolom,0));
        tgl.setText((String)tabel.getValueAt(kolom,1));
        id_tag.setText((String)tabel.getValueAt(kolom,2));
        jlh.setText((String)tabel.getValueAt(kolom,3));
        denda.setText((String)tabel.getValueAt(kolom,4));
        admin.setText((String)tabel.getValueAt(kolom,5));
        stat.setText((String)tabel.getValueAt(kolom,6));
    }
    
    public void fahmi_bersih(){
       id_pem.setText("");
       tgl.setText("");
       id_tag.setText("");
       admin.setText("");
       jlh.setText("");
       stat.setText("");
       tot.setText("");
       denda.setText("");
       TextPane.setText("");
    }
    
    
    
    private void fahmi_BacaTabel(){
    try{
        String header[]= {"ID Pembayaran","Tanggal Bayar","ID Tagihan","Jumlah Tagihan","Biaya Denda","Biaya Admin","Status","Total"};
        DefaultTableModel defaultTableModel = new DefaultTableModel(null,header);
        tabel.setModel(defaultTableModel);
        //Mengatur lebar kolom tabel
        TableColumn column;
        tabel.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        column = tabel.getColumnModel().getColumn(0);
        column.setPreferredWidth(100);
        column = tabel.getColumnModel().getColumn(1);
        column.setPreferredWidth(200);
        column = tabel.getColumnModel().getColumn(2);
        column.setPreferredWidth(200);
        column = tabel.getColumnModel().getColumn(3);
        column.setPreferredWidth(150);
        column = tabel.getColumnModel().getColumn(4);
        column.setPreferredWidth(200);
        column = tabel.getColumnModel().getColumn(5);
        column.setPreferredWidth(100);
        column = tabel.getColumnModel().getColumn(6);
        column.setPreferredWidth(150);
        column = tabel.getColumnModel().getColumn(7);
        column.setPreferredWidth(200);
        //looping tabel
        int baris = tabel.getSelectedRow();
        for (int i = 0; i < baris; i++){
            defaultTableModel.removeRow(i);
        }
        String sql = "select pembayaran.id_pembayaran, pembayaran.tanggal_bayar, tagihan.id_tagihan, (tagihan.pemakaian/1000*tarif.tarif_perkwh),pembayaran.biaya_denda,pembayaran.biaya_admin,pembayaran.status,(tagihan.pemakaian/1000*tarif.tarif_perkwh+pembayaran.biaya_admin+pembayaran.biaya_denda) from pembayaran inner join tagihan on pembayaran.id_tagihan=tagihan.id_tagihan inner join pelanggan on tagihan.id_pelanggan=pelanggan.id_pelanggan inner join tarif on tarif.kode=pelanggan.kode where pembayaran.status ='tidak' ";
        Statement statement = con.connection.createStatement();
        //ea
        ResultSet resultset = statement.executeQuery(sql);
        while (resultset.next()){
        String a = resultset.getString(1);
        String b = resultset.getString(2);
        String c = resultset.getString(3);
        String d = resultset.getString(4);
        String e = resultset.getString(5);
        String f = resultset.getString(6);
        String g = resultset.getString(7);
        String h = resultset.getString(8);
        Object isi[] = {a,b,c,d,e,f,g,h};
        defaultTableModel.addRow(isi);
    }
    }
    catch (Exception e){
        JOptionPane.showMessageDialog(null, e.getMessage());
    }
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        a = new javax.swing.JLabel();
        a5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        a4 = new javax.swing.JLabel();
        a3 = new javax.swing.JLabel();
        a2 = new javax.swing.JLabel();
        a1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        id_pem = new javax.swing.JTextField();
        tgl = new javax.swing.JTextField();
        id_tag = new javax.swing.JTextField();
        jlh = new javax.swing.JTextField();
        denda = new javax.swing.JTextField();
        admin = new javax.swing.JTextField();
        az = new javax.swing.JLabel();
        stat = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        TextPane = new javax.swing.JTextPane();
        tot = new javax.swing.JLabel();
        bayar = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Pembayaran");

        a.setText("Biaya Admin");

        a5.setText("ID Pembayaran");

        tabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabel);

        a4.setText("Tanggal Bayar");

        a3.setText("ID Tagihan");

        a2.setText("Jumlah Tagihan ");

        a1.setText("Biaya Denda");

        jButton1.setText("Kembali");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        az.setText("Status ");

        jScrollPane3.setViewportView(TextPane);

        tot.setText("Total");

        bayar.setText("Bayar");
        bayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bayarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 623, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(a5)
                    .addComponent(a4)
                    .addComponent(a3)
                    .addComponent(a2)
                    .addComponent(a1)
                    .addComponent(a)
                    .addComponent(az))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(admin, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                    .addComponent(denda, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                    .addComponent(jlh, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                    .addComponent(id_tag, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                    .addComponent(tgl, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                    .addComponent(id_pem)
                    .addComponent(stat))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bayar)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(197, 197, 197)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(tot)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(8, 8, 8)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(a5)
                                    .addComponent(id_pem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(a4)
                                    .addComponent(tgl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(a3)
                                    .addComponent(id_tag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(a2)
                                    .addComponent(jlh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(13, 13, 13)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(a1)
                                    .addComponent(denda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(a))
                            .addComponent(admin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(az)
                            .addComponent(stat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(tot)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(bayar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelMouseClicked
        // TODO add your handling code here
        int kolom=tabel.getSelectedRow();
        String id_pembayaran = tabel.getValueAt(kolom, 0).toString();
        id_pem.setText(id_pembayaran);
        
        String tanggal_bayar = tabel.getValueAt(kolom, 1).toString();
        tgl.setText(tanggal_bayar);
        
        String id_tagihan = tabel.getValueAt(kolom, 2).toString();
        id_tag.setText(id_tagihan);
        
        String jumlah_tagihan = tabel.getValueAt(kolom, 3).toString();
        jlh.setText(jumlah_tagihan);
        
        String biaya_denda = tabel.getValueAt(kolom, 4).toString();
        denda.setText(biaya_denda);
        
        String biaya_admin = tabel.getValueAt(kolom, 5).toString();
        admin.setText(biaya_admin);
        
        String status = tabel.getValueAt(kolom, 6).toString();
        stat.setText(status);
        
        String total = tabel.getValueAt(kolom, 7).toString();
        tot.setText(total);
        
        TextPane.setText("Pembayaran Listrik PascaBayar \t\n"
                + "----------------------------------------------------------\n"
                    + "id_pembayaran \t:    "+id_pembayaran+"\n"
                        + "tanggal_bayar \t:    "+tanggal_bayar+"\n"
                            + "id_tagihan \t\t:    "+id_tagihan+"\n"
                                + "jumlah_tagihan \t:    "+jumlah_tagihan+"\n"
                                    + "biaya_denda \t:    "+biaya_denda+"\n"
                                        + "biaya_admin \t:    "+biaya_admin+"\n"
                                            + "status \t\t:    "+status+"\n"
                                                + "total \t\t:    "+total+"\n"
                
        + "----------------------------------------------------------\n"
        + " ADMIN \n\n"
        + " Fahmi");
    }//GEN-LAST:event_tabelMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        new fahmi_dashboard_user().setVisible(true);
        //menutup gui login
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_formMouseClicked

    private void bayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bayarActionPerformed
        // TODO add your handling code here:
        fahmi_update();
        fahmi_bersih();
        fahmi_BacaTabel();
    }//GEN-LAST:event_bayarActionPerformed

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
            java.util.logging.Logger.getLogger(fahmi_pembayaran_user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fahmi_pembayaran_user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fahmi_pembayaran_user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fahmi_pembayaran_user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new fahmi_pembayaran_user().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextPane TextPane;
    private javax.swing.JLabel a;
    private javax.swing.JLabel a1;
    private javax.swing.JLabel a2;
    private javax.swing.JLabel a3;
    private javax.swing.JLabel a4;
    private javax.swing.JLabel a5;
    private javax.swing.JTextField admin;
    private javax.swing.JLabel az;
    private javax.swing.JButton bayar;
    private javax.swing.JTextField denda;
    private javax.swing.JTextField id_pem;
    private javax.swing.JTextField id_tag;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jlh;
    private javax.swing.JTextField stat;
    private javax.swing.JTable tabel;
    private javax.swing.JTextField tgl;
    private javax.swing.JLabel tot;
    // End of variables declaration//GEN-END:variables
}
