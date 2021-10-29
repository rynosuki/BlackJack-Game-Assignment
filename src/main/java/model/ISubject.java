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

	public void notifyAllObservers(Card.Mutable c, Player player) {
		for (IObserver iObserver : observers) {
			iObserver.update(c, player);
		}
	}
}
