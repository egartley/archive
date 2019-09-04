package net.egartley.beyondorigins.windows;

import javax.swing.JFrame;

import net.egartley.beyondorigins.main.Game;

public class Credits extends JFrame{
	
	private static final long serialVersionUID = 1L;

	public Credits() {
		this.getContentPane().setLayout(null);
		// Game.st.addFrameImage(this.getContentPane(), Game.creds, 0, -10);
	}

	public void createWindow() {
		JFrame frame = new Credits();
		frame.setTitle("Credits");
		frame.setSize(500, 510);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
		Game.st.setAbsoluteFrameIcon(frame, Game.mainDir + "assets\\icon32.png");
		Game.st.setSystemLookAndFeel(frame);
	}
	
}
