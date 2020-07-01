/*     */ package com.emgartley.beyondOrigins.main;
/*     */ 
/*     */ import com.emgartley.beyondOrigins.files.Logger;
/*     */ import com.emgartley.beyondOrigins.files.Save;
/*     */ import com.emgartley.beyondOrigins.main.buildings.BuildingRender;
/*     */ import com.emgartley.beyondOrigins.main.entities.Entity;
/*     */ import com.emgartley.beyondOrigins.main.entities.Player;
/*     */ import com.emgartley.beyondOrigins.main.gfx.ImageManager;
/*     */ import com.emgartley.beyondOrigins.main.inventory.Inventory;
/*     */ import com.emgartley.beyondOrigins.main.maps.GrassMap;
/*     */ import com.emgartley.beyondOrigins.main.menus.F3Menu;
/*     */ import com.emgartley.beyondOrigins.main.menus.MainMenu;
/*     */ import com.emgartley.beyondOrigins.main.menus.Overview;
/*     */ import com.emgartley.beyondOrigins.main.menus.PauseMenu;
/*     */ import com.emgartley.beyondOrigins.main.story.StoryText;
/*     */ import com.emgartley.beyondOrigins.main.threads.Init;
/*     */ import com.emgartley.beyondOrigins.main.threads.Noti;
/*     */ import com.emgartley.beyondOrigins.userInput.KeyManager;
/*     */ import com.emgartley.beyondOrigins.userInput.MouseManager;
/*     */ import com.emgartley.beyondOrigins.userInput.MouseMotion;
/*     */ import com.emgartley.stlib.STLib;
/*     */ import java.awt.Canvas;
/*     */ import java.awt.Color;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.Font;
/*     */ import java.awt.FontMetrics;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.event.KeyListener;
/*     */ import java.awt.event.MouseListener;
/*     */ import java.awt.event.MouseMotionListener;
/*     */ import java.awt.image.BufferStrategy;
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.io.File;
/*     */ import java.util.UUID;
/*     */ import javax.swing.JFrame;
/*     */ 
/*     */ public class Game extends Canvas implements Runnable {
/*     */   public static JFrame frame;
/*     */   
/*     */   private static final long serialVersionUID = 1L;
/*     */   
/*     */   public static final int HEIGHT = 573;
/*     */   
/*     */   public static final int WIDTH = 419;
/*     */   
/*     */   public static final int SCALE = 2;
/*     */   
/*     */   public static int width;
/*     */   
/*     */   public static int height;
/*     */   
/*     */   public static int time;
/*     */   
/*     */   public static boolean running = false;
/*     */   
/*     */   public static ImageManager im;
/*     */   
/*     */   private static FontMetrics fm;
/*     */   
/*     */   public static Graphics g;
/*     */   
/*     */   private static String uuid;
/*     */   
/*  49 */   private static String save1Key = "1O222274937592U3";
/*     */   
/*  50 */   private static String save2Key = "062948A75F720091";
/*     */   
/*  50 */   private static String save3Key = "832D409374923902";
/*     */   
/*  51 */   public static String loadingStatus = "string_loading_status_default_value";
/*     */   
/*     */   public Thread gameThread;
/*     */   
/*     */   public static Thread notiThread;
/*     */   
/*     */   public static Thread initThread;
/*     */   
/*     */   public static short frames;
/*     */   
/*     */   public static short currentFrames;
/*     */   
/*  61 */   public static short pMidX = 403;
/*     */   
/*  61 */   public static short pMidY = 270;
/*     */   
/*  64 */   public static String copyright = "©2014 Evan Gartley", version = "010B5";
/*     */   
/*  65 */   public static String title = "Beyond Origins 0.1.0 Build 5", townName = "Lunix";
/*     */   
/*  66 */   public static String mainDir = "C:\\Users\\" + 
/*  67 */     System.getProperty("user.name") + 
/*  68 */     "\\AppData\\Roaming\\Beyond Origins\\";
/*     */   
/*  69 */   public static String save1Path = String.valueOf(mainDir) + "saves\\profile1.xml";
/*     */   
/*  70 */   public static String save2Path = String.valueOf(mainDir) + "saves\\profile2.xml", save3Path = String.valueOf(mainDir) + 
/*  71 */     "saves\\profile3.xml";
/*     */   
/*  71 */   public static String dataPath = String.valueOf(mainDir) + "data.zan";
/*     */   
/*  72 */   public static String keysPath = String.valueOf(mainDir) + "keys.zan";
/*     */   
/*  75 */   public static Color buttonIdleColor = new Color(255, 255, 255);
/*     */   
/*  76 */   public static Color gameProgressColor = new Color(73, 73, 73);
/*     */   
/*  77 */   public static Color profileInfoColor = new Color(99, 99, 99), skyColor = new Color(86, 
/*  78 */       201, 255);
/*     */   
/*  78 */   public static Color buttonClickedColor = new Color(73, 73, 73);
/*     */   
/*  79 */   public static Color buttonSelectedColor = new Color(236, 210, 120);
/*     */   
/*  82 */   public static Font f3MenuFont = new Font("DejaVu Sans", 0, 12);
/*     */   
/*  83 */   public static Font buttonTextFont = new Font("MoolBoran", 0, 32);
/*     */   
/*  84 */   public static Font profileInfoFont = new Font("MoolBoran", 0, 23);
/*     */   
/*  85 */   public static Font profileNameFont = new Font("MoolBoran", 3, 23);
/*     */   
/*  86 */   public static Font areYouSureFont = new Font("MoolBoran", 1, 62);
/*     */   
/*  87 */   public static Font gameProgressFont = new Font("MoolBoran", 0, 60);
/*     */   
/*  88 */   public static Font pHUDBar = new Font("CenturyGothic", 0, 10);
/*     */   
/*  89 */   public static Font questTitleFont = new Font("DejaVu Sans", 1, 12);
/*     */   
/*  90 */   public static Font questDescFont = new Font("DejaVu Sans", 0, 12);
/*     */   
/*     */   public static boolean isInGame = false, saveRequested = false;
/*     */   
/*     */   public static boolean loadRequested = false, isOnMap = true, isLoading = false;
/*     */   
/*     */   public static boolean presenting = true, initing = true, overviewing = false;
/*     */   
/*     */   public static boolean autoSave = true;
/*     */   
/*     */   public static boolean dummy = false;
/*     */   
/*     */   public static boolean sound = true;
/*     */   
/*     */   public static BufferedImage playerSheet;
/*     */   
/*     */   public static BufferedImage terrain1Sheet;
/*     */   
/*     */   public static BufferedImage mainmenuSheet;
/*     */   
/*     */   public static BufferedImage inventorySheet;
/*     */   
/*     */   public static BufferedImage widgetSheet;
/*     */   
/*     */   public static BufferedImage entitySheet;
/*     */   
/*     */   public static BufferedImage logoImage;
/*     */   
/*     */   public static BufferedImage inside1Image;
/*     */   
/*     */   public static BufferedImage mapImage;
/*     */   
/*     */   public static BufferedImage creds;
/*     */   
/*     */   public static BufferedImage mapOverview;
/*     */   
/*     */   public static Logger logger;
/*     */   
/*     */   public static GrassMap grassm;
/*     */   
/*     */   public static MainMenu mainMenu;
/*     */   
/*     */   public static Inventory inv;
/*     */   
/*     */   public static PauseMenu pauseMenu;
/*     */   
/*     */   public static BuildingRender br;
/*     */   
/*     */   public static StoryText storyText;
/*     */   
/*     */   public static STLib st;
/*     */   
/*     */   public static void loadGfx() {
/* 118 */     Init.loadGfx();
/*     */   }
/*     */   
/*     */   public static void createFolder(String path) {
/* 122 */     if (!(new File(path)).exists()) {
/* 123 */       File folder = new File(path);
/* 124 */       folder.mkdir();
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void endClick() {
/* 129 */     MouseManager.mousePressed = false;
/*     */   }
/*     */   
/*     */   public static boolean mouseIsPressed() {
/* 133 */     return MouseManager.mousePressed;
/*     */   }
/*     */   
/*     */   public void run() {
/* 137 */     initing = true;
/* 138 */     addKeyListener((KeyListener)new KeyManager());
/* 139 */     addMouseListener((MouseListener)new MouseManager());
/* 140 */     addMouseMotionListener((MouseMotionListener)new MouseMotion());
/* 141 */     render();
/* 142 */     long lastTime = System.nanoTime();
/* 143 */     long timer = System.currentTimeMillis();
/* 144 */     double ns = 1.6666666666666666E7D;
/* 145 */     double delta = 0.0D;
/* 146 */     requestFocus();
/* 147 */     while (running) {
/* 148 */       long now = System.nanoTime();
/* 149 */       delta += (now - lastTime) / ns;
/* 150 */       lastTime = now;
/* 151 */       if (delta >= 1.0D) {
/* 152 */         tick();
/* 153 */         render();
/* 154 */         delta--;
/* 155 */         frames = (short)(frames + 1);
/* 156 */         if (System.currentTimeMillis() - timer > 1000L) {
/* 157 */           timer += 1000L;
/* 158 */           currentFrames = frames;
/* 159 */           frames = 0;
/*     */         } 
/*     */       } 
/*     */       try {
/* 163 */         Thread.sleep(1L);
/* 164 */       } catch (InterruptedException e) {
/* 165 */         e.printStackTrace();
/*     */       } 
/*     */     } 
/* 168 */     logger.log("Stopping the game");
/* 169 */     stop();
/*     */   }
/*     */   
/*     */   public synchronized void start() {
/* 173 */     if (running)
/*     */       return; 
/* 176 */     running = true;
/* 177 */     this.gameThread = new Thread(this);
/* 178 */     this.gameThread.setPriority(1);
/* 179 */     notiThread = new Thread((Runnable)new Noti("thread_noti"));
/* 180 */     notiThread.setPriority(1);
/* 181 */     initThread = new Thread((Runnable)new Init("thread_init"));
/* 182 */     initThread.setPriority(1);
/* 184 */     this.gameThread.start();
/*     */   }
/*     */   
/*     */   public synchronized void stop() {
/* 188 */     if (!running)
/*     */       return; 
/* 191 */     running = false;
/*     */     try {
/* 193 */       notiThread.join();
/* 194 */       this.gameThread.join();
/* 195 */     } catch (InterruptedException e) {
/* 196 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public synchronized void tick() {
/* 201 */     width = getWidth();
/* 202 */     height = getHeight();
/* 203 */     Noti.checkNotify();
/* 204 */     if (isInGame && !PauseMenu.isOpen && !presenting) {
/* 205 */       if (!storyText.requested && 
/* 206 */         !overviewing) {
/* 209 */         pMidX = (short)(width / 2 - 16);
/* 210 */         pMidY = (short)(height / 2 - 16);
/* 211 */         Save.tick();
/* 212 */         inv.tick();
/* 213 */         grassm.tick();
/* 214 */         Entity.player.tick();
/* 215 */         if (dummy)
/* 216 */           Entity.td.tick(); 
/*     */       } 
/* 220 */     } else if (!isInGame && !PauseMenu.isOpen && !presenting && !initing) {
/* 221 */       mainMenu.tick();
/* 222 */     } else if (!isInGame || !PauseMenu.isOpen || presenting) {
/* 224 */       if (presenting) {
/* 225 */         time++;
/* 226 */         if (time >= 180) {
/* 227 */           time = 0;
/* 228 */           presenting = false;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public synchronized void render() {
/* 235 */     BufferStrategy bs = getBufferStrategy();
/* 236 */     if (bs == null) {
/* 237 */       createBufferStrategy(3);
/*     */       return;
/*     */     } 
/* 240 */     g = bs.getDrawGraphics();
/* 241 */     g.fillRect(0, 0, getWidth(), getHeight());
/* 242 */     g.setColor(Color.white);
/* 243 */     st.enableAntiAliasing(g);
/* 245 */     if (!initing) {
/* 246 */       if (isInGame && !PauseMenu.isOpen) {
/* 247 */         inGameRender(g);
/* 248 */       } else if (!isInGame && !PauseMenu.isOpen) {
/* 249 */         mainMenu.render(g);
/* 250 */       } else if (isInGame && PauseMenu.isOpen) {
/* 251 */         pauseMenu.renderMain(g);
/*     */       } 
/* 253 */       Noti.render(g);
/* 254 */       if (F3Menu.f3menu)
/* 255 */         F3Menu.render(g); 
/* 256 */     } else if (initing) {
/* 257 */       g.setColor(Color.black);
/* 258 */       g.fillRect(0, 0, getWidth(), getHeight());
/* 259 */       g.setFont(buttonTextFont);
/* 260 */       fm = g.getFontMetrics(buttonTextFont);
/* 261 */       g.setColor(Color.white);
/* 262 */       g.drawString(
/* 263 */           "egartley proudly presents", 
/* 264 */           getWidth() / 2 - 
/* 265 */           fm.stringWidth("egartley proudly presents") / 2, 
/* 266 */           getHeight() / 2 - 25);
/* 267 */       g.drawString(loadingStatus, 
/* 268 */           getWidth() / 2 - fm.stringWidth(loadingStatus) / 2, 
/* 269 */           getHeight() / 2 + 25);
/*     */     } 
/* 271 */     g.dispose();
/* 272 */     bs.show();
/*     */   }
/*     */   
/*     */   private void inGameRender(Graphics g) {
/* 277 */     if (storyText.requested) {
/*     */       try {
/* 279 */         storyText.render(g);
/* 280 */       } catch (InterruptedException e) {
/* 281 */         e.printStackTrace();
/*     */       } 
/* 284 */     } else if (overviewing) {
/* 285 */       Overview.render(g);
/*     */     } else {
/* 287 */       grassm.render(g);
/* 288 */       if (dummy)
/* 289 */         Entity.td.render(g); 
/* 291 */       Entity.player.render(g);
/* 292 */       br.render(g);
/* 293 */       Entity.player.drawPlayerHUD(g);
/* 294 */       inv.render(g);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void main(String[] args) throws Exception {
/* 300 */     Game game = new Game();
/* 301 */     st = new STLib();
/* 302 */     game.setPreferredSize(new Dimension(838, 573));
/* 303 */     game.setMaximumSize(new Dimension(838, 573));
/* 304 */     game.setMinimumSize(new Dimension(838, 573));
/* 305 */     frame = new JFrame(title);
/* 306 */     frame.setSize(838, 573);
/* 307 */     frame.setDefaultCloseOperation(3);
/* 308 */     frame.setResizable(false);
/* 309 */     frame.add(game);
/* 310 */     st.centerFrame(frame);
/* 311 */     st.setFrameIconAbsoulute(frame, String.valueOf(mainDir) + "assets\\icon32.png");
/* 312 */     frame.setVisible(true);
/* 313 */     uuid = UUID.randomUUID().toString();
/* 314 */     game.start();
/*     */   }
/*     */   
/*     */   public static String getUUID() {
/* 319 */     return uuid;
/*     */   }
/*     */   
/*     */   public static int getProgress() {
/* 323 */     if (mainMenu.currentProfile == 1)
/* 324 */       return Profile1.progress; 
/* 325 */     if (mainMenu.currentProfile == 2)
/* 326 */       return Profile2.progress; 
/* 327 */     if (mainMenu.currentProfile == 3)
/* 328 */       return Profile3.progress; 
/* 330 */     return 0;
/*     */   }
/*     */   
/*     */   public static void setProgress(int newProgress) {
/* 336 */     if (mainMenu.currentProfile == 1) {
/* 337 */       Profile1.progress = newProgress;
/* 338 */     } else if (mainMenu.currentProfile == 2) {
/* 339 */       Profile2.progress = newProgress;
/* 340 */     } else if (mainMenu.currentProfile == 3) {
/* 341 */       Profile3.progress = newProgress;
/*     */     } 
/*     */   }
/*     */   
/*     */   public static String getSaveKey(int n) {
/* 347 */     if (n == 1)
/* 348 */       return save1Key; 
/* 349 */     if (n == 2)
/* 350 */       return save2Key; 
/* 351 */     if (n == 3)
/* 352 */       return save3Key; 
/* 353 */     if (n == 0)
/* 354 */       return ""; 
/* 356 */     return null;
/*     */   }
/*     */   
/*     */   public static Player getPlayer() {
/* 360 */     return Entity.player;
/*     */   }
/*     */   
/*     */   public static MainMenu getMainMenu() {
/* 364 */     return mainMenu;
/*     */   }
/*     */   
/*     */   public static GrassMap getMap() {
/* 368 */     return grassm;
/*     */   }
/*     */   
/*     */   public static StoryText getStoryText() {
/* 372 */     return storyText;
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.1.0_5.jar!\com\emgartley\beyondOrigins\main\Game.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */