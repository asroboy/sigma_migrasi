/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

/**
 *
 * @author wallet
 */
public class DataConfiguration {
    
    private String ip;
    private String port;
    private String username;
    private String password;
    private String databaseName;

    public DataConfiguration() {
    }
    
    public DataConfiguration(String ip, String port, String username, String password,String databaseName) {
        this.ip = ip;
        this.port = port;
        this.username = username;
        this.password = password;
        this.databaseName = databaseName;
    }
    
    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }
    
        
}
