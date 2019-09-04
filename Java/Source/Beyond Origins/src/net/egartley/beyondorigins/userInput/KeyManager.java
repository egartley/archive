package net.egartley.beyondorigins.userInput;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import net.egartley.beyondorigins.inventory.Inventory;
import net.egartley.beyondorigins.main.Game;
import net.egartley.beyondorigins.menus.F3Menu;
import net.egartley.beyondorigins.menus.PauseMenu;
import net.egartley.beyondorigins.windows.Keys;

public class KeyManager implements KeyListener {

	public static boolean escPressed = false, enterPressed = false;

	public static String removeCharAt(String s, int pos) {
		return s.substring(0, pos) + s.substring(pos + 1);
	}

	private void pressed_attack() {
		if (Game.isInGame) {
			Game.getPlayer().attack();
		}
	}

	private void released_esc() {
		if (Game.getMainMenu().menuState == 2) {
			Game.getMainMenu().menuState = 1;
		} else if (Game.getMainMenu().menuState == 4) {
			Game.getMainMenu().menuState = 1;
		}
	}
	
	private void released_up() {
		if (Game.isInGame && Game.getMainMenu().menuState == 0) {
			Game.getPlayer().up = false;
		}
	}

	private void released_down() {
		if (Game.isInGame && Game.getMainMenu().menuState == 0) {
			Game.getPlayer().down = false;
		}
	}

	private void released_left() {
		if (Game.isInGame && Game.getMainMenu().menuState == 0) {
			Game.getPlayer().left = false;
		}
	}

	private void released_right() {
		if (Game.isInGame && Game.getMainMenu().menuState == 0) {
			Game.getPlayer().right = false;
		}
	}

	private void released_enter() {
		if ((Game.getMainMenu().currentProfile == 1
				|| Game.getMainMenu().currentProfile == 2 || Game.getMainMenu().currentProfile == 3)
				&& Game.getMainMenu().menuState == 2 && Game.isInGame == false) {
			try {
				Game.getMainMenu().m2PlayProfile();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	private void released_block() {
		if (Game.isInGame && Game.getMainMenu().menuState == 0) {
			Game.getPlayer().exp += 10;
		}
	}

	public void keyPressed(KeyEvent e) {

		// up
		if (((e.getKeyCode() == Keys.up)) && !Inventory.invOpen
				&& Game.getMainMenu().menuState == 0) {
			Game.getPlayer().up = true;
		} else if (e.getKeyCode() != Keys.sprint && e.getKeyCode() != Keys.up
				&& e.getKeyCode() != Keys.attack) {
			Game.getPlayer().up = false;
		}

		// down
		if (((e.getKeyCode() == Keys.down)) && !Inventory.invOpen
				&& Game.getMainMenu().menuState == 0) {
			Game.getPlayer().down = true;
		} else if (e.getKeyCode() != Keys.sprint && e.getKeyCode() != Keys.down
				&& e.getKeyCode() != Keys.attack) {
			Game.getPlayer().down = false;
		}

		// left
		if (((e.getKeyCode() == Keys.left)) && !Inventory.invOpen
				&& Game.getMainMenu().menuState == 0) {
			Game.getPlayer().left = true;
		} else if (e.getKeyCode() != Keys.sprint && e.getKeyCode() != Keys.left
				&& e.getKeyCode() != Keys.attack) {
			Game.getPlayer().left = false;
		}

		// right
		if (((e.getKeyCode() == Keys.right)) && !Inventory.invOpen
				&& Game.getMainMenu().menuState == 0) {
			Game.getPlayer().right = true;
		} else if (e.getKeyCode() != Keys.sprint
				&& e.getKeyCode() != Keys.right
				&& e.getKeyCode() != Keys.attack) {
			Game.getPlayer().right = false;
		}

		// inventory toggle
		if (e.getKeyCode() == Keys.invToggle && Game.isInGame
				&& PauseMenu.isOpen == false) {
			Inventory.invOpen = !Inventory.invOpen;
		}

		// F3
		if (e.getKeyCode() == KeyEvent.VK_F3) {
			F3Menu.f3menu = !F3Menu.f3menu;
		}

		// ESC
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			escPressed = true;
		} else
			escPressed = false;
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE && Game.isInGame
				&& Inventory.invOpen == false && PauseMenu.isOpen == false) {
			PauseMenu.isOpen = true;
		}

		// enter
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			enterPressed = !enterPressed;
		}

		// sprint
		/*
		 * if (e.getKeyCode() == Keys.sprint && !Inventory.invOpen) {
		 * Game.getPlayer().SPEED = 2; }
		 */

		// attack
		if (e.getKeyCode() == Keys.attack && !Inventory.invOpen) {
			pressed_attack();
		}

	}

	public void keyReleased(KeyEvent e) {
		
		// toggle map overview
		if (e.getKeyCode() == Keys.toggleOverview) {
			Game.overviewing = !Game.overviewing;
		}

		// block
		if (e.getKeyCode() == Keys.block) {
			released_block();
		}

		// attack
		if (e.getKeyCode() == Keys.attack && !Inventory.invOpen) {
			Game.getPlayer().isAttacking = false;
		}

		// up
		if ((e.getKeyCode() == Keys.up)) {
			released_up();
		}

		// dowe
		if ((e.getKeyCode() == Keys.down)) {
			released_down();
		}

		// a or left
		if ((e.getKeyCode() == Keys.left)) {
			released_left();
		}

		// d or right
		if ((e.getKeyCode() == Keys.right)) {
			released_right();
		}

		// sprint stop
		/*
		 * if (e.getKeyCode() == Keys.sprint && !Inventory.invOpen) {
		 * Game.getPlayer().SPEED = 1; }
		 */

		// esc
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			escPressed = false;
			released_esc();
		}

		// enter
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			released_enter();
		}
		
		// refresh graphics
		if (e.getKeyCode() == KeyEvent.VK_F5) {
			Game.loadGfx();
		}

	}

	public void keyTyped(KeyEvent e) {

	}

}