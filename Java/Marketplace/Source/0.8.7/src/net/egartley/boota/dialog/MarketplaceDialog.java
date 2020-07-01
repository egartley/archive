package net.egartley.boota.dialog;

import java.awt.Container;
import java.awt.event.FocusAdapter;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.SpringLayout;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import net.egartley.boota.Marketplace;
import net.egartley.boota.Utils;

public class MarketplaceDialog {

	/*
	 * © 2015 Evan Gartley - All Rights Reserved
	 */

	public static final int WIDTH = 350, HEIGHT = 200;

	public static void applyDefaultLayoutConstraints(SpringLayout layout, JComponent icon, JComponent text,
			JButton button, Container cp) {
		layout.putConstraint(SpringLayout.NORTH, icon, 30, SpringLayout.NORTH, cp);
		layout.putConstraint(SpringLayout.WEST, icon, 30, SpringLayout.WEST, cp);
		layout.putConstraint(SpringLayout.SOUTH, button, -24, SpringLayout.SOUTH, cp);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, button, 0, SpringLayout.HORIZONTAL_CENTER, cp);
		layout.putConstraint(SpringLayout.WEST, text, 24, SpringLayout.EAST, icon);
		layout.putConstraint(SpringLayout.EAST, text, -24, SpringLayout.EAST, cp);
		layout.putConstraint(SpringLayout.NORTH, text, -12, SpringLayout.NORTH, icon);
	}

	public static void applyDefaultLayoutConstraints(SpringLayout layout, JComponent icon, JComponent text,
			Container cp) {
		layout.putConstraint(SpringLayout.NORTH, icon, 30, SpringLayout.NORTH, cp);
		layout.putConstraint(SpringLayout.WEST, icon, 30, SpringLayout.WEST, cp);
		layout.putConstraint(SpringLayout.WEST, text, 24, SpringLayout.EAST, icon);
		layout.putConstraint(SpringLayout.EAST, text, -24, SpringLayout.EAST, cp);
		layout.putConstraint(SpringLayout.NORTH, text, -12, SpringLayout.NORTH, icon);
	}

	public static FocusAdapter getFocusAdapter(JDialog dialog) {
		return new FocusAdapter() {
			@Override
			public void focusLost(java.awt.event.FocusEvent event) {
				dialog.dispose();
			}
		};
	}

	public static JDialog getDefaultJDialog(JDialog dialog, JDialog containerClass, String title, int w, int h,
			String iconPath) {
		dialog = containerClass;
		dialog.setTitle(title);
		dialog.setSize(w, h);
		dialog.setResizable(false);
		dialog.setLocationRelativeTo(null);
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setVisible(true);
		if (iconPath != "none")
			dialog.setIconImage(Marketplace.stlibGraphics.loadImage(iconPath));
		dialog.addFocusListener(getFocusAdapter(dialog));
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			Utils.handleException(e);
		}
		SwingUtilities.updateComponentTreeUI(dialog);
		return dialog;
	}

}