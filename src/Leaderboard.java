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

public class Leaderboard extends GraphicsPane {

    private MainApplication program; 
    private GImage background;
    private GImage bButton;
    private GLabel text;
    private String username = " ";
    private GImage leaderboard;
    private GImage leaderboardImage;

    public Leaderboard(MainApplication app) {
        super();

        String filename = "src/Images/cloud.gif";
        background = new GImage(filename, 0,0);
        program = app;
        leaderboard = new GImage("src/Images/Leaderboard.png", 220, 0);
        leaderboard.sendToFront();        
        leaderboardImage = new GImage("src/Images/leaderboardImage.png", program.getWidth()/2 - 223, program.getHeight()/5-(400));
        leaderboardImage.sendToFront();
        bButton = new GImage("src/Images/bButton.png", 265, 478);
        bButton.sendToFront();
        text = new GLabel(username, 800/2-150/2, 600*2/3-50);

    }

    @Override
    public void showContents() {
        program.add(background);
        program.add(bButton);
        program.add(leaderboard);
        program.add(leaderboardImage);
    }

    @Override
    public void hideContents() {
        program.remove(background);
        program.remove(bButton);
        program.remove(leaderboard);
        program.remove(leaderboardImage);
    }

    @Override
    public void mousePressed(MouseEvent e) {
    	//boolean isOn = false;
        GObject obj = program.getElementAt(e.getX(), e.getY());
        if (obj == bButton) {
        	program.switchToMenu();
        }
        if (obj == leaderboard) {
        	program.switchToLeaderboard();
        }
        
    }

    public void actionPerformed(ActionEvent e) {
    	
    }

    public void keyPressed(KeyEvent e) {
    }
    
}
