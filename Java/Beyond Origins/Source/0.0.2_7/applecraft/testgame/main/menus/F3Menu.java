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
/* 28 */       g.drawString("Beyond Origins 0.0.2.7 DEV BUILD", 15, 25);
/* 29 */       g.drawString("X: " + Player.playerX + "    " + "FPS: " + Game.currentFrames, 15, 40);
/* 30 */       g.drawString("Y: " + Player.playerY + "    " + "UPS: " + Game.currentUpdates, 15, 55);
/* 31 */       g.drawString("Tile X: " + Player.tileX + " " + "Tile Y: " + Player.tileY, 15, 70);
/* 32 */       g.drawString("Map X: " + Player.mapX + " " + " Map Y: " + Player.mapY, 15, 85);
/* 33 */       g.drawString("  ", 15, 85);
/* 34 */       g.drawString("  ", 15, 100);
/* 35 */       g.drawString("  ", 15, 115);
/* 36 */       g.drawString("  ", 15, 130);
/* 39 */       g.drawString("Made By: Evan Gartley", 650, 25);
/* 40 */       g.drawString("  ", 650, 40);
/* 41 */       g.drawString("  ", 650, 55);
/* 42 */       g.drawString("  ", 650, 70);
/* 43 */       g.drawString("  ", 650, 85);
/* 44 */       g.drawString("  ", 650, 100);
/* 45 */       g.drawString("  ", 650, 115);
/* 46 */       g.drawString("  ", 650, 130);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.2_7.jar!\applecraft\testgame\main\menus\F3Menu.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */