package com.filipszumowski.dnd.controllers;

import com.filipszumowski.dnd.model.Characterclass;
import com.filipszumowski.dnd.repository.CharacterclassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CharacterclassController {


    @Autowired
    CharacterclassRepository characterclassRepository;

    @GetMapping("/elements/allclasses")
    public String showClasses(Model model){
        List<Characterclass> characterclassList =
                characterclassRepository.findAll();
        model.addAttribute("characterclassList", characterclassList);

        return "elements/allclasses";
    }
}
