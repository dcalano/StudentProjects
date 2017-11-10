import java.util.Random;
import java.util.Scanner;

public class Main {
//	Make random generator for dots in Pac-Man.
	public static Random generator = new Random();
	public static Scanner numInput;

	public static void intro(){
		
		System.out.println("Welcome to Forever Arcade! We have many games here that you can play, but once you play you can always checkout, but can never leave! \t");
	}
	public static void main(String[] args) {
		goToLobby();
		
		
		
		// TODO Auto-generated method stub
		//	Create method to play Pac-Man by keeping score on how many dots are left in the game
//		public static dots(){
//			
//			while(dots > 0 && playerAlive -= true){
//				int dots = random(10);
//				
//				for(dots = 100; dots > 0; dots --){
//					System.out.println("dots left" + dots);
//				}
//			}
			
			
		
		
		
		
		
////		create num and string Scanner to let player choose what game they want to play.
//		numInput = new Scanner(System.in);
//		Scanner stringinput = new Scanner(System.in);
//		System.out.println("Chose your arcade game: Street Fighter, Pac-Man, Galaga, Donkey Kong, Space Invaders, and Pong.");
//		String game = stringinput.nextLine();
//		if(game.toLowerCase().equals("Pac-Man"));
////		Make Pac-Man a character to give him his specific attributes
//			Character player1 = new Character();
//			player1.name = "Pac-Man";
//			player1.health = 3;
			
	}
	
	public static void goToLobby() {
		
	}
	
	public static void playPacman() {
		System.out.println("Welcome to pacman! To play, enter left, right, or straight to eat dots and avoid ghosts");
		// Print ghost credits
		int userChoice = 0;
		int playerLives = 3;
		int score = 0;
		int ghostPosition = 0; // Ghost is dead if 0, alive otherwise
		int pathLength = 0;
		
		pathLength = generator.nextInt(10);
		do {
			// 40% of a ghost appearing
			if (ghostPosition == 0) {
				int ghostChance = generator.nextInt(10);
				if (ghostChance < 4) {
					System.out.println("OoooOoOo! A ghost has appeared!");
			}
			
			if (pathLength > 0) {
				System.out.println("[Score: " + score + "] Waka waka waka! Do you want to go (1) straight, (2) left, or (3) right?");
				
				if (ghostPosition != 0) {
					
				}
				
				// User action
				do {
					userChoice = numInput.nextInt();
					if (userChoice != 1 && userChoice != 2 && userChoice != 3 && userChoice != 17)
						System.out.println("Invalid input, try again.");
				} while (userChoice != 1 && userChoice != 2 && userChoice != 3 && userChoice != 17);
				
				// Determine game behavior
				if (userChoice == 1) {
					if (ghostPosition == 1) {
						System.out.println("Oh no! You got eaten by a ghost!");
					} else {
						ghostPosition = 0;
						score++;
					}
				} else if (userChoice == 2) {
					if (ghostPosition == 2) {
						System.out.println("Oh no! You got eaten by a ghost!");
					} else {
						ghostPosition = 0;
						score++;
					}
				} else if (userChoice == 3) {
					if (ghostPosition == 3) {
						System.out.println("Oh no! You got eaten by a ghost!");
					} else {
						ghostPosition = 0;
						score++;
					}
				} else if (userChoice == 17) {
					score = 100;
				} else {
					System.out.println("Invalid input");
				}
				
			// move left
			// move right
			// move straight
		// Get ghosts to randomly generate in certain pathways (40% chance of a ghost popping up)
		// Get a # of dots randomly generated (1-10) for each pathway while also saying how many dots are left after each path is taken (out of 100 dots)
		// Make Pac-Man a character that loses a life every time he meets a ghost (3 lives or health)
		// Get the game to end when Pac-Man loses 3 lives and ask the player if they want to play again with a while loop that restarts the game if they say yes.
		} while(playerLives > 0 && score < 100);
		
		// Game ended, print score and return to lobby
		if (score == 100) {
			System.out.println("You won!");
		} else {
			System.out.println("Game over!");
		}
		
		goToLobby();
	}
}		
	
	


	