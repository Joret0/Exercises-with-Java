package employee_info.interfaces;

import java.util.List;

public interface InfoProvider {
    List<Human> getByName();
    Iterable<Human> getBySalary();
}
