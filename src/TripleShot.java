import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import acm.graphics.GImage; 

public class TripleShot extends Projectile implements ActionListener {
    //fields
    private GImage ps, ds, ts;
    private MainApplication program;
    private PowerType pt;
    private Timer timer;
    public TripleShot(PowerType pt, double d, double e, MainApplication ma) {
        super(d, e);
        program = ma;
        this.pt = pt;
        timer = new Timer(1, this);

        ps = new GImage("src/Bullets/Rotated Shot.png", d+18, e);
        ps.sendToFront();
        ps.setSize(64,64);
        ds = new GImage("src/Bullets/Rotated Shot.png", d, e-1);
        ds.sendToFront();
        ds.setSize(64,64);
        ts = new GImage("src/Bullets/Rotated Shot.png", d-18, e-2);
        ts.sendToFront();
        ts.setSize(64,64);

        program.add(ps);
        program.add(ds);
        program.add(ts);
        timer.start();

    }

    public void actionPerformed(ActionEvent e) {
        if(yPos < 0) {
            timer.stop();
            System.out.println("PS Final coords: " + xPos + ", " + yPos);
        }

            ps.setLocation(xPos+18, yPos);
            ds.setLocation(xPos, yPos);
            ts.setLocation(xPos-18, yPos--);
            yPos -= 1;

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