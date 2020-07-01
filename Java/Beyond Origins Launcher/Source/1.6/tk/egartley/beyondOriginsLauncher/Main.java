/*     */ package tk.egartley.beyondOriginsLauncher;
/*     */ 
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
/*     */ import tk.egartley.stlib.STLib;
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
/*  25 */   public static String windowTitle = "Beyond Origins Launcher Beta";
/*     */   
/*  26 */   public static String launchButtonText = "Launch Game";
/*     */   
/*  27 */   public static String installButtonText = "Install", checkButtonText = "Check";
/*     */   
/*  28 */   public static String user = System.getProperty("user.name");
/*     */   
/*  29 */   public static String mainDir = String.valueOf(System.getenv("SystemDrive")) + "\\Users\\" + 
/*  30 */     user + "\\AppData\\Roaming\\Beyond Origins";
/*     */   
/*     */   public static String installedBuild;
/*     */   
/*     */   public static String remoteBuild;
/*     */   
/*  33 */   public static String status = "Loading...";
/*     */   
/*  34 */   public static String verKey = "7204UN37GK017562";
/*     */   
/*  35 */   public static String tempDir = String.valueOf(System.getenv("SystemDrive")) + "\\Users\\" + 
/*  36 */     user + "\\AppData\\Local\\Temp";
/*     */   
/*     */   private static JLabel statusLabel;
/*     */   
/*     */   public static String currentEULA;
/*     */   
/*     */   public static String currentChangeLog;
/*     */   
/*  39 */   public static Font buttonTextFont = new Font("Arial", 0, 12);
/*     */   
/*     */   private static BufferedImage gameLogo;
/*     */   
/*     */   private static FontMetrics fm;
/*     */   
/*     */   public static JProgressBar progressBar;
/*     */   
/*     */   public static STLib st;
/*     */   
/*     */   public static JButton launchButton;
/*     */   
/*     */   public static JButton installButton;
/*     */   
/*     */   public static JButton checkButton;
/*     */   
/*  45 */   private static File binVersionFile = new File(String.valueOf(mainDir) + "\\bin\\version.txt");
/*     */   
/*  46 */   private static File tempVersionFile = new File(String.valueOf(tempDir) + "\\version.txt");
/*     */   
/*     */   private Main() {
/*  49 */     super(new GridLayout(1, 1));
/*  51 */     JTabbedPane tp = new JTabbedPane();
/*  52 */     tp.setFocusable(false);
/*  54 */     setStatus("Loading...");
/*  55 */     JComponent mainPanel = getMainPanel();
/*  56 */     tp.addTab("Play Game", mainPanel);
/*  57 */     tp.setMnemonicAt(0, 49);
/*  59 */     JComponent eulaPanel = getEULAPanel();
/*  60 */     tp.addTab("Agreement", eulaPanel);
/*  61 */     tp.setMnemonicAt(1, 50);
/*  63 */     JComponent changesPanel = getChangesPanel();
/*  64 */     tp.addTab("Change Log", changesPanel);
/*  65 */     tp.setMnemonicAt(2, 51);
/*  67 */     JComponent consolePanel = getConsolePanel();
/*  68 */     tp.addTab("Console", consolePanel);
/*  69 */     tp.setMnemonicAt(3, 52);
/*  71 */     add(tp);
/*     */   }
/*     */   
/*     */   public static void main(String[] args) throws Exception {
/*  75 */     SwingUtilities.invokeLater(new Runnable() {
/*     */           public void run() {
/*  78 */             Main.st = new STLib();
/*  79 */             Main.frame = new JFrame(Main.windowTitle);
/*  80 */             Main.frame.setSize(Main.width, Main.height);
/*  81 */             Main.frame.setResizable(false);
/*  82 */             Main.frame.setLocationRelativeTo((Component)null);
/*  83 */             Main.frame.setDefaultCloseOperation(3);
/*  84 */             Main.frame.setIconImage(Toolkit.getDefaultToolkit().getImage(
/*  85 */                   JFrame.class.getResource("/icon32.png")));
/*  86 */             Main.frame.add(new Main(null), (Object)null);
/*  87 */             Main.frame.setVisible(true);
/*  88 */             Checker ch = new Checker();
/*  89 */             Main.updateEditorPanes();
/*  90 */             Main.st.setSystemLookAndFeel(Main.frame);
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   public static void updateEditorPanes() {
/*  96 */     Thread worker = new Thread() {
/*     */         public void run() {
/*  98 */           SwingUtilities.invokeLater(new Runnable() {
/*     */                 public void run() {
/* 100 */                   EULA.license.setText(Main.getCurrentEULA());
/* 101 */                   ChangeLog.changesPane.setText(Main.getCurrentChangeLog());
/*     */                 }
/*     */               });
/*     */         }
/*     */       };
/* 106 */     worker.start();
/*     */   }
/*     */   
/*     */   public static void println(String t) {
/* 110 */     st.cout(t);
/* 111 */     ConsoleSIM.appendText(t);
/*     */   }
/*     */   
/*     */   public JComponent getMainPanel() {
/* 115 */     JPanel panel = new JPanel(false);
/* 116 */     panel.setLayout((LayoutManager)null);
/* 117 */     fm = getFontMetrics(buttonTextFont);
/* 118 */     launchButton = new JButton(launchButtonText);
/* 119 */     installButton = new JButton(installButtonText);
/* 120 */     checkButton = new JButton(checkButtonText);
/* 121 */     statusLabel = new JLabel();
/* 122 */     statusLabel.setText("Loading...");
/* 123 */     JLabel logo = new JLabel();
/* 124 */     gameLogo = st.loadAbsoluteImage("/logo.png");
/* 125 */     logo.setIcon(new ImageIcon(gameLogo));
/* 126 */     launchButton.setBounds(width / 2 - 89, 153, 
/* 127 */         178, 32);
/* 128 */     installButton.setBounds(width / 2 - 89, 201, 
/* 129 */         81, 32);
/* 130 */     checkButton.setBounds(width / 2 + 8, 201, 
/* 131 */         81, 32);
/* 132 */     launchButton.addActionListener(this);
/* 133 */     installButton.addActionListener(this);
/* 134 */     checkButton.addActionListener(this);
/* 135 */     launchButton.setFocusable(false);
/* 136 */     installButton.setFocusable(false);
/* 137 */     checkButton.setFocusable(false);
/* 138 */     launchButton.setEnabled(false);
/* 139 */     installButton.setEnabled(false);
/* 140 */     checkButton.setEnabled(true);
/* 141 */     statusLabel.setFont(buttonTextFont);
/* 142 */     logo.setBounds(width / 2 - gameLogo.getWidth() / 2, 35, 
/* 143 */         gameLogo.getWidth(), gameLogo.getHeight());
/* 144 */     progressBar = new JProgressBar(0, 100);
/* 145 */     progressBar.setBounds(width / 2 - 88, height - 130, 176, 16);
/* 146 */     progressBar.setFocusable(false);
/* 147 */     progressBar.setVisible(true);
/* 148 */     progressBar.setIndeterminate(true);
/* 149 */     progressBar.setStringPainted(true);
/* 150 */     panel.add(logo);
/* 151 */     panel.add(launchButton);
/* 152 */     panel.add(installButton);
/* 153 */     panel.add(checkButton);
/* 154 */     panel.add(statusLabel);
/* 155 */     panel.add(progressBar);
/* 156 */     return panel;
/*     */   }
/*     */   
/*     */   public JComponent getEULAPanel() {
/* 160 */     JPanel panel = new JPanel(false);
/* 161 */     panel.setLayout((LayoutManager)null);
/* 162 */     EULA.license = new JEditorPane("text/html", "");
/* 163 */     EULA.license.setBounds(5, 5, width - 22, height - 66);
/* 164 */     EULA.license.setFocusable(false);
/* 165 */     JScrollPane sp = new JScrollPane(EULA.license);
/* 166 */     sp.setBounds(EULA.license.getBounds());
/* 167 */     panel.add(sp);
/* 168 */     return panel;
/*     */   }
/*     */   
/*     */   public JComponent getChangesPanel() {
/* 172 */     JPanel panel = new JPanel(false);
/* 173 */     panel.setLayout((LayoutManager)null);
/* 174 */     ChangeLog.changesPane = new JEditorPane("text/html", "");
/* 175 */     ChangeLog.changesPane.setBounds(5, 5, width - 22, height - 66);
/* 176 */     ChangeLog.changesPane.setEditable(false);
/* 177 */     ChangeLog.changesPane.setFocusable(false);
/* 178 */     JScrollPane sp = new JScrollPane(ChangeLog.changesPane);
/* 179 */     sp.setBounds(ChangeLog.changesPane.getBounds());
/* 180 */     panel.add(sp);
/* 181 */     return panel;
/*     */   }
/*     */   
/*     */   public JComponent getConsolePanel() {
/* 185 */     JPanel panel = new JPanel(false);
/* 186 */     panel.setLayout((LayoutManager)null);
/* 187 */     ConsoleSIM.text = new JTextArea();
/* 188 */     ConsoleSIM.text.setBounds(5, 5, width - 22, height - 66);
/* 189 */     ConsoleSIM.text.setEditable(false);
/* 190 */     ConsoleSIM.text.setFocusable(false);
/* 191 */     JScrollPane sp = new JScrollPane(ConsoleSIM.text);
/* 192 */     sp.setBounds(ConsoleSIM.text.getBounds());
/* 193 */     panel.add(sp);
/* 194 */     return panel;
/*     */   }
/*     */   
/*     */   public static String getCurrentEULA() {
/* 198 */     String lic = "";
/*     */     try {
/* 200 */       downloadFile(String.valueOf(tempDir) + "\\eula.html", 
/* 201 */           "https://dl.dropboxusercontent.com/s/rcvtpfb84f5t6ys/eula.html?dl=1");
/* 202 */       File file = new File(String.valueOf(tempDir) + "\\eula.html");
/* 203 */       FileInputStream fis = new FileInputStream(file);
/* 204 */       byte[] data = new byte[(int)file.length()];
/* 205 */       fis.read(data);
/* 206 */       fis.close();
/* 207 */       lic = new String(data, "UTF-8");
/* 208 */       file.delete();
/* 209 */     } catch (MalformedURLException e) {
/* 210 */       e.printStackTrace();
/* 211 */     } catch (IOException e) {
/* 212 */       e.printStackTrace();
/*     */     } 
/* 214 */     println("Returned current EULA");
/* 215 */     return lic;
/*     */   }
/*     */   
/*     */   public static String getCurrentChangeLog() {
/* 219 */     String cl = "";
/*     */     try {
/* 221 */       downloadFile(String.valueOf(tempDir) + "\\changes.html", 
/* 222 */           "https://dl.dropboxusercontent.com/s/cxx7qrwnxabd8hd/changes.html?dl=1");
/* 223 */       File file = new File(String.valueOf(tempDir) + "\\changes.html");
/* 224 */       FileInputStream fis = new FileInputStream(file);
/* 225 */       byte[] data = new byte[(int)file.length()];
/* 226 */       fis.read(data);
/* 227 */       fis.close();
/* 228 */       cl = new String(data, "UTF-8");
/* 229 */       file.delete();
/* 230 */     } catch (MalformedURLException e) {
/* 231 */       e.printStackTrace();
/* 232 */     } catch (IOException e) {
/* 233 */       e.printStackTrace();
/*     */     } 
/* 235 */     println("Returned current change log");
/* 236 */     return cl;
/*     */   }
/*     */   
/*     */   public static void setStatus(final String text) {
/* 240 */     SwingUtilities.invokeLater(new Runnable() {
/*     */           public void run() {
/* 242 */             Main.status = text;
/* 243 */             Main.statusLabel.setText(text);
/* 244 */             Main.statusLabel.setBounds(Main.width / 2 - Main.fm.stringWidth(text) / 2, 
/* 245 */                 250, Main.width, 27);
/* 246 */             Main.println("Set status to: " + text);
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   public static void writeVersionFile() {
/* 252 */     println("Writing bin version file...");
/* 253 */     File binVer = binVersionFile;
/*     */     try {
/* 254 */       Exception exception2, exception1 = null;
/* 259 */     } catch (IOException e) {
/* 260 */       println(e.getMessage());
/*     */     } 
/*     */     try {
/* 263 */       st.encrypt(verKey, binVer, binVer);
/* 264 */       println("Encrypted bin version file");
/* 265 */     } catch (Exception e) {
/* 266 */       println(e.getMessage());
/*     */     } 
/*     */   }
/*     */   
/*     */   public void actionPerformed(ActionEvent ae) {
/* 272 */     String a = ae.getActionCommand();
/* 273 */     if (a.equals(launchButtonText)) {
/*     */       try {
/* 275 */         launchGame();
/* 276 */       } catch (IOException e) {
/* 277 */         println(e.getMessage());
/*     */       } 
/* 279 */     } else if (a.equals("install_update")) {
/* 280 */       installUpdate();
/* 281 */     } else if (a.equals("install_game")) {
/* 282 */       installGame();
/* 283 */     } else if (a.equals("Check")) {
/* 284 */       checkForUpdates();
/*     */     } 
/*     */   }
/*     */   
/*     */   private void launchGame() throws IOException {
/* 289 */     if ((new File(mainDir)).exists() && (
/* 290 */       new File(String.valueOf(mainDir) + "\\bin")).exists() && (
/* 291 */       new File(String.valueOf(mainDir) + "\\bin\\BeyondOrigins.jar")).exists()) {
/* 292 */       String cmd = "java -jar \"C:\\Users\\" + 
/* 293 */         user + 
/* 294 */         "\\AppData\\Roaming\\Beyond Origins\\bin\\BeyondOrigins.jar\"";
/* 295 */       Runtime.getRuntime().exec(cmd);
/*     */       try {
/* 297 */         Thread.sleep(1000L);
/* 298 */       } catch (InterruptedException e) {
/* 299 */         e.printStackTrace();
/*     */       } 
/* 301 */       System.exit(0);
/*     */     } else {
/* 303 */       setStatus("Unable to launch game; 'BeyondOrigins.jar' and/or its folders do not exist!");
/*     */     } 
/*     */   }
/*     */   
/*     */   private void installGame() {
/* 309 */     Go install = new Go("install");
/*     */   }
/*     */   
/*     */   private void installUpdate() {
/* 314 */     Go update = new Go("update");
/*     */   }
/*     */   
/*     */   public static void downloadFile(String path, String url) throws MalformedURLException, IOException {
/* 319 */     File f = new File(path);
/* 320 */     if (!f.exists()) {
/* 321 */       FileUtils.copyURLToFile(new URL(url), f);
/* 322 */       println("Downloaded file '" + (new File(path)).getName() + "' from the web");
/*     */     } else {
/* 324 */       println("File '" + (new File(path)).getName() + "' already exists, can't download");
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void downloadAssets() throws MalformedURLException, IOException {
/* 330 */     File control_old = new File(String.valueOf(tempDir) + "\\whatToAssets.txt");
/* 331 */     if (control_old.exists() && control_old.delete())
/* 332 */       println("Deleted old assets control file"); 
/* 334 */     downloadFile(String.valueOf(tempDir) + "\\whatToAssets.txt", 
/* 335 */         "https://dl.dropboxusercontent.com/s/27760a7c789pp5l/whatToAssets.txt?dl=1");
/* 336 */     File control = new File(String.valueOf(tempDir) + "\\whatToAssets.txt");
/* 337 */     FileReader fileReader = new FileReader(control);
/* 338 */     BufferedReader buffRdr = new BufferedReader(new FileReader(control));
/* 339 */     LineNumberReader lineNumRdr = new LineNumberReader(fileReader);
/* 340 */     int lineNum = 0;
/* 341 */     while (lineNumRdr.readLine() != null)
/* 342 */       lineNum++; 
/* 344 */     int numOfAssets = lineNum / 2;
/* 345 */     for (int i = 0; i < numOfAssets; i++) {
/* 346 */       String name = buffRdr.readLine();
/* 347 */       String id = buffRdr.readLine();
/* 348 */       downloadFile(String.valueOf(mainDir) + "\\assets\\" + name, 
/* 349 */           "https://dl.dropboxusercontent.com/s/" + id + "/" + name + 
/* 350 */           "?dl=1");
/*     */     } 
/* 352 */     lineNumRdr.close();
/* 353 */     buffRdr.close();
/* 354 */     if (control.exists() && control.delete()) {
/* 355 */       println("Deleted temp assets control file");
/*     */     } else {
/* 357 */       println("Temp assets control file never existed");
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void checkVersions(boolean dir) {
/* 363 */     if (dir) {
/* 364 */       println("Main directory exists");
/*     */       try {
/* 367 */         downloadFile(String.valueOf(tempDir) + "\\version.txt", 
/* 368 */             "https://dl.dropboxusercontent.com/s/63k5w7t3z0tk6cu/version.txt?dl=1");
/* 370 */         BufferedReader rdr = new BufferedReader(new FileReader(String.valueOf(tempDir) + 
/* 371 */               "\\version.txt"));
/* 372 */         remoteBuild = rdr.readLine();
/* 373 */         println("Remote version is: " + remoteBuild);
/* 374 */       } catch (IOException e) {
/* 375 */         println(e.getMessage());
/*     */       } 
/* 378 */       if (binVersionFile.exists()) {
/* 379 */         println("Bin version file exists");
/*     */         try {
/* 382 */           st.decrypt(verKey, binVersionFile, binVersionFile);
/* 383 */         } catch (Exception e) {
/* 384 */           println(e.getMessage());
/*     */         } 
/* 386 */         println("Decrypted bin version");
/*     */         try {
/* 388 */           Exception exception2, exception1 = null;
/* 391 */         } catch (IOException e) {
/* 392 */           println(e.getMessage());
/*     */         } 
/*     */       } else {
/* 397 */         println("Bin version file does not exist");
/* 398 */         installedBuild = remoteBuild;
/* 399 */         writeVersionFile();
/*     */       } 
/* 401 */       if (tempVersionFile.delete()) {
/* 402 */         println("Deleted temp version file");
/*     */       } else {
/* 404 */         println("Error deleting temp version file");
/*     */       } 
/*     */     } else {
/* 406 */       println("Directory does not exist");
/* 409 */       installedBuild = null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void checkForUpdates() {
/* 415 */     Checker ch = new Checker();
/*     */   }
/*     */ }


/* Location:              C:\Users\egart\Documents\GitHub\archive\Java\Beyond Origins Launcher\Builds\Launcher_v1.6.jar!\tk\egartley\beyondOriginsLauncher\Main.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */