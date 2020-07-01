/*     */ package applecraft.testgame.main.gfx;
/*     */ 
/*     */ import java.awt.image.BufferedImage;
/*     */ 
/*     */ public class ImageManager {
/*     */   public BufferedImage playerd1;
/*     */   
/*     */   public BufferedImage playerd2;
/*     */   
/*     */   public BufferedImage playerd3;
/*     */   
/*     */   public BufferedImage playerd4;
/*     */   
/*     */   public BufferedImage playeru1;
/*     */   
/*     */   public BufferedImage playeru2;
/*     */   
/*     */   public BufferedImage playeru3;
/*     */   
/*     */   public BufferedImage playeru4;
/*     */   
/*     */   public BufferedImage playerl1;
/*     */   
/*     */   public BufferedImage playerl2;
/*     */   
/*     */   public BufferedImage playerl3;
/*     */   
/*     */   public BufferedImage playerl4;
/*     */   
/*     */   public BufferedImage playerr1;
/*     */   
/*     */   public BufferedImage playerr2;
/*     */   
/*     */   public BufferedImage playerr3;
/*     */   
/*     */   public BufferedImage playerr4;
/*     */   
/*     */   public static BufferedImage grassFull;
/*     */   
/*     */   public static BufferedImage grassCnr1;
/*     */   
/*     */   public static BufferedImage grassCnr2;
/*     */   
/*     */   public static BufferedImage grassCnr3;
/*     */   
/*     */   public static BufferedImage grassCnr4;
/*     */   
/*     */   public static BufferedImage grassEdge1;
/*     */   
/*     */   public static BufferedImage grassEdge2;
/*     */   
/*     */   public static BufferedImage grassEdge3;
/*     */   
/*     */   public static BufferedImage grassEdge4;
/*     */   
/*     */   public static BufferedImage grassTree1;
/*     */   
/*     */   public static BufferedImage shop1;
/*     */   
/*     */   public static BufferedImage path1_1;
/*     */   
/*     */   public static BufferedImage path1_2;
/*     */   
/*     */   public static BufferedImage path1Cnr1;
/*     */   
/*     */   public static BufferedImage path1Cnr2;
/*     */   
/*     */   public static BufferedImage path1Cnr3;
/*     */   
/*     */   public static BufferedImage path1Cnr4;
/*     */   
/*     */   public BufferedImage cowd1;
/*     */   
/*     */   public BufferedImage cowd2;
/*     */   
/*     */   public BufferedImage cowd3;
/*     */   
/*     */   public BufferedImage cowd4;
/*     */   
/*     */   public BufferedImage cowu1;
/*     */   
/*     */   public BufferedImage cowu2;
/*     */   
/*     */   public BufferedImage cowu3;
/*     */   
/*     */   public BufferedImage cowu4;
/*     */   
/*     */   public BufferedImage cowl1;
/*     */   
/*     */   public BufferedImage cowl2;
/*     */   
/*     */   public BufferedImage cowl3;
/*     */   
/*     */   public BufferedImage cowl4;
/*     */   
/*     */   public BufferedImage cowr1;
/*     */   
/*     */   public BufferedImage cowr2;
/*     */   
/*     */   public BufferedImage cowr3;
/*     */   
/*     */   public BufferedImage cowr4;
/*     */   
/*     */   public BufferedImage playButton1;
/*     */   
/*     */   public BufferedImage playButton2;
/*     */   
/*     */   public BufferedImage playButton3;
/*     */   
/*     */   public BufferedImage cloud1;
/*     */   
/*     */   public BufferedImage cloud2;
/*     */   
/*     */   public BufferedImage cloud3;
/*     */   
/*     */   public BufferedImage inventory1;
/*     */   
/*     */   public BufferedImage inventory2;
/*     */   
/*     */   public BufferedImage inventory3;
/*     */   
/*     */   public BufferedImage tabs01;
/*     */   
/*     */   public BufferedImage tabs02;
/*     */   
/*     */   public BufferedImage tabs03;
/*     */   
/*     */   public BufferedImage tabs11;
/*     */   
/*     */   public BufferedImage tabs12;
/*     */   
/*     */   public BufferedImage tabs13;
/*     */   
/*     */   public BufferedImage arrow1;
/*     */   
/*     */   public BufferedImage arrow2;
/*     */   
/*     */   public ImageManager(SpriteSheet ss) {
/*  38 */     this.playerd1 = ss.crop1(0, 0, 32, 32);
/*  39 */     this.playerd2 = ss.crop1(0, 1, 32, 32);
/*  40 */     this.playerd3 = ss.crop1(0, 2, 32, 32);
/*  41 */     this.playerd4 = ss.crop1(0, 3, 32, 32);
/*  43 */     this.playeru1 = ss.crop1(1, 0, 32, 32);
/*  44 */     this.playeru2 = ss.crop1(1, 1, 32, 32);
/*  45 */     this.playeru3 = ss.crop1(1, 2, 32, 32);
/*  46 */     this.playeru4 = ss.crop1(1, 3, 32, 32);
/*  48 */     this.playerl1 = ss.crop1(2, 0, 32, 32);
/*  49 */     this.playerl2 = ss.crop1(2, 1, 32, 32);
/*  50 */     this.playerl3 = ss.crop1(2, 2, 32, 32);
/*  51 */     this.playerl4 = ss.crop1(2, 3, 32, 32);
/*  53 */     this.playerr1 = ss.crop1(3, 0, 32, 32);
/*  54 */     this.playerr2 = ss.crop1(3, 1, 32, 32);
/*  55 */     this.playerr3 = ss.crop1(3, 2, 32, 32);
/*  56 */     this.playerr4 = ss.crop1(3, 3, 32, 32);
/*  61 */     grassFull = ss.crop8(0, 0, 32, 32);
/*  62 */     grassCnr1 = ss.crop8(1, 0, 32, 32);
/*  63 */     grassCnr2 = ss.crop8(1, 1, 32, 32);
/*  64 */     grassCnr3 = ss.crop8(0, 1, 32, 32);
/*  65 */     grassCnr4 = ss.crop8(2, 1, 32, 32);
/*  66 */     grassEdge1 = ss.crop8(3, 0, 32, 32);
/*  67 */     grassEdge2 = ss.crop8(5, 0, 32, 32);
/*  68 */     grassEdge3 = ss.crop8(4, 0, 32, 32);
/*  69 */     grassEdge4 = ss.crop8(2, 0, 32, 32);
/*  71 */     grassTree1 = ss.crop8(3, 1, 32, 32);
/*  73 */     shop1 = ss.crop7(2, 0, 96, 96);
/*  75 */     path1_1 = ss.crop8(4, 1, 32, 32);
/*  76 */     path1_2 = ss.crop8(5, 1, 32, 32);
/*  77 */     path1Cnr1 = ss.crop8(0, 2, 32, 32);
/*  78 */     path1Cnr2 = ss.crop8(1, 2, 32, 32);
/*  79 */     path1Cnr3 = ss.crop8(2, 2, 32, 32);
/*  80 */     path1Cnr4 = ss.crop8(3, 2, 32, 32);
/*  87 */     this.cowd1 = ss.crop1(0, 2, 32, 32);
/*  88 */     this.cowd2 = ss.crop1(1, 2, 32, 32);
/*  89 */     this.cowd3 = ss.crop1(3, 2, 32, 32);
/*  90 */     this.cowd4 = ss.crop1(2, 2, 32, 32);
/*  92 */     this.cowu1 = ss.crop1(0, 3, 32, 32);
/*  93 */     this.cowu2 = ss.crop1(1, 3, 32, 32);
/*  94 */     this.cowu3 = ss.crop1(3, 3, 32, 32);
/*  95 */     this.cowu4 = ss.crop1(2, 3, 32, 32);
/*  97 */     this.cowl1 = ss.crop1(0, 0, 32, 32);
/*  98 */     this.cowl2 = ss.crop1(1, 0, 32, 32);
/*  99 */     this.cowl3 = ss.crop1(3, 0, 32, 32);
/* 100 */     this.cowl4 = ss.crop1(2, 0, 32, 32);
/* 102 */     this.cowr1 = ss.crop1(0, 1, 32, 32);
/* 103 */     this.cowr2 = ss.crop1(1, 1, 32, 32);
/* 104 */     this.cowr3 = ss.crop1(3, 1, 32, 32);
/* 105 */     this.cowr4 = ss.crop1(2, 1, 32, 32);
/* 110 */     this.playButton1 = ss.crop2(0, 0, 160, 32);
/* 111 */     this.playButton2 = ss.crop2(0, 1, 160, 32);
/* 112 */     this.playButton3 = ss.crop2(0, 2, 160, 32);
/* 114 */     this.cloud1 = ss.crop3(1, 0, 128, 96);
/* 115 */     this.cloud2 = ss.crop3(1, 0, 128, 96);
/* 116 */     this.cloud3 = ss.crop3(1, 0, 128, 96);
/* 122 */     this.inventory1 = ss.crop4(0, 0, 416, 288);
/* 123 */     this.inventory2 = ss.crop4(1, 0, 416, 288);
/* 124 */     this.inventory3 = ss.crop4(0, 1, 416, 288);
/* 128 */     this.tabs01 = ss.crop5(13, 0, 64, 64);
/* 129 */     this.tabs02 = ss.crop5(14, 0, 64, 64);
/* 130 */     this.tabs03 = ss.crop5(15, 0, 64, 64);
/* 131 */     this.tabs11 = ss.crop5(13, 1, 64, 64);
/* 132 */     this.tabs12 = ss.crop5(14, 1, 64, 64);
/* 133 */     this.tabs13 = ss.crop5(15, 1, 64, 64);
/* 137 */     this.arrow1 = ss.crop6(26, 2, 32, 64);
/* 138 */     this.arrow2 = ss.crop6(27, 2, 32, 64);
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.4.2_5.jar!\applecraft\testgame\main\gfx\ImageManager.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */