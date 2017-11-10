import java.util.Random;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Arena {
	
	public static Random generator = new Random();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// System variables
		Scanner scanner = new Scanner(System.in);
		
		// Item variables
		String potion = "potion";
		String sword = "sword";
		String helmet = "helmet";
		
		System.out.println("What is your name?");
		
		String playerName = scanner.nextLine();
		
		Mage player0 = new Mage(playerName);
		player0.displayMyStats();
		player0.addItem(potion);
		
		
		
		Character player1 = new Character(10, 2, 100);
		Character player2 = new Character(11, 1, 100);
		player2.strength = 4;
		player2.defense = 2;
		System.out.println(player1.name + " vs " + player2.name);
		System.out.println(player1.health + " vs " + player2.health);
		while (player1.isAlive() && player2.isAlive()){
			int damage;
			System.out.println(player1.name + ": " + player1.health);
			System.out.println(player2.name + ": " + player2.health);
			damage = player1.attack(player2);
			System.out.println(player1.name + " deals " + damage + " damage to " + player2.name + "!");
			damage = player2.attack(player1);
			System.out.println(player2.name + " deals " + damage + " damage to " + player1.name + "!");
		}
		if (player1.isAlive()){
			System.out.println(player1.name + "is victorious.");
		} else if (player2.isAlive()){
			System.out.println(player2.name + "is victorious.");
		} else {
			System.out.println("It's a draw.");
		}

	}

}
