import java.awt.Color;
import java.awt.event.MouseEvent;

import acm.graphics.GImage;
import acm.graphics.GObject;

public class MenuPane extends GraphicsPane {
	
	// you will use program to get access to all of the GraphicsProgram calls
	private MainApplication program; 
							
	private GImage background;


	public MenuPane(MainApplication app) {
		super();
		background = new GImage("cloud.gif", 0,0);
		program = app;

	}

	@Override
	public void showContents() {
		program.add(background);
	}

	@Override
	public void hideContents() {
		program.remove(background);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if (obj == background) {
			program.switchToSome();
		}
	}
}
