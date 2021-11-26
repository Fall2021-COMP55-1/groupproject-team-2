import java.util.ArrayList;

import acm.graphics.GRectangle;

public class EnemyPack {
	 ArrayList <Enemy> enemies;
	 private MainApplication program;
	 double min, max;
	 private int y = 1;
	
	public EnemyPack(int level, int difficulty, MainApplication app) {
		// TODO Auto-generated constructor stub
		program = app;
		int i = 0;
		int ran = (int)(Math.random()*(2+1-1)+1);
		while(i < level*8) {
			if(level < 3)
				enemies.add(new Enemy(50+i*50, 100*y, app));
			else 
				enemies.add(new Enemy(50+i*50, 100*y, app, ran));
		}
	}
	
	public static boolean checkCollision(GRectangle bounds) {
		// TODO Auto-generated method stub
		return false;
	}
}
