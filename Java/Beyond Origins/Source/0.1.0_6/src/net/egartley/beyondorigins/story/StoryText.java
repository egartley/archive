package net.egartley.beyondorigins.story;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;

import net.egartley.beyondorigins.main.Game;
import net.egartley.beyondorigins.userInput.KeyManager;

public class StoryText {
	
	private static String l1, l2, l3, l4, l5, l6, l7;
	private static FontMetrics fm;
	public static int overlay = 255;

	public boolean requested = false;
	public boolean forward = false;

	public void request(String line1, String line2, String line3,
			String line4, String line5, String line6, String line7) {
		l1 = line1;
		l2 = line2;
		l3 = line3;
		l4 = line4;
		l5 = line5;
		l6 = line6;
		l7 = line7;
		requested = true;
	}

	public void render(Graphics g) throws InterruptedException {
		g.setColor(Color.black);
		g.fillRect(0, 0, Game.width, Game.height);
		g.setFont(Game.buttonTextFont);
		fm = g.getFontMetrics(Game.buttonTextFont);
		g.setColor(Color.white);
		g.drawString(l1, Game.width / 2 - (fm.stringWidth(l1) / 2), 110);
		g.drawString(l2, Game.width / 2 - (fm.stringWidth(l2) / 2), 110 + (45 * 1));
		g.drawString(l3, Game.width / 2 - (fm.stringWidth(l3) / 2), 110 + (45 * 2));
		g.drawString(l4, Game.width / 2 - (fm.stringWidth(l4) / 2), 110 + (45 * 3));
		g.drawString(l5, Game.width / 2 - (fm.stringWidth(l5) / 2), 110 + (45 * 4));
		g.drawString(l6, Game.width / 2 - (fm.stringWidth(l6) / 2), 110 + (45 * 5));
		g.drawString(l7, Game.width / 2 - (fm.stringWidth(l7) / 2), 110 + (45 * 6));
		
		g.drawString("Press enter to continue...", 600, 535);
		if (overlay != 0) {
			overlay-= 1;
		}
		Color c = new Color(0, 0, 0, overlay);
		g.setColor(c);
		g.fillRect(0, 0, Game.width / 2 * 2, Game.height);
		if (overlay == 0 && forward == false) {
			Thread.sleep(2000);
			forward = true;
		}
		if (forward && KeyManager.enterPressed) {
			overlay = 255;
			requested = false;
			forward = false;
		}
	}

}
