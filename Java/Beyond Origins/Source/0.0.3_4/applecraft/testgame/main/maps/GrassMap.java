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
/*     */     int test;
/*  23 */     for (test = 1; test <= sizeX - 3; test++) {
/*  24 */       grassmap[test][0] = 5;
/*  25 */       grassmap[test][sizeY - 2] = 7;
/*     */     } 
/*  28 */     for (test = 1; test <= sizeY - 3; test++) {
/*  29 */       grassmap[0][test] = 8;
/*  30 */       grassmap[sizeX - 2][test] = 6;
/*     */     } 
/*     */   }
/*     */   
/*     */   public GrassMap(ImageManager im) {
/*  36 */     super(im);
/*     */   }
/*     */   
/*     */   public void tick() {}
/*     */   
/*     */   public void render(Graphics g) {
/*  45 */     for (int x = 0; x < sizeX - 1; x++) {
/*  46 */       for (int y = 0; y < sizeY - 1; y++) {
/*  50 */         int grassx = (int)((32 * x) - Player.mapX - Game.playerSpawnX);
/*  51 */         int grassy = (int)((32 * y) - Player.mapY - Game.playerSpawnY);
/*  55 */         int tileID = grassmap[x][y];
/*  59 */         if (tileID == 0)
/*  60 */           g.drawImage(ImageManager.grassFull, grassx, grassy, 32, 32, 
/*  61 */               null); 
/*  64 */         if (tileID == 1)
/*  65 */           g.drawImage(ImageManager.grassCnr1, grassx, grassy, 32, 32, 
/*  66 */               null); 
/*  69 */         if (tileID == 2)
/*  70 */           g.drawImage(ImageManager.grassCnr2, grassx, grassy, 32, 32, 
/*  71 */               null); 
/*  74 */         if (tileID == 3)
/*  75 */           g.drawImage(ImageManager.grassCnr3, grassx, grassy, 32, 32, 
/*  76 */               null); 
/*  79 */         if (tileID == 4)
/*  80 */           g.drawImage(ImageManager.grassCnr4, grassx, grassy, 32, 32, 
/*  81 */               null); 
/*  84 */         if (tileID == 5)
/*  85 */           g.drawImage(ImageManager.grassEdge1, grassx, grassy, 32, 
/*  86 */               32, null); 
/*  89 */         if (tileID == 6)
/*  90 */           g.drawImage(ImageManager.grassEdge2, grassx, grassy, 32, 
/*  91 */               32, null); 
/*  94 */         if (tileID == 7)
/*  95 */           g.drawImage(ImageManager.grassEdge3, grassx, grassy, 32, 
/*  96 */               32, null); 
/*  99 */         if (tileID == 8)
/* 100 */           g.drawImage(ImageManager.grassEdge4, grassx, grassy, 32, 
/* 101 */               32, null); 
/* 104 */         if (tileID == 9)
/* 105 */           g.drawImage(ImageManager.grassTree1, grassx, grassy, 32, 
/* 106 */               32, null); 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.3_4.jar!\applecraft\testgame\main\maps\GrassMap.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */