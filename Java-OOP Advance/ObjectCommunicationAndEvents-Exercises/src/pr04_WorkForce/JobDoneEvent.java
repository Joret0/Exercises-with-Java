package pr04_WorkForce;

import pr04_WorkForce.interfaces.JobDone;

import java.util.EventObject;

public class JobDoneEvent extends EventObject implements JobDone{
    private String name;
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public JobDoneEvent(Object source, String name) {
        super(source);
        this.name = name;
    }

    @Override
    public String getResult() {
        return String.format("Job %s done!",this.name);
    }
}
