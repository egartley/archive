/*     */ package com.emgartley.stlib;
/*     */ 
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import javax.imageio.ImageIO;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.SwingUtilities;
/*     */ import javax.swing.UIManager;
/*     */ import javax.swing.UnsupportedLookAndFeelException;
/*     */ 
/*     */ public class STLib {
/*  15 */   String v = "0.5.2";
/*     */   
/*     */   public BufferedImage loadImage(String path) {
/*     */     try {
/*  37 */       return ImageIO.read(getClass().getResource(path));
/*  38 */     } catch (IOException e) {
/*  39 */       e.printStackTrace();
/*  41 */       System.out
/*  42 */         .println("ERROR: Unable to read image from '" + 
/*  43 */           path + 
/*  44 */           "'!\nPlease make sure the filename is correct and\nthe file extension is included.");
/*  45 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public BufferedImage getCropped(BufferedImage sheet, int x, int y, int w, int h) {
/*  54 */     if (sheet != null)
/*  55 */       return sheet.getSubimage(x, y, w, h); 
/*  57 */     System.out
/*  58 */       .println("ERROR: Provided BufferedImage is null!\nPlease make sure to load it by using loadImage(path)!");
/*  59 */     return null;
/*     */   }
/*     */   
/*     */   public void createFile(String path) {
/*     */     try {
/*  68 */       File file = new File(path);
/*  69 */       if (!file.createNewFile())
/*  71 */         System.out.println("File at: '" + path + "' already exists!"); 
/*  73 */     } catch (IOException e) {
/*  74 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void deleteFile(File file) {
/*  83 */     file.delete();
/*     */   }
/*     */   
/*     */   public void deleteFile(String path) {
/*  91 */     File file = new File(path);
/*  92 */     file.delete();
/*     */   }
/*     */   
/*     */   public void setSystemLookAndFeel(JFrame frame) {
/*     */     try {
/* 101 */       UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
/* 102 */     } catch (ClassNotFoundException e) {
/* 103 */       e.printStackTrace();
/* 104 */     } catch (InstantiationException e) {
/* 105 */       e.printStackTrace();
/* 106 */     } catch (IllegalAccessException e) {
/* 107 */       e.printStackTrace();
/* 108 */     } catch (UnsupportedLookAndFeelException e) {
/* 109 */       e.printStackTrace();
/*     */     } 
/* 112 */     SwingUtilities.updateComponentTreeUI(frame);
/*     */   }
/*     */   
/*     */   public void launchURL(String url) {
/* 123 */     String cmd = "cmd.exe /c start " + url;
/*     */     try {
/* 125 */       Runtime.getRuntime().exec(cmd);
/* 126 */     } catch (IOException e) {
/* 127 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.6_4.jar!\com\emgartley\stlib\STLib.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */