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
/*     */ import java.io.IOException;
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
/*  59 */   public static short playerSpawnX = 403;
/*     */   
/*  60 */   public static short playerSpawnY = 270;
/*     */   
/*  63 */   public static String copyright = "©2014 Evan Gartley", version = "008";
/*     */   
/*  64 */   public static String title = "Beyond Origins 0.0.8 Beta", townName = "Lunix";
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
/*  75 */   public static String keysPath = "C:\\Users\\" + System.getProperty("user.name") + 
/*  76 */     "\\AppData\\Roaming\\Beyond Origins\\keys.zan";
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
/*  94 */   public static Font questTitleFont = new Font("DejaVu Sans", 1, 12);
/*     */   
/*  95 */   public static Font questDescFont = new Font("DejaVu Sans", 0, 12);
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
/* 121 */     st = new STLib();
/* 122 */     loadGfx();
/* 123 */     mainmenu = new MainMenu();
/* 124 */     pauseMenu = new PauseMenu();
/* 125 */     grassm = new GrassMap();
/* 126 */     player = new Player(129, 197, 400, 256);
/* 127 */     td = new TestDummy();
/* 128 */     inv = new Inventory();
/* 129 */     br = new BuildingRender();
/* 130 */     storyText = new StoryText();
/* 131 */     BuildingRender.init();
/* 132 */     Shop.init();
/* 133 */     addKeyListener((KeyListener)new KeyManager());
/* 134 */     addMouseListener((MouseListener)new MouseManager());
/* 135 */     addMouseMotionListener((MouseMotionListener)new MouseMotion());
/*     */   }
/*     */   
/*     */   public static void createFolder(String path) {
/* 139 */     if (!(new File(path)).exists())
/* 140 */       boolean bool = (new File(path)).mkdir(); 
/*     */   }
/*     */   
/*     */   public static void loadGfx() {
/* 147 */     playerSheet = st.loadImage("/player.png");
/* 148 */     terrain1Sheet = st.loadImage("/terrain1.png");
/* 149 */     mainmenuSheet = st.loadImage("/mainmenu.png");
/* 150 */     inventorySheet = st.loadImage("/inventory.png");
/* 151 */     widgetSheet = st.loadImage("/widgets1.png");
/* 152 */     entitySheet = st.loadImage("/entities1.png");
/* 153 */     inside1Image = st.loadImage("/inside1.png");
/* 154 */     logoImage = st.loadImage("/logo.png");
/* 155 */     im = new ImageManager();
/*     */   }
/*     */   
/*     */   public static void endClick() {
/* 159 */     MouseManager.mousePressed = false;
/*     */   }
/*     */   
/*     */   public static boolean mouseIsPressed() {
/* 163 */     return MouseManager.mousePressed;
/*     */   }
/*     */   
/*     */   public synchronized void start() {
/* 167 */     if (running)
/*     */       return; 
/* 170 */     running = true;
/* 171 */     this.gameThread = new Thread(this);
/* 172 */     this.gameThread.start();
/*     */   }
/*     */   
/*     */   public synchronized void stop() {
/* 176 */     if (!running)
/*     */       return; 
/* 179 */     running = false;
/*     */     try {
/* 181 */       this.gameThread.join();
/* 182 */     } catch (InterruptedException e) {
/* 183 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void run() {
/*     */     try {
/* 189 */       init();
/* 190 */     } catch (IOException e) {
/* 191 */       e.printStackTrace();
/*     */     } 
/* 193 */     long lastTime = System.nanoTime();
/* 194 */     long timer = System.currentTimeMillis();
/* 195 */     double ns = 1.6666666666666666E7D;
/* 196 */     double delta = 0.0D;
/* 197 */     requestFocus();
/* 198 */     while (running) {
/* 199 */       long now = System.nanoTime();
/* 200 */       delta += (now - lastTime) / ns;
/* 201 */       lastTime = now;
/* 202 */       if (delta >= 1.0D) {
/* 203 */         tick();
/* 204 */         delta--;
/*     */       } 
/* 206 */       render();
/* 207 */       frames = (short)(frames + 1);
/* 208 */       if (System.currentTimeMillis() - timer > 1000L) {
/* 209 */         timer += 1000L;
/* 210 */         currentFrames = frames;
/* 211 */         frames = 0;
/*     */       } 
/*     */     } 
/* 214 */     stop();
/*     */   }
/*     */   
/*     */   public synchronized void tick() {
/* 218 */     width = getWidth();
/* 219 */     height = getHeight();
/* 220 */     if (isInGame && !PauseMenu.isOpen && 
/* 221 */       !presenting) {
/* 222 */       if (!storyText.requested && 
/* 223 */         !storyText.requested) {
/* 224 */         playerSpawnX = (short)(width / 2 - 16);
/* 225 */         playerSpawnY = (short)(height / 2 - 16);
/* 226 */         Save.tick();
/* 227 */         inv.tick();
/* 228 */         player.tick();
/* 229 */         if (dummy)
/* 230 */           td.tick(); 
/*     */       } 
/* 233 */     } else if (!isInGame && !PauseMenu.isOpen && 
/* 234 */       !presenting) {
/* 235 */       mainmenu.tick();
/* 236 */     } else if (!isInGame || !PauseMenu.isOpen || 
/* 237 */       presenting) {
/* 239 */       if (presenting) {
/* 240 */         time++;
/* 241 */         if (time >= 180) {
/* 242 */           time = 0;
/* 243 */           presenting = false;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public synchronized void render() {
/* 249 */     BufferStrategy bs = getBufferStrategy();
/* 250 */     if (bs == null) {
/* 251 */       createBufferStrategy(3);
/*     */       return;
/*     */     } 
/* 254 */     Graphics g = bs.getDrawGraphics();
/* 255 */     Graphics2D g2d = (Graphics2D)g;
/* 256 */     g.fillRect(0, 0, getWidth(), getHeight());
/* 257 */     g.setColor(Color.white);
/* 258 */     g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, 
/* 259 */         RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
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
/* 274 */         br.render(g);
/* 275 */         player.render(g);
/* 276 */         inv.render(g);
/* 277 */         if (isLoading)
/* 278 */           isLoading = false; 
/*     */       } 
/* 280 */     } else if (!isInGame && !PauseMenu.isOpen && 
/* 281 */       !presenting) {
/* 282 */       mainmenu.render(g);
/* 283 */     } else if (isInGame && PauseMenu.isOpen && !presenting) {
/* 284 */       pauseMenu.renderMain(g);
/* 285 */     } else if (presenting) {
/* 286 */       g.setColor(Color.black);
/* 287 */       g.fillRect(0, 0, getWidth(), getHeight());
/* 288 */       g.setFont(buttonTextFont);
/* 289 */       fm = g.getFontMetrics(buttonTextFont);
/* 290 */       g.setColor(Color.white);
/* 291 */       g.drawString("egartley Presents", 
/* 292 */           getWidth() / 2 - fm.stringWidth("egartley Presents") / 2, 
/* 293 */           getHeight() / 2);
/*     */     } 
/* 295 */     if (isLoading && !presenting) {
/* 296 */       g.setColor(Color.white);
/* 297 */       g.fillRect(0, 0, width, height);
/* 298 */       g.setColor(Color.black);
/* 299 */       g.setFont(buttonTextFont);
/* 300 */       fm = g.getFontMetrics(buttonTextFont);
/* 301 */       g.drawString("Loading...", 
/* 302 */           width / 2 - fm.stringWidth("Loading...") / 2, 
/* 303 */           height / 2 - 7);
/*     */     } 
/* 305 */     if (F3Menu.f3menu)
/* 306 */       F3Menu.render(g); 
/* 307 */     g.dispose();
/* 308 */     bs.show();
/*     */   }
/*     */   
/*     */   public static void main(String[] args) throws Exception {
/* 313 */     Game game = new Game();
/* 314 */     game.setPreferredSize(new Dimension(838, 573));
/* 315 */     game.setMaximumSize(new Dimension(838, 573));
/* 316 */     game.setMinimumSize(new Dimension(838, 573));
/* 317 */     JFrame frame = new JFrame(title);
/* 318 */     frame.setSize(838, 573);
/* 319 */     frame.setDefaultCloseOperation(3);
/* 320 */     frame.setResizable(false);
/* 321 */     frame.add(game);
/* 322 */     frame.setVisible(true);
/* 323 */     frame.setLocationRelativeTo((Component)null);
/* 324 */     frame.setIconImage(Toolkit.getDefaultToolkit().getImage(
/* 325 */           JFrame.class.getResource("/icon32.png")));
/* 326 */     createFolder("C:\\Users\\" + System.getProperty("user.name") + 
/* 327 */         "\\AppData\\Roaming\\Beyond Origins");
/* 328 */     createFolder("C:\\Users\\" + System.getProperty("user.name") + 
/* 329 */         "\\AppData\\Roaming\\Beyond Origins\\saves");
/* 330 */     game.start();
/*     */   }
/*     */   
/*     */   public static Player getPlayer() {
/* 334 */     return player;
/*     */   }
/*     */   
/*     */   public static MainMenu getMainMenu() {
/* 338 */     return mainmenu;
/*     */   }
/*     */   
/*     */   public static GrassMap getMap() {
/* 342 */     return grassm;
/*     */   }
/*     */   
/*     */   public static StoryText getStoryText() {
/* 346 */     return storyText;
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.8_0.jar!\beyondOrigins\main\Game.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */