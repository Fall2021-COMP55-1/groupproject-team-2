import acm.graphics.GImage;

public class Enemy {
	private int xPos;
	private int yPos;
	private int health;
	private MainApplication program;
	private GImage enemy;
	
	public Enemy(int x, int y, MainApplication ma){
	    program = ma;
	    health = 20;
	}
	
	public Enemy(int x, int y, MainApplication app, int ran) {
		// TODO Auto-generated constructor stub
		//ran is random powerup, use ifs and elses for it
	}

	public void draw(int x, int y) {
		enemy = new GImage("", x, y);
		program.add(enemy);
	}
	
	public void attack() {
		
	}
	
	public int getHealth() {
		return health;
	}

	public void dealDamage(int d) {
		health -= d;
	}
	
	public void setX(int xPos) {
		this.xPos = xPos;
	}
	
	public void setY(int yPos) {
		this.yPos = yPos;
	}
	
	public int getX() {
		return this.xPos;
	}
	
	public int getY() {
		return this.yPos;
	}
	
	
}
