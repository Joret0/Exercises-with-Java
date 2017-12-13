package db_extended_test;

import db_extended.ExtendedDatabase;
import db_extended.IExtendedDatabase;
import db_extended.Person;
import org.junit.Assert;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class ExtendedDatabaseTests {

    @Test
    public void checkArrayCapacity() throws OperationNotSupportedException {
        IExtendedDatabase db = new ExtendedDatabase();
        int length = db.getPeople().length;
        Assert.assertEquals(16, length);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddThrowsException() throws OperationNotSupportedException {
        IExtendedDatabase db = new ExtendedDatabase();
        db.add(new Person(-50, "Georgi"));
    }

    @Test
    public void testAdd() throws OperationNotSupportedException {
        IExtendedDatabase db = new ExtendedDatabase();
        db.add(new Person(5, "Georgi"));
        Assert.assertEquals(1, db.getIndex());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddOnFullArray() throws OperationNotSupportedException {
        IExtendedDatabase db = new ExtendedDatabase();
        for (int i = 0; i < 16; i++) {
            db.add(new Person(i, "Georgi"));
        }
        db.add(new Person(1100, "Georgi"));
    }

    @Test
    public void testRemove() throws OperationNotSupportedException {
        IExtendedDatabase db = new ExtendedDatabase();
        for (int i = 0; i < 4; i++) {
            db.add(new Person(i, "Georgi"));
        }
        db.remove();
        Assert.assertEquals(3, db.getIndex());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveOnEmptyDb() throws OperationNotSupportedException {
        IExtendedDatabase db = new ExtendedDatabase();
        db.remove();
    }
}
