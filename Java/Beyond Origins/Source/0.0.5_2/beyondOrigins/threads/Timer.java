/*    */ package beyondOrigins.threads;
/*    */ 
/*    */ import beyondOrigins.main.Game;
/*    */ 
/*    */ public class Timer implements Runnable {
/*    */   String name;
/*    */   
/*    */   Thread t;
/*    */   
/*    */   public Timer(String threadName) {
/* 10 */     this.name = threadName;
/* 11 */     this.t = new Thread(this, this.name);
/* 12 */     System.out.println("New Thread: " + this.t);
/* 13 */     this.t.start();
/*    */   }
/*    */   
/*    */   public void run() {
/* 17 */     while (Game.running)
/* 18 */       threadLoop(); 
/*    */   }
/*    */   
/*    */   private void threadLoop() {}
/*    */   
/*    */   public synchronized boolean pause(long time) {
/*    */     try {
/* 28 */       Thread.sleep(time);
/* 29 */     } catch (InterruptedException e) {
/* 30 */       e.printStackTrace();
/*    */     } 
/* 32 */     return true;
/*    */   }
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.5_2.jar!\beyondOrigins\threads\Timer.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */