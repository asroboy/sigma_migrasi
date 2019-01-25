/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigma.bigmigrasi.db;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Properties;

/**
 *
 * @author Ridho
 */
public class PropertyAccess {

    public void writeConnectionProperties(ConnectionConfiguration conf) {
        Properties prop = new Properties();
        OutputStream output = null;

        try {
            output = new FileOutputStream(conf.getName() + "_config.properties");

            registerProperertyName(conf.getName());
            // set the properties value
            prop.setProperty("driver", conf.driverName);
            prop.setProperty("url", conf.url);
            prop.setProperty("username", conf.username);
            prop.setProperty("password", conf.password);

            // save properties to project root folder
            prop.store(output, null);

        } catch (IOException io) {
            System.out.println(io.getMessage());
        } finally {
            if (output != null) {
                try {
                    output.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }

        }
    }

    public void registerProperertyName(String name) {
        String existingName = readPropertiesName();
        System.out.println("existingName \'" + existingName + "\'");
        Properties prop = new Properties();
        OutputStream output = null;
        try {
            output = new FileOutputStream("name_config.properties");
            // set the properties value
            String nName;
            if (existingName != null && !existingName.trim().equals("")) {
                nName = existingName + "," + name;
            } else {
                nName = name;
            }

            System.out.println("nNames " + nName);
            prop.setProperty("names", nName);
            // save properties to project root folder
            prop.store(output, null);

        } catch (IOException io) {
            System.out.println(io.getMessage());
        } finally {
            if (output != null) {
                try {
                    output.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    public ArrayList<ConnectionConfiguration> readProperties() {
        Properties prop = new Properties();
        InputStream input = null;

        ArrayList<ConnectionConfiguration> conns = new ArrayList<>();
        try {
            String names = readPropertiesName();
            String[] mNames = names.split(",");
            for (String name : mNames) {
                input = new FileInputStream(name + "_config.properties");

                // load a properties file
                ConnectionConfiguration conn = new ConnectionConfiguration();
                prop.load(input);
                conn.setName(name);
                conn.setDriverName(prop.getProperty("driver"));
                conn.setUrl(prop.getProperty("url"));
                conn.setUsername(prop.getProperty("username"));
                conn.setPassword(prop.getProperty("password"));
                conns.add(conn);
            }

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }

        return conns;

    }

    public ConnectionConfiguration readPropertiesByName(String name) throws FileNotFoundException, IOException {
        Properties prop = new Properties();
        InputStream input = null;

        ConnectionConfiguration conn = null;
       

            input = new FileInputStream(name + "_config.properties");

            // load a properties file
            conn = new ConnectionConfiguration();
            prop.load(input);
            conn.setName(name);
            conn.setDriverName(prop.getProperty("driver"));
            conn.setUrl(prop.getProperty("url"));
            conn.setUsername(prop.getProperty("username"));
            conn.setPassword(prop.getProperty("password"));

   
        return conn;

    }

    public String readPropertiesName() {
        Properties prop = new Properties();
        InputStream input = null;
        String names = "";
        try {
            input = new FileInputStream("name_config.properties");
            // load a properties file
            prop.load(input);
            names = prop.getProperty("names");

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        return names;
    }

}
