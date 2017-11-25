package Pr9LinkedListTraversal.models;

import Pr9LinkedListTraversal.interfaces.LinkedList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LinkedListImpl implements LinkedList<Integer> {
    private List<Integer> list;

    public LinkedListImpl() {
        this.list = new ArrayList<>();
    }

    @Override
    public int getSize() {
        return this.list.size();
    }

    @Override
    public void add(int element) {
        this.list.add(element);
    }

    @Override
    public boolean remove(int element) {
        int index = this.list.indexOf(element);
        if (index != -1) {
            this.list.remove(index);
            return true;
        }
        return false;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new LinkedListImplIterator();
    }

    private class LinkedListImplIterator implements Iterator<Integer> {
        private int index;

        @Override
        public boolean hasNext() {
            return this.index < getSize();
        }

        @Override
        public Integer next() {
            return list.get(this.index++);
        }
    }
}
