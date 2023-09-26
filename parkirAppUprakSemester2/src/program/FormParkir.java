/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package program;
import konfigurasi.Koneksi;
import konfigurasi.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;
import java.text.*;
/**
 *
 * @author rafie
 */
public class FormParkir extends javax.swing.JFrame {

    /**
     * Creates new form FormParkir
     */
    
    Connection cnn;
    Statement stm;
    ResultSet rs;
    DefaultTableModel isi;
    Object[] title= {"No Tiket","No Pol","Jenis","Tgl Masuk","Jam Masuk","Tgl Keluar","Jam Keluar"};
    
    public void buka_database(){
        try{
            Koneksi konek = new Koneksi("parkir_db");
            cnn=konek.aktifkan_koneksi();
           
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Coba Lagi, Koneksi Gagal");
        }
    }
    
    final void tampil_parkir(){
        isi = new DefaultTableModel(null,title);
        try {
            stm = cnn.createStatement();
            String perintah = "SELECT * from parkir order by no_tiket desc";
            rs = stm.executeQuery(perintah);
            while(rs.next()){
                String vnotik = rs.getString("no_tiket");
                String vnopol = rs.getString("nopol");
                String vjenis = rs.getString("jenis");
                String vtgl_msk = rs.getString("tgl_masuk");
                String vjam_msk = rs.getString("jam_masuk");
                String vtgl_klr = rs.getString("tgl_keluar");
                String vjam_klr = rs.getString("jam_keluar");
                String[] data = {vnotik,vnopol,vjenis,vtgl_msk,vjam_msk,vtgl_klr,vjam_klr};
                isi.addRow(data);
            }
        } catch(Exception e) {
            System.out.println("gagal Mengambil barang :  "+e);
            System.exit(0);
        }
        tabel_parkir.setModel(isi);
    }
    
    final void dapatkan_data(){
        isi = new DefaultTableModel(null,title);
        try {
            stm = cnn.createStatement();
            String perintah = "SELECT  tgl_keluar, jam_keluar, TIME_FORMAT(jam_keluar,'%H')-TIME_FORMAT(jam_masuk,'%H') AS durasi FROM parkir where nopol='"+tcari.getText()+"';";
            rs = stm.executeQuery(perintah);
            while(rs.next()){
                tkkeluar_tgl.setText(rs.getString("tgl_keluar"));
                tkkeluar_jam.setText(rs.getString("jam_keluar"));
                tdurasi.setText(rs.getString("durasi"));
            }
        } catch(Exception e) {
            System.out.println("gagal Mengambil dapat data :  "+e);
            System.exit(0);
        }
        tabel_parkir.setModel(isi);
    }
    
    public void cari_data() {
        isi = new DefaultTableModel(null,title);
        try {
           stm = cnn.createStatement();
           String perintah = "select * from parkir where nopol like '%"+tcari.getText()+"%'";
           rs = stm.executeQuery(perintah);
           while(rs.next()) {
                String vnotik =rs.getString("no_tiket");
                String vnopol =rs.getString("nopol");
                String vjenis =rs.getString("jenis");
                String vtgl_msk =rs.getString("tgl_masuk");
                String vjam_msk =rs.getString("jam_masuk");
                String vtgl_klr =rs.getString("tgl_keluar");
                String vjam_klr =rs.getString("jam_keluar");
                String[] data ={vnotik, vnopol, vjenis, vtgl_msk, vjam_msk, vtgl_klr, vjam_klr};
                isi.addRow(data);
           }
        } catch(Exception e) {
           System.out.println("gagal Mengambil barang :  "+e);
           System.exit(0);
       }
       tabel_parkir.setModel(isi);
    }
    
    public void akumulasi_biaya(){
        int vdurasi;
        double vbj, vbiaya;
       
        vdurasi = Integer.parseInt(tdurasi.getText());
        vbj = Double.parseDouble(tkbj.getText());
       
        if(vdurasi <= 1) {
            vbiaya = vbj;
        } else {
            vbiaya = (vbj)+((vdurasi-1)*500);
        }
        tbiaya.setText(""+vbiaya);
    }
    
