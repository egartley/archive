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
/*    */   public BufferedImage playButton1;
/*    */   
/*    */   public BufferedImage playButton2;
/*    */   
/*    */   public BufferedImage playButton3;
/*    */   
/*    */   public BufferedImage cloud1;
/*    */   
/*    */   public BufferedImage cloud2;
/*    */   
/*    */   public BufferedImage cloud3;
/*    */   
/*    */   public ImageManager(SpriteSheet ss) {
/* 30 */     this.playerd1 = ss.crop1(0, 0, 32, 32);
/* 31 */     this.playerd2 = ss.crop1(0, 1, 32, 32);
/* 32 */     this.playerd3 = ss.crop1(0, 2, 32, 32);
/* 33 */     this.playerd4 = ss.crop1(0, 3, 32, 32);
/* 35 */     this.playeru1 = ss.crop1(1, 0, 32, 32);
/* 36 */     this.playeru2 = ss.crop1(1, 1, 32, 32);
/* 37 */     this.playeru3 = ss.crop1(1, 2, 32, 32);
/* 38 */     this.playeru4 = ss.crop1(1, 3, 32, 32);
/* 40 */     this.playerl1 = ss.crop1(2, 0, 32, 32);
/* 41 */     this.playerl2 = ss.crop1(2, 1, 32, 32);
/* 42 */     this.playerl3 = ss.crop1(2, 2, 32, 32);
/* 43 */     this.playerl4 = ss.crop1(2, 3, 32, 32);
/* 45 */     this.playerr1 = ss.crop1(3, 0, 32, 32);
/* 46 */     this.playerr2 = ss.crop1(3, 1, 32, 32);
/* 47 */     this.playerr3 = ss.crop1(3, 2, 32, 32);
/* 48 */     this.playerr4 = ss.crop1(3, 3, 32, 32);
/* 53 */     grassFull = ss.crop1(0, 0, 32, 32);
/* 54 */     grassCnr1 = ss.crop1(1, 0, 32, 32);
/* 55 */     grassCnr2 = ss.crop1(1, 1, 32, 32);
/* 56 */     grassCnr3 = ss.crop1(0, 1, 32, 32);
/* 57 */     grassCnr4 = ss.crop1(2, 1, 32, 32);
/* 58 */     grassEdge1 = ss.crop1(3, 0, 32, 32);
/* 59 */     grassEdge2 = ss.crop1(5, 0, 32, 32);
/* 60 */     grassEdge3 = ss.crop1(4, 0, 32, 32);
/* 61 */     grassEdge4 = ss.crop1(2, 0, 32, 32);
/* 63 */     grassTree1 = ss.crop1(3, 1, 32, 32);
/* 70 */     this.cowd1 = ss.crop1(0, 2, 32, 32);
/* 71 */     this.cowd2 = ss.crop1(1, 2, 32, 32);
/* 72 */     this.cowd3 = ss.crop1(3, 2, 32, 32);
/* 73 */     this.cowd4 = ss.crop1(2, 2, 32, 32);
/* 75 */     this.cowu1 = ss.crop1(0, 3, 32, 32);
/* 76 */     this.cowu2 = ss.crop1(1, 3, 32, 32);
/* 77 */     this.cowu3 = ss.crop1(3, 3, 32, 32);
/* 78 */     this.cowu4 = ss.crop1(2, 3, 32, 32);
/* 80 */     this.cowl1 = ss.crop1(0, 0, 32, 32);
/* 81 */     this.cowl2 = ss.crop1(1, 0, 32, 32);
/* 82 */     this.cowl3 = ss.crop1(3, 0, 32, 32);
/* 83 */     this.cowl4 = ss.crop1(2, 0, 32, 32);
/* 85 */     this.cowr1 = ss.crop1(0, 1, 32, 32);
/* 86 */     this.cowr2 = ss.crop1(1, 1, 32, 32);
/* 87 */     this.cowr3 = ss.crop1(3, 1, 32, 32);
/* 88 */     this.cowr4 = ss.crop1(2, 1, 32, 32);
/* 93 */     this.playButton1 = ss.crop2(0, 0, 160, 32);
/* 94 */     this.playButton2 = ss.crop2(0, 1, 160, 32);
/* 95 */     this.playButton3 = ss.crop2(0, 2, 160, 32);
/* 97 */     this.cloud1 = ss.crop3(1, 0, 128, 96);
/* 98 */     this.cloud2 = ss.crop3(1, 0, 128, 96);
/* 99 */     this.cloud3 = ss.crop3(1, 0, 128, 96);
/*    */   }
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.3_8.jar!\applecraft\testgame\main\gfx\ImageManager.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */