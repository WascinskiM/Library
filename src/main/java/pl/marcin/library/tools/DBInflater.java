package pl.marcin.library.tools;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import pl.marcin.library.model.*;
import pl.marcin.library.repositories.*;

@Component
public class DBInflater implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PrintHouseRepository printHouseRepository;
    private OrderRepository orderRepository;
    private PersonRepository personRepository;
    @Autowired
    public DBInflater(AuthorRepository authorRepository, BookRepository bookRepository, PrintHouseRepository printHouseRepository, OrderRepository orderRepository, PersonRepository personRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.printHouseRepository = printHouseRepository;
        this.orderRepository = orderRepository;
        this.personRepository = personRepository;
    }







    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();


    }

    void initData() {

        PrintHouse superstar = new PrintHouse("superstar");
        PrintHouse superstar1 = new PrintHouse("superstar1");
        Author marcin1 = new Author("Marcin", "Wascinski");
        Author marcin2 = new Author("Marcin", "Metelski");
        Author marcin3 = new Author("Wiktor", "Wascinski");

        Person person1 = new Person("Marcin", "Wascinski", "98100456944");
        Person person2 = new Person("Marcin", "Metelski", "823764352343");
        Person person3 = new Person("Wiktor", "Wascinski","87954623478");

        Book book1 = new Book("QuoVadis1", "1995", superstar, marcin1);
        Book book2 = new Book("QuoVadis2", "1995", superstar1, marcin2);
        Book book3 = new Book("QuoVadis3", "1995", superstar, marcin2);
        Book book4 = new Book("QuoVadis4", "1995", superstar1, marcin1);

        Order order1 = new Order(person1, book1,"2018-03-30");
        Order order2 = new Order(person2, book2, "2018-03-28");
        Order order3 = new Order(person3, book3,"20 18-04-24");


        book1.getAuthors().add(marcin2);

        personRepository.save(person1);
        personRepository.save(person2);
        personRepository.save(person3);


        authorRepository.save(marcin1);
        authorRepository.save(marcin2);
        authorRepository.save(marcin3);

        printHouseRepository.save(superstar);
        printHouseRepository.save(superstar1);

        bookRepository.save(book1);
        bookRepository.save(book2);
        bookRepository.save(book3);
        bookRepository.save(book4);

        superstar.getBooks().add(book1);
        superstar.getBooks().add(book2);
        superstar1.getBooks().add(book3);
        superstar1.getBooks().add(book4);

        printHouseRepository.save(superstar);
        printHouseRepository.save(superstar1);

        marcin1.getBooks().add(book1);
        marcin1.getBooks().add(book4);
        marcin2.getBooks().add(book2);
        marcin2.getBooks().add(book3);

        authorRepository.save(marcin1);
        authorRepository.save(marcin2);

        order1.getBooks().add(book1);
        order2.getBooks().add(book2);
        order1.getBooks().add(book2);

        orderRepository.save(order1);
        orderRepository.save(order2);
        orderRepository.save(order3);



    }

}
