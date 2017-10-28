import java.util.Scanner;

public class Pr9TerroristsWin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        line = setBombsOff(line);
        System.out.println(line);
    }

    private static String setBombsOff(String line) {
        while (true) {
            int bombBegin = line.indexOf('|');
            int bombEnd = line.indexOf('|', bombBegin + 1);
            if (bombBegin == -1 || bombEnd == -1) {
                break;
            }
            int power = getBombPower(line, bombBegin, bombEnd);
            line = executeBomb(line, bombBegin - power, bombEnd + power);
        }
        return line;
    }

    private static String executeBomb(String line, int i, int i1) {
        char[] a = line.toCharArray();
        for (int j = i; j <= i1; j++) {
            try {
                a[j] = '.';
            } catch (ArrayIndexOutOfBoundsException ex) {

            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : a) {
            stringBuilder = stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }

    private static int getBombPower(String line, int bombBegin, int bombEnd) {
        int power = 0;
        for (int i = bombBegin + 1; i < bombEnd; i++) {
            power += line.charAt(i);
        }
        return power % 10;
    }


}
