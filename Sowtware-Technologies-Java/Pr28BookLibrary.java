import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Pr28BookLibrary {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        Library library = new Library("Ivan Vazov");
        for (int i = 0; i < n; i++) {
            String[] bookInfo = reader.readLine().split("\\s+");
            String title = bookInfo[0];
            String author = bookInfo[1];
            String publisher = bookInfo[2];
            String ISBN = bookInfo[4];
            Double price = Double.parseDouble(bookInfo[5]);
            Book book = new Book(title, author, publisher, new Date(), ISBN, price);
            AddCurrentBookToLibrary(book, library);
        }
        PrintLibrary(library);
    }

    private static void PrintLibrary(Library library) {
        List<Book> bookList = library.getBooks();

        Collections.sort(bookList, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                Double x1 = ((Book) o1).getPrice();
                Double x2 = ((Book) o2).getPrice();
                int comp = x2.compareTo(x1);

                if (comp != 0) {
                    return comp;
                } else {
                    String y1 = ((Book) o2).getAuthor();
                    String y2 = ((Book) o1).getAuthor();
                    return y2.compareTo(y1);
                }
            }
        });
        for (Book book : bookList) {
            System.out.printf("%s -> %.2f%n", book.getAuthor(), book.getPrice());
        }
    }

    private static void AddCurrentBookToLibrary(Book book, Library library) {
        boolean exists = false;
        for (int i = 0; i < library.getBooks().size(); i++) {
            if (library.getBooks().get(i).getAuthor().equals(book.getAuthor())) {
                library.getBooks().get(i).setPrice(library.getBooks().get(i).getPrice() + book.getPrice());
                exists = true;
            }
        }
        if (!exists) {
            library.getBooks().add(book);
        }
    }
}
class Library {
    private String name;
    private List<Book> books;

    public Library(String name) {
        this.name = name;
        this.books = new ArrayList<Book>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
class Book {
    private String title;
    private String author;
    private String publisher;
    private Date releaseDate;
    private String ISBN;
    private Double price;

    public Book(String title, String author, String publisher, Date releaseDate, String ISBN, Double price) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.releaseDate = releaseDate;
        this.ISBN = ISBN;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}