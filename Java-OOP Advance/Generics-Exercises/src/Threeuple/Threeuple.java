package Threeuple;

public class Threeuple<K, V, U> {
    private K key;
    private V value;
    private U unit;

    public Threeuple(K key, V value, U unit) {
        this.key = key;
        this.value = value;
        this.unit = unit;
    }

    public String toString() {
        return String.format("%s -> %s -> %s", this.key, this.value, this.unit);
    }
}
