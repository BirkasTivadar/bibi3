package collectionsiterator;

import java.util.*;

public class LibraryManager {

    private Set<Book> libraryBooks;

    public LibraryManager(Set<Book> libraryBooks) {
        this.libraryBooks = libraryBooks;
    }

    public Book findBookByRegNumber(int regNumber) {
        for (Iterator<Book> b = libraryBooks.iterator(); b.hasNext(); ) {
            Book book = b.next();
            if (book.getRegNumber() == regNumber) {
                return book;
            }
        }
        throw new MissingBookException(String.format("No books found with regnumber: %d", regNumber));
    }

    public int removeBookByRegNumber(int regNumber) {
        for (Iterator<Book> b = libraryBooks.iterator(); b.hasNext(); ) {
            Book book = b.next();
            if (book.getRegNumber() == regNumber) {
                b.remove();
                return regNumber;
            }
        }
        throw new MissingBookException(String.format("No books found with regnumber: %d", regNumber));
    }

    public Set<Book> selectBooksByAuthor(String author) {
        Set<Book> result = new HashSet<>();
        for (Iterator<Book> b = libraryBooks.iterator(); b.hasNext(); ) {
            Book book = b.next();
            if (book.getAuthor().equals(author)) {
                result.add(book);
            }
        }
        if (result.isEmpty()) {
            throw new MissingBookException(String.format("No books found by %s", author));
        }
        return result;
    }

    public int libraryBooksCount() {
        return libraryBooks.size();
    }

}
