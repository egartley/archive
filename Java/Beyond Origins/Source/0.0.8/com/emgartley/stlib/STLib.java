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
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
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
/*     */   public boolean imageIsVisible(int renderx, int rendery, int windowWidth, int windowHeight, int imageWidth, int imageHeight) {
/*  38 */     if (renderx >= -imageWidth + -1 && rendery >= -imageHeight + -1 && 
/*  39 */       renderx <= windowWidth && rendery <= windowHeight)
/*  40 */       return true; 
/*  42 */     return false;
/*     */   }
/*     */   
/*     */   public boolean isTransparent(int x, int y, BufferedImage i) {
/*  46 */     int pixel = i.getRGB(x, y);
/*  47 */     if (pixel >> 24 == 0)
/*  48 */       return true; 
/*  50 */     return false;
/*     */   }
/*     */   
/*     */   public boolean isInRange(int radius, int var1, int var2) {
/*  54 */     if (Math.sqrt((var1 * var1 + var2 * var2)) <= radius)
/*  55 */       return true; 
/*  57 */     return false;
/*     */   }
/*     */   
/*     */   public BufferedImage loadImage(String path) {
/*     */     try {
/*  69 */       return ImageIO.read(getClass().getResource(path));
/*  70 */     } catch (IOException e) {
/*  71 */       e.printStackTrace();
/*  73 */       System.out
/*  74 */         .println("STLib | ERROR: Unable to read image from '" + 
/*     */           
/*  76 */           path + 
/*  77 */           "'!\nPlease make sure the filename is correct and\nthe file extension is included.");
/*  78 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public BufferedImage getCropped(BufferedImage sheet, int x, int y, int w, int h) {
/*  87 */     if (sheet != null)
/*  88 */       return sheet.getSubimage(x, y, w, h); 
/*  90 */     System.out
/*  91 */       .println("STLib | ERROR: Provided BufferedImage is null!\nPlease make sure to load it by using loadImage(path)!");
/*  93 */     return null;
/*     */   }
/*     */   
/*     */   public String toString(int i) {
/*  97 */     return String.valueOf(i);
/*     */   }
/*     */   
/*     */   public String toString(double i) {
/* 101 */     return String.valueOf(i);
/*     */   }
/*     */   
/*     */   public String toString(short i) {
/* 105 */     return String.valueOf(i);
/*     */   }
/*     */   
/*     */   public String toString(float i) {
/* 109 */     return String.valueOf(i);
/*     */   }
/*     */   
/*     */   public String toString(byte i) {
/* 113 */     return String.valueOf(i);
/*     */   }
/*     */   
/*     */   public String toString(long i) {
/* 117 */     return String.valueOf(i);
/*     */   }
/*     */   
/*     */   public String toString(char i) {
/* 121 */     return String.valueOf(i);
/*     */   }
/*     */   
/*     */   public String toString(boolean i) {
/* 125 */     return String.valueOf(i);
/*     */   }
/*     */   
/*     */   public String removeCharAt(String s, int pos) {
/* 129 */     return String.valueOf(s.substring(0, pos)) + s.substring(pos + 1);
/*     */   }
/*     */   
/*     */   public void createFile(String path) {
/*     */     try {
/* 139 */       File file = new File(path);
/* 140 */       if (!file.createNewFile())
/* 142 */         System.out.println("STLib | File at: '" + path + 
/* 143 */             "' already exists!"); 
/* 145 */     } catch (IOException e) {
/* 146 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void deleteFile(File file) {
/* 155 */     file.delete();
/*     */   }
/*     */   
/*     */   public void deleteFile(String path) {
/* 163 */     File file = new File(path);
/* 164 */     file.delete();
/*     */   }
/*     */   
/*     */   public void setSystemLookAndFeel(JFrame frame) {
/*     */     try {
/* 173 */       UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
/* 174 */     } catch (ClassNotFoundException e) {
/* 175 */       e.printStackTrace();
/* 176 */     } catch (InstantiationException e) {
/* 177 */       e.printStackTrace();
/* 178 */     } catch (IllegalAccessException e) {
/* 179 */       e.printStackTrace();
/* 180 */     } catch (UnsupportedLookAndFeelException e) {
/* 181 */       e.printStackTrace();
/*     */     } 
/* 184 */     SwingUtilities.updateComponentTreeUI(frame);
/*     */   }
/*     */   
/*     */   public void launchURL(String url) {
/* 195 */     String cmd = "cmd.exe /c start " + url;
/*     */     try {
/* 197 */       Runtime.getRuntime().exec(cmd);
/* 198 */     } catch (IOException e) {
/* 199 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void animateEntity(Graphics g, int x, int y, BufferedImage[] frame, short count) {
/* 205 */     for (int i = 1; i < frame.length; i++) {
/* 206 */       int c = i * 10 + 1;
/* 207 */       int cc = c - 9;
/* 208 */       if (count >= cc && count <= c)
/* 209 */         g.drawImage(frame[i], x, y, null); 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void enableAntiAliasing(Graphics g) {
/* 215 */     Graphics2D g2d = (Graphics2D)g;
/* 216 */     g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, 
/* 217 */         RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
/*     */   }
/*     */   
/*     */   public void createFolder(String path) {
/* 221 */     if (!(new File(path)).exists())
/* 222 */       boolean bool = (new File(path)).mkdir(); 
/*     */   }
/*     */   
/*     */   public void addText(JFrame jf, Font f, String text, int x, int y, int w, int h) {
/* 230 */     JLabel l = new JLabel(text);
/* 231 */     l.setBounds(x, y, w, h);
/* 232 */     l.setFont(f);
/* 233 */     l.setOpaque(true);
/* 234 */     jf.add(l);
/*     */   }
/*     */   
/*     */   public void addText(JFrame jf, String text, int x, int y, int w, int h) {
/* 238 */     JLabel l = new JLabel(text);
/* 239 */     l.setBounds(x, y, w, h);
/* 240 */     l.setOpaque(true);
/* 241 */     jf.add(l);
/*     */   }
/*     */   
/*     */   public void addButton(JFrame jf, ActionListener actl, String t, int x, int y, int w, int h) {
/* 246 */     JButton b = new JButton(t);
/* 247 */     b.setBounds(x, y, w, h);
/* 248 */     b.setFocusable(false);
/* 249 */     b.addActionListener(actl);
/* 250 */     jf.add(b);
/*     */   }
/*     */   
/*     */   public void setFrameIcon(JFrame jf, String iconPath) {
/* 254 */     jf.setIconImage(Toolkit.getDefaultToolkit().getImage(
/* 255 */           JFrame.class.getResource(iconPath)));
/*     */   }
/*     */   
/*     */   public void centerFrame(JFrame jf) {
/* 259 */     jf.setLocationRelativeTo((Component)null);
/*     */   }
/*     */   
/*     */   public void addFrameImage(JFrame jf, BufferedImage image, int x, int y) {
/* 263 */     JLabel logoLabel = new JLabel();
/* 264 */     logoLabel.setIcon(new ImageIcon(image));
/* 265 */     logoLabel.setBounds(x, y, image.getWidth(), image.getHeight());
/* 266 */     jf.add(logoLabel);
/*     */   }
/*     */   
/*     */   public void systemExit() {
/* 270 */     System.exit(0);
/*     */   }
/*     */   
/*     */   public void println(String t) {
/* 274 */     System.out.println(t);
/*     */   }
/*     */   
/*     */   public void playSound(String path) {
/*     */     try {
/* 279 */       InputStream inputStream = getClass().getResourceAsStream(path);
/* 280 */       AudioStream audioStream = new AudioStream(inputStream);
/* 281 */       AudioPlayer.player.start((InputStream)audioStream);
/* 282 */     } catch (Exception e) {
/* 283 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.8_2.jar!\com\emgartley\stlib\STLib.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */