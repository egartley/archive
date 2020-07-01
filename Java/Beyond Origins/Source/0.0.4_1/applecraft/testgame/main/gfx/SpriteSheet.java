/*    */ package applecraft.testgame.main.gfx;
/*    */ 
/*    */ import java.awt.image.BufferedImage;
/*    */ 
/*    */ public class SpriteSheet {
/*    */   private BufferedImage player;
/*    */   
/*    */   private BufferedImage mainmenu;
/*    */   
/*    */   private static BufferedImage inventory;
/*    */   
/*    */   private static int test;
/*    */   
/*    */   public SpriteSheet(BufferedImage player, BufferedImage mainmenu, BufferedImage inventory) {
/* 12 */     this.player = player;
/* 13 */     this.mainmenu = mainmenu;
/* 14 */     SpriteSheet.inventory = inventory;
/*    */   }
/*    */   
/*    */   public static void init() {}
/*    */   
/*    */   public BufferedImage crop1(int col, int row, int w, int h) {
/* 23 */     return this.player.getSubimage(col * 32, row * 32, w, h);
/*    */   }
/*    */   
/*    */   public BufferedImage crop2(int col, int row, int w, int h) {
/* 28 */     return this.mainmenu.getSubimage(col * 160, row * 32, w, h);
/*    */   }
/*    */   
/*    */   public BufferedImage crop3(int col, int row, int w, int h) {
/* 33 */     return this.mainmenu.getSubimage(col * 160, row * 96, w, h);
/*    */   }
/*    */   
/*    */   public BufferedImage crop4(int col, int row, int w, int h) {
/* 38 */     return inventory.getSubimage(col * 416, row * 288, w, h);
/*    */   }
/*    */   
/*    */   public BufferedImage crop5(int row, int col, int w, int h) {
/* 43 */     return inventory.getSubimage(row * 64, col * 64, w, h);
/*    */   }
/*    */   
/*    */   public BufferedImage crop6(int row, int col, int w, int h) {
/* 48 */     return inventory.getSubimage(row * 32, col * 64, w, h);
/*    */   }
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.4_1.jar!\applecraft\testgame\main\gfx\SpriteSheet.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */