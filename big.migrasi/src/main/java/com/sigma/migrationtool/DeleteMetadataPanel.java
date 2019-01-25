/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigma.migrationtool;

import com.sigma.big.model.db.DBConConfiguration;
import com.sigma.big.tools.DatabaseTool;
import com.sigma.big.utils.ButtonCellClickedListener;
import com.sigma.big.utils.ButtonEditorDelete;
import com.sigma.big.utils.ButtonRenderer;
import com.sigma.migrationtool.listener.DataChangedLIstener;
import config.DataConfiguration;
import config.HibernateUtilXml;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.text.DefaultCaret;
import view.DeleteMigrasiMetadataNoView;

/**
 *
 * @author wallet
 */
public class DeleteMetadataPanel extends javax.swing.JPanel {

    /**
     * Creates new form DeleteMigrasiMetadata
     */  
    AddDBConnectionNoSave addDBConnectionDialog;
    DBConConfiguration cnf = null;
    ArrayList<FileMetadata> fileMetadatas;
    
    public DeleteMetadataPanel() {
        initComponents();
        DefaultCaret caret = (DefaultCaret) jTextAreaLog.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
        
        Color customGreen = new Color(39, 139, 80);
        jProgressBar1.setForeground(customGreen);
        jProgressBar1.setUI(new MyProgressUI());
        
//        jScrollPane1.setViewportView(jTextAreaLog);
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        buttonKoneksi = new javax.swing.JButton();
        labelKoneksi = new javax.swing.JLabel();
        buttonRefresh = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaLog = new javax.swing.JTextArea();
        jProgressBar1 = new javax.swing.JProgressBar();

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "FILE IDENTIFIER", "DELETE"
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

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Delete Metadata");

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

        jTextAreaLog.setColumns(20);
        jTextAreaLog.setRows(5);
        jScrollPane2.setViewportView(jTextAreaLog);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 738, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(buttonKoneksi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelKoneksi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2)
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonKoneksi, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelKoneksi)
                    .addComponent(buttonRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 604, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 457, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRefreshActionPerformed

        // TODO add your handling code here:
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    clearData();
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
  
    private final String sql = "SELECT * FROM MD_UPLOADFILE ORDER BY ID ASC";
    private final String sqlGetBlob = "SELECT * FROM MD_UPLOADFILE WHERE ID=";

    public void getData() throws IOException, SQLException {

        Connection con = DatabaseTool.getConnection(cnf, null);
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
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
        table.getColumn("DELETE").setCellRenderer(new ButtonRenderer("Delete"));
        table.getColumn("DELETE").setCellEditor(new ButtonEditorDelete(new JCheckBox(), "Delete", new ButtonCellClickedListener() {
                    @Override
                    public void onClick(int code, int row) {
                                       
                        Thread thread;
                        thread = new Thread() {
                            public void run() {
                                
                                try {
      
                                    jTextAreaLog.append("memulai konfigurasi..." + "\n");
                                    tableButton(false);
                                    
                                    Connection con = DatabaseTool.getConnection(cnf, null);

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

                                    DeleteMigrasiMetadataNoView dmmnv = new DeleteMigrasiMetadataNoView(jProgressBar1,jTextAreaLog, hibenateUtil);
                                    String fileIdentifier = table.getModel().getValueAt(row, 1).toString();

                                    if (JOptionPane.showConfirmDialog(null, "apakah anda yakin akan menghapus metadata dengan fileidentifier "+fileIdentifier+" ?", "WARNING",
                                            JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                                        
                                        jTextAreaLog.append("status : menghapus metadata" + "\n");
                                        dmmnv.deleteAll(fileIdentifier);                                         

                                    } else {
                                        jTextAreaLog.append("status : batal menghapus metadata" + "\n");
                                        return;
                                    }

                                } catch (IOException ex) {
                                    Logger.getLogger(DeleteMetadataPanel.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                        };
                        
                        thread.start();
                        
                    }
                }, 1));
        
//            table.getColumn("DELETE").setCellRenderer(new ButtonRenderer("Delete").setEnabled(true));

        for (FileMetadata fileMetadata : fileMetadatas) {
            table.getModel().setValueAt(fileMetadata.getId(), i, 0);
            table.getModel().setValueAt(fileMetadata.getFileIdentifier(), i, 1);
           // table.getModel().setValueAt(new JButton().setEnabled(false));
            i++;
        }
        
        
    }
    
    public void clearData(){
        jTextAreaLog.setText("");
        jProgressBar1.setMinimum(0);
        jProgressBar1.setValue(0);
    }
    
    public void tableButton(boolean enable){
        
        TableColumn col= table.getColumnModel().getColumn(2);
        ButtonRenderer br = (ButtonRenderer)col.getCellRenderer();
        ButtonEditorDelete editor = (ButtonEditorDelete)col.getCellEditor();
        editor.setEnabled(enable);
        br.setEnabled(enable);                                        
        table.repaint();
        
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
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonKoneksi;
    private javax.swing.JButton buttonRefresh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextAreaLog;
    private javax.swing.JLabel labelKoneksi;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}