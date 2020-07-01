/*    */ package beyondOrigins.threads;
/*    */ 
/*    */ import beyondOrigins.main.Game;
/*    */ import beyondOrigins.main.menus.MainMenu;
/*    */ 
/*    */ public class CloudThread implements Runnable {
/*    */   String name;
/*    */   
/*    */   Thread t;
/*    */   
/*    */   public CloudThread(String threadName) {
/* 12 */     this.name = threadName;
/* 13 */     this.t = new Thread(this, this.name);
/* 14 */     System.out.println("New Thread: " + this.t);
/* 15 */     this.t.start();
/*    */   }
/*    */   
/*    */   public void run() {
/* 19 */     long lastTime = System.nanoTime();
/* 20 */     long timer = System.currentTimeMillis();
/* 21 */     double ns = 1.6666666666666666E7D;
/* 22 */     double delta = 0.0D;
/* 23 */     while (Game.running) {
/* 24 */       if (MainMenu.menuState != 0) {
/* 25 */         long now = System.nanoTime();
/* 26 */         delta += (now - lastTime) / ns;
/* 27 */         lastTime = now;
/* 28 */         if (delta >= 1.0D)
/* 30 */           delta--; 
/* 33 */         if (System.currentTimeMillis() - timer > 1000L)
/* 34 */           timer += 1000L; 
/*    */         continue;
/*    */       } 
/* 36 */       if (MainMenu.menuState == 0)
/*    */         try {
/* 39 */           Thread.sleep(1000L);
/* 40 */         } catch (InterruptedException e) {
/* 41 */           e.printStackTrace();
/*    */         }  
/*    */     } 
/*    */   }
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.5_2.jar!\beyondOrigins\threads\CloudThread.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */