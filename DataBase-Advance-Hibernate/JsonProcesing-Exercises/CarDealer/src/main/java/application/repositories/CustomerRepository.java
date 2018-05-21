package application.repositories;

import application.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

    @Query("select c\n" +
            "from Customer as c\n" +
            "order by c.birthDate asc")
    List<Customer> orderedCustomers();

    @Query("select c from Customer c inner join c.sales s inner join s.car.parts p group by c " +
            "having count(s) >= 1 " +
            "order by sum(p.price) desc, count(s.customer) desc")
    List<Customer> totalSalesByCustomer();
}
