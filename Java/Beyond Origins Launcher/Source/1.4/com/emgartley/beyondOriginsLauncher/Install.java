/*    */ package com.emgartley.beyondOriginsLauncher;
/*    */ 
/*    */ import java.io.BufferedReader;
/*    */ import java.io.File;
/*    */ import java.io.FileReader;
/*    */ import java.io.IOException;
/*    */ import java.io.LineNumberReader;
/*    */ 
/*    */ public class Install {
/*    */   public void go() {
/*    */     try {
/* 13 */       setUpFolders();
/* 14 */     } catch (Exception e) {
/* 15 */       e.printStackTrace();
/*    */     } 
/* 17 */     Main.st.println("Set up folders");
/* 18 */     ConsoleSIM.text.append("Set up folders \n");
/*    */     try {
/* 20 */       Main.downloadFile(String.valueOf(Main.directory) + "\\bin\\BeyondOrigins.jar", 
/* 21 */           "https://dl.dropboxusercontent.com/s/qj2pdfkwbsqea7l/BeyondOrigins.jar?dl=1");
/* 22 */       Main.downloadAssets();
/* 23 */     } catch (IOException e) {
/* 24 */       Main.setStatus("Error downloading content/update(s)! Contact @egartley on Twitter!");
/* 25 */       e.printStackTrace();
/*    */       return;
/*    */     } 
/* 28 */     Main.st.println("Done installing");
/* 29 */     ConsoleSIM.text.append("Done installing \n");
/* 30 */     Main.button_install.setEnabled(false);
/* 31 */     Main.button_launch.setEnabled(true);
/* 32 */     Main.setStatus("The game has been installed! Click 'Launch Game' to play!");
/* 33 */     Main.checkForUpdates();
/*    */   }
/*    */   
/*    */   private void setUpFolders() throws Exception {
/* 37 */     File control_old = new File(String.valueOf(Main.tempDir) + "\\folders.txt");
/* 38 */     if (control_old.exists())
/* 39 */       control_old.delete(); 
/* 41 */     File mainFolder = new File(Main.directory);
/* 42 */     mainFolder.mkdirs();
/* 43 */     Main.downloadFile(String.valueOf(Main.tempDir) + "\\folders.txt", 
/* 44 */         "https://dl.dropboxusercontent.com/s/mkor80smcwmk9fy/folders.txt?dl=1");
/* 45 */     File control = new File(String.valueOf(Main.tempDir) + "\\folders.txt");
/* 46 */     FileReader fileReader = new FileReader(control);
/* 47 */     BufferedReader buffRdr = new BufferedReader(new FileReader(control));
/* 48 */     LineNumberReader lineNumRdr = new LineNumberReader(fileReader);
/* 49 */     int lineNum = 0;
/* 50 */     while (lineNumRdr.readLine() != null)
/* 51 */       lineNum++; 
/* 53 */     for (int i = 0; i < lineNum; i++) {
/* 54 */       String name = buffRdr.readLine();
/* 55 */       createFolder(String.valueOf(Main.directory) + "\\" + name);
/*    */     } 
/* 57 */     buffRdr.close();
/* 58 */     lineNumRdr.close();
/* 59 */     control.delete();
/* 60 */     Main.st.println("Deleted temp folder control file");
/*    */   }
/*    */   
/*    */   public static void createFolder(String path) {
/* 64 */     File f = new File(path);
/* 65 */     f.mkdirs();
/* 66 */     Main.st.println("Made folder: " + path);
/*    */   }
/*    */ }


/* Location:              C:\Users\egart\Documents\GitHub\archive\Java\Beyond Origins Launcher\Builds\Launcher_v1.4.jar!\com\emgartley\beyondOriginsLauncher\Install.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */