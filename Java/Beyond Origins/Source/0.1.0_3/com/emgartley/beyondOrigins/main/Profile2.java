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
/*    */ public class Profile2 {
/*    */   public static String name;
/*    */   
/*    */   public static String backup_name;
/*    */   
/*    */   public static String lastPlayed;
/*    */   
/*    */   public static String made;
/*    */   
/* 12 */   public static File file = new File(Game.save2Path);
/*    */   
/*    */   public static int progress;
/*    */   
/*    */   public static void save() throws IOException {
/* 16 */     if (!file.exists()) {
/* 17 */       Save.profileReset();
/* 18 */       made = (new SimpleDateFormat("MM-dd-yyyy")).format(
/* 19 */           Calendar.getInstance().getTime());
/* 20 */       lastPlayed = (new SimpleDateFormat("MM-dd-yyyy")).format(
/* 21 */           Calendar.getInstance().getTime());
/* 22 */     } else if (file.exists()) {
/* 23 */       file.delete();
/* 24 */       lastPlayed = (new SimpleDateFormat("MM-dd-yyyy")).format(
/* 25 */           Calendar.getInstance().getTime());
/*    */     } 
/* 27 */     Save.dataSave();
/* 29 */     FileWriter fw = new FileWriter(file.getPath());
/* 30 */     PrintWriter pw = new PrintWriter(fw);
/* 32 */     pw.println((Game.getPlayer()).name);
/* 33 */     pw.println((Game.getPlayer()).x);
/* 34 */     pw.println((Game.getPlayer()).y);
/* 35 */     Game.getMap();
/* 35 */     pw.println(GrassMap.x);
/* 36 */     Game.getMap();
/* 36 */     pw.println(GrassMap.y);
/* 37 */     pw.println((Game.getPlayer()).mapMovement);
/* 38 */     pw.println((Game.getPlayer()).insideMovement);
/* 39 */     pw.println((Game.getPlayer()).health);
/* 40 */     pw.println((Game.getPlayer()).exp);
/* 41 */     pw.println((Game.getPlayer()).level);
/* 42 */     pw.println(Game.getProgess());
/* 44 */     pw.close();
/*    */     try {
/* 47 */       Game.st.encrypt(Game.getSaveKey(2), file, file);
/* 48 */     } catch (Exception e) {
/* 49 */       e.printStackTrace();
/*    */     } 
/* 52 */     Game.logger.log("Profile 2 saved");
/*    */   }
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.1.0_3.jar!\com\emgartley\beyondOrigins\main\Profile2.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */