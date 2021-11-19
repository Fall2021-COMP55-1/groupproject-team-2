public class Projectile {
    double xPos;
    double yPos;
    int velocity;
    

    public Projectile(double d, double e) {
    	xPos = d;
    	yPos = e;
    }
    

    //Setters for the class
    public void setXPos(int xPos) {
      this.xPos = xPos;
    }
    public void setYPos(int yPos) {
      this.yPos = yPos;
    }
    public void setVelocity(int velocity) {
      this.velocity = velocity;
    }
    //getters for the class

    public double getXPos() {
      return this.xPos;
    }
    public double getYPos() {
      return this.yPos;
    }
    public Integer getVelocity() {
      return this.velocity;
    }


	public void hide() {
		// TODO Auto-generated method stub
		
	}
}
