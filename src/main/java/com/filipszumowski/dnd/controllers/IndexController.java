package com.filipszumowski.dnd.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

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
