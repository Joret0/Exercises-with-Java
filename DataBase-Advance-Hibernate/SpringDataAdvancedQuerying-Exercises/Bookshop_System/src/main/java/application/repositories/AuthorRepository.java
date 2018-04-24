package application.repositories;

import application.models.Author;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long>{
    @Query("select a from Author as a inner join a.books as b where YEAR(b.releaseDate) < 1990")
    List<Author> findAllAuthorsWithAtLeastOneBookAfter1990();
    List<Author> findByFirstNameEndsWith(String letters);

    @Query("select concat(a.firstName, ' ', a.lastName), sum(b.copies) from Author  as a " +
            "inner join a.books as b " +
            "group by a " +
            "order by sum(b.copies) desc")
    List<Object[]> totalBooksCopies();
}
