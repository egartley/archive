/*    */ package com.emgartley.beyondOrigins.main;
/*    */ 
/*    */ import com.emgartley.beyondOrigins.files.Save;
/*    */ import com.emgartley.beyondOrigins.files.WriteXML;
/*    */ import java.io.File;
/*    */ import java.io.IOException;
/*    */ import java.text.SimpleDateFormat;
/*    */ import java.util.Calendar;
/*    */ 
/*    */ public class Profile2 {
/*    */   public static String name;
/*    */   
/*    */   public static String backup_name;
/*    */   
/*    */   public static String lastPlayed;
/*    */   
/*    */   public static String made;
/*    */   
/* 13 */   public static File file = new File(Game.save2Path);
/*    */   
/* 14 */   public static int progress = 0;
/*    */   
/*    */   public static void save() throws IOException {
/* 17 */     if (!file.exists()) {
/* 18 */       Save.profileReset();
/* 19 */       made = (new SimpleDateFormat("MM-dd-yyyy")).format(
/* 20 */           Calendar.getInstance().getTime());
/* 21 */       lastPlayed = (new SimpleDateFormat("MM-dd-yyyy")).format(
/* 22 */           Calendar.getInstance().getTime());
/* 23 */     } else if (file.exists()) {
/* 24 */       file.delete();
/* 25 */       lastPlayed = (new SimpleDateFormat("MM-dd-yyyy")).format(
/* 26 */           Calendar.getInstance().getTime());
/*    */     } 
/* 28 */     Save.dataSave();
/* 29 */     WriteXML.writeSaveFile(file.getAbsolutePath(), file, 2);
/*    */   }
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.1.0_5.jar!\com\emgartley\beyondOrigins\main\Profile2.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */