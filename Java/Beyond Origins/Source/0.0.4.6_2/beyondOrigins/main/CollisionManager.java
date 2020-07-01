/*    */ package beyondOrigins.main;
/*    */ 
/*    */ import beyondOrigins.main.buildings.shop.ShopManager;
/*    */ import beyondOrigins.main.entities.Player;
/*    */ 
/*    */ public class CollisionManager {
/*    */   public static void init() {}
/*    */   
/*    */   public static void tick() {
/* 12 */     if (Player.mapMovement) {
/* 14 */       if (Player.playerX == 606.0F && 
/* 15 */         Player.playerY <= 104.0F && Player.playerY != 0.0F) {
/* 16 */         Player.canMoveRight = 0;
/*    */       } else {
/* 18 */         Player.canMoveRight = 1;
/*    */       } 
/* 20 */       if (Player.playerX >= 607.0F && Player.playerX <= 739.0F && 
/* 21 */         Player.playerY <= 104.0F && Player.playerY >= 1.0F) {
/* 22 */         Player.canMoveUp = 0;
/*    */       } else {
/* 24 */         Player.canMoveUp = 1;
/*    */       } 
/* 26 */       if (Player.playerX == 739.0F && 
/* 27 */         Player.playerY <= 104.0F && Player.playerY != 0.0F) {
/* 28 */         Player.canMoveLeft = 0;
/*    */       } else {
/* 30 */         Player.canMoveLeft = 1;
/*    */       } 
/* 32 */       if (Player.playerX >= 607.0F && Player.playerX <= 739.0F && 
/* 33 */         Player.playerY == 0.0F) {
/* 34 */         Player.canMoveDown = 0;
/*    */       } else {
/* 36 */         Player.canMoveDown = 1;
/*    */       } 
/*    */     } else {
/* 41 */       Player.canMoveRight = 1;
/* 42 */       Player.canMoveUp = 1;
/* 43 */       Player.canMoveLeft = 1;
/* 44 */       Player.canMoveDown = 1;
/*    */     } 
/* 46 */     if (ShopManager.overlay != 0 && ShopManager.overlay != 248 && (Player.mapMovement || Player.insideMovement)) {
/* 48 */       Player.canMoveUp = 0;
/* 49 */       Player.canMoveDown = 0;
/* 50 */       Player.canMoveLeft = 0;
/* 51 */       Player.canMoveRight = 0;
/*    */     } else {
/* 55 */       Player.canMoveUp = 1;
/* 56 */       Player.canMoveDown = 1;
/* 57 */       Player.canMoveLeft = 1;
/* 58 */       Player.canMoveRight = 1;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.4.6_2.jar!\beyondOrigins\main\CollisionManager.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */