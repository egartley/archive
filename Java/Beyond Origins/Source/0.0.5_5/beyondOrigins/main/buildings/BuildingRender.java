/*    */ package beyondOrigins.main.buildings;
/*    */ 
/*    */ import beyondOrigins.main.Game;
/*    */ import beyondOrigins.main.entities.Player;
/*    */ import beyondOrigins.main.gfx.ImageManager;
/*    */ import java.awt.Graphics;
/*    */ 
/*    */ public class BuildingRender {
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
/*    */   public void render(Graphics g) {
/* 23 */     shop1X = 1440;
/* 24 */     shop1Y = 32;
/* 26 */     render1X = shop1X - Player.mapX + Game.playerSpawnX;
/* 27 */     render1Y = shop1Y - Player.mapY + Game.playerSpawnY;
/* 29 */     g.drawImage(ImageManager.shop1, (int)render1X, (int)render1Y, 96, 96, 
/* 30 */         null);
/*    */   }
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.5_5.jar!\beyondOrigins\main\buildings\BuildingRender.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */