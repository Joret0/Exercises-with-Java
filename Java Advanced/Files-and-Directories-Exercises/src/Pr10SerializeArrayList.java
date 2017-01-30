import java.io.*;
import java.util.ArrayList;

public class Pr10SerializeArrayList {

    private final static String PROJECT_PATH = System.getProperty("user.dir") + "/src/resources/arrayList.list";

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(PROJECT_PATH));
        ArrayList<Double> arrayList = new ArrayList<>();
        arrayList.add(5.6);
        arrayList.add(34.43);
        arrayList.add(32.22);
        objectOutputStream.writeObject(arrayList);
        objectOutputStream.flush();
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(PROJECT_PATH));
        System.out.println(objectInputStream.readObject());
        objectInputStream.close();
    }
}
