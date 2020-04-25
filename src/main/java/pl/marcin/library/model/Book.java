package pl.marcin.library.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String Title;
    private String Year;
    @ManyToOne
    private PrintHouse PrintedBy;

    @ManyToMany
    private Set<Author> authors = new HashSet<>();

    public Book(String title, String year, PrintHouse printedBy, Author author) {
        Title = title;
        Year = year;
        PrintedBy = printedBy;
        authors.add(author);
    }


    public Book() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getYear() {
        return Year;
    }

    public void setYear(String year) {
        Year = year;
    }

    public PrintHouse getPrintedBy() {
        return PrintedBy;
    }

    public void setPrintedBy(PrintHouse printedBy) {
        PrintedBy = printedBy;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    @Override
    public String toString() {
        return "Books{" +
                "id=" + id +
                ", Title='" + Title + '\'' +
                ", Year='" + Year + '\'' +
                ", PrintedBy=" + PrintedBy +
                ", authors=" + authors +
                '}';
    }
}
