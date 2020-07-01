/*    */ package beyondOrigins.main;
/*    */ 
/*    */ import beyondOrigins.files.Save;
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
/* 31 */     FileWriter fw = new FileWriter(file.getPath());
/* 32 */     PrintWriter pw = new PrintWriter(fw);
/* 34 */     pw.println((Game.getPlayer()).name);
/* 35 */     pw.println((Game.getPlayer()).x);
/* 36 */     pw.println((Game.getPlayer()).y);
/* 37 */     pw.println((Game.getPlayer()).mapX);
/* 38 */     pw.println((Game.getPlayer()).mapY);
/* 39 */     pw.println((Game.getPlayer()).mapMovement);
/* 40 */     pw.println((Game.getPlayer()).insideMovement);
/* 41 */     pw.println((Game.getPlayer()).health);
/* 42 */     pw.println((Game.getPlayer()).exp);
/* 43 */     pw.println((Game.getPlayer()).level);
/* 45 */     pw.close();
/*    */     try {
/* 48 */       Game.st.encrypt(Game.getSaveKey(3), file, file);
/* 49 */     } catch (Exception e) {
/* 50 */       e.printStackTrace();
/*    */     } 
/* 53 */     Game.logger.log("Profile 3 saved");
/*    */   }
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.9_3.jar!\beyondOrigins\main\Profile3.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */