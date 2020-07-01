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
/* 17 */     shop1X = 96;
/* 18 */     shop1Y = 96;
/* 20 */     for (int x = 3; x < 6; x++) {
/* 21 */       for (int y = 4; y < 6; y++) {
/* 22 */         Game.getMap();
/* 22 */         GrassMap.tiles[x][y] = 99;
/*    */       } 
/*    */     } 
/*    */   }
/*    */   
/*    */   public void render(Graphics g) {
/* 28 */     render1X = (shop1X - GrassMap.x);
/* 29 */     render1Y = (shop1Y - GrassMap.y);
/* 30 */     if (render1X >= -129.0F && render1Y >= -129.0F && render1X <= Game.width && 
/* 31 */       render1Y <= Game.height)
/* 32 */       g.drawImage(ImageManager.shop1, (int)render1X, (int)render1Y, 96, 96, 
/* 33 */           null); 
/*    */   }
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.1.0_3.jar!\com\emgartley\beyondOrigins\main\buildings\BuildingRender.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */