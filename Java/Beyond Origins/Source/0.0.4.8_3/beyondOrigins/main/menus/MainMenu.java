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
/*     */ 
/*     */ public class MainMenu {
/*  22 */   static Random r = new Random();
/*     */   
/*  24 */   public static int menuState = 1;
/*     */   
/*  26 */   public static int currentProfile = 0;
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
/*     */   public static int yesState;
/*     */   
/*     */   public static int noState;
/*     */   
/*     */   public static int confirm;
/*     */   
/*  33 */   public static String save1Name = "WIP", save2Name = "WIP";
/*     */   
/*  34 */   public static String save3Name = "WIP";
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
/*  49 */   private static double cloudSpeed = 0.5D;
/*     */   
/*     */   private ImageManager im;
/*     */   
/*     */   public MainMenu(double x1, double y1, ImageManager im) {
/*  56 */     cloud1x = x1;
/*  57 */     cloud1y = y1;
/*  58 */     this.im = im;
/*     */   }
/*     */   
/*     */   public static void init() {
/*  65 */     r1 = r.nextInt(3);
/*  66 */     r2 = r.nextInt(3);
/*  67 */     r3 = r.nextInt(3);
/*  69 */     if (r1 == 0) {
/*  70 */       cloud1x = 850.0D;
/*  71 */       cloud1y = 160.0D;
/*  72 */     } else if (r1 == 1) {
/*  73 */       cloud1x = 850.0D;
/*  74 */       cloud1y = 200.0D;
/*  75 */     } else if (r1 == 2) {
/*  76 */       cloud1x = 850.0D;
/*  77 */       cloud1y = 220.0D;
/*     */     } 
/*  80 */     if (r2 == 0) {
/*  81 */       cloud2x = 990.0D;
/*  82 */       cloud2y = 2.0D;
/*  83 */     } else if (r2 == 1) {
/*  84 */       cloud2x = 990.0D;
/*  85 */       cloud2y = 22.0D;
/*  86 */     } else if (r2 == 2) {
/*  87 */       cloud2x = 990.0D;
/*  88 */       cloud2y = 42.0D;
/*     */     } 
/*  91 */     if (r3 == 0) {
/*  92 */       cloud3x = -150.0D;
/*  93 */       cloud3y = 315.0D;
/*  94 */     } else if (r3 == 1) {
/*  95 */       cloud3x = -150.0D;
/*  96 */       cloud3y = 340.0D;
/*  97 */     } else if (r3 == 2) {
/*  98 */       cloud3x = -150.0D;
/*  99 */       cloud3y = 365.0D;
/*     */     } 
/*     */   }
/*     */   
/*     */   public int getState_Button(int minX, int minY, int width, int height, int state) {
/* 107 */     if (MouseMotion.mouseX >= minX && MouseMotion.mouseX < minX + width && 
/* 108 */       MouseMotion.mouseY >= minY && 
/* 109 */       MouseMotion.mouseY < minY + height) {
/* 110 */       state = 2;
/* 111 */       if (MouseManager.mouseFullClick == 1) {
/* 112 */         state = 3;
/*     */       } else {
/* 114 */         state = 2;
/*     */       } 
/*     */     } else {
/* 116 */       state = 1;
/*     */     } 
/* 117 */     return state;
/*     */   }
/*     */   
/*     */   public void tick() {
/* 124 */     if (menuState == 2)
/* 125 */       profileTick(); 
/* 129 */     if (cloud1x > -150.0D) {
/* 130 */       cloud1x -= cloudSpeed + 0.1D;
/*     */     } else {
/* 132 */       cloud1x = 850.0D;
/* 133 */       cloud1y = 200.0D;
/*     */     } 
/* 137 */     if (cloud2x > -125.0D) {
/* 138 */       cloud2x -= cloudSpeed;
/*     */     } else {
/* 140 */       cloud2x = 990.0D;
/* 141 */       cloud2y = 22.0D;
/*     */     } 
/* 145 */     if (cloud3x <= 828.0D) {
/* 146 */       cloud3x += cloudSpeed;
/*     */     } else {
/* 148 */       cloud3x = -150.0D;
/* 149 */       cloud3y = 365.0D;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void profileTick() {
/* 157 */     if (!Save.save1.exists()) {
/* 158 */       save1Name = "Play To Create Me";
/* 159 */     } else if (Save.save1.exists()) {
/* 160 */       save1Name = "Profile 1";
/*     */     } 
/* 163 */     if (!Save.save2.exists()) {
/* 164 */       save2Name = "Play To Create Me";
/* 165 */     } else if (Save.save2.exists()) {
/* 166 */       save2Name = "Profile 2";
/*     */     } 
/* 169 */     if (!Save.save3.exists()) {
/* 170 */       save3Name = "Play To Create Me";
/* 171 */     } else if (Save.save3.exists()) {
/* 172 */       save3Name = "Profile 3";
/*     */     } 
/* 176 */     if (save1State == 3 || save2State == 3 || save3State == 3) {
/* 177 */       canPlayProfile = true;
/* 179 */     } else if (save1State == 0 && save2State == 0 && save3State == 0) {
/* 180 */       canPlayProfile = false;
/*     */     } 
/* 185 */     if (currentProfile == 0)
/* 186 */       canDeleteProfile = false; 
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
/* 212 */     g.setColor(Game.sky1);
/* 213 */     g.fillRect(0, 0, 838, 573);
/* 216 */     g.drawImage(this.im.cloud1, (int)cloud1x, (int)cloud1y, 128, 96, null);
/* 217 */     g.drawImage(this.im.cloud2, (int)cloud2x, (int)cloud2y, 128, 96, null);
/* 218 */     g.drawImage(this.im.cloud3, (int)cloud3x, (int)cloud3y, 128, 96, null);
/* 220 */     if (menuState == 1) {
/* 221 */       renderState1(g);
/* 222 */     } else if (menuState == 2) {
/* 223 */       renderState2(g);
/* 224 */     } else if (menuState == 3) {
/* 225 */       renderState3(g);
/* 226 */     } else if (menuState != 4) {
/*     */     
/*     */     } 
/*     */   }
/*     */   
/*     */   public void renderState1(Graphics g) {
/* 237 */     g.drawImage(Game.logoImage, 163, -125, 512, 512, null);
/* 240 */     g.setFont(Game.default2);
/* 241 */     g.setColor(Color.white);
/* 242 */     g.drawString(Game.title, 5, 535);
/* 243 */     g.drawString(Game.copyright, 659, 535);
/* 246 */     if (getState_Button(251, 264, 336, 32, playState) == 1) {
/* 247 */       g.drawImage(this.im.button2_1, 251, 264, 336, 32, null);
/* 248 */       g.setColor(Game.text1);
/* 249 */       g.drawString("Play", 400, 285);
/* 250 */     } else if (getState_Button(251, 264, 336, 32, playState) == 2) {
/* 251 */       g.drawImage(this.im.button2_2, 251, 264, 336, 32, null);
/* 252 */       g.setColor(Game.text2);
/* 253 */       g.drawString("Play", 400, 285);
/* 254 */     } else if (getState_Button(251, 264, 336, 32, playState) == 3) {
/* 255 */       menuStateIs1_play();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void renderState2(Graphics g) {
/* 262 */     g.setFont(Game.menuText1);
/* 263 */     g.setColor(Game.text1Color);
/* 266 */     playSelectedState = getState_Button(
/* 267 */         419 - this.im.button2_1.getWidth() / 2, 425, 
/* 268 */         this.im.button2_1.getWidth(), this.im.button2_1.getHeight(), 
/* 269 */         playSelectedState);
/* 270 */     deleteState = getState_Button(
/* 271 */         419 - this.im.button2_1.getWidth() / 2, 473, 
/* 272 */         this.im.button1_1.getWidth(), this.im.button1_1.getHeight(), deleteState);
/* 273 */     cancelState = getState_Button(
/* 274 */         419 - this.im.button2_1.getWidth() / 2 + 176, 473, 
/* 275 */         this.im.button1_1.getWidth(), this.im.button1_3.getHeight(), cancelState);
/* 279 */     if (save1State == 3) {
/* 280 */       g.drawImage(this.im.profileSelection, 268, 43, 300, 117, null);
/* 281 */       currentProfile = 1;
/* 282 */     } else if (save2State == 3) {
/* 283 */       g.drawImage(this.im.profileSelection, 268, 153, 300, 117, null);
/* 284 */       currentProfile = 2;
/* 285 */     } else if (save3State == 3) {
/* 286 */       g.drawImage(this.im.profileSelection, 268, 263, 300, 117, null);
/* 287 */       currentProfile = 3;
/*     */     } 
/* 292 */     g.drawImage(this.im.profileSquare, 275, 50, 96, 96, null);
/* 293 */     if (Save.save1.exists()) {
/* 294 */       g.setColor(Game.gameProgressColor);
/* 295 */       g.setFont(Game.gameProgressFont);
/* 296 */       g.drawString(String.valueOf(Save.save1Progress) + "%", 298, 110);
/*     */     } else {
/* 298 */       g.drawImage(this.im.profileEmpty, 290, 66, 64, 64, 
/* 299 */           null);
/*     */     } 
/* 300 */     if (currentProfile == 1) {
/* 301 */       g.setColor(Color.white);
/*     */     } else {
/* 303 */       g.setColor(Game.text1Color);
/*     */     } 
/* 304 */     g.setFont(Game.menuText1_1);
/* 305 */     g.drawString(save1Name, 380, 70);
/* 306 */     g.setFont(Game.menuText1);
/* 307 */     g.drawString("Last Played: " + Save.save1LastPlayed, 380, 103);
/* 308 */     g.drawString("Date Created: " + Save.save1Made, 380, 135);
/* 312 */     g.drawImage(this.im.profileSquare, 275, 160, 96, 96, null);
/* 313 */     if (Save.save2.exists()) {
/* 314 */       g.setColor(Game.gameProgressColor);
/* 315 */       g.setFont(Game.gameProgressFont);
/* 316 */       g.drawString(String.valueOf(Save.save2Progress) + "%", 298, 220);
/*     */     } else {
/* 318 */       g.drawImage(this.im.profileEmpty, 290, 176, 64, 
/* 319 */           64, null);
/*     */     } 
/* 321 */     if (currentProfile == 2) {
/* 322 */       g.setColor(Color.white);
/*     */     } else {
/* 324 */       g.setColor(Game.text1Color);
/*     */     } 
/* 325 */     g.setFont(Game.menuText1_1);
/* 326 */     g.drawString(save2Name, 380, 180);
/* 327 */     g.setFont(Game.menuText1);
/* 328 */     g.drawString("Last Played: " + Save.save2LastPlayed, 380, 213);
/* 329 */     g.drawString("Date Created: " + Save.save2Made, 380, 245);
/* 333 */     g.drawImage(this.im.profileSquare, 275, 270, 96, 96, null);
/* 334 */     if (Save.save3.exists()) {
/* 335 */       g.setColor(Game.gameProgressColor);
/* 336 */       g.setFont(Game.gameProgressFont);
/* 337 */       g.drawString(String.valueOf(Save.save3Progress) + "%", 298, 330);
/*     */     } else {
/* 339 */       g.drawImage(this.im.profileEmpty, 290, 286, 64, 
/* 340 */           64, null);
/*     */     } 
/* 341 */     if (currentProfile == 3) {
/* 342 */       g.setColor(Color.white);
/*     */     } else {
/* 344 */       g.setColor(Game.text1Color);
/*     */     } 
/* 345 */     g.setFont(Game.menuText1_1);
/* 346 */     g.drawString(save3Name, 380, 290);
/* 347 */     g.setFont(Game.menuText1);
/* 348 */     g.drawString("Last Played: " + Save.save3LastPlayed, 380, 323);
/* 349 */     g.drawString("Date Created: " + Save.save3Made, 380, 355);
/* 351 */     g.setFont(Game.default2);
/* 352 */     g.setColor(Game.text1);
/* 356 */     if (canPlayProfile) {
/* 357 */       if (playSelectedState == 1) {
/* 358 */         g.drawImage(this.im.button2_1, 419 - 
/* 359 */             this.im.button2_1.getWidth() / 2, 425, 
/* 360 */             this.im.button2_1.getWidth(), this.im.button2_1.getHeight(), null);
/* 361 */         g.setColor(Game.text1);
/* 362 */         g.drawString("Play Selected Profile", 324, 446);
/* 363 */       } else if (playSelectedState == 2) {
/* 364 */         g.drawImage(this.im.button2_2, 419 - 
/* 365 */             this.im.button2_1.getWidth() / 2, 425, 
/* 366 */             this.im.button2_1.getWidth(), this.im.button2_1.getHeight(), null);
/* 367 */         g.setColor(Game.text2);
/* 368 */         g.drawString("Play Selected Profile", 324, 446);
/* 369 */       } else if (playSelectedState == 3) {
/* 370 */         g.drawImage(this.im.button2_3, 419 - 
/* 371 */             this.im.button2_1.getWidth() / 2, 425, 
/* 372 */             this.im.button2_1.getWidth(), this.im.button2_1.getHeight(), null);
/* 373 */         g.setColor(Game.text3);
/* 374 */         g.drawString("Play Selected Profile", 324, 446);
/*     */         try {
/* 376 */           menuStateIs2_playProfile();
/* 377 */         } catch (IOException e) {
/* 378 */           e.printStackTrace();
/*     */         } 
/*     */       } 
/* 381 */     } else if (!canPlayProfile) {
/* 382 */       g.drawImage(this.im.button2_3, 419 - 
/* 383 */           this.im.button2_3.getWidth() / 2, 425, 
/* 384 */           this.im.button2_3.getWidth(), this.im.button2_3.getHeight(), null);
/* 385 */       g.setColor(Game.text3);
/* 386 */       g.drawString("Play Selected Profile", 324, 446);
/*     */     } 
/* 391 */     if (canDeleteProfile) {
/* 392 */       if (deleteState == 1) {
/* 393 */         g.drawImage(this.im.button1_1, 419 - 
/* 394 */             this.im.button2_1.getWidth() / 2, 473, 
/* 395 */             this.im.button1_2.getWidth(), this.im.button1_2.getHeight(), null);
/* 396 */         g.setColor(Game.text1);
/* 397 */         g.drawString("Delete", 297, 496);
/* 398 */       } else if (deleteState == 2) {
/* 399 */         g.drawImage(this.im.button1_2, 419 - 
/* 400 */             this.im.button2_1.getWidth() / 2, 473, 
/* 401 */             this.im.button1_2.getWidth(), this.im.button1_2.getHeight(), null);
/* 402 */         g.setColor(Game.text2);
/* 403 */         g.drawString("Delete", 297, 496);
/* 404 */       } else if (deleteState == 3) {
/* 405 */         g.drawImage(this.im.button1_3, 419 - 
/* 406 */             this.im.button2_1.getWidth() / 2, 473, 
/* 407 */             this.im.button1_3.getWidth(), this.im.button1_3.getHeight(), null);
/* 408 */         g.setColor(Game.text3);
/* 409 */         g.drawString("Delete", 297, 496);
/* 410 */         menuState = 3;
/*     */       } 
/* 412 */     } else if (!canDeleteProfile) {
/* 413 */       g.drawImage(this.im.button1_3, 419 - 
/* 414 */           this.im.button2_1.getWidth() / 2, 473, 
/* 415 */           this.im.button1_3.getWidth(), this.im.button1_3.getHeight(), null);
/* 416 */       g.setColor(Game.text3);
/* 417 */       g.drawString("Delete", 297, 496);
/*     */     } 
/* 422 */     if (cancelState == 1) {
/* 423 */       g.drawImage(this.im.button1_1, 
/* 424 */           419 - this.im.button2_1.getWidth() / 2 + 176, 
/* 425 */           473, this.im.button1_2.getWidth(), 
/* 426 */           this.im.button1_2.getHeight(), null);
/* 427 */       g.setColor(Game.text1);
/* 428 */       g.drawString("Cancel", 473, 496);
/* 429 */     } else if (cancelState == 2) {
/* 430 */       g.drawImage(this.im.button1_2, 
/* 431 */           419 - this.im.button2_1.getWidth() / 2 + 176, 
/* 432 */           473, this.im.button1_2.getWidth(), 
/* 433 */           this.im.button1_2.getHeight(), null);
/* 434 */       g.setColor(Game.text2);
/* 435 */       g.drawString("Cancel", 473, 496);
/* 436 */     } else if (cancelState == 3) {
/* 437 */       g.drawImage(this.im.button1_3, 
/* 438 */           419 - this.im.button2_1.getWidth() / 2 + 176, 
/* 439 */           473, this.im.button1_1.getWidth(), 
/* 440 */           this.im.button1_3.getHeight(), null);
/* 441 */       g.setColor(Game.text3);
/* 442 */       g.drawString("Cancel", 473, 496);
/* 443 */       save1State = 0;
/* 444 */       save2State = 0;
/* 445 */       save3State = 0;
/* 446 */       currentProfile = 0;
/* 447 */       menuState = 1;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void renderState3(Graphics g) {
/* 454 */     g.setFont(Game.menuText3);
/* 455 */     g.setColor(Game.text1Color);
/* 456 */     g.drawString("Are you sure?", 280, 190);
/* 458 */     g.setFont(Game.default2);
/* 460 */     if (getState_Button(215, 325, this.im.button1_1.getWidth(), 
/* 461 */         this.im.button1_1.getHeight(), yesState) == 1) {
/* 462 */       g.drawImage(this.im.button1_1, 215, 325, 
/* 463 */           this.im.button1_1.getWidth(), this.im.button1_1.getHeight(), null);
/* 464 */       g.setColor(Game.text1);
/* 465 */       g.drawString("Yes", 279, 347);
/* 466 */     } else if (getState_Button(215, 325, 
/* 467 */         this.im.button1_1.getWidth(), this.im.button1_1.getHeight(), yesState) == 2) {
/* 468 */       g.drawImage(this.im.button1_2, 215, 325, 
/* 469 */           this.im.button1_1.getWidth(), this.im.button1_1.getHeight(), null);
/* 470 */       g.setColor(Game.text2);
/* 471 */       g.drawString("Yes", 279, 347);
/* 472 */     } else if (getState_Button(215, 325, 
/* 473 */         this.im.button1_1.getWidth(), this.im.button1_1.getHeight(), yesState) == 3) {
/* 474 */       g.drawImage(this.im.button1_3, 215, 325, 
/* 475 */           this.im.button1_1.getWidth(), this.im.button1_1.getHeight(), null);
/* 476 */       g.setColor(Game.text3);
/* 477 */       g.drawString("Yes", 279, 347);
/* 478 */       menuStateIs3_yes();
/*     */     } 
/* 481 */     if (getState_Button(454, 325, this.im.button1_1.getWidth(), 
/* 482 */         this.im.button1_1.getHeight(), noState) == 1) {
/* 483 */       g.drawImage(this.im.button1_1, 454, 325, 
/* 484 */           this.im.button1_1.getWidth(), this.im.button1_1.getHeight(), null);
/* 485 */       g.setColor(Game.text1);
/* 486 */       g.drawString("No", 517, 347);
/* 487 */     } else if (getState_Button(454, 325, 
/* 488 */         this.im.button1_1.getWidth(), this.im.button1_1.getHeight(), noState) == 2) {
/* 489 */       g.drawImage(this.im.button1_2, 454, 325, 
/* 490 */           this.im.button1_1.getWidth(), this.im.button1_1.getHeight(), null);
/* 491 */       g.setColor(Game.text2);
/* 492 */       g.drawString("No", 517, 347);
/* 493 */     } else if (getState_Button(454, 325, 
/* 494 */         this.im.button1_1.getWidth(), this.im.button1_1.getHeight(), noState) == 3) {
/* 495 */       g.drawImage(this.im.button1_3, 454, 325, 
/* 496 */           this.im.button1_1.getWidth(), this.im.button1_1.getHeight(), null);
/* 497 */       g.setColor(Game.text3);
/* 498 */       g.drawString("No", 517, 347);
/* 499 */       menuStateIs3_no();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void menuStateIs1_play() {
/* 507 */     Load.loadData1(Game.dataPath);
/* 508 */     menuState = 2;
/*     */   }
/*     */   
/*     */   public static void menuStateIs2_playProfile() throws IOException {
/* 513 */     if (currentProfile == 1) {
/* 514 */       if (Save.save1.exists()) {
/* 515 */         Load.loadProfile(Game.save1Path);
/* 516 */         Save.profileSave(Save.save1, Game.save1Path, 1);
/* 517 */         Save.dataSave();
/* 518 */       } else if (!Save.save1.exists()) {
/* 520 */         Save.reset();
/* 521 */         Save.profileSave(Save.save1, Game.save1Path, 1);
/* 522 */         Save.dataSave();
/*     */       } 
/* 524 */     } else if (currentProfile == 2) {
/* 525 */       if (Save.save2.exists()) {
/* 526 */         Load.loadProfile(Game.save2Path);
/* 527 */         Save.profileSave(Save.save2, Game.save2Path, 2);
/* 528 */         Save.dataSave();
/* 529 */       } else if (!Save.save2.exists()) {
/* 531 */         Save.reset();
/* 532 */         Save.profileSave(Save.save2, Game.save2Path, 2);
/* 533 */         Save.dataSave();
/*     */       } 
/* 535 */     } else if (currentProfile == 3) {
/* 536 */       if (Save.save3.exists()) {
/* 537 */         Load.loadProfile(Game.save3Path);
/* 538 */         Save.profileSave(Save.save3, Game.save3Path, 3);
/* 539 */         Save.dataSave();
/* 540 */       } else if (!Save.save3.exists()) {
/* 542 */         Save.reset();
/* 543 */         Save.profileSave(Save.save3, Game.save3Path, 3);
/* 544 */         Save.dataSave();
/*     */       } 
/*     */     } 
/* 547 */     Game.isInGame = true;
/* 549 */     save1State = 0;
/* 550 */     save2State = 0;
/* 551 */     save3State = 0;
/* 552 */     menuState = 0;
/*     */   }
/*     */   
/*     */   public void menuStateIs2_deleteProfile() throws IOException {
/* 558 */     if (currentProfile == 1) {
/* 559 */       Save.save1.delete();
/* 560 */       Save.save1Made = "";
/* 561 */       Save.save1LastPlayed = "";
/* 562 */       Save.dataSave();
/* 563 */     } else if (currentProfile == 2) {
/* 564 */       Save.save2.delete();
/* 565 */       Save.save2Made = "";
/* 566 */       Save.save2LastPlayed = "";
/* 567 */       Save.dataSave();
/* 568 */     } else if (currentProfile == 3) {
/* 569 */       Save.save3.delete();
/* 570 */       Save.save3Made = " ";
/* 571 */       Save.save3LastPlayed = " ";
/* 572 */       Save.dataSave();
/*     */     } 
/* 575 */     menuState = 2;
/*     */   }
/*     */   
/*     */   public void menuStateIs2_cancel() {}
/*     */   
/*     */   public void menuStateIs3_yes() {
/*     */     try {
/* 586 */       menuStateIs2_deleteProfile();
/* 587 */     } catch (IOException e) {
/* 588 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void menuStateIs3_no() {
/* 595 */     menuState = 2;
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.4.8_3.jar!\beyondOrigins\main\menus\MainMenu.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */