/*    */ package applecraft.testgame.main.buildings.shop;
/*    */ 
/*    */ import applecraft.testgame.main.Game;
/*    */ import applecraft.testgame.main.entities.Player;
/*    */ import applecraft.testgame.main.gfx.ImageManager;
/*    */ import java.awt.Color;
/*    */ import java.awt.Graphics;
/*    */ 
/*    */ public class ShopManager {
/*    */   private static ImageManager im;
/*    */   
/* 15 */   public static int overlay = 0;
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
/* 26 */     ShopManager.shopEnter = shopEnter;
/*    */   }
/*    */   
/*    */   public static void tick() {
/* 31 */     if (Player.tileX == 46 && Player.tileY == 3 && (
/* 32 */       Player.pUp || test1 == 1) && 
/* 33 */       enter != 2) {
/* 34 */       enter = 1;
/* 35 */       test1 = 1;
/* 36 */       overlay += 8;
/* 37 */       if (overlay >= 248) {
/* 38 */         enter = 2;
/* 39 */         isInside = true;
/* 40 */         Player.insideMovement = true;
/* 41 */         Player.mapMovement = false;
/* 42 */         Game.isOnMap = false;
/* 43 */         Player.playerX = 404.0F;
/* 44 */         Player.playerY = 421.0F;
/*    */       } 
/* 46 */     } else if (Player.tileX == 46 && Player.tileY == 3) {
/* 47 */       enter = 0;
/* 48 */       test1 = 0;
/*    */     } 
/* 51 */     if (Player.playerX >= 386.0F && Player.playerX <= 421.0F && 
/* 52 */       Player.playerY >= 419.0F && Player.playerY <= 424.0F && (
/* 53 */       Player.pDown || test2 == 1) && exit != 2) {
/* 54 */       exit = 1;
/* 55 */       test2 = 1;
/* 56 */       overlay -= 8;
/* 57 */       if (overlay <= 0) {
/* 58 */         exit = 2;
/* 59 */         isInside = false;
/* 60 */         Player.insideMovement = false;
/* 61 */         Player.mapMovement = true;
/* 62 */         Game.isOnMap = true;
/* 63 */         Player.playerX = 673.0F;
/* 64 */         Player.playerY = 109.0F;
/*    */       } 
/* 66 */     } else if ((Player.playerX >= 386.0F && Player.playerX <= 421.0F && Player.playerY >= 419.0F && Player.playerY <= 424.0F) || (
/* 67 */       Player.playerX == 673.0F && Player.playerY == 109.0F)) {
/* 68 */       exit = 0;
/* 69 */       test2 = 0;
/*    */     } 
/* 72 */     if (overlay != 0 && overlay != 248 && (Player.mapMovement || Player.insideMovement)) {
/* 73 */       Player.canMoveUp = 0;
/* 74 */       Player.canMoveDown = 0;
/* 75 */       Player.canMoveLeft = 0;
/* 76 */       Player.canMoveRight = 0;
/*    */     } else {
/* 78 */       Player.canMoveUp = 1;
/* 79 */       Player.canMoveDown = 1;
/* 80 */       Player.canMoveLeft = 1;
/* 81 */       Player.canMoveRight = 1;
/*    */     } 
/*    */   }
/*    */   
/*    */   public static void render(Graphics g) {
/* 88 */     Color enterOrExit = new Color(0, 0, 0, overlay);
/* 90 */     if (enter != 0) {
/* 91 */       g.setColor(enterOrExit);
/* 92 */       g.fillRect(0, 0, 838, 1146);
/*    */     } 
/* 95 */     if (isInside)
/* 96 */       g.drawImage(Game.inside1Image, 195, 
/* 97 */           110, 448, 352, null); 
/*    */   }
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.4.2_6.jar!\applecraft\testgame\main\buildings\shop\ShopManager.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */