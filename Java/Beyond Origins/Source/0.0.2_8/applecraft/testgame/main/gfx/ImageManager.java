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
/*    */   public static BufferedImage grassTree1;
/*    */   
/*    */   public BufferedImage cowd1;
/*    */   
/*    */   public BufferedImage cowd2;
/*    */   
/*    */   public BufferedImage cowd3;
/*    */   
/*    */   public BufferedImage cowd4;
/*    */   
/*    */   public BufferedImage cowu1;
/*    */   
/*    */   public BufferedImage cowu2;
/*    */   
/*    */   public BufferedImage cowu3;
/*    */   
/*    */   public BufferedImage cowu4;
/*    */   
/*    */   public BufferedImage cowl1;
/*    */   
/*    */   public BufferedImage cowl2;
/*    */   
/*    */   public BufferedImage cowl3;
/*    */   
/*    */   public BufferedImage cowl4;
/*    */   
/*    */   public BufferedImage cowr1;
/*    */   
/*    */   public BufferedImage cowr2;
/*    */   
/*    */   public BufferedImage cowr3;
/*    */   
/*    */   public BufferedImage cowr4;
/*    */   
/*    */   public ImageManager(SpriteSheet ss) {
/* 27 */     this.playerd1 = ss.crop1(0, 0, 32, 32);
/* 28 */     this.playerd2 = ss.crop1(0, 1, 32, 32);
/* 29 */     this.playerd3 = ss.crop1(0, 2, 32, 32);
/* 30 */     this.playerd4 = ss.crop1(0, 3, 32, 32);
/* 32 */     this.playeru1 = ss.crop1(1, 0, 32, 32);
/* 33 */     this.playeru2 = ss.crop1(1, 1, 32, 32);
/* 34 */     this.playeru3 = ss.crop1(1, 2, 32, 32);
/* 35 */     this.playeru4 = ss.crop1(1, 3, 32, 32);
/* 37 */     this.playerl1 = ss.crop1(2, 0, 32, 32);
/* 38 */     this.playerl2 = ss.crop1(2, 1, 32, 32);
/* 39 */     this.playerl3 = ss.crop1(2, 2, 32, 32);
/* 40 */     this.playerl4 = ss.crop1(2, 3, 32, 32);
/* 42 */     this.playerr1 = ss.crop1(3, 0, 32, 32);
/* 43 */     this.playerr2 = ss.crop1(3, 1, 32, 32);
/* 44 */     this.playerr3 = ss.crop1(3, 2, 32, 32);
/* 45 */     this.playerr4 = ss.crop1(3, 3, 32, 32);
/* 50 */     grassFull = ss.crop1(0, 0, 32, 32);
/* 51 */     grassCnr1 = ss.crop1(1, 0, 32, 32);
/* 52 */     grassCnr2 = ss.crop1(1, 1, 32, 32);
/* 53 */     grassCnr3 = ss.crop1(0, 1, 32, 32);
/* 54 */     grassCnr4 = ss.crop1(2, 1, 32, 32);
/* 55 */     grassEdge1 = ss.crop1(3, 0, 32, 32);
/* 56 */     grassEdge2 = ss.crop1(5, 0, 32, 32);
/* 57 */     grassEdge3 = ss.crop1(4, 0, 32, 32);
/* 58 */     grassEdge4 = ss.crop1(2, 0, 32, 32);
/* 60 */     grassTree1 = ss.crop1(3, 1, 32, 32);
/* 65 */     this.cowd1 = ss.crop1(0, 3, 32, 32);
/* 66 */     this.cowd2 = ss.crop1(1, 3, 32, 32);
/* 67 */     this.cowd3 = ss.crop1(2, 3, 32, 32);
/* 68 */     this.cowd4 = ss.crop1(0, 3, 32, 32);
/*    */   }
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.2_8.jar!\applecraft\testgame\main\gfx\ImageManager.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */