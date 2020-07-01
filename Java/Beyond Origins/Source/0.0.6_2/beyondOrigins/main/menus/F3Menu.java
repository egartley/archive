/*    */ package beyondOrigins.main.menus;
/*    */ 
/*    */ import beyondOrigins.main.Game;
/*    */ import beyondOrigins.main.entities.Player;
/*    */ import beyondOrigins.main.entities.TestDummy;
/*    */ import beyondOrigins.userInput.MouseMotion;
/*    */ import java.awt.Color;
/*    */ import java.awt.FontMetrics;
/*    */ import java.awt.Graphics;
/*    */ 
/*    */ public class F3Menu {
/*    */   public static boolean f3menu = false;
/*    */   
/* 16 */   private static Color c = new Color(64, 64, 64, 128);
/*    */   
/*    */   private static FontMetrics fm;
/*    */   
/*    */   private static void drawText(Graphics g, String t, int x, int y) {
/* 24 */     fm = g.getFontMetrics(Game.f3MenuFont);
/* 26 */     g.setColor(c);
/* 27 */     g.fillRect(x - 5, y - fm.getHeight() + 4, fm.stringWidth(t) + 10, 
/* 28 */         fm.getHeight() - 1);
/* 30 */     g.setFont(Game.f3MenuFont);
/* 31 */     g.setColor(Color.white);
/* 32 */     g.drawString(t, x, y);
/*    */   }
/*    */   
/*    */   public static void render(Graphics g) {
/* 36 */     g.setFont(Game.f3MenuFont);
/* 37 */     g.setColor(Color.white);
/* 39 */     drawText(g, Game.title, 450, 25);
/* 40 */     drawText(g, Game.copyright, 450, 40);
/* 41 */     drawText(g, "FPS: " + Game.currentFrames + " | " + "Current Profile: " + 
/* 42 */         MainMenu.currentProfile, 450, 55);
/* 44 */     drawText(g, "Player X: " + Player.x + "   " + "Player Y: " + Player.y, 
/* 45 */         650, 25);
/* 46 */     drawText(g, "Tile X: " + Player.tileX + "  " + "Tile Y: " + 
/* 47 */         Player.tileY, 650, 40);
/* 48 */     drawText(g, "Map X: " + Player.mapX + "  " + " Map Y: " + Player.mapY, 
/* 49 */         650, 55);
/* 50 */     drawText(g, "Mouse X: " + MouseMotion.mouseX + " | " + "Mouse Y: " + 
/* 51 */         MouseMotion.mouseY, 650, 70);
/* 52 */     drawText(g, "P Health: " + Player.health + " TD Health: " + 
/* 53 */         TestDummy.health, 650, 85);
/* 54 */     drawText(g, String.valueOf(MainMenu.save1State) + " " + MainMenu.save2State + " " + 
/* 55 */         MainMenu.save3State, 650, 100);
/*    */   }
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.6_2.jar!\beyondOrigins\main\menus\F3Menu.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */