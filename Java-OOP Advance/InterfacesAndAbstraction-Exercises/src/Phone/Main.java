package Phone;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] phones = in.nextLine().split("\\s+");
        String[] urls = in.nextLine().split("\\s+");

        SmartPhone smartphone = new SmartPhone();
        callNumbers(phones, smartphone);
        browseUrls(urls, smartphone);
    }

    private static void browseUrls(String[] urls, SmartPhone smartphone) {
        for (String url : urls) {
            try {
                smartphone.browse(url);
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }
        }
    }

    private static void callNumbers(String[] phones, SmartPhone smartphone) {
        for (String phone : phones) {
            try {
                smartphone.call(phone);
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }
        }
    }
}
