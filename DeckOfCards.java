
// Card Game 21
// File: DeckOfCards.java
/* Purpose: class to represent an entire deck of cards
 * 			updated from given code to use a stack
 * 			instead of arrays for the deck
*/
import java.util.*;
import java.security.SecureRandom; 

public class DeckOfCards {
 
    
    private Stack<Card> deck = new Stack<Card>(); // Card references 
    
    // constructor fills deck of Cards
    public DeckOfCards() {
        String[] faces = {"Ace", "Deuce", "Three", "Four", "Five", "Six",
            "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};  
        
        //populate deck with Card objects
        for (int count = 0; count < 52; count++) {
            deck.push(new Card(faces[count % 13], suits[count / 13]));
        } // end of for loop 
    } // end of DeckOfCards Constructor 
    
    // shuffle deck of Cards with one-pass algorithm
    public void shuffle() {
        Collections.shuffle(deck);
    } // end of shuffle method 
    
    // deal one card 
    public Card dealCard() {
        // determine whether Cards remain to be dealt
        if (deck.size()>0) {
            return deck.pop(); // return current Card in array
        }
        else {
            return null; // return null to indicate that all Cards were dealt
        } // end if/else 
    } // end of dealCard method 
} // end of DeckOfCards class 