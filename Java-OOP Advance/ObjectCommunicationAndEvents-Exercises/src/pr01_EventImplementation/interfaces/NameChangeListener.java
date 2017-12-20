package pr01_EventImplementation.interfaces;

import pr01_EventImplementation.models.NameChange;

public interface NameChangeListener {
    void handleChangedName(NameChange event);
}
