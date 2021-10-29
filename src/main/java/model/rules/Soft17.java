package model.rules;

import model.Card;
import model.Player;

class Soft17 implements HitStrategy {
  private static final int hitLimit = 17;

  public boolean doHit(Player dealer) {
    int score = dealer.calcScore();

    if (score == hitLimit) {
      for (Card c : dealer.getHand()) {
        if (c.getValue() == Card.Value.Ace && score == hitLimit) {
          score -= 10;
        }
      }
    }
    return score < hitLimit;
  }
}