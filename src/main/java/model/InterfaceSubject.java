package model;

import java.util.ArrayList;

/**
 * Subject of the Observer pattern.
 * 
 */
public abstract class InterfaceSubject {
  private ArrayList<InterfaceObserver> observers = new ArrayList<>();

  public void attach(InterfaceObserver observer) {
    this.observers.add(observer);
  }

  /**
   * Notify all observers.
   * 
   * @param c      Card that was drawn.
   * @param player Player that drew the card.
   */
  public void notifyAllObservers(Card.Mutable c, Player player) {
    for (InterfaceObserver observer : observers) {
      observer.update(c, player);
    }
  }
}
