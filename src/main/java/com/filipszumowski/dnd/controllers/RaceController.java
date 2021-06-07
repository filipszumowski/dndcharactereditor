package com.filipszumowski.dnd.controllers;

import com.filipszumowski.dnd.model.Proficiency;
import com.filipszumowski.dnd.model.Race;
import com.filipszumowski.dnd.service.RaceService;
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
    public String saveRace(@Valid @ModelAttribute("raceSave") Race race,
                           BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "elements/race/new_race";
        }

        raceService.saveRace(race);
        return "redirect:elements/race/allrace";
    }

    /*@RequestMapping(value = "/editRace/{raceId}")
    public ModelAndView showEditRaceForm(@PathVariable(name="raceId") Integer raceId){
        ModelAndView modelAndView = new ModelAndView("/elements/race/edit_race");
        Race race = raceService.getRace(raceId);
        modelAndView.addObject("race", race);
        return modelAndView;
    }*/

    // dodane
    @RequestMapping(value = "/editRace", method = RequestMethod.POST)
    public String editRace(@Valid Race race, BindingResult result) {
        if (result.hasErrors()) {
            return "elements/race/allrace";
        }
        raceService.saveRace(race);
        return "redirect:/elements/race/allrace";
    }

    @RequestMapping(value = "/editRace/{raceId}", method = RequestMethod.GET)
    public String showEditRaceForm(@PathVariable Integer raceId, Model model) {
        model.addAttribute("race", raceService.getRace(raceId));
        return "elements/race/edit_race";
    }
    // to co powyżej zostało dodane
    @RequestMapping(value = "/deleteRace/{raceId}")
    public String deleteRace (@PathVariable(name="raceId") Integer raceId){
        try{raceService.deleteRace(raceId);
            return "elements/race/allraces";

        }catch (Exception e){
            return "errors/SQLIntegrity";
        }


    }
}
