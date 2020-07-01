/*    */ package tk.egartley.beyondOriginsLauncher;
/*    */ 
/*    */ import java.io.File;
/*    */ 
/*    */ public class Checker extends Thread {
/*    */   public Checker() {
/*  8 */     start();
/*  9 */     setPriority(5);
/*    */   }
/*    */   
/*    */   public void run() {
/* 13 */     Main.progressBar.setString("Checking versions...");
/* 14 */     Main.progressBar.setVisible(true);
/* 15 */     Main.checkVersions((new File(Main.mainDir)).exists());
/* 16 */     Main.println("Comparing versions...");
/* 17 */     Main.progressBar.setString("Comparing versions...");
/* 18 */     if (Main.installedBuild != null && Main.installedBuild.equals(Main.remoteBuild) && (
/* 19 */       new File(String.valueOf(Main.mainDir) + "\\bin\\BeyondOrigins.jar")).exists()) {
/* 20 */       Main.setStatus("You have the current version! (Build " + Main.installedBuild + 
/* 21 */           ")");
/* 22 */       Main.launchButton.setEnabled(true);
/* 23 */       Main.installButton.setEnabled(false);
/* 24 */       Main.installButton.setActionCommand("install_update");
/* 25 */     } else if (Main.installedBuild == null && 
/* 26 */       !(new File(String.valueOf(Main.mainDir) + "\\bin\\BeyondOrigins.jar")).exists()) {
/* 27 */       Main.setStatus("Click the 'Install Game' button to install Beyond Origins!");
/* 28 */       Main.launchButton.setEnabled(false);
/* 29 */       Main.installButton.setEnabled(true);
/* 30 */       Main.installButton.setActionCommand("install_game");
/* 31 */     } else if (Main.installedBuild != Main.remoteBuild) {
/* 32 */       Main.setStatus("A new update is ready to be installed! (Build " + 
/* 33 */           Main.remoteBuild + ")");
/* 34 */       Main.launchButton.setEnabled(false);
/* 35 */       Main.installButton.setEnabled(true);
/* 36 */       Main.installButton.setActionCommand("install_update");
/*    */     } 
/* 38 */     if (Main.installedBuild != Main.remoteBuild) {
/* 39 */       Main.installedBuild = Main.remoteBuild;
/* 40 */       Main.progressBar.setString("Writing version file...");
/* 41 */       Main.writeVersionFile();
/*    */     } 
/* 43 */     Main.progressBar.setString("Done");
/* 44 */     Main.progressBar.setVisible(false);
/*    */   }
/*    */ }


/* Location:              C:\Users\egart\Documents\GitHub\archive\Java\Beyond Origins Launcher\Builds\Launcher_v1.6.jar!\tk\egartley\beyondOriginsLauncher\Checker.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */