/*    */ package beyondOrigins.main;
/*    */ 
/*    */ import beyondOrigins.main.buildings.shop.Shop;
/*    */ import beyondOrigins.main.entities.Player;
/*    */ 
/*    */ public class CollisionManager {
/*    */   public static void init() {}
/*    */   
/*    */   public static void tick() {
/* 11 */     if (Player.mapMovement) {
/* 12 */       if (Player.playerX == 606.0F && Player.playerY <= 104.0F && 
/* 13 */         Player.playerY != 0.0F) {
/* 14 */         Player.canMoveRight = 0;
/*    */       } else {
/* 16 */         Player.canMoveRight = 1;
/*    */       } 
/* 18 */       if (Player.playerX >= 607.0F && Player.playerX <= 739.0F && 
/* 19 */         Player.playerY <= 104.0F && Player.playerY >= 1.0F) {
/* 20 */         Player.canMoveUp = 0;
/*    */       } else {
/* 22 */         Player.canMoveUp = 1;
/*    */       } 
/* 24 */       if (Player.playerX == 739.0F && Player.playerY <= 104.0F && 
/* 25 */         Player.playerY != 0.0F) {
/* 26 */         Player.canMoveLeft = 0;
/*    */       } else {
/* 28 */         Player.canMoveLeft = 1;
/*    */       } 
/* 30 */       if (Player.playerX >= 607.0F && Player.playerX <= 739.0F && 
/* 31 */         Player.playerY == 0.0F) {
/* 32 */         Player.canMoveDown = 0;
/*    */       } else {
/* 34 */         Player.canMoveDown = 1;
/*    */       } 
/*    */     } else {
/* 37 */       Player.canMoveRight = 1;
/* 38 */       Player.canMoveUp = 1;
/* 39 */       Player.canMoveLeft = 1;
/* 40 */       Player.canMoveDown = 1;
/*    */     } 
/* 42 */     if (Shop.overlay != 0 && Shop.overlay != 248 && (
/* 43 */       Player.mapMovement || Player.insideMovement)) {
/* 44 */       Player.canMoveUp = 0;
/* 45 */       Player.canMoveDown = 0;
/* 46 */       Player.canMoveLeft = 0;
/* 47 */       Player.canMoveRight = 0;
/*    */     } else {
/* 49 */       Player.canMoveUp = 1;
/* 50 */       Player.canMoveDown = 1;
/* 51 */       Player.canMoveLeft = 1;
/* 52 */       Player.canMoveRight = 1;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.5_4.jar!\beyondOrigins\main\CollisionManager.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */