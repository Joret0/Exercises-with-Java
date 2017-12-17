package Lab.models;

import Lab.enums.LogType;
import Lab.interfaces.Handler;
import Lab.interfaces.ObservableTarget;
import Lab.interfaces.Observer;

import java.util.ArrayList;
import java.util.List;

public class Dragon implements ObservableTarget {

    private static final String THIS_DIED_EVENT = "%s dies";

    private String id;
    private int hp;
    private int reward;
    private boolean eventTriggered;
    private List<Observer> observers;
    private Handler logger;

    public Dragon(String id, int hp, int reward, Handler logger) {
        this.id = id;
        this.hp = hp;
        this.reward = reward;
        this.logger = logger;
        this.observers = new ArrayList<>();
    }

    @Override
    public void receiveDamage(int dmg) {
        if (!this.isDead()) {
            this.hp -= dmg;
        }

        if (this.isDead() && !eventTriggered) {
            this.logger.handle(LogType.ERROR, String.format(THIS_DIED_EVENT, this));
            this.eventTriggered = true;
        }
    }

    @Override
    public boolean isDead() {
        return this.hp <= 0;
    }

    @Override
    public String toString() {
        return this.id;
    }

    @Override
    public void register(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void unregister(Observer observer) {
        this.observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : this.observers) {
            observer.update(this.reward);
        }
    }
}
