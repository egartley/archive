package net.egartley.boota.dialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.SpringLayout;

import net.egartley.boota.Marketplace;
import net.egartley.boota.update.ThisBuild;

public class UpdateCompleteDialog extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JButton okayButton;
	private static JDialog dialog;

	public UpdateCompleteDialog() {
		SpringLayout layout = new SpringLayout();
		this.getContentPane().setLayout(layout);

		JLabel icon = new JLabel(new ImageIcon(Marketplace.stlibGraphics.loadImage("/updateLarge.png")));
		JLabel desc = new JLabel("<html><h4>Sucessfully updated!</h4>You're now on build <b>"
				+ ThisBuild.getVersion().getString() + " " + ThisBuild.getType().getPrettyString()
				+ "</b>. It's located in the Marketplace folder, in <b>%appdata%</b> then "
				+ "<b>.egartley</b></html>");

		okayButton = new JButton("Okay");
		okayButton.setFocusable(false);
		okayButton.addActionListener(this);

		MarketplaceDialog.applyDefaultLayoutConstraints(layout, icon, desc, okayButton, this.getContentPane());

		add(icon);
		add(desc);
		add(okayButton);
	}

	public void actionPerformed(ActionEvent e) {
		dispose();
	}

	public static void createDialog() {
		dialog = MarketplaceDialog.getDefaultJDialog(dialog, new UpdateCompleteDialog(), "Update Complete",
				MarketplaceDialog.WIDTH, MarketplaceDialog.HEIGHT, "/update.png");
	}

}