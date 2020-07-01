/*    */ package beyondOrigins.main.inventory;
/*    */ 
/*    */ import beyondOrigins.main.Game;
/*    */ import beyondOrigins.main.gfx.ImageManager;
/*    */ import beyondOrigins.main.quests.Quest;
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
/*    */   public Inventory() {
/* 18 */     Quest.init();
/*    */   }
/*    */   
/*    */   public int getTabState(int x, int y, int w, int h, int state, int tabNumber) {
/* 24 */     if (MouseMotion.mouseX >= x && MouseMotion.mouseX < x + w && 
/* 25 */       MouseMotion.mouseY >= y && MouseMotion.mouseY < y + h - 28 && 
/* 26 */       Game.mouseIsPressed()) {
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
/* 59 */     if (invOpen) {
/* 60 */       g.setColor(new Color(0, 0, 0, 127));
/* 61 */       g.fillRect(0, 0, Game.width, Game.height);
/* 62 */       if (tabSelection == 1)
/* 63 */         g.drawImage(ImageManager.inventory1, 
/* 64 */             419 - ImageManager.inventory1.getWidth() / 2, 135, null); 
/* 66 */       if (tabSelection == 2) {
/* 67 */         g.drawImage(ImageManager.inventory2, 
/* 68 */             419 - ImageManager.inventory1.getWidth() / 2, 135, null);
/* 69 */         Quest.getActiveQuest().render(g);
/*    */       } 
/* 71 */       if (tabSelection == 3)
/* 72 */         g.drawImage(ImageManager.inventory3, 
/* 73 */             419 - ImageManager.inventory1.getWidth() / 2, 135, null); 
/* 75 */       drawTab(g, 243, 135, 64, 64, 1, ImageManager.tab1_1, ImageManager.tab1_2, 
/* 76 */           true);
/* 77 */       drawTab(g, 308, 135, 64, 64, 2, ImageManager.tab2_1, ImageManager.tab2_2, 
/* 78 */           true);
/* 79 */       drawTab(g, 373, 135, 64, 64, 3, ImageManager.tab3_1, ImageManager.tab3_2, 
/* 80 */           true);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.9_3.jar!\beyondOrigins\main\inventory\Inventory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */