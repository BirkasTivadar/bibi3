package collectionscomp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

class OrderedLibraryTest {
    private OrderedLibrary library;


    @BeforeEach
    void setUp() {
        List<Book> bookList = new LinkedList<>(Arrays.asList(new Book(1245, "Őrület", "Utasy Kristóf"),
                new Book(2454, "Álom", "Ómolnár Géza"),
                new Book(5454, "Államhatár", "Ákos János"),
                new Book(5454, "Utitársak", "Ős János")));

        library = new OrderedLibrary(bookList);
    }

    @Test
    void testOrderedByTitle() {
        // Given
        List<Book> orderedBookList = library.orderedByTitle();
        //Then
        assertEquals("Utitársak", orderedBookList.get(0).getTitle());
    }

    @Test
    void testOrderedByAuthor() {
        // Given
        List<Book> orderedBookList = library.orderedByAuthor();
        //Then
        assertEquals("Utasy Kristóf", orderedBookList.get(0).getAuthor());
    }

    @Test
    void testOrderedByTitleLocale() {
        // Given
        List<String> orderedTitleList = library.orderedByTitleLocale(new Locale("hu", "HU"));
        //Then
        assertEquals("Államhatár", orderedTitleList.get(0));
    }

}