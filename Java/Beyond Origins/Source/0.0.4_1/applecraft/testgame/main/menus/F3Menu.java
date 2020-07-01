/*    */ package applecraft.testgame.main.menus;
/*    */ 
/*    */ import applecraft.testgame.main.Game;
/*    */ import applecraft.testgame.main.MouseMotion;
/*    */ import applecraft.testgame.main.entities.Player;
/*    */ import applecraft.testgame.main.gfx.ImageManager;
/*    */ import java.awt.Color;
/*    */ import java.awt.Graphics;
/*    */ 
/*    */ public class F3Menu {
/*    */   public static boolean f3menu = false;
/*    */   
/*    */   private ImageManager im;
/*    */   
/*    */   public F3Menu(ImageManager im) {
/* 21 */     this.im = im;
/*    */   }
/*    */   
/*    */   public void tick() {}
/*    */   
/*    */   public void render(Graphics g) {
/* 30 */     if (f3menu) {
/* 31 */       g.setFont(Game.default1);
/* 32 */       if (!Game.gameRequested) {
/* 33 */         g.setColor(Color.black);
/*    */       } else {
/* 35 */         g.setColor(Color.WHITE);
/*    */       } 
/* 38 */       g.drawString(Game.title, 15, 25);
/* 39 */       g.drawString("Player X: " + Player.playerX + "   " + "Player Y: " + 
/* 40 */           Player.playerY, 15, 40);
/* 41 */       g.drawString("Tile X: " + Player.tileX + "  " + "Tile Y: " + 
/* 42 */           Player.tileY, 15, 55);
/* 43 */       g.drawString("Map X: " + Player.mapX + "  " + " Map Y: " + 
/* 44 */           Player.mapY, 15, 70);
/* 52 */       g.drawString("Made By: Evan Gartley", 650, 25);
/* 53 */       g.drawString("FPS: " + Game.currentFrames + " | " + "UPS: " + 
/* 54 */           Game.currentUpdates, 650, 40);
/* 55 */       g.drawString("MX: " + MouseMotion.mouseX + "  " + "MY: " + 
/* 56 */           MouseMotion.mouseY, 650, 55);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.4_1.jar!\applecraft\testgame\main\menus\F3Menu.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */