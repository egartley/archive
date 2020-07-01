/*     */ package com.emgartley.beyondOriginsLauncher;
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
/*     */ import java.io.FileInputStream;
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
/*     */   public static boolean running = false;
/*     */   
/*  24 */   public static int scale = 46;
/*     */   
/*  25 */   public static int width = 16 * scale;
/*     */   
/*  25 */   public static int height = 9 * scale;
/*     */   
/*  26 */   public static String title = "Beyond Origins Launcher v1.3";
/*     */   
/*  27 */   public static String b1Text = "Launch Game";
/*     */   
/*  28 */   public static String b2Text = "Install Updates";
/*     */   
/*  29 */   public static String user = System.getProperty("user.name");
/*     */   
/*  30 */   public static String directory = String.valueOf(System.getenv("SystemDrive")) + "\\Users\\" + 
/*  31 */     user + "\\AppData\\Roaming\\Beyond Origins";
/*     */   
/*     */   public static String installedVersion;
/*     */   
/*     */   public static String currentVersion;
/*     */   
/*     */   public static String status;
/*     */   
/*  35 */   public static String verKey = "7204UN37GK017562";
/*     */   
/*  36 */   public static String tempDir = String.valueOf(System.getenv("SystemDrive")) + "\\Users\\" + 
/*  37 */     user + "\\AppData\\Local\\Temp";
/*     */   
/*     */   private static JLabel label_status;
/*     */   
/*  39 */   public static Font buttonTextFont = new Font("MoolBoran", 0, 24);
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
/*     */   private Main() throws MalformedURLException, IOException {
/*  49 */     st = new STLib();
/*  50 */     setUpFrame();
/*  51 */     checkForUpdates();
/*     */   }
/*     */   
/*     */   public static void main(String[] args) throws Exception {
/*  55 */     running = true;
/*  56 */     frame = new Main();
/*  57 */     frame.setTitle(title);
/*  58 */     frame.setSize(width, height);
/*  59 */     frame.setResizable(false);
/*  60 */     frame.setLocationRelativeTo((Component)null);
/*  61 */     frame.setDefaultCloseOperation(3);
/*  62 */     st.setSystemLookAndFeel(frame);
/*  63 */     frame.setVisible(true);
/*  64 */     frame.setIconImage(Toolkit.getDefaultToolkit().getImage(
/*  65 */           JFrame.class.getResource("/icon32.png")));
/*     */   }
/*     */   
/*     */   private void setUpFrame() {
/*  69 */     getContentPane().setLayout((LayoutManager)null);
/*  70 */     fm = getFontMetrics(buttonTextFont);
/*  71 */     button_launch = new JButton(b1Text);
/*  72 */     button_install = new JButton(b2Text);
/*  73 */     button_twitter = new JButton();
/*  74 */     button_website = new JButton();
/*  75 */     button_more = new JButton();
/*  76 */     label_status = new JLabel("Loading...");
/*  77 */     JLabel logo = new JLabel();
/*  78 */     image_game = st.loadImage("/logo.png");
/*  79 */     logo.setIcon(new ImageIcon(image_game));
/*  80 */     image_twitter = st.loadImage("/twitterLogo.png");
/*  81 */     sLogo = st.loadImage("/siteLogo.png");
/*  82 */     mLogo = st.loadImage("/moreLogo.png");
/*  83 */     button_launch.setBounds(width / 2 - 89, 143, 
/*  84 */         178, 32);
/*  85 */     button_install.setBounds(width / 2 - 89, 191, 
/*  86 */         178, 32);
/*  87 */     button_launch.addActionListener(this);
/*  88 */     button_install.addActionListener(this);
/*  89 */     button_twitter.addActionListener(this);
/*  90 */     button_website.addActionListener(this);
/*  91 */     button_more.addActionListener(this);
/*  92 */     button_launch.setFocusable(false);
/*  93 */     button_install.setFocusable(false);
/*  94 */     button_twitter.setFocusable(false);
/*  95 */     button_website.setFocusable(false);
/*  96 */     button_more.setFocusable(false);
/*  97 */     button_twitter.setIcon(new ImageIcon(image_twitter));
/*  98 */     button_website.setIcon(new ImageIcon(sLogo));
/*  99 */     button_more.setIcon(new ImageIcon(mLogo));
/* 100 */     button_twitter.setActionCommand("twitter");
/* 101 */     button_website.setActionCommand("site");
/* 102 */     button_more.setActionCommand("more");
/* 103 */     label_status.setFont(buttonTextFont);
/* 104 */     logo.setBounds(width / 2 - image_game.getWidth() / 2, 25, 
/* 105 */         image_game.getWidth(), image_game.getHeight());
/* 106 */     button_website.setBounds(width / 2 - 21 - 50, 239, 
/* 107 */         42, 42);
/* 108 */     button_twitter
/* 109 */       .setBounds(width / 2 - 21, 239, 42, 42);
/* 110 */     button_more.setBounds(width / 2 - 21 + 50, 239, 
/* 111 */         42, 42);
/* 112 */     button_website.setToolTipText("Vist Beyond Origins' webpage!");
/* 113 */     button_twitter.setToolTipText("Vist egartley's Twitter!");
/* 114 */     button_more.setToolTipText("More options...");
/* 115 */     add(button_launch);
/* 116 */     add(button_install);
/* 117 */     add(label_status);
/* 118 */     add(logo);
/* 119 */     add(button_twitter);
/* 120 */     add(button_website);
/* 121 */     add(button_more);
/*     */   }
/*     */   
/*     */   public static String getCurrentLicense() {
/* 125 */     String lic = "";
/*     */     try {
/* 127 */       downloadFile(String.valueOf(tempDir) + "\\license.txt", 
/* 128 */           "https://dl.dropboxusercontent.com/s/ux5t2kqqv9b53rx/license.txt?dl=1");
/* 129 */       File file = new File(String.valueOf(tempDir) + "\\license.txt");
/* 130 */       FileInputStream fis = new FileInputStream(file);
/* 131 */       byte[] data = new byte[(int)file.length()];
/* 132 */       fis.read(data);
/* 133 */       fis.close();
/* 134 */       lic = new String(data, "UTF-8");
/* 135 */       file.delete();
/* 136 */     } catch (MalformedURLException e) {
/* 137 */       e.printStackTrace();
/* 138 */     } catch (IOException e) {
/* 139 */       e.printStackTrace();
/*     */     } 
/* 141 */     st.println("Returned current license");
/* 142 */     return lic;
/*     */   }
/*     */   
/*     */   public static String getCurrentChangeLog() {
/* 146 */     String cl = "";
/*     */     try {
/* 148 */       downloadFile(String.valueOf(tempDir) + "\\changes.txt", 
/* 149 */           "https://dl.dropboxusercontent.com/s/z9a104sjpfrk08b/changes.txt?dl=1");
/* 150 */       File file = new File(String.valueOf(tempDir) + "\\changes.txt");
/* 151 */       FileInputStream fis = new FileInputStream(file);
/* 152 */       byte[] data = new byte[(int)file.length()];
/* 153 */       fis.read(data);
/* 154 */       fis.close();
/* 155 */       cl = new String(data, "UTF-8");
/* 156 */       file.delete();
/* 157 */     } catch (MalformedURLException e) {
/* 158 */       e.printStackTrace();
/* 159 */     } catch (IOException e) {
/* 160 */       e.printStackTrace();
/*     */     } 
/* 162 */     st.println("Returned current change log");
/* 163 */     return cl;
/*     */   }
/*     */   
/*     */   public static void setStatus(String text) {
/* 167 */     status = text;
/* 168 */     label_status.setText(text);
/* 169 */     label_status.setBounds(width / 2 - fm.stringWidth(text) / 2, 
/* 170 */         height - 100, width, 27);
/* 171 */     st.println("Set status to: " + text);
/*     */   }
/*     */   
/*     */   private static void writeVersionFile() {
/* 175 */     st.println("Writing local version file");
/*     */     try {
/* 176 */       Exception exception2, exception1 = null;
/* 181 */     } catch (IOException e) {
/* 182 */       e.printStackTrace();
/*     */     } 
/*     */     try {
/* 185 */       st.encrypt(verKey, new File(String.valueOf(directory) + "\\bin\\version.txt"), 
/* 186 */           new File(String.valueOf(directory) + "\\bin\\version.txt"));
/* 187 */       st.println("Encrypted local version file");
/* 188 */     } catch (Exception e) {
/* 189 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void actionPerformed(ActionEvent ae) {
/* 195 */     String a = ae.getActionCommand();
/* 196 */     if (a.equals(b1Text)) {
/*     */       try {
/* 198 */         launchGame();
/* 199 */       } catch (IOException e) {
/* 200 */         e.printStackTrace();
/*     */       } 
/* 202 */     } else if (a.equals("Install Updates")) {
/* 203 */       installUpdate();
/* 204 */     } else if (a.equals("Install Game")) {
/* 205 */       installGame();
/* 206 */     } else if (a.equals("twitter")) {
/* 207 */       st.launchURL("https://twitter.com/egartley/");
/* 208 */     } else if (a.equals("site")) {
/* 209 */       st.launchURL("https://emgartley.wordpress.com/");
/* 210 */     } else if (a.equals("more")) {
/* 211 */       More m = new More();
/* 212 */       m.createWindow();
/*     */     } 
/*     */   }
/*     */   
/*     */   private void launchGame() throws IOException {
/* 217 */     if ((new File(directory)).exists() && (
/* 218 */       new File(String.valueOf(directory) + "\\bin")).exists() && (
/* 219 */       new File(String.valueOf(directory) + "\\bin\\BeyondOrigins.jar")).exists()) {
/* 220 */       String cmd = "java -jar \"C:\\Users\\" + 
/* 221 */         user + 
/* 222 */         "\\AppData\\Roaming\\Beyond Origins\\bin\\BeyondOrigins.jar\"";
/* 223 */       Runtime.getRuntime().exec(cmd);
/*     */       try {
/* 225 */         Thread.sleep(1500L);
/* 226 */       } catch (InterruptedException e) {
/* 227 */         e.printStackTrace();
/*     */       } 
/* 229 */       System.exit(0);
/*     */     } else {
/* 231 */       setStatus("Unable to launch game; 'BeyondOrigins.jar' and/or its folders do not exist!");
/*     */     } 
/*     */   }
/*     */   
/*     */   private void installGame() {
/* 236 */     in.go();
/*     */   }
/*     */   
/*     */   private void installUpdate() {
/* 240 */     up.go();
/*     */   }
/*     */   
/*     */   public static void downloadFile(String fileName, String fileUrl) throws MalformedURLException, IOException {
/* 245 */     FileUtils.copyURLToFile(new URL(fileUrl), new File(fileName));
/* 246 */     st.println("Downloaded file '" + fileName + "' from '" + fileUrl + "'");
/*     */   }
/*     */   
/*     */   public static void downloadAssets() throws MalformedURLException, IOException {
/* 251 */     downloadFile(String.valueOf(directory) + "\\assets\\animals1.png", 
/* 252 */         "https://dl.dropboxusercontent.com/s/x8eawynxj3w6lza/animals1.png?dl=1");
/* 253 */     downloadFile(String.valueOf(directory) + "\\assets\\creds.png", 
/* 254 */         "https://dl.dropboxusercontent.com/s/qot7pm5x8yg65ef/creds.png?dl=1");
/* 255 */     downloadFile(String.valueOf(directory) + "\\assets\\entities1.png", 
/* 256 */         "https://dl.dropboxusercontent.com/s/z7zhrdfiqkix7uc/entities1.png?dl=1");
/* 257 */     downloadFile(String.valueOf(directory) + "\\assets\\grass.wav", 
/* 258 */         "https://dl.dropboxusercontent.com/s/wrp2ruszl197z7v/grass.wav?dl=1");
/* 259 */     downloadFile(String.valueOf(directory) + "\\assets\\icon32.png", 
/* 260 */         "https://dl.dropboxusercontent.com/s/4q9li1m3sa2rmbz/icon32.png?dl=1");
/* 261 */     downloadFile(String.valueOf(directory) + "\\assets\\inside1.png", 
/* 262 */         "https://dl.dropboxusercontent.com/s/5hg5hdac52qnc6e/inside1.png?dl=1");
/* 263 */     downloadFile(String.valueOf(directory) + "\\assets\\inventory.png", 
/* 264 */         "https://dl.dropboxusercontent.com/s/fn4x1rbsz59vo4g/inventory.png?dl=1");
/* 265 */     downloadFile(String.valueOf(directory) + "\\assets\\logo.png", 
/* 266 */         "https://dl.dropboxusercontent.com/s/q4k0f8gzibxrgz2/logo.png?dl=1");
/* 267 */     downloadFile(String.valueOf(directory) + "\\assets\\mainmenu.png", 
/* 268 */         "https://dl.dropboxusercontent.com/s/doyksdltvmopmsc/mainmenu.png?dl=1");
/* 269 */     downloadFile(String.valueOf(directory) + "\\assets\\mapGrid.png", 
/* 270 */         "https://dl.dropboxusercontent.com/s/di49rvg281kam31/mapGrid.png?dl=1");
/* 271 */     downloadFile(String.valueOf(directory) + "\\assets\\notification.wav", 
/* 272 */         "https://dl.dropboxusercontent.com/s/wfcktn5zadv67ev/notification.wav?dl=1");
/* 273 */     downloadFile(String.valueOf(directory) + "\\assets\\other1.png", 
/* 274 */         "https://dl.dropboxusercontent.com/s/edbs2yfg1b0tvft/other1.png?dl=1");
/* 275 */     downloadFile(String.valueOf(directory) + "\\assets\\player.png", 
/* 276 */         "https://dl.dropboxusercontent.com/s/b2n6q3t73id464h/player.png?dl=1");
/* 277 */     downloadFile(String.valueOf(directory) + "\\assets\\terrain1.png", 
/* 278 */         "https://dl.dropboxusercontent.com/s/d9ffzh15jmzyds9/terrain1.png?dl=1");
/* 279 */     downloadFile(String.valueOf(directory) + "\\assets\\widgets1.png", 
/* 280 */         "https://dl.dropboxusercontent.com/s/km12sv6hb0a6fz6/widgets1.png?dl=1");
/*     */   }
/*     */   
/*     */   private static void checkVersions(boolean dir) {
/* 285 */     if (dir) {
/* 286 */       st.println("Directory exists");
/*     */       try {
/* 289 */         downloadFile(String.valueOf(tempDir) + "\\version.txt", 
/* 290 */             "https://dl.dropboxusercontent.com/s/63k5w7t3z0tk6cu/version.txt?dl=1");
/* 292 */         BufferedReader rdr = new BufferedReader(new FileReader(String.valueOf(tempDir) + 
/* 293 */               "\\version.txt"));
/* 294 */         currentVersion = rdr.readLine();
/* 295 */         st.println("Current Version is: " + currentVersion);
/* 296 */       } catch (IOException e) {
/* 297 */         e.printStackTrace();
/*     */       } 
/* 300 */       if ((new File(String.valueOf(directory) + "\\bin\\version.txt")).exists()) {
/* 301 */         st.println("Bin version file exists");
/*     */         try {
/* 304 */           st.decrypt(verKey, new File(String.valueOf(directory) + 
/* 305 */                 "\\bin\\version.txt"), new File(String.valueOf(directory) + 
/* 306 */                 "\\bin\\version.txt"));
/* 307 */         } catch (Exception e1) {
/* 308 */           e1.printStackTrace();
/*     */         } 
/* 310 */         st.println("Decrypted bin version");
/*     */         try {
/* 312 */           Exception exception2, exception1 = null;
/* 316 */         } catch (IOException e) {
/* 317 */           e.printStackTrace();
/*     */         } 
/*     */       } else {
/* 322 */         st.println("Bin version file does not exist");
/* 323 */         installedVersion = currentVersion;
/* 324 */         writeVersionFile();
/*     */       } 
/*     */     } else {
/* 327 */       st.println("Directory does not exist");
/* 330 */       installedVersion = null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void checkForUpdates() {
/* 335 */     checkVersions((new File(directory)).exists());
/* 336 */     st.println("Comparing and deciding versions");
/* 337 */     if (installedVersion != null && installedVersion.equals(currentVersion) && (
/* 338 */       new File(String.valueOf(directory) + "\\bin\\BeyondOrigins.jar")).exists()) {
/* 339 */       setStatus("You have the current version! (" + installedVersion + 
/* 340 */           ")");
/* 341 */       button_install.setEnabled(false);
/* 342 */       b2Text = "Install Updates";
/* 343 */       button_install.setText(b2Text);
/* 344 */     } else if (installedVersion == null && 
/* 345 */       !(new File(String.valueOf(directory) + "\\bin\\BeyondOrigins.jar")).exists()) {
/* 346 */       setStatus("Click the 'Install Game' button to install Beyond Origins!");
/* 347 */       button_install.setEnabled(true);
/* 348 */       button_launch.setEnabled(false);
/* 349 */       b2Text = "Install Game";
/* 350 */       button_install.setText(b2Text);
/* 351 */     } else if (installedVersion != currentVersion) {
/* 352 */       setStatus("A new update is ready to be installed! (" + 
/* 353 */           currentVersion + ")");
/* 354 */       button_install.setEnabled(true);
/* 355 */       button_launch.setEnabled(false);
/* 356 */       b2Text = "Install Updates";
/* 357 */       button_install.setText(b2Text);
/*     */     } 
/* 359 */     if (installedVersion != currentVersion) {
/* 360 */       installedVersion = currentVersion;
/* 361 */       writeVersionFile();
/*     */     } 
/* 363 */     File f = new File(String.valueOf(tempDir) + "\\version.txt");
/* 364 */     f.delete();
/* 365 */     st.println("Deleted temp version file");
/*     */   }
/*     */ }


/* Location:              C:\Users\egart\Documents\GitHub\archive\Java\Beyond Origins Launcher\Builds\Launcher_v1.3.jar!\com\emgartley\beyondOriginsLauncher\Main.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */