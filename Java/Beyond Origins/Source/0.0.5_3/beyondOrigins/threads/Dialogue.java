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
/*    */   public static int getState(int state, int maxStateValue) {
/* 18 */     if (KeyManager.enterPressed && state < maxStateValue && state != 0) {
/* 19 */       state++;
/* 20 */       KeyManager.enterPressed = false;
/*    */     } 
/* 22 */     if (KeyManager.enterPressed && state == maxStateValue)
/* 23 */       state = 0; 
/* 25 */     return state;
/*    */   }
/*    */   
/*    */   public static void drawDialogue(Graphics g, BufferedImage icon, String name, String line1, String line2, String line3, String line4) {
/* 30 */     fm = g.getFontMetrics(Game.profileInfoFont);
/* 31 */     g.drawImage(im.dialogueBox, 419 - 
/* 32 */         im.dialogueBox.getWidth() / 2, 573 - 
/* 33 */         im.dialogueBox.getHeight() + 32, null);
/* 34 */     g.setColor(Color.white);
/* 35 */     g.setFont(Game.profileInfoFont);
/* 36 */     g.drawImage(icon, 210, 425, null);
/* 37 */     g.drawString(name, 226 - fm.stringWidth(name) / 2, 476);
/* 38 */     g.drawString(line1, 285, 427);
/* 39 */     g.drawString(line2, 285, 452);
/* 40 */     g.drawString(line3, 285, 477);
/* 41 */     g.drawString(line4, 285, 502);
/*    */   }
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.5_3.jar!\beyondOrigins\threads\Dialogue.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */