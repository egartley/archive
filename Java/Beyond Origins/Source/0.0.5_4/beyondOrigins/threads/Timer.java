/*    */ package beyondOrigins.threads;
/*    */ 
/*    */ import beyondOrigins.main.Game;
/*    */ 
/*    */ public class Timer implements Runnable {
/*    */   String name;
/*    */   
/*    */   Thread t;
/*    */   
/*    */   public static boolean isTiming = false;
/*    */   
/*    */   public Timer(String threadName) {
/* 11 */     this.name = threadName;
/* 12 */     this.t = new Thread(this, this.name);
/* 13 */     this.t.start();
/*    */   }
/*    */   
/*    */   public static void start(long time) {
/* 17 */     pause(time);
/*    */   }
/*    */   
/*    */   public void run() {
/* 21 */     while (Game.running) {
/*    */       try {
/* 23 */         Thread.sleep(1000L);
/* 24 */       } catch (InterruptedException e) {
/* 25 */         e.printStackTrace();
/*    */       } 
/*    */     } 
/*    */   }
/*    */   
/*    */   private static void pause(long time) {
/* 31 */     isTiming = true;
/*    */     try {
/* 33 */       Thread.sleep(time);
/* 34 */     } catch (InterruptedException e) {
/* 35 */       e.printStackTrace();
/*    */     } 
/* 37 */     isTiming = false;
/*    */   }
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.5_4.jar!\beyondOrigins\threads\Timer.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */