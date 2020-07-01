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
/* 14 */   public static int tabSelection = 1;
/*    */   
/*    */   public static int tab1State;
/*    */   
/*    */   public static int tab2State;
/*    */   
/*    */   public static int tab3State;
/*    */   
/*    */   public int getTabState(int x, int y, int w, int h, int state, int tabNumber) {
/* 24 */     if (MouseMotion.mouseX >= x && MouseMotion.mouseX < x + w && 
/* 25 */       MouseMotion.mouseY >= y && MouseMotion.mouseY < y + h && 
/* 26 */       Game.isPressed()) {
/* 27 */       if (tabNumber == 1) {
/* 28 */         tab1State = 2;
/* 29 */         tab2State = 1;
/* 30 */         tab3State = 1;
/* 31 */       } else if (tabNumber == 2) {
/* 32 */         tab2State = 2;
/* 33 */         tab3State = 1;
/* 34 */         tab1State = 1;
/* 35 */       } else if (tabNumber == 3) {
/* 36 */         tab3State = 2;
/* 37 */         tab2State = 1;
/* 38 */         tab1State = 1;
/*    */       } 
/* 40 */       tabSelection = tabNumber;
/*    */     } 
/* 42 */     return state;
/*    */   }
/*    */   
/*    */   public void drawTab(Graphics g, int x, int y, int w, int h, int tabNumber, BufferedImage imageSelected, BufferedImage imageUnSelected, boolean includeInventory) {
/* 48 */     g.drawImage(imageUnSelected, x, y, w, h, null);
/* 49 */     if (getTabState(x, y, w, h, tabSelection, tabNumber) == tabNumber)
/* 50 */       g.drawImage(imageSelected, x, y, w, h, null); 
/*    */   }
/*    */   
/*    */   public void tick() {}
/*    */   
/*    */   public void render(Graphics g) {
/* 62 */     if (invOpen) {
/* 63 */       g.setColor(new Color(0, 0, 0, 145));
/* 64 */       g.fillRect(0, 0, 838, 1146);
/* 65 */       if (tabSelection == 1)
/* 66 */         g.drawImage(ImageManager.inventory1, 
/* 67 */             419 - ImageManager.inventory1.getWidth() / 2, 135, null); 
/* 69 */       if (tabSelection == 2)
/* 70 */         g.drawImage(ImageManager.inventory2, 
/* 71 */             419 - ImageManager.inventory1.getWidth() / 2, 135, null); 
/* 73 */       if (tabSelection == 3)
/* 74 */         g.drawImage(ImageManager.inventory3, 
/* 75 */             419 - ImageManager.inventory1.getWidth() / 2, 135, null); 
/* 77 */       drawTab(g, 243, 135, 64, 64, 1, ImageManager.tabs01, ImageManager.tabs11, 
/* 78 */           true);
/* 79 */       drawTab(g, 308, 135, 64, 64, 2, ImageManager.tabs02, ImageManager.tabs12, 
/* 80 */           true);
/* 81 */       drawTab(g, 373, 135, 64, 64, 3, ImageManager.tabs03, ImageManager.tabs13, 
/* 82 */           true);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.5_6.jar!\beyondOrigins\main\inventory\Inventory.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */