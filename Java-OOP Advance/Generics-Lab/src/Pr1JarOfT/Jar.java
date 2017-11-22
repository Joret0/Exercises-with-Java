package Pr1JarOfT;

import java.util.ArrayDeque;
import java.util.Deque;

public class Jar<T> {
    private Deque<T> deque;

    public Jar() {
        this.deque = new ArrayDeque<T>();
    }

    public void add(T type) {
        this.deque.push(type);
    }

    public T remove() {
        return this.deque.pop();
    }
}
