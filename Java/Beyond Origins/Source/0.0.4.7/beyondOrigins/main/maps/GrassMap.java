/*     */ package beyondOrigins.main.maps;
/*     */ 
/*     */ import beyondOrigins.main.Game;
/*     */ import beyondOrigins.main.entities.Player;
/*     */ import beyondOrigins.main.gfx.ImageManager;
/*     */ import beyondOrigins.main.tiles.Tile;
/*     */ import java.awt.Graphics;
/*     */ 
/*     */ public class GrassMap extends Tile {
/*  11 */   private static int sizeY = 34;
/*     */   
/*  12 */   private static int sizeX = 52;
/*     */   
/*  13 */   public static int[][] grassmap = new int[sizeX][sizeY];
/*     */   
/*     */   public static void init() {
/*  16 */     grassmap[0][0] = 1;
/*  17 */     grassmap[sizeX - 2][0] = 2;
/*  18 */     grassmap[sizeX - 2][sizeY - 2] = 3;
/*  19 */     grassmap[0][sizeY - 2] = 4;
/*  20 */     grassmap[46][4] = 10;
/*  21 */     grassmap[46][5] = 14;
/*  22 */     grassmap[45][5] = 11;
/*  23 */     grassmap[44][5] = 11;
/*  24 */     grassmap[43][5] = 11;
/*  25 */     grassmap[42][5] = 11;
/*     */     int test;
/*  26 */     for (test = 1; test <= sizeX - 3; test++) {
/*  27 */       grassmap[test][0] = 5;
/*  28 */       grassmap[test][sizeY - 2] = 7;
/*     */     } 
/*  30 */     for (test = 1; test <= sizeY - 3; test++) {
/*  31 */       grassmap[0][test] = 8;
/*  32 */       grassmap[sizeX - 2][test] = 6;
/*     */     } 
/*     */   }
/*     */   
/*     */   public GrassMap(ImageManager im) {
/*  37 */     super(im);
/*     */   }
/*     */   
/*     */   public void tick() {}
/*     */   
/*     */   public void render(Graphics g) {
/*  44 */     for (int x = 0; x < sizeX - 1; x++) {
/*  45 */       for (int y = 0; y < sizeY - 1; y++) {
/*  46 */         int grassx = (int)((32 * x) - Player.mapX - Game.playerSpawnX);
/*  47 */         int grassy = (int)((32 * y) - Player.mapY - Game.playerSpawnY);
/*  49 */         int tileID = grassmap[x][y];
/*  50 */         if (tileID == 0)
/*  51 */           g.drawImage(ImageManager.grassFull, grassx, grassy, 32, 32, 
/*  52 */               null); 
/*  54 */         if (tileID == 1)
/*  55 */           g.drawImage(ImageManager.grassCnr1, grassx, grassy, 32, 32, 
/*  56 */               null); 
/*  58 */         if (tileID == 2)
/*  59 */           g.drawImage(ImageManager.grassCnr2, grassx, grassy, 32, 32, 
/*  60 */               null); 
/*  62 */         if (tileID == 3)
/*  63 */           g.drawImage(ImageManager.grassCnr3, grassx, grassy, 32, 32, 
/*  64 */               null); 
/*  66 */         if (tileID == 4)
/*  67 */           g.drawImage(ImageManager.grassCnr4, grassx, grassy, 32, 32, 
/*  68 */               null); 
/*  70 */         if (tileID == 5)
/*  71 */           g.drawImage(ImageManager.grassEdge1, grassx, grassy, 32, 
/*  72 */               32, null); 
/*  74 */         if (tileID == 6)
/*  75 */           g.drawImage(ImageManager.grassEdge2, grassx, grassy, 32, 
/*  76 */               32, null); 
/*  78 */         if (tileID == 7)
/*  79 */           g.drawImage(ImageManager.grassEdge3, grassx, grassy, 32, 
/*  80 */               32, null); 
/*  82 */         if (tileID == 8)
/*  83 */           g.drawImage(ImageManager.grassEdge4, grassx, grassy, 32, 
/*  84 */               32, null); 
/*  86 */         if (tileID == 9)
/*  87 */           g.drawImage(ImageManager.grassTree1, grassx, grassy, 32, 
/*  88 */               32, null); 
/*  90 */         if (tileID == 10)
/*  91 */           g.drawImage(ImageManager.path1_1, grassx, grassy, 32, 32, 
/*  92 */               null); 
/*  94 */         if (tileID == 11)
/*  95 */           g.drawImage(ImageManager.path1_2, grassx, grassy, 32, 32, 
/*  96 */               null); 
/*  98 */         if (tileID == 12)
/*  99 */           g.drawImage(ImageManager.path1Cnr1, grassx, grassy, 32, 32, 
/* 100 */               null); 
/* 102 */         if (tileID == 13)
/* 103 */           g.drawImage(ImageManager.path1Cnr2, grassx, grassy, 32, 32, 
/* 104 */               null); 
/* 106 */         if (tileID == 14)
/* 107 */           g.drawImage(ImageManager.path1Cnr3, grassx, grassy, 32, 32, 
/* 108 */               null); 
/* 110 */         if (tileID == 15)
/* 111 */           g.drawImage(ImageManager.path1Cnr4, grassx, grassy, 32, 32, 
/* 112 */               null); 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.4.7.jar!\beyondOrigins\main\maps\GrassMap.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */