package net.egartley.beyondorigins.menus;

import java.awt.Graphics;

import net.egartley.beyondorigins.main.Game;

public class Overview {
	
	public Overview() {
		
	}
	
	public static void render(Graphics g) {
		g.drawImage(Game.mapOverview, 0, 0, null);
	}

}
