/*     */ package beyondOrigins.main.menus;
/*     */ 
/*     */ import beyondOrigins.files.Save;
/*     */ import beyondOrigins.main.Game;
/*     */ import beyondOrigins.main.gfx.ImageManager;
/*     */ import beyondOrigins.userInput.MouseMotion;
/*     */ import java.awt.Color;
/*     */ import java.awt.FontMetrics;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.io.IOException;
/*     */ 
/*     */ public class PauseMenu {
/*     */   public static boolean isOpen = false;
/*     */   
/*     */   private FontMetrics fm;
/*     */   
/*     */   private static int backToGameState;
/*     */   
/*     */   private static int saveAndQuitState;
/*     */   
/*     */   public void tick() {}
/*     */   
/*     */   public int getButtonState(int minX, int minY, int width, int height, int state) {
/*  32 */     if (MouseMotion.mouseX >= minX && MouseMotion.mouseX < minX + width && 
/*  33 */       MouseMotion.mouseY >= minY && 
/*  34 */       MouseMotion.mouseY < minY + height) {
/*  35 */       state = 2;
/*  36 */       if (Game.mouseIsPressed()) {
/*  37 */         state = 3;
/*     */       } else {
/*  39 */         state = 2;
/*     */       } 
/*     */     } else {
/*  41 */       state = 1;
/*     */     } 
/*  42 */     return state;
/*     */   }
/*     */   
/*     */   public void drawButton(Graphics g, int state, int renderX, int renderY, int width, int height, String buttonText, BufferedImage state1Image, BufferedImage state2Image, BufferedImage state3Image, double clickEventType) {
/*  49 */     this.fm = g.getFontMetrics(Game.buttonTextFont);
/*  50 */     g.setFont(Game.buttonTextFont);
/*  51 */     if (getButtonState(renderX, renderY, width, height, state) == 1) {
/*  52 */       g.drawImage(state1Image, renderX, renderY, width, height, null);
/*  53 */       g.setColor(Game.buttonIdleColor);
/*  54 */       g.drawString(buttonText, renderX + state1Image.getWidth() / 2 - 
/*  55 */           this.fm.stringWidth(buttonText) / 2, 
/*  56 */           renderY + state1Image.getHeight() / 2 + 5);
/*  57 */     } else if (getButtonState(renderX, renderY, width, height, state) == 2) {
/*  58 */       g.drawImage(state2Image, renderX, renderY, width, height, null);
/*  59 */       g.setColor(Game.buttonSelectedColor);
/*  60 */       g.drawString(buttonText, renderX + state1Image.getWidth() / 2 - 
/*  61 */           this.fm.stringWidth(buttonText) / 2, 
/*  62 */           renderY + state1Image.getHeight() / 2 + 5);
/*  63 */     } else if (getButtonState(renderX, renderY, width, height, state) == 3) {
/*  64 */       g.drawImage(state3Image, renderX, renderY, width, height, null);
/*  65 */       g.setColor(Game.buttonClickedColor);
/*  66 */       g.drawString(buttonText, renderX + state1Image.getWidth() / 2 - 
/*  67 */           this.fm.stringWidth(buttonText) / 2, 
/*  68 */           renderY + state1Image.getHeight() / 2 + 5);
/*  70 */       if (clickEventType == 1.1D) {
/*     */         try {
/*  72 */           if (MainMenu.currentProfile == 1)
/*  73 */             Save.profileSave(Save.save1, Game.save1Path, 1); 
/*  74 */           if (MainMenu.currentProfile == 2)
/*  75 */             Save.profileSave(Save.save2, Game.save2Path, 2); 
/*  76 */           if (MainMenu.currentProfile == 3)
/*  77 */             Save.profileSave(Save.save3, Game.save3Path, 3); 
/*  78 */           Save.dataSave();
/*  79 */         } catch (IOException e) {
/*  80 */           e.printStackTrace();
/*     */         } 
/*  82 */         isOpen = false;
/*  83 */         Game.isInGame = false;
/*  84 */         Game.endClick();
/*  85 */         saveAndQuitState = 1;
/*  86 */         MainMenu.menuState = 1;
/*  87 */         MainMenu.currentProfile = 0;
/*  88 */       } else if (clickEventType == 1.2D) {
/*  89 */         isOpen = false;
/*  90 */         backToGameState = 1;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void renderMain(Graphics g) {
/*  97 */     g.setColor(new Color(0, 0, 0, 145));
/*  98 */     g.fillRect(0, 0, 838, 573);
/* 100 */     g.setColor(Color.white);
/* 101 */     g.setFont(Game.buttonTextFont);
/* 105 */     g.drawImage(ImageManager.button1_1, 251, 168, 160, 32, null);
/* 106 */     g.drawImage(ImageManager.button1_1, 427, 168, 160, 32, null);
/* 108 */     g.drawImage(ImageManager.button1_1, 251, 268, 160, 32, null);
/* 109 */     g.drawImage(ImageManager.button1_1, 427, 268, 160, 32, null);
/* 111 */     g.setColor(Color.gray);
/* 112 */     g.setFont(Game.profileInfoFont);
/* 113 */     g.drawString("More stuff will be added here in the future.", 278, 440);
/* 115 */     drawButton(g, saveAndQuitState, 419 - 
/* 116 */         ImageManager.button2_1.getWidth() / 2, 316, ImageManager.button2_1.getWidth(), 
/* 117 */         ImageManager.button2_1.getHeight(), 
/* 118 */         "Save and Quit to Title", ImageManager.button2_1, ImageManager.button2_2, 
/* 119 */         ImageManager.button2_3, 1.1D);
/* 121 */     drawButton(g, backToGameState, 419 - 
/* 122 */         ImageManager.button2_1.getWidth() / 2, 120, ImageManager.button2_1.getWidth(), 
/* 123 */         ImageManager.button2_1.getHeight(), "Back to Game", ImageManager.button2_1, 
/* 124 */         ImageManager.button2_2, ImageManager.button2_3, 1.2D);
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.6_2.jar!\beyondOrigins\main\menus\PauseMenu.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */