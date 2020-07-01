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
/*  22 */     grassmap[46][4] = 10;
/*  23 */     grassmap[46][5] = 14;
/*  24 */     grassmap[45][5] = 11;
/*  25 */     grassmap[44][5] = 11;
/*  26 */     grassmap[43][5] = 11;
/*  27 */     grassmap[42][5] = 11;
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
/*  56 */         int grassx = (int)((32 * x) - Player.mapX - Game.playerSpawnX);
/*  57 */         int grassy = (int)((32 * y) - Player.mapY - Game.playerSpawnY);
/*  61 */         int tileID = grassmap[x][y];
/*  65 */         if (tileID == 0)
/*  66 */           g.drawImage(ImageManager.grassFull, grassx, grassy, 32, 32, 
/*  67 */               null); 
/*  70 */         if (tileID == 1)
/*  71 */           g.drawImage(ImageManager.grassCnr1, grassx, grassy, 32, 32, 
/*  72 */               null); 
/*  75 */         if (tileID == 2)
/*  76 */           g.drawImage(ImageManager.grassCnr2, grassx, grassy, 32, 32, 
/*  77 */               null); 
/*  80 */         if (tileID == 3)
/*  81 */           g.drawImage(ImageManager.grassCnr3, grassx, grassy, 32, 32, 
/*  82 */               null); 
/*  85 */         if (tileID == 4)
/*  86 */           g.drawImage(ImageManager.grassCnr4, grassx, grassy, 32, 32, 
/*  87 */               null); 
/*  90 */         if (tileID == 5)
/*  91 */           g.drawImage(ImageManager.grassEdge1, grassx, grassy, 32, 
/*  92 */               32, null); 
/*  95 */         if (tileID == 6)
/*  96 */           g.drawImage(ImageManager.grassEdge2, grassx, grassy, 32, 
/*  97 */               32, null); 
/* 100 */         if (tileID == 7)
/* 101 */           g.drawImage(ImageManager.grassEdge3, grassx, grassy, 32, 
/* 102 */               32, null); 
/* 105 */         if (tileID == 8)
/* 106 */           g.drawImage(ImageManager.grassEdge4, grassx, grassy, 32, 
/* 107 */               32, null); 
/* 110 */         if (tileID == 9)
/* 111 */           g.drawImage(ImageManager.grassTree1, grassx, grassy, 32, 
/* 112 */               32, null); 
/* 115 */         if (tileID == 10)
/* 116 */           g.drawImage(ImageManager.path1_1, grassx, grassy, 32, 32, 
/* 117 */               null); 
/* 120 */         if (tileID == 11)
/* 121 */           g.drawImage(ImageManager.path1_2, grassx, grassy, 32, 32, 
/* 122 */               null); 
/* 125 */         if (tileID == 12)
/* 126 */           g.drawImage(ImageManager.path1Cnr1, grassx, grassy, 32, 32, 
/* 127 */               null); 
/* 130 */         if (tileID == 13)
/* 131 */           g.drawImage(ImageManager.path1Cnr2, grassx, grassy, 32, 32, 
/* 132 */               null); 
/* 135 */         if (tileID == 14)
/* 136 */           g.drawImage(ImageManager.path1Cnr3, grassx, grassy, 32, 32, 
/* 137 */               null); 
/* 140 */         if (tileID == 15)
/* 141 */           g.drawImage(ImageManager.path1Cnr4, grassx, grassy, 32, 32, 
/* 142 */               null); 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.4.2_3.jar!\applecraft\testgame\main\maps\GrassMap.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */