/*     */ package com.emgartley.beyondOriginsLauncher;
/*     */ 
/*     */ import com.emgartley.stlib.STLib;
/*     */ import java.awt.Component;
/*     */ import java.awt.Font;
/*     */ import java.awt.FontMetrics;
/*     */ import java.awt.GridLayout;
/*     */ import java.awt.LayoutManager;
/*     */ import java.awt.Toolkit;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileReader;
/*     */ import java.io.IOException;
/*     */ import java.io.LineNumberReader;
/*     */ import java.net.MalformedURLException;
/*     */ import java.net.URL;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JComponent;
/*     */ import javax.swing.JEditorPane;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.JTabbedPane;
/*     */ import org.apache.commons.io.FileUtils;
/*     */ 
/*     */ public class Main extends JPanel implements ActionListener {
/*     */   private static final long serialVersionUID = 1L;
/*     */   
/*     */   public static JFrame frame;
/*     */   
/*  23 */   public static int scale = 46;
/*     */   
/*  24 */   public static int width = 16 * scale;
/*     */   
/*  24 */   public static int height = 9 * scale;
/*     */   
/*  25 */   public static String title = "Beyond Origins Launcher v1.4.1";
/*     */   
/*  26 */   public static String b1Text = "Launch Game";
/*     */   
/*  27 */   public static String b2Text = "Install Updates";
/*     */   
/*  28 */   public static String user = System.getProperty("user.name");
/*     */   
/*  29 */   public static String directory = String.valueOf(System.getenv("SystemDrive")) + "\\Users\\" + 
/*  30 */     user + "\\AppData\\Roaming\\Beyond Origins";
/*     */   
/*     */   public static String installedVersion;
/*     */   
/*     */   public static String currentVersion;
/*     */   
/*     */   public static String status;
/*     */   
/*  34 */   public static String verKey = "7204UN37GK017562";
/*     */   
/*  35 */   public static String tempDir = String.valueOf(System.getenv("SystemDrive")) + "\\Users\\" + 
/*  36 */     user + "\\AppData\\Local\\Temp";
/*     */   
/*     */   private static JLabel label_status;
/*     */   
/*     */   public static String curEULA;
/*     */   
/*     */   public static String curCL;
/*     */   
/*  39 */   public static Font buttonTextFont = new Font("MoolBoran", 0, 20);
/*     */   
/*     */   private static BufferedImage image_game;
/*     */   
/*     */   private static FontMetrics fm;
/*     */   
/*     */   public static STLib st;
/*     */   
/*  43 */   private static Install in = new Install();
/*     */   
/*  44 */   private static Update up = new Update();
/*     */   
/*     */   public static JButton button_launch;
/*     */   
/*     */   public static JButton button_install;
/*     */   
/*     */   public static JButton button_twitter;
/*     */   
/*     */   public static JButton button_website;
/*     */   
/*     */   public static JButton button_more;
/*     */   
/*     */   private Main() {
/*  49 */     super(new GridLayout(1, 1));
/*  51 */     JTabbedPane tp = new JTabbedPane();
/*  52 */     tp.setFocusable(false);
/*  54 */     JComponent mainPanel = getMainPanel();
/*  55 */     tp.addTab("Main", mainPanel);
/*  56 */     tp.setMnemonicAt(0, 49);
/*  58 */     JComponent eulaPanel = getEULAPanel();
/*  59 */     tp.addTab("Agreement", eulaPanel);
/*  60 */     tp.setMnemonicAt(1, 50);
/*  62 */     JComponent changesPanel = getCLPanel();
/*  63 */     tp.addTab("Change Log", changesPanel);
/*  64 */     tp.setMnemonicAt(2, 51);
/*  66 */     add(tp);
/*     */   }
/*     */   
/*     */   private static void go() {
/*  70 */     checkForUpdates();
/*     */   }
/*     */   
/*     */   public static void main(String[] args) throws Exception {
/*  74 */     st = new STLib();
/*  75 */     frame = new JFrame(title);
/*  76 */     frame.setSize(width, height);
/*  77 */     frame.setResizable(false);
/*  78 */     frame.setLocationRelativeTo((Component)null);
/*  79 */     frame.setDefaultCloseOperation(3);
/*  80 */     st.setSystemLookAndFeel(frame);
/*  81 */     frame.setIconImage(Toolkit.getDefaultToolkit().getImage(
/*  82 */           JFrame.class.getResource("/icon32.png")));
/*  83 */     frame.add(new Main(), (Object)null);
/*  84 */     frame.setVisible(true);
/*  85 */     go();
/*  86 */     updateEditorPanes();
/*     */   }
/*     */   
/*     */   public static void updateEditorPanes() {
/*  90 */     EULA.license.setText(getCurrentEULA());
/*  91 */     ChangeLog.changesPane.setText(getCurrentChangeLog());
/*     */   }
/*     */   
/*     */   public JComponent getMainPanel() {
/*  95 */     JPanel panel = new JPanel(false);
/*  96 */     panel.setLayout((LayoutManager)null);
/*  97 */     fm = getFontMetrics(buttonTextFont);
/*  98 */     button_launch = new JButton(b1Text);
/*  99 */     button_install = new JButton(b2Text);
/* 100 */     label_status = new JLabel();
/* 101 */     label_status.setText("Loading...");
/* 102 */     JLabel logo = new JLabel();
/* 103 */     image_game = st.loadImage("/logo.png");
/* 104 */     logo.setIcon(new ImageIcon(image_game));
/* 105 */     button_launch.setBounds(width / 2 - 89, 143, 
/* 106 */         178, 32);
/* 107 */     button_install.setBounds(width / 2 - 89, 191, 
/* 108 */         178, 32);
/* 109 */     button_launch.addActionListener(this);
/* 110 */     button_install.addActionListener(this);
/* 111 */     button_launch.setFocusable(false);
/* 112 */     button_install.setFocusable(false);
/* 113 */     label_status.setFont(buttonTextFont);
/* 114 */     logo.setBounds(width / 2 - image_game.getWidth() / 2, 25, 
/* 115 */         image_game.getWidth(), image_game.getHeight());
/* 116 */     panel.add(logo);
/* 117 */     panel.add(button_launch);
/* 118 */     panel.add(button_install);
/* 119 */     panel.add(label_status);
/* 120 */     return panel;
/*     */   }
/*     */   
/*     */   public JComponent getEULAPanel() {
/* 124 */     JPanel panel = new JPanel(false);
/* 125 */     panel.setLayout((LayoutManager)null);
/* 126 */     EULA.license = new JEditorPane("text/html", "");
/* 127 */     EULA.license.setBounds(5, 5, width - 22, height - 66);
/* 128 */     EULA.license.setFocusable(false);
/* 129 */     JScrollPane sp = new JScrollPane(EULA.license);
/* 130 */     sp.setBounds(EULA.license.getBounds());
/* 131 */     panel.add(sp);
/* 132 */     return panel;
/*     */   }
/*     */   
/*     */   public JComponent getCLPanel() {
/* 136 */     JPanel panel = new JPanel(false);
/* 137 */     panel.setLayout((LayoutManager)null);
/* 138 */     ChangeLog.changesPane = new JEditorPane("text/html", "");
/* 139 */     ChangeLog.changesPane.setBounds(5, 5, width - 22, height - 66);
/* 140 */     ChangeLog.changesPane.setEditable(false);
/* 141 */     ChangeLog.changesPane.setFocusable(false);
/* 142 */     JScrollPane sp = new JScrollPane(ChangeLog.changesPane);
/* 143 */     sp.setBounds(ChangeLog.changesPane.getBounds());
/* 144 */     panel.add(sp);
/* 145 */     return panel;
/*     */   }
/*     */   
/*     */   public static String getCurrentEULA() {
/* 149 */     String lic = "";
/*     */     try {
/* 151 */       downloadFile(String.valueOf(tempDir) + "\\eula.html", 
/* 152 */           "https://dl.dropboxusercontent.com/s/rcvtpfb84f5t6ys/eula.html?dl=1");
/* 153 */       File file = new File(String.valueOf(tempDir) + "\\eula.html");
/* 154 */       FileInputStream fis = new FileInputStream(file);
/* 155 */       byte[] data = new byte[(int)file.length()];
/* 156 */       fis.read(data);
/* 157 */       fis.close();
/* 158 */       lic = new String(data, "UTF-8");
/* 159 */       file.delete();
/* 160 */     } catch (MalformedURLException e) {
/* 161 */       e.printStackTrace();
/* 162 */     } catch (IOException e) {
/* 163 */       e.printStackTrace();
/*     */     } 
/* 165 */     st.println("Returned current EULA");
/* 166 */     ConsoleSIM.text.append("Returned current EULA \n");
/* 167 */     return lic;
/*     */   }
/*     */   
/*     */   public static String getCurrentChangeLog() {
/* 171 */     String cl = "";
/*     */     try {
/* 173 */       downloadFile(String.valueOf(tempDir) + "\\changes.html", 
/* 174 */           "https://dl.dropboxusercontent.com/s/cxx7qrwnxabd8hd/changes.html?dl=1");
/* 175 */       File file = new File(String.valueOf(tempDir) + "\\changes.html");
/* 176 */       FileInputStream fis = new FileInputStream(file);
/* 177 */       byte[] data = new byte[(int)file.length()];
/* 178 */       fis.read(data);
/* 179 */       fis.close();
/* 180 */       cl = new String(data, "UTF-8");
/* 181 */       file.delete();
/* 182 */     } catch (MalformedURLException e) {
/* 183 */       e.printStackTrace();
/* 184 */     } catch (IOException e) {
/* 185 */       e.printStackTrace();
/*     */     } 
/* 187 */     st.println("Returned current change log");
/* 188 */     ConsoleSIM.text.append("Returned current change log \n");
/* 189 */     return cl;
/*     */   }
/*     */   
/*     */   public static void setStatus(String text) {
/* 193 */     status = text;
/* 194 */     label_status.setText("Status: " + text);
/* 195 */     label_status.setBounds(width / 2 - fm.stringWidth("Status: " + text) / 2, 
/* 196 */         height - 150, width, 27);
/* 197 */     st.println("Set status to: " + text);
/* 198 */     ConsoleSIM.text.append("Set status to: " + text + " \n");
/*     */   }
/*     */   
/*     */   private static void writeVersionFile() {
/* 202 */     st.println("Writing local version file");
/* 203 */     ConsoleSIM.text.append("Writing local version file \n");
/*     */     try {
/* 204 */       Exception exception2, exception1 = null;
/* 210 */     } catch (IOException e) {
/* 211 */       e.printStackTrace();
/*     */     } 
/*     */     try {
/* 214 */       st.encrypt(verKey, new File(String.valueOf(directory) + "\\bin\\version.txt"), 
/* 215 */           new File(String.valueOf(directory) + "\\bin\\version.txt"));
/* 216 */       st.println("Encrypted local version file");
/* 217 */       ConsoleSIM.text.append("Encrypted local version file \n");
/* 218 */     } catch (Exception e) {
/* 219 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void actionPerformed(ActionEvent ae) {
/* 225 */     String a = ae.getActionCommand();
/* 226 */     if (a.equals(b1Text)) {
/*     */       try {
/* 228 */         launchGame();
/* 229 */       } catch (IOException e) {
/* 230 */         e.printStackTrace();
/*     */       } 
/* 232 */     } else if (a.equals("Install Updates")) {
/* 233 */       installUpdate();
/* 234 */     } else if (a.equals("Install Game")) {
/* 235 */       installGame();
/* 236 */     } else if (a.equals("twitter")) {
/* 237 */       st.launchURL("https://twitter.com/egartley/");
/* 238 */     } else if (a.equals("site")) {
/* 239 */       st.launchURL("https://emgartley.wordpress.com/");
/*     */     } 
/*     */   }
/*     */   
/*     */   private void launchGame() throws IOException {
/* 244 */     if ((new File(directory)).exists() && (
/* 245 */       new File(String.valueOf(directory) + "\\bin")).exists() && (
/* 246 */       new File(String.valueOf(directory) + "\\bin\\BeyondOrigins.jar")).exists()) {
/* 247 */       String cmd = "java -jar \"C:\\Users\\" + 
/* 248 */         user + 
/* 249 */         "\\AppData\\Roaming\\Beyond Origins\\bin\\BeyondOrigins.jar\"";
/* 250 */       Runtime.getRuntime().exec(cmd);
/*     */       try {
/* 252 */         Thread.sleep(1500L);
/* 253 */       } catch (InterruptedException e) {
/* 254 */         e.printStackTrace();
/*     */       } 
/* 256 */       ConsoleSIM.close();
/* 257 */       System.exit(0);
/*     */     } else {
/* 259 */       setStatus("Unable to launch game; 'BeyondOrigins.jar' and/or its folders do not exist!");
/*     */     } 
/*     */   }
/*     */   
/*     */   private void installGame() {
/* 264 */     in.go();
/*     */   }
/*     */   
/*     */   private void installUpdate() {
/* 268 */     up.go();
/*     */   }
/*     */   
/*     */   public static void downloadFile(String fileName, String fileUrl) throws MalformedURLException, IOException {
/* 273 */     FileUtils.copyURLToFile(new URL(fileUrl), new File(fileName));
/* 274 */     st.println("Downloaded file '" + fileName + "' from the web");
/* 275 */     ConsoleSIM.text.append("Downloaded file '" + fileName + 
/* 276 */         "' from the web \n");
/*     */   }
/*     */   
/*     */   public static void downloadAssets() throws MalformedURLException, IOException {
/* 281 */     File control_old = new File(String.valueOf(tempDir) + "\\whatToAssets.txt");
/* 282 */     if (control_old.exists())
/* 283 */       control_old.delete(); 
/* 285 */     downloadFile(String.valueOf(tempDir) + "\\whatToAssets.txt", 
/* 286 */         "https://dl.dropboxusercontent.com/s/27760a7c789pp5l/whatToAssets.txt?dl=1");
/* 287 */     File control = new File(String.valueOf(tempDir) + "\\whatToAssets.txt");
/* 288 */     FileReader fileReader = new FileReader(control);
/* 289 */     BufferedReader buffRdr = new BufferedReader(new FileReader(control));
/* 290 */     LineNumberReader lineNumRdr = new LineNumberReader(fileReader);
/* 291 */     int lineNum = 0;
/* 292 */     while (lineNumRdr.readLine() != null)
/* 293 */       lineNum++; 
/* 295 */     int numOfAssets = lineNum / 2;
/* 296 */     for (int i = 0; i < numOfAssets; i++) {
/* 297 */       String name = buffRdr.readLine();
/* 298 */       String id = buffRdr.readLine();
/* 299 */       downloadFile(String.valueOf(directory) + "\\assets\\" + name, 
/* 300 */           "https://dl.dropboxusercontent.com/s/" + id + "/" + name + 
/* 301 */           "?dl=1");
/*     */     } 
/* 303 */     lineNumRdr.close();
/* 304 */     buffRdr.close();
/* 305 */     control.delete();
/* 306 */     st.println("Deleted temp assets control file");
/* 307 */     ConsoleSIM.text.append("Deleted temp assets control file \n");
/*     */   }
/*     */   
/*     */   private static void checkVersions(boolean dir) {
/* 312 */     if (dir) {
/* 313 */       st.println("Directory exists");
/* 314 */       ConsoleSIM.text.append("Directory exists \n");
/*     */       try {
/* 317 */         downloadFile(String.valueOf(tempDir) + "\\version.txt", 
/* 318 */             "https://dl.dropboxusercontent.com/s/63k5w7t3z0tk6cu/version.txt?dl=1");
/* 320 */         BufferedReader rdr = new BufferedReader(new FileReader(String.valueOf(tempDir) + 
/* 321 */               "\\version.txt"));
/* 322 */         currentVersion = rdr.readLine();
/* 323 */         st.println("Current Version is: " + currentVersion);
/* 324 */         ConsoleSIM.text.append("Current Version is: " + currentVersion + 
/* 325 */             " \n");
/* 326 */       } catch (IOException e) {
/* 327 */         e.printStackTrace();
/*     */       } 
/* 330 */       if ((new File(String.valueOf(directory) + "\\bin\\version.txt")).exists()) {
/* 331 */         st.println("Bin version file exists");
/* 332 */         ConsoleSIM.text.append("Bin version file exists \n");
/*     */         try {
/* 335 */           st.decrypt(verKey, new File(String.valueOf(directory) + 
/* 336 */                 "\\bin\\version.txt"), new File(String.valueOf(directory) + 
/* 337 */                 "\\bin\\version.txt"));
/* 338 */         } catch (Exception e1) {
/* 339 */           e1.printStackTrace();
/*     */         } 
/* 341 */         st.println("Decrypted bin version");
/* 342 */         ConsoleSIM.text.append("Decrypted bin version file \n");
/*     */         try {
/* 344 */           Exception exception2, exception1 = null;
/* 350 */         } catch (IOException e) {
/* 351 */           e.printStackTrace();
/*     */         } 
/*     */       } else {
/* 356 */         st.println("Bin version file does not exist");
/* 357 */         ConsoleSIM.text.append("Bin version file does not exist \n");
/* 358 */         installedVersion = currentVersion;
/* 359 */         writeVersionFile();
/*     */       } 
/* 361 */       File f = new File(String.valueOf(tempDir) + "\\version.txt");
/* 362 */       f.delete();
/* 363 */       st.println("Deleted temp version file");
/* 364 */       ConsoleSIM.text.append("Deleted temp version file \n");
/*     */     } else {
/* 366 */       st.println("Directory does not exist");
/* 367 */       ConsoleSIM.text.append("Directory does not exist \n");
/* 370 */       installedVersion = null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void checkForUpdates() {
/* 375 */     ConsoleSIM.createWindow();
/* 376 */     checkVersions((new File(directory)).exists());
/* 377 */     st.println("Comparing and deciding versions");
/* 378 */     ConsoleSIM.text.append("Comparing and deciding versions \n");
/* 379 */     if (installedVersion != null && installedVersion.equals(currentVersion) && (
/* 380 */       new File(String.valueOf(directory) + "\\bin\\BeyondOrigins.jar")).exists()) {
/* 381 */       setStatus("You have the current version! (" + installedVersion + 
/* 382 */           ")");
/* 383 */       button_install.setEnabled(false);
/* 384 */       b2Text = "Install Updates";
/* 385 */       button_install.setText(b2Text);
/* 386 */     } else if (installedVersion == null && 
/* 387 */       !(new File(String.valueOf(directory) + "\\bin\\BeyondOrigins.jar")).exists()) {
/* 388 */       setStatus("Click the 'Install Game' button to install Beyond Origins!");
/* 389 */       button_install.setEnabled(true);
/* 390 */       button_launch.setEnabled(false);
/* 391 */       b2Text = "Install Game";
/* 392 */       button_install.setText(b2Text);
/* 393 */     } else if (installedVersion != currentVersion) {
/* 394 */       setStatus("A new update is ready to be installed! (" + 
/* 395 */           currentVersion + ")");
/* 396 */       button_install.setEnabled(true);
/* 397 */       button_launch.setEnabled(false);
/* 398 */       b2Text = "Install Updates";
/* 399 */       button_install.setText(b2Text);
/*     */     } 
/* 401 */     if (installedVersion != currentVersion) {
/* 402 */       installedVersion = currentVersion;
/* 403 */       writeVersionFile();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\egart\Documents\GitHub\archive\Java\Beyond Origins Launcher\Builds\Launcher_v1.4.jar!\com\emgartley\beyondOriginsLauncher\Main.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */