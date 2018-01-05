package hell.commands;

import hell.annotations.InjectArgs;
import hell.entities.items.CommonItem;
import hell.factories.ItemFactory;
import hell.interfaces.Repository;

/**
 * Created by User on 20.12.2017 г..
 */
public class ItemCommand extends BaseCommand{
    @InjectArgs
    private String[] params;

    public ItemCommand(Repository repository) {
        super(repository);
    }

    @Override
    public String execute() {
        CommonItem commonItem = ItemFactory.createCommonItem(params[1], Integer.parseInt(params[3]), Integer.parseInt(params[4]), Integer.parseInt(params[5]), Integer.parseInt(params[6]), Integer.parseInt(params[7]));
        return super.getManager().itemCommand(commonItem, params[2]);
    }
}
