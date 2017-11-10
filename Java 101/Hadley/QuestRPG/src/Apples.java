import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Apples {

	public static void main(String[] args) {
		// System variables
		Scanner userInput = new Scanner(System.in);
		
		// Game variables
		int numPlayers;
		List<String> players = new ArrayList<>();
		List<Integer> playerScores = new ArrayList<>();
		String currentJudge;
		
		// Start Game
		// Choose number of players
		
		// Enter player names
		System.out.println("Invisible line");
		hideScreen();
		System.out.println("Visible line");
	}

	public final static void hideScreen() {
	    for (int i = 0; i < 50; i++) {
	    	System.out.println("\n");
	    }
	}
}
