package net.egartley.beyondorigins.files;

import java.io.*;

import net.egartley.beyondorigins.main.*;
import net.egartley.beyondorigins.menus.*;
import net.egartley.beyondorigins.windows.*;

public class Save {

	public static File data = new File(Game.dataPath), keys = new File(
			Game.keysPath);

	public static boolean canMakeNewGame = true;

	public static String save1LastPlayed = "", save2LastPlayed = "",
			save3LastPlayed = "";
	public static String save1Made = "", save2Made = "", save3Made = "";

	public static int autoSaveTime = 150000;
	private static long lastTime = System.currentTimeMillis() - autoSaveTime;

	public static FileWriter fw, fwData, fwKeys;
	static Encrypter en = new Encrypter();

	public static void tick() {
		if (Game.autoSave) {
			long thisTime = System.currentTimeMillis();
			if ((thisTime - lastTime) >= autoSaveTime) {
				lastTime = thisTime;
				autoSave();
			}
		}
	}

	public static void autoSave() {
		try {
			int cp = Game.getMainMenu().currentProfile;
			if (cp == 1) {
				Profile1.save();
			} else if (cp == 2) {
				Profile2.save();
			} else if (cp == 3) {
				Profile3.save();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void profileReset() {
		Game.getPlayer().x = 129;
		Game.getPlayer().y = 197;
		Game.getMap().x = 0;
		Game.getMap().y  = 0;
		Game.getPlayer().mapMovement = true;
		Game.getPlayer().insideMovement = false;
		Game.getPlayer().health = 50.0;
		Game.getPlayer().exp = 0;
		Game.getPlayer().level = 1;

		Game.getPlayer().lastDir = 3;
		Game.logger.log("Profile has been reset");
	}

	@SuppressWarnings("unused")
	public static void dataReset() {
		Profile1.lastPlayed = "";
		Profile1.made = "";
		Profile2.lastPlayed = "";
		Profile2.made = "";
		Profile3.lastPlayed = "";
		Profile3.made = "";
		Profile1.name = "IfYouSeeThisSomethingIsWrong";
		Profile2.name = "IfYouSeeThisSomethingIsWrong";
		Profile3.name = "IfYouSeeThisSomethingIsWrong";
		Profile1.backup_name = "";
		Profile2.backup_name = "";
		Profile3.backup_name = "";
		Options.autoSaveToggle = "On";
		Options.tdToggle = "Off";
		Options.soundToggle = "On";
		Options o = new Options();
		Game.logger.log("Data reset");
	}

	public static void dataSave() throws IOException {
		if (!data.exists()) {
			fwData = new FileWriter(Game.dataPath);
		} else if (data.exists()) {
			data.delete();
			fwData = new FileWriter(Game.dataPath);
		}
		// create an object to print to the files
		PrintWriter pw = new PrintWriter(fwData);
		// write contents of data.zan
		pw.println(Profile1.lastPlayed);
		pw.println(Profile1.made);
		pw.println(Profile2.lastPlayed);
		pw.println(Profile2.made);
		pw.println(Profile3.lastPlayed);
		pw.println(Profile3.made);
		pw.println(Profile1.name);
		pw.println(Profile2.name);
		pw.println(Profile3.name);
		pw.println(Profile1.backup_name);
		pw.println(Profile2.backup_name);
		pw.println(Profile3.backup_name);
		pw.println(Game.autoSave);
		pw.println(Game.dummy);
		pw.println(Game.sound);
		// complete writing
		pw.close();
		Game.logger.log("Data saved");
	}

	public static void keysSave() throws IOException {
		if (!keys.exists()) {
			fwKeys = new FileWriter(Game.keysPath);
		} else if (keys.exists()) {
			keys.delete();
			fwKeys = new FileWriter(Game.keysPath);
		}
		PrintWriter pw = new PrintWriter(fwKeys);
		pw.println(Keys.invToggle);
		pw.println(Keys.up);
		pw.println(Keys.down);
		pw.println(Keys.left);
		pw.println(Keys.right);
		pw.println(Keys.attack);
		pw.println(Keys.block);
		pw.println(Keys.sprint);
		pw.close();
		Game.logger.log("Keys saved");
	}

}