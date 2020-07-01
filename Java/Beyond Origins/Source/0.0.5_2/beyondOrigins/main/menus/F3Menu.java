/*    */ package beyondOrigins.main.menus;
/*    */ 
/*    */ import beyondOrigins.main.Game;
/*    */ import beyondOrigins.main.entities.Player;
/*    */ import beyondOrigins.userInput.MouseMotion;
/*    */ import java.awt.Color;
/*    */ import java.awt.Graphics;
/*    */ 
/*    */ public class F3Menu {
/*    */   public static boolean f3menu = false;
/*    */   
/*    */   public void render(Graphics g) {
/* 22 */     g.setFont(Game.f3MenuFont);
/* 23 */     if (!Game.isInGame) {
/* 24 */       g.setColor(Color.black);
/*    */     } else {
/* 26 */       g.setColor(Color.WHITE);
/*    */     } 
/* 28 */     g.drawString(Game.title, 15, 25);
/* 29 */     g.drawString("Player X: " + Player.playerX + "   " + "Player Y: " + 
/* 30 */         Player.playerY, 15, 40);
/* 31 */     g.drawString("Tile X: " + Player.tileX + "  " + "Tile Y: " + 
/* 32 */         Player.tileY, 15, 55);
/* 33 */     g.drawString("Map X: " + Player.mapX + "  " + " Map Y: " + 
/* 34 */         Player.mapY, 15, 70);
/* 36 */     g.drawString(Game.copyright, 650, 25);
/* 37 */     g.drawString("FPS: " + Game.currentFrames + " | " + "Current Profile: " + MainMenu.currentProfile, 650, 40);
/* 38 */     g.drawString("Mouse X: " + MouseMotion.mouseX + " | " + "Mouse Y: " + MouseMotion.mouseY, 650, 55);
/* 39 */     g.drawString("Talk State: " + Player.talk1State, 650, 70);
/*    */   }
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.5_2.jar!\beyondOrigins\main\menus\F3Menu.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */