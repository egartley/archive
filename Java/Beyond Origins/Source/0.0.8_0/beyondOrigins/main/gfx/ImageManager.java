/*     */ package beyondOrigins.main.gfx;
/*     */ 
/*     */ import beyondOrigins.main.Game;
/*     */ import java.awt.image.BufferedImage;
/*     */ 
/*     */ public class ImageManager {
/*     */   public static BufferedImage dialogueBox;
/*     */   
/*     */   public static BufferedImage player_hud;
/*     */   
/*  11 */   public static BufferedImage[] player_up = new BufferedImage[5];
/*     */   
/*  12 */   public static BufferedImage[] player_down = new BufferedImage[5];
/*     */   
/*  13 */   public static BufferedImage[] player_left = new BufferedImage[5];
/*     */   
/*  14 */   public static BufferedImage[] player_right = new BufferedImage[5];
/*     */   
/*  15 */   public static BufferedImage[] player_up_attack = new BufferedImage[5];
/*     */   
/*  16 */   public static BufferedImage[] player_down_attack = new BufferedImage[5];
/*     */   
/*  17 */   public static BufferedImage[] player_left_attack = new BufferedImage[5];
/*     */   
/*  18 */   public static BufferedImage[] player_right_attack = new BufferedImage[5];
/*     */   
/*     */   public static BufferedImage grassFull;
/*     */   
/*     */   public static BufferedImage grassBarrier;
/*     */   
/*     */   public static BufferedImage water;
/*     */   
/*     */   public static BufferedImage shop1;
/*     */   
/*  22 */   public static BufferedImage[] cow_up = new BufferedImage[5];
/*     */   
/*  23 */   public static BufferedImage[] cow_down = new BufferedImage[5], cow_left = new BufferedImage[5];
/*     */   
/*  24 */   public static BufferedImage[] cow_right = new BufferedImage[5];
/*     */   
/*  26 */   public static BufferedImage[] testDummy_up = new BufferedImage[5];
/*     */   
/*  27 */   public static BufferedImage[] testDummy_down = new BufferedImage[5];
/*     */   
/*  28 */   public static BufferedImage[] testDummy_left = new BufferedImage[5];
/*     */   
/*  29 */   public static BufferedImage[] testDummy_right = new BufferedImage[5];
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
/*  39 */   public static short hpCropX = 81, expCropX = 83;
/*     */   
/*     */   public ImageManager() {
/*  42 */     playerSetUp();
/*  43 */     widgetSetUp();
/*  44 */     grassMapSetUp();
/*  45 */     entitySetUp();
/*  46 */     menuSetUp();
/*  47 */     inventorySetUp();
/*     */   }
/*     */   
/*     */   private void playerSetUp() {
/*  51 */     player_down[1] = Game.st.getCropped(Game.playerSheet, 0, 0, 32, 32);
/*  52 */     player_down[2] = Game.st.getCropped(Game.playerSheet, 0, 32, 32, 32);
/*  53 */     player_down[3] = Game.st.getCropped(Game.playerSheet, 0, 64, 32, 32);
/*  54 */     player_down[4] = Game.st.getCropped(Game.playerSheet, 0, 96, 32, 32);
/*  55 */     player_up[1] = Game.st.getCropped(Game.playerSheet, 32, 0, 32, 32);
/*  56 */     player_up[2] = Game.st.getCropped(Game.playerSheet, 32, 32, 32, 32);
/*  57 */     player_up[3] = Game.st.getCropped(Game.playerSheet, 32, 64, 32, 32);
/*  58 */     player_up[4] = Game.st.getCropped(Game.playerSheet, 32, 96, 32, 32);
/*  59 */     player_left[1] = Game.st.getCropped(Game.playerSheet, 64, 0, 32, 32);
/*  60 */     player_left[2] = Game.st.getCropped(Game.playerSheet, 64, 32, 32, 32);
/*  61 */     player_left[3] = Game.st.getCropped(Game.playerSheet, 64, 64, 32, 32);
/*  62 */     player_left[4] = Game.st.getCropped(Game.playerSheet, 64, 96, 32, 32);
/*  63 */     player_right[1] = Game.st.getCropped(Game.playerSheet, 96, 0, 32, 32);
/*  64 */     player_right[2] = Game.st.getCropped(Game.playerSheet, 96, 32, 32, 32);
/*  65 */     player_right[3] = Game.st.getCropped(Game.playerSheet, 96, 64, 32, 32);
/*  66 */     player_right[4] = Game.st.getCropped(Game.playerSheet, 96, 96, 32, 32);
/*  67 */     player_down_attack[1] = Game.st.getCropped(Game.playerSheet, 128, 0, 
/*  68 */         32, 32);
/*  69 */     player_down_attack[2] = Game.st.getCropped(Game.playerSheet, 128, 32, 
/*  70 */         32, 32);
/*  71 */     player_down_attack[3] = Game.st.getCropped(Game.playerSheet, 128, 64, 
/*  72 */         32, 32);
/*  73 */     player_down_attack[4] = Game.st.getCropped(Game.playerSheet, 128, 96, 
/*  74 */         32, 32);
/*  75 */     player_up_attack[1] = Game.st.getCropped(Game.playerSheet, 160, 0, 32, 
/*  76 */         32);
/*  77 */     player_up_attack[2] = Game.st.getCropped(Game.playerSheet, 160, 32, 32, 
/*  78 */         32);
/*  79 */     player_up_attack[3] = Game.st.getCropped(Game.playerSheet, 160, 64, 32, 
/*  80 */         32);
/*  81 */     player_up_attack[4] = Game.st.getCropped(Game.playerSheet, 160, 96, 32, 
/*  82 */         32);
/*  83 */     player_left_attack[1] = Game.st.getCropped(Game.playerSheet, 192, 0, 
/*  84 */         32, 32);
/*  85 */     player_left_attack[2] = Game.st.getCropped(Game.playerSheet, 192, 32, 
/*  86 */         32, 32);
/*  87 */     player_left_attack[3] = Game.st.getCropped(Game.playerSheet, 192, 64, 
/*  88 */         32, 32);
/*  89 */     player_left_attack[4] = Game.st.getCropped(Game.playerSheet, 192, 96, 
/*  90 */         32, 32);
/*  91 */     player_right_attack[1] = Game.st.getCropped(Game.playerSheet, 224, 0, 
/*  92 */         32, 32);
/*  93 */     player_right_attack[2] = Game.st.getCropped(Game.playerSheet, 224, 32, 
/*  94 */         32, 32);
/*  95 */     player_right_attack[3] = Game.st.getCropped(Game.playerSheet, 224, 64, 
/*  96 */         32, 32);
/*  97 */     player_right_attack[4] = Game.st.getCropped(Game.playerSheet, 224, 96, 
/*  98 */         32, 32);
/*     */   }
/*     */   
/*     */   public void widgetSetUp() {
/* 102 */     dialogueBox = Game.st.getCropped(Game.widgetSheet, 0, 0, 512, 160);
/* 103 */     player_hud = Game.st.getCropped(Game.widgetSheet, 0, 160, 160, 64);
/*     */   }
/*     */   
/*     */   private void grassMapSetUp() {
/* 107 */     grassFull = Game.st.getCropped(Game.terrain1Sheet, 0, 0, 32, 32);
/* 108 */     grassBarrier = Game.st.getCropped(Game.terrain1Sheet, 32, 32, 32, 32);
/* 109 */     water = Game.st.getCropped(Game.terrain1Sheet, 32, 0, 32, 32);
/* 110 */     shop1 = Game.st.getCropped(Game.terrain1Sheet, 192, 0, 96, 96);
/*     */   }
/*     */   
/*     */   private void entitySetUp() {
/* 114 */     cow_down[1] = Game.st.getCropped(Game.entitySheet, 0, 64, 32, 32);
/* 115 */     cow_down[2] = Game.st.getCropped(Game.entitySheet, 32, 64, 32, 32);
/* 116 */     cow_down[3] = Game.st.getCropped(Game.entitySheet, 96, 64, 32, 32);
/* 117 */     cow_down[4] = Game.st.getCropped(Game.entitySheet, 64, 64, 32, 32);
/* 118 */     cow_up[1] = Game.st.getCropped(Game.entitySheet, 0, 96, 32, 32);
/* 119 */     cow_up[2] = Game.st.getCropped(Game.entitySheet, 32, 96, 32, 32);
/* 120 */     cow_up[3] = Game.st.getCropped(Game.entitySheet, 96, 96, 32, 32);
/* 121 */     cow_up[4] = Game.st.getCropped(Game.entitySheet, 64, 96, 32, 32);
/* 122 */     cow_left[1] = Game.st.getCropped(Game.entitySheet, 0, 0, 32, 32);
/* 123 */     cow_left[2] = Game.st.getCropped(Game.entitySheet, 32, 0, 32, 32);
/* 124 */     cow_left[3] = Game.st.getCropped(Game.entitySheet, 96, 0, 32, 32);
/* 125 */     cow_left[4] = Game.st.getCropped(Game.entitySheet, 64, 0, 32, 32);
/* 126 */     cow_right[1] = Game.st.getCropped(Game.entitySheet, 0, 32, 32, 32);
/* 127 */     cow_right[2] = Game.st.getCropped(Game.entitySheet, 32, 32, 32, 32);
/* 128 */     cow_right[3] = Game.st.getCropped(Game.entitySheet, 96, 32, 32, 32);
/* 129 */     cow_right[4] = Game.st.getCropped(Game.entitySheet, 64, 32, 32, 32);
/* 131 */     testDummy_down[1] = Game.st.getCropped(Game.entitySheet, 0, 0, 32, 32);
/* 132 */     testDummy_down[2] = Game.st.getCropped(Game.entitySheet, 0, 32, 32, 32);
/* 133 */     testDummy_down[3] = Game.st.getCropped(Game.entitySheet, 0, 64, 32, 32);
/* 134 */     testDummy_down[4] = Game.st.getCropped(Game.entitySheet, 0, 96, 32, 32);
/* 135 */     testDummy_up[1] = Game.st.getCropped(Game.entitySheet, 32, 0, 32, 32);
/* 136 */     testDummy_up[2] = Game.st.getCropped(Game.entitySheet, 32, 32, 32, 32);
/* 137 */     testDummy_up[3] = Game.st.getCropped(Game.entitySheet, 32, 64, 32, 32);
/* 138 */     testDummy_up[4] = Game.st.getCropped(Game.entitySheet, 32, 96, 32, 32);
/* 139 */     testDummy_left[1] = Game.st.getCropped(Game.entitySheet, 64, 0, 32, 32);
/* 140 */     testDummy_left[2] = Game.st
/* 141 */       .getCropped(Game.entitySheet, 64, 32, 32, 32);
/* 142 */     testDummy_left[3] = Game.st
/* 143 */       .getCropped(Game.entitySheet, 64, 64, 32, 32);
/* 144 */     testDummy_left[4] = Game.st
/* 145 */       .getCropped(Game.entitySheet, 64, 96, 32, 32);
/* 146 */     testDummy_right[1] = Game.st
/* 147 */       .getCropped(Game.entitySheet, 96, 0, 32, 32);
/* 148 */     testDummy_right[2] = Game.st.getCropped(Game.entitySheet, 96, 32, 32, 
/* 149 */         32);
/* 150 */     testDummy_right[3] = Game.st.getCropped(Game.entitySheet, 96, 64, 32, 
/* 151 */         32);
/* 152 */     testDummy_right[4] = Game.st.getCropped(Game.entitySheet, 96, 96, 32, 
/* 153 */         32);
/*     */   }
/*     */   
/*     */   private void menuSetUp() {
/* 157 */     button1_1 = Game.st.getCropped(Game.mainmenuSheet, 0, 0, 160, 32);
/* 158 */     button1_2 = Game.st.getCropped(Game.mainmenuSheet, 0, 32, 160, 32);
/* 159 */     button1_3 = Game.st.getCropped(Game.mainmenuSheet, 0, 64, 160, 32);
/* 160 */     button2_1 = Game.st.getCropped(Game.mainmenuSheet, 0, 96, 336, 32);
/* 161 */     button2_2 = Game.st.getCropped(Game.mainmenuSheet, 0, 128, 336, 32);
/* 162 */     button2_3 = Game.st.getCropped(Game.mainmenuSheet, 0, 160, 336, 32);
/* 163 */     profileSquare = Game.st.getCropped(Game.mainmenuSheet, 288, 0, 96, 96);
/* 164 */     profileEmpty = Game.st.getCropped(Game.mainmenuSheet, 384, 0, 64, 64);
/* 165 */     profileSelection = Game.st.getCropped(Game.mainmenuSheet, 0, 192, 300, 
/* 166 */         117);
/* 167 */     cloud1 = Game.st.getCropped(Game.mainmenuSheet, 160, 0, 128, 96);
/* 168 */     cloud2 = Game.st.getCropped(Game.mainmenuSheet, 160, 0, 128, 96);
/* 169 */     cloud3 = Game.st.getCropped(Game.mainmenuSheet, 160, 0, 128, 96);
/*     */   }
/*     */   
/*     */   private void inventorySetUp() {
/* 173 */     inventory1 = Game.st.getCropped(Game.inventorySheet, 0, 0, 416, 288);
/* 174 */     inventory2 = Game.st.getCropped(Game.inventorySheet, 416, 0, 416, 288);
/* 175 */     inventory3 = Game.st.getCropped(Game.inventorySheet, 0, 288, 416, 288);
/* 176 */     tab1_1 = Game.st.getCropped(Game.inventorySheet, 832, 0, 64, 64);
/* 177 */     tab2_1 = Game.st.getCropped(Game.inventorySheet, 896, 0, 64, 64);
/* 178 */     tab3_1 = Game.st.getCropped(Game.inventorySheet, 960, 0, 64, 64);
/* 179 */     tab1_2 = Game.st.getCropped(Game.inventorySheet, 832, 64, 64, 64);
/* 180 */     tab2_2 = Game.st.getCropped(Game.inventorySheet, 896, 64, 64, 64);
/* 181 */     tab3_2 = Game.st.getCropped(Game.inventorySheet, 960, 64, 64, 64);
/* 182 */     arrow_1 = Game.st.getCropped(Game.inventorySheet, 832, 128, 32, 64);
/* 183 */     arrow_2 = Game.st.getCropped(Game.inventorySheet, 864, 128, 32, 64);
/* 184 */     quest_1 = Game.st.getCropped(Game.inventorySheet, 416, 288, 241, 39);
/* 185 */     quest_2 = Game.st.getCropped(Game.inventorySheet, 416, 352, 241, 39);
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.8_0.jar!\beyondOrigins\main\gfx\ImageManager.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */