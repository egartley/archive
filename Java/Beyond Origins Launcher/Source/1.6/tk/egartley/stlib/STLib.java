/*     */ package tk.egartley.stlib;
/*     */ 
/*     */ import java.awt.Component;
/*     */ import java.awt.Font;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Graphics2D;
/*     */ import java.awt.Image;
/*     */ import java.awt.RenderingHints;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.security.Key;
/*     */ import javax.crypto.Cipher;
/*     */ import javax.crypto.NoSuchPaddingException;
/*     */ import javax.crypto.spec.SecretKeySpec;
/*     */ import javax.imageio.ImageIO;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.SwingUtilities;
/*     */ import javax.swing.UIManager;
/*     */ import sun.audio.AudioPlayer;
/*     */ import sun.audio.AudioStream;
/*     */ 
/*     */ public class STLib {
/*     */   private static final String ALGORITHM = "AES";
/*     */   
/*     */   private static final String TRANSFORMATION = "AES";
/*     */   
/*     */   public boolean isVisibleWithin(int targetX, int targetY, int windowWidth, int windowHeight, int targetWidth, int targetHeight) {
/*  58 */     if (targetX >= -targetWidth + -1 && targetY >= -targetHeight + -1 && 
/*  59 */       targetX <= windowWidth && targetY <= windowHeight)
/*  60 */       return true; 
/*  62 */     return false;
/*     */   }
/*     */   
/*     */   public boolean isPixelTransparent(int x, int y, BufferedImage i) {
/*  71 */     int pixel = i.getRGB(x, y);
/*  72 */     if (pixel >> 24 == 0)
/*  73 */       return true; 
/*  75 */     return false;
/*     */   }
/*     */   
/*     */   public boolean isWithinRadius(int radius, int var1, int var2) {
/*  82 */     if (Math.sqrt((var1 * var1 + var2 * var2)) <= radius)
/*  83 */       return true; 
/*  85 */     return false;
/*     */   }
/*     */   
/*     */   public BufferedImage loadAbsoluteImage(String path) {
/*     */     try {
/*  94 */       return ImageIO.read(getClass().getResource(path));
/*  95 */     } catch (IOException e) {
/*  96 */       e.printStackTrace();
/*  98 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public BufferedImage getCroppedImage(BufferedImage sheet, int x, int y, int w, int h) {
/* 106 */     return sheet.getSubimage(x, y, w, h);
/*     */   }
/*     */   
/*     */   public String toString(int i) {
/* 110 */     return String.valueOf(i);
/*     */   }
/*     */   
/*     */   public String toString(double i) {
/* 114 */     return String.valueOf(i);
/*     */   }
/*     */   
/*     */   public String toString(short i) {
/* 118 */     return String.valueOf(i);
/*     */   }
/*     */   
/*     */   public String toString(float i) {
/* 122 */     return String.valueOf(i);
/*     */   }
/*     */   
/*     */   public String toString(byte i) {
/* 126 */     return String.valueOf(i);
/*     */   }
/*     */   
/*     */   public String toString(long i) {
/* 130 */     return String.valueOf(i);
/*     */   }
/*     */   
/*     */   public String toString(char i) {
/* 134 */     return String.valueOf(i);
/*     */   }
/*     */   
/*     */   public String toString(boolean i) {
/* 138 */     return String.valueOf(i);
/*     */   }
/*     */   
/*     */   public String removeCharAt(String s, int pos) {
/* 145 */     return String.valueOf(s.substring(0, pos)) + s.substring(pos + 1);
/*     */   }
/*     */   
/*     */   public void createFile(File file) {
/*     */     try {
/* 153 */       file.createNewFile();
/* 154 */     } catch (IOException e) {
/* 155 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void createFile(String path) {
/*     */     try {
/* 164 */       File file = new File(path);
/* 165 */       file.createNewFile();
/* 166 */     } catch (IOException e) {
/* 167 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void deleteFile(File file) {
/* 175 */     file.delete();
/*     */   }
/*     */   
/*     */   public void deleteFile(String path) {
/* 182 */     File file = new File(path);
/* 183 */     file.delete();
/*     */   }
/*     */   
/*     */   public void setSystemLookAndFeel(JFrame frame) {
/*     */     try {
/* 192 */       UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
/* 194 */     } catch (ClassNotFoundException|InstantiationException|IllegalAccessException|javax.swing.UnsupportedLookAndFeelException e) {
/* 195 */       e.printStackTrace();
/*     */     } 
/* 197 */     SwingUtilities.updateComponentTreeUI(frame);
/*     */   }
/*     */   
/*     */   public void launchURL(String url) {
/* 204 */     String cmd = "cmd.exe /c start " + url;
/*     */     try {
/* 206 */       Runtime.getRuntime().exec(cmd);
/* 207 */     } catch (IOException e) {
/* 208 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void enableAntiAliasing(Graphics g) {
/* 216 */     Graphics2D g2d = (Graphics2D)g;
/* 217 */     g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, 
/* 218 */         RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
/*     */   }
/*     */   
/*     */   public void createFolder(File file) {
/* 225 */     if (!file.exists()) {
/* 226 */       File folder = file;
/* 227 */       folder.mkdir();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void createFolder(String path) {
/* 235 */     if (!(new File(path)).exists()) {
/* 236 */       File folder = new File(path);
/* 237 */       folder.mkdir();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addFrameText(JFrame jf, Font f, String text, int x, int y, int w, int h) {
/* 246 */     JLabel l = new JLabel(text);
/* 247 */     l.setBounds(x, y, w, h);
/* 248 */     l.setFont(f);
/* 249 */     l.setOpaque(true);
/* 250 */     jf.add(l);
/*     */   }
/*     */   
/*     */   public void addFrameText(JFrame jf, String text, int x, int y, int w, int h) {
/* 257 */     JLabel l = new JLabel(text);
/* 258 */     l.setBounds(x, y, w, h);
/* 259 */     l.setOpaque(true);
/* 260 */     jf.add(l);
/*     */   }
/*     */   
/*     */   public void addFrameButton(JFrame jf, ActionListener actl, String t, int x, int y, int w, int h) {
/* 268 */     JButton b = new JButton(t);
/* 269 */     b.setBounds(x, y, w, h);
/* 270 */     b.setFocusable(false);
/* 271 */     b.addActionListener(actl);
/* 272 */     jf.add(b);
/*     */   }
/*     */   
/*     */   public void setAbsoluteFrameIcon(JFrame jf, String iconPath) {
/* 279 */     Image icon = null;
/*     */     try {
/* 281 */       icon = ImageIO.read(new File(iconPath));
/* 282 */     } catch (IOException e) {
/* 283 */       e.printStackTrace();
/*     */     } 
/* 285 */     jf.setIconImage(icon);
/*     */   }
/*     */   
/*     */   public void centerFrame(JFrame jf) {
/* 292 */     jf.setLocationRelativeTo((Component)null);
/*     */   }
/*     */   
/*     */   public void addFrameImage(JFrame jf, BufferedImage image, int x, int y) {
/* 299 */     JLabel logoLabel = new JLabel();
/* 300 */     logoLabel.setIcon(new ImageIcon(image));
/* 301 */     logoLabel.setBounds(x, y, image.getWidth(), image.getHeight());
/* 302 */     jf.add(logoLabel);
/*     */   }
/*     */   
/*     */   public void systemExit() {
/* 309 */     System.exit(0);
/*     */   }
/*     */   
/*     */   public void cout(String t) {
/* 316 */     System.out.println(t);
/*     */   }
/*     */   
/*     */   public void playSound(String path) {
/*     */     try {
/* 324 */       InputStream inputStream = new FileInputStream(path);
/* 325 */       AudioStream audioStream = new AudioStream(inputStream);
/* 326 */       AudioPlayer.player.start((InputStream)audioStream);
/* 327 */     } catch (Exception e) {
/* 328 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void encrypt(String key, File inputFile, File outputFile) throws Exception {
/* 337 */     doCrypto(1, key, inputFile, outputFile);
/*     */   }
/*     */   
/*     */   public void decrypt(String key, File inputFile, File outputFile) throws Exception {
/* 345 */     doCrypto(2, key, inputFile, outputFile);
/*     */   }
/*     */   
/*     */   private void doCrypto(int cipherMode, String key, File inputFile, File outputFile) throws Exception {
/*     */     try {
/* 354 */       Key secretKey = new SecretKeySpec(key.getBytes(), "AES");
/* 355 */       Cipher cipher = Cipher.getInstance("AES");
/* 356 */       cipher.init(cipherMode, secretKey);
/* 357 */       FileInputStream inputStream = new FileInputStream(inputFile);
/* 358 */       byte[] inputBytes = new byte[(int)inputFile.length()];
/* 359 */       inputStream.read(inputBytes);
/* 360 */       byte[] outputBytes = cipher.doFinal(inputBytes);
/* 361 */       FileOutputStream outputStream = new FileOutputStream(outputFile);
/* 362 */       outputStream.write(outputBytes);
/* 363 */       inputStream.close();
/* 364 */       outputStream.close();
/* 367 */     } catch (NoSuchPaddingException|java.security.NoSuchAlgorithmException|java.security.InvalidKeyException|javax.crypto.BadPaddingException|javax.crypto.IllegalBlockSizeException|IOException ex) {
/* 368 */       ex.printStackTrace();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\egart\Documents\GitHub\archive\Java\Beyond Origins Launcher\Builds\Launcher_v1.6.jar!\tk\egartley\stlib\STLib.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */