/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigma.big.utils;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.EventObject;
import javax.swing.AbstractCellEditor;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

/**
 *
 * @author wallet
 */
public class ButtonEditorDelete extends DefaultCellEditor implements TableCellEditor,ActionListener{

    protected JButton button;
    boolean enabled = true;
    int clickCountToStart = 1;
    private final String label;
    private boolean isPushed;
    ButtonCellClickedListener listener;
    int code;
    int row;

    public ButtonEditorDelete(JCheckBox checkBox, String label, ButtonCellClickedListener listener, int code) {
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
    
//    public ButtonEditorDelete(ActionListener al) {
//        button = new JButton();
//        button.addActionListener(this);
//        button.addActionListener(al);
//    }
    
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
    
    @Override
    public Object getCellEditorValue() {
       if (isPushed) {
        }
        isPushed = false;
        return label;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        this.row = row;
        fireEditingStopped();
        isPushed = true;
        button.setEnabled(enabled);
        return button;
    }
    
     public boolean isCellEditable(EventObject anEvent) {
        if (anEvent instanceof MouseEvent) {
            return ((MouseEvent)anEvent).getClickCount() >= clickCountToStart;
        }
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       super.stopCellEditing();
    }
    
  

}

