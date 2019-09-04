package net.egartley.boota.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JList;

import net.egartley.boota.Marketplace;
import net.egartley.boota.app.Application;
import net.egartley.boota.dialog.AboutDialog;

public class CellMouseListener implements MouseListener {

	/*
	 * © 2015 Evan Gartley - All Rights Reserved
	 */

	JList<String> dataList;
	public static boolean pressed;

	public CellMouseListener(JList<String> list) {
		dataList = list;
	}

	public void mouseClicked(MouseEvent e) {
		if (pressed != true) {
			if (e.getSource() == Marketplace.getCopyrightLabel()) {
				AboutDialog.createDialog();
				return;
			}
			if (dataList.equals(null))
				return;
			int index = dataList.locationToIndex(e.getPoint());
			if (Marketplace.getApplications()[index] == null) {
				Marketplace.getAppList().clearSelection();
				return;
			}
			Application curApp = Marketplace.getApplications()[index];
			if (!curApp.isShowing()) {
				curApp.showDetails();
			} else {
				curApp.getDetailsFrame().toFront();
			}
			Marketplace.getAppList().clearSelection();
		}
		pressed = true;
	}

	public void mouseEntered(MouseEvent e) {}

	public void mouseExited(MouseEvent e) {}

	public void mousePressed(MouseEvent e) {}

	public void mouseReleased(MouseEvent e) {
		pressed = false;
		Marketplace.getAppList().clearSelection();
	}

}
