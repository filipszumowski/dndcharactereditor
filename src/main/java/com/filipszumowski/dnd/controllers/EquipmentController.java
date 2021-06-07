package com.filipszumowski.dnd.controllers;

import com.filipszumowski.dnd.model.Characterclass;
import com.filipszumowski.dnd.model.Equipment;
import com.filipszumowski.dnd.service.CharClassService;
import com.filipszumowski.dnd.service.EquipmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

@Controller
public class EquipmentController {
    final EquipmentService equipmentService;

    public EquipmentController(EquipmentService equipmentService) {
        this.equipmentService = equipmentService;
    }

    @RequestMapping("elements/equipment/allequipment")
    public String viewAllEquips(Model model) {
        List<Equipment> equipmentList = equipmentService.listAllEquips();
        model.addAttribute("equipmentList", equipmentList);
        return "elements/equipment/allequipment";
    }

    @RequestMapping("/elements/equipment/new_equipment")
    public String showNewEquipForm(Model model) {
        Equipment equipment = new Equipment();
        model.addAttribute("equipmentSave", equipment);
        return "elements/equipment/new_equipment";
    }

    @RequestMapping(value = "/saveEquip", method = RequestMethod.POST)
    public String saveEquip(@Valid @ModelAttribute("equipmentSave") Equipment equipment,
                            BindingResult bindingResult) {

        if(bindingResult.hasErrors()){
            return "elements/equipment/new_equipment";
        }

        equipmentService.saveEquip(equipment);
        return "redirect:/elements/equipment/allequipment";
    }

    /*@RequestMapping(value = "/editEquip/{equId}")
    public ModelAndView showEditEquipForm(@PathVariable(name="equId") Integer equId){
        ModelAndView modelAndView = new ModelAndView("/elements/equipment/edit_equipment");
        Equipment equipment = equipmentService.getEquip(equId);
        modelAndView.addObject("equipment", equipment);
        return modelAndView;
    }*/

    // dodane
    @RequestMapping(value = "/editEquip", method = RequestMethod.POST)
    public String editEquip(@Valid Equipment equipment, BindingResult result) {
        if (result.hasErrors()) {
            return "elements/equipment/allequipment";
        }
        equipmentService.saveEquip(equipment);
        return "redirect:/elements/equipment/allequipment";
    }

    @RequestMapping(value = "/editEquip/{equId}", method = RequestMethod.GET)
    public String showEditEquipForm(@PathVariable Integer equId, Model model) {
        model.addAttribute("equipmentSave", equipmentService.getEquip(equId));
        return "elements/equipment/edit_equipment";
    }
    // to co powyżej zostało dodane


    @RequestMapping(value = "/deleteEquip/{equId}")
    public String deleteEquip (@PathVariable(name="equId") Integer equId){
        try{equipmentService.deleteEquip(equId);

            return "redirect:/elements/equipment/allequipment";

        }catch (Exception e){
            return "errors/SQLIntegrity";
        }
    }



}
