/*     */ package beyondOrigins.main.menus;
/*     */ 
/*     */ import beyondOrigins.files.Load;
/*     */ import beyondOrigins.files.Save;
/*     */ import beyondOrigins.main.Game;
/*     */ import beyondOrigins.main.entities.Player;
/*     */ import beyondOrigins.main.entities.TestDummy;
/*     */ import beyondOrigins.main.gfx.ImageManager;
/*     */ import beyondOrigins.main.windows.About;
/*     */ import beyondOrigins.main.windows.AddOns;
/*     */ import beyondOrigins.main.windows.Update;
/*     */ import beyondOrigins.threads.StoryText;
/*     */ import beyondOrigins.userInput.KeyManager;
/*     */ import beyondOrigins.userInput.MouseMotion;
/*     */ import java.awt.Color;
/*     */ import java.awt.FontMetrics;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ 
/*     */ public class MainMenu {
/*     */   private FontMetrics fm;
/*     */   
/*     */   private FontMetrics fm2;
/*     */   
/*  30 */   public static byte menuState = 1;
/*     */   
/*     */   public static byte state;
/*     */   
/*     */   private ImageManager im;
/*     */   
/*     */   private ImageManager im2;
/*     */   
/*     */   private Update u;
/*     */   
/*     */   private AddOns a;
/*     */   
/*     */   private About ab;
/*     */   
/*  37 */   public static double cloud1x = 850.0D;
/*     */   
/*  38 */   public static double cloud1y = 200.0D;
/*     */   
/*  39 */   public static double cloud2x = 990.0D;
/*     */   
/*  40 */   public static double cloud2y = 22.0D;
/*     */   
/*  41 */   public static double cloud3x = -150.0D;
/*     */   
/*  42 */   public static double cloud3y = 365.0D;
/*     */   
/*  43 */   private static double cloudSpeed = 0.5D;
/*     */   
/*     */   public static byte playState;
/*     */   
/*     */   private static byte optionsState;
/*     */   
/*     */   private static byte updateState;
/*     */   
/*     */   private static byte quitState;
/*     */   
/*  50 */   public static byte currentProfile = 0;
/*     */   
/*     */   public static boolean canPlayProfile = false;
/*     */   
/*     */   public static boolean canDeleteProfile = false;
/*     */   
/*     */   public static byte playSelectedState;
/*     */   
/*     */   public static byte deleteState;
/*     */   
/*     */   public static byte cancelState;
/*     */   
/*     */   public static byte save1State;
/*     */   
/*     */   public static byte save2State;
/*     */   
/*     */   public static byte save3State;
/*     */   
/*  55 */   public static String save1Name = "IfYouSeeThisSomethingIsWrong";
/*     */   
/*  56 */   public static String save2Name = "IfYouSeeThisSomethingIsWrong";
/*     */   
/*  57 */   public static String save3Name = "IfYouSeeThisSomethingIsWrong";
/*     */   
/*     */   public static String save1Name_backup;
/*     */   
/*     */   public static String save2Name_backup;
/*     */   
/*     */   public static String save3Name_backup;
/*     */   
/*     */   public static boolean enterProfile = false;
/*     */   
/*     */   public static byte yesState;
/*     */   
/*     */   public static byte noState;
/*     */   
/*     */   private static byte autoSaveState;
/*     */   
/*     */   private static byte addOnsState;
/*     */   
/*     */   private static byte tdState;
/*     */   
/*  66 */   public static String autoSaveToggle = "On";
/*     */   
/*  66 */   public static String tdToggle = "Off";
/*     */   
/*     */   private static byte createProfileState;
/*     */   
/*     */   public static byte profileNameBoxState;
/*     */   
/*     */   public static byte playerNameBoxState;
/*     */   
/*     */   public static boolean profileNameBoxInFocus = false;
/*     */   
/*     */   public static boolean playerNameBoxInFocus = false;
/*     */   
/*     */   public MainMenu(ImageManager im, ImageManager im2) {
/*  77 */     this.im = im;
/*  78 */     this.im2 = im2;
/*  79 */     this.u = new Update();
/*  80 */     this.a = new AddOns();
/*  81 */     this.ab = new About();
/*     */   }
/*     */   
/*     */   private byte getButtonState(int x, int y, int width, int height, byte state) {
/*  90 */     if (MouseMotion.mouseX >= x && MouseMotion.mouseX < x + width && 
/*  91 */       MouseMotion.mouseY >= y && MouseMotion.mouseY < y + height) {
/*  92 */       state = 2;
/*  93 */       if (Game.isPressed()) {
/*  94 */         state = 3;
/*     */       } else {
/*  96 */         state = 2;
/*     */       } 
/*     */     } else {
/*  98 */       state = 1;
/*     */     } 
/*  99 */     return state;
/*     */   }
/*     */   
/*     */   private byte getGeneralImageState(int x, int y, int width, int height, byte state, boolean inFocus) {
/* 106 */     if (MouseMotion.mouseX >= x && MouseMotion.mouseX < x + width && 
/* 107 */       MouseMotion.mouseY >= y && MouseMotion.mouseY < y + height) {
/* 108 */       if (!inFocus && Game.isPressed()) {
/* 109 */         state = 2;
/* 110 */         inFocus = true;
/* 111 */       } else if (inFocus) {
/* 112 */         state = 2;
/*     */       } 
/* 115 */     } else if (inFocus) {
/* 116 */       state = 2;
/* 118 */     } else if (Game.isPressed()) {
/* 119 */       state = 1;
/* 120 */       inFocus = false;
/*     */     } 
/* 125 */     return state;
/*     */   }
/*     */   
/*     */   private void drawButton(Graphics g, int x, int y, int width, int height, String buttonText, BufferedImage state1Image, BufferedImage state2Image, BufferedImage state3Image, double clickEventType) {
/* 132 */     this.fm = g.getFontMetrics(Game.buttonTextFont);
/* 134 */     g.setFont(Game.buttonTextFont);
/* 135 */     if (getButtonState(x, y, width, height, state) == 1) {
/* 136 */       g.drawImage(state1Image, x, y, width, height, null);
/* 137 */       g.setColor(Game.buttonIdleColor);
/* 138 */       g.drawString(
/* 139 */           buttonText, 
/* 140 */           x + state1Image.getWidth() / 2 - 
/* 141 */           this.fm.stringWidth(buttonText) / 2, y + 
/* 142 */           state1Image.getHeight() / 2 + 5);
/* 143 */     } else if (getButtonState(x, y, width, height, state) == 2) {
/* 144 */       g.drawImage(state2Image, x, y, width, height, null);
/* 145 */       g.setColor(Game.buttonSelectedColor);
/* 146 */       g.drawString(
/* 147 */           buttonText, 
/* 148 */           x + state1Image.getWidth() / 2 - 
/* 149 */           this.fm.stringWidth(buttonText) / 2, y + 
/* 150 */           state1Image.getHeight() / 2 + 5);
/* 151 */     } else if (getButtonState(x, y, width, height, state) == 3) {
/* 152 */       g.drawImage(state3Image, x, y, width, height, null);
/* 153 */       g.setColor(Game.buttonClickedColor);
/* 154 */       g.drawString(
/* 155 */           buttonText, 
/* 156 */           x + state1Image.getWidth() / 2 - 
/* 157 */           this.fm.stringWidth(buttonText) / 2, y + 
/* 158 */           state1Image.getHeight() / 2 + 5);
/* 159 */       clickEventHandler(clickEventType);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void clickEventHandler(double e) {
/* 165 */     if (e == 1.1D) {
/* 166 */       m1Play();
/* 167 */     } else if (e == 1.2D) {
/* 168 */       m1Options();
/* 169 */     } else if (e == 1.3D) {
/* 170 */       m1Update();
/* 171 */     } else if (e == 1.4D) {
/* 172 */       m1Quit();
/*     */     } 
/* 175 */     if (e == 2.1D) {
/*     */       try {
/* 177 */         m2PlayProfile();
/* 178 */       } catch (IOException ei) {
/* 179 */         ei.printStackTrace();
/*     */       } 
/* 181 */     } else if (e == 2.2D) {
/* 182 */       menuState = 3;
/* 183 */     } else if (e == 2.3D) {
/* 184 */       m2Back();
/*     */     } 
/* 187 */     if (e == 3.1D) {
/* 188 */       m3Yes();
/* 189 */     } else if (e == 3.2D) {
/* 190 */       m3No();
/*     */     } 
/* 193 */     if (e == 4.1D) {
/* 194 */       m4AutoSave();
/* 195 */     } else if (e == 4.2D) {
/* 196 */       m4AddOns();
/* 197 */     } else if (e == 4.3D) {
/* 198 */       m4TestDummy();
/* 199 */     } else if (e == 4.4D) {
/* 200 */       m4Reload();
/* 201 */     } else if (e == 4.5D) {
/* 202 */       m4About();
/*     */     } 
/* 205 */     if (e == 5.1D) {
/*     */       try {
/* 207 */         if (currentProfile == 1) {
/* 208 */           m5CreateProfile(Save.save1, Game.save1Path);
/* 209 */         } else if (currentProfile == 2) {
/* 210 */           m5CreateProfile(Save.save2, Game.save2Path);
/* 211 */         } else if (currentProfile == 3) {
/* 212 */           m5CreateProfile(Save.save3, Game.save3Path);
/*     */         } 
/* 214 */       } catch (IOException ei) {
/* 215 */         ei.printStackTrace();
/*     */       } 
/* 217 */     } else if (e == 5.2D) {
/* 218 */       Game.endClick();
/* 219 */       menuState = 2;
/* 220 */       currentProfile = 0;
/*     */     } 
/*     */   }
/*     */   
/*     */   private void drawProfile(Graphics g, byte state, int x, int y, String lastPlayed, String created, File file, int profileNumber, String name, FontMetrics fm) {
/* 227 */     g.drawImage(this.im.profileSquare, x, y, this.im.profileSquare.getWidth(), 
/* 228 */         this.im.profileSquare.getHeight(), null);
/* 229 */     g.setColor(Game.gameProgressColor);
/* 230 */     g.setFont(Game.gameProgressFont);
/* 231 */     if (file.exists()) {
/* 232 */       g.drawImage(
/* 233 */           this.im2.playerd1, 
/* 234 */           this.im.profileSquare.getWidth() / 2 + x - 
/* 235 */           this.im2.playerd1.getWidth(), 
/* 236 */           y + this.im.profileSquare.getHeight() / 2 - 
/* 237 */           this.im2.playerd1.getHeight(), 64, 64, null);
/* 238 */     } else if (!file.exists()) {
/* 239 */       g.drawString(
/* 240 */           "?", 
/* 241 */           this.im.profileSquare.getWidth() / 2 + x - 
/* 242 */           fm.stringWidth("?") / 2, profileNumber * 110);
/*     */     } 
/* 244 */     if (currentProfile == profileNumber) {
/* 245 */       g.setColor(Color.white);
/*     */     } else {
/* 247 */       g.setColor(Game.profileInfoColor);
/*     */     } 
/* 249 */     g.setFont(Game.profileNameFont);
/* 250 */     g.drawString(name, 380, profileNumber * 110 - 40);
/* 251 */     g.setFont(Game.profileInfoFont);
/* 252 */     g.drawString("Last Played: " + lastPlayed, 380, 
/* 253 */         profileNumber * 110 - 40 + 33);
/* 254 */     g.drawString("Date Created: " + created, 380, 
/* 255 */         profileNumber * 110 - 40 + 66);
/*     */   }
/*     */   
/*     */   private void draw3WayTextBox(Graphics g, byte state, int x, int y, int w, int h, String t1, String t2, String t3, String info, int optionalParam) {
/* 263 */     this.fm = g.getFontMetrics(Game.buttonTextFont);
/* 265 */     g.setColor(Game.profileInfoColor);
/* 266 */     g.setFont(Game.profileInfoFont);
/* 268 */     g.drawString(info, x, y - 9);
/* 270 */     g.setColor(new Color(232, 232, 232));
/* 271 */     g.drawRect(x + 1, y + 1, w - 2, h - 2);
/* 272 */     g.drawRect(x, y, w, h);
/* 274 */     g.setColor(new Color(0, 0, 0, 180));
/* 275 */     g.fillRect(x + 2, y + 2, w - 3, h - 3);
/* 277 */     g.setFont(Game.buttonTextFont);
/* 278 */     g.setColor(Color.white);
/* 279 */     if (optionalParam == 1) {
/* 280 */       g.drawString(t1, x + 8, y + 24);
/* 281 */       if (state == 2)
/* 282 */         g.drawString("_", x + 8 + this.fm.stringWidth(t1), y + 24); 
/* 284 */     } else if (optionalParam == 2) {
/* 285 */       g.drawString(t2, x + 8, y + 24);
/* 286 */       if (state == 2)
/* 287 */         g.drawString("_", x + 8 + this.fm.stringWidth(t2), y + 24); 
/* 289 */     } else if (optionalParam == 3) {
/* 290 */       g.drawString(t3, x + 8, y + 24);
/* 291 */       if (state == 2)
/* 292 */         g.drawString("_", x + 8 + this.fm.stringWidth(t3), y + 24); 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void drawTextBox(Graphics g, byte state, int x, int y, int w, int h, String t, String info) {
/* 301 */     g.setColor(Game.profileInfoColor);
/* 302 */     g.setFont(Game.profileInfoFont);
/* 305 */     g.drawString(info, x, y - 9);
/* 308 */     g.setColor(new Color(232, 232, 232));
/* 309 */     g.drawRect(x + 1, y + 1, w - 2, h - 2);
/* 310 */     g.drawRect(x, y, w, h);
/* 313 */     g.setColor(new Color(0, 0, 0, 180));
/* 314 */     g.fillRect(x + 2, y + 2, w - 3, h - 3);
/* 317 */     g.setFont(Game.buttonTextFont);
/* 318 */     g.setColor(Color.white);
/* 321 */     g.drawString(t, x + 8, y + 24);
/* 322 */     if (state == 2)
/* 323 */       g.drawString("_", x + 8 + this.fm.stringWidth(t), y + 24); 
/*     */   }
/*     */   
/*     */   private static void drawCloud(Graphics g, int number, BufferedImage image) {
/* 328 */     if (number == 1) {
/* 329 */       g.drawImage(image, (int)cloud1x, (int)cloud1y, image.getWidth(), 
/* 330 */           image.getHeight(), null);
/* 331 */     } else if (number == 2) {
/* 332 */       g.drawImage(image, (int)cloud2x, (int)cloud2y, image.getWidth(), 
/* 333 */           image.getHeight(), null);
/* 334 */     } else if (number == 3) {
/* 335 */       g.drawImage(image, (int)cloud3x, (int)cloud3y, image.getWidth(), 
/* 336 */           image.getHeight(), null);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void moveClouds() {
/* 342 */     if (cloud1x > -150.0D) {
/* 343 */       cloud1x -= cloudSpeed + 0.1D;
/*     */     } else {
/* 345 */       cloud1x = 850.0D;
/* 346 */       cloud1y = 200.0D;
/*     */     } 
/* 350 */     if (cloud2x > -125.0D) {
/* 351 */       cloud2x -= cloudSpeed;
/*     */     } else {
/* 353 */       cloud2x = 990.0D;
/* 354 */       cloud2y = 22.0D;
/*     */     } 
/* 358 */     if (cloud3x <= 828.0D) {
/* 359 */       cloud3x += cloudSpeed;
/*     */     } else {
/* 361 */       cloud3x = -150.0D;
/* 362 */       cloud3y = 365.0D;
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void enterGame() {
/* 367 */     Game.isInGame = true;
/* 368 */     menuState = 0;
/* 369 */     KeyManager.enterPressed = false;
/* 370 */     Player.up = false;
/* 371 */     Player.down = false;
/* 372 */     Player.left = false;
/* 373 */     Player.right = false;
/*     */   }
/*     */   
/*     */   public void tick() {
/* 380 */     if (menuState == 2)
/* 381 */       profileTick(); 
/* 384 */     moveClouds();
/*     */   }
/*     */   
/*     */   private void profileTick() {
/* 391 */     if (!Save.save1.exists()) {
/* 392 */       save1Name = "Play To Create Me";
/* 393 */     } else if (Save.save1.exists()) {
/* 394 */       save1Name = save1Name_backup;
/*     */     } 
/* 397 */     if (!Save.save2.exists()) {
/* 398 */       save2Name = "Play To Create Me";
/* 399 */     } else if (Save.save2.exists()) {
/* 400 */       save2Name = save2Name_backup;
/*     */     } 
/* 403 */     if (!Save.save3.exists()) {
/* 404 */       save3Name = "Play To Create Me";
/* 405 */     } else if (Save.save3.exists()) {
/* 406 */       save3Name = save3Name_backup;
/*     */     } 
/* 410 */     if (save1State == 3 || save2State == 3 || save3State == 3) {
/* 411 */       canPlayProfile = true;
/* 413 */     } else if (save1State == 0 && save2State == 0 && save3State == 0) {
/* 414 */       canPlayProfile = false;
/*     */     } 
/* 419 */     if (currentProfile == 0)
/* 420 */       canDeleteProfile = false; 
/* 423 */     if (currentProfile == 1 && !Save.save1.exists()) {
/* 424 */       canDeleteProfile = false;
/* 425 */     } else if (currentProfile == 1 && Save.save1.exists()) {
/* 426 */       canDeleteProfile = true;
/*     */     } 
/* 429 */     if (currentProfile == 2 && !Save.save2.exists()) {
/* 430 */       canDeleteProfile = false;
/* 431 */     } else if (currentProfile == 2 && Save.save2.exists()) {
/* 432 */       canDeleteProfile = true;
/*     */     } 
/* 435 */     if (currentProfile == 3 && !Save.save3.exists()) {
/* 436 */       canDeleteProfile = false;
/* 437 */     } else if (currentProfile == 3 && Save.save3.exists()) {
/* 438 */       canDeleteProfile = true;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void renderMain(Graphics g) {
/* 446 */     g.setColor(Game.skyColor);
/* 447 */     g.fillRect(0, 0, 838, 573);
/* 450 */     drawCloud(g, 1, this.im.cloud1);
/* 451 */     drawCloud(g, 2, this.im.cloud2);
/* 452 */     drawCloud(g, 3, this.im.cloud3);
/* 454 */     if (menuState == 1) {
/* 455 */       renderState1(g);
/* 456 */     } else if (menuState == 2) {
/* 457 */       renderState2(g);
/* 458 */     } else if (menuState == 3) {
/* 459 */       renderState3(g);
/* 460 */     } else if (menuState == 4) {
/* 461 */       renderState4(g);
/* 462 */     } else if (menuState == 5) {
/* 463 */       renderState5(g);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void renderState1(Graphics g) {
/* 474 */     this.fm = g.getFontMetrics(Game.profileInfoFont);
/* 475 */     this.fm2 = g.getFontMetrics(Game.buttonTextFont);
/* 478 */     g.drawImage(Game.logoImage, 419 - Game.logoImage.getWidth(), 
/* 479 */         20, Game.logoImage.getWidth() * 2, 
/* 480 */         Game.logoImage.getHeight() * 2, null);
/* 483 */     g.setFont(Game.profileInfoFont);
/* 484 */     g.setColor(Game.profileInfoColor);
/* 485 */     g.drawString(Game.identifer, 
/* 486 */         419 - this.fm.stringWidth(Game.identifer) / 2, 415);
/* 489 */     g.setFont(Game.buttonTextFont);
/* 490 */     g.setColor(Color.white);
/* 491 */     g.drawString(Game.title, 5, 535);
/* 492 */     g.drawString(Game.copyright, 
/* 493 */         838 - this.fm2.stringWidth(Game.copyright) + 10, 535);
/* 496 */     drawButton(g, 251, 254, 336, 32, "Play", this.im.button2_1, 
/* 497 */         this.im.button2_2, this.im.button2_3, 1.1D);
/* 500 */     drawButton(g, 251, 302, this.im.button2_1.getWidth(), 
/* 501 */         this.im.button2_1.getHeight(), "Options", this.im.button2_1, 
/* 502 */         this.im.button2_2, this.im.button2_3, 1.2D);
/* 505 */     drawButton(g, 419 - this.im.button1_1.getWidth() + 8, 
/* 506 */         350, this.im.button1_1.getWidth(), 
/* 507 */         this.im.button1_1.getHeight(), "Update...", this.im.button1_1, 
/* 508 */         this.im.button1_2, this.im.button1_3, 1.3D);
/* 511 */     drawButton(g, 427, 350, this.im.button1_1.getWidth(), 
/* 512 */         this.im.button1_1.getHeight(), "Quit Game", this.im.button1_1, 
/* 513 */         this.im.button1_2, this.im.button1_3, 1.4D);
/*     */   }
/*     */   
/*     */   private void renderState2(Graphics g) {
/* 521 */     this.fm = g.getFontMetrics(Game.gameProgressFont);
/* 523 */     g.setFont(Game.profileInfoFont);
/* 524 */     g.setColor(Game.profileInfoColor);
/* 528 */     if (save1State == 3) {
/* 529 */       g.drawImage(this.im.profileSelection, 268, 43, 300, 117, null);
/* 530 */       currentProfile = 1;
/* 531 */     } else if (save2State == 3) {
/* 532 */       g.drawImage(this.im.profileSelection, 268, 153, 300, 117, null);
/* 533 */       currentProfile = 2;
/* 534 */     } else if (save3State == 3) {
/* 535 */       g.drawImage(this.im.profileSelection, 268, 263, 300, 117, null);
/* 536 */       currentProfile = 3;
/*     */     } 
/* 541 */     drawProfile(g, save1State, 275, 50, Save.save1LastPlayed, 
/* 542 */         Save.save1Made, Save.save1, 1, save1Name, this.fm);
/* 544 */     drawProfile(g, save2State, 275, 160, Save.save2LastPlayed, 
/* 545 */         Save.save2Made, Save.save2, 2, save2Name, this.fm);
/* 547 */     drawProfile(g, save3State, 275, 270, Save.save3LastPlayed, 
/* 548 */         Save.save3Made, Save.save3, 3, save3Name, this.fm);
/* 551 */     g.setColor(Game.profileInfoColor);
/* 552 */     g.setFont(Game.profileInfoFont);
/* 553 */     g.drawString("Use the WS or up and down keys to select a profile.", 
/* 554 */         498, 535);
/* 558 */     if (canPlayProfile) {
/* 559 */       drawButton(g, 419 - this.im.button2_1.getWidth() / 2, 425, 
/* 560 */           this.im.button2_1.getWidth(), this.im.button2_1.getHeight(), 
/* 561 */           "Play Selected Profile", this.im.button2_1, this.im.button2_2, 
/* 562 */           this.im.button2_3, 2.1D);
/* 563 */     } else if (!canPlayProfile) {
/* 564 */       g.setFont(Game.buttonTextFont);
/* 565 */       g.drawImage(this.im.button2_3, 419 - 
/* 566 */           this.im.button2_3.getWidth() / 2, 425, 
/* 567 */           this.im.button2_3.getWidth(), this.im.button2_3.getHeight(), null);
/* 568 */       g.setColor(Game.buttonClickedColor);
/* 569 */       g.drawString("Play Selected Profile", 324, 446);
/*     */     } 
/* 574 */     if (canDeleteProfile) {
/* 575 */       drawButton(g, 419 - this.im.button2_1.getWidth() / 2, 473, 
/* 576 */           this.im.button1_1.getWidth(), this.im.button1_1.getHeight(), 
/* 577 */           "Delete", this.im.button1_1, this.im.button1_2, this.im.button1_3, 2.2D);
/* 578 */     } else if (!canDeleteProfile) {
/* 579 */       g.setFont(Game.buttonTextFont);
/* 580 */       g.drawImage(this.im.button1_3, 419 - 
/* 581 */           this.im.button2_1.getWidth() / 2, 473, 
/* 582 */           this.im.button1_3.getWidth(), this.im.button1_3.getHeight(), null);
/* 583 */       g.setColor(Game.buttonClickedColor);
/* 584 */       g.drawString("Delete", 300, 
/* 585 */           473 + this.im.button1_3.getHeight() / 2 + 5);
/*     */     } 
/* 590 */     drawButton(g, 419 - this.im.button2_1.getWidth() / 2 + 176, 
/* 591 */         473, this.im.button1_1.getWidth(), this.im.button1_1.getHeight(), 
/* 592 */         "Back", this.im.button1_1, this.im.button1_2, this.im.button1_3, 2.3D);
/*     */   }
/*     */   
/*     */   private void renderState3(Graphics g) {
/* 600 */     g.setFont(Game.areYouSureFont);
/* 601 */     g.setColor(Game.profileInfoColor);
/* 602 */     g.drawString("Are you sure?", 280, 190);
/* 604 */     g.setFont(Game.buttonTextFont);
/* 606 */     drawButton(g, 215, 325, this.im.button1_1.getWidth(), 
/* 607 */         this.im.button1_1.getHeight(), "Yes", this.im.button1_1, this.im.button1_2, 
/* 608 */         this.im.button1_3, 3.1D);
/* 610 */     drawButton(g, 454, 325, this.im.button1_1.getWidth(), 
/* 611 */         this.im.button1_1.getHeight(), "No", this.im.button1_1, this.im.button1_2, 
/* 612 */         this.im.button1_3, 3.2D);
/*     */   }
/*     */   
/*     */   private void renderState4(Graphics g) {
/* 620 */     this.fm = g.getFontMetrics(Game.profileInfoFont);
/* 623 */     drawButton(g, 419 - this.im.button2_1.getWidth() + 8, 100, 
/* 624 */         this.im.button2_1.getWidth(), this.im.button2_1.getHeight(), 
/* 625 */         "Auto Save: " + autoSaveToggle, this.im.button2_1, this.im.button2_2, 
/* 626 */         this.im.button2_3, 4.1D);
/* 627 */     g.setColor(Game.profileInfoColor);
/* 628 */     g.setFont(Game.profileInfoFont);
/* 631 */     drawButton(g, 427, 100, this.im.button2_1.getWidth(), 
/* 632 */         this.im.button2_1.getHeight(), "Test Dummy: " + tdToggle, 
/* 633 */         this.im.button2_1, this.im.button2_2, this.im.button2_3, 4.3D);
/* 636 */     drawButton(g, 419 - this.im.button2_1.getWidth() + 8, 148, 
/* 637 */         this.im.button2_1.getWidth(), this.im.button2_1.getHeight(), 
/* 638 */         "Reload Graphics", this.im.button2_1, this.im.button2_2, this.im.button2_3, 
/* 639 */         4.4D);
/* 642 */     drawButton(g, 419 - this.im.button1_1.getWidth() / 2, 450, 
/* 643 */         this.im.button1_1.getWidth(), this.im.button1_1.getHeight(), "About", 
/* 644 */         this.im.button1_1, this.im.button1_2, this.im.button1_3, 4.5D);
/* 647 */     g.setFont(Game.profileInfoFont);
/* 648 */     g.setColor(Game.profileInfoColor);
/* 649 */     drawButton(g, 419 - this.im.button2_1.getWidth() / 2, 498, 
/* 650 */         this.im.button1_1.getWidth(), this.im.button1_1.getHeight(), 
/* 651 */         "Add-Ons...", this.im.button1_1, this.im.button1_2, this.im.button1_3, 4.2D);
/* 654 */     drawButton(g, 419 - this.im.button2_1.getWidth() / 2 + 176, 
/* 655 */         498, this.im.button1_1.getWidth(), this.im.button1_1.getHeight(), 
/* 656 */         "Back", this.im.button1_1, this.im.button1_2, this.im.button1_3, 2.3D);
/*     */   }
/*     */   
/*     */   private void renderState5(Graphics g) {
/* 664 */     profileNameBoxState = getGeneralImageState(
/* 665 */         419 - this.im.button2_1.getWidth() / 2 - 1, 89, 
/* 666 */         this.im.button2_1.getWidth() + 2, this.im.button2_1.getHeight() + 2, 
/* 667 */         profileNameBoxState, profileNameBoxInFocus);
/* 669 */     playerNameBoxState = getGeneralImageState(
/* 670 */         419 - this.im.button2_1.getWidth() / 2 - 1, 172, 
/* 671 */         this.im.button2_1.getWidth() + 2, this.im.button2_1.getHeight() + 2, 
/* 672 */         playerNameBoxState, playerNameBoxInFocus);
/* 675 */     draw3WayTextBox(g, profileNameBoxState, 
/* 676 */         419 - this.im.button2_1.getWidth() / 2 - 1, 89, 
/* 677 */         this.im.button2_1.getWidth() + 2, this.im.button2_1.getHeight() + 2, 
/* 678 */         save1Name, save2Name, save3Name, "Profile Name: ", 
/* 679 */         currentProfile);
/* 681 */     drawTextBox(g, playerNameBoxState, 
/* 682 */         419 - this.im.button2_1.getWidth() / 2 - 1, 172, 
/* 683 */         this.im.button2_1.getWidth() + 2, this.im.button2_1.getHeight() + 2, 
/* 684 */         Player.typedName, 
/* 685 */         "Character's Name (Cannot change after this!)");
/* 688 */     drawButton(g, 419 - this.im.button2_1.getWidth() / 2, 437, 
/* 689 */         this.im.button1_1.getWidth(), this.im.button1_1.getHeight(), 
/* 690 */         "Create Profile", this.im.button1_1, this.im.button1_2, this.im.button1_3, 5.1D);
/* 693 */     drawButton(
/* 694 */         g, 
/* 695 */         419 - 
/* 696 */         this.im.button2_1.getWidth() / 2 - this.im.button1_1
/* 697 */         .getWidth() + 16, 437, 
/* 698 */         this.im.button1_1.getWidth(), this.im.button1_1.getHeight(), "Back", 
/* 699 */         this.im.button1_1, this.im.button1_2, this.im.button1_3, 5.2D);
/*     */   }
/*     */   
/*     */   private void m1Play() {
/* 706 */     menuState = 2;
/* 707 */     Load.loadData1(Game.dataPath);
/*     */   }
/*     */   
/*     */   private void m1Options() {
/* 711 */     menuState = 4;
/* 712 */     Load.loadData1(Game.dataPath);
/* 714 */     if (autoSaveToggle == "On" && !Game.autoSave) {
/* 715 */       autoSaveToggle = "Off";
/* 716 */     } else if (autoSaveToggle == "Off" && Game.autoSave) {
/* 717 */       autoSaveToggle = "On";
/*     */     } 
/* 721 */     if (tdToggle == "On" && !Game.dummy) {
/* 722 */       tdToggle = "Off";
/* 723 */     } else if (tdToggle == "Off" && Game.dummy) {
/* 724 */       tdToggle = "On";
/*     */     } 
/*     */   }
/*     */   
/*     */   private void m1Update() {
/* 729 */     Game.endClick();
/* 730 */     this.u.createWindow();
/*     */   }
/*     */   
/*     */   private void m1Quit() {
/* 734 */     System.exit(0);
/*     */   }
/*     */   
/*     */   public static void m2PlayProfile() throws IOException {
/* 739 */     if (currentProfile == 1) {
/* 740 */       if (Save.save1.exists()) {
/* 741 */         Load.loadProfile(Game.save1Path);
/* 742 */         Save.profileSave(Save.save1, Game.save1Path, 1);
/* 743 */         enterGame();
/* 744 */       } else if (!Save.save1.exists()) {
/* 745 */         save1Name = "";
/* 746 */         Player.typedName = "";
/* 747 */         cancelState = 0;
/* 748 */         menuState = 5;
/*     */       } 
/* 750 */     } else if (currentProfile == 2) {
/* 751 */       if (Save.save2.exists()) {
/* 752 */         Load.loadProfile(Game.save2Path);
/* 753 */         Save.profileSave(Save.save2, Game.save2Path, 2);
/* 754 */         enterGame();
/* 755 */       } else if (!Save.save2.exists()) {
/* 756 */         save2Name = "";
/* 757 */         Player.typedName = "";
/* 758 */         cancelState = 0;
/* 759 */         menuState = 5;
/*     */       } 
/* 761 */     } else if (currentProfile == 3) {
/* 762 */       if (Save.save3.exists()) {
/* 763 */         Load.loadProfile(Game.save3Path);
/* 764 */         Save.profileSave(Save.save3, Game.save3Path, 3);
/* 765 */         enterGame();
/* 766 */       } else if (!Save.save3.exists()) {
/* 767 */         save3Name = "";
/* 768 */         Player.typedName = "";
/* 769 */         cancelState = 0;
/* 770 */         menuState = 5;
/*     */       } 
/*     */     } 
/* 773 */     Game.endClick();
/* 774 */     TestDummy.isDead = false;
/* 775 */     TestDummy.health = 20.0D;
/* 776 */     save1State = 0;
/* 777 */     save2State = 0;
/* 778 */     save3State = 0;
/*     */   }
/*     */   
/*     */   private void m2DeleteProfile() throws IOException {
/* 784 */     if (currentProfile == 1) {
/* 785 */       Save.save1.delete();
/* 786 */       Save.save1Made = "";
/* 787 */       Save.save1LastPlayed = "";
/* 788 */       Save.dataSave();
/* 789 */     } else if (currentProfile == 2) {
/* 790 */       Save.save2.delete();
/* 791 */       Save.save2Made = "";
/* 792 */       Save.save2LastPlayed = "";
/* 793 */       Save.dataSave();
/* 794 */     } else if (currentProfile == 3) {
/* 795 */       Save.save3.delete();
/* 796 */       Save.save3Made = " ";
/* 797 */       Save.save3LastPlayed = " ";
/* 798 */       Save.dataSave();
/*     */     } 
/* 801 */     menuState = 2;
/* 802 */     currentProfile = 0;
/*     */   }
/*     */   
/*     */   private void m2Back() {
/* 807 */     save1State = 0;
/* 808 */     save2State = 0;
/* 809 */     save3State = 0;
/* 810 */     currentProfile = 0;
/* 811 */     menuState = 1;
/*     */   }
/*     */   
/*     */   private void m3Yes() {
/*     */     try {
/* 817 */       m2DeleteProfile();
/* 818 */     } catch (IOException e) {
/* 819 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   private void m3No() {
/* 825 */     menuState = 2;
/*     */   }
/*     */   
/*     */   private void m4AutoSave() {
/* 829 */     if (autoSaveToggle == "On") {
/* 830 */       autoSaveToggle = "Off";
/* 831 */       Game.autoSave = false;
/* 832 */     } else if (autoSaveToggle == "Off") {
/* 833 */       autoSaveToggle = "On";
/* 834 */       Game.autoSave = true;
/*     */     } 
/* 836 */     Game.endClick();
/*     */     try {
/* 838 */       Save.dataSave();
/* 839 */     } catch (IOException e) {
/* 840 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   private void m4TestDummy() {
/* 845 */     if (tdToggle == "On") {
/* 846 */       tdToggle = "Off";
/* 847 */       Game.dummy = false;
/* 848 */     } else if (tdToggle == "Off") {
/* 849 */       tdToggle = "On";
/* 850 */       Game.dummy = true;
/*     */     } 
/* 852 */     Game.endClick();
/*     */     try {
/* 854 */       Save.dataSave();
/* 855 */     } catch (IOException e) {
/* 856 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   private void m4AddOns() {
/* 861 */     this.a.createWindow();
/* 862 */     Game.endClick();
/*     */   }
/*     */   
/*     */   private void m4Reload() {
/* 866 */     Game.loadGfx();
/*     */   }
/*     */   
/*     */   private void m4About() {
/* 870 */     this.ab.createWindow();
/* 871 */     Game.endClick();
/*     */   }
/*     */   
/*     */   private void m5CreateProfile(File save, String path) throws IOException {
/* 875 */     Save.reset();
/* 876 */     if (currentProfile == 1 && save1Name.length() == 0) {
/* 877 */       save1Name = "Profile 1";
/* 878 */       save1Name_backup = save1Name;
/* 879 */     } else if (currentProfile == 2 && save2Name.length() == 0) {
/* 880 */       save2Name = "Profile 2";
/* 881 */       save2Name_backup = save2Name;
/* 882 */     } else if (currentProfile == 3 && save3Name.length() == 0) {
/* 883 */       save3Name = "Profile 3";
/* 884 */       save3Name_backup = save3Name;
/*     */     } 
/* 886 */     if (Player.typedName.length() == 0) {
/* 887 */       Player.name = Player.defaultName;
/* 888 */     } else if (Player.typedName.length() >= 1) {
/* 889 */       Player.name = Player.typedName;
/*     */     } 
/* 891 */     Save.profileSave(save, path, currentProfile);
/* 892 */     Save.dataSave();
/* 893 */     Load.loadProfile(path);
/* 894 */     createProfileState = 0;
/* 895 */     enterGame();
/* 896 */     StoryText.request("Our story begins within a town called " + 
/* 897 */         Game.townName, 
/* 898 */         "For centuries, each generation has lived in peace, but", 
/* 899 */         "today, something will happen, something big.", 
/* 900 */         "It will distrub the natural balance of " + Game.townName + 
/* 901 */         " and its people.", "", 
/* 902 */         "One the first day, there was darkness.", "");
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.5_5.jar!\beyondOrigins\main\menus\MainMenu.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */