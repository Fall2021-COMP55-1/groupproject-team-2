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
import java.awt.Graphics2D;

public class Settings extends GraphicsPane {
	
    private MainApplication program; 
    private GImage background;
    private GImage settings;
    private GImage settingsTitle;
    private GImage difficultyLevelBox;
    private GImage musicBox;
    private GImage controlText;
    private GImage keyControls;
    private GImage spaceBar;
    private GImage mText;
    private GImage sText;
    private GImage bButton;
    private GImage sBox1;
    private GImage sBox2;
    private GImage sBox3;
    private GImage sBox4;
    private GImage sBox5;
    private GImage sBoxFilled;
    private GImage eText;
    private GImage nText;
    private GImage hText;
    private GImage offText;
    private GImage onText;

    public Settings(MainApplication app) {
        super();

        String filename = "src/Images/cloud.gif";
        background = new GImage(filename, 0,0);
        program = app;
        sBoxFilled = new GImage("src/Images/selectionBoxFilled.png", 340, 135);
        settingsTitle = new GImage("src/Images/settings Title.png", -50, 0);
        settingsTitle.sendToFront();
        difficultyLevelBox = new GImage("src/Images/difficultyLevelBox.png", -73, 80);
        difficultyLevelBox.sendToFront();
        musicBox = new GImage("src/Images/music.png", -115, 160);
        musicBox.sendToFront();
        controlText = new GImage("src/Images/controlText.png", 35, 240);
        controlText.sendToFront();
        sText = new GImage("src/Images/shootingText.png", 360, 310);
        sText.sendToFront();
        mText = new GImage("src/Images/movementText.png", 41, 310);
        mText.sendToFront();
        keyControls = new GImage("src/Images/keyControls.png", 100, 410);
        keyControls.sendToFront();
        spaceBar = new GImage("src/Images/spacebar.png", 450, 420);
        spaceBar.sendToFront();
        settings = new GImage("src/Images/settings gears.png", program.getWidth()/2 - 223, program.getHeight()/5-(400));
        settings.sendToFront();
        bButton = new GImage("src/Images/bButton.png", 265, 478);
        bButton.sendToFront();
        sBox1 = new GImage("src/Images/selectionBox.png", 340, 135);
        sBox1.sendToFront();
        sBox2 = new GImage("src/Images/selectionBox.png", 450, 135);
        sBox2.sendToFront();
        sBox3 = new GImage("src/Images/selectionBox.png", 560, 135);
        sBox3.sendToFront();
        sBox4 = new GImage("src/Images/selectionBox.png", 340, 220);
        sBox4.sendToFront();
        sBox5 = new GImage("src/Images/selectionBox.png", 450, 220);
        sBox5.sendToFront();
        eText = new GImage("src/Images/easytext.png", 235, 50);
        eText.sendToFront();
        nText = new GImage("src/Images/normalText.png", 345, 50);
        nText.sendToFront();
        hText = new GImage("src/Images/hardText.png", 455, 50);
        hText.sendToFront();
        onText = new GImage("src/Images/onText.png", 235, 135);
        onText.sendToFront();
        offText = new GImage("src/Images/offText.png", 345, 135);
        offText.sendToFront();
        
    }

    @Override
    public void showContents() {
        program.add(background);
        program.add(settings);
        program.add(settingsTitle);
        program.add(difficultyLevelBox);
        program.add(musicBox);
        program.add(controlText);
        program.add(keyControls);
        program.add(spaceBar);
        program.add(sText);
        program.add(mText);
        program.add(bButton);
        program.add(sBox1);
        program.add(sBox2);
        program.add(sBox3);
        program.add(sBox4);
        program.add(sBox5);
        program.add(eText);
        program.add(nText);
        program.add(hText);
        program.add(onText);
        program.add(offText);
    }

    @Override
    public void hideContents() {
        program.remove(background);
        program.remove(settings);
        program.remove(settingsTitle);
        program.remove(difficultyLevelBox);
        program.remove(musicBox);
        program.remove(controlText);
        program.remove(keyControls);
        program.remove(spaceBar);
        program.remove(sText);
        program.remove(mText);
        program.remove(bButton);
        program.remove(sBox1);
        program.remove(sBox2);
        program.remove(sBox3);
        program.remove(sBox4);
        program.remove(sBox5);
        program.remove(eText);
        program.remove(nText);
        program.remove(hText);
        program.remove(onText);
        program.remove(offText);
    }

    @Override
    public void mousePressed(MouseEvent e) {
    	boolean isOn = false;
        GObject obj = program.getElementAt(e.getX(), e.getY());
        if (obj == bButton) {
        	program.switchToMenu();
        }
        if (obj == settings) {
        	program.switchToSettings();
        }
        /*if (obj == sBox1 || obj == sBox2 || obj == sBox3) {
        	if (isOn) {
        		isOn = false;
        		program.remove(sBoxFilled);
        	}
        	else {
        		isOn = true;
        		program.add(sBoxFilled);
        	}
        }*/
        /*
        if (obj == sBox1) {
        	if (isOn) {
        		isOn = false;
        		program.remove(sBox1);
        	}
        	else {
        		isOn = true;
        		program.add(sBoxFilled);
        	}
        }8?
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