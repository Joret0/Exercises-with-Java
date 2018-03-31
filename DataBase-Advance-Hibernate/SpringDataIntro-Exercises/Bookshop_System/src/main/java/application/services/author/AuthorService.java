package application.services.author;

import application.models.Author;
import application.services.Service;

import java.util.List;

public interface AuthorService<Author, Long> extends Service<Author, Long>{

    List<Author> findAllAuthorsWithAtLeastOneBookAfter1990();
}
