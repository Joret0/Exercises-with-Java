package db_extended;

import javax.naming.OperationNotSupportedException;
import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

public class ExtendedDatabase implements IExtendedDatabase{
    private static final Integer DEFAULT_SIZE = 16;
    private Person[] people;
    private int index;

    public ExtendedDatabase() {
        this.people = new Person[DEFAULT_SIZE];
        this.index = 0;
    }

    @Override
    public Person finById(Long id) throws OperationNotSupportedException {
        if (id == null) {
            throw new OperationNotSupportedException("Given id is null.");
        }
        Optional<Person> found = Arrays.stream(this.people).filter(x -> x != null && Objects.equals(x.getId(), id)).findFirst();
        if (found.isPresent()) {
            return found.get();
        } else {
            throw new OperationNotSupportedException("User with the given id was not found.");
        }
    }

    @Override
    public Person findByUsername(String username) throws OperationNotSupportedException {
        if (username == null) {
            throw new OperationNotSupportedException("Given username is null.");
        }
        Optional<Person> found = Arrays.stream(this.people).filter(x -> x != null && Objects.equals(x.getUsername(), username)).findFirst();
        if (found.isPresent()) {
            return found.get();
        } else {
            throw new OperationNotSupportedException("User with the given username was not found.");
        }
    }

    @Override
    public void add(Person person) throws OperationNotSupportedException {
        if (person.getId() == null || person.getId() < 0) {
            throw new OperationNotSupportedException("Invalid id.");
        }
        if (Arrays.stream(this.people).filter(x -> x != null && Objects.equals(x.getId(), person.getId())).count() != 0) {
            throw new OperationNotSupportedException("There are other users with the given id.");
        }
        if (this.index > 15) {
            throw new OperationNotSupportedException("Array limit length is reached.");
        }
        this.people[this.index++] = person;
    }

    @Override
    public void remove() throws OperationNotSupportedException {
        if (this.index == 0) {
            throw new OperationNotSupportedException("db.Database is empty.");
        }
        this.people[this.index--] = null;
    }

    @Override
    public Person[] getPeople() {
        return this.people;
    }

    @Override
    public int getIndex() {
        return this.index;
    }
}
