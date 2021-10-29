package model.rules;

import model.Card;
import model.Player;

class Soft17 implements HitStrategy {
  private static final int hitLimit = 17;

  public boolean doHit(Player dealer) {
    int[] cardScores = { 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 11 };
    assert (cardScores.length == Card.Value.Count.ordinal())
        : "Card Scores array size does not match number of card values";

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