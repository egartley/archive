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
/* 12 */       if (Player.x == 606.0F && Player.y <= 104.0F && 
/* 13 */         Player.y != 0.0F) {
/* 14 */         Player.canMoveRight = false;
/*    */       } else {
/* 16 */         Player.canMoveRight = true;
/*    */       } 
/* 18 */       if (Player.x >= 607.0F && Player.x <= 739.0F && 
/* 19 */         Player.y <= 104.0F && Player.y >= 1.0F) {
/* 20 */         Player.canMoveUp = false;
/*    */       } else {
/* 22 */         Player.canMoveUp = true;
/*    */       } 
/* 24 */       if (Player.x == 739.0F && Player.y <= 104.0F && 
/* 25 */         Player.y != 0.0F) {
/* 26 */         Player.canMoveLeft = false;
/*    */       } else {
/* 28 */         Player.canMoveLeft = true;
/*    */       } 
/* 30 */       if (Player.x >= 607.0F && Player.x <= 739.0F && 
/* 31 */         Player.y == 0.0F) {
/* 32 */         Player.canMoveDown = false;
/*    */       } else {
/* 34 */         Player.canMoveDown = true;
/*    */       } 
/*    */     } else {
/* 37 */       Player.canMoveRight = true;
/* 38 */       Player.canMoveUp = true;
/* 39 */       Player.canMoveLeft = true;
/* 40 */       Player.canMoveDown = true;
/*    */     } 
/* 42 */     if (Shop.overlay != 0 && Shop.overlay != 248 && (
/* 43 */       Player.mapMovement || Player.insideMovement)) {
/* 44 */       Player.canMoveUp = false;
/* 45 */       Player.canMoveDown = false;
/* 46 */       Player.canMoveLeft = false;
/* 47 */       Player.canMoveRight = false;
/*    */     } else {
/* 49 */       Player.canMoveUp = true;
/* 50 */       Player.canMoveDown = true;
/* 51 */       Player.canMoveLeft = true;
/* 52 */       Player.canMoveRight = true;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.5_6.jar!\beyondOrigins\main\CollisionManager.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */