/*     */ package beyondOrigins.main.menus;
/*     */ 
/*     */ import beyondOrigins.files.Load;
/*     */ import beyondOrigins.files.Save;
/*     */ import beyondOrigins.main.Game;
/*     */ import beyondOrigins.main.MouseManager;
/*     */ import beyondOrigins.main.MouseMotion;
/*     */ import beyondOrigins.main.gfx.ImageManager;
/*     */ import java.awt.Color;
/*     */ import java.awt.FontMetrics;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.io.IOException;
/*     */ import java.util.Random;
/*     */ 
/*     */ public class MainMenu {
/*  20 */   static Random r = new Random();
/*     */   
/*     */   private static int r1;
/*     */   
/*     */   private static int r2;
/*     */   
/*     */   private static int r3;
/*     */   
/*     */   private FontMetrics fm;
/*     */   
/*  29 */   public static int menuState = 1;
/*     */   
/*     */   private ImageManager im;
/*     */   
/*  31 */   private static int time = 0;
/*     */   
/*  32 */   public static int coolDown = 10;
/*     */   
/*     */   public static boolean canPressButton;
/*     */   
/*     */   public static int playState;
/*     */   
/*     */   private static int optionsState;
/*     */   
/*  40 */   public static int currentProfile = 0;
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
/*  45 */   public static String save1Name = "WIP", save2Name = "WIP";
/*     */   
/*  46 */   public static String save3Name = "WIP";
/*     */   
/*     */   public static int yesState;
/*     */   
/*     */   public static int noState;
/*     */   
/*     */   private static int autoSaveState;
/*     */   
/*     */   private static int addOnsState;
/*     */   
/*  53 */   public static String autoSaveToggle = "On";
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
/*  62 */   private static double cloudSpeed = 0.5D;
/*     */   
/*     */   public MainMenu(double x1, double y1, ImageManager im) {
/*  67 */     cloud1x = x1;
/*  68 */     cloud1y = y1;
/*  69 */     this.im = im;
/*     */   }
/*     */   
/*     */   public static void init() {
/*  76 */     r1 = r.nextInt(3);
/*  77 */     r2 = r.nextInt(3);
/*  78 */     r3 = r.nextInt(3);
/*  80 */     if (r1 == 0) {
/*  81 */       cloud1x = 850.0D;
/*  82 */       cloud1y = 160.0D;
/*  83 */     } else if (r1 == 1) {
/*  84 */       cloud1x = 850.0D;
/*  85 */       cloud1y = 200.0D;
/*  86 */     } else if (r1 == 2) {
/*  87 */       cloud1x = 850.0D;
/*  88 */       cloud1y = 220.0D;
/*     */     } 
/*  91 */     if (r2 == 0) {
/*  92 */       cloud2x = 990.0D;
/*  93 */       cloud2y = 2.0D;
/*  94 */     } else if (r2 == 1) {
/*  95 */       cloud2x = 990.0D;
/*  96 */       cloud2y = 22.0D;
/*  97 */     } else if (r2 == 2) {
/*  98 */       cloud2x = 990.0D;
/*  99 */       cloud2y = 42.0D;
/*     */     } 
/* 102 */     if (r3 == 0) {
/* 103 */       cloud3x = -150.0D;
/* 104 */       cloud3y = 315.0D;
/* 105 */     } else if (r3 == 1) {
/* 106 */       cloud3x = -150.0D;
/* 107 */       cloud3y = 340.0D;
/* 108 */     } else if (r3 == 2) {
/* 109 */       cloud3x = -150.0D;
/* 110 */       cloud3y = 365.0D;
/*     */     } 
/*     */   }
/*     */   
/*     */   public int getButtonState(int minX, int minY, int width, int height, int state) {
/* 118 */     if (MouseMotion.mouseX >= minX && MouseMotion.mouseX < minX + width && 
/* 119 */       MouseMotion.mouseY >= minY && 
/* 120 */       MouseMotion.mouseY < minY + height) {
/* 121 */       state = 2;
/* 122 */       if (MouseManager.mouseFullClick == 1 && canPressButton) {
/* 123 */         state = 3;
/*     */       } else {
/* 125 */         state = 2;
/*     */       } 
/*     */     } else {
/* 127 */       state = 1;
/*     */     } 
/* 128 */     return state;
/*     */   }
/*     */   
/*     */   public void drawButton(Graphics g, int state, int renderX, int renderY, int width, int height, String buttonText, BufferedImage state1Image, BufferedImage state2Image, BufferedImage state3Image, double clickEventType) {
/* 135 */     this.fm = g.getFontMetrics(Game.default2);
/* 136 */     g.setFont(Game.default2);
/* 137 */     if (getButtonState(renderX, renderY, width, height, state) == 1) {
/* 138 */       g.drawImage(state1Image, renderX, renderY, width, height, null);
/* 139 */       g.setColor(Game.text1);
/* 140 */       g.drawString(buttonText, renderX + state1Image.getWidth() / 2 - 
/* 141 */           this.fm.stringWidth(buttonText) / 2, 
/* 142 */           renderY + state1Image.getHeight() / 2 + 5);
/* 143 */     } else if (getButtonState(renderX, renderY, width, height, state) == 2) {
/* 144 */       g.drawImage(state2Image, renderX, renderY, width, height, null);
/* 145 */       g.setColor(Game.text2);
/* 146 */       g.drawString(buttonText, renderX + state1Image.getWidth() / 2 - 
/* 147 */           this.fm.stringWidth(buttonText) / 2, 
/* 148 */           renderY + state1Image.getHeight() / 2 + 5);
/* 149 */     } else if (getButtonState(renderX, renderY, width, height, state) == 3) {
/* 150 */       g.drawImage(state3Image, renderX, renderY, width, height, null);
/* 151 */       g.setColor(Game.text3);
/* 152 */       g.drawString(buttonText, renderX + state1Image.getWidth() / 2 - 
/* 153 */           this.fm.stringWidth(buttonText) / 2, 
/* 154 */           renderY + state1Image.getHeight() / 2 + 5);
/* 156 */       if (clickEventType == 1.1D) {
/* 157 */         menuStateIs1_play();
/* 158 */       } else if (clickEventType == 1.2D) {
/* 159 */         menuStateIs1_options();
/*     */       } 
/* 162 */       if (clickEventType == 2.1D) {
/*     */         try {
/* 164 */           menuStateIs2_playProfile();
/* 165 */         } catch (IOException e) {
/* 166 */           e.printStackTrace();
/*     */         } 
/* 168 */       } else if (clickEventType == 2.2D) {
/* 169 */         menuState = 3;
/* 170 */       } else if (clickEventType == 2.3D) {
/* 171 */         menuStateIs2_cancel();
/*     */       } 
/* 174 */       if (clickEventType == 3.1D) {
/* 175 */         menuStateIs3_yes();
/* 176 */       } else if (clickEventType == 3.2D) {
/* 177 */         menuStateIs3_no();
/*     */       } 
/* 180 */       if (clickEventType == 4.1D) {
/* 181 */         menuStateIs4_autoSave();
/* 182 */       } else if (clickEventType == 4.2D) {
/* 183 */         menuStateIs4_addOns();
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void tick() {
/* 192 */     if (!canPressButton) {
/* 193 */       time++;
/* 194 */       if (time >= coolDown) {
/* 195 */         time = 0;
/* 196 */         canPressButton = true;
/* 197 */         coolDown = 10;
/*     */       } 
/*     */     } 
/* 201 */     if (menuState == 2)
/* 202 */       profileTick(); 
/* 206 */     if (cloud1x > -150.0D) {
/* 207 */       cloud1x -= cloudSpeed + 0.1D;
/*     */     } else {
/* 209 */       cloud1x = 850.0D;
/* 210 */       cloud1y = 200.0D;
/*     */     } 
/* 214 */     if (cloud2x > -125.0D) {
/* 215 */       cloud2x -= cloudSpeed;
/*     */     } else {
/* 217 */       cloud2x = 990.0D;
/* 218 */       cloud2y = 22.0D;
/*     */     } 
/* 222 */     if (cloud3x <= 828.0D) {
/* 223 */       cloud3x += cloudSpeed;
/*     */     } else {
/* 225 */       cloud3x = -150.0D;
/* 226 */       cloud3y = 365.0D;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void profileTick() {
/* 234 */     if (!Save.save1.exists()) {
/* 235 */       save1Name = "Play To Create Me";
/* 236 */     } else if (Save.save1.exists()) {
/* 237 */       save1Name = "Profile 1";
/*     */     } 
/* 240 */     if (!Save.save2.exists()) {
/* 241 */       save2Name = "Play To Create Me";
/* 242 */     } else if (Save.save2.exists()) {
/* 243 */       save2Name = "Profile 2";
/*     */     } 
/* 246 */     if (!Save.save3.exists()) {
/* 247 */       save3Name = "Play To Create Me";
/* 248 */     } else if (Save.save3.exists()) {
/* 249 */       save3Name = "Profile 3";
/*     */     } 
/* 253 */     if (save1State == 3 || save2State == 3 || save3State == 3) {
/* 254 */       canPlayProfile = true;
/* 256 */     } else if (save1State == 0 && save2State == 0 && save3State == 0) {
/* 257 */       canPlayProfile = false;
/*     */     } 
/* 262 */     if (currentProfile == 0)
/* 263 */       canDeleteProfile = false; 
/* 266 */     if (currentProfile == 1 && !Save.save1.exists()) {
/* 267 */       canDeleteProfile = false;
/* 268 */     } else if (currentProfile == 1 && Save.save1.exists()) {
/* 269 */       canDeleteProfile = true;
/*     */     } 
/* 272 */     if (currentProfile == 2 && !Save.save2.exists()) {
/* 273 */       canDeleteProfile = false;
/* 274 */     } else if (currentProfile == 2 && Save.save2.exists()) {
/* 275 */       canDeleteProfile = true;
/*     */     } 
/* 278 */     if (currentProfile == 3 && !Save.save3.exists()) {
/* 279 */       canDeleteProfile = false;
/* 280 */     } else if (currentProfile == 3 && Save.save3.exists()) {
/* 281 */       canDeleteProfile = true;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void renderMain(Graphics g) {
/* 289 */     g.setColor(Game.sky1);
/* 290 */     g.fillRect(0, 0, 838, 573);
/* 293 */     g.drawImage(this.im.cloud1, (int)cloud1x, (int)cloud1y, 128, 96, null);
/* 294 */     g.drawImage(this.im.cloud2, (int)cloud2x, (int)cloud2y, 128, 96, null);
/* 295 */     g.drawImage(this.im.cloud3, (int)cloud3x, (int)cloud3y, 128, 96, null);
/* 297 */     if (menuState == 1) {
/* 298 */       renderState1(g);
/* 299 */     } else if (menuState == 2) {
/* 300 */       renderState2(g);
/* 301 */     } else if (menuState == 3) {
/* 302 */       renderState3(g);
/* 303 */     } else if (menuState == 4) {
/* 304 */       renderState4(g);
/* 305 */     } else if (menuState == 5) {
/* 306 */       renderState5(g);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void renderState1(Graphics g) {
/* 318 */     g.drawImage(Game.logoImage, 419 - Game.logoImage.getWidth(), -125, 512, 512, null);
/* 321 */     g.setFont(Game.default2);
/* 322 */     g.setColor(Color.white);
/* 323 */     g.drawString(Game.title, 5, 535);
/* 324 */     g.drawString(Game.copyright, 659, 535);
/* 327 */     drawButton(g, playState, 251, 264, 336, 32, "Play", 
/* 328 */         this.im.button2_1, this.im.button2_2, this.im.button2_3, 1.1D);
/* 331 */     drawButton(g, optionsState, 251, 312, 
/* 332 */         this.im.button2_1.getWidth(), this.im.button2_1.getHeight(), "Options", 
/* 333 */         this.im.button2_1, this.im.button2_2, this.im.button2_3, 1.2D);
/*     */   }
/*     */   
/*     */   public void renderState2(Graphics g) {
/* 341 */     this.fm = g.getFontMetrics(Game.gameProgressFont);
/* 343 */     g.setFont(Game.menuText1);
/* 344 */     g.setColor(Game.text1Color);
/* 348 */     if (save1State == 3) {
/* 349 */       g.drawImage(this.im.profileSelection, 268, 43, 300, 117, null);
/* 350 */       currentProfile = 1;
/* 351 */     } else if (save2State == 3) {
/* 352 */       g.drawImage(this.im.profileSelection, 268, 153, 300, 117, null);
/* 353 */       currentProfile = 2;
/* 354 */     } else if (save3State == 3) {
/* 355 */       g.drawImage(this.im.profileSelection, 268, 263, 300, 117, null);
/* 356 */       currentProfile = 3;
/*     */     } 
/* 361 */     g.drawImage(this.im.profileSquare, 275, 50, 96, 96, null);
/* 362 */     if (Save.save1.exists()) {
/* 363 */       g.setColor(Game.gameProgressColor);
/* 364 */       g.setFont(Game.gameProgressFont);
/* 365 */       g.drawString(
/* 366 */           String.valueOf(Save.save1Progress) + "%", 
/* 367 */           this.im.profileSquare.getWidth() / 2 + 275 - 
/* 368 */           this.fm.stringWidth(String.valueOf(Save.save1Progress) + "%") / 2, 
/* 369 */           110);
/*     */     } else {
/* 371 */       g.setColor(Game.gameProgressColor);
/* 372 */       g.setFont(Game.gameProgressFont);
/* 373 */       g.drawString(
/* 374 */           "?", 
/* 375 */           this.im.profileSquare.getWidth() / 2 + 275 - 
/* 376 */           this.fm.stringWidth("?") / 2, 110);
/*     */     } 
/* 378 */     if (currentProfile == 1) {
/* 379 */       g.setColor(Color.white);
/*     */     } else {
/* 381 */       g.setColor(Game.text1Color);
/*     */     } 
/* 382 */     g.setFont(Game.menuText1_1);
/* 383 */     g.drawString(save1Name, 380, 70);
/* 384 */     g.setFont(Game.menuText1);
/* 385 */     g.drawString("Last Played: " + Save.save1LastPlayed, 380, 103);
/* 386 */     g.drawString("Date Created: " + Save.save1Made, 380, 135);
/* 390 */     g.drawImage(this.im.profileSquare, 275, 160, 96, 96, null);
/* 391 */     if (Save.save2.exists()) {
/* 392 */       g.setColor(Game.gameProgressColor);
/* 393 */       g.setFont(Game.gameProgressFont);
/* 394 */       g.drawString(
/* 395 */           String.valueOf(Save.save2Progress) + "%", 
/* 396 */           this.im.profileSquare.getWidth() / 2 + 275 - 
/* 397 */           this.fm.stringWidth(String.valueOf(Save.save2Progress) + "%") / 2, 
/* 398 */           220);
/*     */     } else {
/* 400 */       g.setColor(Game.gameProgressColor);
/* 401 */       g.setFont(Game.gameProgressFont);
/* 402 */       g.drawString(
/* 403 */           "?", 
/* 404 */           this.im.profileSquare.getWidth() / 2 + 275 - 
/* 405 */           this.fm.stringWidth("?") / 2, 220);
/*     */     } 
/* 407 */     if (currentProfile == 2) {
/* 408 */       g.setColor(Color.white);
/*     */     } else {
/* 410 */       g.setColor(Game.text1Color);
/*     */     } 
/* 411 */     g.setFont(Game.menuText1_1);
/* 412 */     g.drawString(save2Name, 380, 180);
/* 413 */     g.setFont(Game.menuText1);
/* 414 */     g.drawString("Last Played: " + Save.save2LastPlayed, 380, 213);
/* 415 */     g.drawString("Date Created: " + Save.save2Made, 380, 245);
/* 419 */     g.drawImage(this.im.profileSquare, 275, 270, 96, 96, null);
/* 420 */     if (Save.save3.exists()) {
/* 421 */       g.setColor(Game.gameProgressColor);
/* 422 */       g.setFont(Game.gameProgressFont);
/* 423 */       g.drawString(
/* 424 */           String.valueOf(Save.save3Progress) + "%", 
/* 425 */           this.im.profileSquare.getWidth() / 2 + 275 - 
/* 426 */           this.fm.stringWidth(String.valueOf(Save.save3Progress) + "%") / 2, 
/* 427 */           330);
/*     */     } else {
/* 429 */       g.setColor(Game.gameProgressColor);
/* 430 */       g.setFont(Game.gameProgressFont);
/* 431 */       g.drawString(
/* 432 */           "?", 
/* 433 */           this.im.profileSquare.getWidth() / 2 + 275 - 
/* 434 */           this.fm.stringWidth("?") / 2, 330);
/*     */     } 
/* 436 */     if (currentProfile == 3) {
/* 437 */       g.setColor(Color.white);
/*     */     } else {
/* 439 */       g.setColor(Game.text1Color);
/*     */     } 
/* 440 */     g.setFont(Game.menuText1_1);
/* 441 */     g.drawString(save3Name, 380, 290);
/* 442 */     g.setFont(Game.menuText1);
/* 443 */     g.drawString("Last Played: " + Save.save3LastPlayed, 380, 323);
/* 444 */     g.drawString("Date Created: " + Save.save3Made, 380, 355);
/* 446 */     g.setFont(Game.default2);
/* 447 */     g.setColor(Game.text1);
/* 451 */     if (canPlayProfile) {
/* 452 */       drawButton(g, playSelectedState, 
/* 453 */           419 - this.im.button2_1.getWidth() / 2, 425, 
/* 454 */           this.im.button2_1.getWidth(), this.im.button2_1.getHeight(), 
/* 455 */           "Play Selected Profile", this.im.button2_1, this.im.button2_2, 
/* 456 */           this.im.button2_3, 2.1D);
/* 457 */     } else if (!canPlayProfile) {
/* 458 */       g.drawImage(this.im.button2_3, 419 - 
/* 459 */           this.im.button2_3.getWidth() / 2, 425, 
/* 460 */           this.im.button2_3.getWidth(), this.im.button2_3.getHeight(), null);
/* 461 */       g.setColor(Game.text3);
/* 462 */       g.drawString("Play Selected Profile", 324, 446);
/*     */     } 
/* 467 */     if (canDeleteProfile) {
/* 468 */       drawButton(g, deleteState, 419 - 
/* 469 */           this.im.button2_1.getWidth() / 2, 473, 
/* 470 */           this.im.button1_1.getWidth(), this.im.button1_1.getHeight(), 
/* 471 */           "Delete", this.im.button1_1, this.im.button1_2, this.im.button1_3, 2.2D);
/* 472 */     } else if (!canDeleteProfile) {
/* 473 */       g.drawImage(this.im.button1_3, 419 - 
/* 474 */           this.im.button2_1.getWidth() / 2, 473, 
/* 475 */           this.im.button1_3.getWidth(), this.im.button1_3.getHeight(), null);
/* 476 */       g.setColor(Game.text3);
/* 477 */       g.drawString("Delete", 300, 
/* 478 */           473 + this.im.button1_3.getHeight() / 2 + 5);
/*     */     } 
/* 483 */     drawButton(g, cancelState, 419 - this.im.button2_1.getWidth() / 2 + 
/* 484 */         176, 473, this.im.button1_1.getWidth(), 
/* 485 */         this.im.button1_1.getHeight(), "Back", this.im.button1_1, this.im.button1_2, 
/* 486 */         this.im.button1_3, 2.3D);
/*     */   }
/*     */   
/*     */   public void renderState3(Graphics g) {
/* 494 */     g.setFont(Game.menuText3);
/* 495 */     g.setColor(Game.text1Color);
/* 496 */     g.drawString("Are you sure?", 280, 190);
/* 498 */     g.setFont(Game.default2);
/* 500 */     drawButton(g, yesState, 215, 325, this.im.button1_1.getWidth(), 
/* 501 */         this.im.button1_1.getHeight(), "Yes", this.im.button1_1, this.im.button1_2, 
/* 502 */         this.im.button1_3, 3.1D);
/* 504 */     drawButton(g, noState, 454, 325, this.im.button1_1.getWidth(), 
/* 505 */         this.im.button1_1.getHeight(), "No", this.im.button1_1, this.im.button1_2, 
/* 506 */         this.im.button1_3, 3.2D);
/*     */   }
/*     */   
/*     */   public void renderState4(Graphics g) {
/* 515 */     drawButton(g, autoSaveState, 419 - 
/* 516 */         this.im.button2_1.getWidth() + 8, 100, this.im.button2_1.getWidth(), 
/* 517 */         this.im.button2_1.getHeight(), "Auto Save: " + autoSaveToggle, 
/* 518 */         this.im.button2_1, this.im.button2_2, this.im.button2_3, 4.1D);
/* 519 */     g.setColor(Game.text1Color);
/* 520 */     g.setFont(Game.menuText1);
/* 521 */     g.drawString("Turning this option on will enable automatic saving.", 
/* 522 */         72, 156);
/* 525 */     drawButton(g, addOnsState, 
/* 526 */         419 - this.im.button2_1.getWidth() / 2, 373, 
/* 527 */         this.im.button2_1.getWidth(), this.im.button2_1.getHeight(), 
/* 528 */         "Add-Ons...", this.im.button2_1, this.im.button2_2, this.im.button2_3, 4.2D);
/* 531 */     drawButton(g, cancelState, 419 - this.im.button1_1.getWidth() / 2, 
/* 532 */         473, this.im.button1_1.getWidth(), this.im.button1_1.getHeight(), 
/* 533 */         "Back", this.im.button1_1, this.im.button1_2, this.im.button1_3, 2.3D);
/*     */   }
/*     */   
/*     */   public void renderState5(Graphics g) {}
/*     */   
/*     */   public void menuStateIs1_play() {
/* 545 */     menuState = 2;
/* 546 */     Load.loadData1(Game.dataPath);
/*     */   }
/*     */   
/*     */   public void menuStateIs1_options() {
/* 550 */     menuState = 4;
/* 551 */     Load.loadData1(Game.dataPath);
/* 552 */     if (autoSaveToggle == "On" && !Game.autoSave) {
/* 553 */       autoSaveToggle = "Off";
/* 554 */     } else if (autoSaveToggle == "Off" && Game.autoSave) {
/* 555 */       autoSaveToggle = "On";
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void menuStateIs2_playProfile() throws IOException {
/* 561 */     if (currentProfile == 1) {
/* 562 */       if (Save.save1.exists()) {
/* 563 */         Load.loadProfile(Game.save1Path);
/* 564 */         Save.profileSave(Save.save1, Game.save1Path, 1);
/* 565 */         Save.dataSave();
/* 566 */         Game.isInGame = true;
/* 567 */         menuState = 0;
/* 568 */       } else if (!Save.save1.exists()) {
/* 570 */         Save.reset();
/* 571 */         Save.profileSave(Save.save1, Game.save1Path, 1);
/* 572 */         Save.dataSave();
/* 573 */         Game.isInGame = true;
/* 574 */         menuState = 0;
/*     */       } 
/* 576 */     } else if (currentProfile == 2) {
/* 577 */       if (Save.save2.exists()) {
/* 578 */         Load.loadProfile(Game.save2Path);
/* 579 */         Save.profileSave(Save.save2, Game.save2Path, 2);
/* 580 */         Save.dataSave();
/* 581 */         Game.isInGame = true;
/* 582 */         menuState = 0;
/* 583 */       } else if (!Save.save2.exists()) {
/* 585 */         Save.reset();
/* 586 */         Save.profileSave(Save.save2, Game.save2Path, 2);
/* 587 */         Save.dataSave();
/* 588 */         Game.isInGame = true;
/* 589 */         menuState = 0;
/*     */       } 
/* 591 */     } else if (currentProfile == 3) {
/* 592 */       if (Save.save3.exists()) {
/* 593 */         Load.loadProfile(Game.save3Path);
/* 594 */         Save.profileSave(Save.save3, Game.save3Path, 3);
/* 595 */         Save.dataSave();
/* 596 */         Game.isInGame = true;
/* 597 */         menuState = 0;
/* 598 */       } else if (!Save.save3.exists()) {
/* 600 */         Save.reset();
/* 601 */         Save.profileSave(Save.save3, Game.save3Path, 3);
/* 602 */         Save.dataSave();
/* 603 */         Game.isInGame = true;
/* 604 */         menuState = 0;
/*     */       } 
/*     */     } 
/* 607 */     save1State = 0;
/* 608 */     save2State = 0;
/* 609 */     save3State = 0;
/*     */   }
/*     */   
/*     */   public void menuStateIs2_deleteProfile() throws IOException {
/* 615 */     if (currentProfile == 1) {
/* 616 */       Save.save1.delete();
/* 617 */       Save.save1Made = "";
/* 618 */       Save.save1LastPlayed = "";
/* 619 */       Save.dataSave();
/* 620 */     } else if (currentProfile == 2) {
/* 621 */       Save.save2.delete();
/* 622 */       Save.save2Made = "";
/* 623 */       Save.save2LastPlayed = "";
/* 624 */       Save.dataSave();
/* 625 */     } else if (currentProfile == 3) {
/* 626 */       Save.save3.delete();
/* 627 */       Save.save3Made = " ";
/* 628 */       Save.save3LastPlayed = " ";
/* 629 */       Save.dataSave();
/*     */     } 
/* 632 */     menuState = 2;
/* 633 */     currentProfile = 0;
/*     */   }
/*     */   
/*     */   public void menuStateIs2_cancel() {
/* 638 */     save1State = 0;
/* 639 */     save2State = 0;
/* 640 */     save3State = 0;
/* 641 */     currentProfile = 0;
/* 642 */     menuState = 1;
/*     */   }
/*     */   
/*     */   public void menuStateIs3_yes() {
/*     */     try {
/* 648 */       menuStateIs2_deleteProfile();
/* 649 */     } catch (IOException e) {
/* 650 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void menuStateIs3_no() {
/* 657 */     menuState = 2;
/*     */   }
/*     */   
/*     */   public void menuStateIs4_autoSave() {
/* 663 */     if (autoSaveToggle == "On") {
/* 664 */       autoSaveToggle = "Off";
/* 665 */       Game.autoSave = false;
/* 666 */     } else if (autoSaveToggle == "Off") {
/* 667 */       autoSaveToggle = "On";
/* 668 */       Game.autoSave = true;
/*     */     } 
/* 670 */     canPressButton = false;
/*     */     try {
/* 672 */       Save.dataSave();
/* 673 */     } catch (IOException e) {
/* 674 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void menuStateIs4_addOns() {}
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.4.9_2.jar!\beyondOrigins\main\menus\MainMenu.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */