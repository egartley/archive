/*    */ package beyondOrigins.threads;
/*    */ 
/*    */ import beyondOrigins.main.Game;
/*    */ import beyondOrigins.main.gfx.ImageManager;
/*    */ import beyondOrigins.userInput.KeyManager;
/*    */ import java.awt.Color;
/*    */ import java.awt.FontMetrics;
/*    */ import java.awt.Graphics;
/*    */ import java.awt.image.BufferedImage;
/*    */ 
/*    */ public class Dialogue implements Runnable {
/*    */   private static ImageManager im;
/*    */   
/*    */   private static FontMetrics fm;
/*    */   
/*    */   String name;
/*    */   
/*    */   Thread t;
/*    */   
/*    */   public Dialogue(String threadName, ImageManager im) {
/* 20 */     this.name = threadName;
/* 21 */     this.t = new Thread(this, this.name);
/* 22 */     System.out.println("New Thread: " + this.t);
/* 23 */     this.t.start();
/* 24 */     this.t.setPriority(2);
/* 26 */     Dialogue.im = im;
/*    */   }
/*    */   
/*    */   public void run() {
/*    */     do {
/*    */     
/* 31 */     } while (Game.running);
/*    */   }
/*    */   
/*    */   public static int getState(int state, int maxStateValue) {
/* 38 */     if (KeyManager.enterPressed && state < maxStateValue) {
/* 39 */       state++;
/* 40 */       KeyManager.enterPressed = false;
/*    */     } 
/* 42 */     if (KeyManager.enterPressed && state == maxStateValue)
/* 43 */       state = 0; 
/* 45 */     return state;
/*    */   }
/*    */   
/*    */   public static void drawDialogue(Graphics g, BufferedImage icon, String name, String line1, String line2, String line3, String line4) {
/* 50 */     fm = g.getFontMetrics(Game.profileInfoFont);
/* 51 */     g.drawImage(im.dialogueBox, 419 - 
/* 52 */         im.dialogueBox.getWidth() / 2, 573 - 
/* 53 */         im.dialogueBox.getHeight() + 32, null);
/* 54 */     g.setColor(Color.white);
/* 55 */     g.setFont(Game.profileInfoFont);
/* 56 */     g.drawImage(icon, 210, 425, null);
/* 57 */     g.drawString(name, 226 - fm.stringWidth(name) / 2, 476);
/* 58 */     g.drawString(line1, 285, 427);
/* 59 */     g.drawString(line2, 285, 452);
/* 60 */     g.drawString(line3, 285, 477);
/* 61 */     g.drawString(line4, 285, 502);
/*    */   }
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.5_2.jar!\beyondOrigins\threads\Dialogue.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */