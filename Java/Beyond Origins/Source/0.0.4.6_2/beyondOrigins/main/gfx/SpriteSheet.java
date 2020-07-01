/*    */ package beyondOrigins.main.gfx;
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
/* 14 */     this.player = bfi;
/* 15 */     this.mainmenu = bfi;
/* 16 */     logo = bfi;
/* 17 */     inside1 = bfi;
/* 18 */     this.terrain1 = bfi;
/* 19 */     inventory = bfi;
/*    */   }
/*    */   
/*    */   public static void init() {}
/*    */   
/*    */   public BufferedImage crop1(int col, int row, int w, int h) {
/* 26 */     return this.player.getSubimage(col * 32, row * 32, w, h);
/*    */   }
/*    */   
/*    */   public BufferedImage crop2(int col, int row, int w, int h) {
/* 30 */     return this.mainmenu.getSubimage(col * 160, row * 32, w, h);
/*    */   }
/*    */   
/*    */   public BufferedImage crop3(int col, int row, int w, int h) {
/* 34 */     return this.mainmenu.getSubimage(col * 160, row * 96, w, h);
/*    */   }
/*    */   
/*    */   public BufferedImage crop4(int row, int col, int w, int h) {
/* 38 */     return inventory.getSubimage(row * 416, col * 288, w, h);
/*    */   }
/*    */   
/*    */   public BufferedImage crop5(int row, int col, int w, int h) {
/* 42 */     return inventory.getSubimage(row * 64, col * 64, w, h);
/*    */   }
/*    */   
/*    */   public BufferedImage crop6(int row, int col, int w, int h) {
/* 46 */     return inventory.getSubimage(row * 32, col * 64, w, h);
/*    */   }
/*    */   
/*    */   public BufferedImage crop7(int row, int col, int w, int h) {
/* 50 */     return this.terrain1.getSubimage(row * 96, col * 96, w, h);
/*    */   }
/*    */   
/*    */   public BufferedImage crop8(int row, int col, int w, int h) {
/* 54 */     return this.terrain1.getSubimage(row * 32, col * 32, w, h);
/*    */   }
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.4.6_2.jar!\beyondOrigins\main\gfx\SpriteSheet.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */