package controller;

import model.Game;
import view.EnglishView;
import view.SwedishView;
import view.View;

/**
 * Starts the application using the console.
 */
public class App {
  /**
   * Starts the game.
   * 
   * @param args Not used.
   */
  public static void main(String[] args) {
    Game g = new Game();
    View v = new SwedishView(); // new EnglishView();
    Player ctrl = new Player();
    g.getPlayer().attach(ctrl);
    g.getDealer().attach(ctrl);

    while (ctrl.play(g, v)) {

    }
  }
}