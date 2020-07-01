package net.egartley.beyondorigins.windows;

import java.awt.FontMetrics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import javax.swing.*;

import net.egartley.beyondorigins.files.*;
import net.egartley.beyondorigins.main.*;

public class ProfileCreator extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	FontMetrics fm;
	int cur;
	JTextField proName, plrName;

	public ProfileCreator() {
		this.getContentPane().setLayout(null);

		addText(250 - (164 / 2), 39 + 32, 100, 22, "Profile Name:");
		proName = new JTextField();
		proName.setBounds(250 - (164 / 2), 64 + 32, 164, 22);
		add(proName);

		addText(250 - (164 / 2), 64 + 128 + 32, 200, 22,
				"Player Name (Male, can't change):");
		plrName = new JTextField();
		plrName.setBounds(250 - (164 / 2), 128 + 92 + 32, 164, 22);
		add(plrName);

		addButton(250 - (128 / 2), 500 - 32 - 45 - 48, "Create");
	}

	/*
	 * private void addTextField(int x, int y, String text) { JTextField tf =
	 * new JTextField(); tf.setText(text); tf.setBounds(x, y, 156, 22); add(tf);
	 * }
	 */

	private void addText(int x, int y, int w, int h, String text) {
		JLabel l = new JLabel(text);
		l.setBounds(x, y, w, h);
		l.setOpaque(true);
		add(l);
	}

	private void addButton(int x, int y, String t) {
		JButton b = new JButton(t);
		b.setBounds(x, y, 128, 32);
		b.setFocusable(false);
		b.addActionListener(this);
		add(b);
	}

	public void createWindow(int cp) {
		JFrame frame = new ProfileCreator();
		cur = cp;
		frame.setTitle("Profile Creator");
		frame.setSize(500, 500);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
		Game.st.setAbsoluteFrameIcon(frame, Game.mainDir + "assets\\icon32.png");
		Game.st.setSystemLookAndFeel(frame);
	}

	public void actionPerformed(ActionEvent e) {
		String a = e.getActionCommand();
		if (a.equals("Create")) {
			try {
				Save.profileReset();
				if (Game.getMainMenu().currentProfile == 1) {
					if (proName.getText().length() == 0
							|| proName.getText().equals("")) {
						Profile1.name = "Profile 1";
					} else {
						Profile1.name = proName.getText();
					}
					Profile1.backup_name = Profile1.name;
				} else if (Game.getMainMenu().currentProfile == 2) {
					if (proName.getText().length() == 0
							|| proName.getText().equals("")) {
						Profile2.name = "Profile 2";
					} else {
						Profile2.name = proName.getText();
					}
					Profile2.backup_name = Profile2.name;
				} else if (Game.getMainMenu().currentProfile == 3) {
					if (proName.getText().length() == 0
							|| proName.getText().equals("")) {
						Profile3.name = "Profile 3";
					} else {
						Profile3.name = proName.getText();
					}
					Profile3.backup_name = Profile3.name;
				}
				if (plrName.getText().length() == 0) {
					Game.getPlayer().name = Game.getPlayer().defaultName;
				} else {
					Game.getPlayer().name = plrName.getText();
				}
				if (Game.getMainMenu().currentProfile == 1) {
					Profile1.save();
					Load.loadProfile(Game.save1Path, 1);
				} else if (Game.getMainMenu().currentProfile == 2) {
					Profile2.save();
					Load.loadProfile(Game.save2Path, 2);
				} else if (Game.getMainMenu().currentProfile == 3) {
					Profile3.save();
					Load.loadProfile(Game.save3Path, 3);
				}
				Game.getMainMenu().enterGame(true);
			} catch (IOException ea) {
				ea.printStackTrace();
			}
			dispose();
		}
	}

}
