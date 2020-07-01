/*     */ package com.emgartley.launcher;
/*     */ 
/*     */ import com.emgartley.stlib.STLib;
/*     */ import java.awt.Component;
/*     */ import java.awt.Font;
/*     */ import java.awt.FontMetrics;
/*     */ import java.awt.LayoutManager;
/*     */ import java.awt.Toolkit;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.File;
/*     */ import java.io.FileReader;
/*     */ import java.io.IOException;
/*     */ import java.net.MalformedURLException;
/*     */ import java.net.URL;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JLabel;
/*     */ import org.apache.commons.io.FileUtils;
/*     */ 
/*     */ public class Main extends JFrame implements ActionListener {
/*     */   private static final long serialVersionUID = 1L;
/*     */   
/*     */   public static JFrame frame;
/*     */   
/*  19 */   private static int scale = 46;
/*     */   
/*  20 */   public static int width = 16 * scale;
/*     */   
/*  20 */   public static int height = 9 * scale;
/*     */   
/*  21 */   public static String title = "Beyond Origins Launcher v1.1";
/*     */   
/*  22 */   public static String b1Text = "Launch Game";
/*     */   
/*  23 */   public static String b2Text = "Install Updates";
/*     */   
/*  24 */   public static String user = System.getProperty("user.name");
/*     */   
/*  25 */   public static String directory = "C:\\Users\\" + user + 
/*  26 */     "\\AppData\\Roaming\\Beyond Origins";
/*     */   
/*     */   public static String installedVersion;
/*     */   
/*     */   public static String currentVersion;
/*     */   
/*     */   public static String status;
/*     */   
/*  30 */   public static String verKey = "7204UN37GK017562";
/*     */   
/*  31 */   public static String tempDir = "C:\\Users\\" + user + 
/*  32 */     "\\AppData\\Local\\Temp";
/*     */   
/*     */   private static JLabel label_status;
/*     */   
/*  34 */   private Font buttonTextFont = new Font("MoolBoran", 0, 24);
/*     */   
/*     */   private static BufferedImage image_game;
/*     */   
/*     */   private static BufferedImage image_twitter;
/*     */   
/*     */   private static BufferedImage sLogo;
/*     */   
/*     */   private static BufferedImage mLogo;
/*     */   
/*     */   private static FontMetrics fm;
/*     */   
/*     */   public static STLib st;
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
/*     */   private Main() throws MalformedURLException, IOException {
/*  58 */     st = new STLib();
/*  59 */     setUpFrame();
/*  60 */     checkForUpdates();
/*     */   }
/*     */   
/*     */   public static void main(String[] args) throws Exception {
/*  64 */     frame = new Main();
/*  65 */     frame.setTitle(title);
/*  66 */     frame.setSize(width, height);
/*  67 */     frame.setResizable(false);
/*  68 */     frame.setLocationRelativeTo((Component)null);
/*  69 */     frame.setDefaultCloseOperation(3);
/*  70 */     st.setSystemLookAndFeel(frame);
/*  71 */     frame.setVisible(true);
/*  72 */     frame.setIconImage(Toolkit.getDefaultToolkit().getImage(
/*  73 */           JFrame.class.getResource("/icon32.png")));
/*     */   }
/*     */   
/*     */   private void setUpFolders() {
/*  77 */     createFolder(directory);
/*  78 */     createFolder(String.valueOf(directory) + "\\assets");
/*  79 */     createFolder(String.valueOf(directory) + "\\bin");
/*  80 */     createFolder(String.valueOf(directory) + "\\saves");
/*  81 */     createFolder(String.valueOf(directory) + "\\logs");
/*     */   }
/*     */   
/*     */   private void setUpFrame() {
/*  85 */     getContentPane().setLayout((LayoutManager)null);
/*  86 */     fm = getFontMetrics(this.buttonTextFont);
/*  87 */     button_launch = new JButton(b1Text);
/*  88 */     button_install = new JButton(b2Text);
/*  89 */     button_twitter = new JButton();
/*  90 */     button_website = new JButton();
/*  91 */     button_more = new JButton();
/*  92 */     label_status = new JLabel("Loading...");
/*  93 */     JLabel logo = new JLabel();
/*  94 */     image_game = st.loadImage("/logo.png");
/*  95 */     logo.setIcon(new ImageIcon(image_game));
/*  96 */     image_twitter = st.loadImage("/twitterLogo.png");
/*  97 */     sLogo = st.loadImage("/siteLogo.png");
/*  98 */     mLogo = st.loadImage("/moreLogo.png");
/*  99 */     button_launch.setBounds(width / 2 - 89, 143, 
/* 100 */         178, 32);
/* 101 */     button_install.setBounds(width / 2 - 89, 191, 
/* 102 */         178, 32);
/* 103 */     button_launch.addActionListener(this);
/* 104 */     button_install.addActionListener(this);
/* 105 */     button_twitter.addActionListener(this);
/* 106 */     button_website.addActionListener(this);
/* 107 */     button_more.addActionListener(this);
/* 108 */     button_launch.setFocusable(false);
/* 109 */     button_install.setFocusable(false);
/* 110 */     button_twitter.setFocusable(false);
/* 111 */     button_website.setFocusable(false);
/* 112 */     button_more.setFocusable(false);
/* 113 */     button_twitter.setIcon(new ImageIcon(image_twitter));
/* 114 */     button_website.setIcon(new ImageIcon(sLogo));
/* 115 */     button_more.setIcon(new ImageIcon(mLogo));
/* 116 */     button_twitter.setActionCommand("twitter");
/* 117 */     button_website.setActionCommand("site");
/* 118 */     button_more.setActionCommand("more");
/* 119 */     label_status.setFont(this.buttonTextFont);
/* 120 */     logo.setBounds(width / 2 - image_game.getWidth() / 2, 25, 
/* 121 */         image_game.getWidth(), image_game.getHeight());
/* 122 */     button_website.setBounds(width / 2 - 21 - 50, 239, 
/* 123 */         42, 42);
/* 124 */     button_twitter
/* 125 */       .setBounds(width / 2 - 21, 239, 42, 42);
/* 126 */     button_more.setBounds(width / 2 - 21 + 50, 239, 
/* 127 */         42, 42);
/* 128 */     button_website.setToolTipText("Vist Beyond Origins' webpage!");
/* 129 */     button_twitter.setToolTipText("Vist egartley's Twitter!");
/* 130 */     button_more.setToolTipText("More options...");
/* 131 */     add(button_launch);
/* 132 */     add(button_install);
/* 133 */     add(label_status);
/* 134 */     add(logo);
/* 135 */     add(button_twitter);
/* 136 */     add(button_website);
/* 137 */     add(button_more);
/*     */   }
/*     */   
/*     */   public static void setStatus(String text) {
/* 141 */     status = text;
/* 142 */     label_status.setText(text);
/* 143 */     label_status.setBounds(width / 2 - fm.stringWidth(text) / 2, 
/* 144 */         height - 100, width, 27);
/*     */   }
/*     */   
/*     */   public static void createFolder(String path) {
/* 148 */     File f = new File(path);
/* 149 */     if (!f.exists())
/* 150 */       f.mkdir(); 
/*     */   }
/*     */   
/*     */   private static void writeVersionFile() {
/* 155 */     st.println("Writing local version file");
/*     */     try {
/* 156 */       Exception exception2, exception1 = null;
/* 161 */     } catch (IOException e) {
/* 162 */       e.printStackTrace();
/*     */     } 
/*     */     try {
/* 165 */       st.encrypt(verKey, new File(String.valueOf(directory) + "\\bin\\version.txt"), 
/* 166 */           new File(String.valueOf(directory) + "\\bin\\version.txt"));
/* 167 */       st.println("Encrypted local version file");
/* 168 */     } catch (Exception e) {
/* 169 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void actionPerformed(ActionEvent ae) {
/* 175 */     String a = ae.getActionCommand();
/* 176 */     if (a.equals(b1Text)) {
/*     */       try {
/* 178 */         launchGame();
/* 179 */       } catch (IOException e) {
/* 180 */         e.printStackTrace();
/*     */       } 
/* 182 */     } else if (a.equals("Install Updates")) {
/* 183 */       installUpdate();
/* 184 */     } else if (a.equals("Install Game")) {
/* 185 */       installGame();
/* 186 */     } else if (a.equals("twitter")) {
/* 187 */       st.launchURL("https://twitter.com/egartley/");
/* 188 */     } else if (a.equals("site")) {
/* 189 */       st.launchURL("https://emgartley.wordpress.com/");
/* 190 */     } else if (a.equals("more")) {
/* 191 */       More m = new More();
/* 192 */       m.createWindow();
/*     */     } 
/*     */   }
/*     */   
/*     */   private void launchGame() throws IOException {
/* 197 */     if ((new File(directory)).exists() && (
/* 198 */       new File(String.valueOf(directory) + "\\bin")).exists() && (
/* 199 */       new File(String.valueOf(directory) + "\\bin\\BeyondOrigins.jar")).exists()) {
/* 200 */       String cmd = "java -jar \"C:\\Users\\" + 
/* 201 */         user + 
/* 202 */         "\\AppData\\Roaming\\Beyond Origins\\bin\\BeyondOrigins.jar\"";
/* 203 */       Runtime.getRuntime().exec(cmd);
/*     */       try {
/* 205 */         Thread.sleep(1500L);
/* 206 */       } catch (InterruptedException e) {
/* 207 */         e.printStackTrace();
/*     */       } 
/* 209 */       System.exit(0);
/*     */     } else {
/* 211 */       setStatus("Unable to launch game; 'BeyondOrigins.jar' and/or its folders do not exist!");
/*     */     } 
/*     */   }
/*     */   
/*     */   private void installGame() {
/* 216 */     setUpFolders();
/* 217 */     st.println("Set up folders");
/*     */     try {
/* 219 */       downloadFile(String.valueOf(directory) + "\\bin\\BeyondOrigins.jar", 
/* 220 */           "https://dl.dropboxusercontent.com/s/qj2pdfkwbsqea7l/BeyondOrigins.jar?dl=1");
/* 221 */       downloadAssets();
/* 222 */     } catch (IOException e) {
/* 223 */       setStatus("Error downloading content/update(s)! Contact @egartley on Twitter!");
/* 224 */       e.printStackTrace();
/*     */       return;
/*     */     } 
/* 227 */     st.println("Done installing");
/* 228 */     button_install.setEnabled(false);
/* 229 */     button_launch.setEnabled(true);
/* 230 */     setStatus("The game has been installed! Click 'Launch Game' to play!");
/* 231 */     checkForUpdates();
/*     */   }
/*     */   
/*     */   private void installUpdate() {
/*     */     try {
/* 236 */       downloadFile(String.valueOf(directory) + "\\bin\\BeyondOrigins.jar", 
/* 237 */           "https://dl.dropboxusercontent.com/s/qj2pdfkwbsqea7l/BeyondOrigins.jar?dl=1");
/* 238 */       downloadAssets();
/* 239 */     } catch (IOException e) {
/* 240 */       setStatus("Error downloading content/update(s)! Contact @egartley on Twitter!");
/* 241 */       e.printStackTrace();
/*     */       return;
/*     */     } 
/* 244 */     st.println("Done installing");
/* 245 */     button_install.setEnabled(false);
/* 246 */     button_launch.setEnabled(true);
/* 247 */     setStatus("The latest version has been installed!");
/*     */   }
/*     */   
/*     */   public static void downloadFile(String fileName, String fileUrl) throws MalformedURLException, IOException {
/* 252 */     FileUtils.copyURLToFile(new URL(fileUrl), new File(fileName));
/* 253 */     st.println("Downloaded file '" + fileName + "' from '" + fileUrl + "'");
/*     */   }
/*     */   
/*     */   private void downloadAssets() throws MalformedURLException, IOException {
/* 257 */     downloadFile(String.valueOf(directory) + "\\assets\\animals1.png", 
/* 258 */         "https://dl.dropboxusercontent.com/s/x8eawynxj3w6lza/animals1.png?dl=1");
/* 259 */     downloadFile(String.valueOf(directory) + "\\assets\\creds.png", 
/* 260 */         "https://dl.dropboxusercontent.com/s/qot7pm5x8yg65ef/creds.png?dl=1");
/* 261 */     downloadFile(String.valueOf(directory) + "\\assets\\entities1.png", 
/* 262 */         "https://dl.dropboxusercontent.com/s/z7zhrdfiqkix7uc/entities1.png?dl=1");
/* 263 */     downloadFile(String.valueOf(directory) + "\\assets\\grass.wav", 
/* 264 */         "https://dl.dropboxusercontent.com/s/wrp2ruszl197z7v/grass.wav?dl=1");
/* 265 */     downloadFile(String.valueOf(directory) + "\\assets\\icon32.png", 
/* 266 */         "https://dl.dropboxusercontent.com/s/4q9li1m3sa2rmbz/icon32.png?dl=1");
/* 267 */     downloadFile(String.valueOf(directory) + "\\assets\\inside1.png", 
/* 268 */         "https://dl.dropboxusercontent.com/s/5hg5hdac52qnc6e/inside1.png?dl=1");
/* 269 */     downloadFile(String.valueOf(directory) + "\\assets\\inventory.png", 
/* 270 */         "https://dl.dropboxusercontent.com/s/fn4x1rbsz59vo4g/inventory.png?dl=1");
/* 271 */     downloadFile(String.valueOf(directory) + "\\assets\\logo.png", 
/* 272 */         "https://dl.dropboxusercontent.com/s/q4k0f8gzibxrgz2/logo.png?dl=1");
/* 273 */     downloadFile(String.valueOf(directory) + "\\assets\\mainmenu.png", 
/* 274 */         "https://dl.dropboxusercontent.com/s/doyksdltvmopmsc/mainmenu.png?dl=1");
/* 275 */     downloadFile(String.valueOf(directory) + "\\assets\\mapGrid.png", 
/* 276 */         "https://dl.dropboxusercontent.com/s/di49rvg281kam31/mapGrid.png?dl=1");
/* 277 */     downloadFile(String.valueOf(directory) + "\\assets\\notification.wav", 
/* 278 */         "https://dl.dropboxusercontent.com/s/wfcktn5zadv67ev/notification.wav?dl=1");
/* 279 */     downloadFile(String.valueOf(directory) + "\\assets\\other1.png", 
/* 280 */         "https://dl.dropboxusercontent.com/s/edbs2yfg1b0tvft/other1.png?dl=1");
/* 281 */     downloadFile(String.valueOf(directory) + "\\assets\\player.png", 
/* 282 */         "https://dl.dropboxusercontent.com/s/b2n6q3t73id464h/player.png?dl=1");
/* 283 */     downloadFile(String.valueOf(directory) + "\\assets\\terrain1.png", 
/* 284 */         "https://dl.dropboxusercontent.com/s/d9ffzh15jmzyds9/terrain1.png?dl=1");
/* 285 */     downloadFile(String.valueOf(directory) + "\\assets\\widgets1.png", 
/* 286 */         "https://dl.dropboxusercontent.com/s/km12sv6hb0a6fz6/widgets1.png?dl=1");
/*     */   }
/*     */   
/*     */   private static void checkVersions(boolean dir) {
/* 291 */     if (dir) {
/* 292 */       st.println("Directory exists");
/*     */       try {
/* 295 */         downloadFile(String.valueOf(tempDir) + "\\version.txt", 
/* 296 */             "https://dl.dropboxusercontent.com/s/63k5w7t3z0tk6cu/version.txt?dl=1");
/* 298 */         BufferedReader rdr = new BufferedReader(new FileReader(String.valueOf(tempDir) + 
/* 299 */               "\\version.txt"));
/* 300 */         currentVersion = rdr.readLine();
/* 301 */         st.println("Current Version is: " + currentVersion);
/* 302 */       } catch (IOException e) {
/* 303 */         e.printStackTrace();
/*     */       } 
/* 306 */       if ((new File(String.valueOf(directory) + "\\bin\\version.txt")).exists()) {
/* 307 */         st.println("Bin version file exists");
/*     */         try {
/* 310 */           st.decrypt(verKey, new File(String.valueOf(directory) + 
/* 311 */                 "\\bin\\version.txt"), new File(String.valueOf(directory) + 
/* 312 */                 "\\bin\\version.txt"));
/* 313 */         } catch (Exception e1) {
/* 314 */           e1.printStackTrace();
/*     */         } 
/* 316 */         st.println("Decrypted bin version");
/*     */         try {
/* 318 */           Exception exception2, exception1 = null;
/* 322 */         } catch (IOException e) {
/* 323 */           e.printStackTrace();
/*     */         } 
/*     */       } else {
/* 328 */         st.println("Bin version file does not exist");
/* 329 */         installedVersion = currentVersion;
/* 330 */         writeVersionFile();
/*     */       } 
/*     */     } else {
/* 333 */       st.println("Directory does not exist");
/* 336 */       installedVersion = null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void checkForUpdates() {
/* 341 */     checkVersions((new File(directory)).exists());
/* 342 */     st.println("Comparing and deciding versions");
/* 343 */     if (installedVersion != null && installedVersion.equals(currentVersion) && (
/* 344 */       new File(String.valueOf(directory) + "\\bin\\BeyondOrigins.jar")).exists()) {
/* 345 */       setStatus("You have the current version! (" + installedVersion + 
/* 346 */           ")");
/* 347 */       button_install.setEnabled(false);
/* 348 */       b2Text = "Install Updates";
/* 349 */       button_install.setText(b2Text);
/* 350 */     } else if (installedVersion == null && 
/* 351 */       !(new File(String.valueOf(directory) + "\\bin\\BeyondOrigins.jar")).exists()) {
/* 352 */       setStatus("Click the 'Install Game' button to install Beyond Origins!");
/* 353 */       button_install.setEnabled(true);
/* 354 */       button_launch.setEnabled(false);
/* 355 */       b2Text = "Install Game";
/* 356 */       button_install.setText(b2Text);
/* 357 */     } else if (installedVersion != currentVersion) {
/* 358 */       setStatus("A new update is ready to be installed! (" + 
/* 359 */           currentVersion + ")");
/* 360 */       button_install.setEnabled(true);
/* 361 */       button_launch.setEnabled(false);
/* 362 */       b2Text = "Install Updates";
/* 363 */       button_install.setText(b2Text);
/*     */     } 
/* 365 */     if (installedVersion != currentVersion) {
/* 366 */       installedVersion = currentVersion;
/* 367 */       writeVersionFile();
/*     */     } 
/* 369 */     File f = new File(String.valueOf(tempDir) + "\\version.txt");
/* 370 */     f.delete();
/* 371 */     st.println("Deleted temp version file");
/*     */   }
/*     */ }


/* Location:              C:\Users\egart\Documents\GitHub\archive\Java\Beyond Origins Launcher\Builds\Launcher_v1.1.jar!\com\emgartley\launcher\Main.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */