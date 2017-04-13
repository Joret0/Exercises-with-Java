import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pr17ReverseString {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder(reader.readLine());
        builder.reverse();
        System.out.println(builder);
    }
}
