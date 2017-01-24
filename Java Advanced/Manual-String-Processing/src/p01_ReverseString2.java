import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p01_ReverseString2 {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        builder.append(reader.readLine());
        System.out.println(builder.reverse().toString());
    }
}
