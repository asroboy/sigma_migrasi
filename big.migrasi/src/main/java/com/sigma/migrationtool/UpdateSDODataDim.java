/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigma.migrationtool;

import com.sigma.big.model.db.DBConConfiguration;
import com.sigma.big.tools.DatabaseTool;
import com.sigma.big.tools.LogWriter;
import com.sigma.big.utils.Activity;
import com.sigma.big.utils.ConverterUtil;
import com.sigma.migrationtool.listener.DataChangedLIstener;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.LineString;
import com.vividsolutions.jts.geom.MultiLineString;
import com.vividsolutions.jts.geom.MultiPoint;
import com.vividsolutions.jts.geom.MultiPolygon;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.geom.Polygon;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.spatial.geometry.JGeometry;
import oracle.sql.STRUCT;

/**
 *
 * @author Ridho
 */
public class UpdateSDODataDim extends javax.swing.JPanel implements Activity {

    DBConConfiguration configurationTarget;
    LogWriter logger;
    boolean perbaiki = false;

    ArrayList<String> unsurHas2D;
    String unsurs = "";
    int jenisAnalisa = 0;
    private static final int ANALISA_SRID = 1;
    private static final int ANALISA_DIMENSI = 2;
    private static final int ANALISA_USER_GEOM_SRID = 3;

    /**
     * Creates new form UpdateSDODataDim
     */
    public UpdateSDODataDim() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonKoneksiDBDev = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane2 = new javax.swing.JTextPane();
        jPanel1 = new javax.swing.JPanel();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jButton2 = new javax.swing.JButton();

        buttonKoneksiDBDev.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon_dbcon_25x.png"))); // NOI18N
        buttonKoneksiDBDev.setText("Koneksi DB");
        buttonKoneksiDBDev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonKoneksiDBDevActionPerformed(evt);
            }
        });

        jLabel1.setText("Koneksi");

        jButton1.setText("Analisa");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Logs");

        jScrollPane1.setViewportView(jTextPane1);

        jTextPane2.setEditable(false);
        jTextPane2.setBackground(new java.awt.Color(240, 240, 240));
        jTextPane2.setForeground(new java.awt.Color(0, 102, 102));
        jTextPane2.setText("Pada kolom berikut akan terisi unsur-unsur yang harus diperbaiki , Hapus unsur-unsur yang tidak ingin di perbaiki (fix). tiap-tiap unsur dipisah dengan tanda koma (,)");
        jScrollPane2.setViewportView(jTextPane2);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("PIlih jenis analisa"));

        jRadioButton2.setText("Dimensi Data");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jRadioButton1.setText("Coordinate System Data");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        jRadioButton3.setText("Cord. System Geom Metadata");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jRadioButton1)
                .addGap(18, 18, 18)
                .addComponent(jRadioButton2)
                .addGap(18, 18, 18)
                .addComponent(jRadioButton3)
                .addContainerGap(89, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(9, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton2)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton3))
                .addContainerGap())
        );

        jButton2.setText("Ulangi dari awal");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonKoneksiDBDev, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonKoneksiDBDev, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(16, 16, 16)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonKoneksiDBDevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonKoneksiDBDevActionPerformed
        setConnection(0);
    }//GEN-LAST:event_buttonKoneksiDBDevActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        if (perbaiki) {
            if (jenisAnalisa == ANALISA_DIMENSI) {
                unsurs = jTextField1.getText();
                String[] namaUnsur = unsurs.split(",");
                for (String tableName : namaUnsur) {
                    Thread t = new Thread(() -> {
                        perbaikiDataDimensi(tableName);
                    });
                    t.start();
                }
            }

            if (jenisAnalisa == ANALISA_SRID) {
//                unsurs = jTextField1.getText();
//                String[] namaUnsur = unsurs.split(",");
//                for (String tableName : namaUnsur) {
//                    Thread t = new Thread(() -> {
//                        perbaikiDataSRID(tableName);
//                    });
//                    t.start();
//                }
            }
            if (jenisAnalisa == ANALISA_USER_GEOM_SRID) {
                unsurs = jTextField1.getText();
                String[] namaUnsur = unsurs.split(",");
                for (String tableName : namaUnsur) {
                    Thread t = new Thread(() -> {
                        perbaikiDataUserGeomSRID(tableName);
                    });
                    t.start();
                }
            }

        } else {
            // TODO add your handling code here:
            Thread t = new Thread(() -> {
                try {
                    if (jenisAnalisa == ANALISA_DIMENSI) {
                        analisaDimensi();
                    }

                    if (jenisAnalisa == ANALISA_SRID) {
                        analisaSRID();
                    }
                    if (jenisAnalisa == ANALISA_USER_GEOM_SRID) {
                        analisaUserGeomMetadata();
                    }

                } catch (IOException | SQLException ex) {
                    try {
                        logger.log(LogWriter.ERROR, ex.getMessage());
                    } catch (IOException ex1) {
                        Logger.getLogger(UpdateSDODataDim.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });

            t.start();

        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
        ulangi();
        jenisAnalisa = ANALISA_SRID;
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
        ulangi();
        jenisAnalisa = ANALISA_DIMENSI;
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        // TODO add your handling code here:
        ulangi();
        jenisAnalisa = ANALISA_USER_GEOM_SRID;
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        ulangi();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void ulangi() {
        unsurHas2D = new ArrayList<String>();
        perbaiki = false;
        jButton1.setText("Analisa");
        jTextField1.setText("");
        unsurs = "";
        unsurHas2D.clear();
        jTextPane1.setText("");
    }

    private void perbaikiDataDimensi(String tableName) {
        try {
            String sql = "SELECT OBJECTID, SHAPE FROM " + configurationTarget.getUsername() + "." + tableName + " c WHERE c.SHAPE.GET_DIMS() = 3";
            Connection con = DatabaseTool.getConnection(configurationTarget, logger);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            String sqlUpdate = "UPDATE " + configurationTarget.getUsername() + "." + tableName + " SET SHAPE=? WHERE OBJECTID=?";
            PreparedStatement pstmt = con.prepareStatement(sqlUpdate);
            while (rs.next()) {
                String objectID = rs.getString("OBJECTID");
                JGeometry geometry = JGeometry.load((STRUCT) rs.getObject("SHAPE"));
                geometry = changeDimension(objectID, geometry);
                pstmt.setObject(1, JGeometry.store(geometry, con));
                pstmt.setInt(2, Integer.parseInt(objectID));
                pstmt.addBatch();
            }

            pstmt.executeBatch();
            con.close();
            perbaiki = false;
            jButton1.setText("Analisa");
        } catch (IOException ex) {
            Logger.getLogger(UpdateSDODataDim.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            try {
                Logger.getLogger(UpdateSDODataDim.class.getName()).log(Level.SEVERE, null, ex);
                logger.log(LogWriter.ERROR, ex.getMessage());
                if (ex.getMessage().contains("ODCIINDEXUPDATE")) {
                    logger.log(LogWriter.ERROR, "Periksa spatial index, jika ada hapus kemudian jalankan kembali dari awal");
                }
            } catch (IOException ex1) {
                Logger.getLogger(UpdateSDODataDim.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }

    private void perbaikiDataUserGeomSRID(String tableName) {
        try {
            Connection con = DatabaseTool.getConnection(configurationTarget, logger);
            Statement stmt = con.createStatement();
            String sqlUpdate = "UPDATE mdsys.user_sdo_geom_metadata SET SRID=4326 WHERE table_name='" + tableName + "'";
            stmt.executeUpdate(sqlUpdate);
            con.close();
            perbaiki = false;
            jButton1.setText("Analisa");
        } catch (IOException ex) {
            Logger.getLogger(UpdateSDODataDim.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UpdateSDODataDim.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private JGeometry changeDimension(String objectId, JGeometry geometry) throws IOException, SQLException {

        logger.log(LogWriter.INFO, "OBJECTID : " + objectId
                + ", DIMENSI SEBELUM UPDATE : " + geometry.getDimensions() + ", GEOM TYPE : " + geometry.getType());

        if (geometry.getType() == JGeometry.GTYPE_POLYGON) {
            Polygon polygon = (Polygon) ConverterUtil.toJTS(new GeometryFactory(), geometry);
            for (int i = 0; i < polygon.getNumGeometries(); i++) {
                for (Coordinate coord : polygon.getGeometryN(i).getCoordinates()) {
                    coord.setCoordinate(new Coordinate(coord.x, coord.y)); 
                }
            }
            geometry = ConverterUtil.toJGeometry(polygon, 4326);
        }
        if (geometry.getType() == JGeometry.GTYPE_MULTIPOLYGON) {
            MultiPolygon multiPolygon = (MultiPolygon) ConverterUtil.toJTS(new GeometryFactory(), geometry);
            for (int i = 0; i < multiPolygon.getNumGeometries(); i++) {
                for (Coordinate coord : multiPolygon.getGeometryN(i).getCoordinates()) {
                    coord.setCoordinate(new Coordinate(coord.x, coord.y)); 
                }
            }
            geometry = ConverterUtil.toJGeometry(multiPolygon, 4326);
        }

        if (geometry.getType() == JGeometry.GTYPE_CURVE) { //LINE
            LineString lineString = (LineString) ConverterUtil.toJTS(new GeometryFactory(), geometry);
            for (int i = 0; i < lineString.getNumGeometries(); i++) {
                for (Coordinate coord : lineString.getGeometryN(i).getCoordinates()) {
                   coord.setCoordinate(new Coordinate(coord.x, coord.y)); 
                }
            }
            geometry = ConverterUtil.toJGeometry(lineString, 4326);
        }
        if (geometry.getType() == JGeometry.GTYPE_MULTICURVE) { //LINE
            MultiLineString lineString = (MultiLineString) ConverterUtil.toJTS(new GeometryFactory(), geometry);
            for (int i = 0; i < lineString.getNumGeometries(); i++) {
                for (Coordinate coord : lineString.getGeometryN(i).getCoordinates()) {
                   coord.setCoordinate(new Coordinate(coord.x, coord.y)); 
                }
            }
            geometry = ConverterUtil.toJGeometry(lineString, 4326);
        }

        if (geometry.getType() == JGeometry.GTYPE_POINT) { //POINT
            System.out.println("========= POINT =======");
            double[] point = geometry.getPoint();
            JGeometry newGeometry = new JGeometry(point[0], point[1], 4326);
            geometry = newGeometry;
        }
        if (geometry.getType() == JGeometry.GTYPE_MULTIPOINT) { //MILTIPOINT
            logger.log(LogWriter.WARNING, "TIPE GEOMETRY MULTIPOINT, Dimensi akhir belum diuji cobakan");
            MultiPoint points = (MultiPoint) ConverterUtil.toJTS(new GeometryFactory(), geometry);
            for (int i = 0; i < points.getNumGeometries(); i++) {
                for (Coordinate coord : points.getGeometryN(i).getCoordinates()) {
                   coord.setCoordinate(new Coordinate(coord.x, coord.y)); 
                }
            }
            geometry = ConverterUtil.toJGeometry(points, 4326);
        }
        logger.log(LogWriter.INFO, "GEOMETRY SETELAH UDPATE " + geometry.getDimensions());
        return geometry;
    }

    private void analisaDimensi() throws IOException, SQLException {
        unsurHas2D = new ArrayList<>();
        String sql = "SELECT * FROM dba_tables where owner = '" + configurationTarget.getUsername() + "' and table_name not like '%/_%' ESCAPE '/'";
        Connection con = DatabaseTool.getConnection(configurationTarget, logger);
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        int i = 0;
        while (rs.next()) {

            String tableName = rs.getString("TABLE_NAME");
            String dimensions = getDimensionsOfTables(con, tableName);

            if (dimensions.contains("3")) {
                unsurHas2D.add(tableName);
                if (i > 0) {
                    unsurs += ",";
                }
                unsurs += tableName;
                jTextField1.setText(unsurs);
                System.out.println("===========> " + unsurs);
                i++;
                logger.log(LogWriter.ERROR, "Table tersedia : " + tableName + ", Dimensions : " + dimensions);
            } else {
                logger.log(LogWriter.INFO, "Table tersedia : " + tableName + ", Dimensions : " + dimensions);
            }
        }

        con.close();

        if (unsurHas2D.size() > 0) {
            jButton1.setText("Perbaiki");
            perbaiki = true;
        }

    }

    private String getDimensionsOfTables(Connection con, String tableName) throws IOException, SQLException {

        String sql = "SELECT DISTINCT c.shape.GET_DIMS() as DIM from " + configurationTarget.getUsername() + "." + tableName + " c";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        String dimensions = "";
        int i = 0;
        while (rs.next()) {
            if (i > 0) {
                dimensions += ",";
            }
            dimensions += rs.getString("DIM");
            i++;
        }
        return dimensions;
    }

    private String getSRIDsOfTables(Connection con, String tableName) throws IOException, SQLException {

        String sql = "SELECT DISTINCT c.shape.SDO_SRID as SRID from " + configurationTarget.getUsername() + "." + tableName + " c";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        String srid = "";
        int i = 0;
        while (rs.next()) {
            if (i > 0) {
                srid += ",";
            }
            srid += rs.getString("SRID");
            i++;
        }
        return srid;
    }

    private String getSRIDsOfTablesFromUserGeom(Connection con, String tableName) throws IOException, SQLException {

        String sql = "SELECT SRID FROM mdsys.all_sdo_geom_metadata WHERE table_name= '" + tableName + "'";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        String srid = "";
        int i = 0;
        while (rs.next()) {
            if (i > 0) {
                srid += ",";
            }
            srid += rs.getString("SRID");
            i++;
        }
        return srid;
    }

    @Override
    public void onStart() {
        logger = new LogWriter("CONVERSI_3D_SDO");
        logger.writeToTextArea(jTextPane1);

        buttonGroup1.add(jRadioButton1);
        buttonGroup1.add(jRadioButton2);
        buttonGroup1.add(jRadioButton3);
    }

    @Override
    public void onPause() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void onResume() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    AddDBConnectionNoSave addDBConnectionDialog;

    private void setConnection(int m_code) {
//         configurationTarget = new DBConConfiguration();

        if (addDBConnectionDialog == null) {
            AddDBConnection_ addDBConnection = new AddDBConnection_();
            addDBConnectionDialog = new AddDBConnectionNoSave(addDBConnection, true, listener_, configurationTarget, m_code);
            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            addDBConnectionDialog.setLocation(dim.width / 2 - addDBConnectionDialog.getSize().width / 2, dim.height / 2 - addDBConnectionDialog.getSize().height / 2);
        }
        addDBConnectionDialog.reloadWithCode(
                configurationTarget, m_code);
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
            String url = DatabaseTool.generateUrl((DBConConfiguration) o);
            configurationTarget = (DBConConfiguration) o;
            jLabel1.setText("Koneksi : " + url);
        }
    };


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton buttonKoneksiDBDev;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTextPane jTextPane2;
    // End of variables declaration//GEN-END:variables

    private void analisaSRID() throws IOException, SQLException {
        unsurHas2D = new ArrayList<>();
        String sql = "SELECT * FROM dba_tables where owner = '" + configurationTarget.getUsername() + "' and table_name not like '%/_%' ESCAPE '/'";
        Connection con = DatabaseTool.getConnection(configurationTarget, logger);
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        int i = 0;
        while (rs.next()) {
            String tableName = rs.getString("TABLE_NAME");
            String srids = getSRIDsOfTables(con, tableName);
            String[] srid_s = srids.split(",");
            if (!srids.trim().equals("4326")) {

                if (srids.trim().equals("")) {
                    logger.log(LogWriter.WARNING, "Table tersedia : " + tableName + " Data tidak tersedia");
                } else {
                    unsurHas2D.add(tableName);
                    if (i > 0) {
                        unsurs += ",";
                    }
                    unsurs += tableName;
                    jTextField1.setText(unsurs);
                    System.out.println("===========> " + unsurs);
                    i++;
                    logger.log(LogWriter.ERROR, "Table tersedia : " + tableName + ", SRID(s) : " + srids);
                }
            } else {
                logger.log(LogWriter.INFO, "Table tersedia : " + tableName + ",  SRID(s) : " + srids);
            }
        }

        con.close();

        if (unsurHas2D.size() > 0) {
//            jButton1.setText("Perbaiki");
//            perbaiki = true;
        }
    }

    private void analisaUserGeomMetadata() throws IOException, SQLException {
        unsurHas2D = new ArrayList<>();
        String sql = "SELECT * FROM dba_tables where owner = '" + configurationTarget.getUsername() + "' and table_name not like '%/_%' ESCAPE '/'";
        Connection con = DatabaseTool.getConnection(configurationTarget, logger);
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        int i = 0;
        while (rs.next()) {

            String tableName = rs.getString("TABLE_NAME");
            String srids = getSRIDsOfTablesFromUserGeom(con, tableName);
            String[] srid_s = srids.split(",");
            if (!srids.equals("4326")) {

                if (!srids.trim().equals("")) {
                    unsurHas2D.add(tableName);
                    if (i > 0) {
                        unsurs += ",";
                    }
                    unsurs += tableName;
                    jTextField1.setText(unsurs);
                    System.out.println("===========> " + unsurs);
                    i++;

                    logger.log(LogWriter.ERROR, "Table tersedia : " + tableName + ", SRID(s) : " + srids);

                } else {
                    logger.log(LogWriter.WARNING, "Table tersedia : " + tableName + ", Belum teregister ke dalam Geom Metadata");
                }

            } else {
                logger.log(LogWriter.INFO, "Table tersedia : " + tableName + ",  SRID(s) : " + srids);
            }
        }

        con.close();

        if (unsurHas2D.size() > 0) {
            jButton1.setText("Perbaiki");
            perbaiki = true;
        }
    }

    private void perbaikiDataSRID(String tableName) {
        try {
            Connection con = DatabaseTool.getConnection(configurationTarget, logger);
            Statement stmt = con.createStatement();
            String sqlUpdate = "update " + tableName + " c set c.shape.sdo_srid = 32748";//32748
            stmt.executeUpdate(sqlUpdate);
            con.close();
            perbaiki = false;
            jTextField1.setText("");
            jButton1.setText("Analisa");
        } catch (IOException ex) {
            Logger.getLogger(UpdateSDODataDim.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UpdateSDODataDim.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}