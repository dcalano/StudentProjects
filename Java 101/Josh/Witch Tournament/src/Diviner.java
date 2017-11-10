
public class Diviner extends Character {
	
	public Diviner(String name) {
		super(name, 100, 3, 4, 2, 1);
	}
	
	public void specialAttack(Character enemy) {
		System.out.println("You saw the attack coming, dodging it without trouble.");
		this.superdodge();
	}
}
