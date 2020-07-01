/*    */ package com.emgartley.beyondOrigins.files;
/*    */ 
/*    */ import com.emgartley.beyondOrigins.main.Game;
/*    */ import com.emgartley.beyondOrigins.main.Profile1;
/*    */ import com.emgartley.beyondOrigins.main.Profile2;
/*    */ import com.emgartley.beyondOrigins.main.Profile3;
/*    */ import java.io.File;
/*    */ import java.io.IOException;
/*    */ import org.jdom2.Document;
/*    */ import org.jdom2.Element;
/*    */ import org.jdom2.JDOMException;
/*    */ import org.jdom2.input.SAXBuilder;
/*    */ 
/*    */ public class LoadXML {
/*    */   public static void load(String path, File file, int num) {
/* 13 */     SAXBuilder builder = new SAXBuilder();
/*    */     try {
/* 15 */       Game.st.decrypt(Game.getSaveKey(num), file, file);
/* 16 */     } catch (Exception e) {
/* 17 */       e.printStackTrace();
/*    */     } 
/*    */     try {
/* 21 */       Document document = builder.build(file);
/* 22 */       Element rootNode = document.getRootElement();
/* 24 */       Element playerNode = rootNode.getChild("player_data");
/* 25 */       (Game.getPlayer()).name = playerNode.getChild("name").getText();
/* 26 */       (Game.getPlayer()).x = Integer.parseInt(playerNode.getChild("x_cord")
/* 27 */           .getText());
/* 28 */       (Game.getPlayer()).y = Integer.parseInt(playerNode.getChild("y_cord")
/* 29 */           .getText());
/* 30 */       (Game.getPlayer()).mapMovement = Boolean.parseBoolean(playerNode
/* 31 */           .getChild("map_movement").getText());
/* 32 */       (Game.getPlayer()).insideMovement = Boolean.parseBoolean(playerNode
/* 33 */           .getChild("inside_movement").getText());
/* 34 */       (Game.getPlayer()).health = Double.parseDouble(playerNode.getChild(
/* 35 */             "health").getText());
/* 36 */       (Game.getPlayer()).exp = Short.parseShort(playerNode.getChild("exp")
/* 37 */           .getText());
/* 38 */       (Game.getPlayer()).level = Short.parseShort(playerNode.getChild(
/* 39 */             "level").getText());
/* 41 */       Element mapNode = rootNode.getChild("map_data");
/* 42 */       (Game.getMap()).x = Integer.parseInt(mapNode.getChild("x_cord")
/* 43 */           .getText());
/* 44 */       (Game.getMap()).y = Integer.parseInt(mapNode.getChild("y_cord")
/* 45 */           .getText());
/* 47 */       Element miscNode = rootNode.getChild("misc");
/* 48 */       if (num == 1) {
/* 49 */         Profile1.progress = Integer.parseInt(miscNode.getChild(
/* 50 */               "game_progress").getText());
/* 51 */       } else if (num == 2) {
/* 52 */         Profile2.progress = Integer.parseInt(miscNode.getChild(
/* 53 */               "game_progress").getText());
/* 54 */       } else if (num == 3) {
/* 55 */         Profile3.progress = Integer.parseInt(miscNode.getChild(
/* 56 */               "game_progress").getText());
/*    */       } 
/* 59 */     } catch (IOException io) {
/* 60 */       System.out.println(io.getMessage());
/* 61 */     } catch (JDOMException jdomex) {
/* 62 */       System.out.println(jdomex.getMessage());
/*    */     } 
/*    */     try {
/* 65 */       Game.st.encrypt(Game.getSaveKey(num), file, file);
/* 66 */     } catch (Exception e) {
/* 67 */       e.printStackTrace();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.1.0_4.jar!\com\emgartley\beyondOrigins\files\LoadXML.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */