/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigma.bigmigrasi.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.eclipse.persistence.config.PersistenceUnitProperties;

/**
 *
 * @author Ridho
 */
public class DBUtil {

    public EntityManager openConnection(String persistenceUnitName) {
        EntityManager entityManager = Persistence.createEntityManagerFactory(persistenceUnitName).createEntityManager();
        entityManager.getTransaction().begin();

        return entityManager;
    }

    public void closeConnection(EntityManager entityManager) {
        entityManager.close();
    }

    public void commitAndCloseConnection(EntityManager entityManager) {
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public List<String> getTables(EntityManager entityManager) {
        String sql = "select TABLE_NAME from user_tables";
        Query q = entityManager.createNativeQuery(sql);
        List<String> s = q.getResultList();
        return s;
    }

    public List<FieldOfTable> getFields(EntityManager entityManager, String tableName) {
        String sql = "select column_id as id, COLUMN_NAME as name, data_type as dataType, char_length as dataLength from ALL_TAB_COLUMNS where TABLE_NAME= \'" + tableName + "\'";
        Query q = entityManager.createNativeQuery(sql, FieldOfTable.class);
        List<FieldOfTable> s = q.getResultList();
        return s;
    }

    public EntityManagerFactory setPersistentUnnit() {
        Map props = new HashMap();
        props.put(PersistenceUnitProperties.JDBC_URL, "jdbc:oracle:thin:@192.168.3.100:1521:IGSEKS");
        props.put(PersistenceUnitProperties.JDBC_DRIVER, "oracle.jdbc.OracleDriver");
        props.put(PersistenceUnitProperties.JDBC_USER, "system");
        props.put(PersistenceUnitProperties.JDBC_PASSWORD, "oracle");

        return Persistence.createEntityManagerFactory("SUMBER", props);
    }

    public Connection getConnection(String driverName, String url, String username, String password) {
        try {
//            "oracle.jdbc.driver.OracleDriver"
            Class.forName(driverName);

        } catch (ClassNotFoundException e) {

            System.out.println("Where is your Oracle JDBC Driver?");
            e.printStackTrace();
            return null;

        }

//        System.out.println("Oracle JDBC Driver Registered!");
        Connection connection = null;

        try {
            // url = "jdbc:oracle:thin:@localhost:1521:orcl"
            //username = "system";
            //password = "root123";
            connection = DriverManager.getConnection(
                    url, username, password
            );
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return null;

        }

        return connection;
    }

}
