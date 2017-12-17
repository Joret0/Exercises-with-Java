package security_system.interfaces;

import security_system.models.KeyCardCheck;
import security_system.models.PinCodeCheck;
import security_system.models.ScannerUI;

import java.io.IOException;
import java.util.Scanner;

public class SecurityManager {
    private KeyCardUI keyCardCheck;
    private PinCodeUI pinCodeCheck;

    public SecurityManager(KeyCardUI keyCardCheck, PinCodeUI pinCodeCheck) {
        this.keyCardCheck = keyCardCheck;
        this.pinCodeCheck = pinCodeCheck;
    }

    private void check() {
        Scanner scanner = new Scanner(System.in);
        int option = Integer.parseInt(scanner.nextLine());
        switch (option) {
            case 1:
                System.out.println(keyCardCheck.requestKeyCard());
                break;
            case 2:
                System.out.println(pinCodeCheck.requestPinCode());
                break;
        }
    }

    public static void main(String[] args) throws IOException {
        ScannerUI scannerUI = new ScannerUI();
        KeyCardCheck keyCardCheck = new KeyCardCheck(scannerUI);
        PinCodeCheck pinCodeCheck = new PinCodeCheck(scannerUI);
        SecurityManager manager = new SecurityManager(keyCardCheck, pinCodeCheck);
        manager.check();
    }
}
