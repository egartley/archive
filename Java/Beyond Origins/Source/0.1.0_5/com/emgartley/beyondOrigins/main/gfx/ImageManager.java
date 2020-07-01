/*     */ package com.emgartley.beyondOrigins.main.gfx;
/*     */ 
/*     */ import com.emgartley.beyondOrigins.main.Game;
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
/*  19 */   public static BufferedImage[] player_up_swim = new BufferedImage[5];
/*     */   
/*  20 */   public static BufferedImage[] player_down_swim = new BufferedImage[5];
/*     */   
/*  21 */   public static BufferedImage[] player_left_swim = new BufferedImage[5];
/*     */   
/*  22 */   public static BufferedImage[] player_right_swim = new BufferedImage[5];
/*     */   
/*     */   public static BufferedImage grassFull;
/*     */   
/*     */   public static BufferedImage grassBarrier;
/*     */   
/*     */   public static BufferedImage shop1;
/*     */   
/*     */   public static BufferedImage tree;
/*     */   
/*  25 */   public static BufferedImage[] water = new BufferedImage[5];
/*     */   
/*  27 */   public static BufferedImage[] cow_up = new BufferedImage[5];
/*     */   
/*  28 */   public static BufferedImage[] cow_down = new BufferedImage[5], cow_left = new BufferedImage[5];
/*     */   
/*  29 */   public static BufferedImage[] cow_right = new BufferedImage[5];
/*     */   
/*  31 */   public static BufferedImage[] testDummy_up = new BufferedImage[5];
/*     */   
/*  32 */   public static BufferedImage[] testDummy_down = new BufferedImage[5];
/*     */   
/*  33 */   public static BufferedImage[] testDummy_left = new BufferedImage[5];
/*     */   
/*  34 */   public static BufferedImage[] testDummy_right = new BufferedImage[5];
/*     */   
/*  35 */   public static BufferedImage[] paige_up = new BufferedImage[5];
/*     */   
/*  36 */   public static BufferedImage[] paige_down = new BufferedImage[5];
/*     */   
/*  37 */   public static BufferedImage[] paige_left = new BufferedImage[5];
/*     */   
/*  38 */   public static BufferedImage[] paige_right = new BufferedImage[5];
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
/*  48 */   public static short hpCropX = 81, expCropX = 83;
/*     */   
/*     */   public ImageManager() {
/*  51 */     playerSetUp();
/*  52 */     widgetSetUp();
/*  53 */     grassMapSetUp();
/*  54 */     entitySetUp();
/*  55 */     menuSetUp();
/*  56 */     inventorySetUp();
/*     */   }
/*     */   
/*     */   public BufferedImage getCropped(BufferedImage sheet, int x, int y, int w, int h) {
/*  61 */     return sheet.getSubimage(x, y, w, h);
/*     */   }
/*     */   
/*     */   private void playerSetUp() {
/*  65 */     player_down[1] = getCropped(Game.playerSheet, 0, 0, 32, 32);
/*  66 */     player_down[2] = getCropped(Game.playerSheet, 0, 32, 32, 32);
/*  67 */     player_down[3] = getCropped(Game.playerSheet, 0, 64, 32, 32);
/*  68 */     player_down[4] = getCropped(Game.playerSheet, 0, 96, 32, 32);
/*  69 */     player_up[1] = getCropped(Game.playerSheet, 32, 0, 32, 32);
/*  70 */     player_up[2] = getCropped(Game.playerSheet, 32, 32, 32, 32);
/*  71 */     player_up[3] = getCropped(Game.playerSheet, 32, 64, 32, 32);
/*  72 */     player_up[4] = getCropped(Game.playerSheet, 32, 96, 32, 32);
/*  73 */     player_left[1] = getCropped(Game.playerSheet, 64, 0, 32, 32);
/*  74 */     player_left[2] = getCropped(Game.playerSheet, 64, 32, 32, 32);
/*  75 */     player_left[3] = getCropped(Game.playerSheet, 64, 64, 32, 32);
/*  76 */     player_left[4] = getCropped(Game.playerSheet, 64, 96, 32, 32);
/*  77 */     player_right[1] = getCropped(Game.playerSheet, 96, 0, 32, 32);
/*  78 */     player_right[2] = getCropped(Game.playerSheet, 96, 32, 32, 32);
/*  79 */     player_right[3] = getCropped(Game.playerSheet, 96, 64, 32, 32);
/*  80 */     player_right[4] = getCropped(Game.playerSheet, 96, 96, 32, 32);
/*  81 */     player_down_attack[1] = getCropped(Game.playerSheet, 128, 0, 32, 32);
/*  82 */     player_down_attack[2] = getCropped(Game.playerSheet, 128, 32, 32, 32);
/*  83 */     player_down_attack[3] = getCropped(Game.playerSheet, 128, 64, 32, 32);
/*  84 */     player_down_attack[4] = getCropped(Game.playerSheet, 128, 96, 32, 32);
/*  85 */     player_up_attack[1] = getCropped(Game.playerSheet, 160, 0, 32, 32);
/*  86 */     player_up_attack[2] = getCropped(Game.playerSheet, 160, 32, 32, 32);
/*  87 */     player_up_attack[3] = getCropped(Game.playerSheet, 160, 64, 32, 32);
/*  88 */     player_up_attack[4] = getCropped(Game.playerSheet, 160, 96, 32, 32);
/*  89 */     player_left_attack[1] = getCropped(Game.playerSheet, 192, 0, 32, 32);
/*  90 */     player_left_attack[2] = getCropped(Game.playerSheet, 192, 32, 32, 32);
/*  91 */     player_left_attack[3] = getCropped(Game.playerSheet, 192, 64, 32, 32);
/*  92 */     player_left_attack[4] = getCropped(Game.playerSheet, 192, 96, 32, 32);
/*  93 */     player_right_attack[1] = getCropped(Game.playerSheet, 224, 0, 32, 32);
/*  94 */     player_right_attack[2] = getCropped(Game.playerSheet, 224, 32, 32, 32);
/*  95 */     player_right_attack[3] = getCropped(Game.playerSheet, 224, 64, 32, 32);
/*  96 */     player_right_attack[4] = getCropped(Game.playerSheet, 224, 96, 32, 32);
/*  97 */     player_down_swim[1] = getCropped(Game.playerSheet, 256, 0, 32, 32);
/*  98 */     player_down_swim[2] = getCropped(Game.playerSheet, 256, 32, 32, 32);
/*  99 */     player_down_swim[3] = getCropped(Game.playerSheet, 256, 64, 32, 32);
/* 100 */     player_down_swim[4] = getCropped(Game.playerSheet, 256, 96, 32, 32);
/* 101 */     player_up_swim[1] = getCropped(Game.playerSheet, 288, 0, 32, 32);
/* 102 */     player_up_swim[2] = getCropped(Game.playerSheet, 288, 32, 32, 32);
/* 103 */     player_up_swim[3] = getCropped(Game.playerSheet, 288, 64, 32, 32);
/* 104 */     player_up_swim[4] = getCropped(Game.playerSheet, 288, 96, 32, 32);
/* 105 */     player_left_swim[1] = getCropped(Game.playerSheet, 320, 0, 32, 32);
/* 106 */     player_left_swim[2] = getCropped(Game.playerSheet, 320, 32, 32, 32);
/* 107 */     player_left_swim[3] = getCropped(Game.playerSheet, 320, 64, 32, 32);
/* 108 */     player_left_swim[4] = getCropped(Game.playerSheet, 320, 96, 32, 32);
/* 109 */     player_right_swim[1] = getCropped(Game.playerSheet, 352, 0, 32, 32);
/* 110 */     player_right_swim[2] = getCropped(Game.playerSheet, 352, 32, 32, 32);
/* 111 */     player_right_swim[3] = getCropped(Game.playerSheet, 352, 64, 32, 32);
/* 112 */     player_right_swim[4] = getCropped(Game.playerSheet, 352, 96, 32, 32);
/*     */   }
/*     */   
/*     */   public void widgetSetUp() {
/* 116 */     dialogueBox = getCropped(Game.widgetSheet, 0, 0, 512, 160);
/* 117 */     player_hud = getCropped(Game.widgetSheet, 0, 160, 160, 64);
/*     */   }
/*     */   
/*     */   private void grassMapSetUp() {
/* 121 */     grassFull = getCropped(Game.terrain1Sheet, 0, 0, 32, 32);
/* 122 */     grassBarrier = getCropped(Game.terrain1Sheet, 32, 32, 32, 32);
/* 123 */     tree = getCropped(Game.terrain1Sheet, 0, 32, 32, 32);
/* 124 */     water[1] = getCropped(Game.terrain1Sheet, 32, 0, 32, 32);
/* 125 */     water[2] = getCropped(Game.terrain1Sheet, 64, 0, 32, 32);
/* 126 */     water[3] = getCropped(Game.terrain1Sheet, 96, 0, 32, 32);
/* 127 */     water[4] = getCropped(Game.terrain1Sheet, 128, 0, 32, 32);
/* 128 */     shop1 = getCropped(Game.terrain1Sheet, 192, 0, 96, 96);
/*     */   }
/*     */   
/*     */   private void entitySetUp() {
/* 132 */     cow_down[1] = getCropped(Game.entitySheet, 0, 64, 32, 32);
/* 133 */     cow_down[2] = getCropped(Game.entitySheet, 32, 64, 32, 32);
/* 134 */     cow_down[3] = getCropped(Game.entitySheet, 96, 64, 32, 32);
/* 135 */     cow_down[4] = getCropped(Game.entitySheet, 64, 64, 32, 32);
/* 136 */     cow_up[1] = getCropped(Game.entitySheet, 0, 96, 32, 32);
/* 137 */     cow_up[2] = getCropped(Game.entitySheet, 32, 96, 32, 32);
/* 138 */     cow_up[3] = getCropped(Game.entitySheet, 96, 96, 32, 32);
/* 139 */     cow_up[4] = getCropped(Game.entitySheet, 64, 96, 32, 32);
/* 140 */     cow_left[1] = getCropped(Game.entitySheet, 0, 0, 32, 32);
/* 141 */     cow_left[2] = getCropped(Game.entitySheet, 32, 0, 32, 32);
/* 142 */     cow_left[3] = getCropped(Game.entitySheet, 96, 0, 32, 32);
/* 143 */     cow_left[4] = getCropped(Game.entitySheet, 64, 0, 32, 32);
/* 144 */     cow_right[1] = getCropped(Game.entitySheet, 0, 32, 32, 32);
/* 145 */     cow_right[2] = getCropped(Game.entitySheet, 32, 32, 32, 32);
/* 146 */     cow_right[3] = getCropped(Game.entitySheet, 96, 32, 32, 32);
/* 147 */     cow_right[4] = getCropped(Game.entitySheet, 64, 32, 32, 32);
/* 149 */     testDummy_down[1] = getCropped(Game.entitySheet, 0, 0, 32, 32);
/* 150 */     testDummy_down[2] = getCropped(Game.entitySheet, 0, 32, 32, 32);
/* 151 */     testDummy_down[3] = getCropped(Game.entitySheet, 0, 64, 32, 32);
/* 152 */     testDummy_down[4] = getCropped(Game.entitySheet, 0, 96, 32, 32);
/* 153 */     testDummy_up[1] = getCropped(Game.entitySheet, 32, 0, 32, 32);
/* 154 */     testDummy_up[2] = getCropped(Game.entitySheet, 32, 32, 32, 32);
/* 155 */     testDummy_up[3] = getCropped(Game.entitySheet, 32, 64, 32, 32);
/* 156 */     testDummy_up[4] = getCropped(Game.entitySheet, 32, 96, 32, 32);
/* 157 */     testDummy_left[1] = getCropped(Game.entitySheet, 64, 0, 32, 32);
/* 158 */     testDummy_left[2] = Game.st
/* 159 */       .getCropped(Game.entitySheet, 64, 32, 32, 32);
/* 160 */     testDummy_left[3] = Game.st
/* 161 */       .getCropped(Game.entitySheet, 64, 64, 32, 32);
/* 162 */     testDummy_left[4] = Game.st
/* 163 */       .getCropped(Game.entitySheet, 64, 96, 32, 32);
/* 164 */     testDummy_right[1] = Game.st
/* 165 */       .getCropped(Game.entitySheet, 96, 0, 32, 32);
/* 166 */     testDummy_right[2] = getCropped(Game.entitySheet, 96, 32, 32, 32);
/* 167 */     testDummy_right[3] = getCropped(Game.entitySheet, 96, 64, 32, 32);
/* 168 */     testDummy_right[4] = getCropped(Game.entitySheet, 96, 96, 32, 32);
/* 170 */     paige_down[1] = getCropped(Game.entitySheet, 128, 0, 32, 32);
/* 171 */     paige_down[2] = getCropped(Game.entitySheet, 128, 32, 32, 32);
/* 172 */     paige_down[3] = getCropped(Game.entitySheet, 128, 64, 32, 32);
/* 173 */     paige_down[4] = getCropped(Game.entitySheet, 128, 96, 32, 32);
/* 174 */     paige_up[1] = getCropped(Game.entitySheet, 160, 0, 32, 32);
/* 175 */     paige_up[2] = getCropped(Game.entitySheet, 160, 32, 32, 32);
/* 176 */     paige_up[3] = getCropped(Game.entitySheet, 160, 64, 32, 32);
/* 177 */     paige_up[4] = getCropped(Game.entitySheet, 160, 96, 32, 32);
/* 178 */     paige_left[1] = getCropped(Game.entitySheet, 192, 0, 32, 32);
/* 179 */     paige_left[2] = getCropped(Game.entitySheet, 192, 32, 32, 32);
/* 180 */     paige_left[3] = getCropped(Game.entitySheet, 192, 64, 32, 32);
/* 181 */     paige_left[4] = getCropped(Game.entitySheet, 192, 96, 32, 32);
/* 182 */     paige_right[1] = getCropped(Game.entitySheet, 224, 0, 32, 32);
/* 183 */     paige_right[2] = getCropped(Game.entitySheet, 224, 32, 32, 32);
/* 184 */     paige_right[3] = getCropped(Game.entitySheet, 224, 64, 32, 32);
/* 185 */     paige_right[4] = getCropped(Game.entitySheet, 224, 96, 32, 32);
/*     */   }
/*     */   
/*     */   private void menuSetUp() {
/* 189 */     button1_1 = getCropped(Game.mainmenuSheet, 0, 0, 160, 32);
/* 190 */     button1_2 = getCropped(Game.mainmenuSheet, 0, 32, 160, 32);
/* 191 */     button1_3 = getCropped(Game.mainmenuSheet, 0, 64, 160, 32);
/* 192 */     button2_1 = getCropped(Game.mainmenuSheet, 0, 96, 336, 32);
/* 193 */     button2_2 = getCropped(Game.mainmenuSheet, 0, 128, 336, 32);
/* 194 */     button2_3 = getCropped(Game.mainmenuSheet, 0, 160, 336, 32);
/* 195 */     profileSquare = getCropped(Game.mainmenuSheet, 288, 0, 96, 96);
/* 196 */     profileEmpty = getCropped(Game.mainmenuSheet, 384, 0, 64, 64);
/* 197 */     profileSelection = getCropped(Game.mainmenuSheet, 0, 192, 300, 117);
/* 198 */     cloud1 = getCropped(Game.mainmenuSheet, 160, 0, 128, 96);
/* 199 */     cloud2 = getCropped(Game.mainmenuSheet, 160, 0, 128, 96);
/* 200 */     cloud3 = getCropped(Game.mainmenuSheet, 160, 0, 128, 96);
/*     */   }
/*     */   
/*     */   private void inventorySetUp() {
/* 204 */     inventory1 = getCropped(Game.inventorySheet, 0, 0, 416, 288);
/* 205 */     inventory2 = getCropped(Game.inventorySheet, 416, 0, 416, 288);
/* 206 */     inventory3 = getCropped(Game.inventorySheet, 0, 288, 416, 288);
/* 207 */     tab1_1 = getCropped(Game.inventorySheet, 832, 0, 64, 64);
/* 208 */     tab2_1 = getCropped(Game.inventorySheet, 896, 0, 64, 64);
/* 209 */     tab3_1 = getCropped(Game.inventorySheet, 960, 0, 64, 64);
/* 210 */     tab1_2 = getCropped(Game.inventorySheet, 832, 64, 64, 64);
/* 211 */     tab2_2 = getCropped(Game.inventorySheet, 896, 64, 64, 64);
/* 212 */     tab3_2 = getCropped(Game.inventorySheet, 960, 64, 64, 64);
/* 213 */     arrow_1 = getCropped(Game.inventorySheet, 832, 128, 32, 64);
/* 214 */     arrow_2 = getCropped(Game.inventorySheet, 864, 128, 32, 64);
/* 215 */     quest_1 = getCropped(Game.inventorySheet, 416, 288, 241, 39);
/* 216 */     quest_2 = getCropped(Game.inventorySheet, 416, 352, 241, 39);
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.1.0_5.jar!\com\emgartley\beyondOrigins\main\gfx\ImageManager.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */