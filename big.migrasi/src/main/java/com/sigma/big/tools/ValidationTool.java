/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigma.big.tools;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Ridho
 */
public class ValidationTool {

    private static final Set<String> VALUES = new HashSet<String>(Arrays.asList(
            new String[]{"OBJECTID", "METADATA", "FCODE", "SHAPE"}
    ));

    private static final HashMap<String, String> KATEGORI = new HashMap<String, String>();

    public ValidationTool() {
        setKateogri();
    }

    public boolean checkDomain(Connection con, String domainValue, String domainColumnName) throws SQLException {
        boolean isValid = (domainValue == null || domainValue.equals(""));
        if (!isValid) {
              checkDomainToDB(con, domainColumnName, domainValue);
        }
        return isValid;
    }

    private boolean checkDomainToDB(Connection con, String domainName, String domainValue) throws SQLException {
        String sql = "SELECT * FROM DOMAIN." + domainName + " WHERE CODE LIKE \'%" + domainValue + "\'";
//        System.out.println(sql);
        boolean isData;
        try (Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            isData = false;
            while (rs.next()) {
                isData = true;
            }
        }
        return isData;
    }

    public boolean checkMandatory(String columnName) {
        return !VALUES.contains(columnName);
    }

    public boolean checkValueIsNull(Object data) {
        return data == null;
    }

    public boolean checkStringValueIsEmpty(String data) {
        return data.equals("");
    }

    public boolean checkFcodeIsValid(String value) {
        boolean isValid = (value.length() == 10 && value != null && !value.equals(""));
//        System.out.println("FCODE valid = " + isValid);
        return isValid;
    }

    public void setKateogri() {
        KATEGORI.put("A", "Referensi Spasial");
        KATEGORI.put("B", "Batas Wilayah");
        KATEGORI.put("C", "Transportasi");
        KATEGORI.put("D", "Hidrografi");
        KATEGORI.put("E", "Hipsografi");
        KATEGORI.put("F", "Vegetasi");
        KATEGORI.put("G", "Lingkungan Terbangun");
        KATEGORI.put("H", "Utilitas");
        KATEGORI.put("I", "Geologi");
        KATEGORI.put("J", "Tanah");
        KATEGORI.put("K", "Toponimi");
        KATEGORI.put("L", "Kadaster");
        KATEGORI.put("M", "Kebencanaan");
        KATEGORI.put("Z", "Dataset Khusus");
    }
}
