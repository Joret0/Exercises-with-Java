package app.waste_disposal.managementSystems;

public class ManagementRequirement implements Requirement{
    private String type;
    private double energyBalance;
    private double capitalBalance;

    public ManagementRequirement(String type, double energyBalance, double capitalBalance) {
        this.type = type;
        this.energyBalance = energyBalance;
        this.capitalBalance = capitalBalance;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public void setEnergyBalance(double energyBalance) {
        this.energyBalance = energyBalance;
    }

    @Override
    public void setCapitalBalance(double capitalBalance) {
        this.capitalBalance = capitalBalance;
    }

    @Override
    public double getEnergyBalance() {
        return energyBalance;
    }

    @Override
    public double getCapitalBalance() {
        return capitalBalance;
    }
}
