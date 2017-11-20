package Pr6BirthdayCelebrations;

public class Robot implements Inhabitable{

    private String model;
    private String id;
    private String year;

    public Robot(String model, String id) {
        this.id = id;
        this.model = model;
        this.year = "01/01/9999";
    }

    @Override
    public String getYear() {
        return this.year;
    }

    @Override
    public String getId() {
        return this.id;
    }
}
