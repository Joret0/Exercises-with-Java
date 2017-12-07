package c_barracksWars.core.commands;

import c_barracksWars.contracts.Executable;

public abstract class Command implements Executable{
    private String[] data;

    Command(String[] data) {
        this.data = data;
    }

    String[] getData() {
        return data;
    }
}
