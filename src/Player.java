import java.util.*;
import PowerType.java;

public class Player {
    
    private int username;
    private long score;
    private int health;
    private int velocity;
    private PowerType power;
    private int lives;
    private int x;
    private int y;

    public Player(String un){
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
        this.x += x;
        this.y += y;
    }

    void drawPlayer(){

    }

    public int getUsername() {
        return this.username;
    }

    public void setUsername(int username) {
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

    private void setVelocity(int velocity) {
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
}