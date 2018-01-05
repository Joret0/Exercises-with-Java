package app.waste_disposal.managementSystems;

public interface Requirement {
    String getType();

    void setType(String type);

    void setEnergyBalance(double energyBalance);

    void setCapitalBalance(double capitalBalance);


    double getEnergyBalance();

    double getCapitalBalance();
}
