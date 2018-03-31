package application.console;

import application.enums.AgeRestriction;
import application.enums.EditionType;
import application.models.Author;
import application.models.Book;
import application.models.Category;
import application.services.author.AuthorServiceImpl;
import application.services.book.BookServiceImpl;
import application.services.category.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@SpringBootApplication
@Component
public class ConsoleRunner implements CommandLineRunner{
    private String folder = "C:\\Users\\User\\IdeaProjects\\Bookshop_System\\src\\main\\resources\\";
    private final String BOOK_PATH = folder + "books.txt";
    private final String AUTHOR_PATH = folder + "authors.txt";
    private final String CATEGORY_PATH = folder + "categories.txt";

    private AuthorServiceImpl authorService;
    private BookServiceImpl bookService;
    private CategoryServiceImpl categoryService;

    @Autowired
    public ConsoleRunner(AuthorServiceImpl authorService, BookServiceImpl bookService, CategoryServiceImpl categoryService) {
        this.authorService = authorService;
        this.bookService = bookService;
        this.categoryService = categoryService;
    }

    @Override
    public void run(String... strings) throws Exception {
        seedDatabase();
        exercise3();
    }

    private void exercise3() {
        //1 FirstQuery
        this.bookService.findBookAfter2000().forEach(System.out::println);

        //2 SecondQuery
        this.authorService.findAllAuthorsWithAtLeastOneBookAfter1990()
                .forEach(a -> System.out.printf("%s %s%n", a.getFirstName(), a.getLastName()));

        //3 ThirdQuery
        this.authorService.findAll()
                .stream()
                .sorted(Comparator.comparing((Author x) -> x.getBooks().size()).reversed())
                .forEach(x -> System.out.printf("%s %s %d%n", x.getFirstName(), x.getLastName(), x.getBooks().size()));

        //4 FourthQuery
        this.bookService.findAllBooksByGeorgePowell()
                .stream()
                .sorted(Comparator.comparing(Book::getReleaseDate).reversed()
                .thenComparing(Book::getTitle))
                .forEach(x -> System.out.printf("%s %s %d%n", x.getTitle(), x.getReleaseDate(), x.getCopies()));
    }

    private void seedDatabase() throws IOException, ParseException {
        List<Author> authors = persistAuthorsFromFile();
        Set<Category> categories = persistCategories();
        readBooks(categories, authors);
    }

    private void readBooks(Set<Category> categories, List<Author> authors) throws IOException, ParseException {
        BufferedReader booksReader = new BufferedReader(new FileReader(BOOK_PATH));
        String line = booksReader.readLine();
        Random random = new Random();

        while ((line = booksReader.readLine()) != null) {
            String[] data = line.split("\\s+");

            int authorIndex = random.nextInt(authors.size());
            Author author = authors.get(authorIndex);
            EditionType editionType = EditionType.values()[Integer.parseInt(data[0])];
            SimpleDateFormat formatter = new SimpleDateFormat("d/M/yyyy");
            Date releaseDate = formatter.parse(data[1]);
            int copies = Integer.parseInt(data[2]);
            BigDecimal price = new BigDecimal(data[3]);
            AgeRestriction ageRestriction = AgeRestriction.values()[Integer.parseInt(data[4])];
            StringBuilder titleBuilder = new StringBuilder();
            for (int i = 5; i < data.length; i++) {
                titleBuilder.append(data[i]).append(" ");
            }
            titleBuilder.delete(titleBuilder.lastIndexOf(" "), titleBuilder.lastIndexOf(" "));
            String title = titleBuilder.toString();

            Book book = new Book();
            book.setAuthor(author);
            book.setEditionType(editionType);
            book.setReleaseDate(releaseDate);
            book.setCopies(copies);
            book.setPrice(price);
            book.setAgeRestriction(ageRestriction);
            book.setTitle(title);
            book.setCategories(categories);

            this.bookService.save(book);
        }
    }

    private Set<Category> persistCategories() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(CATEGORY_PATH));
        Set<Category> categories = new HashSet<Category>();
        String line = reader.readLine();

        while (true) {
            if (line == null) {
                break;
            }
            if (line.equals("")) {
                line = reader.readLine();
            }

            Category category = new Category();
            category.setName(line);
            this.categoryService.save(category);
            categories.add(category);

            line = reader.readLine();
        }

        return categories;
    }

    private List<Author> persistAuthorsFromFile() throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader(AUTHOR_PATH));
        String line = reader.readLine();
        List<Author> authors = new ArrayList<Author>();

        while (true) {
            if (line == null) {
                break;
            }

            String[] data = line.split("\\s+");
            String firstName = data[0];
            String secondName = data[1];

            Author author = new Author();
            author.setFirstName(firstName);
            author.setLastName(secondName);
            this.authorService.save(author);
            authors.add(author);

            line = reader.readLine();
        }
        return authors;
    }
}
