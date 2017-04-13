import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Pr29BookLibraryModification {
    public static void main(String[] args) throws ParseException {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        LibraryMod libraryMod = new LibraryMod("Ivan Vazov");
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

        for (int i = 0; i < n; i++)
        {
            String[] bookInfo = in.nextLine().split(" ");

            String title = bookInfo[0];
            String author = bookInfo[1];
            String publisher= bookInfo[2];
            Date date = null;

            try {
                date = sdf.parse(bookInfo[3]);
            } catch (ParseException e) {
                System.err.println("Error with date parsing in input.");
            }

            String ISBN = bookInfo[4];
            double price = Double.parseDouble(bookInfo[5]);
            BookMod book = new BookMod(title, author, publisher, date, ISBN, price);

            AddCurrentBookToLibrary(book, libraryMod);
        }

        Date dateAfter = null;

        try {
            dateAfter = sdf.parse(in.nextLine());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        try {
            PrintLibraryMod(libraryMod, dateAfter);
        } catch (ParseException e) {
            System.err.println("Error with date parsing in printing.");
        }
    }

    private static void AddCurrentBookToLibrary(BookMod book, LibraryMod library)
    {
        library.books.add(book);
    }

    private static void PrintLibraryMod(LibraryMod libraryMod, Date dateAfter) throws ParseException {
        List<BookMod> booksList = libraryMod.getBooks();

        Collections.sort(booksList, new Comparator<BookMod>() {
            @Override
            public int compare(BookMod o1, BookMod o2) {
                Date x1 = ((BookMod) o1).getReleaseDate();
                Date x2 = ((BookMod) o2).getReleaseDate();
                int sComp = x1.compareTo(x2);

                if (sComp != 0) {
                    return sComp;
                } else {
                    String y1 = ((BookMod) o2).getTitle();
                    String y2 = ((BookMod) o1).getTitle();
                    return y2.compareTo(y1);
                }
            }
        });

        for (BookMod book : booksList) {
            if (book.releaseDate.after(dateAfter))
            {
                SimpleDateFormat simpledatafo = new SimpleDateFormat("dd.MM.yyyy");
                String expectedDate= simpledatafo.format(book.getReleaseDate());

                System.out.printf("%s -> %s%n", book.getTitle(), expectedDate);
            }
        }
    }
}
class LibraryMod
{
    public String name;
    public List<BookMod> books;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<BookMod> getBooks() {
        return books;
    }

    public void setBooks(List<BookMod> books) {
        this.books = books;
    }

    public LibraryMod(String name)
    {
        this.name = name;
        this.books = new ArrayList<BookMod>();
    }
}

class BookMod
{
    public String title ;
    public String author;
    public String publisher;
    public Date releaseDate;
    public String ISBN ;
    public double price;

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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public BookMod(String title, String author, String publisher, Date releaseDate, String ISBN, double price)
    {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.releaseDate = releaseDate;
        this.ISBN = ISBN;
        this.price = price;

    }
}
