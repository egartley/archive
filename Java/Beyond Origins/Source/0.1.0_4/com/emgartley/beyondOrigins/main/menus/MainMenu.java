/*     */ package com.emgartley.beyondOrigins.main.menus;
/*     */ 
/*     */ import com.emgartley.beyondOrigins.files.Load;
/*     */ import com.emgartley.beyondOrigins.files.Save;
/*     */ import com.emgartley.beyondOrigins.main.Game;
/*     */ import com.emgartley.beyondOrigins.main.Profile1;
/*     */ import com.emgartley.beyondOrigins.main.Profile2;
/*     */ import com.emgartley.beyondOrigins.main.Profile3;
/*     */ import com.emgartley.beyondOrigins.main.entities.Cloud;
/*     */ import com.emgartley.beyondOrigins.main.entities.Entity;
/*     */ import com.emgartley.beyondOrigins.main.entities.TestDummy;
/*     */ import com.emgartley.beyondOrigins.main.gfx.ImageManager;
/*     */ import com.emgartley.beyondOrigins.main.windows.Credits;
/*     */ import com.emgartley.beyondOrigins.main.windows.ProfileCreator;
/*     */ import com.emgartley.beyondOrigins.userInput.KeyManager;
/*     */ import com.emgartley.beyondOrigins.userInput.MouseMotion;
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
/*  29 */   public byte menuState = 1;
/*     */   
/*     */   public byte state;
/*     */   
/*     */   public Cloud cloud1;
/*     */   
/*     */   public Cloud cloud2;
/*     */   
/*     */   public Cloud cloud3;
/*     */   
/*  35 */   public byte currentProfile = 0;
/*     */   
/*     */   public boolean canPlayProfile = false;
/*     */   
/*     */   public boolean canDeleteProfile = false;
/*     */   
/*     */   public byte cancelState;
/*     */   
/*     */   public byte save1State;
/*     */   
/*     */   public byte save2State;
/*     */   
/*     */   public byte save3State;
/*     */   
/*     */   public boolean enterProfile = false;
/*     */   
/*     */   public byte yesState;
/*     */   
/*     */   public byte noState;
/*     */   
/*     */   private Options o;
/*     */   
/*     */   private ProfileCreator proc;
/*     */   
/*     */   private Credits c;
/*     */   
/*     */   public MainMenu() {
/*  50 */     this.cloud1 = new Cloud(-195.0D, 135.0D);
/*  51 */     this.cloud2 = new Cloud(1033.0D, (286 - 
/*  52 */         ImageManager.cloud1.getHeight() / 2));
/*  53 */     this.cloud3 = new Cloud(-155.0D, 378.0D);
/*     */   }
/*     */   
/*     */   private byte getButtonState(int x, int y, int width, int height, byte state) {
/*  60 */     if (MouseMotion.mouseX >= x && MouseMotion.mouseX < x + width && 
/*  61 */       MouseMotion.mouseY >= y && MouseMotion.mouseY < y + height) {
/*  62 */       state = 2;
/*  63 */       if (Game.mouseIsPressed()) {
/*  64 */         state = 3;
/*     */       } else {
/*  66 */         state = 2;
/*     */       } 
/*     */     } else {
/*  68 */       state = 1;
/*     */     } 
/*  69 */     return state;
/*     */   }
/*     */   
/*     */   private void drawButton(Graphics g, int x, int y, int width, int height, String buttonText, BufferedImage state1Image, BufferedImage state2Image, BufferedImage state3Image, double clickEventType) {
/*  76 */     this.fm = g.getFontMetrics(Game.buttonTextFont);
/*  77 */     g.setFont(Game.buttonTextFont);
/*  78 */     if (getButtonState(x, y, width, height, this.state) == 1) {
/*  79 */       g.drawImage(state1Image, x, y, width, height, null);
/*  80 */       g.setColor(Game.buttonIdleColor);
/*  81 */       g.drawString(
/*  82 */           buttonText, 
/*  83 */           x + state1Image.getWidth() / 2 - 
/*  84 */           this.fm.stringWidth(buttonText) / 2, y + 
/*  85 */           state1Image.getHeight() / 2 + 5);
/*  86 */     } else if (getButtonState(x, y, width, height, this.state) == 2) {
/*  87 */       g.drawImage(state2Image, x, y, width, height, null);
/*  88 */       g.setColor(Game.buttonSelectedColor);
/*  89 */       g.drawString(
/*  90 */           buttonText, 
/*  91 */           x + state1Image.getWidth() / 2 - 
/*  92 */           this.fm.stringWidth(buttonText) / 2, y + 
/*  93 */           state1Image.getHeight() / 2 + 5);
/*  94 */     } else if (getButtonState(x, y, width, height, this.state) == 3) {
/*  95 */       g.drawImage(state3Image, x, y, width, height, null);
/*  96 */       g.setColor(Game.buttonClickedColor);
/*  97 */       g.drawString(
/*  98 */           buttonText, 
/*  99 */           x + state1Image.getWidth() / 2 - 
/* 100 */           this.fm.stringWidth(buttonText) / 2, y + 
/* 101 */           state1Image.getHeight() / 2 + 5);
/* 102 */       clickEventHandler(clickEventType);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void clickEventHandler(double e) {
/* 108 */     if (e == 1.1D) {
/* 109 */       m1Play();
/* 110 */     } else if (e == 1.2D) {
/* 111 */       m1Options();
/* 112 */     } else if (e == 1.3D) {
/* 113 */       m1Creds();
/* 114 */     } else if (e == 1.4D) {
/* 115 */       m1Quit();
/*     */     } 
/* 118 */     if (e == 2.1D) {
/*     */       try {
/* 120 */         m2PlayProfile();
/* 121 */       } catch (IOException ei) {
/* 122 */         ei.printStackTrace();
/*     */       } 
/* 124 */     } else if (e == 2.2D) {
/* 125 */       this.menuState = 3;
/* 126 */     } else if (e == 2.3D) {
/* 127 */       m2Back();
/*     */     } 
/* 130 */     if (e == 3.1D) {
/* 131 */       m3Yes();
/* 132 */     } else if (e == 3.2D) {
/* 133 */       m3No();
/*     */     } 
/* 136 */     if (e == 6.1D) {
/* 137 */       Game.getPlayer().respawn();
/* 138 */     } else if (e == 6.2D) {
/* 139 */       (Game.getPlayer()).health = (Game.getPlayer()).maxHealth;
/*     */       try {
/* 141 */         if (this.currentProfile == 1)
/* 142 */           Profile1.save(); 
/* 143 */         if (this.currentProfile == 2)
/* 144 */           Profile2.save(); 
/* 145 */         if (this.currentProfile == 3)
/* 146 */           Profile3.save(); 
/* 147 */         Save.dataSave();
/* 148 */       } catch (IOException e1) {
/* 149 */         e1.printStackTrace();
/*     */       } 
/* 151 */       Game.endClick();
/* 152 */       this.menuState = 1;
/* 153 */       this.currentProfile = 0;
/*     */     } 
/*     */   }
/*     */   
/*     */   private void drawProfile(Graphics g, byte state, int x, int y, String lastPlayed, String created, File file, int profileNumber, String name, FontMetrics fm) {
/* 160 */     g.drawImage(ImageManager.profileSquare, x, y, 
/* 161 */         ImageManager.profileSquare.getWidth(), 
/* 162 */         ImageManager.profileSquare.getHeight(), null);
/* 163 */     g.setColor(Game.gameProgressColor);
/* 164 */     g.setFont(Game.gameProgressFont);
/* 165 */     if (file.exists()) {
/* 166 */       g.drawImage(ImageManager.player_down[1], 
/* 167 */           ImageManager.profileSquare.getWidth() / 2 + x - 
/* 168 */           ImageManager.player_down[1].getWidth(), 
/* 169 */           y + ImageManager.profileSquare.getHeight() / 2 - 
/* 170 */           ImageManager.player_down[1].getHeight(), 64, 
/* 171 */           64, null);
/* 172 */     } else if (!file.exists()) {
/* 173 */       g.drawString("?", ImageManager.profileSquare.getWidth() / 2 + x - 
/* 174 */           fm.stringWidth("?") / 2, y + 62);
/*     */     } 
/* 176 */     if (this.currentProfile == profileNumber && state == 3) {
/* 177 */       g.setColor(Color.white);
/*     */     } else {
/* 179 */       g.setColor(Game.profileInfoColor);
/*     */     } 
/* 181 */     g.setFont(Game.profileNameFont);
/* 182 */     g.drawString(name, x + 105, y + 27);
/* 183 */     g.setFont(Game.profileInfoFont);
/* 184 */     g.drawString("Last Played: " + lastPlayed, x + 105, y + 27 + 27);
/* 185 */     g.drawString("Date Created: " + created, x + 105, y + 27 + 27 + 27);
/*     */   }
/*     */   
/*     */   public void setCurrentProfile(int i) {
/* 189 */     if (i == 1) {
/* 190 */       this.save1State = 3;
/* 191 */       this.save2State = 0;
/* 192 */       this.save3State = 0;
/* 193 */     } else if (i == 2) {
/* 194 */       this.save1State = 0;
/* 195 */       this.save2State = 3;
/* 196 */       this.save3State = 0;
/* 197 */     } else if (i == 3) {
/* 198 */       this.save1State = 0;
/* 199 */       this.save2State = 0;
/* 200 */       this.save3State = 3;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void enterGame(boolean first) {
/* 205 */     Game.logger.log("Entering game...");
/* 206 */     Game.isInGame = true;
/* 207 */     this.menuState = 0;
/* 208 */     Game.isLoading = true;
/* 209 */     KeyManager.enterPressed = false;
/* 210 */     (Game.getPlayer()).up = false;
/* 211 */     (Game.getPlayer()).down = false;
/* 212 */     (Game.getPlayer()).left = false;
/* 213 */     (Game.getPlayer()).right = false;
/* 214 */     Game.getPlayer().healthBarCheck();
/* 215 */     Game.getPlayer().fixPos();
/* 216 */     if (first) {
/* 217 */       Game.setProgress(1);
/* 218 */       Game.getStoryText().request(
/* 219 */           "Our story begins within a", 
/* 220 */           "town called " + Game.townName + ". " + 
/* 221 */           (Game.getPlayer()).name + " has", 
/* 222 */           "been told to go see his friend, Paige.", "", 
/* 223 */           "Go now, " + (Game.getPlayer()).name + ".", "", "- ???");
/*     */     } 
/* 225 */     Entity.checkData();
/* 226 */     Game.endClick();
/*     */   }
/*     */   
/*     */   public void tick() {
/* 230 */     this.cloud1.tick(Game.width, 0.3D, 1);
/* 231 */     this.cloud2.tick(-155, 0.4D, 0);
/* 232 */     this.cloud3.tick(Game.width + 145, 0.2D, 1);
/*     */   }
/*     */   
/*     */   private void profileCheck() {
/* 238 */     if (!Profile1.file.exists()) {
/* 239 */       Profile1.name = "Play To Create Me";
/* 240 */     } else if (Profile1.file.exists()) {
/* 241 */       Profile1.name = Profile1.backup_name;
/*     */     } 
/* 244 */     if (!Profile2.file.exists()) {
/* 245 */       Profile2.name = "Play To Create Me";
/* 246 */     } else if (Profile2.file.exists()) {
/* 247 */       Profile2.name = Profile2.backup_name;
/*     */     } 
/* 250 */     if (!Profile3.file.exists()) {
/* 251 */       Profile3.name = "Play To Create Me";
/* 252 */     } else if (Profile3.file.exists()) {
/* 253 */       Profile3.name = Profile3.backup_name;
/*     */     } 
/* 256 */     if (this.save1State == 3 || this.save2State == 3 || this.save3State == 3) {
/* 257 */       this.canPlayProfile = true;
/* 258 */     } else if (this.save1State == 0 && this.save2State == 0 && this.save3State == 0) {
/* 259 */       this.canPlayProfile = false;
/*     */     } 
/* 262 */     if ((this.currentProfile == 1 && !Profile1.file.exists()) || (
/* 263 */       this.currentProfile == 2 && !Profile2.file.exists()) || (
/* 264 */       this.currentProfile == 3 && !Profile3.file.exists())) {
/* 265 */       this.canDeleteProfile = false;
/* 266 */     } else if ((this.currentProfile == 1 && Profile1.file.exists()) || (
/* 267 */       this.currentProfile == 2 && Profile2.file.exists()) || (
/* 268 */       this.currentProfile == 3 && Profile3.file.exists())) {
/* 269 */       this.canDeleteProfile = true;
/*     */     } else {
/* 271 */       this.canDeleteProfile = false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void render(Graphics g) {
/* 278 */     g.setColor(Game.skyColor);
/* 279 */     g.fillRect(0, 0, Game.width, Game.height);
/* 281 */     this.cloud1.render(g);
/* 282 */     this.cloud2.render(g);
/* 283 */     this.cloud3.render(g);
/* 285 */     if (this.menuState == 1) {
/* 286 */       renderState1(g);
/* 287 */     } else if (this.menuState == 2) {
/* 288 */       renderState2(g);
/* 289 */     } else if (this.menuState == 3) {
/* 290 */       renderState3(g);
/* 291 */     } else if (this.menuState == 4) {
/* 292 */       renderState4(g);
/* 293 */     } else if (this.menuState != 5) {
/* 295 */       if (this.menuState == 6)
/* 296 */         renderState6(g); 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void renderState1(Graphics g) {
/* 305 */     this.fm = g.getFontMetrics(Game.profileInfoFont);
/* 306 */     this.fm2 = g.getFontMetrics(Game.buttonTextFont);
/* 309 */     g.drawImage(Game.logoImage, 
/* 310 */         Game.width / 2 - Game.logoImage.getWidth(), Game.height / 2 - 
/* 311 */         Game.logoImage.getWidth() - 45, 
/* 312 */         Game.logoImage.getWidth() * 2, Game.logoImage.getHeight() * 2, 
/* 313 */         null);
/* 316 */     g.setFont(Game.buttonTextFont);
/* 317 */     g.setColor(Color.white);
/* 318 */     g.drawString(Game.title, 5, Game.height - 13);
/* 319 */     g.drawString(Game.copyright, 
/* 320 */         Game.width - this.fm2.stringWidth(Game.copyright) + 10, 
/* 321 */         Game.height - 13);
/* 324 */     drawButton(g, Game.width / 2 - 168, Game.height / 2, 336, 32, "Play", 
/* 325 */         ImageManager.button2_1, ImageManager.button2_2, 
/* 326 */         ImageManager.button2_3, 1.1D);
/* 329 */     drawButton(g, Game.width / 2 - 168, Game.height / 2 + 48, 
/* 330 */         ImageManager.button2_1.getWidth(), 
/* 331 */         ImageManager.button2_1.getHeight(), "Options", 
/* 332 */         ImageManager.button2_1, ImageManager.button2_2, 
/* 333 */         ImageManager.button2_3, 1.2D);
/* 336 */     drawButton(g, Game.width / 2 - 168, Game.height / 2 + 48 + 48, 
/* 337 */         ImageManager.button2_1.getWidth(), 
/* 338 */         ImageManager.button2_1.getHeight(), "Quit", 
/* 339 */         ImageManager.button2_1, ImageManager.button2_2, 
/* 340 */         ImageManager.button2_3, 1.4D);
/*     */   }
/*     */   
/*     */   private void renderState2(Graphics g) {
/* 348 */     this.fm = g.getFontMetrics(Game.gameProgressFont);
/* 350 */     g.setFont(Game.profileInfoFont);
/* 351 */     g.setColor(Game.profileInfoColor);
/* 355 */     if (this.save1State == 3) {
/* 356 */       g.drawImage(ImageManager.profileSelection, 104, 107, 300, 
/* 357 */           117, null);
/* 358 */       this.currentProfile = 1;
/* 359 */       profileCheck();
/* 360 */     } else if (this.save2State == 3) {
/* 361 */       g.drawImage(ImageManager.profileSelection, 104, 217, 300, 117, null);
/* 362 */       this.currentProfile = 2;
/* 363 */       profileCheck();
/* 364 */     } else if (this.save3State == 3) {
/* 365 */       g.drawImage(ImageManager.profileSelection, 104, 327, 300, 
/* 366 */           117, null);
/* 367 */       this.currentProfile = 3;
/* 368 */       profileCheck();
/*     */     } 
/* 373 */     drawProfile(
/* 374 */         g, 
/* 375 */         this.save1State, 
/* 376 */         110, 
/* 377 */         Game.height / 2 - ImageManager.profileSquare.getHeight() / 2 - 110, 
/* 378 */         Profile1.lastPlayed, Profile1.made, Profile1.file, 1, 
/* 379 */         Profile1.name, this.fm);
/* 381 */     drawProfile(g, this.save2State, 110, Game.height / 2 - 
/* 382 */         ImageManager.profileSquare.getHeight() / 2, 
/* 383 */         Profile2.lastPlayed, Profile2.made, Profile2.file, 2, 
/* 384 */         Profile2.name, this.fm);
/* 386 */     drawProfile(
/* 387 */         g, 
/* 388 */         this.save3State, 
/* 389 */         110, 
/* 390 */         Game.height / 2 - ImageManager.profileSquare.getHeight() / 2 + 110, 
/* 391 */         Profile3.lastPlayed, Profile3.made, Profile3.file, 3, 
/* 392 */         Profile3.name, this.fm);
/* 394 */     this.fm2 = g.getFontMetrics(Game.buttonTextFont);
/* 398 */     if (this.canPlayProfile) {
/* 399 */       drawButton(g, Game.width - 110 - 128, Game.height / 2 - 48 - 16, 
/* 400 */           ImageManager.button1_1.getWidth(), 
/* 401 */           ImageManager.button1_1.getHeight(), "Play Profile", 
/* 402 */           ImageManager.button1_1, ImageManager.button1_2, 
/* 403 */           ImageManager.button1_3, 2.1D);
/* 404 */     } else if (!this.canPlayProfile) {
/* 405 */       g.setFont(Game.buttonTextFont);
/* 406 */       g.drawImage(ImageManager.button1_3, Game.width - 110 - 128, 
/* 407 */           Game.height / 2 - 48 - 16, 
/* 408 */           ImageManager.button1_3.getWidth(), 
/* 409 */           ImageManager.button1_3.getHeight(), null);
/* 410 */       g.setColor(Game.buttonClickedColor);
/* 411 */       g.drawString("Play Profile", 
/* 412 */           Game.width - 128 - 110 + 29, 
/* 413 */           229);
/*     */     } 
/* 418 */     if (this.canDeleteProfile) {
/* 419 */       drawButton(g, Game.width - 110 - 128, Game.height / 2 - 16, 
/* 420 */           ImageManager.button1_1.getWidth(), 
/* 421 */           ImageManager.button1_1.getHeight(), "Delete", 
/* 422 */           ImageManager.button1_1, ImageManager.button1_2, 
/* 423 */           ImageManager.button1_3, 2.2D);
/* 424 */     } else if (!this.canDeleteProfile) {
/* 425 */       g.setFont(Game.buttonTextFont);
/* 426 */       g.drawImage(ImageManager.button1_3, Game.width - 110 - 128, 
/* 427 */           Game.height / 2 - 16, ImageManager.button1_3.getWidth(), 
/* 428 */           ImageManager.button1_3.getHeight(), null);
/* 429 */       g.setColor(Game.buttonClickedColor);
/* 430 */       g.drawString("Delete", Game.width - 189, 
/* 431 */           Game.height / 2 + 5);
/*     */     } 
/* 436 */     drawButton(g, Game.width - 110 - 128, Game.height / 2 - 16 + 48, 
/* 437 */         ImageManager.button1_1.getWidth(), 
/* 438 */         ImageManager.button1_1.getHeight(), "Back", 
/* 439 */         ImageManager.button1_1, ImageManager.button1_2, 
/* 440 */         ImageManager.button1_3, 2.3D);
/*     */   }
/*     */   
/*     */   private void renderState3(Graphics g) {
/* 448 */     g.setFont(Game.areYouSureFont);
/* 449 */     g.setColor(Game.profileInfoColor);
/* 450 */     g.drawString("Are you sure?", 280, 190);
/* 452 */     g.setFont(Game.buttonTextFont);
/* 454 */     drawButton(g, Game.width / 2 - 204, 325, 
/* 455 */         ImageManager.button1_1.getWidth(), 
/* 456 */         ImageManager.button1_1.getHeight(), "Yes", 
/* 457 */         ImageManager.button1_1, ImageManager.button1_2, 
/* 458 */         ImageManager.button1_3, 3.1D);
/* 460 */     drawButton(g, Game.width / 2 + 35, 325, 
/* 461 */         ImageManager.button1_1.getWidth(), 
/* 462 */         ImageManager.button1_1.getHeight(), "No", 
/* 463 */         ImageManager.button1_1, ImageManager.button1_2, 
/* 464 */         ImageManager.button1_3, 3.2D);
/*     */   }
/*     */   
/*     */   private void renderState4(Graphics g) {
/* 471 */     this.o.render(g);
/*     */   }
/*     */   
/*     */   private void renderState6(Graphics g) {
/* 478 */     g.setFont(Game.buttonTextFont);
/* 479 */     g.setColor(Game.profileInfoColor);
/* 481 */     this.fm = g.getFontMetrics(Game.buttonTextFont);
/* 483 */     g.drawString("You were killed!", 
/* 484 */         Game.width / 2 - this.fm.stringWidth("You were killed!") / 2, 
/* 485 */         200);
/* 487 */     drawButton(g, Game.width / 2 - 
/* 488 */         ImageManager.button2_1.getWidth() / 2, 275, 
/* 489 */         ImageManager.button2_1.getWidth(), 
/* 490 */         ImageManager.button2_1.getHeight(), "Respawn", 
/* 491 */         ImageManager.button2_1, ImageManager.button2_2, 
/* 492 */         ImageManager.button2_3, 6.1D);
/* 494 */     drawButton(g, Game.width / 2 - 
/* 495 */         ImageManager.button2_1.getWidth() / 2, 323, 
/* 496 */         ImageManager.button2_1.getWidth(), 
/* 497 */         ImageManager.button2_1.getHeight(), "Save and Quit to Title", 
/* 498 */         ImageManager.button2_1, ImageManager.button2_2, 
/* 499 */         ImageManager.button2_3, 6.2D);
/*     */   }
/*     */   
/*     */   private void m1Play() {
/* 504 */     this.menuState = 2;
/* 505 */     Load.loadData(Game.dataPath);
/* 506 */     this.save1State = 0;
/* 507 */     this.save2State = 0;
/* 508 */     this.save3State = 0;
/* 509 */     profileCheck();
/* 510 */     Game.endClick();
/*     */   }
/*     */   
/*     */   public void m1Options() {
/* 514 */     this.menuState = 4;
/* 515 */     this.o = new Options();
/* 516 */     Game.endClick();
/*     */   }
/*     */   
/*     */   private void m1Quit() {
/* 520 */     System.exit(0);
/*     */   }
/*     */   
/*     */   public void m1Creds() {
/* 524 */     this.c = new Credits();
/* 525 */     this.c.createWindow();
/* 526 */     Game.endClick();
/*     */   }
/*     */   
/*     */   public void m2PlayProfile() throws IOException {
/* 530 */     if (this.currentProfile == 1) {
/* 531 */       if (Profile1.file.exists()) {
/* 532 */         Load.loadProfile(Game.save1Path, 1);
/* 533 */         enterGame(false);
/* 534 */       } else if (!Profile1.file.exists()) {
/* 535 */         Profile1.name = "";
/* 536 */         (Game.getPlayer()).typedName = "";
/* 537 */         this.cancelState = 0;
/* 538 */         this.save1State = 3;
/* 539 */         this.proc = new ProfileCreator();
/* 540 */         this.proc.createWindow(1);
/*     */       } 
/* 542 */     } else if (this.currentProfile == 2) {
/* 543 */       if (Profile2.file.exists()) {
/* 544 */         Load.loadProfile(Game.save2Path, 2);
/* 545 */         enterGame(false);
/* 546 */       } else if (!Profile2.file.exists()) {
/* 547 */         Profile2.name = "";
/* 548 */         (Game.getPlayer()).typedName = "";
/* 549 */         this.cancelState = 0;
/* 550 */         this.proc = new ProfileCreator();
/* 551 */         this.proc.createWindow(2);
/*     */       } 
/* 553 */     } else if (this.currentProfile == 3) {
/* 554 */       if (Profile3.file.exists()) {
/* 555 */         Load.loadProfile(Game.save3Path, 3);
/* 556 */         enterGame(false);
/* 557 */       } else if (!Profile3.file.exists()) {
/* 558 */         Profile3.name = "";
/* 559 */         (Game.getPlayer()).typedName = "";
/* 560 */         this.cancelState = 0;
/* 561 */         this.proc = new ProfileCreator();
/* 562 */         this.proc.createWindow(3);
/*     */       } 
/*     */     } 
/* 565 */     Game.endClick();
/* 566 */     TestDummy.reset();
/*     */   }
/*     */   
/*     */   private void m2DeleteProfile() throws IOException {
/* 570 */     if (this.currentProfile == 1) {
/* 571 */       Profile1.file.delete();
/* 572 */       Profile1.made = " ";
/* 573 */       Profile1.lastPlayed = " ";
/* 574 */       Save.dataSave();
/* 575 */     } else if (this.currentProfile == 2) {
/* 576 */       Profile2.file.delete();
/* 577 */       Profile2.made = " ";
/* 578 */       Profile2.lastPlayed = " ";
/* 579 */       Save.dataSave();
/* 580 */     } else if (this.currentProfile == 3) {
/* 581 */       Profile3.file.delete();
/* 582 */       Profile3.made = " ";
/* 583 */       Profile3.lastPlayed = " ";
/* 584 */       Save.dataSave();
/*     */     } 
/* 586 */     this.menuState = 2;
/* 587 */     this.currentProfile = 0;
/* 588 */     profileCheck();
/* 589 */     Game.endClick();
/*     */   }
/*     */   
/*     */   private void m2Back() {
/* 593 */     this.save1State = 0;
/* 594 */     this.save2State = 0;
/* 595 */     this.save3State = 0;
/* 596 */     this.currentProfile = 0;
/* 597 */     this.menuState = 1;
/* 598 */     Game.endClick();
/*     */   }
/*     */   
/*     */   private void m3Yes() {
/*     */     try {
/* 603 */       m2DeleteProfile();
/* 604 */     } catch (IOException e) {
/* 605 */       e.printStackTrace();
/*     */     } 
/* 607 */     Game.endClick();
/*     */   }
/*     */   
/*     */   private void m3No() {
/* 611 */     this.menuState = 2;
/* 612 */     Game.endClick();
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.1.0_4.jar!\com\emgartley\beyondOrigins\main\menus\MainMenu.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */