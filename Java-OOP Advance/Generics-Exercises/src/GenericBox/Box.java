package GenericBox;

import java.util.Collections;
import java.util.List;

public class Box<T> {

    private T value;

    public Box(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("%s: %s", this.value.getClass().getCanonicalName(), this.value);
    }

    public static <T> void swap(List<T> list, int i, int j) {
        Collections.swap(list, i, j);
    }

    public static <T extends Comparable<T>> int countGreaterValues(List<T> list, T value) {
        int c = 0;
        for (T t : list) {
            if (t.compareTo(value) > 0) {
                c++;
            }
        }
        return c;
    }
}
