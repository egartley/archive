/*    */ package com.emgartley.beyondOriginsLauncher;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.io.IOException;
/*    */ 
/*    */ public class Install {
/*    */   public void go() {
/* 12 */     setUpFolders();
/* 13 */     Main.st.println("Set up folders");
/*    */     try {
/* 15 */       Main.downloadFile(String.valueOf(Main.directory) + "\\bin\\BeyondOrigins.jar", 
/* 16 */           "https://dl.dropboxusercontent.com/s/qj2pdfkwbsqea7l/BeyondOrigins.jar?dl=1");
/* 17 */       Main.downloadAssets();
/* 18 */     } catch (IOException e) {
/* 19 */       Main.setStatus("Error downloading content/update(s)! Contact @egartley on Twitter!");
/* 20 */       e.printStackTrace();
/*    */       return;
/*    */     } 
/* 23 */     Main.st.println("Done installing");
/* 24 */     Main.button_install.setEnabled(false);
/* 25 */     Main.button_launch.setEnabled(true);
/* 26 */     Main.setStatus("The game has been installed! Click 'Launch Game' to play!");
/* 27 */     Main.checkForUpdates();
/*    */   }
/*    */   
/*    */   private void setUpFolders() {
/* 31 */     createFolder(Main.directory);
/* 32 */     createFolder(String.valueOf(Main.directory) + "\\assets");
/* 33 */     createFolder(String.valueOf(Main.directory) + "\\bin");
/* 34 */     createFolder(String.valueOf(Main.directory) + "\\saves");
/* 35 */     createFolder(String.valueOf(Main.directory) + "\\logs");
/*    */   }
/*    */   
/*    */   public static void createFolder(String path) {
/* 39 */     File f = new File(path);
/* 40 */     if (!f.exists())
/* 41 */       f.mkdir(); 
/*    */   }
/*    */ }


/* Location:              C:\Users\egart\Documents\GitHub\archive\Java\Beyond Origins Launcher\Builds\Launcher_v1.3.jar!\com\emgartley\beyondOriginsLauncher\Install.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */