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
/*     */   public static BufferedImage shop1;
/*     */   
/*     */   public static BufferedImage tree;
/*     */   
/*  21 */   public static BufferedImage[] water = new BufferedImage[5];
/*     */   
/*  23 */   public static BufferedImage[] cow_up = new BufferedImage[5];
/*     */   
/*  24 */   public static BufferedImage[] cow_down = new BufferedImage[5], cow_left = new BufferedImage[5];
/*     */   
/*  25 */   public static BufferedImage[] cow_right = new BufferedImage[5];
/*     */   
/*  27 */   public static BufferedImage[] testDummy_up = new BufferedImage[5];
/*     */   
/*  28 */   public static BufferedImage[] testDummy_down = new BufferedImage[5];
/*     */   
/*  29 */   public static BufferedImage[] testDummy_left = new BufferedImage[5];
/*     */   
/*  30 */   public static BufferedImage[] testDummy_right = new BufferedImage[5];
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
/*  52 */     player_down[1] = Game.st.getCropped(Game.playerSheet, 0, 0, 32, 32);
/*  53 */     player_down[2] = Game.st.getCropped(Game.playerSheet, 0, 32, 32, 32);
/*  54 */     player_down[3] = Game.st.getCropped(Game.playerSheet, 0, 64, 32, 32);
/*  55 */     player_down[4] = Game.st.getCropped(Game.playerSheet, 0, 96, 32, 32);
/*  56 */     player_up[1] = Game.st.getCropped(Game.playerSheet, 32, 0, 32, 32);
/*  57 */     player_up[2] = Game.st.getCropped(Game.playerSheet, 32, 32, 32, 32);
/*  58 */     player_up[3] = Game.st.getCropped(Game.playerSheet, 32, 64, 32, 32);
/*  59 */     player_up[4] = Game.st.getCropped(Game.playerSheet, 32, 96, 32, 32);
/*  60 */     player_left[1] = Game.st.getCropped(Game.playerSheet, 64, 0, 32, 32);
/*  61 */     player_left[2] = Game.st.getCropped(Game.playerSheet, 64, 32, 32, 32);
/*  62 */     player_left[3] = Game.st.getCropped(Game.playerSheet, 64, 64, 32, 32);
/*  63 */     player_left[4] = Game.st.getCropped(Game.playerSheet, 64, 96, 32, 32);
/*  64 */     player_right[1] = Game.st.getCropped(Game.playerSheet, 96, 0, 32, 32);
/*  65 */     player_right[2] = Game.st.getCropped(Game.playerSheet, 96, 32, 32, 32);
/*  66 */     player_right[3] = Game.st.getCropped(Game.playerSheet, 96, 64, 32, 32);
/*  67 */     player_right[4] = Game.st.getCropped(Game.playerSheet, 96, 96, 32, 32);
/*  68 */     player_down_attack[1] = Game.st.getCropped(Game.playerSheet, 128, 0, 
/*  69 */         32, 32);
/*  70 */     player_down_attack[2] = Game.st.getCropped(Game.playerSheet, 128, 32, 
/*  71 */         32, 32);
/*  72 */     player_down_attack[3] = Game.st.getCropped(Game.playerSheet, 128, 64, 
/*  73 */         32, 32);
/*  74 */     player_down_attack[4] = Game.st.getCropped(Game.playerSheet, 128, 96, 
/*  75 */         32, 32);
/*  76 */     player_up_attack[1] = Game.st.getCropped(Game.playerSheet, 160, 0, 32, 
/*  77 */         32);
/*  78 */     player_up_attack[2] = Game.st.getCropped(Game.playerSheet, 160, 32, 32, 
/*  79 */         32);
/*  80 */     player_up_attack[3] = Game.st.getCropped(Game.playerSheet, 160, 64, 32, 
/*  81 */         32);
/*  82 */     player_up_attack[4] = Game.st.getCropped(Game.playerSheet, 160, 96, 32, 
/*  83 */         32);
/*  84 */     player_left_attack[1] = Game.st.getCropped(Game.playerSheet, 192, 0, 
/*  85 */         32, 32);
/*  86 */     player_left_attack[2] = Game.st.getCropped(Game.playerSheet, 192, 32, 
/*  87 */         32, 32);
/*  88 */     player_left_attack[3] = Game.st.getCropped(Game.playerSheet, 192, 64, 
/*  89 */         32, 32);
/*  90 */     player_left_attack[4] = Game.st.getCropped(Game.playerSheet, 192, 96, 
/*  91 */         32, 32);
/*  92 */     player_right_attack[1] = Game.st.getCropped(Game.playerSheet, 224, 0, 
/*  93 */         32, 32);
/*  94 */     player_right_attack[2] = Game.st.getCropped(Game.playerSheet, 224, 32, 
/*  95 */         32, 32);
/*  96 */     player_right_attack[3] = Game.st.getCropped(Game.playerSheet, 224, 64, 
/*  97 */         32, 32);
/*  98 */     player_right_attack[4] = Game.st.getCropped(Game.playerSheet, 224, 96, 
/*  99 */         32, 32);
/*     */   }
/*     */   
/*     */   public void widgetSetUp() {
/* 103 */     dialogueBox = Game.st.getCropped(Game.widgetSheet, 0, 0, 512, 160);
/* 104 */     player_hud = Game.st.getCropped(Game.widgetSheet, 0, 160, 160, 64);
/*     */   }
/*     */   
/*     */   private void grassMapSetUp() {
/* 108 */     grassFull = Game.st.getCropped(Game.terrain1Sheet, 0, 0, 32, 32);
/* 109 */     grassBarrier = Game.st.getCropped(Game.terrain1Sheet, 32, 32, 32, 32);
/* 110 */     tree = Game.st.getCropped(Game.terrain1Sheet, 0, 32, 32, 32);
/* 111 */     water[1] = Game.st.getCropped(Game.terrain1Sheet, 32, 0, 32, 32);
/* 112 */     water[2] = Game.st.getCropped(Game.terrain1Sheet, 64, 0, 32, 32);
/* 113 */     water[3] = Game.st.getCropped(Game.terrain1Sheet, 96, 0, 32, 32);
/* 114 */     water[4] = Game.st.getCropped(Game.terrain1Sheet, 128, 0, 32, 32);
/* 115 */     shop1 = Game.st.getCropped(Game.terrain1Sheet, 192, 0, 96, 96);
/*     */   }
/*     */   
/*     */   private void entitySetUp() {
/* 119 */     cow_down[1] = Game.st.getCropped(Game.entitySheet, 0, 64, 32, 32);
/* 120 */     cow_down[2] = Game.st.getCropped(Game.entitySheet, 32, 64, 32, 32);
/* 121 */     cow_down[3] = Game.st.getCropped(Game.entitySheet, 96, 64, 32, 32);
/* 122 */     cow_down[4] = Game.st.getCropped(Game.entitySheet, 64, 64, 32, 32);
/* 123 */     cow_up[1] = Game.st.getCropped(Game.entitySheet, 0, 96, 32, 32);
/* 124 */     cow_up[2] = Game.st.getCropped(Game.entitySheet, 32, 96, 32, 32);
/* 125 */     cow_up[3] = Game.st.getCropped(Game.entitySheet, 96, 96, 32, 32);
/* 126 */     cow_up[4] = Game.st.getCropped(Game.entitySheet, 64, 96, 32, 32);
/* 127 */     cow_left[1] = Game.st.getCropped(Game.entitySheet, 0, 0, 32, 32);
/* 128 */     cow_left[2] = Game.st.getCropped(Game.entitySheet, 32, 0, 32, 32);
/* 129 */     cow_left[3] = Game.st.getCropped(Game.entitySheet, 96, 0, 32, 32);
/* 130 */     cow_left[4] = Game.st.getCropped(Game.entitySheet, 64, 0, 32, 32);
/* 131 */     cow_right[1] = Game.st.getCropped(Game.entitySheet, 0, 32, 32, 32);
/* 132 */     cow_right[2] = Game.st.getCropped(Game.entitySheet, 32, 32, 32, 32);
/* 133 */     cow_right[3] = Game.st.getCropped(Game.entitySheet, 96, 32, 32, 32);
/* 134 */     cow_right[4] = Game.st.getCropped(Game.entitySheet, 64, 32, 32, 32);
/* 136 */     testDummy_down[1] = Game.st.getCropped(Game.entitySheet, 0, 0, 32, 32);
/* 137 */     testDummy_down[2] = Game.st.getCropped(Game.entitySheet, 0, 32, 32, 32);
/* 138 */     testDummy_down[3] = Game.st.getCropped(Game.entitySheet, 0, 64, 32, 32);
/* 139 */     testDummy_down[4] = Game.st.getCropped(Game.entitySheet, 0, 96, 32, 32);
/* 140 */     testDummy_up[1] = Game.st.getCropped(Game.entitySheet, 32, 0, 32, 32);
/* 141 */     testDummy_up[2] = Game.st.getCropped(Game.entitySheet, 32, 32, 32, 32);
/* 142 */     testDummy_up[3] = Game.st.getCropped(Game.entitySheet, 32, 64, 32, 32);
/* 143 */     testDummy_up[4] = Game.st.getCropped(Game.entitySheet, 32, 96, 32, 32);
/* 144 */     testDummy_left[1] = Game.st.getCropped(Game.entitySheet, 64, 0, 32, 32);
/* 145 */     testDummy_left[2] = Game.st
/* 146 */       .getCropped(Game.entitySheet, 64, 32, 32, 32);
/* 147 */     testDummy_left[3] = Game.st
/* 148 */       .getCropped(Game.entitySheet, 64, 64, 32, 32);
/* 149 */     testDummy_left[4] = Game.st
/* 150 */       .getCropped(Game.entitySheet, 64, 96, 32, 32);
/* 151 */     testDummy_right[1] = Game.st
/* 152 */       .getCropped(Game.entitySheet, 96, 0, 32, 32);
/* 153 */     testDummy_right[2] = Game.st.getCropped(Game.entitySheet, 96, 32, 32, 
/* 154 */         32);
/* 155 */     testDummy_right[3] = Game.st.getCropped(Game.entitySheet, 96, 64, 32, 
/* 156 */         32);
/* 157 */     testDummy_right[4] = Game.st.getCropped(Game.entitySheet, 96, 96, 32, 
/* 158 */         32);
/*     */   }
/*     */   
/*     */   private void menuSetUp() {
/* 162 */     button1_1 = Game.st.getCropped(Game.mainmenuSheet, 0, 0, 160, 32);
/* 163 */     button1_2 = Game.st.getCropped(Game.mainmenuSheet, 0, 32, 160, 32);
/* 164 */     button1_3 = Game.st.getCropped(Game.mainmenuSheet, 0, 64, 160, 32);
/* 165 */     button2_1 = Game.st.getCropped(Game.mainmenuSheet, 0, 96, 336, 32);
/* 166 */     button2_2 = Game.st.getCropped(Game.mainmenuSheet, 0, 128, 336, 32);
/* 167 */     button2_3 = Game.st.getCropped(Game.mainmenuSheet, 0, 160, 336, 32);
/* 168 */     profileSquare = Game.st.getCropped(Game.mainmenuSheet, 288, 0, 96, 96);
/* 169 */     profileEmpty = Game.st.getCropped(Game.mainmenuSheet, 384, 0, 64, 64);
/* 170 */     profileSelection = Game.st.getCropped(Game.mainmenuSheet, 0, 192, 300, 
/* 171 */         117);
/* 172 */     cloud1 = Game.st.getCropped(Game.mainmenuSheet, 160, 0, 128, 96);
/* 173 */     cloud2 = Game.st.getCropped(Game.mainmenuSheet, 160, 0, 128, 96);
/* 174 */     cloud3 = Game.st.getCropped(Game.mainmenuSheet, 160, 0, 128, 96);
/*     */   }
/*     */   
/*     */   private void inventorySetUp() {
/* 178 */     inventory1 = Game.st.getCropped(Game.inventorySheet, 0, 0, 416, 288);
/* 179 */     inventory2 = Game.st.getCropped(Game.inventorySheet, 416, 0, 416, 288);
/* 180 */     inventory3 = Game.st.getCropped(Game.inventorySheet, 0, 288, 416, 288);
/* 181 */     tab1_1 = Game.st.getCropped(Game.inventorySheet, 832, 0, 64, 64);
/* 182 */     tab2_1 = Game.st.getCropped(Game.inventorySheet, 896, 0, 64, 64);
/* 183 */     tab3_1 = Game.st.getCropped(Game.inventorySheet, 960, 0, 64, 64);
/* 184 */     tab1_2 = Game.st.getCropped(Game.inventorySheet, 832, 64, 64, 64);
/* 185 */     tab2_2 = Game.st.getCropped(Game.inventorySheet, 896, 64, 64, 64);
/* 186 */     tab3_2 = Game.st.getCropped(Game.inventorySheet, 960, 64, 64, 64);
/* 187 */     arrow_1 = Game.st.getCropped(Game.inventorySheet, 832, 128, 32, 64);
/* 188 */     arrow_2 = Game.st.getCropped(Game.inventorySheet, 864, 128, 32, 64);
/* 189 */     quest_1 = Game.st.getCropped(Game.inventorySheet, 416, 288, 241, 39);
/* 190 */     quest_2 = Game.st.getCropped(Game.inventorySheet, 416, 352, 241, 39);
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.9_3.jar!\beyondOrigins\main\gfx\ImageManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */