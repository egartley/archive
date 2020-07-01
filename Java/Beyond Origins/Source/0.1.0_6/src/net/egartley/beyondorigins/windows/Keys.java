package net.egartley.beyondorigins.windows;

import java.awt.FontMetrics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

import net.egartley.beyondorigins.files.Load;
import net.egartley.beyondorigins.main.Game;

public class Keys extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	FontMetrics fm;
	byte yBase = 32 + 16 + 13, yInit = 50;
	public static int invToggle = 69, up = 87, down = 83, left = 65,
			right = 68, attack = 75, block = 76, sprint = 16, toggleOverview = 79;
	public JTextField moveUp, moveDown, moveLeft, moveRight;
	
	public Keys() {
		this.getContentPane().setLayout(null);
		fm = getFontMetrics(Game.profileInfoFont);
		
		/*addText(getTPosX(0), getTPosY(0), fm.stringWidth("Move Up:"), 20, "Move Up:");
		moveUp = new JTextField();
		moveUp.setBounds(getTBPosX(0), getTBPosY(0), 164, 22);
		moveUp.setText(String.valueOf(up));
		add(moveUp);*/
	}
	
	/*private int getTPosX(int n) {
		int nn = 0;
		if (n == 0) {
			nn = 50;
		} else if (n == 1) {
			nn = 50 + 164 + 410;
		}
		return nn;
	}
	
	private int getTPosY(int n) {
		int nn = 0;
		if (n == 0) {
			nn = 50;
		} else {
			nn = (50 * n) + (75 * n);
		}
		return nn;
	}
	
	private int getTBPosX(int n) {
		int nn = 0;
		if (n == 0) {
			nn = 50;
		} else if (n == 1) {
			nn = 50 + 164 + 410;
		}
		return nn;
	}
	
	private int getTBPosY(int n) {
		int nn = 0;
		if (n == 0) {
			nn = 80;
		} else {
			nn = (80 * n) + (75 * n);
		}
		return nn;
	}
	
	private void addText(int x, int y, int w, int h, String text) {
		JLabel l = new JLabel(text);
		l.setFont(Game.profileInfoFont);
		l.setBounds(x, y, w, h);
		l.setOpaque(true);
		add(l);
	}*/

	public void actionPerformed(ActionEvent e) {
		String ac = e.getActionCommand();
		if (ac.equals("move_up")) {
			
		}
	}

	public void createWindow() {
		JFrame frame = new Keys();
		Load.loadKeys(Game.keysPath);
		frame.setTitle("Key Config");
		frame.setSize(500, 500);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
		Game.st.setAbsoluteFrameIcon(frame, Game.mainDir + "assets\\icon32.png");
		Game.st.setSystemLookAndFeel(frame);
	}

}
