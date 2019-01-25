/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigma.migrationtool;

import com.sigma.migrationtool.listener.DataChangedLIstener;
import com.sigma.big.controller.DBConConfigurationController;
import com.sigma.big.model.db.DBConConfiguration;
import com.sigma.bigmigrasi.db.DBUtil;
import java.awt.Color;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Ridho
 */
public class AddDBConnection extends javax.swing.JDialog {

    /**
     * Creates new form AddDBConnection
     */
    DataChangedLIstener listener;

    boolean isSID = true;
    DBConConfiguration dbcc;

    public AddDBConnection(java.awt.Frame parent, boolean modal, DataChangedLIstener listener, DBConConfiguration dbcc) {
        super(parent, modal);
        initComponents();
        switchSidService(isSID);
        this.listener = listener;
        reload(dbcc);
    }

    public void reload(DBConConfiguration dbcc) {
        this.dbcc = dbcc;
        if (dbcc != null) {
            jtfHost.setText(dbcc.getHost());
            jtfName.setText(dbcc.getName());
            jtfPassword.setText(dbcc.getPassword());
            jtfPort.setText(String.valueOf(dbcc.getPort()));
            isSID = (dbcc.getSid() != null);
            switchSidService(isSID);
            jtfServiceName.setText(dbcc.getServiceName() != null ? dbcc.getServiceName() : "");
            jtfSid.setText(dbcc.getSid() != null ? dbcc.getSid() : "");
            jtfUsername.setText(dbcc.getUsername());
        } else {
            jtfHost.setText("");
            jtfName.setText("");
            jtfPassword.setText("");
            jtfPort.setText("1521");
            isSID = true;
            switchSidService(isSID);
            jtfServiceName.setText("");
            jtfSid.setText("");
            jtfUsername.setText("");
        }
    }

    public void switchSidService(boolean isSid) {
        jRadioButton1.setSelected(isSid);
        jtfServiceName.setEditable(!isSid);
        jRadioButton2.setSelected(!isSid);
        jtfSid.setEditable(isSid);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtfPassword = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jtfHost = new javax.swing.JTextField();
        jtfName = new javax.swing.JTextField();
        jtfPort = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jtfSid = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jtfServiceName = new javax.swing.JTextField();
        jtfUsername = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        info = new javax.swing.JLabel();
        buttonTest = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Nama Koneksi");

        jtfPort.setText("1521");
        jtfPort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfPortActionPerformed(evt);
            }
        });

        jLabel2.setText("Host");

        jLabel3.setText("Port");

        jButton1.setText("Batal");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel6.setText("Username");

        jButton2.setText("Simpan");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel7.setText("Password");

        jRadioButton1.setText("SID");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        jRadioButton2.setText("Service Name");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        info.setBackground(new java.awt.Color(255, 255, 255));
        info.setForeground(new java.awt.Color(255, 0, 0));
        info.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(info, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(info, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(17, 17, 17))
        );

        buttonTest.setText("Test");
        buttonTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTestActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(31, 31, 31)
                        .addComponent(jtfName))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButton2)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jRadioButton1)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfServiceName)
                            .addComponent(jtfUsername)
                            .addComponent(jtfHost)
                            .addComponent(jtfPort)
                            .addComponent(jtfSid)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(51, 51, 51)
                        .addComponent(jtfPassword))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(buttonTest)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 320, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtfName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtfHost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtfPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfSid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton2)
                    .addComponent(jtfServiceName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(buttonTest))
                .addGap(11, 11, 11)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        info.setText("");
        try {
            DBConConfigurationController dBConConfigurationController = new DBConConfigurationController(new DBUtil());
            DBConConfiguration dBConConfiguration = new DBConConfiguration();
            dBConConfiguration.setName(jtfName.getText());
            dBConConfiguration.setHost(jtfHost.getText());
            dBConConfiguration.setPort(Integer.parseInt(jtfPort.getText()));

            if (isSID) {
                dBConConfiguration.setSid(jtfSid.getText());
                dBConConfiguration.setServiceName("");
            } else {
                dBConConfiguration.setSid("");
                dBConConfiguration.setServiceName(jtfServiceName.getText());
            }
            dBConConfiguration.setUsername(jtfUsername.getText());
            dBConConfiguration.setPassword(jtfPassword.getText());
            //        dbConf.set

            try {
                if (dbcc != null) {
                    dBConConfiguration.setId(dbcc.getId());
                    dBConConfigurationController.update(dBConConfiguration);
                } else {
                    dBConConfigurationController.save(dBConConfiguration);
                }
                this.setVisible(false);
            } catch (SQLException ex) {
//            Logger.getLogger(AddDBConnection_.class.getName()).log(Level.SEVERE, null, ex);
                info.setText("Gagal menyimpan : " + ex.getMessage());
            }
        } catch (Exception e) {
            info.setText("Gagal menyimpan : " + e.getMessage());
        }

        listener.onChanged();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jtfPortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfPortActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfPortActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
        isSID = true;
        switchSidService(isSID);
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
        isSID = false;
        switchSidService(isSID);
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void buttonTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTestActionPerformed
        DBUtil util = new DBUtil();
        String driverName = "oracle.jdbc.OracleDriver";
        String url = "";
        if (jRadioButton1.isSelected()) {
            url = "jdbc:oracle:thin:@"
                    + jtfHost.getText()
                    + ":" + jtfPort.getText()
                    + ":" + jtfSid.getText();
        }
        if (jRadioButton2.isSelected()) {
            url = "jdbc:oracle:thin:@//"
                    + jtfHost.getText()
                    + ":"
                    + jtfPort.getText()
                    + "/"
                    + jtfServiceName.getText();
        }

        System.out.println("DB URL : " + url);
        String username = jtfUsername.getText();
        String password = jtfPassword.getText();
        Connection con = util.getConnection(driverName, url, username, password);

        if (con != null) {
            info.setForeground(Color.black);
            info.setText("Success");
        } else {
            info.setForeground(Color.red);
            info.setText("Failed");
        }

    }//GEN-LAST:event_buttonTestActionPerformed

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
            java.util.logging.Logger.getLogger(AddDBConnection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddDBConnection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddDBConnection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddDBConnection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

//        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                
//                AddDBConnection dialog = new AddDBConnection(new javax.swing.JFrame(), true, listener);
//                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//                    @Override
//                    public void windowClosing(java.awt.event.WindowEvent e) {
//                        System.exit(0);
//                    }
//                });
//                dialog.setVisible(true);
//            }
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonTest;
    private javax.swing.JLabel info;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JTextField jtfHost;
    private javax.swing.JTextField jtfName;
    private javax.swing.JPasswordField jtfPassword;
    private javax.swing.JTextField jtfPort;
    private javax.swing.JTextField jtfServiceName;
    private javax.swing.JTextField jtfSid;
    private javax.swing.JTextField jtfUsername;
    // End of variables declaration//GEN-END:variables
}
