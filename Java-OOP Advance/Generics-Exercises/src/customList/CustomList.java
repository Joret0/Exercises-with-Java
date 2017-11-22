package customList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class CustomList<T extends Comparable<T>>{
    private List<T> list;

    public CustomList() {
        this.list = new ArrayList<T>();
    }
    public List<T> getList() {
        return this.list;
    }
    void add(T element) {
        this.list.add(element);
    }
    T remove(int index) {
        return this.list.remove(index);
    }
    boolean contains(T element) {
        return this.list.contains(element);
    }
    void swap(int i, int j) {
        Collections.swap(this.list, i, j);
    }
    int countGreaterThan(T element) {
        int result = 0;
        for (T t : list) {
            if (t.compareTo(element) > 0) {
                result++;
            }
        }
        return result;
    }
    T getMax() {
        return this.list.stream().sorted().collect(Collectors.toList()).get(this.list.size() - 1);
    }
    T getMin() {
        return this.list.stream().sorted().collect(Collectors.toList()).get(0);
    }
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (T t : list) {
            builder.append(t);
            builder.append(System.lineSeparator());
        }
        return builder.toString().trim();
    }
    void print() {
        Iterator<T> iterator = this.list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
