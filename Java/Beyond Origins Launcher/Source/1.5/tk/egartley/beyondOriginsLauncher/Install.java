/*    */ package tk.egartley.beyondOriginsLauncher;
/*    */ 
/*    */ import java.io.BufferedReader;
/*    */ import java.io.File;
/*    */ import java.io.FileReader;
/*    */ import java.io.IOException;
/*    */ import java.io.LineNumberReader;
/*    */ 
/*    */ public class Install extends Thread {
/*    */   public Install() {
/* 12 */     start();
/* 13 */     setPriority(5);
/*    */   }
/*    */   
/*    */   public void run() {
/* 17 */     Main.setStatus("Installing game...");
/* 18 */     Main.progressBar.setString("Installing...");
/* 19 */     Main.progressBar.setIndeterminate(false);
/*    */     try {
/* 21 */       setUpFolders();
/* 22 */     } catch (Exception e) {
/* 23 */       e.printStackTrace();
/*    */     } 
/* 25 */     Main.progressBar.setValue(10);
/* 26 */     Main.st.println("Set up folders");
/* 27 */     ConsoleSIM.appendText("Set up folders");
/*    */     try {
/* 29 */       Main.downloadFile(String.valueOf(Main.directory) + "\\bin\\BeyondOrigins.jar", 
/* 30 */           "https://dl.dropboxusercontent.com/s/qj2pdfkwbsqea7l/BeyondOrigins.jar?dl=1");
/* 31 */       Main.progressBar.setValue(50);
/* 32 */       Main.downloadAssets();
/* 33 */       Main.progressBar.setValue(95);
/* 34 */     } catch (IOException e) {
/* 35 */       Main.progressBar.setString("Installation Failed");
/* 36 */       Main.progressBar.setValue(0);
/* 37 */       Main.setStatus("Error downloading content/update(s)! Contact @egartley on Twitter!");
/* 38 */       e.printStackTrace();
/*    */       return;
/*    */     } 
/* 41 */     Main.progressBar.setValue(100);
/* 42 */     Main.progressBar.setString("Installation Completed");
/* 43 */     Main.st.println("Done installing");
/* 44 */     ConsoleSIM.appendText("Done installing");
/* 45 */     Main.button_install.setEnabled(false);
/* 46 */     Main.button_launch.setEnabled(true);
/* 47 */     Main.setStatus("The game has been installed! Click 'Launch Game' to play!");
/* 48 */     Main.checkForUpdates();
/*    */   }
/*    */   
/*    */   private void setUpFolders() throws Exception {
/* 52 */     File control_old = new File(String.valueOf(Main.tempDir) + "\\folders.txt");
/* 53 */     if (control_old.exists())
/* 54 */       control_old.delete(); 
/* 56 */     File mainFolder = new File(Main.directory);
/* 57 */     mainFolder.mkdirs();
/* 58 */     Main.downloadFile(String.valueOf(Main.tempDir) + "\\folders.txt", 
/* 59 */         "https://dl.dropboxusercontent.com/s/mkor80smcwmk9fy/folders.txt?dl=1");
/* 60 */     File control = new File(String.valueOf(Main.tempDir) + "\\folders.txt");
/* 61 */     FileReader fileReader = new FileReader(control);
/* 62 */     BufferedReader buffRdr = new BufferedReader(new FileReader(control));
/* 63 */     LineNumberReader lineNumRdr = new LineNumberReader(fileReader);
/* 64 */     int lineNum = 0;
/* 65 */     while (lineNumRdr.readLine() != null)
/* 66 */       lineNum++; 
/* 68 */     for (int i = 0; i < lineNum; i++) {
/* 69 */       String name = buffRdr.readLine();
/* 70 */       createFolder(String.valueOf(Main.directory) + "\\" + name);
/*    */     } 
/* 72 */     buffRdr.close();
/* 73 */     lineNumRdr.close();
/* 74 */     control.delete();
/* 75 */     Main.st.println("Deleted temp folder control file");
/*    */   }
/*    */   
/*    */   public static void createFolder(String path) {
/* 79 */     File f = new File(path);
/* 80 */     f.mkdirs();
/* 81 */     Main.st.println("Made folder: " + path);
/*    */   }
/*    */ }


/* Location:              C:\Users\egart\Documents\GitHub\archive\Java\Beyond Origins Launcher\Builds\Launcher_v1.5.jar!\tk\egartley\beyondOriginsLauncher\Install.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */