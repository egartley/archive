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
/*    */   private BufferedImage mainmenu;
/*    */   
/*    */   public SpriteSheet(BufferedImage player, BufferedImage mainmenu) {
/* 10 */     this.player = player;
/* 11 */     this.mainmenu = mainmenu;
/*    */   }
/*    */   
/*    */   public BufferedImage crop1(int col, int row, int w, int h) {
/* 15 */     return this.player.getSubimage(col * 32, row * 32, w, h);
/*    */   }
/*    */   
/*    */   public BufferedImage crop2(int col, int row, int w, int h) {
/* 19 */     return this.mainmenu.getSubimage(col * 160, row * 32, w, h);
/*    */   }
/*    */   
/*    */   public BufferedImage crop3(int col, int row, int w, int h) {
/* 23 */     return this.mainmenu.getSubimage(col * 160, row * 96, w, h);
/*    */   }
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.3_8.jar!\applecraft\testgame\main\gfx\SpriteSheet.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */