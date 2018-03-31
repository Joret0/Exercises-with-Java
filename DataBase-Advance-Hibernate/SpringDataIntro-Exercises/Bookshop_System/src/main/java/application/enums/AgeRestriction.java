package application.enums;

public enum AgeRestriction {
    Minor(2), Teen(1), Adult(0);

    private int value;

    private AgeRestriction(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
