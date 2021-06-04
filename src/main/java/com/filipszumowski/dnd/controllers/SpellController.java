package com.filipszumowski.dnd.controllers;

import com.filipszumowski.dnd.model.Spell;
import com.filipszumowski.dnd.service.SpellService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
    public String saveSpell(@ModelAttribute("spellSave") Spell spell) {
        spellService.saveSpell(spell);
        return "redirect:/elements/spell/allspell";
    }

    @RequestMapping(value = "/editSpell/{spellId}")
    public ModelAndView showEditSpellForm(@PathVariable(name="spellId") Integer spellId){
        ModelAndView modelAndView = new ModelAndView("/elements/spell/edit_spell");
        Spell spell = spellService.getSpell(spellId);
        modelAndView.addObject("spell", spell);
        return modelAndView;
    }
    @RequestMapping(value = "/deleteSpell/{spellId}")
    public String deleteSpell (@PathVariable(name="spellId") Integer spellId){
        spellService.deleteSpell(spellId);
        return "redirect:/elements/spell/allspell";
    }
}
