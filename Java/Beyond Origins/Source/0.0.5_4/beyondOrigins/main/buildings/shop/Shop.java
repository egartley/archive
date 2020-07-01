/*    */ package beyondOrigins.main.buildings.shop;
/*    */ 
/*    */ import beyondOrigins.main.Game;
/*    */ import beyondOrigins.main.entities.Player;
/*    */ import java.awt.Color;
/*    */ import java.awt.Graphics;
/*    */ 
/*    */ public class Shop {
/* 10 */   public static int overlay = 0;
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
/*    */   public static void tick() {
/* 25 */     if (Player.tileX == 46 && Player.tileY == 3 && (
/* 26 */       Player.movingUp || test1 == 1) && enter != 2) {
/* 27 */       enter = 1;
/* 28 */       test1 = 1;
/* 29 */       overlay += 8;
/* 30 */       if (overlay >= 248) {
/* 31 */         enter = 2;
/* 32 */         isInside = true;
/* 33 */         Player.insideMovement = true;
/* 34 */         Player.mapMovement = false;
/* 35 */         Game.isOnMap = false;
/* 36 */         Player.playerX = 404.0F;
/* 37 */         Player.playerY = 421.0F;
/*    */       } 
/* 39 */     } else if (Player.tileX == 46 && Player.tileY == 3) {
/* 40 */       enter = 0;
/* 41 */       test1 = 0;
/*    */     } 
/* 43 */     if (Player.playerX >= 386.0F && Player.playerX <= 421.0F && 
/* 44 */       Player.playerY >= 419.0F && Player.playerY <= 424.0F && (
/* 45 */       Player.down || test2 == 1) && exit != 2 && !Player.mapMovement) {
/* 46 */       exit = 1;
/* 47 */       test2 = 1;
/* 48 */       overlay -= 8;
/* 49 */       if (overlay <= 0) {
/* 50 */         exit = 2;
/* 51 */         isInside = false;
/* 52 */         Player.insideMovement = false;
/* 53 */         Player.mapMovement = true;
/* 54 */         Game.isOnMap = true;
/* 55 */         Player.playerX = 673.0F;
/* 56 */         Player.playerY = 109.0F;
/*    */       } 
/* 58 */     } else if ((Player.playerX >= 386.0F && Player.playerX <= 421.0F && 
/* 59 */       Player.playerY >= 419.0F && Player.playerY <= 424.0F) || (
/* 60 */       Player.playerX == 673.0F && Player.playerY == 109.0F)) {
/* 61 */       exit = 0;
/* 62 */       test2 = 0;
/*    */     } 
/* 64 */     if (overlay != 0 && overlay != 248 && (
/* 65 */       Player.mapMovement || Player.insideMovement)) {
/* 66 */       Player.canMoveUp = 0;
/* 67 */       Player.canMoveDown = 0;
/* 68 */       Player.canMoveLeft = 0;
/* 69 */       Player.canMoveRight = 0;
/*    */     } else {
/* 71 */       Player.canMoveUp = 1;
/* 72 */       Player.canMoveDown = 1;
/* 73 */       Player.canMoveLeft = 1;
/* 74 */       Player.canMoveRight = 1;
/*    */     } 
/*    */   }
/*    */   
/*    */   public static void render(Graphics g) {
/* 79 */     Color enterOrExit = new Color(0, 0, 0, overlay);
/* 80 */     if (enter != 0) {
/* 81 */       g.setColor(enterOrExit);
/* 82 */       g.fillRect(0, 0, 838, 1146);
/*    */     } 
/* 84 */     if (isInside)
/* 85 */       g.drawImage(Game.inside1Image, 195, 110, 448, 352, null); 
/*    */   }
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.5_4.jar!\beyondOrigins\main\buildings\shop\Shop.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */