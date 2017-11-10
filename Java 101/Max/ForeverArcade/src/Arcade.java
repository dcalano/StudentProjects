import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Arcade {
    //	Make random generator for dots in Pac-Man.
    public static Random generator;
    public static Scanner numInput;
    public static Scanner stringInput;
    public static void main(String[] args) {
      	// Initialize system variables
      	generator = new Random();
      	numInput = new Scanner(System.in);
      	stringInput = new Scanner(System.in);
        goToLobby();

    }

    public static void goToLobby() {
        System.out.println("Welcome to Forever Arcade!\n"
                + "We have many games here that you can play, but once you play you can always checkout, but can never leave!\n"
                + "Which game would you like to play?\n"
            + "1. Pacman\n"
            + "2. Galaga\n"
            + "3. Quit\n");

        int userInput;
        do {
            userInput = numInput.nextInt();
            
            if (userInput != 1 && userInput != 2 && userInput != 3) {
            	System.out.println("Invalid input, try again!");
            }
        } while (userInput != 1 && userInput != 2 && userInput != 3);

        if (userInput == 1) {
            playPacman();
        } else if (userInput == 2) {
        	playGalaga();
        } else if (userInput == 3) {
            System.out.println("Good bye!");

            // Closer scanners
            numInput.close();

            System.exit(0);
        }
    }

    public static void playPacman() {
        System.out.println("Welcome to pacman! To play, enter left, right, or straight to eat dots and avoid ghosts"
        		+ "\nLet's play!\n");
        System.out.println("Starring Pac-Man, Inky, Blinky, Pinky, and Clyde! \n");
        System.out.println("What is your name? (Hint: Don't type in Hadley or game goes into impossible mode)");
        String name = stringInput.nextLine();
        if (name.toLowerCase().equals("hadley")) {
        	System.out.println("Welp, you chose your own fate... time to suffer!");
        }
        // Print ghost credits

        // Game variables
        int forwardSpaceAvailable = 0;

        // Player variables
        int userChoice;
        int playerLives = 3;
        int score = 0;

        // Ghost variables
        boolean ghostNearby = false;
        int ghostPosition = 0;

        // Create initial straight hallway between 5 and 10 spaces
        do {
            forwardSpaceAvailable = generator.nextInt(11);
        } while (forwardSpaceAvailable < 5);


        do {
            // Check if ghost is nearby (5 / 15 = 33.33% spawn rate)
            if (name.toLowerCase().equals("hadley")) {
	        	ghostNearby = true;
            } else {
            	if (ghostNearby == false) {
	                int ghostSpawnChance = generator.nextInt(15);
	                if (ghostSpawnChance < 10) {
	                    ghostNearby = true;
	                    System.out.println("OoooOOoOoo! Lookout, a ghost is nearby!");
	                }
	            }
            }

            // Set potential ghost position and display prompt
//            System.out.println("Forward spaces available " + forwardSpaceAvailable);
            if (forwardSpaceAvailable > 0) {
                if (ghostNearby) {
                    ghostPosition = generator.nextInt(3) + 1;
                }
                
                System.out.println("[Score: " + score + "] Wakka wakka wakka! Do you want to go (1) left, (2) right, or (3) straight?");
            } else {
                if (ghostNearby) {
                    ghostPosition = generator.nextInt(2) + 1;
                }

                System.out.println("[Score: " + score + "] Wakka wakka wakka! Do you want to go (1) left or (2) right?");
            }

            // User choice can be 1, 2, 3 (if the user is not at a wall), or 17 (as a secret winning easter egg)
            do {
                userChoice = numInput.nextInt();
                if (!(userChoice == 1 || userChoice == 2 || (forwardSpaceAvailable > 0 && userChoice == 3) || userChoice == 17))
                    System.out.println("Invalid option");
            } while (!(userChoice == 1 || userChoice == 2 || (forwardSpaceAvailable > 0 && userChoice == 3) || userChoice == 17));

            if (userChoice == 1) {
                // Turn left and create a forward path of random length
                if (ghostNearby) {
                    if (ghostPosition == 1) {
                        // Player dies
                        playerLives--;
                        ghostNearby = false;
                        System.out.println("Oh no, you were eaten by a ghost!\nLives remaining: " + playerLives + "\n\n");

                        // Regenerate hallway for start of new round
                        // Create a random-length straight hallway between 5 and 10 spaces
                        do {
                            forwardSpaceAvailable = generator.nextInt(11);
                        } while (forwardSpaceAvailable < 5);
                    } else {
                        System.out.println("You evaded the ghost!");
                        ghostNearby = false;
                        int scoreToAdd = 0;
                        do {
                            scoreToAdd = generator.nextInt(11);
                        } while (scoreToAdd < 5);
                        score += scoreToAdd;

                        // Create a random-length straight hallway between 5 and 10 spaces
                        do {
                            forwardSpaceAvailable = generator.nextInt(11);
                        } while (forwardSpaceAvailable < 5);
                    }
                } else {
                    int scoreToAdd = 0;
                    do {
                        scoreToAdd = generator.nextInt(11);
                    } while (scoreToAdd < 5);
                    score += scoreToAdd;

                    // Create a random-length straight hallway between 5 and 10 spaces
                    do {
                        forwardSpaceAvailable = generator.nextInt(11);
                    } while (forwardSpaceAvailable < 5);
                }
            } else if (userChoice == 2) {
                // Turn left and create a forward path of random length
                if (ghostNearby) {
                    if (ghostPosition == 3) {
                        // Player dies
                        playerLives--;
                        ghostNearby = false;
                        System.out.println("Oh no, you were eaten by a ghost!\nLives remaining: " + playerLives + "\n\n");

                        // Regenerate hallway for start of new round
                        // Create a random-length straight hallway between 5 and 10 spaces
                        do {
                            forwardSpaceAvailable = generator.nextInt(11);
                        } while (forwardSpaceAvailable < 5);
                    } else {
                        System.out.println("You evaded the ghost!");
                        ghostNearby = false;
                        int scoreToAdd = 0;
                        do {
                            scoreToAdd = generator.nextInt(11);
                        } while (scoreToAdd < 5);
                        score += scoreToAdd;

                        // Create a random-length straight hallway between 5 and 10 spaces
                        do {
                            forwardSpaceAvailable = generator.nextInt(11);
                        } while (forwardSpaceAvailable < 5);
                    }
                } else {
                    int scoreToAdd = 0;
                    do {
                        scoreToAdd = generator.nextInt(11);
                    } while (scoreToAdd < 5);
                    score += scoreToAdd;

                    // Create a random-length straight hallway between 5 and 10 spaces
                    do {
                        forwardSpaceAvailable = generator.nextInt(11);
                    } while (forwardSpaceAvailable < 5);
                }
            } else if (userChoice == 3) {
                // Turn left and create a forward path of random length
                if (ghostNearby) {
                    if (ghostPosition == 3) {
                        // Player dies
                        playerLives--;
                        ghostNearby = false;
                        System.out.println("Oh no, you were eaten by a ghost!\nLives remaining: " + playerLives + "\n\n");
                    } else {
                        System.out.println("You evaded the ghost!");
                        ghostNearby = false;
                        int scoreToAdd = 0;
                        do {
                            scoreToAdd = generator.nextInt(11);
                        } while (scoreToAdd < 5);
                        score += scoreToAdd;
                        forwardSpaceAvailable--;
                    }
                } else {
                    int scoreToAdd = 0;
                    do {
                        scoreToAdd = generator.nextInt(11);
                    } while (scoreToAdd < 5);
                    score += scoreToAdd;
                    forwardSpaceAvailable--;
                }
            } else if (userChoice == 17) {
                System.out.println("Congratulations! You have found an easter egg! Auto-win triggered!");
                score = 100;
            }
        } while (playerLives > 0 && score < 100);

        // Game ended, print score and return to lobby
        if (score >= 100) {
            System.out.println("You won!");
        } else {
            System.out.println("Game over!");
        }

        goToLobby();
    }


    public static void playGalaga() {
    	System.out.println("Welcome to Galaga /n");
    	System.out.println("To play just chose to move (1) left, (2) right, or to (3) stay in place , then shoot! \n");
    	System.out.println("Be careful though because if you move there is a 40% chance that you will get shot, but if you don't move there is less chance of being shot (15%), but you won't be able to shoot \n");
    	System.out.println("Can you kill them all?");
    	//Game Variables
    	int leftSpaceAvailable = 0;
    	int rightSpaceAvailable = 0;
    	// Player Variables
    	int userChoice;
    	int playerLives = 3;
    	int score = 0;
    	//    	
    	goToLobby();
    }
    
    public static String getStringInput(String prompt, List<String> options) {
    	System.out.println(prompt);
    	String userInput;
    	do {
    		userInput = stringInput.nextLine();
    	} while (!options.contains(userInput));
    	
    	return userInput;
    }
}
