/*     */ package beyondOrigins.main.menus;
/*     */ 
/*     */ import beyondOrigins.files.Load;
/*     */ import beyondOrigins.files.Save;
/*     */ import beyondOrigins.main.Game;
/*     */ import beyondOrigins.main.Update;
/*     */ import beyondOrigins.main.entities.Player;
/*     */ import beyondOrigins.main.gfx.ImageManager;
/*     */ import beyondOrigins.threads.StoryText;
/*     */ import beyondOrigins.userInput.KeyManager;
/*     */ import beyondOrigins.userInput.MouseManager;
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
/*  27 */   public static byte menuState = 1;
/*     */   
/*     */   private ImageManager im;
/*     */   
/*     */   private ImageManager im2;
/*     */   
/*     */   private Update u;
/*     */   
/*  32 */   public static double cloud1x = 850.0D;
/*     */   
/*  33 */   public static double cloud1y = 200.0D;
/*     */   
/*  34 */   public static double cloud2x = 990.0D;
/*     */   
/*  35 */   public static double cloud2y = 22.0D;
/*     */   
/*  36 */   public static double cloud3x = -150.0D;
/*     */   
/*  37 */   public static double cloud3y = 365.0D;
/*     */   
/*  38 */   private static double cloudSpeed = 0.5D;
/*     */   
/*     */   public static byte playState;
/*     */   
/*     */   private static byte optionsState;
/*     */   
/*     */   private static byte updateState;
/*     */   
/*     */   private static byte quitState;
/*     */   
/*  45 */   public static byte currentProfile = 0;
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
/*  50 */   public static String save1Name = "IfYouSeeThisSomethingIsWrong";
/*     */   
/*  51 */   public static String save2Name = "IfYouSeeThisSomethingIsWrong";
/*     */   
/*  52 */   public static String save3Name = "IfYouSeeThisSomethingIsWrong";
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
/*  61 */   public static String autoSaveToggle = "On";
/*     */   
/*  61 */   public static String tdToggle = "Off";
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
/*  72 */     this.im = im;
/*  73 */     this.im2 = im2;
/*     */   }
/*     */   
/*     */   public void init() {
/*  79 */     this.u = new Update();
/*     */   }
/*     */   
/*     */   private byte getButtonState(int x, int y, int width, int height, byte state) {
/*  88 */     if (MouseMotion.mouseX >= x && MouseMotion.mouseX < x + width && 
/*  89 */       MouseMotion.mouseY >= y && MouseMotion.mouseY < y + height) {
/*  90 */       state = 2;
/*  91 */       if (MouseManager.mouseFullClick == 1) {
/*  92 */         state = 3;
/*     */       } else {
/*  94 */         state = 2;
/*     */       } 
/*     */     } else {
/*  96 */       state = 1;
/*     */     } 
/*  97 */     return state;
/*     */   }
/*     */   
/*     */   private byte getGeneralImageState(int x, int y, int width, int height, byte state, boolean inFocus) {
/* 104 */     if (MouseMotion.mouseX >= x && MouseMotion.mouseX < x + width && 
/* 105 */       MouseMotion.mouseY >= y && MouseMotion.mouseY < y + height) {
/* 106 */       if (!inFocus && MouseManager.mouseFullClick == 1) {
/* 107 */         state = 2;
/* 108 */         inFocus = true;
/* 109 */       } else if (inFocus) {
/* 110 */         state = 2;
/*     */       } 
/* 113 */     } else if (inFocus) {
/* 114 */       state = 2;
/* 116 */     } else if (MouseManager.mouseFullClick == 1) {
/* 117 */       state = 1;
/* 118 */       inFocus = false;
/*     */     } 
/* 123 */     return state;
/*     */   }
/*     */   
/*     */   private void drawButton(Graphics g, byte state, int x, int y, int width, int height, String buttonText, BufferedImage state1Image, BufferedImage state2Image, BufferedImage state3Image, double clickEventType) {
/* 130 */     this.fm = g.getFontMetrics(Game.buttonTextFont);
/* 131 */     g.setFont(Game.buttonTextFont);
/* 132 */     if (getButtonState(x, y, width, height, state) == 1) {
/* 133 */       g.drawImage(state1Image, x, y, width, height, null);
/* 134 */       g.setColor(Game.buttonIdleColor);
/* 135 */       g.drawString(
/* 136 */           buttonText, 
/* 137 */           x + state1Image.getWidth() / 2 - 
/* 138 */           this.fm.stringWidth(buttonText) / 2, y + 
/* 139 */           state1Image.getHeight() / 2 + 5);
/* 140 */     } else if (getButtonState(x, y, width, height, state) == 2) {
/* 141 */       g.drawImage(state2Image, x, y, width, height, null);
/* 142 */       g.setColor(Game.buttonSelectedColor);
/* 143 */       g.drawString(
/* 144 */           buttonText, 
/* 145 */           x + state1Image.getWidth() / 2 - 
/* 146 */           this.fm.stringWidth(buttonText) / 2, y + 
/* 147 */           state1Image.getHeight() / 2 + 5);
/* 148 */     } else if (getButtonState(x, y, width, height, state) == 3) {
/* 149 */       g.drawImage(state3Image, x, y, width, height, null);
/* 150 */       g.setColor(Game.buttonClickedColor);
/* 151 */       g.drawString(
/* 152 */           buttonText, 
/* 153 */           x + state1Image.getWidth() / 2 - 
/* 154 */           this.fm.stringWidth(buttonText) / 2, y + 
/* 155 */           state1Image.getHeight() / 2 + 5);
/* 157 */       if (clickEventType == 1.1D) {
/* 158 */         m1Play();
/* 159 */       } else if (clickEventType == 1.2D) {
/* 160 */         m1Options();
/* 161 */       } else if (clickEventType == 1.3D) {
/* 162 */         m1Update();
/* 163 */       } else if (clickEventType == 1.4D) {
/* 164 */         m1Quit();
/*     */       } 
/* 167 */       if (clickEventType == 2.1D) {
/*     */         try {
/* 169 */           m2PlayProfile();
/* 170 */         } catch (IOException e) {
/* 171 */           e.printStackTrace();
/*     */         } 
/* 173 */       } else if (clickEventType == 2.2D) {
/* 174 */         menuState = 3;
/* 175 */       } else if (clickEventType == 2.3D) {
/* 176 */         m2Back();
/*     */       } 
/* 179 */       if (clickEventType == 3.1D) {
/* 180 */         m3Yes();
/* 181 */       } else if (clickEventType == 3.2D) {
/* 182 */         m3No();
/*     */       } 
/* 185 */       if (clickEventType == 4.1D) {
/* 186 */         m4AutoSave();
/* 187 */       } else if (clickEventType == 4.2D) {
/* 188 */         m4AddOns();
/* 189 */       } else if (clickEventType == 4.3D) {
/* 190 */         m4TestDummy();
/*     */       } 
/* 193 */       if (clickEventType == 5.1D) {
/*     */         try {
/* 195 */           if (currentProfile == 1) {
/* 196 */             m5CreateProfile(Save.save1, Game.save1Path);
/* 197 */           } else if (currentProfile == 2) {
/* 198 */             m5CreateProfile(Save.save2, Game.save2Path);
/* 199 */           } else if (currentProfile == 3) {
/* 200 */             m5CreateProfile(Save.save3, Game.save3Path);
/*     */           } 
/* 202 */         } catch (IOException e) {
/* 203 */           e.printStackTrace();
/*     */         } 
/* 205 */       } else if (clickEventType == 5.2D) {
/* 206 */         MouseManager.mouseFullClick = 0;
/* 207 */         menuState = 2;
/* 208 */         currentProfile = 0;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void drawProfile(Graphics g, byte state, int x, int y, String lastPlayed, String created, File file, int profileNumber, String name, FontMetrics fm) {
/* 216 */     g.drawImage(this.im.profileSquare, x, y, this.im.profileSquare.getWidth(), 
/* 217 */         this.im.profileSquare.getHeight(), null);
/* 218 */     g.setColor(Game.gameProgressColor);
/* 219 */     g.setFont(Game.gameProgressFont);
/* 220 */     if (file.exists()) {
/* 221 */       g.drawImage(
/* 222 */           this.im2.playerd1, 
/* 223 */           this.im.profileSquare.getWidth() / 2 + x - 
/* 224 */           this.im2.playerd1.getWidth(), 
/* 225 */           y + this.im.profileSquare.getHeight() / 2 - 
/* 226 */           this.im2.playerd1.getHeight(), 64, 64, null);
/* 227 */     } else if (!file.exists()) {
/* 228 */       g.drawString(
/* 229 */           "?", 
/* 230 */           this.im.profileSquare.getWidth() / 2 + x - 
/* 231 */           fm.stringWidth("?") / 2, profileNumber * 110);
/*     */     } 
/* 233 */     if (currentProfile == profileNumber) {
/* 234 */       g.setColor(Color.white);
/*     */     } else {
/* 236 */       g.setColor(Game.profileInfoColor);
/*     */     } 
/* 238 */     g.setFont(Game.profileNameFont);
/* 239 */     g.drawString(name, 380, profileNumber * 110 - 40);
/* 240 */     g.setFont(Game.profileInfoFont);
/* 241 */     g.drawString("Last Played: " + lastPlayed, 380, 
/* 242 */         profileNumber * 110 - 40 + 33);
/* 243 */     g.drawString("Date Created: " + created, 380, 
/* 244 */         profileNumber * 110 - 40 + 66);
/*     */   }
/*     */   
/*     */   private void draw3WayTextBox(Graphics g, byte state, int x, int y, int w, int h, String t1, String t2, String t3, String info, int optionalParam) {
/* 252 */     this.fm = g.getFontMetrics(Game.buttonTextFont);
/* 254 */     g.setColor(Game.profileInfoColor);
/* 255 */     g.setFont(Game.profileInfoFont);
/* 257 */     g.drawString(info, x, y - 9);
/* 259 */     g.setColor(new Color(232, 232, 232));
/* 260 */     g.drawRect(x + 1, y + 1, w - 2, h - 2);
/* 261 */     g.drawRect(x, y, w, h);
/* 263 */     g.setColor(new Color(0, 0, 0, 180));
/* 264 */     g.fillRect(x + 2, y + 2, w - 3, h - 3);
/* 266 */     g.setFont(Game.buttonTextFont);
/* 267 */     g.setColor(Color.white);
/* 268 */     if (optionalParam == 1) {
/* 269 */       g.drawString(t1, x + 8, y + 24);
/* 270 */       if (state == 2)
/* 271 */         g.drawString("_", x + 8 + this.fm.stringWidth(t1), y + 24); 
/* 273 */     } else if (optionalParam == 2) {
/* 274 */       g.drawString(t2, x + 8, y + 24);
/* 275 */       if (state == 2)
/* 276 */         g.drawString("_", x + 8 + this.fm.stringWidth(t2), y + 24); 
/* 278 */     } else if (optionalParam == 3) {
/* 279 */       g.drawString(t3, x + 8, y + 24);
/* 280 */       if (state == 2)
/* 281 */         g.drawString("_", x + 8 + this.fm.stringWidth(t3), y + 24); 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void drawTextBox(Graphics g, byte state, int x, int y, int w, int h, String t, String info) {
/* 290 */     g.setColor(Game.profileInfoColor);
/* 291 */     g.setFont(Game.profileInfoFont);
/* 294 */     g.drawString(info, x, y - 9);
/* 297 */     g.setColor(new Color(232, 232, 232));
/* 298 */     g.drawRect(x + 1, y + 1, w - 2, h - 2);
/* 299 */     g.drawRect(x, y, w, h);
/* 302 */     g.setColor(new Color(0, 0, 0, 180));
/* 303 */     g.fillRect(x + 2, y + 2, w - 3, h - 3);
/* 306 */     g.setFont(Game.buttonTextFont);
/* 307 */     g.setColor(Color.white);
/* 310 */     g.drawString(t, x + 8, y + 24);
/* 311 */     if (state == 2)
/* 312 */       g.drawString("_", x + 8 + this.fm.stringWidth(t), y + 24); 
/*     */   }
/*     */   
/*     */   private static void drawCloud(Graphics g, int number, BufferedImage image) {
/* 317 */     if (number == 1) {
/* 318 */       g.drawImage(image, (int)cloud1x, (int)cloud1y, image.getWidth(), 
/* 319 */           image.getHeight(), null);
/* 320 */     } else if (number == 2) {
/* 321 */       g.drawImage(image, (int)cloud2x, (int)cloud2y, image.getWidth(), 
/* 322 */           image.getHeight(), null);
/* 323 */     } else if (number == 3) {
/* 324 */       g.drawImage(image, (int)cloud3x, (int)cloud3y, image.getWidth(), 
/* 325 */           image.getHeight(), null);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void cloudX() {
/* 331 */     if (cloud1x > -150.0D) {
/* 332 */       cloud1x -= cloudSpeed + 0.1D;
/*     */     } else {
/* 334 */       cloud1x = 850.0D;
/* 335 */       cloud1y = 200.0D;
/*     */     } 
/* 339 */     if (cloud2x > -125.0D) {
/* 340 */       cloud2x -= cloudSpeed;
/*     */     } else {
/* 342 */       cloud2x = 990.0D;
/* 343 */       cloud2y = 22.0D;
/*     */     } 
/* 347 */     if (cloud3x <= 828.0D) {
/* 348 */       cloud3x += cloudSpeed;
/*     */     } else {
/* 350 */       cloud3x = -150.0D;
/* 351 */       cloud3y = 365.0D;
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void enterGame() {
/* 356 */     Game.isInGame = true;
/* 357 */     menuState = 0;
/* 358 */     KeyManager.enterPressed = false;
/* 359 */     Player.up = false;
/* 360 */     Player.down = false;
/* 361 */     Player.left = false;
/* 362 */     Player.right = false;
/*     */   }
/*     */   
/*     */   public void tick() {
/* 369 */     if (menuState == 2)
/* 370 */       profileTick(); 
/* 373 */     cloudX();
/*     */   }
/*     */   
/*     */   private void profileTick() {
/* 380 */     if (!Save.save1.exists()) {
/* 381 */       save1Name = "Play To Create Me";
/* 382 */     } else if (Save.save1.exists()) {
/* 383 */       save1Name = save1Name_backup;
/*     */     } 
/* 386 */     if (!Save.save2.exists()) {
/* 387 */       save2Name = "Play To Create Me";
/* 388 */     } else if (Save.save2.exists()) {
/* 389 */       save2Name = save2Name_backup;
/*     */     } 
/* 392 */     if (!Save.save3.exists()) {
/* 393 */       save3Name = "Play To Create Me";
/* 394 */     } else if (Save.save3.exists()) {
/* 395 */       save3Name = save3Name_backup;
/*     */     } 
/* 399 */     if (save1State == 3 || save2State == 3 || save3State == 3) {
/* 400 */       canPlayProfile = true;
/* 402 */     } else if (save1State == 0 && save2State == 0 && save3State == 0) {
/* 403 */       canPlayProfile = false;
/*     */     } 
/* 408 */     if (currentProfile == 0)
/* 409 */       canDeleteProfile = false; 
/* 412 */     if (currentProfile == 1 && !Save.save1.exists()) {
/* 413 */       canDeleteProfile = false;
/* 414 */     } else if (currentProfile == 1 && Save.save1.exists()) {
/* 415 */       canDeleteProfile = true;
/*     */     } 
/* 418 */     if (currentProfile == 2 && !Save.save2.exists()) {
/* 419 */       canDeleteProfile = false;
/* 420 */     } else if (currentProfile == 2 && Save.save2.exists()) {
/* 421 */       canDeleteProfile = true;
/*     */     } 
/* 424 */     if (currentProfile == 3 && !Save.save3.exists()) {
/* 425 */       canDeleteProfile = false;
/* 426 */     } else if (currentProfile == 3 && Save.save3.exists()) {
/* 427 */       canDeleteProfile = true;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void renderMain(Graphics g) {
/* 435 */     g.setColor(Game.skyColor);
/* 436 */     g.fillRect(0, 0, 838, 573);
/* 439 */     drawCloud(g, 1, this.im.cloud1);
/* 440 */     drawCloud(g, 2, this.im.cloud2);
/* 441 */     drawCloud(g, 3, this.im.cloud3);
/* 443 */     if (menuState == 1) {
/* 444 */       renderState1(g);
/* 445 */     } else if (menuState == 2) {
/* 446 */       renderState2(g);
/* 447 */     } else if (menuState == 3) {
/* 448 */       renderState3(g);
/* 449 */     } else if (menuState == 4) {
/* 450 */       renderState4(g);
/* 451 */     } else if (menuState == 5) {
/* 452 */       renderState5(g);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void renderState1(Graphics g) {
/* 463 */     this.fm = g.getFontMetrics(Game.profileInfoFont);
/* 464 */     this.fm2 = g.getFontMetrics(Game.buttonTextFont);
/* 467 */     g.drawImage(Game.logoImage, 419 - Game.logoImage.getWidth(), 
/* 468 */         20, Game.logoImage.getWidth() * 2, 
/* 469 */         Game.logoImage.getHeight() * 2, null);
/* 472 */     g.setFont(Game.profileInfoFont);
/* 473 */     g.setColor(Game.profileInfoColor);
/* 474 */     g.drawString(Game.identifer, 
/* 475 */         419 - this.fm.stringWidth(Game.identifer) / 2, 415);
/* 478 */     g.setFont(Game.buttonTextFont);
/* 479 */     g.setColor(Color.white);
/* 480 */     g.drawString(Game.title, 5, 535);
/* 481 */     g.drawString(Game.copyright, 
/* 482 */         838 - this.fm2.stringWidth(Game.copyright) + 10, 535);
/* 485 */     drawButton(g, playState, 251, 254, 336, 32, "Play", 
/* 486 */         this.im.button2_1, this.im.button2_2, this.im.button2_3, 1.1D);
/* 489 */     drawButton(g, optionsState, 251, 302, 
/* 490 */         this.im.button2_1.getWidth(), this.im.button2_1.getHeight(), "Options", 
/* 491 */         this.im.button2_1, this.im.button2_2, this.im.button2_3, 1.2D);
/* 494 */     drawButton(g, updateState, 419 - this.im.button1_1.getWidth() + 8, 
/* 495 */         350, this.im.button1_1.getWidth(), 
/* 496 */         this.im.button1_1.getHeight(), "Update...", this.im.button1_1, 
/* 497 */         this.im.button1_2, this.im.button1_3, 1.3D);
/* 500 */     drawButton(g, quitState, 427, 
/* 501 */         350, this.im.button1_1.getWidth(), 
/* 502 */         this.im.button1_1.getHeight(), "Quit Game", this.im.button1_1, 
/* 503 */         this.im.button1_2, this.im.button1_3, 1.4D);
/*     */   }
/*     */   
/*     */   private void renderState2(Graphics g) {
/* 511 */     this.fm = g.getFontMetrics(Game.gameProgressFont);
/* 513 */     g.setFont(Game.profileInfoFont);
/* 514 */     g.setColor(Game.profileInfoColor);
/* 518 */     if (save1State == 3) {
/* 519 */       g.drawImage(this.im.profileSelection, 268, 43, 300, 117, null);
/* 520 */       currentProfile = 1;
/* 521 */     } else if (save2State == 3) {
/* 522 */       g.drawImage(this.im.profileSelection, 268, 153, 300, 117, null);
/* 523 */       currentProfile = 2;
/* 524 */     } else if (save3State == 3) {
/* 525 */       g.drawImage(this.im.profileSelection, 268, 263, 300, 117, null);
/* 526 */       currentProfile = 3;
/*     */     } 
/* 531 */     drawProfile(g, save1State, 275, 50, Save.save1LastPlayed, 
/* 532 */         Save.save1Made, Save.save1, 1, save1Name, this.fm);
/* 534 */     drawProfile(g, save2State, 275, 160, Save.save2LastPlayed, 
/* 535 */         Save.save2Made, Save.save2, 2, save2Name, this.fm);
/* 537 */     drawProfile(g, save3State, 275, 270, Save.save3LastPlayed, 
/* 538 */         Save.save3Made, Save.save3, 3, save3Name, this.fm);
/* 541 */     g.setColor(Game.profileInfoColor);
/* 542 */     g.setFont(Game.profileInfoFont);
/* 543 */     g.drawString("Use the WS or up and down keys to select a profile.", 
/* 544 */         498, 535);
/* 548 */     if (canPlayProfile) {
/* 549 */       drawButton(g, playSelectedState, 
/* 550 */           419 - this.im.button2_1.getWidth() / 2, 425, 
/* 551 */           this.im.button2_1.getWidth(), this.im.button2_1.getHeight(), 
/* 552 */           "Play Selected Profile", this.im.button2_1, this.im.button2_2, 
/* 553 */           this.im.button2_3, 2.1D);
/* 554 */     } else if (!canPlayProfile) {
/* 555 */       g.setFont(Game.buttonTextFont);
/* 556 */       g.drawImage(this.im.button2_3, 419 - 
/* 557 */           this.im.button2_3.getWidth() / 2, 425, 
/* 558 */           this.im.button2_3.getWidth(), this.im.button2_3.getHeight(), null);
/* 559 */       g.setColor(Game.buttonClickedColor);
/* 560 */       g.drawString("Play Selected Profile", 324, 446);
/*     */     } 
/* 565 */     if (canDeleteProfile) {
/* 566 */       drawButton(g, deleteState, 419 - 
/* 567 */           this.im.button2_1.getWidth() / 2, 473, 
/* 568 */           this.im.button1_1.getWidth(), this.im.button1_1.getHeight(), 
/* 569 */           "Delete", this.im.button1_1, this.im.button1_2, this.im.button1_3, 2.2D);
/* 570 */     } else if (!canDeleteProfile) {
/* 571 */       g.setFont(Game.buttonTextFont);
/* 572 */       g.drawImage(this.im.button1_3, 419 - 
/* 573 */           this.im.button2_1.getWidth() / 2, 473, 
/* 574 */           this.im.button1_3.getWidth(), this.im.button1_3.getHeight(), null);
/* 575 */       g.setColor(Game.buttonClickedColor);
/* 576 */       g.drawString("Delete", 300, 
/* 577 */           473 + this.im.button1_3.getHeight() / 2 + 5);
/*     */     } 
/* 582 */     drawButton(g, cancelState, 419 - this.im.button2_1.getWidth() / 2 + 
/* 583 */         176, 473, this.im.button1_1.getWidth(), 
/* 584 */         this.im.button1_1.getHeight(), "Back", this.im.button1_1, this.im.button1_2, 
/* 585 */         this.im.button1_3, 2.3D);
/*     */   }
/*     */   
/*     */   private void renderState3(Graphics g) {
/* 593 */     g.setFont(Game.areYouSureFont);
/* 594 */     g.setColor(Game.profileInfoColor);
/* 595 */     g.drawString("Are you sure?", 280, 190);
/* 597 */     g.setFont(Game.buttonTextFont);
/* 599 */     drawButton(g, yesState, 215, 325, this.im.button1_1.getWidth(), 
/* 600 */         this.im.button1_1.getHeight(), "Yes", this.im.button1_1, this.im.button1_2, 
/* 601 */         this.im.button1_3, 3.1D);
/* 603 */     drawButton(g, noState, 454, 325, this.im.button1_1.getWidth(), 
/* 604 */         this.im.button1_1.getHeight(), "No", this.im.button1_1, this.im.button1_2, 
/* 605 */         this.im.button1_3, 3.2D);
/*     */   }
/*     */   
/*     */   private void renderState4(Graphics g) {
/* 613 */     this.fm = g.getFontMetrics(Game.profileInfoFont);
/* 616 */     drawButton(g, autoSaveState, 419 - 
/* 617 */         this.im.button2_1.getWidth() + 8, 100, this.im.button2_1.getWidth(), 
/* 618 */         this.im.button2_1.getHeight(), "Auto Save: " + autoSaveToggle, 
/* 619 */         this.im.button2_1, this.im.button2_2, this.im.button2_3, 4.1D);
/* 620 */     g.setColor(Game.profileInfoColor);
/* 621 */     g.setFont(Game.profileInfoFont);
/* 624 */     drawButton(g, tdState, 427, 100, this.im.button2_1.getWidth(), 
/* 625 */         this.im.button2_1.getHeight(), "Test Dummy: " + tdToggle, 
/* 626 */         this.im.button2_1, this.im.button2_2, this.im.button2_3, 4.3D);
/* 629 */     g.setFont(Game.profileInfoFont);
/* 630 */     g.setColor(Game.profileInfoColor);
/* 631 */     drawButton(g, addOnsState, 419 - this.im.button2_1.getWidth() / 2, 
/* 632 */         473, this.im.button1_1.getWidth(), this.im.button1_1.getHeight(), 
/* 633 */         "Add-Ons...", this.im.button1_1, this.im.button1_2, this.im.button1_3, 4.2D);
/* 636 */     drawButton(g, cancelState, 419 - this.im.button2_1.getWidth() / 2 + 
/* 637 */         176, 473, this.im.button1_1.getWidth(), 
/* 638 */         this.im.button1_1.getHeight(), "Back", this.im.button1_1, this.im.button1_2, 
/* 639 */         this.im.button1_3, 2.3D);
/*     */   }
/*     */   
/*     */   private void renderState5(Graphics g) {
/* 647 */     profileNameBoxState = getGeneralImageState(
/* 648 */         419 - this.im.button2_1.getWidth() / 2 - 1, 89, 
/* 649 */         this.im.button2_1.getWidth() + 2, this.im.button2_1.getHeight() + 2, 
/* 650 */         profileNameBoxState, profileNameBoxInFocus);
/* 652 */     playerNameBoxState = getGeneralImageState(
/* 653 */         419 - this.im.button2_1.getWidth() / 2 - 1, 172, 
/* 654 */         this.im.button2_1.getWidth() + 2, this.im.button2_1.getHeight() + 2, 
/* 655 */         playerNameBoxState, playerNameBoxInFocus);
/* 658 */     draw3WayTextBox(g, profileNameBoxState, 
/* 659 */         419 - this.im.button2_1.getWidth() / 2 - 1, 89, 
/* 660 */         this.im.button2_1.getWidth() + 2, this.im.button2_1.getHeight() + 2, 
/* 661 */         save1Name, save2Name, save3Name, "Profile Name: ", 
/* 662 */         currentProfile);
/* 664 */     drawTextBox(g, playerNameBoxState, 
/* 665 */         419 - this.im.button2_1.getWidth() / 2 - 1, 172, 
/* 666 */         this.im.button2_1.getWidth() + 2, this.im.button2_1.getHeight() + 2, 
/* 667 */         Player.typedName, 
/* 668 */         "Character's Name (Cannot change after this!)");
/* 671 */     drawButton(g, createProfileState, 
/* 672 */         419 - this.im.button2_1.getWidth() / 2, 437, 
/* 673 */         this.im.button1_1.getWidth(), this.im.button1_1.getHeight(), 
/* 674 */         "Create Profile", this.im.button1_1, this.im.button1_2, this.im.button1_3, 5.1D);
/* 677 */     drawButton(
/* 678 */         g, 
/* 679 */         cancelState, 
/* 680 */         419 - 
/* 681 */         this.im.button2_1.getWidth() / 2 - this.im.button1_1
/* 682 */         .getWidth() + 16, 437, 
/* 683 */         this.im.button1_1.getWidth(), this.im.button1_1.getHeight(), "Back", 
/* 684 */         this.im.button1_1, this.im.button1_2, this.im.button1_3, 5.2D);
/*     */   }
/*     */   
/*     */   private void m1Play() {
/* 691 */     menuState = 2;
/* 692 */     Load.loadData1(Game.dataPath);
/*     */   }
/*     */   
/*     */   private void m1Options() {
/* 696 */     menuState = 4;
/* 697 */     Load.loadData1(Game.dataPath);
/* 699 */     if (autoSaveToggle == "On" && !Game.autoSave) {
/* 700 */       autoSaveToggle = "Off";
/* 701 */     } else if (autoSaveToggle == "Off" && Game.autoSave) {
/* 702 */       autoSaveToggle = "On";
/*     */     } 
/* 706 */     if (tdToggle == "On" && !Game.dummy) {
/* 707 */       tdToggle = "Off";
/* 708 */     } else if (tdToggle == "Off" && Game.dummy) {
/* 709 */       tdToggle = "On";
/*     */     } 
/*     */   }
/*     */   
/*     */   private void m1Update() {
/* 714 */     MouseManager.mouseFullClick = 0;
/* 715 */     this.u.createWindow();
/*     */   }
/*     */   
/*     */   private void m1Quit() {
/* 719 */     System.exit(0);
/*     */   }
/*     */   
/*     */   public static void m2PlayProfile() throws IOException {
/* 724 */     if (currentProfile == 1) {
/* 725 */       if (Save.save1.exists()) {
/* 726 */         Load.loadProfile(Game.save1Path);
/* 727 */         Save.profileSave(Save.save1, Game.save1Path, 1);
/* 728 */         enterGame();
/* 729 */       } else if (!Save.save1.exists()) {
/* 730 */         save1Name = "";
/* 731 */         Player.typedName = "";
/* 732 */         cancelState = 0;
/* 733 */         menuState = 5;
/*     */       } 
/* 735 */     } else if (currentProfile == 2) {
/* 736 */       if (Save.save2.exists()) {
/* 737 */         Load.loadProfile(Game.save2Path);
/* 738 */         Save.profileSave(Save.save2, Game.save2Path, 2);
/* 739 */         enterGame();
/* 740 */       } else if (!Save.save2.exists()) {
/* 741 */         save2Name = "";
/* 742 */         Player.typedName = "";
/* 743 */         cancelState = 0;
/* 744 */         menuState = 5;
/*     */       } 
/* 746 */     } else if (currentProfile == 3) {
/* 747 */       if (Save.save3.exists()) {
/* 748 */         Load.loadProfile(Game.save3Path);
/* 749 */         Save.profileSave(Save.save3, Game.save3Path, 3);
/* 750 */         enterGame();
/* 751 */       } else if (!Save.save3.exists()) {
/* 752 */         save3Name = "";
/* 753 */         Player.typedName = "";
/* 754 */         cancelState = 0;
/* 755 */         menuState = 5;
/*     */       } 
/*     */     } 
/* 758 */     MouseManager.mouseFullClick = 0;
/* 759 */     save1State = 0;
/* 760 */     save2State = 0;
/* 761 */     save3State = 0;
/*     */   }
/*     */   
/*     */   private void m2DeleteProfile() throws IOException {
/* 767 */     if (currentProfile == 1) {
/* 768 */       Save.save1.delete();
/* 769 */       Save.save1Made = "";
/* 770 */       Save.save1LastPlayed = "";
/* 771 */       Save.dataSave();
/* 772 */     } else if (currentProfile == 2) {
/* 773 */       Save.save2.delete();
/* 774 */       Save.save2Made = "";
/* 775 */       Save.save2LastPlayed = "";
/* 776 */       Save.dataSave();
/* 777 */     } else if (currentProfile == 3) {
/* 778 */       Save.save3.delete();
/* 779 */       Save.save3Made = " ";
/* 780 */       Save.save3LastPlayed = " ";
/* 781 */       Save.dataSave();
/*     */     } 
/* 784 */     menuState = 2;
/* 785 */     currentProfile = 0;
/*     */   }
/*     */   
/*     */   private void m2Back() {
/* 790 */     save1State = 0;
/* 791 */     save2State = 0;
/* 792 */     save3State = 0;
/* 793 */     currentProfile = 0;
/* 794 */     menuState = 1;
/*     */   }
/*     */   
/*     */   private void m3Yes() {
/*     */     try {
/* 800 */       m2DeleteProfile();
/* 801 */     } catch (IOException e) {
/* 802 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   private void m3No() {
/* 809 */     menuState = 2;
/*     */   }
/*     */   
/*     */   private void m4AutoSave() {
/* 814 */     if (autoSaveToggle == "On") {
/* 815 */       autoSaveToggle = "Off";
/* 816 */       Game.autoSave = false;
/* 817 */     } else if (autoSaveToggle == "Off") {
/* 818 */       autoSaveToggle = "On";
/* 819 */       Game.autoSave = true;
/*     */     } 
/* 821 */     MouseManager.mouseFullClick = 0;
/*     */     try {
/* 823 */       Save.dataSave();
/* 824 */     } catch (IOException e) {
/* 825 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   private void m4TestDummy() {
/* 830 */     if (tdToggle == "On") {
/* 831 */       tdToggle = "Off";
/* 832 */       Game.dummy = false;
/* 833 */     } else if (tdToggle == "Off") {
/* 834 */       tdToggle = "On";
/* 835 */       Game.dummy = true;
/*     */     } 
/* 837 */     MouseManager.mouseFullClick = 0;
/*     */     try {
/* 839 */       Save.dataSave();
/* 840 */     } catch (IOException e) {
/* 841 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   private void m4AddOns() {}
/*     */   
/*     */   private void m5CreateProfile(File save, String path) throws IOException {
/* 850 */     Save.reset();
/* 851 */     if (currentProfile == 1 && save1Name.length() == 0) {
/* 852 */       save1Name = "Profile 1";
/* 853 */       save1Name_backup = save1Name;
/* 854 */     } else if (currentProfile == 2 && save2Name.length() == 0) {
/* 855 */       save2Name = "Profile 2";
/* 856 */       save2Name_backup = save2Name;
/* 857 */     } else if (currentProfile == 3 && save3Name.length() == 0) {
/* 858 */       save3Name = "Profile 3";
/* 859 */       save3Name_backup = save3Name;
/*     */     } 
/* 861 */     if (Player.typedName.length() == 0) {
/* 862 */       Player.name = Player.defaultName;
/* 863 */     } else if (Player.typedName.length() >= 1) {
/* 864 */       Player.name = Player.typedName;
/*     */     } 
/* 866 */     Save.profileSave(save, path, currentProfile);
/* 867 */     Save.dataSave();
/* 868 */     Load.loadProfile(path);
/* 869 */     createProfileState = 0;
/* 870 */     enterGame();
/* 871 */     StoryText.request("Our story begins within a town called " + 
/* 872 */         Game.townName, 
/* 873 */         "For centuries, each generation has lived in peace, but", 
/* 874 */         "today, something will happen, something big.", 
/* 875 */         "It will distrub the natural balance of " + Game.townName + 
/* 876 */         " and its people.", "", 
/* 877 */         "One the first day, there was darkness.", "");
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.5_4.jar!\beyondOrigins\main\menus\MainMenu.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */