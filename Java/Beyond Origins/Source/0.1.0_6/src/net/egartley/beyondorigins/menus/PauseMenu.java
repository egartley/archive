package net.egartley.beyondorigins.menus;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import net.egartley.beyondorigins.files.Save;
import net.egartley.beyondorigins.gfx.ImageManager;
import net.egartley.beyondorigins.main.Game;
import net.egartley.beyondorigins.main.Profile1;
import net.egartley.beyondorigins.main.Profile2;
import net.egartley.beyondorigins.main.Profile3;
import net.egartley.beyondorigins.userInput.MouseMotion;

public class PauseMenu {

	public static boolean isOpen = false;
	private FontMetrics fm;

	private int backToGameState, saveAndQuitState;

	public int getButtonState(int minX, int minY, int width, int height,
			int state) {
		if (MouseMotion.mouseX >= minX && MouseMotion.mouseX < minX + width
				&& MouseMotion.mouseY >= minY
				&& MouseMotion.mouseY < minY + height) {
			state = 2;
			if (Game.mouseIsPressed()) {
				state = 3;
			} else
				state = 2;
		} else
			state = 1;
		return state;
	}

	public void drawButton(Graphics g, int state, int renderX, int renderY,
			int width, int height, String buttonText,
			BufferedImage state1Image, BufferedImage state2Image,
			BufferedImage state3Image, double clickEventType) {
		fm = g.getFontMetrics(Game.buttonTextFont);
		g.setFont(Game.buttonTextFont);
		if (getButtonState(renderX, renderY, width, height, state) == 1) {
			g.drawImage(state1Image, renderX, renderY, width, height, null);
			g.setColor(Game.buttonIdleColor);
			g.drawString(buttonText, (renderX + (state1Image.getWidth() / 2))
					- (fm.stringWidth(buttonText) / 2),
					(renderY + (state1Image.getHeight() / 2) + (13 / 2 - 1)));
		} else if (getButtonState(renderX, renderY, width, height, state) == 2) {
			g.drawImage(state2Image, renderX, renderY, width, height, null);
			g.setColor(Game.buttonSelectedColor);
			g.drawString(buttonText, (renderX + (state1Image.getWidth() / 2))
					- (fm.stringWidth(buttonText) / 2),
					(renderY + (state1Image.getHeight() / 2) + (13 / 2 - 1)));
		} else if (getButtonState(renderX, renderY, width, height, state) == 3) {
			g.drawImage(state3Image, renderX, renderY, width, height, null);
			g.setColor(Game.buttonClickedColor);
			g.drawString(buttonText, (renderX + (state1Image.getWidth() / 2))
					- (fm.stringWidth(buttonText) / 2),
					(renderY + (state1Image.getHeight() / 2) + (13 / 2 - 1)));
			// 1 -----------------------------
			if (clickEventType == 1.1) {
				try {
					if (Game.getMainMenu().currentProfile == 1)
						Profile1.save();
					if (Game.getMainMenu().currentProfile == 2)
						Profile2.save();
					if (Game.getMainMenu().currentProfile == 3)
						Profile3.save();
					Save.dataSave();
				} catch (IOException e) {
					e.printStackTrace();
				}
				isOpen = false;
				Game.isInGame = false;
				Game.endClick();
				saveAndQuitState = 1;
				Game.getMainMenu().menuState = 1;
				Game.getMainMenu().currentProfile = 0;
			} else if (clickEventType == 1.2) {
				isOpen = false;
				backToGameState = 1;
			}
		}
	}

	public void renderMain(Graphics g) {

		g.setColor(new Color(0, 0, 0, 145));
		g.fillRect(0, 0, Game.WIDTH * Game.SCALE, Game.HEIGHT);

		g.setColor(Color.white);
		g.setFont(Game.buttonTextFont);

		// g.drawImage(ImageManager.button2_1, Game.WIDTH - 168, 120, 336, 32, null);
		// g.drawString("Back To Game", 355, 143);
		g.drawImage(ImageManager.button1_1, Game.WIDTH - 168, 168, 160, 32, null);
		g.drawImage(ImageManager.button1_1, Game.WIDTH + 8, 168, 160, 32, null);

		g.drawImage(ImageManager.button1_1, Game.WIDTH - 168, 268, 160, 32, null);
		g.drawImage(ImageManager.button1_1, Game.WIDTH + 8, 268, 160, 32, null);

		g.setColor(Color.gray);
		g.setFont(Game.profileInfoFont);
		g.drawString("More stuff will be added here in the future.", 278, 440);

		drawButton(g, saveAndQuitState, Game.WIDTH
				- (ImageManager.button2_1.getWidth() / 2), 268 + 48, ImageManager.button2_1.getWidth(),
				ImageManager.button2_1.getHeight(),
				"Save and Quit to Title", ImageManager.button2_1, ImageManager.button2_2,
				ImageManager.button2_3, 1.1);

		drawButton(g, backToGameState, Game.WIDTH
				- (ImageManager.button2_1.getWidth() / 2), 120, ImageManager.button2_1.getWidth(),
				ImageManager.button2_1.getHeight(), "Back to Game", ImageManager.button2_1,
				ImageManager.button2_2, ImageManager.button2_3, 1.2);

	}

}
