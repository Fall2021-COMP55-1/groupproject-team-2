import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.Timer;
import acm.graphics.GImage;
import acm.graphics.GRect;

public class MainGame extends GraphicsPane implements KeyListener, ActionListener{
    
    private Timer timer;
    ArrayList <Enemy> enemies;
    ArrayList <Shots> bullets;
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
        bullets = new ArrayList <Shots>();
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
    
    public boolean rectCollision(GRect boxA, GRect boxB) {
    	double minX = boxA.getX();
    	double minY = boxA.getY();
    	double maxX = minX + boxA.getWidth();
    	double maxY = minY + boxA.getHeight();
    	
    	if(boxB.getX() > maxX || minX > boxB.getX() + boxB.getWidth()) return false;
    	if(boxB.getY() > maxY || minY > boxB.getY() + boxB.getHeight()) return false;
    	return true;
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
        /*Iterator<Shots> iter = bullets.iterator();
        while(iter.hasNext()) {
        	Shots temp = iter.next();
        	temp.update();
        	if(Collision(temp.getImage().getBounds(),))
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
}