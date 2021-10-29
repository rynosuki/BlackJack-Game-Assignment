package model.rules;

import model.Dealer;
import model.Deck;
import model.Player;

class AmericanNewGameStrategy implements NewGameStrategy {

  private int numberOfCardsToDraw;

  /**
   * Initializing constructor.
   */
  public AmericanNewGameStrategy() {
    this.numberOfCardsToDraw = 4;
  }

  /**
   * Start game with four cards, alternating between giving card to dealer or
   * player. The last card is not shown to the players.
   */
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

    // c = deck.getCard();
    // c.show(false);
    // dealer.dealCard(c);

    for (int i = 0; i < this.numberOfCardsToDraw; i++) {
      boolean showCard = true;

      if (i == (this.numberOfCardsToDraw - 1)) {
        showCard = false;
      }

      if (i % 2 == 0) {
        deck.drawCards(player, showCard);
      } else {
        deck.drawCards(dealer, showCard);
      }
    }
    return true;
  }
}