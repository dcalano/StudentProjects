
public class Enemy extends Character {

	public Enemy(String name) {
		super(name, 100, 3, 3, 1, 1);
	}
	public void specialAttack(Character enemy) {
		System.out.println(this.name + " fires off a barrage of spells!");
		int damage = this.strength * 3;
		enemy.takeDamage(damage);
		int damageDealt = enemy.takeDamage(damage);
	}
}
