/*    */ package com.emgartley.beyondOrigins.main.maps;
/*    */ 
/*    */ import com.emgartley.beyondOrigins.main.Game;
/*    */ import com.emgartley.beyondOrigins.main.gfx.Animate;
/*    */ import com.emgartley.beyondOrigins.main.gfx.ImageManager;
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
/* 26 */     grassmap[12][3] = 2;
/* 27 */     grassmap[12][4] = 2;
/* 28 */     grassmap[13][3] = 2;
/* 29 */     grassmap[13][4] = 2;
/* 30 */     for (int y = 0; y < sizeY; y++) {
/* 31 */       grassmap[0][y] = 1;
/* 32 */       grassmap[sizeX - 2][y] = 1;
/*    */     } 
/*    */     int x;
/* 34 */     for (x = 0; x < sizeX; x++) {
/* 35 */       grassmap[x][0] = 1;
/* 36 */       grassmap[x][sizeY - 2] = 1;
/*    */     } 
/* 38 */     for (x = 1; x < 7; x++) {
/* 39 */       for (int j = sizeY - 8; j < sizeY - 2; j++)
/* 40 */         grassmap[x][j] = 3; 
/*    */     } 
/*    */   }
/*    */   
/*    */   public void tick() {
/* 46 */     this.waterCount += 0.2D;
/* 47 */     if (this.waterCount >= 42.0D)
/* 48 */       this.waterCount = 2.0D; 
/*    */   }
/*    */   
/*    */   public void render(Graphics g) {
/* 53 */     for (int x = 0; x < sizeX - 1; x++) {
/* 54 */       for (int y = 0; y < sizeY - 1; y++) {
/* 55 */         int gx = 32 * x - (Game.getPlayer()).mapX - Game.playerSpawnX;
/* 56 */         if (gx >= -33 && gx <= Game.width) {
/* 58 */           int gy = 32 * y - (Game.getPlayer()).mapY - Game.playerSpawnY;
/* 59 */           if (gy >= -33 && gy <= Game.height) {
/* 61 */             int tileID = grassmap[x][y];
/* 62 */             if (tileID == 0) {
/* 63 */               g.drawImage(ImageManager.grassFull, gx, gy, null);
/* 64 */             } else if (tileID == 1) {
/* 65 */               g.drawImage(ImageManager.grassBarrier, gx, gy, null);
/* 66 */             } else if (tileID == 2) {
/* 67 */               a.animateTile(g, gx, gy, ImageManager.water, 
/* 68 */                   (short)(int)this.waterCount);
/* 69 */             } else if (tileID == 3) {
/* 70 */               g.drawImage(ImageManager.tree, gx, gy, null);
/*    */             } else {
/* 72 */               g.drawImage(ImageManager.grassFull, gx, gy, null);
/*    */             } 
/*    */           } 
/*    */         } 
/*    */       } 
/*    */     } 
/*    */   }
/*    */   
/*    */   public static int getTileID(int x, int y) {
/* 79 */     return grassmap[x][y];
/*    */   }
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.1.0_2.jar!\com\emgartley\beyondOrigins\main\maps\GrassMap.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */