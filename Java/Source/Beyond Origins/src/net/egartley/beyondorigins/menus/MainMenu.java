package net.egartley.beyondorigins.menus;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import net.egartley.beyondorigins.entities.Cloud;
import net.egartley.beyondorigins.entities.Entity;
import net.egartley.beyondorigins.entities.TestDummy;
import net.egartley.beyondorigins.files.Load;
import net.egartley.beyondorigins.files.Save;
import net.egartley.beyondorigins.gfx.ImageManager;
import net.egartley.beyondorigins.main.Game;
import net.egartley.beyondorigins.main.Profile1;
import net.egartley.beyondorigins.main.Profile2;
import net.egartley.beyondorigins.main.Profile3;
import net.egartley.beyondorigins.userInput.KeyManager;
import net.egartley.beyondorigins.userInput.MouseMotion;
import net.egartley.beyondorigins.windows.Credits;
import net.egartley.beyondorigins.windows.ProfileCreator;

public class MainMenu {

	private FontMetrics fm, fm2;

	public byte menuState = 1;
	public byte state;

	public Cloud cloud1, cloud2, cloud3;

	// state 2
	public byte currentProfile = 0;
	public boolean canPlayProfile = false;
	public boolean canDeleteProfile = false;
	public byte cancelState;
	public byte save1State, save2State, save3State;
	public boolean enterProfile = false;

	// state 3
	public byte yesState, noState;

	private Options o;
	private ProfileCreator proc;
	private Credits c;

	public MainMenu() {
		cloud1 = new Cloud(-195, 135);
		cloud2 = new Cloud(Game.WIDTH * 2 + 195, (Game.HEIGHT / 2)
				- (ImageManager.cloud1.getHeight() / 2));
		cloud3 = new Cloud(-155, Game.HEIGHT - 195);
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
		// 1 ----------------------------------------
		if (e == 1.1) {
			m1Play();
		} else if (e == 1.2) {
			m1Options();
		} else if (e == 1.3) {
			m1Creds();
		} else if (e == 1.4) {
			m1Quit();
		}
		// 2 ----------------------------------------
		if (e == 2.1) {
			try {
				m2PlayProfile();
			} catch (IOException ei) {
				ei.printStackTrace();
			}
		} else if (e == 2.2) {
			menuState = 3;
		} else if (e == 2.3) {
			m2Back();
		}
		// 3 ----------------------------------------
		if (e == 3.1) {
			m3Yes();
		} else if (e == 3.2) {
			m3No();
		}
		// 6 ----------------------------------------
		if (e == 6.1) {
			Game.getPlayer().respawn();
		} else if (e == 6.2) {
			Game.getPlayer().health = Game.getPlayer().maxHealth;
			try {
				if (currentProfile == 1)
					Profile1.save();
				if (currentProfile == 2)
					Profile2.save();
				if (currentProfile == 3)
					Profile3.save();
				Save.dataSave();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			Game.endClick();
			menuState = 1;
			currentProfile = 0;
		}
	}

	private void drawProfile(Graphics g, byte state, int x, int y,
			String lastPlayed, String created, File file, int profileNumber,
			String name, FontMetrics fm) {
		g.drawImage(ImageManager.profileSquare, x, y,
				ImageManager.profileSquare.getWidth(),
				ImageManager.profileSquare.getHeight(), null);
		g.setColor(Game.gameProgressColor);
		g.setFont(Game.gameProgressFont);
		if (file.exists()) {
			g.drawImage(ImageManager.player_down[1],
					((ImageManager.profileSquare.getWidth() / 2) + x)
							- (ImageManager.player_down[1].getWidth()),
					(y + (ImageManager.profileSquare.getHeight() / 2))
							- (ImageManager.player_down[1].getHeight()), 64,
					64, null);
		} else if (!file.exists()) {
			g.drawString("?", ((ImageManager.profileSquare.getWidth() / 2) + x)
					- (fm.stringWidth("?") / 2), y + 62);
		}
		if (currentProfile == profileNumber && state == 3) {
			g.setColor(Color.white);
		} else {
			g.setColor(Game.profileInfoColor);
		}
		g.setFont(Game.profileNameFont);
		g.drawString(name, x + 105, y + 27);
		g.setFont(Game.profileInfoFont);
		g.drawString("Last Played: " + lastPlayed, x + 105, y + 27 + 27);
		g.drawString("Date Created: " + created, x + 105, y + 27 + 27 + 27);
	}

	public void setCurrentProfile(int i) {
		if (i == 1) {
			save1State = 3;
			save2State = 0;
			save3State = 0;
		} else if (i == 2) {
			save1State = 0;
			save2State = 3;
			save3State = 0;
		} else if (i == 3) {
			save1State = 0;
			save2State = 0;
			save3State = 3;
		}
	}

	public void enterGame(boolean first) {
		Game.logger.log("Entering game...");
		Game.isInGame = true;
		menuState = 0;
		Game.isLoading = true;
		KeyManager.enterPressed = false;
		Game.getPlayer().up = false;
		Game.getPlayer().down = false;
		Game.getPlayer().left = false;
		Game.getPlayer().right = false;
		Game.getPlayer().healthBarCheck();
		Game.getPlayer().fixPos();
		if (first) {
			Game.setProgress(1);
			Game.getStoryText().request(
					"Our story begins within a",
					"town called " + Game.townName + ". "
							+ Game.getPlayer().name + " has",
					"been told to go see his friend, Paige.", "",
					"Go now, " + Game.getPlayer().name + ".", "", "- ???");
		}
		Entity.checkData();
		Game.endClick();
	}

	public void tick() {
		cloud1.tick(Game.width, 0.3, 1);
		cloud2.tick(-155, 0.4, 0);
		cloud3.tick(Game.width + 145, 0.2, 1);
	}

	private void profileCheck() {

		// System.out.println(Profile1.backup_name);
		if (Profile1.file.exists() == false) {
			Profile1.name = "Play To Create Me";
		} else if (Profile1.file.exists() == true) {
			Profile1.name = Profile1.backup_name;
		}

		if (!Profile2.file.exists()) {
			Profile2.name = "Play To Create Me";
		} else if (Profile2.file.exists()) {
			Profile2.name = Profile2.backup_name;
		}

		if (!Profile3.file.exists()) {
			Profile3.name = "Play To Create Me";
		} else if (Profile3.file.exists()) {
			Profile3.name = Profile3.backup_name;
		}

		if (save1State == 3 || save2State == 3 || save3State == 3) {
			canPlayProfile = true;
		} else if (save1State == 0 && save2State == 0 && save3State == 0) {
			canPlayProfile = false;
		}

		if ((currentProfile == 1 && !Profile1.file.exists())
				|| ((currentProfile == 2 && !Profile2.file.exists()))
				|| (currentProfile == 3 && !Profile3.file.exists())) {
			canDeleteProfile = false;
		} else if ((currentProfile == 1 && Profile1.file.exists())
				|| ((currentProfile == 2 && Profile2.file.exists()))
				|| (currentProfile == 3 && Profile3.file.exists())) {
			canDeleteProfile = true;
		} else {
			canDeleteProfile = false;
		}

	}

	public void render(Graphics g) {

		g.setColor(Game.skyColor);
		g.fillRect(0, 0, Game.width, Game.height);

		cloud1.render(g);
		cloud2.render(g);
		cloud3.render(g);

		if (menuState == 1) {
			renderState1(g);
		} else if (menuState == 2) {
			renderState2(g);
		} else if (menuState == 3) {
			renderState3(g);
		} else if (menuState == 4) {
			renderState4(g);
		} else if (menuState == 5) {
			// y u no renderState5();??!?!!?
		} else if (menuState == 6) {
			renderState6(g);
		}

	}

	// --MAIN v

	private void renderState1(Graphics g) {

		fm = g.getFontMetrics(Game.profileInfoFont);
		fm2 = g.getFontMetrics(Game.buttonTextFont);

		// logo
		g.drawImage(Game.logoImage,
				(Game.width / 2) - (Game.logoImage.getWidth()), Game.height / 2
						- Game.logoImage.getWidth() - 45,
				Game.logoImage.getWidth() * 2, Game.logoImage.getHeight() * 2,
				null);

		// bottom corner(s) text (version, copyright)
		g.setFont(Game.buttonTextFont);
		g.setColor(Color.white);
		g.drawString(Game.title, 5, Game.height - 13);
		g.drawString(Game.copyright,
				Game.width - (fm2.stringWidth(Game.copyright) + 10),
				Game.height - 13);

		// play button
		drawButton(g, (Game.width / 2) - 168, Game.height / 2, 336, 32, "Play",
				ImageManager.button2_1, ImageManager.button2_2,
				ImageManager.button2_3, 1.1);

		// options button
		drawButton(g, (Game.width / 2) - 168, Game.height / 2 + 48,
				ImageManager.button2_1.getWidth(),
				ImageManager.button2_1.getHeight(), "Options",
				ImageManager.button2_1, ImageManager.button2_2,
				ImageManager.button2_3, 1.2);

		// quit button
		drawButton(g, (Game.width / 2) - 168, Game.height / 2 + 48 + 48,
				ImageManager.button2_1.getWidth(),
				ImageManager.button2_1.getHeight(), "Quit",
				ImageManager.button2_1, ImageManager.button2_2,
				ImageManager.button2_3, 1.4);

	}

	// --PROFILE SELECTION v

	private void renderState2(Graphics g) {

		fm = g.getFontMetrics(Game.gameProgressFont);

		g.setFont(Game.profileInfoFont);
		g.setColor(Game.profileInfoColor);

		// selection
		// ---------------------------------------------------------------
		if (save1State == 3) {
			g.drawImage(ImageManager.profileSelection, 104, 217 - 110, 300,
					117, null);
			currentProfile = 1;
			profileCheck();
		} else if (save2State == 3) {
			g.drawImage(ImageManager.profileSelection, 104, 217, 300, 117, null);
			currentProfile = 2;
			profileCheck();
		} else if (save3State == 3) {
			g.drawImage(ImageManager.profileSelection, 104, 217 + 110, 300,
					117, null);
			currentProfile = 3;
			profileCheck();
		}

		// profiles
		// ---------------------------------------------------------------
		drawProfile(
				g,
				save1State,
				110,
				((Game.height / 2) - ImageManager.profileSquare.getHeight() / 2) - 110,
				Profile1.lastPlayed, Profile1.made, Profile1.file, 1,
				Profile1.name, fm);

		drawProfile(g, save2State, 110, (Game.height / 2)
				- ImageManager.profileSquare.getHeight() / 2,
				Profile2.lastPlayed, Profile2.made, Profile2.file, 2,
				Profile2.name, fm);

		drawProfile(
				g,
				save3State,
				110,
				((Game.height / 2) - ImageManager.profileSquare.getHeight() / 2) + 110,
				Profile3.lastPlayed, Profile3.made, Profile3.file, 3,
				Profile3.name, fm);

		fm2 = g.getFontMetrics(Game.buttonTextFont);

		// play profile
		// -------------------------------------------------------------
		if (canPlayProfile) {
			drawButton(g, Game.width - 110 - 128, Game.height / 2 - 48 - 16,
					ImageManager.button1_1.getWidth(),
					ImageManager.button1_1.getHeight(), "Play Profile",
					ImageManager.button1_1, ImageManager.button1_2,
					ImageManager.button1_3, 2.1);
		} else if (!canPlayProfile) {
			g.setFont(Game.buttonTextFont);
			g.drawImage(ImageManager.button1_3, Game.width - 110 - 128,
					Game.height / 2 - 48 - 16,
					ImageManager.button1_3.getWidth(),
					ImageManager.button1_3.getHeight(), null);
			g.setColor(Game.buttonClickedColor);
			g.drawString("Play Profile",
					Game.width - 128 - 110 + 29,
					229);
		}

		// delete
		// -------------------------------------------------------------------------
		if (canDeleteProfile) {
			drawButton(g, Game.width - 110 - 128, Game.height / 2 - 16,
					ImageManager.button1_1.getWidth(),
					ImageManager.button1_1.getHeight(), "Delete",
					ImageManager.button1_1, ImageManager.button1_2,
					ImageManager.button1_3, 2.2);
		} else if (!canDeleteProfile) {
			g.setFont(Game.buttonTextFont);
			g.drawImage(ImageManager.button1_3, Game.width - 110 - 128,
					Game.height / 2 - 16, ImageManager.button1_3.getWidth(),
					ImageManager.button1_3.getHeight(), null);
			g.setColor(Game.buttonClickedColor);
			g.drawString("Delete", Game.width - 189,
					(Game.height / 2 + (13 / 2 - 1)));
		}

		// back
		// ------------------------------------------------------------------------
		drawButton(g, Game.width - 110 - 128, Game.height / 2 - 16 + 48,
				ImageManager.button1_1.getWidth(),
				ImageManager.button1_1.getHeight(), "Back",
				ImageManager.button1_1, ImageManager.button1_2,
				ImageManager.button1_3, 2.3);

	}

	// --ARE YOU SURE v

	private void renderState3(Graphics g) {

		g.setFont(Game.areYouSureFont);
		g.setColor(Game.profileInfoColor);
		g.drawString("Are you sure?", 280, 190);

		g.setFont(Game.buttonTextFont);

		drawButton(g, (Game.width / 2) - 204, 325,
				ImageManager.button1_1.getWidth(),
				ImageManager.button1_1.getHeight(), "Yes",
				ImageManager.button1_1, ImageManager.button1_2,
				ImageManager.button1_3, 3.1);

		drawButton(g, (Game.width / 2) + 35, 325,
				ImageManager.button1_1.getWidth(),
				ImageManager.button1_1.getHeight(), "No",
				ImageManager.button1_1, ImageManager.button1_2,
				ImageManager.button1_3, 3.2);

	}

	// --OPTIONS MAIN v

	private void renderState4(Graphics g) {
		o.render(g);
	}

	// --DEATH SCREEN v

	private void renderState6(Graphics g) {

		g.setFont(Game.buttonTextFont);
		g.setColor(Game.profileInfoColor);

		fm = g.getFontMetrics(Game.buttonTextFont);

		g.drawString("You were killed!",
				(Game.width / 2) - (fm.stringWidth("You were killed!") / 2),
				200);

		drawButton(g, (Game.width / 2)
				- (ImageManager.button2_1.getWidth() / 2), 275,
				ImageManager.button2_1.getWidth(),
				ImageManager.button2_1.getHeight(), "Respawn",
				ImageManager.button2_1, ImageManager.button2_2,
				ImageManager.button2_3, 6.1);

		drawButton(g, (Game.width / 2)
				- (ImageManager.button2_1.getWidth() / 2), 275 + 48,
				ImageManager.button2_1.getWidth(),
				ImageManager.button2_1.getHeight(), "Save and Quit to Title",
				ImageManager.button2_1, ImageManager.button2_2,
				ImageManager.button2_3, 6.2);

	}

	private void m1Play() {
		menuState = 2;
		Load.loadData(Game.dataPath);
		save1State = 0;
		save2State = 0;
		save3State = 0;
		profileCheck();
		Game.endClick();
	}

	public void m1Options() {
		menuState = 4;
		o = new Options();
		Game.endClick();
	}

	private void m1Quit() {
		System.exit(0);
	}

	public void m1Creds() {
		c = new Credits();
		c.createWindow();
		Game.endClick();
	}

	public void m2PlayProfile() throws IOException {
		if (currentProfile == 1) {
			if (Profile1.file.exists()) {
				Load.loadProfile(Game.save1Path, 1);
				enterGame(false);
			} else if (!Profile1.file.exists()) {
				Profile1.name = "";
				Game.getPlayer().typedName = "";
				cancelState = 0;
				save1State = 3;
				proc = new ProfileCreator();
				proc.createWindow(1);
			}
		} else if (currentProfile == 2) {
			if (Profile2.file.exists()) {
				Load.loadProfile(Game.save2Path, 2);
				enterGame(false);
			} else if (!Profile2.file.exists()) {
				Profile2.name = "";
				Game.getPlayer().typedName = "";
				cancelState = 0;
				proc = new ProfileCreator();
				proc.createWindow(2);
			}
		} else if (currentProfile == 3) {
			if (Profile3.file.exists()) {
				Load.loadProfile(Game.save3Path, 3);
				enterGame(false);
			} else if (!Profile3.file.exists()) {
				Profile3.name = "";
				Game.getPlayer().typedName = "";
				cancelState = 0;
				proc = new ProfileCreator();
				proc.createWindow(3);
			}
		}
		Game.endClick();
		TestDummy.reset();
	}

	private void m2DeleteProfile() throws IOException {
		if (currentProfile == 1) {
			Profile1.file.delete();
			Profile1.made = " ";
			Profile1.lastPlayed = " ";
			Save.dataSave();
		} else if (currentProfile == 2) {
			Profile2.file.delete();
			Profile2.made = " ";
			Profile2.lastPlayed = " ";
			Save.dataSave();
		} else if (currentProfile == 3) {
			Profile3.file.delete();
			Profile3.made = " ";
			Profile3.lastPlayed = " ";
			Save.dataSave();
		}
		menuState = 2;
		currentProfile = 0;
		profileCheck();
		Game.endClick();
	}

	private void m2Back() {
		save1State = 0;
		save2State = 0;
		save3State = 0;
		currentProfile = 0;
		menuState = 1;
		Game.endClick();
	}

	private void m3Yes() {
		try {
			m2DeleteProfile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Game.endClick();
	}

	private void m3No() {
		menuState = 2;
		Game.endClick();
	}

}