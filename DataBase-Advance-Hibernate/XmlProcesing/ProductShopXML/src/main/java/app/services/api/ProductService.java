package app.services.api;

import java.util.Set;

public interface ProductService<Product, Long> extends Service<Product, Long>{
    Set<Object[]> productsInRange();
}
