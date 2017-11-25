package Pr1ListyIterator;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ListyIterator implements Iterable<String>{

    private List<String> list;
    private int index;

    void create(String... strings) {
        this.list = Arrays.asList(strings);
    }

    boolean move() {
        if (this.index < this.list.size() - 1) {
            this.index++;
            return true;
        }
        return false;
    }

    void print() {
        try {
            System.out.println(this.list.get(this.index));
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Invalid Operation!");
        }
    }

    void printAll() {
        try {
            StringBuilder builder = new StringBuilder();
            this.list.forEach(x -> builder.append(x).append(" "));
            System.out.println(builder.toString().trim());
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Invalid Operation!");
        }
    }

    boolean hasNext() {
        return this.index < this.list.size() - 1;
    }

    @Override
    public Iterator<String> iterator() {
        return new StringListIterator();
    }

    private final class StringListIterator implements Iterator<String> {
        private int index;

        StringListIterator() {
            this.index = 0;
        }

        @Override
        public boolean hasNext() {
            return this.index < list.size();
        }

        @Override
        public String next() {
            return list.get(this.index++);
        }
    }
}
