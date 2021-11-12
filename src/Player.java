import java.util.*;

import acm.graphics.GImage;


public class Player {
	
	private MainApplication program;
    
    private String username;
    private long score;
    private int health;
    private int velocity;
    private PowerType power;
    private int lives;
    private int x;
    private int y;
    private GImage player;

    public Player(String un, MainApplication ma){
    	program = ma;
        username = un;
        score = 0;
        health = 100;
        velocity = 1;
        lives = 3;
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

    void move(int x, int y){
        player.move(x*velocity, y*velocity);
    }

    void drawPlayer(int x, int y){
    	player = new GImage("src/Images/Android Logo.png", x/2, y/2);
    	program.add(player);
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public long getScore() {
        return this.score;
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

    public void setVelocity(int velocity) {
        this.velocity = velocity;
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

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }

    void increaseUserSpeed(){
        setVelocity(velocity+10);
    }

	public void removePlayer() {
		program.remove(player);
		
	}
}