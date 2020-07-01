/*    */ package applecraft.testgame.main.gfx;
/*    */ 
/*    */ import java.awt.image.BufferedImage;
/*    */ 
/*    */ public class ImageManager {
/*    */   public BufferedImage playerd1;
/*    */   
/*    */   public BufferedImage playerd2;
/*    */   
/*    */   public BufferedImage playerd3;
/*    */   
/*    */   public BufferedImage playerd4;
/*    */   
/*    */   public BufferedImage playeru1;
/*    */   
/*    */   public BufferedImage playeru2;
/*    */   
/*    */   public BufferedImage playeru3;
/*    */   
/*    */   public BufferedImage playeru4;
/*    */   
/*    */   public BufferedImage playerl1;
/*    */   
/*    */   public BufferedImage playerl2;
/*    */   
/*    */   public BufferedImage playerl3;
/*    */   
/*    */   public BufferedImage playerl4;
/*    */   
/*    */   public BufferedImage playerr1;
/*    */   
/*    */   public BufferedImage playerr2;
/*    */   
/*    */   public BufferedImage playerr3;
/*    */   
/*    */   public BufferedImage playerr4;
/*    */   
/*    */   public static BufferedImage grassFull;
/*    */   
/*    */   public static BufferedImage grassCnr1;
/*    */   
/*    */   public static BufferedImage grassCnr2;
/*    */   
/*    */   public static BufferedImage grassCnr3;
/*    */   
/*    */   public static BufferedImage grassCnr4;
/*    */   
/*    */   public static BufferedImage grassEdge1;
/*    */   
/*    */   public static BufferedImage grassEdge2;
/*    */   
/*    */   public static BufferedImage grassEdge3;
/*    */   
/*    */   public static BufferedImage grassEdge4;
/*    */   
/*    */   public ImageManager(SpriteSheet ss) {
/* 21 */     this.playerd1 = ss.cropplr(0, 0, 32, 32);
/* 22 */     this.playerd2 = ss.cropplr(0, 1, 32, 32);
/* 23 */     this.playerd3 = ss.cropplr(0, 2, 32, 32);
/* 24 */     this.playerd4 = ss.cropplr(0, 3, 32, 32);
/* 26 */     this.playeru1 = ss.cropplr(1, 0, 32, 32);
/* 27 */     this.playeru2 = ss.cropplr(1, 1, 32, 32);
/* 28 */     this.playeru3 = ss.cropplr(1, 2, 32, 32);
/* 29 */     this.playeru4 = ss.cropplr(1, 3, 32, 32);
/* 31 */     this.playerl1 = ss.cropplr(2, 0, 32, 32);
/* 32 */     this.playerl2 = ss.cropplr(2, 1, 32, 32);
/* 33 */     this.playerl3 = ss.cropplr(2, 2, 32, 32);
/* 34 */     this.playerl4 = ss.cropplr(2, 3, 32, 32);
/* 36 */     this.playerr1 = ss.cropplr(3, 0, 32, 32);
/* 37 */     this.playerr2 = ss.cropplr(3, 1, 32, 32);
/* 38 */     this.playerr3 = ss.cropplr(3, 2, 32, 32);
/* 39 */     this.playerr4 = ss.cropplr(3, 3, 32, 32);
/* 44 */     grassFull = ss.croptr1(0, 0, 32, 32);
/* 45 */     grassCnr1 = ss.croptr1(1, 0, 32, 32);
/* 46 */     grassCnr2 = ss.croptr1(1, 1, 32, 32);
/* 47 */     grassCnr3 = ss.croptr1(0, 1, 32, 32);
/* 48 */     grassCnr4 = ss.croptr1(2, 1, 32, 32);
/* 49 */     grassEdge1 = ss.croptr1(3, 0, 32, 32);
/* 50 */     grassEdge2 = ss.croptr1(5, 0, 32, 32);
/* 51 */     grassEdge3 = ss.croptr1(4, 0, 32, 32);
/* 52 */     grassEdge4 = ss.croptr1(2, 0, 32, 32);
/*    */   }
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.1.jar!\applecraft\testgame\main\gfx\ImageManager.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */