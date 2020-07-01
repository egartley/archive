/*     */ package beyondOrigins.main.menus;
/*     */ 
/*     */ import beyondOrigins.main.Game;
/*     */ import beyondOrigins.main.Load;
/*     */ import beyondOrigins.main.MouseManager;
/*     */ import beyondOrigins.main.MouseMotion;
/*     */ import beyondOrigins.main.Save;
/*     */ import beyondOrigins.main.gfx.ImageManager;
/*     */ import java.awt.Color;
/*     */ import java.awt.Graphics;
/*     */ import java.io.IOException;
/*     */ import java.util.Random;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ 
/*     */ public class MainMenu {
/*  19 */   static Random r = new Random();
/*     */   
/*  21 */   public static int menuState = 1;
/*     */   
/*  23 */   public static int currentProfile = 0;
/*     */   
/*     */   public static boolean canPlayProfile = false;
/*     */   
/*     */   public static boolean canDeleteProfile = false;
/*     */   
/*     */   public static int playSelectedState;
/*     */   
/*     */   public static int deleteState;
/*     */   
/*     */   public static int cancelState;
/*     */   
/*     */   public static int save1State;
/*     */   
/*     */   public static int save2State;
/*     */   
/*     */   public static int save3State;
/*     */   
/*     */   public static String save1Name;
/*     */   
/*     */   public static String save2Name;
/*     */   
/*     */   public static String save3Name;
/*     */   
/*     */   private static int r1;
/*     */   
/*     */   private static int r2;
/*     */   
/*     */   private static int r3;
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
/*     */   public static int playState;
/*     */   
/*  43 */   private static double cloudSpeed = 0.5D;
/*     */   
/*     */   private ImageManager im;
/*     */   
/*     */   public MainMenu(double x1, double y1, ImageManager im) {
/*  49 */     cloud1x = x1;
/*  50 */     cloud1y = y1;
/*  51 */     this.im = im;
/*     */   }
/*     */   
/*     */   public static void init() {
/*  57 */     r1 = r.nextInt(3);
/*  58 */     r2 = r.nextInt(3);
/*  59 */     r3 = r.nextInt(3);
/*  61 */     if (r1 == 0) {
/*  62 */       cloud1x = 850.0D;
/*  63 */       cloud1y = 160.0D;
/*  64 */     } else if (r1 == 1) {
/*  65 */       cloud1x = 850.0D;
/*  66 */       cloud1y = 200.0D;
/*  67 */     } else if (r1 == 2) {
/*  68 */       cloud1x = 850.0D;
/*  69 */       cloud1y = 220.0D;
/*     */     } 
/*  72 */     if (r2 == 0) {
/*  73 */       cloud2x = 990.0D;
/*  74 */       cloud2y = 2.0D;
/*  75 */     } else if (r2 == 1) {
/*  76 */       cloud2x = 990.0D;
/*  77 */       cloud2y = 22.0D;
/*  78 */     } else if (r2 == 2) {
/*  79 */       cloud2x = 990.0D;
/*  80 */       cloud2y = 42.0D;
/*     */     } 
/*  83 */     if (r3 == 0) {
/*  84 */       cloud3x = -150.0D;
/*  85 */       cloud3y = 315.0D;
/*  86 */     } else if (r3 == 1) {
/*  87 */       cloud3x = -150.0D;
/*  88 */       cloud3y = 340.0D;
/*  89 */     } else if (r3 == 2) {
/*  90 */       cloud3x = -150.0D;
/*  91 */       cloud3y = 365.0D;
/*     */     } 
/*     */   }
/*     */   
/*     */   public int getState_BUTTON(int minX, int minY, int width, int height, int state) {
/*  97 */     if (MouseMotion.mouseX >= minX && MouseMotion.mouseX < minX + width && 
/*  98 */       MouseMotion.mouseY >= minY && 
/*  99 */       MouseMotion.mouseY < minY + height) {
/* 100 */       state = 2;
/* 101 */       if (MouseManager.mouseFullClick == 1) {
/* 102 */         state = 3;
/*     */       } else {
/* 104 */         state = 2;
/*     */       } 
/*     */     } else {
/* 106 */       state = 1;
/*     */     } 
/* 107 */     return state;
/*     */   }
/*     */   
/*     */   public int getState_SELECTION(int minX, int minY, int width, int height, int mainState, int extraState1, int extraState2) {
/* 112 */     if (MouseMotion.mouseX >= minX && MouseMotion.mouseX < minX + width && 
/* 113 */       MouseMotion.mouseY >= minY && 
/* 114 */       MouseMotion.mouseY < minY + height && 
/* 115 */       MouseManager.mouseFullClick == 1) {
/* 116 */       mainState = 3;
/* 117 */     } else if (extraState1 == 3 || extraState2 == 3) {
/* 118 */       mainState = 1;
/*     */     } 
/* 120 */     return mainState;
/*     */   }
/*     */   
/*     */   public void tick() {
/* 127 */     if (menuState == 2)
/* 128 */       profileTick(); 
/* 132 */     if (cloud1x > -150.0D) {
/* 133 */       cloud1x -= cloudSpeed + 0.1D;
/*     */     } else {
/* 135 */       cloud1x = 850.0D;
/* 136 */       cloud1y = 200.0D;
/*     */     } 
/* 140 */     if (cloud2x > -125.0D) {
/* 141 */       cloud2x -= cloudSpeed;
/*     */     } else {
/* 143 */       cloud2x = 990.0D;
/* 144 */       cloud2y = 22.0D;
/*     */     } 
/* 148 */     if (cloud3x <= 828.0D) {
/* 149 */       cloud3x += cloudSpeed;
/*     */     } else {
/* 151 */       cloud3x = -150.0D;
/* 152 */       cloud3y = 365.0D;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void profileTick() {
/* 161 */     if (!Save.save1.exists()) {
/* 162 */       save1Name = "Play To Create Me";
/* 163 */     } else if (Save.save1.exists()) {
/* 164 */       save1Name = "Profile 1";
/*     */     } 
/* 167 */     if (!Save.save2.exists()) {
/* 168 */       save2Name = "Play To Create Me";
/* 169 */     } else if (Save.save2.exists()) {
/* 170 */       save2Name = "Profile 2";
/*     */     } 
/* 173 */     if (!Save.save3.exists()) {
/* 174 */       save3Name = "Play To Create Me";
/* 175 */     } else if (Save.save3.exists()) {
/* 176 */       save3Name = "Profile 3";
/*     */     } 
/* 180 */     if (save1State == 3 || save2State == 3 || save3State == 3) {
/* 181 */       canPlayProfile = true;
/* 183 */     } else if (save1State == 0 && save2State == 0 && save3State == 0) {
/* 184 */       canPlayProfile = false;
/*     */     } 
/* 189 */     if (currentProfile == 1 && !Save.save1.exists()) {
/* 190 */       canDeleteProfile = false;
/* 191 */     } else if (currentProfile == 1 && Save.save1.exists()) {
/* 192 */       canDeleteProfile = true;
/*     */     } 
/* 195 */     if (currentProfile == 2 && !Save.save2.exists()) {
/* 196 */       canDeleteProfile = false;
/* 197 */     } else if (currentProfile == 2 && Save.save2.exists()) {
/* 198 */       canDeleteProfile = true;
/*     */     } 
/* 201 */     if (currentProfile == 3 && !Save.save3.exists()) {
/* 202 */       canDeleteProfile = false;
/* 203 */     } else if (currentProfile == 3 && Save.save3.exists()) {
/* 204 */       canDeleteProfile = true;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void renderMain(Graphics g) {
/* 213 */     g.setColor(Game.sky1);
/* 214 */     g.fillRect(0, 0, 838, 573);
/* 217 */     g.drawImage(this.im.cloud1, (int)cloud1x, (int)cloud1y, 128, 96, null);
/* 218 */     g.drawImage(this.im.cloud2, (int)cloud2x, (int)cloud2y, 128, 96, null);
/* 219 */     g.drawImage(this.im.cloud3, (int)cloud3x, (int)cloud3y, 128, 96, null);
/* 221 */     if (menuState == 1) {
/* 222 */       renderState1(g);
/* 223 */     } else if (menuState == 2) {
/* 224 */       renderState2(g);
/* 225 */     } else if (menuState != 3) {
/* 227 */       if (menuState != 4);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void renderState1(Graphics g) {
/* 238 */     playState = getState_BUTTON(251, 264, 336, 32, playState);
/* 241 */     g.drawImage(Game.logoImage, 163, -125, 512, 512, null);
/* 244 */     g.setFont(Game.default2);
/* 245 */     g.setColor(Color.white);
/* 246 */     g.drawString(Game.title, 5, 535);
/* 247 */     g.drawString(Game.copyright, 565, 535);
/* 250 */     if (playState == 1) {
/* 251 */       g.drawImage(this.im.button2_1, 251, 264, 336, 32, null);
/* 252 */       g.setColor(Game.text1);
/* 253 */       g.drawString("Play", 400, 285);
/* 254 */     } else if (playState == 2) {
/* 255 */       g.drawImage(this.im.button2_2, 251, 264, 336, 32, null);
/* 256 */       g.setColor(Game.text2);
/* 257 */       g.drawString("Play", 400, 285);
/* 258 */     } else if (playState == 3) {
/* 259 */       state1_play();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void renderState2(Graphics g) {
/* 267 */     g.setFont(Game.menuText1);
/* 268 */     g.setColor(Game.text1Color);
/* 272 */     if (save1State == 3) {
/* 273 */       g.drawImage(this.im.profileSelection, 268, 43, 300, 
/* 274 */           117, null);
/* 275 */       currentProfile = 1;
/* 276 */     } else if (save2State == 3) {
/* 277 */       g.drawImage(this.im.profileSelection, 268, 153, 300, 
/* 278 */           117, null);
/* 279 */       currentProfile = 2;
/* 280 */     } else if (save3State == 3) {
/* 281 */       g.drawImage(this.im.profileSelection, 268, 263, 300, 
/* 282 */           117, null);
/* 283 */       currentProfile = 3;
/*     */     } 
/* 287 */     save1State = getState_SELECTION(268, 43, 244, 92, save1State, save2State, save3State);
/* 288 */     save2State = getState_SELECTION(268, 153, 300, 117, save2State, save1State, save3State);
/* 289 */     save3State = getState_SELECTION(268, 263, 300, 117, save3State, save1State, save2State);
/* 291 */     playSelectedState = getState_BUTTON(419 - 
/* 292 */         this.im.button2_1.getWidth() / 2, 425, this.im.button2_1.getWidth(), this.im.button2_1.getHeight(), playSelectedState);
/* 293 */     deleteState = getState_BUTTON(419 - 
/* 294 */         this.im.button2_1.getWidth() / 2, 473, this.im.button1_1.getWidth(), this.im.button1_1.getHeight(), deleteState);
/* 295 */     cancelState = getState_BUTTON(419 - this.im.button2_1.getWidth() / 2 + 176, 
/* 296 */         473, this.im.button1_1.getWidth(), this.im.button1_3.getHeight(), cancelState);
/* 300 */     g.drawImage(this.im.profileSquare, 275, 50, 96, 96, null);
/* 301 */     if (Save.save1.exists()) {
/* 302 */       g.setColor(Game.gameProgressColor);
/* 303 */       g.setFont(Game.gameProgressFont);
/* 304 */       g.drawString(String.valueOf(Save.save1Progress) + "%", 298, 110);
/*     */     } else {
/* 306 */       g.drawImage(this.im.profileEmpty, 290, 66, 64, 64, 
/* 307 */           null);
/*     */     } 
/* 308 */     if (currentProfile == 1) {
/* 309 */       g.setColor(Color.white);
/*     */     } else {
/* 311 */       g.setColor(Game.text1Color);
/*     */     } 
/* 312 */     g.setFont(Game.menuText1_1);
/* 313 */     g.drawString(save1Name, 380, 70);
/* 314 */     g.setFont(Game.menuText1);
/* 315 */     g.drawString("Last Played: " + Save.save1LastPlayed, 380, 103);
/* 316 */     g.drawString("Date Created: " + Save.save1Made, 380, 135);
/* 320 */     g.drawImage(this.im.profileSquare, 275, 160, 96, 96, null);
/* 321 */     g.drawImage(this.im.profileEmpty, 290, 176, 64, 64, 
/* 322 */         null);
/* 323 */     if (currentProfile == 2) {
/* 324 */       g.setColor(Color.white);
/*     */     } else {
/* 326 */       g.setColor(Game.text1Color);
/*     */     } 
/* 327 */     g.setFont(Game.menuText1_1);
/* 328 */     g.drawString(save2Name, 380, 180);
/* 329 */     g.setFont(Game.menuText1);
/* 330 */     g.drawString("Last Played: " + Save.save2LastPlayed, 380, 213);
/* 331 */     g.drawString("Date Created: " + Save.save2Made, 380, 245);
/* 335 */     g.drawImage(this.im.profileSquare, 275, 270, 96, 96, null);
/* 336 */     g.drawImage(this.im.profileEmpty, 290, 286, 64, 64, 
/* 337 */         null);
/* 338 */     if (currentProfile == 3) {
/* 339 */       g.setColor(Color.white);
/*     */     } else {
/* 341 */       g.setColor(Game.text1Color);
/*     */     } 
/* 342 */     g.setFont(Game.menuText1_1);
/* 343 */     g.drawString(save3Name, 380, 290);
/* 344 */     g.setFont(Game.menuText1);
/* 345 */     g.drawString("Last Played: " + Save.save3LastPlayed, 380, 323);
/* 346 */     g.drawString("Date Created: " + Save.save3Made, 380, 355);
/* 348 */     g.setFont(Game.default2);
/* 349 */     g.setColor(Game.text1);
/* 353 */     if (canPlayProfile) {
/* 354 */       if (playSelectedState == 1) {
/* 355 */         g.drawImage(this.im.button2_1, 419 - 
/* 356 */             this.im.button2_1.getWidth() / 2, 425, this.im.button2_1.getWidth(), this.im.button2_1.getHeight(), null);
/* 357 */         g.setColor(Game.text1);
/* 358 */         g.drawString("Play Selected Profile", 324, 446);
/* 359 */       } else if (playSelectedState == 2) {
/* 360 */         g.drawImage(this.im.button2_2, 419 - 
/* 361 */             this.im.button2_1.getWidth() / 2, 425, this.im.button2_1.getWidth(), this.im.button2_1.getHeight(), null);
/* 362 */         g.setColor(Game.text2);
/* 363 */         g.drawString("Play Selected Profile", 324, 446);
/* 364 */       } else if (playSelectedState == 3) {
/* 365 */         g.drawImage(this.im.button2_3, 419 - 
/* 366 */             this.im.button2_1.getWidth() / 2, 425, this.im.button2_1.getWidth(), this.im.button2_1.getHeight(), null);
/* 367 */         g.setColor(Game.text3);
/* 368 */         g.drawString("Play Selected Profile", 324, 446);
/*     */         try {
/* 370 */           menuState2Is2_playProfile();
/* 371 */         } catch (IOException e) {
/* 372 */           e.printStackTrace();
/*     */         } 
/*     */       } 
/* 375 */     } else if (!canPlayProfile) {
/* 376 */       g.drawImage(this.im.button2_3, 419 - 
/* 377 */           this.im.button2_3.getWidth() / 2, 425, this.im.button2_3.getWidth(), this.im.button2_3.getHeight(), null);
/* 378 */       g.setColor(Game.text3);
/* 379 */       g.drawString("Play Selected Profile", 324, 446);
/*     */     } 
/* 384 */     if (canDeleteProfile) {
/* 385 */       if (deleteState == 1) {
/* 386 */         g.drawImage(this.im.button1_1, 419 - 
/* 387 */             this.im.button2_1.getWidth() / 2, 473, this.im.button1_2.getWidth(), this.im.button1_2.getHeight(), null);
/* 388 */         g.setColor(Game.text1);
/* 389 */         g.drawString("Delete", 297, 496);
/* 390 */       } else if (deleteState == 2) {
/* 391 */         g.drawImage(this.im.button1_2, 419 - 
/* 392 */             this.im.button2_1.getWidth() / 2, 473, this.im.button1_2.getWidth(), this.im.button1_2.getHeight(), null);
/* 393 */         g.setColor(Game.text2);
/* 394 */         g.drawString("Delete", 297, 496);
/* 395 */       } else if (deleteState == 3) {
/* 396 */         g.drawImage(this.im.button1_3, 419 - 
/* 397 */             this.im.button2_1.getWidth() / 2, 473, this.im.button1_3.getWidth(), this.im.button1_3.getHeight(), null);
/* 398 */         g.setColor(Game.text3);
/* 399 */         g.drawString("Delete", 297, 496);
/* 400 */         menuStateIs2_deleteProfile();
/*     */       } 
/* 402 */     } else if (!canDeleteProfile) {
/* 403 */       g.drawImage(this.im.button1_3, 419 - 
/* 404 */           this.im.button2_1.getWidth() / 2, 473, this.im.button1_3.getWidth(), this.im.button1_3.getHeight(), null);
/* 405 */       g.setColor(Game.text3);
/* 406 */       g.drawString("Delete", 297, 496);
/*     */     } 
/* 411 */     if (cancelState == 1) {
/* 412 */       g.drawImage(this.im.button1_1, 
/* 413 */           419 - this.im.button2_1.getWidth() / 2 + 176, 
/* 414 */           473, this.im.button1_2.getWidth(), this.im.button1_2.getHeight(), null);
/* 415 */       g.setColor(Game.text1);
/* 416 */       g.drawString("Cancel", 473, 496);
/* 417 */     } else if (cancelState == 2) {
/* 418 */       g.drawImage(this.im.button1_2, 
/* 419 */           419 - this.im.button2_1.getWidth() / 2 + 176, 
/* 420 */           473, this.im.button1_2.getWidth(), this.im.button1_2.getHeight(), null);
/* 421 */       g.setColor(Game.text2);
/* 422 */       g.drawString("Cancel", 473, 496);
/* 423 */     } else if (cancelState == 3) {
/* 424 */       g.drawImage(this.im.button1_3, 
/* 425 */           419 - this.im.button2_1.getWidth() / 2 + 176, 
/* 426 */           473, this.im.button1_1.getWidth(), this.im.button1_3.getHeight(), null);
/* 427 */       g.setColor(Game.text3);
/* 428 */       g.drawString("Cancel", 473, 496);
/*     */       try {
/* 431 */         TimeUnit.MILLISECONDS.sleep(75L);
/* 432 */       } catch (InterruptedException e) {
/* 433 */         e.printStackTrace();
/*     */       } 
/* 435 */       save1State = 0;
/* 436 */       save2State = 0;
/* 437 */       save3State = 0;
/* 438 */       currentProfile = 0;
/* 439 */       menuState = 1;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void menuState2Is2_playProfile() throws IOException {
/* 447 */     Save.reset();
/* 449 */     if (currentProfile == 1) {
/* 450 */       if (!Save.save1.exists()) {
/* 451 */         Save.save1();
/* 452 */         Game.isInGame = true;
/* 453 */         Load.loadProfile1(Game.save1Path);
/* 454 */       } else if (Save.save1.exists()) {
/* 455 */         Game.isInGame = true;
/* 456 */         Load.loadProfile1(Game.save1Path);
/*     */       } 
/* 458 */     } else if (currentProfile == 2) {
/* 459 */       if (!Save.save2.exists()) {
/* 460 */         Save.save2();
/* 461 */         Game.isInGame = true;
/* 462 */         Load.loadProfile1(Game.save2Path);
/* 463 */       } else if (Save.save2.exists()) {
/* 464 */         Game.isInGame = true;
/* 465 */         Load.loadProfile1(Game.save2Path);
/*     */       } 
/* 467 */     } else if (currentProfile == 3) {
/* 468 */       if (!Save.save3.exists()) {
/* 469 */         Save.save3();
/* 470 */         Game.isInGame = true;
/* 471 */         Load.loadProfile1(Game.save3Path);
/* 472 */       } else if (Save.save3.exists()) {
/* 473 */         Game.isInGame = true;
/* 474 */         Load.loadProfile1(Game.save3Path);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void menuStateIs2_deleteProfile() {
/* 482 */     if (currentProfile == 1 && Save.save1.exists()) {
/* 483 */       Save.save1.delete();
/* 484 */     } else if (currentProfile == 2 && Save.save2.exists()) {
/* 485 */       Save.save2.delete();
/* 486 */     } else if (currentProfile == 3 && Save.save3.exists()) {
/* 487 */       Save.save3.delete();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void menuStateIs2_cancel() {}
/*     */   
/*     */   public void state1_play() {
/*     */     try {
/* 498 */       TimeUnit.MILLISECONDS.sleep(75L);
/* 499 */     } catch (InterruptedException e) {
/* 500 */       e.printStackTrace();
/*     */     } 
/* 502 */     menuState = 2;
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.4.7_1.jar!\beyondOrigins\main\menus\MainMenu.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */