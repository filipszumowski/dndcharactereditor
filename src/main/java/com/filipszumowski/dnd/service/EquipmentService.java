package com.filipszumowski.dnd.service;

import com.filipszumowski.dnd.model.Characterclass;
import com.filipszumowski.dnd.model.Equipment;
import com.filipszumowski.dnd.repository.CharacterclassRepository;
import com.filipszumowski.dnd.repository.EquipmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipmentService {
    final EquipmentRepository equipmentRepository;

    public EquipmentService(EquipmentRepository equipmentRepository) {
        this.equipmentRepository = equipmentRepository;
    }

    public List<Equipment> listAllEquips() {
        return equipmentRepository.findAll();
    }

    public void saveEquip(Equipment equipment) {
        equipmentRepository.save(equipment);
    }

    public Equipment getEquip(Integer id) {
        return equipmentRepository.getById(id);
    }

    public void deleteEquip(Integer id) {
        equipmentRepository.deleteById(id);
    }
}
