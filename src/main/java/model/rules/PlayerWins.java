package model.rules;

import model.Card;
import model.Player;

class PlayerWins implements WinStrategy {
  
  public boolean doWin(Player dealer, Player player) {
    
    return dealer.calcScore() > player.calcScore();
  }
}