import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.Timer;
import acm.graphics.GImage;

public class MainGame extends GraphicsPane implements KeyListener, ActionListener{
	
	private Timer timer;
	ArrayList <Enemy> enemies;
	ArrayList <Projectile> bullets;
	GImage background;
	KeyHandler keys;
	int enemyDx;
	GImage playerSprite;
	Player player;
	private MainApplication program; 
	boolean paused = false;
	
	public MainGame(MainApplication app) {
		super();
		program = app;
		bullets = new ArrayList <Projectile>();
		//playerSprite = new GImage("/COMP55GroupProject/src/Bullets/Android Logo.png", 300, 300);
		player = new Player("test", program, this);
		background = new GImage("src/Images/bg.png", 0,0);
		
	}
	
	
	public void playGame() {
		//keys = new KeyHandler();
		//enemies = new ArrayList <Enemy>();
		
		
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
		program.add(background);
		player.show();
		timer = new Timer(10, this);
		timer.start();
	}

	@Override
	public void hideContents() {
		// TODO Auto-generated method stub
		program.remove(background);
		player.hide();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(paused) {
			return;
		}
		//player.update();
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if(!paused) {
			if(key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) {
				player.move(-10,0);
			}
			if(key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) {
				player.move(10,0);
			}
			if(key == KeyEvent.VK_UP || key == KeyEvent.VK_W) {
				player.move(0,-10);
			}
			if(key == KeyEvent.VK_DOWN || key == KeyEvent.VK_S) {
				player.move(0,10);
			}
			if(key == KeyEvent.VK_SPACE) {
				Projectile shot = player.shoot(player.getPower());
			}
		}
		 if(key == KeyEvent.VK_ESCAPE) {
			if(paused)
				paused = false;
			else
				paused = true;
		}
	}
}
