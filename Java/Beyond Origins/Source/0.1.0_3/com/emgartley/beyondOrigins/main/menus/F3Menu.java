/*    */ package com.emgartley.beyondOrigins.main.menus;
/*    */ 
/*    */ import com.emgartley.beyondOrigins.main.Game;
/*    */ import com.emgartley.beyondOrigins.main.entities.Player;
/*    */ import com.emgartley.beyondOrigins.main.maps.GrassMap;
/*    */ import com.emgartley.beyondOrigins.userInput.MouseMotion;
/*    */ import java.awt.Color;
/*    */ import java.awt.FontMetrics;
/*    */ import java.awt.Graphics;
/*    */ 
/*    */ public class F3Menu {
/*    */   public static boolean f3menu = false;
/*    */   
/* 13 */   private static Color c = new Color(64, 64, 64, 136);
/*    */   
/*    */   private static FontMetrics fm;
/*    */   
/*    */   private static void drawText(Graphics g, String t, int x, int y) {
/* 17 */     fm = g.getFontMetrics(Game.f3MenuFont);
/* 19 */     g.setColor(c);
/* 20 */     g.fillRect(x - 5, y - fm.getHeight() + 4, fm.stringWidth(t) + 10, 
/* 21 */         fm.getHeight() - 1);
/* 23 */     g.setFont(Game.f3MenuFont);
/* 24 */     g.setColor(Color.white);
/* 25 */     g.drawString(t, x, y);
/*    */   }
/*    */   
/*    */   public static void render(Graphics g) {
/* 30 */     g.setFont(Game.f3MenuFont);
/* 31 */     g.setColor(Color.white);
/* 32 */     drawText(g, Game.title, 450, 25);
/* 33 */     drawText(g, Game.copyright, 450, 40);
/* 34 */     drawText(g, "FPS: " + Game.currentFrames + "   " + "Current Profile: " + 
/* 35 */         (Game.getMainMenu()).currentProfile, 450, 55);
/* 36 */     drawText(g, "Up: " + Game.getPlayer().isNextTileValid(1) + "   Down: " + 
/* 37 */         Game.getPlayer().isNextTileValid(3), 450, 70);
/* 38 */     drawText(g, "Left: " + Game.getPlayer().isNextTileValid(4) + 
/* 39 */         "   Right: " + Game.getPlayer().isNextTileValid(2), 450, 85);
/* 41 */     drawText(g, 
/* 42 */         "PX: " + (Game.getPlayer()).x + "   " + "PY: " + 
/* 43 */         (Game.getPlayer()).y, 650, 25);
/* 44 */     drawText(g, "Tile X: " + (Game.getPlayer()).tileX + "   " + "Tile Y: " + 
/* 45 */         (Game.getPlayer()).tileY, 650, 40);
/* 48 */     Game.getMap();
/* 49 */     Game.getMap();
/* 49 */     drawText(g, "Map X: " + GrassMap.x + "   " + " Map Y: " + GrassMap.y, 650, 55);
/* 50 */     drawText(g, "Mouse X: " + MouseMotion.mouseX + "   " + "Mouse Y: " + 
/* 51 */         MouseMotion.mouseY, 650, 70);
/* 52 */     drawText(g, "Player Tile ID: " + Game.getPlayer().getCurrentTile() + 
/* 53 */         "   " + "CU: " + Player.catchingUp, 650, 85);
/*    */   }
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.1.0_3.jar!\com\emgartley\beyondOrigins\main\menus\F3Menu.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */