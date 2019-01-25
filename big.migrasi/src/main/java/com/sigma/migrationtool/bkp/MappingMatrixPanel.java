/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigma.migrationtool.bkp;

import com.sigma.big.controller.DBConConfigurationController;
import com.sigma.big.controller.DatabaseController;
import com.sigma.big.controller.MappingColumnController;
import com.sigma.big.controller.MappingMatrixController;
import com.sigma.big.model.db.DBConConfiguration;
import com.sigma.big.model.db.MappingColumn;
import com.sigma.big.model.db.MappingMatrix;
import com.sigma.big.utils.Activity;
import com.sigma.big.utils.ButtonCellClickedListener;
import com.sigma.big.utils.ButtonEditor;
import com.sigma.big.utils.ButtonRenderer;
import com.sigma.bigmigrasi.db.DBUtil;
import com.sigma.bigmigrasi.db.FieldOfTable;
import com.sigma.migrationtool.listener.DataChangedLIstener;
import com.sigma.migrationtool.MainFrame;
//import com.sun.xml.internal.ws.handler.HandlerException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ridho
 */
public class MappingMatrixPanel extends javax.swing.JPanel implements DataChangedLIstener, Activity {

    private ArrayList<DBConConfiguration> dbConConfs;
    DBConConfigurationController dBConConfigurationController;

    private JButton mappingHomeButton;

    /**
     * Creates new form MappingMatrixPanel
     *
     */
    public MappingMatrixPanel(JButton mappingHomeButton) {
        initComponents();
        this.mappingHomeButton = mappingHomeButton;
    }

    public void loadConnections() {
        try {
            dBConConfigurationController = new DBConConfigurationController(new DBUtil());
            this.dbConConfs = dBConConfigurationController.getConnectionConfigurations();
        } catch (SQLException ex) {
            Logger.getLogger(KelolaKoneksiDatabase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void showConnectionListToCombo() {
        if (dbConConfs != null) {
            dbConConfs.stream().map((dbConConf) -> {
                comboBoxDBSumber.addItem(dbConConf.getName());
                return dbConConf;
            }).forEachOrdered((dbConConf) -> {
                comboBoxDBTarget.addItem(dbConConf.getName());
            });
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
        comboBoxTableSumber = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        buttonAmbilKolomSumber = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        comboBoxKolomSumber = new javax.swing.JComboBox<>();
        comboBoxDBSumber = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        comboBoxTableTarget = new javax.swing.JComboBox<>();
        buttonAmbilKolomTarget = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        comboBoxKolomTarget = new javax.swing.JComboBox<>();
        comboBoxDBTarget = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableMapping = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        info = new javax.swing.JLabel();
        jtfMappingName = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Sumber"));

        jLabel1.setText("Tabel");

        buttonAmbilKolomSumber.setText("Ambil kolom");
        buttonAmbilKolomSumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAmbilKolomSumberActionPerformed(evt);
            }
        });

        jLabel3.setText("Kolom sumber");

        comboBoxDBSumber.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboBoxDBSumberItemStateChanged(evt);
            }
        });
        comboBoxDBSumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxDBSumberActionPerformed(evt);
            }
        });

        jLabel6.setText("Koneksi DB");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(comboBoxKolomSumber, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboBoxDBSumber, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboBoxTableSumber, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(buttonAmbilKolomSumber)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBoxDBSumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBoxTableSumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonAmbilKolomSumber, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(comboBoxKolomSumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Target"));

        jLabel2.setText("Tabel");

        buttonAmbilKolomTarget.setText("Ambil kolom");
        buttonAmbilKolomTarget.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAmbilKolomTargetActionPerformed(evt);
            }
        });

        jLabel4.setText("Kolom target");

        comboBoxDBTarget.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxDBTargetActionPerformed(evt);
            }
        });

        jLabel5.setText("Koneksi DB");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE))
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboBoxDBTarget, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboBoxKolomTarget, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboBoxTableTarget, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(buttonAmbilKolomTarget)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBoxDBTarget, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(comboBoxTableTarget, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonAmbilKolomTarget)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBoxKolomTarget, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton3.setText("Mapping");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Hasil mapping"));

        jTableMapping.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kolom sumber", "Kol. Sumber Type", "Kolom target", "Kol. Target Type", "Control"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableMapping);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
        );

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton4.setText("Simpan");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        info.setForeground(new java.awt.Color(255, 0, 51));

        jLabel7.setText("Nama Mapping");

        jLabel8.setText("Where clause");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setToolTipText("Example : WHERE COLUMN_NAME = VALUE");
        jScrollPane2.setViewportView(jTextArea1);

        jButton1.setText("Batal");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(231, 231, 231)
                        .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(194, 194, 194))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(info)
                                    .addComponent(jLabel8))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jtfMappingName)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(51, 51, 51)
                        .addComponent(info))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtfMappingName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7)
                        .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)))
                .addGap(8, 8, 8))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void comboBoxDBSumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxDBSumberActionPerformed
        getDataTableToCombo(comboBoxTableSumber, comboBoxDBSumber);
    }//GEN-LAST:event_comboBoxDBSumberActionPerformed

    private void comboBoxDBTargetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxDBTargetActionPerformed
        System.out.println("COMBO CONNECTION TARGET SELECTED");
        getDataTableToCombo(comboBoxTableTarget, comboBoxDBTarget);

    }//GEN-LAST:event_comboBoxDBTargetActionPerformed

    private void getDataTableToCombo(JComboBox comboTable, JComboBox comboDB) {

        Thread t;
        t = new Thread(new Runnable() {
            @Override
            public void run() {
                comboTable.removeAllItems();
                if (comboDB.getSelectedIndex() != 0) {
                    System.out.println("COMBO CONNECTION SUMBER SELECTED " + comboDB.getSelectedIndex());
                    DBUtil dbu = new DBUtil();
                    DBConConfiguration dBConConfiguration = dbConConfs.get(comboDB.getSelectedIndex() - 1);
                    String driver = "oracle.jdbc.OracleDriver";
                    String url = null;
                    if (dBConConfiguration != null) {
                        if (dBConConfiguration.getSid() != null) {
                            if (!dBConConfiguration.getSid().equals("")) {
                                url = "jdbc:oracle:thin:@"
                                        + dBConConfiguration.getHost()
                                        + ":" + dBConConfiguration.getPort()
                                        + ":" + dBConConfiguration.getSid();
                            }
                        }
                        if (dBConConfiguration.getServiceName() != null) {
                            if (!dBConConfiguration.getServiceName().equals("")) {
                                url = "jdbc:oracle:thin:@//"
                                        + dBConConfiguration.getHost()
                                        + ":"
                                        + dBConConfiguration.getPort()
                                        + "/"
                                        + dBConConfiguration.getServiceName();
                            }
                        }

                    }

                    System.out.println("DB URL : " + url);
                    String username = dBConConfiguration.getUsername();
                    String password = dBConConfiguration.getPassword();
                    Connection conn = dbu.getConnection(driver, url, username, password);

                    DatabaseController dbController = new DatabaseController();
                    try {
                        ArrayList<String> tables = dbController.getTables(conn);
                        tables.forEach((table) -> {
                            comboTable.addItem(table);
                        });

                    } catch (SQLException ex) {
                    }
                }
            }
        });

        t.start();
    }


    private void comboBoxDBSumberItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboBoxDBSumberItemStateChanged
        // TODO add your handling code here:
        // TODO add your handling code here:


    }//GEN-LAST:event_comboBoxDBSumberItemStateChanged

    ArrayList<FieldOfTable> fieldsSumber;
    private void buttonAmbilKolomSumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAmbilKolomSumberActionPerformed
        fieldsSumber = getDataKolomToCombo(comboBoxKolomSumber, comboBoxDBSumber, comboBoxTableSumber);
    }//GEN-LAST:event_buttonAmbilKolomSumberActionPerformed

    ArrayList<FieldOfTable> fieldsTarget;
    private void buttonAmbilKolomTargetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAmbilKolomTargetActionPerformed
        fieldsTarget = getDataKolomToCombo(comboBoxKolomTarget, comboBoxDBTarget, comboBoxTableTarget);
    }//GEN-LAST:event_buttonAmbilKolomTargetActionPerformed

    ArrayList<Matrix> matriks = new ArrayList<>();

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        if (fieldsSumber != null && fieldsTarget != null) {

            int indexSumber = comboBoxKolomSumber.getSelectedIndex();
            String namaKolomSumber = fieldsSumber.get(indexSumber).getName();
            String tipeKolomSumber = fieldsSumber.get(indexSumber).getDataType();

            int indexTarget = comboBoxKolomTarget.getSelectedIndex();
            String namaKolomTarget = fieldsTarget.get(indexTarget).getName();
            String tipeKolomTarget = fieldsTarget.get(indexTarget).getDataType();
            Matrix matrix = new Matrix();
            matrix.setNamaKolomSumber(namaKolomSumber);
            matrix.setTipeKolomSumber(tipeKolomSumber);
            matrix.setNamaKolomTarget(namaKolomTarget);
            matrix.setTipeKolomTarget(tipeKolomTarget);

            matriks.add(matrix);
            updateTable();
        } else {
            JOptionPane.showMessageDialog(null, "Kolom Tumber dan Kolom Target harus ada");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void updateTable() {
        DefaultTableModel dtm = (DefaultTableModel) jTableMapping.getModel();
        dtm.setRowCount(matriks.size());
        jTableMapping.setModel(dtm);
        jTableMapping.getColumn("Control").setCellRenderer(new ButtonRenderer("Hapus"));
        jTableMapping.getColumn("Control").setCellEditor(
                new ButtonEditor(new JCheckBox(), "Hapus", new ButtonCellClickedListener() {
                    @Override
                    public void onClick(int code, int row) {
                        matriks.remove(row);
                        updateTable();
                    }
                }, 1));
        int i = 0;
        for (Matrix matrix : matriks) {
            jTableMapping.getModel().setValueAt(matrix.getNamaKolomSumber(), i, 0);
            jTableMapping.getModel().setValueAt(matrix.getTipeKolomSumber(), i, 1);
            jTableMapping.getModel().setValueAt(matrix.getNamaKolomTarget(), i, 2);
            jTableMapping.getModel().setValueAt(matrix.getTipeKolomTarget(), i, 3);
            i++;
        }

    }

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
            // TODO add your handling code here:
            DBUtil dbu = new DBUtil();
            MappingMatrixController matrixController = new MappingMatrixController(dbu);
            MappingColumnController colomController = new MappingColumnController(dbu);

            MappingMatrix mappingMatrix = new MappingMatrix();
            mappingMatrix.setName(jtfMappingName.getText());
            mappingMatrix.setTableSource(comboBoxTableSumber.getSelectedItem().toString());
            mappingMatrix.setTableTarget(comboBoxTableTarget.getSelectedItem().toString());
            mappingMatrix.setConnSumber(dbConConfs.get(comboBoxDBSumber.getSelectedIndex() - 1));
            mappingMatrix.setConnTarget(dbConConfs.get(comboBoxDBTarget.getSelectedIndex() - 1));
            mappingMatrix.setWhereClause(jTextArea1.getText());

//        Date d = new Date();
//        String now = d.toString();
//        mappingMatrix.setCreatedDate(java.sql.Date.valueOf(now));
            mappingMatrix.setCreatedBy("administrator");

            if (matrixController.save(mappingMatrix).equals("OK")) {
                try {
                    MappingMatrix mm = matrixController.getLastInserted();
                    int colomMatrixNumber = jTableMapping.getRowCount();

                    ArrayList<MappingColumn> mappingColumns = new ArrayList<>();
                    for (int i = 0; i < colomMatrixNumber; i++) {
                        MappingColumn mappingColumn = new MappingColumn();
                        mappingColumn.setColSourceName(jTableMapping.getModel().getValueAt(i, 0).toString());
                        mappingColumn.setColSourceType(jTableMapping.getModel().getValueAt(i, 1).toString());
                        mappingColumn.setColTargetName(jTableMapping.getModel().getValueAt(i, 2).toString());
                        mappingColumn.setColTargetType(jTableMapping.getModel().getValueAt(i, 3).toString());
                        mappingColumn.setMappingMatrix(mm);
                        mappingColumns.add(mappingColumn);
                    }

                    colomController.saveMultipleMappingColumn(mappingColumns);
                    try {
                        JOptionPane.showMessageDialog(null, "Data berhasil disimpan");
                        mappingHomeButton.doClick();
                    } catch (Exception e) {
                        mappingHomeButton.doClick();
                    }
                    //                    int result = JOptionPane.showConfirmDialog(null, "Data berhasil disimpan", "Info", JOptionPane.YES_OPTION);

//                    if (result == JOptionPane.YES_OPTION) {
//                    }
                } catch (SQLException ex) {
                    Logger.getLogger(MappingMatrixPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Mapping gagal disimpan");
            }
        } catch (IOException ex) {
            Logger.getLogger(MappingMatrixPanel.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        mappingHomeButton.doClick();
    }//GEN-LAST:event_jButton1ActionPerformed

    private ArrayList<FieldOfTable> getDataKolomToCombo(JComboBox comboBoxKolom, JComboBox comboBoxDB, JComboBox comboBoxTable) {
        ArrayList<FieldOfTable> fields = null;

        comboBoxKolom.removeAllItems();
        if (comboBoxDB.getSelectedIndex() != 0) {
            DBUtil dbu = new DBUtil();
            DBConConfiguration dBConConfiguration = dbConConfs.get(comboBoxDB.getSelectedIndex() - 1);
            String driver = "oracle.jdbc.OracleDriver";
            String url = null;
            if (dBConConfiguration != null) {
                if (dBConConfiguration.getSid() != null) {
                    if (!dBConConfiguration.getSid().equals("")) {
                        url = "jdbc:oracle:thin:@"
                                + dBConConfiguration.getHost()
                                + ":" + dBConConfiguration.getPort()
                                + ":" + dBConConfiguration.getSid();
                    }
                }
                if (dBConConfiguration.getServiceName() != null) {
                    if (!dBConConfiguration.getServiceName().equals("")) {
                        url = "jdbc:oracle:thin:@//"
                                + dBConConfiguration.getHost()
                                + ":"
                                + dBConConfiguration.getPort()
                                + "/"
                                + dBConConfiguration.getServiceName();
                    }
                }

            }

            System.out.println("DB URL : " + url);
            String username = dBConConfiguration.getUsername();
            String password = dBConConfiguration.getPassword();
            Connection conn = dbu.getConnection(driver, url, username, password);

            DatabaseController dbController = new DatabaseController();
            try {
                fields = dbController.getFields(conn, comboBoxTable.getSelectedItem().toString());
                for (FieldOfTable field : fields) {
                    comboBoxKolom.addItem(field.getName() + " (" + field.getDataType() + ")");
                }
            } catch (SQLException ex) {

            }
        }

        return fields;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAmbilKolomSumber;
    private javax.swing.JButton buttonAmbilKolomTarget;
    private javax.swing.JComboBox<String> comboBoxDBSumber;
    private javax.swing.JComboBox<String> comboBoxDBTarget;
    private javax.swing.JComboBox<String> comboBoxKolomSumber;
    private javax.swing.JComboBox<String> comboBoxKolomTarget;
    private javax.swing.JComboBox<String> comboBoxTableSumber;
    private javax.swing.JComboBox<String> comboBoxTableTarget;
    private javax.swing.JLabel info;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableMapping;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jtfMappingName;
    // End of variables declaration//GEN-END:variables

    @Override
    public void onChanged() {

    }

    @Override
    public void doOnChanged(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void onStart() {
        comboBoxDBSumber.removeAllItems();
        comboBoxDBTarget.removeAllItems();
        comboBoxDBSumber.addItem("");
        comboBoxDBTarget.addItem("");
        comboBoxKolomSumber.removeAllItems();
        comboBoxKolomTarget.removeAllItems();
        loadConnections();
        showConnectionListToCombo();
    }

    @Override
    public void onPause() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void onResume() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void doOnChanged(Object o, int code) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    class Matrix {

        String namaKolomSumber;

        public String getNamaKolomSumber() {
            return namaKolomSumber;
        }

        public void setNamaKolomSumber(String namaKolomSumber) {
            this.namaKolomSumber = namaKolomSumber;
        }

        public String getTipeKolomSumber() {
            return tipeKolomSumber;
        }

        public void setTipeKolomSumber(String tipeKolomSumber) {
            this.tipeKolomSumber = tipeKolomSumber;
        }

        public String getNamaKolomTarget() {
            return namaKolomTarget;
        }

        public void setNamaKolomTarget(String namaKolomTarget) {
            this.namaKolomTarget = namaKolomTarget;
        }

        public String getTipeKolomTarget() {
            return tipeKolomTarget;
        }

        public void setTipeKolomTarget(String tipeKolomTarget) {
            this.tipeKolomTarget = tipeKolomTarget;
        }
        String tipeKolomSumber;
        String namaKolomTarget;
        String tipeKolomTarget;

    }

}
