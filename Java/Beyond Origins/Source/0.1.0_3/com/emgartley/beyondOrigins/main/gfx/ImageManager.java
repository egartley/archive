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
/*  31 */   public static BufferedImage[] paige_up = new BufferedImage[5];
/*     */   
/*  32 */   public static BufferedImage[] paige_down = new BufferedImage[5];
/*     */   
/*  33 */   public static BufferedImage[] paige_left = new BufferedImage[5];
/*     */   
/*  34 */   public static BufferedImage[] paige_right = new BufferedImage[5];
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
/*  44 */   public static short hpCropX = 81, expCropX = 83;
/*     */   
/*     */   public ImageManager() {
/*  47 */     playerSetUp();
/*  48 */     widgetSetUp();
/*  49 */     grassMapSetUp();
/*  50 */     entitySetUp();
/*  51 */     menuSetUp();
/*  52 */     inventorySetUp();
/*     */   }
/*     */   
/*     */   public BufferedImage getCropped(BufferedImage sheet, int x, int y, int w, int h) {
/*  57 */     return sheet.getSubimage(x, y, w, h);
/*     */   }
/*     */   
/*     */   private void playerSetUp() {
/*  61 */     player_down[1] = getCropped(Game.playerSheet, 0, 0, 32, 32);
/*  62 */     player_down[2] = getCropped(Game.playerSheet, 0, 32, 32, 32);
/*  63 */     player_down[3] = getCropped(Game.playerSheet, 0, 64, 32, 32);
/*  64 */     player_down[4] = getCropped(Game.playerSheet, 0, 96, 32, 32);
/*  65 */     player_up[1] = getCropped(Game.playerSheet, 32, 0, 32, 32);
/*  66 */     player_up[2] = getCropped(Game.playerSheet, 32, 32, 32, 32);
/*  67 */     player_up[3] = getCropped(Game.playerSheet, 32, 64, 32, 32);
/*  68 */     player_up[4] = getCropped(Game.playerSheet, 32, 96, 32, 32);
/*  69 */     player_left[1] = getCropped(Game.playerSheet, 64, 0, 32, 32);
/*  70 */     player_left[2] = getCropped(Game.playerSheet, 64, 32, 32, 32);
/*  71 */     player_left[3] = getCropped(Game.playerSheet, 64, 64, 32, 32);
/*  72 */     player_left[4] = getCropped(Game.playerSheet, 64, 96, 32, 32);
/*  73 */     player_right[1] = getCropped(Game.playerSheet, 96, 0, 32, 32);
/*  74 */     player_right[2] = getCropped(Game.playerSheet, 96, 32, 32, 32);
/*  75 */     player_right[3] = getCropped(Game.playerSheet, 96, 64, 32, 32);
/*  76 */     player_right[4] = getCropped(Game.playerSheet, 96, 96, 32, 32);
/*  77 */     player_down_attack[1] = getCropped(Game.playerSheet, 128, 0, 32, 32);
/*  78 */     player_down_attack[2] = getCropped(Game.playerSheet, 128, 32, 32, 32);
/*  79 */     player_down_attack[3] = getCropped(Game.playerSheet, 128, 64, 32, 32);
/*  80 */     player_down_attack[4] = getCropped(Game.playerSheet, 128, 96, 32, 32);
/*  81 */     player_up_attack[1] = getCropped(Game.playerSheet, 160, 0, 32, 32);
/*  82 */     player_up_attack[2] = getCropped(Game.playerSheet, 160, 32, 32, 32);
/*  83 */     player_up_attack[3] = getCropped(Game.playerSheet, 160, 64, 32, 32);
/*  84 */     player_up_attack[4] = getCropped(Game.playerSheet, 160, 96, 32, 32);
/*  85 */     player_left_attack[1] = getCropped(Game.playerSheet, 192, 0, 32, 32);
/*  86 */     player_left_attack[2] = getCropped(Game.playerSheet, 192, 32, 32, 32);
/*  87 */     player_left_attack[3] = getCropped(Game.playerSheet, 192, 64, 32, 32);
/*  88 */     player_left_attack[4] = getCropped(Game.playerSheet, 192, 96, 32, 32);
/*  89 */     player_right_attack[1] = getCropped(Game.playerSheet, 224, 0, 32, 32);
/*  90 */     player_right_attack[2] = getCropped(Game.playerSheet, 224, 32, 32, 32);
/*  91 */     player_right_attack[3] = getCropped(Game.playerSheet, 224, 64, 32, 32);
/*  92 */     player_right_attack[4] = getCropped(Game.playerSheet, 224, 96, 32, 32);
/*     */   }
/*     */   
/*     */   public void widgetSetUp() {
/*  96 */     dialogueBox = getCropped(Game.widgetSheet, 0, 0, 512, 160);
/*  97 */     player_hud = getCropped(Game.widgetSheet, 0, 160, 160, 64);
/*     */   }
/*     */   
/*     */   private void grassMapSetUp() {
/* 101 */     grassFull = getCropped(Game.terrain1Sheet, 0, 0, 32, 32);
/* 102 */     grassBarrier = getCropped(Game.terrain1Sheet, 32, 32, 32, 32);
/* 103 */     tree = getCropped(Game.terrain1Sheet, 0, 32, 32, 32);
/* 104 */     water[1] = getCropped(Game.terrain1Sheet, 32, 0, 32, 32);
/* 105 */     water[2] = getCropped(Game.terrain1Sheet, 64, 0, 32, 32);
/* 106 */     water[3] = getCropped(Game.terrain1Sheet, 96, 0, 32, 32);
/* 107 */     water[4] = getCropped(Game.terrain1Sheet, 128, 0, 32, 32);
/* 108 */     shop1 = getCropped(Game.terrain1Sheet, 192, 0, 96, 96);
/*     */   }
/*     */   
/*     */   private void entitySetUp() {
/* 112 */     cow_down[1] = getCropped(Game.entitySheet, 0, 64, 32, 32);
/* 113 */     cow_down[2] = getCropped(Game.entitySheet, 32, 64, 32, 32);
/* 114 */     cow_down[3] = getCropped(Game.entitySheet, 96, 64, 32, 32);
/* 115 */     cow_down[4] = getCropped(Game.entitySheet, 64, 64, 32, 32);
/* 116 */     cow_up[1] = getCropped(Game.entitySheet, 0, 96, 32, 32);
/* 117 */     cow_up[2] = getCropped(Game.entitySheet, 32, 96, 32, 32);
/* 118 */     cow_up[3] = getCropped(Game.entitySheet, 96, 96, 32, 32);
/* 119 */     cow_up[4] = getCropped(Game.entitySheet, 64, 96, 32, 32);
/* 120 */     cow_left[1] = getCropped(Game.entitySheet, 0, 0, 32, 32);
/* 121 */     cow_left[2] = getCropped(Game.entitySheet, 32, 0, 32, 32);
/* 122 */     cow_left[3] = getCropped(Game.entitySheet, 96, 0, 32, 32);
/* 123 */     cow_left[4] = getCropped(Game.entitySheet, 64, 0, 32, 32);
/* 124 */     cow_right[1] = getCropped(Game.entitySheet, 0, 32, 32, 32);
/* 125 */     cow_right[2] = getCropped(Game.entitySheet, 32, 32, 32, 32);
/* 126 */     cow_right[3] = getCropped(Game.entitySheet, 96, 32, 32, 32);
/* 127 */     cow_right[4] = getCropped(Game.entitySheet, 64, 32, 32, 32);
/* 129 */     testDummy_down[1] = getCropped(Game.entitySheet, 0, 0, 32, 32);
/* 130 */     testDummy_down[2] = getCropped(Game.entitySheet, 0, 32, 32, 32);
/* 131 */     testDummy_down[3] = getCropped(Game.entitySheet, 0, 64, 32, 32);
/* 132 */     testDummy_down[4] = getCropped(Game.entitySheet, 0, 96, 32, 32);
/* 133 */     testDummy_up[1] = getCropped(Game.entitySheet, 32, 0, 32, 32);
/* 134 */     testDummy_up[2] = getCropped(Game.entitySheet, 32, 32, 32, 32);
/* 135 */     testDummy_up[3] = getCropped(Game.entitySheet, 32, 64, 32, 32);
/* 136 */     testDummy_up[4] = getCropped(Game.entitySheet, 32, 96, 32, 32);
/* 137 */     testDummy_left[1] = getCropped(Game.entitySheet, 64, 0, 32, 32);
/* 138 */     testDummy_left[2] = Game.st
/* 139 */       .getCropped(Game.entitySheet, 64, 32, 32, 32);
/* 140 */     testDummy_left[3] = Game.st
/* 141 */       .getCropped(Game.entitySheet, 64, 64, 32, 32);
/* 142 */     testDummy_left[4] = Game.st
/* 143 */       .getCropped(Game.entitySheet, 64, 96, 32, 32);
/* 144 */     testDummy_right[1] = Game.st
/* 145 */       .getCropped(Game.entitySheet, 96, 0, 32, 32);
/* 146 */     testDummy_right[2] = getCropped(Game.entitySheet, 96, 32, 32, 32);
/* 147 */     testDummy_right[3] = getCropped(Game.entitySheet, 96, 64, 32, 32);
/* 148 */     testDummy_right[4] = getCropped(Game.entitySheet, 96, 96, 32, 32);
/* 150 */     paige_down[1] = getCropped(Game.entitySheet, 128, 0, 32, 32);
/* 151 */     paige_down[2] = getCropped(Game.entitySheet, 128, 32, 32, 32);
/* 152 */     paige_down[3] = getCropped(Game.entitySheet, 128, 64, 32, 32);
/* 153 */     paige_down[4] = getCropped(Game.entitySheet, 128, 96, 32, 32);
/* 154 */     paige_up[1] = getCropped(Game.entitySheet, 160, 0, 32, 32);
/* 155 */     paige_up[2] = getCropped(Game.entitySheet, 160, 32, 32, 32);
/* 156 */     paige_up[3] = getCropped(Game.entitySheet, 160, 64, 32, 32);
/* 157 */     paige_up[4] = getCropped(Game.entitySheet, 160, 96, 32, 32);
/* 158 */     paige_left[1] = getCropped(Game.entitySheet, 192, 0, 32, 32);
/* 159 */     paige_left[2] = getCropped(Game.entitySheet, 192, 32, 32, 32);
/* 160 */     paige_left[3] = getCropped(Game.entitySheet, 192, 64, 32, 32);
/* 161 */     paige_left[4] = getCropped(Game.entitySheet, 192, 96, 32, 32);
/* 162 */     paige_right[1] = getCropped(Game.entitySheet, 224, 0, 32, 32);
/* 163 */     paige_right[2] = getCropped(Game.entitySheet, 224, 32, 32, 32);
/* 164 */     paige_right[3] = getCropped(Game.entitySheet, 224, 64, 32, 32);
/* 165 */     paige_right[4] = getCropped(Game.entitySheet, 224, 96, 32, 32);
/*     */   }
/*     */   
/*     */   private void menuSetUp() {
/* 169 */     button1_1 = getCropped(Game.mainmenuSheet, 0, 0, 160, 32);
/* 170 */     button1_2 = getCropped(Game.mainmenuSheet, 0, 32, 160, 32);
/* 171 */     button1_3 = getCropped(Game.mainmenuSheet, 0, 64, 160, 32);
/* 172 */     button2_1 = getCropped(Game.mainmenuSheet, 0, 96, 336, 32);
/* 173 */     button2_2 = getCropped(Game.mainmenuSheet, 0, 128, 336, 32);
/* 174 */     button2_3 = getCropped(Game.mainmenuSheet, 0, 160, 336, 32);
/* 175 */     profileSquare = getCropped(Game.mainmenuSheet, 288, 0, 96, 96);
/* 176 */     profileEmpty = getCropped(Game.mainmenuSheet, 384, 0, 64, 64);
/* 177 */     profileSelection = getCropped(Game.mainmenuSheet, 0, 192, 300, 117);
/* 178 */     cloud1 = getCropped(Game.mainmenuSheet, 160, 0, 128, 96);
/* 179 */     cloud2 = getCropped(Game.mainmenuSheet, 160, 0, 128, 96);
/* 180 */     cloud3 = getCropped(Game.mainmenuSheet, 160, 0, 128, 96);
/*     */   }
/*     */   
/*     */   private void inventorySetUp() {
/* 184 */     inventory1 = getCropped(Game.inventorySheet, 0, 0, 416, 288);
/* 185 */     inventory2 = getCropped(Game.inventorySheet, 416, 0, 416, 288);
/* 186 */     inventory3 = getCropped(Game.inventorySheet, 0, 288, 416, 288);
/* 187 */     tab1_1 = getCropped(Game.inventorySheet, 832, 0, 64, 64);
/* 188 */     tab2_1 = getCropped(Game.inventorySheet, 896, 0, 64, 64);
/* 189 */     tab3_1 = getCropped(Game.inventorySheet, 960, 0, 64, 64);
/* 190 */     tab1_2 = getCropped(Game.inventorySheet, 832, 64, 64, 64);
/* 191 */     tab2_2 = getCropped(Game.inventorySheet, 896, 64, 64, 64);
/* 192 */     tab3_2 = getCropped(Game.inventorySheet, 960, 64, 64, 64);
/* 193 */     arrow_1 = getCropped(Game.inventorySheet, 832, 128, 32, 64);
/* 194 */     arrow_2 = getCropped(Game.inventorySheet, 864, 128, 32, 64);
/* 195 */     quest_1 = getCropped(Game.inventorySheet, 416, 288, 241, 39);
/* 196 */     quest_2 = getCropped(Game.inventorySheet, 416, 352, 241, 39);
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.1.0_3.jar!\com\emgartley\beyondOrigins\main\gfx\ImageManager.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */