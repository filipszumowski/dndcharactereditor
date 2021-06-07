package com.filipszumowski.dnd.controllers;

import com.filipszumowski.dnd.model.Race;
import com.filipszumowski.dnd.model.Spell;
import com.filipszumowski.dnd.service.SpellService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.awt.print.Book;
import java.util.List;

@Controller
public class SpellController {
    final SpellService spellService;

    public SpellController(SpellService spellService) {
        this.spellService = spellService;
    }

    @RequestMapping("elements/spell/allspell")
    public String viewAllSpells(Model model) {
        List<Spell> spellList = spellService.listAllSpells();
        model.addAttribute("spellList", spellList);
        return "elements/spell/allspell";
    }

    @RequestMapping("/elements/spell/new_spell")
    public String showNewSpellForm(Model model) {
        Spell spell = new Spell();
        model.addAttribute("spellSave", spell);
        return "elements/spell/new_spell";
    }

    @RequestMapping(value = "/saveSpell", method = RequestMethod.POST)
    public String saveSpell(@Valid @ModelAttribute("spellSave") Spell spell,
                            BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "elements/spell/new_spell";
        }

        spellService.saveSpell(spell);
        return "redirect:/elements/spell/allspell";
    }

    /*@RequestMapping(value = "/editSpell/{spellId}", method = RequestMethod.POST)
    public ModelAndView showEditSpellForm(@PathVariable(name="spellId") Integer spellId){
        ModelAndView modelAndView = new ModelAndView("/elements/spell/edit_spell");
        Spell spell = spellService.getSpell(spellId);
        modelAndView.addObject("spell", spell);
        return modelAndView;
    }*/

    // dodane
    @RequestMapping(value = "/editSpell", method = RequestMethod.POST)
    public String editSpell(@Valid Spell spell, BindingResult result) {
        if (result.hasErrors()) {
            return "elements/spell/allspell";
        }
        spellService.saveSpell(spell);
        return "redirect:/elements/spell/allspell";
    }

    @RequestMapping(value = "/editSpell/{spellId}", method = RequestMethod.GET)
    public String showEditSpellForm(@PathVariable Integer spellId, Model model) {
        model.addAttribute("spell", spellService.getSpell(spellId));
        return "elements/spell/edit_spell";
    }
    // to co powyżej zostało dodane

    @RequestMapping(value = "/deleteSpell/{spellId}")
    public String deleteSpell (@PathVariable(name="spellId") Integer spellId){
        try{spellService.deleteSpell(spellId);
            return "elements/spell/allspell";

        }catch (Exception e){
            return "errors/SQLIntegrity";
        }

    }
}
