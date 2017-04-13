import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pr06CompareCharArrays {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        char[] array1 = reader.readLine().replace(" ", "").toCharArray();
        char[] array2 = reader.readLine().replace(" ", "").toCharArray();
        boolean areEquals = false;

        if (array1.length < array2.length) {
            System.out.println(new String(array1));
            System.out.println(new String(array2));
        } else if (array1.length > array2.length) {
            System.out.println(new String(array2));
            System.out.println(new String(array1));
        } else {
            for (int i = 0; i < array1.length; i++) {
                if (array1[i] < array2[i]) {
                    System.out.println(new String(array1));
                    System.out.println(new String(array2));
                    break;
                } else if (array1[i] > array2[i]) {
                    System.out.println(new String(array2));
                    System.out.println(new String(array1));
                    break;
                } else if (array1[i] == array2[i]){
                    areEquals = true;
                }
            }
        }

        if (areEquals) {
            System.out.println(new String(array1));
            System.out.println(new String(array2));
        }
    }
}
