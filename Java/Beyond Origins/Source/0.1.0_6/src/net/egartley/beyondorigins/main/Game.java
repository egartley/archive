package net.egartley.beyondorigins.main;

import java.awt.*;
import java.awt.image.*;
import java.io.*;
import java.util.*;

import javax.imageio.ImageIO;
import javax.swing.*;

import net.egartley.beyondorigins.buildings.BuildingRender;
import net.egartley.beyondorigins.entities.Entity;
import net.egartley.beyondorigins.entities.Player;
import net.egartley.beyondorigins.files.Logger;
import net.egartley.beyondorigins.files.Save;
import net.egartley.beyondorigins.gfx.ImageManager;
import net.egartley.beyondorigins.inventory.Inventory;
import net.egartley.beyondorigins.maps.GrassMap;
import net.egartley.beyondorigins.menus.F3Menu;
import net.egartley.beyondorigins.menus.MainMenu;
import net.egartley.beyondorigins.menus.Overview;
import net.egartley.beyondorigins.menus.PauseMenu;
import net.egartley.beyondorigins.story.StoryText;
import net.egartley.beyondorigins.threads.Init;
import net.egartley.beyondorigins.threads.Noti;
import net.egartley.beyondorigins.userInput.KeyManager;
import net.egartley.beyondorigins.userInput.MouseManager;
import net.egartley.beyondorigins.userInput.MouseMotion;
import tk.egartley.stlib.STLib;

public class Game extends Canvas implements Runnable {

	// core
	public static JFrame frame;
	private static final long serialVersionUID = 1L;
	public static final int HEIGHT = 573;
	public static final int WIDTH = 419;
	public static final int SCALE = 2;
	public static int width, height, time;
	public static boolean running = false;
	public static ImageManager im;
	private static FontMetrics fm;
	public static Graphics g;
	private static String uuid, save1Key = "1O222274937592U3", save2Key = "062948A75F720091",
			save3Key = "832D409374923902";
	public static String loadingStatus = "string_loading_status_default_value";

	// threads
	public Thread gameThread;

	// technical
	public static short frames, currentFrames;

	// map and player interaction
	public static short pMidX = WIDTH - 16, pMidY = (HEIGHT / 2) - 16;

	// strings
	public static String copyright = "© 2017 Evan Gartley", version = "010B6", title = "Beyond Origins 0.1.0 Build 6",
			townName = "Lunix";
	public static String mainDir = "C:\\Users\\" + System.getProperty("user.name")
			+ "\\AppData\\Roaming\\Beyond Origins\\";
	public static String save1Path = mainDir + "saves\\profile1.xml", save2Path = mainDir + "saves\\profile2.xml",
			save3Path = mainDir + "saves\\profile3.xml", dataPath = mainDir + "data.zan",
			keysPath = mainDir + "keys.zan";

	// colors
	public static Color buttonIdleColor = new Color(255, 255, 255), gameProgressColor = new Color(73, 73, 73),
			profileInfoColor = new Color(99, 99, 99), skyColor = new Color(86, 201, 255),
			buttonClickedColor = new Color(73, 73, 73), buttonSelectedColor = new Color(236, 210, 120);

	// fonts
	public static Font f3MenuFont = new Font("DejaVu Sans", Font.PLAIN, 12),
			buttonTextFont = new Font("Arial", Font.BOLD, 24), profileInfoFont = new Font("Arial", Font.PLAIN, 23),
			profileNameFont = new Font("Arial", Font.BOLD + Font.ITALIC, 23),
			areYouSureFont = new Font("Arial", Font.BOLD, 62), gameProgressFont = new Font("Arial", Font.PLAIN, 60),
			pHUDBar = new Font("CenturyGothic", Font.PLAIN, 10),
			questTitleFont = new Font("DejaVu Sans", Font.BOLD, 12),
			questDescFont = new Font("DejaVu Sans", Font.PLAIN, 12);

	// identifers
	public static boolean isInGame = false, saveRequested = false, loadRequested = false, isOnMap = true,
			isLoading = false, initing = true, overviewing = false;

	// options
	public static boolean autoSave = true, dummy = false, sound = true;

	// images (actual)
	public static BufferedImage playerSheet, terrain1Sheet, mainmenuSheet, inventorySheet, widgetSheet, entitySheet,
			logoImage, inside1Image, mapImage;
	public static BufferedImage creds, mapOverview;

	// notifications

	public static Logger logger;
	public static GrassMap grassm;
	public static MainMenu mainMenu;
	public static Inventory inv;
	public static PauseMenu pauseMenu;
	public static BuildingRender br;
	public static StoryText storyText;
	public static STLib st;

	public static void loadGfx() {
		mapImage = loadImage(mainDir + "assets\\grassMap.png");
		playerSheet = loadImage(mainDir + "assets\\player.png");
		terrain1Sheet = loadImage(mainDir + "assets\\terrain1.png");
		mainmenuSheet = loadImage(mainDir + "assets\\mainmenu.png");
		inventorySheet = loadImage(mainDir + "assets\\inventory.png");
		widgetSheet = loadImage(mainDir + "assets\\widgets1.png");
		entitySheet = loadImage(mainDir + "assets\\entities1.png");
		inside1Image = loadImage(mainDir + "assets\\inside1.png");
		logoImage = loadImage(mainDir + "assets\\logo.png");
		creds = loadImage(mainDir + "assets\\creds.png");
		mapOverview = loadImage(mainDir + "assets\\mapOverview.png");
		im = new ImageManager();
		logger.log("Loaded graphics");
	}

	private static BufferedImage loadImage(String path) {
		try {
			BufferedImage reImage = ImageIO.read(new File(path));
			return reImage;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void createFolder(String path) {
		if (!new File(path).exists()) {
			File folder = new File(path);
			folder.mkdir();
		}
	}

	public static void endClick() {
		MouseManager.isMousePressedDown = false;
	}

	public static boolean mouseIsPressed() {
		return MouseManager.isMousePressedDown;
	}

	@SuppressWarnings("unused")
	public void run() {
		initing = true;
		Init inti = new Init();
		Noti noti = new Noti();
		this.addKeyListener(new KeyManager());
		this.addMouseListener(new MouseManager());
		this.addMouseMotionListener(new MouseMotion());
		render();
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		double ns = 16666666.666666666;
		double delta = 0.0D;
		requestFocus();
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			if (delta >= 1.0D) {
				tick();
				render();
				delta -= 1.0D;
				frames += 1;
				if (System.currentTimeMillis() - timer > 1000L) {
					timer += 1000L;
					currentFrames = frames;
					frames = 0;
				}
			}
			try {
				Thread.sleep(1L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		Game.logger.log("Stopping the game");
		stop();
	}

	public synchronized void start() {
		if (running) {
			return;
		}
		running = true;
		this.gameThread = new Thread(this);
		this.gameThread.setPriority(1);

		this.gameThread.start();
	}

	public synchronized void stop() {
		if (!running) {
			return;
		}
		running = false;
		try {
			this.gameThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public synchronized void tick() {
		width = getWidth();
		height = getHeight();
		if (isInGame && !PauseMenu.isOpen) {
			if (!storyText.requested) {
				if (overviewing) {

				} else {
					pMidX = (short) (width / 2 - 16);
					pMidY = (short) (height / 2 - 16);
					Save.tick();
					inv.tick();
					grassm.tick();
					Entity.player.tick();
					if (dummy) {
						Entity.td.tick();
					}
				}
			}
		} else if (!isInGame && !PauseMenu.isOpen && !initing) {
			mainMenu.tick();
		} else if (isInGame && PauseMenu.isOpen) {

		}
	}

	public synchronized void render() {
		// main render method
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.white);
		st.enableAntiAliasing(g);

		if (!initing) {
			if (isInGame && !PauseMenu.isOpen) {
				inGameRender(g);
			} else if (!isInGame && !PauseMenu.isOpen) {
				mainMenu.render(g);
			} else if (isInGame && PauseMenu.isOpen) {
				pauseMenu.renderMain(g);
			}
			Noti.render(g);
			if (F3Menu.f3menu)
				F3Menu.render(g);
		} else if (initing) {
			g.setColor(Color.black);
			g.fillRect(0, 0, getWidth(), getHeight());
			g.setFont(buttonTextFont);
			fm = g.getFontMetrics(buttonTextFont);
			g.setColor(Color.white);
			g.drawString("egartley proudly presents",
					getWidth() / 2 - (fm.stringWidth("egartley proudly presents") / 2), getHeight() / 2 - 25);
			g.drawString(loadingStatus, getWidth() / 2 - (fm.stringWidth(loadingStatus) / 2), getHeight() / 2 + 25);
		}
		g.dispose();
		bs.show();
	}

	private void inGameRender(Graphics g) {
		// rendering while not in a menu
		if (storyText.requested) {
			try {
				storyText.render(g);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else {
			if (overviewing) {
				Overview.render(g);
			} else {
				grassm.render(g);
				if (dummy) {
					Entity.td.render(g);
				}
				br.render(g);
				Entity.player.render(g);
				Entity.player.drawPlayerHUD(g);
				inv.render(g);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		Game game = new Game();
		st = new STLib();
		game.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT));
		game.setMaximumSize(new Dimension(WIDTH * SCALE, HEIGHT));
		game.setMinimumSize(new Dimension(WIDTH * SCALE, HEIGHT));
		frame = new JFrame(title);
		frame.setSize(WIDTH * SCALE, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.add(game);
		st.centerFrame(frame);
		st.setAbsoluteFrameIcon(frame, mainDir + "assets\\icon32.png");
		frame.setVisible(true);
		uuid = UUID.randomUUID().toString();
		game.start();
	}

	public static String getUUID() {
		// returns session uuid
		return uuid;
	}

	public static int getProgress() {
		if (mainMenu.currentProfile == 1) {
			return Profile1.progress;
		} else if (mainMenu.currentProfile == 2) {
			return Profile2.progress;
		} else if (mainMenu.currentProfile == 3) {
			return Profile3.progress;
		} else {
			return 0;
		}
	}

	public static void setProgress(int newProgress) {
		// sets progress for current profile
		if (mainMenu.currentProfile == 1) {
			Profile1.progress = newProgress;
		} else if (mainMenu.currentProfile == 2) {
			Profile2.progress = newProgress;
		} else if (mainMenu.currentProfile == 3) {
			Profile3.progress = newProgress;
		}
	}

	public static String getSaveKey(int n) {
		// returns encrytions key for save 1, 2 or 3 (n)
		if (n == 1) {
			return save1Key;
		} else if (n == 2) {
			return save2Key;
		} else if (n == 3) {
			return save3Key;
		} else if (n == 0) {
			return "";
		}
		return null;
	}

	public static Player getPlayer() {
		return Entity.player;
	}

	public static MainMenu getMainMenu() {
		return mainMenu;
	}

	public static GrassMap getMap() {
		return grassm;
	}

	public static StoryText getStoryText() {
		return storyText;
	}

}