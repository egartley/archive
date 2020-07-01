/*     */ package com.emgartley.stlib;
/*     */ 
/*     */ import java.awt.Component;
/*     */ import java.awt.Font;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Graphics2D;
/*     */ import java.awt.RenderingHints;
/*     */ import java.awt.Toolkit;
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
/*  45 */     if (renderx >= -imageWidth + -1 && rendery >= -imageHeight + -1 && 
/*  46 */       renderx <= windowWidth && rendery <= windowHeight)
/*  47 */       return true; 
/*  49 */     return false;
/*     */   }
/*     */   
/*     */   public boolean isTransparent(int x, int y, BufferedImage i) {
/*  53 */     int pixel = i.getRGB(x, y);
/*  54 */     if (pixel >> 24 == 0)
/*  55 */       return true; 
/*  57 */     return false;
/*     */   }
/*     */   
/*     */   public boolean isInRange(int radius, int var1, int var2) {
/*  61 */     if (Math.sqrt((var1 * var1 + var2 * var2)) <= radius)
/*  62 */       return true; 
/*  64 */     return false;
/*     */   }
/*     */   
/*     */   public BufferedImage loadImage(String path) {
/*     */     try {
/*  76 */       return ImageIO.read(getClass().getResource(path));
/*  77 */     } catch (IOException e) {
/*  78 */       e.printStackTrace();
/*  80 */       System.out
/*  81 */         .println("STLib | ERROR: Unable to read image from '" + 
/*     */           
/*  83 */           path + 
/*  84 */           "'!\nPlease make sure the filename is correct and\nthe file extension is included.");
/*  85 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public BufferedImage getCropped(BufferedImage sheet, int x, int y, int w, int h) {
/*  94 */     if (sheet != null)
/*  95 */       return sheet.getSubimage(x, y, w, h); 
/*  97 */     System.out
/*  98 */       .println("STLib | ERROR: Provided BufferedImage is null!\nPlease make sure to load it by using loadImage(path)!");
/* 100 */     return null;
/*     */   }
/*     */   
/*     */   public String toString(int i) {
/* 104 */     return String.valueOf(i);
/*     */   }
/*     */   
/*     */   public String toString(double i) {
/* 108 */     return String.valueOf(i);
/*     */   }
/*     */   
/*     */   public String toString(short i) {
/* 112 */     return String.valueOf(i);
/*     */   }
/*     */   
/*     */   public String toString(float i) {
/* 116 */     return String.valueOf(i);
/*     */   }
/*     */   
/*     */   public String toString(byte i) {
/* 120 */     return String.valueOf(i);
/*     */   }
/*     */   
/*     */   public String toString(long i) {
/* 124 */     return String.valueOf(i);
/*     */   }
/*     */   
/*     */   public String toString(char i) {
/* 128 */     return String.valueOf(i);
/*     */   }
/*     */   
/*     */   public String toString(boolean i) {
/* 132 */     return String.valueOf(i);
/*     */   }
/*     */   
/*     */   public String removeCharAt(String s, int pos) {
/* 136 */     return String.valueOf(s.substring(0, pos)) + s.substring(pos + 1);
/*     */   }
/*     */   
/*     */   public void createFile(String path) {
/*     */     try {
/* 146 */       File file = new File(path);
/* 147 */       file.createNewFile();
/* 148 */     } catch (IOException e) {
/* 149 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void deleteFile(File file) {
/* 158 */     file.delete();
/*     */   }
/*     */   
/*     */   public void deleteFile(String path) {
/* 166 */     File file = new File(path);
/* 167 */     file.delete();
/*     */   }
/*     */   
/*     */   public void setSystemLookAndFeel(JFrame frame) {
/*     */     try {
/* 176 */       UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
/* 177 */     } catch (ClassNotFoundException e) {
/* 178 */       e.printStackTrace();
/* 179 */     } catch (InstantiationException e) {
/* 180 */       e.printStackTrace();
/* 181 */     } catch (IllegalAccessException e) {
/* 182 */       e.printStackTrace();
/* 183 */     } catch (UnsupportedLookAndFeelException e) {
/* 184 */       e.printStackTrace();
/*     */     } 
/* 187 */     SwingUtilities.updateComponentTreeUI(frame);
/*     */   }
/*     */   
/*     */   public void launchURL(String url) {
/* 198 */     String cmd = "cmd.exe /c start " + url;
/*     */     try {
/* 200 */       Runtime.getRuntime().exec(cmd);
/* 201 */     } catch (IOException e) {
/* 202 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void animateEntity(Graphics g, int x, int y, BufferedImage[] frame, short count) {
/* 208 */     for (int i = 1; i < frame.length; i++) {
/* 209 */       int c = i * 10 + 1;
/* 210 */       int cc = c - 9;
/* 211 */       if (count >= cc && count <= c)
/* 212 */         g.drawImage(frame[i], x, y, null); 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void enableAntiAliasing(Graphics g) {
/* 218 */     Graphics2D g2d = (Graphics2D)g;
/* 219 */     g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, 
/* 220 */         RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
/*     */   }
/*     */   
/*     */   public void createFolder(String path) {
/* 224 */     if (!(new File(path)).exists())
/* 225 */       boolean bool = (new File(path)).mkdir(); 
/*     */   }
/*     */   
/*     */   public void addText(JFrame jf, Font f, String text, int x, int y, int w, int h) {
/* 233 */     JLabel l = new JLabel(text);
/* 234 */     l.setBounds(x, y, w, h);
/* 235 */     l.setFont(f);
/* 236 */     l.setOpaque(true);
/* 237 */     jf.add(l);
/*     */   }
/*     */   
/*     */   public void addText(JFrame jf, String text, int x, int y, int w, int h) {
/* 241 */     JLabel l = new JLabel(text);
/* 242 */     l.setBounds(x, y, w, h);
/* 243 */     l.setOpaque(true);
/* 244 */     jf.add(l);
/*     */   }
/*     */   
/*     */   public void addButton(JFrame jf, ActionListener actl, String t, int x, int y, int w, int h) {
/* 249 */     JButton b = new JButton(t);
/* 250 */     b.setBounds(x, y, w, h);
/* 251 */     b.setFocusable(false);
/* 252 */     b.addActionListener(actl);
/* 253 */     jf.add(b);
/*     */   }
/*     */   
/*     */   public void setFrameIcon(JFrame jf, String iconPath) {
/* 257 */     jf.setIconImage(Toolkit.getDefaultToolkit().getImage(
/* 258 */           JFrame.class.getResource(iconPath)));
/*     */   }
/*     */   
/*     */   public void centerFrame(JFrame jf) {
/* 262 */     jf.setLocationRelativeTo((Component)null);
/*     */   }
/*     */   
/*     */   public void addFrameImage(JFrame jf, BufferedImage image, int x, int y) {
/* 266 */     JLabel logoLabel = new JLabel();
/* 267 */     logoLabel.setIcon(new ImageIcon(image));
/* 268 */     logoLabel.setBounds(x, y, image.getWidth(), image.getHeight());
/* 269 */     jf.add(logoLabel);
/*     */   }
/*     */   
/*     */   public void systemExit() {
/* 273 */     System.exit(0);
/*     */   }
/*     */   
/*     */   public void println(String t) {
/* 277 */     System.out.println(t);
/*     */   }
/*     */   
/*     */   public void playSound(String path) {
/*     */     try {
/* 282 */       InputStream inputStream = getClass().getResourceAsStream(path);
/* 283 */       AudioStream audioStream = new AudioStream(inputStream);
/* 284 */       AudioPlayer.player.start((InputStream)audioStream);
/* 285 */     } catch (Exception e) {
/* 286 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void encrypt(String key, File inputFile, File outputFile) throws Exception {
/* 292 */     doCrypto(1, key, inputFile, outputFile);
/*     */   }
/*     */   
/*     */   public void decrypt(String key, File inputFile, File outputFile) throws Exception {
/* 297 */     doCrypto(2, key, inputFile, outputFile);
/*     */   }
/*     */   
/*     */   private void doCrypto(int cipherMode, String key, File inputFile, File outputFile) throws Exception {
/*     */     try {
/* 303 */       Key secretKey = new SecretKeySpec(key.getBytes(), "AES");
/* 304 */       Cipher cipher = Cipher.getInstance("AES");
/* 305 */       cipher.init(cipherMode, secretKey);
/* 306 */       FileInputStream inputStream = new FileInputStream(inputFile);
/* 307 */       byte[] inputBytes = new byte[(int)inputFile.length()];
/* 308 */       inputStream.read(inputBytes);
/* 309 */       byte[] outputBytes = cipher.doFinal(inputBytes);
/* 310 */       FileOutputStream outputStream = new FileOutputStream(outputFile);
/* 311 */       outputStream.write(outputBytes);
/* 312 */       inputStream.close();
/* 313 */       outputStream.close();
/* 316 */     } catch (NoSuchPaddingException|java.security.NoSuchAlgorithmException|java.security.InvalidKeyException|javax.crypto.BadPaddingException|javax.crypto.IllegalBlockSizeException|IOException ex) {
/* 317 */       ex.printStackTrace();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\egart\Documents\GitHub\archive\Java\Beyond Origins Launcher\Builds\Launcher_v1.4.jar!\com\emgartley\stlib\STLib.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */