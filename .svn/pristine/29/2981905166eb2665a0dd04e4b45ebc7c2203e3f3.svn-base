/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigma.big.controller;

import com.sigma.big.model.db.Produk;
import com.sigma.bigmigrasi.db.ConnectionConfiguration;
import com.sigma.bigmigrasi.db.DBUtil;
import com.sigma.bigmigrasi.db.PropertyAccess;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ridho
 */
public class ProdukController {

    DBUtil util;

    public ProdukController(DBUtil util) {
        this.util = util;
    }

    public void save(Produk produk) throws IOException, SQLException {
        ConnectionConfiguration conffig = new PropertyAccess().readPropertiesByName("default");
        try (Connection conn = util.getConnection(conffig.getDriverName(), conffig.getUrl(), conffig.getUsername(), conffig.getPassword())) {
            String sql = "INSERT INTO PRODUK ("
                    + "ID, "
                    + " NAME ) VALUES ("
                    + "SEQ_PRODUK.NEXTVAL,"
                    + " ?)";
            //SEQ_DBCONFIGURATION.NEXTVAL
            PreparedStatement preparedStmt = conn.prepareStatement(sql);
            preparedStmt.setString(1, produk.getSkemaSumber());
            
            preparedStmt.execute();
        }
    }
    
    
     public void update(Produk produk) throws IOException, SQLException {
        ConnectionConfiguration conffig = new PropertyAccess().readPropertiesByName("default");
        try (Connection conn = util.getConnection(conffig.getDriverName(), conffig.getUrl(), conffig.getUsername(), conffig.getPassword())) {
            String sql = "UPDATE PRODUK SET "
                    + " NAME = ? WHERE ID = ?";
            //SEQ_DBCONFIGURATION.NEXTVAL
            PreparedStatement preparedStmt = conn.prepareStatement(sql);
            preparedStmt.setString(1, produk.getSkemaSumber());
            preparedStmt.setInt(2, produk.getId());
            
            preparedStmt.executeUpdate();
        }
    }
}
