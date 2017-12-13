package iterator_test;

import iterator.IListIterator;
import iterator.ListIterator;
import org.junit.Assert;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class ListIteratorTests {

    @Test
    public void testSingelMove() throws OperationNotSupportedException {
        IListIterator listIterator = new ListIterator("Georgi, Ivan, Pesho");
        Assert.assertEquals("Error in move().", true, listIterator.move());
    }

    @Test
    public void testManyMoves() throws OperationNotSupportedException {
        IListIterator listIterator = new ListIterator("Georgi", "Ivan", "Dimitar");
        listIterator.move();
        listIterator.move();
        Assert.assertEquals("Error in move().", false, listIterator.move());
    }

    @Test
    public void testHasNextTrue() throws OperationNotSupportedException {
        IListIterator listIterator = new ListIterator("Ivan", "Pesho", "Go4o");
        Assert.assertEquals("Error in hasNext().", true, listIterator.hasNext());
    }

    @Test
    public void testHasNextFalse() throws OperationNotSupportedException {
        IListIterator listIterator = new ListIterator("Georgi", "Ivan", "Mihail");
        listIterator.move();
        listIterator.move();
        Assert.assertEquals("Error in hasNext().", false, listIterator.hasNext());
    }

    @Test
    public void testPrint() throws OperationNotSupportedException {
        IListIterator listIterator = new ListIterator("Georgi", "Ivan", "Misho");
        listIterator.move();
        listIterator.print();
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testPrintThrowsExeption() throws OperationNotSupportedException {
        IListIterator listIterator = new ListIterator();
        listIterator.print();
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructor() throws OperationNotSupportedException {
        IListIterator listIterator = new ListIterator(null);
    }
}
