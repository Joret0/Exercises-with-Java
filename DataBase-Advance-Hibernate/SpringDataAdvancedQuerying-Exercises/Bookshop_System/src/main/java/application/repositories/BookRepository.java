package application.repositories;

import application.enums.AgeRestriction;
import application.enums.EditionType;
import application.models.Book;
import application.models.ReduceBook;
import com.sun.javafx.scene.control.skin.DatePickerSkin;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.Year;
import java.util.Date;
import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<Book, Long>{

    @Query("select b.title from Book b where YEAR(b.releaseDate) > 2000")
    List<String> findBooksAfter2000();
    @Query("select b from Book b where b.author.firstName = 'George' and b.author.lastName = 'Powell'")
    List<Book> findAllBooksByGeorgePowell();
    List<Book> findByAgeRestriction(AgeRestriction ageRestriction);
    List<Book> findByEditionTypeAndCopiesLessThan(EditionType editionType, int copies);
    @Query("select b.title, b.price from Book as b where b.price < 5 or b.price < 40")
    List<Book> findBookByPriceLessThan5AndPriceGreaterThan40();
    List<Book> findByPriceLessThanOrPriceGreaterThan(BigDecimal less, BigDecimal greater);
    List<Book> findByReleaseDateIsNot(Date date);
    List<Book> findByReleaseDateBefore(Date date);
    List<Book> findByTitleContains(String letters);
    List<Book> findAllBooksByAuthorLastNameStartsWith(String str);
    @Query("select count(b) from Book as b where char_length(b.title) > :num")
    Integer countBooks(@Param(value = "num") Long number);
    Book findBookByTitle(String title);
    @Query("select b from Book as b where b.title = :title")
    ReduceBook findAllBooksByTitle(@Param(value = "title") String title);
    @Query("update Book set copies = copies + :param where releaseDate > :date")
    @Modifying
    void increaseBookCopies(@Param(value = "param") int copies, @Param(value = "date") Date date);
    Long countAllByReleaseDateAfter(Date date);
    @Query("delete from Book as b where b.copies < :param")
    @Modifying
    void removeBooksWithLowerCopies(@Param(value = "param") int copies);
    List<Book> findByCopiesLessThan(int copies);

}