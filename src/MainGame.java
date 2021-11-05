import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import acm.graphics.GImage;

public class MainGame extends GraphicsPane {
	
	long startTime = System.nanoTime();
	long tickTime = 1000000000/60;
	long lastTick = System.nanoTime();
	boolean gameOver = false;
	ArrayList <Enemy> enemies;
	ArrayList <Projectile> bullets;
	GImage background;
	KeyHandler keys;
	int enemyDx;
	GImage playerSprite;
	Player player;
	private MainApplication program; 
	
	public MainGame(MainApplication app) {
		super();
		program = app;
	}
	
	
	public void playGame() {
		keys = new KeyHandler();
		enemies = new ArrayList <Enemy>();
		bullets = new ArrayList <Projectile>();
		playerSprite = new GImage("/COMP55GroupProject/src/Bullets/Android Logo.png", 300, 300);
		player = new Player("test");
		player.setVelocity(4);
		while(!gameOver){
			if(System.nanoTime() - lastTick > tickTime) {
				updatePlayer();
				lastTick = System.nanoTime();
			}
		}
	}
	
	public void updatePlayer() {
	
		if(keys.keyDown(KeyEvent.VK_LEFT)) {
			playerSprite.move(0 - player.getVelocity(), 0);
		}
		else if(keys.keyDown(KeyEvent.VK_RIGHT)) {
			playerSprite.move(player.getVelocity(), 0);
		}
	}
	
	@Override
	public void showContents() {
		// TODO Auto-generated method stub

	}

	@Override
	public void hideContents() {
		// TODO Auto-generated method stub

	}

}
