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
/* 17 */     if (KeyManager.enterPressed && state < maxStateValue && state != 0) {
/* 18 */       state++;
/* 19 */       KeyManager.enterPressed = false;
/*    */     } 
/* 21 */     if (KeyManager.enterPressed && state == maxStateValue)
/* 22 */       state = 0; 
/* 24 */     return state;
/*    */   }
/*    */   
/*    */   public static void drawDialogue(Graphics g, BufferedImage icon, String name, String line1, String line2, String line3, String line4) {
/* 29 */     fm = g.getFontMetrics(Game.profileInfoFont);
/* 30 */     g.drawImage(ImageManager.dialogueBox, 419 - 
/* 31 */         ImageManager.dialogueBox.getWidth() / 2, 573 - 
/* 32 */         ImageManager.dialogueBox.getHeight() + 32, null);
/* 33 */     g.setColor(Color.white);
/* 34 */     g.setFont(Game.profileInfoFont);
/* 35 */     g.drawImage(icon, 210, 425, null);
/* 36 */     g.drawString(name, 226 - fm.stringWidth(name) / 2, 476);
/* 37 */     g.drawString(line1, 285, 427);
/* 38 */     g.drawString(line2, 285, 452);
/* 39 */     g.drawString(line3, 285, 477);
/* 40 */     g.drawString(line4, 285, 502);
/*    */   }
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.7.jar!\beyondOrigins\main\story\Dialogue.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */