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
/*  51 */   public static String copyright = "©2014 Evan Gartley", version = "010B3";
/*     */   
/*  52 */   public static String title = "Beyond Origins 0.1.0 Build 3", townName = "Lunix";
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
/*     */   public static BufferedImage mapImage;
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
/* 111 */     grassm = new GrassMap(mapImage, 0, 0);
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
/* 125 */     mapImage = loadImage(String.valueOf(mainDir) + "assets\\grassMap.png");
/* 126 */     playerSheet = loadImage(String.valueOf(mainDir) + "assets\\player.png");
/* 127 */     terrain1Sheet = loadImage(String.valueOf(mainDir) + "assets\\terrain1.png");
/* 128 */     mainmenuSheet = loadImage(String.valueOf(mainDir) + "assets\\mainmenu.png");
/* 129 */     inventorySheet = loadImage(String.valueOf(mainDir) + "assets\\inventory.png");
/* 130 */     widgetSheet = loadImage(String.valueOf(mainDir) + "assets\\widgets1.png");
/* 131 */     entitySheet = loadImage(String.valueOf(mainDir) + "assets\\entities1.png");
/* 132 */     inside1Image = loadImage(String.valueOf(mainDir) + "assets\\inside1.png");
/* 133 */     logoImage = loadImage(String.valueOf(mainDir) + "assets\\logo.png");
/* 134 */     creds = loadImage(String.valueOf(mainDir) + "assets\\creds.png");
/* 135 */     im = new ImageManager();
/* 136 */     logger.log("Loaded graphics");
/*     */   }
/*     */   
/*     */   private static BufferedImage loadImage(String path) {
/*     */     try {
/* 141 */       BufferedImage reImage = ImageIO.read(new File(path));
/* 142 */       return reImage;
/* 143 */     } catch (IOException e) {
/* 144 */       e.printStackTrace();
/* 146 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void createFolder(String path) {
/* 150 */     if (!(new File(path)).exists()) {
/* 151 */       File folder = new File(path);
/* 152 */       folder.mkdir();
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void endClick() {
/* 157 */     MouseManager.mousePressed = false;
/*     */   }
/*     */   
/*     */   public static boolean mouseIsPressed() {
/* 161 */     return MouseManager.mousePressed;
/*     */   }
/*     */   
/*     */   public void run() {
/* 165 */     render();
/* 166 */     long lastTime = System.nanoTime();
/* 167 */     long timer = System.currentTimeMillis();
/* 168 */     double ns = 1.6666666666666666E7D;
/* 169 */     double delta = 0.0D;
/* 170 */     requestFocus();
/* 171 */     while (running) {
/* 172 */       long now = System.nanoTime();
/* 173 */       delta += (now - lastTime) / ns;
/* 174 */       lastTime = now;
/* 175 */       if (delta >= 1.0D) {
/* 176 */         tick();
/* 177 */         render();
/* 178 */         delta--;
/* 179 */         frames = (short)(frames + 1);
/* 180 */         if (System.currentTimeMillis() - timer > 1000L) {
/* 181 */           timer += 1000L;
/* 182 */           currentFrames = frames;
/* 183 */           frames = 0;
/*     */         } 
/*     */       } 
/*     */       try {
/* 187 */         Thread.sleep(1L);
/* 188 */       } catch (InterruptedException e) {
/* 189 */         e.printStackTrace();
/*     */       } 
/*     */     } 
/* 192 */     logger.log("Stopping the game");
/* 193 */     stop();
/*     */   }
/*     */   
/*     */   public synchronized void start() {
/* 197 */     if (running)
/*     */       return; 
/* 200 */     running = true;
/* 201 */     this.gameThread = new Thread(this);
/* 202 */     this.gameThread.setPriority(1);
/* 203 */     notiThread = new Thread((Runnable)new Noti("noti_thread"));
/* 204 */     notiThread.setPriority(1);
/* 206 */     this.gameThread.start();
/*     */   }
/*     */   
/*     */   public synchronized void stop() {
/* 211 */     if (!running)
/*     */       return; 
/* 214 */     running = false;
/*     */     try {
/* 216 */       notiThread.join();
/* 217 */       this.gameThread.join();
/* 218 */     } catch (InterruptedException e) {
/* 219 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public synchronized void tick() {
/* 224 */     width = getWidth();
/* 225 */     height = getHeight();
/* 226 */     Noti.checkNotify();
/* 227 */     if (isInGame && !PauseMenu.isOpen && !presenting) {
/* 228 */       if (!storyText.requested) {
/* 229 */         playerSpawnX = (short)(width / 2 - 16);
/* 230 */         playerSpawnY = (short)(height / 2 - 16);
/* 231 */         Save.tick();
/* 232 */         inv.tick();
/* 233 */         grassm.tick();
/* 234 */         Entity.player.tick();
/* 235 */         if (dummy)
/* 236 */           Entity.td.tick(); 
/*     */       } 
/* 239 */     } else if (!isInGame && !PauseMenu.isOpen && !presenting) {
/* 240 */       mainMenu.tick();
/* 241 */     } else if (!isInGame || !PauseMenu.isOpen || presenting) {
/* 243 */       if (presenting) {
/* 244 */         time++;
/* 245 */         if (time >= 180) {
/* 246 */           time = 0;
/* 247 */           presenting = false;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public synchronized void render() {
/* 253 */     BufferStrategy bs = getBufferStrategy();
/* 254 */     if (bs == null) {
/* 255 */       createBufferStrategy(3);
/*     */       return;
/*     */     } 
/* 258 */     g = bs.getDrawGraphics();
/* 259 */     g.fillRect(0, 0, getWidth(), getHeight());
/* 260 */     g.setColor(Color.white);
/* 261 */     st.enableAntiAliasing(g);
/* 263 */     if (!initing) {
/* 264 */       if (isInGame && !PauseMenu.isOpen) {
/* 265 */         inGameRender(g);
/* 266 */       } else if (!isInGame && !PauseMenu.isOpen) {
/* 267 */         mainMenu.render(g);
/* 268 */       } else if (isInGame && PauseMenu.isOpen) {
/* 269 */         pauseMenu.renderMain(g);
/*     */       } 
/* 281 */       Noti.render(g);
/* 282 */       if (F3Menu.f3menu)
/* 283 */         F3Menu.render(g); 
/* 284 */     } else if (initing) {
/* 285 */       g.setColor(Color.black);
/* 286 */       g.fillRect(0, 0, getWidth(), getHeight());
/* 287 */       g.setFont(buttonTextFont);
/* 288 */       fm = g.getFontMetrics(buttonTextFont);
/* 289 */       g.setColor(Color.white);
/* 290 */       g.drawString("-egartley Presents-", 
/* 291 */           getWidth() / 2 - fm.stringWidth("-egartley Presents-") / 2, 
/* 292 */           getHeight() / 2 - 25);
/* 293 */       g.drawString("Loading game...", 
/* 294 */           getWidth() / 2 - fm.stringWidth("Loading game...") / 2, 
/* 295 */           getHeight() / 2 + 25);
/* 296 */       g.dispose();
/* 297 */       bs.show();
/* 303 */       init();
/*     */       return;
/*     */     } 
/* 306 */     g.dispose();
/* 307 */     bs.show();
/*     */   }
/*     */   
/*     */   private void inGameRender(Graphics g) {
/* 311 */     if (storyText.requested) {
/*     */       try {
/* 313 */         storyText.render(g);
/* 314 */       } catch (InterruptedException e) {
/* 315 */         e.printStackTrace();
/*     */       } 
/*     */     } else {
/* 320 */       grassm.render(g);
/* 321 */       if (dummy)
/* 322 */         Entity.td.render(g); 
/* 324 */       Entity.player.render(g);
/* 325 */       br.render(g);
/* 326 */       Entity.player.drawPlayerHUD(g);
/* 327 */       inv.render(g);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void main(String[] args) throws Exception {
/* 336 */     Game game = new Game();
/* 337 */     st = new STLib();
/* 338 */     game.setPreferredSize(new Dimension(838, 573));
/* 339 */     game.setMaximumSize(new Dimension(838, 573));
/* 340 */     game.setMinimumSize(new Dimension(838, 573));
/* 341 */     frame = new JFrame(title);
/* 342 */     frame.setSize(838, 573);
/* 343 */     frame.setDefaultCloseOperation(3);
/* 344 */     frame.setResizable(false);
/* 345 */     frame.add(game);
/* 346 */     st.centerFrame(frame);
/* 347 */     st.setFrameIconAbsoulute(frame, String.valueOf(mainDir) + "assets\\icon32.png");
/* 348 */     frame.setVisible(true);
/* 349 */     uuid = UUID.randomUUID().toString();
/* 350 */     game.start();
/*     */   }
/*     */   
/*     */   public static String getUUID() {
/* 354 */     return uuid;
/*     */   }
/*     */   
/*     */   public static int getProgess() {
/* 358 */     if (mainMenu.currentProfile == 1)
/* 359 */       return Profile1.progress; 
/* 360 */     if (mainMenu.currentProfile == 2)
/* 361 */       return Profile2.progress; 
/* 362 */     if (mainMenu.currentProfile == 3)
/* 363 */       return Profile3.progress; 
/* 365 */     return 0;
/*     */   }
/*     */   
/*     */   public static void setProgress(int newProgress) {
/* 370 */     if (mainMenu.currentProfile == 1) {
/* 371 */       Profile1.progress = newProgress;
/* 372 */     } else if (mainMenu.currentProfile == 2) {
/* 373 */       Profile2.progress = newProgress;
/* 374 */     } else if (mainMenu.currentProfile == 3) {
/* 375 */       Profile3.progress = newProgress;
/*     */     } 
/*     */   }
/*     */   
/*     */   public static String getSaveKey(int n) {
/* 380 */     if (n == 1)
/* 381 */       return save1Key; 
/* 382 */     if (n == 2)
/* 383 */       return save2Key; 
/* 384 */     if (n == 3)
/* 385 */       return save3Key; 
/* 386 */     if (n == 0)
/* 387 */       return ""; 
/* 389 */     return null;
/*     */   }
/*     */   
/*     */   public static Player getPlayer() {
/* 393 */     return Entity.player;
/*     */   }
/*     */   
/*     */   public static MainMenu getMainMenu() {
/* 397 */     return mainMenu;
/*     */   }
/*     */   
/*     */   public static GrassMap getMap() {
/* 401 */     return grassm;
/*     */   }
/*     */   
/*     */   public static StoryText getStoryText() {
/* 405 */     return storyText;
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.1.0_3.jar!\com\emgartley\beyondOrigins\main\Game.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */