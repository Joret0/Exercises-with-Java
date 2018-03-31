package application.services.book;

import application.models.Book;
import application.services.Service;

import java.util.List;

public interface BookService<Book, Long> extends Service<Book, Long>{
    List<String> findBookAfter2000();
    List<Book> findAllBooksByGeorgePowell();
}
