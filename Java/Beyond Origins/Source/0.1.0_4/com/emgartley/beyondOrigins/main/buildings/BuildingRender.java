/*    */ package com.emgartley.beyondOrigins.main.buildings;
/*    */ 
/*    */ import com.emgartley.beyondOrigins.main.Game;
/*    */ import com.emgartley.beyondOrigins.main.gfx.ImageManager;
/*    */ import com.emgartley.beyondOrigins.main.maps.GrassMap;
/*    */ import java.awt.Graphics;
/*    */ 
/*    */ public class BuildingRender {
/*    */   public static float render1X;
/*    */   
/*    */   public static float render1Y;
/*    */   
/*    */   public static int shop1X;
/*    */   
/*    */   public static int shop1Y;
/*    */   
/*    */   public static void init() {
/* 16 */     shop1X = 96;
/* 17 */     shop1Y = 96;
/* 19 */     for (int x = 3; x < 6; x++) {
/* 20 */       for (int y = 4; y < 6; y++) {
/* 21 */         Game.getMap();
/* 21 */         GrassMap.tiles[x][y] = 99;
/*    */       } 
/*    */     } 
/*    */   }
/*    */   
/*    */   public void render(Graphics g) {
/* 27 */     render1X = (shop1X - (Game.getMap()).x);
/* 28 */     render1Y = (shop1Y - (Game.getMap()).y);
/* 29 */     if (render1X >= -129.0F && render1Y >= -129.0F && render1X <= Game.width && 
/* 30 */       render1Y <= Game.height)
/* 31 */       g.drawImage(ImageManager.shop1, (int)render1X, (int)render1Y, 96, 96, 
/* 32 */           null); 
/*    */   }
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.1.0_4.jar!\com\emgartley\beyondOrigins\main\buildings\BuildingRender.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */