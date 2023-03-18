
// Card Game 21
// File: Card.java
/* Purpose: Card class to represent a single
 * 			card, updated from given file
 *			to include one more function of 
 *			toStringFace for finding Ace card
*/
public class Card {
    private final String face; // face o card ("Ace", "Deuce", ...) 
    private final String suit; // suit of card ("Hearts", Diamonds", etc)
    
    // two-argument constructor initializes card's face and suit 
    public Card(String cardFace, String cardSuit) {
        this.face = cardFace; // initialize face of card
        this.suit = cardSuit; // initialize suit of card 
    } // end of Card Constructor 
    
    // return String representation of Card value only
    public String toStringFace() {
    	return face;
    }// end of toStringFace method
    
    // return String representation of Card
    public String toString() {
        return face + " of " + suit; 
    } // end of toString method 
} // end class Card 