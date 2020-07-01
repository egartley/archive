package net.egartley.beyondorigins.files;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import net.egartley.beyondorigins.main.Game;

public class WriteXML {

	public static void writeSaveFile(String path, File file, int num) {
		try {

			Element profile = new Element("profile");
			Document doc = new Document(profile);

			Element player = new Element("player_data");
			player.addContent(new Element("name").setText(Game.getPlayer().name));
			player.addContent(new Element("x_cord").setText(Game.st
					.toString((Game.getPlayer().x))));
			player.addContent(new Element("y_cord").setText(Game.st
					.toString((Game.getPlayer().y))));
			player.addContent(new Element("map_movement").setText(Game.st
					.toString(Game.getPlayer().mapMovement)));
			player.addContent(new Element("inside_movement").setText(Game.st
					.toString(Game.getPlayer().insideMovement)));
			player.addContent(new Element("health").setText(Game.st
					.toString(Game.getPlayer().health)));
			player.addContent(new Element("exp").setText(Game.st.toString(Game
					.getPlayer().exp)));
			player.addContent(new Element("level").setText(Game.st
					.toString(Game.getPlayer().level)));
			doc.getRootElement().addContent(player);

			Element map = new Element("map_data");
			map.addContent(new Element("x_cord").setText(Game.st.toString(Game
					.getMap().x)));
			map.addContent(new Element("y_cord").setText(Game.st.toString(Game
					.getMap().y)));
			doc.getRootElement().addContent(map);

			Element misc = new Element("misc");
			misc.addContent(new Element("game_progress").setText(Game.st
					.toString(Game.getProgress())));
			doc.getRootElement().addContent(misc);

			XMLOutputter xmlOutput = new XMLOutputter();
			xmlOutput.setFormat(Format.getPrettyFormat());
			xmlOutput.output(doc, new FileWriter(file.getAbsolutePath()));
		} catch (IOException io) {
			System.out.println(io.getMessage());
		}
		
		try {
			Game.st.encrypt(Game.getSaveKey(num), file, file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Game.logger.log("Profile " + num + " saved");
	}

}
