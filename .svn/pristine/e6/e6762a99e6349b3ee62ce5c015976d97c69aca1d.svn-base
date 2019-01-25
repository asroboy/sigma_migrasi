package com.sigma.big.tools;

import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.dialect.Dialect;
import org.hibernate.dialect.Oracle10gDialect;
import org.hibernate.dialect.Oracle9iDialect;
import org.hibernate.dialect.PostgreSQL81Dialect;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.Configurable;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.type.Type;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.service.ServiceRegistry;

/**
 * User: schullto Date: 24/12/2014 Time: 5:33 PM
 */
public class NextRowIdSequenceGenerator implements IdentifierGenerator, Configurable {

    private String schemaOwner = "sde";
    private String tableOwner;
    private String tableName;

  
    public Serializable generate(SessionImplementor session, Object object) throws HibernateException {
        Integer nextRowId = null;
        Connection conn = session.connection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            Dialect dialect = session.getFactory().getDialect();
            String sql = null;
            if (dialect instanceof Oracle10gDialect) {
                sql = "select " + schemaOwner + ".version_user_ddl.next_row_id.next_rowid (?, (select registration_id from SDE.TABLE_REGISTRY where table_name = ?) ) from dual ";
            } else if (dialect instanceof Oracle9iDialect) {
                sql = "select " + schemaOwner + ".gdb_util.next_rowid (?, ?) from dual";
            } else if (dialect instanceof PostgreSQL81Dialect) {
                sql = "select next_rowid (?, ?)";
            }
            if (sql == null) {
                sql = "NO dialect found in NextWorIdSequenceGenerator";
            }
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, tableOwner);
            preparedStatement.setString(2, tableName);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                nextRowId = resultSet.getInt(1);
            }
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return nextRowId;
    }

    @Override
    public void configure(Type type, Properties prprts, ServiceRegistry sr) throws MappingException {
        if (prprts.containsKey("schemaOwner")) {
            schemaOwner = prprts.getProperty("schemaOwner");
        }
        tableName = prprts.getProperty("tableName").toUpperCase();
        tableOwner = prprts.getProperty("tableOwner").toUpperCase();
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Serializable generate(SharedSessionContractImplementor ssci, Object o) throws HibernateException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
