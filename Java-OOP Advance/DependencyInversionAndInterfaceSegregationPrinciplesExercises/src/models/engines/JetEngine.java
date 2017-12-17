package models.engines;

public class JetEngine extends BaseEngine{
    private static final int MULTIPLIER = 5;

    public JetEngine(String model, int horsepower, int displacement) {
        super(model, horsepower, displacement);
    }

    @Override
    public int getOutput() {
        if (this.getCachedOutput() != 0) {
            return this.getCachedOutput();
        }

        this.setCachedOutput((this.getHorsepower() * MULTIPLIER) + this.getDisplacement());
        return this.getCachedOutput();
    }
}
