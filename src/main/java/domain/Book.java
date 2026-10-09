package domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Book {
    @Id
    private BookName name;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Author> authors;

    public Book(BookName name, List<Author> authors) {
        this.name = name;
        this.authors = authors;
    }

    protected Book() {}

    public BookName getName() {
        return name;
    }

    public List<Author> getAuthors() {
        return authors;
    }
}
