package pl.marcin.library.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.marcin.library.repositories.AuthorRepository;
import pl.marcin.library.repositories.BookRepository;
import pl.marcin.library.repositories.PrintHouseRepository;


@Controller
@RequestMapping("/library")
public class LibraryController {
    BookRepository bookRepository;
    PrintHouseRepository printHouseRepository;
    AuthorRepository authorRepository;

    @Autowired
    public LibraryController(BookRepository bookRepository, PrintHouseRepository printHouseRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.printHouseRepository = printHouseRepository;
        this.authorRepository = authorRepository;
    }


    @RequestMapping("/books")
    public String getBooks(Model model) {
        model.addAttribute("books", bookRepository.findAll());
        return "all";
    }

    @RequestMapping("/authors")
    public String getAuthors(Model model) {
        model.addAttribute("authors", authorRepository.findAll());
        return "all";
    }

    @RequestMapping("/print")
    public String getPrintHouse(Model model) {
        model.addAttribute("printHouse", printHouseRepository.findAll());
        return "all";
    }

}
