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
/* 11 */     this.player = player;
/* 12 */     this.grassmap = grassmap;
/* 13 */     this.cow = cow;
/*    */   }
/*    */   
/*    */   public BufferedImage crop1(int col, int row, int w, int h) {
/* 17 */     return this.player.getSubimage(col * 32, row * 32, w, h);
/*    */   }
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.2_9.jar!\applecraft\testgame\main\gfx\SpriteSheet.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */