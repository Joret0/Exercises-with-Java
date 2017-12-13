package iterator;

import javax.naming.OperationNotSupportedException;

public interface IListIterator {
    boolean move();
    boolean hasNext();
    void print() throws OperationNotSupportedException;
}
