package Poker;

public class Main {
	public static void main(String[] args) {
		//Instantiates a new deck of cards in order
		DeckOfCards deck = new DeckOfCards();
		
		//Instantiates a placeholder array for holding dealt cards
		PlayingCard[] hand = new PlayingCard[10];
		System.out.println(deck);
		
		//Shuffles the deck using the prescribed method
		deck.shuffle();
		System.out.println(deck);
		
		//Places a dealt card into the hand. The card is replaced with null in the deck.
		hand[0]= deck.dealNext();
		System.out.println(deck);
		
		//Returns the dealt card as a discarded card.
		deck.returnCard(hand[0]);
		System.out.println(deck);
		
		//Deals another card.
		hand[1] = deck.dealNext();
		System.out.println(deck);
	}
}
