package pl.marcin.library.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@Entity
public class PrintHouse {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @OneToMany
   private Set<Book> books = new HashSet<>();

    public PrintHouse(String name) {
        this.name = name;
    }

    public PrintHouse() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "PrintHouse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", books=" + books +
                '}';
    }
}
