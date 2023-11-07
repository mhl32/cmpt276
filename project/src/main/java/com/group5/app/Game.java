package com.group5.app;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.Serial;
import java.text.DecimalFormat;

/**
* Loads all elements of this game and initial game state values
* <p>
* The handler class responsible to runs through a loop to update
* all game objects, BufferedImage responsible for all images
* element input.
*
* @author	Marco Lai	Joshua Kim  Jad Alriyabi
* @since	1.0
*/

public class Game extends Canvas implements Runnable{
	
	private static final long serialVersionUID = 1L;
	private boolean isRunning = false;
	private Thread thread;
	Handler handler;
	private Camera camera;
	private SpriteSheet ss;
	private Menu menu;

	private BufferedImage level = null;
	private BufferedImage sprite_sheet = null;
	private BufferedImage floor = null;
	private BufferedImage menu_screen = null;

	public int score = 0;
	public int CoinsCollect = 0;
	public int HEALTH = 100 * 2;
	public final int MaxCoins = 86;
	double playTime;
	DecimalFormat dFormat = new DecimalFormat("#0.00");
	Sound sound = new Sound();


	/**
	 * Creates enumeration to save all game states.
	 */
	public static enum STATE{
		/**
		 * Menu State is the default state starting a new game.
		 */
		MENU,
		/**
		 * Game State activates after the user press the play button.
		 */
		GAME,
		/**
		 * Exit State shows up when user finish the game.
		 */
		EXIT,
		/**
		 * Reset State shows up when user finishes or loses the game.
		 */
		RESET,
		/**
		 * When 'ESC' is pressed by the User to is set to a PAUSE STATE
		 * */
		PAUSE
	};

	/**
	 * Initial default state to menu.
	 */
	public static STATE State = STATE.MENU;

	/**
	 * The main method creates multiple instances
	 * Responsible to updates the x and y coordinates
	 * and process all the rendering of graphics
	 */
	public Game() {
		new Window(1280,720,"Escape the Bank", this);
		start();
		menu = new Menu();
		handler = new Handler();
		camera = new Camera(0,0);
		this.addKeyListener(new KeyInput(handler));
		this.addMouseListener(new MouseInput());
		
		BufferedImageLoader loader = new BufferedImageLoader();
		level = loader.loadImage("/project_level.png");

		sprite_sheet = loader.loadImage("/sprite_sheet.png");

		menu_screen = loader.loadImage("/menu_screen.png");
		
		ss = new SpriteSheet(sprite_sheet);
		floor = ss.grabImage(8, 1, 32, 32);
		
		loadLevel(level);
		sound.playMusic(0);

	}

	/**
	 * This method start our thread.
	 */
	public void start() {
		isRunning = true;
		thread = new Thread(this);
		thread.start();
	}

	/**
	 * This method stop our thread.
	 */
	public void stop() {
		isRunning = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Game loop of this program.
	 */
	public void run() {
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		while(isRunning) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >=1) {
				tick();
				delta--;
				if (Game.State == Game.STATE.GAME) {
					playTime +=(double)1/60;
				}
			}
			render();
			if(System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
			}
		}
		stop();
	}

	/**
	 * Checks the game state and initial tick functions from
	 * camera and handler class.
	 */
	public void tick() {
		if(State == STATE.GAME) {
			for(int i = 0; i < handler.object.size(); i++) {
				if(handler.object.get(i).getId() == ID.Player) {
					camera.tick(handler.object.get(i));
				}
			}
			handler.tick();
		}
	}

	/**
	 * This method responsible for all images rendering.
	 * The bufferStrategy preloads the frame of 3 to reduce latency.
	 * Checks the game state and draw the corresponding images.
	 */
	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		Graphics2D g2d = (Graphics2D) g;

		if(State == STATE.GAME) {
			g2d.translate(-camera.getX(), -camera.getY());
			for (int xx = 0; xx < 2560; xx+=32) {
				for(int yy = 0; yy < 1380; yy+=32) {
					g.drawImage(floor, xx, yy, null);
				}
			}
			handler.render(g);
			g2d.translate(camera.getX(), camera.getY());

			//Drawing the Health Bar, Score, Time
			Font fnt0 = new Font("arial", Font.BOLD, 20);
			g.setFont(fnt0);
			g.setColor(Color.gray);
			g.fillRect(5,5,200,30);

			g.setColor(Color.green);
			g.fillRect(5,5,HEALTH,30);

			g.setColor(Color.black);
			g.drawRect(5,5,200,30);

			g.setColor(Color.white);
			g.drawString("Score: " + score,5,60);

			g.drawString("Time: "+ dFormat.format(playTime), 5, 80);

			g.drawString("Coins: " + CoinsCollect + "/86",5,100);

			if (CoinsCollect == 86) {
				g.setColor(Color.green);
				g.drawString("Exit open!",5,120);
			}

		}else if(State == STATE.MENU) {
			g.drawImage(menu_screen, 0, 0, this);
			menu.render(g,this);
		}else if(State == STATE.EXIT){
			g.drawImage(menu_screen, 0, 0, this);
			menu.render(g,this);
		} else if (State == STATE.RESET) {
			score = 0;
			HEALTH = 100 * 2;
			CoinsCollect = 0;
			playTime = 0;

			handler = new Handler();
			camera = new Camera(0,0);
			this.addKeyListener(new KeyInput(handler));
			this.addMouseListener(new MouseInput());

			loadLevel(level);

			Game.State = Game.STATE.GAME;
		} else if (State == STATE.PAUSE) {
			g.drawImage(menu_screen, 0, 0, this);
			menu.render(g,this);
		}

		g.dispose();
		bs.show();
	}

	/**
	* loadLevel method pass the game map of pixel portable
	* network graphics(PNG), and call handler to process
	* add object function according to the color
	* <p>
	* Barriers = red
	* Player = blue
	* MovingEnemy = green
	* Punishment = magenta
	* RegularReward = yellow
	* BonusReward = cyan
	* Exit = orange
	* <p>
	* @author	Marco Lai
	* @since	1.1
	*/
	public void loadLevel(BufferedImage image) {
		int w = image.getWidth();
		int h = image.getHeight();
		for(int xx = 0; xx < w; xx++) {
			for(int yy = 0; yy< h; yy++) {
				int pixel = image.getRGB(xx, yy);
				int red = (pixel >> 16) & 0xff;
				int green = (pixel >> 8) & 0xff;
				int blue = (pixel) & 0xff;
				
				if(red==255 && green==0 && blue==0)
					handler.addObject(new Barriers(xx*32, yy*32, ID.Barriers, ss));
				if(red==0 && green==0 && blue==255)
					handler.addObject(new Player(xx*32, yy*32, ID.Player, handler, this, ss));
				if(red==0 && green==255 && blue==0)
					handler.addObject(new MovingEnemy(xx*32, yy*32, ID.MovingEnemy, handler, ss));
				if(red==255 && green==0 && blue==255)
					handler.addObject(new Punishment(xx*32, yy*32, ID.Punishment, ss));
				if(red==255 && green==255 && blue==0)
					handler.addObject(new RegularReward(xx*32, yy*32, ID.RegularReward, ss));
				if(red==0 && green==255 && blue==255)
					handler.addObject(new BonusReward(xx*32, yy*32, ID.BonusReward, ss));
				if(red==255 && green==165 && blue==0)
					handler.addObject(new Exit(xx*32, yy*32, ID.Exit, ss));
			}
		}
	}

	/**
	 * Main method to create new game.
	 * @param args		an array of command-line arguments for the application.
	 */
	public static void main( String[] args ){
        new Game();
    }
}
