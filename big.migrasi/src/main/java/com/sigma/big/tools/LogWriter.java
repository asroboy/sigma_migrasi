/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigma.big.tools;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import javax.swing.JTextPane;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 *
 * @author Ridho
 */
public class LogWriter {

    public static final int WARNING = 0;
    public static final int INFO = 1;
    public static final int ERROR = 2;
    public static final int FATAL = 3;
    public static final int DEBUG = 4;

    public LogWriter(String fileName) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("ddMMMyyyy_HH-mm-ss");
        System.setProperty("mylog", "C:/migrasi/log/default.log");

        Properties props = new Properties();
        try {
            try (InputStream configStream = getClass().getResourceAsStream("/log4j.properties")) {
                props.load(configStream);
            }
        } catch (IOException e) {
            System.out.println("Errornot laod configuration file ");
        }
        props.setProperty("log4j.appender.file.File", "C:/migrasi/log/" + fileName + "_" + sdf.format(date) + ".log");
        props.setProperty("log4j.appender.file.MaxFileSize", "2MB");
        props.setProperty("log4j.appender.file.MaxBackupIndex", "10");
        LogManager.resetConfiguration();
        PropertyConfigurator.configure(props);

        logger = Logger.getLogger(LogWriter.class);
    }

    public LogWriter() {
        logger = Logger.getLogger(LogWriter.class);
    }

    public Logger logger;

    public void log(int type, String text) throws IOException {

        switch (type) {
            case WARNING:
                logger.warn(text);
                break;
            case INFO:
                logger.info(text);
                break;
            case ERROR:
                logger.error(text);
                break;
            case FATAL:
                logger.fatal(text);
                break;
            case DEBUG:
                logger.debug(text);
                break;
        }
    }

    public void writeToTextArea(JTextPane jTextArea) {
        checkPathExists();
        StatusMessageAppender appender = new StatusMessageAppender(jTextArea);
        LogManager.getRootLogger().addAppender(appender);
    }

    public void checkPathExists() {
        File theDir = new File("C:/migrasi/log");
        if (!theDir.exists()) {
            System.out.println("creating directory: " + theDir.getName());
            if (theDir.mkdir()) {
                System.out.println("DIR created");
            }
        }
    }

}
