/*     */ package beyondOrigins.main.gfx;
/*     */ 
/*     */ import java.awt.image.BufferedImage;
/*     */ 
/*     */ public class ImageManager {
/*     */   public BufferedImage dialogueBox;
/*     */   
/*     */   public BufferedImage playeru1;
/*     */   
/*     */   public BufferedImage playeru2;
/*     */   
/*     */   public BufferedImage playeru3;
/*     */   
/*     */   public BufferedImage playeru4;
/*     */   
/*     */   public BufferedImage playerd1;
/*     */   
/*     */   public BufferedImage playerd2;
/*     */   
/*     */   public BufferedImage playerd3;
/*     */   
/*     */   public BufferedImage playerd4;
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
/*     */   public BufferedImage cowu1;
/*     */   
/*     */   public BufferedImage cowu2;
/*     */   
/*     */   public BufferedImage cowu3;
/*     */   
/*     */   public BufferedImage cowu4;
/*     */   
/*     */   public BufferedImage cowd1;
/*     */   
/*     */   public BufferedImage cowd2;
/*     */   
/*     */   public BufferedImage cowd3;
/*     */   
/*     */   public BufferedImage cowd4;
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
/*     */   public BufferedImage tdu1;
/*     */   
/*     */   public BufferedImage tdu2;
/*     */   
/*     */   public BufferedImage tdu3;
/*     */   
/*     */   public BufferedImage tdu4;
/*     */   
/*     */   public BufferedImage tdd1;
/*     */   
/*     */   public BufferedImage tdd2;
/*     */   
/*     */   public BufferedImage tdd3;
/*     */   
/*     */   public BufferedImage tdd4;
/*     */   
/*     */   public BufferedImage tdl1;
/*     */   
/*     */   public BufferedImage tdl2;
/*     */   
/*     */   public BufferedImage tdl3;
/*     */   
/*     */   public BufferedImage tdl4;
/*     */   
/*     */   public BufferedImage tdr1;
/*     */   
/*     */   public BufferedImage tdr2;
/*     */   
/*     */   public BufferedImage tdr3;
/*     */   
/*     */   public BufferedImage tdr4;
/*     */   
/*     */   public BufferedImage button1_1;
/*     */   
/*     */   public BufferedImage button1_2;
/*     */   
/*     */   public BufferedImage button1_3;
/*     */   
/*     */   public BufferedImage button2_1;
/*     */   
/*     */   public BufferedImage button2_2;
/*     */   
/*     */   public BufferedImage button2_3;
/*     */   
/*     */   public BufferedImage profileSquare;
/*     */   
/*     */   public BufferedImage profileEmpty;
/*     */   
/*     */   public BufferedImage profileSelection;
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
/*  51 */     playerSetUp(ss);
/*  52 */     widgetSetUp(ss);
/*  53 */     grassMapSetUp(ss);
/*  54 */     entitySetUp(ss);
/*  55 */     menuSetUp(ss);
/*  56 */     inventorySetUp(ss);
/*     */   }
/*     */   
/*     */   private void playerSetUp(SpriteSheet ss) {
/*  61 */     this.playerd1 = ss.basic512Crop(0, 0, 32, 32);
/*  62 */     this.playerd2 = ss.basic512Crop(0, 1, 32, 32);
/*  63 */     this.playerd3 = ss.basic512Crop(0, 2, 32, 32);
/*  64 */     this.playerd4 = ss.basic512Crop(0, 3, 32, 32);
/*  65 */     this.playeru1 = ss.basic512Crop(1, 0, 32, 32);
/*  66 */     this.playeru2 = ss.basic512Crop(1, 1, 32, 32);
/*  67 */     this.playeru3 = ss.basic512Crop(1, 2, 32, 32);
/*  68 */     this.playeru4 = ss.basic512Crop(1, 3, 32, 32);
/*  69 */     this.playerl1 = ss.basic512Crop(2, 0, 32, 32);
/*  70 */     this.playerl2 = ss.basic512Crop(2, 1, 32, 32);
/*  71 */     this.playerl3 = ss.basic512Crop(2, 2, 32, 32);
/*  72 */     this.playerl4 = ss.basic512Crop(2, 3, 32, 32);
/*  73 */     this.playerr1 = ss.basic512Crop(3, 0, 32, 32);
/*  74 */     this.playerr2 = ss.basic512Crop(3, 1, 32, 32);
/*  75 */     this.playerr3 = ss.basic512Crop(3, 2, 32, 32);
/*  76 */     this.playerr4 = ss.basic512Crop(3, 3, 32, 32);
/*     */   }
/*     */   
/*     */   private void widgetSetUp(SpriteSheet ss) {
/*  80 */     this.dialogueBox = ss.custom512Crop(0, 0, 512, 160);
/*     */   }
/*     */   
/*     */   private void grassMapSetUp(SpriteSheet ss) {
/*  84 */     grassFull = ss.tileCrop(0, 0, 32, 32);
/*  85 */     grassCnr1 = ss.tileCrop(1, 0, 32, 32);
/*  86 */     grassCnr2 = ss.tileCrop(1, 1, 32, 32);
/*  87 */     grassCnr3 = ss.tileCrop(0, 1, 32, 32);
/*  88 */     grassCnr4 = ss.tileCrop(2, 1, 32, 32);
/*  89 */     grassEdge1 = ss.tileCrop(3, 0, 32, 32);
/*  90 */     grassEdge2 = ss.tileCrop(5, 0, 32, 32);
/*  91 */     grassEdge3 = ss.tileCrop(4, 0, 32, 32);
/*  92 */     grassEdge4 = ss.tileCrop(2, 0, 32, 32);
/*  93 */     grassTree1 = ss.tileCrop(3, 1, 32, 32);
/*  94 */     shop1 = ss.buildingCrop(2, 0, 96, 96);
/*  95 */     path1_1 = ss.tileCrop(4, 1, 32, 32);
/*  96 */     path1_2 = ss.tileCrop(5, 1, 32, 32);
/*  97 */     path1Cnr1 = ss.tileCrop(0, 2, 32, 32);
/*  98 */     path1Cnr2 = ss.tileCrop(1, 2, 32, 32);
/*  99 */     path1Cnr3 = ss.tileCrop(2, 2, 32, 32);
/* 100 */     path1Cnr4 = ss.tileCrop(3, 2, 32, 32);
/*     */   }
/*     */   
/*     */   private void entitySetUp(SpriteSheet ss) {
/* 104 */     this.cowd1 = ss.basic512Crop(0, 2, 32, 32);
/* 105 */     this.cowd2 = ss.basic512Crop(1, 2, 32, 32);
/* 106 */     this.cowd3 = ss.basic512Crop(3, 2, 32, 32);
/* 107 */     this.cowd4 = ss.basic512Crop(2, 2, 32, 32);
/* 108 */     this.cowu1 = ss.basic512Crop(0, 3, 32, 32);
/* 109 */     this.cowu2 = ss.basic512Crop(1, 3, 32, 32);
/* 110 */     this.cowu3 = ss.basic512Crop(3, 3, 32, 32);
/* 111 */     this.cowu4 = ss.basic512Crop(2, 3, 32, 32);
/* 112 */     this.cowl1 = ss.basic512Crop(0, 0, 32, 32);
/* 113 */     this.cowl2 = ss.basic512Crop(1, 0, 32, 32);
/* 114 */     this.cowl3 = ss.basic512Crop(3, 0, 32, 32);
/* 115 */     this.cowl4 = ss.basic512Crop(2, 0, 32, 32);
/* 116 */     this.cowr1 = ss.basic512Crop(0, 1, 32, 32);
/* 117 */     this.cowr2 = ss.basic512Crop(1, 1, 32, 32);
/* 118 */     this.cowr3 = ss.basic512Crop(3, 1, 32, 32);
/* 119 */     this.cowr4 = ss.basic512Crop(2, 1, 32, 32);
/* 121 */     this.tdd1 = ss.basic512Crop(0, 0, 32, 32);
/* 122 */     this.tdd2 = ss.basic512Crop(0, 1, 32, 32);
/* 123 */     this.tdd3 = ss.basic512Crop(0, 2, 32, 32);
/* 124 */     this.tdd4 = ss.basic512Crop(0, 3, 32, 32);
/* 125 */     this.tdu1 = ss.basic512Crop(1, 0, 32, 32);
/* 126 */     this.tdu2 = ss.basic512Crop(1, 1, 32, 32);
/* 127 */     this.tdu3 = ss.basic512Crop(1, 2, 32, 32);
/* 128 */     this.tdu4 = ss.basic512Crop(1, 3, 32, 32);
/* 129 */     this.tdl1 = ss.basic512Crop(2, 0, 32, 32);
/* 130 */     this.tdl2 = ss.basic512Crop(2, 1, 32, 32);
/* 131 */     this.tdl3 = ss.basic512Crop(2, 2, 32, 32);
/* 132 */     this.tdl4 = ss.basic512Crop(2, 3, 32, 32);
/* 133 */     this.tdr1 = ss.basic512Crop(3, 0, 32, 32);
/* 134 */     this.tdr2 = ss.basic512Crop(3, 1, 32, 32);
/* 135 */     this.tdr3 = ss.basic512Crop(3, 2, 32, 32);
/* 136 */     this.tdr4 = ss.basic512Crop(3, 3, 32, 32);
/*     */   }
/*     */   
/*     */   private void menuSetUp(SpriteSheet ss) {
/* 140 */     this.button1_1 = ss.button1Crop(0, 0, 160, 32);
/* 141 */     this.button1_2 = ss.button1Crop(0, 1, 160, 32);
/* 142 */     this.button1_3 = ss.button1Crop(0, 2, 160, 32);
/* 143 */     this.button2_1 = ss.button2Crop(0, 3, 336, 32);
/* 144 */     this.button2_2 = ss.button2Crop(0, 4, 336, 32);
/* 145 */     this.button2_3 = ss.button2Crop(0, 5, 336, 32);
/* 146 */     this.profileSquare = ss.custom512Crop(288, 0, 96, 96);
/* 147 */     this.profileEmpty = ss.custom512Crop(384, 0, 64, 64);
/* 148 */     this.profileSelection = ss.custom512Crop(0, 192, 300, 117);
/* 149 */     this.cloud1 = ss.cloudCrop(1, 0, 128, 96);
/* 150 */     this.cloud2 = ss.cloudCrop(1, 0, 128, 96);
/* 151 */     this.cloud3 = ss.cloudCrop(1, 0, 128, 96);
/*     */   }
/*     */   
/*     */   private void inventorySetUp(SpriteSheet ss) {
/* 155 */     this.inventory1 = ss.custom1024Crop(0, 0, 416, 288);
/* 156 */     this.inventory2 = ss.custom1024Crop(416, 0, 416, 288);
/* 157 */     this.inventory3 = ss.custom1024Crop(0, 288, 416, 288);
/* 158 */     this.tabs01 = ss.invTabCrop(13, 0, 64, 64);
/* 159 */     this.tabs02 = ss.invTabCrop(14, 0, 64, 64);
/* 160 */     this.tabs03 = ss.invTabCrop(15, 0, 64, 64);
/* 161 */     this.tabs11 = ss.invTabCrop(13, 1, 64, 64);
/* 162 */     this.tabs12 = ss.invTabCrop(14, 1, 64, 64);
/* 163 */     this.tabs13 = ss.invTabCrop(15, 1, 64, 64);
/* 164 */     this.arrow1 = ss.arrowCrop(26, 2, 32, 64);
/* 165 */     this.arrow2 = ss.arrowCrop(27, 2, 32, 64);
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.5_4.jar!\beyondOrigins\main\gfx\ImageManager.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */