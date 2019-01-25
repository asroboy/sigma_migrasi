/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigma.migrationtool;

import com.sigma.migrationtool.listener.DataChangedLIstener;
import com.sigma.migrationtool.bkp.MigrasiBigPanel;
import com.sigma.big.controller.DatabaseController;
import com.sigma.big.model.db.Attributes;
import com.sigma.big.model.db.DBConConfiguration;
import com.sigma.big.model.db.Mapping;
import com.sigma.big.model.db.Project;
import com.sigma.big.tools.DatabaseTool;
import com.sigma.big.tools.ExcelReader;
import com.sigma.big.tools.GeometryTool;
import com.sigma.big.tools.LogWriter;
import com.sigma.big.tools.MetadataProject;
import com.sigma.big.tools.ProjectedTable;
import com.sigma.big.tools.Unsur;
import com.sigma.big.tools.ValidationTool;
import com.sigma.big.utils.Activity;
import com.sigma.big.utils.WktWkbUtil;
import com.sigma.bigmigrasi.db.FieldOfTable;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.io.ParseException;
import com.vividsolutions.jts.io.WKBReader;
import com.vividsolutions.jts.io.WKBWriter;
import com.vividsolutions.jts.io.WKTReader;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import javax.swing.event.TableModelEvent;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.text.DefaultCaret;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

/**
 *
 * @author Ridho
 */
public class MigrasiSdeToSdoSpecialCase extends javax.swing.JPanel implements Activity {

    private static final int TIMEOUT = 1000 * 60 * 10;
    private static final int BOOLEAN_COLUMN = 0;
    private static final int DATA_BESAR_COLUMN = 2;
    private static final int CONNECTION_SUMBER_CODE = 1;
    private static final int CONNECTION_TARGET_CODE = 2;
    AddDBConnectionNoSave addDBConnectionDialog;
    DBConConfiguration configurationSumber;
    DBConConfiguration configurationTarget;
    LogWriter logger;
    Connection connSumber;
    ValidationTool validationTool;
    boolean processing = false;
    HashMap<String, Project> projects;
    final int batchSize = 500;
    final int pageSize = 1000;
    ArrayList<Unsur> unsurs;
//    String defaultMappingPath = "C:/migrasi/data/mapping_produksi/mapping.xls";
    String defaultMappingPath = "";
    ArrayList<MetadataProject> metadataProjects;
//    h.denominator as SKALA, 
    String sql = "select a.title, c.FILEIDENTIFIER, d.SPECIFICATION from METADATA.ci_citation a "
            + "join METADATA.md_identification b on a.md_identificationid = b.id "
            + "join METADATA.md_metadata c on b.MD_METADATAID = c.id "
            + "join METADATA.md_format d on b.id = d.MD_IDENTIFICATIONID ORDER BY c.FILEIDENTIFIER ASC";
//            + "left join METADATA.sv_serviceidentification e on  b.id = e.MD_IDENTIFICATIONID "
//            + "left join METADATA.md_dataidentification f on e.id = f.sv_serviceidentificationid "
//            + "left join METADATA.md_resolution g on f.id = g.md_dataidentificationid "
//            + "left join METADATA.md_representativefraction h on g.id = h.md_resolutionid ";

    String currentFileIdentifier = "";

    /**
     * Creates new form MigrasiSdeToSdo
     */
    public MigrasiSdeToSdoSpecialCase() {

        initComponents();
        DefaultCaret caret = (DefaultCaret) textPaneLog.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);

        validationTool = new ValidationTool();
        Color customGreen = new Color(39, 139, 80);
//        Color backgroundColor = new Color(200, 50, 120);
        jProgressBar1.setForeground(customGreen);
//        jProgressBar1.setBackground(backgroundColor);
        jProgressBar2.setForeground(customGreen);
        jProgressBar1.setUI(new MyProgressUI());
        jProgressBar2.setUI(new MyProgressUI());

        radioButtonProject.setSelected(true);
        if (comboBoxProject.getItemCount() > 0) {
            comboBoxProject.setSelectedIndex(0);
        }
        DefaultTableModel dtm = (DefaultTableModel) tabelMapping.getModel();
        dtm.addTableModelListener((TableModelEvent e) -> {
            int row = e.getFirstRow();
            int column = e.getColumn();
            if (column == BOOLEAN_COLUMN) {
                TableModel model = (TableModel) e.getSource();
                String columnName = model.getColumnName(column);
                Boolean checked = (Boolean) model.getValueAt(row, column);
                Unsur unsur = unsurs.get(row);
//                System.out.println(row + " " + columnName + " SELECTED " + checked);
                unsur.setSelected(checked);
                unsurs.set(row, unsur);
            }

            if (column == DATA_BESAR_COLUMN) {
                TableModel model = (TableModel) e.getSource();
                String columnName = model.getColumnName(column);
                Boolean checked = (Boolean) model.getValueAt(row, column);
                Unsur unsur = unsurs.get(row);
//                System.out.println(row + " " + columnName + " SELECTED " + checked);
                unsur.setIsDataBesar(checked);
                unsurs.set(row, unsur);
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonMigrasi = new javax.swing.JButton();
        jProgressBar1 = new javax.swing.JProgressBar();
        jScrollPane1 = new javax.swing.JScrollPane();
        textPaneLog = new javax.swing.JTextPane();
        comboBoxProject = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelMapping = new javax.swing.JTable();
        radioButtonProject = new javax.swing.JRadioButton();
        jProgressBar2 = new javax.swing.JProgressBar();
        jPanel1 = new javax.swing.JPanel();
        buttonKoneksiDBDev = new javax.swing.JButton();
        labelKoneksiSumber = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        buttonKoneksiDBProd = new javax.swing.JButton();
        labelKoneksiTarget = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        buttonAmbilMapping = new javax.swing.JButton();
        labelStatus = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        buttonMigrasi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon_play.png"))); // NOI18N
        buttonMigrasi.setText("MIGRASI");
        buttonMigrasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMigrasiActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(textPaneLog);

        comboBoxProject.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboBoxProjectItemStateChanged(evt);
            }
        });
        comboBoxProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxProjectActionPerformed(evt);
            }
        });

        tabelMapping.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Pilih", "Unsur", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelMapping.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tabelMapping);
        if (tabelMapping.getColumnModel().getColumnCount() > 0) {
            tabelMapping.getColumnModel().getColumn(0).setResizable(false);
            tabelMapping.getColumnModel().getColumn(0).setPreferredWidth(4);
            tabelMapping.getColumnModel().getColumn(1).setPreferredWidth(100);
            tabelMapping.getColumnModel().getColumn(2).setPreferredWidth(250);
        }

        radioButtonProject.setText("Project");
        radioButtonProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioButtonProjectActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Koneksi Development"));

        buttonKoneksiDBDev.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon_dbcon_25x.png"))); // NOI18N
        buttonKoneksiDBDev.setText("Koneksi DB Development");
        buttonKoneksiDBDev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonKoneksiDBDevActionPerformed(evt);
            }
        });

        labelKoneksiSumber.setText("Koneksi dev.");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonKoneksiDBDev, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(labelKoneksiSumber, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 8, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonKoneksiDBDev, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelKoneksiSumber)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Koneksi Produksi"));

        buttonKoneksiDBProd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon_dbcon_25x.png"))); // NOI18N
        buttonKoneksiDBProd.setText("Koneksi DB Produksi");
        buttonKoneksiDBProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonKoneksiDBProdActionPerformed(evt);
            }
        });

        labelKoneksiTarget.setText("Koneksi Prod.");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonKoneksiDBProd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(labelKoneksiTarget, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 7, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonKoneksiDBProd, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelKoneksiTarget)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        buttonAmbilMapping.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon_folder.png"))); // NOI18N
        buttonAmbilMapping.setText("Browse");
        buttonAmbilMapping.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAmbilMappingActionPerformed(evt);
            }
        });

        jLabel1.setText("File Mapping");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon_refresh_setting.png"))); // NOI18N
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
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jProgressBar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addComponent(buttonMigrasi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(radioButtonProject, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel1)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboBoxProject, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextField1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonAmbilMapping)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelStatus)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(buttonAmbilMapping, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(radioButtonProject)
                    .addComponent(comboBoxProject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonMigrasi, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelStatus)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void updateFreezeViews() {
        buttonKoneksiDBDev.setEnabled(!processing);
        buttonKoneksiDBProd.setEnabled(!processing);
        buttonMigrasi.setEnabled(!processing);
        comboBoxProject.setEnabled(!processing);
        radioButtonProject.setEnabled(!processing);
        buttonAmbilMapping.setEnabled(!processing);
        jButton1.setEnabled(!processing);
    }

    private void updateFreezeViews(boolean isEnable) {
        buttonMigrasi.setEnabled(isEnable);
        comboBoxProject.setEnabled(isEnable);
        radioButtonProject.setEnabled(isEnable);
    }

    private void updateFreezeViewsForCon1(boolean isEnable) {
        buttonKoneksiDBProd.setEnabled(isEnable);
    }

    boolean isSetToTextPane = false;
    private void buttonMigrasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMigrasiActionPerformed

        processing = true;
        updateFreezeViews();
        if (configurationSumber == null || configurationTarget == null) {
            JOptionPane.showMessageDialog(null, "Koneksi sumber dan target diperlukan");
            processing = false;
            updateFreezeViews();
        } else {
            //textAreaLog.removeAll();
            textPaneLog.setText(null);
            textPaneLog.setText("");
            jProgressBar1.setMinimum(0);

            Thread t;
            t = new Thread(() -> {
                logger = new LogWriter("MIGRASI_DEV_PROD");
                logger.writeToTextArea(textPaneLog);

                int valueProgress = 1;
                try {
                    logger.log(LogWriter.INFO, "Memulai migrasi...");
                    if (connSumber == null) {
                        connSumber = DatabaseTool.getConnection(configurationSumber, logger);
                        if (connSumber == null) {
                            processing = false;
                            updateFreezeViews();
                        }
                    }
                    if (connSumber.isClosed()) {
                        connSumber = DatabaseTool.getConnection(configurationSumber, logger);
                        if (connSumber == null) {
                            processing = false;
                            updateFreezeViews();
                        }
                    }
                    ArrayList<Unsur> unsurs_ = getSelectedUnsur();
                    jProgressBar1.setStringPainted(true);
                    jProgressBar1.setValue(0);
                    jProgressBar1.setMaximum(unsurs_.size());

                    for (Unsur unsur : unsurs_) {
                        if (unsur.getMapping() != null) {
                            logger.log(LogWriter.INFO, valueProgress + ". MEMIGRASI UNSUR " + unsur.getMapping().getTabelSumber());
//                            String key = entry.getKey();
                            Mapping mapping = unsur.getMapping();

                            if (DatabaseTool.isTableExists(connSumber, mapping.getTabelSumber())) {
                                String fileIndentifier = metadataProjects.get(comboBoxProject.getSelectedIndex()).getFileIdetifier();
                                if (unsur.isIsDataBesar()) {
                                    bacaDataSumberSlow(mapping, fileIndentifier, unsur.getNamaSkema());
                                } else {
                                    bacaDataSumber(mapping, fileIndentifier, unsur.getNamaSkema());
                                }
                            } else {
                                logger.log(LogWriter.ERROR, "Unsur " + unsur.getMapping().getTabelSumber() + " tidak ditemukan di dalam database");
                            }
                        } else {
                            logger.log(LogWriter.ERROR, valueProgress + " Unsur " + unsur.getName() + " tidak ter-mapping");
                        }
                        updateValueBar(valueProgress);
                        valueProgress++;
                    }
                    processing = false;
                    updateFreezeViews();
                    logger.log(LogWriter.INFO, "Selesai ..!!!");
                } catch (IOException | SQLException ex) {
                    Logger.getLogger(MigrasiSdeToSdoSpecialCase.class.getName()).log(Level.SEVERE, null, ex);
                    processing = false;
                    updateFreezeViews();
                }
            });

            t.start();

        }

    }//GEN-LAST:event_buttonMigrasiActionPerformed

    private ArrayList<Unsur> getSelectedUnsur() {
        ArrayList<Unsur> un = new ArrayList<>();
        unsurs.stream().filter((unsur) -> (unsur.isSelected())).forEachOrdered((unsur) -> {
            un.add(unsur);
        });

        return un;
    }

    int previosPosition = 0;
    private void comboBoxProjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxProjectActionPerformed
//        checkBoxSemua.setSelected(true);
        int position = comboBoxProject.getSelectedIndex();
        if (position != previosPosition) {
            previosPosition = position;
            if (defaultMappingPath != null && !defaultMappingPath.equals("")) {
                doMapping();
            }
        }
    }//GEN-LAST:event_comboBoxProjectActionPerformed

    private void radioButtonProjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioButtonProjectActionPerformed
        // TODO add your handling code here:
        switchRadio(true);
        String key = (String) comboBoxProject.getSelectedItem();
        doMapping();
    }//GEN-LAST:event_radioButtonProjectActionPerformed

    private void buttonKoneksiDBDevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonKoneksiDBDevActionPerformed
        setConnection(CONNECTION_SUMBER_CODE);
    }//GEN-LAST:event_buttonKoneksiDBDevActionPerformed

    private void buttonKoneksiDBProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonKoneksiDBProdActionPerformed
        setConnection(CONNECTION_TARGET_CODE);
    }//GEN-LAST:event_buttonKoneksiDBProdActionPerformed

    private void buttonAmbilMappingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAmbilMappingActionPerformed
        // TODO add your handling code here:
        chooseFile();
    }//GEN-LAST:event_buttonAmbilMappingActionPerformed

    private void comboBoxProjectItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboBoxProjectItemStateChanged
        // TODO add your handling code here:
        System.out.println("Combo Item changed");
    }//GEN-LAST:event_comboBoxProjectItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        defaultMappingPath = jTextField1.getText();
        if (!defaultMappingPath.equals("")) {
            doMapping();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void setConnection(int m_code) {
        DBConConfiguration cnf = null;
        if (m_code == CONNECTION_SUMBER_CODE) {
            cnf = configurationSumber;
        }
        if (m_code == CONNECTION_TARGET_CODE) {
            cnf = configurationTarget;
        }
        if (addDBConnectionDialog == null) {
            AddDBConnection_ addDBConnection = new AddDBConnection_();
            addDBConnectionDialog = new AddDBConnectionNoSave(addDBConnection, true, listener_, cnf, m_code);
            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            addDBConnectionDialog.setLocation(dim.width / 2 - addDBConnectionDialog.getSize().width / 2, dim.height / 2 - addDBConnectionDialog.getSize().height / 2);
        }
        addDBConnectionDialog.reloadWithCode(
                cnf, m_code);
        addDBConnectionDialog.setVisible(
                true);
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
            if (code == CONNECTION_SUMBER_CODE) {
                setConnection(CONNECTION_SUMBER_CODE, (DBConConfiguration) o);

            }
            if (code == CONNECTION_TARGET_CODE) {
                setConnection(CONNECTION_TARGET_CODE, (DBConConfiguration) o);
//                doMapping();
//                if (metadataProjects == null) {
                metadataProjects = getProjectFromMetadata();
//                }
            }
        }
    };

    private void doMapping() {
        Thread thr = new Thread(new Runnable() {
            @Override
            public void run() {
                textPaneLog.setText("Sedang membaca mapping ..");
                comboBoxProject.setEnabled(false);
                buttonMigrasi.setEnabled(false);
                readExcelMapping(defaultMappingPath);

            }
        });

        thr.start();

    }

    private void chooseFile() {
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        FileNameExtensionFilter filter = new FileNameExtensionFilter("xls", "xls", "XLS");
        jfc.setFileFilter(filter);
        int returnValue = jfc.showOpenDialog(null);
        // int returnValue = jfc.showSaveDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = jfc.getSelectedFile();
            System.out.println(selectedFile.getName());
            if (!(selectedFile.getName().split("\\.")[1].equalsIgnoreCase("xls"))) {
                showDialog("Hanya mendukung file .xls");
            } else {
                defaultMappingPath = selectedFile.getAbsolutePath();
                jTextField1.setText(defaultMappingPath);
                doMapping();
                System.out.println(selectedFile.getAbsolutePath());
            }

        }
    }

    public void showDialog(final String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    private ArrayList<MetadataProject> getProjectFromMetadata() {
        ArrayList<MetadataProject> projects = new ArrayList<>();
        comboBoxProject.removeAllItems();
        try {
            Connection conn = DatabaseTool.getConnection(configurationTarget, logger);
            Statement stmt = conn.createStatement();
            ResultSet st = stmt.executeQuery(sql);

            while (st.next()) {
                MetadataProject mt = new MetadataProject();
//                mt.setSkala(st.getString("SKALA"));
                mt.setName(st.getString("title"));
                mt.setFileIdetifier(st.getString("FILEIDENTIFIER"));
                String spesification = st.getString("SPECIFICATION");
                ArrayList<String> tableNames = new ArrayList<>();
                String[] s = spesification.split(";");
                for (int i = 0; i < s.length; i++) {
                    String string = s[i].trim();
//                    System.out.println(" string " + string);
                    tableNames.add(string.trim());
                }
                Collections.sort(tableNames);

                mt.setTableNames(tableNames);
                projects.add(mt);
                comboBoxProject.addItem(mt.getName() + " - \n" + mt.getFileIdetifier());
            }
        } catch (IOException ex) {
            Logger.getLogger(MigrasiSdeToSdoSpecialCase.class
                    .getName()).log(Level.SEVERE, null, ex);

        } catch (SQLException ex) {
            Logger.getLogger(MigrasiSdeToSdoSpecialCase.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return projects;
    }

    public void switchRadio(boolean isProject) {
        radioButtonProject.setSelected(isProject);
        comboBoxProject.setEnabled(isProject);
    }

    public void updateValueBar(int value) {
        jProgressBar1.setValue(value);
    }

    public void bacaDataSumber(Mapping mapping, String fileIdentifier, String namaSkema) {
        try {
            DatabaseController dbController = new DatabaseController();
            HashMap<String, FieldOfTable> fields = dbController.getFieldsWithKey(connSumber, mapping.getTabelSumber());
            if (true) {
                Set<String> matrix = mapping.getAttributes().keySet();
                Set<String> sumber = fields.keySet();
                ArrayList<HashMap<String, Object>> sumberPacked = new ArrayList<>();
                ArrayList<HashMap<String, Object>> unmigratedRows = new ArrayList<>();
                ArrayList<String> commons = new ArrayList<>(sumber);
                commons.retainAll(matrix);
                for (String s : commons) {
                    System.out.println("key " + s);
                }

                ArrayList<String> kolomTidakMatch = new ArrayList<>(sumber);
                kolomTidakMatch.removeAll(commons);
//                System.out.println("kolomTidakMatch : " + kolomTidakMatch);

                int index = commons.indexOf("SHAPE");
                System.out.println("key " + index);
                if (index > -1) {
                    commons.remove(index);
                    commons.add(0, "SHAPE");
                }

                if (mandatoryValidation(kolomTidakMatch, mapping.getTabelSumber())) {
                    boolean isGeometryCorrect = true;
                    boolean isDomainCorrect = true;
                    boolean isFcodeCorrect = true;
                    boolean isGeometryNotNull = true;
                    boolean isDataAlreadyMigrated = false;
                    boolean isErroReading = false;
                    logger.log(LogWriter.INFO, "Validasi data dari " + mapping.getTabelSumber() + "...");
                    ValidationTool v = new ValidationTool();
                    int SRID = 0;

                    String FCODE = getFCode(connSumber, mapping.getSkemaSumber(), mapping.getTabelSumber(), fileIdentifier);
                    Connection conn = null;
                    try {
                        Connection conn_ = DatabaseTool.getConnection(configurationTarget, logger);
                        conn_.setNetworkTimeout(Executors.newFixedThreadPool(10), TIMEOUT);
                        //periksa apakah data sudah ada di tabel target
                        String sqlCheck = DatabaseTool.generateSQLCheckMetadataDiTableTarget(mapping.getSkemaTarget(), mapping.getTabelTarget());

                        System.out.println("SQL CHECK " + sqlCheck);
                        Statement stmtCheck = conn_.createStatement();
                        ResultSet checkRs = stmtCheck.executeQuery(sqlCheck);
                        while (checkRs.next()) {
                            String mFcode = checkRs.getString("FCODE");
                            String mFileIdentifier = checkRs.getString("METADATA");

                            System.out.println(mFcode + " " + FCODE);
                            System.out.println(mFileIdentifier + " " + fileIdentifier);

                            if (mFcode.equalsIgnoreCase(FCODE) && mFileIdentifier.equalsIgnoreCase(fileIdentifier)) {
                                isDataAlreadyMigrated = true;
                                logger.log(LogWriter.ERROR, "DATA sudah pernah termigrasi sebelumnya, FILEIDENTIFIER: " + fileIdentifier
                                        + ", \nTabel unsur sumber: " + mapping.getSkemaSumber()
                                        + "." + mapping.getTabelSumber() + "\nTabel unsur target: "
                                        + mapping.getSkemaTarget() + "." + mapping.getTabelTarget());
                            }
                        }
                        HashMap<String, Attributes> mappingColumns = mapping.getAttributes();
                        ArrayList<String> domainAttributes = new ArrayList<>();
                        for (Map.Entry<String, Attributes> entry : mappingColumns.entrySet()) {
                            String key = entry.getKey();
                            Attributes value = entry.getValue();
                            System.out.println("key " + key);
                            System.out.println("is domain " + value.isIsDomain());
                            if (value.isIsDomain()) {
                                domainAttributes.add(value.getNamaSumber());
                                System.out.println("domain attribute" + value.getNamaSumber());
                            }

                        }

                        if (!isDataAlreadyMigrated) {
                            int numberRows = getNumberRows(connSumber, mapping.getSkemaSumber(), mapping.getTabelSumber(), fileIdentifier);
//                            logger.log(LogWriter.INFO, "jumlah rows  " + numberRows);
                            jProgressBar2.setMaximum(numberRows);
                            jProgressBar2.setStringPainted(true);
//                            jProgressBar2.setIndeterminate(true);

                            int pages = numberRows / pageSize;
                            int i = 1;
                            int rowMin = 0;
                            logger.log(LogWriter.INFO, "Membaca data dari " + mapping.getTabelSumber() + "...");

                            Statement stmt = connSumber.createStatement();
                            for (int page = 0; page <= pages; page++) {
                                if (!commons.contains("OBJECTID")) {
                                    commons.add("OBJECTID");
                                }
                                int rowMax = rowMin + pageSize;
                                System.out.println("");
//                                logger.log(LogWriter.INFO, "rowMin " + rowMin + " rowMax " + rowMax);
                                String where_ = (fileIdentifier == null || fileIdentifier.equals("")) ? "" : " WHERE METADATA = \'" + fileIdentifier + "\'";
                                String sql = DatabaseTool.generateSQLGetSourceWithPaging(namaSkema, mapping, logger, commons, fileIdentifier, where_, rowMin, rowMax);
                                System.out.println(sql);
                                ResultSet rs = stmt.executeQuery(sql);
                                while (rs.next()) {
                                    System.out.print("|");
                                    SRID = rs.getInt("SRID");
                                    String geomType = rs.getString("GEOMTYPE");
                                    HashMap<String, Object> dataSumber = new HashMap<>();

                                    for (String colSourceName : commons) {
                                        Attributes attrMapping = mappingColumns.get(colSourceName);
                                        boolean isObjectId = colSourceName.equalsIgnoreCase("OBJECTID");
                                        String colSourceType = attrMapping.getDataTypeSumber();
                                        boolean isDomain = attrMapping.isIsDomain();
                                        if (colSourceType.equalsIgnoreCase("geometry")) {
//                                            dataSumber.put(colSourceName, rs.getBytes(colSourceName));
                                            try {
//                                                Blob colValue = rs.getBlob(colSourceName);
                                                com.esri.core.geometry.Geometry geom = WktWkbUtil.fromWkb((byte[]) rs.getBytes(colSourceName));
//                                                System.out.println("colValue " + colValue);
                                                if (geom == null) {
                                                    isGeometryNotNull = false;
                                                    System.out.println("isGeometryNotNull " + isGeometryNotNull);
                                                }

                                                String clobString = new WktWkbUtil().toWkt(geom);
//                                                System.out.println("GEOMETRY : " + clobString);
//                                                String clobString = ClobTool.toString(colValue);

                                                if (GeometryTool.isGeometryKnown(clobString)) {
                                                    Geometry geometri = GeometryTool.getGeometry(clobString, logger);
                                                    dataSumber.put(colSourceName, geometri);
                                                } else {
                                                    if (geomType == null) {
                                                        continue;
                                                    }
                                                    clobString = GeometryTool.checkStringGeometryClob(clobString, geomType);
                                                    Geometry geometri = GeometryTool.getGeometry(clobString, logger);
                                                    dataSumber.put(colSourceName, geometri);
                                                }
                                            } catch (Exception ex) {
                                                Logger.getLogger(MigrasiBigPanel.class
                                                        .getName()).log(Level.SEVERE, null, ex);
                                            }
                                        } else {
                                            if (!isObjectId) {
                                                String colValue = rs.getString(colSourceName.toUpperCase());
                                                if (isDomain) {
                                                    if (colValue == null) {
                                                        dataSumber.put(colSourceName, colValue);
                                                    } else {
                                                        if (colValue.equals("") || colValue.equals("null")) {
                                                            dataSumber.put(colSourceName, colValue);
                                                        } else {
                                                            //JIKA TIDA REAMRK, MAKA SEMENTARA DOMAIN BENAR SEMUA
                                                            //DALAM HAL INI JIKA DOMAIN TIDAK VALID SECARA OTOMATIS ORACLE AKAN ME-REJECT KARENA TIDAK DITEMUKAN RELASI-NYA
                                                            boolean isDomainValid = true;
                                                            //boolean isDomainValid = v.checkDomain(colValue, colSourceName);
                                                            if (isDomainValid) {
                                                                dataSumber.put(colSourceName, colValue);
                                                            } else {
                                                                isDomainCorrect = false;
                                                                dataSumber.put(colSourceName, colValue);
                                                            }
                                                        }
                                                    }

                                                } else if (colSourceName.equalsIgnoreCase("FCODE")) {
                                                    boolean isFcodeValid = v.checkFcodeIsValid(colValue);
                                                    if (isFcodeValid) {
                                                        dataSumber.put(colSourceName, colValue);
                                                    } else {
                                                        isFcodeCorrect = false;
                                                    }
                                                } else {
                                                    dataSumber.put(colSourceName, colValue);
                                                }
                                            } else {
//                                                System.out.println("OBJECTID == " + colSourceName);
                                                dataSumber.put(colSourceName, rs.getInt(colSourceName.toUpperCase()));
                                            }
                                        }
                                    }

                                    //if (isGeometryCorrect) {
                                    sumberPacked.add(dataSumber);
                                    // } else {
                                    //if (!isGeometryCorrect) {
                                    //unmigratedRows.add(dataSumber);
                                    //}
                                    // isGeometryCorrect = true;

                                    //MIGRASI DATA SETIAP pageSize ROWS , UNTUK MEMINIMALISIR OUT OF MEMORY DALAM MENYIMPAN DATA
                                    if (sumberPacked.size() == pageSize) {
                                        System.out.println("DATA SUMBER SIZE " + sumberPacked.size());
                                        if (isGeometryCorrect && isGeometryNotNull && isDomainCorrect && isFcodeCorrect) {
                                            logger.log(LogWriter.INFO, "SHAPE dari " + mapping.getTabelSumber() + " valid : " + true);
                                            logger.log(LogWriter.INFO, "DOMAIN dari " + mapping.getTabelSumber() + " valid : " + true);
                                            logger.log(LogWriter.INFO, "FCODE dari " + mapping.getTabelSumber() + " valid : " + true);
                                            if (sumberPacked.size() > 0) {
                                                if (conn == null) {
                                                    conn = DatabaseTool.getConnection(configurationTarget, logger);
                                                    conn.setNetworkTimeout(Executors.newFixedThreadPool(10), TIMEOUT);
                                                }
                                                conn.setAutoCommit(false);
                                                try {
                                                    migrasiToSdo(conn, mapping, sumberPacked, unmigratedRows, commons, SRID);
                                                } catch (ParseException ex) {
                                                    logger.log(LogWriter.WARNING, "GAGALM MEMBACA GEOMETRY");
                                                    Logger.getLogger(MigrasiSdeToSdoSpecialCase.class.getName()).log(Level.SEVERE, null, ex);
                                                    break;
                                                }
                                            } else {
                                                logger.log(LogWriter.WARNING, "TIDAK ADA DATA, UNSUR: " + mapping.getTabelSumber() + ", FILEIDENTIFIER: " + fileIdentifier);
                                            }
                                        } else {
                                            if (!isGeometryCorrect) {
                                                logger.log(LogWriter.ERROR, "SHAPE dari " + mapping.getTabelSumber() + " valid : " + false);
                                            }
                                            if (!isDomainCorrect) {
                                                logger.log(LogWriter.ERROR, "DOMAIN dari " + mapping.getTabelSumber() + " valid : " + false);
                                            }
                                            if (!isFcodeCorrect) {
                                                logger.log(LogWriter.ERROR, "FCODE tidak valid untuk unsur " + mapping.getTabelSumber());
                                            }
                                            if (!isGeometryNotNull) {
                                                logger.log(LogWriter.ERROR, "SHAPE dari " + mapping.getTabelSumber() + " Null (Tidak valid)");
                                            }

                                            break;
                                        }
                                        //CLEAR KEMBALI DATA SUMBER = 0
                                        sumberPacked.clear();
                                        dataSumber.clear();
                                    }
                                    jProgressBar2.setValue(i);
                                    i++;
                                }
                                rs.close();
                                rowMin = rowMax;
                            }

//                            jProgressBar2.setIndeterminate(false);
                            stmt.close();
                        }
                    } catch (SQLException e) {
                        logger.log(LogWriter.ERROR, "Gagal membaca data " + e.getMessage());
                        isErroReading = true;
                    }
                    if (!isDataAlreadyMigrated) {
                        if (!isErroReading) {
                            if (isGeometryCorrect && isGeometryNotNull && isDomainCorrect && isFcodeCorrect) {
                                logger.log(LogWriter.INFO, "SHAPE dari " + mapping.getTabelSumber() + " valid : " + true);
                                logger.log(LogWriter.INFO, "DOMAIN dari " + mapping.getTabelSumber() + " valid : " + true);
                                logger.log(LogWriter.INFO, "FCODE dari " + mapping.getTabelSumber() + " valid : " + true);
                                if (sumberPacked.size() > 0) {
                                    if (conn == null) {
                                        conn = DatabaseTool.getConnection(configurationTarget, logger);
                                        conn.setNetworkTimeout(Executors.newFixedThreadPool(10), TIMEOUT);
                                    }
                                    conn.setAutoCommit(false);
                                    try {
                                        migrasiToSdo(conn, mapping, sumberPacked, unmigratedRows, commons, SRID);

                                        if (conn != null) {
                                            System.out.print("COMMIT TRANSACTION");
                                            conn.commit();
                                            System.out.print("CLOSING CONNECTION TARGET");
                                            conn.close();
                                        }
                                    } catch (ParseException ex) {
                                        Logger.getLogger(MigrasiSdeToSdoSpecialCase.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                } else {
                                    logger.log(LogWriter.WARNING, "TIDAK ADA DATA, UNSUR: " + mapping.getTabelSumber() + ", FILEIDENTIFIER: " + fileIdentifier);
                                }
                            } else {
                                if (!isGeometryCorrect) {
                                    logger.log(LogWriter.ERROR, "SHAPE dari " + mapping.getTabelSumber() + " valid : " + false);
                                }
                                if (!isDomainCorrect) {
                                    logger.log(LogWriter.ERROR, "DOMAIN dari " + mapping.getTabelSumber() + " valid : " + false);
                                }
                                if (!isFcodeCorrect) {
                                    logger.log(LogWriter.ERROR, "FCODE tidak valid untuk unsur " + mapping.getTabelSumber());

                                }
                                if (!isGeometryNotNull) {
                                    logger.log(LogWriter.ERROR, "SHAPE dari " + mapping.getTabelSumber() + " Null (Tidak valid)");
                                }

                                if (conn != null) {
                                    System.out.println("ROLLBACK TRANSACTION");
                                    conn.rollback();
                                    System.out.println("CLOSING CONNECTION TARGET");
                                    conn.close();
                                }
                            }
                        } else {

                            if (conn != null) {
                                System.out.println("ROLLBACK TRANSACTION");
                                conn.rollback();
                                System.out.println("CLOSING CONNECTION TARGET");
                                conn.close();
                            }
                        }
                    } else {

                        if (conn != null) {
                            System.out.println("ROLLBACK TRANSACTION");
                            conn.rollback();
                            System.out.println("CLOSING CONNECTION TARGET");
                            conn.close();
                        }
                    }

                }
            } else {
                Logger.getLogger(MigrasiBigPanel.class
                        .getName()).log(Level.WARNING, null, "Attribut tidak sesuai");
                logger.log(LogWriter.WARNING, "Attribut tidak sesuai");

            }
        } catch (IOException | SQLException ex) {
            Logger.getLogger(MigrasiBigPanel.class
                    .getName()).log(Level.SEVERE, null, ex);
            try {
                logger.log(LogWriter.ERROR, "Error " + ex.getMessage());
            } catch (IOException ex1) {
                Logger.getLogger(MigrasiSdeToSdoSpecialCase.class.getName()).log(Level.SEVERE, null, ex1);
            }

        }

    }

    public void bacaDataSumberSlow(Mapping mapping, String fileIdentifier, String namaSkema) {
        try {
            DatabaseController dbController = new DatabaseController();
            HashMap<String, FieldOfTable> fields = dbController.getFieldsWithKey(connSumber, mapping.getTabelSumber());
            if (true) {
                Set<String> matrix = mapping.getAttributes().keySet();
                Set<String> sumber = fields.keySet();
                ArrayList<HashMap<String, Object>> sumberPacked = new ArrayList<>();
                ArrayList<HashMap<String, Object>> unmigratedRows = new ArrayList<>();
                ArrayList<String> common = new ArrayList<>(sumber);
                common.retainAll(matrix);

                ArrayList<String> kolomTidakMatch = new ArrayList<>(sumber);
                kolomTidakMatch.removeAll(common);
                int index = common.indexOf("SHAPE");
                common.remove(index);
                common.add(0, "SHAPE");

                if (mandatoryValidation(kolomTidakMatch, mapping.getTabelSumber())) {
                    boolean isGeometryCorrect = true;
                    boolean isDomainCorrect = true;
                    boolean isFcodeCorrect = true;
                    boolean isGeometryNotNull = true;
                    boolean isDataAlreadyMigrated = false;
                    boolean isErroReading = false;
                    logger.log(LogWriter.INFO, "Validasi data dari " + mapping.getTabelSumber() + "...");
                    ValidationTool v = new ValidationTool();
                    int SRID = 0;

                    String FCODE = getFCode(connSumber, mapping.getSkemaSumber(), mapping.getTabelSumber(), fileIdentifier);

                    try {
                        Connection conn_ = DatabaseTool.getConnection(configurationTarget, logger);
                        conn_.setNetworkTimeout(Executors.newFixedThreadPool(10), TIMEOUT);
                        //periksa apakah data sudah ada di tabel target
                        String sqlCheck = DatabaseTool.generateSQLCheckMetadataDiTableTarget(mapping.getSkemaTarget(), mapping.getTabelTarget());

//                        System.out.println("SQL CHECK " + sqlCheck);
                        Statement stmtCheck = conn_.createStatement();
                        ResultSet checkRs = stmtCheck.executeQuery(sqlCheck);
                        while (checkRs.next()) {
                            String mFcode = checkRs.getString("fcode");
                            String mFileIdentifier = checkRs.getString("metadata");
                            if (mFcode.equalsIgnoreCase(FCODE) && mFileIdentifier.equalsIgnoreCase(fileIdentifier)) {
                                isDataAlreadyMigrated = true;
                                logger.log(LogWriter.ERROR, "DATA sudah pernah termigrasi sebelumnya, FILEIDENTIFIER: " + fileIdentifier + ", \nTabel unsur sumber: " + mapping.getSkemaSumber() + "." + mapping.getTabelSumber() + "\nTabel unsur target: " + mapping.getSkemaTarget() + "." + mapping.getTabelTarget());
                            }
                        }

                        if (!isDataAlreadyMigrated) {

                            ArrayList<Integer> objectIds = getCountObjectIds(connSumber, mapping.getSkemaSumber(), mapping.getTabelSumber(), fileIdentifier);
                            int i = 1;
                            logger.log(LogWriter.INFO, "Membaca data dari " + mapping.getTabelSumber() + "...");

                            for (int objectId : objectIds) {
                                if (connSumber.isClosed()) {
                                    connSumber = DatabaseTool.getConnection(configurationSumber, logger);
                                }
                                Statement stmt = connSumber.createStatement();
                                String where_ = (fileIdentifier == null || fileIdentifier.equals("")) ? "" : " WHERE METADATA = \'" + fileIdentifier + "\' AND OBJECTID = " + objectId;

                                String sql = DatabaseTool.generateSQLGetSource(namaSkema, mapping, logger, common, fileIdentifier, where_);
//                                System.out.println(sql);
                                ResultSet rs = stmt.executeQuery(sql);
                                int numberRows = getNumberRows(connSumber, mapping.getSkemaSumber(), mapping.getTabelSumber(), fileIdentifier);
                                jProgressBar2.setMaximum(numberRows);

                                while (rs.next()) {
                                    System.out.print("|");
                                    SRID = rs.getInt("SRID");
                                    String geomType = rs.getString("GEOMTYPE");
//                                System.out.println("SRID " + SRID);
                                    HashMap<String, Object> dataSumber = new HashMap<>();
                                    HashMap<String, Attributes> mappingColumns = mapping.getAttributes();
                                    for (String colSourceName : common) {
//                              for (Map.Entry<String, Attributes> entry : mappingColumns.entrySet()) {
//                                  String key = entry.getKey();
                                        Attributes attrMapping = mappingColumns.get(colSourceName);
                                        boolean isObjectId = colSourceName.equalsIgnoreCase("OBJECTID");
//                                  String colSourceName = mappingColumn.getNamaSumber();
                                        String colSourceType = attrMapping.getDataTypeSumber();
                                        boolean isDomain = attrMapping.isIsDomain();

                                        if (colSourceType.equalsIgnoreCase("geometry")) {
//                                        System.out.println(colSourceName);
//                                        String clobString = rs.getString(colSourceName);
                                            try {
                                                com.esri.core.geometry.Geometry geom = WktWkbUtil.fromWkb((byte[]) rs.getBytes(colSourceName));
//                                             

                                                if (geom == null) {
                                                    isGeometryNotNull = false;
                                                    System.out.println("isGeometryNotNull " + isGeometryNotNull);
                                                }

                                                String clobString = new WktWkbUtil().toWkt(geom);

                                                if (GeometryTool.isGeometryKnown(clobString)) {
                                                    Geometry geometri = GeometryTool.getGeometry(clobString, logger);
                                                    dataSumber.put(colSourceName, geometri);
                                                } else {
                                                    if (geomType == null) {
                                                        continue;
                                                    }
                                                    clobString = GeometryTool.checkStringGeometryClob(clobString, geomType);
                                                    Geometry geometri = GeometryTool.getGeometry(clobString, logger);
                                                    dataSumber.put(colSourceName, geometri);
                                                }

//                                                String clobString = new WktWkbUtil().toWkt(geom);
//
//                                                Clob colValue = rs.getClob(colSourceName);
//                                                if (isShapeNull(colValue)) {
//                                                    isGeometryNotNull = false;
//                                                }
//                                                String clobString = ClobTool.toString(colValue);
////                                                if (clobString.length() > 60) {
////                                                    String upToNCharacters = clobString.substring(0, 50);
////                                                    System.out.println("WKT  : " + upToNCharacters);
////                                                } else {
//
////                                                }
//                                                System.out.println("WKT STRING : " + clobString);
//                                                if (GeometryTool.isGeometryKnown(clobString)) {
////                                              
//                                                    dataSumber.put(colSourceName, clobString);
//                                                } else {
////                                              isGeometryCorrect = false;
////                                                if (clobString != null) {
//                                                    clobString = GeometryTool.checkStringGeometryClob(clobString, geomType);
////                                                }
//                                                    dataSumber.put(colSourceName, clobString);
//
//                                                }
                                            } catch (IOException ex) {
                                                Logger.getLogger(MigrasiBigPanel.class
                                                        .getName()).log(Level.SEVERE, null, ex);
                                            }
                                        } else {
                                            if (!isObjectId) {
                                                String colValue = rs.getString(colSourceName.toUpperCase());
                                                if (isDomain) {
                                                    if (colValue == null) {
                                                        dataSumber.put(colSourceName, colValue);
                                                    } else {
                                                        if (colValue.equals("") || colValue.equals("null")) {
                                                            dataSumber.put(colSourceName, colValue);
                                                        } else {
                                                            //JIKA TIDA REAMRK, MAKA SEMENTARA DOMAIN BENAR SEMUA
                                                            boolean isDomainValid = true;
//                                                        boolean isDomainValid = v.checkDomainToDB(conn_, colSourceName, colValue);
//                                                        System.out.println("DOMAIN " + colSourceName + " is valid = " + isDomainValid);
                                                            if (isDomainValid) {
                                                                dataSumber.put(colSourceName, colValue);
                                                            } else {
                                                                isDomainCorrect = false;
                                                                dataSumber.put(colSourceName, colValue);
                                                            }
                                                        }
                                                    }

                                                } else if (colSourceName.equalsIgnoreCase("FCODE")) {
//                                                System.out.println("FCODE VALUE " + colValue);
                                                    boolean isFcodeValid = v.checkFcodeIsValid(colValue);
                                                    if (isFcodeValid) {
                                                        dataSumber.put(colSourceName, colValue);
                                                    } else {
                                                        isFcodeCorrect = false;
                                                    }
                                                } else {
//                                                System.out.println("VALUE OF " + colSourceName + " = " + colValue);
                                                    dataSumber.put(colSourceName, colValue);
                                                }
                                            } else {
//                                            info = "OBJECTID = " + rs.getString(colSourceName);
                                            }
                                        }

                                    }
                                    sumberPacked.add(dataSumber);
                                }
                                rs.close();
                                stmt.close();
                                connSumber.close();
                                jProgressBar2.setValue(i);
                                i++;
                            }

                        }
                    } catch (Exception e) {
                        logger.log(LogWriter.ERROR, "Gagal membaca data " + e.getMessage());
                        isErroReading = true;
                    }

                    if (!isDataAlreadyMigrated && !isErroReading) {
                        if (isGeometryCorrect && isGeometryNotNull && isDomainCorrect && isFcodeCorrect) {
                            Connection conn = DatabaseTool.getConnection(configurationTarget, logger);
                            conn.setNetworkTimeout(Executors.newFixedThreadPool(10), TIMEOUT);
                            conn.setAutoCommit(false);
                            logger.log(LogWriter.INFO, "SHAPE dari " + mapping.getTabelSumber() + " valid : " + true);
                            logger.log(LogWriter.INFO, "DOMAIN dari " + mapping.getTabelSumber() + " valid : " + true);
                            logger.log(LogWriter.INFO, "FCODE dari " + mapping.getTabelSumber() + " valid : " + true);

                            if (sumberPacked.size() > 0) {
                                migrasiToSdo(conn, mapping, sumberPacked, unmigratedRows, common, SRID);
                                conn.commit();
                                conn.close();
                            } else {
                                logger.log(LogWriter.WARNING, "TIDAK ADA DATA, UNSUR: " + mapping.getTabelSumber() + ", FILEIDENTIFIER: " + fileIdentifier);
                            }
                        } else {
                            if (!isGeometryCorrect) {
                                logger.log(LogWriter.ERROR, "SHAPE dari " + mapping.getTabelSumber() + " valid : " + false);
                            }
                            if (!isDomainCorrect) {
                                logger.log(LogWriter.ERROR, "DOMAIN dari " + mapping.getTabelSumber() + " valid : " + false);
                            }
                            if (!isFcodeCorrect) {
                                logger.log(LogWriter.ERROR, "FCODE tidak valid untuk unsur " + mapping.getTabelSumber());

                            }
                        }
                    }
                }
            } else {
                Logger.getLogger(MigrasiBigPanel.class
                        .getName()).log(Level.WARNING, null, "Attribut tidak sesuai");

            }
        } catch (IOException | SQLException ex) {
            Logger.getLogger(MigrasiBigPanel.class
                    .getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(MigrasiSdeToSdoSpecialCase.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public ArrayList<Integer> getCountObjectIds(Connection con, String skema, String table, String fileIdentiifier) throws SQLException {
        Statement stm = con.createStatement();
        String sqlCount = "SELECT OBJECTID from " + skema
                + "." + table
                + "  WHERE  METADATA = \'" + fileIdentiifier + "\' order by OBJECTID asc";
//        System.out.println(sqlCount);
        ResultSet rs = stm.executeQuery(sqlCount);
        ArrayList<Integer> objectIds = new ArrayList<>();
        if (rs.isFirst()) {
            int count = rs.getInt("OBJECTID");
//            System.out.println(count);
            objectIds.add(count);
        }

        while (rs.next()) {
            int count = rs.getInt("OBJECTID");
//             System.out.println(count);
            objectIds.add(count);
        }

//        stm.close();
        return objectIds;
    }

    private int getNumberRows(Connection con, String skema, String table, String fileIdentifier) throws SQLException {
        Statement stm = con.createStatement();
        String sql = DatabaseTool.getNumberRows(skema, table, fileIdentifier);
//        System.out.println(sql);
        ResultSet rs = stm.executeQuery(sql);
        int rows = 0;
        if (rs.next()) {
            rows = rs.getInt("CNT");
        }
        stm.close();
        return rows;
    }

    private String getFCode(Connection con, String skema, String tableName, String metadata) throws SQLException {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select DISTINCT fcode from " + skema + "." + tableName + " WHERE METADATA=\'" + metadata + "\'");
        String FCODE = "";
        while (rs.next()) {
            FCODE = rs.getString("FCODE");
        }
        stmt.close();
        System.out.println("FCODE " + FCODE);
        return FCODE;
    }

    private boolean mandatoryValidation(ArrayList<String> columns, String tableName) throws IOException {
        boolean valid = columns.stream().noneMatch((column) -> (!validationTool.checkMandatory(column)));
        int z = (valid) ? LogWriter.INFO : LogWriter.ERROR;
        logger.log(z, "Mandatory attributes dari " + tableName + " valid : " + valid);
        return valid;
    }

    private boolean isShapeNull(Clob colValue) {
        return validationTool.checkValueIsNull(colValue);
    }

    public void migrasiToSdo(Connection conn, Mapping mapping, ArrayList<HashMap<String, Object>> dataSumber, ArrayList<HashMap<String, Object>> failedRows, ArrayList<String> common_, int SRID) throws IOException, SQLException, ParseException {
//        try {
        ArrayList<String> common = common_;
        if (conn != null) {
            SRID = checkSRID(SRID, conn);
            String sql = DatabaseTool.generateSQLInsertTarget(mapping, common, SRID);
            System.out.println(sql);
            PreparedStatement preparedStmt = conn.prepareStatement(sql);
            logger.log(LogWriter.INFO, "Mengumpulkan data dari " + mapping.getTabelSumber() + " untuk di-eksport ke " + mapping.getTabelTarget());
//                jProgressBar2.setValue(0);
//                jProgressBar2.setMaximum(dataSumber.size());
            for (int j = 0; j < dataSumber.size(); j++) {
                HashMap<String, Object> columnData = dataSumber.get(j);
                int i = 1;
//                    HashMap<String, Attributes> mappingColumns = mapping.getAttributes();
//                System.out.println("OBJECTID " + columnData.get("OBJECTID"));
                common.remove("OBJECTID");
                for (String string : common) {

//                    for (Map.Entry<String, Attributes> entry : mappingColumns.entrySet()) {
//                        String key = entry.getKey();
                    Attributes mappingColumn = mapping.getAttributes().get(string);

//                        System.out.println("Tipe " + mappingColumn.getDataTypeSumber());
                    boolean isGeomType = mappingColumn.getDataTypeSumber().equalsIgnoreCase("geometry");
                    boolean isNumber = mappingColumn.getDataTypeSumber().equalsIgnoreCase("integer");
                    boolean isMetadata = mappingColumn.getNamaSumber().equalsIgnoreCase("METADATA");
//                        boolean isObjectID = mappingColumn.getNamaSumber().equalsIgnoreCase("OBJECTID");

                    if (isGeomType) {
//                        System.out.println("get shape " + (String) columnData.get(string));
                        WKBReader wkbr = new WKBReader();
                        WKTReader wktr = new WKTReader();
//                        Geometry geometri = wkbr.read((byte[]) columnData.get(string));
//                        Geometry geometri = wktr.read((String) columnData.get(string));
//                        Geometry geometri = GeometryTool.getGeometry((String) columnData.get(string), logger);
                        Geometry geometri = (Geometry) columnData.get(string);
                        if (geometri != null) {
                            geometri.setSRID(SRID);

//                            System.out.println("BOUNDING BOX " + geometri.getEnvelope());
//                                System.out.println("add to prepared stmt index " + (i) + " " + string + " val " + ((geometri == null) ? null : GeometryTool.getGeometry((String) columnData.get(string), logger)));
//                            System.out.println("SRID " + geometri.getSRID());
                            Blob blob = conn.createBlob();
//                            String str = ((geometri == null) ? "" : GeometryTool.getGeometry((String) columnData.get(string), logger).toString());
                            byte[] wkbs = new WKBWriter().write(geometri);
                            blob.setBytes(1, wkbs);
                            preparedStmt.setBlob(i, blob);
//                            Clob clob = conn.createClob();
//                            clob.setString(1, geometri.toString());
//                            preparedStmt.setClob(i, clob);
                        } else {
                            logger.log(LogWriter.ERROR, "Geometry tidak valid");
//                             Clob clob = conn.createClob();
//                            String str = ((geometri == null) ? "" : GeometryTool.getGeometry((String) columnData.get(string), logger).toString());
//                            preparedStmt.setClob(i, clob); //getGeometry
                        }
                    } else {
//                            if (isNumber) {
//                                System.out.println("add to prepared stmt index " + (i) + mappingColumn.getNamaSumber() + " val " + columnData.get(mappingColumn.getNamaSumber()));
//                                preparedStmt.setInt(i, Integer.parseInt((String) columnData.get(mappingColumn.getNamaSumber())));
                        //                            val += ((String) columnData.get(mappingColumn.getColSourceName()));
                        //                            val += (i == columnData.size() - 1 ? "" : ",");
//                            } else 

                        if (isMetadata) {
//                                System.out.println("add to prepared stmt index " + (i) + " " + string + " val " + columnData.get(string));
                            preparedStmt.setString(i, (String) columnData.get(string));
                        } else {
//                                System.out.println("add to prepared stmt index " + (i) + " " + string + " val " + columnData.get(string));
                            preparedStmt.setString(i, (String) columnData.get(string));
//                            val += "\'" + ((String) columnData.get(mappingColumn.getColSourceName())) + "\'";
//                            val += (i == columnData.size() - 1 ? "" : ",");
                        }
                    }

                    i++;
                }
//                    System.out.println("== ADD BATCH DATA == ");
                preparedStmt.addBatch();
                if ((j + 1) % batchSize == 0) {
                    logger.log(LogWriter.INFO, "Eksekusi batch data untuk unsur " + mapping.getTabelSumber() + " ...");
                    preparedStmt.executeBatch();
                }

//                    jProgressBar2.setValue(j + 1);
            }
            logger.log(LogWriter.INFO, "Meng-export data untuk unsur " + mapping.getTabelSumber() + " ...");
            preparedStmt.executeBatch();
//                preparedStmt.close();
//                conn.close();
        }
//            jLabel3.setText("Selesai, Jumalh row berhasil : " + dataSumber.size() + ", Jumlah row yang tidak dapat di migrasi : " + failedRows.size());
//        } catch (SQLException ex) {
//            conn.rollback();
//           
////            jLabel3.setForeground(Color.red);
////            jLabel3.setText("Gagal");
//            logger.log(LogWriter.ERROR, "Gagal melakukan ekspor data :" + ex.getMessage());
//
//        } catch (ParseException ex) {
//            conn.rollback();
//            logger.log(LogWriter.ERROR, "Gagal membaca geometry :" + ex.getMessage());
//            Logger.getLogger(MigrasiSdeToSdo.class.getName()).log(Level.SEVERE, null, ex);
//        }

    }

    private int checkSRID(int SRID, Connection conn) throws SQLException {
        String sqlCheckSRID = DatabaseTool.generateSQLCheckSRIDinSDO(SRID);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sqlCheckSRID);
        if (rs.next()) {
            if (rs.getInt("COUNT") == 0) {
                SRID = 4326;
            }
        }
        System.out.println("Check SRID " + SRID);
        return SRID;
    }

    @Override
    public void onStart() {
        if (configurationSumber == null) {
            updateFreezeViewsForCon1(false);
        }
        if (configurationTarget == null) {
            updateFreezeViews(false);
        }
        jTextField1.setText(defaultMappingPath);
    }

    @Override
    public void onPause() {
    }

    @Override
    public void onResume() {
    }

    private void setConnection(int code, DBConConfiguration con) {
        if (code == CONNECTION_TARGET_CODE) {
            configurationTarget = con;
            String url = DatabaseTool.generateUrl(configurationTarget);
            System.out.println("URL : " + url);
            labelKoneksiTarget.setText(url);
        }

        if (code == CONNECTION_SUMBER_CODE) {
            configurationSumber = con;
            String url = DatabaseTool.generateUrl(configurationSumber);
            System.out.println("URL : " + url);
            labelKoneksiSumber.setText(url);
            updateFreezeViewsForCon1(true);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAmbilMapping;
    private javax.swing.JButton buttonKoneksiDBDev;
    private javax.swing.JButton buttonKoneksiDBProd;
    private javax.swing.JButton buttonMigrasi;
    private javax.swing.JComboBox<String> comboBoxProject;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JProgressBar jProgressBar2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel labelKoneksiSumber;
    private javax.swing.JLabel labelKoneksiTarget;
    private javax.swing.JLabel labelStatus;
    private javax.swing.JRadioButton radioButtonProject;
    private javax.swing.JTable tabelMapping;
    private javax.swing.JTextPane textPaneLog;
    // End of variables declaration//GEN-END:variables

    public void readExcelMapping(String path) {
        SwingWorker worker = new SwingWorker() {
            @Override
            protected Object doInBackground() throws Exception {
                HashMap<String, Mapping> mappings = null;
                try {
                    ExcelReader excelReader = new ExcelReader();
                    mappings = excelReader.getMappingFromExcelNew(path);
                } catch (IOException ex) {
                    Logger.getLogger(MigrasiSdeToSdoSpecialCase.class
                            .getName()).log(Level.SEVERE, null, ex);
                } catch (EncryptedDocumentException ex) {
                    Logger.getLogger(MigrasiSdeToSdoSpecialCase.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InvalidFormatException ex) {
                    Logger.getLogger(MigrasiSdeToSdoSpecialCase.class.getName()).log(Level.SEVERE, null, ex);
                }
                publish(mappings);
                return mappings;
            }

            @Override
            protected void process(List chunks) {
                super.process(chunks);
                HashMap<String, Mapping> mapping = (HashMap<String, Mapping>) chunks.get(0);

                if (metadataProjects == null) {
                    metadataProjects = getProjectFromMetadata();
                }
                HashMap<String, Mapping> projectMapping = new HashMap<>();
                HashMap<String, ProjectedTable> projectedTables = new HashMap<>();
                int c = 0;
                if (metadataProjects.size() > 0) {
                    MetadataProject project = metadataProjects.get(c);
//                    String skala = new SkalaConverter().convertSkala(project.getSkala());
//                    System.out.println("SKala project " + skala);
                    //selected combo index 1 (0 position)
                    int position = comboBoxProject.getSelectedIndex();
                    ArrayList<String> unsurs = metadataProjects.get(position).getTableNames();
                    Collections.sort(unsurs);
                    for (String string : unsurs) {
                        ProjectedTable projectedTable1 = new ProjectedTable();
                        projectedTable1.setIsSelected(false);
                        projectedTable1.setIsValid(false);
                        projectedTable1.setIsDataBesar(false);
                        projectedTable1.setName(string);
                        projectedTable1.setNamaSkema(configurationSumber.getUsername());
                        projectedTable1.setStatus("Nama unsur tidak valid, periksa kembali data yang ada di dalam METADATA.MD_FORMAT.SPESIFICATION");
                        for (Map.Entry<String, Mapping> entry : mapping.entrySet()) {
                            String key1 = entry.getKey();
                            Mapping value = entry.getValue();
//                            System.out.println(value.getSkala());
//                            System.out.println(configurationSumber.getUsername() + " === " + value.getSkemaSumber());
                            if (value.getSkemaSumber().trim().equalsIgnoreCase(configurationSumber.getUsername().trim())) {
                                if (key1.split("-")[1].equalsIgnoreCase(string)) {
//                                    if (value.getSkala().equalsIgnoreCase(skala)) {
                                    projectedTable1.setIsSelected(true);
                                    projectedTable1.setIsValid(true);
                                    projectedTable1.setStatus("OK");
                                    projectedTable1.setMapping(value);
                                    projectedTable1.setFileIdetifier(metadataProjects.get(c).getFileIdetifier());
                                    projectMapping.put(key1, value);
//                                    }

                                }
                            }
                        }
                        projectedTables.put(string, projectedTable1);
                    }
                    c++;
                }

                TreeMap<String, ProjectedTable> sorted = new TreeMap<>(projectedTables);
                Set<Map.Entry<String, ProjectedTable>> mappings = sorted.entrySet();

                setXTableValue(mappings);
            }

        };
        worker.execute();

    }

    public HashMap<String, Project> readExcelProject(String path) {
        try {
            ExcelReader excelReader = new ExcelReader();
            return excelReader.getProjectFromExcel(path);

        } catch (IOException ex) {
            Logger.getLogger(MigrasiSdeToSdoSpecialCase.class
                    .getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public void setXTableValue(Set<Map.Entry<String, ProjectedTable>> projectedTable) {
        Thread t = new Thread(() -> {
            unsurs = new ArrayList<>();
            for (Map.Entry<String, ProjectedTable> entry : projectedTable) {
                String key = entry.getKey();
//                System.out.println("Key " + key);
                ProjectedTable value = entry.getValue();
                unsurs.add(projectedTableToUnsur(value));
            }
            updateTable(projectedTable.size());
//             comboBoxProject.setEnabled(false);
//              buttonMigrasi.setEnabled(false);
            updateFreezeViews(true);
        });

        t.start();
    }

    private Unsur projectedTableToUnsur(ProjectedTable value) {
//        System.out.println("Value " + value.getName());
        Unsur unsur = new Unsur();
        unsur.setSelected(value.isIsSelected());
        unsur.setValid(value.isIsValid());
        unsur.setMapping(value.getMapping());
        unsur.setStatus(value.getStatus());
        unsur.setIsDataBesar(value.isIsDataBesar());
        unsur.setNamaSkema(value.getNamaSkema());
        unsur.setName(value.getName());
        unsur.setFielIdentifier(value.getFileIdetifier());
        return unsur;
    }

    public void setTableValue(boolean isSelected, Set<Map.Entry<String, Mapping>> mappings) {
        Thread t = new Thread(() -> {
            unsurs = new ArrayList<>();

            for (Map.Entry<String, Mapping> entry : mappings) {
                String key = entry.getKey();
                Mapping value = entry.getValue();
                Unsur unsur = new Unsur();
                unsur.setName(key);
                unsur.setSelected(false);
                unsur.setValid(false);
                unsur.setMapping(value);
                unsur.setStatus("Nama unsur tidak valid, periksa kembali data yang ada di dalam METADATA.MD_FORMAT.SPESIFICATION");
                if (value.getSkemaSumber().equalsIgnoreCase(configurationSumber.getUsername())) {
                    unsur.setSelected(true);
                    unsur.setValid(true);
                    unsur.setStatus("OK");
                }

                unsurs.add(unsur);
            }
            updateTable(mappings.size());
        });

        t.start();
    }

    private void updateTable(int size) {
        tabelMapping.removeAll();

        DefaultTableModel dtm = (DefaultTableModel) tabelMapping.getModel();
        dtm.setRowCount(size);
        tabelMapping.setModel(dtm);

        int i = 0;
        for (Unsur unsur : unsurs) {
            tabelMapping.getModel().setValueAt(unsur.isSelected(), i, 0);
            tabelMapping.getModel().setValueAt(unsur.getName(), i, 1);
//            tabelMapping.getModel().setValueAt(unsur.getName(), i, 1);
            tabelMapping.getModel().setValueAt(unsur.getStatus(), i, 3);
            i++;

        }

        textPaneLog.setText("");
    }

}