    public void bersih(){
        tcari.setText("");
        tkjenis.setText("");
        tkbj.setText("");
        tkkeluar_jam.setText("");
        tkkeluar_tgl.setText("");
        tkmasuk_jam.setText("");
        tkmasuk_tgl.setText("");
        tbiaya.setText("");
        tdurasi.setText("");
       
    }
    
    public FormParkir() {
        initComponents();
        buka_database();
        tampil_parkir();
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
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        tnopol = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cbjenis = new javax.swing.JComboBox();
        bsimpan = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        tcari = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        bkeluar = new javax.swing.JButton();
        tkjenis = new javax.swing.JTextField();
        tkmasuk_tgl = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tkkeluar_tgl = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        tdurasi = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        tkbj = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        tkmasuk_jam = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        tkkeluar_jam = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        tbiaya = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_parkir = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 51, 255));

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("PARKIR KENDARAAN BERMOTOR");

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("UNIVERSITAS BINA SARANA INFORMATIKA");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(164, 164, 164)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "PARKIR MASUK", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 0, 12))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel3.setText("NO. POLISI");

        tnopol.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        tnopol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tnopolActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel4.setText("JENIS");

        cbjenis.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        cbjenis.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "PILIH", "Motor", "Mobil" }));

        bsimpan.setText("SIMPAN");
        bsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsimpanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tnopol)
                    .addComponent(cbjenis, 0, 158, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 213, Short.MAX_VALUE)
                .addComponent(bsimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(bsimpan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(tnopol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cbjenis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 2, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "PARKIR KELUAR", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 0, 12))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel5.setText("CARI NO. POL");

        tcari.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        tcari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tcariActionPerformed(evt);
            }
        });
        tcari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tcariKeyReleased(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel6.setText("JENIS");

        bkeluar.setText("KELUAR");
        bkeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bkeluarActionPerformed(evt);
            }
        });

        tkjenis.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        tkjenis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tkjenisActionPerformed(evt);
            }
        });

        tkmasuk_tgl.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        tkmasuk_tgl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tkmasuk_tglActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel7.setText("MASUK TGL");

        tkkeluar_tgl.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        tkkeluar_tgl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tkkeluar_tglActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel8.setText("KELUAR TGL");

        tdurasi.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        tdurasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tdurasiActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel9.setText("DURASI");

        jLabel10.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel10.setText("BIAYA/JAM");

        tkbj.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        tkbj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tkbjActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel11.setText("JAM MASUK");

        tkmasuk_jam.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        tkmasuk_jam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tkmasuk_jamActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel12.setText("JAM KELUAR");

        tkkeluar_jam.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        tkkeluar_jam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tkkeluar_jamActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel13.setText("BIAYA");

        tbiaya.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        tbiaya.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbiayaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(tdurasi, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tbiaya, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(tkkeluar_tgl, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tkkeluar_jam, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(tkmasuk_tgl, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tkmasuk_jam, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tcari, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(tkjenis, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tkbj, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bkeluar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(bkeluar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(tcari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(tkjenis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(tkbj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel11)
                                .addComponent(tkmasuk_jam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel7)
                                .addComponent(tkmasuk_tgl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel12)
                                .addComponent(tkkeluar_jam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel8)
                                .addComponent(tkkeluar_tgl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel13)
                                .addComponent(tbiaya, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel9)
                                .addComponent(tdurasi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 17, Short.MAX_VALUE)))
                .addContainerGap())
        );

        tabel_parkir.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "No. Tiket", "No. Pol", "Jenis", "Tgl Masuk", "Jam Masuk", "Tgl Keluar", "Jam Keluar"
            }
        ));
        tabel_parkir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_parkirMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel_parkir);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tnopolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tnopolActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tnopolActionPerformed

    private void tcariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tcariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tcariActionPerformed

    private void tkjenisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tkjenisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tkjenisActionPerformed

    private void tkmasuk_tglActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tkmasuk_tglActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tkmasuk_tglActionPerformed

    private void tkkeluar_tglActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tkkeluar_tglActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tkkeluar_tglActionPerformed

    private void tdurasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tdurasiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tdurasiActionPerformed

    private void tkbjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tkbjActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tkbjActionPerformed

    private void tkmasuk_jamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tkmasuk_jamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tkmasuk_jamActionPerformed

    private void tkkeluar_jamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tkkeluar_jamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tkkeluar_jamActionPerformed

    private void tbiayaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbiayaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbiayaActionPerformed

    private void bsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsimpanActionPerformed
        // TODO add your handling code here:
        if( !"".equals(tnopol.getText())){
            try {
                stm = cnn.createStatement();
                String perintah = "INSERT INTO parkir(nopol,jenis,tgl_masuk,jam_masuk) VALUES (upper('"+tnopol.getText()+"'),'"+cbjenis.getSelectedItem()+"',CURDATE(),CURTIME());";
                stm.executeUpdate(perintah);
                JOptionPane.showMessageDialog(null,"Data Berhasil Disimpan");
                tnopol.setText("");
            } catch(Exception e) {
                JOptionPane.showMessageDialog(null,"Data Gagal Disimpan");
                System.out.println("erornya : "+e);
            }
            tampil_parkir();
        } else {
            JOptionPane.showMessageDialog(null, "Anda Belum Input Nopol");
        }
    }//GEN-LAST:event_bsimpanActionPerformed

    private void tcariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tcariKeyReleased
        // TODO add your handling code here:
        cari_data();
    }//GEN-LAST:event_tcariKeyReleased

    private void tabel_parkirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_parkirMouseClicked
        // TODO add your handling code here:
        bersih();
        tcari.setText(tabel_parkir.getValueAt(tabel_parkir.getSelectedRow(),1).toString());
        tkjenis.setText(tabel_parkir.getValueAt(tabel_parkir.getSelectedRow(),2).toString());
        tkmasuk_tgl.setText(tabel_parkir.getValueAt(tabel_parkir.getSelectedRow(),3).toString());
        tkmasuk_jam.setText(tabel_parkir.getValueAt(tabel_parkir.getSelectedRow(),4).toString());

        try {
            stm=cnn.createStatement();
            String perintah="SELECT tarif from kendaraan where jenis='"+tkjenis.getText()+"'";
            rs=stm.executeQuery(perintah);
            
            while(rs.next()){
                tkbj.setText(rs.getString("tarif"));
            }
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null ,"Gagal  ");
            System.out.println("Erornya :  "+e);
            System.exit(0);
        }
    }//GEN-LAST:event_tabel_parkirMouseClicked

    private void bkeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bkeluarActionPerformed
        // TODO add your handling code here:
        if( !"".equals(tcari.getText())){
            try{
                stm = cnn.createStatement();
                String perintah="update parkir set tgl_keluar=curdate(), jam_keluar=curtime() where nopol='"+tcari.getText()+"'";
                stm.executeUpdate(perintah);
                JOptionPane.showMessageDialog(null,"Berhasil Update Keluar");
                tnopol.setText("");
            } catch(Exception e) {
                JOptionPane.showMessageDialog(null,"Data Gagal Diupdate");
                System.out.println("erornya : "+e);
            }
            dapatkan_data();
            akumulasi_biaya();
            tampil_parkir();
        } else {
            JOptionPane.showMessageDialog(null, "Anda Belum Input Nopol");
        }
    }//GEN-LAST:event_bkeluarActionPerformed

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
            java.util.logging.Logger.getLogger(FormParkir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormParkir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormParkir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormParkir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormParkir().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bkeluar;
    private javax.swing.JButton bsimpan;
    private javax.swing.JComboBox cbjenis;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabel_parkir;
    private javax.swing.JTextField tbiaya;
    private javax.swing.JTextField tcari;
    private javax.swing.JTextField tdurasi;
    private javax.swing.JTextField tkbj;
    private javax.swing.JTextField tkjenis;
    private javax.swing.JTextField tkkeluar_jam;
    private javax.swing.JTextField tkkeluar_tgl;
    private javax.swing.JTextField tkmasuk_jam;
    private javax.swing.JTextField tkmasuk_tgl;
    private javax.swing.JTextField tnopol;
    // End of variables declaration//GEN-END:variables
}