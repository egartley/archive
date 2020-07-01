/*     */ package applecraft.testgame.main.entities;
/*     */ 
/*     */ import applecraft.testgame.main.Game;
/*     */ import applecraft.testgame.main.gfx.ImageManager;
/*     */ import java.awt.Graphics;
/*     */ 
/*     */ public class Player {
/*  10 */   private int downCount = 1;
/*     */   
/*  10 */   private int upCount = 1;
/*     */   
/*  10 */   private int leftCount = 1;
/*     */   
/*  10 */   private int rightCount = 1;
/*     */   
/*     */   public static boolean pUp;
/*     */   
/*     */   public static boolean pDown;
/*     */   
/*     */   public static boolean pRight;
/*     */   
/*     */   public static boolean pLeft;
/*     */   
/*  12 */   public static int canMoveUp = 1, canMoveDown = 1, canMoveLeft = 1;
/*     */   
/*  13 */   public static int canMoveRight = 1;
/*     */   
/*     */   public static boolean mapMovement = true;
/*     */   
/*     */   public static boolean insideMovement;
/*     */   
/*  16 */   public static float playerX = 0.0F;
/*     */   
/*  17 */   public static float playerY = 0.0F;
/*     */   
/*     */   public static float mapX;
/*     */   
/*     */   public static float mapY;
/*     */   
/*     */   public static int tileX;
/*     */   
/*     */   public static int tileY;
/*     */   
/*     */   private ImageManager im;
/*     */   
/*  27 */   public static int lastDir = 0;
/*     */   
/*  28 */   public static int catchingUp = 0;
/*     */   
/*     */   public static boolean up = false;
/*     */   
/*     */   public static boolean down = false;
/*     */   
/*     */   public static boolean left = false;
/*     */   
/*     */   public static boolean right = false;
/*     */   
/*  35 */   public static double SPEED = 1.0D;
/*     */   
/*  36 */   public static int speedToggle = 0;
/*     */   
/*     */   public Player(int x, int y, int mx, int my, ImageManager im) {
/*  39 */     playerX = x;
/*  40 */     playerY = y;
/*  41 */     mapX = mx;
/*  42 */     mapY = my;
/*  43 */     this.im = im;
/*     */   }
/*     */   
/*     */   public void tick() {
/*  48 */     tileX = ((int)playerX + 0 + (int)mapX) / 32 - 12;
/*  49 */     tileY = ((int)playerY + 0 + (int)mapY) / 32 - 8;
/*  51 */     if (mapMovement) {
/*  55 */       if (up && playerY >= 1.0F && canMoveUp == 1) {
/*  57 */         if (mapY <= 263.0F) {
/*  58 */           playerY = (float)(playerY - SPEED);
/*  59 */         } else if (catchingUp != 1 && 
/*  60 */           playerY <= Game.playerSpawnY) {
/*  61 */           mapY = (float)(mapY - SPEED);
/*     */         } 
/*  64 */         this.upCount++;
/*  65 */         pUp = true;
/*  66 */         lastDir = 1;
/*  68 */         if (this.upCount == 42)
/*  69 */           this.upCount = 1; 
/*     */       } else {
/*  72 */         this.upCount = 0;
/*  73 */         pUp = false;
/*  75 */         if (pDown && playerY <= Game.playerSpawnY) {
/*  76 */           playerY = (float)(playerY + SPEED);
/*  77 */           catchingUp = 1;
/*     */         } else {
/*  79 */           catchingUp = 0;
/*     */         } 
/*     */       } 
/*  84 */       if (down && playerY <= 511.0F && canMoveDown == 1) {
/*  86 */         if (mapY >= 775.0F) {
/*  87 */           playerY = (float)(playerY + SPEED);
/*  88 */         } else if (catchingUp != 3 && 
/*  89 */           playerY >= Game.playerSpawnY) {
/*  90 */           mapY = (float)(mapY + SPEED);
/*     */         } 
/*  93 */         this.downCount++;
/*  94 */         pDown = true;
/*  95 */         lastDir = 3;
/*  97 */         if (this.downCount == 42)
/*  98 */           this.downCount = 1; 
/*     */       } else {
/* 101 */         this.downCount = 0;
/* 102 */         pDown = false;
/* 104 */         if (pUp && playerY >= Game.playerSpawnY) {
/* 105 */           playerY = (float)(playerY - SPEED);
/* 106 */           catchingUp = 3;
/*     */         } else {
/* 108 */           catchingUp = 0;
/*     */         } 
/*     */       } 
/* 113 */       if (left && playerX >= 0.0F && canMoveLeft == 1) {
/* 115 */         if (mapX <= 398.0F) {
/* 116 */           playerX = (float)(playerX - SPEED);
/* 117 */         } else if (catchingUp != 4 && 
/* 118 */           playerX <= Game.playerSpawnX) {
/* 119 */           mapX = (float)(mapX - SPEED);
/*     */         } 
/* 122 */         this.leftCount++;
/* 123 */         pLeft = true;
/* 124 */         lastDir = 4;
/* 126 */         if (this.leftCount == 42)
/* 127 */           this.leftCount = 1; 
/*     */       } else {
/* 131 */         this.leftCount = 0;
/* 132 */         pLeft = false;
/* 134 */         if (pRight && playerX <= Game.playerSpawnX) {
/* 135 */           playerX = (float)(playerX + SPEED);
/* 136 */           catchingUp = 4;
/*     */         } else {
/* 138 */           catchingUp = 0;
/*     */         } 
/*     */       } 
/* 143 */       if (right && playerX <= 801.0F && canMoveRight == 1) {
/* 145 */         if (mapX >= 1198.0F) {
/* 146 */           playerX = (float)(playerX + SPEED);
/* 147 */         } else if (catchingUp != 2 && 
/* 148 */           playerX >= Game.playerSpawnX) {
/* 149 */           mapX = (float)(mapX + SPEED);
/*     */         } 
/* 152 */         this.rightCount++;
/* 153 */         pRight = true;
/* 154 */         lastDir = 2;
/* 156 */         if (this.rightCount == 42)
/* 157 */           this.rightCount = 1; 
/*     */       } else {
/* 161 */         this.rightCount = 0;
/* 162 */         pRight = false;
/* 164 */         if (pLeft && playerX >= Game.playerSpawnX) {
/* 165 */           playerX = (float)(playerX - SPEED);
/* 166 */           catchingUp = 2;
/*     */         } else {
/* 168 */           catchingUp = 0;
/*     */         } 
/*     */       } 
/*     */     } 
/* 173 */     if (insideMovement) {
/* 175 */       if (up && playerY >= 125.0F && canMoveUp == 1) {
/* 176 */         playerY = (float)(playerY - SPEED);
/* 177 */         this.upCount++;
/* 178 */         pUp = true;
/* 179 */         lastDir = 1;
/* 181 */         if (this.upCount == 42)
/* 182 */           this.upCount = 1; 
/*     */       } else {
/* 185 */         this.upCount = 0;
/* 186 */         pUp = false;
/*     */       } 
/* 189 */       if (down && playerY <= 423.0F && canMoveDown == 1) {
/* 190 */         playerY = (float)(playerY + SPEED);
/* 191 */         this.downCount++;
/* 192 */         pDown = true;
/* 193 */         lastDir = 3;
/* 195 */         if (this.downCount == 42)
/* 196 */           this.downCount = 1; 
/*     */       } else {
/* 199 */         this.downCount = 0;
/* 200 */         pDown = false;
/*     */       } 
/* 203 */       if (left && playerX >= 194.0F && canMoveLeft == 1) {
/* 204 */         playerX = (float)(playerX - SPEED);
/* 205 */         this.leftCount++;
/* 206 */         pLeft = true;
/* 207 */         lastDir = 4;
/* 209 */         if (this.leftCount == 42)
/* 210 */           this.leftCount = 1; 
/*     */       } else {
/* 214 */         this.leftCount = 0;
/* 215 */         pLeft = false;
/*     */       } 
/* 218 */       if (right && playerX <= 612.0F && canMoveRight == 1) {
/* 219 */         playerX = (float)(playerX + SPEED);
/* 220 */         this.rightCount++;
/* 221 */         pRight = true;
/* 222 */         lastDir = 2;
/* 224 */         if (this.rightCount == 42)
/* 225 */           this.rightCount = 1; 
/*     */       } else {
/* 229 */         this.rightCount = 0;
/* 230 */         pRight = false;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void render(Graphics g) {
/* 243 */     if (this.downCount >= 1 && this.downCount <= 11)
/* 244 */       g.drawImage(this.im.playerd1, (int)playerX, (int)playerY, 
/* 245 */           32, 32, null); 
/* 248 */     if (this.downCount >= 12 && this.downCount <= 21)
/* 249 */       g.drawImage(this.im.playerd2, (int)playerX, (int)playerY, 
/* 250 */           32, 32, null); 
/* 253 */     if (this.downCount >= 22 && this.downCount <= 31)
/* 254 */       g.drawImage(this.im.playerd3, (int)playerX, (int)playerY, 
/* 255 */           32, 32, null); 
/* 258 */     if (this.downCount >= 32 && this.downCount <= 41)
/* 259 */       g.drawImage(this.im.playerd4, (int)playerX, (int)playerY, 
/* 260 */           32, 32, null); 
/* 269 */     if (this.upCount >= 1 && this.upCount <= 11)
/* 270 */       g.drawImage(this.im.playeru1, (int)playerX, (int)playerY, 
/* 271 */           32, 32, null); 
/* 274 */     if (this.upCount >= 12 && this.upCount <= 21)
/* 275 */       g.drawImage(this.im.playeru2, (int)playerX, (int)playerY, 
/* 276 */           32, 32, null); 
/* 279 */     if (this.upCount >= 22 && this.upCount <= 31)
/* 280 */       g.drawImage(this.im.playeru3, (int)playerX, (int)playerY, 
/* 281 */           32, 32, null); 
/* 284 */     if (this.upCount >= 32 && this.upCount <= 41)
/* 285 */       g.drawImage(this.im.playeru4, (int)playerX, (int)playerY, 
/* 286 */           32, 32, null); 
/* 295 */     if (this.leftCount >= 1 && this.leftCount <= 11)
/* 296 */       g.drawImage(this.im.playerl1, (int)playerX, (int)playerY, 
/* 297 */           32, 32, null); 
/* 300 */     if (this.leftCount >= 12 && this.leftCount <= 21)
/* 301 */       g.drawImage(this.im.playerl2, (int)playerX, (int)playerY, 
/* 302 */           32, 32, null); 
/* 305 */     if (this.leftCount >= 22 && this.leftCount <= 31)
/* 306 */       g.drawImage(this.im.playerl3, (int)playerX, (int)playerY, 
/* 307 */           32, 32, null); 
/* 310 */     if (this.leftCount >= 32 && this.leftCount <= 41)
/* 311 */       g.drawImage(this.im.playerl4, (int)playerX, (int)playerY, 
/* 312 */           32, 32, null); 
/* 321 */     if (this.rightCount >= 1 && this.rightCount <= 11)
/* 322 */       g.drawImage(this.im.playerr1, (int)playerX, (int)playerY, 
/* 323 */           32, 32, null); 
/* 326 */     if (this.rightCount >= 12 && this.rightCount <= 21)
/* 327 */       g.drawImage(this.im.playerr2, (int)playerX, (int)playerY, 
/* 328 */           32, 32, null); 
/* 331 */     if (this.rightCount >= 22 && this.rightCount <= 31)
/* 332 */       g.drawImage(this.im.playerr3, (int)playerX, (int)playerY, 
/* 333 */           32, 32, null); 
/* 336 */     if (this.rightCount >= 32 && this.rightCount <= 41)
/* 337 */       g.drawImage(this.im.playerr4, (int)playerX, (int)playerY, 
/* 338 */           32, 32, null); 
/* 345 */     if (!pUp && !pDown && !pLeft && !pRight && 
/* 346 */       lastDir == 0)
/* 347 */       g.drawImage(this.im.playerd1, (int)playerX, (int)playerY, 
/* 348 */           32, 32, null); 
/* 351 */     if (!pRight && lastDir == 2)
/* 352 */       g.drawImage(this.im.playerr1, (int)playerX, (int)playerY, 
/* 353 */           32, 32, null); 
/* 356 */     if (!pLeft && lastDir == 4)
/* 357 */       g.drawImage(this.im.playerl1, (int)playerX, (int)playerY, 
/* 358 */           32, 32, null); 
/* 361 */     if (!pUp && lastDir == 1)
/* 362 */       g.drawImage(this.im.playeru1, (int)playerX, (int)playerY, 
/* 363 */           32, 32, null); 
/* 366 */     if (!pDown && lastDir == 3)
/* 367 */       g.drawImage(this.im.playerd1, (int)playerX, (int)playerY, 
/* 368 */           32, 32, null); 
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.4.2_4.jar!\applecraft\testgame\main\entities\Player.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */