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

    private GImage background;
    //private GImage title;
    private GImage button;
    //private GRect textbox;
    //private GLabel text;
    //private GLine textline;
    //private String username = " ";
    private GImage settings;
    private GImage settingsTitle;
    private GImage difficultyLevelBox;
    private GImage musicBox;

    public Settings(MainApplication app) {
        super();

        String filename = "src/Images/cloud.gif";
        background = new GImage(filename, 0,0);
        program = app;
        //title = new GImage("src/Images/title.png", program.getWidth()/2 - 233, program.getHeight()/5-(150/5));
        //title.sendToFront();
      
        settingsTitle = new GImage("src/Images/settings Title.png", -50, 0);
        settingsTitle.sendToFront();
        difficultyLevelBox = new GImage("src/Images/difficultyLevelBox.png", -70, 80);
        difficultyLevelBox.sendToFront();
        musicBox = new GImage("src/Images/music.png", -115, 140);
        musicBox.sendToFront();
        
        settings = new GImage("src/Images/settings gears.png", program.getWidth()/2 - 223, program.getHeight()/5-(400));
        settings.sendToFront();
        button = new GImage("src/Images/continue button.png", program.getWidth()/2-59, program.getHeight()*4/5);
        button.sendToFront();
        //textbox = new GRect(800/2-150/2, 600*2/3-50, 150,37);
        //textbox.sendToFront();
        //text = new GLabel(username, 800/2-150/2, 600*2/3-50);
    }

    @Override
    public void showContents() {
        program.add(background);
        //program.add(title);
        program.add(button);
        //program.add(textbox);
        program.add(settings);
        
        program.add(settingsTitle);
        program.add(difficultyLevelBox);
        program.add(musicBox);
    }

    @Override
    public void hideContents() {
        program.remove(background);
        //program.remove(title);
        program.remove(button);
        program.remove(settings);
        
        program.remove(settingsTitle);
        program.remove(difficultyLevelBox);
        program.remove(musicBox);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        GObject obj = program.getElementAt(e.getX(), e.getY());
        if (obj == button) {

        }
        if (obj == settings) {
        	program.switchToSettings();
        }
        /*if(obj == textbox) {

            text.setFont("Courier");
            text.sendToFront();
            program.add(text);
            textline = new GLine(800/2-150/2, 600*2/3-50, 800/2-150/2, 600*2/3-50+37);
            textline.sendToFront();
            program.add(textline);
        }*/
    }

    public void actionPerformed(ActionEvent e) {

    }

    /*public void keyPressed(KeyEvent e) {
    	if(e.getKeyChar() == KeyEvent.VK_ENTER && username != "") {
    		//program.switchToGame();
    		program.switchToSettings();
    	}
        if(e.getKeyChar() != KeyEvent.VK_BACK_SPACE) {
            username+= e.getKeyChar();
            text.setLabel(username);
        } else
            if(username.length() > 1) {
                username = username.substring(0,username.length()-2);
                text.setLabel(username);
            } else {
                username = "";
        		text.setLabel(username);
            }
    }*/
}