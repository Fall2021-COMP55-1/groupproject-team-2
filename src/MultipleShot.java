import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import acm.graphics.GImage; 

public class MultipleShot extends Projectile implements ActionListener {
	//fields
	private GImage ps;
	private MainApplication program;
	private PowerType pt;
	private Timer timer;
	public MultipleShot(PowerType pt, double d, double e, MainApplication ma) {
		super(d, e);
		program = ma;
		this.pt = pt;
		timer = new Timer(1, this);
		// TODO Auto-generated constructor stub
		ps = new GImage("src/Bullets/Rotated Shot.png", d-48, e-48);
		ps.setSize(64,64);
		program.add(ps);
		ps.sendToFront();
		timer.start();

	}
	
	public void actionPerformed(ActionEvent e) {
		if(yPos != 0)
			ps.setLocation(xPos, yPos--);
	}
	
	public PowerType shoot() {
		/*for(int i = 0; i < 100; i++) {
			
			ps.setLocation(xPos, yPos--);
			System.out.println("Moving bullet");
		}*/
		return pt;
	}
}