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
/* 26 */     if (Player.tileX == 46 && Player.tileY == 3 && (
/* 27 */       Player.movingUp || test1 == 1) && enter != 2) {
/* 28 */       enter = 1;
/* 29 */       test1 = 1;
/* 30 */       overlay += 8;
/* 31 */       if (overlay >= 248) {
/* 32 */         enter = 2;
/* 33 */         isInside = true;
/* 34 */         Player.insideMovement = true;
/* 35 */         Player.mapMovement = false;
/* 36 */         Game.isOnMap = false;
/* 37 */         Player.x = 404.0F;
/* 38 */         Player.y = 421.0F;
/*    */       } 
/* 40 */     } else if (Player.tileX == 46 && Player.tileY == 3) {
/* 41 */       enter = 0;
/* 42 */       test1 = 0;
/*    */     } 
/* 44 */     if (Player.x >= 386.0F && Player.x <= 421.0F && 
/* 45 */       Player.y >= 419.0F && Player.y <= 424.0F && (
/* 46 */       Player.down || test2 == 1) && exit != 2 && !Player.mapMovement) {
/* 47 */       exit = 1;
/* 48 */       test2 = 1;
/* 49 */       overlay -= 8;
/* 50 */       if (overlay <= 0) {
/* 51 */         exit = 2;
/* 52 */         isInside = false;
/* 53 */         Player.insideMovement = false;
/* 54 */         Player.mapMovement = true;
/* 55 */         Game.isOnMap = true;
/* 56 */         Player.x = 673.0F;
/* 57 */         Player.y = 109.0F;
/*    */       } 
/* 59 */     } else if ((Player.x >= 386.0F && Player.x <= 421.0F && 
/* 60 */       Player.y >= 419.0F && Player.y <= 424.0F) || (
/* 61 */       Player.x == 673.0F && Player.y == 109.0F)) {
/* 62 */       exit = 0;
/* 63 */       test2 = 0;
/*    */     } 
/* 65 */     if (overlay != 0 && overlay != 248 && (
/* 66 */       Player.mapMovement || Player.insideMovement)) {
/* 67 */       Player.canMoveUp = false;
/* 68 */       Player.canMoveDown = false;
/* 69 */       Player.canMoveLeft = false;
/* 70 */       Player.canMoveRight = false;
/*    */     } else {
/* 72 */       Player.canMoveUp = true;
/* 73 */       Player.canMoveDown = true;
/* 74 */       Player.canMoveLeft = true;
/* 75 */       Player.canMoveRight = true;
/*    */     } 
/*    */   }
/*    */   
/*    */   public static void render(Graphics g) {
/* 80 */     Color enterOrExit = new Color(0, 0, 0, overlay);
/* 81 */     if (enter != 0) {
/* 82 */       g.setColor(enterOrExit);
/* 83 */       g.fillRect(0, 0, 838, 1146);
/*    */     } 
/* 85 */     if (isInside)
/* 86 */       g.drawImage(Game.inside1Image, 195, 110, 448, 352, null); 
/*    */   }
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.5_6.jar!\beyondOrigins\main\buildings\shop\Shop.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */