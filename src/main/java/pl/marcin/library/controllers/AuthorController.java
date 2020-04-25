package pl.marcin.library.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.marcin.library.repositories.AuthorRepository;

@Controller
public class AuthorController {

    AuthorRepository authorRepository;
    @Autowired
    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }
    @RequestMapping("/authors")
    public String getAuthor(Model model){
        model.addAttribute("authors", authorRepository.findAll());

        return  "all";
    }
}
