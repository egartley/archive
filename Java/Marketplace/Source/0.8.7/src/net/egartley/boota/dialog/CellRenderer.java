package net.egartley.boota.dialog;

import java.awt.Color;
import java.awt.Component;

import javax.swing.*;

import net.egartley.boota.Marketplace;

public class CellRenderer extends JLabel implements ListCellRenderer<Object>{
	
	/*
	 * © 2015 Evan Gartley - All Rights Reserved
	 */
	
	private static final long serialVersionUID = 1L;
	
	public Component getListCellRendererComponent(JList<?> list,
			Object value, int index, boolean isSelected, boolean cellHasFocus) {
		String s = value.toString();
        setText(s);
        setIcon(new ImageIcon(Marketplace.applications[index].getIcon()));
        if (isSelected) {
            setBackground(new Color(0, 146, 255));
            setForeground(list.getSelectionForeground());
        } else {
        	if (index == 0) {
        		setBackground(Color.WHITE);
        	} else if (index == 1) {
        		setBackground(new Color(240 , 240 , 240));
        	} else if ((index & 1) == 0) {
        		setBackground(Color.WHITE);
        	} else {
        		setBackground(new Color(240 , 240 , 240));
        	}
            setForeground(list.getForeground());
        }
        setEnabled(list.isEnabled());
        setFont(list.getFont());
        setOpaque(true);
		return this;
	}

}
