/*    */ package applecraft.testgame.main.inventory;
/*    */ 
/*    */ import applecraft.testgame.main.MouseManager;
/*    */ import applecraft.testgame.main.MouseMotion;
/*    */ import applecraft.testgame.main.gfx.ImageManager;
/*    */ import java.awt.Color;
/*    */ import java.awt.Graphics;
/*    */ 
/*    */ public class InventoryMain {
/*    */   private ImageManager im;
/*    */   
/*    */   private static int tabs1X;
/*    */   
/*    */   private static int tabs2X;
/*    */   
/*    */   private static int tabs3X;
/*    */   
/*    */   private static int yesno1X;
/*    */   
/*    */   private static int yesno1Y;
/*    */   
/*    */   public static boolean invOpen = false;
/*    */   
/* 19 */   private static int tabSelection = 0;
/*    */   
/*    */   public InventoryMain(ImageManager im) {
/* 22 */     this.im = im;
/*    */   }
/*    */   
/*    */   public static void init() {
/* 26 */     tabs1X = 243;
/* 27 */     tabs2X = 308;
/* 28 */     tabs3X = 373;
/* 29 */     yesno1X = 509;
/* 30 */     yesno1Y = 263;
/*    */   }
/*    */   
/*    */   public void tick() {
/* 35 */     if (MouseMotion.mouseX >= 248 && MouseMotion.mouseX <= 300 && 
/* 36 */       MouseMotion.mouseY >= 145 && MouseMotion.mouseY <= 169 && MouseManager.mouseFullClick == 1)
/* 37 */       tabSelection = 1; 
/* 40 */     if (MouseMotion.mouseX >= 313 && MouseMotion.mouseX <= 365 && 
/* 41 */       MouseMotion.mouseY >= 145 && MouseMotion.mouseY <= 169 && MouseManager.mouseFullClick == 1)
/* 42 */       tabSelection = 2; 
/* 45 */     if (MouseMotion.mouseX >= 378 && MouseMotion.mouseX <= 430 && 
/* 46 */       MouseMotion.mouseY >= 145 && MouseMotion.mouseY <= 169 && MouseManager.mouseFullClick == 1)
/* 47 */       tabSelection = 3; 
/*    */   }
/*    */   
/*    */   public void render(Graphics g) {
/* 54 */     if (invOpen) {
/* 56 */       g.setColor(new Color(0, 0, 0, 145));
/* 57 */       g.fillRect(0, 0, 838, 1146);
/* 59 */       if (tabSelection == 0 || tabSelection == 1) {
/* 61 */         g.drawImage(this.im.inventory1, 210, 135, 416, 288, null);
/* 62 */         g.drawImage(this.im.tabs01, tabs1X, 135, 64, 64, null);
/* 63 */         g.drawImage(this.im.tabs12, tabs2X, 135, 64, 64, null);
/* 64 */         g.drawImage(this.im.tabs13, tabs3X, 135, 64, 64, null);
/*    */       } 
/* 68 */       if (tabSelection == 2) {
/* 70 */         g.drawImage(this.im.inventory2, 210, 135, 416, 288, null);
/* 71 */         g.drawImage(this.im.tabs11, tabs1X, 135, 64, 64, null);
/* 72 */         g.drawImage(this.im.tabs02, tabs2X, 135, 64, 64, null);
/* 73 */         g.drawImage(this.im.tabs13, tabs3X, 135, 64, 64, null);
/*    */       } 
/* 77 */       if (tabSelection == 3) {
/* 79 */         g.drawImage(this.im.inventory3, 210, 135, 416, 288, null);
/* 80 */         g.drawImage(this.im.tabs11, tabs1X, 135, 64, 64, null);
/* 81 */         g.drawImage(this.im.tabs12, tabs2X, 135, 64, 64, null);
/* 82 */         g.drawImage(this.im.tabs03, tabs3X, 135, 64, 64, null);
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.4.2_7.jar!\applecraft\testgame\main\inventory\InventoryMain.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */