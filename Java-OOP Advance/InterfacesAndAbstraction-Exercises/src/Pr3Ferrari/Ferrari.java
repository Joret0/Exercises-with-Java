package Pr3Ferrari;

public class Ferrari implements Car{

    private String driverName;

    Ferrari(String driverName) {
        this.driverName = driverName;
    }

    @Override
    public String getModel() {
        return "488-Spider";
    }

    @Override
    public String getDriverName() {
        return this.driverName;
    }

    @Override
    public String pushTheGas() {
        return "Zadu6avam sA!";
    }

    @Override
    public String useBrakes() {
        return "Brakes!";
    }

    @Override
    public String toString() {
        return String.format("%s/%s/%s/%s",
                this.getModel(), this.useBrakes(), this.pushTheGas(), this.getDriverName());
    }
}
