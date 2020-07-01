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
/*     */   public static boolean isMovingUp;
/*     */   
/*     */   public static boolean isMovingDown;
/*     */   
/*     */   public static boolean isMovingRight;
/*     */   
/*     */   public static boolean isMovingLeft;
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
/*  68 */     if (up && playerY >= 1.0F && canMoveUp == 1) {
/*  69 */       if (mapY <= Game.playerSpawnY) {
/*  70 */         playerY = (float)(playerY - SPEED);
/*  71 */       } else if (catchingUp != 1 && playerY <= Game.playerSpawnY) {
/*  72 */         mapY = (float)(mapY - SPEED);
/*     */       } 
/*  74 */       this.upCount++;
/*  75 */       isMovingUp = true;
/*  76 */       lastDir = 1;
/*  77 */       if (this.upCount == 42)
/*  78 */         this.upCount = 1; 
/*     */     } else {
/*  81 */       this.upCount = 0;
/*  82 */       isMovingUp = false;
/*  83 */       if (isMovingDown && playerY <= Game.playerSpawnY) {
/*  84 */         playerY = (float)(playerY + SPEED);
/*  85 */         catchingUp = 1;
/*     */       } else {
/*  87 */         catchingUp = 0;
/*     */       } 
/*     */     } 
/*  91 */     if (down && playerY <= 511.0F && canMoveDown == 1) {
/*  92 */       if (mapY >= 814.0F) {
/*  93 */         playerY = (float)(playerY + SPEED);
/*  94 */       } else if (catchingUp != 3 && playerY >= Game.playerSpawnY) {
/*  95 */         mapY = (float)(mapY + SPEED);
/*     */       } 
/*  97 */       this.downCount++;
/*  98 */       isMovingDown = true;
/*  99 */       lastDir = 3;
/* 100 */       if (this.downCount == 42)
/* 101 */         this.downCount = 1; 
/*     */     } else {
/* 104 */       this.downCount = 0;
/* 105 */       isMovingDown = false;
/* 106 */       if (isMovingUp && playerY >= Game.playerSpawnY) {
/* 107 */         playerY = (float)(playerY - SPEED);
/* 108 */         catchingUp = 3;
/*     */       } else {
/* 110 */         catchingUp = 0;
/*     */       } 
/*     */     } 
/* 114 */     if (left && playerX >= 0.0F && canMoveLeft == 1) {
/* 115 */       if (mapX <= Game.playerSpawnX) {
/* 116 */         playerX = (float)(playerX - SPEED);
/* 117 */       } else if (catchingUp != 4 && playerX <= Game.playerSpawnX) {
/* 118 */         mapX = (float)(mapX - SPEED);
/*     */       } 
/* 120 */       this.leftCount++;
/* 121 */       isMovingLeft = true;
/* 122 */       lastDir = 4;
/* 123 */       if (this.leftCount == 42)
/* 124 */         this.leftCount = 1; 
/*     */     } else {
/* 127 */       this.leftCount = 0;
/* 128 */       isMovingLeft = false;
/* 129 */       if (isMovingRight && playerX <= Game.playerSpawnX) {
/* 130 */         playerX = (float)(playerX + SPEED);
/* 131 */         catchingUp = 4;
/*     */       } else {
/* 133 */         catchingUp = 0;
/*     */       } 
/*     */     } 
/* 137 */     if (right && playerX <= 801.0F && canMoveRight == 1) {
/* 138 */       if (mapX >= 1235.0F) {
/* 139 */         playerX = (float)(playerX + SPEED);
/* 140 */       } else if (catchingUp != 2 && playerX >= Game.playerSpawnX) {
/* 141 */         mapX = (float)(mapX + SPEED);
/*     */       } 
/* 143 */       this.rightCount++;
/* 144 */       isMovingRight = true;
/* 145 */       lastDir = 2;
/* 146 */       if (this.rightCount == 42)
/* 147 */         this.rightCount = 1; 
/*     */     } else {
/* 150 */       this.rightCount = 0;
/* 151 */       isMovingRight = false;
/* 152 */       if (isMovingLeft && playerX >= Game.playerSpawnX) {
/* 153 */         playerX = (float)(playerX - SPEED);
/* 154 */         catchingUp = 2;
/*     */       } else {
/* 156 */         catchingUp = 0;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void insideMovement() {
/* 162 */     if (up && playerY >= 125.0F && canMoveUp == 1) {
/* 163 */       playerY = (float)(playerY - SPEED);
/* 164 */       this.upCount++;
/* 165 */       isMovingUp = true;
/* 166 */       lastDir = 1;
/* 167 */       if (this.upCount == 42)
/* 168 */         this.upCount = 1; 
/*     */     } else {
/* 171 */       this.upCount = 0;
/* 172 */       isMovingUp = false;
/*     */     } 
/* 174 */     if (down && playerY <= 423.0F && canMoveDown == 1) {
/* 175 */       playerY = (float)(playerY + SPEED);
/* 176 */       this.downCount++;
/* 177 */       isMovingDown = true;
/* 178 */       lastDir = 3;
/* 179 */       if (this.downCount == 42)
/* 180 */         this.downCount = 1; 
/*     */     } else {
/* 183 */       this.downCount = 0;
/* 184 */       isMovingDown = false;
/*     */     } 
/* 186 */     if (left && playerX >= 194.0F && canMoveLeft == 1) {
/* 187 */       playerX = (float)(playerX - SPEED);
/* 188 */       this.leftCount++;
/* 189 */       isMovingLeft = true;
/* 190 */       lastDir = 4;
/* 191 */       if (this.leftCount == 42)
/* 192 */         this.leftCount = 1; 
/*     */     } else {
/* 195 */       this.leftCount = 0;
/* 196 */       isMovingLeft = false;
/*     */     } 
/* 198 */     if (right && playerX <= 612.0F && canMoveRight == 1) {
/* 199 */       playerX = (float)(playerX + SPEED);
/* 200 */       this.rightCount++;
/* 201 */       isMovingRight = true;
/* 202 */       lastDir = 2;
/* 203 */       if (this.rightCount == 42)
/* 204 */         this.rightCount = 1; 
/*     */     } else {
/* 207 */       this.rightCount = 0;
/* 208 */       isMovingRight = false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void render(Graphics g) {
/* 213 */     if (this.downCount >= 1 && this.downCount <= 11)
/* 214 */       g.drawImage(this.im.playerd1, (int)playerX, (int)playerY, 32, 32, 
/* 215 */           null); 
/* 217 */     if (this.downCount >= 12 && this.downCount <= 21)
/* 218 */       g.drawImage(this.im.playerd2, (int)playerX, (int)playerY, 32, 32, 
/* 219 */           null); 
/* 221 */     if (this.downCount >= 22 && this.downCount <= 31)
/* 222 */       g.drawImage(this.im.playerd3, (int)playerX, (int)playerY, 32, 32, 
/* 223 */           null); 
/* 225 */     if (this.downCount >= 32 && this.downCount <= 41)
/* 226 */       g.drawImage(this.im.playerd4, (int)playerX, (int)playerY, 32, 32, 
/* 227 */           null); 
/* 229 */     if (this.upCount >= 1 && this.upCount <= 11)
/* 230 */       g.drawImage(this.im.playeru1, (int)playerX, (int)playerY, 32, 32, 
/* 231 */           null); 
/* 233 */     if (this.upCount >= 12 && this.upCount <= 21)
/* 234 */       g.drawImage(this.im.playeru2, (int)playerX, (int)playerY, 32, 32, 
/* 235 */           null); 
/* 237 */     if (this.upCount >= 22 && this.upCount <= 31)
/* 238 */       g.drawImage(this.im.playeru3, (int)playerX, (int)playerY, 32, 32, 
/* 239 */           null); 
/* 241 */     if (this.upCount >= 32 && this.upCount <= 41)
/* 242 */       g.drawImage(this.im.playeru4, (int)playerX, (int)playerY, 32, 32, 
/* 243 */           null); 
/* 245 */     if (this.leftCount >= 1 && this.leftCount <= 11)
/* 246 */       g.drawImage(this.im.playerl1, (int)playerX, (int)playerY, 32, 32, 
/* 247 */           null); 
/* 249 */     if (this.leftCount >= 12 && this.leftCount <= 21)
/* 250 */       g.drawImage(this.im.playerl2, (int)playerX, (int)playerY, 32, 32, 
/* 251 */           null); 
/* 253 */     if (this.leftCount >= 22 && this.leftCount <= 31)
/* 254 */       g.drawImage(this.im.playerl3, (int)playerX, (int)playerY, 32, 32, 
/* 255 */           null); 
/* 257 */     if (this.leftCount >= 32 && this.leftCount <= 41)
/* 258 */       g.drawImage(this.im.playerl4, (int)playerX, (int)playerY, 32, 32, 
/* 259 */           null); 
/* 261 */     if (this.rightCount >= 1 && this.rightCount <= 11)
/* 262 */       g.drawImage(this.im.playerr1, (int)playerX, (int)playerY, 32, 32, 
/* 263 */           null); 
/* 265 */     if (this.rightCount >= 12 && this.rightCount <= 21)
/* 266 */       g.drawImage(this.im.playerr2, (int)playerX, (int)playerY, 32, 32, 
/* 267 */           null); 
/* 269 */     if (this.rightCount >= 22 && this.rightCount <= 31)
/* 270 */       g.drawImage(this.im.playerr3, (int)playerX, (int)playerY, 32, 32, 
/* 271 */           null); 
/* 273 */     if (this.rightCount >= 32 && this.rightCount <= 41)
/* 274 */       g.drawImage(this.im.playerr4, (int)playerX, (int)playerY, 32, 32, 
/* 275 */           null); 
/* 277 */     if (!isMovingUp && !isMovingDown && !isMovingLeft && !isMovingRight && lastDir == 0)
/* 278 */       g.drawImage(this.im.playerd1, (int)playerX, (int)playerY, 32, 32, 
/* 279 */           null); 
/* 281 */     if (!isMovingRight && lastDir == 2)
/* 282 */       g.drawImage(this.im.playerr1, (int)playerX, (int)playerY, 32, 32, 
/* 283 */           null); 
/* 285 */     if (!isMovingLeft && lastDir == 4)
/* 286 */       g.drawImage(this.im.playerl1, (int)playerX, (int)playerY, 32, 32, 
/* 287 */           null); 
/* 289 */     if (!isMovingUp && lastDir == 1)
/* 290 */       g.drawImage(this.im.playeru1, (int)playerX, (int)playerY, 32, 32, 
/* 291 */           null); 
/* 293 */     if (!isMovingDown && lastDir == 3)
/* 294 */       g.drawImage(this.im.playerd1, (int)playerX, (int)playerY, 32, 32, 
/* 295 */           null); 
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.5_1.jar!\beyondOrigins\main\entities\Player.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */