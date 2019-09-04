package net.egartley.beyondorigins.buildings;

import java.awt.*;

import net.egartley.beyondorigins.gfx.ImageManager;
import net.egartley.beyondorigins.main.Game;

public class BuildingRender {

	@SuppressWarnings("static-access")
	public static void init() {
		for (int x = 3; x < 6; x++) {
			for (int y = 3; y < 6; y++) {
				Game.getMap().tiles[x][y] = 99;
			}
		}
	}

	public static int getBuildingID() {
		int returnID = 99;
		if (Game.getPlayer().getCurrentTile() == 98) {
			returnID = 1;
		}
		return returnID;
	}

	public void render(Graphics g) {
		calcRenderCords();
		if (PlayerHouse.rX >= -129 && PlayerHouse.rY >= -129
				&& PlayerHouse.rX <= Game.width
				&& PlayerHouse.rY <= Game.height) {
			g.drawImage(ImageManager.playerHouse, PlayerHouse.rX, PlayerHouse.rY, 96, 96, null);
			if (PlayerHouse.isInside) {
				PlayerHouse.render(g);
			}
		}
	}

	private void calcRenderCords() {
		PlayerHouse.rX = (int) PlayerHouse.startX - Game.getMap().x;
		PlayerHouse.rY = (int) PlayerHouse.startY - Game.getMap().y;
	}
}