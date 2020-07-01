/*    */ package beyondOrigins.threads;
/*    */ 
/*    */ import beyondOrigins.main.Game;
/*    */ import java.awt.Graphics;
/*    */ import java.awt.image.BufferedImage;
/*    */ 
/*    */ public class Animate implements Runnable {
/*    */   String name;
/*    */   
/*    */   Thread t;
/*    */   
/*    */   public Animate(String threadName) {
/* 14 */     this.name = threadName;
/* 15 */     this.t = new Thread(this, this.name);
/* 16 */     System.out.println("New Thread: " + this.t);
/* 17 */     this.t.start();
/*    */   }
/*    */   
/*    */   public void run() {
/*    */     do {
/*    */     
/* 21 */     } while (Game.running);
/*    */   }
/*    */   
/*    */   public static void animateEntity(Graphics g, int x, int y, BufferedImage frame1, BufferedImage frame2, BufferedImage frame3, BufferedImage frame4, int count) {
/* 29 */     if (count >= 1 && count <= 11)
/* 30 */       g.drawImage(frame1, x, y, null); 
/* 32 */     if (count >= 12 && count <= 21)
/* 33 */       g.drawImage(frame2, x, y, null); 
/* 35 */     if (count >= 22 && count <= 31)
/* 36 */       g.drawImage(frame3, x, y, 32, 32, null); 
/* 38 */     if (count >= 32 && count <= 41)
/* 39 */       g.drawImage(frame4, x, y, 32, 32, null); 
/*    */   }
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.5_2.jar!\beyondOrigins\threads\Animate.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */