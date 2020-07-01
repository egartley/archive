/*     */ package beyondOrigins.main;
/*     */ 
/*     */ import beyondOrigins.files.Logger;
/*     */ import beyondOrigins.files.Save;
/*     */ import beyondOrigins.main.buildings.BuildingRender;
/*     */ import beyondOrigins.main.buildings.Shop;
/*     */ import beyondOrigins.main.entities.Player;
/*     */ import beyondOrigins.main.entities.TestDummy;
/*     */ import beyondOrigins.main.gfx.ImageManager;
/*     */ import beyondOrigins.main.inventory.Inventory;
/*     */ import beyondOrigins.main.maps.GrassMap;
/*     */ import beyondOrigins.main.menus.F3Menu;
/*     */ import beyondOrigins.main.menus.MainMenu;
/*     */ import beyondOrigins.main.menus.PauseMenu;
/*     */ import beyondOrigins.main.story.StoryText;
/*     */ import beyondOrigins.main.threads.Noti;
/*     */ import beyondOrigins.userInput.KeyManager;
/*     */ import beyondOrigins.userInput.MouseManager;
/*     */ import beyondOrigins.userInput.MouseMotion;
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
/*     */   private static String uuid;
/*     */   
/*  43 */   private static String save1Key = "1O222274937592U3";
/*     */   
/*  44 */   private static String save2Key = "062948A75F720091";
/*     */   
/*  44 */   private static String save3Key = "832D409374923902";
/*     */   
/*     */   public Thread gameThread;
/*     */   
/*     */   public static Thread notiThread;
/*     */   
/*     */   public static short frames;
/*     */   
/*     */   public static short currentFrames;
/*     */   
/*  54 */   public static short playerSpawnX = 403;
/*     */   
/*  55 */   public static short playerSpawnY = 270;
/*     */   
/*  58 */   public static String copyright = "©2014 Evan Gartley", version = "009B";
/*     */   
/*  59 */   public static String title = "Beyond Origins 0.0.9 Beta", townName = "Lunix";
/*     */   
/*  60 */   public static String mainDir = "C:\\Users\\" + 
/*  61 */     System.getProperty("user.name") + 
/*  62 */     "\\AppData\\Roaming\\Beyond Origins\\";
/*     */   
/*  63 */   public static String save1Path = String.valueOf(mainDir) + "saves\\save1.zan";
/*     */   
/*  64 */   public static String save2Path = String.valueOf(mainDir) + "saves\\save2.zan", save3Path = String.valueOf(mainDir) + 
/*  65 */     "saves\\save3.zan";
/*     */   
/*  65 */   public static String dataPath = String.valueOf(mainDir) + "data.zan";
/*     */   
/*  66 */   public static String keysPath = String.valueOf(mainDir) + "keys.zan";
/*     */   
/*  69 */   public static Color buttonIdleColor = new Color(255, 255, 255);
/*     */   
/*  70 */   public static Color gameProgressColor = new Color(73, 73, 73);
/*     */   
/*  71 */   public static Color profileInfoColor = new Color(99, 99, 99), skyColor = new Color(86, 
/*  72 */       201, 255);
/*     */   
/*  72 */   public static Color buttonClickedColor = new Color(73, 73, 73);
/*     */   
/*  73 */   public static Color buttonSelectedColor = new Color(236, 210, 120);
/*     */   
/*  76 */   public static Font f3MenuFont = new Font("DejaVu Sans", 0, 12);
/*     */   
/*  77 */   public static Font buttonTextFont = new Font("MoolBoran", 0, 32);
/*     */   
/*  78 */   public static Font profileInfoFont = new Font("MoolBoran", 0, 23);
/*     */   
/*  79 */   public static Font profileNameFont = new Font("MoolBoran", 3, 23);
/*     */   
/*  80 */   public static Font areYouSureFont = new Font("MoolBoran", 1, 62);
/*     */   
/*  81 */   public static Font gameProgressFont = new Font("MoolBoran", 0, 60);
/*     */   
/*  82 */   public static Font playerHUDFont = new Font("CenturyGothic", 0, 12);
/*     */   
/*  83 */   public static Font pHUDBar = new Font("CenturyGothic", 0, 10);
/*     */   
/*  84 */   public static Font questTitleFont = new Font("DejaVu Sans", 1, 12);
/*     */   
/*  85 */   public static Font questDescFont = new Font("DejaVu Sans", 0, 12);
/*     */   
/*     */   public static boolean isInGame = false, saveRequested = false;
/*     */   
/*     */   public static boolean loadRequested = false, isOnMap = true, isLoading = false;
/*     */   
/*     */   public static boolean presenting = true;
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
/*     */   public static BufferedImage creds;
/*     */   
/*     */   public static Logger logger;
/*     */   
/*     */   private static Player player;
/*     */   
/*     */   private static GrassMap grassm;
/*     */   
/*     */   private static MainMenu mainMenu;
/*     */   
/*     */   private static Inventory inv;
/*     */   
/*     */   private static PauseMenu pauseMenu;
/*     */   
/*     */   private static TestDummy td;
/*     */   
/*     */   private static BuildingRender br;
/*     */   
/*     */   private static StoryText storyText;
/*     */   
/*     */   public static STLib st;
/*     */   
/*     */   public void init() {
/* 115 */     logger = new Logger();
/* 116 */     logger.log("Game started");
/* 117 */     loadGfx();
/* 118 */     mainMenu = new MainMenu();
/* 119 */     pauseMenu = new PauseMenu();
/* 120 */     grassm = new GrassMap();
/* 121 */     player = new Player(129, 197, 400, 256);
/* 122 */     td = new TestDummy();
/* 123 */     inv = new Inventory();
/* 124 */     br = new BuildingRender();
/* 125 */     storyText = new StoryText();
/* 126 */     BuildingRender.init();
/* 127 */     Shop.init();
/* 128 */     addKeyListener((KeyListener)new KeyManager());
/* 129 */     addMouseListener((MouseListener)new MouseManager());
/* 130 */     addMouseMotionListener((MouseMotionListener)new MouseMotion());
/*     */   }
/*     */   
/*     */   public static void loadGfx() {
/* 134 */     playerSheet = st.loadImage("/player.png");
/* 135 */     terrain1Sheet = st.loadImage("/terrain1.png");
/* 136 */     mainmenuSheet = st.loadImage("/mainmenu.png");
/* 137 */     inventorySheet = st.loadImage("/inventory.png");
/* 138 */     widgetSheet = st.loadImage("/widgets1.png");
/* 139 */     entitySheet = st.loadImage("/entities1.png");
/* 140 */     inside1Image = st.loadImage("/inside1.png");
/* 141 */     logoImage = st.loadImage("/logo.png");
/* 142 */     creds = st.loadImage("/creds.png");
/* 143 */     im = new ImageManager();
/* 144 */     logger.log("Loaded graphics");
/*     */   }
/*     */   
/*     */   public static void createFolder(String path) {
/* 148 */     if (!(new File(path)).exists()) {
/* 149 */       File folder = new File(path);
/* 150 */       folder.mkdir();
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void endClick() {
/* 155 */     MouseManager.mousePressed = false;
/*     */   }
/*     */   
/*     */   public static boolean mouseIsPressed() {
/* 159 */     return MouseManager.mousePressed;
/*     */   }
/*     */   
/*     */   public void run() {
/* 163 */     init();
/* 164 */     long lastTime = System.nanoTime();
/* 165 */     long timer = System.currentTimeMillis();
/* 166 */     double ns = 1.6666666666666666E7D;
/* 167 */     double delta = 0.0D;
/* 168 */     requestFocus();
/* 169 */     while (running) {
/* 170 */       long now = System.nanoTime();
/* 171 */       delta += (now - lastTime) / ns;
/* 172 */       lastTime = now;
/* 173 */       if (delta >= 1.0D) {
/* 174 */         tick();
/* 175 */         render();
/* 176 */         delta--;
/* 177 */         frames = (short)(frames + 1);
/* 178 */         if (System.currentTimeMillis() - timer > 1000L) {
/* 179 */           timer += 1000L;
/* 180 */           currentFrames = frames;
/* 181 */           frames = 0;
/*     */         } 
/*     */       } 
/*     */       try {
/* 185 */         Thread.sleep(1L);
/* 186 */       } catch (InterruptedException e) {
/* 187 */         e.printStackTrace();
/*     */       } 
/*     */     } 
/* 190 */     logger.log("Stopping the game");
/* 191 */     stop();
/*     */   }
/*     */   
/*     */   public synchronized void start() {
/* 195 */     if (running)
/*     */       return; 
/* 198 */     running = true;
/* 199 */     this.gameThread = new Thread(this);
/* 200 */     this.gameThread.setPriority(1);
/* 201 */     notiThread = new Thread((Runnable)new Noti("noti_thread"));
/* 202 */     notiThread.setPriority(1);
/* 203 */     this.gameThread.start();
/*     */   }
/*     */   
/*     */   public synchronized void stop() {
/* 207 */     if (!running)
/*     */       return; 
/* 210 */     running = false;
/*     */     try {
/* 212 */       notiThread.join();
/* 213 */       this.gameThread.join();
/* 214 */     } catch (InterruptedException e) {
/* 215 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public synchronized void tick() {
/* 220 */     width = getWidth();
/* 221 */     height = getHeight();
/* 222 */     Noti.checkNotify();
/* 223 */     if (isInGame && !PauseMenu.isOpen && 
/* 224 */       !presenting) {
/* 225 */       if (!storyText.requested) {
/* 226 */         playerSpawnX = (short)(width / 2 - 16);
/* 227 */         playerSpawnY = (short)(height / 2 - 16);
/* 228 */         Save.tick();
/* 229 */         inv.tick();
/* 230 */         grassm.tick();
/* 231 */         player.tick();
/* 232 */         if (dummy)
/* 233 */           td.tick(); 
/*     */       } 
/* 236 */     } else if (!isInGame && !PauseMenu.isOpen && 
/* 237 */       !presenting) {
/* 238 */       mainMenu.tick();
/* 239 */     } else if ((!isInGame || !PauseMenu.isOpen || 
/* 240 */       presenting) && 
/* 241 */       presenting) {
/* 242 */       time++;
/* 243 */       if (time >= 180) {
/* 244 */         time = 0;
/* 245 */         presenting = false;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public synchronized void render() {
/* 251 */     BufferStrategy bs = getBufferStrategy();
/* 252 */     if (bs == null) {
/* 253 */       createBufferStrategy(3);
/*     */       return;
/*     */     } 
/* 256 */     Graphics g = bs.getDrawGraphics();
/* 257 */     g.fillRect(0, 0, getWidth(), getHeight());
/* 258 */     g.setColor(Color.white);
/* 259 */     st.enableAntiAliasing(g);
/* 260 */     if (isInGame && !PauseMenu.isOpen && !presenting) {
/* 261 */       if (storyText.requested) {
/*     */         try {
/* 263 */           storyText.render(g);
/* 264 */         } catch (InterruptedException e) {
/* 265 */           e.printStackTrace();
/*     */         } 
/* 267 */         if (isLoading)
/* 268 */           isLoading = false; 
/*     */       } else {
/* 270 */         grassm.render(g);
/* 271 */         if (dummy)
/* 272 */           td.render(g); 
/* 274 */         player.render(g);
/* 275 */         br.render(g);
/* 276 */         player.drawPlayerHUD(g);
/* 277 */         inv.render(g);
/* 278 */         if (isLoading) {
/* 279 */           isLoading = false;
/* 280 */           logger.log("Game entered");
/*     */         } 
/*     */       } 
/* 283 */     } else if (!isInGame && !PauseMenu.isOpen && 
/* 284 */       !presenting) {
/* 285 */       mainMenu.render(g);
/* 286 */     } else if (isInGame && PauseMenu.isOpen && !presenting) {
/* 287 */       pauseMenu.renderMain(g);
/* 288 */     } else if (presenting) {
/* 289 */       g.setColor(Color.black);
/* 290 */       g.fillRect(0, 0, getWidth(), getHeight());
/* 291 */       g.setFont(buttonTextFont);
/* 292 */       fm = g.getFontMetrics(buttonTextFont);
/* 293 */       g.setColor(Color.white);
/* 294 */       g.drawString("egartley Presents", 
/* 295 */           getWidth() / 2 - fm.stringWidth("egartley Presents") / 2, 
/* 296 */           getHeight() / 2);
/*     */     } 
/* 298 */     if (isLoading && !presenting) {
/* 299 */       g.setColor(Color.white);
/* 300 */       g.fillRect(0, 0, width, height);
/* 301 */       g.setColor(Color.black);
/* 302 */       g.setFont(buttonTextFont);
/* 303 */       fm = g.getFontMetrics(buttonTextFont);
/* 304 */       g.drawString("Loading...", 
/* 305 */           width / 2 - fm.stringWidth("Loading...") / 2, 
/* 306 */           height / 2 - 7);
/*     */     } 
/* 308 */     Noti.render(g);
/* 309 */     if (F3Menu.f3menu)
/* 310 */       F3Menu.render(g); 
/* 311 */     g.dispose();
/* 312 */     bs.show();
/*     */   }
/*     */   
/*     */   public static void main(String[] args) throws Exception {
/* 317 */     Game game = new Game();
/* 318 */     st = new STLib();
/* 319 */     game.setPreferredSize(new Dimension(838, 573));
/* 320 */     game.setMaximumSize(new Dimension(838, 573));
/* 321 */     game.setMinimumSize(new Dimension(838, 573));
/* 322 */     frame = new JFrame(title);
/* 323 */     frame.setSize(838, 573);
/* 324 */     frame.setDefaultCloseOperation(3);
/* 325 */     frame.setResizable(false);
/* 326 */     frame.add(game);
/* 327 */     st.centerFrame(frame);
/* 328 */     st.setFrameIcon(frame, "/icon32.png");
/* 329 */     frame.setVisible(true);
/* 330 */     uuid = UUID.randomUUID().toString();
/* 331 */     notiThread = new Thread(game);
/* 332 */     game.start();
/*     */   }
/*     */   
/*     */   public static String getUUID() {
/* 336 */     return uuid;
/*     */   }
/*     */   
/*     */   public static String getSaveKey(int n) {
/* 340 */     if (n == 1)
/* 341 */       return save1Key; 
/* 342 */     if (n == 2)
/* 343 */       return save2Key; 
/* 344 */     if (n == 3)
/* 345 */       return save3Key; 
/* 346 */     if (n == 0)
/* 347 */       return ""; 
/* 349 */     return null;
/*     */   }
/*     */   
/*     */   public static Player getPlayer() {
/* 353 */     return player;
/*     */   }
/*     */   
/*     */   public static MainMenu getMainMenu() {
/* 357 */     return mainMenu;
/*     */   }
/*     */   
/*     */   public static GrassMap getMap() {
/* 361 */     return grassm;
/*     */   }
/*     */   
/*     */   public static StoryText getStoryText() {
/* 365 */     return storyText;
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.9_1.jar!\beyondOrigins\main\Game.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */