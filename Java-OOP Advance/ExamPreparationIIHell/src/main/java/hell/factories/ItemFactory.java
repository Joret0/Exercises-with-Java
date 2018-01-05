package hell.factories;

import hell.entities.items.CommonItem;
import hell.entities.items.RecipeItem;
import hell.interfaces.Item;

public final class ItemFactory {
    public static CommonItem createCommonItem(String itemName, int strengthBonus, int agilityBonus, int intelligenceBonus, int hitPointsBonus, int damageBonus) {
        return new CommonItem(itemName, strengthBonus, agilityBonus, intelligenceBonus, hitPointsBonus, damageBonus);
    }

    public static RecipeItem createRecipeItem(String itemName, int strengthBonus, int agilityBonus, int intelligenceBonus, int hitPointsBonus, int damageBonus, String[] requiredItems) {
        return new RecipeItem(itemName, strengthBonus, agilityBonus, intelligenceBonus, hitPointsBonus, damageBonus, requiredItems);
    }
}
