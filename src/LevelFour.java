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

public class LevelFour extends GraphicsPane {
	private MainApplication program; 
	private String username;
	private GImage settings;
	private Player player;

	public LevelFour(MainApplication app, String playerName) {
		super();
		settings = new GImage("src/Images/settings gears.png", 700, 50);
		program = app;
		username = playerName;
		player = new Player(playerName, app);
	}

	@Override
	public void showContents() {
		player.drawPlayer(800, 600);
		program.add(settings);
	}

	@Override
	public void hideContents() {
		player.removePlayer();
		program.remove(settings);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if (obj == settings) {
			program.switchToSome();
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		
	}
	
	public void keyPressed(KeyEvent e) {
		if(e.getKeyChar() != KeyEvent.VK_BACK_SPACE) {
			username+= e.getKeyChar();
			text.setLabel(username);
		} else
			if(username.length() > 1) {
				username = username.substring(0,username.length()-2);
				text.setLabel(username);
			} else
				username = "";
				text.setLabel(username);
	}
	
}