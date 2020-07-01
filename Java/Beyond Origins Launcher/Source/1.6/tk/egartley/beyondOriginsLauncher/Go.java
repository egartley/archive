/*    */ package tk.egartley.beyondOriginsLauncher;
/*    */ 
/*    */ import java.io.BufferedReader;
/*    */ import java.io.File;
/*    */ import java.io.FileReader;
/*    */ import java.io.IOException;
/*    */ import java.io.LineNumberReader;
/*    */ 
/*    */ public class Go extends Thread {
/*    */   String type;
/*    */   
/*    */   public Go(String newType) {
/* 13 */     this.type = newType;
/* 14 */     start();
/* 15 */     setPriority(5);
/*    */   }
/*    */   
/*    */   public void run() {
/* 20 */     boolean typeIsInstall = this.type.equals("install");
/* 21 */     boolean typeIsUpdate = this.type.equals("update");
/* 22 */     if (typeIsInstall) {
/* 23 */       Main.setStatus("Installing...");
/* 24 */       Main.progressBar.setString("Creating directories...");
/* 25 */     } else if (typeIsUpdate) {
/* 26 */       Main.setStatus("Updating...");
/* 27 */       Main.progressBar.setString("Updating directories...");
/*    */     } 
/* 29 */     Main.progressBar.setVisible(true);
/* 30 */     Main.progressBar.setIndeterminate(true);
/*    */     try {
/* 33 */       setupDirectories();
/* 34 */     } catch (Exception e) {
/* 35 */       Main.progressBar.setString("Directory Update Failed");
/* 36 */       Main.setStatus("Error updating directories! See \"Console\" tab!");
/* 37 */       Main.println(e.getMessage());
/*    */       return;
/*    */     } 
/* 40 */     Main.println("Directories updated/created");
/*    */     try {
/* 42 */       Main.progressBar.setString("Downloading game...");
/* 43 */       Main.downloadFile(String.valueOf(Main.mainDir) + "\\bin\\BeyondOrigins.jar", 
/* 44 */           "https://dl.dropboxusercontent.com/s/qj2pdfkwbsqea7l/BeyondOrigins.jar?dl=1");
/* 45 */       Main.progressBar.setString("Downloading assets...");
/* 46 */       Main.downloadAssets();
/* 47 */     } catch (IOException e) {
/* 48 */       Main.progressBar.setString("Installation/Update Failed");
/* 49 */       Main.setStatus("Error downloading content/update(s)! See \"Console\" tab!");
/* 50 */       Main.println(e.getMessage());
/*    */       return;
/*    */     } 
/* 54 */     Main.progressBar.setString("Done");
/* 55 */     Main.println("Done installing/updating");
/* 56 */     Main.installButton.setEnabled(false);
/* 57 */     Main.launchButton.setEnabled(true);
/* 58 */     Main.checkForUpdates();
/*    */   }
/*    */   
/*    */   private void setupDirectories() throws Exception {
/* 62 */     File control_old = new File(String.valueOf(Main.tempDir) + "\\folders.txt");
/* 63 */     if (control_old.exists() && control_old.delete())
/* 64 */       Main.println("Deleted old folder control file"); 
/* 66 */     File mainFolder = new File(Main.mainDir);
/* 67 */     mainFolder.mkdirs();
/* 68 */     Main.downloadFile(String.valueOf(Main.tempDir) + "\\folders.txt", 
/* 69 */         "https://dl.dropboxusercontent.com/s/mkor80smcwmk9fy/folders.txt?dl=1");
/* 70 */     File control = new File(String.valueOf(Main.tempDir) + "\\folders.txt");
/* 71 */     FileReader fileReader = new FileReader(control);
/* 72 */     BufferedReader buffRdr = new BufferedReader(new FileReader(control));
/* 73 */     LineNumberReader lineNumRdr = new LineNumberReader(fileReader);
/* 74 */     int lineNum = 0;
/* 75 */     while (lineNumRdr.readLine() != null)
/* 76 */       lineNum++; 
/* 78 */     for (int i = 0; i < lineNum; i++) {
/* 79 */       String name = buffRdr.readLine();
/* 80 */       createDirectory(String.valueOf(Main.mainDir) + "\\" + name);
/*    */     } 
/* 82 */     buffRdr.close();
/* 83 */     lineNumRdr.close();
/* 84 */     if (control.exists() && control.delete()) {
/* 85 */       Main.println("Deleted temp folder control file");
/*    */     } else {
/* 87 */       Main.println("Temp folder control file never existed");
/*    */     } 
/*    */   }
/*    */   
/*    */   public static void createDirectory(String path) {
/* 92 */     File f = new File(path);
/* 93 */     if (!f.exists()) {
/* 94 */       f.mkdirs();
/*    */     } else {
/*    */       return;
/*    */     } 
/* 97 */     Main.println("Made folder: " + path);
/*    */   }
/*    */ }


/* Location:              C:\Users\egart\Documents\GitHub\archive\Java\Beyond Origins Launcher\Builds\Launcher_v1.6.jar!\tk\egartley\beyondOriginsLauncher\Go.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */