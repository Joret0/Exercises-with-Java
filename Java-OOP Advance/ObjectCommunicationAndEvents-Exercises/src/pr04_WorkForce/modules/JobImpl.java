package pr04_WorkForce.modules;

import pr04_WorkForce.JobDoneEvent;
import pr04_WorkForce.interfaces.Employee;
import pr04_WorkForce.interfaces.Job;
import pr04_WorkForce.interfaces.JobDone;

public class JobImpl implements Job{

    private String name;
    private Employee employee;
    private int hoursRequired;
    private boolean isDone;

    public JobImpl(String name, Employee employee, int hoursRequired) {
        this.name = name;
        this.employee = employee;
        this.hoursRequired = hoursRequired;
        this.setDone(false);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employee getEmployee() {
        return this.employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public int getHoursRequired() {
        return this.hoursRequired;
    }

    public void setHoursRequired(int hoursRequired) {
        this.hoursRequired = hoursRequired;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    @Override
    public void update() {
        this.setHoursRequired(this.getHoursRequired() - this.getEmployee().getHoursPerWeek());
        if (this.getHoursRequired() <= 0) {
            JobDone finishedJob = new JobDoneEvent(this, this.getName());
            System.out.println(finishedJob.getResult());
            this.setDone(true);
        }
    }

    @Override
    public boolean isDone() {
        return this.isDone;
    }

    @Override
    public String toString() {
        return String.format("Job: %s Hours Remaining: %d", this.getName(), this.getHoursRequired());
    }
}
