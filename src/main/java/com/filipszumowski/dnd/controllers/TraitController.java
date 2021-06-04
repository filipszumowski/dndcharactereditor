package com.filipszumowski.dnd.controllers;

import com.filipszumowski.dnd.model.Trait;
import com.filipszumowski.dnd.service.TraitService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

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
    public String saveTrait(@ModelAttribute("traitSave") Trait trait) {
        traitService.saveTrait(trait);
        return "redirect:/elements/trait/alltrait";
    }

    @RequestMapping(value = "/editTrait/{traitId}")
    public ModelAndView showEditEquipForm(@PathVariable(name = "traitId") Integer traitId) {
        ModelAndView modelAndView = new ModelAndView("/elements/trait/edit_trait");
        Trait trait = traitService.getTrait(traitId);
        modelAndView.addObject("trait", trait);
        return modelAndView;
    }

    @RequestMapping(value = "/deleteTrait/{traitId}")
    public String deleteTrait(@PathVariable(name = "traitId") Integer traitId) {
        traitService.deleteTrait(traitId);
        return "redirect:/elements/trait/alltrait";
    }
}
