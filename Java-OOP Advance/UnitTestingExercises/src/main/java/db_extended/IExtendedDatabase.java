package db_extended;

import javax.naming.OperationNotSupportedException;

public interface IExtendedDatabase {
    Person finById(Long id) throws OperationNotSupportedException;
    Person findByUsername(String username) throws OperationNotSupportedException;
    void add(Person person) throws OperationNotSupportedException;
    void remove() throws OperationNotSupportedException;
    public Person[] getPeople();
    int getIndex();
}
