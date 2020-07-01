/*     */ package beyondOrigins.main;
/*     */ 
/*     */ import beyondOrigins.files.Save;
/*     */ import beyondOrigins.main.buildings.BuildingRender;
/*     */ import beyondOrigins.main.buildings.shop.Shop;
/*     */ import beyondOrigins.main.entities.Player;
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
/*  45 */   private long lastTime = System.currentTimeMillis() - Save.autoSaveTime;
/*     */   
/*     */   public Thread gameThread;
/*     */   
/*     */   public static Thread animateThread;
/*     */   
/*     */   public static Thread timer1Thread;
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
/*  65 */   public static int playerSpawnX = 403;
/*     */   
/*  66 */   public static int playerSpawnY = 270;
/*     */   
/*  69 */   public static String identifer = "This is a BETA BUILD. Report bugs/glitches ASAP!!!";
/*     */   
/*  70 */   public static String title = "Beyond Origins 0.0.5 Beta 2";
/*     */   
/*  71 */   public static String copyright = "Evan Gartley 2014";
/*     */   
/*  72 */   public static String save1Path = "C:\\Users\\" + 
/*  73 */     System.getProperty("user.name") + 
/*  74 */     "\\AppData\\Roaming\\Beyond Origins\\save1.zan";
/*     */   
/*  75 */   public static String save2Path = "C:\\Users\\" + 
/*  76 */     System.getProperty("user.name") + 
/*  77 */     "\\AppData\\Roaming\\Beyond Origins\\save2.zan";
/*     */   
/*  78 */   public static String save3Path = "C:\\Users\\" + 
/*  79 */     System.getProperty("user.name") + 
/*  80 */     "\\AppData\\Roaming\\Beyond Origins\\save3.zan";
/*     */   
/*  81 */   public static String dataPath = "C:\\Users\\" + 
/*  82 */     System.getProperty("user.name") + 
/*  83 */     "\\AppData\\Roaming\\Beyond Origins\\data.zan";
/*     */   
/*  86 */   public static Color buttonIdleColor = new Color(255, 255, 255);
/*     */   
/*  87 */   public static Color buttonSelectedColor = new Color(236, 210, 120);
/*     */   
/*  88 */   public static Color buttonClickedColor = new Color(73, 73, 73);
/*     */   
/*  89 */   public static Color skyColor = new Color(86, 201, 255);
/*     */   
/*  90 */   public static Color profileInfoColor = new Color(99, 99, 99);
/*     */   
/*  91 */   public static Color gameProgressColor = new Color(73, 73, 73);
/*     */   
/*  94 */   public static Font f3MenuFont = new Font("DejaVu Sans", 0, 12);
/*     */   
/*  95 */   public static Font buttonTextFont = new Font("MoolBoran", 0, 32);
/*     */   
/*  96 */   public static Font profileInfoFont = new Font("MoolBoran", 0, 23);
/*     */   
/*  97 */   public static Font profileNameFont = new Font("MoolBoran", 3, 
/*  98 */       23);
/*     */   
/*  99 */   public static Font areYouSureFont = new Font("MoolBoran", 1, 62);
/*     */   
/* 100 */   public static Font gameProgressFont = new Font("MoolBoran", 0, 60);
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
/*     */   public static BufferedImage mapGrid;
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
/*     */   private static Dialogue dialogue;
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
/*     */   public void init() throws IOException {
/* 136 */     ImageLoader loader = new ImageLoader();
/* 139 */     this.playerSheet = loader.load("/player.png");
/* 140 */     this.terrain1Sheet = loader.load("/terrain1.png");
/* 141 */     this.mainmenuSheet = loader.load("/mainmenu.png");
/* 142 */     this.inventorySheet = loader.load("/inventory.png");
/* 143 */     inside1Image = loader.load("/inside1.png");
/* 144 */     logoImage = loader.load("/logo.png");
/* 147 */     SpriteSheet ssplr = new SpriteSheet(this.playerSheet);
/* 148 */     SpriteSheet sstr1 = new SpriteSheet(this.terrain1Sheet);
/* 149 */     SpriteSheet ssmnm = new SpriteSheet(this.mainmenuSheet);
/* 150 */     SpriteSheet ssinv = new SpriteSheet(this.inventorySheet);
/* 153 */     this.implr = new ImageManager(ssplr);
/* 154 */     this.immnm = new ImageManager(ssmnm);
/* 155 */     this.iminv = new ImageManager(ssinv);
/* 156 */     this.imtr1 = new ImageManager(sstr1);
/* 159 */     mainmenu = new MainMenu(this.immnm);
/* 160 */     pauseMenu = new PauseMenu(this.immnm);
/* 161 */     grassm = new GrassMap(this.imtr1);
/* 162 */     player = new Player(playerSpawnX, playerSpawnY, playerSpawnX, 
/* 163 */         playerSpawnY, this.implr);
/* 164 */     inventoryMain = new InventoryMain(this.iminv);
/* 165 */     f3menu = new F3Menu();
/* 168 */     dialogue = new Dialogue("Dialogue", this.implr);
/* 171 */     GrassMap.init();
/* 172 */     MainMenu.init();
/* 173 */     BuildingRender.init();
/* 174 */     Shop.init();
/* 177 */     addKeyListener((KeyListener)new KeyManager());
/* 178 */     addMouseListener((MouseListener)new MouseManager());
/* 179 */     addMouseMotionListener((MouseMotionListener)new MouseMotion());
/*     */   }
/*     */   
/*     */   public synchronized void start() {
/* 184 */     if (running)
/*     */       return; 
/* 187 */     running = true;
/* 189 */     this.gameThread = new Thread(this);
/* 190 */     animateThread = new Thread((Runnable)new Animate("Animate"));
/* 191 */     timer1Thread = new Thread((Runnable)new Timer("Timer1"));
/* 195 */     animateThread.setPriority(3);
/* 196 */     timer1Thread.setPriority(2);
/* 199 */     this.gameThread.start();
/*     */   }
/*     */   
/*     */   public synchronized void stop() {
/* 204 */     if (!running)
/*     */       return; 
/* 207 */     running = false;
/*     */     try {
/* 209 */       this.gameThread.join();
/* 210 */     } catch (InterruptedException e) {
/* 211 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void run() {
/*     */     try {
/* 217 */       init();
/* 218 */     } catch (IOException e) {
/* 219 */       e.printStackTrace();
/*     */     } 
/* 221 */     long lastTime = System.nanoTime();
/* 222 */     long timer = System.currentTimeMillis();
/* 223 */     double ns = 1.6666666666666666E7D;
/* 224 */     double delta = 0.0D;
/* 225 */     requestFocus();
/* 228 */     while (running) {
/* 229 */       long now = System.nanoTime();
/* 230 */       delta += (now - lastTime) / ns;
/* 231 */       lastTime = now;
/* 232 */       if (delta >= 1.0D) {
/* 233 */         tick();
/* 234 */         updates++;
/* 235 */         delta--;
/*     */       } 
/* 237 */       render();
/* 238 */       frames++;
/* 239 */       if (System.currentTimeMillis() - timer > 1000L) {
/* 240 */         timer += 1000L;
/* 241 */         currentFrames = frames;
/* 242 */         currentUpdates = updates;
/* 243 */         updates = 0;
/* 244 */         frames = 0;
/*     */       } 
/*     */     } 
/* 247 */     stop();
/*     */   }
/*     */   
/*     */   public synchronized void tick() {
/* 255 */     if (isInGame && !PauseMenu.isOpen) {
/* 256 */       if (autoSave) {
/* 257 */         long thisTime = System.currentTimeMillis();
/* 258 */         if (thisTime - this.lastTime >= Save.autoSaveTime) {
/* 259 */           this.lastTime = thisTime;
/* 260 */           Save.autoSave(this.lastTime);
/*     */         } 
/*     */       } 
/* 263 */       MainMenu.playState = 1;
/* 264 */       inventoryMain.tick();
/* 266 */       player.tick();
/* 268 */     } else if (!isInGame && !PauseMenu.isOpen) {
/* 269 */       mainmenu.tick();
/* 270 */     } else if (isInGame && PauseMenu.isOpen) {
/* 271 */       pauseMenu.tick();
/*     */     } 
/*     */   }
/*     */   
/*     */   public synchronized void render() {
/* 281 */     BufferStrategy bs = getBufferStrategy();
/* 283 */     if (bs == null) {
/* 284 */       createBufferStrategy(3);
/*     */       return;
/*     */     } 
/* 288 */     Graphics g = bs.getDrawGraphics();
/* 291 */     g.fillRect(0, 0, 838, 573);
/* 293 */     g.setColor(Color.WHITE);
/* 296 */     if (isInGame && !PauseMenu.isOpen) {
/* 297 */       grassm.render(g);
/* 302 */       player.render(g);
/* 303 */       inventoryMain.render(g);
/* 304 */     } else if (!isInGame && !PauseMenu.isOpen) {
/* 305 */       mainmenu.renderMain(g);
/* 306 */     } else if (isInGame && PauseMenu.isOpen) {
/* 307 */       pauseMenu.renderMain(g);
/*     */     } 
/* 310 */     if (F3Menu.f3menu)
/* 311 */       f3menu.render(g); 
/* 315 */     g.dispose();
/* 316 */     bs.show();
/*     */   }
/*     */   
/*     */   public static void main(String[] args) throws Exception {
/* 323 */     Game game = new Game();
/* 324 */     game.setPreferredSize(new Dimension(838, 573));
/* 325 */     game.setMaximumSize(new Dimension(838, 573));
/* 326 */     game.setMinimumSize(new Dimension(838, 573));
/* 329 */     JFrame frame = new JFrame(title);
/* 330 */     frame.setSize(838, 573);
/* 331 */     frame.setDefaultCloseOperation(3);
/* 332 */     frame.setResizable(false);
/* 333 */     frame.add(game);
/* 334 */     frame.setVisible(true);
/* 335 */     frame.setLocationRelativeTo((Component)null);
/* 336 */     frame.setIconImage(Toolkit.getDefaultToolkit().getImage(
/* 337 */           JFrame.class.getResource("/icon32.png")));
/*     */     try {
/* 342 */       boolean bool = (new File("C:\\Users\\" + 
/* 343 */           System.getProperty("user.name") + 
/* 344 */           "\\AppData\\Roaming\\Beyond Origins")).mkdir();
/* 346 */     } catch (Exception e) {
/* 347 */       e.printStackTrace();
/*     */     } 
/* 352 */     animateThread = new Thread(game);
/* 353 */     timer1Thread = new Thread(game);
/* 358 */     game.start();
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.5_2.jar!\beyondOrigins\main\Game.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */