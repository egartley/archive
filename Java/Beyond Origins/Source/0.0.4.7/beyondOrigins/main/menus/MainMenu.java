/*     */ package beyondOrigins.main.menus;
/*     */ 
/*     */ import beyondOrigins.main.Game;
/*     */ import beyondOrigins.main.KeyManager;
/*     */ import beyondOrigins.main.Load;
/*     */ import beyondOrigins.main.MouseManager;
/*     */ import beyondOrigins.main.MouseMotion;
/*     */ import beyondOrigins.main.Save;
/*     */ import beyondOrigins.main.gfx.ImageManager;
/*     */ import java.awt.Color;
/*     */ import java.awt.Font;
/*     */ import java.awt.Graphics;
/*     */ import java.io.IOException;
/*     */ import java.util.Random;
/*     */ 
/*     */ public class MainMenu {
/*  19 */   static Random r = new Random();
/*     */   
/*  21 */   public static int menuState = 1;
/*     */   
/*  23 */   private static Font menuText1 = new Font("MoolBoran", 
/*  24 */       0, 23);
/*     */   
/*  25 */   public static String currentProfile = "None";
/*     */   
/*     */   public static boolean canSave1;
/*     */   
/*     */   public static boolean canSave2;
/*     */   
/*     */   public static boolean canSave3;
/*     */   
/*     */   public static int save1State;
/*     */   
/*     */   public static int save2State;
/*     */   
/*     */   public static int save3State;
/*     */   
/*     */   private static int r1;
/*     */   
/*     */   private static int r2;
/*     */   
/*     */   private static int r3;
/*     */   
/*  33 */   Color sky1 = new Color(86, 201, 255);
/*     */   
/*  34 */   Color text1 = new Color(255, 255, 255);
/*     */   
/*  35 */   Color text2 = new Color(236, 210, 120);
/*     */   
/*  36 */   Color text3 = new Color(73, 73, 73);
/*     */   
/*     */   public static double cloud1x;
/*     */   
/*     */   public static double cloud1y;
/*     */   
/*     */   public static double cloud2x;
/*     */   
/*     */   public static double cloud2y;
/*     */   
/*     */   public static double cloud3x;
/*     */   
/*     */   public static double cloud3y;
/*     */   
/*     */   public static boolean playButtonSelected = false;
/*     */   
/*     */   public static boolean loadButtonSelected = false;
/*     */   
/*     */   public static boolean newButtonSelected = false;
/*     */   
/*     */   public static int playState;
/*     */   
/*     */   public static int loadState;
/*     */   
/*     */   public static int newState;
/*     */   
/*  52 */   private static double cSpeed = 0.5D;
/*     */   
/*     */   private ImageManager im;
/*     */   
/*     */   public MainMenu(double x1, double y1, ImageManager im) {
/*  57 */     cloud1x = x1;
/*  58 */     cloud1y = y1;
/*  59 */     this.im = im;
/*     */   }
/*     */   
/*     */   public static void init() {
/*  64 */     r1 = r.nextInt(3);
/*  65 */     r2 = r.nextInt(3);
/*  66 */     r3 = r.nextInt(3);
/*  68 */     if (r1 == 0) {
/*  69 */       cloud1x = 850.0D;
/*  70 */       cloud1y = 160.0D;
/*  71 */     } else if (r1 == 1) {
/*  72 */       cloud1x = 850.0D;
/*  73 */       cloud1y = 200.0D;
/*  74 */     } else if (r1 == 2) {
/*  75 */       cloud1x = 850.0D;
/*  76 */       cloud1y = 220.0D;
/*     */     } 
/*  79 */     if (r2 == 0) {
/*  80 */       cloud2x = 990.0D;
/*  81 */       cloud2y = 2.0D;
/*  82 */     } else if (r2 == 1) {
/*  83 */       cloud2x = 990.0D;
/*  84 */       cloud2y = 22.0D;
/*  85 */     } else if (r2 == 2) {
/*  86 */       cloud2x = 990.0D;
/*  87 */       cloud2y = 42.0D;
/*     */     } 
/*  90 */     if (r3 == 0) {
/*  91 */       cloud3x = -150.0D;
/*  92 */       cloud3y = 315.0D;
/*  93 */     } else if (r3 == 1) {
/*  94 */       cloud3x = -150.0D;
/*  95 */       cloud3y = 340.0D;
/*  96 */     } else if (r3 == 2) {
/*  97 */       cloud3x = -150.0D;
/*  98 */       cloud3y = 365.0D;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void tick() {
/* 104 */     buttonTick();
/* 106 */     if (!Save.save1.exists() || !Save.save2.exists() || !Save.save3.exists()) {
/* 108 */       Save.canMakeNewGame = true;
/* 109 */     } else if (Save.save1.exists() && Save.save2.exists() && Save.save3.exists()) {
/* 111 */       Save.canMakeNewGame = false;
/*     */     } 
/* 114 */     if (!Save.save1.exists() && !Save.save2.exists() && !Save.save3.exists()) {
/* 116 */       Load.canLoadGame = false;
/* 117 */     } else if (Save.save1.exists() || Save.save2.exists() || Save.save3.exists()) {
/* 119 */       Load.canLoadGame = true;
/*     */     } 
/* 123 */     if (cloud1x > -150.0D) {
/* 124 */       cloud1x -= cSpeed + 0.1D;
/*     */     } else {
/* 126 */       cloud1x = 850.0D;
/* 127 */       cloud1y = 200.0D;
/*     */     } 
/* 131 */     if (cloud2x > -125.0D) {
/* 132 */       cloud2x -= cSpeed;
/*     */     } else {
/* 134 */       cloud2x = 990.0D;
/* 135 */       cloud2y = 22.0D;
/*     */     } 
/* 139 */     if (cloud3x <= 828.0D) {
/* 140 */       cloud3x += cSpeed;
/*     */     } else {
/* 142 */       cloud3x = -150.0D;
/* 143 */       cloud3y = 365.0D;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void renderMain(Graphics g) {
/* 151 */     g.setColor(this.sky1);
/* 152 */     g.fillRect(0, 0, 838, 1146);
/* 155 */     g.drawImage(this.im.cloud1, (int)cloud1x, (int)cloud1y, 128, 96, null);
/* 156 */     g.drawImage(this.im.cloud2, (int)cloud2x, (int)cloud2y, 128, 96, null);
/* 157 */     g.drawImage(this.im.cloud3, (int)cloud3x, (int)cloud3y, 128, 96, null);
/* 159 */     if (menuState == 1) {
/* 160 */       renderState1(g);
/* 161 */     } else if (menuState == 2) {
/* 162 */       renderState2(g);
/* 163 */     } else if (menuState == 3) {
/* 164 */       renderState3(g);
/* 165 */     } else if (menuState != 4) {
/*     */     
/*     */     } 
/*     */   }
/*     */   
/*     */   public void buttonTick() {
/* 175 */     if (menuState == 1) {
/* 177 */       if (MouseMotion.mouseX >= 336 && MouseMotion.mouseX <= 491 && 
/* 178 */         MouseMotion.mouseY >= 266 && 
/* 179 */         MouseMotion.mouseY <= 292) {
/* 180 */         playState = 2;
/* 181 */         if (MouseManager.mouseFullClick == 1) {
/* 182 */           playState = 3;
/*     */         } else {
/* 184 */           playState = 2;
/*     */         } 
/*     */       } else {
/* 187 */         playState = 1;
/*     */       } 
/* 190 */       if (MouseMotion.mouseX >= 336 && MouseMotion.mouseX <= 491 && 
/* 191 */         MouseMotion.mouseY >= 304 && 
/* 192 */         MouseMotion.mouseY <= 330 && Load.canLoadGame) {
/* 193 */         loadState = 2;
/* 194 */         if (MouseManager.mouseFullClick == 1) {
/* 195 */           loadState = 3;
/*     */         } else {
/* 197 */           loadState = 2;
/*     */         } 
/*     */       } else {
/* 200 */         loadState = 1;
/*     */       } 
/* 203 */       if (MouseMotion.mouseX >= 336 && MouseMotion.mouseX <= 491 && 
/* 204 */         MouseMotion.mouseY >= 342 && 
/* 205 */         MouseMotion.mouseY <= 370 && Save.canMakeNewGame) {
/* 206 */         newState = 2;
/* 207 */         if (MouseManager.mouseFullClick == 1) {
/* 208 */           newState = 3;
/*     */         } else {
/* 210 */           newState = 2;
/*     */         } 
/*     */       } else {
/* 213 */         newState = 1;
/*     */       } 
/*     */     } 
/* 217 */     if (menuState == 2) {
/* 219 */       if (MouseMotion.mouseX >= 139 && MouseMotion.mouseX <= 295 && 
/* 220 */         MouseMotion.mouseY >= 220 && 
/* 221 */         MouseMotion.mouseY <= 250) {
/* 222 */         save1State = 2;
/* 223 */         if (MouseManager.mouseFullClick == 1) {
/* 224 */           save1State = 3;
/*     */         } else {
/* 226 */           save1State = 2;
/*     */         } 
/*     */       } else {
/* 229 */         save1State = 1;
/*     */       } 
/* 232 */       if (MouseMotion.mouseX >= 339 && MouseMotion.mouseX <= 495 && 
/* 233 */         MouseMotion.mouseY >= 220 && 
/* 234 */         MouseMotion.mouseY <= 250) {
/* 235 */         save2State = 2;
/* 236 */         if (MouseManager.mouseFullClick == 1) {
/* 237 */           save2State = 3;
/*     */         } else {
/* 239 */           save2State = 2;
/*     */         } 
/*     */       } else {
/* 242 */         save2State = 1;
/*     */       } 
/* 245 */       if (MouseMotion.mouseX >= 539 && MouseMotion.mouseX <= 695 && 
/* 246 */         MouseMotion.mouseY >= 220 && 
/* 247 */         MouseMotion.mouseY <= 250) {
/* 248 */         save3State = 2;
/* 249 */         if (MouseManager.mouseFullClick == 1) {
/* 250 */           save3State = 3;
/*     */         } else {
/* 252 */           save3State = 2;
/*     */         } 
/*     */       } else {
/* 255 */         save3State = 1;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void renderState1(Graphics g) {
/* 265 */     g.drawImage(Game.logoImage, 163, -125, 512, 512, null);
/* 268 */     g.setFont(Game.default2);
/* 269 */     g.setColor(Color.white);
/* 270 */     g.drawString(Game.title, 5, 535);
/* 271 */     g.drawString(Game.copyright, 565, 535);
/* 274 */     g.drawImage(this.im.button1_1, 339, 264, 160, 32, null);
/* 275 */     g.setColor(this.text1);
/* 276 */     g.drawString("Play", 400, 285);
/* 278 */     if (Load.canLoadGame) {
/* 279 */       g.drawImage(this.im.button1_1, 339, 304, 160, 32, null);
/* 280 */       g.setColor(this.text1);
/* 281 */       g.drawString("Load Game...", 362, 327);
/*     */     } else {
/* 283 */       g.drawImage(this.im.button1_3, 339, 304, 160, 32, null);
/* 284 */       g.setColor(this.text3);
/* 285 */       g.drawString("Load Game...", 362, 327);
/*     */     } 
/* 288 */     if (Save.canMakeNewGame) {
/* 289 */       g.drawImage(this.im.button1_1, 339, 344, 160, 32, null);
/* 290 */       g.setColor(this.text1);
/* 291 */       g.drawString("New Game...", 362, 367);
/*     */     } else {
/* 293 */       g.drawImage(this.im.button1_3, 339, 344, 160, 32, null);
/* 294 */       g.setColor(this.text3);
/* 295 */       g.drawString("New Game...", 362, 367);
/*     */     } 
/* 299 */     if (playState == 2) {
/* 300 */       g.drawImage(this.im.button1_2, 339, 264, 160, 32, null);
/* 301 */       g.setColor(this.text2);
/* 302 */       g.drawString("Play", 400, 285);
/* 303 */     } else if (playState == 3) {
/* 304 */       Game.isInGame = true;
/* 305 */     } else if (playState == 3) {
/* 306 */       playState = 1;
/* 307 */       Game.isInGame = false;
/*     */     } 
/* 310 */     if (loadState == 2) {
/* 311 */       g.drawImage(this.im.button1_2, 339, 304, 160, 32, null);
/* 312 */       g.setColor(this.text2);
/* 313 */       g.drawString("Load Game...", 362, 327);
/* 314 */     } else if (loadState == 3) {
/* 315 */       g.drawImage(this.im.button1_3, 339, 304, 160, 32, null);
/* 316 */       g.setColor(this.text3);
/* 317 */       g.drawString("Load Game...", 362, 327);
/*     */     } 
/* 320 */     if (newState == 2) {
/* 321 */       g.drawImage(this.im.button1_2, 339, 344, 160, 32, null);
/* 322 */       g.setColor(this.text2);
/* 323 */       g.drawString("New Game...", 362, 367);
/* 324 */     } else if (newState == 3) {
/* 325 */       g.drawImage(this.im.button1_3, 339, 344, 160, 32, null);
/* 326 */       g.setColor(this.text3);
/* 327 */       g.drawString("New Game...", 362, 367);
/* 328 */       menuState = 2;
/*     */     } 
/* 332 */     g.setFont(menuText1);
/* 333 */     g.setColor(Color.darkGray);
/* 334 */     g.drawString("Save Selected: ", 369, 395);
/* 335 */     g.drawString(currentProfile, 399, 412);
/*     */   }
/*     */   
/*     */   public void renderState2(Graphics g) {
/* 343 */     if (KeyManager.escPressed) {
/* 344 */       menuState = 1;
/*     */     } else {
/* 345 */       menuState = 2;
/*     */     } 
/* 348 */     g.setFont(Game.default2);
/* 349 */     g.setColor(Color.darkGray);
/* 350 */     g.drawString("New Game", 365, 95);
/* 352 */     g.drawString("Press ESC to go back", 330, 400);
/* 354 */     g.setFont(Game.default2);
/* 355 */     g.setColor(this.text1);
/* 359 */     if (Save.save1.exists()) {
/* 360 */       canSave1 = false;
/* 361 */       g.drawImage(this.im.button1_3, 139, 220, 160, 
/* 362 */           32, null);
/* 363 */       g.setColor(this.text3);
/* 364 */       g.setFont(Game.default2);
/* 365 */       g.drawString("Save 1", 189, 242);
/* 366 */       g.setFont(menuText1);
/* 367 */       g.drawString("Already Exists!", 170, 280);
/*     */     } else {
/* 369 */       canSave1 = true;
/* 370 */       if (save1State == 2) {
/* 371 */         g.drawImage(this.im.button1_2, 139, 220, 
/* 372 */             160, 32, null);
/* 373 */         g.setColor(this.text2);
/* 374 */         g.setFont(Game.default2);
/* 375 */         g.drawString("Save 1", 189, 242);
/* 376 */         g.setColor(this.text3);
/* 377 */         g.setFont(menuText1);
/* 378 */         g.drawString("Create", 196, 280);
/* 379 */       } else if (save1State == 3) {
/* 380 */         g.drawImage(this.im.button1_3, 139, 220, 
/* 381 */             160, 32, null);
/* 382 */         g.setColor(this.text3);
/* 383 */         g.setFont(Game.default2);
/* 384 */         g.drawString("Save 1", 189, 242);
/*     */         try {
/* 386 */           Save.save1();
/* 387 */         } catch (IOException e) {
/* 388 */           e.printStackTrace();
/*     */         } 
/*     */       } else {
/* 391 */         g.drawImage(this.im.button1_1, 139, 220, 
/* 392 */             160, 32, null);
/* 393 */         g.setColor(this.text1);
/* 394 */         g.setFont(Game.default2);
/* 395 */         g.drawString("Save 1", 189, 242);
/* 396 */         g.setColor(this.text3);
/* 397 */         g.setFont(menuText1);
/* 398 */         g.drawString("Empty", 196, 280);
/*     */       } 
/*     */     } 
/* 405 */     if (Save.save2.exists()) {
/* 406 */       canSave2 = false;
/* 407 */       g.drawImage(this.im.button1_3, 339, 220, 160, 32, null);
/* 408 */       g.setColor(this.text3);
/* 409 */       g.setFont(Game.default2);
/* 410 */       g.drawString("Save 2", 389, 242);
/* 411 */       g.setFont(menuText1);
/* 412 */       g.drawString("Already Exists!", 370, 280);
/*     */     } else {
/* 414 */       canSave2 = true;
/* 415 */       if (save2State == 2) {
/* 416 */         g.drawImage(this.im.button1_2, 339, 220, 160, 32, 
/* 417 */             null);
/* 418 */         g.setColor(this.text2);
/* 419 */         g.setFont(Game.default2);
/* 420 */         g.drawString("Save 2", 389, 242);
/* 421 */         g.setColor(this.text3);
/* 422 */         g.setFont(menuText1);
/* 423 */         g.drawString("Create", 396, 280);
/* 424 */       } else if (save2State == 3) {
/* 425 */         g.drawImage(this.im.button1_3, 339, 220, 160, 32, 
/* 426 */             null);
/* 427 */         g.setColor(this.text3);
/* 428 */         g.setFont(Game.default2);
/* 429 */         g.drawString("Save 2", 389, 242);
/*     */         try {
/* 431 */           Save.save2();
/* 432 */         } catch (IOException e) {
/* 433 */           e.printStackTrace();
/*     */         } 
/*     */       } else {
/* 436 */         g.drawImage(this.im.button1_1, 339, 220, 160, 32, 
/* 437 */             null);
/* 438 */         g.setColor(this.text1);
/* 439 */         g.setFont(Game.default2);
/* 440 */         g.drawString("Save 2", 389, 242);
/* 441 */         g.setColor(this.text3);
/* 442 */         g.setFont(menuText1);
/* 443 */         g.drawString("Empty", 396, 280);
/*     */       } 
/*     */     } 
/* 450 */     if (Save.save3.exists()) {
/* 451 */       canSave3 = false;
/* 452 */       g.drawImage(this.im.button1_3, 539, 220, 160, 
/* 453 */           32, null);
/* 454 */       g.setColor(this.text3);
/* 455 */       g.setFont(Game.default2);
/* 456 */       g.drawString("Save 3", 589, 242);
/* 457 */       g.setFont(menuText1);
/* 458 */       g.drawString("Already Exists!", 570, 280);
/*     */     } else {
/* 461 */       canSave3 = true;
/* 462 */       if (save3State == 2) {
/* 463 */         g.drawImage(this.im.button1_2, 539, 220, 
/* 464 */             160, 32, null);
/* 465 */         g.setColor(this.text2);
/* 466 */         g.setFont(Game.default2);
/* 467 */         g.drawString("Save 3", 589, 242);
/* 468 */         g.setColor(this.text3);
/* 469 */         g.setFont(menuText1);
/* 470 */         g.drawString("Create", 596, 280);
/* 471 */       } else if (save3State == 3) {
/* 472 */         g.drawImage(this.im.button1_3, 539, 220, 
/* 473 */             160, 32, null);
/* 474 */         g.setColor(this.text3);
/* 475 */         g.setFont(Game.default2);
/* 476 */         g.drawString("Save 3", 589, 242);
/*     */         try {
/* 478 */           Save.save3();
/* 479 */         } catch (IOException e) {
/* 480 */           e.printStackTrace();
/*     */         } 
/*     */       } else {
/* 483 */         g.drawImage(this.im.button1_1, 539, 220, 
/* 484 */             160, 32, null);
/* 485 */         g.setColor(this.text1);
/* 486 */         g.setFont(Game.default2);
/* 487 */         g.drawString("Save 3", 589, 242);
/* 488 */         g.setColor(this.text3);
/* 489 */         g.setFont(menuText1);
/* 490 */         g.drawString("Empty", 596, 280);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void renderState3(Graphics g) {}
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.4.7.jar!\beyondOrigins\main\menus\MainMenu.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */