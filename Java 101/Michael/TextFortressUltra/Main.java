import java.util.Random;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {
	public static Scanner intInput;
	public static Scanner stringInput;
	public static Random randomGenerator = new Random();
	public static Character player;
	public static int userClass;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		stringInput = new Scanner(System.in);
		intInput = new Scanner(System.in);
		
		
		
		String playername;
		
		System.out.println("Welcome to Anomia. \nWhat's your name?");
		playername = stringInput.nextLine();
		System.out.println("hello " + playername);
		System.out.println("\n The goal of this game is to defeat the evil Seige in the Game of Anomia. First let's start by choosing your class.");
		
		String question = "what class would you like to be? (answer with number)";
		List<String> questionAnswer = new ArrayList<>();
		questionAnswer.add("Scout: quick, 5dmg, 10hp, 50% chance to dodge attack");
		questionAnswer.add("heavy: slow, 10dmg, 15hp");
		questionAnswer.add("spy: quick, 10dmg(first hit), 4dmg, 10hp");
		questionAnswer.add("engineer: slow(can't hit first move), 12dmg, 510hp");
		questionAnswer.add("sniper: quick(first hit), 6dmg, 10hp, 50% chance of hitting crit(double damage)");
		questionAnswer.add("demoman: slow(second and thrid hit), 10dmg, 14hp");
		questionAnswer.add("soldier: slow, 10dmg, 16hp");
		questionAnswer.add("medic: fast, 5 dmg, 12hp, heals 2 every turn");
		questionAnswer.add("flame thrower: slow, 6dmag, 12hp, deals 2 dmg every turn after first hit");
		questionAnswer.add("Steve: fast, 8dmg, 16hp, 30% chance to one hit win");
		userClass = getUserIntegerInput (question, questionAnswer);
		
		if (userClass == 0) { 
			System.out.println("you are now a scout");
			player = new Scout();
		}
		else if (userClass == 1) {
			System.out.println("you are now a heavy.");
			player = new Heavy();
		}
		else if (userClass == 2) {
			System.out.println("you are now a spy.");
			player = new Spy();
		}
		else if (userClass == 3) {
			System.out.println("you are now engineer");
			player = new Engineer();
		}
		else if (userClass == 4) {
			System.out.println("you are now a sniper");
			player = new Sniper();
		}
		else if (userClass == 5) {
			System.out.println("you are now a demoman.");
			player = new Demoman();
		}
		else if (userClass == 6) {
			System.out.println("you are now a soldier.");
			player = new Soldier();
		}
		else if (userClass == 7) {
			System.out.println("you are now a medic");
			player = new Medic();
		}
		else if (userClass == 8) {
			System.out.println("you are now a flame thrower.");
			player = new Pyro();
		}
		else if (userClass == 9){
			System.out.println("you are now steve.");
			
		}
		
		player.setName(playername);
		goToAnomia();
	}
	
	
	public static void goToAnomia() {
		List<String> places = new ArrayList<>();
		places.add("Coal town");
		places.add("Steves house");
		places.add("Mann co.");
		places.add("Kenya");
		places.add("Seige land");
		places.add("quit");
		int userChoice = getUserIntegerInput("Where would you like to go, " + player.name + "?", places);
		if (userChoice == 0) { 
			goFight("Coal town");
		}
		else if (userChoice == 1) {
			goFight("Steves House");
		}
		else if (userChoice == 2) {
			goFight("Mann co.");
		}
		else if (userChoice == 3) {
			goFight("Kenya");
		}
		else if (userChoice == 4) {
			goFight("Seige land");
		}
		else if (userChoice == 5) {
			System.out.println("Game over");
			System.exit(0);
		}
	}
	public static void goFight(String place) {
		if (place.toLowerCase().equals("coal town")) {
			System.out.println("you are now in Coal town watch out for Spy's they're diguised as your friends");
			System.out.print("(you speaking) Hey Bob. \n (Bob) Hey " + player.name + "\n (Actual Bob) Who are you talking to " + player.name + ", I'm over here"); 
			Character spy = new Spy();
			spy.setName("Spy");
			battle(spy);
			goToAnomia();
		} 
		else if (place.toLowerCase().equals("steves house")) {
			System.out.println("you are now at Steve's house whatch out for Snakes, Skeletons, and Brian");
			int randomNumber1 = randomGenerator.nextInt(3);
			if (randomNumber1 == 0) {
				Character testEnemy = new Snake();
				testEnemy.setName("Snake");
				battle(testEnemy);
				goToAnomia();
			} 
			else if (randomNumber1 == 1) {
				Character testEnemy = new Skeleton();
				testEnemy.setName("Skeleton");
				battle(testEnemy);
				goToAnomia();
			}
			else if (randomNumber1 == 2) {
				Character testEnemy = new Brian();
				testEnemy.setName("Brian");
				battle(testEnemy);
				goToAnomia();
			}
		} 
		else if (place.toLowerCase().equals("mann co.")) {
			System.out.println("you are now at Mann co., however it's been taken over by robots. Fight your way out!");
			Character testEnemy = new Robot();
			testEnemy.setName("Robot");
			battle(testEnemy);
			goToAnomia();
		} 
		else if (place.toLowerCase().equals("kenya")) {
			System.out.println("you are now in Kenya, watch out for Lions, Aligators, Monkeys, girafes,");
			int randomNumber2 = randomGenerator.nextInt(4);
			if (randomNumber2 == 0) {
				Character lion = new Lion();
				lion.setName("Lion");
				battle(lion);
				
				System.out.println("bounus enemy");
				Character michael = new Michael();
				michael.setName("Michael");
				battle(michael);
				goToAnomia();
			}
			else if (randomNumber2 == 1) {
				Character testEnemy = new Aligator();
				testEnemy.setName("Aligator");
				battle(testEnemy);
				goToAnomia();
			}
			else if (randomNumber2 == 2) {
				Character testEnemy = new Monkey();
				testEnemy.setName("Monkey");
				battle(testEnemy);
				goToAnomia();
			}
			else if (randomNumber2 == 3) {
				Character testEnemy = new Giraffe();
				testEnemy.setName("Giraffe");
				battle(testEnemy);
				goToAnomia();
			}
		}
		else if (place.toLowerCase().equals("seige land")) {
			System.out.println("you have reached the final boss. He is undefeated in Anomia. He is The Master Deciferer.");
			Character seige = new Seige();
			seige.setName("Seige");
			battle(seige);
			System.out.println("finaler boss.");
			Character masterMeeseeks = new MasterMeeseeks();
			masterMeeseeks.setName("MasterMeeseeks");
			battle(masterMeeseeks);
		}
	}
	
	public static void battle(Character enemy) {
		String actionPrompt = "Your turn, what action do you want to take?";
		List<String> actions = new ArrayList<>();
		actions.add("attack");
		actions.add("defend");
		
		int currentTurn = 1;
		int playerBurnDamage = 0;
		int enemyBurnDamage = 0;
		System.out.println("\n\nYou are face to face with " + enemy.name + "!\n");
		
		int startTurn = randomGenerator.nextInt(2);
		if ((player.speed < enemy.speed) || (player.speed == enemy.speed && startTurn == 0)) {
			if (enemy.isAlive()) {
				// Extra enemy turn
				// START OF ENEMY TURN
				System.out.println("Enemy sneak attacked you!");
				enemy.isDefending = false; // undefend in case user was defending last turn
				
				// Medic special
				if (enemy instanceof Medic || enemy instanceof MasterMeeseeks) {
					enemy.heal(2);
				}
				
				// Pseudo-AI (attack if over 61% hp, defend at 40% - 60% hp, attack again when below 40% hp
				if ((double) enemy.health / (double) enemy.maxHealth > 0.60) {
					handleAttackLogic(enemy, player, currentTurn, enemyBurnDamage);
				} else if ((double) enemy.health / (double) enemy.maxHealth > 0.40) {
					// Defend
					System.out.println(enemy.name + " is defending");
					enemy.isDefending = true;
				} else {
					handleAttackLogic(enemy, player, currentTurn, enemyBurnDamage);
					if (enemy instanceof Pyro) {
						enemyBurnDamage += 2;
					}
				}
			}
		}
		
		do {
			if (player.isAlive()) {
				// START OF PLAYER TURN
				player.isDefending = false; // undefend in case user was defending last turn
				
				// Medic special
				if (player instanceof Medic) {
					player.heal(2);
				}
				int userChoice = getUserIntegerInput(actionPrompt, actions);
				if (userChoice == 0) {
					handleAttackLogic(player, enemy, currentTurn, playerBurnDamage);
					
					if (player instanceof Pyro) {
						playerBurnDamage = 2;
					}
				} else if (userChoice == 1) {
					player.isDefending = true;
				}
			}
			
			
			if (enemy.isAlive()) {
				// START OF ENEMY TURN
				enemy.isDefending = false; // undefend in case user was defending last turn
				
				// Medic special
				if (enemy instanceof Medic) {
					enemy.heal(2);
				}
				
				// Pseudo-AI (attack if over 61% hp, defend at 40% - 60% hp, attack again when below 40% hp
				if ((double) enemy.health / (double) enemy.maxHealth > 0.60) {
					handleAttackLogic(enemy, player, currentTurn, enemyBurnDamage);
					if (enemy instanceof Pyro) {
						enemyBurnDamage = 2;
					}
				} else if ((double) enemy.health / (double) enemy.maxHealth > 0.40) {
					// Defend
					System.out.println(enemy.name + " is defending");
					enemy.isDefending = true;
				} else {
					handleAttackLogic(enemy, player, currentTurn, enemyBurnDamage);
					if (enemy instanceof Pyro) {
						enemyBurnDamage = 2;
					}
				}
			}
			
			
			// Post round stuff
			currentTurn++;
		} while (player.health > 0 && enemy.health > 0);
		
		if (!player.isAlive()) {
			System.out.println("game over");
			System.exit(0);
		} else {
			System.out.println ("you won the fight");
			player.heal(100);
		}
		
	}

	public static void handleAttackLogic(Character attacker, Character target, int currentTurn, int attackerBurnDamage) {
		// Handle specials for first turn attacks
		int multiplier = 1;
		
		// Spy special
		if (currentTurn == 1) {
			if (attacker instanceof Spy) {
				multiplier = 2;
			}
		}
		
		// Sniper special
		if (attacker instanceof Sniper) {
			int critChance = randomGenerator.nextInt(2);			
			multiplier = critChance + 1;
		}
			
		if (target instanceof Scout || target instanceof Brian) {
			int dodged = randomGenerator.nextInt(2);
			if (dodged == 0) {
				System.out.println(target.name + " dodged the attack!");
			} else {
				if (multiplier > 1)
					System.out.println("Critical hit!");
				attacker.attack(target, multiplier);
				
				// Pyro bonus
				if (attacker instanceof Pyro) {
					target.takeDamage(attackerBurnDamage);
				}
			}
		} else {
			if (multiplier > 1) {
				System.out.println("Critical hit!");
			}
			attacker.attack(target, multiplier);
			
			// Pyro bonus
			if (attacker instanceof Pyro) {
				target.takeDamage(attackerBurnDamage);
			}
		}
	}
	
	public static int getUserIntegerInput(String question, List<String> answerChoices) {
		int userChoice;
		
		System.out.println(question);
		
		for (int i = 0; i < answerChoices.size(); i++) {
			System.out.println((i+1) + ". " + answerChoices.get(i));
		}
		
		do {
			userChoice = intInput.nextInt();
			
			if ( !(userChoice >= 1 && userChoice <= answerChoices.size()) ) {
				System.out.println("invalid");
		}
		} while ( !(userChoice >= 1 && userChoice <= answerChoices.size()));
		
		return (userChoice - 1);
	}
}
