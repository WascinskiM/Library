package pl.marcin.library.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@Table(name="Lend")
@Entity
public class Order {
    private String lendData;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne
    private Person person;
    @ManyToMany
    private Set<Book> books = new HashSet<>();


    public Order(Person person, Book book, String lendData) {
        this.lendData= lendData;
        this.person = person;
        books.add(book);
    }

    public Order() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public String getLendData() {
        return lendData;
    }

    public void setLendData(String lendData) {
        this.lendData = lendData;
    }
}
