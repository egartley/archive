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
/* 12 */     player = new Player(129, 197, 400, 256);
/* 13 */     td = new TestDummy();
/* 14 */     pge = new Paige();
/*    */   }
/*    */   
/*    */   public static void checkData() {
/* 18 */     if (Game.getProgess() == 1)
/* 19 */       pge.setCords(500, 100); 
/*    */   }
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.1.0_1.jar!\com\emgartley\beyondOrigins\main\entities\Entity.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */