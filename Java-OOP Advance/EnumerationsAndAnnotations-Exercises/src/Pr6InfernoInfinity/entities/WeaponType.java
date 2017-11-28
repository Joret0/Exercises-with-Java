package Pr6InfernoInfinity.entities;

public enum WeaponType {
    AXE(5, 10, 4), SWORD(4, 6, 3), KNIFE(3, 4, 2);

    private int min;
    private int max;
    private int sockets;

    WeaponType(int min, int max, int sockets) {
        this.min = min;
        this.max = max;
        this.sockets = sockets;
    }

    public int getSockets() {
        return sockets;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }
}
