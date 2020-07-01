package net.egartley.beyondorigins.gfx;

import java.awt.image.BufferedImage;

import net.egartley.beyondorigins.main.Game;

public class ImageManager {

	public static BufferedImage dialogueBox, player_hud;

	public static BufferedImage[] player_up = new BufferedImage[5],
			player_down = new BufferedImage[5],
			player_left = new BufferedImage[5],
			player_right = new BufferedImage[5],
			player_up_attack = new BufferedImage[5],
			player_down_attack = new BufferedImage[5],
			player_left_attack = new BufferedImage[5],
			player_right_attack = new BufferedImage[5],
			player_up_swim = new BufferedImage[5],
			player_down_swim = new BufferedImage[5],
			player_left_swim = new BufferedImage[5],
			player_right_swim = new BufferedImage[5];

	public static BufferedImage grassFull, grassBarrier, playerHouse, tree;
	public static BufferedImage water[] = new BufferedImage[5];

	public static BufferedImage[] cow_up = new BufferedImage[5],
			cow_down = new BufferedImage[5], cow_left = new BufferedImage[5],
			cow_right = new BufferedImage[5];

	public static BufferedImage[] testDummy_up = new BufferedImage[5],
			testDummy_down = new BufferedImage[5],
			testDummy_left = new BufferedImage[5],
			testDummy_right = new BufferedImage[5];
	public static BufferedImage[] paige_up = new BufferedImage[5],
			paige_down = new BufferedImage[5],
			paige_left = new BufferedImage[5],
			paige_right = new BufferedImage[5];

	public static BufferedImage button1_1, button1_2, button1_3, button2_1,
			button2_2, button2_3, profileSquare, profileEmpty,
			profileSelection, cloud1, cloud2, cloud3;

	public static BufferedImage inventory1, inventory2, inventory3, tab1_1,
			tab2_1, tab3_1, tab1_2, tab2_2, tab3_2, arrow_1, arrow_2, quest_1,
			quest_2;

	public static short hpCropX = 81, expCropX = 83;

	public ImageManager() {
		playerSetUp();
		widgetSetUp();
		grassMapSetUp();
		entitySetUp();
		menuSetUp();
		inventorySetUp();
	}

	public BufferedImage getCropped(BufferedImage sheet, int x, int y, int w,
			int h) {
		return sheet.getSubimage(x, y, w, h);
	}

	private void playerSetUp() {
		player_down[1] = getCropped(Game.playerSheet, 0, 0, 32, 32);
		player_down[2] = getCropped(Game.playerSheet, 0, 32, 32, 32);
		player_down[3] = getCropped(Game.playerSheet, 0, 64, 32, 32);
		player_down[4] = getCropped(Game.playerSheet, 0, 96, 32, 32);
		player_up[1] = getCropped(Game.playerSheet, 32, 0, 32, 32);
		player_up[2] = getCropped(Game.playerSheet, 32, 32, 32, 32);
		player_up[3] = getCropped(Game.playerSheet, 32, 64, 32, 32);
		player_up[4] = getCropped(Game.playerSheet, 32, 96, 32, 32);
		player_left[1] = getCropped(Game.playerSheet, 64, 0, 32, 32);
		player_left[2] = getCropped(Game.playerSheet, 64, 32, 32, 32);
		player_left[3] = getCropped(Game.playerSheet, 64, 64, 32, 32);
		player_left[4] = getCropped(Game.playerSheet, 64, 96, 32, 32);
		player_right[1] = getCropped(Game.playerSheet, 96, 0, 32, 32);
		player_right[2] = getCropped(Game.playerSheet, 96, 32, 32, 32);
		player_right[3] = getCropped(Game.playerSheet, 96, 64, 32, 32);
		player_right[4] = getCropped(Game.playerSheet, 96, 96, 32, 32);
		player_down_attack[1] = getCropped(Game.playerSheet, 128, 0, 32, 32);
		player_down_attack[2] = getCropped(Game.playerSheet, 128, 32, 32, 32);
		player_down_attack[3] = getCropped(Game.playerSheet, 128, 64, 32, 32);
		player_down_attack[4] = getCropped(Game.playerSheet, 128, 96, 32, 32);
		player_up_attack[1] = getCropped(Game.playerSheet, 160, 0, 32, 32);
		player_up_attack[2] = getCropped(Game.playerSheet, 160, 32, 32, 32);
		player_up_attack[3] = getCropped(Game.playerSheet, 160, 64, 32, 32);
		player_up_attack[4] = getCropped(Game.playerSheet, 160, 96, 32, 32);
		player_left_attack[1] = getCropped(Game.playerSheet, 192, 0, 32, 32);
		player_left_attack[2] = getCropped(Game.playerSheet, 192, 32, 32, 32);
		player_left_attack[3] = getCropped(Game.playerSheet, 192, 64, 32, 32);
		player_left_attack[4] = getCropped(Game.playerSheet, 192, 96, 32, 32);
		player_right_attack[1] = getCropped(Game.playerSheet, 224, 0, 32, 32);
		player_right_attack[2] = getCropped(Game.playerSheet, 224, 32, 32, 32);
		player_right_attack[3] = getCropped(Game.playerSheet, 224, 64, 32, 32);
		player_right_attack[4] = getCropped(Game.playerSheet, 224, 96, 32, 32);
		player_down_swim[1] = getCropped(Game.playerSheet, 128 * 2, 0, 32, 32);
		player_down_swim[2] = getCropped(Game.playerSheet, 128 * 2, 32, 32, 32);
		player_down_swim[3] = getCropped(Game.playerSheet, 128 * 2, 64, 32, 32);
		player_down_swim[4] = getCropped(Game.playerSheet, 128 * 2, 96, 32, 32);
		player_up_swim[1] = getCropped(Game.playerSheet, 160 + 128, 0, 32, 32);
		player_up_swim[2] = getCropped(Game.playerSheet, 160 + 128, 32, 32, 32);
		player_up_swim[3] = getCropped(Game.playerSheet, 160 + 128, 64, 32, 32);
		player_up_swim[4] = getCropped(Game.playerSheet, 160 + 128, 96, 32, 32);
		player_left_swim[1] = getCropped(Game.playerSheet, 192 + 128, 0, 32, 32);
		player_left_swim[2] = getCropped(Game.playerSheet, 192 + 128, 32, 32, 32);
		player_left_swim[3] = getCropped(Game.playerSheet, 192 + 128, 64, 32, 32);
		player_left_swim[4] = getCropped(Game.playerSheet, 192 + 128, 96, 32, 32);
		player_right_swim[1] = getCropped(Game.playerSheet, 224 + 128, 0, 32, 32);
		player_right_swim[2] = getCropped(Game.playerSheet, 224 + 128, 32, 32, 32);
		player_right_swim[3] = getCropped(Game.playerSheet, 224 + 128, 64, 32, 32);
		player_right_swim[4] = getCropped(Game.playerSheet, 224 + 128, 96, 32, 32);
	}

	public void widgetSetUp() {
		dialogueBox = getCropped(Game.widgetSheet, 0, 0, 512, 160);
		player_hud = getCropped(Game.widgetSheet, 0, 160, 160, 64);
	}

	private void grassMapSetUp() {
		grassFull = getCropped(Game.terrain1Sheet, 0, 0, 32, 32);
		grassBarrier = getCropped(Game.terrain1Sheet, 32, 32, 32, 32);
		tree = getCropped(Game.terrain1Sheet, 0, 32, 32, 32);
		water[1] = getCropped(Game.terrain1Sheet, 32, 0, 32, 32);
		water[2] = getCropped(Game.terrain1Sheet, 64, 0, 32, 32);
		water[3] = getCropped(Game.terrain1Sheet, 96, 0, 32, 32);
		water[4] = getCropped(Game.terrain1Sheet, 128, 0, 32, 32);
		playerHouse = getCropped(Game.terrain1Sheet, 192, 0, 96, 96);
	}

	private void entitySetUp() {
		cow_down[1] = getCropped(Game.entitySheet, 0, 64, 32, 32);
		cow_down[2] = getCropped(Game.entitySheet, 32, 64, 32, 32);
		cow_down[3] = getCropped(Game.entitySheet, 96, 64, 32, 32);
		cow_down[4] = getCropped(Game.entitySheet, 64, 64, 32, 32);
		cow_up[1] = getCropped(Game.entitySheet, 0, 96, 32, 32);
		cow_up[2] = getCropped(Game.entitySheet, 32, 96, 32, 32);
		cow_up[3] = getCropped(Game.entitySheet, 96, 96, 32, 32);
		cow_up[4] = getCropped(Game.entitySheet, 64, 96, 32, 32);
		cow_left[1] = getCropped(Game.entitySheet, 0, 0, 32, 32);
		cow_left[2] = getCropped(Game.entitySheet, 32, 0, 32, 32);
		cow_left[3] = getCropped(Game.entitySheet, 96, 0, 32, 32);
		cow_left[4] = getCropped(Game.entitySheet, 64, 0, 32, 32);
		cow_right[1] = getCropped(Game.entitySheet, 0, 32, 32, 32);
		cow_right[2] = getCropped(Game.entitySheet, 32, 32, 32, 32);
		cow_right[3] = getCropped(Game.entitySheet, 96, 32, 32, 32);
		cow_right[4] = getCropped(Game.entitySheet, 64, 32, 32, 32);

		testDummy_down[1] = getCropped(Game.entitySheet, 0, 0, 32, 32);
		testDummy_down[2] = getCropped(Game.entitySheet, 0, 32, 32, 32);
		testDummy_down[3] = getCropped(Game.entitySheet, 0, 64, 32, 32);
		testDummy_down[4] = getCropped(Game.entitySheet, 0, 96, 32, 32);
		testDummy_up[1] = getCropped(Game.entitySheet, 32, 0, 32, 32);
		testDummy_up[2] = getCropped(Game.entitySheet, 32, 32, 32, 32);
		testDummy_up[3] = getCropped(Game.entitySheet, 32, 64, 32, 32);
		testDummy_up[4] = getCropped(Game.entitySheet, 32, 96, 32, 32);
		testDummy_left[1] = getCropped(Game.entitySheet, 64, 0, 32, 32);
		testDummy_left[2] = getCropped(Game.entitySheet, 64, 32, 32, 32);
		testDummy_left[3] = getCropped(Game.entitySheet, 64, 64, 32, 32);
		testDummy_left[4] = getCropped(Game.entitySheet, 64, 96, 32, 32);
		testDummy_right[1] = getCropped(Game.entitySheet, 96, 0, 32, 32);
		testDummy_right[2] = getCropped(Game.entitySheet, 96, 32, 32, 32);
		testDummy_right[3] = getCropped(Game.entitySheet, 96, 64, 32, 32);
		testDummy_right[4] = getCropped(Game.entitySheet, 96, 96, 32, 32);

		paige_down[1] = getCropped(Game.entitySheet, 128, 0, 32, 32);
		paige_down[2] = getCropped(Game.entitySheet, 128, 32, 32, 32);
		paige_down[3] = getCropped(Game.entitySheet, 128, 64, 32, 32);
		paige_down[4] = getCropped(Game.entitySheet, 128, 96, 32, 32);
		paige_up[1] = getCropped(Game.entitySheet, 160, 0, 32, 32);
		paige_up[2] = getCropped(Game.entitySheet, 160, 32, 32, 32);
		paige_up[3] = getCropped(Game.entitySheet, 160, 64, 32, 32);
		paige_up[4] = getCropped(Game.entitySheet, 160, 96, 32, 32);
		paige_left[1] = getCropped(Game.entitySheet, 192, 0, 32, 32);
		paige_left[2] = getCropped(Game.entitySheet, 192, 32, 32, 32);
		paige_left[3] = getCropped(Game.entitySheet, 192, 64, 32, 32);
		paige_left[4] = getCropped(Game.entitySheet, 192, 96, 32, 32);
		paige_right[1] = getCropped(Game.entitySheet, 224, 0, 32, 32);
		paige_right[2] = getCropped(Game.entitySheet, 224, 32, 32, 32);
		paige_right[3] = getCropped(Game.entitySheet, 224, 64, 32, 32);
		paige_right[4] = getCropped(Game.entitySheet, 224, 96, 32, 32);
	}

