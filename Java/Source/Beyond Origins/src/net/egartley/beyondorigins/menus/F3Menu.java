package net.egartley.beyondorigins.menus;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;

import net.egartley.beyondorigins.main.Game;
import net.egartley.beyondorigins.userInput.MouseMotion;

public class F3Menu {
	public static boolean f3menu = false;
	private static Color c = new Color(64, 64, 64, 136);
	private static FontMetrics fm;

	private static void drawText(Graphics g, String t, int x, int y) {
		fm = g.getFontMetrics(Game.f3MenuFont);

		g.setColor(c);
		g.fillRect(x - 2, y - fm.getHeight() + 4, fm.stringWidth(t) + 5,
				fm.getHeight() - 1);

		g.setFont(Game.f3MenuFont);
		g.setColor(Color.white);
		g.drawString(t, x, y);
	}

	public static void render(Graphics g) {
		g.setFont(Game.f3MenuFont);
		g.setColor(Color.white);
		drawText(g, Game.title, 450, 25);
		drawText(g, Game.copyright, 450, 40);
		drawText(g, "FPS: " + Game.currentFrames + "   " + "Current Profile: "
				+ Game.getMainMenu().currentProfile, 450, 55);
		if (Game.isInGame) {
			drawText(g, "Up: " + Game.getPlayer().isNextTileValid(1) + "   Down: "
					+ Game.getPlayer().isNextTileValid(3), 450, 70);
			drawText(g, "Left: " + Game.getPlayer().isNextTileValid(4)
					+ "   Right: " + Game.getPlayer().isNextTileValid(2), 450, 85);	
		} else {
			drawText(g, "Up: null   Down: null", 450, 70);
			drawText(g, "Left: null   Right: null", 450, 85);
		}
		drawText(g,
				"Player X: " + Game.getPlayer().x + "   " + "Player Y: "
						+ Game.getPlayer().y, 650, 25);
		drawText(g, "Tile X: " + Game.getPlayer().tileX + "   " + "Tile Y: "
				+ Game.getPlayer().tileY, 650, 40);
		drawText(
				g,
				"Map X: " + Game.getMap().x + "   " + " Map Y: "
						+ Game.getMap().y, 650, 55);
		drawText(g, "Mse X: " + MouseMotion.mouseX + "   " + "Mse Y: "
				+ MouseMotion.mouseY, 650, 70);
		drawText(g, "Current Tile ID: " + Game.getPlayer().getCurrentTile() + "   Count: " + Game.getPlayer().moveCount, 650, 85);
	}
}
