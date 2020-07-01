/*    */ package beyondOrigins.threads;
/*    */ 
/*    */ import beyondOrigins.main.Game;
/*    */ 
/*    */ public class CloudThread implements Runnable {
/*    */   String name;
/*    */   
/*    */   Thread t;
/*    */   
/*    */   public CloudThread(String threadName) {
/* 11 */     this.name = threadName;
/* 12 */     this.t = new Thread(this, this.name);
/* 13 */     System.out.println("New Thread: " + this.t);
/* 14 */     this.t.start();
/*    */   }
/*    */   
/*    */   public void run() {
/*    */     do {
/*    */     
/* 18 */     } while (Game.running);
/*    */   }
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.5_3.jar!\beyondOrigins\threads\CloudThread.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */