/*     */ package beyondOrigins.main;
/*     */ 
/*     */ import beyondOrigins.files.Save;
/*     */ import beyondOrigins.main.buildings.BuildingRender;
/*     */ import beyondOrigins.main.buildings.shop.Shop;
/*     */ import beyondOrigins.main.entities.Player;
/*     */ import beyondOrigins.main.entities.TestDummy;
/*     */ import beyondOrigins.main.gfx.ImageLoader;
/*     */ import beyondOrigins.main.gfx.ImageManager;
/*     */ import beyondOrigins.main.gfx.SpriteSheet;
/*     */ import beyondOrigins.main.inventory.Inventory;
/*     */ import beyondOrigins.main.maps.GrassMap;
/*     */ import beyondOrigins.main.menus.F3Menu;
/*     */ import beyondOrigins.main.menus.MainMenu;
/*     */ import beyondOrigins.main.menus.PauseMenu;
/*     */ import beyondOrigins.threads.Dialogue;
/*     */ import beyondOrigins.threads.StoryText;
/*     */ import beyondOrigins.threads.Timer;
/*     */ import beyondOrigins.userInput.KeyManager;
/*     */ import beyondOrigins.userInput.MouseManager;
/*     */ import beyondOrigins.userInput.MouseMotion;
/*     */ import java.awt.Canvas;
/*     */ import java.awt.Color;
/*     */ import java.awt.Component;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.Font;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Toolkit;
/*     */ import java.awt.event.KeyListener;
/*     */ import java.awt.event.MouseListener;
/*     */ import java.awt.event.MouseMotionListener;
/*     */ import java.awt.image.BufferStrategy;
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.io.File;
/*     */ import java.io.FileWriter;
/*     */ import java.io.IOException;
/*     */ import java.io.PrintWriter;
/*     */ import javax.swing.JFrame;
/*     */ 
/*     */ public class Game extends Canvas implements Runnable {
/*     */   private static final long serialVersionUID = 1L;
/*     */   
/*     */   public static final int HEIGHT = 573;
/*     */   
/*     */   public static final int WIDTH = 419;
/*     */   
/*     */   public static final int SCALE = 2;
/*     */   
/*     */   public static boolean running = false;
/*     */   
/*     */   public Thread gameThread;
/*     */   
/*     */   public static Thread timer1Thread;
/*     */   
/*     */   public static Thread storyTextThread;
/*     */   
/*     */   public static FileWriter fw1;
/*     */   
/*     */   public static FileWriter fw2;
/*     */   
/*     */   public static PrintWriter pw1;
/*     */   
/*     */   public static PrintWriter pw2;
/*     */   
/*     */   public static short frames;
/*     */   
/*     */   public static short currentFrames;
/*     */   
/*     */   public static short updates;
/*     */   
/*     */   public static short currentUpdates;
/*     */   
/*  62 */   public static short playerSpawnX = 403;
/*     */   
/*  63 */   public static short playerSpawnY = 270;
/*     */   
/*  66 */   public static String identifer = "This is a BETA BUILD. Report bugs ASAP!";
/*     */   
/*  67 */   public static String copyright = "©2014 Evan Gartley", version = "005B5";
/*     */   
/*  68 */   public static String title = "Beyond Origins 0.0.5 Beta 5", townName = "Lunix";
/*     */   
/*  69 */   public static String save1Path = "C:\\Users\\" + 
/*  70 */     System.getProperty("user.name") + 
/*  71 */     "\\AppData\\Roaming\\Beyond Origins\\saves\\save1.zan";
/*     */   
/*  72 */   public static String save2Path = "C:\\Users\\" + System.getProperty("user.name") + 
/*  73 */     "\\AppData\\Roaming\\Beyond Origins\\saves\\save2.zan";
/*     */   
/*  74 */   public static String save3Path = "C:\\Users\\" + System.getProperty("user.name") + 
/*  75 */     "\\AppData\\Roaming\\Beyond Origins\\saves\\save3.zan";
/*     */   
/*  76 */   public static String dataPath = "C:\\Users\\" + System.getProperty("user.name") + 
/*  77 */     "\\AppData\\Roaming\\Beyond Origins\\data.zan";
/*     */   
/*  80 */   public static Color buttonIdleColor = new Color(255, 255, 255);
/*     */   
/*  81 */   public static Color gameProgressColor = new Color(73, 73, 73);
/*     */   
/*  82 */   public static Color profileInfoColor = new Color(99, 99, 99), skyColor = new Color(86, 
/*  83 */       201, 255);
/*     */   
/*  83 */   public static Color buttonClickedColor = new Color(73, 73, 73);
/*     */   
/*  84 */   public static Color buttonSelectedColor = new Color(236, 210, 120);
/*     */   
/*  87 */   public static Font f3MenuFont = new Font("DejaVu Sans", 0, 12);
/*     */   
/*  88 */   public static Font buttonTextFont = new Font("MoolBoran", 0, 32);
/*     */   
/*  89 */   public static Font profileInfoFont = new Font("MoolBoran", 0, 23);
/*     */   
/*  90 */   public static Font profileNameFont = new Font("MoolBoran", 3, 23);
/*     */   
/*  91 */   public static Font areYouSureFont = new Font("MoolBoran", 1, 62);
/*     */   
/*  92 */   public static Font gameProgressFont = new Font("MoolBoran", 0, 60);
/*     */   
/*  93 */   public static Font playerHUDFont = new Font("CenturyGothic", 3, 
/*  94 */       12);
/*     */   
/*  94 */   public static Font pHUDBar = new Font("CenturyGothic", 0, 10);
/*     */   
/*     */   public static boolean isInGame = false, saveRequested = false;
/*     */   
/*     */   public static boolean loadRequested = false, isOnMap = true;
/*     */   
/*     */   public static boolean autoSave = true;
/*     */   
/*     */   public static boolean dummy = false;
/*     */   
/*     */   private static BufferedImage playerSheet;
/*     */   
/*     */   private static BufferedImage terrain1Sheet;
/*     */   
/*     */   private static BufferedImage mainmenuSheet;
/*     */   
/*     */   private static BufferedImage inventorySheet;
/*     */   
/*     */   private static BufferedImage widgetSheet;
/*     */   
/*     */   private static BufferedImage entitySheet;
/*     */   
/*     */   public static BufferedImage logoImage;
/*     */   
/*     */   public static BufferedImage inside1Image;
/*     */   
/*     */   private static ImageManager implr;
/*     */   
/*     */   private static ImageManager imtr1;
/*     */   
/*     */   private static ImageManager immnm;
/*     */   
/*     */   private static ImageManager iminv;
/*     */   
/*     */   private static ImageManager imwig;
/*     */   
/*     */   private static ImageManager iment;
/*     */   
/*     */   private static Player player;
/*     */   
/*     */   private static GrassMap grassm;
/*     */   
/*     */   private static MainMenu mainmenu;
/*     */   
/*     */   private static Inventory inventoryMain;
/*     */   
/*     */   private static PauseMenu pauseMenu;
/*     */   
/*     */   private static TestDummy td;
/*     */   
/*     */   private static Dialogue dialogue;
/*     */   
/*     */   public void init() throws IOException {
/* 132 */     loadGfx();
/* 135 */     BuildingRender.init();
/* 136 */     Shop.init();
/* 139 */     addKeyListener((KeyListener)new KeyManager());
/* 140 */     addMouseListener((MouseListener)new MouseManager());
/* 141 */     addMouseMotionListener((MouseMotionListener)new MouseMotion());
/*     */   }
/*     */   
/*     */   public static void loadGfx() {
/* 146 */     ImageLoader loader = new ImageLoader();
/* 149 */     playerSheet = loader.load("/player.png");
/* 150 */     terrain1Sheet = loader.load("/terrain1.png");
/* 151 */     mainmenuSheet = loader.load("/mainmenu.png");
/* 152 */     inventorySheet = loader.load("/inventory.png");
/* 153 */     widgetSheet = loader.load("/widgets1.png");
/* 154 */     entitySheet = loader.load("/entities1.png");
/* 155 */     inside1Image = loader.load("/inside1.png");
/* 156 */     logoImage = loader.load("/logo.png");
/* 161 */     SpriteSheet ssplr = new SpriteSheet(playerSheet);
/* 162 */     SpriteSheet sstr1 = new SpriteSheet(terrain1Sheet);
/* 163 */     SpriteSheet ssmnm = new SpriteSheet(mainmenuSheet);
/* 164 */     SpriteSheet sswig = new SpriteSheet(widgetSheet);
/* 165 */     SpriteSheet ssent = new SpriteSheet(entitySheet);
/* 167 */     SpriteSheet ssinv = new SpriteSheet(inventorySheet);
/* 170 */     implr = new ImageManager(ssplr);
/* 171 */     immnm = new ImageManager(ssmnm);
/* 172 */     iment = new ImageManager(ssent);
/* 173 */     imwig = new ImageManager(sswig);
/* 174 */     iminv = new ImageManager(ssinv);
/* 175 */     imtr1 = new ImageManager(sstr1);
/* 178 */     mainmenu = new MainMenu(immnm, implr);
/* 179 */     pauseMenu = new PauseMenu(immnm);
/* 180 */     grassm = new GrassMap(imtr1);
/* 181 */     player = new Player(playerSpawnX, playerSpawnY, playerSpawnX, 
/* 182 */         playerSpawnY, implr, imwig);
/* 183 */     td = new TestDummy(iment);
/* 184 */     dialogue = new Dialogue(imwig);
/* 185 */     inventoryMain = new Inventory(iminv);
/*     */   }
/*     */   
/*     */   public static void endClick() {
/* 189 */     MouseManager.mousePressed = false;
/*     */   }
/*     */   
/*     */   public static boolean isPressed() {
/* 193 */     return MouseManager.mousePressed;
/*     */   }
/*     */   
/*     */   public static void createFolder(String path) {
/* 197 */     if (!(new File(path)).exists())
/* 198 */       boolean bool = (new File(path)).mkdir(); 
/*     */   }
/*     */   
/*     */   public synchronized void start() {
/* 206 */     if (running)
/*     */       return; 
/* 209 */     running = true;
/* 211 */     this.gameThread = new Thread(this);
/* 212 */     timer1Thread = new Thread((Runnable)new Timer("Timer1"));
/* 213 */     storyTextThread = new Thread((Runnable)new StoryText("StoryText"));
/* 216 */     timer1Thread.setPriority(1);
/* 217 */     storyTextThread.setPriority(1);
/* 220 */     this.gameThread.start();
/*     */   }
/*     */   
/*     */   public synchronized void stop() {
/* 225 */     if (!running)
/*     */       return; 
/* 228 */     running = false;
/*     */     try {
/* 230 */       this.gameThread.join();
/* 231 */     } catch (InterruptedException e) {
/* 232 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void run() {
/*     */     try {
/* 238 */       init();
/* 239 */     } catch (IOException e) {
/* 240 */       e.printStackTrace();
/*     */     } 
/* 242 */     long lastTime = System.nanoTime();
/* 243 */     long timer = System.currentTimeMillis();
/* 244 */     double ns = 1.6666666666666666E7D;
/* 245 */     double delta = 0.0D;
/* 246 */     requestFocus();
/* 249 */     while (running) {
/* 250 */       long now = System.nanoTime();
/* 251 */       delta += (now - lastTime) / ns;
/* 252 */       lastTime = now;
/* 253 */       if (delta >= 1.0D) {
/* 254 */         tick();
/* 255 */         updates = (short)(updates + 1);
/* 256 */         delta--;
/*     */       } 
/* 258 */       render();
/* 259 */       frames = (short)(frames + 1);
/* 260 */       if (System.currentTimeMillis() - timer > 1000L) {
/* 261 */         timer += 1000L;
/* 262 */         currentFrames = frames;
/* 263 */         currentUpdates = updates;
/* 264 */         updates = 0;
/* 265 */         frames = 0;
/*     */       } 
/*     */     } 
/* 268 */     stop();
/*     */   }
/*     */   
/*     */   public synchronized void tick() {
/* 274 */     if (isInGame && !PauseMenu.isOpen) {
/* 275 */       if (!StoryText.requested)
/* 277 */         if (!StoryText.requested) {
/* 278 */           Save.tick();
/* 279 */           inventoryMain.tick();
/* 280 */           player.tick();
/* 281 */           if (dummy)
/* 282 */             td.tick(); 
/*     */         }  
/* 285 */     } else if (!isInGame && !PauseMenu.isOpen) {
/* 286 */       mainmenu.tick();
/* 287 */     } else if (isInGame && PauseMenu.isOpen) {
/* 288 */       pauseMenu.tick();
/*     */     } 
/*     */   }
/*     */   
/*     */   public synchronized void render() {
/* 296 */     BufferStrategy bs = getBufferStrategy();
/* 298 */     if (bs == null) {
/* 299 */       createBufferStrategy(3);
/*     */       return;
/*     */     } 
/* 303 */     Graphics g = bs.getDrawGraphics();
/* 306 */     g.fillRect(0, 0, 838, 573);
/* 308 */     g.setColor(Color.WHITE);
/* 311 */     if (isInGame && !PauseMenu.isOpen) {
/* 312 */       if (StoryText.requested) {
/*     */         try {
/* 314 */           StoryText.render(g);
/* 315 */         } catch (InterruptedException e) {
/* 316 */           e.printStackTrace();
/*     */         } 
/*     */       } else {
/* 319 */         grassm.render(g);
/* 320 */         if (dummy)
/* 321 */           td.render(g); 
/* 323 */         player.render(g);
/* 324 */         inventoryMain.render(g);
/*     */       } 
/* 326 */     } else if (!isInGame && !PauseMenu.isOpen) {
/* 327 */       mainmenu.renderMain(g);
/* 328 */     } else if (isInGame && PauseMenu.isOpen) {
/* 329 */       pauseMenu.renderMain(g);
/*     */     } 
/* 332 */     if (F3Menu.f3menu)
/* 333 */       F3Menu.render(g); 
/* 337 */     g.dispose();
/* 338 */     bs.show();
/*     */   }
/*     */   
/*     */   public static void main(String[] args) throws Exception {
/* 345 */     Game game = new Game();
/* 346 */     game.setPreferredSize(new Dimension(838, 573));
/* 347 */     game.setMaximumSize(new Dimension(838, 573));
/* 348 */     game.setMinimumSize(new Dimension(838, 573));
/* 351 */     JFrame frame = new JFrame(title);
/* 352 */     frame.setSize(838, 573);
/* 353 */     frame.setDefaultCloseOperation(3);
/* 354 */     frame.setResizable(false);
/* 355 */     frame.add(game);
/* 356 */     frame.setVisible(true);
/* 357 */     frame.setLocationRelativeTo((Component)null);
/* 358 */     frame.setIconImage(Toolkit.getDefaultToolkit().getImage(
/* 359 */           JFrame.class.getResource("/icon32.png")));
/*     */     try {
/* 364 */       createFolder("C:\\Users\\" + System.getProperty("user.name") + 
/* 365 */           "\\AppData\\Roaming\\Beyond Origins");
/* 368 */       createFolder("C:\\Users\\" + System.getProperty("user.name") + 
/* 369 */           "\\AppData\\Roaming\\Beyond Origins\\versions");
/* 372 */       createFolder("C:\\Users\\" + System.getProperty("user.name") + 
/* 373 */           "\\AppData\\Roaming\\Beyond Origins\\saves");
/* 375 */     } catch (Exception e) {
/* 376 */       e.printStackTrace();
/*     */     } 
/* 381 */     timer1Thread = new Thread(game);
/* 382 */     storyTextThread = new Thread(game);
/* 387 */     game.start();
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.5_5.jar!\beyondOrigins\main\Game.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */