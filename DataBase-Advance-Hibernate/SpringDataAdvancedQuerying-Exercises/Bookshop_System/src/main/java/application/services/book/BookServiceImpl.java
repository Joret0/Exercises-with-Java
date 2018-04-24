package application.services.book;

import application.enums.AgeRestriction;
import application.enums.EditionType;
import application.models.Book;
import application.models.ReduceBook;
import application.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
@Primary
public class BookServiceImpl implements BookService<Book, Long>{

    private BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<String> findBookAfter2000() {
        return this.bookRepository.findBooksAfter2000();
    }

    @Override
    public List<Book> findAllBooksByGeorgePowell() {
        return this.bookRepository.findAllBooksByGeorgePowell();
    }

    @Override
    public List<Book> findByAgeRestriction(AgeRestriction ageRestriction) {
        return this.bookRepository.findByAgeRestriction(ageRestriction);
    }

    @Override
    public List<Book> findByEditionTypeAndCopiesLessThan(EditionType editionType, int copies) {
        return this.bookRepository.findByEditionTypeAndCopiesLessThan(editionType, copies);
    }

    @Override
    public List<Book> findBookByPriceLessThan5AndPriceGreaterThan40() {
        return this.bookRepository.findBookByPriceLessThan5AndPriceGreaterThan40();
    }

    @Override
    public List<Book> findByPriceLessThanOrPriceGreaterThan(BigDecimal less, BigDecimal greater) {
        return this.bookRepository.findByPriceLessThanOrPriceGreaterThan(less, greater);
    }

    @Override
    public List<Book> findByReleaseDateIsNot(Date date) {
        return this.bookRepository.findByReleaseDateIsNot(date);
    }

    @Override
    public List<Book> findByReleaseDateBefore(Date date) {
        return this.bookRepository.findByReleaseDateBefore(date);
    }

    @Override
    public List<Book> findByTitleContains(String letters) {
        return this.bookRepository.findByTitleContains(letters);
    }

    @Override
    public List<Book> findAllBooksByAuthorLastNameStartsWith(String str) {
        return this.bookRepository.findAllBooksByAuthorLastNameStartsWith(str);
    }

    @Override
    public Integer countBooks(Long number) {
        return this.bookRepository.countBooks(number);
    }

    @Override
    public Book findBookByTitle(String title) {
        return this.bookRepository.findBookByTitle(title);
    }

    @Override
    public ReduceBook findAllBooksByTitle(String title) {
        return this.bookRepository.findAllBooksByTitle(title);
    }

    @Override
    public void increaseBookCopies(int copies, Date date) {
        this.bookRepository.increaseBookCopies(copies, date);
    }

    @Override
    public Long countAllByReleaseDateAfter(Date date) {
        return this.bookRepository.countAllByReleaseDateAfter(date);
    }

    @Override
    public void removeBooksWithLowerCopies(int copies) {
        this.bookRepository.removeBooksWithLowerCopies(copies);
    }

    @Override
    public List<Book> findByCopiesLessThan(int copies) {
        return this.bookRepository.findByCopiesLessThan(copies);
    }

    @Override
    public Book findById(Long id) {
        return this.bookRepository.findOne(id);
    }

    @Override
    public void remove(Book object) {
        this.bookRepository.delete(object);
    }

    @Override
    public List<Book> findAll() {
        return (List<Book>) this.bookRepository.findAll();
    }

    @Override
    public void save(Book object) {
        this.bookRepository.save(object);
    }
}
