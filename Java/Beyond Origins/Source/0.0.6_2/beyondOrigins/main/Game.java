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
/*     */   public static int width;
/*     */   
/*     */   public static int height;
/*     */   
/*     */   public static boolean running = false;
/*     */   
/*     */   public static ImageManager im;
/*     */   
/*     */   public Thread gameThread;
/*     */   
/*     */   public static FileWriter fw1;
/*     */   
/*     */   public static PrintWriter pw1;
/*     */   
/*     */   public static short frames;
/*     */   
/*     */   public static short currentFrames;
/*     */   
/*     */   public static short updates;
/*     */   
/*     */   public static short currentUpdates;
/*     */   
/*  59 */   public static short playerSpawnX = 403;
/*     */   
/*  60 */   public static short playerSpawnY = 270;
/*     */   
/*  63 */   public static String identifer = "This is a BETA BUILD. Report bugs ASAP!";
/*     */   
/*  64 */   public static String copyright = "©2014 Evan Gartley", version = "006B2";
/*     */   
/*  65 */   public static String title = "Beyond Origins 0.0.6 Beta 2", townName = "Lunix";
/*     */   
/*  66 */   public static String save1Path = "C:\\Users\\" + 
/*  67 */     System.getProperty("user.name") + 
/*  68 */     "\\AppData\\Roaming\\Beyond Origins\\saves\\save1.zan";
/*     */   
/*  69 */   public static String save2Path = "C:\\Users\\" + System.getProperty("user.name") + 
/*  70 */     "\\AppData\\Roaming\\Beyond Origins\\saves\\save2.zan";
/*     */   
/*  71 */   public static String save3Path = "C:\\Users\\" + System.getProperty("user.name") + 
/*  72 */     "\\AppData\\Roaming\\Beyond Origins\\saves\\save3.zan";
/*     */   
/*  73 */   public static String dataPath = "C:\\Users\\" + System.getProperty("user.name") + 
/*  74 */     "\\AppData\\Roaming\\Beyond Origins\\data.zan";
/*     */   
/*  77 */   public static Color buttonIdleColor = new Color(255, 255, 255);
/*     */   
/*  78 */   public static Color gameProgressColor = new Color(73, 73, 73);
/*     */   
/*  79 */   public static Color profileInfoColor = new Color(99, 99, 99), skyColor = new Color(86, 
/*  80 */       201, 255);
/*     */   
/*  80 */   public static Color buttonClickedColor = new Color(73, 73, 73);
/*     */   
/*  81 */   public static Color buttonSelectedColor = new Color(236, 210, 120);
/*     */   
/*  84 */   public static Font f3MenuFont = new Font("DejaVu Sans", 0, 12);
/*     */   
/*  85 */   public static Font buttonTextFont = new Font("MoolBoran", 0, 32);
/*     */   
/*  86 */   public static Font profileInfoFont = new Font("MoolBoran", 0, 23);
/*     */   
/*  87 */   public static Font profileNameFont = new Font("MoolBoran", 3, 23);
/*     */   
/*  88 */   public static Font areYouSureFont = new Font("MoolBoran", 1, 62);
/*     */   
/*  89 */   public static Font gameProgressFont = new Font("MoolBoran", 0, 60);
/*     */   
/*  90 */   public static Font playerHUDFont = new Font("CenturyGothic", 3, 
/*  91 */       12);
/*     */   
/*  91 */   public static Font pHUDBar = new Font("CenturyGothic", 0, 10);
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
/* 114 */     loadGfx();
/* 116 */     mainmenu = new MainMenu();
/* 117 */     pauseMenu = new PauseMenu();
/* 118 */     grassm = new GrassMap();
/* 119 */     player = new Player(playerSpawnX, playerSpawnY, playerSpawnX, 
/* 120 */         playerSpawnY);
/* 121 */     td = new TestDummy();
/* 122 */     dialogue = new Dialogue();
/* 123 */     inventoryMain = new Inventory();
/* 126 */     BuildingRender.init();
/* 127 */     Shop.init();
/* 130 */     addKeyListener((KeyListener)new KeyManager());
/* 131 */     addMouseListener((MouseListener)new MouseManager());
/* 132 */     addMouseMotionListener((MouseMotionListener)new MouseMotion());
/*     */   }
/*     */   
/*     */   public static void loadGfx() {
/* 137 */     ImageLoader loader = new ImageLoader();
/* 140 */     playerSheet = loader.load("/player.png");
/* 141 */     terrain1Sheet = loader.load("/terrain1.png");
/* 142 */     mainmenuSheet = loader.load("/mainmenu.png");
/* 143 */     inventorySheet = loader.load("/inventory.png");
/* 144 */     widgetSheet = loader.load("/widgets1.png");
/* 145 */     entitySheet = loader.load("/entities1.png");
/* 146 */     inside1Image = loader.load("/inside1.png");
/* 147 */     logoImage = loader.load("/logo.png");
/* 149 */     im = new ImageManager();
/*     */   }
/*     */   
/*     */   public static void endClick() {
/* 153 */     MouseManager.mousePressed = false;
/*     */   }
/*     */   
/*     */   public static boolean mouseIsPressed() {
/* 157 */     return MouseManager.mousePressed;
/*     */   }
/*     */   
/*     */   public synchronized void start() {
/* 162 */     if (running)
/*     */       return; 
/* 165 */     running = true;
/* 167 */     this.gameThread = new Thread(this);
/* 170 */     this.gameThread.start();
/*     */   }
/*     */   
/*     */   public synchronized void stop() {
/* 175 */     if (!running)
/*     */       return; 
/* 178 */     running = false;
/*     */     try {
/* 180 */       this.gameThread.join();
/* 181 */     } catch (InterruptedException e) {
/* 182 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void run() {
/*     */     try {
/* 188 */       init();
/* 189 */     } catch (IOException e) {
/* 190 */       e.printStackTrace();
/*     */     } 
/* 192 */     long lastTime = System.nanoTime();
/* 193 */     long timer = System.currentTimeMillis();
/* 194 */     double ns = 1.6666666666666666E7D;
/* 195 */     double delta = 0.0D;
/* 196 */     requestFocus();
/* 199 */     while (running) {
/* 200 */       long now = System.nanoTime();
/* 201 */       delta += (now - lastTime) / ns;
/* 202 */       lastTime = now;
/* 203 */       if (delta >= 1.0D) {
/* 204 */         tick();
/* 205 */         updates = (short)(updates + 1);
/* 206 */         delta--;
/*     */       } 
/* 208 */       render();
/* 209 */       frames = (short)(frames + 1);
/* 210 */       if (System.currentTimeMillis() - timer > 1000L) {
/* 211 */         timer += 1000L;
/* 212 */         currentFrames = frames;
/* 213 */         currentUpdates = updates;
/* 214 */         updates = 0;
/* 215 */         frames = 0;
/*     */       } 
/*     */     } 
/* 218 */     stop();
/*     */   }
/*     */   
/*     */   public synchronized void tick() {
/* 223 */     width = getWidth();
/* 224 */     height = getHeight();
/* 227 */     if (isInGame && !PauseMenu.isOpen) {
/* 228 */       if (!StoryText.requested)
/* 230 */         if (!StoryText.requested) {
/* 231 */           playerSpawnX = (short)(width / 2 - 16);
/* 232 */           playerSpawnY = (short)(height / 2 - 16);
/* 233 */           Save.tick();
/* 234 */           inventoryMain.tick();
/* 235 */           player.tick();
/* 236 */           if (dummy)
/* 237 */             td.tick(); 
/*     */         }  
/* 240 */     } else if (!isInGame && !PauseMenu.isOpen) {
/* 241 */       mainmenu.tick();
/* 242 */     } else if (isInGame && PauseMenu.isOpen) {
/* 243 */       pauseMenu.tick();
/*     */     } 
/*     */   }
/*     */   
/*     */   public synchronized void render() {
/* 251 */     BufferStrategy bs = getBufferStrategy();
/* 253 */     if (bs == null) {
/* 254 */       createBufferStrategy(3);
/*     */       return;
/*     */     } 
/* 258 */     Graphics g = bs.getDrawGraphics();
/* 260 */     Graphics2D g2d = (Graphics2D)g;
/* 263 */     g.fillRect(0, 0, 838, 573);
/* 265 */     g.setColor(Color.WHITE);
/* 267 */     g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, 
/* 268 */         RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
/* 271 */     if (isInGame && !PauseMenu.isOpen) {
/* 272 */       if (StoryText.requested) {
/*     */         try {
/* 274 */           StoryText.render(g);
/* 275 */         } catch (InterruptedException e) {
/* 276 */           e.printStackTrace();
/*     */         } 
/*     */       } else {
/* 279 */         grassm.render(g);
/* 280 */         if (dummy)
/* 281 */           td.render(g); 
/* 283 */         player.render(g);
/* 284 */         inventoryMain.render(g);
/*     */       } 
/* 286 */     } else if (!isInGame && !PauseMenu.isOpen) {
/* 287 */       mainmenu.renderMain(g);
/* 288 */     } else if (isInGame && PauseMenu.isOpen) {
/* 289 */       pauseMenu.renderMain(g);
/*     */     } 
/* 292 */     if (F3Menu.f3menu)
/* 293 */       F3Menu.render(g); 
/* 297 */     g.dispose();
/* 298 */     bs.show();
/*     */   }
/*     */   
/*     */   public static void main(String[] args) throws Exception {
/* 305 */     Game game = new Game();
/* 306 */     game.setPreferredSize(new Dimension(838, 573));
/* 307 */     game.setMaximumSize(new Dimension(838, 573));
/* 308 */     game.setMinimumSize(new Dimension(838, 573));
/* 311 */     JFrame frame = new JFrame(title);
/* 312 */     frame.setSize(838, 573);
/* 313 */     frame.setDefaultCloseOperation(3);
/* 314 */     frame.setResizable(true);
/* 315 */     frame.add(game);
/* 316 */     frame.setVisible(true);
/* 317 */     frame.setLocationRelativeTo((Component)null);
/* 318 */     frame.setIconImage(Toolkit.getDefaultToolkit().getImage(
/* 319 */           JFrame.class.getResource("/icon32.png")));
/* 322 */     game.start();
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.6_2.jar!\beyondOrigins\main\Game.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */