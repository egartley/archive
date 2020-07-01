/*     */ package tk.egartley.beyondOriginsLauncher;
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
/*     */ import javax.swing.JProgressBar;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.JTabbedPane;
/*     */ import javax.swing.JTextArea;
/*     */ import javax.swing.SwingUtilities;
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
/*  25 */   public static String title = "Beyond Origins Launcher 1.5 BETA";
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
/*     */   public static String remoteVersion;
/*     */   
/*  33 */   public static String status = "Loading...";
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
/*  42 */   public static JProgressBar progressBar = new JProgressBar(0, 100);
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
/*     */   private Main() {
/*  48 */     super(new GridLayout(1, 1));
/*  50 */     JTabbedPane tp = new JTabbedPane();
/*  51 */     tp.setFocusable(false);
/*  53 */     JComponent mainPanel = getMainPanel();
/*  54 */     tp.addTab("Main", mainPanel);
/*  55 */     tp.setMnemonicAt(0, 49);
/*  57 */     JComponent eulaPanel = getEULAPanel();
/*  58 */     tp.addTab("Agreement", eulaPanel);
/*  59 */     tp.setMnemonicAt(1, 50);
/*  61 */     JComponent changesPanel = getCLPanel();
/*  62 */     tp.addTab("Change Log", changesPanel);
/*  63 */     tp.setMnemonicAt(2, 51);
/*  65 */     JComponent consolePanel = getConsolePanel();
/*  66 */     tp.addTab("Console", consolePanel);
/*  67 */     tp.setMnemonicAt(3, 52);
/*  69 */     add(tp);
/*     */   }
/*     */   
/*     */   public static void main(String[] args) throws Exception {
/*  73 */     SwingUtilities.invokeLater(new Runnable() {
/*     */           public void run() {
/*  76 */             Main.st = new STLib();
/*  77 */             Main.frame = new JFrame(Main.title);
/*  78 */             Main.frame.setSize(Main.width, Main.height);
/*  79 */             Main.frame.setResizable(false);
/*  80 */             Main.frame.setLocationRelativeTo((Component)null);
/*  81 */             Main.frame.setDefaultCloseOperation(3);
/*  82 */             Main.frame.setIconImage(Toolkit.getDefaultToolkit().getImage(
/*  83 */                   JFrame.class.getResource("/icon32.png")));
/*  84 */             Main.frame.add(new Main(null), (Object)null);
/*  85 */             Main.frame.setVisible(true);
/*  86 */             Checker ch = new Checker();
/*  87 */             Main.updateEditorPanes();
/*  88 */             Main.st.setSystemLookAndFeel(Main.frame);
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   public static void updateEditorPanes() {
/*  94 */     Thread worker = new Thread() {
/*     */         public void run() {
/*  96 */           SwingUtilities.invokeLater(new Runnable() {
/*     */                 public void run() {
/*  98 */                   EULA.license.setText(Main.getCurrentEULA());
/*  99 */                   ChangeLog.changesPane.setText(Main.getCurrentChangeLog());
/*     */                 }
/*     */               });
/*     */         }
/*     */       };
/* 104 */     worker.start();
/*     */   }
/*     */   
/*     */   public static void println(String t) {
/* 108 */     st.println(t);
/* 109 */     ConsoleSIM.appendText(t);
/*     */   }
/*     */   
/*     */   public JComponent getMainPanel() {
/* 113 */     JPanel panel = new JPanel(false);
/* 114 */     panel.setLayout((LayoutManager)null);
/* 115 */     fm = getFontMetrics(buttonTextFont);
/* 116 */     button_launch = new JButton(b1Text);
/* 117 */     button_install = new JButton(b2Text);
/* 118 */     label_status = new JLabel();
/* 119 */     label_status.setText("Loading...");
/* 120 */     JLabel logo = new JLabel();
/* 121 */     image_game = st.loadImage("/logo.png");
/* 122 */     logo.setIcon(new ImageIcon(image_game));
/* 123 */     button_launch.setBounds(width / 2 - 89, 143, 
/* 124 */         178, 32);
/* 125 */     button_install.setBounds(width / 2 - 89, 191, 
/* 126 */         178, 32);
/* 127 */     button_launch.addActionListener(this);
/* 128 */     button_install.addActionListener(this);
/* 129 */     button_launch.setFocusable(false);
/* 130 */     button_install.setFocusable(false);
/* 131 */     label_status.setFont(buttonTextFont);
/* 132 */     logo.setBounds(width / 2 - image_game.getWidth() / 2, 25, 
/* 133 */         image_game.getWidth(), image_game.getHeight());
/* 134 */     progressBar.setBounds(width / 2 - 88, height - 140, 176, 16);
/* 135 */     progressBar.setFocusable(false);
/* 136 */     progressBar.setIndeterminate(true);
/* 137 */     progressBar.setStringPainted(true);
/* 138 */     progressBar.setString("Loading...");
/* 139 */     panel.add(logo);
/* 140 */     panel.add(button_launch);
/* 141 */     panel.add(button_install);
/* 142 */     panel.add(label_status);
/* 143 */     panel.add(progressBar);
/* 144 */     return panel;
/*     */   }
/*     */   
/*     */   public JComponent getEULAPanel() {
/* 148 */     JPanel panel = new JPanel(false);
/* 149 */     panel.setLayout((LayoutManager)null);
/* 150 */     EULA.license = new JEditorPane("text/html", "");
/* 151 */     EULA.license.setBounds(5, 5, width - 22, height - 66);
/* 152 */     EULA.license.setFocusable(false);
/* 153 */     JScrollPane sp = new JScrollPane(EULA.license);
/* 154 */     sp.setBounds(EULA.license.getBounds());
/* 155 */     panel.add(sp);
/* 156 */     return panel;
/*     */   }
/*     */   
/*     */   public JComponent getCLPanel() {
/* 160 */     JPanel panel = new JPanel(false);
/* 161 */     panel.setLayout((LayoutManager)null);
/* 162 */     ChangeLog.changesPane = new JEditorPane("text/html", "");
/* 163 */     ChangeLog.changesPane.setBounds(5, 5, width - 22, height - 66);
/* 164 */     ChangeLog.changesPane.setEditable(false);
/* 165 */     ChangeLog.changesPane.setFocusable(false);
/* 166 */     JScrollPane sp = new JScrollPane(ChangeLog.changesPane);
/* 167 */     sp.setBounds(ChangeLog.changesPane.getBounds());
/* 168 */     panel.add(sp);
/* 169 */     return panel;
/*     */   }
/*     */   
/*     */   public JComponent getConsolePanel() {
/* 173 */     JPanel panel = new JPanel(false);
/* 174 */     panel.setLayout((LayoutManager)null);
/* 175 */     ConsoleSIM.text = new JTextArea();
/* 176 */     ConsoleSIM.text.setBounds(5, 5, width - 22, height - 66);
/* 177 */     ConsoleSIM.text.setEditable(false);
/* 178 */     ConsoleSIM.text.setFocusable(false);
/* 179 */     JScrollPane sp = new JScrollPane(ConsoleSIM.text);
/* 180 */     sp.setBounds(ConsoleSIM.text.getBounds());
/* 181 */     panel.add(sp);
/* 182 */     return panel;
/*     */   }
/*     */   
/*     */   public static String getCurrentEULA() {
/* 186 */     String lic = "";
/*     */     try {
/* 188 */       downloadFile(String.valueOf(tempDir) + "\\eula.html", 
/* 189 */           "https://dl.dropboxusercontent.com/s/rcvtpfb84f5t6ys/eula.html?dl=1");
/* 190 */       File file = new File(String.valueOf(tempDir) + "\\eula.html");
/* 191 */       FileInputStream fis = new FileInputStream(file);
/* 192 */       byte[] data = new byte[(int)file.length()];
/* 193 */       fis.read(data);
/* 194 */       fis.close();
/* 195 */       lic = new String(data, "UTF-8");
/* 196 */       file.delete();
/* 197 */     } catch (MalformedURLException e) {
/* 198 */       e.printStackTrace();
/* 199 */     } catch (IOException e) {
/* 200 */       e.printStackTrace();
/*     */     } 
/* 202 */     st.println("Returned current EULA");
/* 203 */     ConsoleSIM.appendText("Returned current EULA");
/* 204 */     return lic;
/*     */   }
/*     */   
/*     */   public static String getCurrentChangeLog() {
/* 208 */     String cl = "";
/*     */     try {
/* 210 */       downloadFile(String.valueOf(tempDir) + "\\changes.html", 
/* 211 */           "https://dl.dropboxusercontent.com/s/cxx7qrwnxabd8hd/changes.html?dl=1");
/* 212 */       File file = new File(String.valueOf(tempDir) + "\\changes.html");
/* 213 */       FileInputStream fis = new FileInputStream(file);
/* 214 */       byte[] data = new byte[(int)file.length()];
/* 215 */       fis.read(data);
/* 216 */       fis.close();
/* 217 */       cl = new String(data, "UTF-8");
/* 218 */       file.delete();
/* 219 */     } catch (MalformedURLException e) {
/* 220 */       e.printStackTrace();
/* 221 */     } catch (IOException e) {
/* 222 */       e.printStackTrace();
/*     */     } 
/* 224 */     st.println("Returned current change log");
/* 225 */     ConsoleSIM.appendText("Returned current change log");
/* 226 */     return cl;
/*     */   }
/*     */   
/*     */   public static void setStatus(final String text) {
/* 230 */     SwingUtilities.invokeLater(new Runnable() {
/*     */           public void run() {
/* 232 */             Main.status = text;
/* 233 */             Main.label_status.setText(text);
/* 234 */             Main.label_status.setBounds(Main.width / 2 - Main.fm.stringWidth(text) / 2, 
/* 235 */                 240, Main.width, 27);
/* 236 */             Main.println("Set status to: " + text);
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   public static void writeVersionFile() {
/* 242 */     println("Writing local version file...");
/* 243 */     File lvf = new File(String.valueOf(directory) + "\\bin\\version.txt");
/*     */     try {
/* 244 */       Exception exception2, exception1 = null;
/* 249 */     } catch (IOException e) {
/* 250 */       println(e.getMessage());
/*     */     } 
/*     */     try {
/* 253 */       st.encrypt(verKey, lvf, lvf);
/* 254 */       println("Encrypted local version file");
/* 255 */     } catch (Exception e) {
/* 256 */       println(e.getMessage());
/*     */     } 
/*     */   }
/*     */   
/*     */   public void actionPerformed(ActionEvent ae) {
/* 262 */     String a = ae.getActionCommand();
/* 263 */     if (a.equals(b1Text)) {
/*     */       try {
/* 265 */         launchGame();
/* 266 */       } catch (IOException e) {
/* 267 */         println(e.getMessage());
/*     */       } 
/* 269 */     } else if (a.equals("Install Updates")) {
/* 270 */       installUpdate();
/* 271 */     } else if (a.equals("Install Game")) {
/* 272 */       installGame();
/* 273 */     } else if (a.equals("twitter")) {
/* 274 */       st.launchURL("https://twitter.com/egartley/");
/* 275 */     } else if (a.equals("site")) {
/* 276 */       st.launchURL("https://emgartley.wordpress.com/");
/*     */     } 
/*     */   }
/*     */   
/*     */   private void launchGame() throws IOException {
/* 281 */     if ((new File(directory)).exists() && (
/* 282 */       new File(String.valueOf(directory) + "\\bin")).exists() && (
/* 283 */       new File(String.valueOf(directory) + "\\bin\\BeyondOrigins.jar")).exists()) {
/* 284 */       String cmd = "java -jar \"C:\\Users\\" + 
/* 285 */         user + 
/* 286 */         "\\AppData\\Roaming\\Beyond Origins\\bin\\BeyondOrigins.jar\"";
/* 287 */       Runtime.getRuntime().exec(cmd);
/*     */       try {
/* 289 */         Thread.sleep(1500L);
/* 290 */       } catch (InterruptedException e) {
/* 291 */         e.printStackTrace();
/*     */       } 
/* 293 */       System.exit(0);
/*     */     } else {
/* 295 */       setStatus("Unable to launch game; 'BeyondOrigins.jar' and/or its folders do not exist!");
/*     */     } 
/*     */   }
/*     */   
/*     */   private void installGame() {
/* 301 */     Install install = new Install();
/*     */   }
/*     */   
/*     */   private void installUpdate() {
/* 306 */     Update update = new Update();
/*     */   }
/*     */   
/*     */   public static void downloadFile(String fileName, String fileUrl) throws MalformedURLException, IOException {
/* 311 */     FileUtils.copyURLToFile(new URL(fileUrl), new File(fileName));
/* 312 */     println("Downloaded file '" + (new File(fileName)).getName() + "' from the web");
/*     */   }
/*     */   
/*     */   public static void downloadAssets() throws MalformedURLException, IOException {
/* 317 */     File control_old = new File(String.valueOf(tempDir) + "\\whatToAssets.txt");
/* 318 */     if (control_old.exists())
/* 319 */       control_old.delete(); 
/* 321 */     downloadFile(String.valueOf(tempDir) + "\\whatToAssets.txt", 
/* 322 */         "https://dl.dropboxusercontent.com/s/27760a7c789pp5l/whatToAssets.txt?dl=1");
/* 323 */     File control = new File(String.valueOf(tempDir) + "\\whatToAssets.txt");
/* 324 */     FileReader fileReader = new FileReader(control);
/* 325 */     BufferedReader buffRdr = new BufferedReader(new FileReader(control));
/* 326 */     LineNumberReader lineNumRdr = new LineNumberReader(fileReader);
/* 327 */     int lineNum = 0;
/* 328 */     while (lineNumRdr.readLine() != null)
/* 329 */       lineNum++; 
/* 331 */     int numOfAssets = lineNum / 2;
/* 332 */     for (int i = 0; i < numOfAssets; i++) {
/* 333 */       String name = buffRdr.readLine();
/* 334 */       String id = buffRdr.readLine();
/* 335 */       downloadFile(String.valueOf(directory) + "\\assets\\" + name, 
/* 336 */           "https://dl.dropboxusercontent.com/s/" + id + "/" + name + 
/* 337 */           "?dl=1");
/*     */     } 
/* 339 */     lineNumRdr.close();
/* 340 */     buffRdr.close();
/* 341 */     control.delete();
/* 342 */     println("Deleted temp assets control file");
/*     */   }
/*     */   
/*     */   public static void checkVersions(boolean dir) {
/* 347 */     if (dir) {
/* 348 */       println("Main directory does exist");
/*     */       try {
/* 351 */         downloadFile(String.valueOf(tempDir) + "\\version.txt", 
/* 352 */             "https://dl.dropboxusercontent.com/s/63k5w7t3z0tk6cu/version.txt?dl=1");
/* 354 */         BufferedReader rdr = new BufferedReader(new FileReader(String.valueOf(tempDir) + 
/* 355 */               "\\version.txt"));
/* 356 */         remoteVersion = rdr.readLine();
/* 357 */         println("Remote version is: " + remoteVersion);
/* 358 */       } catch (IOException e) {
/* 359 */         println(e.getMessage());
/*     */       } 
/* 362 */       if ((new File(String.valueOf(directory) + "\\bin\\version.txt")).exists()) {
/* 363 */         println("Bin version file exists");
/*     */         try {
/* 366 */           st.decrypt(verKey, new File(String.valueOf(directory) + 
/* 367 */                 "\\bin\\version.txt"), new File(String.valueOf(directory) + 
/* 368 */                 "\\bin\\version.txt"));
/* 369 */         } catch (Exception e1) {
/* 370 */           println(e1.getMessage());
/*     */         } 
/* 372 */         println("Decrypted bin version");
/*     */         try {
/* 374 */           Exception exception2, exception1 = null;
/* 378 */         } catch (IOException e) {
/* 379 */           println(e.getMessage());
/*     */         } 
/*     */       } else {
/* 384 */         println("Bin version file does not exist");
/* 385 */         installedVersion = remoteVersion;
/* 386 */         writeVersionFile();
/*     */       } 
/* 388 */       File f = new File(String.valueOf(tempDir) + "\\version.txt");
/* 389 */       f.delete();
/* 390 */       println("Deleted temp version file");
/*     */     } else {
/* 392 */       println("Directory does not exist");
/* 395 */       installedVersion = null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void checkForUpdates() {
/* 401 */     Checker ch = new Checker();
/*     */   }
/*     */ }


/* Location:              C:\Users\egart\Documents\GitHub\archive\Java\Beyond Origins Launcher\Builds\Launcher_v1.5.jar!\tk\egartley\beyondOriginsLauncher\Main.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */