import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class LecturePractice {

	public static Scanner scanner=null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		scanner = new Scanner(System.in);
		
		String player="bob";
		if (player.equals("bob")){
			System.out.println("Game over."); 
		}
		//If statement. This if statement says that if the player is Bob,
		//than it should say that the game is over. The player is bob, so when you run the code it says "game over"
	
		int players=100;
		while ( players>= 0 ) { 
			System.out.println("Joining new game...");
			players--;
		}

		for ( int i=100; i<10 ; i=i-79){
			
		}
		
		List<String> Classmates=new ArrayList<>();
		Classmates.add("Charlotte");
		Classmates.add("Audrey");
		Classmates.add("Zach");
		Classmates.add("Zhana");
		System.out.print(Classmates.get(0));
		
		
		
		
		System.out.print("Dog breeds by intelligence");
		List<String>dogbreeds=new ArrayList<>();
		dogbreeds.add("Border Collie");
		dogbreeds.add("Poodle");
		dogbreeds.add("German Sheperd");
		dogbreeds.add("Doberman Pinscher");
		
		String variable=getanswer("What do you think the smartest dog breed is?", dogbreeds);
		
	}
	
	public static String getanswer (String question, List<String> answers ){
		System.out.println(question);
		
		for( int i=0; i<answers.size(); i++){
			System.out.println((i + 1) + ". " + answers.get(i));
		}

		String var="";
		do {
			var =scanner.nextLine();
		} while (!answers.contains(var));
		
		return var;
	} 

}
