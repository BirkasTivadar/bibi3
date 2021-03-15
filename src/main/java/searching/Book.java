package searching;

import java.util.Objects;

public class Book implements Comparable<Book> {
    private int id;
    private String author;
    private String title;

    public Book(String author, String title) {
        this.author = author;
        this.title = title;
    }

    public Book(int id, String author, String title) {
        this.id = id;
        this.author = author;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(author, book.author) && Objects.equals(title, book.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, title);
    }

    @Override
    public int compareTo(Book o) {
        if (author.equals(o.author)) {
            return title.compareTo(o.title);
        }
        return author.compareTo(o.author);
    }

    @Override
    public String toString() {
        return id + " " + author + " " + title;
    }
}
