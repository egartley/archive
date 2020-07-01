/*     */ package com.emgartley.beyondOrigins.main;
/*     */ 
/*     */ import com.emgartley.beyondOrigins.files.Logger;
/*     */ import com.emgartley.beyondOrigins.files.Save;
/*     */ import com.emgartley.beyondOrigins.main.buildings.BuildingRender;
/*     */ import com.emgartley.beyondOrigins.main.buildings.Shop;
/*     */ import com.emgartley.beyondOrigins.main.entities.Entity;
/*     */ import com.emgartley.beyondOrigins.main.entities.Player;
/*     */ import com.emgartley.beyondOrigins.main.gfx.ImageManager;
/*     */ import com.emgartley.beyondOrigins.main.inventory.Inventory;
/*     */ import com.emgartley.beyondOrigins.main.maps.GrassMap;
/*     */ import com.emgartley.beyondOrigins.main.menus.F3Menu;
/*     */ import com.emgartley.beyondOrigins.main.menus.MainMenu;
/*     */ import com.emgartley.beyondOrigins.main.menus.PauseMenu;
/*     */ import com.emgartley.beyondOrigins.main.story.StoryText;
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
/*     */ import java.io.IOException;
/*     */ import java.util.UUID;
/*     */ import javax.imageio.ImageIO;
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
/*  36 */   private static String save1Key = "1O222274937592U3";
/*     */   
/*  37 */   private static String save2Key = "062948A75F720091";
/*     */   
/*  37 */   private static String save3Key = "832D409374923902";
/*     */   
/*     */   public Thread gameThread;
/*     */   
/*     */   public static Thread notiThread;
/*     */   
/*     */   public static short frames;
/*     */   
/*     */   public static short currentFrames;
/*     */   
/*  47 */   public static short playerSpawnX = 403;
/*     */   
/*  48 */   public static short playerSpawnY = 270;
/*     */   
/*  51 */   public static String copyright = "©2014 Evan Gartley", version = "010B1";
/*     */   
/*  52 */   public static String title = "Beyond Origins 0.1.0 Build 1", townName = "Lunix";
/*     */   
/*  53 */   public static String mainDir = "C:\\Users\\" + 
/*  54 */     System.getProperty("user.name") + 
/*  55 */     "\\AppData\\Roaming\\Beyond Origins\\";
/*     */   
/*  56 */   public static String save1Path = String.valueOf(mainDir) + "saves\\save1.zan";
/*     */   
/*  57 */   public static String save2Path = String.valueOf(mainDir) + "saves\\save2.zan", save3Path = String.valueOf(mainDir) + 
/*  58 */     "saves\\save3.zan";
/*     */   
/*  58 */   public static String dataPath = String.valueOf(mainDir) + "data.zan";
/*     */   
/*  59 */   public static String keysPath = String.valueOf(mainDir) + "keys.zan";
/*     */   
/*  62 */   public static Color buttonIdleColor = new Color(255, 255, 255);
/*     */   
/*  63 */   public static Color gameProgressColor = new Color(73, 73, 73);
/*     */   
/*  64 */   public static Color profileInfoColor = new Color(99, 99, 99), skyColor = new Color(86, 
/*  65 */       201, 255);
/*     */   
/*  65 */   public static Color buttonClickedColor = new Color(73, 73, 73);
/*     */   
/*  66 */   public static Color buttonSelectedColor = new Color(236, 210, 120);
/*     */   
/*  69 */   public static Font f3MenuFont = new Font("DejaVu Sans", 0, 12);
/*     */   
/*  70 */   public static Font buttonTextFont = new Font("MoolBoran", 0, 32);
/*     */   
/*  71 */   public static Font profileInfoFont = new Font("MoolBoran", 0, 23);
/*     */   
/*  72 */   public static Font profileNameFont = new Font("MoolBoran", 3, 23);
/*     */   
/*  73 */   public static Font areYouSureFont = new Font("MoolBoran", 1, 62);
/*     */   
/*  74 */   public static Font gameProgressFont = new Font("MoolBoran", 0, 60);
/*     */   
/*  75 */   public static Font playerHUDFont = new Font("CenturyGothic", 0, 12);
/*     */   
/*  76 */   public static Font pHUDBar = new Font("CenturyGothic", 0, 10);
/*     */   
/*  77 */   public static Font questTitleFont = new Font("DejaVu Sans", 1, 12);
/*     */   
/*  78 */   public static Font questDescFont = new Font("DejaVu Sans", 0, 12);
/*     */   
/*     */   public static boolean isInGame = false, saveRequested = false;
/*     */   
/*     */   public static boolean loadRequested = false, isOnMap = true, isLoading = false;
/*     */   
/*     */   public static boolean presenting = true, initing = true;
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
/*     */   public static BufferedImage creds;
/*     */   
/*     */   public static Logger logger;
/*     */   
/*     */   private static GrassMap grassm;
/*     */   
/*     */   private static MainMenu mainMenu;
/*     */   
/*     */   private static Inventory inv;
/*     */   
/*     */   private static PauseMenu pauseMenu;
/*     */   
/*     */   private static BuildingRender br;
/*     */   
/*     */   private static StoryText storyText;
/*     */   
/*     */   public static STLib st;
/*     */   
/*     */   public void init() {
/* 105 */     initing = true;
/* 106 */     logger = new Logger();
/* 107 */     logger.log("Game started");
/* 108 */     loadGfx();
/* 109 */     mainMenu = new MainMenu();
/* 110 */     pauseMenu = new PauseMenu();
/* 111 */     grassm = new GrassMap();
/* 112 */     Entity.init();
/* 113 */     inv = new Inventory();
/* 114 */     br = new BuildingRender();
/* 115 */     storyText = new StoryText();
/* 116 */     BuildingRender.init();
/* 117 */     Shop.init();
/* 118 */     addKeyListener((KeyListener)new KeyManager());
/* 119 */     addMouseListener((MouseListener)new MouseManager());
/* 120 */     addMouseMotionListener((MouseMotionListener)new MouseMotion());
/* 121 */     initing = false;
/*     */   }
/*     */   
/*     */   public static void loadGfx() {
/* 125 */     playerSheet = loadImage(String.valueOf(mainDir) + "assets\\player.png");
/* 126 */     terrain1Sheet = loadImage(String.valueOf(mainDir) + "assets\\terrain1.png");
/* 127 */     mainmenuSheet = loadImage(String.valueOf(mainDir) + "assets\\mainmenu.png");
/* 128 */     inventorySheet = loadImage(String.valueOf(mainDir) + "assets\\inventory.png");
/* 129 */     widgetSheet = loadImage(String.valueOf(mainDir) + "assets\\widgets1.png");
/* 130 */     entitySheet = loadImage(String.valueOf(mainDir) + "assets\\entities1.png");
/* 131 */     inside1Image = loadImage(String.valueOf(mainDir) + "assets\\inside1.png");
/* 132 */     logoImage = loadImage(String.valueOf(mainDir) + "assets\\logo.png");
/* 133 */     creds = loadImage(String.valueOf(mainDir) + "assets\\creds.png");
/* 134 */     im = new ImageManager();
/* 135 */     logger.log("Loaded graphics");
/*     */   }
/*     */   
/*     */   private static BufferedImage loadImage(String path) {
/*     */     try {
/* 140 */       BufferedImage reImage = ImageIO.read(new File(path));
/* 141 */       return reImage;
/* 142 */     } catch (IOException e) {
/* 143 */       e.printStackTrace();
/* 145 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void createFolder(String path) {
/* 149 */     if (!(new File(path)).exists()) {
/* 150 */       File folder = new File(path);
/* 151 */       folder.mkdir();
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void endClick() {
/* 156 */     MouseManager.mousePressed = false;
/*     */   }
/*     */   
/*     */   public static boolean mouseIsPressed() {
/* 160 */     return MouseManager.mousePressed;
/*     */   }
/*     */   
/*     */   public void run() {
/* 164 */     render();
/* 165 */     long lastTime = System.nanoTime();
/* 166 */     long timer = System.currentTimeMillis();
/* 167 */     double ns = 1.6666666666666666E7D;
/* 168 */     double delta = 0.0D;
/* 169 */     requestFocus();
/* 170 */     while (running) {
/* 171 */       long now = System.nanoTime();
/* 172 */       delta += (now - lastTime) / ns;
/* 173 */       lastTime = now;
/* 174 */       if (delta >= 1.0D) {
/* 175 */         tick();
/* 176 */         render();
/* 177 */         delta--;
/* 178 */         frames = (short)(frames + 1);
/* 179 */         if (System.currentTimeMillis() - timer > 1000L) {
/* 180 */           timer += 1000L;
/* 181 */           currentFrames = frames;
/* 182 */           frames = 0;
/*     */         } 
/*     */       } 
/*     */       try {
/* 186 */         Thread.sleep(1L);
/* 187 */       } catch (InterruptedException e) {
/* 188 */         e.printStackTrace();
/*     */       } 
/*     */     } 
/* 191 */     logger.log("Stopping the game");
/* 192 */     stop();
/*     */   }
/*     */   
/*     */   public synchronized void start() {
/* 196 */     if (running)
/*     */       return; 
/* 199 */     running = true;
/* 200 */     this.gameThread = new Thread(this);
/* 201 */     this.gameThread.setPriority(1);
/* 202 */     notiThread = new Thread((Runnable)new Noti("noti_thread"));
/* 203 */     notiThread.setPriority(1);
/* 205 */     this.gameThread.start();
/*     */   }
/*     */   
/*     */   public synchronized void stop() {
/* 210 */     if (!running)
/*     */       return; 
/* 213 */     running = false;
/*     */     try {
/* 215 */       notiThread.join();
/* 216 */       this.gameThread.join();
/* 217 */     } catch (InterruptedException e) {
/* 218 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public synchronized void tick() {
/* 223 */     width = getWidth();
/* 224 */     height = getHeight();
/* 225 */     Noti.checkNotify();
/* 226 */     if (isInGame && !PauseMenu.isOpen && !presenting) {
/* 227 */       if (!storyText.requested) {
/* 228 */         playerSpawnX = (short)(width / 2 - 16);
/* 229 */         playerSpawnY = (short)(height / 2 - 16);
/* 230 */         Save.tick();
/* 231 */         inv.tick();
/* 232 */         grassm.tick();
/* 233 */         Entity.player.tick();
/* 234 */         if (dummy)
/* 235 */           Entity.td.tick(); 
/*     */       } 
/* 238 */     } else if (!isInGame && !PauseMenu.isOpen && !presenting) {
/* 239 */       mainMenu.tick();
/* 240 */     } else if (!isInGame || !PauseMenu.isOpen || presenting) {
/* 242 */       if (presenting) {
/* 243 */         time++;
/* 244 */         if (time >= 180) {
/* 245 */           time = 0;
/* 246 */           presenting = false;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public synchronized void render() {
/* 252 */     BufferStrategy bs = getBufferStrategy();
/* 253 */     if (bs == null) {
/* 254 */       createBufferStrategy(3);
/*     */       return;
/*     */     } 
/* 257 */     g = bs.getDrawGraphics();
/* 258 */     g.fillRect(0, 0, getWidth(), getHeight());
/* 259 */     g.setColor(Color.white);
/* 260 */     st.enableAntiAliasing(g);
/* 262 */     if (!initing) {
/* 263 */       if (isInGame && !PauseMenu.isOpen) {
/* 264 */         inGameRender(g);
/* 265 */       } else if (!isInGame && !PauseMenu.isOpen) {
/* 266 */         mainMenu.render(g);
/* 267 */       } else if (isInGame && PauseMenu.isOpen) {
/* 268 */         pauseMenu.renderMain(g);
/*     */       } 
/* 280 */       Noti.render(g);
/* 281 */       if (F3Menu.f3menu)
/* 282 */         F3Menu.render(g); 
/* 283 */     } else if (initing) {
/* 284 */       g.setColor(Color.black);
/* 285 */       g.fillRect(0, 0, getWidth(), getHeight());
/* 286 */       g.setFont(buttonTextFont);
/* 287 */       fm = g.getFontMetrics(buttonTextFont);
/* 288 */       g.setColor(Color.white);
/* 289 */       g.drawString("-egartley Presents-", 
/* 290 */           getWidth() / 2 - fm.stringWidth("-egartley Presents-") / 2, 
/* 291 */           getHeight() / 2 - 25);
/* 292 */       g.drawString("Loading game...", 
/* 293 */           getWidth() / 2 - fm.stringWidth("Loading game...") / 2, 
/* 294 */           getHeight() / 2 + 25);
/* 295 */       g.dispose();
/* 296 */       bs.show();
/*     */       try {
/* 298 */         Thread.sleep(1200L);
/* 299 */       } catch (InterruptedException e) {
/* 300 */         e.printStackTrace();
/*     */       } 
/* 302 */       init();
/*     */       return;
/*     */     } 
/* 305 */     g.dispose();
/* 306 */     bs.show();
/*     */   }
/*     */   
/*     */   private void inGameRender(Graphics g) {
/* 310 */     if (storyText.requested) {
/*     */       try {
/* 312 */         storyText.render(g);
/* 313 */       } catch (InterruptedException e) {
/* 314 */         e.printStackTrace();
/*     */       } 
/*     */     } else {
/* 319 */       grassm.render(g);
/* 320 */       if (dummy)
/* 321 */         Entity.td.render(g); 
/* 323 */       Entity.player.render(g);
/* 324 */       br.render(g);
/* 325 */       Entity.player.drawPlayerHUD(g);
/* 326 */       inv.render(g);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void main(String[] args) throws Exception {
/* 335 */     Game game = new Game();
/* 336 */     st = new STLib();
/* 337 */     game.setPreferredSize(new Dimension(838, 573));
/* 338 */     game.setMaximumSize(new Dimension(838, 573));
/* 339 */     game.setMinimumSize(new Dimension(838, 573));
/* 340 */     frame = new JFrame(title);
/* 341 */     frame.setSize(838, 573);
/* 342 */     frame.setDefaultCloseOperation(3);
/* 343 */     frame.setResizable(false);
/* 344 */     frame.add(game);
/* 345 */     st.centerFrame(frame);
/* 346 */     st.setFrameIconAbsoulute(frame, String.valueOf(mainDir) + "assets\\icon32.png");
/* 347 */     frame.setVisible(true);
/* 348 */     uuid = UUID.randomUUID().toString();
/* 349 */     game.start();
/*     */   }
/*     */   
/*     */   public static String getUUID() {
/* 353 */     return uuid;
/*     */   }
/*     */   
/*     */   public static int getProgess() {
/* 357 */     if (mainMenu.currentProfile == 1)
/* 358 */       return Profile1.progress; 
/* 359 */     if (mainMenu.currentProfile == 2)
/* 360 */       return Profile2.progress; 
/* 361 */     if (mainMenu.currentProfile == 3)
/* 362 */       return Profile3.progress; 
/* 364 */     return 0;
/*     */   }
/*     */   
/*     */   public static void setProgress(int newProgress) {
/* 369 */     if (mainMenu.currentProfile == 1) {
/* 370 */       Profile1.progress = newProgress;
/* 371 */     } else if (mainMenu.currentProfile == 2) {
/* 372 */       Profile2.progress = newProgress;
/* 373 */     } else if (mainMenu.currentProfile == 3) {
/* 374 */       Profile3.progress = newProgress;
/*     */     } 
/*     */   }
/*     */   
/*     */   public static String getSaveKey(int n) {
/* 379 */     if (n == 1)
/* 380 */       return save1Key; 
/* 381 */     if (n == 2)
/* 382 */       return save2Key; 
/* 383 */     if (n == 3)
/* 384 */       return save3Key; 
/* 385 */     if (n == 0)
/* 386 */       return ""; 
/* 388 */     return null;
/*     */   }
/*     */   
/*     */   public static Player getPlayer() {
/* 392 */     return Entity.player;
/*     */   }
/*     */   
/*     */   public static MainMenu getMainMenu() {
/* 396 */     return mainMenu;
/*     */   }
/*     */   
/*     */   public static GrassMap getMap() {
/* 400 */     return grassm;
/*     */   }
/*     */   
/*     */   public static StoryText getStoryText() {
/* 404 */     return storyText;
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.1.0_1.jar!\com\emgartley\beyondOrigins\main\Game.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */