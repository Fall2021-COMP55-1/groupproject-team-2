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
    private GLabel score;
    long playerScore;
    private GImage button;
    private GImage loseImage;
    private GImage winImage;
    private boolean winState = false;
    Player player;
    
    //state of whether player lost or won
    //if lost show lost image
    //if won show won image
    
    public WLPane(MainApplication app, MainGame game) {
    	super();
    	player = game.getPlayer();
    	program = app;
    	loseImage = new GImage("src/Images/lostImage.jpg");
    	winImage = new GImage("src/Images/winImage.jpg");
    	
    	
    	if (player != null && player.getHealth() > 0) {
    		winImage.sendToBack();
    		win = new GLabel("YOU HAVE WON", 300, 350);
    		winState = true;
    		win.setColor(Color.white);
    	}
    	else {
    		System.out.println(player.getHealth());
    		loseImage.sendToBack();
    		lose = new GLabel("YOU HAVE LOST", 300, 250);
    		lose.setColor(Color.white);
    	}
    	

        button = new GImage("src/Images/continue button.png", program.getWidth()/2-59, program.getHeight()*4/5);
    }

    @Override
    public void showContents() {
    	if (winState) {
    		program.add(winImage);
    		program.add(win);
    		program.add(score);
    	} 
    	else {
    		program.add(loseImage);
    		program.add(lose);
    		program.add(score);
    	}
        
        program.add(button);
        
    }

    @Override
    public void hideContents() {
    	program.remove(loseImage);
        program.remove(lose);
        program.add(winImage);
        program.remove(win);
        program.remove(score);
        program.remove(button);
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    public void actionPerformed(ActionEvent e) {

    }
    

    public void keyPressed(KeyEvent e) {
    	
               
    }

	public void setPlayer(Player player) {
		this.player = player;
		score = new GLabel("Score: " + player.getScore(), 300, 355);
		score.setColor(Color.white);
		
		
	}

}
