package net.egartley.beyondorigins.inventory;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import net.egartley.beyondorigins.gfx.ImageManager;
import net.egartley.beyondorigins.main.Game;
import net.egartley.beyondorigins.quests.Quest;
import net.egartley.beyondorigins.userInput.MouseMotion;

public class Inventory {
	public static boolean invOpen = false;
	public static int tabSelection = 1;
	public static int tab1State, tab2State, tab3State;

	public Inventory() {
		Quest.init();
	}

	public int getTabState(int x, int y, int w, int h, int state, int tabNumber) {
		// state 2 is selected
		// state 1 is idle
		if (MouseMotion.mouseX >= x && MouseMotion.mouseX < x + w && MouseMotion.mouseY >= y
				&& MouseMotion.mouseY < y + (h - 28) && Game.mouseIsPressed()) {
			if (tabNumber == 1) {
				tab1State = 2;
				tab2State = 1;
				tab3State = 1;
			} else if (tabNumber == 2) {
				tab2State = 2;
				tab3State = 1;
				tab1State = 1;
			} else if (tabNumber == 3) {
				tab3State = 2;
				tab2State = 1;
				tab1State = 1;
			}
			tabSelection = tabNumber;
		}
		return state;
	}

	public void drawTab(Graphics g, int x, int y, int w, int h, int tabNumber, BufferedImage imageSelected,
			BufferedImage imageUnSelected, boolean includeInventory) {
		g.drawImage(imageUnSelected, x, y, w, h, null);
		if (getTabState(x, y, w, h, tabSelection, tabNumber) == tabNumber) {
			g.drawImage(imageSelected, x, y, w, h, null);
		}
	}

	public void tick() {

	}

	public void render(Graphics g) {
		if (invOpen) {
			g.setColor(new Color(0, 0, 0, (int) 255 / 2));
			g.fillRect(0, 0, Game.width, Game.height);
			if (tabSelection == 1) {
				g.drawImage(ImageManager.inventory1, Game.WIDTH - (ImageManager.inventory1.getWidth() / 2), 135, null);
			}
			if (tabSelection == 2) {
				g.drawImage(ImageManager.inventory2, Game.WIDTH - (ImageManager.inventory1.getWidth() / 2), 135, null);
				Quest.getActiveQuest().render(g);
			}
			if (tabSelection == 3) {
				g.drawImage(ImageManager.inventory3, Game.WIDTH - (ImageManager.inventory1.getWidth() / 2), 135, null);
			}
			drawTab(g, 243, 135, 64, 64, 1, ImageManager.tab1_1, ImageManager.tab1_2, true);
			drawTab(g, 308, 135, 64, 64, 2, ImageManager.tab2_1, ImageManager.tab2_2, true);
			drawTab(g, 373, 135, 64, 64, 3, ImageManager.tab3_1, ImageManager.tab3_2, true);
		}
	}
}