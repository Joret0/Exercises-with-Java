package moduleContainerTests;


import cresla.entities.containers.ModuleContainer;
import cresla.interfaces.AbsorbingModule;
import cresla.interfaces.Container;
import cresla.interfaces.EnergyModule;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.NoSuchElementException;

public class ModuleContainerTest {

    private Container container;

    private EnergyModule energyModule1;
    private EnergyModule energyModule2;
    private EnergyModule energyModule3;

    private AbsorbingModule absorbingModule1;
    private AbsorbingModule absorbingModule2;

    @Before
    public void setUp() {
        this.container = new ModuleContainer(3);

        this.energyModule1 = Mockito.mock(EnergyModule.class);
        this.energyModule2 = Mockito.mock(EnergyModule.class);
        this.energyModule3 = Mockito.mock(EnergyModule.class);
        Mockito.when(this.energyModule1.getEnergyOutput()).thenReturn(2_000_000_000);
        Mockito.when(this.energyModule2.getEnergyOutput()).thenReturn(2_000_000_000);
        Mockito.when(this.energyModule3.getEnergyOutput()).thenReturn(2_000_000_000);
        Mockito.when(this.energyModule1.getId()).thenReturn(1);
        Mockito.when(this.energyModule2.getId()).thenReturn(2);
        Mockito.when(this.energyModule3.getId()).thenReturn(3);

        this.absorbingModule1 = Mockito.mock(AbsorbingModule.class);
        this.absorbingModule2 = Mockito.mock(AbsorbingModule.class);
        Mockito.when(this.absorbingModule1.getHeatAbsorbing()).thenReturn(2_000_000_000);
        Mockito.when(this.absorbingModule2.getHeatAbsorbing()).thenReturn(2_000_000_000);
        Mockito.when(this.absorbingModule1.getId()).thenReturn(3);
        Mockito.when(this.absorbingModule2.getId()).thenReturn(4);
    }

    @Test
    public void classShouldRemoveFirstModuleWhenCapacityReached() {
        this.container.addAbsorbingModule(this.absorbingModule2);
        this.container.addAbsorbingModule(this.absorbingModule2);
        this.container.addEnergyModule(this.energyModule1);
        this.container.addEnergyModule(this.energyModule3);

        Assert.assertEquals(0, this.container.getTotalHeatAbsorbing());
        Assert.assertEquals(4_000_000_000L, this.container.getTotalEnergyOutput());
    }

    @Test
    public void getTotalHeatAbsorbingOnEmptyCollection() throws Exception {
        Assert.assertEquals(0, this.container.getTotalHeatAbsorbing());
    }

    @Test
    public void getTotalEnergyOutputOnEmptyCollection() throws Exception {
        Assert.assertEquals(0, this.container.getTotalEnergyOutput());
    }

    @Test(expected = NoSuchElementException.class)
    public void addModuleOnEmptyContainerShouldThrowEx() throws Exception {
        Container container1 = new ModuleContainer(0);
        container1.addAbsorbingModule(this.absorbingModule2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addEnergyModuleWithNullValueShouldThrowException() {
        this.container.addEnergyModule(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addAbsorbingModuleWithNullValueShouldThrowException() {
        this.container.addAbsorbingModule(null);
    }

    @Test
    public void getTotalEnergyOutputShouldWorkCorrectly() throws Exception {
        this.container.addEnergyModule(this.energyModule1);
        this.container.addEnergyModule(this.energyModule2);
        Assert.assertEquals(4_000_000_000L, this.container.getTotalEnergyOutput());
    }

    @Test
    public void getTotalHeatAbsorbingShouldWorkCorrectly() throws Exception {
        this.container.addAbsorbingModule(this.absorbingModule1);
        this.container.addAbsorbingModule(this.absorbingModule2);
        Assert.assertEquals(4_000_000_000L, this.container.getTotalHeatAbsorbing());
    }
}
