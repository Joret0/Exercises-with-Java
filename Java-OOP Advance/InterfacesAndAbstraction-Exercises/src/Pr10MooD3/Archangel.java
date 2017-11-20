package Pr10MooD3;


public class Archangel extends GameObject{
    public Archangel(String userName, String password, int level, double points) {
        super(userName, password, level, points);
    }

    @Override
    public void setPassword(String password) {
        String reversed = new StringBuilder(super.getUserName()).reverse().toString();
        int length = super.getUserName().length() * 21;
        super.setPassword(reversed + length);
    }

    @Override
    public String toString() {
        return super.toString().concat(String.format("%.0f", super.getPoints() * super.getLevel()));
    }
}
