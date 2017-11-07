package Pr6Animals;

public class Animal implements SoundProducable{

    private String name;
    private String age;
    private String gender;

    Animal(String name, String age, String gender) {
        this.setName(name);
        this.setAge(age);
        this.setGender(gender);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (name.isEmpty() || name.trim().length() == 0) {
            throw new IllegalArgumentException("Invalid input!");
        }
        this.name = name;
    }

    private String getAge() {
        return this.age;
    }

    private void setAge(String age) {
        int value = Integer.parseInt(age);
        if (age.isEmpty() || age.trim().length() == 0 || value < 0) {
            throw new IllegalArgumentException("Invalid input!");
        }
        this.age = age;
    }

    private String getGender() {
        return this.gender;
    }

    private void setGender(String gender) {
        if (gender.isEmpty() || gender.trim().length() == 0) {
            throw new IllegalArgumentException("Invalid input!");
        }
        if (!gender.toLowerCase().equals("male") && !gender.toLowerCase().equals("female")) {
            throw new IllegalArgumentException("Invalid input!");
        }
        this.gender = gender;
    }

    @Override
    public String produceSound() {
        return "Not implemented!";
    }

    public String toString() {
        return String.format("%s%n%s %s %s%n%s%n",
                this.getClass().getSimpleName(),
                this.getName(),
                this.getAge(),
                this.getGender(),
                this.produceSound());
    }
}
