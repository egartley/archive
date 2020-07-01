/*    */ package beyondOrigins.main.inventory;
/*    */ 
/*    */ import beyondOrigins.main.Game;
/*    */ import beyondOrigins.main.gfx.ImageManager;
/*    */ import beyondOrigins.userInput.MouseMotion;
/*    */ import java.awt.Color;
/*    */ import java.awt.Graphics;
/*    */ import java.awt.image.BufferedImage;
/*    */ 
/*    */ public class Inventory {
/*    */   public static boolean invOpen = false;
/*    */   
/* 13 */   public static int tabSelection = 1;
/*    */   
/*    */   public static int tab1State;
/*    */   
/*    */   public static int tab2State;
/*    */   
/*    */   public static int tab3State;
/*    */   
/*    */   public int getTabState(int x, int y, int w, int h, int state, int tabNumber) {
/* 19 */     if (MouseMotion.mouseX >= x && MouseMotion.mouseX < x + w && 
/* 20 */       MouseMotion.mouseY >= y && MouseMotion.mouseY < y + h && 
/* 21 */       Game.mouseIsPressed()) {
/* 22 */       if (tabNumber == 1) {
/* 23 */         tab1State = 2;
/* 24 */         tab2State = 1;
/* 25 */         tab3State = 1;
/* 26 */       } else if (tabNumber == 2) {
/* 27 */         tab2State = 2;
/* 28 */         tab3State = 1;
/* 29 */         tab1State = 1;
/* 30 */       } else if (tabNumber == 3) {
/* 31 */         tab3State = 2;
/* 32 */         tab2State = 1;
/* 33 */         tab1State = 1;
/*    */       } 
/* 35 */       tabSelection = tabNumber;
/*    */     } 
/* 37 */     return state;
/*    */   }
/*    */   
/*    */   public void drawTab(Graphics g, int x, int y, int w, int h, int tabNumber, BufferedImage imageSelected, BufferedImage imageUnSelected, boolean includeInventory) {
/* 43 */     g.drawImage(imageUnSelected, x, y, w, h, null);
/* 44 */     if (getTabState(x, y, w, h, tabSelection, tabNumber) == tabNumber)
/* 45 */       g.drawImage(imageSelected, x, y, w, h, null); 
/*    */   }
/*    */   
/*    */   public void tick() {}
/*    */   
/*    */   public void render(Graphics g) {
/* 57 */     if (invOpen) {
/* 58 */       g.setColor(new Color(0, 0, 0, 145));
/* 59 */       g.fillRect(0, 0, 838, 1146);
/* 60 */       if (tabSelection == 1)
/* 61 */         g.drawImage(ImageManager.inventory1, 
/* 62 */             419 - ImageManager.inventory1.getWidth() / 2, 135, null); 
/* 64 */       if (tabSelection == 2)
/* 65 */         g.drawImage(ImageManager.inventory2, 
/* 66 */             419 - ImageManager.inventory1.getWidth() / 2, 135, null); 
/* 68 */       if (tabSelection == 3)
/* 69 */         g.drawImage(ImageManager.inventory3, 
/* 70 */             419 - ImageManager.inventory1.getWidth() / 2, 135, null); 
/* 72 */       drawTab(g, 243, 135, 64, 64, 1, ImageManager.tabs01, ImageManager.tabs11, 
/* 73 */           true);
/* 74 */       drawTab(g, 308, 135, 64, 64, 2, ImageManager.tabs02, ImageManager.tabs12, 
/* 75 */           true);
/* 76 */       drawTab(g, 373, 135, 64, 64, 3, ImageManager.tabs03, ImageManager.tabs13, 
/* 77 */           true);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.6_4.jar!\beyondOrigins\main\inventory\Inventory.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */