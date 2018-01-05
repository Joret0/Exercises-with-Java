package hell.commands;

import hell.annotations.InjectArgs;
import hell.entities.items.RecipeItem;
import hell.factories.ItemFactory;
import hell.interfaces.Repository;

import java.util.Arrays;

public class RecipeCommand extends BaseCommand{
    @InjectArgs
    private String[] params;

    public RecipeCommand(Repository repository) {
        super(repository);
    }

    @Override
    public String execute() {
        RecipeItem recipeItem = ItemFactory.createRecipeItem(params[1], Integer.parseInt(params[3]), Integer.parseInt(params[4]), Integer.parseInt(params[5]), Integer.parseInt(params[6]), Integer.parseInt(params[7]), Arrays.copyOfRange(this.params,8,this.params.length));
        return super.getManager().recipeCommand(recipeItem, params[2]);
    }
}
