
package com.filipszumowski.dnd.controllers;

import com.filipszumowski.dnd.model.Characterclass;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {

 /*   private static final String MAIN_PAGE = "main";
    private static final String JSON_CHARACTER_CLASS_URL = "https://www.dnd5eapi.co/api/classes/warlock";

    @Autowired
    private ParsingService parsingService;

    @GetMapping
    public String main(final Model model){

        List<Characterclass> characterClass = (List<Characterclass>) parsingService.parse(JSON_CHARACTER_CLASS_URL);
        model.addAttribute("characterclass", characterClass.get(1));
        return MAIN_PAGE;
    }*/
}

