package net.egartley.boota.dialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.SpringLayout;

import net.egartley.boota.Marketplace;
import net.egartley.boota.update.ThisBuild;

public class AboutDialog extends JDialog implements ActionListener {

	/*
	 * © 2015 Evan Gartley - All Rights Reserved
	 */

	private static final long serialVersionUID = 1L;

	private static JDialog dialog;

	public AboutDialog() {
		SpringLayout layout = new SpringLayout();
		this.getContentPane().setLayout(layout);

		JLabel icon = new JLabel(new ImageIcon(Marketplace.stlibGraphics.loadImage("/icon64.png")));

		JLabel aboutLabel = new JLabel();
		aboutLabel.setText("<html><h4>Marketplace " + ThisBuild.getVersion().getString() + " "
				+ ThisBuild.getType().getPrettyString() + "</h4>"
				+ "<p>This software is made possible by Evan Gartley and the included software "
				+ "libraries documented in the End User License Agreement.<br><br>Copyright " + ThisBuild.COPYRIGHT
				+ " " + ThisBuild.getAuthor() + "</p></html>");
		
		MarketplaceDialog.applyDefaultLayoutConstraints(layout, icon, aboutLabel, this.getContentPane());

		add(icon);
		add(aboutLabel);
	}

	public static void createDialog() {
		dialog = MarketplaceDialog.getDefaultJDialog(dialog, new AboutDialog(), "About", MarketplaceDialog.WIDTH,
				MarketplaceDialog.HEIGHT, "none");
	}

	public void actionPerformed(ActionEvent e) {
		dispose();
	}

}
