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
/*     */ import java.io.File;
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
/*  18 */   private static int scale = 46;
/*     */   
/*  19 */   private static int width = 16 * scale;
/*     */   
/*  19 */   private static int height = 9 * scale;
/*     */   
/*  20 */   private static String title = "Beyond Origins Launcher 1.0", b1Text = "Launch Game";
/*     */   
/*  21 */   private static String b2Text = "Install Updates", user = System.getProperty("user.name");
/*     */   
/*  22 */   private static String directory = "C:\\Users\\" + user + 
/*  23 */     "\\AppData\\Roaming\\Beyond Origins";
/*     */   
/*     */   private static String installedVersion;
/*     */   
/*     */   private static String newVersion;
/*     */   
/*  24 */   private static String status = "Loading...";
/*     */   
/*  24 */   private static String verKey = "7204UN37GK017562";
/*     */   
/*     */   private JLabel statusLabel;
/*     */   
/*  26 */   private Font buttonTextFont = new Font("MoolBoran", 0, 24);
/*     */   
/*     */   private BufferedImage gLogo;
/*     */   
/*     */   private BufferedImage tLogo;
/*     */   
/*     */   private BufferedImage sLogo;
/*     */   
/*     */   private FontMetrics fm;
/*     */   
/*     */   private static STLib st;
/*     */   
/*     */   private JButton launchButton;
/*     */   
/*     */   private JButton installButton;
/*     */   
/*     */   private JButton tButton;
/*     */   
/*     */   private JButton sButton;
/*     */   
/*     */   private Main() throws MalformedURLException, IOException {
/*  33 */     st = new STLib();
/*  34 */     createFolder(directory);
/*  35 */     createFolder(String.valueOf(directory) + "\\bin");
/*  36 */     createFolder(String.valueOf(directory) + "\\temp");
/*  37 */     createFolder(String.valueOf(directory) + "\\saves");
/*  38 */     createFolder(String.valueOf(directory) + "\\logs");
/*  39 */     getContentPane().setLayout((LayoutManager)null);
/*  40 */     this.fm = getFontMetrics(this.buttonTextFont);
/*  41 */     this.launchButton = new JButton(b1Text);
/*  42 */     this.installButton = new JButton(b2Text);
/*  43 */     this.tButton = new JButton();
/*  44 */     this.sButton = new JButton();
/*  45 */     this.statusLabel = new JLabel("Loading...");
/*  46 */     JLabel logo = new JLabel();
/*  47 */     this.gLogo = st.loadImage("/logo.png");
/*  48 */     logo.setIcon(new ImageIcon(this.gLogo));
/*  49 */     this.tLogo = st.loadImage("/twitterLogo.png");
/*  50 */     this.sLogo = st.loadImage("/siteLogo.png");
/*  51 */     this.launchButton.setBounds(width / 2 - 89, 143, 
/*  52 */         178, 32);
/*  53 */     this.installButton.setBounds(width / 2 - 89, 191, 
/*  54 */         178, 32);
/*  55 */     this.launchButton.addActionListener(this);
/*  56 */     this.installButton.addActionListener(this);
/*  57 */     this.tButton.addActionListener(this);
/*  58 */     this.sButton.addActionListener(this);
/*  59 */     this.launchButton.setFocusable(false);
/*  60 */     this.installButton.setFocusable(false);
/*  61 */     this.tButton.setFocusable(false);
/*  62 */     this.sButton.setFocusable(false);
/*  63 */     this.tButton.setIcon(new ImageIcon(this.tLogo));
/*  64 */     this.sButton.setIcon(new ImageIcon(this.sLogo));
/*  65 */     this.tButton.setActionCommand("twitter");
/*  66 */     this.sButton.setActionCommand("site");
/*  67 */     this.statusLabel.setFont(this.buttonTextFont);
/*  68 */     setStatus(status);
/*  69 */     logo.setBounds(width / 2 - this.gLogo.getWidth() / 2, 25, 
/*  70 */         this.gLogo.getWidth(), this.gLogo.getHeight());
/*  71 */     this.tButton.setBounds(width / 2 + 8, 239, 42, 42);
/*  72 */     this.sButton.setBounds(width / 2 - this.sLogo.getWidth() + 8, 
/*  73 */         239, 42, 42);
/*  74 */     add(this.launchButton);
/*  75 */     add(this.installButton);
/*  76 */     add(this.statusLabel);
/*  77 */     add(logo);
/*  78 */     add(this.tButton);
/*  79 */     add(this.sButton);
/*  80 */     checkForUpdates();
/*     */   }
/*     */   
/*     */   public static void createFolder(String path) {
/*  84 */     File f = new File(path);
/*  85 */     if (!f.exists())
/*  86 */       f.mkdir(); 
/*     */   }
/*     */   
/*     */   private void setStatus(String text) {
/*  91 */     status = text;
/*  92 */     this.statusLabel.setText(text);
/*  93 */     this.statusLabel.setBounds(width / 2 - this.fm.stringWidth(text) / 2, 
/*  94 */         height - 100, width, 27);
/*     */   }
/*     */   
/*     */   public void actionPerformed(ActionEvent ae) {
/*  99 */     String a = ae.getActionCommand();
/* 100 */     if (a.equals(b1Text)) {
/*     */       try {
/* 102 */         launchGame();
/* 103 */       } catch (IOException e) {
/* 104 */         e.printStackTrace();
/*     */       } 
/* 106 */     } else if (a.equals(b2Text)) {
/* 107 */       installUpdate();
/* 108 */     } else if (a.equals("twitter")) {
/* 109 */       st.launchURL("https://twitter.com/egartley/");
/* 110 */     } else if (a.equals("site")) {
/* 111 */       st.launchURL("https://emgartley.wordpress.com/");
/*     */     } 
/*     */   }
/*     */   
/*     */   private void launchGame() throws IOException {
/* 116 */     String cmd = "java -jar \"C:\\Users\\" + 
/* 117 */       user + 
/* 118 */       "\\AppData\\Roaming\\Beyond Origins\\bin\\BeyondOrigins.jar\"";
/* 119 */     Runtime.getRuntime().exec(cmd);
/* 120 */     System.exit(0);
/*     */   }
/*     */   
/*     */   private void installUpdate() {
/*     */     try {
/* 125 */       downloadFile(String.valueOf(directory) + "\\bin\\BeyondOrigins.jar", 
/* 126 */           "https://dl.dropboxusercontent.com/s/qj2pdfkwbsqea7l/BeyondOrigins.jar?dl=1");
/* 127 */     } catch (IOException e) {
/* 128 */       setStatus("Error downloading latest version!");
/* 129 */       e.printStackTrace();
/*     */     } 
/* 131 */     setStatus("The latest version has been installed!");
/* 132 */     this.installButton.setEnabled(false);
/* 133 */     this.launchButton.setEnabled(true);
/*     */   }
/*     */   
/*     */   public static void downloadFile(String fileName, String fileUrl) throws MalformedURLException, IOException {
/* 138 */     FileUtils.copyURLToFile(new URL(fileUrl), new File(fileName));
/*     */   }
/*     */   
/*     */   private void writeVersionFile() {
/*     */     try {
/* 142 */       Exception exception2, exception1 = null;
/* 146 */     } catch (IOException e) {
/* 147 */       e.printStackTrace();
/*     */     } 
/*     */     try {
/* 150 */       st.encrypt(verKey, new File(String.valueOf(directory) + "\\bin\\version.txt"), 
/* 151 */           new File(String.valueOf(directory) + "\\bin\\version.txt"));
/* 152 */     } catch (Exception e) {
/* 153 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   private void checkForUpdates() {
/*     */     try {
/* 159 */       downloadFile(String.valueOf(directory) + "\\temp\\version.txt", 
/* 160 */           "https://dl.dropboxusercontent.com/s/63k5w7t3z0tk6cu/version.txt?dl=1");
/* 161 */     } catch (IOException e) {
/* 162 */       e.printStackTrace();
/*     */     } 
/*     */     try {
/* 164 */       Exception exception2, exception1 = null;
/* 167 */     } catch (IOException e) {
/* 168 */       e.printStackTrace();
/*     */     } 
/* 170 */     if ((new File(String.valueOf(directory) + "\\bin\\version.txt")).exists()) {
/*     */       try {
/* 172 */         st.decrypt(verKey, new File(String.valueOf(directory) + "\\bin\\version.txt"), 
/* 173 */             new File(String.valueOf(directory) + "\\bin\\version.txt"));
/* 174 */       } catch (Exception e1) {
/* 175 */         e1.printStackTrace();
/*     */       } 
/*     */       try {
/* 177 */         Exception exception2, exception1 = null;
/* 180 */       } catch (IOException e) {
/* 181 */         e.printStackTrace();
/*     */       } 
/*     */     } 
/* 184 */     if (installedVersion != null && installedVersion.equals(newVersion) && (
/* 185 */       new File(String.valueOf(directory) + "\\bin\\BeyondOrigins.jar")).exists()) {
/* 186 */       setStatus("You have the current version! (" + installedVersion + 
/* 187 */           ")");
/* 188 */       this.installButton.setEnabled(false);
/* 189 */       b2Text = "Install Updates";
/* 190 */       this.installButton.setText(b2Text);
/* 191 */     } else if (installedVersion == null) {
/* 192 */       setStatus("Click the '" + b2Text + 
/* 193 */           "' button to install Beyond Origins!");
/* 194 */       this.installButton.setEnabled(true);
/* 195 */       b2Text = "Install Game";
/* 196 */       this.installButton.setText(b2Text);
/* 197 */       this.launchButton.setEnabled(false);
/* 198 */     } else if (installedVersion != newVersion) {
/* 199 */       setStatus("A new update is ready to be installed! (" + newVersion + 
/* 200 */           ")");
/* 201 */       this.installButton.setEnabled(true);
/* 202 */       b2Text = "Install Updates";
/* 203 */       this.installButton.setText(b2Text);
/*     */     } 
/* 205 */     if (installedVersion != newVersion) {
/* 206 */       installedVersion = newVersion;
/* 207 */       writeVersionFile();
/*     */     } 
/* 209 */     File f = new File(String.valueOf(directory) + "\\temp\\version.txt");
/* 210 */     f.delete();
/*     */   }
/*     */   
/*     */   public static void main(String[] args) throws Exception {
/* 214 */     JFrame frame = new Main();
/* 215 */     frame.setTitle(title);
/* 216 */     frame.setSize(width, height);
/* 217 */     frame.setResizable(false);
/* 218 */     frame.setLocationRelativeTo((Component)null);
/* 219 */     frame.setDefaultCloseOperation(3);
/* 220 */     st.setSystemLookAndFeel(frame);
/* 221 */     frame.setVisible(true);
/* 222 */     frame.setIconImage(Toolkit.getDefaultToolkit().getImage(
/* 223 */           JFrame.class.getResource("/icon32.png")));
/*     */   }
/*     */ }


/* Location:              C:\Users\egart\Documents\GitHub\archive\Java\Beyond Origins Launcher\Builds\Launcher_v1.0.jar!\com\emgartley\launcher\Main.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */