import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pr9PhoneNumbers {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        while (true) {
            String input = bufferedReader.readLine();
            if (input.equals("END")) {
                break;
            }
            stringBuilder.append(input);
        }
        String regex = "([A-Z][a-zA-Z]*)([^a-zA-Z\\+]*\\+?\\d[\\(\\)\\-\\.\\s\\/\\d]*\\d)";
        Matcher matcher = Pattern.compile(regex).matcher(stringBuilder);
        List<String> outputList = new ArrayList<>();
        while (matcher.find()) {
            String name = matcher.group(1);
            String phone = getPhone(matcher.group(2));
            outputList.add(getFormattedLine(name, phone));
        }
        if (outputList.isEmpty()) {
            System.out.println("<p>No matches!</p>");
        } else {
            System.out.print("<ol>");
            for (String s : outputList) {
                System.out.print(s);
            }
            System.out.print("</ol>");
        }
    }

    private static String getFormattedLine(String name, String phone) {
        return String.format("<li><b>%s:</b> %s</li>", name, phone);
    }

    private static String getPhone(String group) {
        List<Character> symbols = new ArrayList<Character>() {{
            add('(');
            add(')');
            add('/');
            add('.');
            add('-');
            add(' ');
            add('+');
        }};

        StringBuilder sb = new StringBuilder();
        for (int i = group.length() - 1; i >= 0; i--) {
            char currentChar = group.charAt(i);
            if (!symbols.contains(currentChar) && currentChar < 48 || currentChar > 57) {
                break;
            }
            sb.append(currentChar);
        }
        String phone = sb.reverse().toString().trim();
        phone = clearNumber(phone);
        return  phone;
    }

    private static String clearNumber(String phone) {
        StringBuilder sb = new StringBuilder();
        boolean isPlusAdded = false;
        if (phone.charAt(0) == '+') {
            sb.append('+');
            isPlusAdded = true;
        }
        int i;
        if (isPlusAdded)
            i = 1;
        else
            i = 0;

        for (; i <phone.toCharArray().length; i++) {
            char current = phone.charAt(i);
            if (current >= 48 && current <= 57) {
                sb.append(current);
            }
        }
        return sb.toString();
    }
}
