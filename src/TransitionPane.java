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

public class TransitionPane extends GraphicsPane {

    // you will use program to get access to all of the GraphicsProgram calls
    private MainApplication program; 


    private GLabel text;
    private GLabel text2;
    private GLabel text3;
    private GImage button;
    int playerScore; 
    int playerHealth;
    
    public TransitionPane(MainApplication app) {
        super();
        program = app;
        text = new GLabel("Level Finished, Congratulations!", 300, 250);
        text2 = new GLabel("Current Score: " + playerScore, 300, 300);
        text3 = new GLabel("Player Health:" + playerHealth, 300, 350);
        button = new GImage("src/Images/continue button.png", program.getWidth()/2-59, program.getHeight()*4/5);
        
     
    }

    @Override
    public void showContents() {
        program.add(text);
        program.add(text2);
        program.add(text3);
        program.add(button);
    }

    @Override
    public void hideContents() {
        program.remove(text);
        program.remove(text2);
        program.remove(button);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        GObject obj = program.getElementAt(e.getX(), e.getY());
        if(obj == button) {
        	program.switchToGame();
        }
    }

    public void actionPerformed(ActionEvent e) {

    }
    

    public void keyPressed(KeyEvent e) {
    	
               
    }

}