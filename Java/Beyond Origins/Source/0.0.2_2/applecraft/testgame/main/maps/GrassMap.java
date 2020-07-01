/*    */ package applecraft.testgame.main.maps;
/*    */ 
/*    */ import applecraft.testgame.main.gfx.ImageManager;
/*    */ import applecraft.testgame.main.tiles.Tile;
/*    */ import java.awt.Graphics;
/*    */ 
/*    */ public class GrassMap extends Tile {
/* 10 */   private static int[][] grassmap = new int[26][17];
/*    */   
/*    */   public static void init() {
/* 14 */     grassmap[0][0] = 1;
/* 15 */     grassmap[25][0] = 2;
/* 16 */     grassmap[25][16] = 3;
/* 17 */     grassmap[0][16] = 4;
/*    */     int test;
/* 19 */     for (test = 1; test <= 24; test++) {
/* 20 */       grassmap[test][0] = 5;
/* 21 */       grassmap[test][16] = 7;
/*    */     } 
/* 24 */     for (test = 1; test <= 15; test++) {
/* 25 */       grassmap[0][test] = 8;
/* 26 */       grassmap[25][test] = 6;
/*    */     } 
/*    */   }
/*    */   
/*    */   public GrassMap(ImageManager im) {
/* 32 */     super(im);
/*    */   }
/*    */   
/*    */   public void tick() {}
/*    */   
/*    */   public void render(Graphics g) {
/* 41 */     for (int x = 0; x < 26; x++) {
/* 42 */       for (int y = 0; y < 17; y++) {
/* 46 */         int grassx = 32 * x;
/* 47 */         int grassy = 32 * y;
/* 51 */         int tileID = grassmap[x][y];
/* 55 */         if (tileID == 0)
/* 56 */           g.drawImage(ImageManager.grassFull, grassx, grassy, 32, 32, null); 
/* 59 */         if (tileID == 1)
/* 60 */           g.drawImage(ImageManager.grassCnr1, grassx, grassy, 32, 32, null); 
/* 63 */         if (tileID == 2)
/* 64 */           g.drawImage(ImageManager.grassCnr2, grassx, grassy, 32, 32, null); 
/* 67 */         if (tileID == 3)
/* 68 */           g.drawImage(ImageManager.grassCnr3, grassx, grassy, 32, 32, null); 
/* 71 */         if (tileID == 4)
/* 72 */           g.drawImage(ImageManager.grassCnr4, grassx, grassy, 32, 32, null); 
/* 75 */         if (tileID == 5)
/* 76 */           g.drawImage(ImageManager.grassEdge1, grassx, grassy, 32, 32, null); 
/* 79 */         if (tileID == 6)
/* 80 */           g.drawImage(ImageManager.grassEdge2, grassx, grassy, 32, 32, null); 
/* 83 */         if (tileID == 7)
/* 84 */           g.drawImage(ImageManager.grassEdge3, grassx, grassy, 32, 32, null); 
/* 87 */         if (tileID == 8)
/* 88 */           g.drawImage(ImageManager.grassEdge4, grassx, grassy, 32, 32, null); 
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.2_2.jar!\applecraft\testgame\main\maps\GrassMap.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */