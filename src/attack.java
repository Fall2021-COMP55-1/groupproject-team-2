public Class Boss {
  int health;
  int damage;
  
  public enum attack {attackOne, attackTwo, attackThree, attack}
  attack attackType;
  
private int damage;
private int health;
    
  public void AttackOne(attack attackType) {
      this.attackType = attack;
    } 
  public void AttackTwo(attack attackType) {
      this.attackType = attack;
    }
  public void AttackThree(attack attackType) {
      this.attackType = attack;
    }
    
  public void setHealth(int health){
    this.health = health;
  } 
   
  public int getHealth() {
      return health;
    } 
    
  public void dealDamage(int damage) {
      this.damage = damage;
    }

}
