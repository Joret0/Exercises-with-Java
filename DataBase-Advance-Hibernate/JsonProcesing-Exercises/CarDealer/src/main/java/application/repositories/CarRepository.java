package application.repositories;

import application.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long>{

    @Query("select c from Car as c where c.make like 'Toyota' " +
            "order by c.model asc, c.travelledDistance desc")
    List<Car> findAllToyotaCars();
}
