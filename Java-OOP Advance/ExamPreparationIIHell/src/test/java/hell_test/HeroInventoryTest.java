package hell_test;

import hell.entities.miscellaneous.HeroInventory;
import hell.interfaces.Inventory;
import hell.interfaces.Item;
import hell.interfaces.Recipe;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Map;

public class HeroInventoryTest {
    private Inventory heroInventory;
    private Item commonItemMock1;
    private Item commonItemMock2;
    private Item commonItemMock3;
    private Item commonItemMock4;
    private Recipe recipeItemMock;

    @Before
    public void initialize() {
        this.heroInventory = new HeroInventory();
        this.commonItemMock1 = Mockito.mock(Item.class);
        Mockito.when(this.commonItemMock1.getName()).thenReturn("Mock1");
        this.commonItemMock2 = Mockito.mock(Item.class);
        Mockito.when(this.commonItemMock2.getName()).thenReturn("Mock2");
        this.commonItemMock3 = Mockito.mock(Item.class);
        Mockito.when(this.commonItemMock3.getName()).thenReturn("Mock3");

        setMockedCommonItemBonuses();

        this.heroInventory.addCommonItem(this.commonItemMock1);
        this.heroInventory.addCommonItem(this.commonItemMock2);
        this.heroInventory.addCommonItem(this.commonItemMock3);
    }

    @Test
    public void getTotalStrengthBonusShouldReturnSumOfHeroStrengthAndAllBonuses() {
        //Arrange

        //Act

        //Assert
        Assert.assertEquals(
                "Total Strength Bonus is not correct", 70, this.heroInventory.getTotalStrengthBonus());
    }

    @Test
    public void getTotalAgilityBonusShouldReturnSumOfHeroAgilityAndAllBonuses() {
        //Arrange

        //Act

        //Assert
        Assert.assertEquals(
                "Total Agility Bonus is not correct", 23, this.heroInventory.getTotalAgilityBonus());
    }

    @Test
    public void getTotalIntelligenceBonusShouldReturnSumOfHeroIntelligenceAndAllBonuses() {
        //Arrange

        //Act

        //Assert
        Assert.assertEquals(
                "Total Intelligence Bonus is not correct", 20, this.heroInventory.getTotalIntelligenceBonus());
    }

    @Test
    public void getTotalHitPointsBonusShouldReturnSumOfHeroHitPointsAndAllBonuses() {
        //Arrange

        //Act

        //Assert
        Assert.assertEquals(
                "Total HitPoints Bonus is not correct", 40, this.heroInventory.getTotalHitPointsBonus());
    }

    @Test
    public void getTotalDamageBonusShouldReturnSumOfHeroDamageAndAllBonuses() {
        //Arrange

        //Act

        //Assert
        Assert.assertEquals(
                "Total Damage Bonus is not correct", 80, this.heroInventory.getTotalDamageBonus());
    }

    @Test
    public void addCommonItemShouldReturnCorrectSizeOfCommonItems() throws NoSuchFieldException, IllegalAccessException {
        //Arrange
        Class<?> inventoryClass = this.heroInventory.getClass();
        Field commonItemField = inventoryClass.getDeclaredField("commonItems");
        commonItemField.setAccessible(true);
        Map<String, Item> items = (Map<String, Item>) commonItemField.get(this.heroInventory);

        Field recipeItemsField = inventoryClass.getDeclaredField("recipeItems");
        recipeItemsField.setAccessible(true);
        Map<String, Recipe> recipes = (Map<String, Recipe>) commonItemField.get(this.heroInventory);

        this.recipeItemMock = Mockito.mock(Recipe.class);
        Mockito.when(this.recipeItemMock.getName()).thenReturn("Recipe");
        Mockito.when(this.recipeItemMock.getRequiredItems()).thenReturn(
                new ArrayList<String>() {{
                    add("Mock1");
                    add("Mock4");
                }});
        this.heroInventory.addRecipeItem(this.recipeItemMock);
        this.commonItemMock4 = Mockito.mock(Item.class);
        Mockito.when(this.commonItemMock4.getName()).thenReturn("Mock4");
        this.heroInventory.addCommonItem(this.commonItemMock4);

        //Act

        //Assert
        Assert.assertEquals("Items are not added correctly", 3, items.size());

    }

    @Test
    public void addRecipeItemShouldReturnCorrectSizeOfCommonItems() throws NoSuchFieldException, IllegalAccessException {
        //Arrange
        Class<?> inventoryClass = this.heroInventory.getClass();
        Field commonItemField = inventoryClass.getDeclaredField("commonItems");
        commonItemField.setAccessible(true);
        Map<String, Item> items = (Map<String, Item>) commonItemField.get(this.heroInventory);

        Field recipeItemsField = inventoryClass.getDeclaredField("recipeItems");
        recipeItemsField.setAccessible(true);
        Map<String, Recipe> recipes = (Map<String, Recipe>) recipeItemsField.get(this.heroInventory);

        this.recipeItemMock = Mockito.mock(Recipe.class);
        Mockito.when(this.recipeItemMock.getName()).thenReturn("Recipe");
        Mockito.when(this.recipeItemMock.getRequiredItems()).thenReturn(
                new ArrayList<String>() {{
                    add("Mock1");
                    add("Mock2");
                }});
        this.heroInventory.addRecipeItem(this.recipeItemMock);
        //Act

        //Assert
        Assert.assertEquals("Recipe is not added correctly", 1, recipes.size());
    }

    private void setMockedCommonItemBonuses() {
        Mockito.when(this.commonItemMock1.getStrengthBonus()).thenReturn(12);
        Mockito.when(this.commonItemMock2.getStrengthBonus()).thenReturn(30);
        Mockito.when(this.commonItemMock3.getStrengthBonus()).thenReturn(28);

        Mockito.when(this.commonItemMock1.getAgilityBonus()).thenReturn(11);
        Mockito.when(this.commonItemMock2.getAgilityBonus()).thenReturn(22);
        Mockito.when(this.commonItemMock3.getAgilityBonus()).thenReturn(-10);

        Mockito.when(this.commonItemMock1.getIntelligenceBonus()).thenReturn(13);
        Mockito.when(this.commonItemMock2.getIntelligenceBonus()).thenReturn(17);
        Mockito.when(this.commonItemMock3.getIntelligenceBonus()).thenReturn(-10);

        Mockito.when(this.commonItemMock1.getHitPointsBonus()).thenReturn(13);
        Mockito.when(this.commonItemMock2.getHitPointsBonus()).thenReturn(17);
        Mockito.when(this.commonItemMock3.getHitPointsBonus()).thenReturn(10);

        Mockito.when(this.commonItemMock1.getDamageBonus()).thenReturn(13);
        Mockito.when(this.commonItemMock2.getDamageBonus()).thenReturn(17);
        Mockito.when(this.commonItemMock3.getDamageBonus()).thenReturn(50);
    }
}
