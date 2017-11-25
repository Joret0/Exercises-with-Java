package Pr9LinkedListTraversal.interfaces;

public interface LinkedList<Integer> extends Iterable<Integer>{
    int getSize();

    void add(int element);

    boolean remove(int element);
}
