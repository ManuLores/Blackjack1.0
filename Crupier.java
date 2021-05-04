package Ejercicio006;

public class Crupier extends Player {

	boolean firstCard = true;

	public Crupier(Deck deck) {
		super(deck);
		this.x = 50;
		this.y = 50;
	}

	public void takeCard(Boolean showed) {
		System.out.println(this.y);
		Card takenCard = deck.takeCard();
		while (takenCard == null)
			takenCard = deck.takeCard();
		cards.add(takenCard);
		takenCard.setShowed(showed);
	}

	public void showAll() {
		for (int i = 0; i < cards.size(); i++) {
			cards.get(i).setShowed(true);
		}
	}

}
