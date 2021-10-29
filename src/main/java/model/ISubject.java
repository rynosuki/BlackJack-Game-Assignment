package model;

import controller.IObserver;
import java.util.ArrayList;

/**
 * Subject of the Observer pattern.
 * 
 */
public abstract class ISubject {
  private ArrayList<IObserver> observers = new ArrayList<>();

  public void attach(IObserver observer) {
    this.observers.add(observer);
  }

  /**
   * Notify all observers.
   * @param c Card that was drawn.
   * @param player Player that drew the card.
   */
  public void notifyAllObservers(Card.Mutable c, Player player) {
    for (IObserver observer : observers) {
      observer.update(c, player);
    }
  }
}
