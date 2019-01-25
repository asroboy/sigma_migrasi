/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigma.migrationtool;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import javax.swing.JComponent;
import javax.swing.plaf.basic.BasicProgressBarUI;

/**
 *
 * @author Ridho
 */
public class MyProgressUI extends BasicProgressBarUI {

    private Rectangle r = new Rectangle();

    @Override
    protected void paintIndeterminate(Graphics g, JComponent c) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        r = getBox(r);
        g.setColor(progressBar.getForeground());
//          g.fillOval(r.x, r.y, r.width, r.height);
        g.fillRoundRect(r.x, r.y, r.width, r.height, 2, 2);
    }
}
