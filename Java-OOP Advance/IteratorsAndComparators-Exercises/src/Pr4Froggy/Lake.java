package Pr4Froggy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Lake implements Iterable<Integer>{
    private List<Integer> list;

    Lake() {
        this.list = new ArrayList<>();
    }

    void add(String... numbers) {
        for (int i = 0; i < numbers.length; i++) {
            this.list.add(Integer.parseInt(numbers[i]));
        }
    }

    void print() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < this.list.size(); i++) {
            if (this.list.get(i) % 2 != 0) {
                builder.append(this.list.get(i)).append(", ");
            }
        }
        for (int i = 0; i < this.list.size(); i++) {
            if (this.list.get(i) % 2 == 0) {
                builder.append(this.list.get(i)).append(", ");
            }
        }
        builder.setLength(builder.length() - 2);
        System.out.println(builder.toString());
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Frog();
    }

    private class Frog implements Iterator<Integer> {

        private int index;

        Frog() {
            this.index = 0;
        }
        @Override
        public boolean hasNext() {
            return this.index < list.size();
        }

        @Override
        public Integer next() {
            return list.get(this.index++);
        }
    }
}
