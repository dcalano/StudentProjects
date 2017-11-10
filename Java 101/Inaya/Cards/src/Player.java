import java.util.ArrayList;
import java.util.List;

public class Player {

	String name;
	int score;
	List<WhiteCard> cards;

	public Player(String name) {
		this.name = name;
		this.score = 0;
		this.cards = new ArrayList<>();
	}
	
	public void increaseScore() {
		this.score++;
	}
	
	public void resetScore() {
		this.score = 0;
	}
	
	public int getScore() {
		return score;
	}
	
	// Card stuff
	public void addCard(WhiteCard card) {
		this.cards.add(card);
	}
	
	public void addCards(List<WhiteCard> cards) {
		this.cards.addAll(cards);
	}
	
	public void clearCards() {
		this.cards = new ArrayList<>();
	}
	
	public WhiteCard playCard(int cardIndex) {
		WhiteCard card = cards.get(cardIndex);
		cards.remove(cardIndex);
		return card;
	}
	
	public List<WhiteCard> getCards() {
		return this.cards;
	}
}
