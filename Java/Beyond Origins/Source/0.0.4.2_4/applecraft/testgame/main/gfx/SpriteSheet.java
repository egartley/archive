/*    */ package applecraft.testgame.main.gfx;
/*    */ 
/*    */ import java.awt.image.BufferedImage;
/*    */ 
/*    */ public class SpriteSheet {
/*    */   private BufferedImage player;
/*    */   
/*    */   private BufferedImage mainmenu;
/*    */   
/*    */   private BufferedImage terrain1;
/*    */   
/*    */   private static BufferedImage inventory;
/*    */   
/*    */   private static BufferedImage logo;
/*    */   
/*    */   private static BufferedImage inside1;
/*    */   
/*    */   public SpriteSheet(BufferedImage bfi) {
/* 11 */     this.player = bfi;
/* 12 */     this.mainmenu = bfi;
/* 13 */     inventory = bfi;
/* 14 */     logo = bfi;
/* 15 */     inside1 = bfi;
/* 16 */     this.terrain1 = bfi;
/*    */   }
/*    */   
/*    */   public static void init() {}
/*    */   
/*    */   public BufferedImage crop1(int col, int row, int w, int h) {
/* 26 */     return this.player.getSubimage(col * 32, row * 32, w, h);
/*    */   }
/*    */   
/*    */   public BufferedImage crop2(int col, int row, int w, int h) {
/* 31 */     return this.mainmenu.getSubimage(col * 160, row * 32, w, h);
/*    */   }
/*    */   
/*    */   public BufferedImage crop3(int col, int row, int w, int h) {
/* 36 */     return this.mainmenu.getSubimage(col * 160, row * 96, w, h);
/*    */   }
/*    */   
/*    */   public BufferedImage crop4(int col, int row, int w, int h) {
/* 41 */     return inventory.getSubimage(col * 416, row * 288, w, h);
/*    */   }
/*    */   
/*    */   public BufferedImage crop5(int row, int col, int w, int h) {
/* 46 */     return inventory.getSubimage(row * 64, col * 64, w, h);
/*    */   }
/*    */   
/*    */   public BufferedImage crop6(int row, int col, int w, int h) {
/* 51 */     return inventory.getSubimage(row * 32, col * 64, w, h);
/*    */   }
/*    */   
/*    */   public BufferedImage crop7(int row, int col, int w, int h) {
/* 56 */     return this.terrain1.getSubimage(row * 96, col * 96, w, h);
/*    */   }
/*    */   
/*    */   public BufferedImage crop8(int row, int col, int w, int h) {
/* 61 */     return this.terrain1.getSubimage(row * 32, col * 32, w, h);
/*    */   }
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.4.2_4.jar!\applecraft\testgame\main\gfx\SpriteSheet.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */