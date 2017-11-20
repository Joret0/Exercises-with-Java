package Pr6BirthdayCelebrations;

public class Pet implements Inhabitable{

    private String name;
    private String year;

    public Pet(String name, String year) {
        this.name = name;
        this.year = year;
    }

    @Override
    public String getYear() {
        return this.year;
    }

    @Override
    public String getId() {
        return null;
    }
}
