import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import acm.graphics.GImage; 

public class DoubleShot extends Projectile implements ActionListener {
    //fields
    private GImage ps, ds;
    private MainApplication program;
    private PowerType pt;
    private Timer timer;
    public DoubleShot(PowerType pt, double d, double e, MainApplication ma) {
    	super(ma, d+48, e);
        program = ma;
        this.pt = pt;
        timer = new Timer(1, this);

        ps = new GImage("src/Bullets/Rotated Shot.png", d+12, e-48);
        ps.sendToFront();
        ps.setSize(64,64);
        ds = new GImage("src/Bullets/Rotated Shot.png", d-12, e-4);
        ds.sendToFront();
        ds.setSize(64,64);

        program.add(ps);
        program.add(ds);
        timer.start();

    }

    public void actionPerformed(ActionEvent e) {
        if(yPos < 0) {
            timer.stop();
            System.out.println("PS Final coords: " + xPos + ", " + yPos);
        }
            ps.setLocation(xPos+12, yPos--);
            ds.setLocation(xPos-12, yPos--);

    }

    public void remove() {
        program.remove(ps);
    }

    public PowerType shoot() {
        for(int i = 0; i < 100; i++) {

            ps.setLocation(xPos, yPos--);
            System.out.println("Moving bullet");
        }
        return pt;
    }
}