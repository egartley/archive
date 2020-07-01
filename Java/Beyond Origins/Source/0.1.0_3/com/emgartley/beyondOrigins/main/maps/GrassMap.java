/*    */ package com.emgartley.beyondOrigins.main.maps;
/*    */ 
/*    */ import com.emgartley.beyondOrigins.main.Game;
/*    */ import com.emgartley.beyondOrigins.main.gfx.Animate;
/*    */ import com.emgartley.beyondOrigins.main.gfx.ImageManager;
/*    */ import java.awt.Color;
/*    */ import java.awt.Graphics;
/*    */ import java.awt.image.BufferedImage;
/*    */ 
/*    */ public class GrassMap extends Map {
/*    */   public int w;
/*    */   
/*    */   public int h;
/*    */   
/*    */   public static int y;
/*    */   
/*    */   public static int x;
/*    */   
/*    */   public static int[][] tiles;
/*    */   
/* 19 */   double waterCount = 2.0D;
/*    */   
/*    */   private static Animate a;
/*    */   
/*    */   public GrassMap(BufferedImage mapImage, int sx, int sy) {
/* 23 */     a = new Animate();
/* 24 */     x = sx;
/* 25 */     y = sy;
/* 26 */     this.w = mapImage.getWidth();
/* 27 */     this.h = mapImage.getHeight();
/* 28 */     load(mapImage);
/*    */   }
/*    */   
/*    */   public void tick() {
/* 32 */     this.waterCount += 0.2D;
/* 33 */     if (this.waterCount >= 42.0D)
/* 34 */       this.waterCount = 2.0D; 
/*    */   }
/*    */   
/*    */   private void load(BufferedImage mapImage) {
/* 39 */     tiles = new int[mapImage.getWidth()][mapImage.getHeight()];
/* 40 */     for (int y = 0; y < mapImage.getHeight(); y++) {
/* 41 */       for (int x = 0; x < mapImage.getWidth(); x++) {
/* 42 */         Color c = new Color(mapImage.getRGB(x, y));
/* 43 */         String h = String.format("%02x%02x%02x", new Object[] { Integer.valueOf(c.getRed()), 
/* 44 */               Integer.valueOf(c.getGreen()), Integer.valueOf(c.getBlue()) });
/*    */         String str1;
/* 45 */         switch ((str1 = h).hashCode()) {
/*    */           case 1420184684:
/* 45 */             if (str1.equals("00600b")) {
/* 50 */               tiles[x][y] = 2;
/*    */               break;
/*    */             } 
/*    */           case 1420266372:
/*    */             if (str1.equals("007f0e")) {
/* 56 */               tiles[x][y] = 4;
/*    */               break;
/*    */             } 
/*    */           case 1421465680:
/*    */             if (str1.equals("00a012")) {
/*    */               tiles[x][y] = 1;
/*    */               break;
/*    */             } 
/*    */           case 1469141530:
/*    */             if (str1.equals("0e69ce")) {
/*    */               tiles[x][y] = 3;
/*    */               break;
/*    */             } 
/*    */           default:
/* 59 */             tiles[x][y] = 1;
/*    */             break;
/*    */         } 
/*    */       } 
/*    */     } 
/*    */   }
/*    */   
/*    */   public void render(Graphics g) {
/* 68 */     for (int x = 0; x < this.w; x++) {
/* 69 */       for (int y = 0; y < this.h; y++) {
/* 70 */         int gx = 32 * x - GrassMap.x;
/* 71 */         if (gx >= -33 && gx <= Game.width) {
/* 72 */           int gy = 32 * y - GrassMap.y;
/* 73 */           if (gy >= -33 && gy <= Game.height) {
/* 74 */             int tileID = tiles[x][y];
/* 75 */             if (tileID == 1 || tileID == 99) {
/* 76 */               g.drawImage(ImageManager.grassFull, gx, gy, null);
/* 77 */             } else if (tileID == 2) {
/* 78 */               g.drawImage(ImageManager.grassBarrier, gx, gy, null);
/* 79 */             } else if (tileID == 3) {
/* 80 */               a.animateTile(g, gx, gy, ImageManager.water, 
/* 81 */                   (short)(int)this.waterCount);
/* 82 */             } else if (tileID == 4) {
/* 83 */               g.drawImage(ImageManager.tree, gx, gy, null);
/*    */             } else {
/* 85 */               g.setColor(Color.DARK_GRAY);
/* 86 */               g.fillRect(gx, gy, 32, 32);
/*    */             } 
/*    */           } 
/*    */         } 
/*    */       } 
/*    */     } 
/*    */   }
/*    */   
/*    */   public static int getTileID(int x, int y) {
/* 95 */     return tiles[x][y];
/*    */   }
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.1.0_3.jar!\com\emgartley\beyondOrigins\main\maps\GrassMap.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */