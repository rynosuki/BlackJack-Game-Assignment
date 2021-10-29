package model.rules;

/**
 * Creates concrete rules.
 * 
 */
public class RulesFactory {

  /**
   * Creates the rule to use for the dealer's hit behavior.
   * 
   * @return The rule to use
   * 
   */
  public HitStrategy getHitRule() {
    return new Soft17();
  }

  /**
   * Crates the rule to use when starting a new game.
   * 
   * @return The rule to use.
   * 
   */
  public NewGameStrategy getNewGameRule() {
    return new AmericanNewGameStrategy();
  }

  /**
   * Crates the rule to decide who wins on a tie.
   * 
   * @return The rule to use.
   */
  public WinStrategy getNWinRule() {
    return new PlayerWins();
  }
}