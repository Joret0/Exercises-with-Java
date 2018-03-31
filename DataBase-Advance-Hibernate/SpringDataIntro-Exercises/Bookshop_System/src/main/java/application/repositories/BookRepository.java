package application.repositories;

import application.models.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<Book, Long>{

    @Query("select b.title from Book b where YEAR(b.releaseDate) > 2000")
    List<String> findBooksAfter2000();

    @Query("select b from Book b where b.author.firstName = 'George' and b.author.lastName = 'Powell'")
    List<Book> findAllBooksByGeorgePowell();
}
