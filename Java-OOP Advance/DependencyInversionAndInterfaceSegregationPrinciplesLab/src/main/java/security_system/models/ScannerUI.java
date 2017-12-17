package security_system.models;

import security_system.interfaces.KeyCardUI;
import security_system.interfaces.PinCodeUI;

import java.util.Scanner;

public class ScannerUI implements PinCodeUI, KeyCardUI{

    private Scanner scanner;

    public ScannerUI() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public int requestPinCode() {
        System.out.println("enter your pin code");
        return Integer.parseInt(this.scanner.nextLine());
    }

    @Override
    public String requestKeyCard() {
        System.out.println("slide your key card");
        return this.scanner.nextLine();
    }
}
