package hell.interfaces;

import hell.entities.items.CommonItem;

public interface Repository {

    String heroCommand(Hero hero);

    String itemCommand(CommonItem item, String heroName);

    String recipeCommand(Recipe recipe, String heroName);

    String inspectCommand(String heroName) throws IllegalAccessException;

    String quitCommand() throws IllegalAccessException;
}
