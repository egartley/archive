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
/*    */ public class Profile1 {
/*    */   public static String name;
/*    */   
/*    */   public static String backup_name;
/*    */   
/*    */   public static String lastPlayed;
/*    */   
/*    */   public static String made;
/*    */   
/* 12 */   public static File file = new File(Game.save1Path);
/*    */   
/*    */   public static void save() throws IOException {
/* 15 */     if (!file.exists()) {
/* 16 */       Save.profileReset();
/* 17 */       made = (new SimpleDateFormat("MM-dd-yyyy")).format(
/* 18 */           Calendar.getInstance().getTime());
/* 19 */       lastPlayed = (new SimpleDateFormat("MM-dd-yyyy")).format(
/* 20 */           Calendar.getInstance().getTime());
/* 21 */     } else if (file.exists()) {
/* 22 */       file.delete();
/* 23 */       lastPlayed = (new SimpleDateFormat("MM-dd-yyyy")).format(
/* 24 */           Calendar.getInstance().getTime());
/*    */     } 
/* 26 */     Save.dataSave();
/* 28 */     FileWriter fw = new FileWriter(file.getPath());
/* 29 */     PrintWriter pw = new PrintWriter(fw);
/* 31 */     pw.println((Game.getPlayer()).name);
/* 32 */     pw.println((Game.getPlayer()).x);
/* 33 */     pw.println((Game.getPlayer()).y);
/* 34 */     pw.println((Game.getPlayer()).mapX);
/* 35 */     pw.println((Game.getPlayer()).mapY);
/* 36 */     pw.println((Game.getPlayer()).mapMovement);
/* 37 */     pw.println((Game.getPlayer()).insideMovement);
/* 38 */     pw.println((Game.getPlayer()).health);
/* 39 */     pw.println((Game.getPlayer()).exp);
/* 40 */     pw.println((Game.getPlayer()).level);
/* 42 */     pw.close();
/*    */     try {
/* 45 */       Game.st.encrypt(Game.getSaveKey(1), file, file);
/* 46 */     } catch (Exception e) {
/* 47 */       e.printStackTrace();
/*    */     } 
/* 50 */     Game.logger.log("Profile 1 saved");
/*    */   }
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.9_3.jar!\beyondOrigins\main\Profile1.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */