/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigma.big.tools;

import java.awt.Color;
import java.sql.Date;
import java.text.SimpleDateFormat;
import javax.swing.JTextPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.spi.LoggingEvent;

/**
 *
 * @author Ridho
 */
public class StatusMessageAppender extends AppenderSkeleton {

    private final JTextPane jTextA;

    public StatusMessageAppender(JTextPane jTextArea) {
        this.jTextA = jTextArea;
    }

    @Override
    public void close() {

    }

    @Override
    public boolean requiresLayout() {
        return false;
    }

    @Override
    protected void append(LoggingEvent event) {
        SimpleDateFormat dt = new SimpleDateFormat("yyyyy-mm-dd hh:mm:ss");
        Date time = new Date(event.getTimeStamp());
//        jTextA.append(event.getMessage().toString() + "\n");
        appendToPane(jTextA, event);
//                dt.format(time) + " " + event.getLevel() + " " + event.getLoggerName() + " " + );

    }

    private void appendToPane(JTextPane tp, LoggingEvent event) {
        // event.getLevel() + " " + event.getMessage().toString() + "\n"
        StyleContext sc = StyleContext.getDefaultStyleContext();
        Color color = null;
        if (event.getLevel() == org.apache.log4j.Level.INFO) {
            color = Color.BLACK;
        }
        if (event.getLevel() == org.apache.log4j.Level.ERROR) {
            color = Color.RED;
        }
        if (event.getLevel() == org.apache.log4j.Level.WARN) {
            color = Color.ORANGE;
        }
        if (event.getLevel() == org.apache.log4j.Level.FATAL) {
            color = Color.RED;
        }
        if (event.getLevel() == org.apache.log4j.Level.DEBUG) {
            color = Color.BLUE;
        }

        AttributeSet aset = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, color);

        aset = sc.addAttribute(aset, StyleConstants.FontFamily, "Lucida Console");
        aset = sc.addAttribute(aset, StyleConstants.Alignment, StyleConstants.ALIGN_JUSTIFIED);

        int len = tp.getDocument().getLength();
        tp.setCaretPosition(len);
        tp.setCharacterAttributes(aset, false);
        if (event.getLevel() == org.apache.log4j.Level.DEBUG) {
            tp.replaceSelection(event.getMessage() + "\n");
        } else {
            tp.replaceSelection(event.getLevel() + ": " + event.getMessage() + "\n");
        }
    }

}
