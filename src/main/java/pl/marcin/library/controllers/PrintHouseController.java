package pl.marcin.library.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.marcin.library.model.PrintHouse;
import pl.marcin.library.repositories.PrintHouseRepository;

@Controller
public class PrintHouseController {

    PrintHouseRepository printHouseRepository;
@Autowired
    public PrintHouseController(PrintHouseRepository printHouseRepository) {
        this.printHouseRepository = printHouseRepository;
    }
    @RequestMapping("/printHouse")
    public String getPrintHouse(Model model){

    model.addAttribute("PrintHouse", printHouseRepository.findAll());


    return "printHouse";
    }

}
