public class Projectile {
    int xPos;
    int yPos;
    int velocity;
    

    public Projectile(PowerType pt) {
    
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

    public Integer getXPos() {
      return this.xPos;
    }
    public Integer getYPos() {
      return this.yPos;
    }
    public Integer getVelocity() {
      return this.velocity;
    }
}
