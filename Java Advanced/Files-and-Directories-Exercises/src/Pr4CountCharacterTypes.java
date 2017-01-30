import java.io.*;

public class Pr4CountCharacterTypes {

    private static final String path = "/src/resources/SomeText.txt/";
    private static final String PROJECT_PATH = System.getProperty("user.dir") + "/src/resources/results.txt";
    public static void main(String[] args) throws IOException {

        String projectPath = System.getProperty("user.dir");
        String filePath = projectPath + path;
        File someFile = new File(filePath);
        FileReader fileReader = new FileReader(someFile);
        BufferedReader reader = new BufferedReader(fileReader);

        String line;
        String[] stringArray = new String[0];
        StringBuilder builder = new StringBuilder();

        while ((line = reader.readLine()) != null) {
            stringArray = line.split(" ");
        }
        for (int i = 0; i < stringArray.length; i++) {
            builder.append(stringArray[i]);
        }

        String text = builder.toString();
        char[] arrayChar = text.toCharArray();

        int vowelCount = 0;
        int punctuationCount = 0;
        int consonantsCount = 0;
        String punctuation = "!.,?";
        String vowels = "aeiou";

        for (char c : arrayChar) {
            if (vowels.contains(c + "")) {
                vowelCount++;
            } else if (punctuation.contains(c + "")) {
                punctuationCount++;
            } else if (Character.isLetter(c)) {
                consonantsCount++;
            }
        }


        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(PROJECT_PATH)));

        printWriter.write(String.format("Vowels: %d%n", vowelCount));
        printWriter.write(String.format("Consonants: %d%n", consonantsCount));
        printWriter.write(String.format("Punctuation: %d%n", punctuationCount));
        printWriter.close();
        reader.close();
    }
}
