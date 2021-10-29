package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import view.*;

public class EventManager {

    Map<String, List<View>> listeners = new HashMap<>();

    public EventManager(String... operations) {
        for (String operation : operations) {
            this.listeners.put(operation, new ArrayList<>());
        }
    }

    public void subscribe(String eventType, View listener) {
        List<View> users = listeners.get(eventType);
        users.add(listener);
    }

    public void notify(String eventType) {
        List<View> users = listeners.get(eventType);
        for (View listener : users) {
            //listener.update(eventType, file);
            listener.updateIfPlayerGetCard();
        }
    }

}
