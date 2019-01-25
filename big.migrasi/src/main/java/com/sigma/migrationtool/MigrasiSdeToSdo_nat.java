/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigma.migrationtool;

import com.esri.core.geometry.SpatialReference;
import com.esri.core.geometry.ogc.OGCGeometry;
import com.esri.core.geometry.ogc.OGCLineString;
import com.esri.core.geometry.ogc.OGCMultiLineString;
import com.esri.core.geometry.ogc.OGCMultiPoint;
import com.esri.core.geometry.ogc.OGCMultiPolygon;
import com.esri.core.geometry.ogc.OGCPoint;
import com.esri.core.geometry.ogc.OGCPolygon;
import com.sigma.migrationtool.listener.DataChangedLIstener;
import com.sigma.migrationtool.bkp.MigrasiBigPanel;
import com.sigma.big.controller.DatabaseController;
import com.sigma.big.model.db.Attributes;
import com.sigma.big.model.db.DBConConfiguration;
import com.sigma.big.model.db.Mapping;
import com.sigma.big.model.db.Project;
import com.sigma.big.tools.AnimatedIcon;
import com.sigma.big.tools.DatabaseTool;
import com.sigma.big.tools.ExcelReader;
import com.sigma.big.tools.GeometryTool;
import com.sigma.big.tools.LogWriter;
import com.sigma.big.tools.MetadataProject;
import com.sigma.big.tools.ProjectedTable;
import com.sigma.big.tools.TextIcon;
import com.sigma.big.tools.Unsur;
import com.sigma.big.tools.ValidationTool;
import com.sigma.big.utils.Activity;
import com.sigma.big.utils.ConverterUtil;
import com.sigma.big.utils.WktWkbUtil;
import com.sigma.bigmigrasi.db.FieldOfTable;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.MultiPolygon;
import com.vividsolutions.jts.io.ParseException;
import com.vividsolutions.jts.io.oracle.OraWriter;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import javax.swing.event.TableModelEvent;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.text.DefaultCaret;
import oracle.jdbc.OracleConnection;
import oracle.spatial.geometry.JGeometry;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

/**
 *
 * @author Ridho
 */
public class MigrasiSdeToSdo_nat extends javax.swing.JPanel implements Activity {

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
    final int batchSize = 1000;
    final int pageSize = 2000;
    String mySRID = "4326";
    int SRID_4326 = 4326;
    int progressPosition = 0;

    ArrayList<Unsur> unsurs;
//  String defaultMappingPath = "C:/migrasi/data/mapping_produksi/mapping.xls";
    String defaultMappingPath = "";
    ArrayList<MetadataProject> metadataProjects;
//  h.denominator as SKALA, 
    String sql = "select a.title, c.FILEIDENTIFIER, d.SPECIFICATION from METADATA.ci_citation a "
            + "join METADATA.md_identification b on a.md_identificationid = b.id "
            + "join METADATA.md_metadata c on b.MD_METADATAID = c.id "
            + "join METADATA.md_format d on b.id = d.MD_IDENTIFICATIONID ORDER BY c.FILEIDENTIFIER ASC";

    String currentFileIdentifier = "";

    /**
     * Creates new form MigrasiSdeToSdo
     */
    public MigrasiSdeToSdo_nat() {

        initComponents();
        DefaultCaret caret = (DefaultCaret) textPaneLog.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);

        validationTool = new ValidationTool();
        Color customGreen = new Color(39, 139, 80);
//      Color backgroundColor = new Color(200, 50, 120);
        jProgressBar1.setForeground(customGreen);
//      jProgressBar1.setBackground(backgroundColor);
        jProgressBar2.setForeground(customGreen);
        jProgressBar1.setUI(new MyProgressUI());
        jProgressBar2.setUI(new MyProgressUI());

        radioButtonProject.setSelected(true);
        checkBoxSemua.setSelected(true);
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
        radioButtonDBSemua = new javax.swing.JRadioButton();
        checkBoxSemua = new javax.swing.JCheckBox();
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
        jLabel2 = new javax.swing.JLabel();

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
                "Pilih", "Unsur", "Data Besar", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.String.class, java.lang.Boolean.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, true, true
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
            tabelMapping.getColumnModel().getColumn(2).setResizable(false);
            tabelMapping.getColumnModel().getColumn(2).setPreferredWidth(5);
            tabelMapping.getColumnModel().getColumn(3).setPreferredWidth(250);
        }

        radioButtonProject.setText("Project");
        radioButtonProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioButtonProjectActionPerformed(evt);
            }
        });

        radioButtonDBSemua.setText("Database / Semua");
        radioButtonDBSemua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioButtonDBSemuaActionPerformed(evt);
            }
        });

        checkBoxSemua.setText("Pilih semua");
        checkBoxSemua.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                checkBoxSemuaItemStateChanged(evt);
            }
        });
        checkBoxSemua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxSemuaActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Koneksi Development"));

        buttonKoneksiDBDev.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon_dbcon_25x.png"))); // NOI18N
        buttonKoneksiDBDev.setText("Koneksi DB Development");
        buttonKoneksiDBDev.setMaximumSize(new java.awt.Dimension(178, 41));
        buttonKoneksiDBDev.setMinimumSize(new java.awt.Dimension(178, 41));
        buttonKoneksiDBDev.setPreferredSize(new java.awt.Dimension(178, 41));
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
                        .addGap(0, 0, Short.MAX_VALUE)))
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
                        .addGap(0, 10, Short.MAX_VALUE)))
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
                        .addComponent(labelStatus)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jProgressBar1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jProgressBar2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buttonMigrasi, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
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
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(radioButtonDBSemua)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(checkBoxSemua)))
                        .addContainerGap())))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(radioButtonDBSemua)
                    .addComponent(checkBoxSemua))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonMigrasi, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelStatus))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void updateFreezeViews() {
        buttonKoneksiDBDev.setEnabled(!processing);
        buttonKoneksiDBProd.setEnabled(!processing);
        buttonMigrasi.setEnabled(!processing);
        comboBoxProject.setEnabled(!processing);
        radioButtonProject.setEnabled(!processing);
        radioButtonDBSemua.setEnabled(!processing);
        checkBoxSemua.setEnabled(!processing);
        buttonAmbilMapping.setEnabled(!processing);
        jButton1.setEnabled(!processing);
    }

    private void updateFreezeViews(boolean isEnable) {
        buttonMigrasi.setEnabled(isEnable);
        comboBoxProject.setEnabled(isEnable);
        radioButtonProject.setEnabled(isEnable);
        radioButtonDBSemua.setEnabled(isEnable);
        checkBoxSemua.setEnabled(isEnable);
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
                        progressPosition = 0;
                        if (unsur.getMapping() != null) {
                            logger.log(LogWriter.INFO, valueProgress + ". MEMIGRASI UNSUR " + unsur.getMapping().getTabelSumber());
//                            String key = entry.getKey();
                            Mapping mapping = unsur.getMapping();
                            if (connSumber.isClosed()) {
                                connSumber = DatabaseTool.getConnection(configurationSumber, logger);
                            }
                            if (DatabaseTool.isTableExists(connSumber, mapping.getTabelSumber())) {
                                String fileIndentifier = metadataProjects.get(comboBoxProject.getSelectedIndex()).getFileIdetifier();
                                bacaDataSumber(mapping, fileIndentifier, unsur.getNamaSkema());
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
                    Logger.getLogger(MigrasiSdeToSdo_nat.class.getName()).log(Level.SEVERE, null, ex);
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

    private void radioButtonDBSemuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioButtonDBSemuaActionPerformed
        // TODO add your handling code here:
        switchRadio(false);
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                textPaneLog.setText("Sedang membaca mapping ..");
                SwingWorker worker = new SwingWorker() {
                    @Override
                    protected Object doInBackground() throws Exception {
                        HashMap<String, Mapping> mappings = null;
                        try {
                            ExcelReader excelReader = new ExcelReader();
                            mappings = excelReader.getMappingFromExcelNew(defaultMappingPath);
                        } catch (IOException ex) {
                            Logger.getLogger(MigrasiSdeToSdo_nat.class
                                    .getName()).log(Level.SEVERE, null, ex);
                        } catch (EncryptedDocumentException ex) {
                            Logger.getLogger(MigrasiSdeToSdo_nat.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (InvalidFormatException ex) {
                            Logger.getLogger(MigrasiSdeToSdo_nat.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        publish(mappings);
                        return mappings;
                    }

                    @Override
                    protected void process(List chunks) {
                        super.process(chunks);
                        HashMap<String, Mapping> data = (HashMap<String, Mapping>) chunks.get(0);
                        TreeMap<String, Mapping> sorted = new TreeMap<>(data);
                        Set<Map.Entry<String, Mapping>> mappings = sorted.entrySet();
                        setTableValue(true, mappings);
                        checkBoxSemua.setSelected(true);
                    }
                };
                worker.execute();
            }
        });
        t.start();
    }//GEN-LAST:event_radioButtonDBSemuaActionPerformed

    private void checkBoxSemuaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_checkBoxSemuaItemStateChanged
        // TODO add your handling code here:
        boolean isSelected = (evt.getStateChange() == 1);
        int row = 0;
        if (unsurs != null) {
            for (Unsur unsur : unsurs) {
                unsur.setSelected(isSelected);
                unsurs.set(row, unsur);
                row++;
            }
            updateTable(unsurs.size());
        }
    }//GEN-LAST:event_checkBoxSemuaItemStateChanged

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

    private void checkBoxSemuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxSemuaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkBoxSemuaActionPerformed

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
            Logger.getLogger(MigrasiSdeToSdo_nat.class
                    .getName()).log(Level.SEVERE, null, ex);

        } catch (SQLException ex) {
            Logger.getLogger(MigrasiSdeToSdo_nat.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return projects;
    }

    public void switchRadio(boolean isProject) {
        radioButtonProject.setSelected(isProject);
        comboBoxProject.setEnabled(isProject);
        radioButtonDBSemua.setSelected(!isProject);
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
                    Connection conn_ = null;
                    boolean isError = false;
                    try {
                        conn_ = DatabaseTool.getConnection(configurationTarget, logger);
//                        conn_.setNetworkTimeout(Executors.newFixedThreadPool(10), TIMEOUT);
                        conn_.setAutoCommit(false);
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

                        int numberRows = getNumberRows(connSumber, mapping.getSkemaSumber(), mapping.getTabelSumber(), fileIdentifier);
//                            logger.log(LogWriter.INFO, "jumlah rows  " + numberRows);
                        jProgressBar2.setMaximum(numberRows);
                        jProgressBar2.setStringPainted(true);
//                            jProgressBar2.setIndeterminate(true);

                        String where_ = (fileIdentifier == null || fileIdentifier.equals("")) ? "" : " WHERE METADATA = \'" + fileIdentifier + "\'";
                        int pages = numberRows / pageSize;
                        int rowMin = 0;
                        if (isDataAlreadyMigrated) {
                            int dialogButton = JOptionPane.YES_NO_OPTION;
                            int dialogResult = JOptionPane.showConfirmDialog(null, "Data sudah pernah dimigrasikan, data sebelumnya akan dihapus. Lanjutkan?", "Konfirmasi", dialogButton);
                            switch (dialogResult) {
                                case JOptionPane.YES_OPTION:

                                    String geomTrype = mapping.getTabelSumber().split("_")[1];
                                    String gTypeSDO = GeometryTool.getGeomCodes(geomTrype);
                                    clearData(conn_, fileIdentifier, mapping.getSkemaTarget(), mapping.getTabelTarget(), gTypeSDO);
                                    logger.log(LogWriter.INFO, "Memproses data dari " + mapping.getTabelSumber() + "...");
                                    String targetSql = DatabaseTool.generateSQLInsertTarget_nat(mapping, commons);
                                    System.out.println(targetSql);
                                    PreparedStatement pstmt = conn_.prepareStatement(targetSql);

                                    for (int page = 0; page <= pages; page++) {
                                        showLoadingAnimation("Mengambil data");
                                        if (connSumber.isClosed()) {
                                            connSumber = DatabaseTool.getConnection(configurationSumber, logger);
                                        }
                                        Statement stmt = connSumber.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                                                ResultSet.CONCUR_READ_ONLY);
                                        if (!commons.contains("OBJECTID")) {
                                            commons.add("OBJECTID");
                                        }
                                        int rowMax = rowMin + pageSize;
                                        String sql = DatabaseTool.generateSQLGetSourceWithPaging(namaSkema, mapping, logger, commons, fileIdentifier, where_, rowMin, rowMax);

                                        System.out.println("");
                                        System.out.println(sql);
                                        ResultSet rs = stmt.executeQuery(sql);
                                        try {
                                            migrasiToSdo(conn_, pstmt, mapping, commons, rs, page, pages);
                                        } catch (ParseException ex) {
                                            conn_.close();
                                            Logger.getLogger(MigrasiSdeToSdo_nat.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                        rs.close();
                                        stmt.close();
                                        connSumber.close();
                                        rowMin = rowMax;
                                    }
                                    pstmt.close();
                                    break;

                                case JOptionPane.NO_OPTION:
                                    break;
                                default:
                                    break;
                            }
                        } else {
                            logger.log(LogWriter.INFO, "Memproses data dari " + mapping.getTabelSumber() + "...");

                            String targetSql = DatabaseTool.generateSQLInsertTarget_nat(mapping, commons);
                            System.out.println(targetSql);
                            PreparedStatement pstmt = conn_.prepareStatement(targetSql);
                            for (int page = 0; page <= pages; page++) {
                                if (connSumber.isClosed()) {
                                    connSumber = DatabaseTool.getConnection(configurationSumber, logger);
                                }
                                Statement stmt = connSumber.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                                        ResultSet.CONCUR_READ_ONLY);
                                if (!commons.contains("OBJECTID")) {
                                    commons.add("OBJECTID");
                                }
                                int rowMax = rowMin + pageSize;
                                String sql = DatabaseTool.generateSQLGetSourceWithPaging(namaSkema, mapping, logger, commons, fileIdentifier, where_, rowMin, rowMax);

                                System.out.println("");
                                System.out.println(sql);
                                ResultSet rs = stmt.executeQuery(sql);
                                try {
                                    println("SQL INSERT : " + targetSql);
                                    migrasiToSdo(conn_, pstmt, mapping, commons, rs, page, pages);

                                } catch (ParseException ex) {
                                    conn_.close();
                                    hideLoadingAnimation();
                                    Logger.getLogger(MigrasiSdeToSdo_nat.class.getName()).log(Level.SEVERE, null, ex);
                                }
//                                rs.close();
//                                stmt.close();
                                connSumber.close();
                                rowMin = rowMax;
                                if ((page * pageSize % 1000 == 0) && (pages > 0)) {
                                    showLoadingAnimation("Commit data");
                                    println("Commit data at " + (page * pageSize));
                                    conn_.commit();
                                }
                            }
                            hideLoadingAnimation();
//                            pstmt.close();
                        }

//                        stmt.close();
//                            GUNAKAN AUTO COMMIT
//                            logger.log(LogWriter.INFO, "Transaksi commit");
                        showLoadingAnimation("Commit data");
                        println("Commit data  ");
                        conn_.commit();
                        hideLoadingAnimation();
                    } catch (SQLException e) {
                        isError = true;
                        updateFreezeViews();
                        hideLoadingAnimation();
                        logger.log(LogWriter.ERROR, e.getMessage());
                        e.printStackTrace();
                        isErroReading = true;
                    }

//                    if (conn_ != null && !isError) {
//                        Statement stmt_ = conn_.createStatement();
//                        ConverterUtil converter = new ConverterUtil();
//                        String bBox = "";
//                        try {
//                            bBox = converter.getBoundingBox(stmt_, mapping.getSkemaTarget(), mapping.getTabelTarget());
//                        } catch (Exception e) {
//
//                        }
//                        updateMetadataView(conn_, stmt_, bBox, mySRID, mapping.getTabelTarget());
//                        createSpatialIndex(conn_, stmt_, mapping.getSkemaTarget(), mapping.getTabelTarget());
//                    }
                }
            } else {
                Logger.getLogger(MigrasiBigPanel.class
                        .getName()).log(Level.WARNING, null, "Attribut tidak sesuai");
                logger.log(LogWriter.WARNING, "Attribut tidak sesuai");
            }
        } catch (IOException | SQLException ex) {
            hideLoadingAnimation();
            updateFreezeViews();
            Logger.getLogger(MigrasiBigPanel.class
                    .getName()).log(Level.SEVERE, null, ex);
            try {
                logger.log(LogWriter.ERROR, "Error " + ex.getMessage());
            } catch (IOException ex1) {
                Logger.getLogger(MigrasiSdeToSdo_nat.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }

    private void clearData(Connection con, String metadata, String skema, String unsur, String geomCodeSDO) throws IOException {
        try {
            Statement stmt = con.createStatement();
            String sql = "DELETE FROM " + skema + "." + unsur + " a WHERE METADATA ='" + metadata + "' AND a.SHAPE.GET_GTYPE() IN " + geomCodeSDO;
            stmt.executeUpdate(sql);

            logger.log(LogWriter.INFO, "Menghapus data : " + unsur + ", metadata : " + metadata + ", geom type: " + geomCodeSDO);
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(MigrasiSdeToSdo_nat.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void updateMetadataView(Connection conn_, Statement stmt, String bBox, String SRID, String namaUnsur) {
        try {
            String mSql = "SELECT * FROM MDSYS.user_sdo_geom_metadata WHERE TABLE_NAME=\'" + namaUnsur + "\'";
            println("SQL " + mSql);
            ResultSet rs = stmt.executeQuery(mSql);
            boolean isExist = false;
            while (rs.next()) {
                isExist = true;
            }
            if (isExist) {
                String sql = "UPDATE MDSYS.user_sdo_geom_metadata set TABLE_NAME ='" + namaUnsur + "' , COLUMN_NAME = 'shape', "
                        + "DIMINFO = " + bBox + ", SRID = " + SRID + " WHERE TABLE_NAME='" + namaUnsur + "'";
                stmt.execute(sql);
                println("SQL " + sql);
                conn_.commit();
            } else {
                String sql = "INSERT INTO MDSYS.user_sdo_geom_metadata (TABLE_NAME, COLUMN_NAME, DIMINFO, SRID) "
                        + "  VALUES ('" + namaUnsur + "','shape', " + bBox + ","
                        + " " + SRID + ")";
                stmt.execute(sql);
                println("SQL " + sql);
                conn_.commit();
            }

        } catch (SQLException ex) {
            try {
                logger.log(LogWriter.WARNING, ex.getMessage());
            } catch (IOException ex1) {
                Logger.getLogger(MigrasiSdeToSdo_nat.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }

    private void createSpatialIndex(Connection conn_, Statement stmt, String namaSkema, String namaUnsur) {
        try {
            ResultSet rs = stmt.executeQuery("select * from USER_SDO_INDEX_INFO WHERE INDEX_NAME = '" + namaUnsur + "_SPATIAL_IDX' AND TABLE_OWNER='" + namaSkema + "'");
            boolean isExist = false;
            while (rs.next()) {
                isExist = true;
            }
            if (!isExist) {
                stmt.execute("CREATE INDEX " + namaUnsur + "_spatial_idx ON " + namaSkema + "." + namaUnsur + "(SHAPE) INDEXTYPE IS MDSYS.SPATIAL_INDEX");
            }
            conn_.commit();
        } catch (SQLException ex) {
            try {
                logger.log(LogWriter.WARNING, ex.getMessage());
            } catch (IOException ex1) {
                Logger.getLogger(MigrasiSdeToSdo_nat.class.getName()).log(Level.SEVERE, null, ex1);
            }
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

        stm.close();
        return objectIds;
    }

    private int getNumberRows(Connection con, String skema, String table, String fileIdentifier) throws SQLException {
        Statement stm = con.createStatement();
        String sql = DatabaseTool.getNumberRows(skema, table, fileIdentifier);
        ResultSet rs = stm.executeQuery(sql);
        int rows = 0;
        if (rs.next()) {
            rows = rs.getInt("CNT");
        }
        rs.close();
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
        rs.close();
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

    public void migrasiToSdo(Connection conn, PreparedStatement preparedStmt, Mapping mapping, ArrayList<String> common_, ResultSet rs, int bactch, int bactchNumber) throws IOException, SQLException, ParseException {
        ArrayList<String> common = common_;
//        if (conn != null) {
        ValidationTool v = new ValidationTool();
        boolean isFCodeValid = true;
        ConverterUtil converter = new ConverterUtil();
        while (rs.next()) {
            progressPosition++;
            jProgressBar2.setValue(progressPosition);
            int c = 1;
            boolean isShapeNull = false;
            int objectID = 0;
            for (String columnName : common) {
                Attributes attrMapping = mapping.getAttributes().get(columnName);
                boolean isDomain = attrMapping.isIsDomain();
//                String TIPE_GEOMETRY = rs.getString("GEOMTYPE");
//                TIPE_GEOMETRY = TIPE_GEOMETRY.split("_")[1];
                if (columnName.equalsIgnoreCase("SHAPE")) {
//                        println(c + " " + columnName);
                    if (rs.getBytes(columnName) != null) {
                        byte[] shapeData = (byte[]) rs.getBytes(columnName);
//                        String wkt = rs.getString(columnName);
//                        if (!wkt.contains(TIPE_GEOMETRY)) {
//                            wkt = TIPE_GEOMETRY + " ZM " + wkt;
//                        }
//                        println("wkt : " + wkt);
                        WktWkbUtil util = new WktWkbUtil();
//                        com.esri.core.geometry.Geometry g = util.fromWkt(wkt);
//                        byte[] shapeData = util.toWkb(g);
                        ByteBuffer buffer = ByteBuffer.wrap(shapeData);

                        if (buffer.array().length > 0) {
                            com.esri.core.geometry.Geometry g = util.fromWkb(shapeData);
                            SpatialReference sr = SpatialReference.create("4326");
                            OGCGeometry geomOgc = OGCGeometry.createFromEsriGeometry(g, sr);
//                            println("TYPE: " + geomOgc.geometryType() + " DIM : " + geomOgc.coordinateDimension());
                            JGeometry jGeom = null;
                            MultiPolygon multipolygon = null;
                            if (geomOgc.geometryType().equalsIgnoreCase("POINT")) {
                                jGeom = converter.esriOgcPointToJGeometry((OGCPoint) geomOgc);
                            } else if (geomOgc.geometryType().equalsIgnoreCase("MULTLIPOINT")) {
                                jGeom = converter.esriOgcMultiPointToJGeometry((OGCMultiPoint) geomOgc);
                            } else if (geomOgc.geometryType().equalsIgnoreCase("LINESTRING")) {
                                jGeom = converter.esriOgcLineStringtoJGeometry((OGCLineString) geomOgc);
                            } else if (geomOgc.geometryType().equalsIgnoreCase("MULTILINESTRING")) {
                                jGeom = converter.esriOgcMultiLineStringtoJGeometry((OGCMultiLineString) geomOgc);
                            } else if (geomOgc.geometryType().equalsIgnoreCase("POLYGON")) {
                                jGeom = converter.esrOgcPolygonToPolygon((OGCPolygon) geomOgc);
                            } else if (geomOgc.geometryType().equalsIgnoreCase("MULTIPOLYGON")) {
                                multipolygon = converter.esrOgcMultiPolygonToPolygon((OGCMultiPolygon) geomOgc);
                            }
                            if (geomOgc.geometryType().equalsIgnoreCase("MULTIPOLYGON")) {
                                OraWriter writer = new OraWriter();
                                Geometry ge = multipolygon.getFactory().createGeometry(multipolygon);
                                ge.setSRID(SRID_4326);
                                mySRID = String.valueOf(multipolygon.getSRID());
                                try {
//                                    println("==============> geomOgc SRID " + geomOgc.SRID());
//                                    println("==============> multipolygon SRID " + multipolygon.getSRID());
//                                    println("==============> SRID " + ge.getSRID());
                                    preparedStmt.setObject(c, writer.write(ge, (OracleConnection) conn));
                                } catch (SQLException e) {
                                    isShapeNull = true;
                                    logger.log(LogWriter.ERROR, e.getMessage());
                                }

                            } else {
                                jGeom.setSRID(SRID_4326);
//                                println("==============> SRID " + jGeom.getSRID());
//                                mySRID = String.valueOf(jGeom.getSRID());
                                try {
                                    preparedStmt.setObject(c, JGeometry.store(jGeom, conn));
                                } catch (SQLException e) {
                                    isShapeNull = true;
                                    logger.log(LogWriter.ERROR, e.getMessage());
                                }

                            }
                        } else {
                            isShapeNull = true;
                            logger.log(LogWriter.ERROR, "Shape array length = 0");
                        }

                    } else {
                        isShapeNull = true;
                        logger.log(LogWriter.ERROR, "Nilai SHAPE null");
                    }
                } else if (columnName.equalsIgnoreCase("OBJECTID")) {
                    c--;
                    objectID = rs.getInt(columnName.toUpperCase());
                    println("OBJECTID " + objectID);
                } else if (columnName.equalsIgnoreCase("LAT")) {
                    String lat = rs.getString("LAT");
//                    println(lat);
                    if (lat == null) {
                        preparedStmt.setObject(c, null);
                    } else {
                        if (lat.trim().equalsIgnoreCase("null") || lat.trim().equals("")) {
                            preparedStmt.setObject(c, null);
                        } else {
                            preparedStmt.setString(c, lat);
                        }
                    }
                } else if (columnName.equalsIgnoreCase("LON")) {
                    String lon = rs.getString("LON");
//                    println(lon);
                    if (lon == null) {
                        preparedStmt.setObject(c, null);
                    } else {
                        if (lon.trim().equalsIgnoreCase("null") || lon.trim().equals("")) {
                            preparedStmt.setObject(c, null);
                        } else {
                            preparedStmt.setString(c, lon);
                        }
                    }

                } else {
                    if (attrMapping.getDataTypeSumber().equalsIgnoreCase("BLOB")) {
                        Blob colValue = rs.getBlob(columnName.toUpperCase());
                        preparedStmt.setBlob(c, colValue);
                    } //                    else if (attrMapping.getDataTypeSumber().equalsIgnoreCase("CLOB")) {
                    //                        Clob colValue = rs.getClob(columnName.toUpperCase());
                    //                        preparedStmt.setClob(c, colValue);
                    //                    } 
                    else {
                        //                        println(c + " " + columnName);
                        String colValue = rs.getString(columnName.toUpperCase());
                        if (isDomain) {
                            if (colValue == null) {
                                preparedStmt.setString(c, colValue);
                            } else {
                                if (colValue.equals("")) {
                                    if (attrMapping.getDataTypeSumber().equalsIgnoreCase("NUMBER")) {
                                        preparedStmt.setObject(c, null);
                                    } else {
                                        preparedStmt.setString(c, colValue);
                                    }

                                } else if (colValue.equals("null")) {
                                    preparedStmt.setObject(c, null);
                                } else {
                                    //JIKA TIDA REAMRK, MAKA SEMENTARA DOMAIN BENAR SEMUA
                                    //DALAM HAL INI JIKA DOMAIN TIDAK VALID SECARA OTOMATIS ORACLE AKAN ME-REJECT KARENA TIDAK DITEMUKAN RELASI-NYA
                                    boolean isDomainValid = true;
                                    if (isDomainValid) {
                                        preparedStmt.setString(c, colValue);
                                    } else {
                                        preparedStmt.setString(c, colValue);
                                    }
                                }
                            }
                        } else if (columnName.equalsIgnoreCase("FCODE")) {
                            if (v.checkFcodeIsValid(colValue)) {
                                preparedStmt.setString(c, colValue);
                            } else {
                                isFCodeValid = false;
                                println("FCODE tidak valid");
                            }
                        } else if (columnName.equalsIgnoreCase("TGLSURVEI")) {
                            if (colValue != null) {
                                try {
                                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                                    Date date = sdf.parse(colValue);
                                    preparedStmt.setDate(c, new java.sql.Date(date.getTime()));
                                } catch (java.text.ParseException ex) {
                                    Logger.getLogger(MigrasiSdeToSdo_nat.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            } else {
                                preparedStmt.setDate(c, null);
                            }
                        } else {
                            if (attrMapping.getDataTypeSumber().equalsIgnoreCase("date")) {
                                if (colValue != null) {
                                    try {
                                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                                        Date date = sdf.parse(colValue);
                                        preparedStmt.setDate(c, new java.sql.Date(date.getTime()));
                                    } catch (java.text.ParseException ex) {
                                        Logger.getLogger(MigrasiSdeToSdo_nat.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                } else {
                                    preparedStmt.setDate(c, null);
                                }
                            } else {
                                preparedStmt.setString(c, colValue);
                            }
                        }
                    }
                }
                c++;
            }

            if (isShapeNull) {
                logger.log(LogWriter.ERROR, "Object ID " + objectID);
            } else {
                preparedStmt.addBatch();
            }

        }

        showLoadingAnimation("Eksekusi batch " + bactch + " dari " + bactchNumber);
//        logger.log(LogWriter.INFO, "Eksekusi batch " + bactch + " dari " + bactchNumber + "...");
        preparedStmt.executeBatch();
        preparedStmt.clearBatch();

//        }
    }

    private int getRowCount(ResultSet resultSet) {
        int size = 0;
        try {
            resultSet.last();
            size = resultSet.getRow();
            resultSet.beforeFirst();
        } catch (Exception ex) {
            return 0;
        }
        return size;
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
    private javax.swing.JCheckBox checkBoxSemua;
    private javax.swing.JComboBox<String> comboBoxProject;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JRadioButton radioButtonDBSemua;
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
                    Logger.getLogger(MigrasiSdeToSdo_nat.class
                            .getName()).log(Level.SEVERE, null, ex);
                } catch (EncryptedDocumentException ex) {
                    Logger.getLogger(MigrasiSdeToSdo_nat.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InvalidFormatException ex) {
                    Logger.getLogger(MigrasiSdeToSdo_nat.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(MigrasiSdeToSdo_nat.class
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

    private static void println(String message) {
        System.out.println(message);
    }

    private static void print(String message) {
        System.out.print(message);
    }

    AnimatedIcon icon2;

    private void showLoadingAnimation(String text) {
        jLabel2.setText(text);
        jLabel2.setHorizontalTextPosition(JLabel.LEADING);
        icon2 = new AnimatedIcon(jLabel2);
        icon2.setAlignmentX(AnimatedIcon.LEFT);
        icon2.addIcon(new TextIcon(jLabel2, ""));
        icon2.addIcon(new TextIcon(jLabel2, "."));
        icon2.addIcon(new TextIcon(jLabel2, ".."));
        icon2.addIcon(new TextIcon(jLabel2, "..."));
        icon2.addIcon(new TextIcon(jLabel2, "...."));
        icon2.addIcon(new TextIcon(jLabel2, "....."));
        jLabel2.setIcon(icon2);
        icon2.start();
    }

    private void hideLoadingAnimation() {
        if (icon2 != null) {
            icon2.stop();
            jLabel2.setText("");
        }

    }
}
