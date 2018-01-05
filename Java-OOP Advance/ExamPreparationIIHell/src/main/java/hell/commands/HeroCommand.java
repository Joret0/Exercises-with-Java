package hell.commands;

import hell.annotations.InjectArgs;
import hell.factories.HeroFactory;
import hell.interfaces.Hero;
import hell.interfaces.Repository;

public class HeroCommand extends BaseCommand{
    @InjectArgs
    private String[] params;

    public HeroCommand(Repository repository) {
        super(repository);
    }

    @Override
    public String execute() {
        Hero hero = HeroFactory.create(params[2], params[1]);
        return super.getManager().heroCommand(hero);
    }
}
