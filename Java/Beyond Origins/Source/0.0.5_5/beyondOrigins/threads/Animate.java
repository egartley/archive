/*    */ package beyondOrigins.threads;
/*    */ 
/*    */ import java.awt.Graphics;
/*    */ import java.awt.image.BufferedImage;
/*    */ 
/*    */ public class Animate {
/*    */   private static BufferedImage cf;
/*    */   
/*    */   public void animateEntity(Graphics g, int x, int y, BufferedImage frame1, BufferedImage frame2, BufferedImage frame3, BufferedImage frame4, short count) {
/* 13 */     if (count >= 1 && count <= 11) {
/* 14 */       g.drawImage(frame1, x, y, null);
/* 15 */       cf = frame1;
/*    */     } 
/* 17 */     if (count >= 12 && count <= 21) {
/* 18 */       g.drawImage(frame2, x, y, null);
/* 19 */       cf = frame2;
/*    */     } 
/* 21 */     if (count >= 22 && count <= 31) {
/* 22 */       g.drawImage(frame3, x, y, null);
/* 23 */       cf = frame3;
/*    */     } 
/* 25 */     if (count >= 32 && count <= 41) {
/* 26 */       g.drawImage(frame4, x, y, null);
/* 27 */       cf = frame4;
/*    */     } 
/*    */   }
/*    */   
/*    */   public static void imageBreak(Graphics g, BufferedImage i, short x, short y) {
/* 32 */     BufferedImage c1 = i.getSubimage(0, 0, 16, 16);
/* 33 */     BufferedImage c2 = i.getSubimage(16, 0, 16, 16);
/* 34 */     BufferedImage c3 = i.getSubimage(16, 16, 16, 16);
/* 35 */     BufferedImage c4 = i.getSubimage(0, 16, 16, 16);
/* 37 */     short c1x = x, c1y = y, c2x = (short)(x + 16), c2y = y;
/* 38 */     short c3x = (short)(x + 16), c3y = (short)(y + 16), c4x = x, c4y = (short)(y + 16);
/*    */   }
/*    */   
/*    */   public BufferedImage getCurrentFrame() {
/* 42 */     return cf;
/*    */   }
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.5_5.jar!\beyondOrigins\threads\Animate.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */