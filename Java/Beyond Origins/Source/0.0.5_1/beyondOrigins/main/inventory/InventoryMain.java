/*    */ package beyondOrigins.main.inventory;
/*    */ 
/*    */ import beyondOrigins.main.gfx.ImageManager;
/*    */ import beyondOrigins.userInput.MouseManager;
/*    */ import beyondOrigins.userInput.MouseMotion;
/*    */ import java.awt.Color;
/*    */ import java.awt.Graphics;
/*    */ import java.awt.image.BufferedImage;
/*    */ 
/*    */ public class InventoryMain {
/*    */   private ImageManager im;
/*    */   
/*    */   public static boolean invOpen = false;
/*    */   
/* 15 */   public static int tabSelection = 1;
/*    */   
/*    */   public static int tab1State;
/*    */   
/*    */   public static int tab2State;
/*    */   
/*    */   public static int tab3State;
/*    */   
/*    */   public InventoryMain(ImageManager im) {
/* 19 */     this.im = im;
/*    */   }
/*    */   
/*    */   public int getTabState(int x, int y, int w, int h, int state, int tabNumber) {
/* 25 */     if (MouseMotion.mouseX >= x && MouseMotion.mouseX < x + w && 
/* 26 */       MouseMotion.mouseY >= y && MouseMotion.mouseY < y + h && 
/* 27 */       MouseManager.mouseFullClick == 1) {
/* 28 */       if (tabNumber == 1) {
/* 29 */         tab1State = 2;
/* 30 */         tab2State = 1;
/* 31 */         tab3State = 1;
/* 32 */       } else if (tabNumber == 2) {
/* 33 */         tab2State = 2;
/* 34 */         tab3State = 1;
/* 35 */         tab1State = 1;
/* 36 */       } else if (tabNumber == 3) {
/* 37 */         tab3State = 2;
/* 38 */         tab2State = 1;
/* 39 */         tab1State = 1;
/*    */       } 
/* 41 */       tabSelection = tabNumber;
/*    */     } 
/* 43 */     return state;
/*    */   }
/*    */   
/*    */   public void drawTab(Graphics g, int x, int y, int w, int h, int tabNumber, BufferedImage imageSelected, BufferedImage imageUnSelected, boolean includeInventory) {
/* 49 */     g.drawImage(imageUnSelected, x, y, w, h, null);
/* 50 */     if (getTabState(x, y, w, h, tabSelection, tabNumber) == tabNumber)
/* 51 */       g.drawImage(imageSelected, x, y, w, h, null); 
/*    */   }
/*    */   
/*    */   public void tick() {}
/*    */   
/*    */   public void render(Graphics g) {
/* 63 */     if (invOpen) {
/* 64 */       g.setColor(new Color(0, 0, 0, 145));
/* 65 */       g.fillRect(0, 0, 838, 1146);
/* 66 */       if (tabSelection == 1)
/* 67 */         g.drawImage(this.im.inventory1, 
/* 68 */             419 - this.im.inventory1.getWidth() / 2, 135, null); 
/* 70 */       if (tabSelection == 2)
/* 71 */         g.drawImage(this.im.inventory2, 
/* 72 */             419 - this.im.inventory1.getWidth() / 2, 135, null); 
/* 74 */       if (tabSelection == 3)
/* 75 */         g.drawImage(this.im.inventory3, 
/* 76 */             419 - this.im.inventory1.getWidth() / 2, 135, null); 
/* 78 */       drawTab(g, 243, 135, 64, 64, 1, this.im.tabs01, this.im.tabs11, 
/* 79 */           true);
/* 80 */       drawTab(g, 308, 135, 64, 64, 2, this.im.tabs02, this.im.tabs12, 
/* 81 */           true);
/* 82 */       drawTab(g, 373, 135, 64, 64, 3, this.im.tabs03, this.im.tabs13, 
/* 83 */           true);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.5_1.jar!\beyondOrigins\main\inventory\InventoryMain.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */