/*     */ package beyondOrigins.main;
/*     */ 
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
/*     */   public static int width;
/*     */   
/*     */   public static int height;
/*     */   
/*     */   public static boolean running = false;
/*     */   
/*     */   public static ImageManager im;
/*     */   
/*     */   private static FontMetrics fm;
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
/*  62 */   public static short playerSpawnX = 403;
/*     */   
/*  63 */   public static short playerSpawnY = 270;
/*     */   
/*  66 */   public static String copyright = "©2014 Evan Gartley", version = "007";
/*     */   
/*  67 */   public static String title = "Beyond Origins 0.0.7 Beta", townName = "Lunix";
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
/*  78 */   public static String keysPath = "C:\\Users\\" + System.getProperty("user.name") + 
/*  79 */     "\\AppData\\Roaming\\Beyond Origins\\keys.zan";
/*     */   
/*  82 */   public static Color buttonIdleColor = new Color(255, 255, 255);
/*     */   
/*  83 */   public static Color gameProgressColor = new Color(73, 73, 73);
/*     */   
/*  84 */   public static Color profileInfoColor = new Color(99, 99, 99), skyColor = new Color(86, 
/*  85 */       201, 255);
/*     */   
/*  85 */   public static Color buttonClickedColor = new Color(73, 73, 73);
/*     */   
/*  86 */   public static Color buttonSelectedColor = new Color(236, 210, 120);
/*     */   
/*  89 */   public static Font f3MenuFont = new Font("DejaVu Sans", 0, 12);
/*     */   
/*  90 */   public static Font buttonTextFont = new Font("MoolBoran", 0, 32);
/*     */   
/*  91 */   public static Font profileInfoFont = new Font("MoolBoran", 0, 23);
/*     */   
/*  92 */   public static Font profileNameFont = new Font("MoolBoran", 3, 23);
/*     */   
/*  93 */   public static Font areYouSureFont = new Font("MoolBoran", 1, 62);
/*     */   
/*  94 */   public static Font gameProgressFont = new Font("MoolBoran", 0, 60);
/*     */   
/*  95 */   public static Font playerHUDFont = new Font("CenturyGothic", 3, 
/*  96 */       12);
/*     */   
/*  96 */   public static Font pHUDBar = new Font("CenturyGothic", 0, 10);
/*     */   
/*  97 */   public static Font questTitleFont = new Font("DejaVu Sans", 1, 12);
/*     */   
/*  98 */   public static Font questDescFont = new Font("DejaVu Sans", 0, 12);
/*     */   
/*     */   public static boolean isInGame = false, saveRequested = false;
/*     */   
/*     */   public static boolean loadRequested = false, isOnMap = true, isLoading = false;
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
/*     */   public void init() throws IOException {
/* 123 */     st = new STLib();
/* 124 */     loadGfx();
/* 126 */     mainmenu = new MainMenu();
/* 127 */     pauseMenu = new PauseMenu();
/* 128 */     grassm = new GrassMap();
/* 129 */     player = new Player(344, 145, 400, 256);
/* 130 */     td = new TestDummy();
/* 131 */     inv = new Inventory();
/* 132 */     br = new BuildingRender();
/* 133 */     storyText = new StoryText();
/* 136 */     BuildingRender.init();
/* 137 */     Shop.init();
/* 140 */     addKeyListener((KeyListener)new KeyManager());
/* 141 */     addMouseListener((MouseListener)new MouseManager());
/* 142 */     addMouseMotionListener((MouseMotionListener)new MouseMotion());
/*     */   }
/*     */   
/*     */   public static void createFolder(String path) {
/* 146 */     if (!(new File(path)).exists())
/* 147 */       boolean bool = (new File(path)).mkdir(); 
/*     */   }
/*     */   
/*     */   public static void loadGfx() {
/* 155 */     playerSheet = st.loadImage("/player.png");
/* 156 */     terrain1Sheet = st.loadImage("/terrain1.png");
/* 157 */     mainmenuSheet = st.loadImage("/mainmenu.png");
/* 158 */     inventorySheet = st.loadImage("/inventory.png");
/* 159 */     widgetSheet = st.loadImage("/widgets1.png");
/* 160 */     entitySheet = st.loadImage("/entities1.png");
/* 161 */     inside1Image = st.loadImage("/inside1.png");
/* 162 */     logoImage = st.loadImage("/logo.png");
/* 164 */     im = new ImageManager();
/*     */   }
/*     */   
/*     */   public static void endClick() {
/* 168 */     MouseManager.mousePressed = false;
/*     */   }
/*     */   
/*     */   public static boolean mouseIsPressed() {
/* 172 */     return MouseManager.mousePressed;
/*     */   }
/*     */   
/*     */   public synchronized void start() {
/* 177 */     if (running)
/*     */       return; 
/* 180 */     running = true;
/* 182 */     this.gameThread = new Thread(this);
/* 185 */     this.gameThread.start();
/*     */   }
/*     */   
/*     */   public synchronized void stop() {
/* 190 */     if (!running)
/*     */       return; 
/* 193 */     running = false;
/*     */     try {
/* 195 */       this.gameThread.join();
/* 196 */     } catch (InterruptedException e) {
/* 197 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void run() {
/*     */     try {
/* 203 */       init();
/* 204 */     } catch (IOException e) {
/* 205 */       e.printStackTrace();
/*     */     } 
/* 207 */     long lastTime = System.nanoTime();
/* 208 */     long timer = System.currentTimeMillis();
/* 209 */     double ns = 1.6666666666666666E7D;
/* 210 */     double delta = 0.0D;
/* 211 */     requestFocus();
/* 214 */     while (running) {
/* 215 */       long now = System.nanoTime();
/* 216 */       delta += (now - lastTime) / ns;
/* 217 */       lastTime = now;
/* 218 */       if (delta >= 1.0D) {
/* 219 */         tick();
/* 220 */         updates = (short)(updates + 1);
/* 221 */         delta--;
/*     */       } 
/* 223 */       render();
/* 224 */       frames = (short)(frames + 1);
/* 225 */       if (System.currentTimeMillis() - timer > 1000L) {
/* 226 */         timer += 1000L;
/* 227 */         currentFrames = frames;
/* 228 */         currentUpdates = updates;
/* 229 */         updates = 0;
/* 230 */         frames = 0;
/*     */       } 
/*     */     } 
/* 233 */     stop();
/*     */   }
/*     */   
/*     */   public synchronized void tick() {
/* 238 */     width = getWidth();
/* 239 */     height = getHeight();
/* 242 */     if (isInGame && !PauseMenu.isOpen) {
/* 243 */       if (!storyText.requested)
/* 245 */         if (!storyText.requested) {
/* 246 */           playerSpawnX = (short)(width / 2 - 16);
/* 247 */           playerSpawnY = (short)(height / 2 - 16);
/* 248 */           Save.tick();
/* 249 */           inv.tick();
/* 250 */           player.tick();
/* 251 */           if (dummy)
/* 252 */             td.tick(); 
/*     */         }  
/* 255 */     } else if (!isInGame && !PauseMenu.isOpen) {
/* 256 */       mainmenu.tick();
/* 257 */     } else if (isInGame) {
/*     */     
/*     */     } 
/*     */   }
/*     */   
/*     */   public synchronized void render() {
/* 264 */     BufferStrategy bs = getBufferStrategy();
/* 265 */     if (bs == null) {
/* 266 */       createBufferStrategy(3);
/*     */       return;
/*     */     } 
/* 269 */     Graphics g = bs.getDrawGraphics();
/* 270 */     Graphics2D g2d = (Graphics2D)g;
/* 271 */     g.fillRect(0, 0, 838, 573);
/* 272 */     g.setColor(Color.WHITE);
/* 273 */     g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, 
/* 274 */         RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
/* 275 */     if (isInGame && !PauseMenu.isOpen) {
/* 276 */       if (storyText.requested) {
/*     */         try {
/* 278 */           storyText.render(g);
/* 279 */         } catch (InterruptedException e) {
/* 280 */           e.printStackTrace();
/*     */         } 
/* 282 */         if (isLoading)
/* 283 */           isLoading = false; 
/*     */       } else {
/* 285 */         grassm.render(g);
/* 286 */         if (dummy)
/* 287 */           td.render(g); 
/* 289 */         br.render(g);
/* 290 */         player.render(g);
/* 291 */         inv.render(g);
/* 292 */         if (isLoading)
/* 293 */           isLoading = false; 
/*     */       } 
/* 295 */     } else if (!isInGame && !PauseMenu.isOpen) {
/* 296 */       mainmenu.render(g);
/* 297 */     } else if (isInGame && PauseMenu.isOpen) {
/* 298 */       pauseMenu.renderMain(g);
/*     */     } 
/* 300 */     if (isLoading) {
/* 301 */       g.setColor(Color.white);
/* 302 */       g.fillRect(0, 0, width, height);
/* 303 */       g.setColor(Color.black);
/* 304 */       g.setFont(buttonTextFont);
/* 305 */       fm = g.getFontMetrics(buttonTextFont);
/* 306 */       g.drawString("Loading...", 
/* 307 */           width / 2 - fm.stringWidth("Loading...") / 2, 
/* 308 */           height / 2 - 13);
/*     */     } 
/* 310 */     if (F3Menu.f3menu)
/* 311 */       F3Menu.render(g); 
/* 312 */     g.dispose();
/* 313 */     bs.show();
/*     */   }
/*     */   
/*     */   public static void main(String[] args) throws Exception {
/* 319 */     Game game = new Game();
/* 320 */     game.setPreferredSize(new Dimension(838, 573));
/* 321 */     game.setMaximumSize(new Dimension(838, 573));
/* 322 */     game.setMinimumSize(new Dimension(838, 573));
/* 325 */     JFrame frame = new JFrame(title);
/* 326 */     frame.setSize(838, 573);
/* 327 */     frame.setDefaultCloseOperation(3);
/* 328 */     frame.setResizable(false);
/* 329 */     frame.add(game);
/* 330 */     frame.setVisible(true);
/* 331 */     frame.setLocationRelativeTo((Component)null);
/* 332 */     frame.setIconImage(Toolkit.getDefaultToolkit().getImage(
/* 333 */           JFrame.class.getResource("/icon32.png")));
/* 335 */     createFolder("C:\\Users\\" + System.getProperty("user.name") + 
/* 336 */         "\\AppData\\Roaming\\Beyond Origins");
/* 337 */     createFolder("C:\\Users\\" + System.getProperty("user.name") + 
/* 338 */         "\\AppData\\Roaming\\Beyond Origins\\saves");
/* 341 */     game.start();
/*     */   }
/*     */   
/*     */   public static Player getPlayer() {
/* 345 */     return player;
/*     */   }
/*     */   
/*     */   public static MainMenu getMainMenu() {
/* 349 */     return mainmenu;
/*     */   }
/*     */   
/*     */   public static GrassMap getMap() {
/* 353 */     return grassm;
/*     */   }
/*     */   
/*     */   public static StoryText getStoryText() {
/* 357 */     return storyText;
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.7.jar!\beyondOrigins\main\Game.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */