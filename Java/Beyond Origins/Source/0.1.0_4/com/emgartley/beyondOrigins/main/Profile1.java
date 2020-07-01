/*    */ package com.emgartley.beyondOrigins.main;
/*    */ 
/*    */ import com.emgartley.beyondOrigins.files.Save;
/*    */ import com.emgartley.beyondOrigins.files.WriteXML;
/*    */ import java.io.File;
/*    */ import java.io.IOException;
/*    */ import java.text.SimpleDateFormat;
/*    */ import java.util.Calendar;
/*    */ 
/*    */ public class Profile1 {
/*    */   public static String name;
/*    */   
/*    */   public static String backup_name;
/*    */   
/*    */   public static String lastPlayed;
/*    */   
/*    */   public static String made;
/*    */   
/* 14 */   public static File file = new File(Game.save1Path);
/*    */   
/* 15 */   public static int progress = 0;
/*    */   
/*    */   public static void save() throws IOException {
/* 18 */     if (!file.exists()) {
/* 19 */       Save.profileReset();
/* 20 */       made = (new SimpleDateFormat("MM-dd-yyyy")).format(
/* 21 */           Calendar.getInstance().getTime());
/* 22 */       lastPlayed = (new SimpleDateFormat("MM-dd-yyyy")).format(
/* 23 */           Calendar.getInstance().getTime());
/* 24 */     } else if (file.exists()) {
/* 25 */       file.delete();
/* 26 */       lastPlayed = (new SimpleDateFormat("MM-dd-yyyy")).format(
/* 27 */           Calendar.getInstance().getTime());
/*    */     } 
/* 29 */     Save.dataSave();
/* 30 */     WriteXML.writeSaveFile(file.getAbsolutePath(), file, 1);
/*    */   }
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.1.0_4.jar!\com\emgartley\beyondOrigins\main\Profile1.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */