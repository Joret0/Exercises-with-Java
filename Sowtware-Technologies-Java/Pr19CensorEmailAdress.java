import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pr19CensorEmailAdress {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String mail = reader.readLine();
        String text = reader.readLine();
        int index = mail.indexOf("@");
        String replaceString = mail.substring(0, index);
        String domain = mail.substring(index, mail.length());
        String userName = replaceString.replaceAll("[\\dA-Za-z()?:!.,;{}]", "*");
        String mailToReplace = userName + domain;
        String result = text.replaceAll(mail, mailToReplace);
        System.out.println(result);
    }
}
