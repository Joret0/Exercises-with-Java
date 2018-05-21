package application.services.api;

import java.math.BigDecimal;
import java.util.Set;

public interface ProductService<Product, Long> extends Service<Product, Long>{
    Set<Product> findProductByBuyerIsNullAndPriceBetweenOrderByPrice(BigDecimal min, BigDecimal max);
}
