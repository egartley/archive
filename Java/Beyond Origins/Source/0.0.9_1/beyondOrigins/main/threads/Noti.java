/*    */ package beyondOrigins.main.threads;
/*    */ 
/*    */ import beyondOrigins.main.Game;
/*    */ import beyondOrigins.main.gfx.Notification;
/*    */ import java.awt.Graphics;
/*    */ 
/*    */ public class Noti implements Runnable {
/*    */   String name;
/*    */   
/*    */   Thread t;
/*    */   
/* 13 */   public static Notification gre = new Notification(
/* 14 */       "Graphics have been reloaded!");
/*    */   
/* 15 */   public static Notification fre = new Notification("null");
/*    */   
/* 16 */   public static Notification aut = new Notification(
/* 17 */       "Game has been auto saved!");
/*    */   
/*    */   public Noti(String threadName) {
/* 20 */     this.name = threadName;
/* 21 */     this.t = new Thread(this, this.name);
/* 22 */     this.t.setPriority(1);
/* 23 */     this.t.start();
/*    */   }
/*    */   
/*    */   public static boolean isNotifying() {
/* 27 */     if (gre.rendering || fre.rendering || aut.rendering)
/* 28 */       return true; 
/* 29 */     return false;
/*    */   }
/*    */   
/*    */   public static void startNotify(Notification n) {
/* 33 */     cancelActiveNotification();
/* 34 */     n.start();
/*    */   }
/*    */   
/*    */   public static void checkNotify() {
/* 38 */     if (gre.isStarted())
/* 39 */       gre.rendering = true; 
/* 40 */     if (fre.isStarted())
/* 41 */       fre.rendering = true; 
/* 42 */     if (aut.isStarted())
/* 43 */       aut.rendering = true; 
/* 44 */     if (isNotifying())
/* 45 */       getActiveNotification().tick(); 
/*    */   }
/*    */   
/*    */   public static void cancelActiveNotification() {
/* 50 */     if (isNotifying()) {
/* 51 */       getActiveNotification().reset();
/* 52 */       getActiveNotification().cancel();
/*    */     } 
/*    */   }
/*    */   
/*    */   public static void render(Graphics g) {
/* 57 */     if (isNotifying())
/* 58 */       getActiveNotification().render(g); 
/*    */   }
/*    */   
/*    */   public void run() {
/* 63 */     while (Game.running) {
/*    */       try {
/* 65 */         Thread.sleep(1000L);
/* 66 */       } catch (InterruptedException e) {
/* 67 */         e.printStackTrace();
/*    */       } 
/*    */     } 
/*    */   }
/*    */   
/*    */   public static Notification getActiveNotification() {
/* 73 */     if (gre.rendering)
/* 74 */       return gre; 
/* 75 */     if (fre.rendering)
/* 76 */       return fre; 
/* 77 */     if (aut.rendering)
/* 78 */       return aut; 
/* 79 */     return null;
/*    */   }
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.9_1.jar!\beyondOrigins\main\threads\Noti.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */