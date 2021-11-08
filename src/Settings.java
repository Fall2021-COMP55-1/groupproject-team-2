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

public class Settings extends GraphicsPane {
	
	// you will use program to get access to all of the GraphicsProgram calls
	private MainApplication program; 
							

	public Settings(MainApplication app) {
		super();
		

	}

	@Override
	public void showContents() {

	}

	@Override
	public void hideContents() {

	}

	@Override
	public void mousePressed(MouseEvent e) {
	//	GObject obj = program.getElementAt(e.getX(), e.getY());
	//	if (obj == button) {
	//		program.switchToSome();
	//	}
	}
	
	public void actionPerformed(ActionEvent e) {
		
	}

}
