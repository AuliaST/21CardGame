
// Card Game 21
// File:	PlayerHand.java
/* Purpose: class to represent a player's hand
 * 			for the card game 21. allows to
 * 			find hand sum, if there is an
 * 			ace present, and what value
 *			the ace should be represented as
 *			well as others
*/
import java.util.*;
public class PlayerHand {
	// stack to represent the player's hand
	private Stack<Card> deck;
	private int total;
	// boolean to see if it is 
	// dealer's turn or not
	private boolean dealerShows;
	// determines value of ace
	private boolean bigAce;
	
	// constructor method for a player's hand
	public PlayerHand() {
		this.deck = new Stack<Card>();
		this.total = 0;
		this.dealerShows=false;
		this.bigAce = false;
	}// end of PlayerHand
	
	// returns the sum of the players hand
	public int handSum() {
		// creates a clone stack
		// to find values of the 
		// player's hand
		Stack <Card> clone = new Stack<Card>();
		clone.addAll(this.deck);
		this.total = 0;
		int size= clone.size();
		// for loop that runs through the size of the 
		// player's hand
		for(int i = 0; i <size;i++) {
			// switch off of the player's card's
			// face to lower case so I saved time
			// typing the words out 
			switch(clone.pop().toStringFace().toLowerCase()) {
			case "ace":
				// based on the chosen value of the 
				// ace, adds either 11 to the total
				// or just 1
				if(bigAce) {
					this.total+=11;
				}
				else {
					this.total++;
				}
				break;
			case "deuce":
				this.total+=2;
				break;
			case "three":
				this.total+=3;
				break;
			case "four":
				this.total+=4;
				break;
			case "five":
				this.total+=5;
				break;
			case "six":
				this.total+=6;
				break;
			case "seven":
				this.total+=7;
				break;
			case "eight":
				this.total+=8;
				break;
			case "nine":
				this.total+=9;
				break;
			case "ten":
				this.total+=10;
				break;
			case "jack":
				this.total+=10;
				break;
			case "queen":
				this.total+=10;
				break;
			case "king":
				this.total+=10;
				break;
			
			}// end switch
		}// end for loop
		// returns sum of hand
		return (this.total);
	}// end of total method
	
	// method to add a card
	// from the deck to the hand
	public void draw(Card cardFromDeck) {
		this.deck.push(cardFromDeck);
		
	}// end draw
	
	
	// method to print out the 
	// player's hand
	public void printHand() {
		Stack <Card> clone = new Stack<Card>();
		clone.addAll(this.deck);
		Card tempCard;
		int size = deck.size();
		// for loop to print all cards in the 
		// player's hand
		for(int i = 0; i<size;i++) {
			System.out.print("|"+clone.pop().toString()+"| ");
			
		}// end for
		System.out.println();
	}// end printHand
	
	// Method to print out dealer's hand
	// it's own method because 
	// it will print a hidden card before
	// the player finishes their turn
	// and then shows their whole hand
	// after player has finished their turn
	public void printDealerHand() {
		Stack <Card> clone = new Stack<Card>();
		clone.addAll(this.deck);
		Card tempCard;
		int size = deck.size();
		// if to print all cards in dealer's hand
		// if player finished their turn
		if(this.dealerShows) {
			// for loop to print out all dealer's cards
			for(int i = 0; i<size;i++) {
				System.out.print("|"+clone.pop().toString()+"| ");
			
			}// end  for
			System.out.println();
		}
		// otherwise prints one card
		// and a hidden card if still
		// player's turn
		else {
			System.out.println("|=======| |"+clone.pop().toString()+"|");
		}// end if/else
		
	}// end printDealerHand
	
	// method to know that the player
	// has finished their turn
	public void playerPlayed() {
		this.dealerShows = true;
	}// end playerPlayed
	
	// method to check if there is an ace
	// in the player's hand
	public boolean checkAce() {
		Stack <Card> clone = new Stack<Card>();
		clone.addAll(this.deck);
		Card temp;
		int size = deck.size();
		// for loop to search through
		// whole hand
		for(int i = 0;i<size;i++) {
			temp = clone.pop();
			// if ace is found, return true
			if(temp.toStringFace() == "Ace") {
				return true;
			}// end if
		}// end for
		// else return false
		return false;
		
	}// end checkAce
	
	// method to record player's choice
	// for ace's value
	public void aceValue(int eleven) {
		// if input is 1 then
		// ace value is 1,
		// otherwise ace is considered value
		// 11
		if(eleven==1) {
			bigAce = false;
		}
		else {
			bigAce = true;
		}// end if/else
	}// end aceValue
}
