package domain;

import jakarta.persistence.*;

import java.util.Map;

@Entity
public class Library {
    @Id
    private LibraryName name;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @MapKey(name = "name")
    private Map<BookName, Book> books;

    public Library(LibraryName name, Map<BookName, Book> books) {
        this.name = name;
        this.books = books;
    }

    protected Library() {}

    public LibraryName getName() {
        return name;
    }

    public Map<BookName, Book> getBooks() {
        return books;
    }
}
