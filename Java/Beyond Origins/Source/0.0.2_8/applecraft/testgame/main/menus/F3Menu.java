/*    */ package applecraft.testgame.main.menus;
/*    */ 
/*    */ import applecraft.testgame.main.Game;
/*    */ import applecraft.testgame.main.entities.Player;
/*    */ import applecraft.testgame.main.gfx.ImageManager;
/*    */ import java.awt.Graphics;
/*    */ 
/*    */ public class F3Menu {
/*    */   public static boolean f3menu = false;
/*    */   
/*    */   private ImageManager im;
/*    */   
/*    */   public F3Menu(ImageManager im) {
/* 16 */     this.im = im;
/*    */   }
/*    */   
/*    */   public void tick() {}
/*    */   
/*    */   public void render(Graphics g) {
/* 25 */     if (f3menu) {
/* 28 */       g.drawString(Game.title, 15, 25);
/* 29 */       g.drawString("Player X: " + Player.playerX, 15, 40);
/* 30 */       g.drawString("Player Y: " + Player.playerY, 15, 55);
/* 31 */       g.drawString("Tile X: " + Player.tileX + " " + "Tile Y: " + Player.tileY, 15, 70);
/* 32 */       g.drawString("Map X: " + Player.mapX + " " + " Map Y: " + Player.mapY, 15, 85);
/* 39 */       g.drawString("Made By: Evan Gartley", 650, 25);
/* 40 */       g.drawString("FPS: " + Game.currentFrames, 650, 40);
/* 41 */       g.drawString("UPS: " + Game.currentUpdates, 650, 55);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.2_8.jar!\applecraft\testgame\main\menus\F3Menu.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */