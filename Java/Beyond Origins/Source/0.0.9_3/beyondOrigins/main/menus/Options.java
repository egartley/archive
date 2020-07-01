/*     */ package beyondOrigins.main.menus;
/*     */ 
/*     */ import beyondOrigins.files.Load;
/*     */ import beyondOrigins.files.Save;
/*     */ import beyondOrigins.main.Game;
/*     */ import beyondOrigins.main.Profile1;
/*     */ import beyondOrigins.main.Profile2;
/*     */ import beyondOrigins.main.Profile3;
/*     */ import beyondOrigins.main.gfx.ImageManager;
/*     */ import beyondOrigins.main.threads.Noti;
/*     */ import beyondOrigins.main.windows.About;
/*     */ import beyondOrigins.main.windows.Keys;
/*     */ import beyondOrigins.userInput.MouseMotion;
/*     */ import java.awt.FontMetrics;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.io.IOException;
/*     */ 
/*     */ public class Options {
/*  22 */   public static String autoSaveToggle = "On";
/*     */   
/*  22 */   public static String tdToggle = "Off";
/*     */   
/*     */   private byte state;
/*     */   
/*  25 */   private About ab = new About();
/*     */   
/*  26 */   private Keys k = new Keys();
/*     */   
/*     */   private FontMetrics fm;
/*     */   
/*     */   public Options() {
/*  30 */     Load.loadData(Game.dataPath);
/*  31 */     if (autoSaveToggle == "On" && !Game.autoSave) {
/*  32 */       autoSaveToggle = "Off";
/*  33 */     } else if (autoSaveToggle == "Off" && Game.autoSave) {
/*  34 */       autoSaveToggle = "On";
/*     */     } 
/*  36 */     if (tdToggle == "On" && !Game.dummy) {
/*  37 */       tdToggle = "Off";
/*  38 */     } else if (tdToggle == "Off" && Game.dummy) {
/*  39 */       tdToggle = "On";
/*     */     } 
/*     */   }
/*     */   
/*     */   private byte getButtonState(int x, int y, int width, int height, byte state) {
/*  47 */     if (MouseMotion.mouseX >= x && MouseMotion.mouseX < x + width && 
/*  48 */       MouseMotion.mouseY >= y && MouseMotion.mouseY < y + height) {
/*  49 */       state = 2;
/*  50 */       if (Game.mouseIsPressed()) {
/*  51 */         state = 3;
/*     */       } else {
/*  53 */         state = 2;
/*     */       } 
/*     */     } else {
/*  55 */       state = 1;
/*     */     } 
/*  56 */     return state;
/*     */   }
/*     */   
/*     */   private void drawButton(Graphics g, int x, int y, int width, int height, String buttonText, BufferedImage state1Image, BufferedImage state2Image, BufferedImage state3Image, double clickEventType) {
/*  63 */     this.fm = g.getFontMetrics(Game.buttonTextFont);
/*  65 */     g.setFont(Game.buttonTextFont);
/*  66 */     if (getButtonState(x, y, width, height, this.state) == 1) {
/*  67 */       g.drawImage(state1Image, x, y, width, height, null);
/*  68 */       g.setColor(Game.buttonIdleColor);
/*  69 */       g.drawString(
/*  70 */           buttonText, 
/*  71 */           x + state1Image.getWidth() / 2 - 
/*  72 */           this.fm.stringWidth(buttonText) / 2, y + 
/*  73 */           state1Image.getHeight() / 2 + 5);
/*  74 */     } else if (getButtonState(x, y, width, height, this.state) == 2) {
/*  75 */       g.drawImage(state2Image, x, y, width, height, null);
/*  76 */       g.setColor(Game.buttonSelectedColor);
/*  77 */       g.drawString(
/*  78 */           buttonText, 
/*  79 */           x + state1Image.getWidth() / 2 - 
/*  80 */           this.fm.stringWidth(buttonText) / 2, y + 
/*  81 */           state1Image.getHeight() / 2 + 5);
/*  82 */     } else if (getButtonState(x, y, width, height, this.state) == 3) {
/*  83 */       g.drawImage(state3Image, x, y, width, height, null);
/*  84 */       g.setColor(Game.buttonClickedColor);
/*  85 */       g.drawString(
/*  86 */           buttonText, 
/*  87 */           x + state1Image.getWidth() / 2 - 
/*  88 */           this.fm.stringWidth(buttonText) / 2, y + 
/*  89 */           state1Image.getHeight() / 2 + 5);
/*  90 */       clickEventHandler(clickEventType);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void clickEventHandler(double e) {
/*  95 */     if (e == 4.1D) {
/*  96 */       m4AutoSave();
/*  97 */     } else if (e == 4.2D) {
/*  98 */       m4AddOns();
/*  99 */     } else if (e == 4.3D) {
/* 100 */       m4TestDummy();
/* 101 */     } else if (e == 4.4D) {
/* 102 */       m4Reload();
/* 103 */     } else if (e == 4.5D) {
/* 104 */       m4About();
/* 105 */     } else if (e == 4.6D) {
/* 106 */       m4ResetFiles();
/* 107 */     } else if (e == 4.7D) {
/* 108 */       m4Keys();
/* 109 */     } else if (e == 4.0D) {
/* 110 */       m4Back();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void render(Graphics g) {
/* 115 */     this.fm = g.getFontMetrics(Game.profileInfoFont);
/* 117 */     drawButton(g, Game.width / 2 - 
/* 118 */         ImageManager.button2_1.getWidth() + 8, 100, 
/* 119 */         ImageManager.button2_1.getWidth(), 
/* 120 */         ImageManager.button2_1.getHeight(), "Auto Save: " + 
/* 121 */         autoSaveToggle, ImageManager.button2_1, 
/* 122 */         ImageManager.button2_2, ImageManager.button2_3, 4.1D);
/* 123 */     g.setColor(Game.profileInfoColor);
/* 124 */     g.setFont(Game.profileInfoFont);
/* 126 */     drawButton(g, Game.width / 2 + 8, 100, 
/* 127 */         ImageManager.button2_1.getWidth(), 
/* 128 */         ImageManager.button2_1.getHeight(), "Test Dummy: " + tdToggle, 
/* 129 */         ImageManager.button2_1, ImageManager.button2_2, 
/* 130 */         ImageManager.button2_3, 4.3D);
/* 132 */     drawButton(g, Game.width / 2 - 
/* 133 */         ImageManager.button2_1.getWidth() + 8, 148, 
/* 134 */         ImageManager.button2_1.getWidth(), 
/* 135 */         ImageManager.button2_1.getHeight(), "Reload Graphics", 
/* 136 */         ImageManager.button2_1, ImageManager.button2_2, 
/* 137 */         ImageManager.button2_3, 4.4D);
/* 139 */     drawButton(g, Game.width / 2 + 8, 148, 
/* 140 */         ImageManager.button2_1.getWidth(), 
/* 141 */         ImageManager.button2_1.getHeight(), "Reset Files", 
/* 142 */         ImageManager.button2_1, ImageManager.button2_2, 
/* 143 */         ImageManager.button2_3, 4.6D);
/* 145 */     drawButton(g, Game.width / 2 + 8, 445, 
/* 146 */         ImageManager.button1_1.getWidth(), 
/* 147 */         ImageManager.button1_1.getHeight(), "About...", 
/* 148 */         ImageManager.button1_1, ImageManager.button1_2, 
/* 149 */         ImageManager.button1_3, 4.5D);
/* 151 */     drawButton(g, Game.width / 2 - 
/* 152 */         ImageManager.button1_1.getWidth() * 2 + 24, 
/* 153 */         445, ImageManager.button1_1.getWidth(), 
/* 154 */         ImageManager.button1_1.getHeight(), "Add-Ons...", 
/* 155 */         ImageManager.button1_1, ImageManager.button1_2, 
/* 156 */         ImageManager.button1_3, 4.2D);
/* 158 */     drawButton(g, Game.width / 2 - 
/* 159 */         ImageManager.button1_1.getWidth() + 8, 445, 
/* 160 */         ImageManager.button1_1.getWidth(), 
/* 161 */         ImageManager.button1_1.getHeight(), "Keys...", 
/* 162 */         ImageManager.button1_1, ImageManager.button1_2, 
/* 163 */         ImageManager.button1_3, 4.7D);
/* 165 */     drawButton(g, Game.width / 2 + 
/* 166 */         ImageManager.button1_1.getWidth() + 24, 
/* 167 */         445, ImageManager.button1_1.getWidth(), 
/* 168 */         ImageManager.button1_1.getHeight(), "Back", 
/* 169 */         ImageManager.button1_1, ImageManager.button1_2, 
/* 170 */         ImageManager.button1_3, 4.0D);
/*     */   }
/*     */   
/*     */   private void m4AutoSave() {
/* 174 */     if (autoSaveToggle == "On") {
/* 175 */       autoSaveToggle = "Off";
/* 176 */       Game.autoSave = false;
/* 177 */     } else if (autoSaveToggle == "Off") {
/* 178 */       autoSaveToggle = "On";
/* 179 */       Game.autoSave = true;
/*     */     } 
/* 181 */     Game.endClick();
/*     */     try {
/* 183 */       Save.dataSave();
/* 184 */     } catch (IOException e) {
/* 185 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   private void m4TestDummy() {
/* 190 */     if (tdToggle == "On") {
/* 191 */       tdToggle = "Off";
/* 192 */       Game.dummy = false;
/* 193 */     } else if (tdToggle == "Off") {
/* 194 */       tdToggle = "On";
/* 195 */       Game.dummy = true;
/*     */     } 
/* 197 */     Game.endClick();
/*     */     try {
/* 199 */       Save.dataSave();
/* 200 */     } catch (IOException e) {
/* 201 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   private void m4AddOns() {
/* 207 */     Noti.startNotify(Noti.cms);
/* 208 */     Game.endClick();
/*     */   }
/*     */   
/*     */   private void m4Reload() {
/* 212 */     Game.loadGfx();
/* 213 */     Noti.startNotify(Noti.gre);
/* 214 */     Game.endClick();
/*     */   }
/*     */   
/*     */   private void m4About() {
/* 218 */     this.ab.createWindow();
/* 219 */     Game.endClick();
/*     */   }
/*     */   
/*     */   private void m4ResetFiles() {
/* 223 */     if (!Profile1.file.exists() && !Profile2.file.exists() && 
/* 224 */       !Profile3.file.exists() && !Save.data.exists() && 
/* 225 */       !Save.keys.exists()) {
/* 226 */       Noti.fre.setText("No files were detected, but all values were reset!");
/* 227 */     } else if ((Profile1.file.delete() || Profile2.file.delete() || Profile3.file
/* 228 */       .delete()) && Save.data.delete() && Save.keys.delete()) {
/* 229 */       Noti.fre.setText("All files deleted and all values reset!");
/*     */     } else {
/* 231 */       Profile1.file.delete();
/* 232 */       Profile2.file.delete();
/* 233 */       Profile3.file.delete();
/* 234 */       Save.data.delete();
/* 235 */       Save.keys.delete();
/* 236 */       Noti.fre.setText("Some files deleted and all values were reset!");
/*     */     } 
/* 238 */     Save.dataReset();
/* 239 */     Save.profileReset();
/* 240 */     Game.logger.log.delete();
/* 241 */     Noti.startNotify(Noti.fre);
/* 242 */     Game.endClick();
/*     */   }
/*     */   
/*     */   private void m4Keys() {
/* 246 */     this.k.createWindow();
/* 247 */     Game.endClick();
/*     */   }
/*     */   
/*     */   private void m4Back() {
/* 251 */     (Game.getMainMenu()).save1State = 0;
/* 252 */     (Game.getMainMenu()).save2State = 0;
/* 253 */     (Game.getMainMenu()).save3State = 0;
/* 254 */     (Game.getMainMenu()).currentProfile = 0;
/* 255 */     (Game.getMainMenu()).menuState = 1;
/* 256 */     Game.endClick();
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.9_3.jar!\beyondOrigins\main\menus\Options.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */