import java.util.ArrayList;

import acm.graphics.GRectangle;

public class EnemyPack {
 ArrayList <Enemy> enemies;
 double dx, dy;
 private MainApplication program;
 double min, max;
 private MainGame game;
 
 EnemyPack(MainApplication app, MainGame pane, int num){
	 program = app;
	 game = pane;
	 min = 800;
	 max = 0;
	 dx = 0.3;
	 
 }

public static boolean checkCollision(GRectangle bounds) {
	// TODO Auto-generated method stub
	return false;
}
}
