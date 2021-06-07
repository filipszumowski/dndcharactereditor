package com.filipszumowski.dnd.controllers;

import com.filipszumowski.dnd.model.Spell;
import com.filipszumowski.dnd.model.Trait;
import com.filipszumowski.dnd.service.TraitService;
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
import java.util.NoSuchElementException;

@Controller
public class TraitController {

    final TraitService traitService;

    public TraitController(TraitService traitService) {
        this.traitService = traitService;
    }

    @RequestMapping("elements/trait/alltrait")
    public String viewAllTraits(Model model) {
        List<Trait> traitList = traitService.listAllTraits();
        model.addAttribute("traitList", traitList);
        return "elements/trait/alltrait";
    }

    @RequestMapping("/elements/trait/new_trait")
    public String showNewTraitForm(Model model) {
        Trait trait = new Trait();
        model.addAttribute("traitSave", trait);
        return "elements/trait/new_trait";
    }

    @RequestMapping(value = "/saveTrait", method = RequestMethod.POST)
    public String saveTrait(@Valid @ModelAttribute("traitSave") Trait trait,
                            BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "elements/trait/new_trait";
        }
        traitService.saveTrait(trait);
        return "redirect:/elements/trait/alltrait";
    }

    /*@RequestMapping(value = "/editTrait/{traitId}")
    public ModelAndView showEditEquipForm(@PathVariable(name = "traitId") Integer traitId) //throws NoSuchElementException
    {
        ModelAndView modelAndView = new ModelAndView("/elements/trait/edit_trait");
        try {
            Trait trait = traitService.getTrait(traitId);
            modelAndView.addObject("trait", trait);
            return modelAndView;
        } catch (NoSuchElementException e) {
            ModelAndView modelAndViewError = new ModelAndView("errors/SQLIntegrity");
            return modelAndViewError;
        }
    }*/
    // dodane
    @RequestMapping(value = "/editTrait", method = RequestMethod.POST)
    public String editTrait(@Valid Trait trait, BindingResult result) {
        if (result.hasErrors()) {
            return "elements/trait/alltrait";
        }
        traitService.saveTrait(trait);
        return "redirect:/elements/trait/alltrait";
    }

    @RequestMapping(value = "/editTrait/{traitId}", method = RequestMethod.GET)
    public String showEditTraitForm(@PathVariable Integer traitId, Model model) {
        model.addAttribute("trait", traitService.getTrait(traitId));
        return "elements/trait/edit_trait";
    }
    // to co powyżej zostało dodane
    @RequestMapping(value = "/deleteTrait/{traitId}")
    public String deleteTrait(@PathVariable(name = "traitId") Integer traitId) {
        try{
            traitService.deleteTrait(traitId);
            return "elements/trait/alltrait";

        }catch (Exception e){
            return "errors/SQLIntegrity";
        }


    }
}
