package rpg_tests;


import interfaces.Target;
import interfaces.Weapon;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rpg_lab.Axe;
import rpg_lab.Dummy;
import rpg_lab.Hero;

public class DummyTests {

    private static final int DUMMY_INITIAL_HEALTH = 50;
    private static final int DUMMY_INITIAL_EXPERIENCE = 40;
    private static final int DUMMY_INITIAL_ATTACK_POINTS = 25;
    private static final String DUMMY_DOES_NOT_LOSE_HEALTH_PROPERLY_MESSAGE = "models.Dummy does not lose health properly.";
    private static final int DUMMY_EXPECTED_HEALTH = 25;
    private static final String DEAD_DUMMY_DOES_NOT_THROW_EXCEPTION_MESSAGE = "Dead dummy does not throw exception.";
    private static final int HERO_INITIAL_EXPERIENCE = 40;
    private static final String DEAD_DUMMY_DOES_NOT_GIVE_EXPERIENCE_MESSAGE = "Dead dummy does not give experience.";
    private static final String HERO_NAME = "Ivan";
    private static final String ALIVE_DUMMY_DOES_GIVE_EXPERIENCE_MESSAGE = "Alive dummy does give experience.";
    private static final int ZERO_VALUE = 0;
    public static final int AXE_ATTACK = 10;
    public static final int AXE_DURABILITY = 10;

    private Target dummy;
    private Hero hero;
    private Weapon weapon;

    @Before
    public void createObjects() {
        this.dummy = new Dummy(DUMMY_INITIAL_HEALTH, DUMMY_INITIAL_EXPERIENCE);
        this.weapon = new Axe(AXE_ATTACK, AXE_DURABILITY);
        this.hero = new Hero(HERO_NAME, weapon);
    }

    @Test
    public void dummyLosesHealthIfAttacked() {
        this.dummy.takeAttack(DUMMY_INITIAL_ATTACK_POINTS);
        Assert.assertEquals(DUMMY_DOES_NOT_LOSE_HEALTH_PROPERLY_MESSAGE, DUMMY_EXPECTED_HEALTH, this.dummy.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void deadDummyThrowsExceptionIfAttacked() {
        for (int i = 0; i < 3; i++) {
            this.dummy.takeAttack(DUMMY_INITIAL_ATTACK_POINTS);
        }
        Assert.assertEquals(DEAD_DUMMY_DOES_NOT_THROW_EXCEPTION_MESSAGE, DUMMY_EXPECTED_HEALTH, this.dummy.getHealth());
    }

    @Test
    public void deadDummyCanGiveXP() {
        for (int i = 0; i < 5; i++) {
            this.hero.attack(this.dummy);
        }
        Assert.assertEquals(DEAD_DUMMY_DOES_NOT_GIVE_EXPERIENCE_MESSAGE, HERO_INITIAL_EXPERIENCE, this.hero.getExperience());
    }

    @Test
    public void aliveDummyCantGiveXP() {
        this.hero.attack(this.dummy);
        Assert.assertEquals(ALIVE_DUMMY_DOES_GIVE_EXPERIENCE_MESSAGE, ZERO_VALUE, this.hero.getExperience());
    }
}
