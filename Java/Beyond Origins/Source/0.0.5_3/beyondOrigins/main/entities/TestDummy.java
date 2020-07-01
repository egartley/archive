/*    */ package beyondOrigins.main.entities;
/*    */ 
/*    */ import beyondOrigins.main.Game;
/*    */ import beyondOrigins.main.gfx.ImageManager;
/*    */ import java.awt.Color;
/*    */ import java.awt.Graphics;
/*    */ 
/*    */ public class TestDummy {
/* 12 */   public static float x = 200.0F;
/*    */   
/* 12 */   public static float y = 200.0F;
/*    */   
/*    */   public static float rx;
/*    */   
/*    */   public static float ry;
/*    */   
/* 13 */   public static short upCount = 1;
/*    */   
/* 13 */   public static short downCount = 1;
/*    */   
/* 13 */   public static short leftCount = 1;
/*    */   
/* 13 */   public static short rightCount = 1;
/*    */   
/*    */   public static boolean isMovingUp;
/*    */   
/*    */   public static boolean isMovingDown;
/*    */   
/*    */   public static boolean isMovingLeft;
/*    */   
/*    */   public static boolean isMovingRight;
/*    */   
/*    */   public static short lastDir;
/*    */   
/*    */   public TestDummy(ImageManager im) {}
/*    */   
/*    */   public void tick() {}
/*    */   
/*    */   public void render(Graphics g) {
/* 29 */     rx = x - Player.mapX + Game.playerSpawnX;
/* 30 */     ry = y - Player.mapY + Game.playerSpawnY;
/* 40 */     if (!isMovingUp && !isMovingDown && !isMovingLeft && 
/* 41 */       !isMovingRight && lastDir == 0) {
/* 43 */       g.setColor(Color.lightGray);
/* 44 */       g.fillRect((int)rx, (int)ry, 32, 32);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.5_3.jar!\beyondOrigins\main\entities\TestDummy.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */