package application.services.book;

import application.models.Book;
import application.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

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
