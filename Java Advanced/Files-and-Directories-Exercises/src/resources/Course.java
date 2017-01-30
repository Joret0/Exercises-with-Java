package resources;

import java.io.Serializable;

public class Course implements Serializable {
    private String name;
    private int numberOfCourses;

    public Course(String name, int numberOfCourses) {
        this.name = name;
        this.numberOfCourses = numberOfCourses;
    }

    public void printInfo() {
        System.out.printf("In course %s have %d students.", this.name, this.numberOfCourses);
    }
}
