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
/*    */ public class Dialogue {
/*    */   private static ImageManager im;
/*    */   
/*    */   private static FontMetrics fm;
/*    */   
/*    */   public Dialogue(ImageManager im) {
/* 18 */     Dialogue.im = im;
/*    */   }
/*    */   
/*    */   public static int getState(int state, int maxStateValue) {
/* 22 */     if (KeyManager.enterPressed && state < maxStateValue && state != 0) {
/* 23 */       state++;
/* 24 */       KeyManager.enterPressed = false;
/*    */     } 
/* 26 */     if (KeyManager.enterPressed && state == maxStateValue)
/* 27 */       state = 0; 
/* 29 */     return state;
/*    */   }
/*    */   
/*    */   public static void drawDialogue(Graphics g, BufferedImage icon, String name, String line1, String line2, String line3, String line4) {
/* 34 */     fm = g.getFontMetrics(Game.profileInfoFont);
/* 35 */     g.drawImage(im.dialogueBox, 419 - 
/* 36 */         im.dialogueBox.getWidth() / 2, 573 - 
/* 37 */         im.dialogueBox.getHeight() + 32, null);
/* 38 */     g.setColor(Color.white);
/* 39 */     g.setFont(Game.profileInfoFont);
/* 40 */     g.drawImage(icon, 210, 425, null);
/* 41 */     g.drawString(name, 226 - fm.stringWidth(name) / 2, 476);
/* 42 */     g.drawString(line1, 285, 427);
/* 43 */     g.drawString(line2, 285, 452);
/* 44 */     g.drawString(line3, 285, 477);
/* 45 */     g.drawString(line4, 285, 502);
/*    */   }
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.5_5.jar!\beyondOrigins\threads\Dialogue.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */