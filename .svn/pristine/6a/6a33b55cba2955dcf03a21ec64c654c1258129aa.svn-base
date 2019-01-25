/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigma.big.utils;

import java.awt.Component;
import java.awt.event.ActionEvent;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;

/**
 *
 * @author Ridho
 */
public class ButtonEditor extends DefaultCellEditor {

    protected JButton button;
    private final String label;
    private boolean isPushed;
    ButtonCellClickedListener listener;
    int code;
    int row;

    public ButtonEditor(JCheckBox checkBox, String label, ButtonCellClickedListener listener, int code) {
        super(checkBox);
        this.label = label;
        this.listener = listener;
        this.code = code;

        button = new JButton(label);
        button.setOpaque(true);
        button.addActionListener((ActionEvent e) -> {
            System.out.println("listener === clicked");
            fireEditingStopped();
            listener.onClick(code, row);
        });
    }

    
    @Override
    public Component getTableCellEditorComponent(JTable table, Object value,
            boolean isSelected, int row, int column) {
        this.row = row;
         fireEditingStopped();
        isPushed = true;
        return button;
    }

    @Override
    public Object getCellEditorValue() {
        if (isPushed) {
        }
        isPushed = false;
        return label;
    }

    @Override
    public boolean stopCellEditing() {
        isPushed = false;
        return super.stopCellEditing();
    }

    @Override
    protected void fireEditingStopped() {
        super.fireEditingStopped();
    }
}
