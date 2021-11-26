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
import acm.graphics.GRect;

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
    private EnemyPack enemy;
    private Boss b;
    
    private GImage tempE;
    private GRect shield1;
    private GRect shield2;
    private GRect shield3;
	private int level;
    private int difficulty;
    public MainGame(String username,MainApplication app) {
        super();
        program = app;
        bullets = new ArrayList <Projectile>();
        player = new Player(username, program, this);
        System.out.println(player.getUserName());
        background = new GImage("src/Images/bg2.gif", 0,0);
        background.sendToBack();
    	level = 1;
    	b = new Boss(program, this);
    	tempE = new GImage("src/Images/shot_apple.png", 50, 50);
    }
    
    
    public void playGame() {
    	if(level < 5) {
    		enemy = new EnemyPack(level, difficulty, program);
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
    
    public boolean rectCollision(GRectangle gRectangle, GRectangle gRectangle2) {
    	double minX = gRectangle.getX();
    	double minY = gRectangle.getY();
    	double maxX = minX + gRectangle.getWidth();
    	double maxY = minY + gRectangle.getHeight();
    	
    	if(gRectangle2.getX() > maxX || minX > gRectangle2.getX() + gRectangle2.getWidth()) return false;
    	if(gRectangle2.getY() > maxY || minY > gRectangle2.getY() + gRectangle2.getHeight()) return false;
    	return true;
    }
    
    @Override
    public void showContents() {
        // TODO Auto-generated method stub
        program.add(background);
        player.show();
        b.show();
        program.add(tempE);
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
        for(Projectile p : bullets) {
        	p.update();
        	if(p.getY() < 0) {
        		p.hide();
        	}
        }
        /*Iterator<Shots> iter = bullets.iterator();
        while(iter.hasNext()) {
        	Projectile temp = iter.next();
        	temp.update();
        	if(EnemyPack.checkCollision(temp.getImage().getBounds()))
        	if(rectCollision(temp.getImage().getBounds(),player.getBounds())) {
        		player.takedamage();
            	temp.hide();
            	iter.remove();
            }
        	else if(temp.getY() < 0 || temp.getY() > 600) {
        		
        	}
        }*/
    }

	@Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if(!paused) {
            if(key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) {
                //player.move(-10,0);
                player.updateVelocity(-2, 0);
            }
            if(key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) {
                //player.move(10,0);
            	player.updateVelocity(2, 0);
            }
            if(key == KeyEvent.VK_UP || key == KeyEvent.VK_W) {
                player.updateVelocity(0,-2);
            }
            if(key == KeyEvent.VK_DOWN || key == KeyEvent.VK_S) {
                player.updateVelocity(0,2);
            }
            if(key == KeyEvent.VK_SPACE) {
                bullets.add(player.shoot(player.getPower()));
                System.out.println(player.getUserName());
            }
        }
         if(key == KeyEvent.VK_ESCAPE) {
            if(paused) {
                paused = false;
            }
            else
                paused = true;
            	for(Projectile p : bullets) {
            		p.pause();
            	}
            	program.switchToSettings(this);
            	
        }
    }


	public void changeLevel(int level) {
		// TODO Auto-generated method stub
		this.level = level;
	}
}