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
/* 231 */     Game.isInGame = true;
/* 232 */     this.menuState = 0;
/* 233 */     Game.isLoading = true;
/* 234 */     KeyManager.enterPressed = false;
/* 235 */     (Game.getPlayer()).up = false;
/* 236 */     (Game.getPlayer()).down = false;
/* 237 */     (Game.getPlayer()).left = false;
/* 238 */     (Game.getPlayer()).right = false;
/* 239 */     Game.getPlayer().healthBarCheck();
/* 240 */     Game.getPlayer().fixPos();
/* 241 */     Game.endClick();
/*     */   }
/*     */   
/*     */   public void tick() {
/* 245 */     this.cloud1.tick(Game.width, 0.3D, 1);
/* 246 */     this.cloud2.tick(-155, 0.4D, 0);
/* 247 */     this.cloud3.tick(Game.width + 145, 0.2D, 1);
/*     */   }
/*     */   
/*     */   private void profileCheck() {
/* 252 */     if (!Save.save1.exists()) {
/* 253 */       this.save1Name = "Play To Create Me";
/* 254 */     } else if (Save.save1.exists()) {
/* 255 */       this.save1Name = this.save1Name_backup;
/*     */     } 
/* 258 */     if (!Save.save2.exists()) {
/* 259 */       this.save2Name = "Play To Create Me";
/* 260 */     } else if (Save.save2.exists()) {
/* 261 */       this.save2Name = this.save2Name_backup;
/*     */     } 
/* 264 */     if (!Save.save3.exists()) {
/* 265 */       this.save3Name = "Play To Create Me";
/* 266 */     } else if (Save.save3.exists()) {
/* 267 */       this.save3Name = this.save3Name_backup;
/*     */     } 
/* 270 */     if (this.save1State == 3 || this.save2State == 3 || this.save3State == 3) {
/* 271 */       this.canPlayProfile = true;
/* 272 */     } else if (this.save1State == 0 && this.save2State == 0 && this.save3State == 0) {
/* 273 */       this.canPlayProfile = false;
/*     */     } 
/* 276 */     if ((this.currentProfile == 1 && !Save.save1.exists()) || (
/* 277 */       this.currentProfile == 2 && !Save.save2.exists()) || (
/* 278 */       this.currentProfile == 3 && !Save.save3.exists()) || 
/* 279 */       this.currentProfile == 0) {
/* 280 */       this.canDeleteProfile = false;
/* 281 */     } else if ((this.currentProfile == 1 && Save.save1.exists()) || (
/* 282 */       this.currentProfile == 2 && Save.save2.exists()) || (
/* 283 */       this.currentProfile == 3 && Save.save3.exists())) {
/* 284 */       this.canDeleteProfile = true;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void render(Graphics g) {
/* 291 */     g.setColor(Game.skyColor);
/* 292 */     g.fillRect(0, 0, Game.width, Game.height);
/* 294 */     this.cloud1.render(g);
/* 295 */     this.cloud2.render(g);
/* 296 */     this.cloud3.render(g);
/* 298 */     if (this.menuState == 1) {
/* 299 */       renderState1(g);
/* 300 */     } else if (this.menuState == 2) {
/* 301 */       renderState2(g);
/* 302 */     } else if (this.menuState == 3) {
/* 303 */       renderState3(g);
/* 304 */     } else if (this.menuState == 4) {
/* 305 */       renderState4(g);
/* 306 */     } else if (this.menuState != 5) {
/* 308 */       if (this.menuState == 6)
/* 309 */         renderState6(g); 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void renderState1(Graphics g) {
/* 318 */     this.fm = g.getFontMetrics(Game.profileInfoFont);
/* 319 */     this.fm2 = g.getFontMetrics(Game.buttonTextFont);
/* 322 */     g.drawImage(Game.logoImage, 
/* 323 */         Game.width / 2 - Game.logoImage.getWidth(), Game.height / 2 - 
/* 324 */         Game.logoImage.getWidth() - 45, 
/* 325 */         Game.logoImage.getWidth() * 2, Game.logoImage.getHeight() * 2, 
/* 326 */         null);
/* 329 */     g.setFont(Game.buttonTextFont);
/* 330 */     g.setColor(Color.white);
/* 331 */     g.drawString(Game.title, 5, Game.height - 13);
/* 332 */     g.drawString(Game.copyright, 
/* 333 */         Game.width - this.fm2.stringWidth(Game.copyright) + 10, 
/* 334 */         Game.height - 13);
/* 337 */     drawButton(g, Game.width / 2 - 168, Game.height / 2, 336, 32, "Play", 
/* 338 */         ImageManager.button2_1, ImageManager.button2_2, 
/* 339 */         ImageManager.button2_3, 1.1D);
/* 342 */     drawButton(g, Game.width / 2 - 168, Game.height / 2 + 48, 
/* 343 */         ImageManager.button2_1.getWidth(), 
/* 344 */         ImageManager.button2_1.getHeight(), "Options", 
/* 345 */         ImageManager.button2_1, ImageManager.button2_2, 
/* 346 */         ImageManager.button2_3, 1.2D);
/* 349 */     drawButton(g, Game.width / 2 + 8, Game.height / 2 + 48 + 48, 
/* 350 */         ImageManager.button1_1.getWidth(), 
/* 351 */         ImageManager.button1_1.getHeight(), "Quit", 
/* 352 */         ImageManager.button1_1, ImageManager.button1_2, 
/* 353 */         ImageManager.button1_3, 1.4D);
/* 356 */     drawButton(g, Game.width / 2 - 168, Game.height / 2 + 48 + 48, 
/* 357 */         ImageManager.button1_1.getWidth(), 
/* 358 */         ImageManager.button1_1.getHeight(), "Credits", 
/* 359 */         ImageManager.button1_1, ImageManager.button1_2, 
/* 360 */         ImageManager.button1_3, 1.3D);
/*     */   }
/*     */   
/*     */   private void renderState2(Graphics g) {
/* 368 */     this.fm = g.getFontMetrics(Game.gameProgressFont);
/* 370 */     g.setFont(Game.profileInfoFont);
/* 371 */     g.setColor(Game.profileInfoColor);
/* 375 */     if (this.save1State == 3) {
/* 376 */       g.drawImage(ImageManager.profileSelection, Game.width / 2 - 150, 
/* 377 */           43, 300, 117, null);
/* 378 */       this.currentProfile = 1;
/* 379 */       profileCheck();
/* 380 */     } else if (this.save2State == 3) {
/* 381 */       g.drawImage(ImageManager.profileSelection, Game.width / 2 - 150, 
/* 382 */           153, 300, 117, null);
/* 383 */       this.currentProfile = 2;
/* 384 */       profileCheck();
/* 385 */     } else if (this.save3State == 3) {
/* 386 */       g.drawImage(ImageManager.profileSelection, Game.width / 2 - 150, 
/* 387 */           263, 300, 117, null);
/* 388 */       this.currentProfile = 3;
/* 389 */       profileCheck();
/*     */     } 
/* 394 */     drawProfile(g, this.save1State, Game.width / 2 - 144, 50, 
/* 395 */         Save.save1LastPlayed, Save.save1Made, Save.save1, 1, this.save1Name, 
/* 396 */         this.fm);
/* 398 */     drawProfile(g, this.save2State, Game.width / 2 - 144, 160, 
/* 399 */         Save.save2LastPlayed, Save.save2Made, Save.save2, 2, this.save2Name, 
/* 400 */         this.fm);
/* 402 */     drawProfile(g, this.save3State, Game.width / 2 - 144, 270, 
/* 403 */         Save.save3LastPlayed, Save.save3Made, Save.save3, 3, this.save3Name, 
/* 404 */         this.fm);
/* 406 */     this.fm2 = g.getFontMetrics(Game.buttonTextFont);
/* 410 */     if (this.canPlayProfile) {
/* 411 */       drawButton(g, Game.width / 2 - 
/* 412 */           ImageManager.button2_1.getWidth() / 2, 425, 
/* 413 */           ImageManager.button2_1.getWidth(), 
/* 414 */           ImageManager.button2_1.getHeight(), "Play Profile", 
/* 415 */           ImageManager.button2_1, ImageManager.button2_2, 
/* 416 */           ImageManager.button2_3, 2.1D);
/* 417 */     } else if (!this.canPlayProfile) {
/* 418 */       g.setFont(Game.buttonTextFont);
/* 419 */       g.drawImage(ImageManager.button2_3, Game.width / 2 - 
/* 420 */           ImageManager.button2_3.getWidth() / 2, 425, 
/* 421 */           ImageManager.button2_3.getWidth(), 
/* 422 */           ImageManager.button2_3.getHeight(), null);
/* 423 */       g.setColor(Game.buttonClickedColor);
/* 424 */       g.drawString("Play Profile", 
/* 425 */           Game.width / 2 - this.fm2.stringWidth("Play Profile") / 2, 
/* 426 */           446);
/*     */     } 
/* 431 */     if (this.canDeleteProfile) {
/* 432 */       drawButton(g, Game.width / 2 - 
/* 433 */           ImageManager.button2_1.getWidth() / 2, 473, 
/* 434 */           ImageManager.button1_1.getWidth(), 
/* 435 */           ImageManager.button1_1.getHeight(), "Delete", 
/* 436 */           ImageManager.button1_1, ImageManager.button1_2, 
/* 437 */           ImageManager.button1_3, 2.2D);
/* 438 */     } else if (!this.canDeleteProfile) {
/* 439 */       g.setFont(Game.buttonTextFont);
/* 440 */       g.drawImage(ImageManager.button1_3, Game.width / 2 - 
/* 441 */           ImageManager.button2_1.getWidth() / 2, 473, 
/* 442 */           ImageManager.button1_3.getWidth(), 
/* 443 */           ImageManager.button1_3.getHeight(), null);
/* 444 */       g.setColor(Game.buttonClickedColor);
/* 445 */       g.drawString(
/* 446 */           "Delete", 
/* 447 */           Game.width / 2 - ImageManager.button1_1.getWidth() / 2 - 8 - 
/* 448 */           this.fm2.stringWidth("Delete") / 2, 
/* 449 */           473 + ImageManager.button1_3.getHeight() / 2 + 5);
/*     */     } 
/* 454 */     drawButton(g, Game.width / 2 - 
/* 455 */         ImageManager.button2_1.getWidth() / 2 + 176, 473, 
/* 456 */         ImageManager.button1_1.getWidth(), 
/* 457 */         ImageManager.button1_1.getHeight(), "Back", 
/* 458 */         ImageManager.button1_1, ImageManager.button1_2, 
/* 459 */         ImageManager.button1_3, 2.3D);
/*     */   }
/*     */   
/*     */   private void renderState3(Graphics g) {
/* 467 */     g.setFont(Game.areYouSureFont);
/* 468 */     g.setColor(Game.profileInfoColor);
/* 469 */     g.drawString("Are you sure?", 280, 190);
/* 471 */     g.setFont(Game.buttonTextFont);
/* 473 */     drawButton(g, Game.width / 2 - 204, 325, 
/* 474 */         ImageManager.button1_1.getWidth(), 
/* 475 */         ImageManager.button1_1.getHeight(), "Yes", 
/* 476 */         ImageManager.button1_1, ImageManager.button1_2, 
/* 477 */         ImageManager.button1_3, 3.1D);
/* 479 */     drawButton(g, Game.width / 2 + 35, 325, 
/* 480 */         ImageManager.button1_1.getWidth(), 
/* 481 */         ImageManager.button1_1.getHeight(), "No", 
/* 482 */         ImageManager.button1_1, ImageManager.button1_2, 
/* 483 */         ImageManager.button1_3, 3.2D);
/*     */   }
/*     */   
/*     */   private void renderState4(Graphics g) {
/* 490 */     this.o.render(g);
/*     */   }
/*     */   
/*     */   private void renderState6(Graphics g) {
/* 497 */     g.setFont(Game.buttonTextFont);
/* 498 */     g.setColor(Game.profileInfoColor);
/* 500 */     this.fm = g.getFontMetrics(Game.buttonTextFont);
/* 502 */     g.drawString("You were killed!", 
/* 503 */         Game.width / 2 - this.fm.stringWidth("You were killed!") / 2, 
/* 504 */         200);
/* 506 */     drawButton(g, Game.width / 2 - 
/* 507 */         ImageManager.button2_1.getWidth() / 2, 275, 
/* 508 */         ImageManager.button2_1.getWidth(), 
/* 509 */         ImageManager.button2_1.getHeight(), "Respawn", 
/* 510 */         ImageManager.button2_1, ImageManager.button2_2, 
/* 511 */         ImageManager.button2_3, 6.1D);
/* 513 */     drawButton(g, Game.width / 2 - 
/* 514 */         ImageManager.button2_1.getWidth() / 2, 323, 
/* 515 */         ImageManager.button2_1.getWidth(), 
/* 516 */         ImageManager.button2_1.getHeight(), "Save and Quit to Title", 
/* 517 */         ImageManager.button2_1, ImageManager.button2_2, 
/* 518 */         ImageManager.button2_3, 6.2D);
/*     */   }
/*     */   
/*     */   private void m1Play() {
/* 523 */     this.menuState = 2;
/* 524 */     Load.loadData(Game.dataPath);
/* 525 */     profileCheck();
/* 526 */     Game.endClick();
/*     */   }
/*     */   
/*     */   public void m1Options() {
/* 530 */     this.menuState = 4;
/* 531 */     this.o = new Options();
/* 532 */     Game.endClick();
/*     */   }
/*     */   
/*     */   private void m1Quit() {
/* 536 */     System.exit(0);
/*     */   }
/*     */   
/*     */   private void m1Creds() {
/* 540 */     this.c = new Credits();
/* 541 */     this.c.createWindow();
/* 542 */     Game.endClick();
/*     */   }
/*     */   
/*     */   public void m2PlayProfile() throws IOException {
/* 546 */     if (this.currentProfile == 1) {
/* 547 */       if (Save.save1.exists()) {
/* 548 */         Load.loadProfile(Game.save1Path);
/* 549 */         Save.profileSave(Save.save1, Game.save1Path, 1);
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
/* 561 */         Load.loadProfile(Game.save2Path);
/* 562 */         Save.profileSave(Save.save2, Game.save2Path, 2);
/* 563 */         enterGame();
/* 564 */       } else if (!Save.save2.exists()) {
/* 565 */         this.save2Name = "";
/* 566 */         (Game.getPlayer()).typedName = "";
/* 567 */         this.cancelState = 0;
/* 568 */         this.proc = new ProfileCreator();
/* 569 */         this.proc.createWindow(2);
/*     */       } 
/* 571 */     } else if (this.currentProfile == 3) {
/* 572 */       if (Save.save3.exists()) {
/* 573 */         Load.loadProfile(Game.save3Path);
/* 574 */         Save.profileSave(Save.save3, Game.save3Path, 3);
/* 575 */         enterGame();
/* 576 */       } else if (!Save.save3.exists()) {
/* 577 */         this.save3Name = "";
/* 578 */         (Game.getPlayer()).typedName = "";
/* 579 */         this.cancelState = 0;
/* 580 */         this.proc = new ProfileCreator();
/* 581 */         this.proc.createWindow(3);
/*     */       } 
/*     */     } 
/* 584 */     Game.endClick();
/* 585 */     TestDummy.reset();
/* 586 */     this.save1State = 0;
/* 587 */     this.save2State = 0;
/* 588 */     this.save3State = 0;
/*     */   }
/*     */   
/*     */   private void m2DeleteProfile() throws IOException {
/* 592 */     if (this.currentProfile == 1) {
/* 593 */       Save.save1.delete();
/* 594 */       Save.save1Made = "";
/* 595 */       Save.save1LastPlayed = "";
/* 596 */       Save.dataSave();
/* 597 */     } else if (this.currentProfile == 2) {
/* 598 */       Save.save2.delete();
/* 599 */       Save.save2Made = "";
/* 600 */       Save.save2LastPlayed = "";
/* 601 */       Save.dataSave();
/* 602 */     } else if (this.currentProfile == 3) {
/* 603 */       Save.save3.delete();
/* 604 */       Save.save3Made = " ";
/* 605 */       Save.save3LastPlayed = " ";
/* 606 */       Save.dataSave();
/*     */     } 
/* 608 */     this.menuState = 2;
/* 609 */     this.currentProfile = 0;
/* 610 */     profileCheck();
/* 611 */     Game.endClick();
/*     */   }
/*     */   
/*     */   private void m2Back() {
/* 615 */     this.save1State = 0;
/* 616 */     this.save2State = 0;
/* 617 */     this.save3State = 0;
/* 618 */     this.currentProfile = 0;
/* 619 */     this.menuState = 1;
/* 620 */     Game.endClick();
/*     */   }
/*     */   
/*     */   private void m3Yes() {
/*     */     try {
/* 625 */       m2DeleteProfile();
/* 626 */     } catch (IOException e) {
/* 627 */       e.printStackTrace();
/*     */     } 
/* 629 */     Game.endClick();
/*     */   }
/*     */   
/*     */   private void m3No() {
/* 633 */     this.menuState = 2;
/* 634 */     Game.endClick();
/*     */   }
/*     */   
/*     */   public void m5CreateProfile(File save, String path) throws IOException {
/* 638 */     Save.profileReset();
/* 639 */     if (this.currentProfile == 1 && this.save1Name.length() == 0) {
/* 640 */       this.save1Name = "Profile 1";
/* 641 */       this.save1Name_backup = this.save1Name;
/* 642 */     } else if (this.currentProfile == 2 && this.save2Name.length() == 0) {
/* 643 */       this.save2Name = "Profile 2";
/* 644 */       this.save2Name_backup = this.save2Name;
/* 645 */     } else if (this.currentProfile == 3 && this.save3Name.length() == 0) {
/* 646 */       this.save3Name = "Profile 3";
/* 647 */       this.save3Name_backup = this.save3Name;
/*     */     } 
/* 649 */     if ((Game.getPlayer()).typedName.length() == 0) {
/* 650 */       (Game.getPlayer()).name = (Game.getPlayer()).defaultName;
/* 651 */     } else if ((Game.getPlayer()).typedName.length() >= 1) {
/* 652 */       (Game.getPlayer()).name = (Game.getPlayer()).typedName;
/*     */     } 
/* 654 */     Save.profileSave(save, path, this.currentProfile);
/* 655 */     Load.loadProfile(path);
/* 656 */     enterGame();
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.8_1.jar!\beyondOrigins\main\menus\MainMenu.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */