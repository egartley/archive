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
/*     */   private int backToGameState;
/*     */   
/*     */   private int saveAndQuitState;
/*     */   
/*     */   public int getButtonState(int minX, int minY, int width, int height, int state) {
/*  23 */     if (MouseMotion.mouseX >= minX && MouseMotion.mouseX < minX + width && 
/*  24 */       MouseMotion.mouseY >= minY && 
/*  25 */       MouseMotion.mouseY < minY + height) {
/*  26 */       state = 2;
/*  27 */       if (Game.mouseIsPressed()) {
/*  28 */         state = 3;
/*     */       } else {
/*  30 */         state = 2;
/*     */       } 
/*     */     } else {
/*  32 */       state = 1;
/*     */     } 
/*  33 */     return state;
/*     */   }
/*     */   
/*     */   public void drawButton(Graphics g, int state, int renderX, int renderY, int width, int height, String buttonText, BufferedImage state1Image, BufferedImage state2Image, BufferedImage state3Image, double clickEventType) {
/*  40 */     this.fm = g.getFontMetrics(Game.buttonTextFont);
/*  41 */     g.setFont(Game.buttonTextFont);
/*  42 */     if (getButtonState(renderX, renderY, width, height, state) == 1) {
/*  43 */       g.drawImage(state1Image, renderX, renderY, width, height, null);
/*  44 */       g.setColor(Game.buttonIdleColor);
/*  45 */       g.drawString(buttonText, renderX + state1Image.getWidth() / 2 - 
/*  46 */           this.fm.stringWidth(buttonText) / 2, 
/*  47 */           renderY + state1Image.getHeight() / 2 + 5);
/*  48 */     } else if (getButtonState(renderX, renderY, width, height, state) == 2) {
/*  49 */       g.drawImage(state2Image, renderX, renderY, width, height, null);
/*  50 */       g.setColor(Game.buttonSelectedColor);
/*  51 */       g.drawString(buttonText, renderX + state1Image.getWidth() / 2 - 
/*  52 */           this.fm.stringWidth(buttonText) / 2, 
/*  53 */           renderY + state1Image.getHeight() / 2 + 5);
/*  54 */     } else if (getButtonState(renderX, renderY, width, height, state) == 3) {
/*  55 */       g.drawImage(state3Image, renderX, renderY, width, height, null);
/*  56 */       g.setColor(Game.buttonClickedColor);
/*  57 */       g.drawString(buttonText, renderX + state1Image.getWidth() / 2 - 
/*  58 */           this.fm.stringWidth(buttonText) / 2, 
/*  59 */           renderY + state1Image.getHeight() / 2 + 5);
/*  61 */       if (clickEventType == 1.1D) {
/*     */         try {
/*  63 */           if ((Game.getMainMenu()).currentProfile == 1)
/*  64 */             Save.profileSave(Save.save1, Game.save1Path, 1); 
/*  65 */           if ((Game.getMainMenu()).currentProfile == 2)
/*  66 */             Save.profileSave(Save.save2, Game.save2Path, 2); 
/*  67 */           if ((Game.getMainMenu()).currentProfile == 3)
/*  68 */             Save.profileSave(Save.save3, Game.save3Path, 3); 
/*  69 */           Save.dataSave();
/*  70 */         } catch (IOException e) {
/*  71 */           e.printStackTrace();
/*     */         } 
/*  73 */         isOpen = false;
/*  74 */         Game.isInGame = false;
/*  75 */         Game.endClick();
/*  76 */         this.saveAndQuitState = 1;
/*  77 */         (Game.getMainMenu()).menuState = 1;
/*  78 */         (Game.getMainMenu()).currentProfile = 0;
/*  79 */       } else if (clickEventType == 1.2D) {
/*  80 */         isOpen = false;
/*  81 */         this.backToGameState = 1;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void renderMain(Graphics g) {
/*  88 */     g.setColor(new Color(0, 0, 0, 145));
/*  89 */     g.fillRect(0, 0, 838, 573);
/*  91 */     g.setColor(Color.white);
/*  92 */     g.setFont(Game.buttonTextFont);
/*  96 */     g.drawImage(ImageManager.button1_1, 251, 168, 160, 32, null);
/*  97 */     g.drawImage(ImageManager.button1_1, 427, 168, 160, 32, null);
/*  99 */     g.drawImage(ImageManager.button1_1, 251, 268, 160, 32, null);
/* 100 */     g.drawImage(ImageManager.button1_1, 427, 268, 160, 32, null);
/* 102 */     g.setColor(Color.gray);
/* 103 */     g.setFont(Game.profileInfoFont);
/* 104 */     g.drawString("More stuff will be added here in the future.", 278, 440);
/* 106 */     drawButton(g, this.saveAndQuitState, 419 - 
/* 107 */         ImageManager.button2_1.getWidth() / 2, 316, ImageManager.button2_1.getWidth(), 
/* 108 */         ImageManager.button2_1.getHeight(), 
/* 109 */         "Save and Quit to Title", ImageManager.button2_1, ImageManager.button2_2, 
/* 110 */         ImageManager.button2_3, 1.1D);
/* 112 */     drawButton(g, this.backToGameState, 419 - 
/* 113 */         ImageManager.button2_1.getWidth() / 2, 120, ImageManager.button2_1.getWidth(), 
/* 114 */         ImageManager.button2_1.getHeight(), "Back to Game", ImageManager.button2_1, 
/* 115 */         ImageManager.button2_2, ImageManager.button2_3, 1.2D);
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.6_4.jar!\beyondOrigins\main\menus\PauseMenu.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */