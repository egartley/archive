package net.egartley.beyondorigins.buildings;

import java.awt.*;

import net.egartley.beyondorigins.main.Game;

public class PlayerHouse {
	
	public static int rX;
	public static int rY;
	public static int startX = 96;
	public static int startY = 96;
	public int ID = 1;
	
	public static int overlay = 128;
	public static boolean isInside = false;

	public static void init() {
		
	}

	public static void tick() {
		
	}
	
	public static void enter() {
		isInside = true;
		Game.getPlayer().isInBuilding = true;
		Game.getPlayer().x = Game.pMidX;
		Game.getPlayer().y = Game.height - 120;
	}
	
	public static void exit() {
		isInside = false;
		Game.getPlayer().isInBuilding = false;
		Game.getPlayer().x = 129;
		Game.getPlayer().y = 197;
	}

	public static void render(Graphics g) {
		g.setColor(new Color(0, 0, 0, overlay));
		g.fillRect(0, 0, Game.width * 2, Game.height);
		g.drawImage(Game.inside1Image, Game.width / 2 - 224, Game.height / 2 - 176, null);
	}
}