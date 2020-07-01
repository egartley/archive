package net.egartley.beyondorigins.threads;

import java.awt.image.*;
import java.io.*;

import javax.imageio.*;

import net.egartley.beyondorigins.buildings.*;
import net.egartley.beyondorigins.entities.*;
import net.egartley.beyondorigins.files.*;
import net.egartley.beyondorigins.gfx.*;
import net.egartley.beyondorigins.inventory.*;
import net.egartley.beyondorigins.main.*;
import net.egartley.beyondorigins.maps.*;
import net.egartley.beyondorigins.menus.*;
import net.egartley.beyondorigins.story.*;

public class Init extends Thread {

	public Init() {
		this.start();
		this.setPriority(NORM_PRIORITY);
	}

	private static BufferedImage loadImage(String path) {
		try {
			BufferedImage reImage = ImageIO.read(new File(path));
			return reImage;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void run() {
		Game.loadingStatus = "Starting up... (1/3)";
		Game.initing = true;
		Game.logger = new Logger();
		Game.logger.log("Game started");
		Game.loadingStatus = "Loading in graphics... (2/3)";
		loadGfx();
		Game.loadingStatus = "Starting classes... (3/3)";
		Game.mainMenu = new MainMenu();
		Game.pauseMenu = new PauseMenu();
		Game.grassm = new GrassMap(Game.mapImage, 0, 0);
		Entity.init();
		Game.inv = new Inventory();
		Game.br = new BuildingRender();
		Game.storyText = new StoryText();
		BuildingRender.init();
		PlayerHouse.init();
		Game.loadingStatus = "Done loading!";
		try {
			Thread.sleep(1200L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Game.initing = false;
	}

	public static void loadGfx() {
		Game.mapImage = loadImage(Game.mainDir + "assets\\grassMap.png");
		Game.playerSheet = loadImage(Game.mainDir + "assets\\player.png");
		Game.terrain1Sheet = loadImage(Game.mainDir + "assets\\terrain1.png");
		Game.mainmenuSheet = loadImage(Game.mainDir + "assets\\mainmenu.png");
		Game.inventorySheet = loadImage(Game.mainDir + "assets\\inventory.png");
		Game.widgetSheet = loadImage(Game.mainDir + "assets\\widgets1.png");
		Game.entitySheet = loadImage(Game.mainDir + "assets\\entities1.png");
		Game.inside1Image = loadImage(Game.mainDir + "assets\\inside1.png");
		Game.logoImage = loadImage(Game.mainDir + "assets\\logo.png");
		Game.creds = loadImage(Game.mainDir + "assets\\creds.png");
		Game.mapOverview = loadImage(Game.mainDir + "assets\\mapOverview.png");
		Game.im = new ImageManager();
		Game.logger.log("Loaded graphics");
	}

}
