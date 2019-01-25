/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigma.migrationtool;

import com.alee.laf.WebLookAndFeel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Ridho
 */
public class Main {

    public static void main(String[] arg) {
        // set look and feel to the system look and feel
//        try {
//            String lookAndFeel = "com.sun.java.swing.plaf.gtk.GTKLookAndFeel";
//            String lookAndFeel = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";
//            UIManager.setLookAndFeel(
//                    UIManager.getCrossPlatformLookAndFeelClassName());
//            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        UIManager.put("ProgressBar.selectionBackground", Color.green);
        UIManager.put("ProgressBar.selectionForeground", Color.green);
        UIManager.put("ProgressBar.foreground", new Color(8, 32, 128));

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // Initialize L&F here, before creating any UI
                WebLookAndFeel.initializeManagers();
                WebLookAndFeel.install();

            }
        });

//            UIManager.setLookAndFeel(lookAndFeel);
//        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException ex) {
//        }
        SwingUtilities.invokeLater(
                () -> {
                    MainFrame mainFrame = new MainFrame();
                    mainFrame.setTitle("Migration Tool SJ BIG");
//                    mainFrame.setIconImage(new ImageIcon("com/sigma/big/images/big_log.png").getImage());
                    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
                    mainFrame.setLocation(dim.width / 2 - mainFrame.getSize().width / 2, dim.height / 2 - mainFrame.getSize().height / 2);
                    mainFrame.setVisible(true);
                }
        );
    }

}
