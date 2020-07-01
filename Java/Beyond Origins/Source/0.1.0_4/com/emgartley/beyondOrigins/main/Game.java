/*     */ package com.emgartley.beyondOrigins.main;
/*     */ 
/*     */ import com.emgartley.beyondOrigins.files.Logger;
/*     */ import com.emgartley.beyondOrigins.files.Save;
/*     */ import com.emgartley.beyondOrigins.main.buildings.BuildingRender;
/*     */ import com.emgartley.beyondOrigins.main.entities.Entity;
/*     */ import com.emgartley.beyondOrigins.main.entities.Player;
/*     */ import com.emgartley.beyondOrigins.main.gfx.ImageManager;
/*     */ import com.emgartley.beyondOrigins.main.inventory.Inventory;
/*     */ import com.emgartley.beyondOrigins.main.maps.GrassMap;
/*     */ import com.emgartley.beyondOrigins.main.menus.F3Menu;
/*     */ import com.emgartley.beyondOrigins.main.menus.MainMenu;
/*     */ import com.emgartley.beyondOrigins.main.menus.PauseMenu;
/*     */ import com.emgartley.beyondOrigins.main.story.StoryText;
/*     */ import com.emgartley.beyondOrigins.main.threads.Init;
/*     */ import com.emgartley.beyondOrigins.main.threads.Noti;
/*     */ import com.emgartley.beyondOrigins.userInput.KeyManager;
/*     */ import com.emgartley.beyondOrigins.userInput.MouseManager;
/*     */ import com.emgartley.beyondOrigins.userInput.MouseMotion;
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
/*     */   public static Graphics g;
/*     */   
/*     */   private static String uuid;
/*     */   
/*  35 */   private static String save1Key = "1O222274937592U3";
/*     */   
/*  36 */   private static String save2Key = "062948A75F720091";
/*     */   
/*  36 */   private static String save3Key = "832D409374923902";
/*     */   
/*  37 */   public static String loadingStatus = "string_loading_status_default_value";
/*     */   
/*     */   public Thread gameThread;
/*     */   
/*     */   public static Thread notiThread;
/*     */   
/*     */   public static Thread initThread;
/*     */   
/*     */   public static short frames;
/*     */   
/*     */   public static short currentFrames;
/*     */   
/*  47 */   public static short pMidX = 403;
/*     */   
/*  48 */   public static short pMidY = 270;
/*     */   
/*  51 */   public static String copyright = "©2014 Evan Gartley", version = "010B3";
/*     */   
/*  52 */   public static String title = "Beyond Origins 0.1.0 Build 4", townName = "Lunix";
/*     */   
/*  53 */   public static String mainDir = "C:\\Users\\" + 
/*  54 */     System.getProperty("user.name") + 
/*  55 */     "\\AppData\\Roaming\\Beyond Origins\\";
/*     */   
/*  56 */   public static String save1Path = String.valueOf(mainDir) + "saves\\profile1.xml";
/*     */   
/*  57 */   public static String save2Path = String.valueOf(mainDir) + "saves\\profile2.xml", save3Path = String.valueOf(mainDir) + 
/*  58 */     "saves\\profile3.xml";
/*     */   
/*  58 */   public static String dataPath = String.valueOf(mainDir) + "data.zan";
/*     */   
/*  59 */   public static String keysPath = String.valueOf(mainDir) + "keys.zan";
/*     */   
/*  62 */   public static Color buttonIdleColor = new Color(255, 255, 255);
/*     */   
/*  63 */   public static Color gameProgressColor = new Color(73, 73, 73);
/*     */   
/*  64 */   public static Color profileInfoColor = new Color(99, 99, 99), skyColor = new Color(86, 
/*  65 */       201, 255);
/*     */   
/*  65 */   public static Color buttonClickedColor = new Color(73, 73, 73);
/*     */   
/*  66 */   public static Color buttonSelectedColor = new Color(236, 210, 120);
/*     */   
/*  69 */   public static Font f3MenuFont = new Font("DejaVu Sans", 0, 12);
/*     */   
/*  70 */   public static Font buttonTextFont = new Font("MoolBoran", 0, 32);
/*     */   
/*  71 */   public static Font profileInfoFont = new Font("MoolBoran", 0, 23);
/*     */   
/*  72 */   public static Font profileNameFont = new Font("MoolBoran", 3, 23);
/*     */   
/*  73 */   public static Font areYouSureFont = new Font("MoolBoran", 1, 62);
/*     */   
/*  74 */   public static Font gameProgressFont = new Font("MoolBoran", 0, 60);
/*     */   
/*  75 */   public static Font pHUDBar = new Font("CenturyGothic", 0, 10);
/*     */   
/*  76 */   public static Font questTitleFont = new Font("DejaVu Sans", 1, 12);
/*     */   
/*  77 */   public static Font questDescFont = new Font("DejaVu Sans", 0, 12);
/*     */   
/*     */   public static boolean isInGame = false, saveRequested = false;
/*     */   
/*     */   public static boolean loadRequested = false, isOnMap = true, isLoading = false;
/*     */   
/*     */   public static boolean presenting = true, initing = true;
/*     */   
/*     */   public static boolean autoSave = true;
/*     */   
/*     */   public static boolean dummy = false;
/*     */   
/*     */   public static boolean sound = true;
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
/*     */   public static BufferedImage mapImage;
/*     */   
/*     */   public static BufferedImage creds;
/*     */   
/*     */   public static Logger logger;
/*     */   
/*     */   public static GrassMap grassm;
/*     */   
/*     */   public static MainMenu mainMenu;
/*     */   
/*     */   public static Inventory inv;
/*     */   
/*     */   public static PauseMenu pauseMenu;
/*     */   
/*     */   public static BuildingRender br;
/*     */   
/*     */   public static StoryText storyText;
/*     */   
/*     */   public static STLib st;
/*     */   
/*     */   public static void loadGfx() {
/* 105 */     Init.loadGfx();
/*     */   }
/*     */   
/*     */   public static void createFolder(String path) {
/* 109 */     if (!(new File(path)).exists()) {
/* 110 */       File folder = new File(path);
/* 111 */       folder.mkdir();
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void endClick() {
/* 116 */     MouseManager.mousePressed = false;
/*     */   }
/*     */   
/*     */   public static boolean mouseIsPressed() {
/* 120 */     return MouseManager.mousePressed;
/*     */   }
/*     */   
/*     */   public void run() {
/* 124 */     initing = true;
/* 125 */     addKeyListener((KeyListener)new KeyManager());
/* 126 */     addMouseListener((MouseListener)new MouseManager());
/* 127 */     addMouseMotionListener((MouseMotionListener)new MouseMotion());
/* 128 */     render();
/* 129 */     long lastTime = System.nanoTime();
/* 130 */     long timer = System.currentTimeMillis();
/* 131 */     double ns = 1.6666666666666666E7D;
/* 132 */     double delta = 0.0D;
/* 133 */     requestFocus();
/* 134 */     while (running) {
/* 135 */       long now = System.nanoTime();
/* 136 */       delta += (now - lastTime) / ns;
/* 137 */       lastTime = now;
/* 138 */       if (delta >= 1.0D) {
/* 139 */         tick();
/* 140 */         render();
/* 141 */         delta--;
/* 142 */         frames = (short)(frames + 1);
/* 143 */         if (System.currentTimeMillis() - timer > 1000L) {
/* 144 */           timer += 1000L;
/* 145 */           currentFrames = frames;
/* 146 */           frames = 0;
/*     */         } 
/*     */       } 
/*     */       try {
/* 150 */         Thread.sleep(1L);
/* 151 */       } catch (InterruptedException e) {
/* 152 */         e.printStackTrace();
/*     */       } 
/*     */     } 
/* 155 */     logger.log("Stopping the game");
/* 156 */     stop();
/*     */   }
/*     */   
/*     */   public synchronized void start() {
/* 160 */     if (running)
/*     */       return; 
/* 163 */     running = true;
/* 164 */     this.gameThread = new Thread(this);
/* 165 */     this.gameThread.setPriority(1);
/* 166 */     notiThread = new Thread((Runnable)new Noti("thread_noti"));
/* 167 */     notiThread.setPriority(1);
/* 168 */     initThread = new Thread((Runnable)new Init("thread_init"));
/* 169 */     initThread.setPriority(1);
/* 171 */     this.gameThread.start();
/*     */   }
/*     */   
/*     */   public synchronized void stop() {
/* 175 */     if (!running)
/*     */       return; 
/* 178 */     running = false;
/*     */     try {
/* 180 */       notiThread.join();
/* 181 */       this.gameThread.join();
/* 182 */     } catch (InterruptedException e) {
/* 183 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public synchronized void tick() {
/* 188 */     width = getWidth();
/* 189 */     height = getHeight();
/* 190 */     Noti.checkNotify();
/* 191 */     if (isInGame && !PauseMenu.isOpen && !presenting) {
/* 192 */       if (!storyText.requested) {
/* 193 */         pMidX = (short)(width / 2 - 16);
/* 194 */         pMidY = (short)(height / 2 - 16);
/* 195 */         Save.tick();
/* 196 */         inv.tick();
/* 197 */         grassm.tick();
/* 198 */         Entity.player.tick();
/* 199 */         if (dummy)
/* 200 */           Entity.td.tick(); 
/*     */       } 
/* 203 */     } else if (!isInGame && !PauseMenu.isOpen && !presenting && !initing) {
/* 204 */       mainMenu.tick();
/* 205 */     } else if (!isInGame || !PauseMenu.isOpen || presenting) {
/* 207 */       if (presenting) {
/* 208 */         time++;
/* 209 */         if (time >= 180) {
/* 210 */           time = 0;
/* 211 */           presenting = false;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public synchronized void render() {
/* 217 */     BufferStrategy bs = getBufferStrategy();
/* 218 */     if (bs == null) {
/* 219 */       createBufferStrategy(3);
/*     */       return;
/*     */     } 
/* 222 */     g = bs.getDrawGraphics();
/* 223 */     g.fillRect(0, 0, getWidth(), getHeight());
/* 224 */     g.setColor(Color.white);
/* 225 */     st.enableAntiAliasing(g);
/* 227 */     if (!initing) {
/* 228 */       if (isInGame && !PauseMenu.isOpen) {
/* 229 */         inGameRender(g);
/* 230 */       } else if (!isInGame && !PauseMenu.isOpen) {
/* 231 */         mainMenu.render(g);
/* 232 */       } else if (isInGame && PauseMenu.isOpen) {
/* 233 */         pauseMenu.renderMain(g);
/*     */       } 
/* 235 */       Noti.render(g);
/* 236 */       if (F3Menu.f3menu)
/* 237 */         F3Menu.render(g); 
/* 238 */     } else if (initing) {
/* 239 */       g.setColor(Color.black);
/* 240 */       g.fillRect(0, 0, getWidth(), getHeight());
/* 241 */       g.setFont(buttonTextFont);
/* 242 */       fm = g.getFontMetrics(buttonTextFont);
/* 243 */       g.setColor(Color.white);
/* 244 */       g.drawString("egartley proudly presents", 
/* 245 */           getWidth() / 2 - 
/* 246 */           fm.stringWidth("egartley proudly presents") / 2, 
/* 247 */           getHeight() / 2 - 25);
/* 248 */       g.drawString(loadingStatus, 
/* 249 */           getWidth() / 2 - fm.stringWidth(loadingStatus) / 2, 
/* 250 */           getHeight() / 2 + 25);
/*     */     } 
/* 252 */     g.dispose();
/* 253 */     bs.show();
/*     */   }
/*     */   
/*     */   private void inGameRender(Graphics g) {
/* 257 */     if (storyText.requested) {
/*     */       try {
/* 259 */         storyText.render(g);
/* 260 */       } catch (InterruptedException e) {
/* 261 */         e.printStackTrace();
/*     */       } 
/*     */     } else {
/* 264 */       grassm.render(g);
/* 265 */       if (dummy)
/* 266 */         Entity.td.render(g); 
/* 268 */       Entity.player.render(g);
/* 269 */       br.render(g);
/* 270 */       Entity.player.drawPlayerHUD(g);
/* 271 */       inv.render(g);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void main(String[] args) throws Exception {
/* 276 */     Game game = new Game();
/* 277 */     st = new STLib();
/* 278 */     game.setPreferredSize(new Dimension(838, 573));
/* 279 */     game.setMaximumSize(new Dimension(838, 573));
/* 280 */     game.setMinimumSize(new Dimension(838, 573));
/* 281 */     frame = new JFrame(title);
/* 282 */     frame.setSize(838, 573);
/* 283 */     frame.setDefaultCloseOperation(3);
/* 284 */     frame.setResizable(false);
/* 285 */     frame.add(game);
/* 286 */     st.centerFrame(frame);
/* 287 */     st.setFrameIconAbsoulute(frame, String.valueOf(mainDir) + "assets\\icon32.png");
/* 288 */     frame.setVisible(true);
/* 289 */     uuid = UUID.randomUUID().toString();
/* 290 */     game.start();
/*     */   }
/*     */   
/*     */   public static String getUUID() {
/* 294 */     return uuid;
/*     */   }
/*     */   
/*     */   public static int getProgress() {
/* 298 */     if (mainMenu.currentProfile == 1)
/* 299 */       return Profile1.progress; 
/* 300 */     if (mainMenu.currentProfile == 2)
/* 301 */       return Profile2.progress; 
/* 302 */     if (mainMenu.currentProfile == 3)
/* 303 */       return Profile3.progress; 
/* 305 */     return 0;
/*     */   }
/*     */   
/*     */   public static void setProgress(int newProgress) {
/* 310 */     if (mainMenu.currentProfile == 1) {
/* 311 */       Profile1.progress = newProgress;
/* 312 */     } else if (mainMenu.currentProfile == 2) {
/* 313 */       Profile2.progress = newProgress;
/* 314 */     } else if (mainMenu.currentProfile == 3) {
/* 315 */       Profile3.progress = newProgress;
/*     */     } 
/*     */   }
/*     */   
/*     */   public static String getSaveKey(int n) {
/* 320 */     if (n == 1)
/* 321 */       return save1Key; 
/* 322 */     if (n == 2)
/* 323 */       return save2Key; 
/* 324 */     if (n == 3)
/* 325 */       return save3Key; 
/* 326 */     if (n == 0)
/* 327 */       return ""; 
/* 329 */     return null;
/*     */   }
/*     */   
/*     */   public static Player getPlayer() {
/* 333 */     return Entity.player;
/*     */   }
/*     */   
/*     */   public static MainMenu getMainMenu() {
/* 337 */     return mainMenu;
/*     */   }
/*     */   
/*     */   public static GrassMap getMap() {
/* 341 */     return grassm;
/*     */   }
/*     */   
/*     */   public static StoryText getStoryText() {
/* 345 */     return storyText;
/*     */   }
/*     */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.1.0_4.jar!\com\emgartley\beyondOrigins\main\Game.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */