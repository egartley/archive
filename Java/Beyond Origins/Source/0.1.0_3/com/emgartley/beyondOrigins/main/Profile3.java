/*    */ package com.emgartley.beyondOrigins.main;
/*    */ 
/*    */ import com.emgartley.beyondOrigins.files.Save;
/*    */ import com.emgartley.beyondOrigins.main.maps.GrassMap;
/*    */ import java.io.File;
/*    */ import java.io.FileWriter;
/*    */ import java.io.IOException;
/*    */ import java.io.PrintWriter;
/*    */ import java.text.SimpleDateFormat;
/*    */ import java.util.Calendar;
/*    */ 
/*    */ public class Profile3 {
/*    */   public static String name;
/*    */   
/*    */   public static String backup_name;
/*    */   
/*    */   public static String lastPlayed;
/*    */   
/*    */   public static String made;
/*    */   
/* 15 */   public static File file = new File(Game.save3Path);
/*    */   
/*    */   public static int progress;
/*    */   
/*    */   public static void save() throws IOException {
/* 19 */     if (!file.exists()) {
/* 20 */       Save.profileReset();
/* 21 */       made = (new SimpleDateFormat("MM-dd-yyyy")).format(
/* 22 */           Calendar.getInstance().getTime());
/* 23 */       lastPlayed = (new SimpleDateFormat("MM-dd-yyyy")).format(
/* 24 */           Calendar.getInstance().getTime());
/* 25 */     } else if (file.exists()) {
/* 26 */       file.delete();
/* 27 */       lastPlayed = (new SimpleDateFormat("MM-dd-yyyy")).format(
/* 28 */           Calendar.getInstance().getTime());
/*    */     } 
/* 30 */     Save.dataSave();
/* 32 */     FileWriter fw = new FileWriter(file.getPath());
/* 33 */     PrintWriter pw = new PrintWriter(fw);
/* 35 */     pw.println((Game.getPlayer()).name);
/* 36 */     pw.println((Game.getPlayer()).x);
/* 37 */     pw.println((Game.getPlayer()).y);
/* 38 */     Game.getMap();
/* 38 */     pw.println(GrassMap.x);
/* 39 */     Game.getMap();
/* 39 */     pw.println(GrassMap.y);
/* 40 */     pw.println((Game.getPlayer()).mapMovement);
/* 41 */     pw.println((Game.getPlayer()).insideMovement);
/* 42 */     pw.println((Game.getPlayer()).health);
/* 43 */     pw.println((Game.getPlayer()).exp);
/* 44 */     pw.println((Game.getPlayer()).level);
/* 45 */     pw.println(Game.getProgess());
/* 47 */     pw.close();
/*    */     try {
/* 50 */       Game.st.encrypt(Game.getSaveKey(3), file, file);
/* 51 */     } catch (Exception e) {
/* 52 */       e.printStackTrace();
/*    */     } 
/* 55 */     Game.logger.log("Profile 3 saved");
/*    */   }
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.1.0_3.jar!\com\emgartley\beyondOrigins\main\Profile3.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */