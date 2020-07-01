/*     */ package beyondOrigins.main.entities;
/*     */ 
/*     */ import beyondOrigins.main.Game;
/*     */ import beyondOrigins.main.gfx.ImageManager;
/*     */ import java.awt.Graphics;
/*     */ 
/*     */ public class Player {
/*  10 */   private int upCount = 1;
/*     */   
/*  11 */   private int leftCount = 1;
/*     */   
/*  12 */   private int rightCount = 1;
/*     */   
/*  13 */   private int downCount = 1;
/*     */   
/*  15 */   public static int canMoveUp = 1;
/*     */   
/*  16 */   public static int canMoveDown = 1;
/*     */   
/*  17 */   public static int canMoveLeft = 1;
/*     */   
/*  18 */   public static int canMoveRight = 1;
/*     */   
/*  19 */   public static float playerX = 0.0F;
/*     */   
/*  20 */   public static float playerY = 0.0F;
/*     */   
/*  21 */   public static int lastDir = 0;
/*     */   
/*  22 */   public static int catchingUp = 0;
/*     */   
/*     */   public static boolean up = false;
/*     */   
/*     */   public static boolean down = false;
/*     */   
/*     */   public static boolean left = false;
/*     */   
/*     */   public static boolean right = false;
/*     */   
/*  29 */   public static double SPEED = 1.0D;
/*     */   
/*  30 */   public static int speedToggle = 0;
/*     */   
/*     */   public static boolean pUp;
/*     */   
/*     */   public static boolean pDown;
/*     */   
/*     */   public static boolean pRight;
/*     */   
/*     */   public static boolean pLeft;
/*     */   
/*     */   public static boolean mapMovement = true;
/*     */   
/*     */   public static boolean insideMovement;
/*     */   
/*  40 */   public static float mapX = 0.0F;
/*     */   
/*  41 */   public static float mapY = 0.0F;
/*     */   
/*     */   public static int tileX;
/*     */   
/*     */   public static int tileY;
/*     */   
/*     */   private ImageManager im;
/*     */   
/*     */   public Player(int x, int y, int mx, int my, ImageManager im) {
/*  48 */     playerX = x;
/*  49 */     playerY = y;
/*  50 */     mapX = mx;
/*  51 */     mapY = my;
/*  52 */     this.im = im;
/*     */   }
/*     */   
/*     */   public void tick() {
/*  56 */     tileX = ((int)playerX + (int)mapX) / 32 - 12;
/*  57 */     tileY = ((int)playerY + (int)mapY) / 32 - 8;
/*  58 */     if (mapMovement)
/*  59 */       mapMovement(); 
/*  61 */     if (insideMovement)
/*  62 */       insideMovement(); 
/*     */   }
/*     */   
/*     */   public void mapMovement() {
/*  67 */     if (up && playerY >= 1.0F && canMoveUp == 1) {
/*  68 */       if (mapY <= 263.0F) {
/*  69 */         playerY = (float)(playerY - SPEED);
/*  70 */       } else if (catchingUp != 1 && playerY <= Game.playerSpawnY) {
/*  71 */         mapY = (float)(mapY - SPEED);
/*     */       } 
/*  73 */       this.upCount++;
/*  74 */       pUp = true;
/*  75 */       lastDir = 1;
/*  76 */       if (this.upCount == 42)
/*  77 */         this.upCount = 1; 
/*     */     } else {
/*  80 */       this.upCount = 0;
/*  81 */       pUp = false;
/*  82 */       if (pDown && playerY <= Game.playerSpawnY) {
/*  83 */         playerY = (float)(playerY + SPEED);
/*  84 */         catchingUp = 1;
/*     */       } else {
/*  86 */         catchingUp = 0;
/*     */       } 
/*     */     } 
/*  89 */     if (down && playerY <= 511.0F && canMoveDown == 1) {
/*  90 */       if (mapY >= 807.0F) {
/*  91 */         playerY = (float)(playerY + SPEED);
/*  92 */       } else if (catchingUp != 3 && playerY >= Game.playerSpawnY) {
/*  93 */         mapY = (float)(mapY + SPEED);
/*     */       } 
/*  95 */       this.downCount++;
/*  96 */       pDown = true;
/*  97 */       lastDir = 3;
/*  98 */       if (this.downCount == 42)
/*  99 */         this.downCount = 1; 
/*     */     } else {
/* 102 */       this.downCount = 0;
/* 103 */       pDown = false;
/* 104 */       if (pUp && playerY >= Game.playerSpawnY) {
/* 105 */         playerY = (float)(playerY - SPEED);
/* 106 */         catchingUp = 3;
/*     */       } else {
/* 108 */         catchingUp = 0;
/*     */       } 
/*     */     } 
/* 111 */     if (left && playerX >= 0.0F && canMoveLeft == 1) {
/* 112 */       if (mapX <= 398.0F) {
/* 113 */         playerX = (float)(playerX - SPEED);
/* 114 */       } else if (catchingUp != 4 && playerX <= Game.playerSpawnX) {
/* 115 */         mapX = (float)(mapX - SPEED);
/*     */       } 
/* 117 */       this.leftCount++;
/* 118 */       pLeft = true;
/* 119 */       lastDir = 4;
/* 120 */       if (this.leftCount == 42)
/* 121 */         this.leftCount = 1; 
/*     */     } else {
/* 124 */       this.leftCount = 0;
/* 125 */       pLeft = false;
/* 126 */       if (pRight && playerX <= Game.playerSpawnX) {
/* 127 */         playerX = (float)(playerX + SPEED);
/* 128 */         catchingUp = 4;
/*     */       } else {
/* 130 */         catchingUp = 0;
/*     */       } 
/*     */     } 
/* 133 */     if (right && playerX <= 801.0F && canMoveRight == 1) {
/* 134 */       if (mapX >= 1230.0D) {
/* 135 */         playerX = (float)(playerX + SPEED);
/* 136 */       } else if (catchingUp != 2 && playerX >= Game.playerSpawnX) {
/* 137 */         mapX = (float)(mapX + SPEED);
/*     */       } 
/* 139 */       this.rightCount++;
/* 140 */       pRight = true;
/* 141 */       lastDir = 2;
/* 142 */       if (this.rightCount == 42)
/* 143 */         this.rightCount = 1; 
/*     */     } else {
/* 146 */       this.rightCount = 0;
/* 147 */       pRight = false;
/* 148 */       if (pLeft && playerX >= Game.playerSpawnX) {
/* 149 */         playerX = (float)(playerX - SPEED);
/* 150 */         catchingUp = 2;
/*     */       } else {
/* 152 */         catchingUp = 0;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void insideMovement() {
/* 158 */     if (up && playerY >= 125.0F && canMoveUp == 1) {
/* 159 */       playerY = (float)(playerY - SPEED);
/* 160 */       this.upCount++;
/* 161 */       pUp = true;
/* 162 */       lastDir = 1;
/* 163 */       if (this.upCount == 42)
/* 164 */         this.upCount = 1; 
/*     */     } else {
/* 167 */       this.upCount = 0;
/* 168 */       pUp = false;
/*     */     } 
/* 170 */     if (down && playerY <= 423.0F && canMoveDown == 1) {
/* 171 */       playerY = (float)(playerY + SPEED);
/* 172 */       this.downCount++;
/* 173 */       pDown = true;
/* 174 */       lastDir = 3;
/* 175 */       if (this.downCount == 42)
/* 176 */         this.downCount = 1; 
/*     */     } else {
/* 179 */       this.downCount = 0;
/* 180 */       pDown = false;
/*     */     } 
/* 182 */     if (left && playerX >= 194.0F && canMoveLeft == 1) {
/* 183 */       playerX = (float)(playerX - SPEED);
/* 184 */       this.leftCount++;
/* 185 */       pLeft = true;
/* 186 */       lastDir = 4;
/* 187 */       if (this.leftCount == 42)
/* 188 */         this.leftCount = 1; 
/*     */     } else {
/* 191 */       this.leftCount = 0;
/* 192 */       pLeft = false;
/*     */     } 
/* 194 */     if (right && playerX <= 612.0F && canMoveRight == 1) {
/* 195 */       playerX = (float)(playerX + SPEED);
/* 196 */       this.rightCount++;
/* 197 */       pRight = true;
/* 198 */       lastDir = 2;
/* 199 */       if (this.rightCount == 42)
/* 200 */         this.rightCount = 1; 
/*     */     } else {
/* 203 */       this.rightCount = 0;
/* 204 */       pRight = false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void render(Graphics g) {
/* 209 */     if (this.downCount >= 1 && this.downCount <= 11)
/* 210 */       g.drawImage(this.im.playerd1, (int)playerX, (int)playerY, 32, 32, 
/* 211 */           null); 
/* 213 */     if (this.downCount >= 12 && this.downCount <= 21)
/* 214 */       g.drawImage(this.im.playerd2, (int)playerX, (int)playerY, 32, 32, 
/* 215 */           null); 
/* 217 */     if (this.downCount >= 22 && this.downCount <= 31)
/* 218 */       g.drawImage(this.im.playerd3, (int)playerX, (int)playerY, 32, 32, 
/* 219 */           null); 
/* 221 */     if (this.downCount >= 32 && this.downCount <= 41)
/* 222 */       g.drawImage(this.im.playerd4, (int)playerX, (int)playerY, 32, 32, 
/* 223 */           null); 
/* 225 */     if (this.upCount >= 1 && this.upCount <= 11)
/* 226 */       g.drawImage(this.im.playeru1, (int)playerX, (int)playerY, 32, 32, 
/* 227 */           null); 
/* 229 */     if (this.upCount >= 12 && this.upCount <= 21)
/* 230 */       g.drawImage(this.im.playeru2, (int)playerX, (int)playerY, 32, 32, 
/* 231 */           null); 
/* 233 */     if (this.upCount >= 22 && this.upCount <= 31)
/* 234 */       g.drawImage(this.im.playeru3, (int)playerX, (int)playerY, 32, 32, 
/* 235 */           null); 
/* 237 */     if (this.upCount >= 32 && this.upCount <= 41)
/* 238 */       g.drawImage(this.im.playeru4, (int)playerX, (int)playerY, 32, 32, 
/* 239 */           null); 
/* 241 */     if (this.leftCount >= 1 && this.leftCount <= 11)
/* 242 */       g.drawImage(this.im.playerl1, (int)playerX, (int)playerY, 32, 32, 
/* 243 */           null); 
/* 245 */     if (this.leftCount >= 12 && this.leftCount <= 21)
/* 246 */       g.drawImage(this.im.playerl2, (int)playerX, (int)playerY, 32, 32, 
/* 247 */           null); 
/* 249 */     if (this.leftCount >= 22 && this.leftCount <= 31)
/* 250 */       g.drawImage(this.im.playerl3, (int)playerX, (int)playerY, 32, 32, 
/* 251 */           null); 
/* 253 */     if (this.leftCount >= 32 && this.leftCount <= 41)
/* 254 */       g.drawImage(this.im.playerl4, (int)playerX, (int)playerY, 32, 32, 
/* 255 */           null); 
/* 257 */     if (this.rightCount >= 1 && this.rightCount <= 11)
/* 258 */       g.drawImage(this.im.playerr1, (int)playerX, (int)playerY, 32, 32, 
/* 259 */           null); 
/* 261 */     if (this.rightCount >= 12 && this.rightCount <= 21)
/* 262 */       g.drawImage(this.im.playerr2, (int)playerX, (int)playerY, 32, 32, 
/* 263 */           null); 
/* 265 */     if (this.rightCount >= 22 && this.rightCount <= 31)
/* 266 */       g.drawImage(this.im.playerr3, (int)playerX, (int)playerY, 32, 32, 
/* 267 */           null); 
/* 269 */     if (this.rightCount >= 32 && this.rightCount <= 41)
/* 270 */       g.drawImage(this.im.playerr4, (int)playerX, (int)playerY, 32, 32, 
/* 271 */           null); 
/* 273 */     if (!pUp && !pDown && !pLeft && !pRight && lastDir == 0)
/* 274 */       g.drawImage(this.im.playerd1, (int)playerX, (int)playerY, 32, 32, 
/* 275 */           null); 
/* 277 */     if (!pRight && lastDir == 2)
/* 278 */       g.drawImage(this.im.playerr1, (int)playerX, (int)playerY, 32, 32, 
/* 279 */           null); 
/* 281 */     if (!pLeft && lastDir == 4)
/* 282 */       g.drawImage(this.im.playerl1, (int)playerX, (int)playerY, 32, 32, 
/* 283 */           null); 
/* 285 */     if (!pUp && lastDir == 1)
/* 286 */       g.drawImage(this.im.playeru1, (int)playerX, (int)playerY, 32, 32, 
/* 287 */           null); 
/* 289 */     if (!pDown && lastDir == 3)
/* 290 */       g.drawImage(this.im.playerd1, (int)playerX, (int)playerY, 32, 32, 
/* 291 */           null); 
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.4.9_1.jar!\beyondOrigins\main\entities\Player.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */