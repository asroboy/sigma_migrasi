/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigma.migrationtool;

import com.sigma.big.model.db.Attributes;
import com.sigma.migrationtool.listener.DataChangedLIstener;
import com.sigma.big.model.db.DBConConfiguration;
import com.sigma.big.model.db.Mapping;
import com.sigma.big.model.db.Project;
import com.sigma.big.tools.AnimatedIcon;
import com.sigma.big.tools.DatabaseTool;
import com.sigma.big.tools.ExcelReader;
import com.sigma.big.tools.GeometryHelper;
import com.sigma.big.tools.GeometryTool;
import com.sigma.big.tools.LogWriter;
import com.sigma.big.tools.TextIcon;
import com.sigma.big.tools.Unsur;
import com.sigma.big.utils.Activity;
import com.sigma.big.utils.WktWkbUtil;
import com.sigma.migrationtool.publikasi.PythonExecutor;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.io.oracle.OraReader;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.text.DefaultCaret;
import libraries.xml.XmlMetadataWriter;
import oracle.spatial.geometry.JGeometry;
import oracle.sql.STRUCT;

/**
 *
 * @author Ridho
 */
public class MigrasiSdoToSde extends javax.swing.JPanel implements Activity {

//    String defaultMappingPath = "C:/migrasi/data/mapping_publikasi/mapping publikasi_RBI10K_sumatera.xls";
//    String defaultMappingPath = "C:/migrasi/data/mapping_publikasi/MAPPINGGGGGGGGG.xls";
    String defaultMappingPath = "";
    Connection conSumber, conTarget;
    private static final int CONNECTION_SUMBER_CODE = 1;
    private static final int CONNECTION_TARGET_CODE = 2;
    LogWriter logger;
    AnimatedIcon icon2;
    //KEYS
    private final String KEY_NOMOR_PETA = "NOMOR_PETA";
    private final String KEY_FILEINDENTIFIER = "FILEIDENTIFIER";
    private final String KEY_TITLE = "TITLE";
    private final String KEY_NAMA_UNSURS = "SPECIFICATION";
    private final String KEY_NLPS = "SUPLEMENTATIONINFORMATION";
    private final String KEY_DATE = "DATE_";
    private final String KEY_GTYPE = "G_TYPE";

    ArrayList<String> nomorPetas, mNomorPetas;
    ArrayList<Project> namaProject, projects;
    HashMap<String, String> unsurTermigrasi;
    ArrayList<Unsur> unsursHash;
    HashMap<String, ArrayList<String>> nlpListForUnsur;
    private final int batchSize = 1;
    boolean changeCheckBoxStatus = false;
    AddDBConnectionNoSave addDBConnectionDialog;
    DBConConfiguration configurationSumber;
    DBConConfiguration configurationTarget;
    String fileIdentifierBaruRelease;

    /**
     * Creates new form MigrasiSdoToSde
     */
    public MigrasiSdoToSde() {
        initComponents();
        DefaultCaret caret = (DefaultCaret) jTextPaneLog.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);

        checkBoxSemua.setSelected(true);
        Color customGreen = new Color(39, 139, 80);
        jProgressBar1.setForeground(customGreen);
        jProgressBar2.setForeground(customGreen);
        jProgressBar1.setUI(new MyProgressUI());
        jProgressBar2.setUI(new MyProgressUI());

        updateViewsCon1(configurationSumber != null);

        Calendar cal = Calendar.getInstance();
        Date now = cal.getTime();
        cal.add(Calendar.YEAR, -100);
        Date startDate = cal.getTime();
        cal.add(Calendar.YEAR, 300);
        Date endDate = cal.getTime();
        SpinnerDateModel model = new SpinnerDateModel(now, startDate, endDate, Calendar.YEAR);
        spinnerTahunMulai.setModel(model);
        JSpinner.DateEditor d = new JSpinner.DateEditor(spinnerTahunMulai, "yyyy");
        spinnerTahunMulai.setEditor(d);

        SpinnerDateModel model2 = new SpinnerDateModel(now, startDate, endDate, Calendar.YEAR);
        spinnerTahunSampai.setModel(model2);
        JSpinner.DateEditor d2 = new JSpinner.DateEditor(spinnerTahunSampai, "yyyy");
        spinnerTahunSampai.setEditor(d2);
    }

    private void updateViewsCon1(boolean isActive) {
        buttonKoneksiTarget.setEnabled(isActive);
        comboBoxProduk.setEnabled(configurationTarget != null);
        comboBoxSkala.setEnabled(configurationTarget != null);
        buttonBrowse.setEnabled(configurationTarget != null);
        checkBoxSemua.setEnabled(configurationTarget != null);
        buttonMigrasi.setEnabled(configurationTarget != null);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        buttonMigrasi = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelProyek = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabelUnsur = new javax.swing.JTable();
        checkBoxSemua = new javax.swing.JCheckBox();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextPaneLog = new javax.swing.JTextPane();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        comboBoxProduk = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        spinnerTahunMulai = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();
        comboBoxSkala = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        spinnerTahunSampai = new javax.swing.JSpinner();
        buttonJalankanFilter = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabelKoneksiProduksi = new javax.swing.JLabel();
        buttonKoneksiSumber = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabelKoneksiPublikasi = new javax.swing.JLabel();
        buttonKoneksiTarget = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextMapping = new javax.swing.JTextField();
        buttonBrowse = new javax.swing.JButton();
        buttonRefresh = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        statusLabel = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jProgressBar2 = new javax.swing.JProgressBar();

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 632, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1131, Short.MAX_VALUE)
        );

        jScrollPane1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        buttonMigrasi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon_play.png"))); // NOI18N
        buttonMigrasi.setText("MIGRASI");
        buttonMigrasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMigrasiActionPerformed(evt);
            }
        });

        tabelProyek.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Pilih", "Metadata", "Nama Proyek", "Tahun"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tabelProyek);
        if (tabelProyek.getColumnModel().getColumnCount() > 0) {
            tabelProyek.getColumnModel().getColumn(0).setMinWidth(50);
            tabelProyek.getColumnModel().getColumn(0).setPreferredWidth(50);
            tabelProyek.getColumnModel().getColumn(0).setMaxWidth(100);
            tabelProyek.getColumnModel().getColumn(2).setPreferredWidth(100);
            tabelProyek.getColumnModel().getColumn(3).setMinWidth(100);
            tabelProyek.getColumnModel().getColumn(3).setPreferredWidth(100);
            tabelProyek.getColumnModel().getColumn(3).setMaxWidth(150);
        }

        tabelUnsur.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Pilih", "Unsur", "Metadata", "Tahun", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tabelUnsur);
        if (tabelUnsur.getColumnModel().getColumnCount() > 0) {
            tabelUnsur.getColumnModel().getColumn(0).setMinWidth(50);
            tabelUnsur.getColumnModel().getColumn(0).setPreferredWidth(50);
            tabelUnsur.getColumnModel().getColumn(0).setMaxWidth(100);
            tabelUnsur.getColumnModel().getColumn(1).setMinWidth(100);
            tabelUnsur.getColumnModel().getColumn(1).setPreferredWidth(150);
            tabelUnsur.getColumnModel().getColumn(1).setMaxWidth(150);
            tabelUnsur.getColumnModel().getColumn(2).setMinWidth(200);
            tabelUnsur.getColumnModel().getColumn(2).setPreferredWidth(200);
            tabelUnsur.getColumnModel().getColumn(2).setMaxWidth(250);
            tabelUnsur.getColumnModel().getColumn(3).setMinWidth(80);
            tabelUnsur.getColumnModel().getColumn(3).setPreferredWidth(80);
            tabelUnsur.getColumnModel().getColumn(3).setMaxWidth(100);
            tabelUnsur.getColumnModel().getColumn(4).setMinWidth(150);
            tabelUnsur.getColumnModel().getColumn(4).setPreferredWidth(150);
            tabelUnsur.getColumnModel().getColumn(4).setMaxWidth(200);
        }

        checkBoxSemua.setText("Semua");
        checkBoxSemua.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                checkBoxSemuaItemStateChanged(evt);
            }
        });

        jScrollPane3.setViewportView(jTextPaneLog);

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Produk ");

        comboBoxProduk.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "RBI", "LLN", "LPI", "JKG" }));
        comboBoxProduk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxProdukActionPerformed(evt);
            }
        });

        jLabel3.setText("Range tahun");

        jLabel5.setText("Skala");

        comboBoxSkala.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1:5.000", "1:10.000", "1.25.000", "1:100.000", "1:250.000", "1:500.000", "1:1.000.000" }));

        jLabel4.setText("s.d");

        buttonJalankanFilter.setText("Jalankan Filter");
        buttonJalankanFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonJalankanFilterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonJalankanFilter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboBoxProduk, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(comboBoxSkala, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(spinnerTahunMulai, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(32, 32, 32)
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(spinnerTahunSampai, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(comboBoxProduk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(comboBoxSkala, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spinnerTahunMulai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(spinnerTahunSampai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(10, 10, 10)
                .addComponent(buttonJalankanFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setLayout(new java.awt.GridLayout(1, 0));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Koneksi Produksi"));

        jLabelKoneksiProduksi.setText("Koneksi prod.");

        buttonKoneksiSumber.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon_dbcon_25x.png"))); // NOI18N
        buttonKoneksiSumber.setText("Koneksi DB Produksi");
        buttonKoneksiSumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonKoneksiSumberActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonKoneksiSumber, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
                    .addComponent(jLabelKoneksiProduksi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonKoneksiSumber, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelKoneksiProduksi)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.add(jPanel1);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Koneksi Publikasi"));

        jLabelKoneksiPublikasi.setText("Koneksi pub.");

        buttonKoneksiTarget.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon_dbcon_25x.png"))); // NOI18N
        buttonKoneksiTarget.setText("Koneksi DB Publikasi");
        buttonKoneksiTarget.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonKoneksiTargetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonKoneksiTarget, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelKoneksiPublikasi, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonKoneksiTarget, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelKoneksiPublikasi)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.add(jPanel2);

        jLabel2.setText("Pilih mapping");

        buttonBrowse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon_folder.png"))); // NOI18N
        buttonBrowse.setText("Browse");
        buttonBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBrowseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextMapping)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonBrowse, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(buttonBrowse, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jTextMapping, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel2))
        );

        buttonRefresh.setText("Refresh");
        buttonRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRefreshActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon_play.png"))); // NOI18N
        jButton1.setText("MIGRASI ARCPY");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addComponent(jScrollPane4)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(buttonRefresh)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(checkBoxSemua))
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(buttonMigrasi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkBoxSemua)
                    .addComponent(buttonRefresh))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buttonMigrasi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel3);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(statusLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(307, 307, 307))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jProgressBar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(statusLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jProgressBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 641, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 851, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonKoneksiSumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonKoneksiSumberActionPerformed
//        configurationSumber = new DBConConfiguration();
//        configurationSumber.setHost("192.168.210.195");
//        configurationSumber.setPort(1521);
//        configurationSumber.setSid("dbprod");
//        configurationSumber.setUsername("system");
//        configurationSumber.setPassword("oracle");
//        configurationSumber.setHost("virtua.co.id");
//        configurationSumber.setPort(1522);
//        configurationSumber.setSid("igsver2");
//        configurationSumber.setUsername("system");
//        configurationSumber.setPassword("Virtua2017");
        setConnection(CONNECTION_SUMBER_CODE);
    }//GEN-LAST:event_buttonKoneksiSumberActionPerformed

    private void buttonKoneksiTargetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonKoneksiTargetActionPerformed
//        configurationTarget = new DBConConfiguration();
//        configurationTarget.setHost("localhost");
//        configurationTarget.setPort(1521);
//        configurationTarget.setSid("migrasisde");
//        configurationTarget.setUsername("PUBLIKASI");
//        configurationTarget.setPassword("PUBLIKASI");
        setConnection(CONNECTION_TARGET_CODE);
    }//GEN-LAST:event_buttonKoneksiTargetActionPerformed

    private void buttonMigrasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMigrasiActionPerformed
        doMigrasiData();
    }//GEN-LAST:event_buttonMigrasiActionPerformed

    private String generateMetadataBaru() throws IOException, ParseException {
        String projectName = comboBoxProduk.getSelectedItem().toString();
        String skala = comboBoxSkala.getSelectedItem().toString();
        String skalaNoPembanding = comboBoxSkala.getSelectedItem().toString().split(":")[1];
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        SimpleDateFormat formatterZ = new SimpleDateFormat("EEE MMM dd hh:mm:ss zzz yyyy");
        Date from = formatterZ.parse(spinnerTahunMulai.getValue().toString());
        Date to = formatterZ.parse(spinnerTahunSampai.getValue().toString());
        String mulaiSampai = getTahunMulaiTahunSampai();
        String tahunMulai = mulaiSampai.split("-")[0];
        String tahunSampai = mulaiSampai.split("-")[1];

        String fileIdentifierBaru = projectName + skalaNoPembanding.replace(".", "") + tahunMulai + tahunSampai; //+ "GEN" + new Date().getTime();
        String title = projectName + " " + skala + " " + mulaiSampai;

        String listFileIdentifier = "";
        for (Project project : projects) {
            if (project.isIsSelected()) {
                listFileIdentifier += project.getFileIdentifier() + ", ";
            }
        }

        XmlMetadataWriter xmlMetadataWriter = new XmlMetadataWriter(fileIdentifierBaru, title, listFileIdentifier);
        xmlMetadataWriter.write();

        logger.log(LogWriter.INFO, "metadata " + fileIdentifierBaru);
        return fileIdentifierBaru;
    }

    private String getTahunMulaiTahunSampai() {
        int[] tahuns = new int[projects.size()];
        int i = 0;
        for (Project project : projects) {
            tahuns[i] = project.getTahun();
            i++;
        }
        return getMinValue(tahuns) + "-" + getMaxValue(tahuns);
    }

    // getting the maximum value
    public static int getMaxValue(int[] array) {
        int maxValue = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > maxValue) {
                maxValue = array[i];
            }
        }
        return maxValue;
    }

// getting the miniumum value
    public static int getMinValue(int[] array) {
        int minValue = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < minValue) {
                minValue = array[i];
            }
        }
        return minValue;
    }

    private void doMigrasiData() {

        freezeViews();
        nlpListForUnsur = null;
        jTextPaneLog.setText("");
        Thread t = new Thread(() -> {
            try {
                logger = new LogWriter("MIGRASI_PROD-PUB");
                logger.writeToTextArea(jTextPaneLog);
                logger.log(LogWriter.INFO, "Memulai migrasi");
                logger.log(LogWriter.INFO, "Generate metadata ...");

                fileIdentifierBaruRelease = generateMetadataBaru();

                unsurTermigrasi = new HashMap<>();
                conSumber = DatabaseTool.getConnection(configurationSumber, logger);

                int v = 0;
                ArrayList<Unsur> selectedUnsurs = getSelectedUnsur();
                jProgressBar2.setMaximum(selectedUnsurs.size());
                for (Unsur unsur : selectedUnsurs) {
                    //TEST ADMINISTRASI AJAH
                    //if (unsur.getName().equalsIgnoreCase("ADMINISTRASI")) {
                    if (unsur.getProductionMappings().size() > 0) {
                        println("HAS MAPPING");
                        println("Migrasi unsur " + unsur.getName() + " tahun " + unsur.getTahun());
                        logger.log(LogWriter.INFO, "Migrasi unsur " + unsur.getName() + " tahun " + unsur.getTahun());
                        logger.log(LogWriter.INFO, "Metadata " + unsur.getFielIdentifier());
                        //Menghintung Jumlah Row
                        //int jumlahROw = hitungJumlahRow(unsur);
                        //jProgressBar1.setMaximum(jumlahROw);
                        //MENGAMBIL DATA BERDASARKAN METADATA
                        ambilDataSumber(unsur);
                    } else {
                        logger.log(LogWriter.WARNING, "Unsur " + unsur.getName() + " tidak termapping");
                    }
//                    }
                    v++;
                    jProgressBar2.setValue(v);
                }

                if (!conSumber.isClosed()) {
                    conSumber.close();
                }
                if (conTarget != null) {
                    if (!conTarget.isClosed()) {
                        conTarget.close();
                    }
                }

                logger.log(LogWriter.INFO, "Selesai");
                deFreezeViews();
            } catch (IOException | SQLException ex) {
                deFreezeViews();
                try {
                    logger.log(LogWriter.ERROR, "Error :" + ex);
                } catch (IOException ex1) {
                    Logger.getLogger(MigrasiSdoToSde.class.getName()).log(Level.SEVERE, null, ex1);
                }

            } catch (ParseException ex) {
                deFreezeViews();
                Logger.getLogger(MigrasiSdoToSde.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        t.start();

    }

    //Mneghapus nomor peta nasional yang tidak dipakai
    private ArrayList<String> getNlpOfUnsur(Unsur unsur, Mapping mapping) throws SQLException, IOException {
        logger.log(LogWriter.INFO, "Mengambil nomor peta nlp..");
        String geomType = mapping.getTabelTarget().split("_")[1].trim();
        insertIntoTempTable(geomType, unsur.getFielIdentifier(), mapping.getSkemaSumber(), unsur.getName());

        showLoadingAnimation("Mohon tunggu");
        Statement stmt = conSumber.createStatement();
        String sql = DatabaseTool.generateSQLGetNlp(unsur, geomType, GeometryTool.getSkala(comboBoxSkala.getSelectedItem().toString()));
        println("------- MENGAMBIL NLP ------");
        println(sql);
        println("");
        ResultSet rs = stmt.executeQuery(sql);
        ArrayList<String> nlps = new ArrayList<>();
        while (rs.next()) {
            String nl = rs.getString(KEY_NOMOR_PETA);
            nlps.add(nl);
            showLoadingAnimation("Mengumpulkan values");
        }
        rs.close();
        stmt.close();
        hideLoading();
        return nlps;
    }

    private void insertIntoTempTable(String geomType, String fileIdentifier, String namaSkema, String namaUnsur) throws SQLException, IOException {
        conSumber.setAutoCommit(false);
        String sql = DatabaseTool.generateSqlInsertIntoTempTable(geomType, fileIdentifier, namaSkema, namaUnsur);
        println("------- INSERT INTO TEMP TABLE ------");
        println(sql);

        truncateTempDataPT(conSumber.createStatement());
        if (checkSpatialIndexTempDataPT(conSumber.createStatement()) > 0) {
            dropSpatialIndexTempDataPt(conSumber.createStatement());
        }
        deleteUserGeomTempDataPT(conSumber.createStatement());
        conSumber.createStatement().execute(sql);
        insertBoundingBoxForTempDataPT(conSumber.createStatement(), getDimTempDataPT(conSumber.createStatement()));
        createSpatialIndexTempDataPt(conSumber.createStatement());

    }

    private void insertBoundingBoxForTempDataPT(Statement stmt, int dim) throws SQLException, IOException {

        String sql = "INSERT INTO USER_SDO_GEOM_METADATA \n"
                + "  VALUES (\n"
                + "  'TEMP_DATA_PT',\n"
                + "   'SHAPE',\n"
                + "  MDSYS.SDO_DIM_ARRAY(   -- 20X20 grid\n"
                + "         MDSYS.SDO_DIM_ELEMENT('X',771714.9991,806240.9682,0.005),\n"
                + "         MDSYS.SDO_DIM_ELEMENT('Y',9232266.5412,9255499.1612,0.005)\n"
                + "         \n"
                + "     ),\n"
                + "  4326   -- SRID\n"
                + ")";
        if (dim == 3) {
            changeDimenstionTempDataPT(stmt);
        }
        println(sql);
        stmt.execute(sql);
        conSumber.commit();
        stmt.close();
    }

    private void changeDimenstionTempDataPT(Statement stmt) throws SQLException, IOException, IOException {
        String sql = "SELECT SDO_ROWID, SHAPE FROM IGD.TEMP_DATA_PT";
        String sqlUpdate = "UPDATE IGD.TEMP_DATA_PT SET SHAPE=? WHERE SDO_ROWID=?";
        PreparedStatement pstmt = conSumber.prepareStatement(sqlUpdate);
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            JGeometry geometry = JGeometry.load((STRUCT) rs.getObject("SHAPE"));
            GeometryHelper helper = new GeometryHelper();
            String rowID = rs.getString("SDO_ROWID");
            geometry = helper.changeDimension(rowID, geometry, logger);

            pstmt.setObject(1, JGeometry.store(geometry, conSumber));
            pstmt.setString(2, rowID);
            pstmt.addBatch();
        }
        pstmt.executeBatch();
        conSumber.commit();
        pstmt.close();
    }

    private void truncateTempDataPT(Statement stmt) throws SQLException {
        String sql = "truncate table igd.temp_data_pt";
        println(sql);
        stmt.execute(sql);
        conSumber.commit();
        stmt.close();
    }

    private void deleteUserGeomTempDataPT(Statement stmt) throws SQLException {
        String sql = "delete from mdsys.USER_SDO_GEOM_METADATA where table_name = 'TEMP_DATA_PT'";
        println(sql);
        stmt.execute(sql);
        conSumber.commit();
        stmt.close();
    }

    private void createSpatialIndexTempDataPt(Statement stmt) throws SQLException {
        String sql = "CREATE INDEX TEMP_DATA_SPATIAL_IDX ON TEMP_DATA_PT(SHAPE) INDEXTYPE IS MDSYS.SPATIAL_INDEX";
        println(sql);
        stmt.execute(sql);
        conSumber.commit();
        stmt.close();

    }

    private int getDimTempDataPT(Statement stmt) throws SQLException {
        String sql = "select  distinct c.shape.get_dims() as dim from  igd.temp_data_pt c";
        println(sql);
        ResultSet rs = stmt.executeQuery(sql);
        int dim = 2;
        while (rs.next()) {
            dim = rs.getInt("dim");
        }
        conSumber.commit();
        stmt.close();
        return dim;
    }

    private int checkSpatialIndexTempDataPT(Statement stmt) throws SQLException {
        String sql = "select  count(*) as count from  dba_ind_columns where index_name = 'TEMP_DATA_SPATIAL_IDX'";
        println(sql);
        ResultSet rs = stmt.executeQuery(sql);
        int number = 0;
        while (rs.next()) {
            number = rs.getInt("count");
        }
        conSumber.commit();
        stmt.close();
        return number;
    }

    private void dropSpatialIndexTempDataPt(Statement stmt) throws SQLException {
        String sql = "DROP INDEX TEMP_DATA_SPATIAL_IDX";
        println(sql);
        stmt.execute(sql);
        conSumber.commit();
        stmt.close();
    }

    private void freezeViews() {
        buttonKoneksiSumber.setEnabled(false);
        buttonKoneksiTarget.setEnabled(false);
        jTextMapping.setEnabled(false);
        buttonBrowse.setEnabled(false);
        comboBoxProduk.setEnabled(false);
        comboBoxSkala.setEnabled(false);
        spinnerTahunMulai.setEnabled(false);
        spinnerTahunSampai.setEnabled(false);
        buttonJalankanFilter.setEnabled(false);
        buttonRefresh.setEnabled(false);
        checkBoxSemua.setEnabled(false);
        buttonMigrasi.setEnabled(false);
        tabelProyek.setEnabled(false);
        tabelUnsur.setEnabled(false);
    }

    private void deFreezeViews() {
        buttonKoneksiSumber.setEnabled(true);
        buttonKoneksiTarget.setEnabled(true);
        jTextMapping.setEnabled(true);
        buttonBrowse.setEnabled(true);
        comboBoxProduk.setEnabled(true);
        comboBoxSkala.setEnabled(true);
        spinnerTahunMulai.setEnabled(true);
        spinnerTahunSampai.setEnabled(true);
        buttonJalankanFilter.setEnabled(true);
        buttonRefresh.setEnabled(true);
        checkBoxSemua.setEnabled(true);
        buttonMigrasi.setEnabled(true);
        tabelProyek.setEnabled(true);
        tabelUnsur.setEnabled(true);
    }

    private void ambilDataSumber(Unsur unsur) throws IOException, SQLException {

        ArrayList<String> attributes = new ArrayList<>();
        unsur.getProductionMappings().entrySet().stream().map((entry) -> {
            String key = entry.getKey();
            println("mapping key " + key);
            println("unsur name " + unsur.getName());
            return entry;
        }).forEachOrdered((entry) -> {

            try {
                Mapping mapping = entry.getValue();
                if (mapping == null) {
                    logger.log(LogWriter.ERROR, "Unsur tidak termapping");
                } else {
                    //UNTUk KEPERLUAN AMBIL DATA (BUILD QUERY)
                    HashMap<String, Attributes> attrHashMap = mapping.getAttributes();
                    attrHashMap.entrySet().stream().map((attr) -> attr.getValue()).filter((value) -> (!attributes.contains(value.getNamaSumber()))).forEachOrdered((value) -> {
                        attributes.add(value.getNamaSumber());
                    });

                    //get Geometry Code dengan mengamil TIPE GEOMETRI DARI NAMA UNSUR --> SPLIT BERDASARKAN TANDA "_"
                    String geomCode = GeometryTool.getGeomCodes(mapping.getTabelTarget().split("_")[1]);

                    //JIKA  UNSUR TAHUN TERBARU SUDAH DIMIGRASIKAN MAKA MENGGUNAKAN SQL QUERY KE-2, DILAKUKAN PENGECEKANNYA ADDALAH DENGAN
                    //PERIKSA DAFTAR NLP SUDAH ADA PADA UNSUR TERSEBUT.
                    String sql = "";
                    if (nlpListForUnsur != null) {
                        if (nlpListForUnsur.containsKey(mapping.getTabelTarget().trim())) {
                            ArrayList<String> nlps = nlpListForUnsur.get(mapping.getTabelTarget().trim());
                            ArrayList<String> nextNlps = getNlpOfUnsur(unsur, mapping);
                            println("NLP PEMBANDING");
                            nlps.forEach((nlp) -> {
                                System.out.print(nlp + ",");
                            });
                            println("NLP SEBELUM DI BADINGKAN ");
                            nextNlps.forEach((nextNlp) -> {
                                System.out.print(nextNlp + ",");
                            });
                            nextNlps.removeAll(nlps);
                            println("NLP SESUDAH DI BADINGKAN ");
                            nextNlps.stream().map((nextNlp) -> {
                                System.out.print(nextNlp + ",");
                                return nextNlp;
                            }).forEachOrdered((nextNlp) -> {
                                nlps.add(nextNlp);
                            });
                            nlpListForUnsur.replace(mapping.getTabelTarget().trim(), nlps);
                            println("nextNlps.size() : " + nextNlps.size());
                            if (nextNlps.size() > 0) {
                                sql = DatabaseTool.generateSQLgetPublikasiWithNLP(mapping, unsur, geomCode, nextNlps, GeometryTool.getSkala(comboBoxSkala.getSelectedItem().toString()));
                            }
                        } else {
                            ArrayList<String> nlps = getNlpOfUnsur(unsur, mapping);
                            nlpListForUnsur.put(mapping.getTabelTarget().trim(), nlps);
                            //HAPUS UNSUR TARGET
                            hapusUnsurTarget(unsur, mapping);
                            sql = DatabaseTool.generateSQLGetProduksi(unsur.getMapping().getSkemaSumber(), attributes, unsur.getName(), unsur.getFielIdentifier(), geomCode);
                        }
                    } else {
                        nlpListForUnsur = new HashMap<>();
                        ArrayList<String> nlps = getNlpOfUnsur(unsur, mapping);
                        nlpListForUnsur.put(mapping.getTabelTarget().trim(), nlps);
                        //HAPUS UNSUR TARGET
                        hapusUnsurTarget(unsur, mapping);
                        sql = DatabaseTool.generateSQLGetProduksi(unsur.getMapping().getSkemaSumber(), attributes, unsur.getName(), unsur.getFielIdentifier(), geomCode);
                    }

                    println("SQL : " + sql);
                    if (!sql.equals("")) {
                        logger.log(LogWriter.INFO, "Membaca data sumber dengan tipe unsur " + entry.getKey().split("_")[1] + "...");
                        Statement stmt = conSumber.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                                ResultSet.CONCUR_READ_ONLY);
                        ResultSet rs = stmt.executeQuery(sql);
                        int i = 1;
                        jProgressBar1.setIndeterminate(true);
                        ArrayList<HashMap<String, Object>> suumberPacked = new ArrayList<>();
                        extractData(suumberPacked, unsur, mapping, geomCode, rs);
//                        while (rs.next()) {
//                            println(rs.getString("OBJECTID"));
//                            HashMap<String, Object> dataSumber = new HashMap<>();
//                            for (Map.Entry<String, Attributes> attributes_ : attrHashMap.entrySet()) {
//                                Attributes value = attributes_.getValue();
//                                if (value.getDataTypeSumber().equalsIgnoreCase("GEOMETRY")) {
//                                    Object geom = rs.getObject(value.getNamaSumber());
//                                    //String wkt = rs.getString(value.getNamaSumber());
//                                    dataSumber.put(value.getNamaSumber(), geom);
//                                } else {
//                                    if (value.getNamaSumber().equalsIgnoreCase("METADATA")) {
//                                        dataSumber.put(value.getNamaSumber(), fileIdentifierBaruRelease);
//                                    } else {
//                                        dataSumber.put(value.getNamaSumber(), rs.getString(value.getNamaSumber()));
//                                    }
//
//                                }
//                            }
//                            suumberPacked.add(dataSumber);
//                            i++;
//                        }

                        jProgressBar1.setIndeterminate(false);
//                        extractData(suumberPacked, unsur, mapping, geomCode);
                    }
                }

            } catch (SQLException | IOException ex) {
                try {
                    hideLoading();
                    logger.log(LogWriter.ERROR, ex.getMessage());
                    Logger.getLogger(MigrasiSdoToSde.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex1) {
                    Logger.getLogger(MigrasiSdoToSde.class.getName()).log(Level.SEVERE, null, ex1);
                }
            }
        });

    }

    private void extractData(ArrayList<HashMap<String, Object>> dataSetSumber, Unsur unsur, Mapping mapping, String geomCode, ResultSet rs) throws IOException, SQLException {
        println("");
        logger.log(LogWriter.INFO, "Mempersiapkan migrasi dari " + unsur.getName() + " ke " + mapping.getTabelTarget());
        if (geomCode.equalsIgnoreCase("(3,7)")) {
            migrasiToPublikasiForAR(dataSetSumber, unsur, mapping, mapping.getTabelTarget(), geomCode, rs);
        } else {
            migrasiToPublikasi(dataSetSumber, unsur, mapping, mapping.getTabelTarget(), geomCode, rs);
        }
    }

    //TRUNCATE DATA
    private void hapusUnsurTarget(Unsur unsur, Mapping mapping) throws IOException, SQLException {
        conTarget = DatabaseTool.getConnection(configurationTarget, logger);
        try (Statement stmt = conTarget.createStatement()) {
//            conTarget.setAutoCommit(true);
//            logger.log(LogWriter.INFO, "Membersihkan data pada unsur " + mapping.getTabelTarget());
            println("");
            String sql = DatabaseTool.generateTruncateUnsur(unsur, mapping);
//            println(sql);
//            stmt.execute(sql);
//            stmt.close();
        }
    }

    private void print(String message) {
        System.out.print(message);
    }

    private void println(String message) {
        System.out.println(message);
    }

    private void error(String message) {
        try {
            logger.log(LogWriter.ERROR, "Error : " + message);
            updateViewsCon1(true);

        } catch (IOException ex1) {
            Logger.getLogger(MigrasiSdoToSde.class
                    .getName()).log(Level.SEVERE, null, ex1);
        }
    }

    private ArrayList<Unsur> getSelectedUnsur() {
        ArrayList<Unsur> un = new ArrayList<>();
        unsursHash.stream().filter((unsur) -> (unsur.isSelected())).forEachOrdered((unsur) -> {
            un.add(unsur);
        });
        return un;
    }

    public void migrasiToPublikasi(ArrayList<HashMap<String, Object>> sumberPakced, Unsur unsur, Mapping mapping, String skemaTarget, String geomCode, ResultSet rs) throws IOException, SQLException {
        if (conTarget.isClosed()) {
            conTarget = DatabaseTool.getConnection(configurationTarget, null);
        }
        conTarget.setAutoCommit(false);
        //SRID PAKAI YANG DIBAWA DARI PRODUKSI 
//        int SRID = getSRIDPublikasi(unsur.getMapping().getSkemaTarget(), skemaTarget, conTarget);
//        if (SRID == 0) {
        int SRID = getSRIDpublikasi(conTarget, unsur.getMapping().getSkemaTarget(), unsur.getMapping().getTabelTarget());
//                getSRIDproduksi(unsur.getMapping().getSkemaSumber(), unsur.getMapping().getTabelSumber(), unsur.getFielIdentifier(), geomCode);
//        }
        String sql = DatabaseTool.generateSQLInsertPuplikasiManual(mapping, SRID);
        System.out.println("SQL INSERT : " + sql);
        PreparedStatement preparedStmt = conTarget.prepareStatement(sql);
        System.out.println("");
        logger.log(LogWriter.INFO, "Mengumpulkan data untuk dimigrasi ...");

        HashMap<String, Attributes> attributes = mapping.getAttributes();
        ArrayList<String> keys = new ArrayList();
        for (Map.Entry<String, Attributes> entry : attributes.entrySet()) {
            Attributes value = entry.getValue();
            keys.add(value.getNamaSumber());
        }
//        keys.remove("OBJECTID");
//        keys.remove("SHAPE");
//        keys.add(0, "SHAPE");

        logger.log(LogWriter.INFO, "Memigrasikan data ...");

        jProgressBar1.setMaximum(rs.getRow());
        String objectId = "";
//        for (int l = 0; l < sumberPakced.size(); l++) {
        if (conTarget.isClosed()) {
            conTarget = DatabaseTool.getConnection(configurationTarget, null);
            conTarget.setAutoCommit(false);
        }
        if (preparedStmt.isClosed()) {
            preparedStmt = conTarget.prepareStatement(sql);
        }
        int l = 0;
        while (rs.next()) {
            objectId = String.valueOf(rs.getInt("OBJECTID"));
            println("object id " + objectId);
            try {
//                HashMap<String, Object> hashMap = sumberPakced.get(l);
//                objectId = (String) hashMap.get("OBJECTID");
//                print("UKURAN keys " + keys.size());
                int i = 1;
                for (String namaAttribut : keys) {
                    boolean isShape = namaAttribut.equals("SHAPE");
                    if (isShape) {
//                    String wkt = ((String) dataValue);
//                    print(namaAttribut + " at " + i + " " + wkt);
//                    Clob clob = conTarget.createClob();
//                    clob.setString(i, ((String) dataValue));
//                    wkt = wkt.replace(",", ",'||'");
//                        Geometry geometry = new WKBReader().read((byte[])dataValue);
//                        if(geometry.isValid()){
//                            print("GEOMETRY VALID");
//                        }else{
//                             print("GEOMETRY VALID");
//                        }
                        //MENGIRIMKAN TIPE GEOMETRY SEBAGAI OBJECT KE DALAM STATEMENT
                        Object dataValue = rs.getObject(namaAttribut);
                        OraReader reader = new OraReader();
                        Geometry geometry = reader.read((STRUCT) dataValue);
                        println(KEY_DATE);

                        com.esri.core.geometry.Geometry sdeGeometry = GeometryTool.convertSdoGeometryToSdeGeometry(geometry);
                        Blob blob = conTarget.createBlob();
                        WktWkbUtil util = new WktWkbUtil();
                        blob.setBytes(1, util.toWkb(sdeGeometry));
                        preparedStmt.setBlob(i, blob);
//                        preparedStmt.setObject(i, dataValue);
//                        ((OraclePreparedStatement) preparedStmt).setStringForClob(1, wkt);
                    } else {
                        String dataValue = rs.getString(namaAttribut);
//                        print(namaAttribut + " at " + i + " " + dataValue);
                        preparedStmt.setString(i, (String) dataValue);
                    }
                    i++;
                }
                preparedStmt.addBatch();
                if ((l + 1) % batchSize == 0) {
//                    logger.log(LogWriter.INFO, "Eksekusi batch data untuk unsur " + mapping.getTabelSumber() + " ke " + mapping.getTabelTarget() + " ...");
                    preparedStmt.executeBatch();
                }

                jProgressBar1.setValue(l + 1);
                l++;
            } catch (Exception e) {
                logger.log(LogWriter.ERROR, "OBJECTID " + objectId);
                logger.log(LogWriter.ERROR, e.getMessage());
            }

        }

        preparedStmt.executeBatch();
//        logger.log(LogWriter.INFO, "Commit data ...");
        conTarget.commit();
        logger.log(LogWriter.INFO, "Data termigrasi " + l);
        logger.log(LogWriter.INFO, "-");
        preparedStmt.close();
        rs.close();
//        conTarget.close();
    }

    public void migrasiToPublikasiForAR(ArrayList<HashMap<String, Object>> sumberPakced, Unsur unsur, Mapping mapping, String skemaTarget, String geomCode, ResultSet rs) throws IOException, SQLException {

        //SRID PAKAI YANG DARI PUBILKASI
        int SRID = getSRIDpublikasi(conTarget, unsur.getMapping().getSkemaTarget(), unsur.getMapping().getTabelTarget());
        String sql = DatabaseTool.generateSQLInsertPuplikasiManualForAR(mapping, SRID);
        System.out.println("SQL INSERT : " + sql);
        System.out.println("");
        logger.log(LogWriter.INFO, "Mengumpulkan data untuk dimigrasi ...");

        HashMap<String, Attributes> attributes = mapping.getAttributes();
        ArrayList<String> keys = new ArrayList();
        for (Map.Entry<String, Attributes> entry : attributes.entrySet()) {
            Attributes value = entry.getValue();
            keys.add(value.getNamaSumber());
        }

        logger.log(LogWriter.INFO, "Memigrasikan data ...");

        jProgressBar1.setMaximum(rs.getRow());
        String objectId = "";

        int l = 0;
        while (rs.next()) {

            if (conTarget.isClosed()) {
                conTarget = DatabaseTool.getConnection(configurationTarget, null);
            }
            PreparedStatement preparedStmt = conTarget.prepareStatement(sql);

            objectId = String.valueOf(rs.getInt("OBJECTID"));
            println("object id " + objectId);
            try {
                int i = 1;
                for (String namaAttribut : keys) {
                    boolean isShape = namaAttribut.equals("SHAPE");
                    if (isShape) {

                        //MENGIRIMKAN TIPE GEOMETRY SEBAGAI OBJECT KE DALAM STATEMENT
                        Object dataValue = rs.getObject(namaAttribut);
                        OraReader reader = new OraReader();
                        Geometry geometry = reader.read((STRUCT) dataValue);
//                        Clob clob = conTarget.createClob();
//                        String wkt = new WKTWriter().write(geometry);
//                        com.esri.core.geometry.Geometry esriGeom = WktWkbUtil.fromWkt(wkt);
//                        clob.setString(1, WktWkbUtil.toWkt(esriGeom));

                        com.esri.core.geometry.Geometry sdeGeometry = GeometryTool.convertSdoGeometryToSdeGeometry(geometry);
                        Clob blob = conTarget.createClob();
                        WktWkbUtil util = new WktWkbUtil();
                        blob.setString(1, util.toWkt(sdeGeometry));
                        preparedStmt.setClob(i, blob);

//                        println(wkt);
//                        Clob blob = conTarget.createClob();
//                        blob.setString(1, new WKTWriter().write(geometry));
//                        preparedStmt.setClob(i, blob);
//                        preparedStmt.setClob(i, clob);
//                        preparedStmt.setObject(i, dataValue);
//                        ((OraclePreparedStatement) preparedStmt).setStringForClob(1, wkt);
                    } else {
                        String dataValue = rs.getString(namaAttribut);
//                        print(namaAttribut + " at " + i + " " + dataValue);
                        preparedStmt.setString(i, (String) dataValue);
                    }
                    i++;
                }
                preparedStmt.addBatch();
                preparedStmt.executeBatch();
                preparedStmt.close();
                conTarget.close();
                jProgressBar1.setValue(l + 1);
                l++;
            } catch (Exception e) {
                logger.log(LogWriter.ERROR, "OBJECTID " + objectId);
                logger.log(LogWriter.ERROR, e.getMessage());
            }

        }
        logger.log(LogWriter.INFO, "Data termigrasi " + l);
        logger.log(LogWriter.INFO, "-");

        rs.close();
    }


    private void buttonBrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBrowseActionPerformed
        // TODO add your handling code here:
        chooseFile();
    }//GEN-LAST:event_buttonBrowseActionPerformed

    private void checkBoxSemuaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_checkBoxSemuaItemStateChanged
        // TODO add your handling code here:
        boolean isSelected = (evt.getStateChange() == 1);
        int row = 0;
        println("CHECK BOX SEMUA " + isSelected);
        if (!changeCheckBoxStatus) {
            if (unsursHash != null) {
                for (Unsur unsur : unsursHash) {
                    unsur.setSelected(isSelected);
                    unsursHash.set(row, unsur);
                    row++;
                }
                updateTableUnsur(unsursHash.size());
            }
        }


    }//GEN-LAST:event_checkBoxSemuaItemStateChanged

    private void buttonJalankanFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonJalankanFilterActionPerformed
        // TODO add your handling code here:
        //        getNamaProyek();
        ambilDaftarUsnurBerdasarSkalaTahun();
    }//GEN-LAST:event_buttonJalankanFilterActionPerformed

    private void buttonRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRefreshActionPerformed
        // TODO add your handling code here:
        checkBoxSemua.setSelected(true);
        doMapping();
    }//GEN-LAST:event_buttonRefreshActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    if (logger == null) {
                        logger = new LogWriter("MIGRASI_PROD-PUB");
                        logger.writeToTextArea(jTextPaneLog);
                    }
                    PythonExecutor pye = PythonExecutor.init(logger);
                    pye.execute(PythonExecutor.DB_TO_SHP);
                } catch (IOException ex) {
                    Logger.getLogger(MigrasiSdoToSde.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

        t.start();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void comboBoxProdukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxProdukActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxProdukActionPerformed

    private int getSRIDproduksi(String skemaName, String tableName, String fileIdentifier, String geomCode) throws IOException, SQLException {
        int SRID = 0;

        conSumber = DatabaseTool.getConnection(configurationSumber, logger);
        String sql = DatabaseTool.getSQLBoundingBox(skemaName, tableName, fileIdentifier, geomCode);
        System.out.println(sql);
        Statement stmt = conSumber.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            oracle.sql.STRUCT emp = (oracle.sql.STRUCT) rs.getObject("AGGR_MBR");
            if (emp != null) {
                Object[] empValues = emp.getAttributes();
                SRID = Integer.parseInt(String.valueOf(empValues[1]));
            }
        }
        return SRID;
    }

    private int getSRIDpublikasi(Connection con, String skemaName, String tableName) throws IOException, SQLException {
        int SRID = 4326;
        String sql = DatabaseTool.generateSRIDUnsurPublikasi(skemaName, tableName);
        System.out.println(sql);
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            SRID = rs.getInt("SRID");
        }
        return SRID;
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
                jTextMapping.setText(defaultMappingPath);

                doMapping();
                System.out.println(selectedFile.getAbsolutePath());
            }

        }
    }

    private void showLoadingAnimation(String text) {
        statusLabel.setText(text);
        statusLabel.setHorizontalTextPosition(JLabel.LEADING);
        icon2 = new AnimatedIcon(statusLabel);
        icon2.setAlignmentX(AnimatedIcon.LEFT);
        icon2.addIcon(new TextIcon(statusLabel, ""));
        icon2.addIcon(new TextIcon(statusLabel, "."));
        icon2.addIcon(new TextIcon(statusLabel, ".."));
        icon2.addIcon(new TextIcon(statusLabel, "..."));
        icon2.addIcon(new TextIcon(statusLabel, "...."));
        icon2.addIcon(new TextIcon(statusLabel, "....."));
        statusLabel.setIcon(icon2);
        icon2.start();
    }

    private void hideLoading() {
        icon2.stop();
        statusLabel.setText("");
    }

    private void ambilDaftarUsnurBerdasarSkalaTahun() {
        try {
//          statusLabel.setText("Mengambil data ...");
            showLoadingAnimation("Mengambil data");
            String skala = GeometryTool.getSkala(comboBoxSkala.getSelectedItem().toString());
            String produk = comboBoxProduk.getSelectedItem().toString();
            //Thu Dec 21 16:34:49 ICT 2017   E MMM dd hh:mm:ss Z yyyy
            SimpleDateFormat formatterZ = new SimpleDateFormat("EEE MMM dd hh:mm:ss zzz yyyy");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
            Date from = formatterZ.parse(spinnerTahunMulai.getValue().toString());
            Date to = formatterZ.parse(spinnerTahunSampai.getValue().toString());
            String tahunMulai = sdf.format(from);
            String tahunSampai = sdf.format(to);
            String sql = DatabaseTool.generateSQLDaftarUnsurBerdasarSkalaTahun(tahunMulai, tahunSampai, produk, skala);
            println("------- AMBIL DAFTAR UNSUR BERDASARKAN SKALA ------");
            println(sql);

            try (Connection con = DatabaseTool.getConnection(configurationSumber, null); ResultSet rs = con.createStatement().executeQuery(sql)) {
                projects = new ArrayList<>();
                while (rs.next()) {
                    Project project = new Project();
                    String fileIdentifier = rs.getString(KEY_FILEINDENTIFIER);
                    project.setFileIdentifier(fileIdentifier);
                    project.setIsSelected(true);
                    project.setNamaProject(rs.getString(KEY_TITLE));
                    ArrayList<String> namaUnsurs = new ArrayList<>();
                    String uns = rs.getString(KEY_NAMA_UNSURS);
//                    System.out.println("UNSUR == > " + uns);
                    String[] u = uns.split(";");
                    for (String u1 : u) {
                        String namaUnsur = u1.trim();
                        if (!namaUnsurs.contains(namaUnsur)) {
//                            if (namaUnsur.equalsIgnoreCase("ADMINISTRASI")) {
//                            print("ADD UNSUR " + namaUnsur);
                            namaUnsurs.add(namaUnsur);
//                            }
                        }
                    }
                    project.setNamaUnsurs(namaUnsurs);
                    ArrayList<String> nlps = new ArrayList<>();
                    String nlp = rs.getString(KEY_NLPS);
                    System.out.println("NLP == > " + nlp);
                    String[] n = nlp.split(";");
                    for (String n1 : n) {
                        nlps.add(n1.trim());
                    }
                    project.setNlps(nlps);
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
                    Date date = rs.getDate(KEY_DATE);
                    project.setTahun(Integer.parseInt(formatter.format(date)));
                    System.out.println("TAHUN  " + Integer.parseInt(formatter.format(date)));
                    projects.add(project);
                }
            }
            System.out.println("Ambil Data Projects, size " + projects.size());
            updateTableProject(projects.size());

            doMapping();
            hideLoading();

        } catch (IOException | SQLException | ParseException ex) {
            Logger.getLogger(MigrasiSdoToSde.class
                    .getName()).log(Level.SEVERE, null, ex);

        }

    }

    private void doMapping() {
        unsursHash = new ArrayList<>();
//        Thread thr = new Thread(() -> {
        try {
            showLoadingAnimation("Membaca mapping");
            comboBoxProduk.setEnabled(false);
            comboBoxSkala.setEnabled(false);
            buttonMigrasi.setEnabled(false);
            buttonBrowse.setEnabled(false);
            defaultMappingPath = jTextMapping.getText();
            HashMap<String, Mapping> mappings = readExcelMapping(defaultMappingPath, configurationTarget.getUsername());
            projects.stream().filter((project) -> (project.isIsSelected())).map((project) -> {
                println("MAPPING PROJECT " + project.getNamaProject() + " " + project.getTahun());
                return project;
            }).forEachOrdered((project) -> {
                ArrayList<String> unsurOfProject = project.getNamaUnsurs();
                Collections.sort(unsurOfProject);
                for (String string : unsurOfProject) {
//                    print("==> unsur " + string);
                    Unsur unsur = new Unsur();
                    unsur.setName(string);
                    unsur.setFielIdentifier(project.getFileIdentifier());
                    unsur.setTahun(project.getTahun());
                    HashMap<String, Mapping> mappingsOfUnsurs = new HashMap<>();
                    mappings.entrySet().forEach((entry) -> {
                        String key = entry.getKey();
                        Mapping value = entry.getValue();

                        if (value.getTabelSumber().equalsIgnoreCase(string)) {
                            Mapping mapping = mappings.get(key);
                            mappingsOfUnsurs.put(value.getTabelTarget(), value);
                            unsur.setMapping(value);
                        }
                    });
                    unsur.setProductionMappings(mappingsOfUnsurs);
                    unsur.setSelected(true);
                    unsur.setValid(true);
                    unsur.setStatus("OK");
                    unsursHash.add(unsur);
                }
            });

            updateTableUnsur(unsursHash.size());
            updateViewsCon1(true);
            hideLoading();
            comboBoxProduk.setEnabled(true);
            comboBoxSkala.setEnabled(true);
            buttonMigrasi.setEnabled(true);
            buttonBrowse.setEnabled(true);
        } catch (Exception e) {
            hideLoading();
            System.out.println(e.getMessage());
            comboBoxProduk.setEnabled(true);
            comboBoxSkala.setEnabled(true);
            buttonMigrasi.setEnabled(true);
            buttonBrowse.setEnabled(true);
        }
//        });
//
//        thr.start();

    }

    public void setTableProyek(Set<Map.Entry<String, Project>> projectedTable) {
        Thread t = new Thread(() -> {
            namaProject = new ArrayList<>();
            for (Map.Entry<String, Project> entry : projectedTable) {
                Project value = entry.getValue();
                namaProject.add(projectTable(value));
            }
            updateTableProject(projectedTable.size());
            updateViewsCon1(true);
        });

        t.start();
    }

    private Project projectTable(Project value) {
        Project prj = new Project();
        prj.setNamaProject(value.getNamaProject());
        prj.setIsSelected(value.isIsSelected());

        return prj;
    }

    private void updateTableProject(int size) {
        tabelProyek.removeAll();
        //SETELAH DATA DITAMBAHKAN KE TABLE -- TAMBAHKAN LISTENER UNTUK MENGHANDLE PERUBAHAN STATUS CHECKBOX
        DefaultTableModel dtm = (DefaultTableModel) tabelProyek.getModel();
        dtm.setRowCount(size);
        dtm.addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                int row = e.getFirstRow();
                int column = e.getColumn();
                if (column == 0) {
                    TableModel model = (TableModel) e.getSource();
                    Boolean checked = (Boolean) model.getValueAt(row, column);
                    Project prj = projects.get(row);
                    prj.setIsSelected(checked);
                    projects.remove(row);
                    projects.add(row, prj);
//                    System.out.println(row + " " + column + " SELECTED ");
                }
            }
        });
        int i = 0;
        for (int j = 0; j < projects.size(); j++) {
            Project value = projects.get(j);
            tabelProyek.getModel().setValueAt(value.isIsSelected(), i, 0);
            tabelProyek.getModel().setValueAt(value.getFileIdentifier(), i, 1);
            tabelProyek.getModel().setValueAt(value.getNamaProject(), i, 2);
            tabelProyek.getModel().setValueAt(value.getTahun(), i, 3);
            i++;
        }
    }

    private void updateTableUnsur(int size) {
        tabelUnsur.removeAll();
        DefaultTableModel dtm = (DefaultTableModel) tabelUnsur.getModel();
        dtm.setRowCount(size);
        int i = 0;
        for (Unsur unsur : unsursHash) {
            tabelUnsur.getModel().setValueAt(unsur.isSelected(), i, 0);
            tabelUnsur.getModel().setValueAt(unsur.getName(), i, 1);
            tabelUnsur.getModel().setValueAt(unsur.getFielIdentifier(), i, 2);
            tabelUnsur.getModel().setValueAt(unsur.getTahun(), i, 3);
            tabelUnsur.getModel().setValueAt(unsur.getStatus(), i, 4);
            i++;
        }

        dtm.addTableModelListener((TableModelEvent e) -> {
            int row = e.getFirstRow();
            int column = e.getColumn();
            if (column == 0) {
                TableModel model = (TableModel) e.getSource();
                Boolean checked = (Boolean) model.getValueAt(row, 0);
                Unsur unsur = unsursHash.get(row);
                unsur.setSelected(checked);
                unsursHash.set(row, unsur);
//                System.out.println(row + " " + column + " SELECTED ");
            }

        });
    }

    public HashMap<String, Mapping> readExcelMapping(String path, String skemaFromLogin) {
        try {
            ExcelReader excelReader = new ExcelReader();
            HashMap<String, Mapping> newMappings = new HashMap<String, Mapping>();
            HashMap<String, Mapping> mappings = excelReader.getMappingFromExcelPublikasi(path);
            for (Map.Entry<String, Mapping> entry : mappings.entrySet()) {
                String key = entry.getKey();
                Mapping value = entry.getValue();
                if (value.getSkemaTarget().equalsIgnoreCase(skemaFromLogin)) {
                    newMappings.put(key, value);
                }

            }
            return newMappings;

        } catch (IOException ex) {
            Logger.getLogger(MigrasiSdeToSdo.class
                    .getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public void showDialog(final String message) {
        JOptionPane.showMessageDialog(null, message);
    }

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
                setConSumber((DBConConfiguration) o);

            }
            if (code == CONNECTION_TARGET_CODE) {
                setConTarget((DBConConfiguration) o);
                //doMapping();
                //getNamaProduk();
            }
        }
    };

    private void setConSumber(DBConConfiguration con) {
        configurationSumber = new DBConConfiguration();
        configurationSumber.setName(con.getName());
        configurationSumber.setHost(con.getHost());
        configurationSumber.setPassword(con.getPassword());
        configurationSumber.setUsername(con.getUsername());
        configurationSumber.setPort(con.getPort());
        configurationSumber.setServiceName(con.getServiceName());
        configurationSumber.setSid(con.getSid());
        String url = DatabaseTool.generateUrl(configurationSumber);
        System.out.println("URL : " + url);
        jLabelKoneksiProduksi.setText(url);
        updateViewsCon1(configurationSumber != null);

    }

    private void setConTarget(DBConConfiguration con) {
        configurationTarget = con;
//                new DBConConfiguration();
        configurationTarget.setName(con.getName());
        configurationTarget.setHost(con.getHost());
        configurationTarget.setPassword(con.getPassword());
        configurationTarget.setUsername(con.getUsername());
        configurationTarget.setPort(con.getPort());
        configurationTarget.setServiceName(con.getServiceName());
        configurationTarget.setSid(con.getSid());
        String url = DatabaseTool.generateUrl(configurationTarget);
        System.out.println("URL : " + url);
        jLabelKoneksiPublikasi.setText(url);
        updateViewsCon1(configurationSumber != null);

//        ambilNomoPeta();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonBrowse;
    private javax.swing.JButton buttonJalankanFilter;
    private javax.swing.JButton buttonKoneksiSumber;
    private javax.swing.JButton buttonKoneksiTarget;
    private javax.swing.JButton buttonMigrasi;
    private javax.swing.JButton buttonRefresh;
    private javax.swing.JCheckBox checkBoxSemua;
    private javax.swing.JComboBox<String> comboBoxProduk;
    private javax.swing.JComboBox<String> comboBoxSkala;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelKoneksiProduksi;
    private javax.swing.JLabel jLabelKoneksiPublikasi;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JProgressBar jProgressBar2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField jTextMapping;
    private javax.swing.JTextPane jTextPaneLog;
    private javax.swing.JSpinner spinnerTahunMulai;
    private javax.swing.JSpinner spinnerTahunSampai;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JTable tabelProyek;
    private javax.swing.JTable tabelUnsur;
    // End of variables declaration//GEN-END:variables

    @Override
    public void onStart() {
        jTextMapping.setText(defaultMappingPath);
    }

    @Override
    public void onPause() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void onResume() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

    class Pro {

        public Clob getShape() {
            return shape;
        }

        public void setShape(Clob shape) {
            this.shape = shape;
        }

        public String getSrsId() {
            return srsId;
        }

        public void setSrsId(String srsId) {
            this.srsId = srsId;
        }

        public int getObjectId() {
            return objectId;
        }

        public void setObjectId(int objectId) {
            this.objectId = objectId;
        }

        public int getSrId() {
            return srId;
        }

        public void setSrId(int srId) {
            this.srId = srId;
        }

        public String getfCode() {
            return fCode;
        }

        public void setfCode(String fCode) {
            this.fCode = fCode;
        }
        Clob shape;
        String srsId;
        int objectId;
        int srId;
        String fCode;
    }
}
