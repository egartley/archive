/*    */ package com.emgartley.beyondOrigins.files;
/*    */ 
/*    */ import com.emgartley.beyondOrigins.main.Game;
/*    */ import java.io.File;
/*    */ import java.io.FileWriter;
/*    */ import java.io.IOException;
/*    */ import org.jdom2.Content;
/*    */ import org.jdom2.Document;
/*    */ import org.jdom2.Element;
/*    */ import org.jdom2.output.Format;
/*    */ import org.jdom2.output.XMLOutputter;
/*    */ 
/*    */ public class WriteXML {
/*    */   public static void writeSaveFile(String path, File file, int num) {
/*    */     try {
/* 19 */       Element profile = new Element("profile");
/* 20 */       Document doc = new Document(profile);
/* 22 */       Element player = new Element("player_data");
/* 23 */       player.addContent((Content)(new Element("name")).setText((Game.getPlayer()).name));
/* 24 */       player.addContent((Content)(new Element("x_cord")).setText(Game.st
/* 25 */             .toString((Game.getPlayer()).x)));
/* 26 */       player.addContent((Content)(new Element("y_cord")).setText(Game.st
/* 27 */             .toString((Game.getPlayer()).y)));
/* 28 */       player.addContent((Content)(new Element("map_movement")).setText(Game.st
/* 29 */             .toString((Game.getPlayer()).mapMovement)));
/* 30 */       player.addContent((Content)(new Element("inside_movement")).setText(Game.st
/* 31 */             .toString((Game.getPlayer()).insideMovement)));
/* 32 */       player.addContent((Content)(new Element("health")).setText(Game.st
/* 33 */             .toString((Game.getPlayer()).health)));
/* 34 */       player.addContent((Content)(new Element("exp")).setText(Game.st.toString(
/* 35 */               (Game.getPlayer()).exp)));
/* 36 */       player.addContent((Content)(new Element("level")).setText(Game.st
/* 37 */             .toString((Game.getPlayer()).level)));
/* 38 */       doc.getRootElement().addContent((Content)player);
/* 40 */       Element map = new Element("map_data");
/* 41 */       map.addContent((Content)(new Element("x_cord")).setText(Game.st.toString(
/* 42 */               (Game.getMap()).x)));
/* 43 */       map.addContent((Content)(new Element("y_cord")).setText(Game.st.toString(
/* 44 */               (Game.getMap()).y)));
/* 45 */       doc.getRootElement().addContent((Content)map);
/* 47 */       Element misc = new Element("misc");
/* 48 */       misc.addContent((Content)(new Element("game_progress")).setText(Game.st
/* 49 */             .toString(Game.getProgress())));
/* 50 */       doc.getRootElement().addContent((Content)misc);
/* 52 */       XMLOutputter xmlOutput = new XMLOutputter();
/* 53 */       xmlOutput.setFormat(Format.getPrettyFormat());
/* 54 */       xmlOutput.output(doc, new FileWriter(file.getAbsolutePath()));
/* 55 */     } catch (IOException io) {
/* 56 */       System.out.println(io.getMessage());
/*    */     } 
/*    */     try {
/* 60 */       Game.st.encrypt(Game.getSaveKey(num), file, file);
/* 61 */     } catch (Exception e) {
/* 62 */       e.printStackTrace();
/*    */     } 
/* 65 */     Game.logger.log("Profile " + num + " saved");
/*    */   }
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.1.0_5.jar!\com\emgartley\beyondOrigins\files\WriteXML.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */