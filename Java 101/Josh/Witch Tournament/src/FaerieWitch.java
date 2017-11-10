
public class FaerieWitch extends Character {
	
	public FaerieWitch(String name) {
		super(name, 100, 3, 3, 2, 2);
	}
	
	public void specialAttack(Character enemy) {
		System.out.println("Using an illusion, you're able to dodge the next attack.");
		this.superdodge();
	}
}
