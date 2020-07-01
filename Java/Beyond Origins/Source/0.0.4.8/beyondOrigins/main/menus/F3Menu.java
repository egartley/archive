/*    */ package beyondOrigins.main.menus;
/*    */ 
/*    */ import beyondOrigins.main.Game;
/*    */ import beyondOrigins.main.entities.Player;
/*    */ import java.awt.Color;
/*    */ import java.awt.Graphics;
/*    */ 
/*    */ public class F3Menu {
/*    */   public static boolean f3menu = false;
/*    */   
/*    */   public void render(Graphics g) {
/* 21 */     g.setFont(Game.default1);
/* 22 */     if (!Game.isInGame) {
/* 23 */       g.setColor(Color.black);
/*    */     } else {
/* 25 */       g.setColor(Color.WHITE);
/*    */     } 
/* 27 */     g.drawString(Game.title, 15, 25);
/* 28 */     g.drawString("Player X: " + Player.playerX + "   " + "Player Y: " + 
/* 29 */         Player.playerY, 15, 40);
/* 30 */     g.drawString("Tile X: " + Player.tileX + "  " + "Tile Y: " + 
/* 31 */         Player.tileY, 15, 55);
/* 32 */     g.drawString("Map X: " + Player.mapX + "  " + " Map Y: " + 
/* 33 */         Player.mapY, 15, 70);
/* 35 */     g.drawString(Game.copyright, 650, 25);
/* 36 */     g.drawString("FPS: " + Game.currentFrames + " | " + "Current Profile: " + MainMenu.currentProfile, 650, 40);
/*    */   }
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.4.8.jar!\beyondOrigins\main\menus\F3Menu.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */