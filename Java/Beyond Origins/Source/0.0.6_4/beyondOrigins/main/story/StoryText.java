/*    */ package beyondOrigins.main.story;
/*    */ 
/*    */ import beyondOrigins.main.Game;
/*    */ import beyondOrigins.userInput.KeyManager;
/*    */ import java.awt.Color;
/*    */ import java.awt.FontMetrics;
/*    */ import java.awt.Graphics;
/*    */ 
/*    */ public class StoryText {
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
/*    */   private static FontMetrics fm;
/*    */   
/* 14 */   public static int overlay = 255;
/*    */   
/*    */   public static boolean requested = false, forward = false;
/*    */   
/*    */   public static void request(String line1, String line2, String line3, String line4, String line5, String line6, String line7) {
/* 20 */     l1 = line1;
/* 21 */     l2 = line2;
/* 22 */     l3 = line3;
/* 23 */     l4 = line4;
/* 24 */     l5 = line5;
/* 25 */     l6 = line6;
/* 26 */     l7 = line7;
/* 27 */     requested = true;
/*    */   }
/*    */   
/*    */   public static void render(Graphics g) throws InterruptedException {
/* 31 */     g.setColor(Color.black);
/* 32 */     g.fillRect(0, 0, 838, 573);
/* 33 */     g.setFont(Game.buttonTextFont);
/* 34 */     fm = g.getFontMetrics(Game.buttonTextFont);
/* 35 */     g.setColor(Color.white);
/* 36 */     g.drawString(l1, 419 - fm.stringWidth(l1) / 2, 110);
/* 37 */     g.drawString(l2, 419 - fm.stringWidth(l2) / 2, 155);
/* 38 */     g.drawString(l3, 419 - fm.stringWidth(l3) / 2, 200);
/* 39 */     g.drawString(l4, 419 - fm.stringWidth(l4) / 2, 245);
/* 40 */     g.drawString(l5, 419 - fm.stringWidth(l5) / 2, 290);
/* 41 */     g.drawString(l6, 419 - fm.stringWidth(l6) / 2, 335);
/* 42 */     g.drawString(l7, 419 - fm.stringWidth(l7) / 2, 380);
/* 44 */     g.drawString("Press enter to continue...", 600, 535);
/* 45 */     if (overlay != 0)
/* 46 */       overlay--; 
/* 48 */     Color c = new Color(0, 0, 0, overlay);
/* 49 */     g.setColor(c);
/* 50 */     g.fillRect(0, 0, 838, 573);
/* 51 */     if (overlay == 0 && !forward) {
/* 52 */       Thread.sleep(2000L);
/* 53 */       forward = true;
/*    */     } 
/* 55 */     if (forward && KeyManager.enterPressed) {
/* 56 */       overlay = 255;
/* 57 */       requested = false;
/* 58 */       forward = false;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.6_4.jar!\beyondOrigins\main\story\StoryText.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */