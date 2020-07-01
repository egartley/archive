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
/*     */ import beyondOrigins.main.inventory.InventoryMain;
/*     */ import beyondOrigins.main.maps.GrassMap;
/*     */ import beyondOrigins.main.menus.F3Menu;
/*     */ import beyondOrigins.main.menus.MainMenu;
/*     */ import beyondOrigins.main.menus.PauseMenu;
/*     */ import beyondOrigins.threads.Animate;
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
/*     */   public static Thread animateThread;
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
/*  67 */   public static short playerSpawnX = 403;
/*     */   
/*  68 */   public static short playerSpawnY = 270;
/*     */   
/*  71 */   public static String identifer = "This is a BETA BUILD. Report bugs ASAP!";
/*     */   
/*  72 */   public static String title = "Beyond Origins 0.0.5 Beta 4";
/*     */   
/*  73 */   public static String version = "0.0.5 Beta 4";
/*     */   
/*  74 */   public static String copyright = "©2014 Evan Gartley";
/*     */   
/*  75 */   public static String save1Path = "C:\\Users\\" + 
/*  76 */     System.getProperty("user.name") + 
/*  77 */     "\\AppData\\Roaming\\Beyond Origins\\save1.zan";
/*     */   
/*  78 */   public static String save2Path = "C:\\Users\\" + 
/*  79 */     System.getProperty("user.name") + 
/*  80 */     "\\AppData\\Roaming\\Beyond Origins\\save2.zan";
/*     */   
/*  81 */   public static String save3Path = "C:\\Users\\" + 
/*  82 */     System.getProperty("user.name") + 
/*  83 */     "\\AppData\\Roaming\\Beyond Origins\\save3.zan";
/*     */   
/*  84 */   public static String dataPath = "C:\\Users\\" + 
/*  85 */     System.getProperty("user.name") + 
/*  86 */     "\\AppData\\Roaming\\Beyond Origins\\data.zan";
/*     */   
/*  87 */   public static String townName = "Lunix";
/*     */   
/*  90 */   public static Color buttonIdleColor = new Color(255, 255, 255);
/*     */   
/*  91 */   public static Color buttonSelectedColor = new Color(236, 210, 120);
/*     */   
/*  92 */   public static Color buttonClickedColor = new Color(73, 73, 73);
/*     */   
/*  93 */   public static Color skyColor = new Color(86, 201, 255);
/*     */   
/*  94 */   public static Color profileInfoColor = new Color(99, 99, 99);
/*     */   
/*  95 */   public static Color gameProgressColor = new Color(73, 73, 73);
/*     */   
/*  98 */   public static Font f3MenuFont = new Font("DejaVu Sans", 0, 12);
/*     */   
/*  99 */   public static Font buttonTextFont = new Font("MoolBoran", 0, 32);
/*     */   
/* 100 */   public static Font profileInfoFont = new Font("MoolBoran", 0, 23);
/*     */   
/* 101 */   public static Font profileNameFont = new Font("MoolBoran", 3, 
/* 102 */       23);
/*     */   
/* 103 */   public static Font areYouSureFont = new Font("MoolBoran", 1, 62);
/*     */   
/* 104 */   public static Font gameProgressFont = new Font("MoolBoran", 0, 60);
/*     */   
/*     */   public static boolean isInGame = false;
/*     */   
/*     */   public static boolean saveRequested = false;
/*     */   
/*     */   public static boolean loadRequested = false;
/*     */   
/*     */   public static boolean isOnMap = true;
/*     */   
/*     */   public static boolean autoSave = true;
/*     */   
/*     */   public static boolean dummy = false;
/*     */   
/*     */   private BufferedImage playerSheet;
/*     */   
/*     */   private BufferedImage terrain1Sheet;
/*     */   
/*     */   private BufferedImage mainmenuSheet;
/*     */   
/*     */   private BufferedImage inventorySheet;
/*     */   
/*     */   private BufferedImage widgetSheet;
/*     */   
/*     */   private BufferedImage entitySheet;
/*     */   
/*     */   public static BufferedImage logoImage;
/*     */   
/*     */   public static BufferedImage inside1Image;
/*     */   
/*     */   private ImageManager implr;
/*     */   
/*     */   private ImageManager imtr1;
/*     */   
/*     */   private ImageManager immnm;
/*     */   
/*     */   private ImageManager iminv;
/*     */   
/*     */   private ImageManager imwig;
/*     */   
/*     */   private ImageManager iment;
/*     */   
/*     */   private static Player player;
/*     */   
/*     */   private static GrassMap grassm;
/*     */   
/*     */   private static F3Menu f3menu;
/*     */   
/*     */   private static MainMenu mainmenu;
/*     */   
/*     */   private static InventoryMain inventoryMain;
/*     */   
/*     */   private static PauseMenu pauseMenu;
/*     */   
/*     */   private static TestDummy td;
/*     */   
/*     */   private static Dialogue dialogue;
/*     */   
/*     */   public void init() throws IOException {
/* 147 */     ImageLoader loader = new ImageLoader();
/* 150 */     this.playerSheet = loader.load("/player.png");
/* 151 */     this.terrain1Sheet = loader.load("/terrain1.png");
/* 152 */     this.mainmenuSheet = loader.load("/mainmenu.png");
/* 153 */     this.inventorySheet = loader.load("/inventory.png");
/* 154 */     this.widgetSheet = loader.load("/widgets1.png");
/* 155 */     this.entitySheet = loader.load("/entities1.png");
/* 156 */     inside1Image = loader.load("/inside1.png");
/* 157 */     logoImage = loader.load("/logo.png");
/* 162 */     SpriteSheet ssplr = new SpriteSheet(this.playerSheet);
/* 163 */     SpriteSheet sstr1 = new SpriteSheet(this.terrain1Sheet);
/* 164 */     SpriteSheet ssmnm = new SpriteSheet(this.mainmenuSheet);
/* 165 */     SpriteSheet sswig = new SpriteSheet(this.widgetSheet);
/* 166 */     SpriteSheet ssent = new SpriteSheet(this.entitySheet);
/* 168 */     SpriteSheet ssinv = new SpriteSheet(this.inventorySheet);
/* 171 */     this.implr = new ImageManager(ssplr);
/* 172 */     this.immnm = new ImageManager(ssmnm);
/* 173 */     this.iment = new ImageManager(ssent);
/* 174 */     this.imwig = new ImageManager(sswig);
/* 175 */     this.iminv = new ImageManager(ssinv);
/* 176 */     this.imtr1 = new ImageManager(sstr1);
/* 179 */     mainmenu = new MainMenu(this.immnm, this.implr);
/* 180 */     pauseMenu = new PauseMenu(this.immnm);
/* 181 */     grassm = new GrassMap(this.imtr1);
/* 182 */     player = new Player(playerSpawnX, playerSpawnY, playerSpawnX, 
/* 183 */         playerSpawnY, this.implr);
/* 184 */     td = new TestDummy(this.iment);
/* 185 */     dialogue = new Dialogue(this.imwig);
/* 186 */     inventoryMain = new InventoryMain(this.iminv);
/* 187 */     f3menu = new F3Menu();
/* 190 */     GrassMap.init();
/* 191 */     mainmenu.init();
/* 192 */     BuildingRender.init();
/* 193 */     Shop.init();
/* 196 */     addKeyListener((KeyListener)new KeyManager());
/* 197 */     addMouseListener((MouseListener)new MouseManager());
/* 198 */     addMouseMotionListener((MouseMotionListener)new MouseMotion());
/*     */   }
/*     */   
/*     */   public synchronized void start() {
/* 203 */     if (running)
/*     */       return; 
/* 206 */     running = true;
/* 208 */     this.gameThread = new Thread(this);
/* 209 */     animateThread = new Thread((Runnable)new Animate("Animate"));
/* 210 */     timer1Thread = new Thread((Runnable)new Timer("Timer1"));
/* 211 */     storyTextThread = new Thread((Runnable)new StoryText("StoryText"));
/* 215 */     animateThread.setPriority(1);
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
/* 333 */       f3menu.render(g); 
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
/* 364 */       boolean bool = (new File("C:\\Users\\" + 
/* 365 */           System.getProperty("user.name") + 
/* 366 */           "\\AppData\\Roaming\\Beyond Origins")).mkdir();
/* 372 */     } catch (Exception e) {
/* 373 */       e.printStackTrace();
/*     */     } 
/* 378 */     animateThread = new Thread(game);
/* 379 */     timer1Thread = new Thread(game);
/* 380 */     storyTextThread = new Thread(game);
/* 385 */     game.start();
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.5_4.jar!\beyondOrigins\main\Game.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */