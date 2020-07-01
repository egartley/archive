/*    */ package beyondOrigins.main.menus;
/*    */ 
/*    */ import beyondOrigins.main.Game;
/*    */ import beyondOrigins.main.entities.Player;
/*    */ import beyondOrigins.main.entities.TestDummy;
/*    */ import beyondOrigins.userInput.MouseMotion;
/*    */ import java.awt.Color;
/*    */ import java.awt.Graphics;
/*    */ 
/*    */ public class F3Menu {
/*    */   public static boolean f3menu = false;
/*    */   
/*    */   public void render(Graphics g) {
/* 20 */     g.setFont(Game.f3MenuFont);
/* 21 */     if (!Game.isInGame) {
/* 22 */       g.setColor(Color.black);
/*    */     } else {
/* 24 */       g.setColor(Color.WHITE);
/*    */     } 
/* 26 */     g.drawString(Game.title, 15, 25);
/* 27 */     g.drawString("Player X: " + Player.playerX + "   " + "Player Y: " + 
/* 28 */         Player.playerY, 15, 40);
/* 29 */     g.drawString("Tile X: " + Player.tileX + "  " + "Tile Y: " + 
/* 30 */         Player.tileY, 15, 55);
/* 31 */     g.drawString("Map X: " + Player.mapX + "  " + " Map Y: " + 
/* 32 */         Player.mapY, 15, 70);
/* 34 */     g.drawString(Game.copyright, 650, 25);
/* 35 */     g.drawString("FPS: " + Game.currentFrames + " | " + "Current Profile: " + MainMenu.currentProfile, 650, 40);
/* 36 */     g.drawString("Mouse X: " + MouseMotion.mouseX + " | " + "Mouse Y: " + MouseMotion.mouseY, 650, 55);
/* 37 */     g.drawString("TD RX: " + TestDummy.rx + " |  TD RY: " + TestDummy.ry, 650, 70);
/*    */   }
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.5_3.jar!\beyondOrigins\main\menus\F3Menu.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */