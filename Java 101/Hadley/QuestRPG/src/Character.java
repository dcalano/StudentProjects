import java.util.List;
import java.util.ArrayList;

public class Character {
	
	String name;
	int attack;
	int health;
	int maxHealth;
	int armor;
	int gold;
	boolean isDefending;
	public List<Item> inventory;
	
	public Character(int attack, int armor, int health) {
		this.attack = attack;
        this.armor = armor;
        this.health = health;
        this.maxHealth = health;
        this.inventory = new ArrayList<>();
        this.gold = 0;
        this.isDefending = false;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void displayItems() {
		System.out.println("\nYou currently have:");
		for (int i = 0; i < this.inventory.size(); i++) {
			System.out.println(this.inventory.get(i).name);
		}
		System.out.println();
	}
	
	public void addItem(Item item) {
		inventory.add(item);
	}
	
	public void removeItem(Item item) {
		inventory.remove(item);
	}
	
	public int attack(Character target) {
		int damage = this.attack;
		System.out.println(this.name + " attacks " + target.name + " for " + damage + " damage!");
		int damageGiven = target.takeDamage(damage);
		return damageGiven;
	}
	
	public int takeDamage(int damage) {
		int damageTaken = 0;
		if (isDefending) {
			damageTaken = damage - (this.armor * 2);
		} else {
			damageTaken = damage - this.armor;
		}
		
		if (damageTaken < 0) {
			damageTaken = 0;
		}
		
		// Flavor text
		if (isDefending) {
			System.out.println(this.name + " defends against the attack, taking " + damageTaken + " damage!");
		} else {
			System.out.println("The blow hit " + this.name + " for " + damageTaken + " damage!");
		}
		
		this.health -= damageTaken;
		
		if (health < 0)
			health = 0;
		
		if(health == 0) {
			if (this.inventory.contains(ItemList.revivePotion)) {
				this.heal(this.maxHealth);
				this.inventory.remove(ItemList.revivePotion);
			}
		}
		
		System.out.println(this.name + " has " + this.health + "/" + this.maxHealth + " health remaining!");
		
		return damageTaken;
	}
	
	public boolean isAlive() {
		return this.health > 0;
	}
	
	public void addGold(int amount) {
		this.gold += amount;
	}
	
	public boolean spendGold(int amount) {
		if (this.gold < amount) {
			return false;
		} else {
			this.gold -= amount;
			return true;
		}
	}
	
	public void displayGold() {
		System.out.println("\nYou have " + this.gold + " gold\n");
	}
	
	public void heal(int amount) {
		if (health + amount > maxHealth) {
			health = maxHealth;
		} else {
			health += amount;
		}
	}
}
