/*    */ package com.emgartley.beyondOrigins.main.threads;
/*    */ 
/*    */ import com.emgartley.beyondOrigins.main.Game;
/*    */ import com.emgartley.beyondOrigins.main.gfx.Notification;
/*    */ import java.awt.Graphics;
/*    */ 
/*    */ public class Noti implements Runnable {
/* 10 */   String name = "thread_noti";
/*    */   
/*    */   public Thread t;
/*    */   
/* 12 */   public static Notification gre = new Notification(
/* 13 */       "Graphics have been reloaded!");
/*    */   
/* 14 */   public static Notification fre = new Notification("null");
/*    */   
/* 15 */   public static Notification aut = new Notification(
/* 16 */       "Game has been auto saved!");
/*    */   
/* 17 */   public static Notification cms = new Notification("Coming Soon!");
/*    */   
/*    */   public Noti(String n) {
/* 20 */     this.name = n;
/* 21 */     this.t = new Thread(this, this.name);
/* 22 */     this.t.setPriority(1);
/* 23 */     this.t.start();
/*    */   }
/*    */   
/*    */   public static boolean isNotifying() {
/* 27 */     if (gre.rendering || fre.rendering || aut.rendering || cms.rendering)
/* 28 */       return true; 
/* 30 */     return false;
/*    */   }
/*    */   
/*    */   public static void startNotify(Notification n) {
/* 34 */     cancelActiveNotification();
/* 35 */     n.start();
/*    */   }
/*    */   
/*    */   public static void checkNotify() {
/* 39 */     if (gre.isStarted())
/* 40 */       gre.rendering = true; 
/* 41 */     if (fre.isStarted())
/* 42 */       fre.rendering = true; 
/* 43 */     if (aut.isStarted())
/* 44 */       aut.rendering = true; 
/* 45 */     if (cms.isStarted())
/* 46 */       cms.rendering = true; 
/* 47 */     if (isNotifying())
/* 48 */       getActiveNotification().tick(); 
/*    */   }
/*    */   
/*    */   public static void cancelActiveNotification() {
/* 53 */     if (isNotifying()) {
/* 54 */       getActiveNotification().reset();
/* 55 */       getActiveNotification().cancel();
/*    */     } 
/*    */   }
/*    */   
/*    */   public void run() {
/* 60 */     while (Game.running) {
/*    */       try {
/* 62 */         Thread.sleep(1L);
/* 63 */       } catch (InterruptedException e) {
/* 64 */         e.printStackTrace();
/*    */       } 
/*    */     } 
/*    */   }
/*    */   
/*    */   public static Notification getActiveNotification() {
/* 70 */     if (gre.rendering)
/* 71 */       return gre; 
/* 72 */     if (fre.rendering)
/* 73 */       return fre; 
/* 74 */     if (aut.rendering)
/* 75 */       return aut; 
/* 76 */     if (cms.rendering)
/* 77 */       return cms; 
/* 78 */     return null;
/*    */   }
/*    */   
/*    */   public static void render(Graphics g) {
/* 83 */     if (isNotifying())
/* 84 */       getActiveNotification().render(g); 
/*    */   }
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.1.0_1.jar!\com\emgartley\beyondOrigins\main\threads\Noti.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */