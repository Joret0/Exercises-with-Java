package application.services.api;

import java.util.List;

public interface CarService<Car, Long> extends Service<Car, Long>{
    List<Car> findAllToyotaCars();
}
