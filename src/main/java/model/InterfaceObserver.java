package model;

/**
 * Creating the interface of the observer pattern.
 */
public abstract class InterfaceObserver {
  public abstract void update(model.Card.Mutable c, model.Player player);
}
