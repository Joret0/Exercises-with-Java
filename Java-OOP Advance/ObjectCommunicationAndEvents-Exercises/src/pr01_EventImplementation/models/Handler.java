package pr01_EventImplementation.models;

import pr01_EventImplementation.interfaces.NameChangeListener;

public class Handler implements NameChangeListener{

    public static final String DISPATCHER_S_NAME_CHANGED_TO_S = "Dispatcher's name changed to %s.";

    @Override
    public void handleChangedName(NameChange event) {
        System.out.println(String.format(DISPATCHER_S_NAME_CHANGED_TO_S, event.getChangedName()));
    }
}
