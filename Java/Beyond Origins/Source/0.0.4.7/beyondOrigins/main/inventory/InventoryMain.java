/*    */ package beyondOrigins.main.inventory;
/*    */ 
/*    */ import beyondOrigins.main.MouseManager;
/*    */ import beyondOrigins.main.MouseMotion;
/*    */ import beyondOrigins.main.gfx.ImageManager;
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
/* 18 */   private static int tabSelection = 0;
/*    */   
/*    */   public InventoryMain(ImageManager im) {
/* 21 */     this.im = im;
/*    */   }
/*    */   
/*    */   public static void init() {
/* 25 */     tabs1X = 243;
/* 26 */     tabs2X = 308;
/* 27 */     tabs3X = 373;
/* 28 */     yesno1X = 509;
/* 29 */     yesno1Y = 263;
/*    */   }
/*    */   
/*    */   public void tick() {
/* 33 */     if (MouseMotion.mouseX >= 248 && MouseMotion.mouseX <= 300 && 
/* 34 */       MouseMotion.mouseY >= 145 && MouseMotion.mouseY <= 169 && 
/* 35 */       MouseManager.mouseFullClick == 1)
/* 36 */       tabSelection = 1; 
/* 38 */     if (MouseMotion.mouseX >= 313 && MouseMotion.mouseX <= 365 && 
/* 39 */       MouseMotion.mouseY >= 145 && MouseMotion.mouseY <= 169 && 
/* 40 */       MouseManager.mouseFullClick == 1)
/* 41 */       tabSelection = 2; 
/* 43 */     if (MouseMotion.mouseX >= 378 && MouseMotion.mouseX <= 430 && 
/* 44 */       MouseMotion.mouseY >= 145 && MouseMotion.mouseY <= 169 && 
/* 45 */       MouseManager.mouseFullClick == 1)
/* 46 */       tabSelection = 3; 
/*    */   }
/*    */   
/*    */   public void render(Graphics g) {
/* 51 */     if (invOpen) {
/* 52 */       g.setColor(new Color(0, 0, 0, 145));
/* 53 */       g.fillRect(0, 0, 838, 1146);
/* 54 */       if (tabSelection == 0 || tabSelection == 1) {
/* 55 */         g.drawImage(this.im.inventory1, 210, 135, 416, 288, null);
/* 56 */         g.drawImage(this.im.tabs01, tabs1X, 135, 64, 64, null);
/* 57 */         g.drawImage(this.im.tabs12, tabs2X, 135, 64, 64, null);
/* 58 */         g.drawImage(this.im.tabs13, tabs3X, 135, 64, 64, null);
/*    */       } 
/* 60 */       if (tabSelection == 2) {
/* 61 */         g.drawImage(this.im.inventory2, 210, 135, 416, 288, null);
/* 62 */         g.drawImage(this.im.tabs11, tabs1X, 135, 64, 64, null);
/* 63 */         g.drawImage(this.im.tabs02, tabs2X, 135, 64, 64, null);
/* 64 */         g.drawImage(this.im.tabs13, tabs3X, 135, 64, 64, null);
/*    */       } 
/* 66 */       if (tabSelection == 3) {
/* 67 */         g.drawImage(this.im.inventory3, 210, 135, 416, 288, null);
/* 68 */         g.drawImage(this.im.tabs11, tabs1X, 135, 64, 64, null);
/* 69 */         g.drawImage(this.im.tabs12, tabs2X, 135, 64, 64, null);
/* 70 */         g.drawImage(this.im.tabs03, tabs3X, 135, 64, 64, null);
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.4.7.jar!\beyondOrigins\main\inventory\InventoryMain.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */