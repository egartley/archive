/*    */ package beyondOrigins.main.maps;
/*    */ 
/*    */ import beyondOrigins.main.Game;
/*    */ import beyondOrigins.main.gfx.Animate;
/*    */ import beyondOrigins.main.gfx.ImageManager;
/*    */ import java.awt.Graphics;
/*    */ 
/*    */ public class GrassMap extends Map {
/* 11 */   private static int sizeX = 53;
/*    */   
/* 12 */   private static int sizeY = 35;
/*    */   
/* 13 */   public static int[][] grassmap = new int[sizeX][sizeY];
/*    */   
/* 14 */   double waterCount = 2.0D;
/*    */   
/*    */   private static Animate a;
/*    */   
/*    */   public GrassMap() {
/* 18 */     a = new Animate();
/* 19 */     for (int i = 0; i < sizeX - 1; i++) {
/* 20 */       for (int j = 0; j < sizeY - 1; j++)
/* 21 */         grassmap[i][j] = 0; 
/*    */     } 
/* 24 */     grassmap[11][3] = 2;
/* 25 */     grassmap[11][4] = 2;
/* 26 */     grassmap[12][2] = 2;
/* 27 */     grassmap[12][3] = 2;
/* 28 */     grassmap[12][4] = 2;
/* 29 */     grassmap[12][5] = 2;
/* 30 */     grassmap[13][2] = 2;
/* 31 */     grassmap[13][3] = 2;
/* 32 */     grassmap[13][4] = 2;
/* 33 */     grassmap[13][5] = 2;
/* 34 */     grassmap[14][2] = 2;
/* 35 */     grassmap[14][3] = 2;
/* 36 */     grassmap[14][4] = 2;
/* 37 */     grassmap[14][5] = 2;
/* 38 */     grassmap[15][3] = 2;
/* 39 */     grassmap[15][4] = 2;
/* 40 */     for (int y = 0; y < sizeY; y++) {
/* 41 */       grassmap[0][y] = 1;
/* 42 */       grassmap[sizeX - 2][y] = 1;
/*    */     } 
/* 44 */     for (int x = 0; x < sizeX; x++) {
/* 45 */       grassmap[x][0] = 1;
/* 46 */       grassmap[x][sizeY - 2] = 1;
/*    */     } 
/* 48 */     grassmap[4][sizeY - 4] = 3;
/*    */   }
/*    */   
/*    */   public void tick() {
/* 52 */     this.waterCount += 0.2D;
/* 53 */     if (this.waterCount >= 42.0D)
/* 54 */       this.waterCount = 2.0D; 
/*    */   }
/*    */   
/*    */   public void render(Graphics g) {
/* 59 */     for (int x = 0; x < sizeX - 1; x++) {
/* 60 */       for (int y = 0; y < sizeY - 1; y++) {
/* 61 */         int gx = 32 * x - (Game.getPlayer()).mapX - Game.playerSpawnX;
/* 62 */         int gy = 32 * y - (Game.getPlayer()).mapY - Game.playerSpawnY;
/* 63 */         if (gx >= -33 && gy >= -33 && gx <= Game.width && 
/* 64 */           gy <= Game.height) {
/* 65 */           int tileID = grassmap[x][y];
/* 66 */           if (tileID == 0) {
/* 67 */             g.drawImage(ImageManager.grassFull, gx, gy, null);
/* 68 */           } else if (tileID == 1) {
/* 69 */             g.drawImage(ImageManager.grassBarrier, gx, gy, null);
/* 70 */           } else if (tileID == 2) {
/* 71 */             a.animateTile(g, gx, gy, ImageManager.water, (short)(int)this.waterCount);
/* 72 */           } else if (tileID == 3) {
/* 73 */             g.drawImage(ImageManager.tree, gx, gy, null);
/*    */           } else {
/* 75 */             g.drawImage(ImageManager.grassFull, gx, gy, null);
/*    */           } 
/*    */         } 
/*    */       } 
/*    */     } 
/*    */   }
/*    */   
/*    */   public static int getTileID(int x, int y) {
/* 83 */     return grassmap[x][y];
/*    */   }
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.8_1.jar!\beyondOrigins\main\maps\GrassMap.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */