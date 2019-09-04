package net.egartley.boota.dialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.*;

import net.egartley.boota.Marketplace;
import net.egartley.boota.Utils;
import net.egartley.boota.app.Application;
import net.egartley.boota.update.ThisBuild;

public class AppDetailsDialog extends JDialog implements ActionListener {

	/*
	 * © 2015 Evan Gartley - All Rights Reserved
	 */

	private static final long serialVersionUID = 1L;
	private String ac_download = "Download";
	private String ac_open = "Launch";
	private String ac_error = "Error";
	private String ac_delete = "Delete";

	JButton actionButton, deleteButton;

	Application app;

	public AppDetailsDialog(Application app) {
		if (app != null) {
			this.app = app;

			SpringLayout layout = new SpringLayout();
			this.getContentPane().setLayout(layout);

			BufferedImage icon = app.getIcon();
			String name = app.getDisplayName();
			String version = app.getVersionString();

			JLabel iconLabel = new JLabel(new ImageIcon(icon));
			JLabel nameLabel = new JLabel("<html><b>" + name + "</b></html>");
			JLabel versionLabel = new JLabel(version);

			actionButton = new JButton();
			String actionText = getActionButtonText();
			actionButton.addActionListener(this);
			actionButton.setText(actionText);
			actionButton.setFocusable(false);

			deleteButton = new JButton(new ImageIcon(Marketplace.stlibGraphics.loadImage("/uninstall.png")));
			deleteButton.addActionListener(this);
			deleteButton.setFocusable(false);
			deleteButton.setVisible(false);
			deleteButton.setActionCommand(ac_delete);

			if (actionText.equalsIgnoreCase(ac_open))
				setCanDelete(true);
			else
				setCanDelete(false);

			String core = app.getFullDesc() + "<br><br>" + "Developer: <b>egartley</b><br>Version: <b>" + version
					+ "</b><br>Size: <b>" + Utils.getSizeString(app.getSize()) + "</b><br>Compatibility: <b>"
					+ app.getCompatability() + "</b>" + "<br><br>Copyright " + ThisBuild.COPYRIGHT;

			JTextPane desc = new JTextPane();
			desc.setContentType("text/html");
			desc.setText("<html><head><style>body{font-family:sans-serif;font-size:9px;}</style></head><body>" + core
					+ "</body></html>");
			desc.setFocusable(false);
			desc.setEditable(false);
			desc.setBackground(null);
			desc.setOpaque(false);

			JScrollPane sp = new JScrollPane(desc);
			sp.setRequestFocusEnabled(true);
			sp.setBorder(BorderFactory.createEmptyBorder());

			layout.putConstraint(SpringLayout.NORTH, iconLabel, 10, SpringLayout.NORTH, this.getContentPane());
			layout.putConstraint(SpringLayout.WEST, iconLabel, 70, SpringLayout.WEST, this.getContentPane());

			layout.putConstraint(SpringLayout.WEST, nameLabel, 10, SpringLayout.EAST, iconLabel);
			layout.putConstraint(SpringLayout.NORTH, nameLabel, 15, SpringLayout.NORTH, iconLabel);

			layout.putConstraint(SpringLayout.WEST, versionLabel, 10, SpringLayout.EAST, iconLabel);
			layout.putConstraint(SpringLayout.NORTH, versionLabel, 3, SpringLayout.SOUTH, nameLabel);

			layout.putConstraint(SpringLayout.WEST, actionButton, 10, SpringLayout.EAST, nameLabel);
			layout.putConstraint(SpringLayout.NORTH, actionButton, 5, SpringLayout.NORTH, nameLabel);

			layout.putConstraint(SpringLayout.WEST, deleteButton, 10, SpringLayout.EAST, actionButton);
			layout.putConstraint(SpringLayout.NORTH, deleteButton, 0, SpringLayout.NORTH, actionButton);

			layout.putConstraint(SpringLayout.NORTH, sp, 10, SpringLayout.SOUTH, iconLabel);
			layout.putConstraint(SpringLayout.WEST, sp, 20, SpringLayout.WEST, this.getContentPane());
			layout.putConstraint(SpringLayout.EAST, sp, -20, SpringLayout.EAST, this.getContentPane());
			layout.putConstraint(SpringLayout.SOUTH, sp, -20, SpringLayout.SOUTH, this.getContentPane());

			add(iconLabel);
			add(nameLabel);
			add(versionLabel);
			add(actionButton);
			add(deleteButton);
			add(sp);
		}
	}

	public void actionPerformed(ActionEvent e) {
		String ac = e.getActionCommand();
		if (ac.equals(ac_download)) {
			installApp();
		} else if (ac.equals(ac_open)) {
			launchApp();
		} else if (ac.equals(ac_error)) {
			Utils.handleError("Internal error! actionButton should not have been able"
					+ " to be clicked, with text of \"Error\"!");
		} else if (ac.equals(ac_delete)) {
			ConfirmDialog.createFrame(this);
		}
	}

	private void launchApp() {
		Utils.runInNewThread(new Runnable() {
			public void run() {
				app.launch();
			}
		});
	}

	private void installApp() {
		Utils.runInNewThread(new Runnable() {
			public void run() {
				app.install();
				setCanDelete(true);
			}
		});
	}

	public void uninstallApp() {
		Utils.runInNewThread(new Runnable() {
			public void run() {
				app.uninstall();
				setCanDelete(false);
			}
		});
	}

	public void createFrame(Application app) {
		JDialog frame = new AppDetailsDialog(app);
		frame.setTitle(app.getDisplayName() + " Details");
		frame.setSize(350, 300);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.setVisible(true);
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			Utils.handleException(e);
		}
		SwingUtilities.updateComponentTreeUI(frame);
		frame.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				app.setShowing(false);
				frame.dispose();
			}
		});
		frame.addFocusListener(new java.awt.event.FocusAdapter() {
			@Override
			public void focusLost(java.awt.event.FocusEvent event) {
				app.setShowing(false);
				frame.dispose();
			}
		});
		app.setDetailsFrame(frame);
	}

	private void setCanDelete(boolean set) {
		actionButton.setText(getActionButtonText());
		deleteButton.setVisible(set);
		if (!set) {
			actionButton.setEnabled(true);
		}
	}

	private String getActionButtonText() {
		String result;
		if (app.isInstalled()) {
			result = ac_open;
			actionButton.setActionCommand(ac_open);
		} else if (!app.isInstalled()) {
			result = ac_download;
			actionButton.setActionCommand(ac_download);
		} else {
			Utils.handleError("There was an error while attempting to run getActionButtonText()!"
					+ " Setting actionButton text to \"Error\", and disabling...");
			result = ac_error;
			actionButton.setActionCommand(ac_error);
			actionButton.setEnabled(false);
		}
		return result;
	}

}