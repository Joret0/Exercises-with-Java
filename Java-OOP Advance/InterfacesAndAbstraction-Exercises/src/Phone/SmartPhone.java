package Phone;


public class SmartPhone implements Callable, Browseable{

    private String number;
    private String url;

    @Override
    public void call(String number) {
        this.setNumber(number);
        System.out.printf("Calling... %s%n", this.number);
    }

    @Override
    public void browse(String url) {
        this.setUrl(url);
        System.out.printf("Browsing: %s!%n", this.url);
    }

    private void setNumber(String number) {
        for (char c : number.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException("Invalid number!");
            }
        }

        this.number = number;
    }

    private void setUrl(String url) {
        for (char c : url.toCharArray()) {
            if (Character.isDigit(c)) {
                throw new IllegalArgumentException("Invalid URL!");
            }
        }
        this.url = url;
    }
}
