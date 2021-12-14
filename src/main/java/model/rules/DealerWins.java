package model.rules;

import model.Player;

class DealerWins implements WinStrategy {

  public boolean doWin(Player dealer, Player player) {
    
    return dealer.calcScore() > player.calcScore();
  }
}