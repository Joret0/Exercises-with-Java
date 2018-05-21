package application.repositories;

import application.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long>{
    @Query("select s.car.make, s.car.model, s.car.travelledDistance, s.customer.name, s.discount, sum(p.price), sum(p.price) * (s.discount / 100) " +
            "from Sale s " +
            "inner join s.car.parts p " +
            "group by s")
    List<Object[]> salesWithAppliedDiscount();
}