	private void menuSetUp() {
		button1_1 = getCropped(Game.mainmenuSheet, 0, 0, 160, 32);
		button1_2 = getCropped(Game.mainmenuSheet, 0, 32, 160, 32);
		button1_3 = getCropped(Game.mainmenuSheet, 0, 64, 160, 32);
		button2_1 = getCropped(Game.mainmenuSheet, 0, 96, 336, 32);
		button2_2 = getCropped(Game.mainmenuSheet, 0, 128, 336, 32);
		button2_3 = getCropped(Game.mainmenuSheet, 0, 160, 336, 32);
		profileSquare = getCropped(Game.mainmenuSheet, 288, 0, 96, 96);
		profileEmpty = getCropped(Game.mainmenuSheet, 384, 0, 64, 64);
		profileSelection = getCropped(Game.mainmenuSheet, 0, 192, 300, 117);
		cloud1 = getCropped(Game.mainmenuSheet, 160, 0, 128, 96);
		cloud2 = getCropped(Game.mainmenuSheet, 160, 0, 128, 96);
		cloud3 = getCropped(Game.mainmenuSheet, 160, 0, 128, 96);
	}

	private void inventorySetUp() {
		inventory1 = getCropped(Game.inventorySheet, 0, 0, 416, 288);
		inventory2 = getCropped(Game.inventorySheet, 416, 0, 416, 288);
		inventory3 = getCropped(Game.inventorySheet, 0, 288, 416, 288);
		tab1_1 = getCropped(Game.inventorySheet, 832, 0, 64, 64);
		tab2_1 = getCropped(Game.inventorySheet, 896, 0, 64, 64);
		tab3_1 = getCropped(Game.inventorySheet, 960, 0, 64, 64);
		tab1_2 = getCropped(Game.inventorySheet, 832, 64, 64, 64);
		tab2_2 = getCropped(Game.inventorySheet, 896, 64, 64, 64);
		tab3_2 = getCropped(Game.inventorySheet, 960, 64, 64, 64);
		arrow_1 = getCropped(Game.inventorySheet, 832, 128, 32, 64);
		arrow_2 = getCropped(Game.inventorySheet, 864, 128, 32, 64);
		quest_1 = getCropped(Game.inventorySheet, 416, 288, 241, 39);
		quest_2 = getCropped(Game.inventorySheet, 416, 352, 241, 39);
	}

}