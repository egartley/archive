/*    */ package applecraft.testgame.main.buildings.shop;
/*    */ 
/*    */ import applecraft.testgame.main.Game;
/*    */ import applecraft.testgame.main.KeyManager;
/*    */ import applecraft.testgame.main.entities.Player;
/*    */ import applecraft.testgame.main.gfx.ImageManager;
/*    */ import java.awt.Color;
/*    */ import java.awt.Graphics;
/*    */ 
/*    */ public class ShopManager {
/*    */   private static ImageManager im;
/*    */   
/* 15 */   private static int overlay = 0;
/*    */   
/* 16 */   private static int overlay2 = 0;
/*    */   
/*    */   public static boolean shopEnter = false;
/*    */   
/*    */   private static boolean isInside = false;
/*    */   
/*    */   public static int enter;
/*    */   
/*    */   public static int exit;
/*    */   
/*    */   public static int test1;
/*    */   
/*    */   public static int test2;
/*    */   
/*    */   public static void init() {}
/*    */   
/*    */   public ShopManager(boolean shopEnter) {
/* 27 */     ShopManager.shopEnter = shopEnter;
/*    */   }
/*    */   
/*    */   public static void tick() {
/* 32 */     if (Player.tileX == 46 && Player.tileY == 3 && (
/* 33 */       KeyManager.enterPressed || test1 == 1) && 
/* 34 */       enter != 2) {
/* 35 */       enter = 1;
/* 36 */       test1 = 1;
/* 37 */       overlay += 8;
/* 38 */       if (overlay >= 248) {
/* 39 */         enter = 2;
/* 40 */         isInside = true;
/* 41 */         Player.insideMovement = true;
/* 42 */         Player.mapMovement = false;
/* 43 */         Game.isOnMap = false;
/* 44 */         Player.playerX = 404.0F;
/* 45 */         Player.playerY = 421.0F;
/*    */       } 
/* 47 */     } else if (Player.tileX == 46 && Player.tileY == 3) {
/* 48 */       enter = 0;
/* 49 */       test1 = 0;
/*    */     } 
/* 52 */     if (Player.playerX >= 386.0F && Player.playerX <= 421.0F && 
/* 53 */       Player.playerY >= 419.0F && Player.playerY <= 424.0F && (
/* 54 */       KeyManager.enterPressed || test2 == 1) && exit != 2) {
/* 55 */       exit = 1;
/* 56 */       test2 = 1;
/* 57 */       overlay -= 8;
/* 58 */       if (overlay <= 0) {
/* 59 */         exit = 2;
/* 60 */         isInside = false;
/* 61 */         Player.insideMovement = false;
/* 62 */         Player.mapMovement = true;
/* 63 */         Game.isOnMap = true;
/* 64 */         Player.playerX = 673.0F;
/* 65 */         Player.playerY = 109.0F;
/*    */       } 
/* 67 */     } else if ((Player.playerX >= 386.0F && Player.playerX <= 421.0F && 
/* 68 */       Player.playerY >= 419.0F && Player.playerY <= 424.0F) || (Player.playerX == 673.0F && Player.playerY == 109.0F)) {
/* 69 */       exit = 0;
/* 70 */       test2 = 0;
/*    */     } 
/*    */   }
/*    */   
/*    */   public static void render(Graphics g) {
/* 77 */     Color enterOrExit = new Color(0, 0, 0, overlay);
/* 79 */     if (enter != 0) {
/* 80 */       g.setColor(enterOrExit);
/* 81 */       g.fillRect(0, 0, 838, 1146);
/*    */     } 
/* 84 */     if (isInside)
/* 85 */       g.drawImage(Game.inside1Image, 195, 
/* 86 */           110, 448, 352, null); 
/*    */   }
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.4.2_5.jar!\applecraft\testgame\main\buildings\shop\ShopManager.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */