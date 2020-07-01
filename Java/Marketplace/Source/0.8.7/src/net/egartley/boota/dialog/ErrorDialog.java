package net.egartley.boota.dialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import net.egartley.boota.Marketplace;

public class ErrorDialog extends JDialog implements ActionListener {

	/*
	 * © 2015 Evan Gartley - All Rights Reserved
	 */

	private static final long serialVersionUID = 2L;

	String desc;
	private static JDialog dialog;
	private JButton okayButton;

	public ErrorDialog(String desc) {
		SpringLayout layout = new SpringLayout();
		this.getContentPane().setLayout(layout);
		this.desc = desc;

		JLabel icon = new JLabel(new ImageIcon(Marketplace.stlibGraphics.loadImage("/errorLarge.png")));
		JLabel errorDesc = new JLabel();
		errorDesc.setText("<html><h4>Oops! Something went wrong!</h4>" + desc + "</html>");

		okayButton = new JButton("Okay");
		okayButton.setFocusable(false);
		okayButton.addActionListener(this);

		MarketplaceDialog.applyDefaultLayoutConstraints(layout, icon, errorDesc, okayButton, this.getContentPane());

		add(icon);
		add(okayButton);
		add(errorDesc);
	}

	public static void createDialog(String desc, String title) {
		dialog = MarketplaceDialog.getDefaultJDialog(dialog, new ErrorDialog(desc), title, MarketplaceDialog.WIDTH,
				MarketplaceDialog.HEIGHT, "/error.png");
	}

	public void actionPerformed(ActionEvent e) {
		dialog.dispose();
		Marketplace.close();
	}

}