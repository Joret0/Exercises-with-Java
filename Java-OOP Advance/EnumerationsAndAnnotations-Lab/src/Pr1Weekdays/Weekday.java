package Pr1Weekdays;

public enum Weekday {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;

    @Override
    public String toString() {
        String day = super.name().charAt(0) + super.name().substring(1).toLowerCase();
        return day;
    }
}
