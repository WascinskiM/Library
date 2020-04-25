package pl.marcin.library.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.marcin.library.model.Book;
import pl.marcin.library.repositories.BookRepository;
import pl.marcin.library.repositories.OrderRepository;
import pl.marcin.library.repositories.PersonRepository;

@Controller
@RequestMapping("orderList")
public class OrderController {
    private OrderRepository orderRepository;
    private PersonRepository personRepository;
    private BookRepository bookRepository;

    @Autowired
    public OrderController(OrderRepository orderRepository, PersonRepository personRepository, BookRepository bookRepository) {
        this.orderRepository = orderRepository;
        this.personRepository = personRepository;
        this.bookRepository = bookRepository;
    }
    @RequestMapping("/orders")
    public String getOrder(Model model){
        model.addAttribute("orders", orderRepository.findAll());
      return "all";
    };
    @RequestMapping("/books")
    public String getBooks(Model model){
        model.addAttribute("books", bookRepository.findAll());
        return "all";
    };

    @RequestMapping("/persons")
    public String getPersons(Model model){
        model.addAttribute("persons", personRepository.findAll());
        return "all";
    };


}
