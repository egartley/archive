/*    */ package beyondOrigins.main.maps;
/*    */ 
/*    */ import beyondOrigins.main.Game;
/*    */ import beyondOrigins.main.entities.Player;
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
/*    */   public GrassMap() {
/* 16 */     grassmap[0][0] = 1;
/* 17 */     grassmap[sizeX - 2][0] = 2;
/* 18 */     grassmap[sizeX - 2][sizeY - 2] = 3;
/* 19 */     grassmap[0][sizeY - 2] = 4;
/*    */     int test;
/* 20 */     for (test = 1; test <= sizeX - 3; test++) {
/* 21 */       grassmap[test][0] = 5;
/* 22 */       grassmap[test][sizeY - 2] = 7;
/*    */     } 
/* 24 */     for (test = 1; test <= sizeY - 3; test++) {
/* 25 */       grassmap[0][test] = 8;
/* 26 */       grassmap[sizeX - 2][test] = 6;
/*    */     } 
/*    */   }
/*    */   
/*    */   public void tick() {}
/*    */   
/*    */   public void render(Graphics g) {
/* 34 */     for (int x = 0; x < sizeX - 1; x++) {
/* 35 */       for (int y = 0; y < sizeY - 1; y++) {
/* 36 */         int grassx = (int)((32 * x) - Player.mapX - Game.playerSpawnX);
/* 37 */         int grassy = (int)((32 * y) - Player.mapY - Game.playerSpawnY);
/* 39 */         int tileID = grassmap[x][y];
/* 40 */         if (tileID == 0)
/* 41 */           g.drawImage(ImageManager.grassFull, grassx, grassy, 32, 32, 
/* 42 */               null); 
/* 44 */         if (tileID == 1)
/* 45 */           g.drawImage(ImageManager.grassCnr1, grassx, grassy, 32, 32, 
/* 46 */               null); 
/* 48 */         if (tileID == 2)
/* 49 */           g.drawImage(ImageManager.grassCnr2, grassx, grassy, 32, 32, 
/* 50 */               null); 
/* 52 */         if (tileID == 3)
/* 53 */           g.drawImage(ImageManager.grassCnr3, grassx, grassy, 32, 32, 
/* 54 */               null); 
/* 56 */         if (tileID == 4)
/* 57 */           g.drawImage(ImageManager.grassCnr4, grassx, grassy, 32, 32, 
/* 58 */               null); 
/* 60 */         if (tileID == 5)
/* 61 */           g.drawImage(ImageManager.grassEdge1, grassx, grassy, 32, 
/* 62 */               32, null); 
/* 64 */         if (tileID == 6)
/* 65 */           g.drawImage(ImageManager.grassEdge2, grassx, grassy, 32, 
/* 66 */               32, null); 
/* 68 */         if (tileID == 7)
/* 69 */           g.drawImage(ImageManager.grassEdge3, grassx, grassy, 32, 
/* 70 */               32, null); 
/* 72 */         if (tileID == 8)
/* 73 */           g.drawImage(ImageManager.grassEdge4, grassx, grassy, 32, 
/* 74 */               32, null); 
/* 76 */         if (tileID == 9)
/* 77 */           g.drawImage(ImageManager.grassTree1, grassx, grassy, 32, 
/* 78 */               32, null); 
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.5_6.jar!\beyondOrigins\main\maps\GrassMap.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */