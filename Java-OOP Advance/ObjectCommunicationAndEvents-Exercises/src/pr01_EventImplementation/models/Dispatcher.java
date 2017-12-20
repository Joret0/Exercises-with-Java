package pr01_EventImplementation.models;

import pr01_EventImplementation.interfaces.NameChangeListener;

import java.util.ArrayList;
import java.util.List;

public class Dispatcher {
    private String name;
    private List<NameChangeListener> listeners;

    public Dispatcher(String name) {
        this.name = name;
        this.listeners = new ArrayList<>();
    }

    public void changeName(String name) {
        if (!this.name.equals(name)) {
            this.name = name;
            this.fireNameChangeEvent();
        }
    }

    public void addNameChangeListener(NameChangeListener listener) {
        this.listeners.add(listener);
    }

    public void removeNameChangeListener(NameChangeListener listener) {
        this.listeners.remove(listener);
    }

    public void fireNameChangeEvent() {
        NameChange event = new NameChange(this.name);
        this.listeners.forEach(x -> x.handleChangedName(event));
    }
}
