package Ejercicio006;

import java.awt.Image;
import java.awt.Rectangle;

public class Card extends Rectangle {

	public Image image;
	public Image reverse;
	private boolean used = false;
	private boolean showed = false;
	private int value;
	private String name;

	public Card(int value, String name, Blackjack blackjack) {
		this.value = value;
		this.name = name;
		this.image = blackjack.getImage(blackjack.getCodeBase(), Blackjack.DIRECCION + name + ".png");
		this.reverse = blackjack.getImage(blackjack.getCodeBase(), Blackjack.DIRECCION + "reverso.png");
	}

	public int getValue() {
		return value;
	}

	public boolean isShowed() {
		return showed;
	}

	public void setShowed(boolean showed) {
		this.showed = showed;
	}

	public boolean isUsed() {
		return this.used;
	}

	public void setUsed(boolean used) {
		this.used = used;
	}

}
