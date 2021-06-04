package com.filipszumowski.dnd.controllers;

import com.filipszumowski.dnd.model.Race;
import com.filipszumowski.dnd.service.RaceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class RaceController {
    final RaceService raceService;

    public RaceController(RaceService raceService) {
        this.raceService = raceService;
    }

    @RequestMapping("elements/race/allrace")
    public String viewAllRaces(Model model) {
        List<Race> raceList = raceService.listAllRaces();
        model.addAttribute("raceList", raceList);
        return "elements/race/allrace";
    }

    @RequestMapping("/elements/race/new_race")
    public String showNewRaceForm(Model model) {
        Race race = new Race();
        model.addAttribute("raceSave", race);
        return "elements/race/new_race";
    }

    @RequestMapping(value = "/saveRace", method = RequestMethod.POST)
    public String saveRace(@ModelAttribute("raceSave") Race race) {
        raceService.saveRace(race);
        return "redirect:/elements/race/allrace";
    }

    @RequestMapping(value = "/editRace/{raceId}")
    public ModelAndView showEditRaceForm(@PathVariable(name="raceId") Integer raceId){
        ModelAndView modelAndView = new ModelAndView("/elements/race/edit_race");
        Race race = raceService.getRace(raceId);
        modelAndView.addObject("race", race);
        return modelAndView;
    }
    @RequestMapping(value = "/deleteRace/{raceId}")
    public String deleteRace (@PathVariable(name="raceId") Integer raceId){
        raceService.deleteRace(raceId);
        return "redirect:/elements/race/allraces";
    }
}
