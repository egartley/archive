package net.egartley.beyondorigins.story;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import net.egartley.beyondorigins.gfx.ImageManager;
import net.egartley.beyondorigins.main.Game;
import net.egartley.beyondorigins.userInput.KeyManager;

public class Dialogue {

	private static FontMetrics fm;

	public static int getState(int state, int maxStateValue) {
		if (KeyManager.enterPressed && state < maxStateValue && state != 0) {
			state++;
			KeyManager.enterPressed = false;
		}
		if (KeyManager.enterPressed && state == maxStateValue) {
			state = 0;
		}
		return state;
	}
	
	public static void drawDialogue(Graphics g, BufferedImage icon, String name,
			String line1, String line2, String line3, String line4) {
		fm = g.getFontMetrics(Game.profileInfoFont);
		g.drawImage(ImageManager.dialogueBox, Game.WIDTH
				- (ImageManager.dialogueBox.getWidth() / 2), Game.HEIGHT
				- (ImageManager.dialogueBox.getHeight() + 32), null);
		g.setColor(Color.white);
		g.setFont(Game.profileInfoFont);
		g.drawImage(icon, 210, 425, null);
		g.drawString(name, (210 + 16) - (fm.stringWidth(name) / 2), 476);
		g.drawString(line1, 285, 427);
		g.drawString(line2, 285, 427 + 25);
		g.drawString(line3, 285, 427 + 50);
		g.drawString(line4, 285, 427 + 75);
	}
}
