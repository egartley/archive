/*    */ package beyondOrigins.threads;
/*    */ 
/*    */ import beyondOrigins.main.Game;
/*    */ import beyondOrigins.userInput.KeyManager;
/*    */ import java.awt.Color;
/*    */ import java.awt.FontMetrics;
/*    */ import java.awt.Graphics;
/*    */ 
/*    */ public class StoryText implements Runnable {
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
/*    */   public StoryText(String threadName) {
/* 21 */     this.name = threadName;
/* 22 */     t = new Thread(this, this.name);
/* 23 */     t.start();
/*    */   }
/*    */   
/*    */   public void run() {
/*    */     do {
/*    */     
/* 27 */     } while (Game.running);
/*    */   }
/*    */   
/*    */   public static void request(String line1, String line2, String line3, String line4, String line5, String line6, String line7) {
/* 34 */     l1 = line1;
/* 35 */     l2 = line2;
/* 36 */     l3 = line3;
/* 37 */     l4 = line4;
/* 38 */     l5 = line5;
/* 39 */     l6 = line6;
/* 40 */     l7 = line7;
/* 41 */     requested = true;
/*    */   }
/*    */   
/*    */   public static void render(Graphics g) throws InterruptedException {
/* 45 */     g.setColor(Color.black);
/* 46 */     g.fillRect(0, 0, 838, 573);
/* 47 */     g.setFont(Game.buttonTextFont);
/* 48 */     fm = g.getFontMetrics(Game.buttonTextFont);
/* 49 */     g.setColor(Color.white);
/* 50 */     g.drawString(l1, 419 - fm.stringWidth(l1) / 2, 110);
/* 51 */     g.drawString(l2, 419 - fm.stringWidth(l2) / 2, 155);
/* 52 */     g.drawString(l3, 419 - fm.stringWidth(l3) / 2, 200);
/* 53 */     g.drawString(l4, 419 - fm.stringWidth(l4) / 2, 245);
/* 54 */     g.drawString(l5, 419 - fm.stringWidth(l5) / 2, 290);
/* 55 */     g.drawString(l6, 419 - fm.stringWidth(l6) / 2, 335);
/* 56 */     g.drawString(l7, 419 - fm.stringWidth(l7) / 2, 380);
/* 58 */     g.drawString("Press enter to continue...", 600, 535);
/* 59 */     if (overlay != 0)
/* 60 */       overlay--; 
/* 62 */     Color c = new Color(0, 0, 0, overlay);
/* 63 */     g.setColor(c);
/* 64 */     g.fillRect(0, 0, 838, 573);
/* 65 */     if (overlay == 0 && !forward) {
/* 66 */       Thread.sleep(2000L);
/* 67 */       forward = true;
/*    */     } 
/* 69 */     if (forward && KeyManager.enterPressed) {
/* 70 */       overlay = 255;
/* 71 */       requested = false;
/* 72 */       forward = false;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.5_3.jar!\beyondOrigins\threads\StoryText.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */