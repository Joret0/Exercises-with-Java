package Pr10MooD3;

public class Demon extends GameObject{
    public Demon(String userName, String password, int level, double points) {
        super(userName, password, level, points);
    }

    @Override
    public void setPassword(String password) {
        super.setPassword(String.valueOf(super.getUserName().length() * 217));
    }

    @Override
    public String toString() {
        return super.toString().concat(super.getPoints() * super.getLevel() + "");
    }
}
