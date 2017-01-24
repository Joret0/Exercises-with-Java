import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p02_StringLength {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        StringBuilder builder = new StringBuilder(input);
        if (builder.length() > 20){
            builder.delete(20, builder.length());
        }
        for (int i = builder.length(); i < 20; i++) {
            builder.append("*");
        }
        System.out.println(builder.toString());
    }
}
