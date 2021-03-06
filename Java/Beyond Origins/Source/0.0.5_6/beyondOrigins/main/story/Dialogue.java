/*    */ package beyondOrigins.main.story;
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
/*    */   private static FontMetrics fm;
/*    */   
/*    */   public static int getState(int state, int maxStateValue) {
/* 21 */     if (KeyManager.enterPressed && state < maxStateValue && state != 0) {
/* 22 */       state++;
/* 23 */       KeyManager.enterPressed = false;
/*    */     } 
/* 25 */     if (KeyManager.enterPressed && state == maxStateValue)
/* 26 */       state = 0; 
/* 28 */     return state;
/*    */   }
/*    */   
/*    */   public static void drawDialogue(Graphics g, BufferedImage icon, String name, String line1, String line2, String line3, String line4) {
/* 33 */     fm = g.getFontMetrics(Game.profileInfoFont);
/* 34 */     g.drawImage(ImageManager.dialogueBox, 419 - 
/* 35 */         ImageManager.dialogueBox.getWidth() / 2, 573 - 
/* 36 */         ImageManager.dialogueBox.getHeight() + 32, null);
/* 37 */     g.setColor(Color.white);
/* 38 */     g.setFont(Game.profileInfoFont);
/* 39 */     g.drawImage(icon, 210, 425, null);
/* 40 */     g.drawString(name, 226 - fm.stringWidth(name) / 2, 476);
/* 41 */     g.drawString(line1, 285, 427);
/* 42 */     g.drawString(line2, 285, 452);
/* 43 */     g.drawString(line3, 285, 477);
/* 44 */     g.drawString(line4, 285, 502);
/*    */   }
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.5_6.jar!\beyondOrigins\main\story\Dialogue.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */