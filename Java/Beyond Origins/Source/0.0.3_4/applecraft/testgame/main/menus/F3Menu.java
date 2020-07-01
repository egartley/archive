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
/* 20 */     this.im = im;
/*    */   }
/*    */   
/*    */   public void tick() {}
/*    */   
/*    */   public void render(Graphics g) {
/* 29 */     if (f3menu) {
/* 30 */       g.setFont(Game.default1);
/* 31 */       if (!Game.gameRequested) {
/* 32 */         g.setColor(Color.black);
/*    */       } else {
/* 34 */         g.setColor(Color.WHITE);
/*    */       } 
/* 37 */       g.drawString(Game.title, 15, 25);
/* 38 */       g.drawString("Player X: " + Player.playerX + "   " + "Player Y: " + 
/* 39 */           Player.playerY, 15, 40);
/* 40 */       g.drawString("Tile X: " + Player.tileX + "  " + "Tile Y: " + 
/* 41 */           Player.tileY, 15, 55);
/* 42 */       g.drawString("Map X: " + Player.mapX + "  " + " Map Y: " + 
/* 43 */           Player.mapY, 15, 70);
/* 51 */       g.drawString("Made By: Evan Gartley", 650, 25);
/* 52 */       g.drawString("FPS: " + Game.currentFrames + " | " + "UPS: " + Game.currentUpdates, 650, 40);
/* 53 */       g.drawString("MX: " + MouseMotion.mouseX + "  " + "MY: " + 
/* 54 */           MouseMotion.mouseY, 650, 55);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.3_4.jar!\applecraft\testgame\main\menus\F3Menu.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */