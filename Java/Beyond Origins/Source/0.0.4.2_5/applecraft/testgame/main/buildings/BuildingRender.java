/*    */ package applecraft.testgame.main.buildings;
/*    */ 
/*    */ import applecraft.testgame.main.Game;
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
/* 21 */     this.im = im;
/*    */   }
/*    */   
/*    */   public void tick() {
/* 28 */     if (Player.mapMovement) {
/* 29 */       if (Player.playerX == 606.0F && Player.playerY <= 104.0F && Player.playerY != 0.0F) {
/* 30 */         Player.canMoveRight = 0;
/*    */       } else {
/* 32 */         Player.canMoveRight = 1;
/*    */       } 
/* 34 */       if (Player.playerX >= 607.0F && Player.playerX <= 739.0F && Player.playerY <= 104.0F && Player.playerY >= 1.0F) {
/* 35 */         Player.canMoveUp = 0;
/*    */       } else {
/* 37 */         Player.canMoveUp = 1;
/*    */       } 
/* 39 */       if (Player.playerX == 739.0F && Player.playerY <= 104.0F && Player.playerY != 0.0F) {
/* 40 */         Player.canMoveLeft = 0;
/*    */       } else {
/* 42 */         Player.canMoveLeft = 1;
/*    */       } 
/* 43 */       if (Player.playerX >= 607.0F && Player.playerX <= 739.0F && Player.playerY == 0.0F) {
/* 44 */         Player.canMoveDown = 0;
/*    */       } else {
/* 46 */         Player.canMoveDown = 1;
/*    */       } 
/*    */     } else {
/* 48 */       Player.canMoveRight = 1;
/* 49 */       Player.canMoveUp = 1;
/* 50 */       Player.canMoveLeft = 1;
/* 51 */       Player.canMoveDown = 1;
/*    */     } 
/*    */   }
/*    */   
/*    */   public void render(Graphics g) {
/* 58 */     shop1X = 1440;
/* 59 */     shop1Y = 32;
/* 61 */     render1X = shop1X - Player.mapX + Game.playerSpawnX;
/* 62 */     render1Y = shop1Y - Player.mapY + Game.playerSpawnY;
/* 64 */     g.drawImage(ImageManager.shop1, (int)render1X, (int)render1Y, 96, 96, null);
/*    */   }
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.4.2_5.jar!\applecraft\testgame\main\buildings\BuildingRender.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */