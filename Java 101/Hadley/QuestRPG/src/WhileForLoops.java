import java.util.Random;

public class WhileForLoops {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random generator = new Random();
		
		int playerHealth, monsterHealth;
		
		playerHealth = 100;
		monsterHealth = generator.nextInt(10) + 1;
		
		while(playerHealth > 0) { 
			System.out.println("You have " + playerHealth + "health");
			int playerDamage = generator.nextInt(5) + 1;
			int monsterDamage = generator.nextInt(3) + 1;
			playerHealth -= monsterDamage;
			monsterHealth -= playerDamage;
		}
			
	}

}
