import java.util.*;

import acm.graphics.GImage;
import acm.graphics.GLabel;


public class Player {
	
	private MainApplication program;
    private MainGame game;
    private GLabel username;
    private long score;
    private int health;
    private int velocity;
    private PowerType power;
    private int lives;
    private double x, dx, dy;
    private double y;
    private GImage ship;
    double maxSpeed = 30;
    boolean isMoving = false;

    public Player(String un, MainApplication ma, MainGame gam){
    	program = ma;
        username = new GLabel (un,280, 500);
        score = 0;
        health = 100;
        velocity = 1;
        lives = 3;
        game = gam;
        ship = new GImage ("src/Images/Player.png",280,550);
    }

    private Projectile shoot(PowerType p){
        Projectile proj;
        if(p == null){
            proj  = new Projectile(PowerType.NONE);
        } else {
            proj = new Projectile(p);
        }
        
        return proj;
    }

    public void setScore(long score) {
        this.score = score;
    }

    public int getHealth() {
        return this.health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getVelocity() {
        return this.velocity;
    }

    public void updateVelocity(double x, double y) {
    	if(dx == 0 && x > 0) {
    		dx = 30;
    		return;
    	}
    	if(dx == 0 && x < 0) {
    		dx =  -30;
    		return;
    	}
       dx += x;
       dy += y;
       if(maxSpeed < dx) {
    	   dx = maxSpeed;
       }
       if(maxSpeed < dy) {
    	   dy = maxSpeed;
       }
    }

    public PowerType getPower() {
        return this.power;
    }

    public void setPower(PowerType power) {
        this.power = power;
    }

    public int getLives() {
        return this.lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

	public void hide() {
		program.remove(ship);
		program.remove(username);
		
	}
	
	public void show() {
		program.add(ship);
		program.add(username);
	}
	
	public void update() {
		if(ship.getX()+dx < 0) {
			dx = 0;
			ship.setLocation(0, ship.getY());
		}
		if(ship.getX() + ship.getWidth() + dx > 800) {
			dx = 0;
			ship.setLocation(800 - ship.getWidth(), ship.getY());
		}
		ship.move(dx, dy);
		username.move(dx, dy);
		if(isMoving || (dx == 0 && dy == 0)) {
			return;
		}
		if(dx > 0) {
			dx = dx - 5;
		}
		else {
			dx = dx + 5;
		}
		if(dx < 3 && dx > -3) {
			dx = 0;
		}
	}
	
	public void updateMoving(boolean x) {
		isMoving = x;
		
	}
}