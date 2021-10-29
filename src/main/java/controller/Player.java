package controller;

import model.Card.Mutable;
import model.Game;
import view.View;

/**
 * Scenario controller for playing the game.
 * 
 */
public class Player extends IObserver {

  private enum Choice {
    PLAY, HIT, STAND, QUIT, DEFAULT
  }

  private View view;

  private static final char play = 'p';
  private static final char hit = 'h';
  private static final char stand = 's';
  private static final char quit = 'q';

  /**
   * Runs the play use case.
   * 
   * @param game The game state.
   * 
   * @param view The view to use.
   * 
   * @return True as long as the game should continue.
   * 
   */
  public boolean play(Game game, View view) {
    this.view = view;
    view.displayWelcomeMessage();

    view.displayDealerHand(game.getDealerHand(), game.getDealerScore());
    view.displayPlayerHand(game.getPlayerHand(), game.getPlayerScore());

    if (game.isGameOver()) {
      view.displayGameOver(game.isDealerWinner());
    }

    int input = view.getInput();
    Choice choice = Choice.DEFAULT;
    if (input == play) {
      choice = Choice.PLAY;
    } else if (input == hit) {
      choice = Choice.HIT;
    } else if (input == stand) {
      choice = Choice.STAND;
    } else if (input == quit) {
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

  /**
   * Send update from subject.
   */
  public void update(Mutable c, model.Player player) {
    try {
      view.displayCardD(player, c);
      Thread.sleep(500);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}