/*    */ package applecraft.testgame.main.gfx;
/*    */ 
/*    */ import java.awt.image.BufferedImage;
/*    */ 
/*    */ public class SpriteSheet {
/*    */   private BufferedImage player;
/*    */   
/*    */   private BufferedImage grassmap;
/*    */   
/*    */   public SpriteSheet(BufferedImage player, BufferedImage grassmap) {
/* 10 */     this.player = player;
/* 11 */     this.grassmap = grassmap;
/*    */   }
/*    */   
/*    */   public BufferedImage cropplr(int col, int row, int w, int h) {
/* 15 */     return this.player.getSubimage(col * 32, row * 32, w, h);
/*    */   }
/*    */   
/*    */   public BufferedImage croptr1(int col, int row, int w, int h) {
/* 19 */     return this.grassmap.getSubimage(col * 32, row * 32, w, h);
/*    */   }
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.1.jar!\applecraft\testgame\main\gfx\SpriteSheet.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */