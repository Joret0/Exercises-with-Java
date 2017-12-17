package system_resources.implementations;

import system_resources.interfaces.TimeProvider;

import java.time.LocalTime;

public class CurrentTime implements TimeProvider{
    @Override
    public int getHour() {
        return LocalTime.now().getHour();
    }
}
