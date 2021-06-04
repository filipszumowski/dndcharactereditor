package com.filipszumowski.dnd.service;

import com.filipszumowski.dnd.model.Equipment;
import com.filipszumowski.dnd.model.Proficiency;
import com.filipszumowski.dnd.repository.EquipmentRepository;
import com.filipszumowski.dnd.repository.ProficiencyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProficiencyService {
    final ProficiencyRepository proficiencyRepository;

    public ProficiencyService(ProficiencyRepository proficiencyRepository) {
        this.proficiencyRepository = proficiencyRepository;
    }

    public List<Proficiency> listAllProfs() {
        return proficiencyRepository.findAll();
    }

    public void saveProf(Proficiency proficiency) {
        proficiencyRepository.save(proficiency);
    }

    public Proficiency getProf(Integer id) {
        return proficiencyRepository.getById(id);
    }

    public void deleteProf(Integer id) {
        proficiencyRepository.deleteById(id);
    }
}
