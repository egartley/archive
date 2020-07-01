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
/*  42 */   public static short hpCropX = 81, expCropX = 83;
/*     */   
/*     */   public ImageManager() {
/*  45 */     playerSetUp();
/*  46 */     widgetSetUp();
/*  47 */     grassMapSetUp();
/*  48 */     entitySetUp();
/*  49 */     menuSetUp();
/*  50 */     inventorySetUp();
/*     */   }
/*     */   
/*     */   public static BufferedImage custom512Crop(BufferedImage sheet, int x, int y, int w, int h) {
/*  55 */     return sheet.getSubimage(x, y, w, h);
/*     */   }
/*     */   
/*     */   public BufferedImage custom1024Crop(BufferedImage sheet, int x, int y, int w, int h) {
/*  60 */     return sheet.getSubimage(x, y, w, h);
/*     */   }
/*     */   
/*     */   public BufferedImage basic512Crop(BufferedImage sheet, int col, int row, int w, int h) {
/*  65 */     return sheet.getSubimage(col * 32, row * 32, w, h);
/*     */   }
/*     */   
/*     */   public BufferedImage button1Crop(BufferedImage sheet, int col, int row, int w, int h) {
/*  70 */     return sheet.getSubimage(col * 160, row * 32, w, h);
/*     */   }
/*     */   
/*     */   public BufferedImage button2Crop(BufferedImage sheet, int col, int row, int w, int h) {
/*  75 */     return sheet.getSubimage(col * 336, row * 32, w, h);
/*     */   }
/*     */   
/*     */   public BufferedImage cloudCrop(BufferedImage sheet, int col, int row, int w, int h) {
/*  80 */     return sheet.getSubimage(col * 160, row * 96, w, h);
/*     */   }
/*     */   
/*     */   public BufferedImage invTabCrop(BufferedImage sheet, int row, int col, int w, int h) {
/*  85 */     return sheet.getSubimage(row * 64, col * 64, w, h);
/*     */   }
/*     */   
/*     */   public BufferedImage arrowCrop(BufferedImage sheet, int row, int col, int w, int h) {
/*  90 */     return sheet.getSubimage(row * 32, col * 64, w, h);
/*     */   }
/*     */   
/*     */   public BufferedImage buildingCrop(BufferedImage sheet, int row, int col, int w, int h) {
/*  95 */     return sheet.getSubimage(row * 96, col * 96, w, h);
/*     */   }
/*     */   
/*     */   public BufferedImage tileCrop(BufferedImage sheet, int row, int col, int w, int h) {
/* 100 */     return sheet.getSubimage(row * 32, col * 32, w, h);
/*     */   }
/*     */   
/*     */   private void playerSetUp() {
/* 104 */     playerd1 = basic512Crop(Game.playerSheet, 0, 0, 32, 32);
/* 105 */     playerd2 = basic512Crop(Game.playerSheet, 0, 1, 32, 32);
/* 106 */     playerd3 = basic512Crop(Game.playerSheet, 0, 2, 32, 32);
/* 107 */     playerd4 = basic512Crop(Game.playerSheet, 0, 3, 32, 32);
/* 108 */     playeru1 = basic512Crop(Game.playerSheet, 1, 0, 32, 32);
/* 109 */     playeru2 = basic512Crop(Game.playerSheet, 1, 1, 32, 32);
/* 110 */     playeru3 = basic512Crop(Game.playerSheet, 1, 2, 32, 32);
/* 111 */     playeru4 = basic512Crop(Game.playerSheet, 1, 3, 32, 32);
/* 112 */     playerl1 = basic512Crop(Game.playerSheet, 2, 0, 32, 32);
/* 113 */     playerl2 = basic512Crop(Game.playerSheet, 2, 1, 32, 32);
/* 114 */     playerl3 = basic512Crop(Game.playerSheet, 2, 2, 32, 32);
/* 115 */     playerl4 = basic512Crop(Game.playerSheet, 2, 3, 32, 32);
/* 116 */     playerr1 = basic512Crop(Game.playerSheet, 3, 0, 32, 32);
/* 117 */     playerr2 = basic512Crop(Game.playerSheet, 3, 1, 32, 32);
/* 118 */     playerr3 = basic512Crop(Game.playerSheet, 3, 2, 32, 32);
/* 119 */     playerr4 = basic512Crop(Game.playerSheet, 3, 3, 32, 32);
/*     */   }
/*     */   
/*     */   public void widgetSetUp() {
/* 123 */     dialogueBox = custom512Crop(Game.widgetSheet, 0, 0, 512, 160);
/* 124 */     pHUD = custom512Crop(Game.widgetSheet, 0, 160, 160, 64);
/*     */   }
/*     */   
/*     */   private void grassMapSetUp() {
/* 128 */     grassFull = tileCrop(Game.terrain1Sheet, 0, 0, 32, 32);
/* 129 */     grassCnr1 = tileCrop(Game.terrain1Sheet, 1, 0, 32, 32);
/* 130 */     grassCnr2 = tileCrop(Game.terrain1Sheet, 1, 1, 32, 32);
/* 131 */     grassCnr3 = tileCrop(Game.terrain1Sheet, 0, 1, 32, 32);
/* 132 */     grassCnr4 = tileCrop(Game.terrain1Sheet, 2, 1, 32, 32);
/* 133 */     grassEdge1 = tileCrop(Game.terrain1Sheet, 3, 0, 32, 32);
/* 134 */     grassEdge2 = tileCrop(Game.terrain1Sheet, 5, 0, 32, 32);
/* 135 */     grassEdge3 = tileCrop(Game.terrain1Sheet, 4, 0, 32, 32);
/* 136 */     grassEdge4 = tileCrop(Game.terrain1Sheet, 2, 0, 32, 32);
/* 137 */     grassTree1 = tileCrop(Game.terrain1Sheet, 3, 1, 32, 32);
/* 138 */     shop1 = buildingCrop(Game.terrain1Sheet, 2, 0, 96, 96);
/* 139 */     path1_1 = tileCrop(Game.terrain1Sheet, 4, 1, 32, 32);
/* 140 */     path1_2 = tileCrop(Game.terrain1Sheet, 5, 1, 32, 32);
/* 141 */     path1Cnr1 = tileCrop(Game.terrain1Sheet, 0, 2, 32, 32);
/* 142 */     path1Cnr2 = tileCrop(Game.terrain1Sheet, 1, 2, 32, 32);
/* 143 */     path1Cnr3 = tileCrop(Game.terrain1Sheet, 2, 2, 32, 32);
/* 144 */     path1Cnr4 = tileCrop(Game.terrain1Sheet, 3, 2, 32, 32);
/*     */   }
/*     */   
/*     */   private void entitySetUp() {
/* 148 */     cowd1 = basic512Crop(Game.entitySheet, 0, 2, 32, 32);
/* 149 */     cowd2 = basic512Crop(Game.entitySheet, 1, 2, 32, 32);
/* 150 */     cowd3 = basic512Crop(Game.entitySheet, 3, 2, 32, 32);
/* 151 */     cowd4 = basic512Crop(Game.entitySheet, 2, 2, 32, 32);
/* 152 */     cowu1 = basic512Crop(Game.entitySheet, 0, 3, 32, 32);
/* 153 */     cowu2 = basic512Crop(Game.entitySheet, 1, 3, 32, 32);
/* 154 */     cowu3 = basic512Crop(Game.entitySheet, 3, 3, 32, 32);
/* 155 */     cowu4 = basic512Crop(Game.entitySheet, 2, 3, 32, 32);
/* 156 */     cowl1 = basic512Crop(Game.entitySheet, 0, 0, 32, 32);
/* 157 */     cowl2 = basic512Crop(Game.entitySheet, 1, 0, 32, 32);
/* 158 */     cowl3 = basic512Crop(Game.entitySheet, 3, 0, 32, 32);
/* 159 */     cowl4 = basic512Crop(Game.entitySheet, 2, 0, 32, 32);
/* 160 */     cowr1 = basic512Crop(Game.entitySheet, 0, 1, 32, 32);
/* 161 */     cowr2 = basic512Crop(Game.entitySheet, 1, 1, 32, 32);
/* 162 */     cowr3 = basic512Crop(Game.entitySheet, 3, 1, 32, 32);
/* 163 */     cowr4 = basic512Crop(Game.entitySheet, 2, 1, 32, 32);
/* 165 */     tdd1 = basic512Crop(Game.entitySheet, 0, 0, 32, 32);
/* 166 */     tdd2 = basic512Crop(Game.entitySheet, 0, 1, 32, 32);
/* 167 */     tdd3 = basic512Crop(Game.entitySheet, 0, 2, 32, 32);
/* 168 */     tdd4 = basic512Crop(Game.entitySheet, 0, 3, 32, 32);
/* 169 */     tdu1 = basic512Crop(Game.entitySheet, 1, 0, 32, 32);
/* 170 */     tdu2 = basic512Crop(Game.entitySheet, 1, 1, 32, 32);
/* 171 */     tdu3 = basic512Crop(Game.entitySheet, 1, 2, 32, 32);
/* 172 */     tdu4 = basic512Crop(Game.entitySheet, 1, 3, 32, 32);
/* 173 */     tdl1 = basic512Crop(Game.entitySheet, 2, 0, 32, 32);
/* 174 */     tdl2 = basic512Crop(Game.entitySheet, 2, 1, 32, 32);
/* 175 */     tdl3 = basic512Crop(Game.entitySheet, 2, 2, 32, 32);
/* 176 */     tdl4 = basic512Crop(Game.entitySheet, 2, 3, 32, 32);
/* 177 */     tdr1 = basic512Crop(Game.entitySheet, 3, 0, 32, 32);
/* 178 */     tdr2 = basic512Crop(Game.entitySheet, 3, 1, 32, 32);
/* 179 */     tdr3 = basic512Crop(Game.entitySheet, 3, 2, 32, 32);
/* 180 */     tdr4 = basic512Crop(Game.entitySheet, 3, 3, 32, 32);
/*     */   }
/*     */   
/*     */   private void menuSetUp() {
/* 184 */     button1_1 = button1Crop(Game.mainmenuSheet, 0, 0, 160, 32);
/* 185 */     button1_2 = button1Crop(Game.mainmenuSheet, 0, 1, 160, 32);
/* 186 */     button1_3 = button1Crop(Game.mainmenuSheet, 0, 2, 160, 32);
/* 187 */     button2_1 = button2Crop(Game.mainmenuSheet, 0, 3, 336, 32);
/* 188 */     button2_2 = button2Crop(Game.mainmenuSheet, 0, 4, 336, 32);
/* 189 */     button2_3 = button2Crop(Game.mainmenuSheet, 0, 5, 336, 32);
/* 190 */     profileSquare = custom512Crop(Game.mainmenuSheet, 288, 0, 96, 96);
/* 191 */     profileEmpty = custom512Crop(Game.mainmenuSheet, 384, 0, 64, 64);
/* 192 */     profileSelection = custom512Crop(Game.mainmenuSheet, 0, 192, 300, 117);
/* 193 */     cloud1 = cloudCrop(Game.mainmenuSheet, 1, 0, 128, 96);
/* 194 */     cloud2 = cloudCrop(Game.mainmenuSheet, 1, 0, 128, 96);
/* 195 */     cloud3 = cloudCrop(Game.mainmenuSheet, 1, 0, 128, 96);
/*     */   }
/*     */   
/*     */   private void inventorySetUp() {
/* 199 */     inventory1 = custom1024Crop(Game.inventorySheet, 0, 0, 416, 288);
/* 200 */     inventory2 = custom1024Crop(Game.inventorySheet, 416, 0, 416, 288);
/* 201 */     inventory3 = custom1024Crop(Game.inventorySheet, 0, 288, 416, 288);
/* 202 */     tabs01 = invTabCrop(Game.inventorySheet, 13, 0, 64, 64);
/* 203 */     tabs02 = invTabCrop(Game.inventorySheet, 14, 0, 64, 64);
/* 204 */     tabs03 = invTabCrop(Game.inventorySheet, 15, 0, 64, 64);
/* 205 */     tabs11 = invTabCrop(Game.inventorySheet, 13, 1, 64, 64);
/* 206 */     tabs12 = invTabCrop(Game.inventorySheet, 14, 1, 64, 64);
/* 207 */     tabs13 = invTabCrop(Game.inventorySheet, 15, 1, 64, 64);
/* 208 */     arrow1 = arrowCrop(Game.inventorySheet, 26, 2, 32, 64);
/* 209 */     arrow2 = arrowCrop(Game.inventorySheet, 27, 2, 32, 64);
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.6_2.jar!\beyondOrigins\main\gfx\ImageManager.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */