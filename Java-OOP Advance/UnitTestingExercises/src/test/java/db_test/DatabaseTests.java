package db_test;

import db.Database;
import db.IDatabase;
import org.junit.Assert;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTests {

    @Test
    public void checkArrayCapacity() throws OperationNotSupportedException {
        IDatabase db = new Database(1, 2, 3, 4);
        int length = db.getNumbers().length;
        Assert.assertEquals(16, length);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddThrowsException() throws OperationNotSupportedException {
        IDatabase db = new Database(1, 2, 3, 4);
        db.addNumber(null);
    }

    @Test
    public void testAdd() throws OperationNotSupportedException {
        IDatabase db = new Database(1, 2, 3, 4);
        db.addNumber(5);
        Assert.assertEquals(5, db.getIndex());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddOnFullArray() throws OperationNotSupportedException {
        IDatabase db = new Database(1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 4, 5, 6, 7);
        db.addNumber(5);
    }

    @Test
    public void testRemove() throws OperationNotSupportedException {
        IDatabase db = new Database(1, 2, 3, 4);
        db.removeNumber();
        Assert.assertEquals(3, db.getIndex());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveOnEmptyDb() throws OperationNotSupportedException {
        IDatabase db = new Database();
        db.removeNumber();
    }
    @Test
    public void testFetch() throws OperationNotSupportedException {
        Integer[] initial = new Integer[]{ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
        IDatabase db = new Database(initial);
        Assert.assertArrayEquals(db.fetch(), initial);
    }
}
