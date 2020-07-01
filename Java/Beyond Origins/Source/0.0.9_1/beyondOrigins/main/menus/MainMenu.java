/*     */ package beyondOrigins.main.menus;
/*     */ 
/*     */ import beyondOrigins.files.Load;
/*     */ import beyondOrigins.files.Save;
/*     */ import beyondOrigins.main.Game;
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
/*  25 */   public byte menuState = 1;
/*     */   
/*     */   public byte state;
/*     */   
/*     */   public Cloud cloud1;
/*     */   
/*     */   public Cloud cloud2;
/*     */   
/*     */   public Cloud cloud3;
/*     */   
/*  31 */   public byte currentProfile = 0;
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
/*  36 */   public String save1Name = "IfYouSeeThisSomethingIsWrong";
/*     */   
/*  37 */   public String save2Name = "IfYouSeeThisSomethingIsWrong";
/*     */   
/*  38 */   public String save3Name = "IfYouSeeThisSomethingIsWrong";
/*     */   
/*     */   public String save1Name_backup;
/*     */   
/*     */   public String save2Name_backup;
/*     */   
/*     */   public String save3Name_backup;
/*     */   
/*     */   public boolean enterProfile = false;
/*     */   
/*     */   public byte yesState;
/*     */   
/*     */   public byte noState;
/*     */   
/*     */   public byte profileNameBoxState;
/*     */   
/*     */   public byte playerNameBoxState;
/*     */   
/*     */   public boolean profileNameBoxInFocus = false;
/*     */   
/*     */   public boolean playerNameBoxInFocus = false;
/*     */   
/*     */   private Options o;
/*     */   
/*     */   private ProfileCreator proc;
/*     */   
/*     */   private Credits c;
/*     */   
/*     */   public MainMenu() {
/*  55 */     this.cloud1 = new Cloud(-195.0D, 135.0D);
/*  56 */     this.cloud2 = new Cloud(1033.0D, (286 - 
/*  57 */         ImageManager.cloud1.getHeight() / 2));
/*  58 */     this.cloud3 = new Cloud(-155.0D, 378.0D);
/*     */   }
/*     */   
/*     */   private byte getButtonState(int x, int y, int width, int height, byte state) {
/*  65 */     if (MouseMotion.mouseX >= x && MouseMotion.mouseX < x + width && 
/*  66 */       MouseMotion.mouseY >= y && MouseMotion.mouseY < y + height) {
/*  67 */       state = 2;
/*  68 */       if (Game.mouseIsPressed()) {
/*  69 */         state = 3;
/*     */       } else {
/*  71 */         state = 2;
/*     */       } 
/*     */     } else {
/*  73 */       state = 1;
/*     */     } 
/*  74 */     return state;
/*     */   }
/*     */   
/*     */   private void drawButton(Graphics g, int x, int y, int width, int height, String buttonText, BufferedImage state1Image, BufferedImage state2Image, BufferedImage state3Image, double clickEventType) {
/*  81 */     this.fm = g.getFontMetrics(Game.buttonTextFont);
/*  82 */     g.setFont(Game.buttonTextFont);
/*  83 */     if (getButtonState(x, y, width, height, this.state) == 1) {
/*  84 */       g.drawImage(state1Image, x, y, width, height, null);
/*  85 */       g.setColor(Game.buttonIdleColor);
/*  86 */       g.drawString(
/*  87 */           buttonText, 
/*  88 */           x + state1Image.getWidth() / 2 - 
/*  89 */           this.fm.stringWidth(buttonText) / 2, y + 
/*  90 */           state1Image.getHeight() / 2 + 5);
/*  91 */     } else if (getButtonState(x, y, width, height, this.state) == 2) {
/*  92 */       g.drawImage(state2Image, x, y, width, height, null);
/*  93 */       g.setColor(Game.buttonSelectedColor);
/*  94 */       g.drawString(
/*  95 */           buttonText, 
/*  96 */           x + state1Image.getWidth() / 2 - 
/*  97 */           this.fm.stringWidth(buttonText) / 2, y + 
/*  98 */           state1Image.getHeight() / 2 + 5);
/*  99 */     } else if (getButtonState(x, y, width, height, this.state) == 3) {
/* 100 */       g.drawImage(state3Image, x, y, width, height, null);
/* 101 */       g.setColor(Game.buttonClickedColor);
/* 102 */       g.drawString(
/* 103 */           buttonText, 
/* 104 */           x + state1Image.getWidth() / 2 - 
/* 105 */           this.fm.stringWidth(buttonText) / 2, y + 
/* 106 */           state1Image.getHeight() / 2 + 5);
/* 107 */       clickEventHandler(clickEventType);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void clickEventHandler(double e) {
/* 113 */     if (e == 1.1D) {
/* 114 */       m1Play();
/* 115 */     } else if (e == 1.2D) {
/* 116 */       m1Options();
/* 117 */     } else if (e == 1.3D) {
/* 118 */       m1Creds();
/* 119 */     } else if (e == 1.4D) {
/* 120 */       m1Quit();
/*     */     } 
/* 123 */     if (e == 2.1D) {
/*     */       try {
/* 125 */         m2PlayProfile();
/* 126 */       } catch (IOException ei) {
/* 127 */         ei.printStackTrace();
/*     */       } 
/* 129 */     } else if (e == 2.2D) {
/* 130 */       this.menuState = 3;
/* 131 */     } else if (e == 2.3D) {
/* 132 */       m2Back();
/*     */     } 
/* 135 */     if (e == 3.1D) {
/* 136 */       m3Yes();
/* 137 */     } else if (e == 3.2D) {
/* 138 */       m3No();
/*     */     } 
/* 141 */     if (e == 5.1D) {
/*     */       try {
/* 143 */         if (this.currentProfile == 1) {
/* 144 */           m5CreateProfile(Save.save1, Game.save1Path);
/* 145 */         } else if (this.currentProfile == 2) {
/* 146 */           m5CreateProfile(Save.save2, Game.save2Path);
/* 147 */         } else if (this.currentProfile == 3) {
/* 148 */           m5CreateProfile(Save.save3, Game.save3Path);
/*     */         } 
/* 150 */       } catch (IOException ei) {
/* 151 */         ei.printStackTrace();
/*     */       } 
/* 153 */     } else if (e == 5.2D) {
/* 154 */       Game.endClick();
/* 155 */       this.menuState = 2;
/* 156 */       this.currentProfile = 0;
/*     */     } 
/* 159 */     if (e == 6.1D) {
/* 160 */       Game.getPlayer().respawn();
/* 161 */     } else if (e == 6.2D) {
/* 162 */       (Game.getPlayer()).health = (Game.getPlayer()).maxHealth;
/*     */       try {
/* 164 */         if (this.currentProfile == 1)
/* 165 */           Save.profileSave(Save.save1, Game.save1Path, 1); 
/* 166 */         if (this.currentProfile == 2)
/* 167 */           Save.profileSave(Save.save2, Game.save2Path, 2); 
/* 168 */         if (this.currentProfile == 3)
/* 169 */           Save.profileSave(Save.save3, Game.save3Path, 3); 
/* 170 */         Save.dataSave();
/* 171 */       } catch (IOException e1) {
/* 172 */         e1.printStackTrace();
/*     */       } 
/* 174 */       Game.endClick();
/* 175 */       this.menuState = 1;
/* 176 */       this.currentProfile = 0;
/*     */     } 
/*     */   }
/*     */   
/*     */   private void drawProfile(Graphics g, byte state, int x, int y, String lastPlayed, String created, File file, int profileNumber, String name, FontMetrics fm) {
/* 183 */     g.drawImage(ImageManager.profileSquare, x, y, 
/* 184 */         ImageManager.profileSquare.getWidth(), 
/* 185 */         ImageManager.profileSquare.getHeight(), null);
/* 186 */     g.setColor(Game.gameProgressColor);
/* 187 */     g.setFont(Game.gameProgressFont);
/* 188 */     if (file.exists()) {
/* 189 */       g.drawImage(ImageManager.player_down[1], 
/* 190 */           ImageManager.profileSquare.getWidth() / 2 + x - 
/* 191 */           ImageManager.player_down[1].getWidth(), 
/* 192 */           y + ImageManager.profileSquare.getHeight() / 2 - 
/* 193 */           ImageManager.player_down[1].getHeight(), 64, 
/* 194 */           64, null);
/* 195 */     } else if (!file.exists()) {
/* 196 */       g.drawString("?", ImageManager.profileSquare.getWidth() / 2 + x - 
/* 197 */           fm.stringWidth("?") / 2, profileNumber * 110);
/*     */     } 
/* 199 */     if (this.currentProfile == profileNumber && state == 3) {
/* 200 */       g.setColor(Color.white);
/*     */     } else {
/* 202 */       g.setColor(Game.profileInfoColor);
/*     */     } 
/* 204 */     g.setFont(Game.profileNameFont);
/* 205 */     g.drawString(name, 380, profileNumber * 110 - 40);
/* 206 */     g.setFont(Game.profileInfoFont);
/* 207 */     g.drawString("Last Played: " + lastPlayed, 380, 
/* 208 */         profileNumber * 110 - 40 + 33);
/* 209 */     g.drawString("Date Created: " + created, 380, 
/* 210 */         profileNumber * 110 - 40 + 66);
/*     */   }
/*     */   
/*     */   public void setCurrentProfile(int i) {
/* 215 */     if (i == 1) {
/* 216 */       this.save1State = 3;
/* 217 */       this.save2State = 0;
/* 218 */       this.save3State = 0;
/* 219 */     } else if (i == 2) {
/* 220 */       this.save1State = 0;
/* 221 */       this.save2State = 3;
/* 222 */       this.save3State = 0;
/* 223 */     } else if (i == 3) {
/* 224 */       this.save1State = 0;
/* 225 */       this.save2State = 0;
/* 226 */       this.save3State = 3;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void enterGame() {
/* 231 */     Game.logger.log("Entering game...");
/* 232 */     Game.isInGame = true;
/* 233 */     this.menuState = 0;
/* 234 */     Game.isLoading = true;
/* 235 */     KeyManager.enterPressed = false;
/* 236 */     (Game.getPlayer()).up = false;
/* 237 */     (Game.getPlayer()).down = false;
/* 238 */     (Game.getPlayer()).left = false;
/* 239 */     (Game.getPlayer()).right = false;
/* 240 */     Game.getPlayer().healthBarCheck();
/* 241 */     Game.getPlayer().fixPos();
/* 242 */     Game.endClick();
/*     */   }
/*     */   
/*     */   public void tick() {
/* 246 */     this.cloud1.tick(Game.width, 0.3D, 1);
/* 247 */     this.cloud2.tick(-155, 0.4D, 0);
/* 248 */     this.cloud3.tick(Game.width + 145, 0.2D, 1);
/*     */   }
/*     */   
/*     */   private void profileCheck() {
/* 253 */     if (!Save.save1.exists()) {
/* 254 */       this.save1Name = "Play To Create Me";
/* 255 */     } else if (Save.save1.exists()) {
/* 256 */       this.save1Name = this.save1Name_backup;
/*     */     } 
/* 259 */     if (!Save.save2.exists()) {
/* 260 */       this.save2Name = "Play To Create Me";
/* 261 */     } else if (Save.save2.exists()) {
/* 262 */       this.save2Name = this.save2Name_backup;
/*     */     } 
/* 265 */     if (!Save.save3.exists()) {
/* 266 */       this.save3Name = "Play To Create Me";
/* 267 */     } else if (Save.save3.exists()) {
/* 268 */       this.save3Name = this.save3Name_backup;
/*     */     } 
/* 271 */     if (this.save1State == 3 || this.save2State == 3 || this.save3State == 3) {
/* 272 */       this.canPlayProfile = true;
/* 273 */     } else if (this.save1State == 0 && this.save2State == 0 && this.save3State == 0) {
/* 274 */       this.canPlayProfile = false;
/*     */     } 
/* 277 */     if ((this.currentProfile == 1 && !Save.save1.exists()) || (
/* 278 */       this.currentProfile == 2 && !Save.save2.exists()) || (
/* 279 */       this.currentProfile == 3 && !Save.save3.exists()) || 
/* 280 */       this.currentProfile == 0) {
/* 281 */       this.canDeleteProfile = false;
/* 282 */     } else if ((this.currentProfile == 1 && Save.save1.exists()) || (
/* 283 */       this.currentProfile == 2 && Save.save2.exists()) || (
/* 284 */       this.currentProfile == 3 && Save.save3.exists())) {
/* 285 */       this.canDeleteProfile = true;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void render(Graphics g) {
/* 292 */     g.setColor(Game.skyColor);
/* 293 */     g.fillRect(0, 0, Game.width, Game.height);
/* 295 */     this.cloud1.render(g);
/* 296 */     this.cloud2.render(g);
/* 297 */     this.cloud3.render(g);
/* 299 */     if (this.menuState == 1) {
/* 300 */       renderState1(g);
/* 301 */     } else if (this.menuState == 2) {
/* 302 */       renderState2(g);
/* 303 */     } else if (this.menuState == 3) {
/* 304 */       renderState3(g);
/* 305 */     } else if (this.menuState == 4) {
/* 306 */       renderState4(g);
/* 307 */     } else if (this.menuState != 5) {
/* 309 */       if (this.menuState == 6)
/* 310 */         renderState6(g); 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void renderState1(Graphics g) {
/* 319 */     this.fm = g.getFontMetrics(Game.profileInfoFont);
/* 320 */     this.fm2 = g.getFontMetrics(Game.buttonTextFont);
/* 323 */     g.drawImage(Game.logoImage, 
/* 324 */         Game.width / 2 - Game.logoImage.getWidth(), Game.height / 2 - 
/* 325 */         Game.logoImage.getWidth() - 45, 
/* 326 */         Game.logoImage.getWidth() * 2, Game.logoImage.getHeight() * 2, 
/* 327 */         null);
/* 330 */     g.setFont(Game.buttonTextFont);
/* 331 */     g.setColor(Color.white);
/* 332 */     g.drawString(Game.title, 5, Game.height - 13);
/* 333 */     g.drawString(Game.copyright, 
/* 334 */         Game.width - this.fm2.stringWidth(Game.copyright) + 10, 
/* 335 */         Game.height - 13);
/* 338 */     drawButton(g, Game.width / 2 - 168, Game.height / 2, 336, 32, "Play", 
/* 339 */         ImageManager.button2_1, ImageManager.button2_2, 
/* 340 */         ImageManager.button2_3, 1.1D);
/* 343 */     drawButton(g, Game.width / 2 - 168, Game.height / 2 + 48, 
/* 344 */         ImageManager.button2_1.getWidth(), 
/* 345 */         ImageManager.button2_1.getHeight(), "Options", 
/* 346 */         ImageManager.button2_1, ImageManager.button2_2, 
/* 347 */         ImageManager.button2_3, 1.2D);
/* 350 */     drawButton(g, Game.width / 2 + 8, Game.height / 2 + 48 + 48, 
/* 351 */         ImageManager.button1_1.getWidth(), 
/* 352 */         ImageManager.button1_1.getHeight(), "Quit", 
/* 353 */         ImageManager.button1_1, ImageManager.button1_2, 
/* 354 */         ImageManager.button1_3, 1.4D);
/* 357 */     drawButton(g, Game.width / 2 - 168, Game.height / 2 + 48 + 48, 
/* 358 */         ImageManager.button1_1.getWidth(), 
/* 359 */         ImageManager.button1_1.getHeight(), "Credits", 
/* 360 */         ImageManager.button1_1, ImageManager.button1_2, 
/* 361 */         ImageManager.button1_3, 1.3D);
/*     */   }
/*     */   
/*     */   private void renderState2(Graphics g) {
/* 369 */     this.fm = g.getFontMetrics(Game.gameProgressFont);
/* 371 */     g.setFont(Game.profileInfoFont);
/* 372 */     g.setColor(Game.profileInfoColor);
/* 376 */     if (this.save1State == 3) {
/* 377 */       g.drawImage(ImageManager.profileSelection, Game.width / 2 - 150, 
/* 378 */           43, 300, 117, null);
/* 379 */       this.currentProfile = 1;
/* 380 */       profileCheck();
/* 381 */     } else if (this.save2State == 3) {
/* 382 */       g.drawImage(ImageManager.profileSelection, Game.width / 2 - 150, 
/* 383 */           153, 300, 117, null);
/* 384 */       this.currentProfile = 2;
/* 385 */       profileCheck();
/* 386 */     } else if (this.save3State == 3) {
/* 387 */       g.drawImage(ImageManager.profileSelection, Game.width / 2 - 150, 
/* 388 */           263, 300, 117, null);
/* 389 */       this.currentProfile = 3;
/* 390 */       profileCheck();
/*     */     } 
/* 395 */     drawProfile(g, this.save1State, Game.width / 2 - 144, 50, 
/* 396 */         Save.save1LastPlayed, Save.save1Made, Save.save1, 1, this.save1Name, 
/* 397 */         this.fm);
/* 399 */     drawProfile(g, this.save2State, Game.width / 2 - 144, 160, 
/* 400 */         Save.save2LastPlayed, Save.save2Made, Save.save2, 2, this.save2Name, 
/* 401 */         this.fm);
/* 403 */     drawProfile(g, this.save3State, Game.width / 2 - 144, 270, 
/* 404 */         Save.save3LastPlayed, Save.save3Made, Save.save3, 3, this.save3Name, 
/* 405 */         this.fm);
/* 407 */     this.fm2 = g.getFontMetrics(Game.buttonTextFont);
/* 411 */     if (this.canPlayProfile) {
/* 412 */       drawButton(g, Game.width / 2 - 
/* 413 */           ImageManager.button2_1.getWidth() / 2, 425, 
/* 414 */           ImageManager.button2_1.getWidth(), 
/* 415 */           ImageManager.button2_1.getHeight(), "Play Profile", 
/* 416 */           ImageManager.button2_1, ImageManager.button2_2, 
/* 417 */           ImageManager.button2_3, 2.1D);
/* 418 */     } else if (!this.canPlayProfile) {
/* 419 */       g.setFont(Game.buttonTextFont);
/* 420 */       g.drawImage(ImageManager.button2_3, Game.width / 2 - 
/* 421 */           ImageManager.button2_3.getWidth() / 2, 425, 
/* 422 */           ImageManager.button2_3.getWidth(), 
/* 423 */           ImageManager.button2_3.getHeight(), null);
/* 424 */       g.setColor(Game.buttonClickedColor);
/* 425 */       g.drawString("Play Profile", 
/* 426 */           Game.width / 2 - this.fm2.stringWidth("Play Profile") / 2, 
/* 427 */           446);
/*     */     } 
/* 432 */     if (this.canDeleteProfile) {
/* 433 */       drawButton(g, Game.width / 2 - 
/* 434 */           ImageManager.button2_1.getWidth() / 2, 473, 
/* 435 */           ImageManager.button1_1.getWidth(), 
/* 436 */           ImageManager.button1_1.getHeight(), "Delete", 
/* 437 */           ImageManager.button1_1, ImageManager.button1_2, 
/* 438 */           ImageManager.button1_3, 2.2D);
/* 439 */     } else if (!this.canDeleteProfile) {
/* 440 */       g.setFont(Game.buttonTextFont);
/* 441 */       g.drawImage(ImageManager.button1_3, Game.width / 2 - 
/* 442 */           ImageManager.button2_1.getWidth() / 2, 473, 
/* 443 */           ImageManager.button1_3.getWidth(), 
/* 444 */           ImageManager.button1_3.getHeight(), null);
/* 445 */       g.setColor(Game.buttonClickedColor);
/* 446 */       g.drawString(
/* 447 */           "Delete", 
/* 448 */           Game.width / 2 - ImageManager.button1_1.getWidth() / 2 - 8 - 
/* 449 */           this.fm2.stringWidth("Delete") / 2, 
/* 450 */           473 + ImageManager.button1_3.getHeight() / 2 + 5);
/*     */     } 
/* 455 */     drawButton(g, Game.width / 2 - 
/* 456 */         ImageManager.button2_1.getWidth() / 2 + 176, 473, 
/* 457 */         ImageManager.button1_1.getWidth(), 
/* 458 */         ImageManager.button1_1.getHeight(), "Back", 
/* 459 */         ImageManager.button1_1, ImageManager.button1_2, 
/* 460 */         ImageManager.button1_3, 2.3D);
/*     */   }
/*     */   
/*     */   private void renderState3(Graphics g) {
/* 468 */     g.setFont(Game.areYouSureFont);
/* 469 */     g.setColor(Game.profileInfoColor);
/* 470 */     g.drawString("Are you sure?", 280, 190);
/* 472 */     g.setFont(Game.buttonTextFont);
/* 474 */     drawButton(g, Game.width / 2 - 204, 325, 
/* 475 */         ImageManager.button1_1.getWidth(), 
/* 476 */         ImageManager.button1_1.getHeight(), "Yes", 
/* 477 */         ImageManager.button1_1, ImageManager.button1_2, 
/* 478 */         ImageManager.button1_3, 3.1D);
/* 480 */     drawButton(g, Game.width / 2 + 35, 325, 
/* 481 */         ImageManager.button1_1.getWidth(), 
/* 482 */         ImageManager.button1_1.getHeight(), "No", 
/* 483 */         ImageManager.button1_1, ImageManager.button1_2, 
/* 484 */         ImageManager.button1_3, 3.2D);
/*     */   }
/*     */   
/*     */   private void renderState4(Graphics g) {
/* 491 */     this.o.render(g);
/*     */   }
/*     */   
/*     */   private void renderState6(Graphics g) {
/* 498 */     g.setFont(Game.buttonTextFont);
/* 499 */     g.setColor(Game.profileInfoColor);
/* 501 */     this.fm = g.getFontMetrics(Game.buttonTextFont);
/* 503 */     g.drawString("You were killed!", 
/* 504 */         Game.width / 2 - this.fm.stringWidth("You were killed!") / 2, 
/* 505 */         200);
/* 507 */     drawButton(g, Game.width / 2 - 
/* 508 */         ImageManager.button2_1.getWidth() / 2, 275, 
/* 509 */         ImageManager.button2_1.getWidth(), 
/* 510 */         ImageManager.button2_1.getHeight(), "Respawn", 
/* 511 */         ImageManager.button2_1, ImageManager.button2_2, 
/* 512 */         ImageManager.button2_3, 6.1D);
/* 514 */     drawButton(g, Game.width / 2 - 
/* 515 */         ImageManager.button2_1.getWidth() / 2, 323, 
/* 516 */         ImageManager.button2_1.getWidth(), 
/* 517 */         ImageManager.button2_1.getHeight(), "Save and Quit to Title", 
/* 518 */         ImageManager.button2_1, ImageManager.button2_2, 
/* 519 */         ImageManager.button2_3, 6.2D);
/*     */   }
/*     */   
/*     */   private void m1Play() {
/* 524 */     this.menuState = 2;
/* 525 */     Load.loadData(Game.dataPath);
/* 526 */     profileCheck();
/* 527 */     Game.endClick();
/*     */   }
/*     */   
/*     */   public void m1Options() {
/* 531 */     this.menuState = 4;
/* 532 */     this.o = new Options();
/* 533 */     Game.endClick();
/*     */   }
/*     */   
/*     */   private void m1Quit() {
/* 537 */     System.exit(0);
/*     */   }
/*     */   
/*     */   private void m1Creds() {
/* 541 */     this.c = new Credits();
/* 542 */     this.c.createWindow();
/* 543 */     Game.endClick();
/*     */   }
/*     */   
/*     */   public void m2PlayProfile() throws IOException {
/* 547 */     if (this.currentProfile == 1) {
/* 548 */       if (Save.save1.exists()) {
/* 549 */         Load.loadProfile(Game.save1Path, 1);
/* 550 */         enterGame();
/* 551 */       } else if (!Save.save1.exists()) {
/* 552 */         this.save1Name = "";
/* 553 */         (Game.getPlayer()).typedName = "";
/* 554 */         this.cancelState = 0;
/* 555 */         this.save1State = 3;
/* 556 */         this.proc = new ProfileCreator();
/* 557 */         this.proc.createWindow(1);
/*     */       } 
/* 559 */     } else if (this.currentProfile == 2) {
/* 560 */       if (Save.save2.exists()) {
/* 561 */         Load.loadProfile(Game.save2Path, 2);
/* 562 */         enterGame();
/* 563 */       } else if (!Save.save2.exists()) {
/* 564 */         this.save2Name = "";
/* 565 */         (Game.getPlayer()).typedName = "";
/* 566 */         this.cancelState = 0;
/* 567 */         this.proc = new ProfileCreator();
/* 568 */         this.proc.createWindow(2);
/*     */       } 
/* 570 */     } else if (this.currentProfile == 3) {
/* 571 */       if (Save.save3.exists()) {
/* 572 */         Load.loadProfile(Game.save3Path, 3);
/* 573 */         enterGame();
/* 574 */       } else if (!Save.save3.exists()) {
/* 575 */         this.save3Name = "";
/* 576 */         (Game.getPlayer()).typedName = "";
/* 577 */         this.cancelState = 0;
/* 578 */         this.proc = new ProfileCreator();
/* 579 */         this.proc.createWindow(3);
/*     */       } 
/*     */     } 
/* 582 */     Game.endClick();
/* 583 */     TestDummy.reset();
/* 584 */     this.save1State = 0;
/* 585 */     this.save2State = 0;
/* 586 */     this.save3State = 0;
/*     */   }
/*     */   
/*     */   private void m2DeleteProfile() throws IOException {
/* 590 */     if (this.currentProfile == 1) {
/* 591 */       Save.save1.delete();
/* 592 */       Save.save1Made = "";
/* 593 */       Save.save1LastPlayed = "";
/* 594 */       Save.dataSave();
/* 595 */     } else if (this.currentProfile == 2) {
/* 596 */       Save.save2.delete();
/* 597 */       Save.save2Made = "";
/* 598 */       Save.save2LastPlayed = "";
/* 599 */       Save.dataSave();
/* 600 */     } else if (this.currentProfile == 3) {
/* 601 */       Save.save3.delete();
/* 602 */       Save.save3Made = " ";
/* 603 */       Save.save3LastPlayed = " ";
/* 604 */       Save.dataSave();
/*     */     } 
/* 606 */     this.menuState = 2;
/* 607 */     this.currentProfile = 0;
/* 608 */     profileCheck();
/* 609 */     Game.endClick();
/*     */   }
/*     */   
/*     */   private void m2Back() {
/* 613 */     this.save1State = 0;
/* 614 */     this.save2State = 0;
/* 615 */     this.save3State = 0;
/* 616 */     this.currentProfile = 0;
/* 617 */     this.menuState = 1;
/* 618 */     Game.endClick();
/*     */   }
/*     */   
/*     */   private void m3Yes() {
/*     */     try {
/* 623 */       m2DeleteProfile();
/* 624 */     } catch (IOException e) {
/* 625 */       e.printStackTrace();
/*     */     } 
/* 627 */     Game.endClick();
/*     */   }
/*     */   
/*     */   private void m3No() {
/* 631 */     this.menuState = 2;
/* 632 */     Game.endClick();
/*     */   }
/*     */   
/*     */   public void m5CreateProfile(File save, String path) throws IOException {
/* 636 */     Save.profileReset();
/* 637 */     if (this.currentProfile == 1 && this.save1Name.length() == 0) {
/* 638 */       this.save1Name = "Profile 1";
/* 639 */       this.save1Name_backup = this.save1Name;
/* 640 */     } else if (this.currentProfile == 2 && this.save2Name.length() == 0) {
/* 641 */       this.save2Name = "Profile 2";
/* 642 */       this.save2Name_backup = this.save2Name;
/* 643 */     } else if (this.currentProfile == 3 && this.save3Name.length() == 0) {
/* 644 */       this.save3Name = "Profile 3";
/* 645 */       this.save3Name_backup = this.save3Name;
/*     */     } 
/* 647 */     if ((Game.getPlayer()).typedName.length() == 0) {
/* 648 */       (Game.getPlayer()).name = (Game.getPlayer()).defaultName;
/* 649 */     } else if ((Game.getPlayer()).typedName.length() >= 1) {
/* 650 */       (Game.getPlayer()).name = (Game.getPlayer()).typedName;
/*     */     } 
/* 652 */     Save.profileSave(save, path, this.currentProfile);
/* 653 */     Load.loadProfile(path, this.currentProfile);
/* 654 */     enterGame();
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.9_1.jar!\beyondOrigins\main\menus\MainMenu.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */