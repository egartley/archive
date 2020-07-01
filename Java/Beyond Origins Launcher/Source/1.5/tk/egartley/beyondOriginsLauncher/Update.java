/*    */ package tk.egartley.beyondOriginsLauncher;
/*    */ 
/*    */ import java.io.IOException;
/*    */ 
/*    */ public class Update extends Thread {
/*    */   public Update() {
/* 12 */     start();
/* 13 */     setPriority(5);
/*    */   }
/*    */   
/*    */   public void run() {
/* 17 */     Main.setStatus("Updaing game...");
/* 18 */     Main.progressBar.setString("Updating...");
/* 19 */     Main.progressBar.setIndeterminate(false);
/*    */     try {
/* 21 */       Main.downloadFile(String.valueOf(Main.directory) + "\\bin\\BeyondOrigins.jar", 
/* 22 */           "https://dl.dropboxusercontent.com/s/qj2pdfkwbsqea7l/BeyondOrigins.jar?dl=1");
/* 23 */       Main.progressBar.setValue(25);
/* 24 */       Main.downloadAssets();
/* 25 */       Main.progressBar.setValue(95);
/* 26 */     } catch (IOException e) {
/* 27 */       Main.progressBar.setString("Update Failed");
/* 28 */       Main.progressBar.setValue(0);
/* 29 */       Main.setStatus("Error downloading content/update(s)! Contact @egartley on Twitter!");
/* 30 */       e.printStackTrace();
/*    */       return;
/*    */     } 
/* 33 */     Main.progressBar.setValue(100);
/* 34 */     Main.progressBar.setString("Update Finished");
/* 35 */     Main.println("Done installing");
/* 36 */     Main.button_install.setEnabled(false);
/* 37 */     Main.button_launch.setEnabled(true);
/* 38 */     Main.setStatus("The latest version has been installed!");
/*    */   }
/*    */ }


/* Location:              C:\Users\egart\Documents\GitHub\archive\Java\Beyond Origins Launcher\Builds\Launcher_v1.5.jar!\tk\egartley\beyondOriginsLauncher\Update.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */