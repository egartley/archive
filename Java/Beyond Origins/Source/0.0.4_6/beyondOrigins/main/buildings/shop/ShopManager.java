/*    */ package beyondOrigins.main.buildings.shop;
/*    */ 
/*    */ import beyondOrigins.main.Game;
/*    */ import beyondOrigins.main.entities.Player;
/*    */ import beyondOrigins.main.gfx.ImageManager;
/*    */ import java.awt.Color;
/*    */ import java.awt.Graphics;
/*    */ 
/*    */ public class ShopManager {
/*    */   private static ImageManager im;
/*    */   
/* 12 */   public static int overlay = 0;
/*    */   
/*    */   public static boolean isInside = false;
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
/* 23 */     im = im;
/*    */   }
/*    */   
/*    */   public static void tick() {
/* 27 */     if (Player.tileX == 46 && Player.tileY == 3 && (
/* 28 */       Player.pUp || test1 == 1) && enter != 2) {
/* 29 */       enter = 1;
/* 30 */       test1 = 1;
/* 31 */       overlay += 8;
/* 32 */       if (overlay >= 248) {
/* 33 */         enter = 2;
/* 34 */         isInside = true;
/* 35 */         Player.insideMovement = true;
/* 36 */         Player.mapMovement = false;
/* 37 */         Game.isOnMap = false;
/* 38 */         Player.playerX = 404.0F;
/* 39 */         Player.playerY = 421.0F;
/*    */       } 
/* 41 */     } else if (Player.tileX == 46 && Player.tileY == 3) {
/* 42 */       enter = 0;
/* 43 */       test1 = 0;
/*    */     } 
/* 45 */     if (Player.playerX >= 386.0F && Player.playerX <= 421.0F && 
/* 46 */       Player.playerY >= 419.0F && Player.playerY <= 424.0F && (
/* 47 */       Player.pDown || test2 == 1) && exit != 2) {
/* 48 */       exit = 1;
/* 49 */       test2 = 1;
/* 50 */       overlay -= 8;
/* 51 */       if (overlay <= 0) {
/* 52 */         exit = 2;
/* 53 */         isInside = false;
/* 54 */         Player.insideMovement = false;
/* 55 */         Player.mapMovement = true;
/* 56 */         Game.isOnMap = true;
/* 57 */         Player.playerX = 673.0F;
/* 58 */         Player.playerY = 109.0F;
/*    */       } 
/* 60 */     } else if ((Player.playerX >= 386.0F && Player.playerX <= 421.0F && 
/* 61 */       Player.playerY >= 419.0F && Player.playerY <= 424.0F) || (
/* 62 */       Player.playerX == 673.0F && Player.playerY == 109.0F)) {
/* 63 */       exit = 0;
/* 64 */       test2 = 0;
/*    */     } 
/* 66 */     if (overlay != 0 && overlay != 248 && (
/* 67 */       Player.mapMovement || Player.insideMovement)) {
/* 68 */       Player.canMoveUp = 0;
/* 69 */       Player.canMoveDown = 0;
/* 70 */       Player.canMoveLeft = 0;
/* 71 */       Player.canMoveRight = 0;
/*    */     } else {
/* 73 */       Player.canMoveUp = 1;
/* 74 */       Player.canMoveDown = 1;
/* 75 */       Player.canMoveLeft = 1;
/* 76 */       Player.canMoveRight = 1;
/*    */     } 
/*    */   }
/*    */   
/*    */   public static void render(Graphics g) {
/* 81 */     Color enterOrExit = new Color(0, 0, 0, overlay);
/* 82 */     if (enter != 0) {
/* 83 */       g.setColor(enterOrExit);
/* 84 */       g.fillRect(0, 0, 838, 1146);
/*    */     } 
/* 86 */     if (isInside)
/* 87 */       g.drawImage(Game.inside1Image, 195, 110, 448, 352, null); 
/*    */   }
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.4_6.jar!\beyondOrigins\main\buildings\shop\ShopManager.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */