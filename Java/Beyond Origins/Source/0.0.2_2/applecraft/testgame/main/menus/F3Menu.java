/*    */ package applecraft.testgame.main.menus;
/*    */ 
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
/* 26 */       g.drawString("Beyond Origins 0.0.2", 15, 25);
/* 27 */       g.drawString("Made By: Evan M. Gartley", 15, 40);
/* 28 */       g.drawString("X: " + Player.playerx, 15, 55);
/* 29 */       g.drawString("Y: " + Player.playery, 15, 70);
/* 30 */       g.drawString("Tile X: " + Player.tileX + " " + "Tile Y: " + Player.tileY, 15, 85);
/* 31 */       g.drawString("  ", 15, 100);
/* 32 */       g.drawString("  ", 15, 115);
/* 33 */       g.drawString("  ", 15, 120);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.2_2.jar!\applecraft\testgame\main\menus\F3Menu.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */