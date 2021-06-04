package com.filipszumowski.dnd.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @GetMapping("")
    public String viewHomepage(){
        return "index";
    }
//    @GetMapping("/")
//    public String viewAllCharacters(){
//        return "index";
//    }
    /*@GetMapping("/elements/allclasses")
    public String viewAllClasses(){
        return "elements/charclasses/allclasses";
    }
    @GetMapping("/elements/allequipment")
    public String viewAllEquipment(){
        return "elements/equipment/allequipment";
    }
    @GetMapping("/elements/allprof")
    public String viewAllProficiencies(){
        return "elements/proficiency/allprof";
    }
    @GetMapping("/elements/allrace")
    public String viewAllRace(){
        return "elements/race/allrace";
    }
    @GetMapping("/elements/allspell")
    public String viewAllSpells(){
        return "elements/spell/allspell";
    }
    @GetMapping("/elements/alltrait")
    public String viewAllTraits(){
        return "elements/trait/alltrait";
    }
*/


    @RequestMapping("/add-class")
    public String addClassHref() {
        return "character/add-class";
    }

    @RequestMapping("/add-race")
    public String addRaceHref() {
        return "add-spell";
    }

    @RequestMapping("/add-spell")
    public String addSpellHref() {
        return "character/add-spell";
    }
    @RequestMapping("/add-equipment")
    public String addEquipmentHref() {
        return "character/add-equipment";
    }
    @RequestMapping("/add-proficiency")
    public String addProficiencyHref() {
        return "character/add-proficiency";
    }
    @RequestMapping("/add-skills")
    public String addSkillsHref() {
        return "character/add-skills";
    }
    @RequestMapping("/add-trait")
    public String addTraitHref() {
        return "character/add-trait";
    }
}
