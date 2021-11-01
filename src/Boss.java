public class Boss {
  int health;
  int damage;
  
  public enum attack {attackOne, attackTwo, attackThree}
  attack attackType;
    
  public AttackOne(attack attackType) {
      this.attackType = attack;
    } 
  public AttackTwo(attack attackType) {
      this.attackType = attack;
    }
  public AttackThree(attack attackType) {
      this.attackType = attack;
    }
    
  public void setHealth(int health){
    this.health = health;
  } 
   
  public int getHealth() {
      return health;
    } 
    
  public dealDamage(int damage) {
      this.damage = damage;
    }

}
