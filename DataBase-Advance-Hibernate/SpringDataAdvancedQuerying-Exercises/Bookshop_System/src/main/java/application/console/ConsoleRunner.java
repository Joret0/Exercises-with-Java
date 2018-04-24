package application.console;

import application.enums.AgeRestriction;
import application.enums.EditionType;
import application.models.Author;
import application.models.Book;
import application.models.Category;
import application.models.ReduceBook;
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
import java.io.InputStreamReader;
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
        //seedDatabase();
        //exercise3();

        //Exercises: Spring Data Advanced Querying

        //task1BooksTitlesByAgeRestriction();
        //task2GoldenBooks();
        //task3BooksByPrice();
        //task4NotReleasedBooks();
        //task5BooksReleasedBeforeDate();
        //task6AuthorsSearch();
        //task7BooksSearch();
        //task8BookTitlesSearch();
        //task9CountBooks();
        //task10TotalBookCopies();
        //task11ReducedBook();
        //task12IncreaseBookCopies(); Unparseable date
        task13RemoveBooks();
    }

    private void task13RemoveBooks() {
        int copies = 300;
        List<Book> foundBooks = this.bookService.findByCopiesLessThan(copies);
        System.out.println(foundBooks.size());
        this.bookService.removeBooksWithLowerCopies(copies);
    }

    private void task12IncreaseBookCopies() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy");
        Date date = sdf.parse("06 Jun 2013");
        int count = 100;
        this.bookService.increaseBookCopies(count, date);
        System.out.println(this.bookService.countAllByReleaseDateAfter(date) * count);
    }

    private void task11ReducedBook() {
        String title = "Things Fall Apart";
        String title2 = "Things Fall Apart";
        Book book = this.bookService.findBookByTitle(title);
        ReduceBook reduceBook = this.bookService.findAllBooksByTitle(title2);
        System.out.printf("%s %s %s %s%n", book.getTitle(), book.getEditionType(), book.getAgeRestriction(), book.getPrice());
        System.out.printf("%s %s %s %s%n", reduceBook.getTitle(), reduceBook.getEditionType(), reduceBook.getAgeRestriction(), reduceBook.getPrice());
    }

    private void task10TotalBookCopies() {
        List<Object[]> found = this.authorService.totalBooksCopies();
        for (Object[] current : found) {
            System.out.printf("%s %s%n", current[0], current[1]);
        }
    }

    private void task9CountBooks() {
        int number = this.bookService.countBooks(12L);
        System.out.println(number);
    }

    private void task8BookTitlesSearch() {
        List<Book> books = this.bookService.findAllBooksByAuthorLastNameStartsWith("R");
        books.forEach(b -> System.out.printf("%s (%s %s)%n", b.getTitle(), b.getAuthor().getFirstName(), b.getAuthor().getLastName()));
    }

    private void task7BooksSearch() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Book> books = this.bookService.findByTitleContains(reader.readLine());
        books.forEach(b -> System.out.printf("%s%n", b.getTitle()));
    }

    private void task6AuthorsSearch() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Author> authors = this.authorService.findByFirstNameEndsWith(reader.readLine());
        authors.forEach(a -> System.out.printf("%s %s%n", a.getFirstName(), a.getLastName()));
    }

    private void task5BooksReleasedBeforeDate() throws IOException, ParseException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date date = sdf.parse(reader.readLine());
        List<Book> books = this.bookService.findByReleaseDateBefore(date);
        books.forEach(b -> System.out.printf("%s, %s, %.2f%n", b.getTitle(), b.getEditionType(), b.getPrice()));
    }

    private void task4NotReleasedBooks() throws IOException, ParseException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        Date date = sdf.parse(reader.readLine());
        List<Book> books = this.bookService.findByReleaseDateIsNot(date);
        books.forEach(b -> System.out.printf("%s%n", b.getTitle()));
    }

    private void task3BooksByPrice() {
        List<Book> books = this.bookService.findByPriceLessThanOrPriceGreaterThan(BigDecimal.valueOf(5.00), BigDecimal.valueOf(40.00));
        books.forEach(b -> System.out.printf("%s %.2f%n", b.getTitle(), b.getPrice()));
    }

    private void task2GoldenBooks() {
        List<Book> books = this.bookService.findByEditionTypeAndCopiesLessThan(EditionType.Gold, 5000);
        books.forEach(b -> System.out.printf("%s%n", b.getTitle()));
    }

    private void task1BooksTitlesByAgeRestriction() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String ageRestrictionLevel = reader.readLine();
        AgeRestriction ageRestriction = null;
        switch (ageRestrictionLevel.toUpperCase()) {
            case "MINOR":
                ageRestriction = AgeRestriction.Minor;
                break;
            case "TEEN":
                ageRestriction = AgeRestriction.Teen;
                break;
            case "ADULT":
                ageRestriction = AgeRestriction.Adult;
                break;
                default:
                    break;
        }
        List<Book> books = this.bookService.findByAgeRestriction(ageRestriction);
        books.forEach(b -> System.out.printf("%s%n", b.getTitle()));
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
