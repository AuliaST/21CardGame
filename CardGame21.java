
// Card Game 21
// File: CardGame21.java
/* Purpose: Create a card game representing 21
 * 			where the player plays against the computer
 * 			to get as close to a value of 21
 * 			without going over and without having 
 * 			a smaller value than the dealer's 
 * 			hand
*/
import java.util.*;
public class CardGame21 {
	
	
	public static void main(String[] args)
		{
			int result = 0;
			String quit = "test";
			Scanner decision = new Scanner(System.in);
			System.out.println("Welcome to 21");
			rules();
			// while statement that runs the main game play
			// method until a user decides to stop playing
			while(quit.charAt(0) != 'q' && quit.charAt(0) != 'Q') {
				// initializes new hands and deck of cards
				// for each new round
				PlayerHand player = new PlayerHand();
				PlayerHand dealer = new PlayerHand();
				DeckOfCards cards = new DeckOfCards();
				cards.shuffle();
				// draws 2 starting cards for both 
				// player and dealer
				for(int i = 0;i<2;i++) {
					player.draw(cards.dealCard());
					dealer.draw(cards.dealCard());
				}// end of for loop
				// runs the game play
				result = play(player, dealer, cards);
				// if/else statement that has all options that 
				// a player can lose or win at, or if they tie
				// then asks the user if they wish to play 
				// another round or not
				if(result==1) {
					System.out.println("Player has busted, Dealer wins");
					System.out.println("Enter q or Q to quit, enter any other character to play another round");
					quit = decision.next();
				}
				else if(result==2) {
					System.out.println("Player has gotten 21, you have won!");
					System.out.println("Enter q or Q to quit, enter any other character to play another round");
					quit = decision.next();
				}
				else if(result == 3){
					System.out.println("Player has beaten the dealer, you have won!");
					System.out.println("Enter q or Q to quit, enter any other character to play another round");
					quit = decision.next();
				}
				else if(result == 4){
					System.out.println("Player has drawn with the dealer, you have tied!");
					System.out.println("Enter q or Q to quit, enter any other character to play another round");
					quit = decision.next();
				}
				else if(result == 5){
					System.out.println("Player has been beaten, you have lost!");
					System.out.println("Enter q or Q to quit, enter any other character to play another round");
					quit = decision.next();
				}
				else if(result == 6){
					System.out.println("Dealer has busted, you have won!");
					System.out.println("Enter q or Q to quit, enter any other character to play another round");
					quit = decision.next();
				}// end of if/else
			}// end of while statement
			
			
			
		}// end of main method
	
	// method that just prints out the rules for 
	// the card game 21
	public static void rules() {
		System.out.println("These are the rules to the card game 21:");
		System.out.println("https://bicyclecards.com/how-to-play/blackjack/");
		System.out.println("21 is the same as blackjack except the ");
		System.out.println("betting rules are not used at all");
	}// end of method rules
	
	// method that has one game session of
	// the card game 21
	public static int play(PlayerHand player, PlayerHand dealer, DeckOfCards cards) {
		String playerChoice="";
		int ace = 0;
		int quit = 0;
		int win = 0;
		int aceFound = 0;
		boolean stand = false;
		Scanner decision = new Scanner(System.in);
		
		// prints out dealer's hand with one card hidden first 
		System.out.println("Dealer's Hand: ");
		dealer.printDealerHand();
		
		//while statement that loops until
		// the round is over
		while(quit !=1) {
			
			// first prints the player's drawn hand
			// as well as current sum of those cards
			// just to make it easier
			System.out.println("Player's Hand Total: "+ player.handSum());
			player.printHand();
			// if statement to check if an ace
			// is found in the player's hand
			// and if this question hasn't been asked before
			// it asks what value the player wants
			// the ace to be either 1 or 11
			if(player.checkAce() && aceFound == 0) {
				System.out.println("Would you like to have the ace be a value of 1 or 11?");
				System.out.println("Enter 1 for value 1 and 11 for value 11");
				ace = decision.nextInt();
				// while loop to run if a user
				// inputs something other than 1 or 11
				while(ace!=1 && ace!=11) {
					System.out.println("Please enter either 1 or 11");
					ace = decision.nextInt();
				}// end of while
				// sets chosen ace value
				player.aceValue(ace);
			}// end of if
			System.out.println();
			System.out.println("Would you like to hit (h) or stand (s)");
			playerChoice = decision.next();
			
			// while loop that runs as long as a user
			// does not enter either an h or s value
			while(playerChoice.charAt(0) != 'h' && playerChoice.charAt(0) != 's') {
				System.out.println("Please enter either h to hit or s to stand");
				playerChoice = decision.next();
			}// end of while
			
			// switch to go between either 
			// a player choosing to hit or stand
			switch(playerChoice.charAt(0)) {
			// if hit then players
			// gets another card
			case 'h':
				player.draw(cards.dealCard());
				break;
			// if stand then raises flag to indicate
			// stand was chosen and player's turn is over
			case 's':
				System.out.println("the player has chosen to stand");
				stand = true;
				break;
			}
			
			// immediately checks if player got more than 21
			if(player.handSum()>21) {
				System.out.println("Players total: "+player.handSum());
				win = 1;
				quit = 1;
				
			}
			// then checks if player got 21 
			else if(player.handSum()== 21) {
				win = 2;
				quit = 1;
			}
			// otherwise goes to computer's turn
			else if(stand) {
				// prints out user's hand just for easier
				// readability for user
				System.out.println("Player's Hand Total: "+ player.handSum());
				player.printHand();
				// flag if computer's hand was either
				// at 17 or below
				int notSmall = 0;
				dealer.playerPlayed();
				// if statement if a dealer has an ace
				// following the rules that if the 
				// dealer has less than 17 with ace
				// being 1, it must make it 11,
				// otherwise it will stay at 1
				if(dealer.checkAce()) {
					if(dealer.handSum() + 10>=17 && dealer.handSum()+10 <=21) {
						dealer.aceValue(11);
					}
					else {
						dealer.aceValue(1);
					}// end if/else
				}// end if
				
				// while method to draw cards
				// for the dealer until they have
				// 17 or more
				while(dealer.handSum()<17) {
					System.out.println("Dealer has less than 17, must draw");
					dealer.draw(cards.dealCard());
					System.out.println("Dealers Hand Total: "+dealer.handSum());
					
					dealer.printDealerHand();
					// flags that the dealer had to draw
					notSmall = 1;
				}// end while
				// if the dealer did not have to draw
				// will print dealer's total so 
				// user can see what the dealer's hand was
				// otherwise will not print again if while 
				// loop above was run
				if(notSmall==0) {
					System.out.println("Dealers Hand Total: "+dealer.handSum());
					dealer.printDealerHand();
				}// end if
				
				// if statement to check if dealer did not bust
				if(dealer.handSum()<=21) {
					// checks if user has more than dealer
					if(player.handSum()>dealer.handSum()) {
						win = 3;
						quit = 1;
					}
					// checks if they tied
					else if(player.handSum()==dealer.handSum()) {
						win = 4;
						quit = 1;
					}
					// checks if player lost to user
					else if(player.handSum()<dealer.handSum()) {
						win = 5;
						quit = 1;
					}// end if/else
				}// end if
				// otherwise dealer busted
				// while drawing
				else {
					win = 6;
					quit =1;
				}// end if/else
				
			}// end if/else
			
			
			

			
		}// end while 
		// returns what kind of win or
		// loss the user got
		return win;
		
		
		
	}// end method play

}
