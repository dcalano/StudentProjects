import java.util.Scanner;
public class Testing {

	public static void main(String args[]) {
		System.out.println("Hello!");
	
		Scanner playerInput;
		playerInput = new Scanner (System.in);
		String playerName;
		System.out.println("What is your name?");
		playerName = playerInput.nextLine();
		System.out.println("Hello " + playerName + ", Prepare to Battle" );
		System.out.println("Your health is 100");
		String answer;
		System.out.println("Will you fight the goblin, its health is 100");
		answer = playerInput.nextLine();
		if (answer.equals("yes")) { 
		
			int playerHealth = 100;
			int goblinHealth = 100;
			if (playerHealth > goblinHealth) {
				System.out.println("You killed the goblin");
			} else  {
				System.out.println("The goblin was too strong, and he damaged you");
				int damage = 30;
				playerHealth = playerHealth - damage;
				System.out.println("Your health is " + playerHealth);
			}
		} 
		
		
		
		
		playerInput.close();
	
	
		}
}