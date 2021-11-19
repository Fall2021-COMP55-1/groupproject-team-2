import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.Timer;
import acm.graphics.GImage;
import acm.graphics.GRectangle;

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
    private EnemyPack enemyLevelThree;
	private int level;
    
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
    	int level = 3;
    	if(enemyLevelThree == null) {
    		level++;
    		program.switchToTransition(level);
    	}
        enemyLevelThree = new EnemyPack(program, this, 3);
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
        player.update();
        Iterator<Projectile> iter = bullets.iterator();
        while(iter.hasNext()) {
        	Projectile temp = iter.next();
        	temp.update();
        	if(EnemyPack.checkCollision(temp.getImage().getBounds()))
        	if(collision(temp.getImage().getBounds(),player.getBounds())) {
        		player.takedamage();
            	temp.hide();
            	iter.remove();
            }
        	else if(temp.getY() < 0 || temp.getY() > 600) {
        		
        	}
        }
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
        /*        if(player.getPower() == PowerType.POWERSHOT) {
                    
                    System.out.println("Deleting");
                    boolean collided = player.hasCollidedPS(shot);
                    if(collided)
                        player.delete(shot);
                } else {
                    System.out.println("Deleting");
                    boolean collided = player.hasCollidedMS(shot);
                    if(collided)
                        player.delete(shot);
                }*/
            }
        }
         if(key == KeyEvent.VK_ESCAPE) {
            if(paused) {
                paused = false;
                program.switchToSettings();
            }
            else
                paused = true;
        }
    }


	public void changeLevel(int level) {
		// TODO Auto-generated method stub
		this.level = level;
	}
}