package net.egartley.beyondorigins.windows;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

import net.egartley.beyondorigins.main.Game;

public class AddOns extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	private String b1 = "Apply", b2 = "Cancel";

	public AddOns() {
		this.getContentPane().setLayout(null);

		// add content
		addText(208, 240, 100, 15, "Coming Soon!");
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		String a = ae.getActionCommand();
		if (a.equals(b1)) {

		} else if (a.equals(b2)) {

		}
	}

	/*private void addButton(int x, int y, int w, int h, String text) {
		JButton b = new JButton(text);
		b.setBounds(x, y, w, h);
		b.setFocusable(false);
		b.addActionListener(this);
		add(b);
	}*/

	private void addText(int x, int y, int w, int h, String text) {
		JLabel l = new JLabel(text);
		l.setBounds(x, y, w, h);
		l.setOpaque(true);
		add(l);
	}

	public void createWindow() {
		// create and set up the window.
		JFrame frame = new AddOns();
		frame.setTitle("Add-Ons");
		frame.setSize(500, 500);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
		Game.st.setAbsoluteFrameIcon(frame, Game.mainDir + "assets\\icon32.png");
		Game.st.setSystemLookAndFeel(frame);
	}

}
