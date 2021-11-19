import java.util.*;

import acm.graphics.GImage;
import acm.graphics.GLabel;


public class Player {
	
	private MainApplication program;
    private MainGame game;
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
        score = 0;
        health = 100;
        velocity = 1;
        lives = 3;
        game = gam;
        ship = new GImage ("src/Images/Player.png",280,550);
        x = ship.getX();
        y = ship.getY();
    }

    public Shots shoot(PowerType p){
    	System.out.println("Shooting");
    	p = PowerType.TRIPLESHOT;
        Shots shot = new Shots(p, ship.getX() + ship.getWidth()/2 - 32, ship.getY() - 2*ship.getHeight() - ship.getHeight() - 5, program);
       
        return shot;
    }
    
    public void delete(Projectile proj) {
    	if(shots.contains(proj)) {
    		System.out.println("deleting proj");
    		shots.remove(proj);
    		proj.remove();
    	}
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
    		dx = 6;
    		return;
    	}
    	if(dx == 0 && x < 0) {
    		dx =  -6;
    		return;
    	}
        if(dy == 0 && y > 0) {
    			dy = 6;
    			return;
       }
       if(dy == 0 && y < 0) {
    			dy =  -6;
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
		
	}
	
	public void show() {
		program.add(ship);
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
		if(ship.getY()+dy < 0) {
			dy = 0;
			ship.setLocation(ship.getX(), 0);
		}
		if(ship.getY() + ship.getHeight() + dy > 600) {
			dy = 0;
			ship.setLocation(ship.getX(),600 - ship.getHeight() );
		}
		ship.move(dx, dy);
		if(isMoving || (dx == 0 && dy == 0)) {
			return;
		}
		if(dx > 0) {
			dx = dx - 0.5;
		}
		else {
			dx = dx + 0.5;
		}
		if(dx < 1 && dx > -1) {
			dx = 0;
		}
		if(dy > 0) {
			dy = dy - 0.5;
		}
		else {
			dy = dy + 0.5;
		}
		if(dy < 1 && dy > -1) {
			dy = 0;
		}

	}
	
	public void updateMoving(boolean x) {
		isMoving = x;
		
	}
	
	public void move(int x, int y) {
		if(this.x <= 800 - ship.getWidth() && this.x >= 0) {
			System.out.println("("+ this.x + ", " + this.y + ") " + x);
			this.x += x;
			if(this.x < 0){
				this.x = 0;
			} else if(this.x > 800 - ship.getWidth()) {
				this.x = 800-ship.getWidth();
			}
		}
		if(this.y <= 600 - ship.getHeight() && this.y >= 400) {
			System.out.println("("+ this.x + ", " + this.y + ") " + y);
			this.y += y;
			if(this.y < 400){
				this.y = 400;
			} else if(this.y > 600 - ship.getHeight()) {
				this.y = 600-ship.getHeight();
			}
		} 
		
		ship.setLocation(this.x, this.y);
	}

<<<<<<< HEAD
	public boolean hasCollidedPS(Projectile shot) {
		// TODO Auto-generated method stub
		System.out.println("Shot coord" + shot.getXPos() + " " + shot.getYPos());
		if(shot.getYPos() < 0) {
			System.out.println("Colliding");
			return true;
		}
		return false;
	}
	
	public boolean hasCollidedMS(Projectile shot) {	
		// TODO Auto-generated method stub
		System.out.println("Shot coord" + shot.getXPos() + " " + shot.getYPos());
		if(shot.getYPos() < 0) {
			System.out.println("Colliding");
			return true;
		}
		return false;
	}

	public void takedamage() {
		// TODO Auto-generated method stub
		
	}

	public Object getBounds() {
		// TODO Auto-generated method stub
		return ship.getBounds();
	}
=======
>>>>>>> branch 'main' of https://github.com/Fall2021-COMP55-1/groupproject-team-2.git
}