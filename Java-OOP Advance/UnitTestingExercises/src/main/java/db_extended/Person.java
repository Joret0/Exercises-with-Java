package db_extended;

public class Person {
    private Long id;
    private String username;

    public Person(long id, String username) {
        this.id = id;
        this.username = username;
    }

    public Long getId() {
        return this.id;
    }

    public String getUsername() {
        return this.username;
    }
}
