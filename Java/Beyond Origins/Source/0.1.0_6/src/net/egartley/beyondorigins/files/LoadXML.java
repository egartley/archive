package net.egartley.beyondorigins.files;

import java.io.*;

import org.jdom2.*;
import org.jdom2.input.*;

import net.egartley.beyondorigins.main.*;

public class LoadXML {

	public static void load(String path, File file, int num) {
		SAXBuilder builder = new SAXBuilder();
		try {
			Game.st.decrypt(Game.getSaveKey(num), file, file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {

			Document document = (Document) builder.build(file);
			Element rootNode = document.getRootElement();

			Element playerNode = rootNode.getChild("player_data");
			Game.getPlayer().name = playerNode.getChild("name").getText();
			Game.getPlayer().x = Integer.parseInt(playerNode.getChild("x_cord").getText());
			Game.getPlayer().y = Integer.parseInt(playerNode.getChild("y_cord").getText());
			Game.getPlayer().mapMovement = Boolean.parseBoolean(playerNode.getChild("map_movement").getText());
			Game.getPlayer().insideMovement = Boolean.parseBoolean(playerNode.getChild("inside_movement").getText());
			Game.getPlayer().health = Double.parseDouble(playerNode.getChild("health").getText());
			Game.getPlayer().exp = Short.parseShort(playerNode.getChild("exp").getText());
			Game.getPlayer().level = Short.parseShort(playerNode.getChild("level").getText());

			Element mapNode = rootNode.getChild("map_data");
			Game.getMap().x = Integer.parseInt(mapNode.getChild("x_cord").getText());
			Game.getMap().y = Integer.parseInt(mapNode.getChild("y_cord").getText());

			Element miscNode = rootNode.getChild("misc");
			if (num == 1) {
				Profile1.progress = Integer.parseInt(miscNode.getChild("game_progress").getText());
			} else if (num == 2) {
				Profile2.progress = Integer.parseInt(miscNode.getChild("game_progress").getText());
			} else if (num == 3) {
				Profile3.progress = Integer.parseInt(miscNode.getChild("game_progress").getText());
			}

		} catch (IOException io) {
			System.out.println(io.getMessage());
		} catch (JDOMException jdomex) {
			System.out.println(jdomex.getMessage());
		}
		try {
			Game.st.encrypt(Game.getSaveKey(num), file, file);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
