/*     */ package beyondOrigins.main.entities;
/*     */ 
/*     */ import beyondOrigins.main.Game;
/*     */ import beyondOrigins.main.gfx.ImageManager;
/*     */ import beyondOrigins.threads.Animate;
/*     */ import java.awt.Graphics;
/*     */ 
/*     */ public class Player {
/*  12 */   public static String name = "Roland";
/*     */   
/*  13 */   public static String defaultName = "Roland";
/*     */   
/*  14 */   public static String typedName = "";
/*     */   
/*  17 */   public static double health = 35.0D;
/*     */   
/*  20 */   public static double damage = 1.5D;
/*     */   
/*  23 */   public static short upCount = 1;
/*     */   
/*  24 */   public static short leftCount = 1;
/*     */   
/*  25 */   public static short rightCount = 1;
/*     */   
/*  26 */   public static short downCount = 1;
/*     */   
/*  29 */   public static short canMoveUp = 1;
/*     */   
/*  30 */   public static short canMoveDown = 1;
/*     */   
/*  31 */   public static short canMoveLeft = 1;
/*     */   
/*  32 */   public static short canMoveRight = 1;
/*     */   
/*  33 */   public static float playerX = 0.0F;
/*     */   
/*  34 */   public static float playerY = 0.0F;
/*     */   
/*     */   public static short lastDir;
/*     */   
/*     */   public static short catchingUp;
/*     */   
/*     */   public static boolean up = false;
/*     */   
/*     */   public static boolean down = false;
/*     */   
/*     */   public static boolean left = false;
/*     */   
/*     */   public static boolean right = false;
/*     */   
/*  41 */   public static double SPEED = 1.0D;
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
/*     */   public static float mapX;
/*     */   
/*     */   public static float mapY;
/*     */   
/*  50 */   public static int mbX = 1235;
/*     */   
/*  50 */   public static int mbY = 814;
/*     */   
/*  50 */   public static int pbX = 801;
/*     */   
/*  50 */   public static int pbY = 1;
/*     */   
/*     */   public static int tileX;
/*     */   
/*     */   public static int tileY;
/*     */   
/*     */   private ImageManager im;
/*     */   
/*     */   public Player(int x, int y, int mx, int my, ImageManager im) {
/*  58 */     playerX = x;
/*  59 */     playerY = y;
/*  60 */     mapX = mx;
/*  61 */     mapY = my;
/*  62 */     this.im = im;
/*     */   }
/*     */   
/*     */   public void tick() {
/*  67 */     tileX = ((int)playerX + (int)mapX) / 32 - 12;
/*  68 */     tileY = ((int)playerY + (int)mapY) / 32 - 8;
/*  71 */     if (mapX > mbX)
/*  72 */       mapX = mbX; 
/*  74 */     if (mapX < Game.playerSpawnX)
/*  75 */       mapX = Game.playerSpawnX; 
/*  77 */     if (mapY > mbY)
/*  78 */       mapY = mbY; 
/*  80 */     if (mapY < Game.playerSpawnY)
/*  81 */       mapY = Game.playerSpawnY; 
/*  85 */     if (mapMovement)
/*  86 */       mapMovement(); 
/*  88 */     if (insideMovement)
/*  89 */       insideMovement(); 
/*     */   }
/*     */   
/*     */   public void mapMovement() {
/*  95 */     if (up && playerY >= pbY && canMoveUp == 1) {
/*  96 */       if (mapY <= Game.playerSpawnY) {
/*  97 */         playerY = (float)(playerY - SPEED);
/*  98 */       } else if (catchingUp != 1 && playerY <= Game.playerSpawnY) {
/*  99 */         mapY = (float)(mapY - SPEED);
/*     */       } 
/* 101 */       upCount = (short)(int)(upCount + SPEED);
/* 102 */       isMovingUp = true;
/* 103 */       lastDir = 1;
/* 104 */       if (upCount >= 42)
/* 105 */         upCount = 1; 
/*     */     } else {
/* 108 */       upCount = 0;
/* 109 */       isMovingUp = false;
/* 110 */       if (isMovingDown && playerY <= Game.playerSpawnY) {
/* 111 */         playerY = (float)(playerY + SPEED);
/* 112 */         catchingUp = 1;
/*     */       } else {
/* 114 */         catchingUp = 0;
/*     */       } 
/*     */     } 
/* 118 */     if (down && playerY <= 511.0F && canMoveDown == 1) {
/* 119 */       if (mapY >= mbY) {
/* 120 */         playerY = (float)(playerY + SPEED);
/* 121 */       } else if (catchingUp != 3 && playerY >= Game.playerSpawnY) {
/* 122 */         mapY = (float)(mapY + SPEED);
/*     */       } 
/* 124 */       downCount = (short)(int)(downCount + SPEED);
/* 125 */       isMovingDown = true;
/* 126 */       lastDir = 3;
/* 127 */       if (downCount >= 42)
/* 128 */         downCount = 1; 
/*     */     } else {
/* 131 */       downCount = 0;
/* 132 */       isMovingDown = false;
/* 133 */       if (isMovingUp && playerY >= Game.playerSpawnY) {
/* 134 */         playerY = (float)(playerY - SPEED);
/* 135 */         catchingUp = 3;
/*     */       } else {
/* 137 */         catchingUp = 0;
/*     */       } 
/*     */     } 
/* 141 */     if (left && playerX >= 0.0F && canMoveLeft == 1) {
/* 142 */       if (mapX <= Game.playerSpawnX) {
/* 143 */         playerX = (float)(playerX - SPEED);
/* 144 */       } else if (catchingUp != 4 && playerX <= Game.playerSpawnX) {
/* 145 */         mapX = (float)(mapX - SPEED);
/*     */       } 
/* 147 */       leftCount = (short)(int)(leftCount + SPEED);
/* 148 */       isMovingLeft = true;
/* 149 */       lastDir = 4;
/* 150 */       if (leftCount >= 42)
/* 151 */         leftCount = 1; 
/*     */     } else {
/* 154 */       leftCount = 0;
/* 155 */       isMovingLeft = false;
/* 156 */       if (isMovingRight && playerX <= Game.playerSpawnX) {
/* 157 */         playerX = (float)(playerX + SPEED);
/* 158 */         catchingUp = 4;
/*     */       } else {
/* 160 */         catchingUp = 0;
/*     */       } 
/*     */     } 
/* 164 */     if (right && playerX <= pbX && canMoveRight == 1) {
/* 165 */       if (mapX >= mbX) {
/* 166 */         playerX = (float)(playerX + SPEED);
/* 167 */       } else if (catchingUp != 2 && playerX >= Game.playerSpawnX) {
/* 168 */         mapX = (float)(mapX + SPEED);
/*     */       } 
/* 170 */       rightCount = (short)(int)(rightCount + SPEED);
/* 171 */       isMovingRight = true;
/* 172 */       lastDir = 2;
/* 173 */       if (rightCount >= 42)
/* 174 */         rightCount = 1; 
/*     */     } else {
/* 177 */       rightCount = 0;
/* 178 */       isMovingRight = false;
/* 179 */       if (isMovingLeft && playerX >= Game.playerSpawnX) {
/* 180 */         playerX = (float)(playerX - SPEED);
/* 181 */         catchingUp = 2;
/*     */       } else {
/* 183 */         catchingUp = 0;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void insideMovement() {
/* 189 */     if (up && playerY >= 125.0F && canMoveUp == 1) {
/* 190 */       playerY = (float)(playerY - SPEED);
/* 191 */       upCount = (short)(upCount + 1);
/* 192 */       isMovingUp = true;
/* 193 */       lastDir = 1;
/* 194 */       if (upCount == 42)
/* 195 */         upCount = 1; 
/*     */     } else {
/* 198 */       upCount = 0;
/* 199 */       isMovingUp = false;
/*     */     } 
/* 201 */     if (down && playerY <= 423.0F && canMoveDown == 1) {
/* 202 */       playerY = (float)(playerY + SPEED);
/* 203 */       downCount = (short)(downCount + 1);
/* 204 */       isMovingDown = true;
/* 205 */       lastDir = 3;
/* 206 */       if (downCount == 42)
/* 207 */         downCount = 1; 
/*     */     } else {
/* 210 */       downCount = 0;
/* 211 */       isMovingDown = false;
/*     */     } 
/* 213 */     if (left && playerX >= 194.0F && canMoveLeft == 1) {
/* 214 */       playerX = (float)(playerX - SPEED);
/* 215 */       leftCount = (short)(leftCount + 1);
/* 216 */       isMovingLeft = true;
/* 217 */       lastDir = 4;
/* 218 */       if (leftCount == 42)
/* 219 */         leftCount = 1; 
/*     */     } else {
/* 222 */       leftCount = 0;
/* 223 */       isMovingLeft = false;
/*     */     } 
/* 225 */     if (right && playerX <= 612.0F && canMoveRight == 1) {
/* 226 */       playerX = (float)(playerX + SPEED);
/* 227 */       rightCount = (short)(rightCount + 1);
/* 228 */       isMovingRight = true;
/* 229 */       lastDir = 2;
/* 230 */       if (rightCount == 42)
/* 231 */         rightCount = 1; 
/*     */     } else {
/* 234 */       rightCount = 0;
/* 235 */       isMovingRight = false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void render(Graphics g) {
/* 241 */     Animate.animateEntity(g, (int)playerX, (int)playerY, this.im.playeru1, 
/* 242 */         this.im.playeru2, this.im.playeru3, this.im.playeru4, upCount);
/* 243 */     Animate.animateEntity(g, (int)playerX, (int)playerY, this.im.playerd1, 
/* 244 */         this.im.playerd2, this.im.playerd3, this.im.playerd4, downCount);
/* 245 */     Animate.animateEntity(g, (int)playerX, (int)playerY, this.im.playerl1, 
/* 246 */         this.im.playerl2, this.im.playerl3, this.im.playerl4, leftCount);
/* 247 */     Animate.animateEntity(g, (int)playerX, (int)playerY, this.im.playerr1, 
/* 248 */         this.im.playerr2, this.im.playerr3, this.im.playerr4, rightCount);
/* 263 */     if (!isMovingUp && !isMovingDown && !isMovingLeft && 
/* 264 */       !isMovingRight && lastDir == 0)
/* 266 */       g.drawImage(this.im.playerd1, (int)playerX, (int)playerY, 32, 32, 
/* 267 */           null); 
/* 269 */     if (!isMovingRight && lastDir == 2)
/* 270 */       g.drawImage(this.im.playerr1, (int)playerX, (int)playerY, 32, 32, 
/* 271 */           null); 
/* 273 */     if (!isMovingLeft && lastDir == 4)
/* 274 */       g.drawImage(this.im.playerl1, (int)playerX, (int)playerY, 32, 32, 
/* 275 */           null); 
/* 277 */     if (!isMovingUp && lastDir == 1)
/* 278 */       g.drawImage(this.im.playeru1, (int)playerX, (int)playerY, 32, 32, 
/* 279 */           null); 
/* 281 */     if (!isMovingDown && lastDir == 3)
/* 282 */       g.drawImage(this.im.playerd1, (int)playerX, (int)playerY, 32, 32, 
/* 283 */           null); 
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.5_3.jar!\beyondOrigins\main\entities\Player.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */