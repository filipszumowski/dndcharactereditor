package com.filipszumowski.dnd.controllers;

import com.filipszumowski.dnd.model.CharacterCreate;
import com.filipszumowski.dnd.forms.*;
import com.filipszumowski.dnd.model.*;
import com.filipszumowski.dnd.repository.*;
import com.filipszumowski.dnd.service.CharClassService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;


//@RequestMapping("/character")
@Controller

public class CharacterCreateController {

    final CharacterCreateRepository characterCreateRepository;

    final CharacterclassRepository characterclassRepository;

    final EquipmentRepository equipmentRepository;

    final ProficiencyRepository proficiencyRepository;

    final RaceRepository raceRepository;

    final SpellsRepository spellsRepository;

    final TraitRepository traitRepository;

    final CharClassService charClassService;

    public CharacterCreateController(CharacterCreateRepository characterCreateRepository,
                                     CharacterclassRepository characterclassRepository,
                                     EquipmentRepository equipmentRepository,
                                     ProficiencyRepository proficiencyRepository,
                                     RaceRepository raceRepository,
                                     SpellsRepository spellsRepository,
                                     TraitRepository traitRepository,
                                     CharClassService charClassService) {
        this.characterCreateRepository = characterCreateRepository;
        this.characterclassRepository = characterclassRepository;
        this.equipmentRepository = equipmentRepository;
        this.proficiencyRepository = proficiencyRepository;
        this.raceRepository = raceRepository;
        this.spellsRepository = spellsRepository;
        this.traitRepository = traitRepository;
        this.charClassService = charClassService;
    }

    //zmiana z Get na Post
    @GetMapping("/character/new")
    public String showNewCharacterForm(Model model) {
        List<Race> listRace = raceRepository.findAll();
        List<Characterclass> listClass = characterclassRepository.findAll();
        List<Spell> listSpell = spellsRepository.findAll();
        List<Proficiency> listProf = proficiencyRepository.findAll();
        List<Equipment> listEquip = equipmentRepository.findAll();
        List<Trait> listTrait = traitRepository.findAll();
        model.addAttribute("characterCreate", new CharacterCreate());
        model.addAttribute("listRace", listRace);
        model.addAttribute("listClass", listClass);
        model.addAttribute("listSpell", listSpell);
        model.addAttribute("listProf", listProf);
        model.addAttribute("listEquip", listEquip);
        model.addAttribute("listTrait", listTrait);
        return "character/characterCreateForm";
    }

    //dodane repozytoria, wczesiej nie było żadnego
    @PostMapping("/character/save")
    public String saveCharacter(@Valid @ModelAttribute("characterCreate")
                                            CharacterCreate characterCreate,
                                BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            List<Race> listRace = raceRepository.findAll();
            List<Characterclass> listClass = characterclassRepository.findAll();
            List<Spell> listSpell = spellsRepository.findAll();
            List<Proficiency> listProf = proficiencyRepository.findAll();
            List<Equipment> listEquip = equipmentRepository.findAll();
            List<Trait> listTrait = traitRepository.findAll();
            model.addAttribute("listRace", listRace);
            model.addAttribute("listClass", listClass);
            model.addAttribute("listSpell", listSpell);
            model.addAttribute("listProf", listProf);
            model.addAttribute("listEquip", listEquip);
            model.addAttribute("listTrait", listTrait);
            return "character/characterCreateForm";
//"character/new";
        }

        characterCreateRepository.save(characterCreate);
        return "redirect:/character/characters-view";
    }

    @GetMapping("/character/characters-view")
    public String viewAllCharacters(Model model) {
        List<CharacterCreate> characterCreateList = characterCreateRepository.findAll();
        /*Set<String> characterclassSet = charClassService.getClassName(characterId);
model.addAttribute("characterclassSet", characterclassSet);*/
        model.addAttribute("characterCreateList", characterCreateList);
        return "character/characters-view";
    }

    @GetMapping("character/edit/{characterId}")
    public String showEditCharForm(@PathVariable("characterId") Integer characterId, Model model) {
        CharacterCreate characterCreate = characterCreateRepository.findById(characterId).get();
        model.addAttribute("characterCreate", characterCreate);
        List<Race> listRace = raceRepository.findAll();
        model.addAttribute("listRace", listRace);
        List<Characterclass> listClass = characterclassRepository.findAll();
        model.addAttribute("listClass", listClass);
        List<Spell> listSpell = spellsRepository.findAll();
        List<Proficiency> listProf = proficiencyRepository.findAll();
        List<Equipment> listEquip = equipmentRepository.findAll();
        List<Trait> listTrait = traitRepository.findAll();
        model.addAttribute("listSpell", listSpell);
        model.addAttribute("listProf", listProf);
        model.addAttribute("listEquip", listEquip);
        model.addAttribute("listTrait", listTrait);
        return "character/characterCreateForm";
    }

    @GetMapping("character/delete/{characterId}")
    public String showDeleteCharForm(@PathVariable("characterId") Integer characterId) {
        characterCreateRepository.deleteById(characterId);
        return "redirect:/character/characters-view";
    }

}









