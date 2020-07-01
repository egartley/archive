package net.egartley.beyondorigins.quests;

import java.awt.Color;
import java.awt.Graphics;

import net.egartley.beyondorigins.gfx.ImageManager;
import net.egartley.beyondorigins.main.Game;
import net.egartley.beyondorigins.userInput.MouseMotion;

public class TestQuest extends Quest{

	byte state;
	boolean inFocus;
	String title = "Test Quest", desc = "This is a 'quest' for testing.";

	public byte getQuestState(int x, int y, int w, int h, byte state,
			boolean inFocus) {
		if ((MouseMotion.mouseX >= x) && (MouseMotion.mouseX < x + w)
				&& (MouseMotion.mouseY >= y) && (MouseMotion.mouseY < y + h)) {
			if ((!inFocus) && (Game.mouseIsPressed())) {
				state = 2;
				inFocus = true;
			} else if (inFocus) {
				state = 2;
			}
		} else if (inFocus) {
			state = 2;
		} else if (Game.mouseIsPressed()) {
			state = 1;
			inFocus = false;
		}
		return state;
	}

	public void drawQuest(Graphics g, String t, String d, int x, int y) {
		state = getQuestState(x, y, ImageManager.quest_1.getWidth(),
				ImageManager.quest_1.getHeight(), state, inFocus);
		if (state == 1) {
			g.drawImage(ImageManager.quest_1, x, y, null);
		} else if (state == 2) {
			g.drawImage(ImageManager.quest_2, x, y, null);
		}
		g.setFont(Game.questTitleFont);
		g.setColor(new Color(99, 90, 74));
		g.drawString(t, x + 5, y + 16);
		g.setFont(Game.questDescFont);
		g.drawString(d, x + 5, y + 31);
	}

	public void render(Graphics g) {
		drawQuest(g, title, desc, 222, 178);
	}

}
