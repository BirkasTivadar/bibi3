package sorting;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class OrderedLibrary {

    private Set<Book> library;

    public OrderedLibrary(Set<Book> library) {
        this.library = new TreeSet<>(library);
    }

    public Book lendFirstBook(){
        return new ArrayList<>(library).get(0);
    }
}
