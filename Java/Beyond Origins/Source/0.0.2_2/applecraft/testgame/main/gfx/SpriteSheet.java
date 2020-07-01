/*    */ package applecraft.testgame.main.gfx;
/*    */ 
/*    */ import java.awt.image.BufferedImage;
/*    */ 
/*    */ public class SpriteSheet {
/*    */   private BufferedImage player;
/*    */   
/*    */   private BufferedImage grassmap;
/*    */   
/*    */   private BufferedImage cow;
/*    */   
/*    */   public SpriteSheet(BufferedImage player, BufferedImage grassmap, BufferedImage cow) {
/* 10 */     this.player = player;
/* 11 */     this.grassmap = grassmap;
/* 12 */     this.cow = cow;
/*    */   }
/*    */   
/*    */   public BufferedImage cropplr(int col, int row, int w, int h) {
/* 16 */     return this.player.getSubimage(col * 32, row * 32, w, h);
/*    */   }
/*    */   
/*    */   public BufferedImage croptr1(int col, int row, int w, int h) {
/* 20 */     return this.grassmap.getSubimage(col * 32, row * 32, w, h);
/*    */   }
/*    */   
/*    */   public BufferedImage cropcow(int col, int row, int w, int h) {
/* 24 */     return this.cow.getSubimage(col * 32, row * 32, w, h);
/*    */   }
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.2_2.jar!\applecraft\testgame\main\gfx\SpriteSheet.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */