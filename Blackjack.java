package Ejercicio006;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Panel;

public class Blackjack extends Applet {
	public static int[] CARDVALUES = { 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 6, 6, 6, 6, 7, 7, 7,
			7, 8, 8, 8, 8, 9, 9, 9, 9, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, };
	public static String[] cards = { "1_of_clubs", "1_of_diamonds", "1_of_hearts", "1_of_spades", "2_of_clubs",
			"2_of_diamonds", "2_of_hearts", "2_of_spades", "3_of_clubs", "3_of_diamonds", "3_of_hearts", "3_of_spades",
			"4_of_clubs", "4_of_diamonds", "4_of_hearts", "4_of_spades", "5_of_clubs", "5_of_diamonds", "5_of_hearts",
			"5_of_spades", "6_of_clubs", "6_of_diamonds", "6_of_hearts", "6_of_spades", "7_of_clubs", "7_of_diamonds",
			"7_of_hearts", "7_of_spades", "8_of_clubs", "8_of_diamonds", "8_of_hearts", "8_of_spades", "9_of_clubs",
			"9_of_diamonds", "9_of_hearts", "9_of_spades", "10_of_clubs", "10_of_diamonds", "10_of_hearts",
			"10_of_spades", "11_of_clubs", "11_of_diamonds", "11_of_hearts", "11_of_spades", "12_of_clubs",
			"12_of_diamonds", "12_of_hearts", "12_of_spades", "13_of_clubs", "13_of_diamonds", "13_of_hearts",
			"13_of_spades" };
	public static String DIRECCION = "/C:/imagenes/Cartas/";
	public static final int CARD_WIDTH = 100;
	public static final int CARD_HEIGHT = 140;

	private Deck deck;
	private Player player;
	private Crupier crupier;
	private CardBack cardback;
	private boolean canTakeCard = true;
	String textToShow = null;

	public void init() {
		deck = new Deck(6, this);
		cardback = new CardBack(this);
		player = new Player(deck);
		crupier = new Crupier(deck);

		Button stop = new Button("Plantarse");
		this.setLayout(new BorderLayout());
		Panel panel = new Panel();
		panel.add(stop);
		this.add(panel, "North");

		repaint();
		player.takeCard();
		repaint();
		crupier.takeCard(true);
		repaint();
		player.takeCard();
		repaint();
		crupier.takeCard(false);
		repaint();
		if (player.getPoints() >= 21)
			crupierTourn();

		this.resize(600, 600);
	}

	public void paint(Graphics g) {
		g.setColor(Color.GRAY);
		g.fillRect(0, 0, 600, 600);
		cardback.drawCard(g, this);
		player.drawCards(g, this);
		crupier.drawCards(g, this);
		g.setColor(Color.GREEN);
		if (player.getPoints() > 21)
			g.setColor(Color.RED);
		g.drawString("Puntos: " + player.getPoints(), 50, 295);
		if (textToShow != null)
			g.drawString(textToShow, 250, 250);
	}

	public boolean mouseDown(Event e, int x, int y) {
		if (cardback.contains(x, y)) {
			if (!canTakeCard)
				return false;
			player.takeCard();
			repaint();
			if (player.getPoints() >= 21)
				crupierTourn();
		}
		return true;
	}

	public void crupierTourn() {
		canTakeCard = false;
		crupier.showAll();
		repaint();
		while (crupier.getPoints() < 17) {
			try {
				Thread.sleep(1000);
				crupier.takeCard();
				repaint();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		if (player.getPoints() > 21 && crupier.getPoints() > 21)
			textToShow = "Nadie gana";
		else if ((player.getPoints() < 21) && (crupier.getPoints() > 21))
			textToShow = "Tú ganas";
		else if (player.getPoints() > 21 && crupier.getPoints() <= 21)
			textToShow = "El crupier gana";
		else if (player.getPoints() > crupier.getPoints())
			textToShow = "Tú ganas";
		else if (player.getPoints() == crupier.getPoints())
			textToShow = "Empate";
		else
			textToShow = "El crupier gana";
		repaint();
	}

	public boolean action(Event ev, Object obj) {
		if (ev.target instanceof Button) {
			crupierTourn();
		}
		return true;
	}
}
