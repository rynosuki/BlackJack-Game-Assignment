package controller;

public abstract class IObserver {
    public abstract void update(model.Card.Mutable c, model.Player player);
}
