/*    */ package beyondOrigins.threads;
/*    */ 
/*    */ import beyondOrigins.main.Game;
/*    */ import beyondOrigins.main.menus.MainMenu;
/*    */ import java.awt.Graphics;
/*    */ import java.awt.image.BufferedImage;
/*    */ import java.util.Random;
/*    */ 
/*    */ public class CloudThread implements Runnable {
/*    */   String name;
/*    */   
/*    */   Thread t;
/*    */   
/*    */   public static boolean isSleeping = false;
/*    */   
/*    */   public static long amount;
/*    */   
/* 18 */   public static double cloud1x = 850.0D;
/*    */   
/* 19 */   public static double cloud1y = 200.0D;
/*    */   
/* 20 */   public static double cloud2x = 990.0D;
/*    */   
/* 21 */   public static double cloud2y = 22.0D;
/*    */   
/* 22 */   public static double cloud3x = -150.0D;
/*    */   
/* 23 */   public static double cloud3y = 365.0D;
/*    */   
/* 24 */   private static double cloudSpeed = 0.5D;
/*    */   
/* 26 */   private static Random r = new Random();
/*    */   
/*    */   private static int rC;
/*    */   
/*    */   public CloudThread(String threadName) {
/* 30 */     this.name = threadName;
/* 31 */     this.t = new Thread(this, this.name);
/* 32 */     System.out.println("New Thread: " + this.t);
/* 33 */     this.t.start();
/*    */   }
/*    */   
/*    */   public void run() {
/* 37 */     long lastTime = System.nanoTime();
/* 38 */     long timer = System.currentTimeMillis();
/* 39 */     double amountOfTicks = 60.0D;
/* 40 */     double ns = 1.6666666666666666E7D;
/* 41 */     double delta = 0.0D;
/* 42 */     while (Game.running) {
/* 43 */       if (MainMenu.menuState != 0) {
/* 44 */         long now = System.nanoTime();
/* 45 */         delta += (now - lastTime) / ns;
/* 46 */         lastTime = now;
/* 47 */         if (delta >= 1.0D) {
/* 48 */           getCloudX();
/* 49 */           delta--;
/*    */         } 
/* 52 */         if (System.currentTimeMillis() - timer > 1000L)
/* 53 */           timer += 1000L; 
/*    */       } 
/*    */     } 
/*    */   }
/*    */   
/*    */   private void getCloudX() {
/* 60 */     if (MainMenu.clouds && !isSleeping) {
/* 62 */       if (cloud1x > -150.0D) {
/* 63 */         cloud1x -= cloudSpeed + 0.1D;
/*    */       } else {
/* 65 */         cloud1x = 850.0D;
/* 66 */         cloud1y = 200.0D;
/*    */       } 
/* 70 */       if (cloud2x > -125.0D) {
/* 71 */         cloud2x -= cloudSpeed;
/*    */       } else {
/* 73 */         cloud2x = 990.0D;
/* 74 */         cloud2y = 22.0D;
/*    */       } 
/* 78 */       if (cloud3x <= 828.0D) {
/* 79 */         cloud3x += cloudSpeed;
/*    */       } else {
/* 81 */         cloud3x = -150.0D;
/* 82 */         cloud3y = 365.0D;
/*    */       } 
/*    */     } 
/*    */   }
/*    */   
/*    */   public static void drawCloud(Graphics g, int number, BufferedImage image) {
/* 88 */     if (number == 1) {
/* 89 */       g.drawImage(image, (int)cloud1x, (int)cloud1y, image.getWidth(), 
/* 90 */           image.getHeight(), null);
/* 91 */     } else if (number == 2) {
/* 92 */       g.drawImage(image, (int)cloud2x, (int)cloud2y, image.getWidth(), 
/* 93 */           image.getHeight(), null);
/* 94 */     } else if (number == 3) {
/* 95 */       g.drawImage(image, (int)cloud3x, (int)cloud3y, image.getWidth(), 
/* 96 */           image.getHeight(), null);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.5_1.jar!\beyondOrigins\threads\CloudThread.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */