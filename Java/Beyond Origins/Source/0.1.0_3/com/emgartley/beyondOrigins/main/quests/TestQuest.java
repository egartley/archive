/*    */ package com.emgartley.beyondOrigins.main.quests;
/*    */ 
/*    */ import com.emgartley.beyondOrigins.main.Game;
/*    */ import com.emgartley.beyondOrigins.main.gfx.ImageManager;
/*    */ import com.emgartley.beyondOrigins.userInput.MouseMotion;
/*    */ import java.awt.Color;
/*    */ import java.awt.Graphics;
/*    */ 
/*    */ public class TestQuest extends Quest {
/*    */   byte state;
/*    */   
/*    */   boolean inFocus;
/*    */   
/* 14 */   String title = "Test Quest", desc = "This is a 'quest' for testing.";
/*    */   
/*    */   public byte getQuestState(int x, int y, int w, int h, byte state, boolean inFocus) {
/* 18 */     if (MouseMotion.mouseX >= x && MouseMotion.mouseX < x + w && 
/* 19 */       MouseMotion.mouseY >= y && MouseMotion.mouseY < y + h) {
/* 20 */       if (!inFocus && Game.mouseIsPressed()) {
/* 21 */         state = 2;
/* 22 */         inFocus = true;
/* 23 */       } else if (inFocus) {
/* 24 */         state = 2;
/*    */       } 
/* 26 */     } else if (inFocus) {
/* 27 */       state = 2;
/* 28 */     } else if (Game.mouseIsPressed()) {
/* 29 */       state = 1;
/* 30 */       inFocus = false;
/*    */     } 
/* 32 */     return state;
/*    */   }
/*    */   
/*    */   public void drawQuest(Graphics g, String t, String d, int x, int y) {
/* 36 */     this.state = getQuestState(x, y, ImageManager.quest_1.getWidth(), 
/* 37 */         ImageManager.quest_1.getHeight(), this.state, this.inFocus);
/* 38 */     if (this.state == 1) {
/* 39 */       g.drawImage(ImageManager.quest_1, x, y, null);
/* 40 */     } else if (this.state == 2) {
/* 41 */       g.drawImage(ImageManager.quest_2, x, y, null);
/*    */     } 
/* 43 */     g.setFont(Game.questTitleFont);
/* 44 */     g.setColor(new Color(99, 90, 74));
/* 45 */     g.drawString(t, x + 5, y + 16);
/* 46 */     g.setFont(Game.questDescFont);
/* 47 */     g.drawString(d, x + 5, y + 31);
/*    */   }
/*    */   
/*    */   public void render(Graphics g) {
/* 51 */     drawQuest(g, this.title, this.desc, 222, 178);
/*    */   }
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.1.0_3.jar!\com\emgartley\beyondOrigins\main\quests\TestQuest.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */