package chapter5;
import shared.textio.TextIO;
import shared.classes.chapter5.BlackjackHand;
import shared.classes.chapter5.Deck;
import shared.classes.chapter5.Card;
/**
 * @author JDav
 * Program to test BlackjackHand class (shared.classes.chapter.BlackjackHand.java) by dealing 2 to 6 cards
 * from a Hand (shared.classes.chapter.Hand.java) of Cards (shared.classes.chapter.Card.java) and finally 
 * printing out these cards with along their Blackjack value as many times as the user wishes.
 */
public class E_04_TestBlackjackHand {

	public static void main(String[] args) {
		boolean resp;
		BlackjackHand hand = new BlackjackHand();
		Deck deck = new Deck();
		Card card;
		int numberCardsToDeal, numberLeftCards;
		
		System.out.print("Welcome to the test of a Blackjack Hand.\n\n");
		deck.shuffle();
		do {
			numberCardsToDeal = (int)(Math.random()*5)+2; //In range 2 to 6
			numberLeftCards = deck.cardsLeft();
			if(numberLeftCards == 0 || numberLeftCards == 1) {
				System.out.print("\n\nNo more available cards to deal in the deck. End of test."); break;
			}else if(numberLeftCards < numberCardsToDeal) {
				numberCardsToDeal = numberLeftCards; //deal only left cards
			}
			System.out.print("The Cards in your hand are:\n");
			try {
				hand.clear();
				for(int i=0; i<numberCardsToDeal; i++) {
					hand.addCard(card = deck.dealCard());
					System.out.printf("- %s%n", card);
				}
				System.out.printf("And your Blackjack value is: %d%n", hand.getBlackjackValue());
			}catch(Exception e) {
				System.out.println("An error has occurred. " + e.getMessage());
			}
			System.out.print("\nDo you wish to continue? (y/n): ");
			resp = TextIO.getlnBoolean();
		}while(resp);
	}
}
