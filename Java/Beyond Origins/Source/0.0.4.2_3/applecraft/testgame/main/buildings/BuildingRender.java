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
/* 29 */       if (Player.tileX == 44 && Player.tileY <= 3) {
/* 30 */         Player.canMoveRight = 0;
/*    */       } else {
/* 32 */         Player.canMoveRight = 1;
/*    */       } 
/* 34 */       if (Player.tileX >= 45 && Player.tileX <= 47 && Player.playerY <= 104.0F) {
/* 35 */         Player.canMoveUp = 0;
/*    */       } else {
/* 37 */         Player.canMoveUp = 1;
/*    */       } 
/* 39 */       if (Player.tileX == 48 && Player.tileY <= 3) {
/* 40 */         Player.canMoveLeft = 0;
/*    */       } else {
/* 42 */         Player.canMoveLeft = 1;
/*    */       } 
/*    */     } else {
/* 44 */       Player.canMoveRight = 1;
/* 45 */       Player.canMoveUp = 1;
/* 46 */       Player.canMoveLeft = 1;
/*    */     } 
/*    */   }
/*    */   
/*    */   public void render(Graphics g) {
/* 53 */     shop1X = 1440;
/* 54 */     shop1Y = 32;
/* 56 */     render1X = shop1X - Player.mapX + Game.playerSpawnX;
/* 57 */     render1Y = shop1Y - Player.mapY + Game.playerSpawnY;
/* 59 */     g.drawImage(ImageManager.shop1, (int)render1X, (int)render1Y, 96, 96, null);
/*    */   }
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.4.2_3.jar!\applecraft\testgame\main\buildings\BuildingRender.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */