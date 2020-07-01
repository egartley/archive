package net.egartley.beyondorigins.windows;

import java.awt.FontMetrics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import net.egartley.beyondorigins.main.Game;

public class About extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	private FontMetrics fm;

	public About() {
		this.getContentPane().setLayout(null);
		fm = getFontMetrics(Game.f3MenuFont);
		BufferedImage image = Game.logoImage;

		JLabel logoLabel = new JLabel();
		logoLabel.setIcon(new ImageIcon(image));
		logoLabel.setBounds(250 - (image.getWidth()),
				(250 / 2) - (image.getHeight() / 2) - 35, image.getWidth(),
				image.getHeight());
		add(logoLabel);

		addText(250 - (image.getWidth() / 2)
				- (fm.stringWidth(Game.copyright) / 2), 145,
				fm.stringWidth(Game.copyright), 30, Game.copyright);
		addText(250 - (image.getWidth() / 2) - (fm.stringWidth(Game.title) / 2),
				125, fm.stringWidth(Game.title), 27, Game.title);

		addButton(350 - (100 / 2), (85 - 13), 100, 30, "Website");
		addButton(350 - (100 / 2), (85 - 13) + 38, 100, 30, "Credits");
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		String a = ae.getActionCommand();
		if (a.equals("test")) {
		} else if (a.equals("Website")) {
			String url = "http://emgartley.wordpress.com/games/beyond-origins/";
			String cmd = "cmd.exe /c start " + url;
			try {
				Runtime.getRuntime().exec(cmd);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (a.equals("Credits")) {
			Game.getMainMenu().m1Creds();
		}
	}

	private void addButton(int x, int y, int w, int h, String t) {
		JButton b = new JButton(t);
		b.setBounds(x, y, w, h);
		b.addActionListener(this);
		b.setFocusable(false);
		add(b);
	}

	private void addText(int x, int y, int w, int h, String text) {
		JLabel l = new JLabel(text);
		l.setBounds(x, y, w, h);
		l.setFont(Game.f3MenuFont);
		l.setOpaque(true);
		add(l);
	}

	public void createWindow() {
		// create and set up the window.
		JFrame frame = new About();
		frame.setTitle("About");
		frame.setSize(500, 250);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
		Game.st.setAbsoluteFrameIcon(frame, Game.mainDir + "assets\\icon32.png");
		Game.st.setSystemLookAndFeel(frame);
	}

}
