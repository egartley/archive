/*    */ package beyondOrigins.main.maps;
/*    */ 
/*    */ import beyondOrigins.main.Game;
/*    */ import beyondOrigins.main.gfx.ImageManager;
/*    */ import java.awt.Graphics;
/*    */ 
/*    */ public class GrassMap extends Map {
/* 10 */   private static int sizeX = 53;
/*    */   
/* 11 */   private static int sizeY = 35;
/*    */   
/* 12 */   public static int[][] grassmap = new int[sizeX][sizeY];
/*    */   
/*    */   public GrassMap() {
/* 15 */     for (int i = 0; i < sizeX - 1; i++) {
/* 16 */       for (int j = 0; j < sizeY - 1; j++)
/* 17 */         grassmap[i][j] = 0; 
/*    */     } 
/* 20 */     for (int y = 0; y < sizeY; y++) {
/* 21 */       grassmap[0][y] = 1;
/* 22 */       grassmap[sizeX - 2][y] = 1;
/*    */     } 
/* 24 */     for (int x = 0; x < sizeX; x++) {
/* 25 */       grassmap[x][0] = 1;
/* 26 */       grassmap[x][sizeY - 2] = 1;
/*    */     } 
/*    */   }
/*    */   
/*    */   public void tick() {}
/*    */   
/*    */   public void render(Graphics g) {
/* 35 */     for (int x = 0; x < sizeX - 1; x++) {
/* 36 */       for (int y = 0; y < sizeY - 1; y++) {
/* 37 */         int gx = (int)((32 * x) - (Game.getPlayer()).mapX - Game.playerSpawnX);
/* 38 */         int gy = (int)((32 * y) - (Game.getPlayer()).mapY - Game.playerSpawnY);
/* 40 */         int tileID = grassmap[x][y];
/* 50 */         if (tileID == 0) {
/* 51 */           g.drawImage(ImageManager.grassFull, gx, gy, null);
/* 52 */         } else if (tileID == 1) {
/* 53 */           g.drawImage(ImageManager.grassBarrier, gx, gy, null);
/*    */         } else {
/* 55 */           g.drawImage(ImageManager.grassFull, gx, gy, null);
/*    */         } 
/*    */       } 
/*    */     } 
/*    */   }
/*    */   
/*    */   public static int getTileID(int x, int y) {
/* 62 */     return grassmap[x][y];
/*    */   }
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.6_3.jar!\beyondOrigins\main\maps\GrassMap.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */