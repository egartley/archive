/*    */ package applecraft.testgame.main;
/*    */ 
/*    */ import applecraft.testgame.main.buildings.shop.ShopManager;
/*    */ import applecraft.testgame.main.entities.Player;
/*    */ 
/*    */ public class CollisionManager {
/*    */   public static void init() {}
/*    */   
/*    */   public static void tick() {
/* 18 */     if (Player.mapMovement) {
/* 19 */       if (Player.playerX == 606.0F && 
/* 20 */         Player.playerY <= 104.0F && Player.playerY != 0.0F) {
/* 21 */         Player.canMoveRight = 0;
/*    */       } else {
/* 23 */         Player.canMoveRight = 1;
/*    */       } 
/* 25 */       if (Player.playerX >= 607.0F && Player.playerX <= 739.0F && 
/* 26 */         Player.playerY <= 104.0F && Player.playerY >= 1.0F) {
/* 27 */         Player.canMoveUp = 0;
/*    */       } else {
/* 29 */         Player.canMoveUp = 1;
/*    */       } 
/* 31 */       if (Player.playerX == 739.0F && 
/* 32 */         Player.playerY <= 104.0F && Player.playerY != 0.0F) {
/* 33 */         Player.canMoveLeft = 0;
/*    */       } else {
/* 35 */         Player.canMoveLeft = 1;
/*    */       } 
/* 36 */       if (Player.playerX >= 607.0F && Player.playerX <= 739.0F && 
/* 37 */         Player.playerY == 0.0F) {
/* 38 */         Player.canMoveDown = 0;
/*    */       } else {
/* 40 */         Player.canMoveDown = 1;
/*    */       } 
/*    */     } else {
/* 42 */       Player.canMoveRight = 1;
/* 43 */       Player.canMoveUp = 1;
/* 44 */       Player.canMoveLeft = 1;
/* 45 */       Player.canMoveDown = 1;
/*    */     } 
/* 48 */     if (ShopManager.overlay != 0 && ShopManager.overlay != 248 && (Player.mapMovement || Player.insideMovement)) {
/* 49 */       Player.canMoveUp = 0;
/* 50 */       Player.canMoveDown = 0;
/* 51 */       Player.canMoveLeft = 0;
/* 52 */       Player.canMoveRight = 0;
/*    */     } else {
/* 54 */       Player.canMoveUp = 1;
/* 55 */       Player.canMoveDown = 1;
/* 56 */       Player.canMoveLeft = 1;
/* 57 */       Player.canMoveRight = 1;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.4.2_7.jar!\applecraft\testgame\main\CollisionManager.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */