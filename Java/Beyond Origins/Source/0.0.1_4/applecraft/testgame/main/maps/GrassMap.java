/*    */ package applecraft.testgame.main.maps;
/*    */ 
/*    */ import applecraft.testgame.main.gfx.ImageManager;
/*    */ import applecraft.testgame.main.tiles.Tile;
/*    */ import java.awt.Graphics;
/*    */ 
/*    */ public class GrassMap extends Tile {
/* 12 */   private static int[][] grassmap = new int[26][17];
/*    */   
/*    */   public static void init() {
/* 16 */     grassmap[0][0] = 1;
/* 17 */     grassmap[25][0] = 2;
/* 18 */     grassmap[25][16] = 3;
/* 19 */     grassmap[0][16] = 4;
/*    */     int test;
/* 21 */     for (test = 1; test <= 24; test++) {
/* 22 */       grassmap[test][0] = 5;
/* 23 */       grassmap[test][16] = 7;
/*    */     } 
/* 26 */     for (test = 1; test <= 15; test++) {
/* 27 */       grassmap[0][test] = 8;
/* 28 */       grassmap[25][test] = 6;
/*    */     } 
/*    */   }
/*    */   
/*    */   public GrassMap(ImageManager im) {
/* 34 */     super(im);
/*    */   }
/*    */   
/*    */   public void tick() {}
/*    */   
/*    */   public void render(Graphics g) {
/* 43 */     for (int x = 0; x < 26; x++) {
/* 44 */       for (int y = 0; y < 17; y++) {
/* 48 */         int grassx = 32 * x;
/* 49 */         int grassy = 32 * y;
/* 53 */         int tileID = grassmap[x][y];
/* 57 */         if (tileID == 0)
/* 58 */           g.drawImage(ImageManager.grassFull, grassx, grassy, 32, 32, null); 
/* 61 */         if (tileID == 1)
/* 62 */           g.drawImage(ImageManager.grassCnr1, grassx, grassy, 32, 32, null); 
/* 65 */         if (tileID == 2)
/* 66 */           g.drawImage(ImageManager.grassCnr2, grassx, grassy, 32, 32, null); 
/* 69 */         if (tileID == 3)
/* 70 */           g.drawImage(ImageManager.grassCnr3, grassx, grassy, 32, 32, null); 
/* 73 */         if (tileID == 4)
/* 74 */           g.drawImage(ImageManager.grassCnr4, grassx, grassy, 32, 32, null); 
/* 77 */         if (tileID == 5)
/* 78 */           g.drawImage(ImageManager.grassEdge1, grassx, grassy, 32, 32, null); 
/* 81 */         if (tileID == 6)
/* 82 */           g.drawImage(ImageManager.grassEdge2, grassx, grassy, 32, 32, null); 
/* 85 */         if (tileID == 7)
/* 86 */           g.drawImage(ImageManager.grassEdge3, grassx, grassy, 32, 32, null); 
/* 89 */         if (tileID == 8)
/* 90 */           g.drawImage(ImageManager.grassEdge4, grassx, grassy, 32, 32, null); 
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.1_4.jar!\applecraft\testgame\main\maps\GrassMap.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */