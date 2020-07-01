/*     */ package beyondOrigins.main;
/*     */ 
/*     */ import beyondOrigins.files.Save;
/*     */ import beyondOrigins.main.buildings.BuildingRender;
/*     */ import beyondOrigins.main.buildings.shop.Shop;
/*     */ import beyondOrigins.main.entities.Player;
/*     */ import beyondOrigins.main.entities.TestDummy;
/*     */ import beyondOrigins.main.gfx.ImageLoader;
/*     */ import beyondOrigins.main.gfx.ImageManager;
/*     */ import beyondOrigins.main.inventory.Inventory;
/*     */ import beyondOrigins.main.maps.GrassMap;
/*     */ import beyondOrigins.main.menus.F3Menu;
/*     */ import beyondOrigins.main.menus.MainMenu;
/*     */ import beyondOrigins.main.menus.PauseMenu;
/*     */ import beyondOrigins.main.story.Dialogue;
/*     */ import beyondOrigins.main.story.StoryText;
/*     */ import beyondOrigins.userInput.KeyManager;
/*     */ import beyondOrigins.userInput.MouseManager;
/*     */ import beyondOrigins.userInput.MouseMotion;
/*     */ import java.awt.Canvas;
/*     */ import java.awt.Color;
/*     */ import java.awt.Component;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.Font;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Graphics2D;
/*     */ import java.awt.RenderingHints;
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
/*     */   public static ImageManager im;
/*     */   
/*     */   public Thread gameThread;
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
/*  61 */   public static short playerSpawnX = 403;
/*     */   
/*  62 */   public static short playerSpawnY = 270;
/*     */   
/*  65 */   public static String identifer = "This is a BETA BUILD. Report bugs ASAP!";
/*     */   
/*  66 */   public static String copyright = "©2014 Evan Gartley", version = "005B6";
/*     */   
/*  67 */   public static String title = "Beyond Origins 0.0.5 Beta 6", townName = "Lunix";
/*     */   
/*  68 */   public static String save1Path = "C:\\Users\\" + 
/*  69 */     System.getProperty("user.name") + 
/*  70 */     "\\AppData\\Roaming\\Beyond Origins\\saves\\save1.zan";
/*     */   
/*  71 */   public static String save2Path = "C:\\Users\\" + System.getProperty("user.name") + 
/*  72 */     "\\AppData\\Roaming\\Beyond Origins\\saves\\save2.zan";
/*     */   
/*  73 */   public static String save3Path = "C:\\Users\\" + System.getProperty("user.name") + 
/*  74 */     "\\AppData\\Roaming\\Beyond Origins\\saves\\save3.zan";
/*     */   
/*  75 */   public static String dataPath = "C:\\Users\\" + System.getProperty("user.name") + 
/*  76 */     "\\AppData\\Roaming\\Beyond Origins\\data.zan";
/*     */   
/*  79 */   public static Color buttonIdleColor = new Color(255, 255, 255);
/*     */   
/*  80 */   public static Color gameProgressColor = new Color(73, 73, 73);
/*     */   
/*  81 */   public static Color profileInfoColor = new Color(99, 99, 99), skyColor = new Color(86, 
/*  82 */       201, 255);
/*     */   
/*  82 */   public static Color buttonClickedColor = new Color(73, 73, 73);
/*     */   
/*  83 */   public static Color buttonSelectedColor = new Color(236, 210, 120);
/*     */   
/*  86 */   public static Font f3MenuFont = new Font("DejaVu Sans", 0, 12);
/*     */   
/*  87 */   public static Font buttonTextFont = new Font("MoolBoran", 0, 32);
/*     */   
/*  88 */   public static Font profileInfoFont = new Font("MoolBoran", 0, 23);
/*     */   
/*  89 */   public static Font profileNameFont = new Font("MoolBoran", 3, 23);
/*     */   
/*  90 */   public static Font areYouSureFont = new Font("MoolBoran", 1, 62);
/*     */   
/*  91 */   public static Font gameProgressFont = new Font("MoolBoran", 0, 60);
/*     */   
/*  92 */   public static Font playerHUDFont = new Font("CenturyGothic", 3, 
/*  93 */       12);
/*     */   
/*  93 */   public static Font pHUDBar = new Font("CenturyGothic", 0, 10);
/*     */   
/*     */   public static boolean isInGame = false, saveRequested = false;
/*     */   
/*     */   public static boolean loadRequested = false, isOnMap = true;
/*     */   
/*     */   public static boolean autoSave = true;
/*     */   
/*     */   public static boolean dummy = false;
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
/* 122 */     loadGfx();
/* 124 */     mainmenu = new MainMenu();
/* 125 */     pauseMenu = new PauseMenu();
/* 126 */     grassm = new GrassMap();
/* 127 */     player = new Player(playerSpawnX, playerSpawnY, playerSpawnX, 
/* 128 */         playerSpawnY);
/* 129 */     td = new TestDummy();
/* 130 */     dialogue = new Dialogue();
/* 131 */     inventoryMain = new Inventory();
/* 134 */     BuildingRender.init();
/* 135 */     Shop.init();
/* 138 */     addKeyListener((KeyListener)new KeyManager());
/* 139 */     addMouseListener((MouseListener)new MouseManager());
/* 140 */     addMouseMotionListener((MouseMotionListener)new MouseMotion());
/*     */   }
/*     */   
/*     */   public static void loadGfx() {
/* 145 */     ImageLoader loader = new ImageLoader();
/* 148 */     playerSheet = loader.load("/player.png");
/* 149 */     terrain1Sheet = loader.load("/terrain1.png");
/* 150 */     mainmenuSheet = loader.load("/mainmenu.png");
/* 151 */     inventorySheet = loader.load("/inventory.png");
/* 152 */     widgetSheet = loader.load("/widgets1.png");
/* 153 */     entitySheet = loader.load("/entities1.png");
/* 154 */     inside1Image = loader.load("/inside1.png");
/* 155 */     logoImage = loader.load("/logo.png");
/* 157 */     im = new ImageManager();
/*     */   }
/*     */   
/*     */   public static void endClick() {
/* 162 */     MouseManager.mousePressed = false;
/*     */   }
/*     */   
/*     */   public static boolean isPressed() {
/* 166 */     return MouseManager.mousePressed;
/*     */   }
/*     */   
/*     */   public static void createFolder(String path) {
/* 170 */     if (!(new File(path)).exists())
/* 171 */       boolean bool = (new File(path)).mkdir(); 
/*     */   }
/*     */   
/*     */   public synchronized void start() {
/* 179 */     if (running)
/*     */       return; 
/* 182 */     running = true;
/* 184 */     this.gameThread = new Thread(this);
/* 187 */     this.gameThread.start();
/*     */   }
/*     */   
/*     */   public synchronized void stop() {
/* 192 */     if (!running)
/*     */       return; 
/* 195 */     running = false;
/*     */     try {
/* 197 */       this.gameThread.join();
/* 198 */     } catch (InterruptedException e) {
/* 199 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void run() {
/*     */     try {
/* 205 */       init();
/* 206 */     } catch (IOException e) {
/* 207 */       e.printStackTrace();
/*     */     } 
/* 209 */     long lastTime = System.nanoTime();
/* 210 */     long timer = System.currentTimeMillis();
/* 211 */     double ns = 1.6666666666666666E7D;
/* 212 */     double delta = 0.0D;
/* 213 */     requestFocus();
/* 216 */     while (running) {
/* 217 */       long now = System.nanoTime();
/* 218 */       delta += (now - lastTime) / ns;
/* 219 */       lastTime = now;
/* 220 */       if (delta >= 1.0D) {
/* 221 */         tick();
/* 222 */         updates = (short)(updates + 1);
/* 223 */         delta--;
/*     */       } 
/* 225 */       render();
/* 226 */       frames = (short)(frames + 1);
/* 227 */       if (System.currentTimeMillis() - timer > 1000L) {
/* 228 */         timer += 1000L;
/* 229 */         currentFrames = frames;
/* 230 */         currentUpdates = updates;
/* 231 */         updates = 0;
/* 232 */         frames = 0;
/*     */       } 
/*     */     } 
/* 235 */     stop();
/*     */   }
/*     */   
/*     */   public synchronized void tick() {
/* 241 */     if (isInGame && !PauseMenu.isOpen) {
/* 242 */       if (!StoryText.requested)
/* 244 */         if (!StoryText.requested) {
/* 245 */           Save.tick();
/* 246 */           inventoryMain.tick();
/* 247 */           player.tick();
/* 248 */           if (dummy)
/* 249 */             td.tick(); 
/*     */         }  
/* 252 */     } else if (!isInGame && !PauseMenu.isOpen) {
/* 253 */       mainmenu.tick();
/* 254 */     } else if (isInGame && PauseMenu.isOpen) {
/* 255 */       pauseMenu.tick();
/*     */     } 
/*     */   }
/*     */   
/*     */   public synchronized void render() {
/* 263 */     BufferStrategy bs = getBufferStrategy();
/* 265 */     if (bs == null) {
/* 266 */       createBufferStrategy(3);
/*     */       return;
/*     */     } 
/* 270 */     Graphics g = bs.getDrawGraphics();
/* 272 */     Graphics2D g2d = (Graphics2D)g;
/* 275 */     g.fillRect(0, 0, 838, 573);
/* 277 */     g.setColor(Color.WHITE);
/* 279 */     g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, 
/* 280 */         RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
/* 283 */     if (isInGame && !PauseMenu.isOpen) {
/* 284 */       if (StoryText.requested) {
/*     */         try {
/* 286 */           StoryText.render(g);
/* 287 */         } catch (InterruptedException e) {
/* 288 */           e.printStackTrace();
/*     */         } 
/*     */       } else {
/* 291 */         grassm.render(g);
/* 292 */         if (dummy)
/* 293 */           td.render(g); 
/* 295 */         player.render(g);
/* 296 */         inventoryMain.render(g);
/*     */       } 
/* 298 */     } else if (!isInGame && !PauseMenu.isOpen) {
/* 299 */       mainmenu.renderMain(g);
/* 300 */     } else if (isInGame && PauseMenu.isOpen) {
/* 301 */       pauseMenu.renderMain(g);
/*     */     } 
/* 304 */     if (F3Menu.f3menu)
/* 305 */       F3Menu.render(g); 
/* 309 */     g.dispose();
/* 310 */     bs.show();
/*     */   }
/*     */   
/*     */   public static void main(String[] args) throws Exception {
/* 317 */     Game game = new Game();
/* 318 */     game.setPreferredSize(new Dimension(838, 573));
/* 319 */     game.setMaximumSize(new Dimension(838, 573));
/* 320 */     game.setMinimumSize(new Dimension(838, 573));
/* 323 */     JFrame frame = new JFrame(title);
/* 324 */     frame.setSize(838, 573);
/* 325 */     frame.setDefaultCloseOperation(3);
/* 326 */     frame.setResizable(false);
/* 327 */     frame.add(game);
/* 328 */     frame.setVisible(true);
/* 329 */     frame.setLocationRelativeTo((Component)null);
/* 330 */     frame.setIconImage(Toolkit.getDefaultToolkit().getImage(
/* 331 */           JFrame.class.getResource("/icon32.png")));
/*     */     try {
/* 336 */       createFolder("C:\\Users\\" + System.getProperty("user.name") + 
/* 337 */           "\\AppData\\Roaming\\Beyond Origins");
/* 340 */       createFolder("C:\\Users\\" + System.getProperty("user.name") + 
/* 341 */           "\\AppData\\Roaming\\Beyond Origins\\versions");
/* 344 */       createFolder("C:\\Users\\" + System.getProperty("user.name") + 
/* 345 */           "\\AppData\\Roaming\\Beyond Origins\\saves");
/* 347 */     } catch (Exception e) {
/* 348 */       e.printStackTrace();
/*     */     } 
/* 352 */     game.start();
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.5_6.jar!\beyondOrigins\main\Game.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */