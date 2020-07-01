/*    */ package com.emgartley.beyondOrigins.main.menus;
/*    */ 
/*    */ import com.emgartley.beyondOrigins.main.Game;
/*    */ import com.emgartley.beyondOrigins.userInput.MouseMotion;
/*    */ import java.awt.Color;
/*    */ import java.awt.FontMetrics;
/*    */ import java.awt.Graphics;
/*    */ 
/*    */ public class F3Menu {
/*    */   public static boolean f3menu = false;
/*    */   
/* 12 */   private static Color c = new Color(64, 64, 64, 136);
/*    */   
/*    */   private static FontMetrics fm;
/*    */   
/*    */   private static void drawText(Graphics g, String t, int x, int y) {
/* 16 */     fm = g.getFontMetrics(Game.f3MenuFont);
/* 18 */     g.setColor(c);
/* 19 */     g.fillRect(x - 2, y - fm.getHeight() + 4, fm.stringWidth(t) + 5, 
/* 20 */         fm.getHeight() - 1);
/* 22 */     g.setFont(Game.f3MenuFont);
/* 23 */     g.setColor(Color.white);
/* 24 */     g.drawString(t, x, y);
/*    */   }
/*    */   
/*    */   public static void render(Graphics g) {
/* 28 */     g.setFont(Game.f3MenuFont);
/* 29 */     g.setColor(Color.white);
/* 30 */     drawText(g, Game.title, 450, 25);
/* 31 */     drawText(g, Game.copyright, 450, 40);
/* 32 */     drawText(g, "FPS: " + Game.currentFrames + "   " + "Current Profile: " + 
/* 33 */         (Game.getMainMenu()).currentProfile, 450, 55);
/* 34 */     drawText(g, "Up: " + Game.getPlayer().isNextTileValid(1) + "   Down: " + 
/* 35 */         Game.getPlayer().isNextTileValid(3), 450, 70);
/* 36 */     drawText(g, "Left: " + Game.getPlayer().isNextTileValid(4) + 
/* 37 */         "   Right: " + Game.getPlayer().isNextTileValid(2), 450, 85);
/* 39 */     drawText(g, 
/* 40 */         "Player X: " + (Game.getPlayer()).x + "   " + "Player Y: " + 
/* 41 */         (Game.getPlayer()).y, 650, 25);
/* 42 */     drawText(g, "Tile X: " + (Game.getPlayer()).tileX + "   " + "Tile Y: " + 
/* 43 */         (Game.getPlayer()).tileY, 650, 40);
/* 44 */     drawText(
/* 45 */         g, 
/* 46 */         "Map X: " + (Game.getMap()).x + "   " + " Map Y: " + 
/* 47 */         (Game.getMap()).y, 650, 55);
/* 48 */     drawText(g, "Mse X: " + MouseMotion.mouseX + "   " + "Mse Y: " + 
/* 49 */         MouseMotion.mouseY, 650, 70);
/* 50 */     drawText(g, "Current Tile ID: " + Game.getPlayer().getCurrentTile() + "   Count: " + (Game.getPlayer()).moveCount, 650, 85);
/*    */   }
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.1.0_5.jar!\com\emgartley\beyondOrigins\main\menus\F3Menu.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */