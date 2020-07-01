/*     */ package applecraft.testgame.main.maps;
/*     */ 
/*     */ import applecraft.testgame.main.Game;
/*     */ import applecraft.testgame.main.entities.Player;
/*     */ import applecraft.testgame.main.gfx.ImageManager;
/*     */ import applecraft.testgame.main.tiles.Tile;
/*     */ import java.awt.Graphics;
/*     */ 
/*     */ public class GrassMap extends Tile {
/*  12 */   private static int sizeX = 52;
/*     */   
/*  12 */   private static int sizeY = 34;
/*     */   
/*  14 */   public static int[][] grassmap = new int[sizeX][sizeY];
/*     */   
/*     */   public static void init() {
/*  18 */     grassmap[0][0] = 1;
/*  19 */     grassmap[sizeX - 2][0] = 2;
/*  20 */     grassmap[sizeX - 2][sizeY - 2] = 3;
/*  21 */     grassmap[0][sizeY - 2] = 4;
/*  22 */     grassmap[18][sizeY - 4] = 9;
/*  23 */     grassmap[18][sizeY - 5] = 9;
/*  24 */     grassmap[18][sizeY - 6] = 9;
/*     */     int test;
/*  26 */     for (test = 1; test <= sizeX - 3; test++) {
/*  27 */       grassmap[test][0] = 5;
/*  28 */       grassmap[test][sizeY - 2] = 7;
/*     */     } 
/*  31 */     for (test = 1; test <= sizeY - 3; test++) {
/*  32 */       grassmap[0][test] = 8;
/*  33 */       grassmap[sizeX - 2][test] = 6;
/*     */     } 
/*     */   }
/*     */   
/*     */   public GrassMap(ImageManager im) {
/*  39 */     super(im);
/*     */   }
/*     */   
/*     */   public void tick() {}
/*     */   
/*     */   public void render(Graphics g) {
/*  48 */     for (int x = 0; x < sizeX - 1; x++) {
/*  49 */       for (int y = 0; y < sizeY - 1; y++) {
/*  53 */         int grassx = (int)((32 * x) - Player.mapX - Game.playerSpawnX);
/*  54 */         int grassy = (int)((32 * y) - Player.mapY - Game.playerSpawnY);
/*  58 */         int tileID = grassmap[x][y];
/*  62 */         if (tileID == 0)
/*  63 */           g.drawImage(ImageManager.grassFull, grassx, grassy, 32, 32, 
/*  64 */               null); 
/*  67 */         if (tileID == 1)
/*  68 */           g.drawImage(ImageManager.grassCnr1, grassx, grassy, 32, 32, 
/*  69 */               null); 
/*  72 */         if (tileID == 2)
/*  73 */           g.drawImage(ImageManager.grassCnr2, grassx, grassy, 32, 32, 
/*  74 */               null); 
/*  77 */         if (tileID == 3)
/*  78 */           g.drawImage(ImageManager.grassCnr3, grassx, grassy, 32, 32, 
/*  79 */               null); 
/*  82 */         if (tileID == 4)
/*  83 */           g.drawImage(ImageManager.grassCnr4, grassx, grassy, 32, 32, 
/*  84 */               null); 
/*  87 */         if (tileID == 5)
/*  88 */           g.drawImage(ImageManager.grassEdge1, grassx, grassy, 32, 
/*  89 */               32, null); 
/*  92 */         if (tileID == 6)
/*  93 */           g.drawImage(ImageManager.grassEdge2, grassx, grassy, 32, 
/*  94 */               32, null); 
/*  97 */         if (tileID == 7)
/*  98 */           g.drawImage(ImageManager.grassEdge3, grassx, grassy, 32, 
/*  99 */               32, null); 
/* 102 */         if (tileID == 8)
/* 103 */           g.drawImage(ImageManager.grassEdge4, grassx, grassy, 32, 
/* 104 */               32, null); 
/* 107 */         if (tileID == 9)
/* 108 */           g.drawImage(ImageManager.grassTree1, grassx, grassy, 32, 
/* 109 */               32, null); 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.3_1.jar!\applecraft\testgame\main\maps\GrassMap.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */