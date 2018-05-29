package application.annotations.password;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

public class PasswordValidator implements ConstraintValidator<Password, String>{

    int minLength;
    int maxLength;
    boolean containLowerCaseLetter;
    boolean containUpperCaseLetter;
    boolean containDigit;
    boolean containSymbol;

    @Override
    public void initialize(Password password) {
        this.minLength = password.minLength();
        this.maxLength = password.maxLength();
        this.containLowerCaseLetter = password.containLowerCaseLetter();
        this.containUpperCaseLetter = password.containUpperCaseLetter();
        this.containDigit = password.containDigit();
        this.containSymbol = password.containSymbol();
    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext constraintValidatorContext) {
        boolean containLowerCaseLetter = checkForLowerCaseLetter(password);
        boolean containUpperCaseLetter = checkForUpperCaseLetter(password);
        boolean containDigit = checkForDigit(password);
        boolean containSymbol = checkForSpecialSymbol(password);
        int length = password.length();
        if (length < 6 || (!containLowerCaseLetter && this.containLowerCaseLetter) || (!containUpperCaseLetter && this.containUpperCaseLetter) ||
                (!containDigit && this.containDigit)) {
            return false;
        }
        return true;
    }

    private boolean checkForSpecialSymbol(String password) {
        List<Character> list = new ArrayList<Character>() {{
            add('!');
            add('@');
            add('#');
            add('$');
            add('%');
            add('^');
            add('&');
            add('*');
            add('(');
            add(')');
            add('_');
            add('+');
            add('<');
            add('>');
            add('?');
            add('(');
            add(')');
        }};

        for (char c : password.toCharArray()) {
            if (list.contains(c)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkForDigit(String password) {
        for (char c : password.toCharArray()) {
            int cc = (int)c;
            if (cc >= 48 && cc <= 57) {
                return true;
            }
        }
        return false;
    }

    private boolean checkForUpperCaseLetter(String password) {
        for (char c : password.toCharArray()) {
            int cc = (int)c;
            if (cc >= 65 && cc <= 90) {
                return true;
            }
        }
        return false;
    }

    private boolean checkForLowerCaseLetter(String password) {
        for (char c : password.toCharArray()) {
            int cc = (int)c;
            if (cc >= 97 && cc <= 122) {
                return true;
            }
        }
        return false;
    }
}
