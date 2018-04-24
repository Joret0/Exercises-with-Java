package application.services.book;

import application.enums.AgeRestriction;
import application.enums.EditionType;
import application.models.Book;
import application.models.ReduceBook;
import application.services.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface BookService<Book, Long> extends Service<Book, Long>{
    List<String> findBookAfter2000();
    List<Book> findAllBooksByGeorgePowell();
    List<Book> findByAgeRestriction(AgeRestriction ageRestriction);
    List<Book> findByEditionTypeAndCopiesLessThan(EditionType editionType, int copies);
    List<Book> findBookByPriceLessThan5AndPriceGreaterThan40();
    List<Book> findByPriceLessThanOrPriceGreaterThan(BigDecimal less, BigDecimal greater);
    List<Book> findByReleaseDateIsNot(Date date);
    List<Book> findByReleaseDateBefore(Date date);
    List<Book> findByTitleContains(String letters);
    List<Book> findAllBooksByAuthorLastNameStartsWith(String str);
    Integer countBooks(Long number);
    Book findBookByTitle(String title);
    ReduceBook findAllBooksByTitle(String title);
    void increaseBookCopies(int copies, Date date);
    Long countAllByReleaseDateAfter(Date date);
    void removeBooksWithLowerCopies(int copies);
    List<Book> findByCopiesLessThan(int copies);
}
