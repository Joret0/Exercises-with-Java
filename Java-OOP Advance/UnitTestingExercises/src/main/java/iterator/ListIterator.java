package iterator;

import javax.naming.OperationNotSupportedException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListIterator implements IListIterator{

    private List<String> list;
    private int index;

    public ListIterator(String... params) throws OperationNotSupportedException {
        if (params == null) {
            throw new OperationNotSupportedException("Parameter in constructor is null.");
        }
        this.index = 0;
        this.list = new ArrayList<>();
        Collections.addAll(this.list, params);
    }

    @Override
    public boolean move() {
        if (this.index >= list.size() - 1) {
            return false;
        }
        this.index++;
        return true;
    }

    @Override
    public boolean hasNext() {
        return this.index < list.size() - 1;
    }

    @Override
    public void print() throws OperationNotSupportedException {
        try {
            System.out.println(this.list.get(this.index));
        } catch (IndexOutOfBoundsException ex) {
            throw new OperationNotSupportedException("Unable to invoke print method on empty list.");
        }
    }
}
