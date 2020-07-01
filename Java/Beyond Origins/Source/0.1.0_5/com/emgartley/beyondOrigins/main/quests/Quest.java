/*    */ package com.emgartley.beyondOrigins.main.quests;
/*    */ 
/*    */ import java.awt.Graphics;
/*    */ 
/*    */ public abstract class Quest {
/*    */   public static Quest activeQuest;
/*    */   
/*    */   public static Quest testQuest;
/*    */   
/*    */   public static void init() {
/* 10 */     activeQuest = new TestQuest();
/*    */   }
/*    */   
/*    */   public static Quest getActiveQuest() {
/* 14 */     return activeQuest;
/*    */   }
/*    */   
/*    */   public void render(Graphics g) {
/* 18 */     activeQuest.render(g);
/*    */   }
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.1.0_5.jar!\com\emgartley\beyondOrigins\main\quests\Quest.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */