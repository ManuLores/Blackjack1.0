package Ejercicio006;

import java.applet.Applet;
import java.awt.Graphics;

public class CardBack extends Card {

	public CardBack(Blackjack blackjack) {
		super(-1, "reverso", blackjack);
		this.x = 450;
		this.y = 50;
		this.width = Blackjack.CARD_WIDTH;
		this.height = Blackjack.CARD_HEIGHT;
	}

	public void drawCard(Graphics g, Applet observer) {
		g.drawImage(this.image, this.x, this.y, this.width, this.height, observer);
	}

}
