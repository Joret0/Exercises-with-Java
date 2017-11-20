package Pr4Telephony;


import java.util.List;

public class Smartphone implements Callable, Browsable{

    private List<String> phoneNumbers;
    private List<String> listOfWebSites;

    Smartphone(List<String> phoneNumbers, List<String> listOfWebSites) {
        this.phoneNumbers = phoneNumbers;
        this.listOfWebSites = listOfWebSites;
    }

    @Override
    public void calling() {
        for (String phoneNumber : phoneNumbers) {
            System.out.printf("Calling... %s%n", phoneNumber);
        }
    }

    @Override
    public void browsing() {
        boolean hasDigit = false;
        for (String webSite : listOfWebSites) {
            for (int i = 0; i < webSite.length(); i++) {
                if (Character.isDigit(webSite.charAt(i))) {
                    hasDigit = true;
                }
            }
            if (hasDigit) {
                System.out.println("Invalid URL!");
                hasDigit = false;
            } else {
                System.out.printf("Browsing: %s!%n", webSite);
            }
        }
    }
}
