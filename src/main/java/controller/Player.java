package controller;

import model.Game;
import view.View;

/**
 * Scenario controller for playing the game.
 */
public class Player {

  private enum Choice {
    PLAY, HIT, STAND, QUIT, DEFAULT
  }

  /**
   * Runs the play use case.
   * 
   * @param game The game state.
   * @param view The view to use.
   * @return True as long as the game should continue.
   */
  public boolean play(Game game, View view) {
    view.displayWelcomeMessage();

    view.displayDealerHand(game.getDealerHand(), game.getDealerScore());
    view.displayPlayerHand(game.getPlayerHand(), game.getPlayerScore());

    if (game.isGameOver()) {
      view.displayGameOver(game.isDealerWinner());
    }

    int input = view.getInput();
    Choice choice = Choice.DEFAULT;
    if (input == 'p') {
      choice = Choice.PLAY;
    } else if (input == 'h') {
      choice = Choice.HIT;
    } else if (input == 's') {
      choice = Choice.STAND;
    } else if (input == 'q') {
      choice = Choice.QUIT;
    }

    switch (choice) {
    case PLAY:
      game.newGame();
      break;
    case HIT:
      game.hit();
      break;
    case STAND:
      game.stand();
      break;
    case QUIT:
      System.exit(0);
      break;
    default:
      return input != 'q';
    }

    return true;
  }
}