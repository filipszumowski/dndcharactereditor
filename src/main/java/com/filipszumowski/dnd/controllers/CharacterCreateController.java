package com.filipszumowski.dnd.controllers;

import com.filipszumowski.dnd.creator.CharacterCreate;
import com.filipszumowski.dnd.forms.*;
import com.filipszumowski.dnd.model.*;
import com.filipszumowski.dnd.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.validation.Valid;
import java.util.Optional;

@RequiredArgsConstructor
@RequestMapping("/character")
@Controller
@RestController
@EnableWebMvc
public class CharacterCreateController {

    @Autowired
    CharacterCreateRepository characterCreateRepository;
    @Autowired
    CharacterclassRepository characterclassRepository;
    @Autowired
    EquipmentRepository equipmentRepository;
    @Autowired
    ProficiencyRepository proficiencyRepository;
    @Autowired
    RaceRepository raceRepository;
    @Autowired
    SpellsRepository spellsRepository;
    @Autowired
    TraitRepository traitRepository;

    /*@RequestMapping("")
    public String allClasses(Model model) {
        model.addAttribute("title", "Classes");
        model.addAttribute("class", characterclassRepository.findAll());
        return "createcharacter/allclasses";
    }*/

////////////// Create character GET & Post
    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String create(Model model) {
        model.addAttribute("title", "Create Character");
        model.addAttribute(new CharacterCreate());
        return "character/create";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String create(Model model, @ModelAttribute @Valid CharacterCreate charactercreate, Errors errors) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Create Character");
            return "character/create";
        }
        characterCreateRepository.save(charactercreate);

        return "redirect:character-view" + charactercreate.getCharacterId();
    }

