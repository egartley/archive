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
/*     */     int test;
/*  20 */     for (test = 1; test <= sizeX - 3; test++) {
/*  21 */       grassmap[test][0] = 5;
/*  22 */       grassmap[test][sizeY - 2] = 7;
/*     */     } 
/*  24 */     for (test = 1; test <= sizeY - 3; test++) {
/*  25 */       grassmap[0][test] = 8;
/*  26 */       grassmap[sizeX - 2][test] = 6;
/*     */     } 
/*     */   }
/*     */   
/*     */   public GrassMap(ImageManager im) {
/*  31 */     super(im);
/*     */   }
/*     */   
/*     */   public void tick() {}
/*     */   
/*     */   public void render(Graphics g) {
/*  38 */     for (int x = 0; x < sizeX - 1; x++) {
/*  39 */       for (int y = 0; y < sizeY - 1; y++) {
/*  40 */         int grassx = (int)((32 * x) - Player.mapX - Game.playerSpawnX);
/*  41 */         int grassy = (int)((32 * y) - Player.mapY - Game.playerSpawnY);
/*  43 */         int tileID = grassmap[x][y];
/*  44 */         if (tileID == 0)
/*  45 */           g.drawImage(ImageManager.grassFull, grassx, grassy, 32, 32, 
/*  46 */               null); 
/*  48 */         if (tileID == 1)
/*  49 */           g.drawImage(ImageManager.grassCnr1, grassx, grassy, 32, 32, 
/*  50 */               null); 
/*  52 */         if (tileID == 2)
/*  53 */           g.drawImage(ImageManager.grassCnr2, grassx, grassy, 32, 32, 
/*  54 */               null); 
/*  56 */         if (tileID == 3)
/*  57 */           g.drawImage(ImageManager.grassCnr3, grassx, grassy, 32, 32, 
/*  58 */               null); 
/*  60 */         if (tileID == 4)
/*  61 */           g.drawImage(ImageManager.grassCnr4, grassx, grassy, 32, 32, 
/*  62 */               null); 
/*  64 */         if (tileID == 5)
/*  65 */           g.drawImage(ImageManager.grassEdge1, grassx, grassy, 32, 
/*  66 */               32, null); 
/*  68 */         if (tileID == 6)
/*  69 */           g.drawImage(ImageManager.grassEdge2, grassx, grassy, 32, 
/*  70 */               32, null); 
/*  72 */         if (tileID == 7)
/*  73 */           g.drawImage(ImageManager.grassEdge3, grassx, grassy, 32, 
/*  74 */               32, null); 
/*  76 */         if (tileID == 8)
/*  77 */           g.drawImage(ImageManager.grassEdge4, grassx, grassy, 32, 
/*  78 */               32, null); 
/*  80 */         if (tileID == 9)
/*  81 */           g.drawImage(ImageManager.grassTree1, grassx, grassy, 32, 
/*  82 */               32, null); 
/*  84 */         if (tileID == 10)
/*  85 */           g.drawImage(ImageManager.path1_1, grassx, grassy, 32, 32, 
/*  86 */               null); 
/*  88 */         if (tileID == 11)
/*  89 */           g.drawImage(ImageManager.path1_2, grassx, grassy, 32, 32, 
/*  90 */               null); 
/*  92 */         if (tileID == 12)
/*  93 */           g.drawImage(ImageManager.path1Cnr1, grassx, grassy, 32, 32, 
/*  94 */               null); 
/*  96 */         if (tileID == 13)
/*  97 */           g.drawImage(ImageManager.path1Cnr2, grassx, grassy, 32, 32, 
/*  98 */               null); 
/* 100 */         if (tileID == 14)
/* 101 */           g.drawImage(ImageManager.path1Cnr3, grassx, grassy, 32, 32, 
/* 102 */               null); 
/* 104 */         if (tileID == 15)
/* 105 */           g.drawImage(ImageManager.path1Cnr4, grassx, grassy, 32, 32, 
/* 106 */               null); 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.4.8_3.jar!\beyondOrigins\main\maps\GrassMap.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */