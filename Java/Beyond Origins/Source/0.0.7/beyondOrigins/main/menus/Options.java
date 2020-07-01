/*     */ package beyondOrigins.main.menus;
/*     */ 
/*     */ import beyondOrigins.files.Load;
/*     */ import beyondOrigins.files.Save;
/*     */ import beyondOrigins.main.Game;
/*     */ import beyondOrigins.main.gfx.ImageManager;
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
/*  20 */   public static String autoSaveToggle = "On";
/*     */   
/*  20 */   public static String tdToggle = "Off";
/*     */   
/*     */   private byte state;
/*     */   
/*     */   private AddOns a;
/*     */   
/*     */   private About ab;
/*     */   
/*     */   private Keys keyWindow;
/*     */   
/*     */   private FontMetrics fm;
/*     */   
/*     */   public Options() {
/*  28 */     this.a = new AddOns();
/*  29 */     this.ab = new About();
/*  30 */     this.keyWindow = new Keys();
/*  31 */     Load.loadData(Game.dataPath);
/*  32 */     if (autoSaveToggle == "On" && !Game.autoSave) {
/*  33 */       autoSaveToggle = "Off";
/*  34 */     } else if (autoSaveToggle == "Off" && Game.autoSave) {
/*  35 */       autoSaveToggle = "On";
/*     */     } 
/*  37 */     if (tdToggle == "On" && !Game.dummy) {
/*  38 */       tdToggle = "Off";
/*  39 */     } else if (tdToggle == "Off" && Game.dummy) {
/*  40 */       tdToggle = "On";
/*     */     } 
/*     */   }
/*     */   
/*     */   private byte getButtonState(int x, int y, int width, int height, byte state) {
/*  48 */     if (MouseMotion.mouseX >= x && MouseMotion.mouseX < x + width && 
/*  49 */       MouseMotion.mouseY >= y && MouseMotion.mouseY < y + height) {
/*  50 */       state = 2;
/*  51 */       if (Game.mouseIsPressed()) {
/*  52 */         state = 3;
/*     */       } else {
/*  54 */         state = 2;
/*     */       } 
/*     */     } else {
/*  56 */       state = 1;
/*     */     } 
/*  57 */     return state;
/*     */   }
/*     */   
/*     */   private void drawButton(Graphics g, int x, int y, int width, int height, String buttonText, BufferedImage state1Image, BufferedImage state2Image, BufferedImage state3Image, double clickEventType) {
/*  64 */     this.fm = g.getFontMetrics(Game.buttonTextFont);
/*  66 */     g.setFont(Game.buttonTextFont);
/*  67 */     if (getButtonState(x, y, width, height, this.state) == 1) {
/*  68 */       g.drawImage(state1Image, x, y, width, height, null);
/*  69 */       g.setColor(Game.buttonIdleColor);
/*  70 */       g.drawString(
/*  71 */           buttonText, 
/*  72 */           x + state1Image.getWidth() / 2 - 
/*  73 */           this.fm.stringWidth(buttonText) / 2, y + 
/*  74 */           state1Image.getHeight() / 2 + 5);
/*  75 */     } else if (getButtonState(x, y, width, height, this.state) == 2) {
/*  76 */       g.drawImage(state2Image, x, y, width, height, null);
/*  77 */       g.setColor(Game.buttonSelectedColor);
/*  78 */       g.drawString(
/*  79 */           buttonText, 
/*  80 */           x + state1Image.getWidth() / 2 - 
/*  81 */           this.fm.stringWidth(buttonText) / 2, y + 
/*  82 */           state1Image.getHeight() / 2 + 5);
/*  83 */     } else if (getButtonState(x, y, width, height, this.state) == 3) {
/*  84 */       g.drawImage(state3Image, x, y, width, height, null);
/*  85 */       g.setColor(Game.buttonClickedColor);
/*  86 */       g.drawString(
/*  87 */           buttonText, 
/*  88 */           x + state1Image.getWidth() / 2 - 
/*  89 */           this.fm.stringWidth(buttonText) / 2, y + 
/*  90 */           state1Image.getHeight() / 2 + 5);
/*  91 */       clickEventHandler(clickEventType);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void clickEventHandler(double e) {
/*  96 */     if (e == 4.1D) {
/*  97 */       m4AutoSave();
/*  98 */     } else if (e == 4.2D) {
/*  99 */       m4AddOns();
/* 100 */     } else if (e == 4.3D) {
/* 101 */       m4TestDummy();
/* 102 */     } else if (e == 4.4D) {
/* 103 */       m4Reload();
/* 104 */     } else if (e == 4.5D) {
/* 105 */       m4About();
/* 106 */     } else if (e == 4.6D) {
/* 107 */       m4ResetFiles();
/*     */     } else if (e == 4.7D) {
/* 109 */       m4Keys();
/* 110 */     } else if (e == 4.0D) {
/* 111 */       m4Back();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void render(Graphics g) {
/* 116 */     this.fm = g.getFontMetrics(Game.profileInfoFont);
/* 119 */     drawButton(g, Game.width / 2 - 
/* 120 */         ImageManager.button2_1.getWidth() + 8, 100, 
/* 121 */         ImageManager.button2_1.getWidth(), 
/* 122 */         ImageManager.button2_1.getHeight(), "Auto Save: " + 
/* 123 */         autoSaveToggle, ImageManager.button2_1, 
/* 124 */         ImageManager.button2_2, ImageManager.button2_3, 4.1D);
/* 125 */     g.setColor(Game.profileInfoColor);
/* 126 */     g.setFont(Game.profileInfoFont);
/* 129 */     drawButton(g, Game.width / 2 + 8, 100, 
/* 130 */         ImageManager.button2_1.getWidth(), 
/* 131 */         ImageManager.button2_1.getHeight(), "Test Dummy: " + tdToggle, 
/* 132 */         ImageManager.button2_1, ImageManager.button2_2, 
/* 133 */         ImageManager.button2_3, 4.3D);
/* 136 */     drawButton(g, Game.width / 2 - 
/* 137 */         ImageManager.button2_1.getWidth() + 8, 148, 
/* 138 */         ImageManager.button2_1.getWidth(), 
/* 139 */         ImageManager.button2_1.getHeight(), "Reload Graphics", 
/* 140 */         ImageManager.button2_1, ImageManager.button2_2, 
/* 141 */         ImageManager.button2_3, 4.4D);
/* 144 */     drawButton(g, Game.width / 2 + 8, 148, 
/* 145 */         ImageManager.button2_1.getWidth(), 
/* 146 */         ImageManager.button2_1.getHeight(), "Reset Files", 
/* 147 */         ImageManager.button2_1, ImageManager.button2_2, 
/* 148 */         ImageManager.button2_3, 4.6D);
/* 151 */     drawButton(g, Game.width / 2 + 8, 445, 
/* 152 */         ImageManager.button1_1.getWidth(), 
/* 153 */         ImageManager.button1_1.getHeight(), "About...", 
/* 154 */         ImageManager.button1_1, ImageManager.button1_2, 
/* 155 */         ImageManager.button1_3, 4.5D);
/* 158 */     drawButton(g, Game.width / 2 - 
/* 159 */         ImageManager.button1_1.getWidth() * 2 + 24, 
/* 160 */         445, ImageManager.button1_1.getWidth(), 
/* 161 */         ImageManager.button1_1.getHeight(), "Add-Ons...", 
/* 162 */         ImageManager.button1_1, ImageManager.button1_2, 
/* 163 */         ImageManager.button1_3, 4.2D);
/* 166 */     drawButton(g, Game.width / 2 - 
/* 167 */         ImageManager.button1_1.getWidth() + 8, 445, 
/* 168 */         ImageManager.button1_1.getWidth(), 
/* 169 */         ImageManager.button1_1.getHeight(), "Keys...", 
/* 170 */         ImageManager.button1_1, ImageManager.button1_2, 
/* 171 */         ImageManager.button1_3, 4.7D);
/* 174 */     drawButton(g, Game.width / 2 + 
/* 175 */         ImageManager.button1_1.getWidth() + 24, 
/* 176 */         445, ImageManager.button1_1.getWidth(), 
/* 177 */         ImageManager.button1_1.getHeight(), "Back", 
/* 178 */         ImageManager.button1_1, ImageManager.button1_2, 
/* 179 */         ImageManager.button1_3, 4.0D);
/*     */   }
/*     */   
/*     */   private void m4AutoSave() {
/* 183 */     if (autoSaveToggle == "On") {
/* 184 */       autoSaveToggle = "Off";
/* 185 */       Game.autoSave = false;
/* 186 */     } else if (autoSaveToggle == "Off") {
/* 187 */       autoSaveToggle = "On";
/* 188 */       Game.autoSave = true;
/*     */     } 
/* 190 */     Game.endClick();
/*     */     try {
/* 192 */       Save.dataSave();
/* 193 */     } catch (IOException e) {
/* 194 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   private void m4TestDummy() {
/* 199 */     if (tdToggle == "On") {
/* 200 */       tdToggle = "Off";
/* 201 */       Game.dummy = false;
/* 202 */     } else if (tdToggle == "Off") {
/* 203 */       tdToggle = "On";
/* 204 */       Game.dummy = true;
/*     */     } 
/* 206 */     Game.endClick();
/*     */     try {
/* 208 */       Save.dataSave();
/* 209 */     } catch (IOException e) {
/* 210 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   private void m4AddOns() {
/* 215 */     this.a.createWindow();
/* 216 */     Game.endClick();
/*     */   }
/*     */   
/*     */   private void m4Reload() {
/* 220 */     Game.loadGfx();
/* 221 */     Game.endClick();
/*     */   }
/*     */   
/*     */   private void m4About() {
/* 225 */     this.ab.createWindow();
/* 226 */     Game.endClick();
/*     */   }
/*     */   
/*     */   private void m4ResetFiles() {
/* 230 */     Save.save1.delete();
/* 231 */     Save.save2.delete();
/* 232 */     Save.save3.delete();
/* 233 */     Save.data.delete();
/* 234 */     Save.keys.delete();
/* 235 */     Save.dataReset();
/* 236 */     Save.profileReset();
/* 237 */     Game.endClick();
/*     */   }
/*     */   
/*     */   private void m4Keys() {
/* 241 */     Load.loadKeys(Game.keysPath);
/* 242 */     this.keyWindow.createWindow();
/* 243 */     Game.endClick();
/*     */   }
/*     */   
/*     */   private void m4Back() {
/* 247 */     (Game.getMainMenu()).save1State = 0;
/* 248 */     (Game.getMainMenu()).save2State = 0;
/* 249 */     (Game.getMainMenu()).save3State = 0;
/* 250 */     (Game.getMainMenu()).currentProfile = 0;
/* 251 */     (Game.getMainMenu()).menuState = 1;
/* 252 */     Game.endClick();
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.7.jar!\beyondOrigins\main\menus\Options.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */