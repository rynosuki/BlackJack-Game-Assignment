package model.rules;

import model.Dealer;
import model.Player;

class InternationalNewGameStrategy implements NewGameStrategy {

  private int numberOfCardsToDraw;

  /**
   * Initializing constructor.
   */
  public InternationalNewGameStrategy() {
    this.numberOfCardsToDraw = 3;
  }

  public boolean newGame(Dealer dealer, Player player) {
    for (int i = 0; i < numberOfCardsToDraw; i++) {

      if (i % 2 == 0) {
        dealer.drawCards(dealer, true);
      } else {
        dealer.drawCards(player, true);
      }
    }

    return true;
  }
}