/*    */ package beyondOrigins.main.menus;
/*    */ 
/*    */ import beyondOrigins.main.Game;
/*    */ import beyondOrigins.main.entities.Player;
/*    */ import beyondOrigins.userInput.MouseMotion;
/*    */ import java.awt.Color;
/*    */ import java.awt.FontMetrics;
/*    */ import java.awt.Graphics;
/*    */ 
/*    */ public class F3Menu {
/*    */   public static boolean f3menu = false;
/*    */   
/* 15 */   private static Color c = new Color(64, 64, 64, 136);
/*    */   
/*    */   private static FontMetrics fm;
/*    */   
/*    */   private static void drawText(Graphics g, String t, int x, int y) {
/* 23 */     fm = g.getFontMetrics(Game.f3MenuFont);
/* 25 */     g.setColor(c);
/* 26 */     g.fillRect(x - 5, y - fm.getHeight() + 4, fm.stringWidth(t) + 10, 
/* 27 */         fm.getHeight() - 1);
/* 29 */     g.setFont(Game.f3MenuFont);
/* 30 */     g.setColor(Color.white);
/* 31 */     g.drawString(t, x, y);
/*    */   }
/*    */   
/*    */   public static void render(Graphics g) {
/* 35 */     g.setFont(Game.f3MenuFont);
/* 36 */     g.setColor(Color.white);
/* 37 */     drawText(g, Game.title, 450, 25);
/* 38 */     drawText(g, Game.copyright, 450, 40);
/* 39 */     drawText(g, "FPS: " + Game.currentFrames + "   " + "Current Profile: " + 
/* 40 */         (Game.getMainMenu()).currentProfile, 450, 55);
/* 41 */     drawText(g, "Up: " + Game.getPlayer().isNextTileValid(1) + "   Down: " + 
/* 42 */         Game.getPlayer().isNextTileValid(3), 450, 70);
/* 43 */     drawText(g, "Left: " + Game.getPlayer().isNextTileValid(4) + 
/* 44 */         "   Right: " + Game.getPlayer().isNextTileValid(2), 450, 85);
/* 46 */     drawText(g, 
/* 47 */         "PX: " + (Game.getPlayer()).x + "   " + "PY: " + 
/* 48 */         (Game.getPlayer()).y, 650, 25);
/* 49 */     drawText(g, "Tile X: " + (Game.getPlayer()).tileX + "   " + "Tile Y: " + 
/* 50 */         (Game.getPlayer()).tileY, 650, 40);
/* 51 */     drawText(g, "Map X: " + (Game.getPlayer()).mapX + "   " + " Map Y: " + 
/* 52 */         (Game.getPlayer()).mapY, 650, 55);
/* 53 */     drawText(g, "Mouse X: " + MouseMotion.mouseX + "   " + "Mouse Y: " + 
/* 54 */         MouseMotion.mouseY, 650, 70);
/* 55 */     drawText(g, "Player Tile ID: " + Game.getPlayer().getCurrentTile() + 
/* 56 */         "   " + "CU: " + Player.catchingUp, 650, 85);
/*    */   }
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.9_3.jar!\beyondOrigins\main\menus\F3Menu.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */