/*     */ package beyondOrigins.main.gfx;
/*     */ 
/*     */ import beyondOrigins.main.Game;
/*     */ import java.awt.image.BufferedImage;
/*     */ 
/*     */ public class ImageManager {
/*     */   public static BufferedImage dialogueBox;
/*     */   
/*     */   public static BufferedImage pHUD;
/*     */   
/*     */   public static BufferedImage playeru1;
/*     */   
/*     */   public static BufferedImage playeru2;
/*     */   
/*     */   public static BufferedImage playeru3;
/*     */   
/*     */   public static BufferedImage playeru4;
/*     */   
/*     */   public static BufferedImage playerd1;
/*     */   
/*     */   public static BufferedImage playerd2;
/*     */   
/*     */   public static BufferedImage playerd3;
/*     */   
/*     */   public static BufferedImage playerd4;
/*     */   
/*     */   public static BufferedImage playerl1;
/*     */   
/*     */   public static BufferedImage playerl2;
/*     */   
/*     */   public static BufferedImage playerl3;
/*     */   
/*     */   public static BufferedImage playerl4;
/*     */   
/*     */   public static BufferedImage playerr1;
/*     */   
/*     */   public static BufferedImage playerr2;
/*     */   
/*     */   public static BufferedImage playerr3;
/*     */   
/*     */   public static BufferedImage playerr4;
/*     */   
/*     */   public static BufferedImage grassFull;
/*     */   
/*     */   public static BufferedImage grassBarrier;
/*     */   
/*     */   public static BufferedImage shop1;
/*     */   
/*     */   public static BufferedImage cowu1;
/*     */   
/*     */   public static BufferedImage cowu2;
/*     */   
/*     */   public static BufferedImage cowu3;
/*     */   
/*     */   public static BufferedImage cowu4;
/*     */   
/*     */   public static BufferedImage cowd1;
/*     */   
/*     */   public static BufferedImage cowd2;
/*     */   
/*     */   public static BufferedImage cowd3;
/*     */   
/*     */   public static BufferedImage cowd4;
/*     */   
/*     */   public static BufferedImage cowl1;
/*     */   
/*     */   public static BufferedImage cowl2;
/*     */   
/*     */   public static BufferedImage cowl3;
/*     */   
/*     */   public static BufferedImage cowl4;
/*     */   
/*     */   public static BufferedImage cowr1;
/*     */   
/*     */   public static BufferedImage cowr2;
/*     */   
/*     */   public static BufferedImage cowr3;
/*     */   
/*     */   public static BufferedImage cowr4;
/*     */   
/*     */   public static BufferedImage tdu1;
/*     */   
/*     */   public static BufferedImage tdu2;
/*     */   
/*     */   public static BufferedImage tdu3;
/*     */   
/*     */   public static BufferedImage tdu4;
/*     */   
/*     */   public static BufferedImage tdd1;
/*     */   
/*     */   public static BufferedImage tdd2;
/*     */   
/*     */   public static BufferedImage tdd3;
/*     */   
/*     */   public static BufferedImage tdd4;
/*     */   
/*     */   public static BufferedImage tdl1;
/*     */   
/*     */   public static BufferedImage tdl2;
/*     */   
/*     */   public static BufferedImage tdl3;
/*     */   
/*     */   public static BufferedImage tdl4;
/*     */   
/*     */   public static BufferedImage tdr1;
/*     */   
/*     */   public static BufferedImage tdr2;
/*     */   
/*     */   public static BufferedImage tdr3;
/*     */   
/*     */   public static BufferedImage tdr4;
/*     */   
/*     */   public static BufferedImage button1_1;
/*     */   
/*     */   public static BufferedImage button1_2;
/*     */   
/*     */   public static BufferedImage button1_3;
/*     */   
/*     */   public static BufferedImage button2_1;
/*     */   
/*     */   public static BufferedImage button2_2;
/*     */   
/*     */   public static BufferedImage button2_3;
/*     */   
/*     */   public static BufferedImage profileSquare;
/*     */   
/*     */   public static BufferedImage profileEmpty;
/*     */   
/*     */   public static BufferedImage profileSelection;
/*     */   
/*     */   public static BufferedImage cloud1;
/*     */   
/*     */   public static BufferedImage cloud2;
/*     */   
/*     */   public static BufferedImage cloud3;
/*     */   
/*     */   public static BufferedImage inventory1;
/*     */   
/*     */   public static BufferedImage inventory2;
/*     */   
/*     */   public static BufferedImage inventory3;
/*     */   
/*     */   public static BufferedImage tabs01;
/*     */   
/*     */   public static BufferedImage tabs02;
/*     */   
/*     */   public static BufferedImage tabs03;
/*     */   
/*     */   public static BufferedImage tabs11;
/*     */   
/*     */   public static BufferedImage tabs12;
/*     */   
/*     */   public static BufferedImage tabs13;
/*     */   
/*     */   public static BufferedImage arrow1;
/*     */   
/*     */   public static BufferedImage arrow2;
/*     */   
/*  40 */   public static short hpCropX = 81, expCropX = 83;
/*     */   
/*     */   public ImageManager() {
/*  43 */     playerSetUp();
/*  44 */     widgetSetUp();
/*  45 */     grassMapSetUp();
/*  46 */     entitySetUp();
/*  47 */     menuSetUp();
/*  48 */     inventorySetUp();
/*     */   }
/*     */   
/*     */   private void playerSetUp() {
/*  52 */     playerd1 = Game.st.getCropped(Game.playerSheet, 0, 0, 32, 32);
/*  53 */     playerd2 = Game.st.getCropped(Game.playerSheet, 0, 32, 32, 32);
/*  54 */     playerd3 = Game.st.getCropped(Game.playerSheet, 0, 64, 32, 32);
/*  55 */     playerd4 = Game.st.getCropped(Game.playerSheet, 0, 96, 32, 32);
/*  56 */     playeru1 = Game.st.getCropped(Game.playerSheet, 32, 0, 32, 32);
/*  57 */     playeru2 = Game.st.getCropped(Game.playerSheet, 32, 32, 32, 32);
/*  58 */     playeru3 = Game.st.getCropped(Game.playerSheet, 32, 64, 32, 32);
/*  59 */     playeru4 = Game.st.getCropped(Game.playerSheet, 32, 96, 32, 32);
/*  60 */     playerl1 = Game.st.getCropped(Game.playerSheet, 64, 0, 32, 32);
/*  61 */     playerl2 = Game.st.getCropped(Game.playerSheet, 64, 32, 32, 32);
/*  62 */     playerl3 = Game.st.getCropped(Game.playerSheet, 64, 64, 32, 32);
/*  63 */     playerl4 = Game.st.getCropped(Game.playerSheet, 64, 96, 32, 32);
/*  64 */     playerr1 = Game.st.getCropped(Game.playerSheet, 96, 0, 32, 32);
/*  65 */     playerr2 = Game.st.getCropped(Game.playerSheet, 96, 32, 32, 32);
/*  66 */     playerr3 = Game.st.getCropped(Game.playerSheet, 96, 64, 32, 32);
/*  67 */     playerr4 = Game.st.getCropped(Game.playerSheet, 96, 96, 32, 32);
/*     */   }
/*     */   
/*     */   public void widgetSetUp() {
/*  71 */     dialogueBox = Game.st.getCropped(Game.widgetSheet, 0, 0, 512, 160);
/*  72 */     pHUD = Game.st.getCropped(Game.widgetSheet, 0, 160, 160, 64);
/*     */   }
/*     */   
/*     */   private void grassMapSetUp() {
/*  76 */     grassFull = Game.st.getCropped(Game.terrain1Sheet, 0, 0, 32, 32);
/*  77 */     grassBarrier = Game.st.getCropped(Game.terrain1Sheet, 32, 32, 32, 32);
/*  78 */     shop1 = Game.st.getCropped(Game.terrain1Sheet, 192, 0, 96, 96);
/*     */   }
/*     */   
/*     */   private void entitySetUp() {
/*  82 */     cowd1 = Game.st.getCropped(Game.entitySheet, 0, 64, 32, 32);
/*  83 */     cowd2 = Game.st.getCropped(Game.entitySheet, 32, 64, 32, 32);
/*  84 */     cowd3 = Game.st.getCropped(Game.entitySheet, 96, 64, 32, 32);
/*  85 */     cowd4 = Game.st.getCropped(Game.entitySheet, 64, 64, 32, 32);
/*  86 */     cowu1 = Game.st.getCropped(Game.entitySheet, 0, 96, 32, 32);
/*  87 */     cowu2 = Game.st.getCropped(Game.entitySheet, 32, 96, 32, 32);
/*  88 */     cowu3 = Game.st.getCropped(Game.entitySheet, 96, 96, 32, 32);
/*  89 */     cowu4 = Game.st.getCropped(Game.entitySheet, 64, 96, 32, 32);
/*  90 */     cowl1 = Game.st.getCropped(Game.entitySheet, 0, 0, 32, 32);
/*  91 */     cowl2 = Game.st.getCropped(Game.entitySheet, 32, 0, 32, 32);
/*  92 */     cowl3 = Game.st.getCropped(Game.entitySheet, 96, 0, 32, 32);
/*  93 */     cowl4 = Game.st.getCropped(Game.entitySheet, 64, 0, 32, 32);
/*  94 */     cowr1 = Game.st.getCropped(Game.entitySheet, 0, 32, 32, 32);
/*  95 */     cowr2 = Game.st.getCropped(Game.entitySheet, 32, 32, 32, 32);
/*  96 */     cowr3 = Game.st.getCropped(Game.entitySheet, 96, 32, 32, 32);
/*  97 */     cowr4 = Game.st.getCropped(Game.entitySheet, 64, 32, 32, 32);
/*  99 */     tdd1 = Game.st.getCropped(Game.entitySheet, 0, 0, 32, 32);
/* 100 */     tdd2 = Game.st.getCropped(Game.entitySheet, 0, 32, 32, 32);
/* 101 */     tdd3 = Game.st.getCropped(Game.entitySheet, 0, 64, 32, 32);
/* 102 */     tdd4 = Game.st.getCropped(Game.entitySheet, 0, 96, 32, 32);
/* 103 */     tdu1 = Game.st.getCropped(Game.entitySheet, 32, 0, 32, 32);
/* 104 */     tdu2 = Game.st.getCropped(Game.entitySheet, 32, 32, 32, 32);
/* 105 */     tdu3 = Game.st.getCropped(Game.entitySheet, 32, 64, 32, 32);
/* 106 */     tdu4 = Game.st.getCropped(Game.entitySheet, 32, 96, 32, 32);
/* 107 */     tdl1 = Game.st.getCropped(Game.entitySheet, 64, 0, 32, 32);
/* 108 */     tdl2 = Game.st.getCropped(Game.entitySheet, 64, 32, 32, 32);
/* 109 */     tdl3 = Game.st.getCropped(Game.entitySheet, 64, 64, 32, 32);
/* 110 */     tdl4 = Game.st.getCropped(Game.entitySheet, 64, 96, 32, 32);
/* 111 */     tdr1 = Game.st.getCropped(Game.entitySheet, 96, 0, 32, 32);
/* 112 */     tdr2 = Game.st.getCropped(Game.entitySheet, 96, 32, 32, 32);
/* 113 */     tdr3 = Game.st.getCropped(Game.entitySheet, 96, 64, 32, 32);
/* 114 */     tdr4 = Game.st.getCropped(Game.entitySheet, 96, 96, 32, 32);
/*     */   }
/*     */   
/*     */   private void menuSetUp() {
/* 118 */     button1_1 = Game.st.getCropped(Game.mainmenuSheet, 0, 0, 160, 32);
/* 119 */     button1_2 = Game.st.getCropped(Game.mainmenuSheet, 0, 32, 160, 32);
/* 120 */     button1_3 = Game.st.getCropped(Game.mainmenuSheet, 0, 64, 160, 32);
/* 121 */     button2_1 = Game.st.getCropped(Game.mainmenuSheet, 0, 96, 336, 32);
/* 122 */     button2_2 = Game.st.getCropped(Game.mainmenuSheet, 0, 128, 336, 32);
/* 123 */     button2_3 = Game.st.getCropped(Game.mainmenuSheet, 0, 160, 336, 32);
/* 124 */     profileSquare = Game.st.getCropped(Game.mainmenuSheet, 288, 0, 96, 96);
/* 125 */     profileEmpty = Game.st.getCropped(Game.mainmenuSheet, 384, 0, 64, 64);
/* 126 */     profileSelection = Game.st.getCropped(Game.mainmenuSheet, 0, 192, 300, 117);
/* 127 */     cloud1 = Game.st.getCropped(Game.mainmenuSheet, 160, 0, 128, 96);
/* 128 */     cloud2 = Game.st.getCropped(Game.mainmenuSheet, 160, 0, 128, 96);
/* 129 */     cloud3 = Game.st.getCropped(Game.mainmenuSheet, 160, 0, 128, 96);
/*     */   }
/*     */   
/*     */   private void inventorySetUp() {
/* 133 */     inventory1 = Game.st.getCropped(Game.inventorySheet, 0, 0, 416, 288);
/* 134 */     inventory2 = Game.st.getCropped(Game.inventorySheet, 416, 0, 416, 288);
/* 135 */     inventory3 = Game.st.getCropped(Game.inventorySheet, 0, 288, 416, 288);
/* 136 */     tabs01 = Game.st.getCropped(Game.inventorySheet, 832, 0, 64, 64);
/* 137 */     tabs02 = Game.st.getCropped(Game.inventorySheet, 896, 0, 64, 64);
/* 138 */     tabs03 = Game.st.getCropped(Game.inventorySheet, 960, 0, 64, 64);
/* 139 */     tabs11 = Game.st.getCropped(Game.inventorySheet, 832, 64, 64, 64);
/* 140 */     tabs12 = Game.st.getCropped(Game.inventorySheet, 896, 64, 64, 64);
/* 141 */     tabs13 = Game.st.getCropped(Game.inventorySheet, 960, 64, 64, 64);
/* 142 */     arrow1 = Game.st.getCropped(Game.inventorySheet, 832, 128, 32, 64);
/* 143 */     arrow2 = Game.st.getCropped(Game.inventorySheet, 864, 128, 32, 64);
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.6_4.jar!\beyondOrigins\main\gfx\ImageManager.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */