/*     */ package beyondOrigins.main.menus;
/*     */ 
/*     */ import beyondOrigins.files.Load;
/*     */ import beyondOrigins.files.Save;
/*     */ import beyondOrigins.main.Game;
/*     */ import beyondOrigins.main.entities.Cloud;
/*     */ import beyondOrigins.main.entities.Player;
/*     */ import beyondOrigins.main.entities.TestDummy;
/*     */ import beyondOrigins.main.gfx.ImageManager;
/*     */ import beyondOrigins.main.windows.About;
/*     */ import beyondOrigins.main.windows.AddOns;
/*     */ import beyondOrigins.main.windows.Update;
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
/*  30 */   public static byte menuState = 1;
/*     */   
/*  39 */   public static byte currentProfile = 0;
/*     */   
/*     */   public static boolean canPlayProfile = false;
/*     */   
/*     */   public static boolean canDeleteProfile = false;
/*     */   
/*  44 */   public static String save1Name = "IfYouSeeThisSomethingIsWrong";
/*     */   
/*  45 */   public static String save2Name = "IfYouSeeThisSomethingIsWrong";
/*     */   
/*  46 */   public static String save3Name = "IfYouSeeThisSomethingIsWrong";
/*     */   
/*     */   public static boolean enterProfile = false;
/*     */   
/*  54 */   public static String autoSaveToggle = "On";
/*     */   
/*  54 */   public static String tdToggle = "Off";
/*     */   
/*     */   public static boolean profileNameBoxInFocus = false;
/*     */   
/*     */   public static boolean playerNameBoxInFocus = false;
/*     */   
/*  64 */   private Update u = new Update();
/*     */   
/*  65 */   private AddOns a = new AddOns();
/*     */   
/*  66 */   private About ab = new About();
/*     */   
/*  67 */   public Cloud cloud1 = new Cloud(-195.0D, 135.0D);
/*     */   
/*  68 */   public Cloud cloud2 = new Cloud(1033.0D, (286 - 
/*  69 */       ImageManager.cloud1.getHeight() / 2));
/*     */   
/*  70 */   public Cloud cloud3 = new Cloud(-155.0D, 378.0D);
/*     */   
/*     */   private FontMetrics fm;
/*     */   
/*     */   private FontMetrics fm2;
/*     */   
/*     */   public static byte state;
/*     */   
/*     */   public static byte cancelState;
/*     */   
/*     */   public static byte save1State;
/*     */   
/*     */   public static byte save2State;
/*     */   
/*     */   public static byte save3State;
/*     */   
/*     */   public static String save1Name_backup;
/*     */   
/*     */   public static String save2Name_backup;
/*     */   
/*     */   public static String save3Name_backup;
/*     */   
/*     */   public static byte yesState;
/*     */   
/*     */   public static byte noState;
/*     */   
/*     */   public static byte profileNameBoxState;
/*     */   
/*     */   public static byte playerNameBoxState;
/*     */   
/*     */   private byte getButtonState(int x, int y, int width, int height, byte state) {
/*  79 */     if (MouseMotion.mouseX >= x && MouseMotion.mouseX < x + width && 
/*  80 */       MouseMotion.mouseY >= y && MouseMotion.mouseY < y + height) {
/*  81 */       state = 2;
/*  82 */       if (Game.mouseIsPressed()) {
/*  83 */         state = 3;
/*     */       } else {
/*  85 */         state = 2;
/*     */       } 
/*     */     } else {
/*  87 */       state = 1;
/*     */     } 
/*  88 */     return state;
/*     */   }
/*     */   
/*     */   private byte getGeneralImageState(int x, int y, int width, int height, byte state, boolean inFocus) {
/*  95 */     if (MouseMotion.mouseX >= x && MouseMotion.mouseX < x + width && 
/*  96 */       MouseMotion.mouseY >= y && MouseMotion.mouseY < y + height) {
/*  97 */       if (!inFocus && Game.mouseIsPressed()) {
/*  98 */         state = 2;
/*  99 */         inFocus = true;
/* 100 */       } else if (inFocus) {
/* 101 */         state = 2;
/*     */       } 
/* 104 */     } else if (inFocus) {
/* 105 */       state = 2;
/* 107 */     } else if (Game.mouseIsPressed()) {
/* 108 */       state = 1;
/* 109 */       inFocus = false;
/*     */     } 
/* 114 */     return state;
/*     */   }
/*     */   
/*     */   private void drawButton(Graphics g, int x, int y, int width, int height, String buttonText, BufferedImage state1Image, BufferedImage state2Image, BufferedImage state3Image, double clickEventType) {
/* 121 */     this.fm = g.getFontMetrics(Game.buttonTextFont);
/* 123 */     g.setFont(Game.buttonTextFont);
/* 124 */     if (getButtonState(x, y, width, height, state) == 1) {
/* 125 */       g.drawImage(state1Image, x, y, width, height, null);
/* 126 */       g.setColor(Game.buttonIdleColor);
/* 127 */       g.drawString(
/* 128 */           buttonText, 
/* 129 */           x + state1Image.getWidth() / 2 - 
/* 130 */           this.fm.stringWidth(buttonText) / 2, y + 
/* 131 */           state1Image.getHeight() / 2 + 5);
/* 132 */     } else if (getButtonState(x, y, width, height, state) == 2) {
/* 133 */       g.drawImage(state2Image, x, y, width, height, null);
/* 134 */       g.setColor(Game.buttonSelectedColor);
/* 135 */       g.drawString(
/* 136 */           buttonText, 
/* 137 */           x + state1Image.getWidth() / 2 - 
/* 138 */           this.fm.stringWidth(buttonText) / 2, y + 
/* 139 */           state1Image.getHeight() / 2 + 5);
/* 140 */     } else if (getButtonState(x, y, width, height, state) == 3) {
/* 141 */       g.drawImage(state3Image, x, y, width, height, null);
/* 142 */       g.setColor(Game.buttonClickedColor);
/* 143 */       g.drawString(
/* 144 */           buttonText, 
/* 145 */           x + state1Image.getWidth() / 2 - 
/* 146 */           this.fm.stringWidth(buttonText) / 2, y + 
/* 147 */           state1Image.getHeight() / 2 + 5);
/* 148 */       clickEventHandler(clickEventType);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void clickEventHandler(double e) {
/* 154 */     if (e == 1.1D) {
/* 155 */       m1Play();
/* 156 */     } else if (e == 1.2D) {
/* 157 */       m1Options();
/* 158 */     } else if (e == 1.3D) {
/* 159 */       m1Update();
/* 160 */     } else if (e == 1.4D) {
/* 161 */       m1Quit();
/*     */     } 
/* 164 */     if (e == 2.1D) {
/*     */       try {
/* 166 */         m2PlayProfile();
/* 167 */       } catch (IOException ei) {
/* 168 */         ei.printStackTrace();
/*     */       } 
/* 170 */     } else if (e == 2.2D) {
/* 171 */       menuState = 3;
/* 172 */     } else if (e == 2.3D) {
/* 173 */       m2Back();
/*     */     } 
/* 176 */     if (e == 3.1D) {
/* 177 */       m3Yes();
/* 178 */     } else if (e == 3.2D) {
/* 179 */       m3No();
/*     */     } 
/* 182 */     if (e == 4.1D) {
/* 183 */       m4AutoSave();
/* 184 */     } else if (e == 4.2D) {
/* 185 */       m4AddOns();
/* 186 */     } else if (e == 4.3D) {
/* 187 */       m4TestDummy();
/* 188 */     } else if (e == 4.4D) {
/* 189 */       m4Reload();
/* 190 */     } else if (e == 4.5D) {
/* 191 */       m4About();
/*     */     } 
/* 194 */     if (e == 5.1D) {
/*     */       try {
/* 196 */         if (currentProfile == 1) {
/* 197 */           m5CreateProfile(Save.save1, Game.save1Path);
/* 198 */         } else if (currentProfile == 2) {
/* 199 */           m5CreateProfile(Save.save2, Game.save2Path);
/* 200 */         } else if (currentProfile == 3) {
/* 201 */           m5CreateProfile(Save.save3, Game.save3Path);
/*     */         } 
/* 203 */       } catch (IOException ei) {
/* 204 */         ei.printStackTrace();
/*     */       } 
/* 206 */     } else if (e == 5.2D) {
/* 207 */       Game.endClick();
/* 208 */       menuState = 2;
/* 209 */       currentProfile = 0;
/*     */     } 
/* 212 */     if (e == 6.1D) {
/* 213 */       Player.respawn();
/* 214 */     } else if (e == 6.2D) {
/* 215 */       Player.health = Player.maxHealth;
/*     */       try {
/* 217 */         if (currentProfile == 1)
/* 218 */           Save.profileSave(Save.save1, Game.save1Path, 1); 
/* 219 */         if (currentProfile == 2)
/* 220 */           Save.profileSave(Save.save2, Game.save2Path, 2); 
/* 221 */         if (currentProfile == 3)
/* 222 */           Save.profileSave(Save.save3, Game.save3Path, 3); 
/* 223 */         Save.dataSave();
/* 224 */       } catch (IOException e1) {
/* 225 */         e1.printStackTrace();
/*     */       } 
/* 227 */       Game.endClick();
/* 228 */       menuState = 1;
/* 229 */       currentProfile = 0;
/*     */     } 
/*     */   }
/*     */   
/*     */   private void drawProfile(Graphics g, byte state, int x, int y, String lastPlayed, String created, File file, int profileNumber, String name, FontMetrics fm) {
/* 236 */     g.drawImage(ImageManager.profileSquare, x, y, 
/* 237 */         ImageManager.profileSquare.getWidth(), 
/* 238 */         ImageManager.profileSquare.getHeight(), null);
/* 239 */     g.setColor(Game.gameProgressColor);
/* 240 */     g.setFont(Game.gameProgressFont);
/* 241 */     if (file.exists()) {
/* 242 */       g.drawImage(ImageManager.playerd1, 
/* 243 */           ImageManager.profileSquare.getWidth() / 2 + x - 
/* 244 */           ImageManager.playerd1.getWidth(), 
/* 245 */           y + ImageManager.profileSquare.getHeight() / 2 - 
/* 246 */           ImageManager.playerd1.getHeight(), 64, 64, null);
/* 247 */     } else if (!file.exists()) {
/* 248 */       g.drawString("?", ImageManager.profileSquare.getWidth() / 2 + x - 
/* 249 */           fm.stringWidth("?") / 2, profileNumber * 110);
/*     */     } 
/* 251 */     if (currentProfile == profileNumber) {
/* 252 */       g.setColor(Color.white);
/*     */     } else {
/* 254 */       g.setColor(Game.profileInfoColor);
/*     */     } 
/* 256 */     g.setFont(Game.profileNameFont);
/* 257 */     g.drawString(name, 380, profileNumber * 110 - 40);
/* 258 */     g.setFont(Game.profileInfoFont);
/* 259 */     g.drawString("Last Played: " + lastPlayed, 380, 
/* 260 */         profileNumber * 110 - 40 + 33);
/* 261 */     g.drawString("Date Created: " + created, 380, 
/* 262 */         profileNumber * 110 - 40 + 66);
/*     */   }
/*     */   
/*     */   private void draw3WayTextBox(Graphics g, byte state, int x, int y, int w, int h, String t1, String t2, String t3, String info, int optionalParam) {
/* 270 */     this.fm = g.getFontMetrics(Game.buttonTextFont);
/* 272 */     g.setColor(Game.profileInfoColor);
/* 273 */     g.setFont(Game.profileInfoFont);
/* 275 */     g.drawString(info, x, y - 9);
/* 277 */     g.setColor(new Color(232, 232, 232));
/* 278 */     g.drawRect(x + 1, y + 1, w - 2, h - 2);
/* 279 */     g.drawRect(x, y, w, h);
/* 281 */     g.setColor(new Color(0, 0, 0, 180));
/* 282 */     g.fillRect(x + 2, y + 2, w - 3, h - 3);
/* 284 */     g.setFont(Game.buttonTextFont);
/* 285 */     g.setColor(Color.white);
/* 286 */     if (optionalParam == 1) {
/* 287 */       g.drawString(t1, x + 8, y + 24);
/* 288 */       if (state == 2)
/* 289 */         g.drawString("_", x + 8 + this.fm.stringWidth(t1), y + 24); 
/* 291 */     } else if (optionalParam == 2) {
/* 292 */       g.drawString(t2, x + 8, y + 24);
/* 293 */       if (state == 2)
/* 294 */         g.drawString("_", x + 8 + this.fm.stringWidth(t2), y + 24); 
/* 296 */     } else if (optionalParam == 3) {
/* 297 */       g.drawString(t3, x + 8, y + 24);
/* 298 */       if (state == 2)
/* 299 */         g.drawString("_", x + 8 + this.fm.stringWidth(t3), y + 24); 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void drawTextBox(Graphics g, byte state, int x, int y, int w, int h, String t, String info) {
/* 308 */     g.setColor(Game.profileInfoColor);
/* 309 */     g.setFont(Game.profileInfoFont);
/* 312 */     g.drawString(info, x, y - 9);
/* 315 */     g.setColor(new Color(232, 232, 232));
/* 316 */     g.drawRect(x + 1, y + 1, w - 2, h - 2);
/* 317 */     g.drawRect(x, y, w, h);
/* 320 */     g.setColor(new Color(0, 0, 0, 180));
/* 321 */     g.fillRect(x + 2, y + 2, w - 3, h - 3);
/* 324 */     g.setFont(Game.buttonTextFont);
/* 325 */     g.setColor(Color.white);
/* 328 */     g.drawString(t, x + 8, y + 24);
/* 329 */     if (state == 2)
/* 330 */       g.drawString("_", x + 8 + this.fm.stringWidth(t), y + 24); 
/*     */   }
/*     */   
/*     */   public static void setCurrentProfile(int i) {
/* 335 */     if (i == 1) {
/* 336 */       save1State = 3;
/* 337 */       save2State = 0;
/* 338 */       save3State = 0;
/* 339 */     } else if (i == 2) {
/* 340 */       save1State = 0;
/* 341 */       save2State = 3;
/* 342 */       save3State = 0;
/* 343 */     } else if (i == 3) {
/* 344 */       save1State = 0;
/* 345 */       save2State = 0;
/* 346 */       save3State = 3;
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void enterGame() {
/* 351 */     Game.isInGame = true;
/* 352 */     menuState = 0;
/* 353 */     KeyManager.enterPressed = false;
/* 354 */     Player.up = false;
/* 355 */     Player.down = false;
/* 356 */     Player.left = false;
/* 357 */     Player.right = false;
/* 358 */     Player.healthBarCheck();
/*     */   }
/*     */   
/*     */   public void tick() {
/* 365 */     if (menuState == 2)
/* 366 */       profileTick(); 
/* 369 */     this.cloud1.tick(Game.width, 0.5D, 1);
/* 370 */     this.cloud2.tick(-155, 0.6D, 0);
/* 371 */     this.cloud3.tick(Game.width + 145, 0.4D, 1);
/*     */   }
/*     */   
/*     */   private void profileTick() {
/* 378 */     if (!Save.save1.exists()) {
/* 379 */       save1Name = "Play To Create Me";
/* 380 */     } else if (Save.save1.exists()) {
/* 381 */       save1Name = save1Name_backup;
/*     */     } 
/* 384 */     if (!Save.save2.exists()) {
/* 385 */       save2Name = "Play To Create Me";
/* 386 */     } else if (Save.save2.exists()) {
/* 387 */       save2Name = save2Name_backup;
/*     */     } 
/* 390 */     if (!Save.save3.exists()) {
/* 391 */       save3Name = "Play To Create Me";
/* 392 */     } else if (Save.save3.exists()) {
/* 393 */       save3Name = save3Name_backup;
/*     */     } 
/* 397 */     if (save1State == 3 || save2State == 3 || save3State == 3) {
/* 398 */       canPlayProfile = true;
/* 400 */     } else if (save1State == 0 && save2State == 0 && save3State == 0) {
/* 401 */       canPlayProfile = false;
/*     */     } 
/* 406 */     if (currentProfile == 0)
/* 407 */       canDeleteProfile = false; 
/* 410 */     if (currentProfile == 1 && !Save.save1.exists()) {
/* 411 */       canDeleteProfile = false;
/* 412 */     } else if (currentProfile == 1 && Save.save1.exists()) {
/* 413 */       canDeleteProfile = true;
/*     */     } 
/* 416 */     if (currentProfile == 2 && !Save.save2.exists()) {
/* 417 */       canDeleteProfile = false;
/* 418 */     } else if (currentProfile == 2 && Save.save2.exists()) {
/* 419 */       canDeleteProfile = true;
/*     */     } 
/* 422 */     if (currentProfile == 3 && !Save.save3.exists()) {
/* 423 */       canDeleteProfile = false;
/* 424 */     } else if (currentProfile == 3 && Save.save3.exists()) {
/* 425 */       canDeleteProfile = true;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void renderMain(Graphics g) {
/* 433 */     g.setColor(Game.skyColor);
/* 434 */     g.fillRect(0, 0, Game.width, Game.height);
/* 436 */     this.cloud1.render(g);
/* 437 */     this.cloud2.render(g);
/* 438 */     this.cloud3.render(g);
/* 440 */     if (menuState == 1) {
/* 441 */       renderState1(g);
/* 442 */     } else if (menuState == 2) {
/* 443 */       renderState2(g);
/* 444 */     } else if (menuState == 3) {
/* 445 */       renderState3(g);
/* 446 */     } else if (menuState == 4) {
/* 447 */       renderState4(g);
/* 448 */     } else if (menuState == 5) {
/* 449 */       renderState5(g);
/* 450 */     } else if (menuState == 6) {
/* 451 */       renderState6(g);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void renderState1(Graphics g) {
/* 462 */     this.fm = g.getFontMetrics(Game.profileInfoFont);
/* 463 */     this.fm2 = g.getFontMetrics(Game.buttonTextFont);
/* 466 */     g.drawImage(Game.logoImage, 
/* 467 */         Game.width / 2 - Game.logoImage.getWidth(), Game.height / 2 - 
/* 468 */         Game.logoImage.getWidth() - 45, 
/* 469 */         Game.logoImage.getWidth() * 2, Game.logoImage.getHeight() * 2, 
/* 470 */         null);
/* 473 */     g.setFont(Game.profileInfoFont);
/* 474 */     g.setColor(Game.profileInfoColor);
/* 475 */     g.drawString(Game.identifer, 
/* 476 */         Game.width / 2 - this.fm.stringWidth(Game.identifer) / 2, 
/* 477 */         Game.height / 2 + 48 + 110);
/* 480 */     g.setFont(Game.buttonTextFont);
/* 481 */     g.setColor(Color.white);
/* 482 */     g.drawString(Game.title, 5, Game.height - 13);
/* 483 */     g.drawString(Game.copyright, 
/* 484 */         Game.width - this.fm2.stringWidth(Game.copyright) + 10, 
/* 485 */         Game.height - 13);
/* 488 */     drawButton(g, Game.width / 2 - 168, Game.height / 2, 336, 32, "Play", 
/* 489 */         ImageManager.button2_1, ImageManager.button2_2, 
/* 490 */         ImageManager.button2_3, 1.1D);
/* 493 */     drawButton(g, Game.width / 2 - 168, Game.height / 2 + 48, 
/* 494 */         ImageManager.button2_1.getWidth(), 
/* 495 */         ImageManager.button2_1.getHeight(), "Options", 
/* 496 */         ImageManager.button2_1, ImageManager.button2_2, 
/* 497 */         ImageManager.button2_3, 1.2D);
/* 500 */     drawButton(g, Game.width / 2 - 168, Game.height / 2 + 48 + 48, 
/* 501 */         ImageManager.button2_1.getWidth(), 
/* 502 */         ImageManager.button2_1.getHeight(), "Quit Game", 
/* 503 */         ImageManager.button2_1, ImageManager.button2_2, 
/* 504 */         ImageManager.button2_3, 1.4D);
/*     */   }
/*     */   
/*     */   private void renderState2(Graphics g) {
/* 512 */     this.fm = g.getFontMetrics(Game.gameProgressFont);
/* 514 */     g.setFont(Game.profileInfoFont);
/* 515 */     g.setColor(Game.profileInfoColor);
/* 519 */     if (save1State == 3) {
/* 520 */       g.drawImage(ImageManager.profileSelection, Game.width / 2 - 150, 
/* 521 */           43, 300, 117, null);
/* 522 */       currentProfile = 1;
/* 523 */     } else if (save2State == 3) {
/* 524 */       g.drawImage(ImageManager.profileSelection, Game.width / 2 - 150, 
/* 525 */           153, 300, 117, null);
/* 526 */       currentProfile = 2;
/* 527 */     } else if (save3State == 3) {
/* 528 */       g.drawImage(ImageManager.profileSelection, Game.width / 2 - 150, 
/* 529 */           263, 300, 117, null);
/* 530 */       currentProfile = 3;
/*     */     } 
/* 535 */     drawProfile(g, save1State, Game.width / 2 - 144, 50, 
/* 536 */         Save.save1LastPlayed, Save.save1Made, Save.save1, 1, save1Name, 
/* 537 */         this.fm);
/* 539 */     drawProfile(g, save2State, Game.width / 2 - 144, 160, 
/* 540 */         Save.save2LastPlayed, Save.save2Made, Save.save2, 2, save2Name, 
/* 541 */         this.fm);
/* 543 */     drawProfile(g, save3State, Game.width / 2 - 144, 270, 
/* 544 */         Save.save3LastPlayed, Save.save3Made, Save.save3, 3, save3Name, 
/* 545 */         this.fm);
/* 549 */     if (canPlayProfile) {
/* 550 */       drawButton(g, 419 - ImageManager.button2_1.getWidth() / 2, 
/* 551 */           425, ImageManager.button2_1.getWidth(), 
/* 552 */           ImageManager.button2_1.getHeight(), 
/* 553 */           "Play Selected Profile", ImageManager.button2_1, 
/* 554 */           ImageManager.button2_2, ImageManager.button2_3, 2.1D);
/* 555 */     } else if (!canPlayProfile) {
/* 556 */       g.setFont(Game.buttonTextFont);
/* 557 */       g.drawImage(ImageManager.button2_3, 419 - 
/* 558 */           ImageManager.button2_3.getWidth() / 2, 425, 
/* 559 */           ImageManager.button2_3.getWidth(), 
/* 560 */           ImageManager.button2_3.getHeight(), null);
/* 561 */       g.setColor(Game.buttonClickedColor);
/* 562 */       g.drawString("Play Selected Profile", 324, 446);
/*     */     } 
/* 567 */     if (canDeleteProfile) {
/* 568 */       drawButton(g, 419 - ImageManager.button2_1.getWidth() / 2, 
/* 569 */           473, ImageManager.button1_1.getWidth(), 
/* 570 */           ImageManager.button1_1.getHeight(), "Delete", 
/* 571 */           ImageManager.button1_1, ImageManager.button1_2, 
/* 572 */           ImageManager.button1_3, 2.2D);
/* 573 */     } else if (!canDeleteProfile) {
/* 574 */       g.setFont(Game.buttonTextFont);
/* 575 */       g.drawImage(ImageManager.button1_3, 419 - 
/* 576 */           ImageManager.button2_1.getWidth() / 2, 473, 
/* 577 */           ImageManager.button1_3.getWidth(), 
/* 578 */           ImageManager.button1_3.getHeight(), null);
/* 579 */       g.setColor(Game.buttonClickedColor);
/* 580 */       g.drawString(
/* 581 */           "Delete", 
/* 582 */           300, 
/* 583 */           473 + ImageManager.button1_3.getHeight() / 2 + 5);
/*     */     } 
/* 588 */     drawButton(g, 419 - ImageManager.button2_1.getWidth() / 2 + 
/* 589 */         176, 473, ImageManager.button1_1.getWidth(), 
/* 590 */         ImageManager.button1_1.getHeight(), "Back", 
/* 591 */         ImageManager.button1_1, ImageManager.button1_2, 
/* 592 */         ImageManager.button1_3, 2.3D);
/*     */   }
/*     */   
/*     */   private void renderState3(Graphics g) {
/* 600 */     g.setFont(Game.areYouSureFont);
/* 601 */     g.setColor(Game.profileInfoColor);
/* 602 */     g.drawString("Are you sure?", 280, 190);
/* 604 */     g.setFont(Game.buttonTextFont);
/* 606 */     drawButton(g, 215, 325, ImageManager.button1_1.getWidth(), 
/* 607 */         ImageManager.button1_1.getHeight(), "Yes", 
/* 608 */         ImageManager.button1_1, ImageManager.button1_2, 
/* 609 */         ImageManager.button1_3, 3.1D);
/* 611 */     drawButton(g, 454, 325, ImageManager.button1_1.getWidth(), 
/* 612 */         ImageManager.button1_1.getHeight(), "No", 
/* 613 */         ImageManager.button1_1, ImageManager.button1_2, 
/* 614 */         ImageManager.button1_3, 3.2D);
/*     */   }
/*     */   
/*     */   private void renderState4(Graphics g) {
/* 622 */     this.fm = g.getFontMetrics(Game.profileInfoFont);
/* 625 */     drawButton(g, 419 - ImageManager.button2_1.getWidth() + 8, 
/* 626 */         100, ImageManager.button2_1.getWidth(), 
/* 627 */         ImageManager.button2_1.getHeight(), "Auto Save: " + 
/* 628 */         autoSaveToggle, ImageManager.button2_1, 
/* 629 */         ImageManager.button2_2, ImageManager.button2_3, 4.1D);
/* 630 */     g.setColor(Game.profileInfoColor);
/* 631 */     g.setFont(Game.profileInfoFont);
/* 634 */     drawButton(g, 427, 100, ImageManager.button2_1.getWidth(), 
/* 635 */         ImageManager.button2_1.getHeight(), "Test Dummy: " + tdToggle, 
/* 636 */         ImageManager.button2_1, ImageManager.button2_2, 
/* 637 */         ImageManager.button2_3, 4.3D);
/* 640 */     drawButton(g, 419 - ImageManager.button2_1.getWidth() + 8, 
/* 641 */         148, ImageManager.button2_1.getWidth(), 
/* 642 */         ImageManager.button2_1.getHeight(), "Reload Graphics", 
/* 643 */         ImageManager.button2_1, ImageManager.button2_2, 
/* 644 */         ImageManager.button2_3, 4.4D);
/* 647 */     drawButton(g, 419 - ImageManager.button1_1.getWidth() / 2, 
/* 648 */         445, ImageManager.button1_1.getWidth(), 
/* 649 */         ImageManager.button1_1.getHeight(), "About", 
/* 650 */         ImageManager.button1_1, ImageManager.button1_2, 
/* 651 */         ImageManager.button1_3, 4.5D);
/* 654 */     drawButton(g, 419 - 
/* 655 */         ImageManager.button2_1.getWidth() / 2 + 88, 
/* 656 */         445, ImageManager.button1_1.getWidth(), 
/* 657 */         ImageManager.button1_1.getHeight(), "Add-Ons...", 
/* 658 */         ImageManager.button1_1, ImageManager.button1_2, 
/* 659 */         ImageManager.button1_3, 4.2D);
/* 662 */     drawButton(g, 419 - ImageManager.button2_1.getWidth() / 2 + 
/* 663 */         176 + 88, 445, 
/* 664 */         ImageManager.button1_1.getWidth(), 
/* 665 */         ImageManager.button1_1.getHeight(), "Back", 
/* 666 */         ImageManager.button1_1, ImageManager.button1_2, 
/* 667 */         ImageManager.button1_3, 2.3D);
/*     */   }
/*     */   
/*     */   private void renderState5(Graphics g) {
/* 675 */     profileNameBoxState = getGeneralImageState(419 - 
/* 676 */         ImageManager.button2_1.getWidth() / 2 - 1, 89, 
/* 677 */         ImageManager.button2_1.getWidth() + 2, 
/* 678 */         ImageManager.button2_1.getHeight() + 2, profileNameBoxState, 
/* 679 */         profileNameBoxInFocus);
/* 681 */     playerNameBoxState = getGeneralImageState(419 - 
/* 682 */         ImageManager.button2_1.getWidth() / 2 - 1, 172, 
/* 683 */         ImageManager.button2_1.getWidth() + 2, 
/* 684 */         ImageManager.button2_1.getHeight() + 2, playerNameBoxState, 
/* 685 */         playerNameBoxInFocus);
/* 688 */     draw3WayTextBox(g, profileNameBoxState, 419 - 
/* 689 */         ImageManager.button2_1.getWidth() / 2 - 1, 89, 
/* 690 */         ImageManager.button2_1.getWidth() + 2, 
/* 691 */         ImageManager.button2_1.getHeight() + 2, save1Name, save2Name, 
/* 692 */         save3Name, "Profile Name: ", currentProfile);
/* 694 */     drawTextBox(g, playerNameBoxState, 419 - 
/* 695 */         ImageManager.button2_1.getWidth() / 2 - 1, 172, 
/* 696 */         ImageManager.button2_1.getWidth() + 2, 
/* 697 */         ImageManager.button2_1.getHeight() + 2, Player.typedName, 
/* 698 */         "Character's Name (Cannot change after this!)");
/* 701 */     drawButton(g, 419 - ImageManager.button2_1.getWidth() / 2, 
/* 702 */         437, ImageManager.button1_1.getWidth(), 
/* 703 */         ImageManager.button1_1.getHeight(), "Create Profile", 
/* 704 */         ImageManager.button1_1, ImageManager.button1_2, 
/* 705 */         ImageManager.button1_3, 5.1D);
/* 708 */     drawButton(
/* 709 */         g, 
/* 710 */         419 - 
/* 711 */         ImageManager.button2_1.getWidth() / 2 - ImageManager.button1_1
/* 712 */         .getWidth() + 16, 437, 
/* 713 */         ImageManager.button1_1.getWidth(), 
/* 714 */         ImageManager.button1_1.getHeight(), "Back", 
/* 715 */         ImageManager.button1_1, ImageManager.button1_2, 
/* 716 */         ImageManager.button1_3, 5.2D);
/*     */   }
/*     */   
/*     */   private void renderState6(Graphics g) {
/* 724 */     g.setFont(Game.buttonTextFont);
/* 725 */     g.setColor(Game.profileInfoColor);
/* 727 */     this.fm = g.getFontMetrics(Game.buttonTextFont);
/* 729 */     g.drawString("You were killed!", 
/* 730 */         419 - this.fm.stringWidth("You were killed!") / 2, 200);
/* 732 */     drawButton(g, 419 - ImageManager.button2_1.getWidth() / 2, 
/* 733 */         275, ImageManager.button2_1.getWidth(), 
/* 734 */         ImageManager.button2_1.getHeight(), "Respawn", 
/* 735 */         ImageManager.button2_1, ImageManager.button2_2, 
/* 736 */         ImageManager.button2_3, 6.1D);
/* 738 */     drawButton(g, 419 - ImageManager.button2_1.getWidth() / 2, 
/* 739 */         323, ImageManager.button2_1.getWidth(), 
/* 740 */         ImageManager.button2_1.getHeight(), "Save and Quit to Title", 
/* 741 */         ImageManager.button2_1, ImageManager.button2_2, 
/* 742 */         ImageManager.button2_3, 6.2D);
/*     */   }
/*     */   
/*     */   private void m1Play() {
/* 749 */     Game.endClick();
/* 750 */     menuState = 2;
/* 751 */     Load.loadData(Game.dataPath);
/*     */   }
/*     */   
/*     */   private void m1Options() {
/* 755 */     menuState = 4;
/* 756 */     Load.loadData(Game.dataPath);
/* 758 */     if (autoSaveToggle == "On" && !Game.autoSave) {
/* 759 */       autoSaveToggle = "Off";
/* 760 */     } else if (autoSaveToggle == "Off" && Game.autoSave) {
/* 761 */       autoSaveToggle = "On";
/*     */     } 
/* 765 */     if (tdToggle == "On" && !Game.dummy) {
/* 766 */       tdToggle = "Off";
/* 767 */     } else if (tdToggle == "Off" && Game.dummy) {
/* 768 */       tdToggle = "On";
/*     */     } 
/*     */   }
/*     */   
/*     */   private void m1Update() {
/* 773 */     Game.endClick();
/* 774 */     this.u.createWindow();
/*     */   }
/*     */   
/*     */   private void m1Quit() {
/* 778 */     System.exit(0);
/*     */   }
/*     */   
/*     */   public static void m2PlayProfile() throws IOException {
/* 783 */     if (currentProfile == 1) {
/* 784 */       if (Save.save1.exists()) {
/* 785 */         Load.loadProfile(Game.save1Path);
/* 786 */         Save.profileSave(Save.save1, Game.save1Path, 1);
/* 787 */         enterGame();
/* 788 */       } else if (!Save.save1.exists()) {
/* 789 */         save1Name = "";
/* 790 */         Player.typedName = "";
/* 791 */         cancelState = 0;
/* 792 */         menuState = 5;
/*     */       } 
/* 794 */     } else if (currentProfile == 2) {
/* 795 */       if (Save.save2.exists()) {
/* 796 */         Load.loadProfile(Game.save2Path);
/* 797 */         Save.profileSave(Save.save2, Game.save2Path, 2);
/* 798 */         enterGame();
/* 799 */       } else if (!Save.save2.exists()) {
/* 800 */         save2Name = "";
/* 801 */         Player.typedName = "";
/* 802 */         cancelState = 0;
/* 803 */         menuState = 5;
/*     */       } 
/* 805 */     } else if (currentProfile == 3) {
/* 806 */       if (Save.save3.exists()) {
/* 807 */         Load.loadProfile(Game.save3Path);
/* 808 */         Save.profileSave(Save.save3, Game.save3Path, 3);
/* 809 */         enterGame();
/* 810 */       } else if (!Save.save3.exists()) {
/* 811 */         save3Name = "";
/* 812 */         Player.typedName = "";
/* 813 */         cancelState = 0;
/* 814 */         menuState = 5;
/*     */       } 
/*     */     } 
/* 817 */     Game.endClick();
/* 818 */     TestDummy.reset();
/* 819 */     save1State = 0;
/* 820 */     save2State = 0;
/* 821 */     save3State = 0;
/*     */   }
/*     */   
/*     */   private void m2DeleteProfile() throws IOException {
/* 827 */     if (currentProfile == 1) {
/* 828 */       Save.save1.delete();
/* 829 */       Save.save1Made = "";
/* 830 */       Save.save1LastPlayed = "";
/* 831 */       Save.dataSave();
/* 832 */     } else if (currentProfile == 2) {
/* 833 */       Save.save2.delete();
/* 834 */       Save.save2Made = "";
/* 835 */       Save.save2LastPlayed = "";
/* 836 */       Save.dataSave();
/* 837 */     } else if (currentProfile == 3) {
/* 838 */       Save.save3.delete();
/* 839 */       Save.save3Made = " ";
/* 840 */       Save.save3LastPlayed = " ";
/* 841 */       Save.dataSave();
/*     */     } 
/* 844 */     menuState = 2;
/* 845 */     currentProfile = 0;
/*     */   }
/*     */   
/*     */   private void m2Back() {
/* 850 */     save1State = 0;
/* 851 */     save2State = 0;
/* 852 */     save3State = 0;
/* 853 */     currentProfile = 0;
/* 854 */     menuState = 1;
/*     */   }
/*     */   
/*     */   private void m3Yes() {
/*     */     try {
/* 860 */       m2DeleteProfile();
/* 861 */     } catch (IOException e) {
/* 862 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   private void m3No() {
/* 868 */     menuState = 2;
/*     */   }
/*     */   
/*     */   private void m4AutoSave() {
/* 872 */     if (autoSaveToggle == "On") {
/* 873 */       autoSaveToggle = "Off";
/* 874 */       Game.autoSave = false;
/* 875 */     } else if (autoSaveToggle == "Off") {
/* 876 */       autoSaveToggle = "On";
/* 877 */       Game.autoSave = true;
/*     */     } 
/* 879 */     Game.endClick();
/*     */     try {
/* 881 */       Save.dataSave();
/* 882 */     } catch (IOException e) {
/* 883 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   private void m4TestDummy() {
/* 888 */     if (tdToggle == "On") {
/* 889 */       tdToggle = "Off";
/* 890 */       Game.dummy = false;
/* 891 */     } else if (tdToggle == "Off") {
/* 892 */       tdToggle = "On";
/* 893 */       Game.dummy = true;
/*     */     } 
/* 895 */     Game.endClick();
/*     */     try {
/* 897 */       Save.dataSave();
/* 898 */     } catch (IOException e) {
/* 899 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   private void m4AddOns() {
/* 904 */     this.a.createWindow();
/* 905 */     Game.endClick();
/*     */   }
/*     */   
/*     */   private void m4Reload() {
/* 909 */     Game.loadGfx();
/*     */   }
/*     */   
/*     */   private void m4About() {
/* 913 */     this.ab.createWindow();
/* 914 */     Game.endClick();
/*     */   }
/*     */   
/*     */   private void m5CreateProfile(File save, String path) throws IOException {
/* 918 */     Save.reset();
/* 919 */     if (currentProfile == 1 && save1Name.length() == 0) {
/* 920 */       save1Name = "Profile 1";
/* 921 */       save1Name_backup = save1Name;
/* 922 */     } else if (currentProfile == 2 && save2Name.length() == 0) {
/* 923 */       save2Name = "Profile 2";
/* 924 */       save2Name_backup = save2Name;
/* 925 */     } else if (currentProfile == 3 && save3Name.length() == 0) {
/* 926 */       save3Name = "Profile 3";
/* 927 */       save3Name_backup = save3Name;
/*     */     } 
/* 929 */     if (Player.typedName.length() == 0) {
/* 930 */       Player.name = Player.defaultName;
/* 931 */     } else if (Player.typedName.length() >= 1) {
/* 932 */       Player.name = Player.typedName;
/*     */     } 
/* 934 */     Save.profileSave(save, path, currentProfile);
/* 935 */     Save.dataSave();
/* 936 */     Load.loadProfile(path);
/* 937 */     enterGame();
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.6_2.jar!\beyondOrigins\main\menus\MainMenu.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */