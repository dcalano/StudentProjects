import java.util.ArrayList;
import java.util.List;

public class Character {
	// Character variable
	public String name;
	public int strength;
	public int health;
	public int defense;
	public List<String> inventory;
	
	// Constructors
	public Character(String name, int str, int def, int health) {
		this.name = name;
        this.strength = str;
        this.defense = def;
        this.health = health;
        this.inventory = new ArrayList<>();
    }
	
	public Character(int str, int def, int health) {
		this.name = "Anonymous";
        this.strength = str;
        this.defense = def;
        this.health = health;
    }
	
	// Methods
	public void addItem(String item) {
		inventory.add(item);
	}
	
	public void removeItem(String item) {
		inventory.remove(item);
	}
	// Display my stats
	public void displayMyStats() {
		System.out.println("Player Name: " + this.name);
		System.out.println("Player Strength: " + this.strength);
		System.out.println("Player Defense: " + this.defense);
		System.out.println("Player HP: " + this.health);
	}
	
	
	public int takeDamage(int damage){
		int damageTaken = damage - this.defense;
		this.health -= damageTaken;
		return damageTaken;
	}
	
	public int attack(Character target){
		int damage = this.strength * 2;
		target.takeDamage(damage);
		int damageDealt = target.takeDamage(damage);
		return damageDealt;
	}
	public boolean isAlive(){
		return this.health > 0;
	}
	
}
