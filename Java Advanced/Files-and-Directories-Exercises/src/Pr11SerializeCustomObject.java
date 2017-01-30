import resources.Course;

import java.io.*;

public class Pr11SerializeCustomObject {

    private final static String PROJECT_PATH = System.getProperty("user.dir") + "/src/resources/Course.ser";

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(PROJECT_PATH));
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(PROJECT_PATH));

        Course course = new Course("Java Advance", 250);
        objectOutputStream.writeObject(course);
        Course readerObject = (Course)objectInputStream.readObject();
        readerObject.printInfo();
    }
}
