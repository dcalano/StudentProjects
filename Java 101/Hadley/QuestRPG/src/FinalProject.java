import java.util.List;
import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;

public class FinalProject {

	public static Character player;
	
	public static Scanner playerStringInput;
	public static Scanner playerNumberInput;
	public static Random randomGenerator = new Random();
	
	public static void main(String[] args) {
		playerStringInput= new Scanner(System.in);
		playerNumberInput = new Scanner(System.in);
		
		player = intro(playerStringInput);
		System.out.println("You start your adventure in the town.");
		gotoTown();
		
		playerStringInput.close();
		playerNumberInput.close();
		
	}
	
	// Display intro text and get user details
	public static Character intro(Scanner playerStringInput) {
		Character player = null;
		String playerName;
		String playerClass;
		
		System.out.println("Welcome player, what is you name? ");
		playerName = playerStringInput.nextLine();
		System.out.println("Welcome to Middle Earth " + playerName);
		System.out.println("What class would you like to play? ");
		System.out.println("You can be a warrior, kinight, wizard, or assassin");
		System.out.println("A warrior's attack is 5, armor is 3 and health is 20.");
		System.out.println("A knight's attack is 3, armor is 4 and health is 30.");
		System.out.println("A wizard's attack is 7, armor is 1 and health is 15.");
		System.out.println("A assassin's attack is 11, armor is 1 and health is 12.");
		System.out.println("Now choose you class by typing their name below.");
		playerClass = playerStringInput.nextLine();
		
		if (playerClass.toLowerCase().equals("warrior")) {
			player = new Warrior();
			System.out.println("Congratulations " + playerName + " You are now a Warrior.");
		} else if (playerClass.toLowerCase().equals("knight")) {
			player = new Knight();
			System.out.println("Congratulations " + playerName + " You are now a Knight.");
		} else if(playerClass.toLowerCase().equals("wizard")) {
			player = new Wizard();
			System.out.println("Congratulations " + playerName + " You are now a Wizard.");
		} else if(playerClass.toLowerCase().equals("assassin")) {
			player = new Assassin();
			System.out.println("Congratulations " + playerName + " You are now a Assassin.");
		}
		
		if (player != null) {
			player.setName(playerName);
			player.addItem(ItemList.healthPotion);
			player.addGold(5);
			System.out.println("You have also recived a health2 potion and 5 peices of gold.");
		}
		
		return player;
	}
	
	
	public static int getNumberInput(String messageToDisplay, List<String> options) {
		int answer = -1;
		System.out.println(messageToDisplay);
		for (int i = 0; i < options.size(); i++) {
			System.out.println((i + 1) + ". " + options.get(i));
		}
		
		boolean reaskQuestion = false;
		do {
			answer = playerNumberInput.nextInt();
			if (answer < 1 && answer > options.size() - 1) {
				System.out.println("Invalid option");
				reaskQuestion = true;
			}
		} while (reaskQuestion == true);
			
		return answer;
	}

	public static void gotoTown() {
		List<String> options = new ArrayList<>();
		options.add("Explore the forest");
		options.add("Explore the caves");
		options.add("Enter the store");
		options.add("Rest for the night");
		options.add("Display inventory");
		options.add("Display gold");
		options.add("Quit game");
		int userChoice = getNumberInput("\n\nWhat would like to do?", options);
		if (userChoice == 1) {
			goToAdventure("forest");
		} else if(userChoice == 2) {
			goToAdventure("caves");
		} else if(userChoice == 3) {
			List<Item> storeItems = new ArrayList<>();
			storeItems.add(ItemList.healthPotion);
			storeItems.add(ItemList.superHealthPotion);
			storeItems.add(ItemList.revivePotion);
			goToItemShop(storeItems);
		} else if (userChoice == 4) {
			System.out.println("You go to the inn and rest.");
			player.heal(player.maxHealth);
			gotoTown();
		} else if (userChoice == 5) {
			player.displayItems();
			gotoTown();
		} else if (userChoice == 6) {
			player.displayGold();
			gotoTown();
		} else if (userChoice == 7) {
			System.out.println("Quitting game...");
			System.exit(0);
		}
	}
	

	public static void goToItemShop(List<Item> availableItems) {
		String boughtItem = null;
		
		List<String> options = new ArrayList<>();
		options.add("Buy an item");
		options.add("Leave the store");
		int userChoice = getNumberInput("What would like to do?", options);
		if (userChoice == 1) {
			// Display items to buy
			List<String> itemNames = new ArrayList<>();
			for (int i = 0; i < availableItems.size(); i++) {
				itemNames.add( availableItems.get(i).name + " [" + availableItems.get(i).value + " gold]");
			}
			
			userChoice = getNumberInput("What would you like to buy?", itemNames);
			
			Item selectedItem = availableItems.get(userChoice - 1);
			if ( player.spendGold( selectedItem.value ) ) {
				player.addItem(selectedItem);
				System.out.println("You bought a " + selectedItem.name);
			} else {
				System.out.println("Insufficient gold");
			}
		}else{
			System.out.println("Bye");
		}
		
		gotoTown();
	}
	
	
	public static void goToAdventure(String location) {
		int randomNumber = randomGenerator.nextInt(10);
		if(location.equals("forest")) {
			System.out.println("You enter the dark forest.");
			if (randomNumber > 6) {
				int goldAmount = randomGenerator.nextInt(4) + 1;
				player.addGold(goldAmount);
				System.out.println("Congratulatons you found " + goldAmount + " gold!");
			}else if (randomNumber > 5) {
				Item item = ItemList.healthPotion;
				System.out.println("Congratulatons you found a " + item.name + "!");
				player.addItem(item);
			}else{
				// Battle
				int enemyType = randomGenerator.nextInt(10);
				if (enemyType < 3) {
					System.out.println("ROAR!! A mighty dragon has appeared!\n");
					Dragon dragon = new Dragon();
					dragon.addGold(randomGenerator.nextInt(7) + 1);
					dragon.addItem(ItemList.superHealthPotion);
					battle(dragon);
				} else {
					System.out.println("A wicked witch challenges you!\n");
					Witch witch = new Witch();
					witch.addGold(randomGenerator.nextInt(7) + 1);
					witch.addItem(ItemList.healthPotion);
					battle(witch);
				}
			
			}
		}else if(location.equals("caves")) {
			System.out.println("You enter the cold caves.");
			if (randomNumber > 6) {
				int goldAmount = randomGenerator.nextInt(4) + 1;
				player.addGold(goldAmount);
				System.out.println("Congratulatons you found " + goldAmount + " gold!");
			}else if (randomNumber > 5) {
				Item item = ItemList.healthPotion;
				System.out.println("Congratulatons you found a " + item.name + "!");
				player.addItem(item);
			}else{
				// Battle
				System.out.println("You have been attacked by a goblin!\n");
				Goblin goblin = new Goblin();
				goblin.addGold(randomGenerator.nextInt(5) + 1);
				battle(goblin);
			}
		}
		
		System.out.println("\nReturning to town...");
		gotoTown();
	}
	
	
	public static void battle(Character enemy) {
		do {
			// Player turn
			// Reset defending state
			player.isDefending = false;
			
			List<String> options = new ArrayList<>();
			options.add("Attack");
			options.add("Defend");
			options.add("Use item");
			int choice = getNumberInput("What would you like to do?", options);
			if (choice == 1) {
					player.attack(enemy);
			} else if (choice == 2) {
				player.isDefending = true;
			} else if (choice == 3) {
				List<String> itemOptions = new ArrayList<>();
					itemOptions.add("Use Health potion");
					itemOptions.add("Use Super Health potion");
				choice = getNumberInput("Which item will you use?", itemOptions);
				
				if (choice == 1) {
					if (player.inventory.contains(ItemList.healthPotion)) {
						player.heal(ItemList.healthPotion.value);
						player.inventory.remove(ItemList.healthPotion);
					} else {
						System.out.println("No potions available, you lost your turn while fumbling around in your backpack :(");
					}
				} else if(choice == 2) {
					if (player.inventory.contains(ItemList.superHealthPotion)) {
						player.heal(ItemList.superHealthPotion.value);
						player.inventory.remove(ItemList.superHealthPotion);
					} else {
						System.out.println("No super potions available, you lost your turn while fumbling around in your backpack :(");
					}
				}
			
			}
			
			
			// Enemy turn
			if (enemy.health > 0) {
				// Reset defending state
				enemy.isDefending = false;
				// If enemy is above 50% hp, attack player
				if (enemy.health > (enemy.maxHealth / 2)) {
					enemy.attack(player);
					
				// If enemy is between 25% and 50% hp, defend
				} else if (enemy.health > (enemy.maxHealth / 4)) {
					enemy.isDefending = true;
					System.out.println(enemy.name + " bolsters their defenses!");
				// Enemy is below 25% hp, it will try to attack again!
				} else {
					enemy.attack(player);
					
				}
			} else {
				System.out.println("\nCongratulations, you have slain " + enemy.name);
			}
		} while (player.isAlive() && enemy.isAlive());
		
		if (!player.isAlive()) {
			System.out.println("You were defeated!\nGame Over!");
			System.exit(0);
		} else {
			// Player won
			player.addGold(enemy.gold);
			System.out.println("Congratulations, you got " + enemy.gold + " gold!\n\n");
			
			if (enemy.inventory.size() > 0) {
				for (int i = 0; i < enemy.inventory.size(); i++) {
					player.addItem(enemy.inventory.get(i));
					System.out.println("Player has received a " + enemy.inventory.get(i).name);
				}
			}
		}
	}
}




