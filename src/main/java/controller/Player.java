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

  private final char play = 'p';
	private final char hit = 'h';
	private final char stand = 's';
	private final char quit = 'q';

  /**
   * Runs the play use case.
   * 
   * @param game The game state.
   * @param view The view to use.
   * @return True as long as the game should continue.
   */
  public boolean play(Game game, View view) {


    Editor editor = new Editor();
    editor.events.subscribe("test", view);
    //editor.sendNotice();




    view.displayWelcomeMessage();

    view.displayDealerHand(game.getDealerHand(), game.getDealerScore());
    if (view.displayDealerHand(game.getDealerHand()) {
      
    }
    editor.sendNotice();
    view.displayPlayerHand(game.getPlayerHand(), game.getPlayerScore());
    editor.sendNotice();
    

    
    

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
}