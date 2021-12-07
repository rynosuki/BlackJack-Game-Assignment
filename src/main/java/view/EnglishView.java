package view;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Implements an english console view.
 * 
 */
public class EnglishView implements View {

  private static final String stand = "s";
  private static final String play = "p";
  private static final String hit = "h";
  private static final String quit = "q";

  /**
   * Shows a welcome message.
   * 
   */
  public void displayWelcomeMessage() {
    for (int i = 0; i < 50; i++) {
      System.out.print("\n");
    }
    System.out.println("Hello Black Jack World");
    System.out.println("Type " + play + " to Play, " + hit + " to Hit, "
        + stand + " to Stand or " + quit + " to Quit\n");
  }

  /**
   * Returns pressed characters from the keyboard.
   * 
   * @return the pressed character.
   * 
   */
  public Choice getInput() {
    try {
      BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
      String choice = read.readLine();

      switch (choice) {
        case play:
          return Choice.PLAY;
        case hit:
          return Choice.HIT;
        case stand:
          return Choice.STAND;
        case quit:
          return Choice.QUIT;
        default:
          return null;
      }
    } catch (java.io.IOException e) {
      System.out.println("" + e);
      return null;
    }
  }

  public void displayCard(model.Card card) {
    System.out.println("" + card.getValue() + " of " + card.getColor());
  }

  public void displayPlayerHand(Iterable<model.Card> hand, int score) {
    displayHand("Player", hand, score);
  }

  public void displayDealerHand(Iterable<model.Card> hand, int score) {
    displayHand("Dealer", hand, score);
  }

  private void displayHand(String name, Iterable<model.Card> hand, int score) {
    System.out.println(name + " Has: ");
    for (model.Card c : hand) {
      displayCard(c);
    }
    System.out.println("Score: " + score);
    System.out.println("");
  }

  /**
   * Displays the winner of the game.
   * 
   * @param dealerIsWinner True if the dealer is the winner.
   * 
   */
  public void displayGameOver(boolean dealerIsWinner) {
    System.out.println("GameOver: ");
    if (dealerIsWinner) {
      System.out.println("Dealer Won!");
    } else {
      System.out.println("You Won!");
    }

  }

  /**
   * Displays the card recently drawns.
   * 
   * @param p Player that drew the card. Used to determine what to print.
   * 
   * @param c Card that that was drawn.
   * 
   */
  public void displayCardD(model.Player p, model.Card.Mutable c) {
    if (p.getClass().getName().contains("Player")) {
      System.out.print("Player got an ");
      displayCard(c);
    } else {
      System.out.print("Dealer got an ");
      displayCard(c);
    }
  }
}
