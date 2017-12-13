package db;

import javax.naming.OperationNotSupportedException;

public class Database implements IDatabase{

    private static final Integer DEFAULT_SIZE = 16;
    private Integer[] numbers;
    private Integer index;

    public Database(Integer... numbers) throws OperationNotSupportedException {
        this.numbers = new Integer[DEFAULT_SIZE];
        this.index = 0;
        this.setNumbers(numbers);
    }

    private void setNumbers(Integer[] numbers) throws OperationNotSupportedException {
        for (Integer number : numbers) {
            this.addNumber(number);
        }
    }
    @Override
    public void addNumber(Integer number) throws OperationNotSupportedException {
        if (number == null) {
            throw new OperationNotSupportedException("Number is null.");
        }
        if (this.index > 15) {
            throw new OperationNotSupportedException("Array limit length is reached.");
        }
        this.numbers[this.index++] = number;
    }

    @Override
    public void removeNumber() throws OperationNotSupportedException {
        if (this.index == 0) {
            throw new OperationNotSupportedException("db.DataBase is empty.");
        }
        this.numbers[this.index--] = null;
    }

    @Override
    public Integer[] fetch() {
        return this.numbers;
    }

    @Override
    public Integer[] getNumbers() {
        return this.numbers;
    }

    @Override
    public int getIndex() {
        return this.index;
    }
}
