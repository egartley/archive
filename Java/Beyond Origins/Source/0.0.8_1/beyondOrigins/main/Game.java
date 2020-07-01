/*     */ package beyondOrigins.main;
/*     */ 
/*     */ import beyondOrigins.files.Save;
/*     */ import beyondOrigins.main.buildings.BuildingRender;
/*     */ import beyondOrigins.main.buildings.Shop;
/*     */ import beyondOrigins.main.entities.Player;
/*     */ import beyondOrigins.main.entities.TestDummy;
/*     */ import beyondOrigins.main.gfx.ImageManager;
/*     */ import beyondOrigins.main.gfx.Notification;
/*     */ import beyondOrigins.main.inventory.Inventory;
/*     */ import beyondOrigins.main.maps.GrassMap;
/*     */ import beyondOrigins.main.menus.F3Menu;
/*     */ import beyondOrigins.main.menus.MainMenu;
/*     */ import beyondOrigins.main.menus.PauseMenu;
/*     */ import beyondOrigins.main.story.StoryText;
/*     */ import beyondOrigins.userInput.KeyManager;
/*     */ import beyondOrigins.userInput.MouseManager;
/*     */ import beyondOrigins.userInput.MouseMotion;
/*     */ import com.emgartley.stlib.STLib;
/*     */ import java.awt.Canvas;
/*     */ import java.awt.Color;
/*     */ import java.awt.Component;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.Font;
/*     */ import java.awt.FontMetrics;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Toolkit;
/*     */ import java.awt.event.KeyListener;
/*     */ import java.awt.event.MouseListener;
/*     */ import java.awt.event.MouseMotionListener;
/*     */ import java.awt.image.BufferStrategy;
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.io.File;
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
/*     */   public Thread gameThread;
/*     */   
/*     */   public static short frames;
/*     */   
/*     */   public static short currentFrames;
/*     */   
/*  48 */   public static short playerSpawnX = 403;
/*     */   
/*  49 */   public static short playerSpawnY = 270;
/*     */   
/*  52 */   public static String copyright = "©2014 Evan Gartley", version = "008";
/*     */   
/*  53 */   public static String title = "Beyond Origins 0.0.8 Beta", townName = "Lunix";
/*     */   
/*  55 */   public static String save1Path = "C:\\Users\\" + 
/*  56 */     System.getProperty("user.name") + 
/*  57 */     "\\AppData\\Roaming\\Beyond Origins\\saves\\save1.zan";
/*     */   
/*  58 */   public static String save2Path = "C:\\Users\\" + System.getProperty("user.name") + 
/*  59 */     "\\AppData\\Roaming\\Beyond Origins\\saves\\save2.zan";
/*     */   
/*  60 */   public static String save3Path = "C:\\Users\\" + System.getProperty("user.name") + 
/*  61 */     "\\AppData\\Roaming\\Beyond Origins\\saves\\save3.zan";
/*     */   
/*  62 */   public static String dataPath = "C:\\Users\\" + System.getProperty("user.name") + 
/*  63 */     "\\AppData\\Roaming\\Beyond Origins\\data.zan";
/*     */   
/*  64 */   public static String keysPath = "C:\\Users\\" + System.getProperty("user.name") + 
/*  65 */     "\\AppData\\Roaming\\Beyond Origins\\keys.zan";
/*     */   
/*  68 */   public static Color buttonIdleColor = new Color(255, 255, 255);
/*     */   
/*  69 */   public static Color gameProgressColor = new Color(73, 73, 73);
/*     */   
/*  70 */   public static Color profileInfoColor = new Color(99, 99, 99), skyColor = new Color(86, 
/*  71 */       201, 255);
/*     */   
/*  71 */   public static Color buttonClickedColor = new Color(73, 73, 73);
/*     */   
/*  72 */   public static Color buttonSelectedColor = new Color(236, 210, 120);
/*     */   
/*  75 */   public static Font f3MenuFont = new Font("DejaVu Sans", 0, 12);
/*     */   
/*  76 */   public static Font buttonTextFont = new Font("MoolBoran", 0, 32);
/*     */   
/*  77 */   public static Font profileInfoFont = new Font("MoolBoran", 0, 23);
/*     */   
/*  78 */   public static Font profileNameFont = new Font("MoolBoran", 3, 23);
/*     */   
/*  79 */   public static Font areYouSureFont = new Font("MoolBoran", 1, 62);
/*     */   
/*  80 */   public static Font gameProgressFont = new Font("MoolBoran", 0, 60);
/*     */   
/*  81 */   public static Font playerHUDFont = new Font("CenturyGothic", 0, 
/*  82 */       12);
/*     */   
/*  82 */   public static Font pHUDBar = new Font("CenturyGothic", 0, 10);
/*     */   
/*  83 */   public static Font questTitleFont = new Font("DejaVu Sans", 1, 12);
/*     */   
/*  84 */   public static Font questDescFont = new Font("DejaVu Sans", 0, 12);
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
/* 100 */   public static Notification gre = new Notification("Graphics have been reloaded!");
/*     */   
/* 101 */   public static Notification fre = new Notification("null");
/*     */   
/* 102 */   public static Notification aut = new Notification("Game has been auto saved!");
/*     */   
/*     */   private static Player player;
/*     */   
/*     */   private static GrassMap grassm;
/*     */   
/*     */   private static MainMenu mainmenu;
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
/* 115 */     st = new STLib();
/* 116 */     loadGfx();
/* 117 */     mainmenu = new MainMenu();
/* 118 */     pauseMenu = new PauseMenu();
/* 119 */     grassm = new GrassMap();
/* 120 */     player = new Player(129, 197, 400, 256);
/* 121 */     td = new TestDummy();
/* 122 */     inv = new Inventory();
/* 123 */     br = new BuildingRender();
/* 124 */     storyText = new StoryText();
/* 125 */     BuildingRender.init();
/* 126 */     Shop.init();
/* 127 */     addKeyListener((KeyListener)new KeyManager());
/* 128 */     addMouseListener((MouseListener)new MouseManager());
/* 129 */     addMouseMotionListener((MouseMotionListener)new MouseMotion());
/*     */   }
/*     */   
/*     */   public static boolean isNotifying() {
/* 133 */     if (gre.rendering || fre.rendering || aut.rendering)
/* 134 */       return true; 
/* 135 */     return false;
/*     */   }
/*     */   
/*     */   public static Notification getActiveNotification() {
/* 139 */     if (gre.rendering)
/* 140 */       return gre; 
/* 141 */     if (fre.rendering)
/* 142 */       return fre; 
/* 143 */     if (aut.rendering)
/* 144 */       return aut; 
/* 145 */     return null;
/*     */   }
/*     */   
/*     */   public void checkNotify() {
/* 149 */     if (gre.isStarted())
/* 150 */       gre.rendering = true; 
/* 151 */     if (fre.isStarted())
/* 152 */       fre.rendering = true; 
/* 153 */     if (aut.isStarted())
/* 154 */       aut.rendering = true; 
/* 155 */     if (isNotifying())
/* 156 */       getActiveNotification().tick(); 
/*     */   }
/*     */   
/*     */   public static void startNotify(Notification n) {
/* 161 */     cancelActive();
/* 162 */     n.start();
/*     */   }
/*     */   
/*     */   public static void cancelActive() {
/* 166 */     if (isNotifying()) {
/* 167 */       getActiveNotification().reset();
/* 168 */       getActiveNotification().cancel();
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void createFolder(String path) {
/* 173 */     if (!(new File(path)).exists())
/* 174 */       boolean bool = (new File(path)).mkdir(); 
/*     */   }
/*     */   
/*     */   public static void loadGfx() {
/* 181 */     playerSheet = st.loadImage("/player.png");
/* 182 */     terrain1Sheet = st.loadImage("/terrain1.png");
/* 183 */     mainmenuSheet = st.loadImage("/mainmenu.png");
/* 184 */     inventorySheet = st.loadImage("/inventory.png");
/* 185 */     widgetSheet = st.loadImage("/widgets1.png");
/* 186 */     entitySheet = st.loadImage("/entities1.png");
/* 187 */     inside1Image = st.loadImage("/inside1.png");
/* 188 */     logoImage = st.loadImage("/logo.png");
/* 189 */     creds = st.loadImage("/creds.png");
/* 190 */     im = new ImageManager();
/*     */   }
/*     */   
/*     */   public static void endClick() {
/* 194 */     MouseManager.mousePressed = false;
/*     */   }
/*     */   
/*     */   public static boolean mouseIsPressed() {
/* 198 */     return MouseManager.mousePressed;
/*     */   }
/*     */   
/*     */   public synchronized void start() {
/* 202 */     if (running)
/*     */       return; 
/* 205 */     running = true;
/* 206 */     this.gameThread = new Thread(this);
/* 207 */     this.gameThread.start();
/*     */   }
/*     */   
/*     */   public synchronized void stop() {
/* 211 */     if (!running)
/*     */       return; 
/* 214 */     running = false;
/*     */     try {
/* 216 */       this.gameThread.join();
/* 217 */     } catch (InterruptedException e) {
/* 218 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void run() {
/* 223 */     init();
/* 224 */     long lastTime = System.nanoTime();
/* 225 */     long timer = System.currentTimeMillis();
/* 226 */     double ns = 1.6666666666666666E7D;
/* 227 */     double delta = 0.0D;
/* 228 */     requestFocus();
/* 229 */     while (running) {
/* 230 */       long now = System.nanoTime();
/* 231 */       delta += (now - lastTime) / ns;
/* 232 */       lastTime = now;
/* 233 */       if (delta >= 1.0D) {
/* 234 */         tick();
/* 235 */         delta--;
/*     */       } 
/* 237 */       render();
/* 238 */       frames = (short)(frames + 1);
/* 239 */       if (System.currentTimeMillis() - timer > 1000L) {
/* 240 */         timer += 1000L;
/* 241 */         currentFrames = frames;
/* 242 */         frames = 0;
/*     */       } 
/*     */     } 
/* 245 */     stop();
/*     */   }
/*     */   
/*     */   public synchronized void tick() {
/* 249 */     width = getWidth();
/* 250 */     height = getHeight();
/* 251 */     checkNotify();
/* 252 */     if (isInGame && !PauseMenu.isOpen && 
/* 253 */       !presenting) {
/* 254 */       if (!storyText.requested) {
/* 255 */         playerSpawnX = (short)(width / 2 - 16);
/* 256 */         playerSpawnY = (short)(height / 2 - 16);
/* 257 */         Save.tick();
/* 258 */         inv.tick();
/* 259 */         grassm.tick();
/* 260 */         player.tick();
/* 261 */         if (dummy)
/* 262 */           td.tick(); 
/*     */       } 
/* 265 */     } else if (!isInGame && !PauseMenu.isOpen && 
/* 266 */       !presenting) {
/* 267 */       mainmenu.tick();
/* 268 */     } else if ((!isInGame || !PauseMenu.isOpen || 
/* 269 */       presenting) && 
/* 270 */       presenting) {
/* 271 */       time++;
/* 272 */       if (time >= 180) {
/* 273 */         time = 0;
/* 274 */         presenting = false;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public synchronized void render() {
/* 280 */     BufferStrategy bs = getBufferStrategy();
/* 281 */     if (bs == null) {
/* 282 */       createBufferStrategy(3);
/*     */       return;
/*     */     } 
/* 285 */     Graphics g = bs.getDrawGraphics();
/* 286 */     g.fillRect(0, 0, getWidth(), getHeight());
/* 287 */     g.setColor(Color.white);
/* 288 */     st.enableAntiAliasing(g);
/* 289 */     if (isInGame && !PauseMenu.isOpen && !presenting) {
/* 290 */       if (storyText.requested) {
/*     */         try {
/* 292 */           storyText.render(g);
/* 293 */         } catch (InterruptedException e) {
/* 294 */           e.printStackTrace();
/*     */         } 
/* 296 */         if (isLoading)
/* 297 */           isLoading = false; 
/*     */       } else {
/* 299 */         grassm.render(g);
/* 300 */         if (dummy)
/* 301 */           td.render(g); 
/* 303 */         player.render(g);
/* 304 */         br.render(g);
/* 305 */         player.drawPlayerHUD(g);
/* 306 */         inv.render(g);
/* 307 */         if (isLoading)
/* 308 */           isLoading = false; 
/*     */       } 
/* 310 */     } else if (!isInGame && !PauseMenu.isOpen && 
/* 311 */       !presenting) {
/* 312 */       mainmenu.render(g);
/* 313 */     } else if (isInGame && PauseMenu.isOpen && !presenting) {
/* 314 */       pauseMenu.renderMain(g);
/* 315 */     } else if (presenting) {
/* 316 */       g.setColor(Color.black);
/* 317 */       g.fillRect(0, 0, getWidth(), getHeight());
/* 318 */       g.setFont(buttonTextFont);
/* 319 */       fm = g.getFontMetrics(buttonTextFont);
/* 320 */       g.setColor(Color.white);
/* 321 */       g.drawString("egartley Presents", 
/* 322 */           getWidth() / 2 - fm.stringWidth("egartley Presents") / 2, 
/* 323 */           getHeight() / 2);
/*     */     } 
/* 325 */     if (isLoading && !presenting) {
/* 326 */       g.setColor(Color.white);
/* 327 */       g.fillRect(0, 0, width, height);
/* 328 */       g.setColor(Color.black);
/* 329 */       g.setFont(buttonTextFont);
/* 330 */       fm = g.getFontMetrics(buttonTextFont);
/* 331 */       g.drawString("Loading...", 
/* 332 */           width / 2 - fm.stringWidth("Loading...") / 2, 
/* 333 */           height / 2 - 7);
/*     */     } 
/* 335 */     if (isNotifying())
/* 336 */       getActiveNotification().render(g); 
/* 337 */     if (F3Menu.f3menu)
/* 338 */       F3Menu.render(g); 
/* 339 */     g.dispose();
/* 340 */     bs.show();
/*     */   }
/*     */   
/*     */   public static void main(String[] args) throws Exception {
/* 345 */     Game game = new Game();
/* 346 */     game.setPreferredSize(new Dimension(838, 573));
/* 347 */     game.setMaximumSize(new Dimension(838, 573));
/* 348 */     game.setMinimumSize(new Dimension(838, 573));
/* 349 */     frame = new JFrame(title);
/* 350 */     frame.setSize(838, 573);
/* 351 */     frame.setDefaultCloseOperation(3);
/* 352 */     frame.setResizable(false);
/* 353 */     frame.add(game);
/* 354 */     frame.setVisible(true);
/* 355 */     frame.setLocationRelativeTo((Component)null);
/* 356 */     frame.setIconImage(Toolkit.getDefaultToolkit().getImage(
/* 357 */           JFrame.class.getResource("/icon32.png")));
/* 358 */     createFolder("C:\\Users\\" + System.getProperty("user.name") + 
/* 359 */         "\\AppData\\Roaming\\Beyond Origins");
/* 360 */     createFolder("C:\\Users\\" + System.getProperty("user.name") + 
/* 361 */         "\\AppData\\Roaming\\Beyond Origins\\saves");
/* 362 */     game.start();
/*     */   }
/*     */   
/*     */   public static Player getPlayer() {
/* 366 */     return player;
/*     */   }
/*     */   
/*     */   public static MainMenu getMainMenu() {
/* 370 */     return mainmenu;
/*     */   }
/*     */   
/*     */   public static GrassMap getMap() {
/* 374 */     return grassm;
/*     */   }
/*     */   
/*     */   public static StoryText getStoryText() {
/* 378 */     return storyText;
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.8_1.jar!\beyondOrigins\main\Game.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */