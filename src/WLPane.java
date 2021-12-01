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


public class WLPane extends GraphicsPane {

    // you will use program to get access to all of the GraphicsProgram calls
    private MainApplication program; 

    
    private GLabel lose;
    private GLabel win;
    private GImage button;
    private GImage loseImage;
    private GImage winImage;
    //state of whether player lost or won
    //if lost show lost image
    //if won show won image
    
    public WLPane(MainApplication app) {
    	super();
    	loseImage = new GImage("src/Images/lostImage.jpg");
    	loseImage.sendToBack();
    	program = app;
    	
    	lose = new GLabel("YOU LOST", 300, 250);
    	win = new GLabel("YOU WON", 300, 350);

        button = new GImage("src/Images/continue button.png", program.getWidth()/2-59, program.getHeight()*4/5);
    }

    @Override
    public void showContents() {
    	program.add(loseImage);
        program.add(winImage);
        program.add(lose);
        program.add(win);
        program.add(button);
        
    }

    @Override
    public void hideContents() {
        program.remove(lose);
        program.remove(win);
        program.remove(button);
        program.remove(loseImage);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    public void actionPerformed(ActionEvent e) {

    }
    

    public void keyPressed(KeyEvent e) {
    	
               
    }

}
