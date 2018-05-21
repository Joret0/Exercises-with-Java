package application.repositories;

import application.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

    @Query("select c.name, count(p), avg(p.price), sum(p.price) from Category c inner join c.products p " +
            "group by c " +
            "order by count(p) desc")
    Set<Object[]> categoriesByProductsCount();
}
