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
/*    */   public GrassMap(ImageManager im) {
/* 16 */     super(im);
/* 17 */     grassmap[0][0] = 1;
/* 18 */     grassmap[sizeX - 2][0] = 2;
/* 19 */     grassmap[sizeX - 2][sizeY - 2] = 3;
/* 20 */     grassmap[0][sizeY - 2] = 4;
/*    */     int test;
/* 21 */     for (test = 1; test <= sizeX - 3; test++) {
/* 22 */       grassmap[test][0] = 5;
/* 23 */       grassmap[test][sizeY - 2] = 7;
/*    */     } 
/* 25 */     for (test = 1; test <= sizeY - 3; test++) {
/* 26 */       grassmap[0][test] = 8;
/* 27 */       grassmap[sizeX - 2][test] = 6;
/*    */     } 
/*    */   }
/*    */   
/*    */   public void tick() {}
/*    */   
/*    */   public void render(Graphics g) {
/* 35 */     for (int x = 0; x < sizeX - 1; x++) {
/* 36 */       for (int y = 0; y < sizeY - 1; y++) {
/* 37 */         int grassx = (int)((32 * x) - Player.mapX - Game.playerSpawnX);
/* 38 */         int grassy = (int)((32 * y) - Player.mapY - Game.playerSpawnY);
/* 40 */         int tileID = grassmap[x][y];
/* 41 */         if (tileID == 0)
/* 42 */           g.drawImage(ImageManager.grassFull, grassx, grassy, 32, 32, 
/* 43 */               null); 
/* 45 */         if (tileID == 1)
/* 46 */           g.drawImage(ImageManager.grassCnr1, grassx, grassy, 32, 32, 
/* 47 */               null); 
/* 49 */         if (tileID == 2)
/* 50 */           g.drawImage(ImageManager.grassCnr2, grassx, grassy, 32, 32, 
/* 51 */               null); 
/* 53 */         if (tileID == 3)
/* 54 */           g.drawImage(ImageManager.grassCnr3, grassx, grassy, 32, 32, 
/* 55 */               null); 
/* 57 */         if (tileID == 4)
/* 58 */           g.drawImage(ImageManager.grassCnr4, grassx, grassy, 32, 32, 
/* 59 */               null); 
/* 61 */         if (tileID == 5)
/* 62 */           g.drawImage(ImageManager.grassEdge1, grassx, grassy, 32, 
/* 63 */               32, null); 
/* 65 */         if (tileID == 6)
/* 66 */           g.drawImage(ImageManager.grassEdge2, grassx, grassy, 32, 
/* 67 */               32, null); 
/* 69 */         if (tileID == 7)
/* 70 */           g.drawImage(ImageManager.grassEdge3, grassx, grassy, 32, 
/* 71 */               32, null); 
/* 73 */         if (tileID == 8)
/* 74 */           g.drawImage(ImageManager.grassEdge4, grassx, grassy, 32, 
/* 75 */               32, null); 
/* 77 */         if (tileID == 9)
/* 78 */           g.drawImage(ImageManager.grassTree1, grassx, grassy, 32, 
/* 79 */               32, null); 
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.5_5.jar!\beyondOrigins\main\maps\GrassMap.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */