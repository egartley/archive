/*     */ package beyondOrigins.main.menus;
/*     */ 
/*     */ import beyondOrigins.files.Load;
/*     */ import beyondOrigins.files.Save;
/*     */ import beyondOrigins.main.Game;
/*     */ import beyondOrigins.main.Profile1;
/*     */ import beyondOrigins.main.Profile2;
/*     */ import beyondOrigins.main.Profile3;
/*     */ import beyondOrigins.main.entities.Cloud;
/*     */ import beyondOrigins.main.entities.TestDummy;
/*     */ import beyondOrigins.main.gfx.ImageManager;
/*     */ import beyondOrigins.main.windows.Credits;
/*     */ import beyondOrigins.main.windows.ProfileCreator;
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
/*  21 */   public byte menuState = 1;
/*     */   
/*     */   public byte state;
/*     */   
/*     */   public Cloud cloud1;
/*     */   
/*     */   public Cloud cloud2;
/*     */   
/*     */   public Cloud cloud3;
/*     */   
/*  27 */   public byte currentProfile = 0;
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
/*  42 */     this.cloud1 = new Cloud(-195.0D, 135.0D);
/*  43 */     this.cloud2 = new Cloud(1033.0D, (286 - 
/*  44 */         ImageManager.cloud1.getHeight() / 2));
/*  45 */     this.cloud3 = new Cloud(-155.0D, 378.0D);
/*     */   }
/*     */   
/*     */   private byte getButtonState(int x, int y, int width, int height, byte state) {
/*  52 */     if (MouseMotion.mouseX >= x && MouseMotion.mouseX < x + width && 
/*  53 */       MouseMotion.mouseY >= y && MouseMotion.mouseY < y + height) {
/*  54 */       state = 2;
/*  55 */       if (Game.mouseIsPressed()) {
/*  56 */         state = 3;
/*     */       } else {
/*  58 */         state = 2;
/*     */       } 
/*     */     } else {
/*  60 */       state = 1;
/*     */     } 
/*  61 */     return state;
/*     */   }
/*     */   
/*     */   private void drawButton(Graphics g, int x, int y, int width, int height, String buttonText, BufferedImage state1Image, BufferedImage state2Image, BufferedImage state3Image, double clickEventType) {
/*  68 */     this.fm = g.getFontMetrics(Game.buttonTextFont);
/*  69 */     g.setFont(Game.buttonTextFont);
/*  70 */     if (getButtonState(x, y, width, height, this.state) == 1) {
/*  71 */       g.drawImage(state1Image, x, y, width, height, null);
/*  72 */       g.setColor(Game.buttonIdleColor);
/*  73 */       g.drawString(
/*  74 */           buttonText, 
/*  75 */           x + state1Image.getWidth() / 2 - 
/*  76 */           this.fm.stringWidth(buttonText) / 2, y + 
/*  77 */           state1Image.getHeight() / 2 + 5);
/*  78 */     } else if (getButtonState(x, y, width, height, this.state) == 2) {
/*  79 */       g.drawImage(state2Image, x, y, width, height, null);
/*  80 */       g.setColor(Game.buttonSelectedColor);
/*  81 */       g.drawString(
/*  82 */           buttonText, 
/*  83 */           x + state1Image.getWidth() / 2 - 
/*  84 */           this.fm.stringWidth(buttonText) / 2, y + 
/*  85 */           state1Image.getHeight() / 2 + 5);
/*  86 */     } else if (getButtonState(x, y, width, height, this.state) == 3) {
/*  87 */       g.drawImage(state3Image, x, y, width, height, null);
/*  88 */       g.setColor(Game.buttonClickedColor);
/*  89 */       g.drawString(
/*  90 */           buttonText, 
/*  91 */           x + state1Image.getWidth() / 2 - 
/*  92 */           this.fm.stringWidth(buttonText) / 2, y + 
/*  93 */           state1Image.getHeight() / 2 + 5);
/*  94 */       clickEventHandler(clickEventType);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void clickEventHandler(double e) {
/* 100 */     if (e == 1.1D) {
/* 101 */       m1Play();
/* 102 */     } else if (e == 1.2D) {
/* 103 */       m1Options();
/* 104 */     } else if (e == 1.3D) {
/* 105 */       m1Creds();
/* 106 */     } else if (e == 1.4D) {
/* 107 */       m1Quit();
/*     */     } 
/* 110 */     if (e == 2.1D) {
/*     */       try {
/* 112 */         m2PlayProfile();
/* 113 */       } catch (IOException ei) {
/* 114 */         ei.printStackTrace();
/*     */       } 
/* 116 */     } else if (e == 2.2D) {
/* 117 */       this.menuState = 3;
/* 118 */     } else if (e == 2.3D) {
/* 119 */       m2Back();
/*     */     } 
/* 122 */     if (e == 3.1D) {
/* 123 */       m3Yes();
/* 124 */     } else if (e == 3.2D) {
/* 125 */       m3No();
/*     */     } 
/* 128 */     if (e == 6.1D) {
/* 129 */       Game.getPlayer().respawn();
/* 130 */     } else if (e == 6.2D) {
/* 131 */       (Game.getPlayer()).health = (Game.getPlayer()).maxHealth;
/*     */       try {
/* 133 */         if (this.currentProfile == 1)
/* 134 */           Profile1.save(); 
/* 135 */         if (this.currentProfile == 2)
/* 136 */           Profile2.save(); 
/* 137 */         if (this.currentProfile == 3)
/* 138 */           Profile3.save(); 
/* 139 */         Save.dataSave();
/* 140 */       } catch (IOException e1) {
/* 141 */         e1.printStackTrace();
/*     */       } 
/* 143 */       Game.endClick();
/* 144 */       this.menuState = 1;
/* 145 */       this.currentProfile = 0;
/*     */     } 
/*     */   }
/*     */   
/*     */   private void drawProfile(Graphics g, byte state, int x, int y, String lastPlayed, String created, File file, int profileNumber, String name, FontMetrics fm) {
/* 152 */     g.drawImage(ImageManager.profileSquare, x, y, 
/* 153 */         ImageManager.profileSquare.getWidth(), 
/* 154 */         ImageManager.profileSquare.getHeight(), null);
/* 155 */     g.setColor(Game.gameProgressColor);
/* 156 */     g.setFont(Game.gameProgressFont);
/* 157 */     if (file.exists()) {
/* 158 */       g.drawImage(ImageManager.player_down[1], 
/* 159 */           ImageManager.profileSquare.getWidth() / 2 + x - 
/* 160 */           ImageManager.player_down[1].getWidth(), 
/* 161 */           y + ImageManager.profileSquare.getHeight() / 2 - 
/* 162 */           ImageManager.player_down[1].getHeight(), 64, 
/* 163 */           64, null);
/* 164 */     } else if (!file.exists()) {
/* 165 */       g.drawString("?", ImageManager.profileSquare.getWidth() / 2 + x - 
/* 166 */           fm.stringWidth("?") / 2, profileNumber * 110);
/*     */     } 
/* 168 */     if (this.currentProfile == profileNumber && state == 3) {
/* 169 */       g.setColor(Color.white);
/*     */     } else {
/* 171 */       g.setColor(Game.profileInfoColor);
/*     */     } 
/* 173 */     g.setFont(Game.profileNameFont);
/* 174 */     g.drawString(name, Game.width / 2 - 31, profileNumber * 110 - 40);
/* 175 */     g.setFont(Game.profileInfoFont);
/* 176 */     g.drawString("Last Played: " + lastPlayed, Game.width / 2 - 31, 
/* 177 */         profileNumber * 110 - 40 + 33);
/* 178 */     g.drawString("Date Created: " + created, Game.width / 2 - 31, 
/* 179 */         profileNumber * 110 - 40 + 66);
/*     */   }
/*     */   
/*     */   public void setCurrentProfile(int i) {
/* 184 */     if (i == 1) {
/* 185 */       this.save1State = 3;
/* 186 */       this.save2State = 0;
/* 187 */       this.save3State = 0;
/* 188 */     } else if (i == 2) {
/* 189 */       this.save1State = 0;
/* 190 */       this.save2State = 3;
/* 191 */       this.save3State = 0;
/* 192 */     } else if (i == 3) {
/* 193 */       this.save1State = 0;
/* 194 */       this.save2State = 0;
/* 195 */       this.save3State = 3;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void enterGame() {
/* 200 */     Game.logger.log("Entering game...");
/* 201 */     Game.isInGame = true;
/* 202 */     this.menuState = 0;
/* 203 */     Game.isLoading = true;
/* 204 */     KeyManager.enterPressed = false;
/* 205 */     (Game.getPlayer()).up = false;
/* 206 */     (Game.getPlayer()).down = false;
/* 207 */     (Game.getPlayer()).left = false;
/* 208 */     (Game.getPlayer()).right = false;
/* 209 */     Game.getPlayer().healthBarCheck();
/* 210 */     Game.getPlayer().fixPos();
/* 211 */     Game.endClick();
/*     */   }
/*     */   
/*     */   public void tick() {
/* 215 */     this.cloud1.tick(Game.width, 0.3D, 1);
/* 216 */     this.cloud2.tick(-155, 0.4D, 0);
/* 217 */     this.cloud3.tick(Game.width + 145, 0.2D, 1);
/*     */   }
/*     */   
/*     */   private void profileCheck() {
/* 223 */     if (!Profile1.file.exists()) {
/* 224 */       Profile1.name = "Play To Create Me";
/* 225 */     } else if (Profile1.file.exists()) {
/* 226 */       Profile1.name = Profile1.backup_name;
/*     */     } 
/* 229 */     if (!Profile2.file.exists()) {
/* 230 */       Profile2.name = "Play To Create Me";
/* 231 */     } else if (Profile2.file.exists()) {
/* 232 */       Profile2.name = Profile2.backup_name;
/*     */     } 
/* 235 */     if (!Profile3.file.exists()) {
/* 236 */       Profile3.name = "Play To Create Me";
/* 237 */     } else if (Profile3.file.exists()) {
/* 238 */       Profile3.name = Profile3.backup_name;
/*     */     } 
/* 241 */     if (this.save1State == 3 || this.save2State == 3 || this.save3State == 3) {
/* 242 */       this.canPlayProfile = true;
/* 243 */     } else if (this.save1State == 0 && this.save2State == 0 && this.save3State == 0) {
/* 244 */       this.canPlayProfile = false;
/*     */     } 
/* 247 */     if ((this.currentProfile == 1 && !Profile1.file.exists()) || (
/* 248 */       this.currentProfile == 2 && !Profile2.file.exists()) || (
/* 249 */       this.currentProfile == 3 && !Profile3.file.exists())) {
/* 250 */       this.canDeleteProfile = false;
/* 251 */     } else if ((this.currentProfile == 1 && Profile1.file.exists()) || (
/* 252 */       this.currentProfile == 2 && Profile2.file.exists()) || (
/* 253 */       this.currentProfile == 3 && Profile3.file.exists())) {
/* 254 */       this.canDeleteProfile = true;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void render(Graphics g) {
/* 261 */     g.setColor(Game.skyColor);
/* 262 */     g.fillRect(0, 0, Game.width, Game.height);
/* 264 */     this.cloud1.render(g);
/* 265 */     this.cloud2.render(g);
/* 266 */     this.cloud3.render(g);
/* 268 */     if (this.menuState == 1) {
/* 269 */       renderState1(g);
/* 270 */     } else if (this.menuState == 2) {
/* 271 */       renderState2(g);
/* 272 */     } else if (this.menuState == 3) {
/* 273 */       renderState3(g);
/* 274 */     } else if (this.menuState == 4) {
/* 275 */       renderState4(g);
/* 276 */     } else if (this.menuState != 5) {
/* 278 */       if (this.menuState == 6)
/* 279 */         renderState6(g); 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void renderState1(Graphics g) {
/* 288 */     this.fm = g.getFontMetrics(Game.profileInfoFont);
/* 289 */     this.fm2 = g.getFontMetrics(Game.buttonTextFont);
/* 292 */     g.drawImage(Game.logoImage, 
/* 293 */         Game.width / 2 - Game.logoImage.getWidth(), Game.height / 2 - 
/* 294 */         Game.logoImage.getWidth() - 45, 
/* 295 */         Game.logoImage.getWidth() * 2, Game.logoImage.getHeight() * 2, 
/* 296 */         null);
/* 299 */     g.setFont(Game.buttonTextFont);
/* 300 */     g.setColor(Color.white);
/* 301 */     g.drawString(Game.title, 5, Game.height - 13);
/* 302 */     g.drawString(Game.copyright, 
/* 303 */         Game.width - this.fm2.stringWidth(Game.copyright) + 10, 
/* 304 */         Game.height - 13);
/* 307 */     drawButton(g, Game.width / 2 - 168, Game.height / 2, 336, 32, "Play", 
/* 308 */         ImageManager.button2_1, ImageManager.button2_2, 
/* 309 */         ImageManager.button2_3, 1.1D);
/* 312 */     drawButton(g, Game.width / 2 - 168, Game.height / 2 + 48, 
/* 313 */         ImageManager.button2_1.getWidth(), 
/* 314 */         ImageManager.button2_1.getHeight(), "Options", 
/* 315 */         ImageManager.button2_1, ImageManager.button2_2, 
/* 316 */         ImageManager.button2_3, 1.2D);
/* 319 */     drawButton(g, Game.width / 2 - 168, Game.height / 2 + 48 + 48, 
/* 320 */         ImageManager.button2_1.getWidth(), 
/* 321 */         ImageManager.button2_1.getHeight(), "Quit", 
/* 322 */         ImageManager.button2_1, ImageManager.button2_2, 
/* 323 */         ImageManager.button2_3, 1.4D);
/*     */   }
/*     */   
/*     */   private void renderState2(Graphics g) {
/* 331 */     this.fm = g.getFontMetrics(Game.gameProgressFont);
/* 333 */     g.setFont(Game.profileInfoFont);
/* 334 */     g.setColor(Game.profileInfoColor);
/* 338 */     if (this.save1State == 3) {
/* 339 */       g.drawImage(ImageManager.profileSelection, Game.width / 2 - 150, 
/* 340 */           43, 300, 117, null);
/* 341 */       this.currentProfile = 1;
/* 342 */       profileCheck();
/* 343 */     } else if (this.save2State == 3) {
/* 344 */       g.drawImage(ImageManager.profileSelection, Game.width / 2 - 150, 
/* 345 */           153, 300, 117, null);
/* 346 */       this.currentProfile = 2;
/* 347 */       profileCheck();
/* 348 */     } else if (this.save3State == 3) {
/* 349 */       g.drawImage(ImageManager.profileSelection, Game.width / 2 - 150, 
/* 350 */           263, 300, 117, null);
/* 351 */       this.currentProfile = 3;
/* 352 */       profileCheck();
/*     */     } 
/* 357 */     drawProfile(g, this.save1State, Game.width / 2 - 144, 50, 
/* 358 */         Profile1.lastPlayed, Profile1.made, Profile1.file, 1, 
/* 359 */         Profile1.name, this.fm);
/* 361 */     drawProfile(g, this.save2State, Game.width / 2 - 144, 160, 
/* 362 */         Profile2.lastPlayed, Profile2.made, Profile2.file, 2, 
/* 363 */         Profile2.name, this.fm);
/* 365 */     drawProfile(g, this.save3State, Game.width / 2 - 144, 270, 
/* 366 */         Profile3.lastPlayed, Profile3.made, Profile3.file, 3, 
/* 367 */         Profile3.name, this.fm);
/* 369 */     this.fm2 = g.getFontMetrics(Game.buttonTextFont);
/* 373 */     if (this.canPlayProfile) {
/* 374 */       drawButton(g, Game.width / 2 - 
/* 375 */           ImageManager.button2_1.getWidth() / 2, 425, 
/* 376 */           ImageManager.button2_1.getWidth(), 
/* 377 */           ImageManager.button2_1.getHeight(), "Play Profile", 
/* 378 */           ImageManager.button2_1, ImageManager.button2_2, 
/* 379 */           ImageManager.button2_3, 2.1D);
/* 380 */     } else if (!this.canPlayProfile) {
/* 381 */       g.setFont(Game.buttonTextFont);
/* 382 */       g.drawImage(ImageManager.button2_3, Game.width / 2 - 
/* 383 */           ImageManager.button2_3.getWidth() / 2, 425, 
/* 384 */           ImageManager.button2_3.getWidth(), 
/* 385 */           ImageManager.button2_3.getHeight(), null);
/* 386 */       g.setColor(Game.buttonClickedColor);
/* 387 */       g.drawString("Play Profile", 
/* 388 */           Game.width / 2 - this.fm2.stringWidth("Play Profile") / 2, 
/* 389 */           446);
/*     */     } 
/* 394 */     if (this.canDeleteProfile) {
/* 395 */       drawButton(g, Game.width / 2 - 
/* 396 */           ImageManager.button2_1.getWidth() / 2, 473, 
/* 397 */           ImageManager.button1_1.getWidth(), 
/* 398 */           ImageManager.button1_1.getHeight(), "Delete", 
/* 399 */           ImageManager.button1_1, ImageManager.button1_2, 
/* 400 */           ImageManager.button1_3, 2.2D);
/* 401 */     } else if (!this.canDeleteProfile) {
/* 402 */       g.setFont(Game.buttonTextFont);
/* 403 */       g.drawImage(ImageManager.button1_3, Game.width / 2 - 
/* 404 */           ImageManager.button2_1.getWidth() / 2, 473, 
/* 405 */           ImageManager.button1_3.getWidth(), 
/* 406 */           ImageManager.button1_3.getHeight(), null);
/* 407 */       g.setColor(Game.buttonClickedColor);
/* 408 */       g.drawString(
/* 409 */           "Delete", 
/* 410 */           Game.width / 2 - ImageManager.button1_1.getWidth() / 2 - 8 - 
/* 411 */           this.fm2.stringWidth("Delete") / 2, 
/* 412 */           473 + ImageManager.button1_3.getHeight() / 2 + 5);
/*     */     } 
/* 417 */     drawButton(g, Game.width / 2 - 
/* 418 */         ImageManager.button2_1.getWidth() / 2 + 176, 473, 
/* 419 */         ImageManager.button1_1.getWidth(), 
/* 420 */         ImageManager.button1_1.getHeight(), "Back", 
/* 421 */         ImageManager.button1_1, ImageManager.button1_2, 
/* 422 */         ImageManager.button1_3, 2.3D);
/*     */   }
/*     */   
/*     */   private void renderState3(Graphics g) {
/* 430 */     g.setFont(Game.areYouSureFont);
/* 431 */     g.setColor(Game.profileInfoColor);
/* 432 */     g.drawString("Are you sure?", 280, 190);
/* 434 */     g.setFont(Game.buttonTextFont);
/* 436 */     drawButton(g, Game.width / 2 - 204, 325, 
/* 437 */         ImageManager.button1_1.getWidth(), 
/* 438 */         ImageManager.button1_1.getHeight(), "Yes", 
/* 439 */         ImageManager.button1_1, ImageManager.button1_2, 
/* 440 */         ImageManager.button1_3, 3.1D);
/* 442 */     drawButton(g, Game.width / 2 + 35, 325, 
/* 443 */         ImageManager.button1_1.getWidth(), 
/* 444 */         ImageManager.button1_1.getHeight(), "No", 
/* 445 */         ImageManager.button1_1, ImageManager.button1_2, 
/* 446 */         ImageManager.button1_3, 3.2D);
/*     */   }
/*     */   
/*     */   private void renderState4(Graphics g) {
/* 453 */     this.o.render(g);
/*     */   }
/*     */   
/*     */   private void renderState6(Graphics g) {
/* 460 */     g.setFont(Game.buttonTextFont);
/* 461 */     g.setColor(Game.profileInfoColor);
/* 463 */     this.fm = g.getFontMetrics(Game.buttonTextFont);
/* 465 */     g.drawString("You were killed!", 
/* 466 */         Game.width / 2 - this.fm.stringWidth("You were killed!") / 2, 
/* 467 */         200);
/* 469 */     drawButton(g, Game.width / 2 - 
/* 470 */         ImageManager.button2_1.getWidth() / 2, 275, 
/* 471 */         ImageManager.button2_1.getWidth(), 
/* 472 */         ImageManager.button2_1.getHeight(), "Respawn", 
/* 473 */         ImageManager.button2_1, ImageManager.button2_2, 
/* 474 */         ImageManager.button2_3, 6.1D);
/* 476 */     drawButton(g, Game.width / 2 - 
/* 477 */         ImageManager.button2_1.getWidth() / 2, 323, 
/* 478 */         ImageManager.button2_1.getWidth(), 
/* 479 */         ImageManager.button2_1.getHeight(), "Save and Quit to Title", 
/* 480 */         ImageManager.button2_1, ImageManager.button2_2, 
/* 481 */         ImageManager.button2_3, 6.2D);
/*     */   }
/*     */   
/*     */   private void m1Play() {
/* 486 */     this.menuState = 2;
/* 487 */     Load.loadData(Game.dataPath);
/* 488 */     this.save1State = 0;
/* 489 */     this.save2State = 0;
/* 490 */     this.save3State = 0;
/* 491 */     profileCheck();
/* 492 */     Game.endClick();
/*     */   }
/*     */   
/*     */   public void m1Options() {
/* 496 */     this.menuState = 4;
/* 497 */     this.o = new Options();
/* 498 */     Game.endClick();
/*     */   }
/*     */   
/*     */   private void m1Quit() {
/* 502 */     System.exit(0);
/*     */   }
/*     */   
/*     */   public void m1Creds() {
/* 506 */     this.c = new Credits();
/* 507 */     this.c.createWindow();
/* 508 */     Game.endClick();
/*     */   }
/*     */   
/*     */   public void m2PlayProfile() throws IOException {
/* 512 */     if (this.currentProfile == 1) {
/* 513 */       if (Profile1.file.exists()) {
/* 514 */         Load.loadProfile(Game.save1Path, 1);
/* 515 */         enterGame();
/* 516 */       } else if (!Profile1.file.exists()) {
/* 517 */         Profile1.name = "";
/* 518 */         (Game.getPlayer()).typedName = "";
/* 519 */         this.cancelState = 0;
/* 520 */         this.save1State = 3;
/* 521 */         this.proc = new ProfileCreator();
/* 522 */         this.proc.createWindow(1);
/*     */       } 
/* 524 */     } else if (this.currentProfile == 2) {
/* 525 */       if (Profile2.file.exists()) {
/* 526 */         Load.loadProfile(Game.save2Path, 2);
/* 527 */         enterGame();
/* 528 */       } else if (!Profile2.file.exists()) {
/* 529 */         Profile2.name = "";
/* 530 */         (Game.getPlayer()).typedName = "";
/* 531 */         this.cancelState = 0;
/* 532 */         this.proc = new ProfileCreator();
/* 533 */         this.proc.createWindow(2);
/*     */       } 
/* 535 */     } else if (this.currentProfile == 3) {
/* 536 */       if (Profile3.file.exists()) {
/* 537 */         Load.loadProfile(Game.save3Path, 3);
/* 538 */         enterGame();
/* 539 */       } else if (!Profile3.file.exists()) {
/* 540 */         Profile3.name = "";
/* 541 */         (Game.getPlayer()).typedName = "";
/* 542 */         this.cancelState = 0;
/* 543 */         this.proc = new ProfileCreator();
/* 544 */         this.proc.createWindow(3);
/*     */       } 
/*     */     } 
/* 547 */     Game.endClick();
/* 548 */     TestDummy.reset();
/*     */   }
/*     */   
/*     */   private void m2DeleteProfile() throws IOException {
/* 552 */     if (this.currentProfile == 1) {
/* 553 */       Profile1.file.delete();
/* 554 */       Profile1.made = " ";
/* 555 */       Profile1.lastPlayed = " ";
/* 556 */       Save.dataSave();
/* 557 */     } else if (this.currentProfile == 2) {
/* 558 */       Profile2.file.delete();
/* 559 */       Profile2.made = " ";
/* 560 */       Profile2.lastPlayed = " ";
/* 561 */       Save.dataSave();
/* 562 */     } else if (this.currentProfile == 3) {
/* 563 */       Profile3.file.delete();
/* 564 */       Profile3.made = " ";
/* 565 */       Profile3.lastPlayed = " ";
/* 566 */       Save.dataSave();
/*     */     } 
/* 568 */     this.menuState = 2;
/* 569 */     this.currentProfile = 0;
/* 570 */     profileCheck();
/* 571 */     Game.endClick();
/*     */   }
/*     */   
/*     */   private void m2Back() {
/* 575 */     this.save1State = 0;
/* 576 */     this.save2State = 0;
/* 577 */     this.save3State = 0;
/* 578 */     this.currentProfile = 0;
/* 579 */     this.menuState = 1;
/* 580 */     Game.endClick();
/*     */   }
/*     */   
/*     */   private void m3Yes() {
/*     */     try {
/* 585 */       m2DeleteProfile();
/* 586 */     } catch (IOException e) {
/* 587 */       e.printStackTrace();
/*     */     } 
/* 589 */     Game.endClick();
/*     */   }
/*     */   
/*     */   private void m3No() {
/* 593 */     this.menuState = 2;
/* 594 */     Game.endClick();
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.9_3.jar!\beyondOrigins\main\menus\MainMenu.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */