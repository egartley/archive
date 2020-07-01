/*    */ package beyondOrigins.main.buildings;
/*    */ 
/*    */ import beyondOrigins.main.Game;
/*    */ import beyondOrigins.main.gfx.ImageManager;
/*    */ import beyondOrigins.main.maps.GrassMap;
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
/*    */   public static void init() {
/* 16 */     shop1X = 96;
/* 17 */     shop1Y = 96;
/* 19 */     for (int x = 3; x < 6; x++) {
/* 20 */       for (int y = 3; y < 6; y++) {
/* 21 */         Game.getMap();
/* 21 */         GrassMap.grassmap[x][y] = 99;
/*    */       } 
/*    */     } 
/*    */   }
/*    */   
/*    */   public void render(Graphics g) {
/* 27 */     render1X = shop1X - (Game.getPlayer()).mapX + Game.playerSpawnX;
/* 28 */     render1Y = shop1Y - (Game.getPlayer()).mapY + Game.playerSpawnY;
/* 30 */     g.drawImage(ImageManager.shop1, (int)render1X, (int)render1Y, 96, 96, 
/* 31 */         null);
/*    */   }
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.6_4.jar!\beyondOrigins\main\buildings\BuildingRender.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */