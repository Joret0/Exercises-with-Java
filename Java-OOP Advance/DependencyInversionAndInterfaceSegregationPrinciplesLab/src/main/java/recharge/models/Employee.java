package recharge.models;

import recharge.interfaces.Sleeper;

public class Employee extends Worker implements Sleeper{
    public Employee(String id) {
        super(id);
    }

    @Override
    public void sleep() {
        System.out.println("Sleep...");
    }
}
