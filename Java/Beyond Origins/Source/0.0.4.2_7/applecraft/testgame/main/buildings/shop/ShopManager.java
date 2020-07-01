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
/* 14 */   public static int overlay = 0;
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
/*    */   public ShopManager(ImageManager im) {
/* 24 */     ShopManager.im = im;
/*    */   }
/*    */   
/*    */   public static void tick() {
/* 29 */     if (Player.tileX == 46 && Player.tileY == 3 && (
/* 30 */       Player.pUp || test1 == 1) && 
/* 31 */       enter != 2) {
/* 32 */       enter = 1;
/* 33 */       test1 = 1;
/* 34 */       overlay += 8;
/* 35 */       if (overlay >= 248) {
/* 36 */         enter = 2;
/* 37 */         isInside = true;
/* 38 */         Player.insideMovement = true;
/* 39 */         Player.mapMovement = false;
/* 40 */         Game.isOnMap = false;
/* 41 */         Player.playerX = 404.0F;
/* 42 */         Player.playerY = 421.0F;
/*    */       } 
/* 44 */     } else if (Player.tileX == 46 && Player.tileY == 3) {
/* 45 */       enter = 0;
/* 46 */       test1 = 0;
/*    */     } 
/* 49 */     if (Player.playerX >= 386.0F && Player.playerX <= 421.0F && 
/* 50 */       Player.playerY >= 419.0F && Player.playerY <= 424.0F && (
/* 51 */       Player.pDown || test2 == 1) && exit != 2) {
/* 52 */       exit = 1;
/* 53 */       test2 = 1;
/* 54 */       overlay -= 8;
/* 55 */       if (overlay <= 0) {
/* 56 */         exit = 2;
/* 57 */         isInside = false;
/* 58 */         Player.insideMovement = false;
/* 59 */         Player.mapMovement = true;
/* 60 */         Game.isOnMap = true;
/* 61 */         Player.playerX = 673.0F;
/* 62 */         Player.playerY = 109.0F;
/*    */       } 
/* 64 */     } else if ((Player.playerX >= 386.0F && Player.playerX <= 421.0F && Player.playerY >= 419.0F && Player.playerY <= 424.0F) || (
/* 65 */       Player.playerX == 673.0F && Player.playerY == 109.0F)) {
/* 66 */       exit = 0;
/* 67 */       test2 = 0;
/*    */     } 
/* 70 */     if (overlay != 0 && overlay != 248 && (Player.mapMovement || Player.insideMovement)) {
/* 71 */       Player.canMoveUp = 0;
/* 72 */       Player.canMoveDown = 0;
/* 73 */       Player.canMoveLeft = 0;
/* 74 */       Player.canMoveRight = 0;
/*    */     } else {
/* 76 */       Player.canMoveUp = 1;
/* 77 */       Player.canMoveDown = 1;
/* 78 */       Player.canMoveLeft = 1;
/* 79 */       Player.canMoveRight = 1;
/*    */     } 
/*    */   }
/*    */   
/*    */   public static void render(Graphics g) {
/* 86 */     Color enterOrExit = new Color(0, 0, 0, overlay);
/* 88 */     if (enter != 0) {
/* 89 */       g.setColor(enterOrExit);
/* 90 */       g.fillRect(0, 0, 838, 1146);
/*    */     } 
/* 93 */     if (isInside)
/* 94 */       g.drawImage(Game.inside1Image, 195, 
/* 95 */           110, 448, 352, null); 
/*    */   }
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.4.2_7.jar!\applecraft\testgame\main\buildings\shop\ShopManager.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */