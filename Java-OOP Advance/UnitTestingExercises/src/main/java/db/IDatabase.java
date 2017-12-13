package db;

import javax.naming.OperationNotSupportedException;

public interface IDatabase {
    void addNumber(Integer number) throws OperationNotSupportedException;
    void removeNumber() throws OperationNotSupportedException;
    Integer[] fetch();
    public Integer[] getNumbers();
    public int getIndex();
}
