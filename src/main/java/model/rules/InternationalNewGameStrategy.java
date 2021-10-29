package model.rules;

import model.Dealer;
import model.Deck;
import model.Player;

class InternationalNewGameStrategy implements NewGameStrategy {

  private int numberOfCardsToDraw;

  /**
   * Initializing constructor.
   */
  public InternationalNewGameStrategy() {
    this.numberOfCardsToDraw = 3;
  }

  public boolean newGame(Deck deck, Dealer dealer, Player player) {
    // Card.Mutable c;

    // c = deck.getCard();
    // c.show(true);
    // player.dealCard(c);

    // c = deck.getCard();
    // c.show(true);
    // dealer.dealCard(c);

    // c = deck.getCard();
    // c.show(true);
    // player.dealCard(c);

    for (int i = 0; i < numberOfCardsToDraw; i++) {

      if (i % 2 == 0) {
        deck.drawCards(dealer, true);
      } else {
        deck.drawCards(player, true);
      }
    }

    return true;
  }
}