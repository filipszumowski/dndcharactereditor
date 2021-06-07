package com.filipszumowski.dnd.controllers;

import com.filipszumowski.dnd.model.Characterclass;
import com.filipszumowski.dnd.service.CharClassService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.exceptions.TemplateInputException;

import javax.validation.Valid;
import java.awt.print.Book;
import java.util.List;

@Controller
public class CharacterclassController {


    final CharClassService charClassService;

    public CharacterclassController(CharClassService charClassService) {
        this.charClassService = charClassService;
    }

    @RequestMapping("elements/charclasses/allclasses")
    public String viewAllClasses(Model model) {
        List<Characterclass> characterclassList = charClassService.listAllClasses();
        model.addAttribute("charclassList", characterclassList);
        return "elements/charclasses/allclasses";
    }

    @RequestMapping("/elements/charclasses/new_class")
    public String showNewClassForm(Model model) {
        Characterclass characterclass = new Characterclass();
        model.addAttribute("charClass", characterclass);
        return "elements/charclasses/new_class";
    }

    @RequestMapping(value = "/saveClass", method = RequestMethod.POST)
    public String saveClass(@Valid @ModelAttribute("charClass") Characterclass characterclass,
                            BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "elements/charclasses/new_class";
        }

        charClassService.saveClass(characterclass);
        return "redirect:/elements/charclasses/allclasses";
    }

    //zakomentowane
   /* @RequestMapping(value = "/editclass/{classId}")
    public ModelAndView showEditClassForm(@PathVariable(name="classId") Integer classId){
        ModelAndView modelAndView = new ModelAndView("/elements/charclasses/edit_class");
        Characterclass characterclass = charClassService.getClass(classId);
        modelAndView.addObject("charClass", characterclass);
        return modelAndView;
    }*/

    // dodane
    @RequestMapping(value = "/editclass", method = RequestMethod.POST)
    public String editClass(@Valid Characterclass characterclass, BindingResult result) {
        if (result.hasErrors()) {
            return "elements/charclasses/allclasses";
        }
        charClassService.saveClass(characterclass);
        return "redirect:/elements/charclasses/allclasses";
    }

    @RequestMapping(value = "/editclass/{classId}", method = RequestMethod.GET)
    public String showEditForm(@PathVariable Integer classId, Model model) {

            model.addAttribute("charClass", charClassService.getClass(classId));
            return "elements/charclasses/edit_class";

    }

// to co powyżej zostało dodane


    @RequestMapping(value = "/deleteclass/{classId}")
    public String deleteClass(@PathVariable(name = "classId") Integer classId) {
        charClassService.deleteClass(classId);
        return "redirect:/elements/charclasses/allclasses";
    }



}
