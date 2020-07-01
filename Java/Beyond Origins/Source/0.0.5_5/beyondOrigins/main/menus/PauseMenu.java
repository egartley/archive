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
/*     */   private static ImageManager im;
/*     */   
/*     */   public PauseMenu(ImageManager im) {
/*  25 */     PauseMenu.im = im;
/*     */   }
/*     */   
/*     */   public void tick() {}
/*     */   
/*     */   public int getButtonState(int minX, int minY, int width, int height, int state) {
/*  34 */     if (MouseMotion.mouseX >= minX && MouseMotion.mouseX < minX + width && 
/*  35 */       MouseMotion.mouseY >= minY && 
/*  36 */       MouseMotion.mouseY < minY + height) {
/*  37 */       state = 2;
/*  38 */       if (Game.isPressed()) {
/*  39 */         state = 3;
/*     */       } else {
/*  41 */         state = 2;
/*     */       } 
/*     */     } else {
/*  43 */       state = 1;
/*     */     } 
/*  44 */     return state;
/*     */   }
/*     */   
/*     */   public void drawButton(Graphics g, int state, int renderX, int renderY, int width, int height, String buttonText, BufferedImage state1Image, BufferedImage state2Image, BufferedImage state3Image, double clickEventType) {
/*  51 */     this.fm = g.getFontMetrics(Game.buttonTextFont);
/*  52 */     g.setFont(Game.buttonTextFont);
/*  53 */     if (getButtonState(renderX, renderY, width, height, state) == 1) {
/*  54 */       g.drawImage(state1Image, renderX, renderY, width, height, null);
/*  55 */       g.setColor(Game.buttonIdleColor);
/*  56 */       g.drawString(buttonText, renderX + state1Image.getWidth() / 2 - 
/*  57 */           this.fm.stringWidth(buttonText) / 2, 
/*  58 */           renderY + state1Image.getHeight() / 2 + 5);
/*  59 */     } else if (getButtonState(renderX, renderY, width, height, state) == 2) {
/*  60 */       g.drawImage(state2Image, renderX, renderY, width, height, null);
/*  61 */       g.setColor(Game.buttonSelectedColor);
/*  62 */       g.drawString(buttonText, renderX + state1Image.getWidth() / 2 - 
/*  63 */           this.fm.stringWidth(buttonText) / 2, 
/*  64 */           renderY + state1Image.getHeight() / 2 + 5);
/*  65 */     } else if (getButtonState(renderX, renderY, width, height, state) == 3) {
/*  66 */       g.drawImage(state3Image, renderX, renderY, width, height, null);
/*  67 */       g.setColor(Game.buttonClickedColor);
/*  68 */       g.drawString(buttonText, renderX + state1Image.getWidth() / 2 - 
/*  69 */           this.fm.stringWidth(buttonText) / 2, 
/*  70 */           renderY + state1Image.getHeight() / 2 + 5);
/*  72 */       if (clickEventType == 1.1D) {
/*     */         try {
/*  74 */           if (MainMenu.currentProfile == 1)
/*  75 */             Save.profileSave(Save.save1, Game.save1Path, 1); 
/*  76 */           if (MainMenu.currentProfile == 2)
/*  77 */             Save.profileSave(Save.save2, Game.save2Path, 2); 
/*  78 */           if (MainMenu.currentProfile == 3)
/*  79 */             Save.profileSave(Save.save3, Game.save3Path, 3); 
/*  80 */           Save.dataSave();
/*  81 */         } catch (IOException e) {
/*  82 */           e.printStackTrace();
/*     */         } 
/*  84 */         isOpen = false;
/*  85 */         Game.isInGame = false;
/*  86 */         Game.endClick();
/*  87 */         saveAndQuitState = 1;
/*  88 */         MainMenu.menuState = 1;
/*  89 */         MainMenu.currentProfile = 0;
/*  90 */       } else if (clickEventType == 1.2D) {
/*  91 */         isOpen = false;
/*  92 */         backToGameState = 1;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void renderMain(Graphics g) {
/*  99 */     g.setColor(new Color(0, 0, 0, 145));
/* 100 */     g.fillRect(0, 0, 838, 573);
/* 102 */     g.setColor(Color.white);
/* 103 */     g.setFont(Game.buttonTextFont);
/* 107 */     g.drawImage(im.button1_1, 251, 168, 160, 32, null);
/* 108 */     g.drawImage(im.button1_1, 427, 168, 160, 32, null);
/* 110 */     g.drawImage(im.button1_1, 251, 268, 160, 32, null);
/* 111 */     g.drawImage(im.button1_1, 427, 268, 160, 32, null);
/* 113 */     g.setColor(Color.gray);
/* 114 */     g.setFont(Game.profileInfoFont);
/* 115 */     g.drawString("More stuff will be added here in the future.", 278, 440);
/* 117 */     drawButton(g, saveAndQuitState, 419 - 
/* 118 */         im.button2_1.getWidth() / 2, 316, im.button2_1.getWidth(), 
/* 119 */         im.button2_1.getHeight(), 
/* 120 */         "Save and Quit to Title", im.button2_1, im.button2_2, 
/* 121 */         im.button2_3, 1.1D);
/* 123 */     drawButton(g, backToGameState, 419 - 
/* 124 */         im.button2_1.getWidth() / 2, 120, im.button2_1.getWidth(), 
/* 125 */         im.button2_1.getHeight(), "Back to Game", im.button2_1, 
/* 126 */         im.button2_2, im.button2_3, 1.2D);
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.5_5.jar!\beyondOrigins\main\menus\PauseMenu.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */