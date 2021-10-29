package controller;

public class Editor {
    public EventManager events;

    public Editor() {
        this.events = new EventManager("test");
    }

    public void sendNotice() {
        System.out.println("heeeeeeeeeello");
        events.notify("test");
    }

}
