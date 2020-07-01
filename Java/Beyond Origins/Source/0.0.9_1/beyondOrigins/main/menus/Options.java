/*     */ package beyondOrigins.main.menus;
/*     */ 
/*     */ import beyondOrigins.files.Load;
/*     */ import beyondOrigins.files.Save;
/*     */ import beyondOrigins.main.Game;
/*     */ import beyondOrigins.main.gfx.ImageManager;
/*     */ import beyondOrigins.main.threads.Noti;
/*     */ import beyondOrigins.main.windows.About;
/*     */ import beyondOrigins.main.windows.AddOns;
/*     */ import beyondOrigins.main.windows.Keys;
/*     */ import beyondOrigins.userInput.MouseMotion;
/*     */ import java.awt.FontMetrics;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.io.IOException;
/*     */ 
/*     */ public class Options {
/*  21 */   public static String autoSaveToggle = "On";
/*     */   
/*  21 */   public static String tdToggle = "Off";
/*     */   
/*     */   private byte state;
/*     */   
/*  23 */   private AddOns a = new AddOns();
/*     */   
/*  24 */   private About ab = new About();
/*     */   
/*  25 */   private Keys k = new Keys();
/*     */   
/*     */   private FontMetrics fm;
/*     */   
/*     */   public Options() {
/*  29 */     Load.loadData(Game.dataPath);
/*  30 */     if (autoSaveToggle == "On" && !Game.autoSave) {
/*  31 */       autoSaveToggle = "Off";
/*  32 */     } else if (autoSaveToggle == "Off" && Game.autoSave) {
/*  33 */       autoSaveToggle = "On";
/*     */     } 
/*  35 */     if (tdToggle == "On" && !Game.dummy) {
/*  36 */       tdToggle = "Off";
/*  37 */     } else if (tdToggle == "Off" && Game.dummy) {
/*  38 */       tdToggle = "On";
/*     */     } 
/*     */   }
/*     */   
/*     */   private byte getButtonState(int x, int y, int width, int height, byte state) {
/*  46 */     if (MouseMotion.mouseX >= x && MouseMotion.mouseX < x + width && 
/*  47 */       MouseMotion.mouseY >= y && MouseMotion.mouseY < y + height) {
/*  48 */       state = 2;
/*  49 */       if (Game.mouseIsPressed()) {
/*  50 */         state = 3;
/*     */       } else {
/*  52 */         state = 2;
/*     */       } 
/*     */     } else {
/*  54 */       state = 1;
/*     */     } 
/*  55 */     return state;
/*     */   }
/*     */   
/*     */   private void drawButton(Graphics g, int x, int y, int width, int height, String buttonText, BufferedImage state1Image, BufferedImage state2Image, BufferedImage state3Image, double clickEventType) {
/*  62 */     this.fm = g.getFontMetrics(Game.buttonTextFont);
/*  64 */     g.setFont(Game.buttonTextFont);
/*  65 */     if (getButtonState(x, y, width, height, this.state) == 1) {
/*  66 */       g.drawImage(state1Image, x, y, width, height, null);
/*  67 */       g.setColor(Game.buttonIdleColor);
/*  68 */       g.drawString(
/*  69 */           buttonText, 
/*  70 */           x + state1Image.getWidth() / 2 - 
/*  71 */           this.fm.stringWidth(buttonText) / 2, y + 
/*  72 */           state1Image.getHeight() / 2 + 5);
/*  73 */     } else if (getButtonState(x, y, width, height, this.state) == 2) {
/*  74 */       g.drawImage(state2Image, x, y, width, height, null);
/*  75 */       g.setColor(Game.buttonSelectedColor);
/*  76 */       g.drawString(
/*  77 */           buttonText, 
/*  78 */           x + state1Image.getWidth() / 2 - 
/*  79 */           this.fm.stringWidth(buttonText) / 2, y + 
/*  80 */           state1Image.getHeight() / 2 + 5);
/*  81 */     } else if (getButtonState(x, y, width, height, this.state) == 3) {
/*  82 */       g.drawImage(state3Image, x, y, width, height, null);
/*  83 */       g.setColor(Game.buttonClickedColor);
/*  84 */       g.drawString(
/*  85 */           buttonText, 
/*  86 */           x + state1Image.getWidth() / 2 - 
/*  87 */           this.fm.stringWidth(buttonText) / 2, y + 
/*  88 */           state1Image.getHeight() / 2 + 5);
/*  89 */       clickEventHandler(clickEventType);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void clickEventHandler(double e) {
/*  94 */     if (e == 4.1D) {
/*  95 */       m4AutoSave();
/*  96 */     } else if (e == 4.2D) {
/*  97 */       m4AddOns();
/*  98 */     } else if (e == 4.3D) {
/*  99 */       m4TestDummy();
/* 100 */     } else if (e == 4.4D) {
/* 101 */       m4Reload();
/* 102 */     } else if (e == 4.5D) {
/* 103 */       m4About();
/* 104 */     } else if (e == 4.6D) {
/* 105 */       m4ResetFiles();
/* 106 */     } else if (e == 4.7D) {
/* 107 */       m4Keys();
/* 108 */     } else if (e == 4.0D) {
/* 109 */       m4Back();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void render(Graphics g) {
/* 114 */     this.fm = g.getFontMetrics(Game.profileInfoFont);
/* 116 */     drawButton(g, Game.width / 2 - 
/* 117 */         ImageManager.button2_1.getWidth() + 8, 100, 
/* 118 */         ImageManager.button2_1.getWidth(), 
/* 119 */         ImageManager.button2_1.getHeight(), "Auto Save: " + 
/* 120 */         autoSaveToggle, ImageManager.button2_1, 
/* 121 */         ImageManager.button2_2, ImageManager.button2_3, 4.1D);
/* 122 */     g.setColor(Game.profileInfoColor);
/* 123 */     g.setFont(Game.profileInfoFont);
/* 125 */     drawButton(g, Game.width / 2 + 8, 100, 
/* 126 */         ImageManager.button2_1.getWidth(), 
/* 127 */         ImageManager.button2_1.getHeight(), "Test Dummy: " + tdToggle, 
/* 128 */         ImageManager.button2_1, ImageManager.button2_2, 
/* 129 */         ImageManager.button2_3, 4.3D);
/* 131 */     drawButton(g, Game.width / 2 - 
/* 132 */         ImageManager.button2_1.getWidth() + 8, 148, 
/* 133 */         ImageManager.button2_1.getWidth(), 
/* 134 */         ImageManager.button2_1.getHeight(), "Reload Graphics", 
/* 135 */         ImageManager.button2_1, ImageManager.button2_2, 
/* 136 */         ImageManager.button2_3, 4.4D);
/* 138 */     drawButton(g, Game.width / 2 + 8, 148, 
/* 139 */         ImageManager.button2_1.getWidth(), 
/* 140 */         ImageManager.button2_1.getHeight(), "Reset Files", 
/* 141 */         ImageManager.button2_1, ImageManager.button2_2, 
/* 142 */         ImageManager.button2_3, 4.6D);
/* 144 */     drawButton(g, Game.width / 2 + 8, 445, 
/* 145 */         ImageManager.button1_1.getWidth(), 
/* 146 */         ImageManager.button1_1.getHeight(), "About...", 
/* 147 */         ImageManager.button1_1, ImageManager.button1_2, 
/* 148 */         ImageManager.button1_3, 4.5D);
/* 150 */     drawButton(g, Game.width / 2 - 
/* 151 */         ImageManager.button1_1.getWidth() * 2 + 24, 
/* 152 */         445, ImageManager.button1_1.getWidth(), 
/* 153 */         ImageManager.button1_1.getHeight(), "Add-Ons...", 
/* 154 */         ImageManager.button1_1, ImageManager.button1_2, 
/* 155 */         ImageManager.button1_3, 4.2D);
/* 157 */     drawButton(g, Game.width / 2 - 
/* 158 */         ImageManager.button1_1.getWidth() + 8, 445, 
/* 159 */         ImageManager.button1_1.getWidth(), 
/* 160 */         ImageManager.button1_1.getHeight(), "Keys...", 
/* 161 */         ImageManager.button1_1, ImageManager.button1_2, 
/* 162 */         ImageManager.button1_3, 4.7D);
/* 164 */     drawButton(g, Game.width / 2 + 
/* 165 */         ImageManager.button1_1.getWidth() + 24, 
/* 166 */         445, ImageManager.button1_1.getWidth(), 
/* 167 */         ImageManager.button1_1.getHeight(), "Back", 
/* 168 */         ImageManager.button1_1, ImageManager.button1_2, 
/* 169 */         ImageManager.button1_3, 4.0D);
/*     */   }
/*     */   
/*     */   private void m4AutoSave() {
/* 173 */     if (autoSaveToggle == "On") {
/* 174 */       autoSaveToggle = "Off";
/* 175 */       Game.autoSave = false;
/* 176 */     } else if (autoSaveToggle == "Off") {
/* 177 */       autoSaveToggle = "On";
/* 178 */       Game.autoSave = true;
/*     */     } 
/* 180 */     Game.endClick();
/*     */     try {
/* 182 */       Save.dataSave();
/* 183 */     } catch (IOException e) {
/* 184 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   private void m4TestDummy() {
/* 189 */     if (tdToggle == "On") {
/* 190 */       tdToggle = "Off";
/* 191 */       Game.dummy = false;
/* 192 */     } else if (tdToggle == "Off") {
/* 193 */       tdToggle = "On";
/* 194 */       Game.dummy = true;
/*     */     } 
/* 196 */     Game.endClick();
/*     */     try {
/* 198 */       Save.dataSave();
/* 199 */     } catch (IOException e) {
/* 200 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   private void m4AddOns() {
/* 205 */     this.a.createWindow();
/* 206 */     Game.endClick();
/*     */   }
/*     */   
/*     */   private void m4Reload() {
/* 210 */     Game.loadGfx();
/* 211 */     Noti.startNotify(Noti.gre);
/* 212 */     Game.endClick();
/*     */   }
/*     */   
/*     */   private void m4About() {
/* 216 */     this.ab.createWindow();
/* 217 */     Game.endClick();
/*     */   }
/*     */   
/*     */   private void m4ResetFiles() {
/* 221 */     if (!Save.save1.exists() && !Save.save2.exists() && 
/* 222 */       !Save.save3.exists() && !Save.data.exists() && 
/* 223 */       !Save.keys.exists()) {
/* 224 */       Noti.fre.setText("No files were detected, but all values were reset!");
/* 225 */     } else if ((Save.save1.delete() || Save.save2.delete() || Save.save3
/* 226 */       .delete()) && Save.data.delete() && Save.keys.delete()) {
/* 227 */       Noti.fre.setText("All files deleted and all values reset!");
/*     */     } else {
/* 229 */       Save.save1.delete();
/* 230 */       Save.save2.delete();
/* 231 */       Save.save3.delete();
/* 232 */       Save.data.delete();
/* 233 */       Save.keys.delete();
/* 234 */       Noti.fre.setText("Some files deleted and all values were reset!");
/*     */     } 
/* 236 */     Save.dataReset();
/* 237 */     Save.profileReset();
/* 238 */     Game.logger.log.delete();
/* 239 */     Noti.startNotify(Noti.fre);
/* 240 */     Game.endClick();
/*     */   }
/*     */   
/*     */   private void m4Keys() {
/* 244 */     this.k.createWindow();
/* 245 */     Game.endClick();
/*     */   }
/*     */   
/*     */   private void m4Back() {
/* 249 */     (Game.getMainMenu()).save1State = 0;
/* 250 */     (Game.getMainMenu()).save2State = 0;
/* 251 */     (Game.getMainMenu()).save3State = 0;
/* 252 */     (Game.getMainMenu()).currentProfile = 0;
/* 253 */     (Game.getMainMenu()).menuState = 1;
/* 254 */     Game.endClick();
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.9_1.jar!\beyondOrigins\main\menus\Options.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */