/*    */ package com.emgartley.beyondOrigins.main.entities;
/*    */ 
/*    */ import com.emgartley.beyondOrigins.main.Game;
/*    */ 
/*    */ public abstract class Entity {
/*    */   public static Player player;
/*    */   
/*    */   public static TestDummy td;
/*    */   
/*    */   public static Paige pge;
/*    */   
/*    */   public static void init() {
/* 11 */     player = new Player(129, 197, 400, 256);
/* 12 */     td = new TestDummy();
/* 13 */     pge = new Paige();
/*    */   }
/*    */   
/*    */   public static void checkData() {
/* 17 */     if (Game.getProgress() == 1)
/* 18 */       pge.setCords(500, 100); 
/*    */   }
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.1.0_4.jar!\com\emgartley\beyondOrigins\main\entities\Entity.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */