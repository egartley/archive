package net.egartley.beyondorigins.menus;

import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import net.egartley.beyondorigins.files.Load;
import net.egartley.beyondorigins.files.Save;
import net.egartley.beyondorigins.gfx.ImageManager;
import net.egartley.beyondorigins.main.Game;
import net.egartley.beyondorigins.main.Profile1;
import net.egartley.beyondorigins.main.Profile2;
import net.egartley.beyondorigins.main.Profile3;
import net.egartley.beyondorigins.threads.Noti;
import net.egartley.beyondorigins.userInput.MouseMotion;
import net.egartley.beyondorigins.windows.About;
import net.egartley.beyondorigins.windows.Keys;

public class Options {

	public static String autoSaveToggle = "On", tdToggle = "Off",
			soundToggle = "On";
	private byte state;
	private About ab = new About();
	private Keys k = new Keys();
	private FontMetrics fm;

	public Options() {
		Load.loadData(Game.dataPath);
		if (autoSaveToggle == "On" && Game.autoSave == false) {
			autoSaveToggle = "Off";
		} else if (autoSaveToggle == "Off" && Game.autoSave == true) {
			autoSaveToggle = "On";
		}
		if (tdToggle == "On" && Game.dummy == false) {
			tdToggle = "Off";
		} else if (tdToggle == "Off" && Game.dummy == true) {
			tdToggle = "On";
		}
		if (soundToggle == "On" && Game.sound == false) {
			soundToggle = "Off";
		} else if (soundToggle == "Off" && Game.sound == true) {
			soundToggle = "On";
		}
	}

	private int getPosX(int num) {
		int re = 0;
		if (num == 0) {
			re = 72;
		} else if (num == 1) {
			re = 424;
		}
		return re;
	}

	private int getPosY(int num) {
		int re = 100;
		if (num == 0) {
			re += 0;
		} else {
			for (int i = 0; i < num; i++) {
				re += 32;
				re += 16;
			}
		}
		return re;
	}

	private byte getButtonState(int x, int y, int width, int height, byte state) {
		// state 2 is
		// state 1 is idle
		// state 3 is clicked
		if (MouseMotion.mouseX >= x && MouseMotion.mouseX < x + width
				&& MouseMotion.mouseY >= y && MouseMotion.mouseY < y + height) {
			state = 2;
			if (Game.mouseIsPressed()) {
				state = 3;
			} else
				state = 2;
		} else
			state = 1;
		return state;
	}

	private void drawButton(Graphics g, int x, int y, int width, int height,
			String buttonText, BufferedImage state1Image,
			BufferedImage state2Image, BufferedImage state3Image,
			double clickEventType) {
		fm = g.getFontMetrics(Game.buttonTextFont);

		g.setFont(Game.buttonTextFont);
		if (getButtonState(x, y, width, height, state) == 1) {
			g.drawImage(state1Image, x, y, width, height, null);
			g.setColor(Game.buttonIdleColor);
			g.drawString(
					buttonText,
					(x + (state1Image.getWidth() / 2))
							- (fm.stringWidth(buttonText) / 2), (y
							+ (state1Image.getHeight() / 2) + (13 / 2 - 1)));
		} else if (getButtonState(x, y, width, height, state) == 2) {
			g.drawImage(state2Image, x, y, width, height, null);
			g.setColor(Game.buttonSelectedColor);
			g.drawString(
					buttonText,
					(x + (state1Image.getWidth() / 2))
							- (fm.stringWidth(buttonText) / 2), (y
							+ (state1Image.getHeight() / 2) + (13 / 2 - 1)));
		} else if (getButtonState(x, y, width, height, state) == 3) {
			g.drawImage(state3Image, x, y, width, height, null);
			g.setColor(Game.buttonClickedColor);
			g.drawString(
					buttonText,
					(x + (state1Image.getWidth() / 2))
							- (fm.stringWidth(buttonText) / 2), (y
							+ (state1Image.getHeight() / 2) + (13 / 2 - 1)));
			clickEventHandler(clickEventType);
		}
	}

	private void clickEventHandler(double e) {
		if (e == 4.1) {
			m4AutoSave();
		} else if (e == 4.2) {
			m4AddOns();
		} else if (e == 4.3) {
			m4TestDummy();
		} else if (e == 4.4) {
			m4Reload();
		} else if (e == 4.5) {
			m4About();
		} else if (e == 4.6) {
			m4ResetFiles();
		} else if (e == 4.7) {
			m4Keys();
		} else if (e == 4.8){
			m4Sound();
		} else if (e == 4.0) {
			m4Back();
		}
	}

