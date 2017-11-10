import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

public class Main { 
	
	public static Scanner stringInput;
	public static Scanner intInput;
	public static Random generator = new Random();
	
	public static int numBlackCards = 34;
	public static int numWhiteCards = 209;
	
	static List<BlackCard> blackDeck = new ArrayList<>();
	static List<WhiteCard> whiteDeck = new ArrayList<>();
	
	public static void main(String[] args) {
		// System variables
		stringInput = new Scanner(System.in);
		intInput = new Scanner(System.in);
		
		// Game variables
		List<Player> allPlayers = new ArrayList<>();
		int currentJudgeIndex = -1;
		Player currentJudge;
		List<Player> playersForCurrentRound = new ArrayList<>();
		List<WhiteCard> currentPlayedCards = new ArrayList<>();
	
		// Initialize game stuff
		setWhiteCards();
		setBlackCards();
		allPlayers = initPlayers();
		
		for (int round = 1; round <= 10; round++) {
			// Set judge
			currentJudgeIndex++;
			if (currentJudgeIndex == allPlayers.size())
				currentJudgeIndex = 0;
			currentJudge = allPlayers.get(currentJudgeIndex);
			
			// Set up players
			playersForCurrentRound.clear();
			playersForCurrentRound.addAll(allPlayers);
			playersForCurrentRound.remove(currentJudgeIndex);
//			for (int i = 0; i < playersForCurrentRound.size(); i++) {
//				System.out.println("Player: " + playersForCurrentRound.get(i).name);
//			}
			
			// Clear cards
			currentPlayedCards = new ArrayList<>();
			
			System.out.println("\n\nRound " + round + "!");
			System.out.println("Current judge: " + currentJudge.name + "\n");

			for (int p = 0; p < playersForCurrentRound.size(); p++) {
				playersForCurrentRound.get(p).addCard(drawWhiteCard());
			}
			
			// Play a black card
			BlackCard currentBlackCard = drawBlackCard();
			System.out.println(currentBlackCard.cardText);
			
			// Every player chooses a white card to play except judge
			for (int p = 0; p < playersForCurrentRound.size(); p++) {
				Player currentPlayer = playersForCurrentRound.get(p);
				System.out.println("\nWhich card will your play, " + currentPlayer.name + "?");
				currentPlayedCards.add(getPlayerCardChoice(currentPlayer));
				System.out.println("\n\n\n");
			}
			
			// Judge picks winner
			System.out.println(currentJudge.name + ", pick a winner!");
			for (int i = 0; i < playersForCurrentRound.size(); i++) {
				System.out.println((i + 1) + ". " + playersForCurrentRound.get(i).name + " played \"" + currentPlayedCards.get(i).cardText + "\"");
			}
			
			int choice = intInput.nextInt();

			//Update user stats
			Player winner = playersForCurrentRound.get(choice - 1);
			System.out.println("Winner of the round is: " + winner.name + "!" );
			allPlayers.get( allPlayers.indexOf(winner) ).increaseScore();
		}
		
		// Display final scores
		System.out.println("Scores");
		for (int i = 0; i < allPlayers.size(); i++) {
			System.out.println(allPlayers.get(i).name + ": " + allPlayers.get(i).getScore());
		}

		System.out.println("\n\nGame over");
	}

	//Black card text
	public static void setBlackCards() {
		blackDeck.add(new BlackCard("But before I kill you Mr.Bond, I must show you _______."));
		blackDeck.add(new BlackCard("Here is the church, here is the steeple, open the doors and there is _________."));
		blackDeck.add(new BlackCard("Trust me; I'm ___________."));
		blackDeck.add(new BlackCard("____________, don't try this at home."));
		blackDeck.add(new BlackCard("You can't be serious! ________________ is absolutely a social construct."));
		blackDeck.add(new BlackCard("My new favorite food truck is ___________."));
		blackDeck.add(new BlackCard("What's my secret power?"));
		blackDeck.add(new BlackCard("What do old people smell like?"));
		blackDeck.add(new BlackCard("What are my parents hiding from me?"));
		blackDeck.add(new BlackCard("_________. It's a trap!"));
		blackDeck.add(new BlackCard("I always carry _______ in my purse."));
		blackDeck.add(new BlackCard("We've become a nation of ________."));
		blackDeck.add(new BlackCard("Now on Instagram:__________!"));
		blackDeck.add(new BlackCard("What gets better with age?"));
		blackDeck.add(new BlackCard("What am I giving up for lent?"));
		blackDeck.add(new BlackCard("What's that smell?"));
		blackDeck.add(new BlackCard("Why can't I sleep at night?"));
		blackDeck.add(new BlackCard("What would Jesus do?") );
		blackDeck.add(new BlackCard("What are we waiting for?"));
		blackDeck.add(new BlackCard("Netflix and ________."));
		blackDeck.add(new BlackCard("_____________. High Five bro."));
		blackDeck.add(new BlackCard("____________, betcha can't have just one."));
		blackDeck.add(new BlackCard("What's the most emo?"));
		blackDeck.add(new BlackCard("May the ______ be with you"));
		blackDeck.add(new BlackCard("How am I maintaining my relationship status?"));
		blackDeck.add(new BlackCard("What did I bring back from Mexico?"));
		blackDeck.add(new BlackCard("I'm not racist or anything, but I really don't like __________."));
		blackDeck.add(new BlackCard("#_______________- problems") );
		blackDeck.add(new BlackCard("In space, no one can hear _____________."));
		blackDeck.add(new BlackCard("I get by with a little help from __________."));
		blackDeck.add(new BlackCard("Dear Abby, I'm having trouble with _________ and I really need your advice."));
		blackDeck.add(new BlackCard("____________ cuts deeper than swords"));
		blackDeck.add(new BlackCard("During high school, I never really fit in until I found ____________ club."));
		blackDeck.add(new BlackCard("Maybe she's born with it, maybe it's _____________."));
		blackDeck.add(new BlackCard("When Pharoah remained unmoved Moses called down a Plague of ___________."));
	}
	
