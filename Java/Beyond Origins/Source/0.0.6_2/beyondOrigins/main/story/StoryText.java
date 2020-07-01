/*    */ package beyondOrigins.main.story;
/*    */ 
/*    */ import beyondOrigins.main.Game;
/*    */ import beyondOrigins.userInput.KeyManager;
/*    */ import java.awt.Color;
/*    */ import java.awt.FontMetrics;
/*    */ import java.awt.Graphics;
/*    */ 
/*    */ public class StoryText {
/*    */   String name;
/*    */   
/*    */   private static String l1;
/*    */   
/*    */   private static String l2;
/*    */   
/*    */   private static String l3;
/*    */   
/*    */   private static String l4;
/*    */   
/*    */   private static String l5;
/*    */   
/*    */   private static String l6;
/*    */   
/*    */   private static String l7;
/*    */   
/*    */   private static Thread t;
/*    */   
/*    */   private static FontMetrics fm;
/*    */   
/* 16 */   public static int overlay = 255;
/*    */   
/*    */   public static boolean requested = false, forward = false;
/*    */   
/*    */   public static void request(String line1, String line2, String line3, String line4, String line5, String line6, String line7) {
/* 26 */     l1 = line1;
/* 27 */     l2 = line2;
/* 28 */     l3 = line3;
/* 29 */     l4 = line4;
/* 30 */     l5 = line5;
/* 31 */     l6 = line6;
/* 32 */     l7 = line7;
/* 33 */     requested = true;
/*    */   }
/*    */   
/*    */   public static void render(Graphics g) throws InterruptedException {
/* 37 */     g.setColor(Color.black);
/* 38 */     g.fillRect(0, 0, 838, 573);
/* 39 */     g.setFont(Game.buttonTextFont);
/* 40 */     fm = g.getFontMetrics(Game.buttonTextFont);
/* 41 */     g.setColor(Color.white);
/* 42 */     g.drawString(l1, 419 - fm.stringWidth(l1) / 2, 110);
/* 43 */     g.drawString(l2, 419 - fm.stringWidth(l2) / 2, 155);
/* 44 */     g.drawString(l3, 419 - fm.stringWidth(l3) / 2, 200);
/* 45 */     g.drawString(l4, 419 - fm.stringWidth(l4) / 2, 245);
/* 46 */     g.drawString(l5, 419 - fm.stringWidth(l5) / 2, 290);
/* 47 */     g.drawString(l6, 419 - fm.stringWidth(l6) / 2, 335);
/* 48 */     g.drawString(l7, 419 - fm.stringWidth(l7) / 2, 380);
/* 50 */     g.drawString("Press enter to continue...", 600, 535);
/* 51 */     if (overlay != 0)
/* 52 */       overlay--; 
/* 54 */     Color c = new Color(0, 0, 0, overlay);
/* 55 */     g.setColor(c);
/* 56 */     g.fillRect(0, 0, 838, 573);
/* 57 */     if (overlay == 0 && !forward) {
/* 58 */       Thread.sleep(2000L);
/* 59 */       forward = true;
/*    */     } 
/* 61 */     if (forward && KeyManager.enterPressed) {
/* 62 */       overlay = 255;
/* 63 */       requested = false;
/* 64 */       forward = false;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.6_2.jar!\beyondOrigins\main\story\StoryText.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */