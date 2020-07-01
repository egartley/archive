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
/* 20 */     grassmap[12][2] = 2;
/* 21 */     grassmap[13][2] = 2;
/* 22 */     grassmap[12][3] = 2;
/* 23 */     grassmap[13][3] = 2;
/* 24 */     grassmap[11][3] = 2;
/* 25 */     grassmap[12][4] = 2;
/* 26 */     for (int y = 0; y < sizeY; y++) {
/* 27 */       grassmap[0][y] = 1;
/* 28 */       grassmap[sizeX - 2][y] = 1;
/*    */     } 
/* 30 */     for (int x = 0; x < sizeX; x++) {
/* 31 */       grassmap[x][0] = 1;
/* 32 */       grassmap[x][sizeY - 2] = 1;
/*    */     } 
/*    */   }
/*    */   
/*    */   public void tick() {}
/*    */   
/*    */   public void render(Graphics g) {
/* 41 */     for (int x = 0; x < sizeX - 1; x++) {
/* 42 */       for (int y = 0; y < sizeY - 1; y++) {
/* 43 */         int gx = 32 * x - (Game.getPlayer()).mapX - Game.playerSpawnX;
/* 44 */         int gy = 32 * y - (Game.getPlayer()).mapY - Game.playerSpawnY;
/* 45 */         if (gx >= -33 && gy >= -33 && gx <= Game.width && 
/* 46 */           gy <= Game.height) {
/* 47 */           int tileID = grassmap[x][y];
/* 48 */           if (tileID == 0) {
/* 49 */             g.drawImage(ImageManager.grassFull, gx, gy, null);
/* 50 */           } else if (tileID == 1) {
/* 51 */             g.drawImage(ImageManager.grassBarrier, gx, gy, null);
/* 52 */           } else if (tileID == 2) {
/* 53 */             g.drawImage(ImageManager.water, gx, gy, null);
/*    */           } else {
/* 55 */             g.drawImage(ImageManager.grassFull, gx, gy, null);
/*    */           } 
/*    */         } 
/*    */       } 
/*    */     } 
/*    */   }
/*    */   
/*    */   public static int getTileID(int x, int y) {
/* 63 */     return grassmap[x][y];
/*    */   }
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.8_0.jar!\beyondOrigins\main\maps\GrassMap.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */