/*     */ package beyondOrigins.main.gfx;
/*     */ 
/*     */ import java.awt.image.BufferedImage;
/*     */ 
/*     */ public class ImageManager {
/*     */   public BufferedImage dialogueBox;
/*     */   
/*     */   public BufferedImage pHUD;
/*     */   
/*     */   public BufferedImage pHUDHealth;
/*     */   
/*     */   public BufferedImage pHUDExp;
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
/*  42 */     playerSetUp(ss);
/*  43 */     widgetSetUp(ss);
/*  44 */     grassMapSetUp(ss);
/*  45 */     entitySetUp(ss);
/*  46 */     menuSetUp(ss);
/*  47 */     inventorySetUp(ss);
/*     */   }
/*     */   
/*     */   private void playerSetUp(SpriteSheet ss) {
/*  52 */     this.playerd1 = ss.basic512Crop(0, 0, 32, 32);
/*  53 */     this.playerd2 = ss.basic512Crop(0, 1, 32, 32);
/*  54 */     this.playerd3 = ss.basic512Crop(0, 2, 32, 32);
/*  55 */     this.playerd4 = ss.basic512Crop(0, 3, 32, 32);
/*  56 */     this.playeru1 = ss.basic512Crop(1, 0, 32, 32);
/*  57 */     this.playeru2 = ss.basic512Crop(1, 1, 32, 32);
/*  58 */     this.playeru3 = ss.basic512Crop(1, 2, 32, 32);
/*  59 */     this.playeru4 = ss.basic512Crop(1, 3, 32, 32);
/*  60 */     this.playerl1 = ss.basic512Crop(2, 0, 32, 32);
/*  61 */     this.playerl2 = ss.basic512Crop(2, 1, 32, 32);
/*  62 */     this.playerl3 = ss.basic512Crop(2, 2, 32, 32);
/*  63 */     this.playerl4 = ss.basic512Crop(2, 3, 32, 32);
/*  64 */     this.playerr1 = ss.basic512Crop(3, 0, 32, 32);
/*  65 */     this.playerr2 = ss.basic512Crop(3, 1, 32, 32);
/*  66 */     this.playerr3 = ss.basic512Crop(3, 2, 32, 32);
/*  67 */     this.playerr4 = ss.basic512Crop(3, 3, 32, 32);
/*     */   }
/*     */   
/*     */   private void widgetSetUp(SpriteSheet ss) {
/*  71 */     this.dialogueBox = ss.custom512Crop(0, 0, 512, 160);
/*  72 */     this.pHUD = ss.custom512Crop(0, 160, 160, 64);
/*  73 */     this.pHUDHealth = ss.custom512Crop(160, 160, 81, 8);
/*  74 */     this.pHUDExp = ss.custom512Crop(160, 168, 83, 8);
/*     */   }
/*     */   
/*     */   private void grassMapSetUp(SpriteSheet ss) {
/*  78 */     grassFull = ss.tileCrop(0, 0, 32, 32);
/*  79 */     grassCnr1 = ss.tileCrop(1, 0, 32, 32);
/*  80 */     grassCnr2 = ss.tileCrop(1, 1, 32, 32);
/*  81 */     grassCnr3 = ss.tileCrop(0, 1, 32, 32);
/*  82 */     grassCnr4 = ss.tileCrop(2, 1, 32, 32);
/*  83 */     grassEdge1 = ss.tileCrop(3, 0, 32, 32);
/*  84 */     grassEdge2 = ss.tileCrop(5, 0, 32, 32);
/*  85 */     grassEdge3 = ss.tileCrop(4, 0, 32, 32);
/*  86 */     grassEdge4 = ss.tileCrop(2, 0, 32, 32);
/*  87 */     grassTree1 = ss.tileCrop(3, 1, 32, 32);
/*  88 */     shop1 = ss.buildingCrop(2, 0, 96, 96);
/*  89 */     path1_1 = ss.tileCrop(4, 1, 32, 32);
/*  90 */     path1_2 = ss.tileCrop(5, 1, 32, 32);
/*  91 */     path1Cnr1 = ss.tileCrop(0, 2, 32, 32);
/*  92 */     path1Cnr2 = ss.tileCrop(1, 2, 32, 32);
/*  93 */     path1Cnr3 = ss.tileCrop(2, 2, 32, 32);
/*  94 */     path1Cnr4 = ss.tileCrop(3, 2, 32, 32);
/*     */   }
/*     */   
/*     */   private void entitySetUp(SpriteSheet ss) {
/*  98 */     this.cowd1 = ss.basic512Crop(0, 2, 32, 32);
/*  99 */     this.cowd2 = ss.basic512Crop(1, 2, 32, 32);
/* 100 */     this.cowd3 = ss.basic512Crop(3, 2, 32, 32);
/* 101 */     this.cowd4 = ss.basic512Crop(2, 2, 32, 32);
/* 102 */     this.cowu1 = ss.basic512Crop(0, 3, 32, 32);
/* 103 */     this.cowu2 = ss.basic512Crop(1, 3, 32, 32);
/* 104 */     this.cowu3 = ss.basic512Crop(3, 3, 32, 32);
/* 105 */     this.cowu4 = ss.basic512Crop(2, 3, 32, 32);
/* 106 */     this.cowl1 = ss.basic512Crop(0, 0, 32, 32);
/* 107 */     this.cowl2 = ss.basic512Crop(1, 0, 32, 32);
/* 108 */     this.cowl3 = ss.basic512Crop(3, 0, 32, 32);
/* 109 */     this.cowl4 = ss.basic512Crop(2, 0, 32, 32);
/* 110 */     this.cowr1 = ss.basic512Crop(0, 1, 32, 32);
/* 111 */     this.cowr2 = ss.basic512Crop(1, 1, 32, 32);
/* 112 */     this.cowr3 = ss.basic512Crop(3, 1, 32, 32);
/* 113 */     this.cowr4 = ss.basic512Crop(2, 1, 32, 32);
/* 115 */     this.tdd1 = ss.basic512Crop(0, 0, 32, 32);
/* 116 */     this.tdd2 = ss.basic512Crop(0, 1, 32, 32);
/* 117 */     this.tdd3 = ss.basic512Crop(0, 2, 32, 32);
/* 118 */     this.tdd4 = ss.basic512Crop(0, 3, 32, 32);
/* 119 */     this.tdu1 = ss.basic512Crop(1, 0, 32, 32);
/* 120 */     this.tdu2 = ss.basic512Crop(1, 1, 32, 32);
/* 121 */     this.tdu3 = ss.basic512Crop(1, 2, 32, 32);
/* 122 */     this.tdu4 = ss.basic512Crop(1, 3, 32, 32);
/* 123 */     this.tdl1 = ss.basic512Crop(2, 0, 32, 32);
/* 124 */     this.tdl2 = ss.basic512Crop(2, 1, 32, 32);
/* 125 */     this.tdl3 = ss.basic512Crop(2, 2, 32, 32);
/* 126 */     this.tdl4 = ss.basic512Crop(2, 3, 32, 32);
/* 127 */     this.tdr1 = ss.basic512Crop(3, 0, 32, 32);
/* 128 */     this.tdr2 = ss.basic512Crop(3, 1, 32, 32);
/* 129 */     this.tdr3 = ss.basic512Crop(3, 2, 32, 32);
/* 130 */     this.tdr4 = ss.basic512Crop(3, 3, 32, 32);
/*     */   }
/*     */   
/*     */   private void menuSetUp(SpriteSheet ss) {
/* 134 */     this.button1_1 = ss.button1Crop(0, 0, 160, 32);
/* 135 */     this.button1_2 = ss.button1Crop(0, 1, 160, 32);
/* 136 */     this.button1_3 = ss.button1Crop(0, 2, 160, 32);
/* 137 */     this.button2_1 = ss.button2Crop(0, 3, 336, 32);
/* 138 */     this.button2_2 = ss.button2Crop(0, 4, 336, 32);
/* 139 */     this.button2_3 = ss.button2Crop(0, 5, 336, 32);
/* 140 */     this.profileSquare = ss.custom512Crop(288, 0, 96, 96);
/* 141 */     this.profileEmpty = ss.custom512Crop(384, 0, 64, 64);
/* 142 */     this.profileSelection = ss.custom512Crop(0, 192, 300, 117);
/* 143 */     this.cloud1 = ss.cloudCrop(1, 0, 128, 96);
/* 144 */     this.cloud2 = ss.cloudCrop(1, 0, 128, 96);
/* 145 */     this.cloud3 = ss.cloudCrop(1, 0, 128, 96);
/*     */   }
/*     */   
/*     */   private void inventorySetUp(SpriteSheet ss) {
/* 149 */     this.inventory1 = ss.custom1024Crop(0, 0, 416, 288);
/* 150 */     this.inventory2 = ss.custom1024Crop(416, 0, 416, 288);
/* 151 */     this.inventory3 = ss.custom1024Crop(0, 288, 416, 288);
/* 152 */     this.tabs01 = ss.invTabCrop(13, 0, 64, 64);
/* 153 */     this.tabs02 = ss.invTabCrop(14, 0, 64, 64);
/* 154 */     this.tabs03 = ss.invTabCrop(15, 0, 64, 64);
/* 155 */     this.tabs11 = ss.invTabCrop(13, 1, 64, 64);
/* 156 */     this.tabs12 = ss.invTabCrop(14, 1, 64, 64);
/* 157 */     this.tabs13 = ss.invTabCrop(15, 1, 64, 64);
/* 158 */     this.arrow1 = ss.arrowCrop(26, 2, 32, 64);
/* 159 */     this.arrow2 = ss.arrowCrop(27, 2, 32, 64);
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.5_5.jar!\beyondOrigins\main\gfx\ImageManager.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */