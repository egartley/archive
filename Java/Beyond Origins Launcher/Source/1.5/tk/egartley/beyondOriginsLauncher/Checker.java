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
/* 13 */     Main.setStatus("Checking for updates...");
/* 14 */     Main.checkVersions((new File(Main.directory)).exists());
/* 15 */     Main.println("Comparing versions...");
/* 16 */     if (Main.installedVersion != null && Main.installedVersion.equals(Main.remoteVersion) && (
/* 17 */       new File(String.valueOf(Main.directory) + "\\bin\\BeyondOrigins.jar")).exists()) {
/* 18 */       Main.setStatus("You have the current version! (" + Main.installedVersion + 
/* 19 */           ")");
/* 20 */       Main.button_install.setEnabled(false);
/* 21 */       Main.b2Text = "Install Updates";
/* 22 */       Main.button_install.setText(Main.b2Text);
/* 23 */     } else if (Main.installedVersion == null && 
/* 24 */       !(new File(String.valueOf(Main.directory) + "\\bin\\BeyondOrigins.jar")).exists()) {
/* 25 */       Main.setStatus("Click the 'Install Game' button to install Beyond Origins!");
/* 26 */       Main.button_install.setEnabled(true);
/* 27 */       Main.button_launch.setEnabled(false);
/* 28 */       Main.b2Text = "Install Game";
/* 29 */       Main.button_install.setText(Main.b2Text);
/* 30 */     } else if (Main.installedVersion != Main.remoteVersion) {
/* 31 */       Main.setStatus("A new update is ready to be installed! (" + 
/* 32 */           Main.remoteVersion + ")");
/* 33 */       Main.button_install.setEnabled(true);
/* 34 */       Main.button_launch.setEnabled(false);
/* 35 */       Main.b2Text = "Install Updates";
/* 36 */       Main.button_install.setText(Main.b2Text);
/*    */     } 
/* 38 */     if (Main.installedVersion != Main.remoteVersion) {
/* 39 */       Main.installedVersion = Main.remoteVersion;
/* 40 */       Main.writeVersionFile();
/*    */     } 
/* 42 */     Main.progressBar.setString("Ready to work");
/*    */   }
/*    */ }


/* Location:              C:\Users\egart\Documents\GitHub\archive\Java\Beyond Origins Launcher\Builds\Launcher_v1.5.jar!\tk\egartley\beyondOriginsLauncher\Checker.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */