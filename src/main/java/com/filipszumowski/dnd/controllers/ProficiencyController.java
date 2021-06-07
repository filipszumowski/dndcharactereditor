package com.filipszumowski.dnd.controllers;


import com.filipszumowski.dnd.model.Equipment;
import com.filipszumowski.dnd.model.Proficiency;

import com.filipszumowski.dnd.service.ProficiencyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ProficiencyController {
    final ProficiencyService proficiencyService;

    public ProficiencyController(ProficiencyService proficiencyService) {
        this.proficiencyService = proficiencyService;
    }

    @RequestMapping("/elements/proficiency/allprof")
    public String viewAllProfs(Model model) {
        List<Proficiency> proficiencyList = proficiencyService.listAllProfs();
        model.addAttribute("proficiencyList", proficiencyList);
        return "elements/proficiency/allprof";
    }

    @RequestMapping("/elements/proficiency/new_prof")
    public String showNewProfForm(Model model) {
        Proficiency proficiency = new Proficiency();
        model.addAttribute("proficiencySave", proficiency);
        return "elements/proficiency/new_prof";
    }

    @RequestMapping(value = "/saveProf", method = RequestMethod.POST)
    public String saveProf(@Valid @ModelAttribute("proficiencySave") Proficiency proficiency,
                           BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "elements/proficiency/new_prof";
        }
        proficiencyService.saveProf(proficiency);
        return "redirect:/elements/proficiency/allprof";
    }

   /* @RequestMapping(value = "/editProf/{profId}")
    public ModelAndView showEditProfForm(@PathVariable(name="profId") Integer profId){
        ModelAndView modelAndView = new ModelAndView("/elements/proficiency/edit_prof");
        Proficiency proficiency = proficiencyService.getProf(profId);
        modelAndView.addObject("proficiency", proficiency);
        return modelAndView;
    }*/

    // dodane
    @RequestMapping(value = "/editProf", method = RequestMethod.POST)
    public String editProf(@Valid Proficiency proficiency, BindingResult result) {
        if (result.hasErrors()) {
            return "elements/proficiency/allprof";
        }
        proficiencyService.saveProf(proficiency);
        return "redirect:/elements/proficiency/allprof";
    }

    @RequestMapping(value = "/editProf/{profId}", method = RequestMethod.GET)
    public String showEditProfForm(@PathVariable Integer profId, Model model) {
        model.addAttribute("proficiency", proficiencyService.getProf(profId));
        return "elements/proficiency/edit_prof";
    }
    // to co powyżej zostało dodane
    @RequestMapping(value = "/deleteProf/{profId}")
    public String deleteProf (@PathVariable(name="profId") Integer profId){
        try{proficiencyService.deleteProf(profId);
            return "redirect:/elements/proficiency/allprof";

        }catch (Exception e){
            return "errors/SQLIntegrity";
        }

    }
}
