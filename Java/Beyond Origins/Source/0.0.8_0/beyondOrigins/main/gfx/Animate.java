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
/*    */   public void animateEntity(Graphics g, int x, int y, BufferedImage[] frame, short count) {
/* 16 */     if (count >= 1 && count <= 11) {
/* 17 */       g.drawImage(frame[1], x, y, null);
/* 18 */       this.cf = frame[1];
/*    */     } 
/* 20 */     if (count >= 12 && count <= 21) {
/* 21 */       g.drawImage(frame[2], x, y, null);
/* 22 */       this.cf = frame[2];
/*    */     } 
/* 24 */     if (count >= 22 && count <= 31) {
/* 25 */       g.drawImage(frame[3], x, y, null);
/* 26 */       this.cf = frame[3];
/*    */     } 
/* 28 */     if (count >= 32 && count <= 41) {
/* 29 */       g.drawImage(frame[4], x, y, null);
/* 30 */       this.cf = frame[4];
/*    */     } 
/*    */   }
/*    */   
/*    */   public void imageBreak(Graphics g, BufferedImage i, short x, short y) {}
/*    */   
/*    */   public BufferedImage getCurrentFrame() {
/* 45 */     return this.cf;
/*    */   }
/*    */   
/*    */   public void imageFlash(Graphics g, BufferedImage image, float ex, float ey, Color c) {
/* 49 */     g.setColor(c);
/* 50 */     for (int x = 0; x < image.getWidth(); x++) {
/* 51 */       for (int y = 0; y < image.getHeight(); y++) {
/* 52 */         if (!isTransparent(x, y, image))
/* 53 */           g.fillRect((int)ex + x, (int)ey + y, 1, 1); 
/*    */       } 
/*    */     } 
/* 57 */     this.time = (short)(this.time + 1);
/* 58 */     if (this.time >= 30.0D) {
/* 59 */       this.flashRequest = false;
/* 60 */       this.time = 0;
/*    */     } 
/*    */   }
/*    */   
/*    */   public boolean isTransparent(int x, int y, BufferedImage i) {
/* 65 */     int pixel = i.getRGB(x, y);
/* 66 */     if (pixel >> 24 == 0)
/* 67 */       return true; 
/* 68 */     return false;
/*    */   }
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.8_0.jar!\beyondOrigins\main\gfx\Animate.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */