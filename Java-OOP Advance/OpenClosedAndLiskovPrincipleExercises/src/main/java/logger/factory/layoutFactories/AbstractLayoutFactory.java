package logger.factory.layoutFactories;

import logger.classes.layouts.SimpleLayout;
import logger.classes.layouts.XmlLayout;
import logger.interfaces.ILayoutFactory;
import logger.interfaces.Layout;
import logger.utils.Constants;

public class AbstractLayoutFactory implements ILayoutFactory{

    @Override
    public Layout getLayout(String type) {
        if (type.equals(Constants.SIMPLE_LAYOUT)) {
            return new SimpleLayout();
        } else if (type.equals(Constants.XML_LAYOUT)) {
            return new XmlLayout();
        }
        return null;
    }
}
