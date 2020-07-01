package net.egartley.boota.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import net.egartley.boota.console.Console;

public class InputKeyListener implements KeyListener{
	
	/*
	 * © 2015 Evan Gartley - All Rights Reserved
	 */

	public void keyPressed(KeyEvent e) {
		
	}

	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			Console.doCommand();
		}
	}

	public void keyTyped(KeyEvent e) {
		
	}

}
