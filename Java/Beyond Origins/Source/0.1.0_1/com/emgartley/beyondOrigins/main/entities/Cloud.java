/*    */ package com.emgartley.beyondOrigins.main.entities;
/*    */ 
/*    */ import com.emgartley.beyondOrigins.main.gfx.ImageManager;
/*    */ import java.awt.Graphics;
/*    */ 
/*    */ public class Cloud extends Entity {
/*    */   public double x;
/*    */   
/*    */   public double y;
/*    */   
/*    */   public double sx;
/*    */   
/*    */   public Cloud(double x, double y) {
/* 12 */     this.x = x;
/* 13 */     this.y = y;
/* 15 */     this.sx = x;
/*    */   }
/*    */   
/*    */   public void tick(int bx, double speed, int i) {
/* 19 */     if (i == 1) {
/* 20 */       if (this.x < bx) {
/* 21 */         this.x += speed;
/*    */       } else {
/* 23 */         this.x = this.sx;
/*    */       } 
/* 25 */     } else if (i == 0) {
/* 26 */       if (this.x > bx) {
/* 27 */         this.x -= speed;
/*    */       } else {
/* 29 */         this.x = this.sx;
/*    */       } 
/*    */     } 
/*    */   }
/*    */   
/*    */   public void render(Graphics g) {
/* 35 */     g.drawImage(ImageManager.cloud1, (int)this.x, (int)this.y, null);
/*    */   }
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.1.0_1.jar!\com\emgartley\beyondOrigins\main\entities\Cloud.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */