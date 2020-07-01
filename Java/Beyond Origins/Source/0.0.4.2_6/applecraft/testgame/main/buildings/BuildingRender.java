/*    */ package applecraft.testgame.main.buildings;
/*    */ 
/*    */ import applecraft.testgame.main.Game;
/*    */ import applecraft.testgame.main.buildings.shop.ShopManager;
/*    */ import applecraft.testgame.main.entities.Player;
/*    */ import applecraft.testgame.main.gfx.ImageManager;
/*    */ import java.awt.Graphics;
/*    */ 
/*    */ public class BuildingRender {
/*    */   private ImageManager im;
/*    */   
/*    */   public static float render1X;
/*    */   
/*    */   public static float render1Y;
/*    */   
/*    */   public static int shop1X;
/*    */   
/*    */   public static int shop1Y;
/*    */   
/*    */   public static void init() {}
/*    */   
/*    */   public BuildingRender(ImageManager im) {
/* 22 */     this.im = im;
/*    */   }
/*    */   
/*    */   public void tick() {
/* 29 */     if (Player.mapMovement) {
/* 30 */       if (Player.playerX == 606.0F && 
/* 31 */         Player.playerY <= 104.0F && Player.playerY != 0.0F) {
/* 32 */         Player.canMoveRight = 0;
/*    */       } else {
/* 34 */         Player.canMoveRight = 1;
/*    */       } 
/* 36 */       if (Player.playerX >= 607.0F && Player.playerX <= 739.0F && 
/* 37 */         Player.playerY <= 104.0F && Player.playerY >= 1.0F) {
/* 38 */         Player.canMoveUp = 0;
/*    */       } else {
/* 40 */         Player.canMoveUp = 1;
/*    */       } 
/* 42 */       if (Player.playerX == 739.0F && 
/* 43 */         Player.playerY <= 104.0F && Player.playerY != 0.0F) {
/* 44 */         Player.canMoveLeft = 0;
/*    */       } else {
/* 46 */         Player.canMoveLeft = 1;
/*    */       } 
/* 47 */       if (Player.playerX >= 607.0F && Player.playerX <= 739.0F && 
/* 48 */         Player.playerY == 0.0F) {
/* 49 */         Player.canMoveDown = 0;
/*    */       } else {
/* 51 */         Player.canMoveDown = 1;
/*    */       } 
/*    */     } else {
/* 53 */       Player.canMoveRight = 1;
/* 54 */       Player.canMoveUp = 1;
/* 55 */       Player.canMoveLeft = 1;
/* 56 */       Player.canMoveDown = 1;
/*    */     } 
/* 59 */     if (ShopManager.overlay != 0 && ShopManager.overlay != 248 && (Player.mapMovement || Player.insideMovement)) {
/* 60 */       Player.canMoveUp = 0;
/* 61 */       Player.canMoveDown = 0;
/* 62 */       Player.canMoveLeft = 0;
/* 63 */       Player.canMoveRight = 0;
/*    */     } else {
/* 65 */       Player.canMoveUp = 1;
/* 66 */       Player.canMoveDown = 1;
/* 67 */       Player.canMoveLeft = 1;
/* 68 */       Player.canMoveRight = 1;
/*    */     } 
/*    */   }
/*    */   
/*    */   public void render(Graphics g) {
/* 75 */     shop1X = 1440;
/* 76 */     shop1Y = 32;
/* 78 */     render1X = shop1X - Player.mapX + Game.playerSpawnX;
/* 79 */     render1Y = shop1Y - Player.mapY + Game.playerSpawnY;
/* 81 */     g.drawImage(ImageManager.shop1, (int)render1X, (int)render1Y, 96, 96, null);
/*    */   }
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.4.2_6.jar!\applecraft\testgame\main\buildings\BuildingRender.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */