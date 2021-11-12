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

public class MenuPane extends GraphicsPane {

    // you will use program to get access to all of the GraphicsProgram calls
    private MainApplication program; 

    private GImage background;
    private GImage title;
    private GImage button;
    private GRect textbox;
    private GLabel text;
    private GLine textline;
    private String username = " ";

    public MenuPane(MainApplication app) {
        super();

        String filename = "src/Images/cloud.gif";
        background = new GImage(filename, 0,0);
        program = app;
        title = new GImage("src/Images/title.png", program.getWidth()/2 - 233, program.getHeight()/5-(150/5));
        title.sendToFront();
        button = new GImage("src/Images/continue button.png", program.getWidth()/2-59, program.getHeight()*4/5);
        button.sendToFront();
        textbox = new GRect(800/2-150/2, 600*2/3-50, 150,37);
        textbox.sendToFront();

    }

    @Override
    public void showContents() {
        program.add(background);
        program.add(title);
        program.add(button);
        program.add(textbox);
    }

    @Override
    public void hideContents() {
        program.remove(background);
        program.remove(title);
        program.remove(button);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        GObject obj = program.getElementAt(e.getX(), e.getY());
        if (obj == button) {

        }
        if(obj == textbox) {
            text = new GLabel(username, 800/2-150/2, 600*2/3-50);
            text.setFont("Courier");
            text.sendToFront();
            program.add(text);
            textline = new GLine(800/2-150/2, 600*2/3-50, 800/2-150/2, 600*2/3-50+37);
            textline.sendToFront();
            program.add(textline);
        }
    }

    public void actionPerformed(ActionEvent e) {

    }
    
    public String getUsername() {
    	return username;
    }

    public void keyPressed(KeyEvent e) {
    	if(e.getKeyChar() == KeyEvent.VK_ENTER && username != "") {
    		program.switchToGame();
    	}
        if(e.getKeyChar() != KeyEvent.VK_BACK_SPACE) {
            username+= e.getKeyChar();
            try {
            	text.setLabel(username);
            } catch(Exception e1) { 
            	System.out.println(e1);
            }
        } else
            if(username.length() > 1) {
                username = username.substring(0,username.length()-2);
                text.setLabel(username);
            } else
                username = "";
                text.setLabel(username);
               
    }
}
