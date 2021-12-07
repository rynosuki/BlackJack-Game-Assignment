package view;

/**
 * Implements a Swedish console view.
 * 
 */
public class SwedishView implements View {

  private static final String stand = "s";
  private static final String play = "p";
  private static final String hit = "n";
  private static final String quit = "q";

  /**
   * Shows a welcome message.
   * 
   */
  public void displayWelcomeMessage() {
    for (int i = 0; i < 50; i++) {
      System.out.print("\n");
    }

    System.out.println("Hej Black Jack Världen");
    System.out.println("----------------------");
    System.out.println("Skriv " + play + " för att Spela, " + hit + " för nytt kort, "
        + stand + " för att stanna " + quit + " för att avsluta\n");
  }

  /**
   * Returns pressed characters from the keyboard.
   * 
   * @return the pressed character.
   * 
   */
  public Choice getInput() {
    try {
      int c = System.in.read();
      while (c == '\r' || c == '\n') {
        c = System.in.read();
      }

      String choice = Integer.toString(c);

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

  /**
   * Displays a card.
   * 
   * @param card The card to display.
   * 
   */
  public void displayCard(model.Card card) {
    if (card.getColor() == model.Card.Color.Hidden) {
      System.out.println("Dolt Kort");
    } else {
      String[] colors = { "Hjärter", "Spader", "Ruter", "Klöver" };
      String[] values = { "två", "tre", "fyra", "fem", "sex", "sju", "åtta", "nio", "tio", "knekt", "dam", "kung",
          "ess" };
      System.out.println("" + colors[card.getColor().ordinal()] + " " + values[card.getValue().ordinal()]);
    }
  }

  public void displayPlayerHand(Iterable<model.Card> hand, int score) {
    displayHand("Spelare", hand, score);
  }

  public void displayDealerHand(Iterable<model.Card> hand, int score) {
    displayHand("Croupier", hand, score);
  }

  /**
   * Displays the winner of the game.
   * 
   * @param dealerIsWinner True if the dealer is the winner.
   * 
   */
  public void displayGameOver(boolean dealerIsWinner) {
    System.out.println("Slut: ");
    if (dealerIsWinner) {
      System.out.println("Croupiern Vann!");
    } else {
      System.out.println("Du vann!");
    }
  }

  private void displayHand(String name, Iterable<model.Card> hand, int score) {
    System.out.println(name + " Har: " + score);
    for (model.Card c : hand) {
      displayCard(c);
    }
    System.out.println("Poäng: " + score);
    System.out.println("");
  }

  public void displayCardD(model.Player p, model.Card.Mutable c) {
    if (p.getClass().getName().contains("Player")) {
      System.out.print("Spelaren fick ett  ");
      displayCard(c);
    } else {
      System.out.print("Croupiern fick ett ");
      displayCard(c);
    }
  }
}
