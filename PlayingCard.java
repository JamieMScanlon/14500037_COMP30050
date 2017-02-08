package Poker;

public class PlayingCard {
	//Variables initialized for use throughout code.
	static public final char HEARTS = 'H'; 
	static public final char SPADES = 'S';
	static public final char DIAMONDS = 'D';
	static public final char CLUBS = 'C';
	static public final int CARD_AMOUNT = 52;
	
	//Class variables initialized that characterize a Playing Card.
	private String type;
	private char suit;
	private int face_value, game_value;
	
	//Playing Card constructor that takes in arguments and assigns the values to the class variables.
	PlayingCard(String type, char suit, int face_value, int game_value){
		this.type = type;
		this.suit = suit;
		this.face_value = face_value;
		this.game_value = game_value;
	}
	
	//toString method that, based on values assigned in the constructor, merges type and suit into a string and returns it.
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(type);
		sb.append(suit);
		return sb.toString();
	}
	
	//Getters and Setters
	public String getType() {
		return this.type;
	}
	
	public char getSuit() {
		return this.suit;
	}
	
	public int getFaceValue() {
		return this.face_value;
	}
	
	public int getGameValue() {
		return this.game_value;
	}
}
