/*    */ package beyondOrigins.main.menus;
/*    */ 
/*    */ import beyondOrigins.main.Game;
/*    */ import beyondOrigins.main.MouseMotion;
/*    */ import beyondOrigins.main.Save;
/*    */ import beyondOrigins.main.entities.Player;
/*    */ import java.awt.Color;
/*    */ import java.awt.Graphics;
/*    */ 
/*    */ public class F3Menu {
/*    */   public static boolean f3menu = false;
/*    */   
/*    */   public void tick() {}
/*    */   
/*    */   public void render(Graphics g) {
/* 23 */     if (f3menu) {
/* 24 */       g.setFont(Game.default1);
/* 25 */       if (!Game.isInGame) {
/* 26 */         g.setColor(Color.black);
/*    */       } else {
/* 28 */         g.setColor(Color.WHITE);
/*    */       } 
/* 30 */       g.drawString(Game.title, 15, 25);
/* 31 */       g.drawString("Player X: " + Player.playerX + "   " + "Player Y: " + 
/* 32 */           Player.playerY, 15, 40);
/* 33 */       g.drawString("Tile X: " + Player.tileX + "  " + "Tile Y: " + 
/* 34 */           Player.tileY, 15, 55);
/* 35 */       g.drawString("Map X: " + Player.mapX + "  " + " Map Y: " + 
/* 36 */           Player.mapY, 15, 70);
/* 38 */       g.drawString("Made By: Evan Gartley", 650, 25);
/* 39 */       g.drawString("FPS: " + Game.currentFrames, 650, 40);
/* 40 */       g.drawString("MX: " + MouseMotion.mouseX + "  " + "MY: " + 
/* 41 */           MouseMotion.mouseY, 650, 55);
/* 42 */       g.drawString("canMakeNewGame: " + Save.canMakeNewGame, 650, 70);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.4.7.jar!\beyondOrigins\main\menus\F3Menu.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */