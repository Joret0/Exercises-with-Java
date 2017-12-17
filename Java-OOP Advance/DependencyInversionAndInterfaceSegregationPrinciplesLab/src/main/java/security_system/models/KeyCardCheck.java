package security_system.models;

import security_system.interfaces.KeyCardUI;

import java.util.Scanner;

public class KeyCardCheck extends SecurityCheck implements KeyCardUI{

    private KeyCardUI securityUI;
    private Scanner scanner;

    public KeyCardCheck(KeyCardUI securityUI) {
        this.scanner = new Scanner(System.in);
        this.securityUI = securityUI;
    }

    private boolean isValid(String code) {
        return true;
    }

    @Override
    public String requestKeyCard() {
        System.out.println("slide your key card");
        return this.scanner.nextLine();
    }

    @Override
    public boolean validateUser() {
        String code = this.requestKeyCard();
        if (isValid(code)) {
            return true;
        }

        return false;
    }
}
