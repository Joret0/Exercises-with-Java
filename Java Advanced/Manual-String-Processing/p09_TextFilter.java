import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p09_TextFilter {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] banList = reader.readLine().split(", ");
        String text = reader.readLine();
        for (String ban : banList) {
            StringBuilder asteriksBuilder = new StringBuilder();
            for (int i = 0; i < ban.length(); i++) {
                asteriksBuilder.append("*");
            }
            text = text.replaceAll(ban, asteriksBuilder.toString());
        }
        System.out.println(text);
    }
}
