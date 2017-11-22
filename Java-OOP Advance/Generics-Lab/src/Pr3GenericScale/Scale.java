package Pr3GenericScale;

public class Scale<T extends Comparable<T>> {

    private T left;
    private T right;

    public Scale(T left, T right) {
        this.left = left;
        this.right = right;
    }

    public T getHeavier() {
        int i = this.left.compareTo(this.right);
        if (i > 0) {
            return this.left;
        } else if (i < 0) {
            return this.right;
        }
        return null;
    }
}
