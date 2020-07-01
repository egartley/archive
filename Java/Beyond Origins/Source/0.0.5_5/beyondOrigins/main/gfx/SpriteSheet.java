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
/*    */   public static BufferedImage inventory;
/*    */   
/*    */   public SpriteSheet(BufferedImage bfi) {
/* 13 */     this.player = bfi;
/* 14 */     this.mainmenu = bfi;
/* 15 */     this.terrain1 = bfi;
/* 16 */     inventory = bfi;
/*    */   }
/*    */   
/*    */   public BufferedImage custom512Crop(int x, int y, int w, int h) {
/* 20 */     return this.player.getSubimage(x, y, w, h);
/*    */   }
/*    */   
/*    */   public BufferedImage custom1024Crop(int x, int y, int w, int h) {
/* 24 */     return inventory.getSubimage(x, y, w, h);
/*    */   }
/*    */   
/*    */   public BufferedImage basic512Crop(int col, int row, int w, int h) {
/* 28 */     return this.player.getSubimage(col * 32, row * 32, w, h);
/*    */   }
/*    */   
/*    */   public BufferedImage button1Crop(int col, int row, int w, int h) {
/* 32 */     return this.mainmenu.getSubimage(col * 160, row * 32, w, h);
/*    */   }
/*    */   
/*    */   public BufferedImage button2Crop(int col, int row, int w, int h) {
/* 36 */     return this.mainmenu.getSubimage(col * 336, row * 32, w, h);
/*    */   }
/*    */   
/*    */   public BufferedImage cloudCrop(int col, int row, int w, int h) {
/* 40 */     return this.mainmenu.getSubimage(col * 160, row * 96, w, h);
/*    */   }
/*    */   
/*    */   public BufferedImage invTabCrop(int row, int col, int w, int h) {
/* 44 */     return inventory.getSubimage(row * 64, col * 64, w, h);
/*    */   }
/*    */   
/*    */   public BufferedImage arrowCrop(int row, int col, int w, int h) {
/* 48 */     return inventory.getSubimage(row * 32, col * 64, w, h);
/*    */   }
/*    */   
/*    */   public BufferedImage buildingCrop(int row, int col, int w, int h) {
/* 52 */     return this.terrain1.getSubimage(row * 96, col * 96, w, h);
/*    */   }
/*    */   
/*    */   public BufferedImage tileCrop(int row, int col, int w, int h) {
/* 56 */     return this.terrain1.getSubimage(row * 32, col * 32, w, h);
/*    */   }
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.5_5.jar!\beyondOrigins\main\gfx\SpriteSheet.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */