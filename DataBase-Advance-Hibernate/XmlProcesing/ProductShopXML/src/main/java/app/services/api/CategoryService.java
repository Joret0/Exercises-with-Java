package app.services.api;

import java.util.Set;

public interface CategoryService<Category, Long> extends Service<Category, Long>{
    Set<Object[]> categoriesByProductsCount();
}
