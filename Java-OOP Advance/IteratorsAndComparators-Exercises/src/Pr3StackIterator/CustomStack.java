package Pr3StackIterator;

import java.util.*;

public class CustomStack implements Iterable<Integer>{

    private List<Integer> stack;

    CustomStack() {
        this.stack = new ArrayList<>();
    }

    void push(String... numbers) {
        for (int i = 0; i < numbers.length; i++) {
            stack.add(0, Integer.parseInt(numbers[i]));
        }
    }

    void pop() {
        try {
            stack.remove(0);
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("No elements");
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return new CustomStackIterator();
    }

    private class CustomStackIterator implements Iterator<Integer> {
        private int index;

        CustomStackIterator() {
            this.index = 0;
        }

        @Override
        public boolean hasNext() {
            return this.index < stack.size() ;
        }

        @Override
        public Integer next() {
            return stack.get(this.index++);
        }
    }
}
