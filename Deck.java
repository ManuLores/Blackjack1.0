package Ejercicio006;

import java.util.Random;

public class Deck {

	Card[] cards;
	int numberOfDecks;

	public Deck(int numberOfDecks, Blackjack blackjack) {
		cards = new Card[numberOfDecks * 52];
		for (int i = 0; i < numberOfDecks; i++) {
			for (int j = 0; j < 52; j++) {
				cards[j + (i * j)] = new Card(Blackjack.CARDVALUES[j], Blackjack.cards[j], blackjack);
			}
		}
		this.numberOfDecks = numberOfDecks;
	}

	public Card takeCard() {
		Card selectedCard;
		try {
			int random = new Random().nextInt(cards.length) - 1;
			selectedCard = cards[random];
			while (selectedCard.isUsed()) {
				random = new Random().nextInt(cards.length) - 1;
				selectedCard = cards[random];
			}
			return selectedCard;
		} catch (NullPointerException e) {
		}
		;
		return null;
	}

}
