/*    */ package beyondOrigins.main.menus;
/*    */ 
/*    */ import beyondOrigins.main.Game;
/*    */ import beyondOrigins.userInput.MouseMotion;
/*    */ import java.awt.Color;
/*    */ import java.awt.FontMetrics;
/*    */ import java.awt.Graphics;
/*    */ 
/*    */ public class F3Menu {
/*    */   public static boolean f3menu = false;
/*    */   
/* 14 */   private static Color c = new Color(64, 64, 64, 128);
/*    */   
/*    */   private static FontMetrics fm;
/*    */   
/*    */   private static void drawText(Graphics g, String t, int x, int y) {
/* 22 */     fm = g.getFontMetrics(Game.f3MenuFont);
/* 24 */     g.setColor(c);
/* 25 */     g.fillRect(x - 5, y - fm.getHeight() + 4, fm.stringWidth(t) + 10, 
/* 26 */         fm.getHeight() - 1);
/* 28 */     g.setFont(Game.f3MenuFont);
/* 29 */     g.setColor(Color.white);
/* 30 */     g.drawString(t, x, y);
/*    */   }
/*    */   
/*    */   public static void render(Graphics g) {
/* 34 */     g.setFont(Game.f3MenuFont);
/* 35 */     g.setColor(Color.white);
/* 37 */     drawText(g, Game.title, 450, 25);
/* 38 */     drawText(g, Game.copyright, 450, 40);
/* 39 */     drawText(g, "FPS: " + Game.currentFrames + "   " + "Current Profile: " + 
/* 40 */         (Game.getMainMenu()).currentProfile, 450, 55);
/* 42 */     drawText(g, "PX: " + (Game.getPlayer()).x + "   " + "PY: " + 
/* 43 */         (Game.getPlayer()).y, 650, 25);
/* 44 */     drawText(g, "Tile X: " + (Game.getPlayer()).tileX + "   " + "Tile Y: " + 
/* 45 */         (Game.getPlayer()).tileY, 650, 40);
/* 46 */     drawText(g, "Map X: " + (Game.getPlayer()).mapX + "   " + " Map Y: " + 
/* 47 */         (Game.getPlayer()).mapY, 650, 55);
/* 48 */     drawText(g, "Mouse X: " + MouseMotion.mouseX + "   " + "Mouse Y: " + 
/* 49 */         MouseMotion.mouseY, 650, 70);
/* 50 */     drawText(g, "Player Tile ID: " + Game.getPlayer().getCurrentTile(), 650, 85);
/*    */   }
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.6_4.jar!\beyondOrigins\main\menus\F3Menu.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */