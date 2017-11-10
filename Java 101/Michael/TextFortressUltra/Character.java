import java.util.List;
import java.util.ArrayList;

public class Character {
	
	String name;
	int damage;
	int health;
	int maxHealth;
	int defense;
	int speed; // 3 = fast, 2 = medium, 1 = slow
	boolean isDefending;
	
	public Character(int damage, int health, int speed) {
		this.damage = damage;
        this.health = health;
        this.maxHealth = health;
        this.speed = speed;
        this.isDefending = false;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int attack(Character target) {
		int damageGiven = target.takeDamage(this.damage);
		return damageGiven;
	}
	
	public int attack(Character target, int multiplier) {
		System.out.println(this.name + " attacks " + target.name + " for " + (this.damage * multiplier) + " damage!");
		int damageGiven = target.takeDamage(this.damage * multiplier);
		return damageGiven;
	}
	
	public int takeDamage(int damage) {
		int damageTaken = damage;
		if (this.isDefending == true) {
			System.out.println(this.name + " defends the attack, taking half damage!");
			damageTaken /= 2;
		}
		
		this.health -= damageTaken;
		
		
		if (this.health < 0) {
			this.health = 0;
			System.out.println(this.name + " has died!");
		} else {
			System.out.println(this.name + " has " + this.health + " hp!");
		}
		
		return damage;
	}
	
	public void heal(int amount) {
		if (this.health == this.maxHealth) {
			return;
		} else if (this.health + amount >= this.maxHealth) {
			this.health = this.maxHealth;
			System.out.println(this.name + " has been fully healed!");
		} else {
			this.health += amount;
			System.out.println(this.name + " was healed for " + amount + " health!");
		}
		
	}
	
	public boolean isAlive() {
		return this.health > 0;
	}
}
