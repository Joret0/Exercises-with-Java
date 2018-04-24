package application.services.author;

import application.models.Author;
import application.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class AuthorServiceImpl implements AuthorService<Author, Long>{
    private AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> findAllAuthorsWithAtLeastOneBookAfter1990() {
        return this.authorRepository.findAllAuthorsWithAtLeastOneBookAfter1990();
    }

    @Override
    public List<Author> findByFirstNameEndsWith(String letters) {
        return this.authorRepository.findByFirstNameEndsWith(letters);
    }

    @Override
    public List<Object[]> totalBooksCopies() {
        return this.authorRepository.totalBooksCopies();
    }

    @Override
    public Author findById(Long id) {
        return this.authorRepository.findOne(id);
    }

    @Override
    public void remove(Author object) {
        this.authorRepository.delete(object);
    }

    @Override
    public List<Author> findAll() {
        return (List<Author>) this.authorRepository.findAll();
    }

    @Override
    public void save(Author object) {
        this.authorRepository.save(object);
    }
}
