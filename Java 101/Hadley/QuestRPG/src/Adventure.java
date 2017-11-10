import java.util.Random;
import java.util.Scanner;

public class Adventure {

	// Display intro text and get user details
	public static String intro(Scanner playerStringInput) {
		System.out.println("Welcome player, what is you name? ");
		String playerName = playerStringInput.nextLine();
		
		return playerName;
	}
	
	
	public static void main(String[] args) {
		// Declare system variables
		Random randomGenerator = new Random();
		Scanner playerStringInput= new Scanner(System.in);
		Scanner playerNumberInput = new Scanner(System.in);
		
		// Declare player variables
		int playerLevel = 1;
		double playerHealth = 10.0;
		String playerName;
		
	
		playerName = intro(playerStringInput);
		
		System.out.println("Welcome " + playerName);
		System.out.println("Before you there is a dark cave, do you enter");
		
		int playerChoice = getNumberInput(playerNumberInput, "1. You enter the cave.\n2. You find a new adventure");
		
		if(playerChoice == 1) {
				//player enters the cave
		
				System.out.println("You enter the dark cave.");
				playerLevel ++;
				System.out.println("Congratulations, you are now level " + playerLevel);
			
				System.out.println("Ask you continue into the cave you step on a stone tile which sinks into the ground.");
				System.out.println("Suddenly arrows start to fly at you from the walls.");
				int arrowDamage = randomGenerator.nextInt(3);
				playerHealth -= arrowDamage;
				System.out.println("The arrows hit you in the side, you recived " + arrowDamage + " Damage!");
				System.out.println("Your current health is now " + playerHealth);
				
				System.out.println("As you press on you walk into a large cavern.");
				System.out.println("Look, in the middle of the cavern is a treasure chest; however it could be a trap.");
				
				Boolean hasSword = false;
				playerChoice = getNumberInput(playerNumberInput, "1. You open the chest.\n2. You don't open the chest.");
				
				if(playerChoice == 1) {
					System.out.println("You open the chest and there is a red sword which you take.");
					hasSword = true;
					System.out.println("You enter further into the cave.");
					System.out.println("You enter into another cavern and there is the Goblin king.");
					System.out.println("Look out! He is swinging his club at you.");
					playerChoice = getNumberInput(playerNumberInput, "1. You dodge to the left.\n2. You dodge to the right.");
						
					if(playerChoice == 1) {
						System.out.println("You try to dodge to the left, and the Goblin king hits you.");
						System.out.println("The force of the impact make you fly and hit the wall.");
						int clubDamage = randomGenerator.nextInt(5);
						playerHealth -= clubDamage;
						System.out.println("You took " + clubDamage + "Damage.");
						System.out.println("Your current health is " + playerHealth);
							
						
					}
					else     {
						System.out.println("You try to doge to the right, and the Goblin king misses");
						
						if(hasSword = true)  {
							System.out.println("You use your red sword to chop of the Goblin King's hand.");
							System.out.println("The Goblin King retreats into the cave");
							playerLevel ++;
							playerLevel ++;
							System.out.println("Congratulations, you are now level " + playerLevel);
						}	
					}				
				}
				else      {
					System.out.println("You ignore the chest and continue into the cave.");
				}
		}
		else{
			// Player finds a new adventure
		}
		
		System.out.println("You leave the cave and return to your base.");
		
		
		

		playerStringInput.close();
		playerNumberInput.close();
		System.exit(0);	
			
	}

	// Ask the user a question and get either 1 or 2 as an answer, keep asking for input until the user gives a proper answer.
	public static int getNumberInput(Scanner playerNumberInput, String messageToDisplay) {
		int answer = -1;
		
		System.out.println(messageToDisplay);
		
		while (answer != 1 && answer != 2) {
			System.out.print("Enter a number: ");
			answer = playerNumberInput.nextInt();
			
			if (answer != 1 && answer != 2) {
				System.out.println("Invalid number");
			}
		}
		
		return answer;
	}
}
