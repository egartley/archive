/*     */ package applecraft.testgame.main.maps;
/*     */ 
/*     */ import applecraft.testgame.main.Game;
/*     */ import applecraft.testgame.main.entities.Player;
/*     */ import applecraft.testgame.main.gfx.ImageManager;
/*     */ import applecraft.testgame.main.tiles.Tile;
/*     */ import java.awt.Graphics;
/*     */ 
/*     */ public class GrassMap extends Tile {
/*  15 */   private static int sizeX = 52;
/*     */   
/*  15 */   private static int sizeY = 34;
/*     */   
/*  17 */   public static int[][] grassmap = new int[sizeX][sizeY];
/*     */   
/*     */   public static void init() {
/*  21 */     grassmap[0][0] = 1;
/*  22 */     grassmap[sizeX - 2][0] = 2;
/*  23 */     grassmap[sizeX - 2][sizeY - 2] = 3;
/*  24 */     grassmap[0][sizeY - 2] = 4;
/*  25 */     grassmap[18][sizeY - 4] = 9;
/*  26 */     grassmap[18][sizeY - 5] = 9;
/*  27 */     grassmap[18][sizeY - 6] = 9;
/*     */     int test;
/*  29 */     for (test = 1; test <= sizeX - 3; test++) {
/*  30 */       grassmap[test][0] = 5;
/*  31 */       grassmap[test][sizeY - 2] = 7;
/*     */     } 
/*  34 */     for (test = 1; test <= sizeY - 3; test++) {
/*  35 */       grassmap[0][test] = 8;
/*  36 */       grassmap[sizeX - 2][test] = 6;
/*     */     } 
/*     */   }
/*     */   
/*     */   public GrassMap(ImageManager im) {
/*  42 */     super(im);
/*     */   }
/*     */   
/*     */   public void tick() {}
/*     */   
/*     */   public void render(Graphics g) {
/*  51 */     for (int x = 0; x < sizeX - 1; x++) {
/*  52 */       for (int y = 0; y < sizeY - 1; y++) {
/*  56 */         int grassx = (int)((32 * x) - Player.mapX - Game.PlayerSpawnX);
/*  57 */         int grassy = (int)((32 * y) - Player.mapY - Game.PlayerSpawnY);
/*  61 */         int tileID = grassmap[x][y];
/*  65 */         if (tileID == 0)
/*  66 */           g.drawImage(ImageManager.grassFull, grassx, grassy, 32, 32, null); 
/*  69 */         if (tileID == 1)
/*  70 */           g.drawImage(ImageManager.grassCnr1, grassx, grassy, 32, 32, null); 
/*  73 */         if (tileID == 2)
/*  74 */           g.drawImage(ImageManager.grassCnr2, grassx, grassy, 32, 32, null); 
/*  77 */         if (tileID == 3)
/*  78 */           g.drawImage(ImageManager.grassCnr3, grassx, grassy, 32, 32, null); 
/*  81 */         if (tileID == 4)
/*  82 */           g.drawImage(ImageManager.grassCnr4, grassx, grassy, 32, 32, null); 
/*  85 */         if (tileID == 5)
/*  86 */           g.drawImage(ImageManager.grassEdge1, grassx, grassy, 32, 32, null); 
/*  89 */         if (tileID == 6)
/*  90 */           g.drawImage(ImageManager.grassEdge2, grassx, grassy, 32, 32, null); 
/*  93 */         if (tileID == 7)
/*  94 */           g.drawImage(ImageManager.grassEdge3, grassx, grassy, 32, 32, null); 
/*  97 */         if (tileID == 8)
/*  98 */           g.drawImage(ImageManager.grassEdge4, grassx, grassy, 32, 32, null); 
/* 101 */         if (tileID == 9)
/* 102 */           g.drawImage(ImageManager.grassTree1, grassx, grassy, 32, 32, null); 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.2_7.jar!\applecraft\testgame\main\maps\GrassMap.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */