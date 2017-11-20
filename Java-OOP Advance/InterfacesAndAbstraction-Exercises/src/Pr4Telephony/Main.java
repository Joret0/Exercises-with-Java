package Pr4Telephony;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> phoneList = Arrays.stream(reader.readLine().split("\\s+")).collect(Collectors.toList());
        List<String> webSiteList = Arrays.stream(reader.readLine().split("\\s+")).collect(Collectors.toList());

        Smartphone smartphone = new Smartphone(phoneList, webSiteList);

        smartphone.calling();
        smartphone.browsing();
    }
}