	public void render(Graphics g) {
		fm = g.getFontMetrics(Game.profileInfoFont);
		// Auto Save ---------------------------------------------
		drawButton(g, getPosX(0), getPosY(0),
				ImageManager.button2_1.getWidth(),
				ImageManager.button2_1.getHeight(), "Auto Save: "
						+ autoSaveToggle, ImageManager.button2_1,
				ImageManager.button2_2, ImageManager.button2_3, 4.1);
		g.setColor(Game.profileInfoColor);
		g.setFont(Game.profileInfoFont);
		// TestDummy ---------------------------------------------
		drawButton(g, getPosX(1), getPosY(0),
				ImageManager.button2_1.getWidth(),
				ImageManager.button2_1.getHeight(), "Test Dummy: " + tdToggle,
				ImageManager.button2_1, ImageManager.button2_2,
				ImageManager.button2_3, 4.3);
		// Reload Graphics ---------------------------------------
		drawButton(g, getPosX(0), getPosY(1),
				ImageManager.button2_1.getWidth(),
				ImageManager.button2_1.getHeight(), "Reload Graphics",
				ImageManager.button2_1, ImageManager.button2_2,
				ImageManager.button2_3, 4.4);
		// Reset Files -------------------------------------------
		drawButton(g, getPosX(1), getPosY(1),
				ImageManager.button2_1.getWidth(),
				ImageManager.button2_1.getHeight(), "Reset Files",
				ImageManager.button2_1, ImageManager.button2_2,
				ImageManager.button2_3, 4.6);
		// Sound -------------------------------------------------
		drawButton(g, getPosX(0), getPosY(2),
				ImageManager.button2_1.getWidth(),
				ImageManager.button2_1.getHeight(), "Sound: " + soundToggle,
				ImageManager.button2_1, ImageManager.button2_2,
				ImageManager.button2_3, 4.8);
		// About -------------------------------------------------
		drawButton(g, (Game.width / 2) + 8, Game.HEIGHT - 128,
				ImageManager.button1_1.getWidth(),
				ImageManager.button1_1.getHeight(), "About...",
				ImageManager.button1_1, ImageManager.button1_2,
				ImageManager.button1_3, 4.5);
		// Add-Ons -----------------------------------------------
		drawButton(g, (Game.width / 2)
				- ((ImageManager.button1_1.getWidth() * 2 + 24)),
				Game.HEIGHT - 128, ImageManager.button1_1.getWidth(),
				ImageManager.button1_1.getHeight(), "Add-Ons...",
				ImageManager.button1_1, ImageManager.button1_2,
				ImageManager.button1_3, 4.2);
		// Keys -----------------------------------------------
		drawButton(g, (Game.width / 2)
				- ((ImageManager.button1_1.getWidth() + 8)), Game.HEIGHT - 128,
				ImageManager.button1_1.getWidth(),
				ImageManager.button1_1.getHeight(), "Keys...",
				ImageManager.button1_1, ImageManager.button1_2,
				ImageManager.button1_3, 4.7);
		// Back --------------------------------------------------
		drawButton(g, (Game.width / 2)
				+ ((ImageManager.button1_1.getWidth() + 24)),
				Game.HEIGHT - 128, ImageManager.button1_1.getWidth(),
				ImageManager.button1_1.getHeight(), "Back",
				ImageManager.button1_1, ImageManager.button1_2,
				ImageManager.button1_3, 4.0);
	}

	private void m4AutoSave() {
		if (autoSaveToggle == "On") {
			autoSaveToggle = "Off";
			Game.autoSave = false;
		} else if (autoSaveToggle == "Off") {
			autoSaveToggle = "On";
			Game.autoSave = true;
		}
		Game.endClick();
		try {
			Save.dataSave();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void m4TestDummy() {
		if (tdToggle == "On") {
			tdToggle = "Off";
			Game.dummy = false;
		} else if (tdToggle == "Off") {
			tdToggle = "On";
			Game.dummy = true;
		}
		Game.endClick();
		try {
			Save.dataSave();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void m4Sound() {
		if (soundToggle == "On") {
			soundToggle = "Off";
			Game.sound = false;
		} else if (soundToggle == "Off") {
			soundToggle = "On";
			Game.sound = true;
		}
		Game.endClick();
		try {
			Save.dataSave();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void m4AddOns() {
		// a.createWindow();
		Noti.startNotify(Noti.cms);
		Game.endClick();
	}

	private void m4Reload() {
		Game.loadGfx();
		Noti.startNotify(Noti.gre);
		Game.endClick();
	}

	private void m4About() {
		ab.createWindow();
		Game.endClick();
	}

	private void m4ResetFiles() {
		if (!Profile1.file.exists() && !Profile2.file.exists()
				&& !Profile3.file.exists() && !Save.data.exists()
				&& !Save.keys.exists()) {
			Noti.fre.setText("No files were detected, but all values were reset!");
		} else if ((Profile1.file.delete() || Profile2.file.delete() || Profile3.file
				.delete()) && Save.data.delete() && Save.keys.delete()) {
			Noti.fre.setText("All files deleted and all values reset!");
		} else {
			Profile1.file.delete();
			Profile2.file.delete();
			Profile3.file.delete();
			Save.data.delete();
			Save.keys.delete();
			Noti.fre.setText("Some files deleted and all values were reset!");
		}
		Save.dataReset();
		Save.profileReset();
		Game.logger.log.delete();
		Noti.startNotify(Noti.fre);
		Game.endClick();
	}

	private void m4Keys() {
		k.createWindow();
		Game.endClick();
	}

	private void m4Back() {
		Game.getMainMenu().save1State = 0;
		Game.getMainMenu().save2State = 0;
		Game.getMainMenu().save3State = 0;
		Game.getMainMenu().currentProfile = 0;
		Game.getMainMenu().menuState = 1;
		Game.endClick();
	}

}
