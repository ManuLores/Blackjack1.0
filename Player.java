package Ejercicio006;

import java.applet.Applet;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class Player {

	List<Card> cards = new ArrayList<Card>();
	Deck deck;
	int x;
	int y;

	public Player(Deck deck) {
		this.deck = deck;
		this.x = 50;
		this.y = 300;
	}

	public void takeCard() {
		Card takenCard = deck.takeCard();
		while (takenCard == null)
			takenCard = deck.takeCard();
		cards.add(takenCard);
		takenCard.setShowed(true);
	}

	public void drawCards(Graphics g, Applet observer) {
		for (int i = 0; i < cards.size(); i++) {
			// g.fillRect(50 + i * 30, 300, 30, 50);
			if (cards.get(i).isShowed())
				g.drawImage(cards.get(i).image, this.x + i * 30, this.y, Blackjack.CARD_WIDTH, Blackjack.CARD_HEIGHT,
						observer);
			else
				g.drawImage(cards.get(i).reverse, this.x + i * 30, this.y, Blackjack.CARD_WIDTH, Blackjack.CARD_HEIGHT,
						observer);
		}
	}

	public int getPoints() {
		int totalCount = 0;
		int totalAs = 0;
		for (int i = 0; i < cards.size(); i++) {
			if (cards.get(i).getValue() == 1)
				totalAs++;
			totalCount += cards.get(i).getValue();
		}
		for (int i = 0; i < totalAs; i++) {
			if (totalCount + 10 <= 21)
				totalCount += 10;
		}
		return totalCount;
	}
}
