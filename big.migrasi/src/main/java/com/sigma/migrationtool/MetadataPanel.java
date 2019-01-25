/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigma.migrationtool;

import com.sigma.big.model.db.DBConConfiguration;
import com.sigma.big.tools.DatabaseTool;
import com.sigma.migrationtool.listener.DataChangedLIstener;
import config.DataConfiguration;
import config.HibernateUtilXml;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import javax.swing.text.DefaultCaret;
import org.xml.sax.SAXException;
import view.KoneksiView;
import view.MigrasiMetadata;
import view.MigrasiMetadataNoView;

/**
 *
 * @author Ridho
 */
public class MetadataPanel extends javax.swing.JPanel {

    /**
     * Creates new form MetadataPanel
     */
    public MetadataPanel() {
        initComponents();
        DefaultCaret caret = (DefaultCaret) jTextAreaLog.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
        jtextFieldPath.setText("");
        jScrollPane1.setViewportView(jTextAreaLog);

        Color customGreen = new Color(39, 139, 80);
        jProgressBar1.setForeground(customGreen);
        jProgressBar1.setUI(new MyProgressUI());

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton3 = new javax.swing.JButton();
        jtextFieldPath = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaLog = new javax.swing.JTextArea();
        jProgressBar1 = new javax.swing.JProgressBar();
        jButton1 = new javax.swing.JButton();
        labelUrlKoneksi = new javax.swing.JLabel();

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon_play.png"))); // NOI18N
        jButton3.setText("Proses");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon_folder.png"))); // NOI18N
        jButton4.setText("Browse");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel1.setText("Ambil File Metadata");

        jTextAreaLog.setColumns(20);
        jTextAreaLog.setRows(5);
        jScrollPane1.setViewportView(jTextAreaLog);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon_dbcon.png"))); // NOI18N
        jButton1.setText("Koneksi Database");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        labelUrlKoneksi.setText("Koneksi");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelUrlKoneksi)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jtextFieldPath, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton4)))
                        .addGap(3, 3, 3))
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelUrlKoneksi))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtextFieldPath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        chooseFile();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String path = jtextFieldPath.getText();
        jTextAreaLog.setText("");
        if (path.equals("")) {
            showDialog("Path/file metadata tidak ditemukan");
        } else if (cnf == null) {
            showDialog("Koneksi ke database belum dibuat");
        } else {
            jTextAreaLog.setText("memulai konfigurasi ...\n");
            Thread t = new Thread(() -> {
                if (cnf != null) {
                    try {
                        //Convert to Hibernate Configuration
                        DataConfiguration data = new DataConfiguration();
                        if (cnf.getSid().equals("")) {
                            data.setDatabaseName(cnf.getServiceName());
                        }
                        if (cnf.getServiceName().equals("")) {
                            data.setDatabaseName(cnf.getSid());
                        }
                        data.setIp(cnf.getHost());
                        data.setPort(String.valueOf(cnf.getPort()));
                        data.setPassword(cnf.getPassword());
                        data.setUsername(cnf.getUsername());

                        HibernateUtilXml hibenateUtil = new HibernateUtilXml(data);
//                        MigrasiMetadata migrasiMeatadata = new MigrasiMetadata(hibenateUtil);
//                        migrasiMeatadata.show();
                        MigrasiMetadataNoView migrasiMetadataNoView = new MigrasiMetadataNoView(jProgressBar1, path, jTextAreaLog, hibenateUtil);
                        migrasiMetadataNoView.SetFile();
                        migrasiMetadataNoView.simpan();
//                        KoneksiView koneksiView = new KoneksiView();
//                        koneksiView.show();
                    } catch (SAXException | IOException ex) {
                        Logger.getLogger(MetadataPanel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    showDialog("Koneksi ke database belum dibuat");
                }
            });

            t.start();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    AddDBConnectionNoSave addDBConnectionDialog;
    DBConConfiguration cnf = null;

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
//        cnf = new DBConConfiguration();
//        cnf.setHost("192.168.210.195");
//        cnf.setUsername("METADATA");
//        cnf.setPassword("METADATA");
//        cnf.setSid("dbprod");

        if (addDBConnectionDialog == null) {
            AddDBConnection_ addDBConnection = new AddDBConnection_();
            addDBConnectionDialog = new AddDBConnectionNoSave(addDBConnection, true, listener_, cnf, 1);
            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            addDBConnectionDialog.setLocation(dim.width / 2 - addDBConnectionDialog.getSize().width / 2, dim.height / 2 - addDBConnectionDialog.getSize().height / 2);
        }
        addDBConnectionDialog.reloadWithCode(
                cnf, 1);
        addDBConnectionDialog.setVisible(
                true);
    }//GEN-LAST:event_jButton1ActionPerformed

    DataChangedLIstener listener_ = new DataChangedLIstener() {
        @Override
        public void onChanged() {
        }

        @Override
        public void doOnChanged(Object o) {
        }

        @Override
        public void doOnChanged(Object o, int code) {
            cnf = (DBConConfiguration) o;
            String url = DatabaseTool.generateUrl(cnf);
            System.out.println("URL : " + url);
            labelUrlKoneksi.setText(url);
        }
    };

    public void showDialog(final String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    private void chooseFile() {
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        FileNameExtensionFilter filter = new FileNameExtensionFilter("xml", "xml", "XML");
        jfc.setFileFilter(filter);
        int returnValue = jfc.showOpenDialog(null);
        // int returnValue = jfc.showSaveDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = jfc.getSelectedFile();
            System.out.println(selectedFile.getName());
            if (!(selectedFile.getName().split("\\.")[1].equals("xml"))) {
                showDialog("Hanya mendukung file .xml");
            } else {
                String defaultMappingPath = selectedFile.getAbsolutePath();
                jtextFieldPath.setText(defaultMappingPath);
                System.out.println(selectedFile.getAbsolutePath());
            }

        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreaLog;
    private javax.swing.JTextField jtextFieldPath;
    private javax.swing.JLabel labelUrlKoneksi;
    // End of variables declaration//GEN-END:variables
}