package security_system.models;

import security_system.interfaces.PinCodeUI;

import java.util.Scanner;

public class PinCodeCheck extends SecurityCheck implements PinCodeUI{
    private PinCodeUI securityUI;
    private Scanner scanner;

    public PinCodeCheck(PinCodeUI securityUI) {
        this.securityUI = securityUI;
        this.scanner = new Scanner(System.in);
    }

    private boolean isValid(int pin) {
        return true;
    }

    @Override
    public boolean validateUser() {
        int pin = this.requestPinCode();
        if (isValid(pin)) {
            return true;
        }
        return false;
    }

    @Override
    public int requestPinCode() {
        System.out.println("enter your pin code");
        return Integer.parseInt(this.scanner.nextLine());
    }
}
