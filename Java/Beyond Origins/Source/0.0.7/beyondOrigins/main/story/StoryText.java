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
/*    */   public boolean requested = false;
/*    */   
/*    */   public boolean forward = false;
/*    */   
/*    */   public void request(String line1, String line2, String line3, String line4, String line5, String line6, String line7) {
/* 21 */     l1 = line1;
/* 22 */     l2 = line2;
/* 23 */     l3 = line3;
/* 24 */     l4 = line4;
/* 25 */     l5 = line5;
/* 26 */     l6 = line6;
/* 27 */     l7 = line7;
/* 28 */     this.requested = true;
/*    */   }
/*    */   
/*    */   public void render(Graphics g) throws InterruptedException {
/* 32 */     g.setColor(Color.black);
/* 33 */     g.fillRect(0, 0, Game.width / 2 * 2, 573);
/* 34 */     g.setFont(Game.buttonTextFont);
/* 35 */     fm = g.getFontMetrics(Game.buttonTextFont);
/* 36 */     g.setColor(Color.white);
/* 37 */     g.drawString(l1, Game.width / 2 - fm.stringWidth(l1) / 2, 110);
/* 38 */     g.drawString(l2, Game.width / 2 - fm.stringWidth(l2) / 2, 155);
/* 39 */     g.drawString(l3, Game.width / 2 - fm.stringWidth(l3) / 2, 200);
/* 40 */     g.drawString(l4, Game.width / 2 - fm.stringWidth(l4) / 2, 245);
/* 41 */     g.drawString(l5, Game.width / 2 - fm.stringWidth(l5) / 2, 290);
/* 42 */     g.drawString(l6, Game.width / 2 - fm.stringWidth(l6) / 2, 335);
/* 43 */     g.drawString(l7, Game.width / 2 - fm.stringWidth(l7) / 2, 380);
/* 45 */     g.drawString("Press enter to continue...", 600, 535);
/* 46 */     if (overlay != 0)
/* 47 */       overlay--; 
/* 49 */     Color c = new Color(0, 0, 0, overlay);
/* 50 */     g.setColor(c);
/* 51 */     g.fillRect(0, 0, Game.width / 2 * 2, 573);
/* 52 */     if (overlay == 0 && !this.forward) {
/* 53 */       Thread.sleep(2000L);
/* 54 */       this.forward = true;
/*    */     } 
/* 56 */     if (this.forward && KeyManager.enterPressed) {
/* 57 */       overlay = 255;
/* 58 */       this.requested = false;
/* 59 */       this.forward = false;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.7.jar!\beyondOrigins\main\story\StoryText.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */