/*    */ package com.emgartley.beyondOriginsLauncher;
/*    */ 
/*    */ import java.io.IOException;
/*    */ 
/*    */ public class Update {
/*    */   public void go() {
/*    */     try {
/* 13 */       Main.downloadFile(String.valueOf(Main.directory) + "\\bin\\BeyondOrigins.jar", 
/* 14 */           "https://dl.dropboxusercontent.com/s/qj2pdfkwbsqea7l/BeyondOrigins.jar?dl=1");
/* 15 */       Main.downloadAssets();
/* 16 */     } catch (IOException e) {
/* 17 */       Main.setStatus("Error downloading content/update(s)! Contact @egartley on Twitter!");
/* 18 */       e.printStackTrace();
/*    */       return;
/*    */     } 
/* 21 */     Main.st.println("Done installing");
/* 22 */     ConsoleSIM.text.append("Done installing \n");
/* 23 */     Main.button_install.setEnabled(false);
/* 24 */     Main.button_launch.setEnabled(true);
/* 25 */     Main.setStatus("The latest version has been installed!");
/*    */   }
/*    */ }


/* Location:              C:\Users\egart\Documents\GitHub\archive\Java\Beyond Origins Launcher\Builds\Launcher_v1.4.jar!\com\emgartley\beyondOriginsLauncher\Update.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */