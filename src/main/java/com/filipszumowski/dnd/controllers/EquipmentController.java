package com.filipszumowski.dnd.controllers;

import com.filipszumowski.dnd.model.Characterclass;
import com.filipszumowski.dnd.model.Equipment;
import com.filipszumowski.dnd.service.CharClassService;
import com.filipszumowski.dnd.service.EquipmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
    public String saveEquip(@ModelAttribute("equipmentSave") Equipment equipment) {
        equipmentService.saveEquip(equipment);
        return "redirect:/elements/equipment/allequipment";
    }

    @RequestMapping(value = "/editEquip/{equId}")
    public ModelAndView showEditEquipForm(@PathVariable(name="equId") Integer equId){
        ModelAndView modelAndView = new ModelAndView("/elements/equipment/edit_equipment");
        Equipment equipment = equipmentService.getEquip(equId);
        modelAndView.addObject("equipment", equipment);
        return modelAndView;
    }
    @RequestMapping(value = "/deleteEquip/{equId}")
    public String deleteEquip (@PathVariable(name="equId") Integer equId){
        equipmentService.deleteEquip(equId);
        return "redirect:/elements/equipment/allequipment";
    }



}
