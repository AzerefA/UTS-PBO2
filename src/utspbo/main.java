/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utspbo;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Header;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.html.simpleparser.TableWrapper;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Akito
 */
public class main extends javax.swing.JFrame {
    String nol_jam = "";
    String nol_menit = "";
    String nol_detik = "";

    /**
     * Creates new form main
     */
    public main(String nama) {
        initComponents();
        hargat();
        selectData();
        String nama_kasir = nama;
        kasir.setText(nama);
    }
    public void setJam(){
     ActionListener taskPerformer = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date dt = new Date();
                int nilai_jam = dt.getHours();
                int nilai_menit = dt.getMinutes();
                int nilai_detik = dt.getSeconds();
                if (nilai_jam <= 9) {
                    nol_jam = "0";
                }
                if (nilai_menit <=9) {
                    nol_menit = "0";
                }
                if (nilai_detik <= 9) {
                    nol_detik = "0";
                }
                
                String jam = nol_jam + Integer.toString(nilai_jam);
                String menit = nol_menit + Integer.toString(nilai_menit);
                String detik = Integer.toString(nilai_detik);
                Jaml.setText(jam+ ":" + menit +":"+detik);
                
            }
        };
    new Timer(100, taskPerformer).start();
}
    
    public void hargat(){
        int harga = 0;
        int total = 0;
        int diskons = 0;
        int jum = 0;
        String SQL = "Select * From chart";
        ResultSet rs = KoneksiDB.executeQuery(SQL);
        try {
            while(rs.next()) {
                harga =+ rs.getInt(3);
                
                total += harga;
                
            }
            if (total == 100000) {
                diskon.setText("10%");
                diskons = total /10;
                jum = total - diskons;
                jumlah.setText("Rp."+String.valueOf(total));
           }else if(total > 100000){
               diskon.setText("20%");
                diskons = total / 5;
                jum = total - diskons;
                jumlah.setText("Rp."+String.valueOf(jum));
           }else{
              diskon.setText("0%");
              jum = total;
              jumlah.setText("Rp."+String.valueOf(jum));
           }hargatt.setText("Rp."+String.valueOf(total));
            
            
        } catch (Exception e) {
            
        }
        
        
    }
    public void selectData(){
            String kolom[] = {"ID Barang","Nama Barang","Harga"};
            DefaultTableModel dtm = new DefaultTableModel(null, kolom);
            String SQL = "SELECT * FROM chart";
            ResultSet rs = KoneksiDB.executeQuery(SQL);
            try {
                while (rs.next()) {
                    String id = rs.getString(1);
                    String barang = rs.getString(2);
                    String harga = rs.getString(3);
                    String data[] = {id,barang,harga};
                    dtm.addRow(data);
                }
        } catch (SQLException ex) {
                Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
            tabel.setModel(dtm);
        }
    
    public void selectCari(){
        String caris = cari.getText();
        String kolom[] = {"ID Barang","Nama Barang","Harga"};
            DefaultTableModel dtm = new DefaultTableModel(null, kolom);
            String SQL = "SELECT * FROM produk where nama_barang REGEXP '"+caris+"'";
            ResultSet rs = KoneksiDB.executeQuery(SQL);
            try {
                while (rs.next()) {
                    String id = rs.getString(1);
                    String barang = rs.getString(2);
                    String harga = rs.getString(3);
                    String data[] = {id,barang,harga};
                    dtm.addRow(data);
                }
        } catch (SQLException ex) {
                Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
            tabel1.setModel(dtm);
    }

    public void setTanggal(){
    java.util.Date skrg = new java.util.Date();
    java.text.SimpleDateFormat kal = new SimpleDateFormat("dd/MM/yyyy");
    tanggal.setText(kal.format(skrg));
    
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tanggal = new javax.swing.JLabel();
        Jaml = new javax.swing.JLabel();
        tanggal1 = new javax.swing.JLabel();
        Jaml1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel1 = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jumlah = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        diskon = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        hargatt = new javax.swing.JTextField();
        print = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        kasir = new javax.swing.JLabel();
        kasirs = new javax.swing.JLabel();
        cari = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        save = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        clear = new javax.swing.JButton();
        judul = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 102, 0));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Toko Buku Akito");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(300, 10, 430, 40);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Toko buku tak berkualitas");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(430, 50, 190, 17);

        tanggal.setText(" ");
        jPanel1.add(tanggal);
        tanggal.setBounds(870, 74, 110, 20);
        jPanel1.add(Jaml);
        Jaml.setBounds(870, 44, 110, 20);

        tanggal1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tanggal1.setText("Tanggal:");
        jPanel1.add(tanggal1);
        tanggal1.setBounds(810, 70, 60, 20);

        Jaml1.setText("Jam:");
        jPanel1.add(Jaml1);
        Jaml1.setBounds(820, 40, 40, 20);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1000, 110);

        jPanel3.setBackground(new java.awt.Color(255, 102, 0));
        jPanel3.setLayout(null);

        tabel1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID Barang", "Nama Barang", "Harga Barang"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabel1);

        jPanel3.add(jScrollPane1);
        jScrollPane1.setBounds(10, 340, 650, 130);

        jPanel5.setBackground(new java.awt.Color(255, 204, 51));
        jPanel5.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Jumlah Bayar:");
        jPanel5.add(jLabel3);
        jLabel3.setBounds(20, 100, 90, 20);
        jPanel5.add(jumlah);
        jumlah.setBounds(120, 90, 170, 30);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Total harga :");
        jPanel5.add(jLabel5);
        jLabel5.setBounds(20, 20, 90, 20);
        jPanel5.add(diskon);
        diskon.setBounds(120, 60, 170, 20);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Diskon        :");
        jPanel5.add(jLabel7);
        jLabel7.setBounds(20, 60, 90, 20);

        hargatt.setEditable(false);
        jPanel5.add(hargatt);
        hargatt.setBounds(120, 20, 170, 30);

        print.setText("Print");
        print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printActionPerformed(evt);
            }
        });
        jPanel5.add(print);
        print.setBounds(20, 150, 80, 30);

        jPanel3.add(jPanel5);
        jPanel5.setBounds(670, 280, 300, 190);

        jPanel2.setLayout(null);

        kasir.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        kasir.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        kasir.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel2.add(kasir);
        kasir.setBounds(110, 10, 220, 40);

        kasirs.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        kasirs.setText("Nama Kasir:");
        jPanel2.add(kasirs);
        kasirs.setBounds(10, 10, 100, 20);

        jPanel3.add(jPanel2);
        jPanel2.setBounds(10, 210, 340, 60);

        cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariActionPerformed(evt);
            }
        });
        cari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cariKeyPressed(evt);
            }
        });
        jPanel3.add(cari);
        cari.setBounds(10, 300, 150, 30);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Pencarian(nama barang):");
        jPanel3.add(jLabel6);
        jLabel6.setBounds(10, 280, 200, 20);

        tabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID Barang", "Nama Barang", "Harga Barang"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tabel);

        jPanel3.add(jScrollPane3);
        jScrollPane3.setBounds(10, 10, 960, 190);

        getContentPane().add(jPanel3);
        jPanel3.setBounds(10, 210, 980, 490);

        jPanel4.setBackground(new java.awt.Color(255, 102, 0));
        jPanel4.setLayout(null);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Nama Buku");
        jPanel4.add(jLabel4);
        jLabel4.setBounds(10, 10, 140, 17);

        save.setText("Save");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });
        jPanel4.add(save);
        save.setBounds(640, 30, 100, 30);

        delete.setText("Delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        jPanel4.add(delete);
        delete.setBounds(750, 30, 100, 30);

        clear.setText("Clear");
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });
        jPanel4.add(clear);
        clear.setBounds(860, 30, 100, 30);

        jPanel4.add(judul);
        judul.setBounds(10, 30, 200, 30);

        getContentPane().add(jPanel4);
        jPanel4.setBounds(10, 120, 980, 80);

        setBounds(0, 0, 1016, 744);
    }// </editor-fold>//GEN-END:initComponents

    
    
    
    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        // TODO add your handling code here:
        String value = judul.getSelectedItem().toString();
        int id;
        String nama;
        int harga;
        
        String SQL = "select * from produk where nama_barang='"+value+"'";
        ResultSet rs = KoneksiDB.executeQuery(SQL);
        try {
            if (rs.next()) {
                id = rs.getInt(1);
                nama=rs.getString(2);
                harga = rs.getInt(3);
                
                
                if (rootPaneCheckingEnabled) {
                    String SQLI = "INSERT INTO chart (barang,harga) " + "VALUES('"+nama+"','"+harga+"')";
                
                int status = KoneksiDB.execute(SQLI);
                if (status == 1) {
                
                    JOptionPane.showMessageDialog(this, "Data berhasil Di tambahkan", "Sukses",JOptionPane.INFORMATION_MESSAGE);
                    selectData();
                    setTanggal();
                    setJam();
                    hargat();
                    }
                }else{
                    JOptionPane.showMessageDialog(this, "Data gagal Di tambahkan", "Gagal",JOptionPane.WARNING_MESSAGE);
                }
 
            }
        } catch (Exception e) {
            
        }
        
        
        
        
    }//GEN-LAST:event_saveActionPerformed

    private void printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printActionPerformed
 
        try {
            // TODO add your handling code here:
            
            String SQL= "Select * From chart";
            ResultSet rs = KoneksiDB.executeQuery(SQL);
            
            Document doc=new Document();
            try {
                PdfWriter.getInstance(doc,new FileOutputStream("Report.pdf"));
            } catch (DocumentException ex) {
                Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
            }
            doc.open();
            try {
                doc.add(new Paragraph("                                                         TOKO AKITO"));
                doc.add(new Paragraph("                                                    Toko Tak Berkualitas"));
                doc.add(new Paragraph("     "));
                doc.add(new Paragraph("Jam Pembelian       : "+Jaml.getText()));
                doc.add(new Paragraph("tanggal Pemebelian  : "+tanggal.getText()));
                doc.add(new Paragraph("Nama Kasir          : " + kasir.getText()));
                doc.add(new Paragraph("ID Barang"+"          "+"       Nama barang"+"                      "+"Harga Barang"));
                try {
                    while(rs.next()){
                       String id= rs.getString(1);
                       String nama = rs.getString(2);
                       String harga = rs.getString(3);
                        
                       doc.add(new Paragraph("    "+id+"                          "+nama+"                            "+"Rp."+harga));
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
                }
                doc.add(new Paragraph("                                                          Total Harga    : " + hargatt.getText()));
                doc.add(new Paragraph("                                                          Diskon            : " + diskon.getText()));
                doc.add(new Paragraph("                                                          Jumlah Bayar : " + jumlah.getText()));
                
                
                
            } catch (DocumentException ex) {
                Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
            }
            doc.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
        
    }//GEN-LAST:event_printActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        setTanggal();
        setJam();
        selectData();
        String SQL = "select * from produk";
        ResultSet rs = KoneksiDB.executeQuery(SQL);
        
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        
        try {
            while(rs.next()) {
                String is= rs.getString(2);
                model.addElement(is);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Gagal", "Gagal",JOptionPane.WARNING_MESSAGE);
        }
        judul.setModel(model);
                
    }//GEN-LAST:event_formWindowOpened

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        // TODO add your handling code here:
        int baris = tabel1.getSelectedRow();
        if (baris != 1) {
            String ID = tabel1.getValueAt(baris,0).toString();
            String SQL = "DELETE FROM chart WHERE id='"+ID+"'";
            int status = KoneksiDB.execute(SQL);
            if (status == 1) {
                
                    JOptionPane.showMessageDialog(this, "Data berhasil Di hapus", "Sukses",JOptionPane.INFORMATION_MESSAGE);
                   
                    
            }else{
                    JOptionPane.showMessageDialog(this, "Data gagal Di Hapus", "Gagal",JOptionPane.WARNING_MESSAGE);
                }
       }else{
            JOptionPane.showMessageDialog(this, "Pilih Baris Data Terlebih Dahulu", "ERROR",JOptionPane.WARNING_MESSAGE);
        }
        setTanggal();
        setJam();
        selectData();
        hargat();
    }//GEN-LAST:event_deleteActionPerformed

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        // TODO add your handling code here:
        judul.setSelectedIndex(0);
    }//GEN-LAST:event_clearActionPerformed

    private void cariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cariKeyPressed
        // TODO add your handling code here:]
        selectCari();
    }//GEN-LAST:event_cariKeyPressed

    private void cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_cariActionPerformed

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
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Jaml;
    private javax.swing.JLabel Jaml1;
    private javax.swing.JTextField cari;
    private javax.swing.JButton clear;
    private javax.swing.JButton delete;
    private javax.swing.JLabel diskon;
    private javax.swing.JTextField hargatt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JComboBox<String> judul;
    private javax.swing.JTextField jumlah;
    private javax.swing.JLabel kasir;
    private javax.swing.JLabel kasirs;
    private javax.swing.JButton print;
    private javax.swing.JButton save;
    private javax.swing.JTable tabel;
    private javax.swing.JTable tabel1;
    private javax.swing.JLabel tanggal;
    private javax.swing.JLabel tanggal1;
    // End of variables declaration//GEN-END:variables
}
