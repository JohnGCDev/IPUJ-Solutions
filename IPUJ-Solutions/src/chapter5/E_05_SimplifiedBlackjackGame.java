package chapter5;
import shared.textio.TextIO;
import shared.classes.chapter5.BlackjackHand;
import shared.classes.chapter5.Deck;
import shared.classes.chapter5.Card;
import static java.lang.System.out;
/**
 * @author JDav
 * Program that lets the user play a simplified version of Blackjack game, initially the user
 * will have $100 to make bets in successive games. 
 */
public class E_05_SimplifiedBlackjackGame {

	private static BlackjackHand userHand = new BlackjackHand(), dealerHand = new BlackjackHand();
	private static Deck deck;
	private static Card card;
	
	/**
	 * @author JDav
	 * Method that prints out all the cards belonging to a specific hand.
	 * @param someHand A user's hand or a dealer's hand.
	 */
	private static void printHand(BlackjackHand someHand) {
		int countCards = someHand.getCardCount();
		for(int i=0; i<countCards; i++) {
			out.println("- " + someHand.getCard(i));
		}
	}
	
	/**
	 * @author JDav
	 * Method that allows the user to play simplified Blackjack game once.
	 * @return A boolean value that indicates whether the user wins or not.
	 */
	public static boolean play() {
		//Initialization
		deck = new Deck();
		deck.shuffle();
		userHand.clear();
		dealerHand.clear();
		//Go!
		out.println("Beginning game");
		//Deal two cards for each player
		out.println("\nDealer's Hand:");
		for(int i=0; i<2; i++) {
			dealerHand.addCard(card = deck.dealCard());
			if(i == 1) {
				out.println("- " + "??");
			}else {
				out.println("- " + card);
			}
		}
		out.println("\nYour Hand:");
		for(int i=0; i<2; i++) {
			userHand.addCard(card = deck.dealCard());
			out.println("- " + card);
		}
		int blackjackValue = userHand.getBlackjackValue();
		out.println("\nYour Blackjack value is " + blackjackValue);
		//Check for a winner
		if(dealerHand.getBlackjackValue() == 21) {	
			out.println("\nThe dealer hand's Blackjack value is 21!");
			out.println("Dealer's Hand:");
			printHand(dealerHand);
			return false;
		}
		if(userHand.getBlackjackValue() == 21) return true; //The user wins
		//If there is not a winner yet, continue the game
		char resp;
		while(true) {
			out.print("\nWould you like to hit or stand? (h/s): ");
			resp = TextIO.getlnChar();
			if(resp != 'h' && resp != 's') {
				out.println("Invalid answer, it's only allowed \"s\" or \"h\"");
				continue;
			}
			if(resp == 'h') { //The user will hit
				userHand.addCard(deck.dealCard());
				out.println("\nNow, your Hand is:");
				printHand(userHand);
				//Check the Blackjack value
				blackjackValue = userHand.getBlackjackValue(); 
				out.println("\nAnd your Blackjack value is " + blackjackValue);
				if(blackjackValue == 21) return true;
				if(blackjackValue > 21) return false;
			}else if(resp == 's') {//The user will stand
				out.println("\nThe full Dealer's Hand is:");
				printHand(dealerHand);
				blackjackValue = dealerHand.getBlackjackValue(); 
				out.println("\nAnd the dealer's Blackjack value is " + blackjackValue);
				if(blackjackValue <= 16) {//The dealer must draw a card.
					dealerHand.addCard(deck.dealCard());
					out.println("\nThe dealer must draw a card. Now, the Dealer's Hand is:");
					printHand(dealerHand);
					blackjackValue = dealerHand.getBlackjackValue(); 
					out.println("\nHence the dealer's Blackjack value is " + blackjackValue); 
				}
				//---Finally, determine the winner---
				//The dealer's hand has gone over 21
				if(blackjackValue > 21) return true;
				//Otherwise, the dealer's hand value is greater than or equal to the user's
				if(blackjackValue >= userHand.getBlackjackValue()) return false;   
				//Otherwise, the user wins
				return true;
			}
		}
	}
	
	public static void main(String[] args) {
		float total = 100.0f, bet; //Initially, the user will have $100 for bets
		out.println("Welcome to The Simplified Blackjack Game!\n");
		while(true) {
			//Make bet
			while(true) {
				out.print("You have $" + total + ", how much money do you want to bet?: ");
				bet = TextIO.getlnFloat();
				if(bet <= 0) {
					out.println("Not applicable. Invalid amount."); continue;
				}
				if(bet > total) {
					out.println("Not applicable. You only have $" + total); continue;
				}
				break;
			}
			//Play game
			out.print("\nGreat! Let's play!\n\n");
			if(play()) {//The user wins
				total += bet;
				out.println("Congratulations! You have won!");
			}else {//The user loses
				total -= bet;
				out.println("You have lost.");
				if(total == 0.0f) {
					out.println("Sorry, you have run out of money.");
					break;
				}
			}
			//Play again?
			out.print("\nWould you like to play again?(y/n): ");
			if(!TextIO.getlnBoolean()) break;
		}
		out.print("\n\nEnd of the game. Thanks for playing!");
	}
}