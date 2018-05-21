package application.repositories;

import application.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Set;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

    Set<Product> findProductByBuyerIsNullAndPriceBetweenOrderByPrice(BigDecimal min, BigDecimal max);
}
