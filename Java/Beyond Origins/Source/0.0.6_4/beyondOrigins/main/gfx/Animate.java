/*    */ package beyondOrigins.main.gfx;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import java.awt.Graphics;
/*    */ import java.awt.image.BufferedImage;
/*    */ 
/*    */ public class Animate {
/*    */   private BufferedImage cf;
/*    */   
/*    */   private short time;
/*    */   
/*    */   public boolean flashRequest = false;
/*    */   
/*    */   public void animateEntity(Graphics g, int x, int y, BufferedImage frame1, BufferedImage frame2, BufferedImage frame3, BufferedImage frame4, short count) {
/* 17 */     if (count >= 1 && count <= 11) {
/* 18 */       g.drawImage(frame1, x, y, null);
/* 19 */       this.cf = frame1;
/*    */     } 
/* 21 */     if (count >= 12 && count <= 21) {
/* 22 */       g.drawImage(frame2, x, y, null);
/* 23 */       this.cf = frame2;
/*    */     } 
/* 25 */     if (count >= 22 && count <= 31) {
/* 26 */       g.drawImage(frame3, x, y, null);
/* 27 */       this.cf = frame3;
/*    */     } 
/* 29 */     if (count >= 32 && count <= 41) {
/* 30 */       g.drawImage(frame4, x, y, null);
/* 31 */       this.cf = frame4;
/*    */     } 
/*    */   }
/*    */   
/*    */   public void imageBreak(Graphics g, BufferedImage i, short x, short y) {}
/*    */   
/*    */   public BufferedImage getCurrentFrame() {
/* 46 */     return this.cf;
/*    */   }
/*    */   
/*    */   public void imageFlash(Graphics g, BufferedImage image, float ex, float ey, Color c) {
/* 50 */     g.setColor(c);
/* 51 */     for (int x = 0; x < image.getWidth(); x++) {
/* 52 */       for (int y = 0; y < image.getHeight(); y++) {
/* 53 */         if (!isTransparent(x, y, image))
/* 55 */           g.fillRect((int)ex + x, (int)ey + y, 1, 1); 
/*    */       } 
/*    */     } 
/* 59 */     this.time = (short)(this.time + 1);
/* 60 */     if (this.time >= 30.0D) {
/* 61 */       this.flashRequest = false;
/* 62 */       this.time = 0;
/*    */     } 
/*    */   }
/*    */   
/*    */   public boolean isTransparent(int x, int y, BufferedImage i) {
/* 67 */     int pixel = i.getRGB(x, y);
/* 68 */     if (pixel >> 24 == 0)
/* 69 */       return true; 
/* 70 */     return false;
/*    */   }
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.6_4.jar!\beyondOrigins\main\gfx\Animate.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */