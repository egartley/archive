/*     */ package beyondOrigins.main.menus;
/*     */ 
/*     */ import beyondOrigins.files.Load;
/*     */ import beyondOrigins.files.Save;
/*     */ import beyondOrigins.main.Game;
/*     */ import beyondOrigins.main.entities.Cloud;
/*     */ import beyondOrigins.main.entities.TestDummy;
/*     */ import beyondOrigins.main.gfx.ImageManager;
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
/*     */   public MainMenu() {
/*  54 */     this.cloud1 = new Cloud(-195.0D, 135.0D);
/*  55 */     this.cloud2 = new Cloud(1033.0D, (286 - 
/*  56 */         ImageManager.cloud1.getHeight() / 2));
/*  57 */     this.cloud3 = new Cloud(-155.0D, 378.0D);
/*     */   }
/*     */   
/*     */   private byte getButtonState(int x, int y, int width, int height, byte state) {
/*  64 */     if (MouseMotion.mouseX >= x && MouseMotion.mouseX < x + width && 
/*  65 */       MouseMotion.mouseY >= y && MouseMotion.mouseY < y + height) {
/*  66 */       state = 2;
/*  67 */       if (Game.mouseIsPressed()) {
/*  68 */         state = 3;
/*     */       } else {
/*  70 */         state = 2;
/*     */       } 
/*     */     } else {
/*  72 */       state = 1;
/*     */     } 
/*  73 */     return state;
/*     */   }
/*     */   
/*     */   private void drawButton(Graphics g, int x, int y, int width, int height, String buttonText, BufferedImage state1Image, BufferedImage state2Image, BufferedImage state3Image, double clickEventType) {
/*  80 */     this.fm = g.getFontMetrics(Game.buttonTextFont);
/*  81 */     g.setFont(Game.buttonTextFont);
/*  82 */     if (getButtonState(x, y, width, height, this.state) == 1) {
/*  83 */       g.drawImage(state1Image, x, y, width, height, null);
/*  84 */       g.setColor(Game.buttonIdleColor);
/*  85 */       g.drawString(
/*  86 */           buttonText, 
/*  87 */           x + state1Image.getWidth() / 2 - 
/*  88 */           this.fm.stringWidth(buttonText) / 2, y + 
/*  89 */           state1Image.getHeight() / 2 + 5);
/*  90 */     } else if (getButtonState(x, y, width, height, this.state) == 2) {
/*  91 */       g.drawImage(state2Image, x, y, width, height, null);
/*  92 */       g.setColor(Game.buttonSelectedColor);
/*  93 */       g.drawString(
/*  94 */           buttonText, 
/*  95 */           x + state1Image.getWidth() / 2 - 
/*  96 */           this.fm.stringWidth(buttonText) / 2, y + 
/*  97 */           state1Image.getHeight() / 2 + 5);
/*  98 */     } else if (getButtonState(x, y, width, height, this.state) == 3) {
/*  99 */       g.drawImage(state3Image, x, y, width, height, null);
/* 100 */       g.setColor(Game.buttonClickedColor);
/* 101 */       g.drawString(
/* 102 */           buttonText, 
/* 103 */           x + state1Image.getWidth() / 2 - 
/* 104 */           this.fm.stringWidth(buttonText) / 2, y + 
/* 105 */           state1Image.getHeight() / 2 + 5);
/* 106 */       clickEventHandler(clickEventType);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void clickEventHandler(double e) {
/* 112 */     if (e == 1.1D) {
/* 113 */       m1Play();
/* 114 */     } else if (e == 1.2D) {
/* 115 */       m1Options();
/* 116 */     } else if (e != 1.3D) {
/* 118 */       if (e == 1.4D)
/* 119 */         m1Quit(); 
/*     */     } 
/* 122 */     if (e == 2.1D) {
/*     */       try {
/* 124 */         m2PlayProfile();
/* 125 */       } catch (IOException ei) {
/* 126 */         ei.printStackTrace();
/*     */       } 
/* 128 */     } else if (e == 2.2D) {
/* 129 */       this.menuState = 3;
/* 130 */     } else if (e == 2.3D) {
/* 131 */       m2Back();
/*     */     } 
/* 134 */     if (e == 3.1D) {
/* 135 */       m3Yes();
/* 136 */     } else if (e == 3.2D) {
/* 137 */       m3No();
/*     */     } 
/* 140 */     if (e == 5.1D) {
/*     */       try {
/* 142 */         if (this.currentProfile == 1) {
/* 143 */           m5CreateProfile(Save.save1, Game.save1Path);
/* 144 */         } else if (this.currentProfile == 2) {
/* 145 */           m5CreateProfile(Save.save2, Game.save2Path);
/* 146 */         } else if (this.currentProfile == 3) {
/* 147 */           m5CreateProfile(Save.save3, Game.save3Path);
/*     */         } 
/* 149 */       } catch (IOException ei) {
/* 150 */         ei.printStackTrace();
/*     */       } 
/* 152 */     } else if (e == 5.2D) {
/* 153 */       Game.endClick();
/* 154 */       this.menuState = 2;
/* 155 */       this.currentProfile = 0;
/*     */     } 
/* 158 */     if (e == 6.1D) {
/* 159 */       Game.getPlayer().respawn();
/* 160 */     } else if (e == 6.2D) {
/* 161 */       (Game.getPlayer()).health = (Game.getPlayer()).maxHealth;
/*     */       try {
/* 163 */         if (this.currentProfile == 1)
/* 164 */           Save.profileSave(Save.save1, Game.save1Path, 1); 
/* 165 */         if (this.currentProfile == 2)
/* 166 */           Save.profileSave(Save.save2, Game.save2Path, 2); 
/* 167 */         if (this.currentProfile == 3)
/* 168 */           Save.profileSave(Save.save3, Game.save3Path, 3); 
/* 169 */         Save.dataSave();
/* 170 */       } catch (IOException e1) {
/* 171 */         e1.printStackTrace();
/*     */       } 
/* 173 */       Game.endClick();
/* 174 */       this.menuState = 1;
/* 175 */       this.currentProfile = 0;
/*     */     } 
/*     */   }
/*     */   
/*     */   private void drawProfile(Graphics g, byte state, int x, int y, String lastPlayed, String created, File file, int profileNumber, String name, FontMetrics fm) {
/* 182 */     g.drawImage(ImageManager.profileSquare, x, y, 
/* 183 */         ImageManager.profileSquare.getWidth(), 
/* 184 */         ImageManager.profileSquare.getHeight(), null);
/* 185 */     g.setColor(Game.gameProgressColor);
/* 186 */     g.setFont(Game.gameProgressFont);
/* 187 */     if (file.exists()) {
/* 188 */       g.drawImage(ImageManager.playerd1, 
/* 189 */           ImageManager.profileSquare.getWidth() / 2 + x - 
/* 190 */           ImageManager.playerd1.getWidth(), 
/* 191 */           y + ImageManager.profileSquare.getHeight() / 2 - 
/* 192 */           ImageManager.playerd1.getHeight(), 64, 64, null);
/* 193 */     } else if (!file.exists()) {
/* 194 */       g.drawString("?", ImageManager.profileSquare.getWidth() / 2 + x - 
/* 195 */           fm.stringWidth("?") / 2, profileNumber * 110);
/*     */     } 
/* 197 */     if (this.currentProfile == profileNumber) {
/* 198 */       g.setColor(Color.white);
/*     */     } else {
/* 200 */       g.setColor(Game.profileInfoColor);
/*     */     } 
/* 202 */     g.setFont(Game.profileNameFont);
/* 203 */     g.drawString(name, 380, profileNumber * 110 - 40);
/* 204 */     g.setFont(Game.profileInfoFont);
/* 205 */     g.drawString("Last Played: " + lastPlayed, 380, 
/* 206 */         profileNumber * 110 - 40 + 33);
/* 207 */     g.drawString("Date Created: " + created, 380, 
/* 208 */         profileNumber * 110 - 40 + 66);
/*     */   }
/*     */   
/*     */   public void setCurrentProfile(int i) {
/* 213 */     if (i == 1) {
/* 214 */       this.save1State = 3;
/* 215 */       this.save2State = 0;
/* 216 */       this.save3State = 0;
/* 217 */     } else if (i == 2) {
/* 218 */       this.save1State = 0;
/* 219 */       this.save2State = 3;
/* 220 */       this.save3State = 0;
/* 221 */     } else if (i == 3) {
/* 222 */       this.save1State = 0;
/* 223 */       this.save2State = 0;
/* 224 */       this.save3State = 3;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void enterGame() {
/* 229 */     Game.isInGame = true;
/* 230 */     this.menuState = 0;
/* 231 */     Game.isLoading = true;
/* 232 */     KeyManager.enterPressed = false;
/* 233 */     (Game.getPlayer()).up = false;
/* 234 */     (Game.getPlayer()).down = false;
/* 235 */     (Game.getPlayer()).left = false;
/* 236 */     (Game.getPlayer()).right = false;
/* 237 */     Game.getPlayer().healthBarCheck();
/* 238 */     Game.endClick();
/*     */   }
/*     */   
/*     */   public void tick() {
/* 242 */     this.cloud1.tick(Game.width, 0.3D, 1);
/* 243 */     this.cloud2.tick(-155, 0.4D, 0);
/* 244 */     this.cloud3.tick(Game.width + 145, 0.2D, 1);
/*     */   }
/*     */   
/*     */   private void profileCheck() {
/* 249 */     if (!Save.save1.exists()) {
/* 250 */       this.save1Name = "Play To Create Me";
/* 251 */     } else if (Save.save1.exists()) {
/* 252 */       this.save1Name = this.save1Name_backup;
/*     */     } 
/* 255 */     if (!Save.save2.exists()) {
/* 256 */       this.save2Name = "Play To Create Me";
/* 257 */     } else if (Save.save2.exists()) {
/* 258 */       this.save2Name = this.save2Name_backup;
/*     */     } 
/* 261 */     if (!Save.save3.exists()) {
/* 262 */       this.save3Name = "Play To Create Me";
/* 263 */     } else if (Save.save3.exists()) {
/* 264 */       this.save3Name = this.save3Name_backup;
/*     */     } 
/* 267 */     if (this.save1State == 3 || this.save2State == 3 || this.save3State == 3) {
/* 268 */       this.canPlayProfile = true;
/* 269 */     } else if (this.save1State == 0 && this.save2State == 0 && this.save3State == 0) {
/* 270 */       this.canPlayProfile = false;
/*     */     } 
/* 273 */     if ((this.currentProfile == 1 && !Save.save1.exists()) || (
/* 274 */       this.currentProfile == 2 && !Save.save2.exists()) || (
/* 275 */       this.currentProfile == 3 && !Save.save3.exists()) || 
/* 276 */       this.currentProfile == 0) {
/* 277 */       this.canDeleteProfile = false;
/* 278 */     } else if ((this.currentProfile == 1 && Save.save1.exists()) || (
/* 279 */       this.currentProfile == 2 && Save.save2.exists()) || (
/* 280 */       this.currentProfile == 3 && Save.save3.exists())) {
/* 281 */       this.canDeleteProfile = true;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void render(Graphics g) {
/* 288 */     g.setColor(Game.skyColor);
/* 289 */     g.fillRect(0, 0, Game.width, Game.height);
/* 291 */     this.cloud1.render(g);
/* 292 */     this.cloud2.render(g);
/* 293 */     this.cloud3.render(g);
/* 295 */     if (this.menuState == 1) {
/* 296 */       renderState1(g);
/* 297 */     } else if (this.menuState == 2) {
/* 298 */       renderState2(g);
/* 299 */     } else if (this.menuState == 3) {
/* 300 */       renderState3(g);
/* 301 */     } else if (this.menuState == 4) {
/* 302 */       renderState4(g);
/* 303 */     } else if (this.menuState != 5) {
/* 305 */       if (this.menuState == 6)
/* 306 */         renderState6(g); 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void renderState1(Graphics g) {
/* 315 */     this.fm = g.getFontMetrics(Game.profileInfoFont);
/* 316 */     this.fm2 = g.getFontMetrics(Game.buttonTextFont);
/* 319 */     g.drawImage(Game.logoImage, 
/* 320 */         Game.width / 2 - Game.logoImage.getWidth(), Game.height / 2 - 
/* 321 */         Game.logoImage.getWidth() - 45, 
/* 322 */         Game.logoImage.getWidth() * 2, Game.logoImage.getHeight() * 2, 
/* 323 */         null);
/* 326 */     g.setFont(Game.buttonTextFont);
/* 327 */     g.setColor(Color.white);
/* 328 */     g.drawString(Game.title, 5, Game.height - 13);
/* 329 */     g.drawString(Game.copyright, 
/* 330 */         Game.width - this.fm2.stringWidth(Game.copyright) + 10, 
/* 331 */         Game.height - 13);
/* 334 */     drawButton(g, Game.width / 2 - 168, Game.height / 2, 336, 32, "Play", 
/* 335 */         ImageManager.button2_1, ImageManager.button2_2, 
/* 336 */         ImageManager.button2_3, 1.1D);
/* 339 */     drawButton(g, Game.width / 2 - 168, Game.height / 2 + 48, 
/* 340 */         ImageManager.button2_1.getWidth(), 
/* 341 */         ImageManager.button2_1.getHeight(), "Options", 
/* 342 */         ImageManager.button2_1, ImageManager.button2_2, 
/* 343 */         ImageManager.button2_3, 1.2D);
/* 346 */     drawButton(g, Game.width / 2 - 168, Game.height / 2 + 48 + 48, 
/* 347 */         ImageManager.button2_1.getWidth(), 
/* 348 */         ImageManager.button2_1.getHeight(), "Quit Game", 
/* 349 */         ImageManager.button2_1, ImageManager.button2_2, 
/* 350 */         ImageManager.button2_3, 1.4D);
/*     */   }
/*     */   
/*     */   private void renderState2(Graphics g) {
/* 358 */     this.fm = g.getFontMetrics(Game.gameProgressFont);
/* 360 */     g.setFont(Game.profileInfoFont);
/* 361 */     g.setColor(Game.profileInfoColor);
/* 365 */     if (this.save1State == 3) {
/* 366 */       g.drawImage(ImageManager.profileSelection, Game.width / 2 - 150, 
/* 367 */           43, 300, 117, null);
/* 368 */       this.currentProfile = 1;
/* 369 */       profileCheck();
/* 370 */     } else if (this.save2State == 3) {
/* 371 */       g.drawImage(ImageManager.profileSelection, Game.width / 2 - 150, 
/* 372 */           153, 300, 117, null);
/* 373 */       this.currentProfile = 2;
/* 374 */       profileCheck();
/* 375 */     } else if (this.save3State == 3) {
/* 376 */       g.drawImage(ImageManager.profileSelection, Game.width / 2 - 150, 
/* 377 */           263, 300, 117, null);
/* 378 */       this.currentProfile = 3;
/* 379 */       profileCheck();
/*     */     } 
/* 384 */     drawProfile(g, this.save1State, Game.width / 2 - 144, 50, 
/* 385 */         Save.save1LastPlayed, Save.save1Made, Save.save1, 1, this.save1Name, 
/* 386 */         this.fm);
/* 388 */     drawProfile(g, this.save2State, Game.width / 2 - 144, 160, 
/* 389 */         Save.save2LastPlayed, Save.save2Made, Save.save2, 2, this.save2Name, 
/* 390 */         this.fm);
/* 392 */     drawProfile(g, this.save3State, Game.width / 2 - 144, 270, 
/* 393 */         Save.save3LastPlayed, Save.save3Made, Save.save3, 3, this.save3Name, 
/* 394 */         this.fm);
/* 396 */     this.fm2 = g.getFontMetrics(Game.buttonTextFont);
/* 400 */     if (this.canPlayProfile) {
/* 401 */       drawButton(g, Game.width / 2 - 
/* 402 */           ImageManager.button2_1.getWidth() / 2, 425, 
/* 403 */           ImageManager.button2_1.getWidth(), 
/* 404 */           ImageManager.button2_1.getHeight(), "Play Profile", 
/* 405 */           ImageManager.button2_1, ImageManager.button2_2, 
/* 406 */           ImageManager.button2_3, 2.1D);
/* 407 */     } else if (!this.canPlayProfile) {
/* 408 */       g.setFont(Game.buttonTextFont);
/* 409 */       g.drawImage(ImageManager.button2_3, Game.width / 2 - 
/* 410 */           ImageManager.button2_3.getWidth() / 2, 425, 
/* 411 */           ImageManager.button2_3.getWidth(), 
/* 412 */           ImageManager.button2_3.getHeight(), null);
/* 413 */       g.setColor(Game.buttonClickedColor);
/* 414 */       g.drawString("Play Profile", 
/* 415 */           Game.width / 2 - this.fm2.stringWidth("Play Profile") / 2, 
/* 416 */           446);
/*     */     } 
/* 421 */     if (this.canDeleteProfile) {
/* 422 */       drawButton(g, Game.width / 2 - 
/* 423 */           ImageManager.button2_1.getWidth() / 2, 473, 
/* 424 */           ImageManager.button1_1.getWidth(), 
/* 425 */           ImageManager.button1_1.getHeight(), "Delete", 
/* 426 */           ImageManager.button1_1, ImageManager.button1_2, 
/* 427 */           ImageManager.button1_3, 2.2D);
/* 428 */     } else if (!this.canDeleteProfile) {
/* 429 */       g.setFont(Game.buttonTextFont);
/* 430 */       g.drawImage(ImageManager.button1_3, Game.width / 2 - 
/* 431 */           ImageManager.button2_1.getWidth() / 2, 473, 
/* 432 */           ImageManager.button1_3.getWidth(), 
/* 433 */           ImageManager.button1_3.getHeight(), null);
/* 434 */       g.setColor(Game.buttonClickedColor);
/* 435 */       g.drawString(
/* 436 */           "Delete", 
/* 437 */           Game.width / 2 - ImageManager.button1_1.getWidth() / 2 - 8 - 
/* 438 */           this.fm2.stringWidth("Delete") / 2, 
/* 439 */           473 + ImageManager.button1_3.getHeight() / 2 + 5);
/*     */     } 
/* 444 */     drawButton(g, Game.width / 2 - 
/* 445 */         ImageManager.button2_1.getWidth() / 2 + 176, 473, 
/* 446 */         ImageManager.button1_1.getWidth(), 
/* 447 */         ImageManager.button1_1.getHeight(), "Back", 
/* 448 */         ImageManager.button1_1, ImageManager.button1_2, 
/* 449 */         ImageManager.button1_3, 2.3D);
/*     */   }
/*     */   
/*     */   private void renderState3(Graphics g) {
/* 457 */     g.setFont(Game.areYouSureFont);
/* 458 */     g.setColor(Game.profileInfoColor);
/* 459 */     g.drawString("Are you sure?", 280, 190);
/* 461 */     g.setFont(Game.buttonTextFont);
/* 463 */     drawButton(g, Game.width / 2 - 204, 325, 
/* 464 */         ImageManager.button1_1.getWidth(), 
/* 465 */         ImageManager.button1_1.getHeight(), "Yes", 
/* 466 */         ImageManager.button1_1, ImageManager.button1_2, 
/* 467 */         ImageManager.button1_3, 3.1D);
/* 469 */     drawButton(g, Game.width / 2 + 35, 325, 
/* 470 */         ImageManager.button1_1.getWidth(), 
/* 471 */         ImageManager.button1_1.getHeight(), "No", 
/* 472 */         ImageManager.button1_1, ImageManager.button1_2, 
/* 473 */         ImageManager.button1_3, 3.2D);
/*     */   }
/*     */   
/*     */   private void renderState4(Graphics g) {
/* 480 */     this.o.render(g);
/*     */   }
/*     */   
/*     */   private void renderState6(Graphics g) {
/* 487 */     g.setFont(Game.buttonTextFont);
/* 488 */     g.setColor(Game.profileInfoColor);
/* 490 */     this.fm = g.getFontMetrics(Game.buttonTextFont);
/* 492 */     g.drawString("You were killed!", 
/* 493 */         Game.width / 2 - this.fm.stringWidth("You were killed!") / 2, 
/* 494 */         200);
/* 496 */     drawButton(g, Game.width / 2 - 
/* 497 */         ImageManager.button2_1.getWidth() / 2, 275, 
/* 498 */         ImageManager.button2_1.getWidth(), 
/* 499 */         ImageManager.button2_1.getHeight(), "Respawn", 
/* 500 */         ImageManager.button2_1, ImageManager.button2_2, 
/* 501 */         ImageManager.button2_3, 6.1D);
/* 503 */     drawButton(g, Game.width / 2 - 
/* 504 */         ImageManager.button2_1.getWidth() / 2, 323, 
/* 505 */         ImageManager.button2_1.getWidth(), 
/* 506 */         ImageManager.button2_1.getHeight(), "Save and Quit to Title", 
/* 507 */         ImageManager.button2_1, ImageManager.button2_2, 
/* 508 */         ImageManager.button2_3, 6.2D);
/*     */   }
/*     */   
/*     */   private void m1Play() {
/* 513 */     this.menuState = 2;
/* 514 */     Load.loadData(Game.dataPath);
/* 515 */     profileCheck();
/* 516 */     Game.endClick();
/*     */   }
/*     */   
/*     */   public void m1Options() {
/* 520 */     this.menuState = 4;
/* 521 */     this.o = new Options();
/* 522 */     Game.endClick();
/*     */   }
/*     */   
/*     */   private void m1Quit() {
/* 526 */     System.exit(0);
/*     */   }
/*     */   
/*     */   public void m2PlayProfile() throws IOException {
/* 530 */     if (this.currentProfile == 1) {
/* 531 */       if (Save.save1.exists()) {
/* 532 */         Load.loadProfile(Game.save1Path);
/* 533 */         Save.profileSave(Save.save1, Game.save1Path, 1);
/* 534 */         enterGame();
/* 535 */       } else if (!Save.save1.exists()) {
/* 536 */         this.save1Name = "";
/* 537 */         (Game.getPlayer()).typedName = "";
/* 538 */         this.cancelState = 0;
/* 539 */         this.proc = new ProfileCreator();
/* 540 */         this.proc.createWindow(1);
/*     */       } 
/* 542 */     } else if (this.currentProfile == 2) {
/* 543 */       if (Save.save2.exists()) {
/* 544 */         Load.loadProfile(Game.save2Path);
/* 545 */         Save.profileSave(Save.save2, Game.save2Path, 2);
/* 546 */         enterGame();
/* 547 */       } else if (!Save.save2.exists()) {
/* 548 */         this.save2Name = "";
/* 549 */         (Game.getPlayer()).typedName = "";
/* 550 */         this.cancelState = 0;
/* 551 */         this.proc = new ProfileCreator();
/* 552 */         this.proc.createWindow(2);
/*     */       } 
/* 554 */     } else if (this.currentProfile == 3) {
/* 555 */       if (Save.save3.exists()) {
/* 556 */         Load.loadProfile(Game.save3Path);
/* 557 */         Save.profileSave(Save.save3, Game.save3Path, 3);
/* 558 */         enterGame();
/* 559 */       } else if (!Save.save3.exists()) {
/* 560 */         this.save3Name = "";
/* 561 */         (Game.getPlayer()).typedName = "";
/* 562 */         this.cancelState = 0;
/* 563 */         this.proc = new ProfileCreator();
/* 564 */         this.proc.createWindow(3);
/*     */       } 
/*     */     } 
/* 567 */     Game.endClick();
/* 568 */     TestDummy.reset();
/* 569 */     this.save1State = 0;
/* 570 */     this.save2State = 0;
/* 571 */     this.save3State = 0;
/*     */   }
/*     */   
/*     */   private void m2DeleteProfile() throws IOException {
/* 575 */     if (this.currentProfile == 1) {
/* 576 */       Save.save1.delete();
/* 577 */       Save.save1Made = "";
/* 578 */       Save.save1LastPlayed = "";
/* 579 */       Save.dataSave();
/* 580 */     } else if (this.currentProfile == 2) {
/* 581 */       Save.save2.delete();
/* 582 */       Save.save2Made = "";
/* 583 */       Save.save2LastPlayed = "";
/* 584 */       Save.dataSave();
/* 585 */     } else if (this.currentProfile == 3) {
/* 586 */       Save.save3.delete();
/* 587 */       Save.save3Made = " ";
/* 588 */       Save.save3LastPlayed = " ";
/* 589 */       Save.dataSave();
/*     */     } 
/* 591 */     this.menuState = 2;
/* 592 */     this.currentProfile = 0;
/* 593 */     profileCheck();
/* 594 */     Game.endClick();
/*     */   }
/*     */   
/*     */   private void m2Back() {
/* 598 */     this.save1State = 0;
/* 599 */     this.save2State = 0;
/* 600 */     this.save3State = 0;
/* 601 */     this.currentProfile = 0;
/* 602 */     this.menuState = 1;
/* 603 */     Game.endClick();
/*     */   }
/*     */   
/*     */   private void m3Yes() {
/*     */     try {
/* 608 */       m2DeleteProfile();
/* 609 */     } catch (IOException e) {
/* 610 */       e.printStackTrace();
/*     */     } 
/* 612 */     Game.endClick();
/*     */   }
/*     */   
/*     */   private void m3No() {
/* 616 */     this.menuState = 2;
/* 617 */     Game.endClick();
/*     */   }
/*     */   
/*     */   public void m5CreateProfile(File save, String path) throws IOException {
/* 621 */     Save.profileReset();
/* 622 */     if (this.currentProfile == 1 && this.save1Name.length() == 0) {
/* 623 */       this.save1Name = "Profile 1";
/* 624 */       this.save1Name_backup = this.save1Name;
/* 625 */     } else if (this.currentProfile == 2 && this.save2Name.length() == 0) {
/* 626 */       this.save2Name = "Profile 2";
/* 627 */       this.save2Name_backup = this.save2Name;
/* 628 */     } else if (this.currentProfile == 3 && this.save3Name.length() == 0) {
/* 629 */       this.save3Name = "Profile 3";
/* 630 */       this.save3Name_backup = this.save3Name;
/*     */     } 
/* 632 */     if ((Game.getPlayer()).typedName.length() == 0) {
/* 633 */       (Game.getPlayer()).name = (Game.getPlayer()).defaultName;
/* 634 */     } else if ((Game.getPlayer()).typedName.length() >= 1) {
/* 635 */       (Game.getPlayer()).name = (Game.getPlayer()).typedName;
/*     */     } 
/* 637 */     Save.profileSave(save, path, this.currentProfile);
/* 638 */     Load.loadProfile(path);
/* 639 */     enterGame();
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.7.jar!\beyondOrigins\main\menus\MainMenu.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */