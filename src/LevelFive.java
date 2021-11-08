import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import acm.graphics.GImage;
import acm.graphics.GRect;
import acm.graphics.GLabel;
import acm.graphics.GLine;
import acm.graphics.GObject;

public class LevelFive extends GraphicsPane {
	
	// you will use program to get access to all of the GraphicsProgram calls
	private MainApplication program; 

	private String username;
	private Player player;
	private GImage settings;

	public LevelFive(MainApplication app, String player_name) {
		super();

		username = player_name;
		player = new Player(username, app);
		settings = new GImage("src/Images/settings gear.png", 700,50);
	}

	@Override
	public void showContents() {
		player.drawPlayer(800, 600);
	}

	@Override
	public void hideContents() {
		player.removePlayer();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if (obj == settings) {
			program.switchToSome();
		}

	}
	
	public void actionPerformed(ActionEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if (obj == settings) {
			program.switchToSettings();
		}
	}
	
	public void keyPressed(KeyEvent e) {
		if(e.getKeyChar() == KeyEvent.VK_LEFT)
			player.move(-1, 0);
		if(e.getKeyChar() == KeyEvent.VK_RIGHT)
			player.move(0, 0);
		if(e.getKeyChar() == KeyEvent.VK_UP)
			player.move(0, 1);
		if(e.getKeyChar() == KeyEvent.VK_DOWN)
			player.move(0, -1);
	}
}
