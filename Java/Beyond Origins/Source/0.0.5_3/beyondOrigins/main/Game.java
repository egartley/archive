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
/*     */   public static int frames;
/*     */   
/*     */   public static int currentFrames;
/*     */   
/*     */   public static int updates;
/*     */   
/*     */   public static int currentUpdates;
/*     */   
/*  66 */   public static int playerSpawnX = 403;
/*     */   
/*  67 */   public static int playerSpawnY = 270;
/*     */   
/*  70 */   public static String identifer = "This is a BETA BUILD.";
/*     */   
/*  71 */   public static String title = "Beyond Origins 0.0.5 Beta 3";
/*     */   
/*  72 */   public static String copyright = "Evan Gartley 2014";
/*     */   
/*  73 */   public static String save1Path = "C:\\Users\\" + 
/*  74 */     System.getProperty("user.name") + 
/*  75 */     "\\AppData\\Roaming\\Beyond Origins\\save1.zan";
/*     */   
/*  76 */   public static String save2Path = "C:\\Users\\" + 
/*  77 */     System.getProperty("user.name") + 
/*  78 */     "\\AppData\\Roaming\\Beyond Origins\\save2.zan";
/*     */   
/*  79 */   public static String save3Path = "C:\\Users\\" + 
/*  80 */     System.getProperty("user.name") + 
/*  81 */     "\\AppData\\Roaming\\Beyond Origins\\save3.zan";
/*     */   
/*  82 */   public static String dataPath = "C:\\Users\\" + 
/*  83 */     System.getProperty("user.name") + 
/*  84 */     "\\AppData\\Roaming\\Beyond Origins\\data.zan";
/*     */   
/*  85 */   public static String townName = "Lunix";
/*     */   
/*  88 */   public static Color buttonIdleColor = new Color(255, 255, 255);
/*     */   
/*  89 */   public static Color buttonSelectedColor = new Color(236, 210, 120);
/*     */   
/*  90 */   public static Color buttonClickedColor = new Color(73, 73, 73);
/*     */   
/*  91 */   public static Color skyColor = new Color(86, 201, 255);
/*     */   
/*  92 */   public static Color profileInfoColor = new Color(99, 99, 99);
/*     */   
/*  93 */   public static Color gameProgressColor = new Color(73, 73, 73);
/*     */   
/*  96 */   public static Font f3MenuFont = new Font("DejaVu Sans", 0, 12);
/*     */   
/*  97 */   public static Font buttonTextFont = new Font("MoolBoran", 0, 32);
/*     */   
/*  98 */   public static Font profileInfoFont = new Font("MoolBoran", 0, 23);
/*     */   
/*  99 */   public static Font profileNameFont = new Font("MoolBoran", 3, 
/* 100 */       23);
/*     */   
/* 101 */   public static Font areYouSureFont = new Font("MoolBoran", 1, 62);
/*     */   
/* 102 */   public static Font gameProgressFont = new Font("MoolBoran", 0, 60);
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
/*     */   public static boolean testDummy = false;
/*     */   
/*     */   private BufferedImage playerSheet;
/*     */   
/*     */   private BufferedImage terrain1Sheet;
/*     */   
/*     */   private BufferedImage mainmenuSheet;
/*     */   
/*     */   private BufferedImage inventorySheet;
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
/*     */   public void init() throws IOException {
/* 140 */     ImageLoader loader = new ImageLoader();
/* 143 */     this.playerSheet = loader.load("/player.png");
/* 144 */     this.terrain1Sheet = loader.load("/terrain1.png");
/* 145 */     this.mainmenuSheet = loader.load("/mainmenu.png");
/* 146 */     this.inventorySheet = loader.load("/inventory.png");
/* 147 */     inside1Image = loader.load("/inside1.png");
/* 148 */     logoImage = loader.load("/logo.png");
/* 151 */     SpriteSheet ssplr = new SpriteSheet(this.playerSheet);
/* 152 */     SpriteSheet sstr1 = new SpriteSheet(this.terrain1Sheet);
/* 153 */     SpriteSheet ssmnm = new SpriteSheet(this.mainmenuSheet);
/* 154 */     SpriteSheet ssinv = new SpriteSheet(this.inventorySheet);
/* 157 */     this.implr = new ImageManager(ssplr);
/* 158 */     this.immnm = new ImageManager(ssmnm);
/* 159 */     this.iminv = new ImageManager(ssinv);
/* 160 */     this.imtr1 = new ImageManager(sstr1);
/* 163 */     mainmenu = new MainMenu(this.immnm, this.implr);
/* 164 */     pauseMenu = new PauseMenu(this.immnm);
/* 165 */     grassm = new GrassMap(this.imtr1);
/* 166 */     player = new Player(playerSpawnX, playerSpawnY, playerSpawnX, 
/* 167 */         playerSpawnY, this.implr);
/* 168 */     td = new TestDummy(this.implr);
/* 169 */     inventoryMain = new InventoryMain(this.iminv);
/* 170 */     f3menu = new F3Menu();
/* 173 */     GrassMap.init();
/* 174 */     MainMenu.init();
/* 175 */     BuildingRender.init();
/* 176 */     Shop.init();
/* 179 */     addKeyListener((KeyListener)new KeyManager());
/* 180 */     addMouseListener((MouseListener)new MouseManager());
/* 181 */     addMouseMotionListener((MouseMotionListener)new MouseMotion());
/*     */   }
/*     */   
/*     */   public synchronized void start() {
/* 186 */     if (running)
/*     */       return; 
/* 189 */     running = true;
/* 191 */     this.gameThread = new Thread(this);
/* 192 */     animateThread = new Thread((Runnable)new Animate("Animate"));
/* 193 */     timer1Thread = new Thread((Runnable)new Timer("Timer1"));
/* 194 */     storyTextThread = new Thread((Runnable)new StoryText("StoryText"));
/* 198 */     animateThread.setPriority(1);
/* 199 */     timer1Thread.setPriority(1);
/* 200 */     storyTextThread.setPriority(1);
/* 203 */     this.gameThread.start();
/*     */   }
/*     */   
/*     */   public synchronized void stop() {
/* 208 */     if (!running)
/*     */       return; 
/* 211 */     running = false;
/*     */     try {
/* 213 */       this.gameThread.join();
/* 214 */     } catch (InterruptedException e) {
/* 215 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void run() {
/*     */     try {
/* 221 */       init();
/* 222 */     } catch (IOException e) {
/* 223 */       e.printStackTrace();
/*     */     } 
/* 225 */     long lastTime = System.nanoTime();
/* 226 */     long timer = System.currentTimeMillis();
/* 227 */     double ns = 1.6666666666666666E7D;
/* 228 */     double delta = 0.0D;
/* 229 */     requestFocus();
/* 232 */     while (running) {
/* 233 */       long now = System.nanoTime();
/* 234 */       delta += (now - lastTime) / ns;
/* 235 */       lastTime = now;
/* 236 */       if (delta >= 1.0D) {
/* 237 */         tick();
/* 238 */         updates++;
/* 239 */         delta--;
/*     */       } 
/* 241 */       render();
/* 242 */       frames++;
/* 243 */       if (System.currentTimeMillis() - timer > 1000L) {
/* 244 */         timer += 1000L;
/* 245 */         currentFrames = frames;
/* 246 */         currentUpdates = updates;
/* 247 */         updates = 0;
/* 248 */         frames = 0;
/*     */       } 
/*     */     } 
/* 251 */     stop();
/*     */   }
/*     */   
/*     */   public synchronized void tick() {
/* 257 */     if (isInGame && !PauseMenu.isOpen) {
/* 258 */       if (!StoryText.requested)
/* 260 */         if (!StoryText.requested) {
/* 261 */           Save.tick();
/* 262 */           inventoryMain.tick();
/* 263 */           player.tick();
/* 264 */           if (testDummy)
/* 265 */             td.tick(); 
/*     */         }  
/* 268 */     } else if (!isInGame && !PauseMenu.isOpen) {
/* 269 */       mainmenu.tick();
/* 270 */     } else if (isInGame && PauseMenu.isOpen) {
/* 271 */       pauseMenu.tick();
/*     */     } 
/*     */   }
/*     */   
/*     */   public synchronized void render() {
/* 279 */     BufferStrategy bs = getBufferStrategy();
/* 281 */     if (bs == null) {
/* 282 */       createBufferStrategy(3);
/*     */       return;
/*     */     } 
/* 286 */     Graphics g = bs.getDrawGraphics();
/* 289 */     g.fillRect(0, 0, 838, 573);
/* 291 */     g.setColor(Color.WHITE);
/* 294 */     if (isInGame && !PauseMenu.isOpen) {
/* 295 */       if (StoryText.requested) {
/*     */         try {
/* 297 */           StoryText.render(g);
/* 298 */         } catch (InterruptedException e) {
/* 299 */           e.printStackTrace();
/*     */         } 
/*     */       } else {
/* 302 */         grassm.render(g);
/* 303 */         player.render(g);
/* 304 */         if (testDummy)
/* 305 */           td.render(g); 
/* 307 */         inventoryMain.render(g);
/*     */       } 
/* 309 */     } else if (!isInGame && !PauseMenu.isOpen) {
/* 310 */       mainmenu.renderMain(g);
/* 311 */     } else if (isInGame && PauseMenu.isOpen) {
/* 312 */       pauseMenu.renderMain(g);
/*     */     } 
/* 315 */     if (F3Menu.f3menu)
/* 316 */       f3menu.render(g); 
/* 320 */     g.dispose();
/* 321 */     bs.show();
/*     */   }
/*     */   
/*     */   public static void main(String[] args) throws Exception {
/* 328 */     Game game = new Game();
/* 329 */     game.setPreferredSize(new Dimension(838, 573));
/* 330 */     game.setMaximumSize(new Dimension(838, 573));
/* 331 */     game.setMinimumSize(new Dimension(838, 573));
/* 334 */     JFrame frame = new JFrame(title);
/* 335 */     frame.setSize(838, 573);
/* 336 */     frame.setDefaultCloseOperation(3);
/* 337 */     frame.setResizable(false);
/* 338 */     frame.add(game);
/* 339 */     frame.setVisible(true);
/* 340 */     frame.setLocationRelativeTo((Component)null);
/* 341 */     frame.setIconImage(Toolkit.getDefaultToolkit().getImage(
/* 342 */           JFrame.class.getResource("/icon32.png")));
/*     */     try {
/* 347 */       boolean bool = (new File("C:\\Users\\" + 
/* 348 */           System.getProperty("user.name") + 
/* 349 */           "\\AppData\\Roaming\\Beyond Origins")).mkdir();
/* 355 */     } catch (Exception e) {
/* 356 */       e.printStackTrace();
/*     */     } 
/* 361 */     animateThread = new Thread(game);
/* 362 */     timer1Thread = new Thread(game);
/* 363 */     storyTextThread = new Thread(game);
/* 368 */     game.start();
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.5_3.jar!\beyondOrigins\main\Game.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */