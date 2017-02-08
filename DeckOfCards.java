package Poker;
import java.util.Random;

public class DeckOfCards {
	//Card array holds all the cards in the deck.
	private PlayingCard[] cardArray = new PlayingCard[PlayingCard.CARD_AMOUNT];
	
	//This holds cards returned by the user.
	private PlayingCard[] discardArray = new PlayingCard[PlayingCard.CARD_AMOUNT];
	
	//Private variables that keep track of both arrays.
	private int top = 0, tracker = 0;
	
	//Constructor to initially create the deck when instantiated.
	public DeckOfCards(){
		this.cardArray = createCards();
	}
	
	//toString which returns a string with all the cards.
	public String toString() {
		String result = "";
		for(int i = 0; i < PlayingCard.CARD_AMOUNT; i++) {
			result += this.cardArray[i] + "\n";
		}
		return result;
	}
	
	//dealNext uses the top variable to deal the next card on top of the deck.
	public PlayingCard dealNext() {
		PlayingCard topDeck;
		if(top != 52) {
			topDeck = this.cardArray[top];
			this.cardArray[top] = null;
			top++;
			return topDeck;
		} else {
			System.out.println("No cards left in deck");
			return null;
		}
	}
	
	//A simple method to add discarded cards to an array.
	void returnCard(PlayingCard discarded) {
		discardArray[tracker] = discarded;
		tracker++;
	}
	
	//Shuffles the card 52 to the power of 2 times.
	public void shuffle() {
		PlayingCard[] toBeShuffled = this.cardArray;
		Random rand = new Random();
		int rand1, rand2;
		PlayingCard temp;
		for(int i = 0; i < Math.pow(PlayingCard.CARD_AMOUNT, 2); i++) {
			rand1 = rand.nextInt(52);
			rand2 = rand.nextInt(52);
			temp = toBeShuffled[rand1];
			toBeShuffled[rand1] = toBeShuffled[rand2];
			toBeShuffled[rand2] = temp;
		}
		this.cardArray = toBeShuffled;
	}
	
	//Creates a new deck and shuffles it.
	public void reset() {
		this.cardArray = createCards();
		shuffle();
	}
	
	//Creates the cards and puts them in an array.
	private PlayingCard[] createCards() {
		PlayingCard[] cardArray = new PlayingCard[PlayingCard.CARD_AMOUNT];
		int currentCard = 0;
		for(int i = 0; i < 4; i++) {
			for(int j = 1; j < 14; j++) {
				switch(i) {
					case 0:
						PlayingCard heartCard = new PlayingCard(typeCheck(j), PlayingCard.HEARTS, j, gameValueCheck(j));
						cardArray[currentCard] = heartCard;
						break;
					case 1:
						PlayingCard spadeCard = new PlayingCard(typeCheck(j), PlayingCard.SPADES, j, gameValueCheck(j));
						cardArray[currentCard] = spadeCard;
						break;
					case 2:
						PlayingCard diamondCard = new PlayingCard(typeCheck(j), PlayingCard.DIAMONDS, j, gameValueCheck(j));
						cardArray[currentCard] = diamondCard;
						break;
					case 3:
						PlayingCard clubCard = new PlayingCard(typeCheck(j), PlayingCard.CLUBS, j, gameValueCheck(j));
						cardArray[currentCard] = clubCard;
						break;
				}
				currentCard++;
			}
		}	
		return cardArray;
	}
	
	//Simple check that handles aces.
	private String typeCheck(int face_value) {
		if(face_value == 1) {
			return "A";
		} else if(face_value == 11) {
			return "J";
		} else if(face_value == 12) {
			return "Q";
		} else if(face_value == 13) {
			return "K";
		} else {
			return Integer.toString(face_value);
		}
	}
	
	//Simple check that handles aces.
	private int gameValueCheck(int face_value) {
		if(face_value == 1) {
			return 14;
		} else {
			return face_value;
		}
	}
}