///////////////////// Create character GET & Post
//
    @RequestMapping(value = "character/mainview/${characterId}", method = RequestMethod.GET)
    public String viewCharacter(Model model, @PathVariable Integer characterId) {
        CharacterCreate characterCreate = characterCreateRepository.findById(characterId).get();
        model.addAttribute("title", characterCreate.getName());
        model.addAttribute("class", characterCreate.getCharacterClass());
        model.addAttribute("race", characterCreate.getRace());
        model.addAttribute("spells", characterCreate.getSpells());
       // model.addAttribute("skills", characterCreate.getSkills());
        model.addAttribute("traits", characterCreate.getTraits());
        model.addAttribute("proficiencies", characterCreate.getProficiencies());
        model.addAttribute("equipment", characterCreate.getEquipment());

        return "character/mainview";
    }

    ////////////////// \|/ ADD SOMETHING GET \|/  //////////////////

    @RequestMapping(value = "add-class/${characterId}", method = RequestMethod.GET)
    public String addCharclass(Model model, @PathVariable String characterId) {
        CharacterCreate characterCreate = characterCreateRepository.findById(Integer.parseInt(characterId)).get();
        AddCharacterClassForm form = new AddCharacterClassForm(
                characterclassRepository.findAll(), characterCreate);
        model.addAttribute("title", "Add Class to Character" + characterCreate.getName());
        model.addAttribute("form", form);
        return "character/add-class";
    }

    @RequestMapping(value = "add-equipment/${characterId}", method = RequestMethod.GET)
    public String addEquipment(Model model, @PathVariable String characterId) {
        CharacterCreate characterCreate = characterCreateRepository.findById(Integer.parseInt(characterId)).get();
        AddCharacterEquipForm form = new AddCharacterEquipForm(
                equipmentRepository.findAll(), characterCreate);
        model.addAttribute("title", "Add Equipment to Character" + characterCreate.getName());
        model.addAttribute("form", form);
        return "character/add-equipment";
    }

   // /${characterId}
    @RequestMapping(value = "add-proficiency/${characterId}", method = RequestMethod.GET)
    public String addProficiency(Model model, @PathVariable Integer characterId) {
        CharacterCreate characterCreate = characterCreateRepository.findById(characterId).get();
        AddCharacterProfForm form = new AddCharacterProfForm(
                proficiencyRepository.findAll(), characterCreate);
        model.addAttribute("title", "Add Proficiency to Character" + characterCreate.getName());
        model.addAttribute("form", form);
        return "character/add-proficiency";
    }

    @RequestMapping(value = "add-race/${characterId}", method = RequestMethod.GET)
    public String addRace(Model model, @PathVariable Integer characterId) {
        CharacterCreate characterCreate = characterCreateRepository.findById(characterId).get();
        AddCharacterRaceForm form = new AddCharacterRaceForm(
                raceRepository.findAll(), characterCreate);
        model.addAttribute("title", "Add Race to Character" + characterCreate.getName());
        model.addAttribute("form", form);
        return "character/add-race";
    }

    @RequestMapping(value = "add-spell/${characterId}", method = RequestMethod.GET)
    public String addSpell(Model model, @PathVariable Integer characterId) {
        CharacterCreate characterCreate = characterCreateRepository.findById(characterId).get();
        AddCharacterSpellForm form = new AddCharacterSpellForm(
                spellsRepository.findAll(), characterCreate);
        model.addAttribute("title", "Add Spell to Character" + characterCreate.getName());
        model.addAttribute("form", form);
        return "character/add-spell";
    }

    @RequestMapping(value = "add-trait/${characterId}", method = RequestMethod.GET)
    public String addTrait(Model model, @PathVariable Integer characterId) {
        CharacterCreate characterCreate = characterCreateRepository.findById(characterId).get();
        AddCharacterTraitForm form = new AddCharacterTraitForm(
                traitRepository.findAll(), characterCreate);
        model.addAttribute("title", "Add Trait to Character" + characterCreate.getName());
        model.addAttribute("form", form);
        return "character/add-trait";
    }
    /////////////////// /|\ ADD SOMETHING GET /|\  ////////////////////


    ////////////////// \|/ ADD SOMETHING POST \|/  //////////////////

    @RequestMapping(value = "add-class", method = RequestMethod.POST)
    public String addClass(Model model, @ModelAttribute @Valid AddCharacterClassForm form,
                           Errors errors) {
        if (errors.hasErrors()) {
            model.addAttribute("form", form);
            return "character/add-class";
        }

        Characterclass charclass = characterclassRepository.findById(form.getClassId()).get();
        CharacterCreate character = characterCreateRepository.findById(form.getCharacterId()).get();
        character.addClass(charclass);
        characterCreateRepository.save(character);
        return "redirect:character/mainview" + character.getCharacterId();

    }

    @RequestMapping(value = "add-race", method = RequestMethod.POST)
    public String addRace(Model model, @ModelAttribute @Valid AddCharacterRaceForm form, Errors errors) {
        if (errors.hasErrors()) {
            model.addAttribute("form", form);
            return "character/add-race";
        }
        Characterclass charclass = characterclassRepository.findById(form.getRaceId()).get();
        CharacterCreate character = characterCreateRepository.findById(form.getCharacterId()).get();
        character.addClass(charclass);
        characterCreateRepository.save(character);
        return "redirect:character/mainview" + character.getCharacterId();

    }

    @RequestMapping(value = "add-equipment", method = RequestMethod.POST)
    public String addEquip(Model model, @ModelAttribute @Valid
            AddCharacterEquipForm form, Errors errors) {
        if (errors.hasErrors()) {
            model.addAttribute("form", form);
            return "character/add-equipment";
        }
        Equipment equipment= equipmentRepository.findById(form.getEquId()).get();
        CharacterCreate character = characterCreateRepository.findById(form.getCharacterId()).get();
        character.addEquipment(equipment);
        characterCreateRepository.save(character);
        return "redirect:character/mainview" + character.getCharacterId();

    }
    @RequestMapping(value = "add-spell", method = RequestMethod.POST)
    public String addSpell(Model model, @ModelAttribute @Valid
            AddCharacterSpellForm form, Errors errors) {
        if (errors.hasErrors()) {
            model.addAttribute("form", form);
            return "character/add-spell";
        }
        Spells spell= spellsRepository.findById(form.getSpellId()).get();
        CharacterCreate character = characterCreateRepository.findById(form.getCharacterId()).get();
        character.addSpells(spell);
        characterCreateRepository.save(character);
        return "redirect:character/mainview" + character.getCharacterId();

    }
    @RequestMapping(value = "add-proficiency", method = RequestMethod.POST)
    public String addProfs(Model model, @ModelAttribute @Valid
            AddCharacterProfForm form, Errors errors) {
        if (errors.hasErrors()) {
            model.addAttribute("form", form);
            return "character/add-proficiency";
        }
        Proficiency proficiency= proficiencyRepository.findById(form.getProfId()).get();
        CharacterCreate character = characterCreateRepository.findById(form.getCharacterId()).get();
        character.addProficiencies(proficiency);
        characterCreateRepository.save(character);
        return "redirect:character/mainview" + character.getCharacterId();

    }
    @RequestMapping(value = "add-trait", method = RequestMethod.POST)
    public String addTrait(Model model, @ModelAttribute @Valid
            AddCharacterTraitForm form, Errors errors) {
        if (errors.hasErrors()) {
            model.addAttribute("form", form);
            return "character/add-trait";
        }
        Trait trait = traitRepository.findById(form.getTraitId()).get();
        CharacterCreate character = characterCreateRepository.findById(form.getCharacterId()).get();
        character.addTrait(trait);
        characterCreateRepository.save(character);
        return "redirect:character/mainview" + character.getCharacterId();

    }

    /////////////////// /|\ ADD SOMETHING POST /|\  ////////////////////










    /*@RequestMapping("/allequip")
    public String all(Model model) {
        model.addAttribute("equip", equipmentRepository.findAll());
        return "/allequip";
    }

    @RequestMapping("/allrace")
    public String all(Model model) {
        model.addAttribute("race", raceRepository.findAll());
        return "/allrace";
    }

    @RequestMapping("/allspells")
    public String all(Model model) {
        model.addAttribute("spell", spellsRepository.findAll());
        return "/allspells";
    }

    @RequestMapping("/alltrait")
    public String all(Model model) {
        model.addAttribute("trait", traitRepository.findAll());
        return "/alltrait";
    }

    public BookFormController(PublisherDao publisherDao, BookDao bookDao) {
        this.publisherDao = publisherDao;
        this.bookDao = bookDao;
    }

    @ModelAttribute("publishers")
    public List<Publisher> getAllPublishers() {
        return publisherDao.findAll();
    }

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("books", bookDao.findAll());
        return "book/list";
    }


    @GetMapping("/createcharacter")
    public String add(Model model) {
        model.addAttribute("charactercreate", new CharacterCreate());
        return "createcharacter";
    }

    @PostMapping("/add")
    public String save(@Valid CharacterCreate charactercreate, BindingResult result) {
        if (result.hasErrors()) {
            return "add";
        }
        bookDao.save(book);
        return "redirect:/book-form/list";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable long id) {
        model.addAttribute("book", bookDao.findById(id));
        return "book/edit";
    }

    @PostMapping("/update")
    public String update(@Valid Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "book/edit";
        }
        bookDao.update(book);
        return "redirect:/book-form/list";
    }

    @GetMapping("/confirm")
    public String confirm() {
        return "book/confirm";
    }

    @GetMapping("/remove/{id}")
    public String remove(@PathVariable long id) {
        bookDao.delete(bookDao.findById(id));
        return "redirect:/book-form/list";
    }*/
}