package Pr11.CatLady;


public class Cat {
    private String name;
    private String breed;
    private String catSpecific;

    public Cat(String name, String breed, String catSpecific) {
        this.name = name;
        this.breed = breed;
        this.catSpecific = catSpecific;
    }

    public String getName() {
        return this.name;
    }

    public String getBreed() {
        return this.breed;
    }

    public String getCatSpecific() {
        return this.catSpecific;
    }
}
