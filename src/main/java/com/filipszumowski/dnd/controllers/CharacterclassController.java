package com.filipszumowski.dnd.controllers;

import com.filipszumowski.dnd.model.Characterclass;
import com.filipszumowski.dnd.service.CharClassService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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
    public String saveClass(@ModelAttribute("charClass") Characterclass characterclass) {
        charClassService.saveClass(characterclass);
        return "redirect:/elements/charclasses/allclasses";
    }

    @RequestMapping(value = "/editclass/{classId}")
    public ModelAndView showEditClassForm(@PathVariable(name="classId") Integer classId){
        ModelAndView modelAndView = new ModelAndView("/elements/charclasses/edit_class");
        Characterclass characterclass = charClassService.getClass(classId);
        modelAndView.addObject("charClass", characterclass);
        return modelAndView;
    }
    @RequestMapping(value = "/deleteclass/{classId}")
    public String deleteClass (@PathVariable(name="classId") Integer classId){
        charClassService.deleteClass(classId);
        return "redirect:/elements/charclasses/allclasses";
    }


}
