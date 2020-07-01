package net.egartley.boota.dialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.SpringLayout;

import net.egartley.boota.Marketplace;
import net.egartley.boota.Utils;
import net.egartley.boota.object.Build;
import net.egartley.boota.update.UpdateCore;

public class UpdateDialog extends JDialog implements ActionListener {

	/*
	 * © 2015 Evan Gartley - All Rights Reserved
	 */

	private static final long serialVersionUID = 1L;

	private static JDialog dialog;
	private JButton updateButton, okayButton;

	public UpdateDialog(Build build, boolean hasLatest) {
		SpringLayout layout = new SpringLayout();
		this.getContentPane().setLayout(layout);

		JLabel icon = new JLabel(new ImageIcon(Marketplace.stlibGraphics.loadImage("/updateLarge.png")));
		JButton button;
		JLabel desc;

		if (hasLatest) {
			desc = new JLabel("<html><h4>You're up-to-date!</h4>Congrats, it looks like you have the latest build "
					+ "installed! Please check back later for a new one!<br></html>");
			okayButton = new JButton("Okay");
			okayButton.setFocusable(false);
			okayButton.addActionListener(this);
			button = okayButton;
			button.setActionCommand("okay");
		} else {
			desc = new JLabel(
					"<html><h4>A new build is ready for you!</h4>Please update as soon as possible!<br><br><b>Build "
							+ build.getVersion().getString() + " </b> is now available<br>This is a <b>"
							+ build.getType().getPrettyString().toLowerCase() + "</b> build.</html>");
			updateButton = new JButton("Update Now");
			updateButton.setFocusable(false);
			updateButton.addActionListener(this);
			button = updateButton;
			button.setActionCommand("update");
		}

		MarketplaceDialog.applyDefaultLayoutConstraints(layout, icon, desc, button, this.getContentPane());

		add(icon);
		add(desc);
		add(button);

	}

	public static void createDialog(Build build, boolean hasLatest) {
		dialog = MarketplaceDialog.getDefaultJDialog(dialog, new UpdateDialog(build, hasLatest), "Update",
				MarketplaceDialog.WIDTH, MarketplaceDialog.HEIGHT, "/update.png");
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("update")) {
			Utils.runInNewThread(new Runnable() {
				public void run() {
					UpdateCore.downloadAvailableBuild();
				}
			});
			return;
		}
		dialog.dispose();
	}

}