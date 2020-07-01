package net.egartley.beyondorigins.files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import net.egartley.beyondorigins.main.Game;
import net.egartley.beyondorigins.main.Profile1;
import net.egartley.beyondorigins.main.Profile2;
import net.egartley.beyondorigins.main.Profile3;
import net.egartley.beyondorigins.windows.Keys;

public class Load {

	static Decrypter de = new Decrypter();

	public static void loadProfile(String path, int num) {
		LoadXML.load(path, new File(path), num);
		Game.logger.log("Profile " + num + " loaded");
	}

	public static void loadData(String path) {
		if (Save.data.exists()) {
			try (BufferedReader r = new BufferedReader(new FileReader(path))) {
				Profile1.lastPlayed = r.readLine();
				Profile1.made = r.readLine();
				Profile2.lastPlayed = r.readLine();
				Profile2.made = r.readLine();
				Profile3.lastPlayed = r.readLine();
				Profile3.made = r.readLine();
				Profile1.name = r.readLine();
				Profile2.name = r.readLine();
				Profile3.name = r.readLine();
				Profile1.backup_name = r.readLine();
				Profile2.backup_name = r.readLine();
				Profile3.backup_name = r.readLine();
				Game.autoSave = Boolean.parseBoolean(r.readLine());
				Game.dummy = Boolean.parseBoolean(r.readLine());
				Game.sound = Boolean.parseBoolean(r.readLine());
			} catch (IOException e) {
				e.printStackTrace();
			}
			Game.logger.log("Data loaded");
		} else if (!Save.data.exists()) {
			Save.save1LastPlayed = "";
			Save.save1Made = "";
			Save.save2LastPlayed = "";
			Save.save2Made = "";
			Save.save3LastPlayed = "";
			Save.save3Made = "";
			Game.autoSave = true;
			Game.dummy = false;
			Game.sound = true;
		}
	}

	public static void loadKeys(String path) {
		File file = new File(path);
		if (file.exists()) {
			try (BufferedReader r = new BufferedReader(new FileReader(path))) {
				Keys.invToggle = Integer.parseInt(r.readLine());
				Keys.up = Integer.parseInt(r.readLine());
				Keys.down = Integer.parseInt(r.readLine());
				Keys.left = Integer.parseInt(r.readLine());
				Keys.right = Integer.parseInt(r.readLine());
				Keys.attack = Integer.parseInt(r.readLine());
				Keys.block = Integer.parseInt(r.readLine());
				Keys.sprint = Integer.parseInt(r.readLine());
			} catch (IOException e) {
				e.printStackTrace();
			}
			Game.logger.log("Keys loaded");
		} else if (!file.exists()) {
			try {
				Save.keysSave();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void loadMastery() {

	}

}