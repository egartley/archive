package net.egartley.beyondorigins.userInput;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.Timer;

import net.egartley.beyondorigins.main.Game;

public class MouseManager implements MouseListener, ActionListener {

	public static boolean isMousePressedDown = false;

	private final static int clickInterval = (Integer) Toolkit.getDefaultToolkit()
			.getDesktopProperty("awt.multiClickInterval");

	private MouseEvent lastEvent;
	private Timer timer;

	public MouseManager() {
		this(clickInterval);
	}

	public MouseManager(int delay) {
		timer = new Timer(delay, this);
	}

	public void doubleClick(MouseEvent e) {
		if (!Game.isInGame && Game.getMainMenu().menuState == 2
				&& ((MouseMotion.mouseX >= 110 && MouseMotion.mouseX < 110 + 300 && MouseMotion.mouseY >= 224 - 110
						&& MouseMotion.mouseY < 224 - 110 + 117
						|| (MouseMotion.mouseX >= 110 && MouseMotion.mouseX < 110 + 300 && MouseMotion.mouseY >= 224
								&& MouseMotion.mouseY < 224 + 117)
						|| (MouseMotion.mouseX >= 110 && MouseMotion.mouseX < 110 + 300
								&& MouseMotion.mouseY >= 224 + 110 && MouseMotion.mouseY < 224 + 110 + 117)))) {
			try {
				Game.getMainMenu().m2PlayProfile();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	public void singleClick(MouseEvent e) {

	}

	public void mousePressed(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1) {
			isMousePressedDown = true;
		}
	}

	public void mouseReleased(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1) {
			isMousePressedDown = false;
		}
		if (!Game.isInGame && Game.getMainMenu().menuState == 2) {
			if (MouseMotion.mouseX >= 110 && MouseMotion.mouseX < 110 + 300 && MouseMotion.mouseY >= 224 - 110
					&& MouseMotion.mouseY < 224 - 110 + 117) {
				Game.getMainMenu().setCurrentProfile(1);
			} else if (MouseMotion.mouseX >= 110 && MouseMotion.mouseX < 110 + 300 && MouseMotion.mouseY >= 224
					&& MouseMotion.mouseY < 224 + 117) {
				Game.getMainMenu().setCurrentProfile(2);
			} else if (MouseMotion.mouseX >= 110 && MouseMotion.mouseX < 110 + 300 && MouseMotion.mouseY >= 224 + 110
					&& MouseMotion.mouseY < 224 + 110 + 117) {
				Game.getMainMenu().setCurrentProfile(3);
			}
		}
	}

	public void mouseEntered(MouseEvent e) {

	}

	public void mouseExited(MouseEvent e) {

	}

	public void mouseClicked(MouseEvent e) {
		if (e.getClickCount() > 2)
			return;
		lastEvent = e;
		if (timer.isRunning()) {
			timer.stop();
			doubleClick(lastEvent);
		} else {
			timer.restart();
		}
	}

	public void actionPerformed(ActionEvent arg0) {
		timer.stop();
		singleClick(lastEvent);
	}

}