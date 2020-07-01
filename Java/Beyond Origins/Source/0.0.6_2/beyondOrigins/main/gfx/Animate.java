/*    */ package beyondOrigins.main.gfx;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import java.awt.Graphics;
/*    */ import java.awt.image.BufferedImage;
/*    */ 
/*    */ public class Animate {
/*    */   private static BufferedImage cf;
/*    */   
/*    */   private static short time;
/*    */   
/*    */   public boolean flashRequest = false;
/*    */   
/*    */   public void animateEntity(Graphics g, int x, int y, BufferedImage frame1, BufferedImage frame2, BufferedImage frame3, BufferedImage frame4, short count) {
/* 19 */     if (count >= 1 && count <= 11) {
/* 20 */       g.drawImage(frame1, x, y, null);
/* 21 */       cf = frame1;
/*    */     } 
/* 23 */     if (count >= 12 && count <= 21) {
/* 24 */       g.drawImage(frame2, x, y, null);
/* 25 */       cf = frame2;
/*    */     } 
/* 27 */     if (count >= 22 && count <= 31) {
/* 28 */       g.drawImage(frame3, x, y, null);
/* 29 */       cf = frame3;
/*    */     } 
/* 31 */     if (count >= 32 && count <= 41) {
/* 32 */       g.drawImage(frame4, x, y, null);
/* 33 */       cf = frame4;
/*    */     } 
/*    */   }
/*    */   
/*    */   public static void imageBreak(Graphics g, BufferedImage i, short x, short y) {
/* 38 */     BufferedImage c1 = i.getSubimage(0, 0, 16, 16);
/* 39 */     BufferedImage c2 = i.getSubimage(16, 0, 16, 16);
/* 40 */     BufferedImage c3 = i.getSubimage(16, 16, 16, 16);
/* 41 */     BufferedImage c4 = i.getSubimage(0, 16, 16, 16);
/* 43 */     short c1x = x, c1y = y, c2x = (short)(x + 16), c2y = y;
/* 44 */     short c3x = (short)(x + 16), c3y = (short)(y + 16), c4x = x, c4y = (short)(y + 16);
/*    */   }
/*    */   
/*    */   public BufferedImage getCurrentFrame() {
/* 48 */     return cf;
/*    */   }
/*    */   
/*    */   public void imageFlash(Graphics g, BufferedImage image, float ex, float ey, Color c) {
/* 52 */     g.setColor(c);
/* 53 */     for (int x = 0; x < image.getWidth(); x++) {
/* 54 */       for (int y = 0; y < image.getHeight(); y++) {
/* 55 */         if (!isTransparent(x, y, image))
/* 57 */           g.fillRect((int)ex + x, (int)ey + y, 1, 1); 
/*    */       } 
/*    */     } 
/* 61 */     time = (short)(time + 1);
/* 62 */     if (time >= 30.0D) {
/* 63 */       this.flashRequest = false;
/* 64 */       time = 0;
/*    */     } 
/*    */   }
/*    */   
/*    */   public boolean isTransparent(int x, int y, BufferedImage i) {
/* 69 */     int pixel = i.getRGB(x, y);
/* 70 */     if (pixel >> 24 == 0)
/* 71 */       return true; 
/* 72 */     return false;
/*    */   }
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.6_2.jar!\beyondOrigins\main\gfx\Animate.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */