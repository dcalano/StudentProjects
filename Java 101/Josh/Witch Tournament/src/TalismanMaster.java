
public class TalismanMaster extends Character {
	
	public TalismanMaster(String name) {
		super(name, 95, 3, 5, 1, 1);
	}
	
	public void specialAttack(Character enemy) {
		int damage = this.strength * 3;
		enemy.takeDamage(damage);
		int damageDealt = enemy.takeDamage(damage);
		System.out.println("You use a talisman to boost the power of your attack, dealing " + damageDealt + " damage.");
	}
}
