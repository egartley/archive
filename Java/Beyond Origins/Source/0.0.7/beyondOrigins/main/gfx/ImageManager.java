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
/*     */   public static BufferedImage playeru1_a;
/*     */   
/*     */   public static BufferedImage playeru2_a;
/*     */   
/*     */   public static BufferedImage playeru3_a;
/*     */   
/*     */   public static BufferedImage playeru4_a;
/*     */   
/*     */   public static BufferedImage playerd1_a;
/*     */   
/*     */   public static BufferedImage playerd2_a;
/*     */   
/*     */   public static BufferedImage playerd3_a;
/*     */   
/*     */   public static BufferedImage playerd4_a;
/*     */   
/*     */   public static BufferedImage playerl1_a;
/*     */   
/*     */   public static BufferedImage playerl2_a;
/*     */   
/*     */   public static BufferedImage playerl3_a;
/*     */   
/*     */   public static BufferedImage playerl4_a;
/*     */   
/*     */   public static BufferedImage playerr1_a;
/*     */   
/*     */   public static BufferedImage playerr2_a;
/*     */   
/*     */   public static BufferedImage playerr3_a;
/*     */   
/*     */   public static BufferedImage playerr4_a;
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
/*     */   public static BufferedImage tab1_1;
/*     */   
/*     */   public static BufferedImage tab2_1;
/*     */   
/*     */   public static BufferedImage tab3_1;
/*     */   
/*     */   public static BufferedImage tab1_2;
/*     */   
/*     */   public static BufferedImage tab2_2;
/*     */   
/*     */   public static BufferedImage tab3_2;
/*     */   
/*     */   public static BufferedImage arrow_1;
/*     */   
/*     */   public static BufferedImage arrow_2;
/*     */   
/*     */   public static BufferedImage quest_1;
/*     */   
/*     */   public static BufferedImage quest_2;
/*     */   
/*  36 */   public static short hpCropX = 81, expCropX = 83;
/*     */   
/*     */   public ImageManager() {
/*  39 */     playerSetUp();
/*  40 */     widgetSetUp();
/*  41 */     grassMapSetUp();
/*  42 */     entitySetUp();
/*  43 */     menuSetUp();
/*  44 */     inventorySetUp();
/*     */   }
/*     */   
/*     */   private void playerSetUp() {
/*  48 */     playerd1 = Game.st.getCropped(Game.playerSheet, 0, 0, 32, 32);
/*  49 */     playerd2 = Game.st.getCropped(Game.playerSheet, 0, 32, 32, 32);
/*  50 */     playerd3 = Game.st.getCropped(Game.playerSheet, 0, 64, 32, 32);
/*  51 */     playerd4 = Game.st.getCropped(Game.playerSheet, 0, 96, 32, 32);
/*  52 */     playeru1 = Game.st.getCropped(Game.playerSheet, 32, 0, 32, 32);
/*  53 */     playeru2 = Game.st.getCropped(Game.playerSheet, 32, 32, 32, 32);
/*  54 */     playeru3 = Game.st.getCropped(Game.playerSheet, 32, 64, 32, 32);
/*  55 */     playeru4 = Game.st.getCropped(Game.playerSheet, 32, 96, 32, 32);
/*  56 */     playerl1 = Game.st.getCropped(Game.playerSheet, 64, 0, 32, 32);
/*  57 */     playerl2 = Game.st.getCropped(Game.playerSheet, 64, 32, 32, 32);
/*  58 */     playerl3 = Game.st.getCropped(Game.playerSheet, 64, 64, 32, 32);
/*  59 */     playerl4 = Game.st.getCropped(Game.playerSheet, 64, 96, 32, 32);
/*  60 */     playerr1 = Game.st.getCropped(Game.playerSheet, 96, 0, 32, 32);
/*  61 */     playerr2 = Game.st.getCropped(Game.playerSheet, 96, 32, 32, 32);
/*  62 */     playerr3 = Game.st.getCropped(Game.playerSheet, 96, 64, 32, 32);
/*  63 */     playerr4 = Game.st.getCropped(Game.playerSheet, 96, 96, 32, 32);
/*  64 */     playerd1_a = Game.st.getCropped(Game.playerSheet, 128, 0, 32, 32);
/*  65 */     playerd2_a = Game.st.getCropped(Game.playerSheet, 128, 32, 32, 32);
/*  66 */     playerd3_a = Game.st.getCropped(Game.playerSheet, 128, 64, 32, 32);
/*  67 */     playerd4_a = Game.st.getCropped(Game.playerSheet, 128, 96, 32, 32);
/*  68 */     playeru1_a = Game.st.getCropped(Game.playerSheet, 160, 0, 32, 32);
/*  69 */     playeru2_a = Game.st.getCropped(Game.playerSheet, 160, 32, 32, 32);
/*  70 */     playeru3_a = Game.st.getCropped(Game.playerSheet, 160, 64, 32, 32);
/*  71 */     playeru4_a = Game.st.getCropped(Game.playerSheet, 160, 96, 32, 32);
/*  72 */     playerl1_a = Game.st.getCropped(Game.playerSheet, 192, 0, 32, 32);
/*  73 */     playerl2_a = Game.st.getCropped(Game.playerSheet, 192, 32, 32, 32);
/*  74 */     playerl3_a = Game.st.getCropped(Game.playerSheet, 192, 64, 32, 32);
/*  75 */     playerl4_a = Game.st.getCropped(Game.playerSheet, 192, 96, 32, 32);
/*  76 */     playerr1_a = Game.st.getCropped(Game.playerSheet, 224, 0, 32, 32);
/*  77 */     playerr2_a = Game.st.getCropped(Game.playerSheet, 224, 32, 32, 32);
/*  78 */     playerr3_a = Game.st.getCropped(Game.playerSheet, 224, 64, 32, 32);
/*  79 */     playerr4_a = Game.st.getCropped(Game.playerSheet, 224, 96, 32, 32);
/*     */   }
/*     */   
/*     */   public void widgetSetUp() {
/*  83 */     dialogueBox = Game.st.getCropped(Game.widgetSheet, 0, 0, 512, 160);
/*  84 */     pHUD = Game.st.getCropped(Game.widgetSheet, 0, 160, 160, 64);
/*     */   }
/*     */   
/*     */   private void grassMapSetUp() {
/*  88 */     grassFull = Game.st.getCropped(Game.terrain1Sheet, 0, 0, 32, 32);
/*  89 */     grassBarrier = Game.st.getCropped(Game.terrain1Sheet, 32, 32, 32, 32);
/*  90 */     shop1 = Game.st.getCropped(Game.terrain1Sheet, 192, 0, 96, 96);
/*     */   }
/*     */   
/*     */   private void entitySetUp() {
/*  94 */     cowd1 = Game.st.getCropped(Game.entitySheet, 0, 64, 32, 32);
/*  95 */     cowd2 = Game.st.getCropped(Game.entitySheet, 32, 64, 32, 32);
/*  96 */     cowd3 = Game.st.getCropped(Game.entitySheet, 96, 64, 32, 32);
/*  97 */     cowd4 = Game.st.getCropped(Game.entitySheet, 64, 64, 32, 32);
/*  98 */     cowu1 = Game.st.getCropped(Game.entitySheet, 0, 96, 32, 32);
/*  99 */     cowu2 = Game.st.getCropped(Game.entitySheet, 32, 96, 32, 32);
/* 100 */     cowu3 = Game.st.getCropped(Game.entitySheet, 96, 96, 32, 32);
/* 101 */     cowu4 = Game.st.getCropped(Game.entitySheet, 64, 96, 32, 32);
/* 102 */     cowl1 = Game.st.getCropped(Game.entitySheet, 0, 0, 32, 32);
/* 103 */     cowl2 = Game.st.getCropped(Game.entitySheet, 32, 0, 32, 32);
/* 104 */     cowl3 = Game.st.getCropped(Game.entitySheet, 96, 0, 32, 32);
/* 105 */     cowl4 = Game.st.getCropped(Game.entitySheet, 64, 0, 32, 32);
/* 106 */     cowr1 = Game.st.getCropped(Game.entitySheet, 0, 32, 32, 32);
/* 107 */     cowr2 = Game.st.getCropped(Game.entitySheet, 32, 32, 32, 32);
/* 108 */     cowr3 = Game.st.getCropped(Game.entitySheet, 96, 32, 32, 32);
/* 109 */     cowr4 = Game.st.getCropped(Game.entitySheet, 64, 32, 32, 32);
/* 111 */     tdd1 = Game.st.getCropped(Game.entitySheet, 0, 0, 32, 32);
/* 112 */     tdd2 = Game.st.getCropped(Game.entitySheet, 0, 32, 32, 32);
/* 113 */     tdd3 = Game.st.getCropped(Game.entitySheet, 0, 64, 32, 32);
/* 114 */     tdd4 = Game.st.getCropped(Game.entitySheet, 0, 96, 32, 32);
/* 115 */     tdu1 = Game.st.getCropped(Game.entitySheet, 32, 0, 32, 32);
/* 116 */     tdu2 = Game.st.getCropped(Game.entitySheet, 32, 32, 32, 32);
/* 117 */     tdu3 = Game.st.getCropped(Game.entitySheet, 32, 64, 32, 32);
/* 118 */     tdu4 = Game.st.getCropped(Game.entitySheet, 32, 96, 32, 32);
/* 119 */     tdl1 = Game.st.getCropped(Game.entitySheet, 64, 0, 32, 32);
/* 120 */     tdl2 = Game.st.getCropped(Game.entitySheet, 64, 32, 32, 32);
/* 121 */     tdl3 = Game.st.getCropped(Game.entitySheet, 64, 64, 32, 32);
/* 122 */     tdl4 = Game.st.getCropped(Game.entitySheet, 64, 96, 32, 32);
/* 123 */     tdr1 = Game.st.getCropped(Game.entitySheet, 96, 0, 32, 32);
/* 124 */     tdr2 = Game.st.getCropped(Game.entitySheet, 96, 32, 32, 32);
/* 125 */     tdr3 = Game.st.getCropped(Game.entitySheet, 96, 64, 32, 32);
/* 126 */     tdr4 = Game.st.getCropped(Game.entitySheet, 96, 96, 32, 32);
/*     */   }
/*     */   
/*     */   private void menuSetUp() {
/* 130 */     button1_1 = Game.st.getCropped(Game.mainmenuSheet, 0, 0, 160, 32);
/* 131 */     button1_2 = Game.st.getCropped(Game.mainmenuSheet, 0, 32, 160, 32);
/* 132 */     button1_3 = Game.st.getCropped(Game.mainmenuSheet, 0, 64, 160, 32);
/* 133 */     button2_1 = Game.st.getCropped(Game.mainmenuSheet, 0, 96, 336, 32);
/* 134 */     button2_2 = Game.st.getCropped(Game.mainmenuSheet, 0, 128, 336, 32);
/* 135 */     button2_3 = Game.st.getCropped(Game.mainmenuSheet, 0, 160, 336, 32);
/* 136 */     profileSquare = Game.st.getCropped(Game.mainmenuSheet, 288, 0, 96, 96);
/* 137 */     profileEmpty = Game.st.getCropped(Game.mainmenuSheet, 384, 0, 64, 64);
/* 138 */     profileSelection = Game.st.getCropped(Game.mainmenuSheet, 0, 192, 300, 
/* 139 */         117);
/* 140 */     cloud1 = Game.st.getCropped(Game.mainmenuSheet, 160, 0, 128, 96);
/* 141 */     cloud2 = Game.st.getCropped(Game.mainmenuSheet, 160, 0, 128, 96);
/* 142 */     cloud3 = Game.st.getCropped(Game.mainmenuSheet, 160, 0, 128, 96);
/*     */   }
/*     */   
/*     */   private void inventorySetUp() {
/* 146 */     inventory1 = Game.st.getCropped(Game.inventorySheet, 0, 0, 416, 288);
/* 147 */     inventory2 = Game.st.getCropped(Game.inventorySheet, 416, 0, 416, 288);
/* 148 */     inventory3 = Game.st.getCropped(Game.inventorySheet, 0, 288, 416, 288);
/* 149 */     tab1_1 = Game.st.getCropped(Game.inventorySheet, 832, 0, 64, 64);
/* 150 */     tab2_1 = Game.st.getCropped(Game.inventorySheet, 896, 0, 64, 64);
/* 151 */     tab3_1 = Game.st.getCropped(Game.inventorySheet, 960, 0, 64, 64);
/* 152 */     tab1_2 = Game.st.getCropped(Game.inventorySheet, 832, 64, 64, 64);
/* 153 */     tab2_2 = Game.st.getCropped(Game.inventorySheet, 896, 64, 64, 64);
/* 154 */     tab3_2 = Game.st.getCropped(Game.inventorySheet, 960, 64, 64, 64);
/* 155 */     arrow_1 = Game.st.getCropped(Game.inventorySheet, 832, 128, 32, 64);
/* 156 */     arrow_2 = Game.st.getCropped(Game.inventorySheet, 864, 128, 32, 64);
/* 157 */     quest_1 = Game.st.getCropped(Game.inventorySheet, 416, 288, 241, 39);
/* 158 */     quest_2 = Game.st.getCropped(Game.inventorySheet, 416, 352, 241, 39);
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.7.jar!\beyondOrigins\main\gfx\ImageManager.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */