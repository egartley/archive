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
/*  64 */   public static String copyright = "©2014 Evan Gartley", version = "006B3";
/*     */   
/*  65 */   public static String title = "Beyond Origins 0.0.6 Beta 3", townName = "Lunix";
/*     */   
/*  67 */   public static String save1Path = "C:\\Users\\" + 
/*  68 */     System.getProperty("user.name") + 
/*  69 */     "\\AppData\\Roaming\\Beyond Origins\\saves\\save1.zan";
/*     */   
/*  70 */   public static String save2Path = "C:\\Users\\" + System.getProperty("user.name") + 
/*  71 */     "\\AppData\\Roaming\\Beyond Origins\\saves\\save2.zan";
/*     */   
/*  72 */   public static String save3Path = "C:\\Users\\" + System.getProperty("user.name") + 
/*  73 */     "\\AppData\\Roaming\\Beyond Origins\\saves\\save3.zan";
/*     */   
/*  74 */   public static String dataPath = "C:\\Users\\" + System.getProperty("user.name") + 
/*  75 */     "\\AppData\\Roaming\\Beyond Origins\\data.zan";
/*     */   
/*  78 */   public static Color buttonIdleColor = new Color(255, 255, 255);
/*     */   
/*  79 */   public static Color gameProgressColor = new Color(73, 73, 73);
/*     */   
/*  80 */   public static Color profileInfoColor = new Color(99, 99, 99), skyColor = new Color(86, 
/*  81 */       201, 255);
/*     */   
/*  81 */   public static Color buttonClickedColor = new Color(73, 73, 73);
/*     */   
/*  82 */   public static Color buttonSelectedColor = new Color(236, 210, 120);
/*     */   
/*  85 */   public static Font f3MenuFont = new Font("DejaVu Sans", 0, 12);
/*     */   
/*  86 */   public static Font buttonTextFont = new Font("MoolBoran", 0, 32);
/*     */   
/*  87 */   public static Font profileInfoFont = new Font("MoolBoran", 0, 23);
/*     */   
/*  88 */   public static Font profileNameFont = new Font("MoolBoran", 3, 23);
/*     */   
/*  89 */   public static Font areYouSureFont = new Font("MoolBoran", 1, 62);
/*     */   
/*  90 */   public static Font gameProgressFont = new Font("MoolBoran", 0, 60);
/*     */   
/*  91 */   public static Font playerHUDFont = new Font("CenturyGothic", 3, 
/*  92 */       12);
/*     */   
/*  92 */   public static Font pHUDBar = new Font("CenturyGothic", 0, 10);
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
/*     */   private static BuildingRender br;
/*     */   
/*     */   public static STLib st;
/*     */   
/*     */   public void init() throws IOException {
/* 116 */     st = new STLib();
/* 117 */     loadGfx();
/* 119 */     mainmenu = new MainMenu();
/* 120 */     pauseMenu = new PauseMenu();
/* 121 */     grassm = new GrassMap();
/* 122 */     player = new Player(playerSpawnX, playerSpawnY, 400, 256);
/* 123 */     td = new TestDummy();
/* 124 */     inventoryMain = new Inventory();
/* 125 */     br = new BuildingRender();
/* 128 */     BuildingRender.init();
/* 129 */     Shop.init();
/* 132 */     addKeyListener((KeyListener)new KeyManager());
/* 133 */     addMouseListener((MouseListener)new MouseManager());
/* 134 */     addMouseMotionListener((MouseMotionListener)new MouseMotion());
/*     */   }
/*     */   
/*     */   public static void loadGfx() {
/* 139 */     playerSheet = st.loadImage("/player.png");
/* 140 */     terrain1Sheet = st.loadImage("/terrain1.png");
/* 141 */     mainmenuSheet = st.loadImage("/mainmenu.png");
/* 142 */     inventorySheet = st.loadImage("/inventory.png");
/* 143 */     widgetSheet = st.loadImage("/widgets1.png");
/* 144 */     entitySheet = st.loadImage("/entities1.png");
/* 145 */     inside1Image = st.loadImage("/inside1.png");
/* 146 */     logoImage = st.loadImage("/logo.png");
/* 148 */     im = new ImageManager();
/*     */   }
/*     */   
/*     */   public static void endClick() {
/* 152 */     MouseManager.mousePressed = false;
/*     */   }
/*     */   
/*     */   public static boolean mouseIsPressed() {
/* 156 */     return MouseManager.mousePressed;
/*     */   }
/*     */   
/*     */   public synchronized void start() {
/* 161 */     if (running)
/*     */       return; 
/* 164 */     running = true;
/* 166 */     this.gameThread = new Thread(this);
/* 169 */     this.gameThread.start();
/*     */   }
/*     */   
/*     */   public synchronized void stop() {
/* 174 */     if (!running)
/*     */       return; 
/* 177 */     running = false;
/*     */     try {
/* 179 */       this.gameThread.join();
/* 180 */     } catch (InterruptedException e) {
/* 181 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void run() {
/*     */     try {
/* 187 */       init();
/* 188 */     } catch (IOException e) {
/* 189 */       e.printStackTrace();
/*     */     } 
/* 191 */     long lastTime = System.nanoTime();
/* 192 */     long timer = System.currentTimeMillis();
/* 193 */     double ns = 1.6666666666666666E7D;
/* 194 */     double delta = 0.0D;
/* 195 */     requestFocus();
/* 198 */     while (running) {
/* 199 */       long now = System.nanoTime();
/* 200 */       delta += (now - lastTime) / ns;
/* 201 */       lastTime = now;
/* 202 */       if (delta >= 1.0D) {
/* 203 */         tick();
/* 204 */         updates = (short)(updates + 1);
/* 205 */         delta--;
/*     */       } 
/* 207 */       render();
/* 208 */       frames = (short)(frames + 1);
/* 209 */       if (System.currentTimeMillis() - timer > 1000L) {
/* 210 */         timer += 1000L;
/* 211 */         currentFrames = frames;
/* 212 */         currentUpdates = updates;
/* 213 */         updates = 0;
/* 214 */         frames = 0;
/*     */       } 
/*     */     } 
/* 217 */     stop();
/*     */   }
/*     */   
/*     */   public synchronized void tick() {
/* 222 */     width = getWidth();
/* 223 */     height = getHeight();
/* 226 */     if (isInGame && !PauseMenu.isOpen) {
/* 227 */       if (!StoryText.requested)
/* 229 */         if (!StoryText.requested) {
/* 230 */           playerSpawnX = (short)(width / 2 - 16);
/* 231 */           playerSpawnY = (short)(height / 2 - 16);
/* 232 */           Save.tick();
/* 233 */           inventoryMain.tick();
/* 234 */           player.tick();
/* 235 */           if (dummy)
/* 236 */             td.tick(); 
/*     */         }  
/* 239 */     } else if (!isInGame && !PauseMenu.isOpen) {
/* 240 */       mainmenu.tick();
/* 241 */     } else if (isInGame) {
/*     */     
/*     */     } 
/*     */   }
/*     */   
/*     */   public synchronized void render() {
/* 250 */     BufferStrategy bs = getBufferStrategy();
/* 252 */     if (bs == null) {
/* 253 */       createBufferStrategy(3);
/*     */       return;
/*     */     } 
/* 257 */     Graphics g = bs.getDrawGraphics();
/* 259 */     Graphics2D g2d = (Graphics2D)g;
/* 262 */     g.fillRect(0, 0, 838, 573);
/* 264 */     g.setColor(Color.WHITE);
/* 266 */     g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, 
/* 267 */         RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
/* 270 */     if (isInGame && !PauseMenu.isOpen) {
/* 271 */       if (StoryText.requested) {
/*     */         try {
/* 273 */           StoryText.render(g);
/* 274 */         } catch (InterruptedException e) {
/* 275 */           e.printStackTrace();
/*     */         } 
/*     */       } else {
/* 278 */         grassm.render(g);
/* 279 */         br.render(g);
/* 280 */         if (dummy)
/* 281 */           td.render(g); 
/* 283 */         player.render(g);
/* 284 */         inventoryMain.render(g);
/*     */       } 
/* 286 */     } else if (!isInGame && !PauseMenu.isOpen) {
/* 287 */       mainmenu.render(g);
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
/* 314 */     frame.setResizable(false);
/* 315 */     frame.add(game);
/* 316 */     frame.setVisible(true);
/* 317 */     frame.setLocationRelativeTo((Component)null);
/* 318 */     frame.setIconImage(Toolkit.getDefaultToolkit().getImage(
/* 319 */           JFrame.class.getResource("/icon32.png")));
/* 322 */     game.start();
/*     */   }
/*     */   
/*     */   public static Player getPlayer() {
/* 326 */     return player;
/*     */   }
/*     */   
/*     */   public static MainMenu getMainMenu() {
/* 330 */     return mainmenu;
/*     */   }
/*     */   
/*     */   public static GrassMap getMap() {
/* 334 */     return grassm;
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.6_3.jar!\beyondOrigins\main\Game.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */