import acm.graphics.GImage; 

public class PowerShot extends Projectile {
	//fields
	private GImage ps;
	private MainApplication program;
	public PowerShot( PowerType pt, double d, double e, MainApplication ma) {
		super(pt, d, e);
		program = ma;
		// TODO Auto-generated constructor stub
		ps = new GImage("src/Bullets/Power Shot.png", d, e);
		ps.setSize(64,64);
		program.add(ps);
		ps.sendToFront();

	}
	
	public PowerType shoot() {
		for(int i = 0; i < 100; i++) {
			ps.setLocation(xPos, yPos+i);
		}
		return PowerType.POWERSHOT;
	}
}