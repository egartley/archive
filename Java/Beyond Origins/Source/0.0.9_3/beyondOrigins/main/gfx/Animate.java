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
/* 16 */     for (int i = 1; i < frame.length; i++) {
/* 17 */       int c = i * 10 + 1;
/* 18 */       int cc = c - 9;
/* 19 */       if (count >= cc && count <= c) {
/* 20 */         g.drawImage(frame[i], x, y, null);
/* 21 */         this.cf = frame[i];
/*    */       } 
/*    */     } 
/*    */   }
/*    */   
/*    */   public void animateTile(Graphics g, int x, int y, BufferedImage[] frame, short count) {
/* 28 */     for (int i = 1; i < frame.length; i++) {
/* 29 */       int c = i * 10 + 1;
/* 30 */       int cc = c - 9;
/* 31 */       if (count >= cc && count <= c) {
/* 32 */         g.drawImage(frame[i], x, y, null);
/* 33 */         this.cf = frame[i];
/*    */       } 
/*    */     } 
/*    */   }
/*    */   
/*    */   public void imageBreak(Graphics g, BufferedImage i, short x, short y) {}
/*    */   
/*    */   public BufferedImage getCurrentFrame() {
/* 52 */     return this.cf;
/*    */   }
/*    */   
/*    */   public void imageFlash(Graphics g, BufferedImage image, float ex, float ey, Color c) {
/* 57 */     g.setColor(c);
/* 58 */     for (int x = 0; x < image.getWidth(); x++) {
/* 59 */       for (int y = 0; y < image.getHeight(); y++) {
/* 60 */         if (!isTransparent(x, y, image))
/* 61 */           g.fillRect((int)ex + x, (int)ey + y, 1, 1); 
/*    */       } 
/*    */     } 
/* 65 */     this.time = (short)(this.time + 1);
/* 66 */     if (this.time >= 30.0D) {
/* 67 */       this.flashRequest = false;
/* 68 */       this.time = 0;
/*    */     } 
/*    */   }
/*    */   
/*    */   public boolean isTransparent(int x, int y, BufferedImage i) {
/* 73 */     int pixel = i.getRGB(x, y);
/* 74 */     if (pixel >> 24 == 0)
/* 75 */       return true; 
/* 77 */     return false;
/*    */   }
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.9_3.jar!\beyondOrigins\main\gfx\Animate.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */