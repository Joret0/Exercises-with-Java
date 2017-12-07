package rpg_tests;

import interfaces.Target;
import interfaces.Weapon;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import rpg_lab.Hero;

public class HeroTests {
    private static final String HERO_NAME = "Georgi";
    private static final int EXPERIENCE_POINTS = 3;

    private Weapon weapon;
    private Target target;

    @Before
    public void initializeData() {
        this.weapon = Mockito.mock(Weapon.class);
        this.target = Mockito.mock(Target.class);
        Mockito.when(target.isDead()).thenReturn(true);
        Mockito.when(target.giveExperience()).thenReturn(EXPERIENCE_POINTS);
    }

    @Test
    public void ifHeroGainsXPOnDeadTarget() {
        Hero hero = new Hero(HERO_NAME, weapon);
        hero.attack(target);
        Assert.assertEquals("models.Hero does not gain xp ot dead target properly.", EXPERIENCE_POINTS, hero.getExperience());
    }

    @Test
    public void ifHeroGetsRandomWeaponOnSuccessfulAttack() {
        Hero hero = new Hero(HERO_NAME, weapon);
        hero.attack(target);
        int expectedValue = 1;
        Assert.assertEquals("models.Hero does not get random weapon on successful attack ot dead target properly.",
                expectedValue);
    }
}
