package app.repositories;

import app.modules.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

    @Query("select p.name,p.price,concat(p.seller.firstName,' ', p.seller.lastName) from Product p " +
            " where p.price between 500 and 1000 " +
            "order by p.price asc")
    Set<Object[]> productsInRange();
}
