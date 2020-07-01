/*    */ package com.emgartley.beyondOrigins.files;
/*    */ 
/*    */ import com.emgartley.beyondOrigins.main.Game;
/*    */ import java.io.File;
/*    */ import java.io.IOException;
/*    */ import java.text.SimpleDateFormat;
/*    */ import java.util.Calendar;
/*    */ 
/*    */ public class Logger {
/* 11 */   public File log = new File(String.valueOf(Game.mainDir) + "\\logs\\session.txt");
/*    */   
/*    */   public Logger() {
/*    */     try {
/* 15 */       if (!this.log.exists())
/* 16 */         this.log.createNewFile(); 
/* 18 */     } catch (IOException e) {
/* 19 */       e.printStackTrace();
/*    */     } 
/*    */   }
/*    */   
/*    */   public void log(String text) {
/* 24 */     String date = (new SimpleDateFormat("[MM-dd-yy ")).format(
/* 25 */         Calendar.getInstance().getTime());
/* 26 */     String time = (new SimpleDateFormat("HH:mm:ss] ")).format(
/* 27 */         Calendar.getInstance().getTime());
/* 28 */     String stamp = String.valueOf(date) + time;
/*    */     try {
/* 29 */       Exception exception2, exception1 = null;
/* 32 */     } catch (IOException e) {
/* 33 */       e.printStackTrace();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.1.0_1.jar!\com\emgartley\beyondOrigins\files\Logger.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */