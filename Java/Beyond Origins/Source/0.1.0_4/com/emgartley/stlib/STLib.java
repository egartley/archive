/*     */ package com.emgartley.stlib;
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
/*     */ import javax.swing.UnsupportedLookAndFeelException;
/*     */ import sun.audio.AudioPlayer;
/*     */ import sun.audio.AudioStream;
/*     */ 
/*     */ public class STLib {
/*     */   private static final String ALGORITHM = "AES";
/*     */   
/*     */   private static final String TRANSFORMATION = "AES";
/*     */   
/*     */   public boolean imageIsVisible(int renderx, int rendery, int windowWidth, int windowHeight, int imageWidth, int imageHeight) {
/*  65 */     if (renderx >= -imageWidth + -1 && rendery >= -imageHeight + -1 && 
/*  66 */       renderx <= windowWidth && rendery <= windowHeight)
/*  67 */       return true; 
/*  69 */     return false;
/*     */   }
/*     */   
/*     */   public boolean isTransparent(int x, int y, BufferedImage i) {
/*  73 */     int pixel = i.getRGB(x, y);
/*  74 */     if (pixel >> 24 == 0)
/*  75 */       return true; 
/*  77 */     return false;
/*     */   }
/*     */   
/*     */   public boolean isInRange(int radius, int var1, int var2) {
/*  81 */     if (Math.sqrt((var1 * var1 + var2 * var2)) <= radius)
/*  82 */       return true; 
/*  84 */     return false;
/*     */   }
/*     */   
/*     */   public BufferedImage loadImage(String path) {
/*     */     try {
/*  96 */       return ImageIO.read(getClass().getResource(path));
/*  97 */     } catch (IOException e) {
/*  98 */       e.printStackTrace();
/* 100 */       System.out
/* 101 */         .println("STLib | ERROR: Unable to read image from '" + 
/*     */           
/* 103 */           path + 
/* 104 */           "'!\nPlease make sure the filename is correct and\nthe file extension is included.");
/* 105 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public BufferedImage getCropped(BufferedImage sheet, int x, int y, int w, int h) {
/* 110 */     return sheet.getSubimage(x, y, w, h);
/*     */   }
/*     */   
/*     */   public String toString(int i) {
/* 114 */     return String.valueOf(i);
/*     */   }
/*     */   
/*     */   public String toString(double i) {
/* 118 */     return String.valueOf(i);
/*     */   }
/*     */   
/*     */   public String toString(short i) {
/* 122 */     return String.valueOf(i);
/*     */   }
/*     */   
/*     */   public String toString(float i) {
/* 126 */     return String.valueOf(i);
/*     */   }
/*     */   
/*     */   public String toString(byte i) {
/* 130 */     return String.valueOf(i);
/*     */   }
/*     */   
/*     */   public String toString(long i) {
/* 134 */     return String.valueOf(i);
/*     */   }
/*     */   
/*     */   public String toString(char i) {
/* 138 */     return String.valueOf(i);
/*     */   }
/*     */   
/*     */   public String toString(boolean i) {
/* 142 */     return String.valueOf(i);
/*     */   }
/*     */   
/*     */   public String removeCharAt(String s, int pos) {
/* 146 */     return String.valueOf(s.substring(0, pos)) + s.substring(pos + 1);
/*     */   }
/*     */   
/*     */   public void createFile(String path) {
/*     */     try {
/* 156 */       File file = new File(path);
/* 157 */       file.createNewFile();
/* 158 */     } catch (IOException e) {
/* 159 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void deleteFile(File file) {
/* 168 */     file.delete();
/*     */   }
/*     */   
/*     */   public void deleteFile(String path) {
/* 176 */     File file = new File(path);
/* 177 */     file.delete();
/*     */   }
/*     */   
/*     */   public void setSystemLookAndFeel(JFrame frame) {
/*     */     try {
/* 186 */       UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
/* 187 */     } catch (ClassNotFoundException e) {
/* 188 */       e.printStackTrace();
/* 189 */     } catch (InstantiationException e) {
/* 190 */       e.printStackTrace();
/* 191 */     } catch (IllegalAccessException e) {
/* 192 */       e.printStackTrace();
/* 193 */     } catch (UnsupportedLookAndFeelException e) {
/* 194 */       e.printStackTrace();
/*     */     } 
/* 197 */     SwingUtilities.updateComponentTreeUI(frame);
/*     */   }
/*     */   
/*     */   public void launchURL(String url) {
/* 208 */     String cmd = "cmd.exe /c start " + url;
/*     */     try {
/* 210 */       Runtime.getRuntime().exec(cmd);
/* 211 */     } catch (IOException e) {
/* 212 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void animateEntity(Graphics g, int x, int y, BufferedImage[] frame, short count) {
/* 218 */     for (int i = 1; i < frame.length; i++) {
/* 219 */       int c = i * 10 + 1;
/* 220 */       int cc = c - 9;
/* 221 */       if (count >= cc && count <= c)
/* 222 */         g.drawImage(frame[i], x, y, null); 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void enableAntiAliasing(Graphics g) {
/* 228 */     Graphics2D g2d = (Graphics2D)g;
/* 229 */     g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, 
/* 230 */         RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
/*     */   }
/*     */   
/*     */   public void createFolder(String path) {
/* 234 */     if (!(new File(path)).exists())
/* 235 */       boolean bool = (new File(path)).mkdir(); 
/*     */   }
/*     */   
/*     */   public void addText(JFrame jf, Font f, String text, int x, int y, int w, int h) {
/* 243 */     JLabel l = new JLabel(text);
/* 244 */     l.setBounds(x, y, w, h);
/* 245 */     l.setFont(f);
/* 246 */     l.setOpaque(true);
/* 247 */     jf.add(l);
/*     */   }
/*     */   
/*     */   public void addText(JFrame jf, String text, int x, int y, int w, int h) {
/* 251 */     JLabel l = new JLabel(text);
/* 252 */     l.setBounds(x, y, w, h);
/* 253 */     l.setOpaque(true);
/* 254 */     jf.add(l);
/*     */   }
/*     */   
/*     */   public void addButton(JFrame jf, ActionListener actl, String t, int x, int y, int w, int h) {
/* 259 */     JButton b = new JButton(t);
/* 260 */     b.setBounds(x, y, w, h);
/* 261 */     b.setFocusable(false);
/* 262 */     b.addActionListener(actl);
/* 263 */     jf.add(b);
/*     */   }
/*     */   
/*     */   public void setFrameIconAbsoulute(JFrame jf, String iconPath) {
/* 267 */     Image icon = null;
/*     */     try {
/* 269 */       icon = ImageIO.read(new File(iconPath));
/* 270 */     } catch (IOException e) {
/* 271 */       e.printStackTrace();
/*     */     } 
/* 273 */     jf.setIconImage(icon);
/*     */   }
/*     */   
/*     */   public void centerFrame(JFrame jf) {
/* 277 */     jf.setLocationRelativeTo((Component)null);
/*     */   }
/*     */   
/*     */   public void addFrameImage(JFrame jf, BufferedImage image, int x, int y) {
/* 281 */     JLabel logoLabel = new JLabel();
/* 282 */     logoLabel.setIcon(new ImageIcon(image));
/* 283 */     logoLabel.setBounds(x, y, image.getWidth(), image.getHeight());
/* 284 */     jf.add(logoLabel);
/*     */   }
/*     */   
/*     */   public void systemExit() {
/* 288 */     System.exit(0);
/*     */   }
/*     */   
/*     */   public void println(String t) {
/* 292 */     System.out.println(t);
/*     */   }
/*     */   
/*     */   public void playSound(String path) {
/*     */     try {
/* 297 */       InputStream inputStream = new FileInputStream(path);
/* 298 */       AudioStream audioStream = new AudioStream(inputStream);
/* 299 */       AudioPlayer.player.start((InputStream)audioStream);
/* 300 */     } catch (Exception e) {
/* 301 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void encrypt(String key, File inputFile, File outputFile) throws Exception {
/* 307 */     doCrypto(1, key, inputFile, outputFile);
/*     */   }
/*     */   
/*     */   public void decrypt(String key, File inputFile, File outputFile) throws Exception {
/* 312 */     doCrypto(2, key, inputFile, outputFile);
/*     */   }
/*     */   
/*     */   private void doCrypto(int cipherMode, String key, File inputFile, File outputFile) throws Exception {
/*     */     try {
/* 318 */       Key secretKey = new SecretKeySpec(key.getBytes(), "AES");
/* 319 */       Cipher cipher = Cipher.getInstance("AES");
/* 320 */       cipher.init(cipherMode, secretKey);
/* 321 */       FileInputStream inputStream = new FileInputStream(inputFile);
/* 322 */       byte[] inputBytes = new byte[(int)inputFile.length()];
/* 323 */       inputStream.read(inputBytes);
/* 324 */       byte[] outputBytes = cipher.doFinal(inputBytes);
/* 325 */       FileOutputStream outputStream = new FileOutputStream(outputFile);
/* 326 */       outputStream.write(outputBytes);
/* 327 */       inputStream.close();
/* 328 */       outputStream.close();
/* 331 */     } catch (NoSuchPaddingException|java.security.NoSuchAlgorithmException|java.security.InvalidKeyException|javax.crypto.BadPaddingException|javax.crypto.IllegalBlockSizeException|IOException ex) {
/* 332 */       ex.printStackTrace();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.1.0_4.jar!\com\emgartley\stlib\STLib.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */