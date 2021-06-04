package com.filipszumowski.dnd.controllers;

import com.filipszumowski.dnd.model.CharacterCreate;
import com.filipszumowski.dnd.forms.*;
import com.filipszumowski.dnd.model.*;
import com.filipszumowski.dnd.repository.*;
import com.filipszumowski.dnd.service.CharClassService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @PostMapping("/character/save")
    public String saveCharacter(CharacterCreate characterCreate) {
        characterCreateRepository.save(characterCreate);
        return "redirect:characters-view";
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

        return "character/characterCreateForm";
    }

    @GetMapping("character/delete/{characterId}")
    public String showDeleteCharForm(@PathVariable("characterId") Integer characterId, Model model) {
        characterCreateRepository.deleteById(characterId);
        return "redirect:/character/characters-view";
    }











    /*@RequestMapping("")
    public String allClasses(Model model) {
        model.addAttribute("title", "Classes");
        model.addAttribute("class", characterclassRepository.findAll());
        return "createcharacter/allclasses";
    }*/

        ////////////// Create character GET & Post
//        @RequestMapping(value = "character/create", method = RequestMethod.GET)
//        public String create (Model model){
//            model.addAttribute("title", "Create Character");
//            model.addAttribute(new CharacterCreate());
//            return "character/create";
//        }
//
//        @RequestMapping(value = "character/create", method = RequestMethod.POST)
//        public String create (Model model, @ModelAttribute @Valid CharacterCreate charactercreate, Errors errors){
//            if (errors.hasErrors()) {
//                model.addAttribute("title", "Create Character");
//                return "character/create";
//            }
//            characterCreateRepository.save(charactercreate);
//
//            return "redirect:character-view" + charactercreate.getCharacterId();
//        }

        ///////////////////// Create character GET & Post
//
//        @RequestMapping(value = "character/mainview/{characterId}", method = RequestMethod.GET)
//        public String viewCharacter (Model model, @PathVariable Integer characterId){
//            CharacterCreate characterCreate = characterCreateRepository.findById(characterId).get();
//            model.addAttribute("title", characterCreate.getName());
//            model.addAttribute("class", characterCreate.getCharacterClass());
//            model.addAttribute("race", characterCreate.getRace());
//            model.addAttribute("spells", characterCreate.getSpells());
//            // model.addAttribute("skills", characterCreate.getSkills());
//            model.addAttribute("traits", characterCreate.getTraits());
//            model.addAttribute("proficiencies", characterCreate.getProficiencies());
//            model.addAttribute("equipment", characterCreate.getEquipment());
//
//            return "character/mainview";
//        }

    /*////////////////// \|/ ADD SOMETHING GET \|/  //////////////////

    @RequestMapping(value = "add-class/{characterId}", method = RequestMethod.GET)
    public String addCharclass(Model model, @PathVariable String characterId) {
        CharacterCreate characterCreate = characterCreateRepository.findById(Integer.parseInt(characterId)).get();
        AddCharacterClassForm form = new AddCharacterClassForm(
                characterclassRepository.findAll(), characterCreate);
        model.addAttribute("title", "Add Class to Character" + characterCreate.getName());
        model.addAttribute("form", form);
        return "character/add-class";
    }

    @RequestMapping(value = "add-equipment/{characterId}", method = RequestMethod.GET)
    public String addEquipment(Model model, @PathVariable String characterId) {
        CharacterCreate characterCreate = characterCreateRepository.findById(Integer.parseInt(characterId)).get();
        AddCharacterEquipForm form = new AddCharacterEquipForm(
                equipmentRepository.findAll(), characterCreate);
        model.addAttribute("title", "Add Equipment to Character" + characterCreate.getName());
        model.addAttribute("form", form);
        return "character/add-equipment";
    }

   // /${characterId}
    @RequestMapping(value = "add-proficiency/{characterId}", method = RequestMethod.GET)
    public String addProficiency(Model model, @PathVariable Integer characterId) {
        CharacterCreate characterCreate = characterCreateRepository.findById(characterId).get();
        AddCharacterProfForm form = new AddCharacterProfForm(
                proficiencyRepository.findAll(), characterCreate);
        model.addAttribute("title", "Add Proficiency to Character" + characterCreate.getName());
        model.addAttribute("form", form);
        return "character/add-proficiency";
    }

    @RequestMapping(value = "add-race/{characterId}", method = RequestMethod.GET)
    public String addRace(Model model, @PathVariable Integer characterId) {
        CharacterCreate characterCreate = characterCreateRepository.findById(characterId).get();
        AddCharacterRaceForm form = new AddCharacterRaceForm(
                raceRepository.findAll(), characterCreate);
        model.addAttribute("title", "Add Race to Character" + characterCreate.getName());
        model.addAttribute("form", form);
        return "character/add-race";
    }

    @RequestMapping(value = "add-spell/{characterId}", method = RequestMethod.GET)
    public String addSpell(Model model, @PathVariable Integer characterId) {
        CharacterCreate characterCreate = characterCreateRepository.findById(characterId).get();
        AddCharacterSpellForm form = new AddCharacterSpellForm(
                spellsRepository.findAll(), characterCreate);
        model.addAttribute("title", "Add Spell to Character" + characterCreate.getName());
        model.addAttribute("form", form);
        return "character/add-spell";
    }

    @RequestMapping(value = "add-trait/{characterId}", method = RequestMethod.GET)
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

    @RequestMapping(value = "add-class", method = RequestMethod.GET)
    public String addClass(Model model *//*@ModelAttribute @Valid AddCharacterClassForm form,
                           Errors errors*//*) {


         *//*Characterclass charclass = characterclassRepository.findById(form.getClassId()).get();
        CharacterCreate character = characterCreateRepository.findById(form.getCharacterId()).get();
        character.addClass(charclass);*//*
        // characterCreateRepository.save(character);
        return "character/mainview";

    }

    @RequestMapping(value = "add-race", method = RequestMethod.POST)
    public String addRace(Model model
            , @ModelAttribute @Valid AddCharacterRaceForm form, Errors errors) {
       *//* if (errors.hasErrors()) {
            model.addAttribute("form", form);
            return "character/add-race";
        }*//*
        Race race = raceRepository.findById(form.getRaceId()).get();
        CharacterCreate character = characterCreateRepository.findById(form.getCharacterId()).get();
        character.addRace(race);
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
        Spell spell= spellsRepository.findById(form.getSpellId()).get();
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

*/








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