/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigma.migrationtool;

import com.sigma.big.controller.DBConConfigurationController;
import com.sigma.big.model.db.DBConConfiguration;
import com.sigma.big.tools.DatabaseTool;
import com.sigma.big.tools.Unsur;
import com.sigma.big.utils.ButtonCellClickedListener;
import com.sigma.big.utils.ButtonEditor;
import com.sigma.big.utils.ButtonRenderer;
import com.sigma.bigmigrasi.db.ConnectionConfiguration;
import com.sigma.bigmigrasi.db.DBUtil;
import com.sigma.migrationtool.bkp.KelolaKoneksiDatabase;
import com.sigma.migrationtool.listener.DataChangedLIstener;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ridho
 */
public class DownloadMetadataPanel extends javax.swing.JPanel {

    AddDBConnectionNoSave addDBConnectionDialog;
    DBConConfiguration cnf = null;
    ArrayList<FileMetadata> fileMetadatas;

    /**
     * Creates new form DownloadMetadataPanel
     */
    public DownloadMetadataPanel() {
        initComponents();
        if (cnf == null) {
            buttonRefresh.setEnabled(false);
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
        table = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        buttonKoneksi = new javax.swing.JButton();
        labelKoneksi = new javax.swing.JLabel();
        buttonRefresh = new javax.swing.JButton();

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "FILE IDENTIFIER", "DOWNLOAD"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setMinWidth(50);
            table.getColumnModel().getColumn(0).setPreferredWidth(30);
            table.getColumnModel().getColumn(0).setMaxWidth(100);
            table.getColumnModel().getColumn(2).setMinWidth(200);
            table.getColumnModel().getColumn(2).setPreferredWidth(200);
            table.getColumnModel().getColumn(2).setMaxWidth(250);
        }

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Download Metadata");

        buttonKoneksi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon_dbcon_25x.png"))); // NOI18N
        buttonKoneksi.setText("Koneksi Database");
        buttonKoneksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonKoneksiActionPerformed(evt);
            }
        });

        labelKoneksi.setText("Koneksi");

        buttonRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon_refresh_setting.png"))); // NOI18N
        buttonRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 592, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(buttonKoneksi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelKoneksi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonKoneksi, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelKoneksi)
                    .addComponent(buttonRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonKoneksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonKoneksiActionPerformed
        // TODO add your handling code here:
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
    }//GEN-LAST:event_buttonKoneksiActionPerformed

    private void buttonRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRefreshActionPerformed

        // TODO add your handling code here:
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    getData();
                } catch (IOException ex) {
                    Logger.getLogger(DownloadMetadataPanel.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(DownloadMetadataPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        t.start();

    }//GEN-LAST:event_buttonRefreshActionPerformed

    private final String sql = "SELECT * FROM MD_UPLOADFILE ORDER BY ID ASC";
    private final String sqlGetBlob = "SELECT * FROM MD_UPLOADFILE WHERE ID=";

    public void getData() throws IOException, SQLException {

        Connection con = DatabaseTool.getConnection(cnf, null);
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        System.out.println(rs);
        fileMetadatas = new ArrayList<>();
        while (rs.next()) {
            System.out.println(rs.getString("FILEIDENTIFIER"));
            FileMetadata fileMetadata = new FileMetadata();
            fileMetadata.setId(rs.getInt("ID"));
            fileMetadata.setFileIdentifier(rs.getString("FILEIDENTIFIER"));
            fileMetadata.setFile(rs.getBlob("FILENAME"));
            fileMetadatas.add(fileMetadata);
        }
        stmt.close();
        con.close();
        updateTable(fileMetadatas);

    }

    private void updateTable(ArrayList<FileMetadata> fileMetadatas) {
        int i = 0;
        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        dtm.setRowCount(fileMetadatas.size());
        table.setModel(dtm);
        table.getColumn("DOWNLOAD").setCellRenderer(new ButtonRenderer("Download"));
        table.getColumn("DOWNLOAD").setCellEditor(
                new ButtonEditor(new JCheckBox(), "Download", new ButtonCellClickedListener() {
                    @Override
                    public void onClick(int code, int row) {
                        InputStream in = null;
                        try {
                            Connection con = DatabaseTool.getConnection(cnf, null);
                            Statement stmt = con.createStatement();
                            ResultSet rs = stmt.executeQuery(sqlGetBlob + fileMetadatas.get(row).getId());
                            while (rs.next()) {
                                Blob blob = rs.getBlob("FILENAME");
                                in = blob.getBinaryStream();
                                String path = "C:\\migrasi\\metadata-xml\\" + fileMetadatas.get(row).getFileIdentifier() + ".xml";
                                OutputStream out = new FileOutputStream(new File(path));
                                byte[] buff = new byte[4096];  // how much of the blob to read/write at a time
                                int len = 0;
                                while ((len = in.read(buff)) != -1) {
                                    out.write(buff, 0, len);
                                }

                                int reply = JOptionPane.showConfirmDialog(null, "Selesai, buka lokasi file?", "Perhatian", JOptionPane.YES_NO_OPTION);
                                if (reply == JOptionPane.YES_OPTION) {
                                    Runtime.getRuntime().exec("explorer.exe /select," + path);
                                } else {

                                }
                                
                                in.close();
                                out.close();
                            }
                                
                            rs.close();
                            stmt.close();
                            con.close();

                        } catch (SQLException ex) {
                            Logger.getLogger(DownloadMetadataPanel.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (FileNotFoundException ex) {
                            Logger.getLogger(DownloadMetadataPanel.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (IOException ex) {
                            Logger.getLogger(DownloadMetadataPanel.class.getName()).log(Level.SEVERE, null, ex);
                        } finally {
                            try {
                                in.close();
                            } catch (IOException ex) {
                                Logger.getLogger(DownloadMetadataPanel.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                }, 1));

        for (FileMetadata fileMetadata : fileMetadatas) {
            table.getModel().setValueAt(fileMetadata.getId(), i, 0);
            table.getModel().setValueAt(fileMetadata.getFileIdentifier(), i, 1);
//            table.getModel().setValueAt(new JButton(), i, 2);
            i++;
        }
    }

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
            labelKoneksi.setText(url);

            buttonRefresh.setEnabled(true);

            // TODO add your handling code here:
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        getData();
                    } catch (IOException ex) {
                        Logger.getLogger(DownloadMetadataPanel.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(DownloadMetadataPanel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });

            t.start();
        }
    };

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonKoneksi;
    private javax.swing.JButton buttonRefresh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelKoneksi;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables

    class FileMetadata {

        int id;
        String fileIdentifier;
        Blob file;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getFileIdentifier() {
            return fileIdentifier;
        }

        public void setFileIdentifier(String fileIdentifier) {
            this.fileIdentifier = fileIdentifier;
        }

        public Blob getFile() {
            return file;
        }

        public void setFile(Blob file) {
            this.file = file;
        }

    }
}