	//White card text
	public static void setWhiteCards() {
		whiteDeck.add(new WhiteCard("Obesity."));
		whiteDeck.add(new WhiteCard("Hope."));
		whiteDeck.add(new WhiteCard("BATMAN!!!!"));
		whiteDeck.add(new WhiteCard("New Age Music."));
		whiteDeck.add(new WhiteCard("Michelle Obama's Arms"));
		whiteDeck.add(new WhiteCard("Britney Spears at 55"));
		whiteDeck.add(new WhiteCard("The Make a Wish Foundation"));
		whiteDeck.add(new WhiteCard("Flightless birds"));
		whiteDeck.add(new WhiteCard("Emma Watson"));
		whiteDeck.add(new WhiteCard("Hot cheese."));
		whiteDeck.add(new WhiteCard("People."));
		whiteDeck.add(new WhiteCard("Nicholas Cage"));
		whiteDeck.add(new WhiteCard("Acne"));
		whiteDeck.add(new WhiteCard("Your Face"));
		whiteDeck.add(new WhiteCard("Bees?"));
		whiteDeck.add(new WhiteCard("Barack Obama"));
		whiteDeck.add(new WhiteCard("Donald Trump"));
		whiteDeck.add(new WhiteCard("A Bop it!"));
		whiteDeck.add(new WhiteCard("Being Rich"));
		whiteDeck.add(new WhiteCard("Natural Selection"));
		whiteDeck.add(new WhiteCard("Attitude"));
		whiteDeck.add(new WhiteCard("Men"));
		whiteDeck.add(new WhiteCard("Women"));
		whiteDeck.add(new WhiteCard("Teenagers"));
		whiteDeck.add(new WhiteCard("Throwing someone into a volcano"));
		whiteDeck.add(new WhiteCard("Tumblr"));
		whiteDeck.add(new WhiteCard("Snapchat"));
		whiteDeck.add(new WhiteCard("'Tweeting'"));
		whiteDeck.add(new WhiteCard("The end of time."));
		whiteDeck.add(new WhiteCard("Americans"));
		whiteDeck.add(new WhiteCard("Racists"));
		whiteDeck.add(new WhiteCard("A Soap Opera"));
		whiteDeck.add(new WhiteCard("A barbie"));
		whiteDeck.add(new WhiteCard("sad clowns"));
		whiteDeck.add(new WhiteCard("Myself."));
		whiteDeck.add(new WhiteCard("Plaigarism"));
		whiteDeck.add(new WhiteCard("Jesus"));
		whiteDeck.add(new WhiteCard("Easy Bake Ovens"));
		whiteDeck.add(new WhiteCard("My Self Esteem"));
		whiteDeck.add(new WhiteCard("My report card"));
		whiteDeck.add(new WhiteCard("My parents' expectations"));
		whiteDeck.add(new WhiteCard("Cultural Appropriation"));
		whiteDeck.add(new WhiteCard("Childrens."));
		whiteDeck.add(new WhiteCard("Air from my lungs"));
		whiteDeck.add(new WhiteCard("The Blood of Christ"));
		whiteDeck.add(new WhiteCard("Jobs"));
		whiteDeck.add(new WhiteCard("Being Marginalized"));
		whiteDeck.add(new WhiteCard("That."));
		whiteDeck.add(new WhiteCard("Adventures"));
		whiteDeck.add(new WhiteCard("My inner demons"));
		whiteDeck.add(new WhiteCard("The Boy Scouts of America"));
		whiteDeck.add(new WhiteCard("Pancakes"));
		whiteDeck.add(new WhiteCard("Finding out Santa isn't real"));
		whiteDeck.add(new WhiteCard("Directioners"));
		whiteDeck.add(new WhiteCard("Hipsters"));
		whiteDeck.add(new WhiteCard("Science."));
		whiteDeck.add(new WhiteCard("A Spaceship."));
		whiteDeck.add(new WhiteCard("A sad relationship"));
		whiteDeck.add(new WhiteCard("'President' Donald"));
		whiteDeck.add(new WhiteCard("20 million Dollars"));
		whiteDeck.add(new WhiteCard("Crippling Debt"));
		whiteDeck.add(new WhiteCard("Whining"));
		whiteDeck.add(new WhiteCard("An Army of Skeletons"));
		whiteDeck.add(new WhiteCard("Farts"));
		whiteDeck.add(new WhiteCard("Horrible People."));
		whiteDeck.add(new WhiteCard("My nightmares."));
		whiteDeck.add(new WhiteCard("Democracy."));
		whiteDeck.add(new WhiteCard("Justin Beiber"));
		whiteDeck.add(new WhiteCard("The Heart of a Child"));
		whiteDeck.add(new WhiteCard("My First Born Child"));
		whiteDeck.add(new WhiteCard("Miranda Cosgrove"));
		whiteDeck.add(new WhiteCard("Fan Fiction"));
		whiteDeck.add(new WhiteCard("A Spoiler Alert"));
		whiteDeck.add(new WhiteCard("A Banana"));
		whiteDeck.add(new WhiteCard("The end of time itself!"));
		whiteDeck.add(new WhiteCard("My rage"));
		whiteDeck.add(new WhiteCard("My vengeance"));
		whiteDeck.add(new WhiteCard("'texting'"));
		whiteDeck.add(new WhiteCard("Nickelback"));
		whiteDeck.add(new WhiteCard("The American Dream"));
		whiteDeck.add(new WhiteCard("Medicine"));
		whiteDeck.add(new WhiteCard("Gingers"));
		whiteDeck.add(new WhiteCard("Ginger Supremisists"));
		whiteDeck.add(new WhiteCard("'Real Talk'"));
		whiteDeck.add(new WhiteCard("First World Problems"));
		whiteDeck.add(new WhiteCard("Every Disney Princess, in order"));
		whiteDeck.add(new WhiteCard("The Fresh Prince of Bel Air"));
		whiteDeck.add(new WhiteCard("Miss piggy"));
		whiteDeck.add(new WhiteCard("casual."));
		whiteDeck.add(new WhiteCard("wrestling."));
		whiteDeck.add(new WhiteCard("Nuns"));
		whiteDeck.add(new WhiteCard("being on fire"));
		whiteDeck.add(new WhiteCard("Being Politically Correct"));
		whiteDeck.add(new WhiteCard("Being a Mall Cop"));
		whiteDeck.add(new WhiteCard("University Senate"));
		whiteDeck.add(new WhiteCard("Pity Favors"));
		whiteDeck.add(new WhiteCard("Dobby's Sock"));
		whiteDeck.add(new WhiteCard("Poppies!"));
		whiteDeck.add(new WhiteCard("Emotions?"));
		whiteDeck.add(new WhiteCard("My soul."));
		whiteDeck.add(new WhiteCard("Refusing to eat brown m&m's"));
		whiteDeck.add(new WhiteCard("Dancing"));
		whiteDeck.add(new WhiteCard("Graduating"));
		whiteDeck.add(new WhiteCard("The Ivy's"));
		whiteDeck.add(new WhiteCard("Eating Chicken Nuggets"));
		whiteDeck.add(new WhiteCard("Breathing"));
		whiteDeck.add(new WhiteCard("The Third World"));
		whiteDeck.add(new WhiteCard("Julia Roberts"));
		whiteDeck.add(new WhiteCard("The Smurfs"));
		whiteDeck.add(new WhiteCard("Uranus"));
		whiteDeck.add(new WhiteCard("Stuff and Things"));
		whiteDeck.add(new WhiteCard("A Pinata"));
		whiteDeck.add(new WhiteCard("Peanut Butter Jelly Time"));
		whiteDeck.add(new WhiteCard("Over 9000 Subscribers"));
		whiteDeck.add(new WhiteCard("Fanfiction"));
		whiteDeck.add(new WhiteCard("Trash."));
		whiteDeck.add(new WhiteCard("Ellen Degenerous"));
		whiteDeck.add(new WhiteCard("A Supersoaker full of cat pee"));
		whiteDeck.add(new WhiteCard("Google+"));
		whiteDeck.add(new WhiteCard("MySpace"));
		whiteDeck.add(new WhiteCard("google stalking your date"));
		whiteDeck.add(new WhiteCard("Poor Life Choices"));
		whiteDeck.add(new WhiteCard("Free Samples"));
		whiteDeck.add(new WhiteCard("Not All Men"));
		whiteDeck.add(new WhiteCard("Unlimited Soup, Salad, and Breaksticks"));
		whiteDeck.add(new WhiteCard("Boogers"));
		whiteDeck.add(new WhiteCard("HOT PIE!!"));
		whiteDeck.add(new WhiteCard("ALL OF IT!"));
		whiteDeck.add(new WhiteCard("What's her face"));
		whiteDeck.add(new WhiteCard("Speaking fake french"));
		whiteDeck.add(new WhiteCard("Public Restrooms"));
		whiteDeck.add(new WhiteCard("Cat Videos"));
		whiteDeck.add(new WhiteCard("Fancy Feast"));
		whiteDeck.add(new WhiteCard("World Peace"));
		whiteDeck.add(new WhiteCard("Hilary Clinton"));
		whiteDeck.add(new WhiteCard("Blurry Photos"));
		whiteDeck.add(new WhiteCard("Where the Sun Shines"));
		whiteDeck.add(new WhiteCard("Laughing Crazily"));
		whiteDeck.add(new WhiteCard("Fangirls"));
		whiteDeck.add(new WhiteCard("Yogurt Commercials"));
		whiteDeck.add(new WhiteCard("Lady Gaga"));
		whiteDeck.add(new WhiteCard("Important news about Taylor Swift"));
		whiteDeck.add(new WhiteCard("A Balanced Breakfast"));
		whiteDeck.add(new WhiteCard("Magic Beans"));
		whiteDeck.add(new WhiteCard("Johnny Depp's Mascara"));
		whiteDeck.add(new WhiteCard("Mouthwash"));
		whiteDeck.add(new WhiteCard("Disney World"));
		whiteDeck.add(new WhiteCard("Cheeseburger!"));
		whiteDeck.add(new WhiteCard("swords"));
		whiteDeck.add(new WhiteCard("Robot Arms"));
		whiteDeck.add(new WhiteCard("Cards Against Humanity"));
		whiteDeck.add(new WhiteCard("Your sister"));
		whiteDeck.add(new WhiteCard("Sorry?"));
		whiteDeck.add(new WhiteCard("Mila Kunis"));
		whiteDeck.add(new WhiteCard("A Dog Show"));
		whiteDeck.add(new WhiteCard("Duckfaces"));
		whiteDeck.add(new WhiteCard("Winter Break"));
		whiteDeck.add(new WhiteCard("Taxi Drivers"));
		whiteDeck.add(new WhiteCard("Resting B**** Face"));
		whiteDeck.add(new WhiteCard("Growing Up"));
		whiteDeck.add(new WhiteCard("Coming of Age"));
		whiteDeck.add(new WhiteCard("Lunchables"));
		whiteDeck.add(new WhiteCard("It's a trap!"));
		whiteDeck.add(new WhiteCard("The Dark Side"));
		whiteDeck.add(new WhiteCard("The Light Side"));
		whiteDeck.add(new WhiteCard("Yoda"));
		whiteDeck.add(new WhiteCard("My knowledge"));
		whiteDeck.add(new WhiteCard("My father"));
		whiteDeck.add(new WhiteCard("Bad Feels"));
		whiteDeck.add(new WhiteCard("A Dissapointing Birthday Party"));
		whiteDeck.add(new WhiteCard("A Small Horse"));
		whiteDeck.add(new WhiteCard("Being Fabulous"));
		whiteDeck.add(new WhiteCard("A Super Massive Black Hole"));
		whiteDeck.add(new WhiteCard("Republicans"));
		whiteDeck.add(new WhiteCard("Democrats"));
		whiteDeck.add(new WhiteCard("Sarah Palin"));
		whiteDeck.add(new WhiteCard("Oversized Lolipops"));
		whiteDeck.add(new WhiteCard("Exactly what you'd expect"));
		whiteDeck.add(new WhiteCard("20 Minutes"));
		whiteDeck.add(new WhiteCard("Madonna's arms"));
		whiteDeck.add(new WhiteCard("Jennifer Lawrence's at the Afterparty "));
		whiteDeck.add(new WhiteCard("A Sippy Cup of Sprite"));
		whiteDeck.add(new WhiteCard("Bill Nye the Science Guy"));
		whiteDeck.add(new WhiteCard("Not Giving a Crap"));
		whiteDeck.add(new WhiteCard("The Force."));
		whiteDeck.add(new WhiteCard("New Year's Day"));
		whiteDeck.add(new WhiteCard("Tom Cruise"));
		whiteDeck.add(new WhiteCard("College"));
		whiteDeck.add(new WhiteCard("Pandas"));
		whiteDeck.add(new WhiteCard("Cute Boys"));
		whiteDeck.add(new WhiteCard("Harry Potter"));
		whiteDeck.add(new WhiteCard("Preteens"));
		whiteDeck.add(new WhiteCard("Doing the right thing"));
		whiteDeck.add(new WhiteCard("Sunshine and Rainbows"));
		whiteDeck.add(new WhiteCard("My Relationship Status"));
		whiteDeck.add(new WhiteCard("My mom"));
		whiteDeck.add(new WhiteCard("Vampire Ninjas"));
		whiteDeck.add(new WhiteCard("An elevator of blood"));
		whiteDeck.add(new WhiteCard("A swarm of eels"));
		whiteDeck.add(new WhiteCard("Those meddling kids"));
		whiteDeck.add(new WhiteCard("Free candy from strangers"));
		whiteDeck.add(new WhiteCard("Shame"));
		whiteDeck.add(new WhiteCard("Hoarders"));
		whiteDeck.add(new WhiteCard("God hating me"));
		whiteDeck.add(new WhiteCard("Stealing wheelchairs"));
		whiteDeck.add(new WhiteCard("Party Poopers"));
		whiteDeck.add(new WhiteCard("Frolicking"));
		whiteDeck.add(new WhiteCard("Authentic Mexican Cuisine"));
		whiteDeck.add(new WhiteCard("All of my secrets"));
		whiteDeck.add(new WhiteCard("Actually taking candy from a baby"));
		
	}
	
	public static List<Player> initPlayers() {
		List<Player> players = new ArrayList<>();
		
		// Display instructions
		System.out.println("How to Play Apples Against Humanity");
		System.out.println("1] Users will have to choose how many players will be participating");
		System.out.println("2]Users will input their names, each user will get 7 random cards");
		System.out.println("3]The screen will display the name of the judge at the start of each round");
		System.out.println("and all other players will have to select a card from their deck for the 'topic' or 'black card'");
		System.out.println("4]At the end of each round the judge will have to select the winner of the round who will get one point");
		System.out.println("5]After 15 rounds, whoever has the most points wins the game!\n\n\n");
		
		System.out.println("How many players do you have?");
		int playernumber = intInput.nextInt();
		
		for (int currentPlayerSetup = 0; currentPlayerSetup < playernumber; currentPlayerSetup++) {
			String name;
			System.out.println("What is your name player " + (currentPlayerSetup + 1) + "?");
			name = stringInput.nextLine();
			
			// Give them 7 cards
			List<WhiteCard> startingCards = new ArrayList<>();
			for (int i = 0; i < 7; i++) {
				startingCards.add(drawWhiteCard());
			}
			
			Player player = new Player(name);
			player.addCards(startingCards);
			players.add(player);
		}
		
		return players;
	}

	
	public static BlackCard drawBlackCard() {
		BlackCard card = blackDeck.get( generator.nextInt(blackDeck.size()) );
		blackDeck.remove(card);
		return card;
	}
	
	public static WhiteCard drawWhiteCard() {
		WhiteCard card = whiteDeck.get( generator.nextInt(whiteDeck.size()) );
		whiteDeck.remove(card);
		return card;
	}
	
	public static WhiteCard getPlayerCardChoice(Player player) {
		List<WhiteCard> playerCards = player.getCards();
		
		for (int i = 0; i < playerCards.size(); i++) {
			System.out.println((i + 1) + ". " + playerCards.get(i).cardText);
		}
		
		int choice = intInput.nextInt();
		WhiteCard chosenCard = player.playCard(choice - 1);
		return chosenCard;
	}
}
